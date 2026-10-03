package ni.shikatu.okhttp3.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.IntCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlin.time.Duration;
import ni.shikatu.kotlin.time.DurationKt;
import ni.shikatu.kotlin.time.DurationUnit;
import ni.shikatu.okhttp3.CacheControl;
import ni.shikatu.okhttp3.Headers;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\f\u0010\u0003\u001a\u00020\u0004*\u00020\u0005H\u0000\u001a\f\u0010\u0006\u001a\u00020\u0002*\u00020\u0007H\u0000\u001a\f\u0010\b\u001a\u00020\u0002*\u00020\u0007H\u0000\u001a\f\u0010\t\u001a\u00020\u0002*\u00020\nH\u0000\u001a\f\u0010\u000b\u001a\u00020\n*\u00020\nH\u0000\u001a\f\u0010\f\u001a\u00020\n*\u00020\nH\u0000\u001a\f\u0010\r\u001a\u00020\n*\u00020\nH\u0000\u001a\f\u0010\u000e\u001a\u00020\n*\u00020\nH\u0000\u001a\f\u0010\u000f\u001a\u00020\n*\u00020\nH\u0000\u001a\u0014\u0010\u0010\u001a\u00020\u0002*\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0012H\u0000\u001a\u001e\u0010\u0013\u001a\u00020\u0004*\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00012\b\b\u0002\u0010\u0015\u001a\u00020\u0004H\u0002¨\u0006\u0016"}, d2 = {"commonToString", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/CacheControl;", "commonClampToInt", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "commonForceNetwork", "Lni/shikatu/okhttp3/CacheControl$Companion;", "commonForceCache", "commonBuild", "Lni/shikatu/okhttp3/CacheControl$Builder;", "commonNoCache", "commonNoStore", "commonOnlyIfCached", "commonNoTransform", "commonImmutable", "commonParse", "headers", "Lni/shikatu/okhttp3/Headers;", "indexOfElement", "characters", "startIndex", "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class _CacheControlCommonKt {
    public static final String commonToString(CacheControl $this$commonToString) {
        Intrinsics.checkNotNullParameter($this$commonToString, "<this>");
        String result = $this$commonToString.getHeaderValue$okhttp();
        if (result == null) {
            StringBuilder $this$commonToString_u24lambda_u240 = new StringBuilder();
            if ($this$commonToString.noCache()) {
                $this$commonToString_u24lambda_u240.append("no-cache, ");
            }
            if ($this$commonToString.noStore()) {
                $this$commonToString_u24lambda_u240.append("no-store, ");
            }
            if ($this$commonToString.maxAgeSeconds() != -1) {
                $this$commonToString_u24lambda_u240.append("max-age=").append($this$commonToString.maxAgeSeconds()).append(", ");
            }
            if ($this$commonToString.sMaxAgeSeconds() != -1) {
                $this$commonToString_u24lambda_u240.append("s-maxage=").append($this$commonToString.sMaxAgeSeconds()).append(", ");
            }
            if ($this$commonToString.isPrivate()) {
                $this$commonToString_u24lambda_u240.append("private, ");
            }
            if ($this$commonToString.isPublic()) {
                $this$commonToString_u24lambda_u240.append("public, ");
            }
            if ($this$commonToString.mustRevalidate()) {
                $this$commonToString_u24lambda_u240.append("must-revalidate, ");
            }
            if ($this$commonToString.maxStaleSeconds() != -1) {
                $this$commonToString_u24lambda_u240.append("max-stale=").append($this$commonToString.maxStaleSeconds()).append(", ");
            }
            if ($this$commonToString.minFreshSeconds() != -1) {
                $this$commonToString_u24lambda_u240.append("min-fresh=").append($this$commonToString.minFreshSeconds()).append(", ");
            }
            if ($this$commonToString.onlyIfCached()) {
                $this$commonToString_u24lambda_u240.append("only-if-cached, ");
            }
            if ($this$commonToString.noTransform()) {
                $this$commonToString_u24lambda_u240.append("no-transform, ");
            }
            if ($this$commonToString.immutable()) {
                $this$commonToString_u24lambda_u240.append("immutable, ");
            }
            if ($this$commonToString_u24lambda_u240.length() == 0) {
                return _UrlKt.FRAGMENT_ENCODE_SET;
            }
            Intrinsics.checkNotNullExpressionValue($this$commonToString_u24lambda_u240.delete($this$commonToString_u24lambda_u240.length() - 2, $this$commonToString_u24lambda_u240.length()), "delete(...)");
            String result2 = $this$commonToString_u24lambda_u240.toString();
            $this$commonToString.setHeaderValue$okhttp(result2);
            return result2;
        }
        return result;
    }

    public static final int commonClampToInt(long $this$commonClampToInt) {
        return $this$commonClampToInt > 2147483647L ? IntCompanionObject.MAX_VALUE : (int) $this$commonClampToInt;
    }

    public static final CacheControl commonForceNetwork(CacheControl.Companion $this$commonForceNetwork) {
        Intrinsics.checkNotNullParameter($this$commonForceNetwork, "<this>");
        return new CacheControl.Builder().noCache().build();
    }

    public static final CacheControl commonForceCache(CacheControl.Companion $this$commonForceCache) {
        Intrinsics.checkNotNullParameter($this$commonForceCache, "<this>");
        CacheControl.Builder builderOnlyIfCached = new CacheControl.Builder().onlyIfCached();
        Duration.Companion companion = Duration.Companion;
        return builderOnlyIfCached.m1613maxStaleLRDsOJo(DurationKt.toDuration(IntCompanionObject.MAX_VALUE, DurationUnit.SECONDS)).build();
    }

    public static final CacheControl commonBuild(CacheControl.Builder $this$commonBuild) {
        Intrinsics.checkNotNullParameter($this$commonBuild, "<this>");
        return new CacheControl($this$commonBuild.getNoCache$okhttp(), $this$commonBuild.getNoStore$okhttp(), $this$commonBuild.getMaxAgeSeconds$okhttp(), -1, false, false, false, $this$commonBuild.getMaxStaleSeconds$okhttp(), $this$commonBuild.getMinFreshSeconds$okhttp(), $this$commonBuild.getOnlyIfCached$okhttp(), $this$commonBuild.getNoTransform$okhttp(), $this$commonBuild.getImmutable$okhttp(), null);
    }

    public static final CacheControl.Builder commonNoCache(CacheControl.Builder $this$commonNoCache) {
        Intrinsics.checkNotNullParameter($this$commonNoCache, "<this>");
        $this$commonNoCache.setNoCache$okhttp(true);
        return $this$commonNoCache;
    }

    public static final CacheControl.Builder commonNoStore(CacheControl.Builder $this$commonNoStore) {
        Intrinsics.checkNotNullParameter($this$commonNoStore, "<this>");
        $this$commonNoStore.setNoStore$okhttp(true);
        return $this$commonNoStore;
    }

    public static final CacheControl.Builder commonOnlyIfCached(CacheControl.Builder $this$commonOnlyIfCached) {
        Intrinsics.checkNotNullParameter($this$commonOnlyIfCached, "<this>");
        $this$commonOnlyIfCached.setOnlyIfCached$okhttp(true);
        return $this$commonOnlyIfCached;
    }

    public static final CacheControl.Builder commonNoTransform(CacheControl.Builder $this$commonNoTransform) {
        Intrinsics.checkNotNullParameter($this$commonNoTransform, "<this>");
        $this$commonNoTransform.setNoTransform$okhttp(true);
        return $this$commonNoTransform;
    }

    public static final CacheControl.Builder commonImmutable(CacheControl.Builder $this$commonImmutable) {
        Intrinsics.checkNotNullParameter($this$commonImmutable, "<this>");
        $this$commonImmutable.setImmutable$okhttp(true);
        return $this$commonImmutable;
    }

    public static final CacheControl commonParse(CacheControl.Companion $this$commonParse, Headers headers) {
        String headerValue;
        String parameter;
        Intrinsics.checkNotNullParameter($this$commonParse, "<this>");
        Intrinsics.checkNotNullParameter(headers, "headers");
        boolean canUseHeaderValue = true;
        String headerValue2 = null;
        int size = headers.size();
        boolean noStore = false;
        int maxAgeSeconds = -1;
        int sMaxAgeSeconds = -1;
        boolean isPrivate = false;
        boolean isPublic = false;
        boolean mustRevalidate = false;
        int maxStaleSeconds = -1;
        int minFreshSeconds = -1;
        boolean onlyIfCached = false;
        boolean noTransform = false;
        boolean immutable = false;
        boolean noCache = false;
        for (int i = 0; i < size; i++) {
            String name = headers.name(i);
            String value = headers.value(i);
            if (StringsKt.equals(name, "Cache-Control", true)) {
                if (headerValue2 != null) {
                    canUseHeaderValue = false;
                } else {
                    headerValue2 = value;
                }
            } else {
                if (StringsKt.equals(name, "Pragma", true)) {
                    canUseHeaderValue = false;
                }
            }
            int pos = 0;
            while (pos < value.length()) {
                int tokenStart = pos;
                int pos2 = indexOfElement(value, "=,;", pos);
                String strSubstring = value.substring(tokenStart, pos2);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                String directive = StringsKt.trim((CharSequence) strSubstring).toString();
                if (pos2 == value.length() || value.charAt(pos2) == ',' || value.charAt(pos2) == ';') {
                    pos = pos2 + 1;
                    parameter = null;
                } else {
                    int pos3 = _UtilCommonKt.indexOfNonWhitespace(value, pos2 + 1);
                    if (pos3 < value.length() && value.charAt(pos3) == '\"') {
                        int pos4 = pos3 + 1;
                        int pos5 = StringsKt.indexOf$default((CharSequence) value, '\"', pos4, false, 4, (Object) null);
                        parameter = value.substring(pos4, pos5);
                        Intrinsics.checkNotNullExpressionValue(parameter, "substring(...)");
                        pos = pos5 + 1;
                    } else {
                        pos = indexOfElement(value, ",;", pos3);
                        String strSubstring2 = value.substring(pos3, pos);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                        parameter = StringsKt.trim((CharSequence) strSubstring2).toString();
                    }
                }
                if (StringsKt.equals("no-cache", directive, true)) {
                    noCache = true;
                } else if (StringsKt.equals("no-store", directive, true)) {
                    noStore = true;
                } else if (StringsKt.equals("max-age", directive, true)) {
                    maxAgeSeconds = _UtilCommonKt.toNonNegativeInt(parameter, -1);
                } else if (StringsKt.equals("s-maxage", directive, true)) {
                    sMaxAgeSeconds = _UtilCommonKt.toNonNegativeInt(parameter, -1);
                } else if (StringsKt.equals("private", directive, true)) {
                    isPrivate = true;
                } else if (StringsKt.equals("public", directive, true)) {
                    isPublic = true;
                } else if (StringsKt.equals("must-revalidate", directive, true)) {
                    mustRevalidate = true;
                } else if (StringsKt.equals("max-stale", directive, true)) {
                    maxStaleSeconds = _UtilCommonKt.toNonNegativeInt(parameter, IntCompanionObject.MAX_VALUE);
                } else if (StringsKt.equals("min-fresh", directive, true)) {
                    minFreshSeconds = _UtilCommonKt.toNonNegativeInt(parameter, -1);
                } else if (StringsKt.equals("only-if-cached", directive, true)) {
                    onlyIfCached = true;
                } else if (StringsKt.equals("no-transform", directive, true)) {
                    noTransform = true;
                } else if (StringsKt.equals("immutable", directive, true)) {
                    immutable = true;
                }
            }
        }
        if (canUseHeaderValue) {
            headerValue = headerValue2;
        } else {
            headerValue = null;
        }
        return new CacheControl(noCache, noStore, maxAgeSeconds, sMaxAgeSeconds, isPrivate, isPublic, mustRevalidate, maxStaleSeconds, minFreshSeconds, onlyIfCached, noTransform, immutable, headerValue);
    }

    static  int indexOfElement$default(String str, String str2, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return indexOfElement(str, str2, i);
    }

    private static final int indexOfElement(String $this$indexOfElement, String characters, int startIndex) {
        int length = $this$indexOfElement.length();
        for (int i = startIndex; i < length; i++) {
            if (StringsKt.contains$default((CharSequence) characters, $this$indexOfElement.charAt(i), false, 2, (Object) null)) {
                return i;
            }
        }
        int i2 = $this$indexOfElement.length();
        return i2;
    }
}
