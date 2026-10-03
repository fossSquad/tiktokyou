package ni.shikatu.okhttp3.internal.http;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.collections.MapsKt;
import ni.shikatu.kotlin.io.encoding.Base64;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.Challenge;
import ni.shikatu.okhttp3.Cookie;
import ni.shikatu.okhttp3.CookieJar;
import ni.shikatu.okhttp3.Headers;
import ni.shikatu.okhttp3.HttpUrl;
import ni.shikatu.okhttp3.Response;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.platform.Platform;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.ByteString;

@Metadata(d1 = {"\u0000T\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b\u001a\u001a\u0010\t\u001a\u00020\n*\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rH\u0002\u001a\f\u0010\u000e\u001a\u00020\u000f*\u00020\u000bH\u0002\u001a\u0014\u0010\u0010\u001a\u00020\u000f*\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002\u001a\u000e\u0010\u0013\u001a\u0004\u0018\u00010\b*\u00020\u000bH\u0002\u001a\u000e\u0010\u0014\u001a\u0004\u0018\u00010\b*\u00020\u000bH\u0002\u001a\u001a\u0010\u0015\u001a\u00020\n*\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006\u001a\n\u0010\u001a\u001a\u00020\u000f*\u00020\u001b\u001a\u0010\u0010\u001c\u001a\u00020\u000f2\u0006\u0010\u001d\u001a\u00020\u001bH\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"QUOTED_STRING_DELIMITERS", "Lni/shikatu/okio/ByteString;", "TOKEN_DELIMITERS", "parseChallenges", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/Challenge;", "Lni/shikatu/okhttp3/Headers;", "headerName", _UrlKt.FRAGMENT_ENCODE_SET, "readChallengeHeader", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okio/Buffer;", "result", _UrlKt.FRAGMENT_ENCODE_SET, "skipCommasAndWhitespace", _UrlKt.FRAGMENT_ENCODE_SET, "startsWith", "prefix", _UrlKt.FRAGMENT_ENCODE_SET, "readQuotedString", "readToken", "receiveHeaders", "Lni/shikatu/okhttp3/CookieJar;", "url", "Lni/shikatu/okhttp3/HttpUrl;", "headers", "promisesBody", "Lni/shikatu/okhttp3/Response;", "hasBody", "response", "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class HttpHeaders {
    private static final ByteString QUOTED_STRING_DELIMITERS = ByteString.Companion.encodeUtf8("\"\\");
    private static final ByteString TOKEN_DELIMITERS = ByteString.Companion.encodeUtf8("\t ,=");

    public static final List<Challenge> parseChallenges(Headers $this$parseChallenges, String headerName) {
        Intrinsics.checkNotNullParameter($this$parseChallenges, "<this>");
        Intrinsics.checkNotNullParameter(headerName, "headerName");
        List result = new ArrayList();
        int size = $this$parseChallenges.size();
        for (int h = 0; h < size; h++) {
            if (StringsKt.equals(headerName, $this$parseChallenges.name(h), true)) {
                Buffer header = new Buffer().writeUtf8($this$parseChallenges.value(h));
                try {
                    readChallengeHeader(header, result);
                } catch (EOFException e) {
                    Platform.Companion.get().log("Unable to parse challenge", 5, e);
                }
            }
        }
        return result;
    }

    private static final void readChallengeHeader(Buffer $this$readChallengeHeader, List<Challenge> list) throws EOFException {
        String parameterValue;
        String replaced;
        String peek = null;
        while (true) {
            if (peek == null) {
                skipCommasAndWhitespace($this$readChallengeHeader);
                peek = readToken($this$readChallengeHeader);
                if (peek == null) {
                    return;
                }
            }
            String schemeName = peek;
            boolean commaPrefixed = skipCommasAndWhitespace($this$readChallengeHeader);
            peek = readToken($this$readChallengeHeader);
            if (peek == null) {
                if ($this$readChallengeHeader.exhausted()) {
                    list.add(new Challenge(schemeName, (Map<String, String>) MapsKt.emptyMap()));
                    return;
                }
                return;
            }
            int eqCount = _UtilCommonKt.skipAll($this$readChallengeHeader, Base64.padSymbol);
            boolean commaSuffixed = skipCommasAndWhitespace($this$readChallengeHeader);
            if (!commaPrefixed && (commaSuffixed || $this$readChallengeHeader.exhausted())) {
                Map mapSingletonMap = Collections.singletonMap(null, peek + StringsKt.repeat("=", eqCount));
                Intrinsics.checkNotNullExpressionValue(mapSingletonMap, "singletonMap(...)");
                list.add(new Challenge(schemeName, (Map<String, String>) mapSingletonMap));
                peek = null;
            } else {
                Map parameters = new LinkedHashMap();
                int eqCount2 = eqCount + _UtilCommonKt.skipAll($this$readChallengeHeader, Base64.padSymbol);
                while (true) {
                    if (peek == null) {
                        peek = readToken($this$readChallengeHeader);
                        if (!skipCommasAndWhitespace($this$readChallengeHeader)) {
                            eqCount2 = _UtilCommonKt.skipAll($this$readChallengeHeader, Base64.padSymbol);
                            if (eqCount2 != 0) {
                                break;
                            }
                            if (eqCount2 <= 1 || skipCommasAndWhitespace($this$readChallengeHeader)) {
                                return;
                            }
                            if (startsWith($this$readChallengeHeader, (byte) 34)) {
                                parameterValue = readQuotedString($this$readChallengeHeader);
                            } else {
                                parameterValue = readToken($this$readChallengeHeader);
                            }
                            if (parameterValue == null) {
                                return;
                            }
                            replaced = (String) parameters.put(peek, parameterValue);
                            peek = null;
                            if (replaced != null) {
                                return;
                            }
                            if (skipCommasAndWhitespace($this$readChallengeHeader) && !$this$readChallengeHeader.exhausted()) {
                                return;
                            }
                        } else {
                            break;
                        }
                    } else {
                        if (eqCount2 != 0) {
                            break;
                            break;
                        }
                        if (eqCount2 <= 1) {
                            return;
                        }
                        if (startsWith($this$readChallengeHeader, (byte) 34)) {
                            parameterValue = readQuotedString($this$readChallengeHeader);
                        } else {
                            parameterValue = readToken($this$readChallengeHeader);
                        }
                        if (parameterValue == null) {
                            return;
                        }
                        replaced = (String) parameters.put(peek, parameterValue);
                        peek = null;
                        if (replaced != null) {
                            return;
                        } else {
                            if (skipCommasAndWhitespace($this$readChallengeHeader)) {
                            }
                        }
                    }
                }
                list.add(new Challenge(schemeName, (Map<String, String>) parameters));
            }
        }
    }

    private static final boolean skipCommasAndWhitespace(Buffer $this$skipCommasAndWhitespace) throws EOFException {
        boolean commaFound = false;
        while (!$this$skipCommasAndWhitespace.exhausted()) {
            byte b = $this$skipCommasAndWhitespace.getByte(0L);
            if (b == 44) {
                $this$skipCommasAndWhitespace.readByte();
                commaFound = true;
            } else {
                if (b != 32 && b != 9) {
                    break;
                }
                $this$skipCommasAndWhitespace.readByte();
            }
        }
        return commaFound;
    }

    private static final boolean startsWith(Buffer $this$startsWith, byte prefix) {
        return !$this$startsWith.exhausted() && $this$startsWith.getByte(0L) == prefix;
    }

    private static final String readQuotedString(Buffer $this$readQuotedString) throws EOFException {
        if (!($this$readQuotedString.readByte() == 34)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        Buffer result = new Buffer();
        while (true) {
            long i = $this$readQuotedString.indexOfElement(QUOTED_STRING_DELIMITERS);
            if (i == -1) {
                return null;
            }
            if ($this$readQuotedString.getByte(i) == 34) {
                result.write($this$readQuotedString, i);
                $this$readQuotedString.readByte();
                return result.readUtf8();
            }
            if ($this$readQuotedString.size() == i + 1) {
                return null;
            }
            result.write($this$readQuotedString, i);
            $this$readQuotedString.readByte();
            result.write($this$readQuotedString, 1L);
        }
    }

    private static final String readToken(Buffer $this$readToken) {
        long tokenSize = $this$readToken.indexOfElement(TOKEN_DELIMITERS);
        if (tokenSize == -1) {
            tokenSize = $this$readToken.size();
        }
        if (tokenSize != 0) {
            return $this$readToken.readUtf8(tokenSize);
        }
        return null;
    }

    public static final void receiveHeaders(CookieJar $this$receiveHeaders, HttpUrl url, Headers headers) {
        Intrinsics.checkNotNullParameter($this$receiveHeaders, "<this>");
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        if ($this$receiveHeaders == CookieJar.NO_COOKIES) {
            return;
        }
        List<Cookie> all = Cookie.Companion.parseAll(url, headers);
        if (all.isEmpty()) {
            return;
        }
        $this$receiveHeaders.saveFromResponse(url, all);
    }

    public static final boolean promisesBody(Response $this$promisesBody) {
        Intrinsics.checkNotNullParameter($this$promisesBody, "<this>");
        if (Intrinsics.areEqual($this$promisesBody.request().method(), "HEAD")) {
            return false;
        }
        int responseCode = $this$promisesBody.code();
        return (((responseCode >= 100 && responseCode < 200) || responseCode == 204 || responseCode == 304) && _UtilJvmKt.headersContentLength($this$promisesBody) == -1 && !StringsKt.equals("chunked", Response.header$default($this$promisesBody, "Transfer-Encoding", null, 2, null), true)) ? false : true;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "No longer supported", replaceWith = @ReplaceWith(expression = "response.promisesBody()", imports = {}))
    public static final boolean hasBody(Response response) {
        Intrinsics.checkNotNullParameter(response, "response");
        return promisesBody(response);
    }
}
