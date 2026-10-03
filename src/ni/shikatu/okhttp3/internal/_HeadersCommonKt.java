package ni.shikatu.okhttp3.internal;
import java.util.Map.Entry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.internal.ProgressionUtilKt;
import ni.shikatu.kotlin.jvm.internal.ArrayIteratorKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.CharsKt;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.Headers;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000X\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010$\n\u0000\u001a\u0014\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0014\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007*\u00020\u00022\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001a\u001e\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010\u000b0\n*\u00020\u0002H\u0000\u001a\f\u0010\f\u001a\u00020\r*\u00020\u0002H\u0000\u001a\u0016\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0000\u001a\f\u0010\u0012\u001a\u00020\u0004*\u00020\u0002H\u0000\u001a\f\u0010\u0013\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a%\u0010\u0014\u001a\u0004\u0018\u00010\u00012\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00162\u0006\u0010\b\u001a\u00020\u0001H\u0000¢\u0006\u0002\u0010\u0017\u001a\u001c\u0010\u0018\u001a\u00020\r*\u00020\r2\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u001a\u001a\u00020\r*\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0002H\u0000\u001a\u001c\u0010\u001c\u001a\u00020\r*\u00020\r2\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0001H\u0000\u001a\u0014\u0010\u001d\u001a\u00020\r*\u00020\r2\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001a\u001c\u0010\u001e\u001a\u00020\r*\u00020\r2\u0006\u0010\b\u001a\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u0001H\u0000\u001a\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u0001*\u00020\r2\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001a\f\u0010 \u001a\u00020\u0002*\u00020\rH\u0000\u001a\u0010\u0010!\u001a\u00020\"2\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001a\u0018\u0010#\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\u0001H\u0000\u001a\f\u0010$\u001a\u00020\u0001*\u00020%H\u0002\u001a!\u0010&\u001a\u00020\u00022\u0012\u0010'\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0016\"\u00020\u0001H\u0000¢\u0006\u0002\u0010(\u001a\u0018\u0010)\u001a\u00020\u0002*\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00010*H\u0000¨\u0006+"}, d2 = {"commonName", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/Headers;", "index", _UrlKt.FRAGMENT_ENCODE_SET, "commonValue", "commonValues", _UrlKt.FRAGMENT_ENCODE_SET, "name", "commonIterator", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/Pair;", "commonNewBuilder", "Lni/shikatu/okhttp3/Headers$Builder;", "commonEquals", _UrlKt.FRAGMENT_ENCODE_SET, "other", _UrlKt.FRAGMENT_ENCODE_SET, "commonHashCode", "commonToString", "commonHeadersGet", "namesAndValues", _UrlKt.FRAGMENT_ENCODE_SET, "([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "commonAdd", "value", "commonAddAll", "headers", "commonAddLenient", "commonRemoveAll", "commonSet", "commonGet", "commonBuild", "headersCheckName", _UrlKt.FRAGMENT_ENCODE_SET, "headersCheckValue", "charCode", _UrlKt.FRAGMENT_ENCODE_SET, "commonHeadersOf", "inputNamesAndValues", "([Ljava/lang/String;)Lokhttp3/Headers;", "commonToHeaders", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class _HeadersCommonKt {
    public static final String commonName(Headers $this$commonName, int index) {
        Intrinsics.checkNotNullParameter($this$commonName, "<this>");
        String str = (String) ArraysKt.getOrNull($this$commonName.getNamesAndValues$okhttp(), index * 2);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("name[" + index + AbstractJsonLexerKt.END_LIST);
    }

    public static final String commonValue(Headers $this$commonValue, int index) {
        Intrinsics.checkNotNullParameter($this$commonValue, "<this>");
        String str = (String) ArraysKt.getOrNull($this$commonValue.getNamesAndValues$okhttp(), (index * 2) + 1);
        if (str != null) {
            return str;
        }
        throw new IndexOutOfBoundsException("value[" + index + AbstractJsonLexerKt.END_LIST);
    }

    public static final List<String> commonValues(Headers $this$commonValues, String name) {
        List<String> listUnmodifiableList;
        Intrinsics.checkNotNullParameter($this$commonValues, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        List result = null;
        int size = $this$commonValues.size();
        for (int i = 0; i < size; i++) {
            if (StringsKt.equals(name, $this$commonValues.name(i), true)) {
                if (result == null) {
                    List result2 = new ArrayList(2);
                    result = result2;
                }
                result.add($this$commonValues.value(i));
            }
        }
        if (result == null) {
            listUnmodifiableList = null;
        } else {
            List $this$unmodifiable$iv = result;
            listUnmodifiableList = Collections.unmodifiableList($this$unmodifiable$iv);
            Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(...)");
        }
        return listUnmodifiableList == null ? CollectionsKt.emptyList() : listUnmodifiableList;
    }

    public static final Iterator<Pair<String, String>> commonIterator(Headers $this$commonIterator) {
        Intrinsics.checkNotNullParameter($this$commonIterator, "<this>");
        int size = $this$commonIterator.size();
        Pair[] pairArr = new Pair[size];
        for (int i = 0; i < size; i++) {
            pairArr[i] = TuplesKt.to($this$commonIterator.name(i), $this$commonIterator.value(i));
        }
        return ArrayIteratorKt.iterator(pairArr);
    }

    public static final Headers.Builder commonNewBuilder(Headers $this$commonNewBuilder) {
        Intrinsics.checkNotNullParameter($this$commonNewBuilder, "<this>");
        Headers.Builder result = new Headers.Builder();
        CollectionsKt.addAll(result.getNamesAndValues$okhttp(), $this$commonNewBuilder.getNamesAndValues$okhttp());
        return result;
    }

    public static final boolean commonEquals(Headers $this$commonEquals, Object other) {
        Intrinsics.checkNotNullParameter($this$commonEquals, "<this>");
        return (other instanceof Headers) && Arrays.equals($this$commonEquals.getNamesAndValues$okhttp(), ((Headers) other).getNamesAndValues$okhttp());
    }

    public static final int commonHashCode(Headers $this$commonHashCode) {
        Intrinsics.checkNotNullParameter($this$commonHashCode, "<this>");
        return Arrays.hashCode($this$commonHashCode.getNamesAndValues$okhttp());
    }

    public static final String commonToString(Headers $this$commonToString) {
        Intrinsics.checkNotNullParameter($this$commonToString, "<this>");
        StringBuilder $this$commonToString_u24lambda_u240 = new StringBuilder();
        int size = $this$commonToString.size();
        for (int i = 0; i < size; i++) {
            String name = $this$commonToString.name(i);
            String value = $this$commonToString.value(i);
            $this$commonToString_u24lambda_u240.append(name);
            $this$commonToString_u24lambda_u240.append(": ");
            $this$commonToString_u24lambda_u240.append(_UtilCommonKt.isSensitiveHeader(name) ? "██" : value);
            $this$commonToString_u24lambda_u240.append("\n");
        }
        return $this$commonToString_u24lambda_u240.toString();
    }

    public static final String commonHeadersGet(String[] namesAndValues, String name) {
        Intrinsics.checkNotNullParameter(namesAndValues, "namesAndValues");
        Intrinsics.checkNotNullParameter(name, "name");
        int length = namesAndValues.length - 2;
        int i = length;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(length, 0, -2);
        if (progressionLastElement <= i) {
            while (!StringsKt.equals(name, namesAndValues[i], true)) {
                if (i == progressionLastElement) {
                    return null;
                }
                i -= 2;
            }
            return namesAndValues[i + 1];
        }
        return null;
    }

    public static final Headers.Builder commonAdd(Headers.Builder $this$commonAdd, String name, String value) {
        Intrinsics.checkNotNullParameter($this$commonAdd, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        headersCheckName(name);
        headersCheckValue(value, name);
        commonAddLenient($this$commonAdd, name, value);
        return $this$commonAdd;
    }

    public static final Headers.Builder commonAddAll(Headers.Builder $this$commonAddAll, Headers headers) {
        Intrinsics.checkNotNullParameter($this$commonAddAll, "<this>");
        Intrinsics.checkNotNullParameter(headers, "headers");
        int size = headers.size();
        for (int i = 0; i < size; i++) {
            commonAddLenient($this$commonAddAll, headers.name(i), headers.value(i));
        }
        return $this$commonAddAll;
    }

    public static final Headers.Builder commonAddLenient(Headers.Builder $this$commonAddLenient, String name, String value) {
        Intrinsics.checkNotNullParameter($this$commonAddLenient, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        $this$commonAddLenient.getNamesAndValues$okhttp().add(name);
        $this$commonAddLenient.getNamesAndValues$okhttp().add(StringsKt.trim((CharSequence) value).toString());
        return $this$commonAddLenient;
    }

    public static final Headers.Builder commonRemoveAll(Headers.Builder $this$commonRemoveAll, String name) {
        Intrinsics.checkNotNullParameter($this$commonRemoveAll, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        int i = 0;
        while (i < $this$commonRemoveAll.getNamesAndValues$okhttp().size()) {
            if (StringsKt.equals(name, $this$commonRemoveAll.getNamesAndValues$okhttp().get(i), true)) {
                $this$commonRemoveAll.getNamesAndValues$okhttp().remove(i);
                $this$commonRemoveAll.getNamesAndValues$okhttp().remove(i);
                i -= 2;
            }
            i += 2;
        }
        return $this$commonRemoveAll;
    }

    public static final Headers.Builder commonSet(Headers.Builder $this$commonSet, String name, String value) {
        Intrinsics.checkNotNullParameter($this$commonSet, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(value, "value");
        headersCheckName(name);
        headersCheckValue(value, name);
        $this$commonSet.removeAll(name);
        commonAddLenient($this$commonSet, name, value);
        return $this$commonSet;
    }

    public static final String commonGet(Headers.Builder $this$commonGet, String name) {
        Intrinsics.checkNotNullParameter($this$commonGet, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        int size = $this$commonGet.getNamesAndValues$okhttp().size() - 2;
        int i = size;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(size, 0, -2);
        if (progressionLastElement <= i) {
            while (!StringsKt.equals(name, $this$commonGet.getNamesAndValues$okhttp().get(i), true)) {
                if (i == progressionLastElement) {
                    return null;
                }
                i -= 2;
            }
            return $this$commonGet.getNamesAndValues$okhttp().get(i + 1);
        }
        return null;
    }

    public static final Headers commonBuild(Headers.Builder $this$commonBuild) {
        Intrinsics.checkNotNullParameter($this$commonBuild, "<this>");
        Collection $this$toTypedArray$iv = $this$commonBuild.getNamesAndValues$okhttp();
        return new Headers((String[]) $this$toTypedArray$iv.toArray(new String[0]));
    }

    public static final void headersCheckName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (!(name.length() > 0)) {
            throw new IllegalArgumentException("name is empty".toString());
        }
        int length = name.length();
        for (int i = 0; i < length; i++) {
            char c = name.charAt(i);
            if (!('!' <= c && c < 127)) {
                throw new IllegalArgumentException(("Unexpected char 0x" + charCode(c) + " at " + i + " in header name: " + name).toString());
            }
        }
    }

    public static final void headersCheckValue(String value, String name) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(name, "name");
        int length = value.length();
        for (int i = 0; i < length; i++) {
            char c = value.charAt(i);
            boolean z = true;
            if (c != '\t') {
                if (!(' ' <= c && c < 127)) {
                    z = false;
                }
            }
            if (!z) {
                throw new IllegalArgumentException(("Unexpected char 0x" + charCode(c) + " at " + i + " in " + name + " value" + (_UtilCommonKt.isSensitiveHeader(name) ? _UrlKt.FRAGMENT_ENCODE_SET : ": " + value)).toString());
            }
        }
    }

    private static final String charCode(char $this$charCode) {
        String it = Integer.toString($this$charCode, CharsKt.checkRadix(16));
        Intrinsics.checkNotNullExpressionValue(it, "toString(...)");
        if (it.length() < 2) {
            return '0' + it;
        }
        return it;
    }

    public static final Headers commonHeadersOf(String... inputNamesAndValues) {
        Intrinsics.checkNotNullParameter(inputNamesAndValues, "inputNamesAndValues");
        if (!(inputNamesAndValues.length % 2 == 0)) {
            throw new IllegalArgumentException("Expected alternating header names and values".toString());
        }
        String[] namesAndValues = (String[]) Arrays.copyOf(inputNamesAndValues, inputNamesAndValues.length);
        int length = namesAndValues.length;
        for (int i = 0; i < length; i++) {
            if (!(namesAndValues[i] != null)) {
                throw new IllegalArgumentException("Headers cannot be null".toString());
            }
            namesAndValues[i] = StringsKt.trim((CharSequence) inputNamesAndValues[i]).toString();
        }
        int i2 = 0;
        int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(0, namesAndValues.length - 1, 2);
        if (0 <= progressionLastElement) {
            while (true) {
                String name = namesAndValues[i2];
                String value = namesAndValues[i2 + 1];
                headersCheckName(name);
                headersCheckValue(value, name);
                if (i2 == progressionLastElement) {
                    break;
                }
                i2 += 2;
            }
        }
        return new Headers(namesAndValues);
    }

    public static final Headers commonToHeaders(Map<String, String> map) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        String[] namesAndValues = new String[map.size() * 2];
        int i = 0;
        for (Map.Entry<String, String> entry : map.entrySet()) {
            String k = entry.getKey();
            String v = entry.getValue();
            String name = StringsKt.trim((CharSequence) k).toString();
            String value = StringsKt.trim((CharSequence) v).toString();
            headersCheckName(name);
            headersCheckValue(value, name);
            namesAndValues[i] = name;
            namesAndValues[i + 1] = value;
            i += 2;
        }
        return new Headers(namesAndValues);
    }
}
