package ni.shikatu.okhttp3;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.jvm.JvmStatic;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.StringCompanionObject;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.internal._HeadersCommonKt;
import ni.shikatu.okhttp3.internal.http.DateFormattingKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u0003\u0018\u0000 *2\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002)*B\u0017\b\u0000\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u00032\u0006\u0010\f\u001a\u00020\u0003H\u0086\u0002J\u0010\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\f\u001a\u00020\u0003J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\u0003H\u0007J\r\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\b\u0014J\u000e\u0010\f\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0012J\u000e\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0012J\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00030\u0018J\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00030\u001a2\u0006\u0010\f\u001a\u00020\u0003J\u0006\u0010\u001b\u001a\u00020\u001cJ\u001b\u0010\u001d\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u00020\u001eH\u0096\u0002J\u0006\u0010\u001f\u001a\u00020 J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010$H\u0096\u0002J\b\u0010%\u001a\u00020\u0012H\u0016J\b\u0010&\u001a\u00020\u0003H\u0016J\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u00020\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u001a0(R\u001c\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0011\u001a\u00020\u00128G¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0013¨\u0006+"}, d2 = {"Lni/shikatu/okhttp3/Headers;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/Pair;", _UrlKt.FRAGMENT_ENCODE_SET, "namesAndValues", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "([Ljava/lang/String;)V", "getNamesAndValues$okhttp", "()[Ljava/lang/String;", "[Ljava/lang/String;", "get", "name", "getDate", "Ljava/util/Date;", "getInstant", "Ljava/time/Instant;", "size", _UrlKt.FRAGMENT_ENCODE_SET, "()I", "-deprecated_size", "index", "value", "names", _UrlKt.FRAGMENT_ENCODE_SET, "values", _UrlKt.FRAGMENT_ENCODE_SET, "byteCount", _UrlKt.FRAGMENT_ENCODE_SET, "iterator", _UrlKt.FRAGMENT_ENCODE_SET, "newBuilder", "Lni/shikatu/okhttp3/Headers$Builder;", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "toString", "toMultimap", _UrlKt.FRAGMENT_ENCODE_SET, "Builder", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Headers implements Iterable<Pair<? extends String, ? extends String>>, KMappedMarker {
    public static final Companion Companion = new Companion(null);
    public static final Headers EMPTY = new Headers(new String[0]);
    private final String[] namesAndValues;

    public Headers(String[] namesAndValues) {
        Intrinsics.checkNotNullParameter(namesAndValues, "namesAndValues");
        this.namesAndValues = namesAndValues;
    }

    public final String[] getNamesAndValues$okhttp() {
        return this.namesAndValues;
    }

    public final String get(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return _HeadersCommonKt.commonHeadersGet(this.namesAndValues, name);
    }

    public final Date getDate(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        String str = get(name);
        if (str != null) {
            return DateFormattingKt.toHttpDateOrNull(str);
        }
        return null;
    }

    public final Instant getInstant(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Date date = getDate(name);
        if (date != null) {
            return date.toInstant();
        }
        return null;
    }

    public final int size() {
        return this.namesAndValues.length / 2;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "size", imports = {}))

    public final int m1642deprecated_size() {
        return size();
    }

    public final String name(int index) {
        return _HeadersCommonKt.commonName(this, index);
    }

    public final String value(int index) {
        return _HeadersCommonKt.commonValue(this, index);
    }

    public final Set<String> names() {
        TreeSet result = new TreeSet(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        int size = size();
        for (int i = 0; i < size; i++) {
            result.add(name(i));
        }
        TreeSet $this$unmodifiable$iv = result;
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet($this$unmodifiable$iv);
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(...)");
        return setUnmodifiableSet;
    }

    public final List<String> values(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return _HeadersCommonKt.commonValues(this, name);
    }

    public final long byteCount() {
        long result = this.namesAndValues.length * 2;
        int length = this.namesAndValues.length;
        for (int i = 0; i < length; i++) {
            result += (long) this.namesAndValues[i].length();
        }
        return result;
    }

    @Override
    public Iterator<Pair<? extends String, ? extends String>> iterator() {
        return _HeadersCommonKt.commonIterator(this);
    }

    public final Builder newBuilder() {
        return _HeadersCommonKt.commonNewBuilder(this);
    }

    public boolean equals(Object other) {
        return _HeadersCommonKt.commonEquals(this, other);
    }

    public int hashCode() {
        return _HeadersCommonKt.commonHashCode(this);
    }

    public String toString() {
        return _HeadersCommonKt.commonToString(this);
    }

    public final Map<String, List<String>> toMultimap() {
        TreeMap result = new TreeMap(StringsKt.getCASE_INSENSITIVE_ORDER(StringCompanionObject.INSTANCE));
        int size = size();
        for (int i = 0; i < size; i++) {
            String strName = name(i);
            Locale locale = Locale.US;
            Intrinsics.checkNotNullExpressionValue(locale, "US");
            String name = strName.toLowerCase(locale);
            Intrinsics.checkNotNullExpressionValue(name, "toLowerCase(...)");
            List values = (List) result.get(name);
            if (values == null) {
                values = new ArrayList(2);
                result.put(name, values);
            }
            values.add(value(i));
        }
        return result;
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0015\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0006J\u0016\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006J\u0016\u0010\u000f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0011\u001a\u00020\u0012J\u0016\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0013J\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0014H\u0007J\u0019\u0010\u0015\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0013H\u0086\u0002J\u0019\u0010\u0015\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0014H\u0087\u0002J\u001d\u0010\t\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0000¢\u0006\u0002\b\u000bJ\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0006J\u0019\u0010\u0015\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0006H\u0086\u0002J\u0013\u0010\u0017\u001a\u0004\u0018\u00010\u00062\u0006\u0010\r\u001a\u00020\u0006H\u0086\u0002J\u0006\u0010\u0018\u001a\u00020\u0012R\u001a\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0019"}, d2 = {"Lni/shikatu/okhttp3/Headers$Builder;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "namesAndValues", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "getNamesAndValues$okhttp", "()Ljava/util/List;", "addLenient", "line", "addLenient$okhttp", "add", "name", "value", "addUnsafeNonAscii", "addAll", "headers", "Lni/shikatu/okhttp3/Headers;", "Ljava/util/Date;", "Ljava/time/Instant;", "set", "removeAll", "get", "build", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        private final List<String> namesAndValues = new ArrayList(20);

        public final List<String> getNamesAndValues$okhttp() {
            return this.namesAndValues;
        }

        public final Builder addLenient$okhttp(String line) {
            Intrinsics.checkNotNullParameter(line, "line");
            Builder $this$addLenient_u24lambda_u240 = this;
            int index = StringsKt.indexOf$default((CharSequence) line, AbstractJsonLexerKt.COLON, 1, false, 4, (Object) null);
            if (index != -1) {
                String strSubstring = line.substring(0, index);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                String strSubstring2 = line.substring(index + 1);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                $this$addLenient_u24lambda_u240.addLenient$okhttp(strSubstring, strSubstring2);
            } else if (line.charAt(0) == ':') {
                String strSubstring3 = line.substring(1);
                Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                $this$addLenient_u24lambda_u240.addLenient$okhttp(_UrlKt.FRAGMENT_ENCODE_SET, strSubstring3);
            } else {
                $this$addLenient_u24lambda_u240.addLenient$okhttp(_UrlKt.FRAGMENT_ENCODE_SET, line);
            }
            return this;
        }

        public final Builder add(String line) {
            Intrinsics.checkNotNullParameter(line, "line");
            Builder $this$add_u24lambda_u240 = this;
            int index = StringsKt.indexOf$default((CharSequence) line, AbstractJsonLexerKt.COLON, 0, false, 6, (Object) null);
            if (!(index != -1)) {
                throw new IllegalArgumentException(("Unexpected header: " + line).toString());
            }
            String strSubstring = line.substring(0, index);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            String string = StringsKt.trim((CharSequence) strSubstring).toString();
            String strSubstring2 = line.substring(index + 1);
            Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
            $this$add_u24lambda_u240.add(string, strSubstring2);
            return this;
        }

        public final Builder add(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            return _HeadersCommonKt.commonAdd(this, name, value);
        }

        public final Builder addUnsafeNonAscii(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Builder $this$addUnsafeNonAscii_u24lambda_u240 = this;
            _HeadersCommonKt.headersCheckName(name);
            $this$addUnsafeNonAscii_u24lambda_u240.addLenient$okhttp(name, value);
            return this;
        }

        public final Builder addAll(Headers headers) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            return _HeadersCommonKt.commonAddAll(this, headers);
        }

        public final Builder add(String name, Date value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            return add(name, DateFormattingKt.toHttpDateString(value));
        }

        public final Builder add(String name, Instant value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Date dateFrom = Date.from(value);
            Intrinsics.checkNotNullExpressionValue(dateFrom, "from(...)");
            return add(name, dateFrom);
        }

        public final Builder set(String name, Date value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            return set(name, DateFormattingKt.toHttpDateString(value));
        }

        public final Builder set(String name, Instant value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            Date dateFrom = Date.from(value);
            Intrinsics.checkNotNullExpressionValue(dateFrom, "from(...)");
            return set(name, dateFrom);
        }

        public final Builder addLenient$okhttp(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            return _HeadersCommonKt.commonAddLenient(this, name, value);
        }

        public final Builder removeAll(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return _HeadersCommonKt.commonRemoveAll(this, name);
        }

        public final Builder set(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(value, "value");
            return _HeadersCommonKt.commonSet(this, name, value);
        }

        public final String get(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            return _HeadersCommonKt.commonGet(this, name);
        }

        public final Headers build() {
            return _HeadersCommonKt.commonBuild(this);
        }
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J#\u0010\u0006\u001a\u00020\u00052\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000bJ#\u0010\n\u001a\u00020\u00052\u0012\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\b\"\u00020\tH\u0007¢\u0006\u0004\b\f\u0010\u000bJ\u001d\u0010\r\u001a\u00020\u0005*\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000eH\u0007¢\u0006\u0002\b\nJ!\u0010\n\u001a\u00020\u00052\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u000eH\u0007¢\u0006\u0002\b\fR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lni/shikatu/okhttp3/Headers$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "EMPTY", "Lni/shikatu/okhttp3/Headers;", "headersOf", "namesAndValues", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "of", "([Ljava/lang/String;)Lokhttp3/Headers;", "-deprecated_of", "toHeaders", _UrlKt.FRAGMENT_ENCODE_SET, "headers", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Headers of(String... namesAndValues) {
            Intrinsics.checkNotNullParameter(namesAndValues, "namesAndValues");
            return _HeadersCommonKt.commonHeadersOf((String[]) Arrays.copyOf(namesAndValues, namesAndValues.length));
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "function name changed", replaceWith = @ReplaceWith(expression = "headersOf(*namesAndValues)", imports = {}))

        public final Headers m1644deprecated_of(String... namesAndValues) {
            Intrinsics.checkNotNullParameter(namesAndValues, "namesAndValues");
            return of((String[]) Arrays.copyOf(namesAndValues, namesAndValues.length));
        }

        @JvmStatic
        public final Headers of(Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "<this>");
            return _HeadersCommonKt.commonToHeaders(map);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "function moved to extension", replaceWith = @ReplaceWith(expression = "headers.toHeaders()", imports = {}))

        public final Headers m1643deprecated_of(Map<String, String> map) {
            Intrinsics.checkNotNullParameter(map, "headers");
            return of(map);
        }
    }

    @JvmStatic
    public static final Headers of(String... namesAndValues) {
        return Companion.of(namesAndValues);
    }

    @JvmStatic
    public static final Headers of(Map<String, String> map) {
        return Companion.of(map);
    }
}
