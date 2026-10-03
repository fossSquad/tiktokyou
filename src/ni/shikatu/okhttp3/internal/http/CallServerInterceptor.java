package ni.shikatu.okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import ni.shikatu.kotlin.ExceptionsKt;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.Headers;
import ni.shikatu.okhttp3.Interceptor;
import ni.shikatu.okhttp3.Request;
import ni.shikatu.okhttp3.RequestBody;
import ni.shikatu.okhttp3.Response;
import ni.shikatu.okhttp3.ResponseBody;
import ni.shikatu.okhttp3.TrailersSource;
import ni.shikatu.okhttp3.internal.UnreadableResponseBody;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.connection.Exchange;
import ni.shikatu.okhttp3.internal.http2.ConnectionShutdownException;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.BufferedSink;
import ni.shikatu.okio.BufferedSource;
import ni.shikatu.okio.Okio;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002¨\u0006\f"}, d2 = {"Lni/shikatu/okhttp3/internal/http/CallServerInterceptor;", "Lni/shikatu/okhttp3/Interceptor;", "<init>", "()V", "intercept", "Lni/shikatu/okhttp3/Response;", "chain", "Lni/shikatu/okhttp3/Interceptor$Chain;", "shouldIgnoreAndWaitForRealResponse", _UrlKt.FRAGMENT_ENCODE_SET, "code", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CallServerInterceptor implements Interceptor {
    public static final CallServerInterceptor INSTANCE = new CallServerInterceptor();

    private CallServerInterceptor() {
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        boolean invokeStartEvent;
        Response response;
        int code;
        boolean isUpgradeCode;
        Response response2;
        boolean invokeStartEvent2;
        Response.Builder responseBuilder;
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealInterceptorChain realChain = (RealInterceptorChain) chain;
        final Exchange exchange = realChain.getExchange$okhttp();
        Intrinsics.checkNotNull(exchange);
        Request request = realChain.getRequest$okhttp();
        RequestBody requestBody = request.body();
        long sentRequestMillis = System.currentTimeMillis();
        boolean invokeStartEvent3 = true;
        Response.Builder responseBuilder2 = null;
        IOException sendRequestException = null;
        boolean hasRequestBody = HttpMethod.permitsRequestBody(request.method()) && requestBody != null;
        boolean isUpgradeRequest = StringsKt.equals("upgrade", request.header("Connection"), true);
        try {
            exchange.writeRequestHeaders(request);
            if (hasRequestBody) {
                if (StringsKt.equals("100-continue", request.header("Expect"), true)) {
                    exchange.flushRequest();
                    responseBuilder2 = exchange.readResponseHeaders(true);
                    exchange.responseHeadersStart();
                    invokeStartEvent3 = false;
                }
                if (responseBuilder2 != null) {
                    exchange.noRequestBody();
                    if (!exchange.getConnection$okhttp().isMultiplexed$okhttp()) {
                        exchange.noNewExchangesOnConnection();
                    }
                } else if (requestBody.isDuplex()) {
                    exchange.flushRequest();
                    requestBody.writeTo(Okio.buffer(exchange.createRequestBody(request, true)));
                } else {
                    BufferedSink bufferedRequestBody = Okio.buffer(exchange.createRequestBody(request, false));
                    requestBody.writeTo(bufferedRequestBody);
                    bufferedRequestBody.close();
                }
            } else {
                exchange.noRequestBody();
            }
            if (requestBody == null || !requestBody.isDuplex()) {
                exchange.finishRequest();
            }
        } catch (IOException e) {
            if ((e instanceof ConnectionShutdownException) || !exchange.getHasFailure$okhttp()) {
                throw e;
            }
            sendRequestException = e;
        }
        if (responseBuilder2 != null) {
            invokeStartEvent = invokeStartEvent3;
            response = responseBuilder2.request(request).handshake(exchange.getConnection$okhttp().handshake()).sentRequestAtMillis(sentRequestMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
            code = response.code();
            while (shouldIgnoreAndWaitForRealResponse(code)) {
                invokeStartEvent2 = invokeStartEvent;
                responseBuilder = exchange.readResponseHeaders(false);
                Intrinsics.checkNotNull(responseBuilder);
                if (invokeStartEvent2) {
                    exchange.responseHeadersStart();
                    RealInterceptorChain realChain2 = realChain;
                    Request request2 = request;
                    RequestBody requestBody2 = requestBody;
                    response = responseBuilder.request(request).handshake(exchange.getConnection$okhttp().handshake()).sentRequestAtMillis(sentRequestMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
                    code = response.code();
                    request = request2;
                    invokeStartEvent = invokeStartEvent2;
                    requestBody = requestBody2;
                    realChain = realChain2;
                } else {
                    RealInterceptorChain realChain3 = realChain;
                    Request request3 = request;
                    RequestBody requestBody3 = requestBody;
                    response = responseBuilder.request(request).handshake(exchange.getConnection$okhttp().handshake()).sentRequestAtMillis(sentRequestMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
                    code = response.code();
                    request = request3;
                    invokeStartEvent = invokeStartEvent2;
                    requestBody = requestBody3;
                    realChain = realChain3;
                }
            }
            exchange.responseHeadersEnd(response);
            if (code == 101) {
                isUpgradeCode = true;
            } else {
                isUpgradeCode = false;
            }
            if (isUpgradeCode) {
                throw new ProtocolException("Unexpected 101 code on HTTP/2 connection");
            }
            if (isUpgradeCode) {
            }
            if (isUpgradeRequest) {
                final ResponseBody responseBody = exchange.openResponseBody(response);
                response2 = response.newBuilder().body(responseBody).trailers(new TrailersSource() {
                    @Override
                    public Headers peek() {
                        return exchange.peekTrailers();
                    }

                    @Override
                    public Headers get() throws IOException {
                        BufferedSource source = responseBody.source();
                        if (source.isOpen()) {
                            _UtilJvmKt.skipAll(source);
                        }
                        Headers headersPeek = peek();
                        if (headersPeek != null) {
                            return headersPeek;
                        }
                        throw new IllegalStateException("null trailers after exhausting response body?!".toString());
                    }
                }).build();
            } else {
                final ResponseBody responseBody2 = exchange.openResponseBody(response);
                response2 = response.newBuilder().body(responseBody2).trailers(new TrailersSource() {
                    @Override
                    public Headers peek() {
                        return exchange.peekTrailers();
                    }

                    @Override
                    public Headers get() throws IOException {
                        BufferedSource source = responseBody2.source();
                        if (source.isOpen()) {
                            _UtilJvmKt.skipAll(source);
                        }
                        Headers headersPeek = peek();
                        if (headersPeek != null) {
                            return headersPeek;
                        }
                        throw new IllegalStateException("null trailers after exhausting response body?!".toString());
                    }
                }).build();
            }
            if (StringsKt.equals("close", response2.request().header("Connection"), true)) {
                exchange.noNewExchangesOnConnection();
            } else {
                exchange.noNewExchangesOnConnection();
            }
            if (code != 204) {
                throw new ProtocolException("HTTP " + code + " had non-zero Content-Length: " + response2.body().contentLength());
            }
            throw new ProtocolException("HTTP " + code + " had non-zero Content-Length: " + response2.body().contentLength());
            return response2;
        }
        try {
            Response.Builder responseHeaders = exchange.readResponseHeaders(false);
            Intrinsics.checkNotNull(responseHeaders);
            responseBuilder2 = responseHeaders;
            if (invokeStartEvent3) {
                exchange.responseHeadersStart();
                invokeStartEvent3 = false;
            }
            try {
                invokeStartEvent = invokeStartEvent3;
                try {
                    response = responseBuilder2.request(request).handshake(exchange.getConnection$okhttp().handshake()).sentRequestAtMillis(sentRequestMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
                    code = response.code();
                    while (shouldIgnoreAndWaitForRealResponse(code)) {
                        try {
                            invokeStartEvent2 = invokeStartEvent;
                            try {
                                responseBuilder = exchange.readResponseHeaders(false);
                                Intrinsics.checkNotNull(responseBuilder);
                                if (invokeStartEvent2) {
                                    try {
                                        exchange.responseHeadersStart();
                                        RealInterceptorChain realChain4 = realChain;
                                        try {
                                            Request request4 = request;
                                            RequestBody requestBody4 = requestBody;
                                            try {
                                                response = responseBuilder.request(request).handshake(exchange.getConnection$okhttp().handshake()).sentRequestAtMillis(sentRequestMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
                                                code = response.code();
                                                request = request4;
                                                invokeStartEvent = invokeStartEvent2;
                                                requestBody = requestBody4;
                                                realChain = realChain4;
                                            } catch (IOException e2) {
                                                e = e2;
                                            }
                                        } catch (IOException e3) {
                                            e = e3;
                                        }
                                    } catch (IOException e4) {
                                        e = e4;
                                    }
                                } else {
                                    RealInterceptorChain realChain5 = realChain;
                                    Request request5 = request;
                                    RequestBody requestBody5 = requestBody;
                                    response = responseBuilder.request(request).handshake(exchange.getConnection$okhttp().handshake()).sentRequestAtMillis(sentRequestMillis).receivedResponseAtMillis(System.currentTimeMillis()).build();
                                    code = response.code();
                                    request = request5;
                                    invokeStartEvent = invokeStartEvent2;
                                    requestBody = requestBody5;
                                    realChain = realChain5;
                                }
                            } catch (IOException e5) {
                                e = e5;
                            }
                        } catch (IOException e6) {
                            e = e6;
                        }
                    }
                    try {
                        exchange.responseHeadersEnd(response);
                        if (code == 101) {
                            isUpgradeCode = true;
                        } else {
                            isUpgradeCode = false;
                        }
                        if (isUpgradeCode && exchange.getConnection$okhttp().isMultiplexed$okhttp()) {
                            throw new ProtocolException("Unexpected 101 code on HTTP/2 connection");
                        }
                        boolean isUpgradeResponse = !isUpgradeCode && StringsKt.equals("upgrade", Response.header$default(response, "Connection", null, 2, null), true);
                        try {
                            if (isUpgradeRequest || !isUpgradeResponse) {
                                final ResponseBody responseBody3 = exchange.openResponseBody(response);
                                response2 = response.newBuilder().body(responseBody3).trailers(new TrailersSource() {
                                    @Override
                                    public Headers peek() {
                                        return exchange.peekTrailers();
                                    }

                                    @Override
                                    public Headers get() throws IOException {
                                        BufferedSource source = responseBody3.source();
                                        if (source.isOpen()) {
                                            _UtilJvmKt.skipAll(source);
                                        }
                                        Headers headersPeek = peek();
                                        if (headersPeek != null) {
                                            return headersPeek;
                                        }
                                        throw new IllegalStateException("null trailers after exhausting response body?!".toString());
                                    }
                                }).build();
                            } else {
                                response2 = response.newBuilder().body(new UnreadableResponseBody(response.body().contentType(), response.body().contentLength())).socket(exchange.upgradeToSocket()).build();
                            }
                            if (StringsKt.equals("close", response2.request().header("Connection"), true) || StringsKt.equals("close", Response.header$default(response2, "Connection", null, 2, null), true)) {
                                exchange.noNewExchangesOnConnection();
                            }
                            if ((code != 204 || code == 205) && response2.body().contentLength() > 0) {
                                throw new ProtocolException("HTTP " + code + " had non-zero Content-Length: " + response2.body().contentLength());
                            }
                            return response2;
                        } catch (IOException e7) {
                            e = e7;
                        }
                    } catch (IOException e8) {
                        e = e8;
                    }
                } catch (IOException e9) {
                    e = e9;
                }
            } catch (IOException e10) {
                e = e10;
            }
        } catch (IOException e11) {
            e = e11;
        }
        if (sendRequestException == null) {
            throw e;
        }
        ExceptionsKt.addSuppressed(sendRequestException, e);
        throw sendRequestException;
    }

    private final boolean shouldIgnoreAndWaitForRealResponse(int code) {
        if (code == 100) {
            return true;
        }
        return 102 <= code && code < 200;
    }
}
