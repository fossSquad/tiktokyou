package ni.shikatu.okhttp3.internal.cache;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlin.time.DurationKt;
import ni.shikatu.okhttp3.CacheControl;
import ni.shikatu.okhttp3.Headers;
import ni.shikatu.okhttp3.Request;
import ni.shikatu.okhttp3.Response;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal.http.DateFormattingKt;
import ni.shikatu.okhttp3.internal.http.HttpStatusCodesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \r2\u00020\u0001:\u0002\f\rB\u001d\b\u0000\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000e"}, d2 = {"Lni/shikatu/okhttp3/internal/cache/CacheStrategy;", _UrlKt.FRAGMENT_ENCODE_SET, "networkRequest", "Lni/shikatu/okhttp3/Request;", "cacheResponse", "Lni/shikatu/okhttp3/Response;", "<init>", "(Lokhttp3/Request;Lokhttp3/Response;)V", "getNetworkRequest", "()Lokhttp3/Request;", "getCacheResponse", "()Lokhttp3/Response;", "Factory", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CacheStrategy {
    public static final Companion Companion = new Companion(null);
    private final Response cacheResponse;
    private final Request networkRequest;

    public CacheStrategy(Request networkRequest, Response cacheResponse) {
        this.networkRequest = networkRequest;
        this.cacheResponse = cacheResponse;
    }

    public final Request getNetworkRequest() {
        return this.networkRequest;
    }

    public final Response getCacheResponse() {
        return this.cacheResponse;
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0018\u001a\u00020\u0019H\u0002J\u0006\u0010\u001a\u001a\u00020\u001bJ\b\u0010\u001c\u001a\u00020\u001bH\u0002J\b\u0010\u001d\u001a\u00020\u0003H\u0002J\b\u0010\u001e\u001a\u00020\u0003H\u0002J\u0010\u0010\u001f\u001a\u00020\u00192\u0006\u0010\u0004\u001a\u00020\u0005H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lni/shikatu/okhttp3/internal/cache/CacheStrategy$Factory;", _UrlKt.FRAGMENT_ENCODE_SET, "nowMillis", _UrlKt.FRAGMENT_ENCODE_SET, "request", "Lni/shikatu/okhttp3/Request;", "cacheResponse", "Lni/shikatu/okhttp3/Response;", "<init>", "(JLokhttp3/Request;Lokhttp3/Response;)V", "getRequest$okhttp", "()Lokhttp3/Request;", "servedDate", "Ljava/util/Date;", "servedDateString", _UrlKt.FRAGMENT_ENCODE_SET, "lastModified", "lastModifiedString", "expires", "sentRequestMillis", "receivedResponseMillis", "etag", "ageSeconds", _UrlKt.FRAGMENT_ENCODE_SET, "isFreshnessLifetimeHeuristic", _UrlKt.FRAGMENT_ENCODE_SET, "compute", "Lni/shikatu/okhttp3/internal/cache/CacheStrategy;", "computeCandidate", "computeFreshnessLifetime", "cacheResponseAge", "hasConditions", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Factory {
        private int ageSeconds;
        private final Response cacheResponse;
        private String etag;
        private Date expires;
        private Date lastModified;
        private String lastModifiedString;
        private final long nowMillis;
        private long receivedResponseMillis;
        private final Request request;
        private long sentRequestMillis;
        private Date servedDate;
        private String servedDateString;

        public Factory(long nowMillis, Request request, Response cacheResponse) {
            Intrinsics.checkNotNullParameter(request, "request");
            this.nowMillis = nowMillis;
            this.request = request;
            this.cacheResponse = cacheResponse;
            this.ageSeconds = -1;
            if (this.cacheResponse == null) {
                return;
            }
            this.sentRequestMillis = this.cacheResponse.sentRequestAtMillis();
            this.receivedResponseMillis = this.cacheResponse.receivedResponseAtMillis();
            Headers headers = this.cacheResponse.headers();
            int size = headers.size();
            for (int i = 0; i < size; i++) {
                String fieldName = headers.name(i);
                String value = headers.value(i);
                if (StringsKt.equals(fieldName, "Date", true)) {
                    this.servedDate = DateFormattingKt.toHttpDateOrNull(value);
                    this.servedDateString = value;
                } else if (StringsKt.equals(fieldName, "Expires", true)) {
                    this.expires = DateFormattingKt.toHttpDateOrNull(value);
                } else if (StringsKt.equals(fieldName, "Last-Modified", true)) {
                    this.lastModified = DateFormattingKt.toHttpDateOrNull(value);
                    this.lastModifiedString = value;
                } else if (StringsKt.equals(fieldName, "ETag", true)) {
                    this.etag = value;
                } else if (StringsKt.equals(fieldName, "Age", true)) {
                    this.ageSeconds = _UtilCommonKt.toNonNegativeInt(value, -1);
                }
            }
        }

        public final Request getRequest$okhttp() {
            return this.request;
        }

        private final boolean isFreshnessLifetimeHeuristic() {
            Response response = this.cacheResponse;
            Intrinsics.checkNotNull(response);
            return response.cacheControl().maxAgeSeconds() == -1 && this.expires == null;
        }

        public final CacheStrategy compute() {
            CacheStrategy candidate = computeCandidate();
            if (candidate.getNetworkRequest() != null && this.request.cacheControl().onlyIfCached()) {
                return new CacheStrategy(null, null);
            }
            return candidate;
        }

        private final CacheStrategy computeCandidate() {
            String conditionName;
            String conditionName2;
            if (this.cacheResponse == null) {
                return new CacheStrategy(this.request, null);
            }
            if (!this.request.isHttps() || this.cacheResponse.handshake() != null) {
                if (!CacheStrategy.Companion.isCacheable(this.cacheResponse, this.request)) {
                    return new CacheStrategy(this.request, null);
                }
                CacheControl requestCaching = this.request.cacheControl();
                if (requestCaching.noCache() || hasConditions(this.request)) {
                    return new CacheStrategy(this.request, null);
                }
                CacheControl responseCaching = this.cacheResponse.cacheControl();
                long ageMillis = cacheResponseAge();
                long freshMillis = computeFreshnessLifetime();
                if (requestCaching.maxAgeSeconds() != -1) {
                    freshMillis = Math.min(freshMillis, TimeUnit.SECONDS.toMillis(requestCaching.maxAgeSeconds()));
                }
                long minFreshMillis = 0;
                if (requestCaching.minFreshSeconds() != -1) {
                    minFreshMillis = TimeUnit.SECONDS.toMillis(requestCaching.minFreshSeconds());
                }
                long maxStaleMillis = 0;
                if (!responseCaching.mustRevalidate() && requestCaching.maxStaleSeconds() != -1) {
                    maxStaleMillis = TimeUnit.SECONDS.toMillis(requestCaching.maxStaleSeconds());
                }
                if (!responseCaching.noCache() && ageMillis + minFreshMillis < freshMillis + maxStaleMillis) {
                    Response.Builder builder = this.cacheResponse.newBuilder();
                    if (ageMillis + minFreshMillis >= freshMillis) {
                        builder.addHeader("Warning", "110 HttpURLConnection \"Response is stale\"");
                    }
                    if (ageMillis > DurationKt.MILLIS_IN_DAY && isFreshnessLifetimeHeuristic()) {
                        builder.addHeader("Warning", "113 HttpURLConnection \"Heuristic expiration\"");
                    }
                    return new CacheStrategy(null, builder.build());
                }
                if (this.etag != null) {
                    conditionName = "If-None-Match";
                    conditionName2 = this.etag;
                } else if (this.lastModified != null) {
                    conditionName = "If-Modified-Since";
                    conditionName2 = this.lastModifiedString;
                } else {
                    if (this.servedDate == null) {
                        return new CacheStrategy(this.request, null);
                    }
                    conditionName = "If-Modified-Since";
                    conditionName2 = this.servedDateString;
                }
                Headers.Builder conditionalRequestHeaders = this.request.headers().newBuilder();
                Intrinsics.checkNotNull(conditionName2);
                conditionalRequestHeaders.addLenient$okhttp(conditionName, conditionName2);
                Request conditionalRequest = this.request.newBuilder().headers(conditionalRequestHeaders.build()).build();
                return new CacheStrategy(conditionalRequest, this.cacheResponse);
            }
            return new CacheStrategy(this.request, null);
        }

        private final long computeFreshnessLifetime() {
            Response response = this.cacheResponse;
            Intrinsics.checkNotNull(response);
            CacheControl responseCaching = response.cacheControl();
            if (responseCaching.maxAgeSeconds() != -1) {
                return TimeUnit.SECONDS.toMillis(responseCaching.maxAgeSeconds());
            }
            Date expires = this.expires;
            if (expires != null) {
                Date date = this.servedDate;
                long servedMillis = date != null ? date.getTime() : this.receivedResponseMillis;
                long delta = expires.getTime() - servedMillis;
                if (delta > 0) {
                    return delta;
                }
                return 0L;
            }
            if (this.lastModified == null || this.cacheResponse.request().url().query() != null) {
                return 0L;
            }
            Date date2 = this.servedDate;
            long servedMillis2 = date2 != null ? date2.getTime() : this.sentRequestMillis;
            Date date3 = this.lastModified;
            Intrinsics.checkNotNull(date3);
            long delta2 = servedMillis2 - date3.getTime();
            if (delta2 > 0) {
                return delta2 / ((long) 10);
            }
            return 0L;
        }

        private final long cacheResponseAge() {
            long apparentReceivedAge;
            long receivedAge;
            Date servedDate = this.servedDate;
            if (servedDate != null) {
                apparentReceivedAge = Math.max(0L, this.receivedResponseMillis - servedDate.getTime());
            } else {
                apparentReceivedAge = 0;
            }
            if (this.ageSeconds != -1) {
                receivedAge = Math.max(apparentReceivedAge, TimeUnit.SECONDS.toMillis(this.ageSeconds));
            } else {
                receivedAge = apparentReceivedAge;
            }
            long responseDuration = Math.max(0L, this.receivedResponseMillis - this.sentRequestMillis);
            long residentDuration = Math.max(0L, this.nowMillis - this.receivedResponseMillis);
            return receivedAge + responseDuration + residentDuration;
        }

        private final boolean hasConditions(Request request) {
            return (request.header("If-Modified-Since") == null && request.header("If-None-Match") == null) ? false : true;
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¨\u0006\n"}, d2 = {"Lni/shikatu/okhttp3/internal/cache/CacheStrategy$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "isCacheable", _UrlKt.FRAGMENT_ENCODE_SET, "response", "Lni/shikatu/okhttp3/Response;", "request", "Lni/shikatu/okhttp3/Request;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isCacheable(Response response, Request request) {
            Intrinsics.checkNotNullParameter(response, "response");
            Intrinsics.checkNotNullParameter(request, "request");
            switch (response.code()) {
                case 200:
                case 203:
                case 204:
                case 300:
                case 301:
                case HttpStatusCodesKt.HTTP_PERM_REDIRECT /* 308 */:
                case 404:
                case 405:
                case 410:
                case 414:
                case 501:
                    break;
                case 302:
                case HttpStatusCodesKt.HTTP_TEMP_REDIRECT /* 307 */:
                    if (Response.header$default(response, "Expires", null, 2, null) == null && response.cacheControl().maxAgeSeconds() == -1 && !response.cacheControl().isPublic() && !response.cacheControl().isPrivate()) {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
            return (response.cacheControl().noStore() || request.cacheControl().noStore()) ? false : true;
        }
    }
}
