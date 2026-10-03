package ni.shikatu.okhttp3;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.internal.ProgressionUtilKt;
import ni.shikatu.kotlin.jvm.JvmStatic;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.MatchGroup;
import ni.shikatu.kotlin.text.MatchResult;
import ni.shikatu.kotlin.text.Regex;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB/\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007¢\u0006\u0004\b\b\u0010\tJ\u0016\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0007J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0011\u001a\u00020\u0003J\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0012J\r\u0010\u0005\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0013J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0018\u001a\u00020\u0019H\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u0013\u0010\u0005\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u000bR\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\f¨\u0006\u001b"}, d2 = {"Lni/shikatu/okhttp3/MediaType;", _UrlKt.FRAGMENT_ENCODE_SET, "mediaType", _UrlKt.FRAGMENT_ENCODE_SET, "type", "subtype", "parameterNamesAndValues", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)V", "getMediaType$okhttp", "()Ljava/lang/String;", "[Ljava/lang/String;", "charset", "Ljava/nio/charset/Charset;", "defaultValue", "parameter", "name", "-deprecated_type", "-deprecated_subtype", "toString", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MediaType {
    private static final String QUOTED = "\"([^\"]*)\"";
    private static final String TOKEN = "([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)";
    private final String mediaType;
    private final String[] parameterNamesAndValues;
    private final String subtype;
    private final String type;
    public static final Companion Companion = new Companion(null);
    private static final Regex TYPE_SUBTYPE = new Regex("([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)/([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)");
    private static final Regex PARAMETER = new Regex(";\\s*(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)=(?:([a-zA-Z0-9-!#$%&'*+.^_`{|}~]+)|\"([^\"]*)\"))?");

    public final Charset charset() {
        return charset$default(this, null, 1, null);
    }

    public MediaType(String mediaType, String type, String subtype, String[] parameterNamesAndValues) {
        Intrinsics.checkNotNullParameter(mediaType, "mediaType");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(subtype, "subtype");
        Intrinsics.checkNotNullParameter(parameterNamesAndValues, "parameterNamesAndValues");
        this.mediaType = mediaType;
        this.type = type;
        this.subtype = subtype;
        this.parameterNamesAndValues = parameterNamesAndValues;
    }

    public final String getMediaType$okhttp() {
        return this.mediaType;
    }

    public final String type() {
        return this.type;
    }

    public final String subtype() {
        return this.subtype;
    }

    public static  Charset charset$default(MediaType mediaType, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = null;
        }
        return mediaType.charset(charset);
    }

    public final Charset charset(Charset defaultValue) {
        String charset = parameter("charset");
        if (charset == null) {
            return defaultValue;
        }
        try {
            return Charset.forName(charset);
        } catch (IllegalArgumentException e) {
            return defaultValue;
        }
    }

    public final String parameter(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        int i = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, this.parameterNamesAndValues.length - 1, 2);
        if (0 <= progressionLastElement) {
            while (!StringsKt.equals(this.parameterNamesAndValues[i], name, true)) {
                if (i == progressionLastElement) {
                    return null;
                }
                i += 2;
            }
            return this.parameterNamesAndValues[i + 1];
        }
        return null;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "type", imports = {}))

    public final String m1669deprecated_type() {
        return this.type;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "subtype", imports = {}))

    public final String m1668deprecated_subtype() {
        return this.subtype;
    }

    public String toString() {
        return this.mediaType;
    }

    public boolean equals(Object other) {
        return (other instanceof MediaType) && Intrinsics.areEqual(((MediaType) other).mediaType, this.mediaType);
    }

    public int hashCode() {
        return this.mediaType.hashCode();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\n\u001a\u00020\u000b*\u00020\u0005H\u0007¢\u0006\u0002\b\fJ\u0013\u0010\r\u001a\u0004\u0018\u00010\u000b*\u00020\u0005H\u0007¢\u0006\u0002\b\u000eJ\u0015\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u0010J\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u000f\u001a\u00020\u0005H\u0007¢\u0006\u0002\b\u0011R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lni/shikatu/okhttp3/MediaType$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "TOKEN", _UrlKt.FRAGMENT_ENCODE_SET, "QUOTED", "TYPE_SUBTYPE", "Lni/shikatu/kotlin/text/Regex;", "PARAMETER", "toMediaType", "Lni/shikatu/okhttp3/MediaType;", "get", "toMediaTypeOrNull", "parse", "mediaType", "-deprecated_get", "-deprecated_parse", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final MediaType get(String $this$toMediaType) {
            String value;
            Intrinsics.checkNotNullParameter($this$toMediaType, "<this>");
            MatchResult typeSubtype = MediaType.TYPE_SUBTYPE.matchAt($this$toMediaType, 0);
            if (typeSubtype == null) {
                throw new IllegalArgumentException("No subtype found for: \"" + $this$toMediaType + '\"');
            }
            String type = typeSubtype.getGroupValues().get(1).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(type, "toLowerCase(...)");
            String subtype = typeSubtype.getGroupValues().get(2).toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(subtype, "toLowerCase(...)");
            Collection parameterNamesAndValues = (List) new ArrayList();
            int s = typeSubtype.getRange().getLast() + 1;
            while (s < s) {
                MatchResult parameter = MediaType.PARAMETER.matchAt($this$toMediaType, s);
                if (!(parameter != null)) {
                    StringBuilder sbAppend = new StringBuilder().append("Parameter is not formatted correctly: \"");
                    String strSubstring = $this$toMediaType.substring(s);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    throw new IllegalArgumentException(sbAppend.append(strSubstring).append("\" for: \"").append($this$toMediaType).append('\"').toString().toString());
                }
                MatchGroup matchGroup = parameter.getGroups().get(1);
                String name = matchGroup != null ? matchGroup.getValue() : null;
                if (name == null) {
                    s = parameter.getRange().getLast() + 1;
                } else {
                    MatchGroup matchGroup2 = parameter.getGroups().get(2);
                    String token = matchGroup2 != null ? matchGroup2.getValue() : null;
                    if (token == null) {
                        MatchGroup matchGroup3 = parameter.getGroups().get(3);
                        Intrinsics.checkNotNull(matchGroup3);
                        value = matchGroup3.getValue();
                    } else if (StringsKt.startsWith$default((CharSequence) token, '\'', false, 2, (Object) null) && StringsKt.endsWith$default((CharSequence) token, '\'', false, 2, (Object) null) && token.length() > 2) {
                        String strSubstring2 = token.substring(1, token.length() - 1);
                        Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                        value = strSubstring2;
                    } else {
                        value = token;
                    }
                    parameterNamesAndValues.add(name);
                    parameterNamesAndValues.add(value);
                    s = parameter.getRange().getLast() + 1;
                }
            }
            Collection $this$toTypedArray$iv = parameterNamesAndValues;
            return new MediaType($this$toMediaType, type, subtype, (String[]) $this$toTypedArray$iv.toArray(new String[0]));
        }

        @JvmStatic
        public final MediaType parse(String $this$toMediaTypeOrNull) {
            Intrinsics.checkNotNullParameter($this$toMediaTypeOrNull, "<this>");
            try {
                return get($this$toMediaTypeOrNull);
            } catch (IllegalArgumentException e) {
                return null;
            }
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "mediaType.toMediaType()", imports = {"ni.shikatu.okhttp3.MediaType.Companion.toMediaType"}))

        public final MediaType m1670deprecated_get(String mediaType) {
            Intrinsics.checkNotNullParameter(mediaType, "mediaType");
            return get(mediaType);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "mediaType.toMediaTypeOrNull()", imports = {"ni.shikatu.okhttp3.MediaType.Companion.toMediaTypeOrNull"}))

        public final MediaType m1671deprecated_parse(String mediaType) {
            Intrinsics.checkNotNullParameter(mediaType, "mediaType");
            return parse(mediaType);
        }
    }

    @JvmStatic
    public static final MediaType get(String $this$get) {
        return Companion.get($this$get);
    }

    @JvmStatic
    public static final MediaType parse(String $this$parse) {
        return Companion.parse($this$parse);
    }
}
