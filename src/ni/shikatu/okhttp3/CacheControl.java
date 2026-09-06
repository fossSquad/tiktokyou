package ni.shikatu.okhttp3;

import java.util.concurrent.TimeUnit;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.jvm.JvmStatic;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.time.Duration;
import ni.shikatu.okhttp3.internal._CacheControlCommonKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u0000 &2\u00020\u0001:\u0002%&Bs\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u0003\u0012\u0006\u0010\u000f\u001a\u00020\u0003\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001aJ\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001bJ\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u001cJ\r\u0010\u0007\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u001dJ\r\u0010\n\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001eJ\r\u0010\u000b\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u001fJ\r\u0010\f\u001a\u00020\u0006H\u0007¢\u0006\u0002\b J\r\u0010\r\u001a\u00020\u0003H\u0007¢\u0006\u0002\b!J\r\u0010\u000e\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\"J\r\u0010\u000f\u001a\u00020\u0003H\u0007¢\u0006\u0002\b#J\b\u0010$\u001a\u00020\u0011H\u0016R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0014R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0014R\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0015R\u0013\u0010\u0007\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0014R\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0014R\u0013\u0010\n\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0014R\u0013\u0010\u000b\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0015R\u0013\u0010\f\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0015R\u0013\u0010\r\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0014R\u0013\u0010\u000e\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0014R\u0013\u0010\u000f\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0014R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006'"}, d2 = {"Lni/shikatu/okhttp3/CacheControl;", _UrlKt.FRAGMENT_ENCODE_SET, "noCache", _UrlKt.FRAGMENT_ENCODE_SET, "noStore", "maxAgeSeconds", _UrlKt.FRAGMENT_ENCODE_SET, "sMaxAgeSeconds", "isPrivate", "isPublic", "mustRevalidate", "maxStaleSeconds", "minFreshSeconds", "onlyIfCached", "noTransform", "immutable", "headerValue", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(ZZIIZZZIIZZZLjava/lang/String;)V", "()Z", "()I", "getHeaderValue$okhttp", "()Ljava/lang/String;", "setHeaderValue$okhttp", "(Ljava/lang/String;)V", "-deprecated_noCache", "-deprecated_noStore", "-deprecated_maxAgeSeconds", "-deprecated_sMaxAgeSeconds", "-deprecated_mustRevalidate", "-deprecated_maxStaleSeconds", "-deprecated_minFreshSeconds", "-deprecated_onlyIfCached", "-deprecated_noTransform", "-deprecated_immutable", "toString", "Builder", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CacheControl {
    private String headerValue;
    private final boolean immutable;
    private final boolean isPrivate;
    private final boolean isPublic;
    private final int maxAgeSeconds;
    private final int maxStaleSeconds;
    private final int minFreshSeconds;
    private final boolean mustRevalidate;
    private final boolean noCache;
    private final boolean noStore;
    private final boolean noTransform;
    private final boolean onlyIfCached;
    private final int sMaxAgeSeconds;
    public static final Companion Companion = new Companion(null);
    public static final CacheControl FORCE_NETWORK = _CacheControlCommonKt.commonForceNetwork(Companion);
    public static final CacheControl FORCE_CACHE = _CacheControlCommonKt.commonForceCache(Companion);

    public CacheControl(boolean noCache, boolean noStore, int maxAgeSeconds, int sMaxAgeSeconds, boolean isPrivate, boolean isPublic, boolean mustRevalidate, int maxStaleSeconds, int minFreshSeconds, boolean onlyIfCached, boolean noTransform, boolean immutable, String headerValue) {
        this.noCache = noCache;
        this.noStore = noStore;
        this.maxAgeSeconds = maxAgeSeconds;
        this.sMaxAgeSeconds = sMaxAgeSeconds;
        this.isPrivate = isPrivate;
        this.isPublic = isPublic;
        this.mustRevalidate = mustRevalidate;
        this.maxStaleSeconds = maxStaleSeconds;
        this.minFreshSeconds = minFreshSeconds;
        this.onlyIfCached = onlyIfCached;
        this.noTransform = noTransform;
        this.immutable = immutable;
        this.headerValue = headerValue;
    }

    public final boolean noCache() {
        return this.noCache;
    }

    public final boolean noStore() {
        return this.noStore;
    }

    public final int maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    public final int sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    public final boolean isPrivate() {
        return this.isPrivate;
    }

    public final boolean isPublic() {
        return this.isPublic;
    }

    public final boolean mustRevalidate() {
        return this.mustRevalidate;
    }

    public final int maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    public final int minFreshSeconds() {
        return this.minFreshSeconds;
    }

    public final boolean onlyIfCached() {
        return this.onlyIfCached;
    }

    public final boolean noTransform() {
        return this.noTransform;
    }

    public final boolean immutable() {
        return this.immutable;
    }

    public final String getHeaderValue$okhttp() {
        return this.headerValue;
    }

    public final void setHeaderValue$okhttp(String str) {
        this.headerValue = str;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noCache", imports = {}))

    public final boolean m1607deprecated_noCache() {
        return this.noCache;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noStore", imports = {}))

    public final boolean m1608deprecated_noStore() {
        return this.noStore;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "maxAgeSeconds", imports = {}))

    public final int m1603deprecated_maxAgeSeconds() {
        return this.maxAgeSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "sMaxAgeSeconds", imports = {}))

    public final int m1611deprecated_sMaxAgeSeconds() {
        return this.sMaxAgeSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "mustRevalidate", imports = {}))

    public final boolean m1606deprecated_mustRevalidate() {
        return this.mustRevalidate;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "maxStaleSeconds", imports = {}))

    public final int m1604deprecated_maxStaleSeconds() {
        return this.maxStaleSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "minFreshSeconds", imports = {}))

    public final int m1605deprecated_minFreshSeconds() {
        return this.minFreshSeconds;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "onlyIfCached", imports = {}))

    public final boolean m1610deprecated_onlyIfCached() {
        return this.onlyIfCached;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "noTransform", imports = {}))

    public final boolean m1609deprecated_noTransform() {
        return this.noTransform;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "immutable", imports = {}))

    public final boolean m1602deprecated_immutable() {
        return this.immutable;
    }

    public String toString() {
        return _CacheControlCommonKt.commonToString(this);
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0000J\u0006\u0010\n\u001a\u00020\u0000J\u0006\u0010\u0019\u001a\u00020\u0000J\u0006\u0010\u001c\u001a\u00020\u0000J\u0006\u0010\u001f\u001a\u00020\u0000J\u0015\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020#¢\u0006\u0004\b$\u0010%J\u0015\u0010&\u001a\u00020\u00002\u0006\u0010&\u001a\u00020#¢\u0006\u0004\b'\u0010%J\u0015\u0010(\u001a\u00020\u00002\u0006\u0010(\u001a\u00020#¢\u0006\u0004\b)\u0010%J\u0016\u0010\"\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020+J\u0016\u0010&\u001a\u00020\u00002\u0006\u0010&\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020+J\u0016\u0010(\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u000e2\u0006\u0010*\u001a\u00020+J\u0006\u0010,\u001a\u00020-R\u001a\u0010\u0004\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0010\"\u0004\b\u0015\u0010\u0012R\u001a\u0010\u0016\u001a\u00020\u000eX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\u0019\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u0007\"\u0004\b\u001b\u0010\tR\u001a\u0010\u001c\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\tR\u001a\u0010\u001f\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0007\"\u0004\b!\u0010\t¨\u0006."}, d2 = {"Lni/shikatu/okhttp3/CacheControl$Builder;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "noCache", _UrlKt.FRAGMENT_ENCODE_SET, "getNoCache$okhttp", "()Z", "setNoCache$okhttp", "(Z)V", "noStore", "getNoStore$okhttp", "setNoStore$okhttp", "maxAgeSeconds", _UrlKt.FRAGMENT_ENCODE_SET, "getMaxAgeSeconds$okhttp", "()I", "setMaxAgeSeconds$okhttp", "(I)V", "maxStaleSeconds", "getMaxStaleSeconds$okhttp", "setMaxStaleSeconds$okhttp", "minFreshSeconds", "getMinFreshSeconds$okhttp", "setMinFreshSeconds$okhttp", "onlyIfCached", "getOnlyIfCached$okhttp", "setOnlyIfCached$okhttp", "noTransform", "getNoTransform$okhttp", "setNoTransform$okhttp", "immutable", "getImmutable$okhttp", "setImmutable$okhttp", "maxAge", "Lni/shikatu/kotlin/time/Duration;", "maxAge-LRDsOJo", "(J)Lokhttp3/CacheControl$Builder;", "maxStale", "maxStale-LRDsOJo", "minFresh", "minFresh-LRDsOJo", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "build", "Lni/shikatu/okhttp3/CacheControl;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        private boolean immutable;
        private int maxAgeSeconds = -1;
        private int maxStaleSeconds = -1;
        private int minFreshSeconds = -1;
        private boolean noCache;
        private boolean noStore;
        private boolean noTransform;
        private boolean onlyIfCached;

        public final boolean getNoCache$okhttp() {
            return this.noCache;
        }

        public final void setNoCache$okhttp(boolean z) {
            this.noCache = z;
        }

        public final boolean getNoStore$okhttp() {
            return this.noStore;
        }

        public final void setNoStore$okhttp(boolean z) {
            this.noStore = z;
        }

        public final int getMaxAgeSeconds$okhttp() {
            return this.maxAgeSeconds;
        }

        public final void setMaxAgeSeconds$okhttp(int i) {
            this.maxAgeSeconds = i;
        }

        public final int getMaxStaleSeconds$okhttp() {
            return this.maxStaleSeconds;
        }

        public final void setMaxStaleSeconds$okhttp(int i) {
            this.maxStaleSeconds = i;
        }

        public final int getMinFreshSeconds$okhttp() {
            return this.minFreshSeconds;
        }

        public final void setMinFreshSeconds$okhttp(int i) {
            this.minFreshSeconds = i;
        }

        public final boolean getOnlyIfCached$okhttp() {
            return this.onlyIfCached;
        }

        public final void setOnlyIfCached$okhttp(boolean z) {
            this.onlyIfCached = z;
        }

        public final boolean getNoTransform$okhttp() {
            return this.noTransform;
        }

        public final void setNoTransform$okhttp(boolean z) {
            this.noTransform = z;
        }

        public final boolean getImmutable$okhttp() {
            return this.immutable;
        }

        public final void setImmutable$okhttp(boolean z) {
            this.immutable = z;
        }

        public final Builder noCache() {
            return _CacheControlCommonKt.commonNoCache(this);
        }

        public final Builder noStore() {
            return _CacheControlCommonKt.commonNoStore(this);
        }

        public final Builder onlyIfCached() {
            return _CacheControlCommonKt.commonOnlyIfCached(this);
        }

        public final Builder noTransform() {
            return _CacheControlCommonKt.commonNoTransform(this);
        }

        public final Builder immutable() {
            return _CacheControlCommonKt.commonImmutable(this);
        }

        public final Builder m1612maxAgeLRDsOJo(long j) {
            Builder $this$maxAge_LRDsOJo_u24lambda_u240 = this;
            long maxAgeSeconds = Duration.m1399getInWholeSecondsimpl(j);
            if (!(maxAgeSeconds >= 0)) {
                throw new IllegalArgumentException(("maxAge < 0: " + maxAgeSeconds).toString());
            }
            $this$maxAge_LRDsOJo_u24lambda_u240.maxAgeSeconds = _CacheControlCommonKt.commonClampToInt(maxAgeSeconds);
            return this;
        }

        public final Builder m1613maxStaleLRDsOJo(long j) {
            Builder $this$maxStale_LRDsOJo_u24lambda_u240 = this;
            long maxStaleSeconds = Duration.m1399getInWholeSecondsimpl(j);
            if (!(maxStaleSeconds >= 0)) {
                throw new IllegalArgumentException(("maxStale < 0: " + maxStaleSeconds).toString());
            }
            $this$maxStale_LRDsOJo_u24lambda_u240.maxStaleSeconds = _CacheControlCommonKt.commonClampToInt(maxStaleSeconds);
            return this;
        }

        public final Builder m1614minFreshLRDsOJo(long j) {
            Builder $this$minFresh_LRDsOJo_u24lambda_u240 = this;
            long minFreshSeconds = Duration.m1399getInWholeSecondsimpl(j);
            if (!(minFreshSeconds >= 0)) {
                throw new IllegalArgumentException(("minFresh < 0: " + minFreshSeconds).toString());
            }
            $this$minFresh_LRDsOJo_u24lambda_u240.minFreshSeconds = _CacheControlCommonKt.commonClampToInt(minFreshSeconds);
            return this;
        }

        public final Builder maxAge(int maxAge, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            Builder $this$maxAge_u24lambda_u240 = this;
            if (!(maxAge >= 0)) {
                throw new IllegalArgumentException(("maxAge < 0: " + maxAge).toString());
            }
            long maxAgeSecondsLong = timeUnit.toSeconds(maxAge);
            $this$maxAge_u24lambda_u240.maxAgeSeconds = _CacheControlCommonKt.commonClampToInt(maxAgeSecondsLong);
            return this;
        }

        public final Builder maxStale(int maxStale, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            Builder $this$maxStale_u24lambda_u240 = this;
            if (!(maxStale >= 0)) {
                throw new IllegalArgumentException(("maxStale < 0: " + maxStale).toString());
            }
            long maxStaleSecondsLong = timeUnit.toSeconds(maxStale);
            $this$maxStale_u24lambda_u240.maxStaleSeconds = _CacheControlCommonKt.commonClampToInt(maxStaleSecondsLong);
            return this;
        }

        public final Builder minFresh(int minFresh, TimeUnit timeUnit) {
            Intrinsics.checkNotNullParameter(timeUnit, "timeUnit");
            Builder $this$minFresh_u24lambda_u240 = this;
            if (!(minFresh >= 0)) {
                throw new IllegalArgumentException(("minFresh < 0: " + minFresh).toString());
            }
            long minFreshSecondsLong = timeUnit.toSeconds(minFresh);
            $this$minFresh_u24lambda_u240.minFreshSeconds = _CacheControlCommonKt.commonClampToInt(minFreshSecondsLong);
            return this;
        }

        public final CacheControl build() {
            return _CacheControlCommonKt.commonBuild(this);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lni/shikatu/okhttp3/CacheControl$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "FORCE_NETWORK", "Lni/shikatu/okhttp3/CacheControl;", "FORCE_CACHE", "parse", "headers", "Lni/shikatu/okhttp3/Headers;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final CacheControl parse(Headers headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            return _CacheControlCommonKt.commonParse(this, headers);
        }
    }

    @JvmStatic
    public static final CacheControl parse(Headers headers) {
        return Companion.parse(headers);
    }
}
