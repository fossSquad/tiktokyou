package ni.shikatu.okhttp3;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.JvmClassMappingKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.internal.EmptyTags;
import ni.shikatu.okhttp3.internal.IsProbablyUtf8Kt;
import ni.shikatu.okhttp3.internal.Tags;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal.http.GzipRequestBody;
import ni.shikatu.okhttp3.internal.http.HttpMethod;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\u0018\u00002\u00020\u0001:\u00015B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005B1\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0004\u0010\u000eJ\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u001e\u001a\u00020\u000bJ\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f2\u0006\u0010\u001e\u001a\u00020\u000bJ\u001e\u0010 \u001a\u0004\u0018\u0001H!\"\n\b\u0000\u0010!\u0018\u0001*\u00020\u0001H\u0087\b¢\u0006\u0004\b\"\u0010#J%\u0010 \u001a\u0004\u0018\u0001H!\"\b\b\u0000\u0010!*\u00020\u00012\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H!0%¢\u0006\u0002\u0010&J\b\u0010 \u001a\u0004\u0018\u00010\u0001J#\u0010 \u001a\u0004\u0018\u0001H!\"\u0004\b\u0000\u0010!2\u000e\u0010$\u001a\n\u0012\u0006\b\u0001\u0012\u0002H!0'¢\u0006\u0002\u0010(J\u0006\u0010)\u001a\u00020\u0003J\r\u0010\u0006\u001a\u00020\u0007H\u0007¢\u0006\u0002\b,J\r\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\b-J\r\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b.J\u000f\u0010\f\u001a\u0004\u0018\u00010\rH\u0007¢\u0006\u0002\b/J\r\u0010*\u001a\u00020\u0019H\u0007¢\u0006\u0002\b0J\b\u00101\u001a\u00020\u000bH\u0016J\u0012\u00102\u001a\u00020\u000b2\b\b\u0002\u00103\u001a\u00020\u001bH\u0007J\f\u00104\u001a\u00020\u000b*\u00020\u000bH\u0002R\u0013\u0010\u0006\u001a\u00020\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u000fR\u0013\u0010\n\u001a\u00020\u000b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0010R\u0013\u0010\b\u001a\u00020\t8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0015\u0010\f\u001a\u0004\u0018\u00010\r8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0012R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u00078\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001cR\u0011\u0010*\u001a\u00020\u00198G¢\u0006\u0006\u001a\u0004\b*\u0010+¨\u00066"}, d2 = {"Lni/shikatu/okhttp3/Request;", _UrlKt.FRAGMENT_ENCODE_SET, "builder", "Lni/shikatu/okhttp3/Request$Builder;", "<init>", "(Lokhttp3/Request$Builder;)V", "url", "Lni/shikatu/okhttp3/HttpUrl;", "headers", "Lni/shikatu/okhttp3/Headers;", "method", _UrlKt.FRAGMENT_ENCODE_SET, "body", "Lni/shikatu/okhttp3/RequestBody;", "(Lokhttp3/HttpUrl;Lokhttp3/Headers;Ljava/lang/String;Lokhttp3/RequestBody;)V", "()Lokhttp3/HttpUrl;", "()Ljava/lang/String;", "()Lokhttp3/Headers;", "()Lokhttp3/RequestBody;", "cacheUrlOverride", "tags", "Lni/shikatu/okhttp3/internal/Tags;", "getTags$okhttp", "()Lokhttp3/internal/Tags;", "lazyCacheControl", "Lni/shikatu/okhttp3/CacheControl;", "isHttps", _UrlKt.FRAGMENT_ENCODE_SET, "()Z", "header", "name", _UrlKt.FRAGMENT_ENCODE_SET, "tag", "T", "reifiedTag", "()Ljava/lang/Object;", "type", "Lni/shikatu/kotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/Object;", "newBuilder", "cacheControl", "()Lokhttp3/CacheControl;", "-deprecated_url", "-deprecated_method", "-deprecated_headers", "-deprecated_body", "-deprecated_cacheControl", "toString", "toCurl", "includeBody", "shellEscape", "Builder", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Request {
    private final RequestBody body;
    private final HttpUrl cacheUrlOverride;
    private final Headers headers;
    private CacheControl lazyCacheControl;
    private final String method;
    private final Tags tags;
    private final HttpUrl url;

    public final String toCurl() {
        return toCurl$default(this, false, 1, null);
    }

    public Request(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        HttpUrl url$okhttp = builder.getUrl$okhttp();
        if (url$okhttp == null) {
            throw new IllegalStateException("url == null".toString());
        }
        this.url = url$okhttp;
        this.method = builder.getMethod$okhttp();
        this.headers = builder.getHeaders$okhttp().build();
        this.body = builder.getBody$okhttp();
        this.cacheUrlOverride = builder.getCacheUrlOverride$okhttp();
        this.tags = builder.getTags$okhttp();
    }

    public final HttpUrl url() {
        return this.url;
    }

    public final String method() {
        return this.method;
    }

    public final Headers headers() {
        return this.headers;
    }

    public final RequestBody body() {
        return this.body;
    }

    public final HttpUrl cacheUrlOverride() {
        return this.cacheUrlOverride;
    }

    public final Tags getTags$okhttp() {
        return this.tags;
    }

    public final boolean isHttps() {
        return this.url.isHttps();
    }

    public  Request(HttpUrl httpUrl, Headers headers, String str, RequestBody requestBody, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(httpUrl, (i & 2) != 0 ? Headers.Companion.of(new String[0]) : headers, (i & 4) != 0 ? "\u0000" : str, (i & 8) != 0 ? null : requestBody);
    }

    public Request(HttpUrl url, Headers headers, String method, RequestBody body) {
        String str;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(headers, "headers");
        Intrinsics.checkNotNullParameter(method, "method");
        Builder builderHeaders = new Builder().url(url).headers(headers);
        if (Intrinsics.areEqual(method, "\u0000")) {
            str = body != null ? "POST" : "GET";
        } else {
            str = method;
        }
        this(builderHeaders.method(str, body));
    }

    public final String header(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.headers.get(name);
    }

    public final List<String> headers(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return this.headers.values(name);
    }

    public final  <T> T reifiedTag() {
        Intrinsics.reifiedOperationMarker(4, "T");
        return (T) tag(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final <T> T tag(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "type");
        return (T) JvmClassMappingKt.getJavaClass((KClass) kClass).cast(this.tags.get(kClass));
    }

    public final Object tag() {
        return tag(Reflection.getOrCreateKotlinClass(Object.class));
    }

    public final <T> T tag(Class<? extends T> cls) {
        Intrinsics.checkNotNullParameter(cls, "type");
        return (T) tag(JvmClassMappingKt.getKotlinClass(cls));
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    public final CacheControl cacheControl() {
        CacheControl result = this.lazyCacheControl;
        if (result == null) {
            CacheControl result2 = CacheControl.Companion.parse(this.headers);
            this.lazyCacheControl = result2;
            return result2;
        }
        return result;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "url", imports = {}))

    public final HttpUrl m1716deprecated_url() {
        return this.url;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "method", imports = {}))

    public final String m1715deprecated_method() {
        return this.method;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "headers", imports = {}))

    public final Headers m1714deprecated_headers() {
        return this.headers;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "body", imports = {}))

    public final RequestBody m1712deprecated_body() {
        return this.body;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "cacheControl", imports = {}))

    public final CacheControl m1713deprecated_cacheControl() {
        return cacheControl();
    }

    public String toString() {
        StringBuilder $this$toString_u24lambda_u240 = new StringBuilder(32);
        $this$toString_u24lambda_u240.append("Request{method=");
        $this$toString_u24lambda_u240.append(this.method);
        $this$toString_u24lambda_u240.append(", url=");
        $this$toString_u24lambda_u240.append(this.url);
        if (this.headers.size() != 0) {
            $this$toString_u24lambda_u240.append(", headers=[");
            Iterable $this$forEachIndexed$iv = this.headers;
            int index = 0;
            for (Object item$iv : $this$forEachIndexed$iv) {
                int index$iv = index + 1;
                if (index < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Pair<? extends String, ? extends String> pair = (Pair) item$iv;
                String name = pair.component1();
                String value = pair.component2();
                if (index > 0) {
                    $this$toString_u24lambda_u240.append(", ");
                }
                $this$toString_u24lambda_u240.append(name);
                $this$toString_u24lambda_u240.append(AbstractJsonLexerKt.COLON);
                $this$toString_u24lambda_u240.append(_UtilCommonKt.isSensitiveHeader(name) ? "██" : value);
                index = index$iv;
            }
            $this$toString_u24lambda_u240.append(AbstractJsonLexerKt.END_LIST);
        }
        if (!Intrinsics.areEqual(this.tags, EmptyTags.INSTANCE)) {
            $this$toString_u24lambda_u240.append(", tags=");
            $this$toString_u24lambda_u240.append(this.tags);
        }
        $this$toString_u24lambda_u240.append(AbstractJsonLexerKt.END_OBJ);
        return $this$toString_u24lambda_u240.toString();
    }

    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\u000eH\u0016J\u0010\u0010(\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u000eH\u0002J\u0010\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020)H\u0016J\u0018\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000eH\u0016J\u0018\u0010-\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u000eH\u0016J\u0010\u0010.\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u000eH\u0016J\u0010\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020\u00002\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020\u0000H\u0016J\b\u00103\u001a\u00020\u0000H\u0016J\u0010\u00104\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0014\u00105\u001a\u00020\u00002\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0017J\u0010\u00106\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u00107\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u0010\u00108\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\u001a\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J&\u00109\u001a\u00020\u0000\"\n\b\u0000\u0010:\u0018\u0001*\u00020\u00012\b\u00109\u001a\u0004\u0018\u0001H:H\u0087\b¢\u0006\u0004\b;\u0010<J-\u00109\u001a\u00020\u0000\"\b\b\u0000\u0010:*\u00020\u00012\f\u0010=\u001a\b\u0012\u0004\u0012\u0002H:0>2\b\u00109\u001a\u0004\u0018\u0001H:¢\u0006\u0002\u0010?J\u0012\u00109\u001a\u00020\u00002\b\u00109\u001a\u0004\u0018\u00010\u0001H\u0016J-\u00109\u001a\u00020\u0000\"\u0004\b\u0000\u0010:2\u000e\u0010=\u001a\n\u0012\u0006\b\u0000\u0012\u0002H:0@2\b\u00109\u001a\u0004\u0018\u0001H:H\u0016¢\u0006\u0002\u0010AJ\u0010\u0010\u001f\u001a\u00020\u00002\b\u0010\u001f\u001a\u0004\u0018\u00010\bJ\u0006\u0010B\u001a\u00020\u0000J\b\u0010C\u001a\u00020\u0005H\u0016R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u001c\u0010\u001f\u001a\u0004\u0018\u00010\bX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\n\"\u0004\b!\u0010\fR\u001a\u0010\"\u001a\u00020#X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006D"}, d2 = {"Lni/shikatu/okhttp3/Request$Builder;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "request", "Lni/shikatu/okhttp3/Request;", "(Lokhttp3/Request;)V", "url", "Lni/shikatu/okhttp3/HttpUrl;", "getUrl$okhttp", "()Lokhttp3/HttpUrl;", "setUrl$okhttp", "(Lokhttp3/HttpUrl;)V", "method", _UrlKt.FRAGMENT_ENCODE_SET, "getMethod$okhttp", "()Ljava/lang/String;", "setMethod$okhttp", "(Ljava/lang/String;)V", "headers", "Lni/shikatu/okhttp3/Headers$Builder;", "getHeaders$okhttp", "()Lokhttp3/Headers$Builder;", "setHeaders$okhttp", "(Lokhttp3/Headers$Builder;)V", "body", "Lni/shikatu/okhttp3/RequestBody;", "getBody$okhttp", "()Lokhttp3/RequestBody;", "setBody$okhttp", "(Lokhttp3/RequestBody;)V", "cacheUrlOverride", "getCacheUrlOverride$okhttp", "setCacheUrlOverride$okhttp", "tags", "Lni/shikatu/okhttp3/internal/Tags;", "getTags$okhttp", "()Lokhttp3/internal/Tags;", "setTags$okhttp", "(Lokhttp3/internal/Tags;)V", "canonicalUrl", "Ljava/net/URL;", "header", "name", "value", "addHeader", "removeHeader", "Lni/shikatu/okhttp3/Headers;", "cacheControl", "Lni/shikatu/okhttp3/CacheControl;", "get", "head", "post", "delete", "put", "patch", "query", "tag", "T", "reifiedTag", "(Ljava/lang/Object;)Lokhttp3/Request$Builder;", "type", "Lni/shikatu/kotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lokhttp3/Request$Builder;", "Ljava/lang/Class;", "(Ljava/lang/Class;Ljava/lang/Object;)Lokhttp3/Request$Builder;", "gzip", "build", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static class Builder {
        private RequestBody body;
        private HttpUrl cacheUrlOverride;
        private Headers.Builder headers;
        private String method;
        private Tags tags;
        private HttpUrl url;

        public final Builder delete() {
            return delete$default(this, null, 1, null);
        }

        public final HttpUrl getUrl$okhttp() {
            return this.url;
        }

        public final void setUrl$okhttp(HttpUrl httpUrl) {
            this.url = httpUrl;
        }

        public final String getMethod$okhttp() {
            return this.method;
        }

        public final void setMethod$okhttp(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.method = str;
        }

        public final Headers.Builder getHeaders$okhttp() {
            return this.headers;
        }

        public final void setHeaders$okhttp(Headers.Builder builder) {
            Intrinsics.checkNotNullParameter(builder, "<set-?>");
            this.headers = builder;
        }

        public final RequestBody getBody$okhttp() {
            return this.body;
        }

        public final void setBody$okhttp(RequestBody requestBody) {
            this.body = requestBody;
        }

        public final HttpUrl getCacheUrlOverride$okhttp() {
            return this.cacheUrlOverride;
        }

        public final void setCacheUrlOverride$okhttp(HttpUrl httpUrl) {
            this.cacheUrlOverride = httpUrl;
        }

        public final Tags getTags$okhttp() {
            return this.tags;
        }

        public final void setTags$okhttp(Tags tags) {
            Intrinsics.checkNotNullParameter(tags, "<set-?>");
            this.tags = tags;
        }

        public Builder() {
            this.tags = EmptyTags.INSTANCE;
            this.method = "GET";
            this.headers = new Headers.Builder();
        }

        public Builder(Request request) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.tags = EmptyTags.INSTANCE;
            this.url = request.url();
            this.method = request.method();
            this.body = request.body();
            this.tags = request.getTags$okhttp();
            this.headers = request.headers().newBuilder();
            this.cacheUrlOverride = request.cacheUrlOverride();
        }

        public Builder url(HttpUrl url) {
            Intrinsics.checkNotNullParameter(url, "url");
            Builder $this$url_u24lambda_u240 = this;
            $this$url_u24lambda_u240.url = url;
            return this;
        }

        public Builder url(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return url(HttpUrl.Companion.get(canonicalUrl(url)));
        }

        private final String canonicalUrl(String url) {
            if (StringsKt.startsWith(url, "ws:", true)) {
                StringBuilder sbAppend = new StringBuilder().append("http:");
                String strSubstring = url.substring(3);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                return sbAppend.append(strSubstring).toString();
            }
            if (!StringsKt.startsWith(url, "wss:", true)) {
                return url;
            }
            StringBuilder sbAppend2 = new StringBuilder().append("https:");
            String strSubstring2 = url.substring(4);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            return sbAppend2.append(strSubstring2).toString();
        }

        public Builder url(URL url) {
            Intrinsics.checkNotNullParameter(url, "url");
            HttpUrl.Companion companion = HttpUrl.Companion;
            String string = url.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return url(companion.get(string));
        }

        public Builder header(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Builder $this$header_u24lambda_u240 = this;
            $this$header_u24lambda_u240.headers.set(name, value);
            return this;
        }

        public Builder addHeader(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Builder $this$addHeader_u24lambda_u240 = this;
            $this$addHeader_u24lambda_u240.headers.add(name, value);
            return this;
        }

        public Builder removeHeader(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            Builder $this$removeHeader_u24lambda_u240 = this;
            $this$removeHeader_u24lambda_u240.headers.removeAll(name);
            return this;
        }

        public Builder headers(Headers headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            Builder $this$headers_u24lambda_u240 = this;
            $this$headers_u24lambda_u240.headers = headers.newBuilder();
            return this;
        }

        public Builder cacheControl(CacheControl cacheControl) {
            Intrinsics.checkNotNullParameter(cacheControl, "cacheControl");
            String value = cacheControl.toString();
            return value.length() == 0 ? removeHeader("Cache-Control") : header("Cache-Control", value);
        }

        public Builder get() {
            return method("GET", null);
        }

        public Builder head() {
            return method("HEAD", null);
        }

        public Builder post(RequestBody body) {
            Intrinsics.checkNotNullParameter(body, "body");
            return method("POST", body);
        }

        public static  Builder delete$default(Builder builder, RequestBody requestBody, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
            }
            if ((i & 1) != 0) {
                requestBody = RequestBody.EMPTY;
            }
            return builder.delete(requestBody);
        }

        public Builder delete(RequestBody body) {
            return method("DELETE", body);
        }

        public Builder put(RequestBody body) {
            Intrinsics.checkNotNullParameter(body, "body");
            return method("PUT", body);
        }

        public Builder patch(RequestBody body) {
            Intrinsics.checkNotNullParameter(body, "body");
            return method("PATCH", body);
        }

        public Builder query(RequestBody body) {
            Intrinsics.checkNotNullParameter(body, "body");
            return method("QUERY", body);
        }

        public Builder method(String method, RequestBody body) {
            Intrinsics.checkNotNullParameter(method, "method");
            Builder $this$method_u24lambda_u240 = this;
            if (!(method.length() > 0)) {
                throw new IllegalArgumentException("method.isEmpty() == true".toString());
            }
            if (body == null) {
                if (HttpMethod.requiresRequestBody(method)) {
                    throw new IllegalArgumentException(("method " + method + " must have a request body.").toString());
                }
            } else if (!HttpMethod.permitsRequestBody(method)) {
                throw new IllegalArgumentException(("method " + method + " must not have a request body.").toString());
            }
            $this$method_u24lambda_u240.method = method;
            $this$method_u24lambda_u240.body = body;
            return this;
        }

        public final  <T> Builder reifiedTag(T t) {
            Intrinsics.reifiedOperationMarker(4, "T");
            return tag(Reflection.getOrCreateKotlinClass(Object.class), t);
        }

        public final <T> Builder tag(KClass<T> kClass, T t) {
            Intrinsics.checkNotNullParameter(kClass, "type");
            Builder $this$tag_u24lambda_u240 = this;
            $this$tag_u24lambda_u240.tags = $this$tag_u24lambda_u240.tags.plus(kClass, t);
            return this;
        }

        public Builder tag(Object tag) {
            return tag((KClass<Object>) Reflection.getOrCreateKotlinClass(Object.class), tag);
        }

        public <T> Builder tag(Class<? super T> cls, T t) {
            Intrinsics.checkNotNullParameter(cls, "type");
            return tag(JvmClassMappingKt.getKotlinClass(cls), t);
        }

        public final Builder cacheUrlOverride(HttpUrl cacheUrlOverride) {
            Builder $this$cacheUrlOverride_u24lambda_u240 = this;
            $this$cacheUrlOverride_u24lambda_u240.cacheUrlOverride = cacheUrlOverride;
            return this;
        }

        public final Builder gzip() {
            Builder $this$gzip_u24lambda_u240 = this;
            RequestBody identityBody = $this$gzip_u24lambda_u240.body;
            if (identityBody == null) {
                throw new IllegalStateException("cannot gzip a request that has no body");
            }
            String contentEncoding = $this$gzip_u24lambda_u240.headers.get("Content-Encoding");
            if (!(contentEncoding == null)) {
                throw new IllegalStateException(("Content-Encoding already set: " + contentEncoding).toString());
            }
            $this$gzip_u24lambda_u240.headers.add("Content-Encoding", "gzip");
            $this$gzip_u24lambda_u240.body = new GzipRequestBody(identityBody);
            return this;
        }

        public Request build() {
            return new Request(this);
        }
    }

    public static  String toCurl$default(Request request, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = true;
        }
        return request.toCurl(z);
    }

    public final String toCurl(boolean includeBody) throws IOException {
        MediaType mediaTypeContentType;
        StringBuilder $this$toCurl_u24lambda_u240 = new StringBuilder();
        $this$toCurl_u24lambda_u240.append("curl " + shellEscape(this.url.toString()));
        RequestBody requestBody = this.body;
        String contentType = (requestBody == null || (mediaTypeContentType = requestBody.contentType()) == null) ? null : mediaTypeContentType.toString();
        String defaultMethod = (!includeBody || this.body == null) ? "GET" : "POST";
        if (!Intrinsics.areEqual(this.method, defaultMethod)) {
            $this$toCurl_u24lambda_u240.append(" \\\n  -X " + shellEscape(this.method));
        }
        for (Pair<? extends String, ? extends String> pair : this.headers) {
            String name = pair.component1();
            String value = pair.component2();
            if (contentType == null || !StringsKt.equals(name, "Content-Type", true)) {
                $this$toCurl_u24lambda_u240.append(" \\\n  -H " + shellEscape(name + ": " + value));
            }
        }
        if (contentType != null) {
            $this$toCurl_u24lambda_u240.append(" \\\n  -H " + shellEscape("Content-Type: " + contentType));
        }
        if (includeBody && this.body != null) {
            Buffer bodyBuffer = new Buffer();
            this.body.writeTo(bodyBuffer);
            if (IsProbablyUtf8Kt.isProbablyUtf8$default(bodyBuffer, 0L, 1, null)) {
                $this$toCurl_u24lambda_u240.append(" \\\n  --data " + shellEscape(bodyBuffer.readUtf8()));
            } else {
                $this$toCurl_u24lambda_u240.append(" \\\n  --data-binary " + shellEscape(bodyBuffer.readByteString().hex()));
            }
        }
        return $this$toCurl_u24lambda_u240.toString();
    }

    private final String shellEscape(String $this$shellEscape) {
        return '\'' + StringsKt.replace$default($this$shellEscape, "'", "'\\''", false, 4, (Object) null) + '\'';
    }
}
