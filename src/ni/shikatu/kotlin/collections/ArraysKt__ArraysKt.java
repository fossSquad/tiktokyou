package ni.shikatu.kotlin.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.UByteArray;
import ni.shikatu.kotlin.UIntArray;
import ni.shikatu.kotlin.ULongArray;
import ni.shikatu.kotlin.UShortArray;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.unsigned.UArraysKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00030\u0003H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0004\u001aK\u0010\u0005\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00070\u00010\u0006\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0007*\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00070\u00060\u0003H\u0086\u0080\u0004¢\u0006\u0002\u0010\b\u001a<\u0010\t\u001a\u00020\n*\b\u0012\u0002\b\u0003\u0018\u00010\u0003H\u0087\u0088\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000eb\u0002\b\u000f\u0082\u0002\u000e\n\f\b\u0000\u0012\u0002\u0018\u0001\u001a\u0004\b\u0003\u0010\u0000¢\u0006\u0002\u0010\u000b\u001a[\u0010\u0010\u001a\u0002H\u0007\"\u0010\b\u0000\u0010\u0011*\u0006\u0012\u0002\b\u00030\u0003*\u0002H\u0007\"\u0004\b\u0001\u0010\u0007*\u0002H\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0013H\u0087\u0088\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000eb\u0002\b\u000fø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\u0014\u001aW\u0010\u0015\u001a\u00020\n\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u00032\u0010\u0010\u0016\u001a\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0081\u0080\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000eb\u0002\b\u0019b\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u0017¢\u0006\u0004\b\u0017\u0010\u0018\u001aE\u0010\u001c\u001a\u00020\u001d\"\u0004\b\u0000\u0010\u0002*\f\u0012\u0006\b\u0001\u0012\u0002H\u0002\u0018\u00010\u0003H\u0081\u0080\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000eb\u0002\b\u0019b\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001e¢\u0006\u0004\b\u001e\u0010\u001f\u001aA\u0010 \u001a\u00020!\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u00032\n\u0010\"\u001a\u00060#j\u0002`$2\u0010\u0010%\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030&H\u0082\u0080\u0004¢\u0006\u0004\b'\u0010(\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006)"}, d2 = {"flatten", _UrlKt.FRAGMENT_ENCODE_SET, "T", _UrlKt.FRAGMENT_ENCODE_SET, "([[Ljava/lang/Object;)Ljava/util/List;", "unzip", "Lni/shikatu/kotlin/Pair;", "R", "([Lkotlin/Pair;)Lkotlin/Pair;", "isNullOrEmpty", _UrlKt.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Z", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "Lni/shikatu/kotlin/internal/InlineOnly;", "ifEmpty", "C", "defaultValue", "Lni/shikatu/kotlin/Function0;", "([Ljava/lang/Object;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "contentDeepEqualsImpl", "other", "contentDeepEquals", "([Ljava/lang/Object;[Ljava/lang/Object;)Z", "Lni/shikatu/kotlin/PublishedApi;", "Lni/shikatu/kotlin/jvm/JvmName;", "name", "contentDeepToStringImpl", _UrlKt.FRAGMENT_ENCODE_SET, "contentDeepToString", "([Ljava/lang/Object;)Ljava/lang/String;", "contentDeepToStringInternal", _UrlKt.FRAGMENT_ENCODE_SET, "result", "Ljava/lang/StringBuilder;", "Lni/shikatu/kotlin/text/StringBuilder;", "processed", _UrlKt.FRAGMENT_ENCODE_SET, "contentDeepToStringInternal$ArraysKt__ArraysKt", "([Ljava/lang/Object;Ljava/lang/StringBuilder;Ljava/util/List;)V", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/collections/ArraysKt")
class ArraysKt__ArraysKt extends ArraysKt__ArraysJVMKt {
    public static final <T> List<T> flatten(T[][] tArr) {
        Intrinsics.checkNotNullParameter(tArr, "<this>");
        long totalSizeLong = 0;
        for (Object[] it : tArr) {
            totalSizeLong += (long) it.length;
        }
        if (totalSizeLong == 0) {
            return CollectionsKt.emptyList();
        }
        if (!(totalSizeLong <= 2147483647L)) {
            throw new IllegalArgumentException(("Sum of all arrays lengths (" + totalSizeLong + ") exceeds maximum list size (2147483647)").toString());
        }
        Object[] outputArray = new Object[(int) totalSizeLong];
        int offset = 0;
        for (T[] tArr2 : tArr) {
            ArraysKt.copyInto$default(tArr2, outputArray, offset, 0, 0, 12, (Object) null);
            offset += tArr2.length;
        }
        List<T> listAsList = (List<T>) (List) ArraysKt.asList(outputArray);
        Intrinsics.checkNotNull(listAsList, "null cannot be cast to non-null type kotlin.collections.List<T of kotlin.collections.ArraysKt__ArraysKt.flatten>");
        return listAsList;
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Pair<? extends T, ? extends R>[] pairArr) {
        Intrinsics.checkNotNullParameter(pairArr, "<this>");
        ArrayList listT = new ArrayList(pairArr.length);
        ArrayList listR = new ArrayList(pairArr.length);
        for (Pair<? extends T, ? extends R> pair : pairArr) {
            listT.add(pair.getFirst());
            listR.add(pair.getSecond());
        }
        return TuplesKt.to(listT, listR);
    }

    private static final boolean isNullOrEmpty(Object[] $this$isNullOrEmpty) {
        if ($this$isNullOrEmpty != null) {
            return $this$isNullOrEmpty.length == 0;
        }
        return true;
    }

    private static final Object ifEmpty(Object[] $this$ifEmpty, Function0 defaultValue) {
        Intrinsics.checkNotNullParameter(defaultValue, "defaultValue");
        return $this$ifEmpty.length == 0 ? defaultValue.invoke() : $this$ifEmpty;
    }

    public static final <T> boolean contentDeepEquals(T[] tArr, T[] tArr2) {
        if (tArr == tArr2) {
            return true;
        }
        if (tArr == null || tArr2 == null || tArr.length != tArr2.length) {
            return false;
        }
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            Object objArr = tArr[i];
            Object objArr2 = tArr2[i];
            if (objArr != objArr2) {
                if (objArr == null || objArr2 == null) {
                    return false;
                }
                if ((objArr instanceof Object[]) && (objArr2 instanceof Object[])) {
                    if (!ArraysKt.contentDeepEquals((Object[]) objArr, (Object[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof byte[]) && (objArr2 instanceof byte[])) {
                    if (!Arrays.equals((byte[]) objArr, (byte[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof short[]) && (objArr2 instanceof short[])) {
                    if (!Arrays.equals((short[]) objArr, (short[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof int[]) && (objArr2 instanceof int[])) {
                    if (!Arrays.equals((int[]) objArr, (int[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof long[]) && (objArr2 instanceof long[])) {
                    if (!Arrays.equals((long[]) objArr, (long[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof float[]) && (objArr2 instanceof float[])) {
                    if (!Arrays.equals((float[]) objArr, (float[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof double[]) && (objArr2 instanceof double[])) {
                    if (!Arrays.equals((double[]) objArr, (double[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof char[]) && (objArr2 instanceof char[])) {
                    if (!Arrays.equals((char[]) objArr, (char[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof boolean[]) && (objArr2 instanceof boolean[])) {
                    if (!Arrays.equals((boolean[]) objArr, (boolean[]) objArr2)) {
                        return false;
                    }
                } else if ((objArr instanceof UByteArray) && (objArr2 instanceof UByteArray)) {
                    if (!UArraysKt.m579contentEqualskV0jMPg(((UByteArray) objArr).m91unboximpl(), ((UByteArray) objArr2).m91unboximpl())) {
                        return false;
                    }
                } else if ((objArr instanceof UShortArray) && (objArr2 instanceof UShortArray)) {
                    if (!UArraysKt.m577contentEqualsFGO6Aew(((UShortArray) objArr).m354unboximpl(), ((UShortArray) objArr2).m354unboximpl())) {
                        return false;
                    }
                } else if ((objArr instanceof UIntArray) && (objArr2 instanceof UIntArray)) {
                    if (!UArraysKt.m578contentEqualsKJPZfPQ(((UIntArray) objArr).m170unboximpl(), ((UIntArray) objArr2).m170unboximpl())) {
                        return false;
                    }
                } else if ((objArr instanceof ULongArray) && (objArr2 instanceof ULongArray)) {
                    if (!UArraysKt.m580contentEqualslec5QzE(((ULongArray) objArr).m249unboximpl(), ((ULongArray) objArr2).m249unboximpl())) {
                        return false;
                    }
                } else if (!Intrinsics.areEqual(objArr, objArr2)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static final <T> String contentDeepToString(T[] tArr) {
        if (tArr == null) {
            return AbstractJsonLexerKt.NULL;
        }
        int length = (RangesKt.coerceAtMost(tArr.length, 429496729) * 5) + 2;
        StringBuilder $this$contentDeepToStringImpl_u24lambda_u240 = new StringBuilder(length);
        contentDeepToStringInternal$ArraysKt__ArraysKt(tArr, $this$contentDeepToStringImpl_u24lambda_u240, new ArrayList());
        return $this$contentDeepToStringImpl_u24lambda_u240.toString();
    }

    private static final <T> void contentDeepToStringInternal$ArraysKt__ArraysKt(T[] tArr, StringBuilder sb, List<Object[]> list) {
        if (list.contains(tArr)) {
            sb.append("[...]");
            return;
        }
        list.add(tArr);
        sb.append(AbstractJsonLexerKt.BEGIN_LIST);
        int length = tArr.length;
        for (int i = 0; i < length; i++) {
            if (i != 0) {
                sb.append(", ");
            }
            Object objArr = tArr[i];
            if (objArr == null) {
                sb.append(AbstractJsonLexerKt.NULL);
            } else if (objArr instanceof Object[]) {
                contentDeepToStringInternal$ArraysKt__ArraysKt((Object[]) objArr, sb, list);
                Unit unit = Unit.INSTANCE;
            } else if (objArr instanceof byte[]) {
                String string = Arrays.toString((byte[]) objArr);
                Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                sb.append(string);
            } else if (objArr instanceof short[]) {
                String string2 = Arrays.toString((short[]) objArr);
                Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                sb.append(string2);
            } else if (objArr instanceof int[]) {
                String string3 = Arrays.toString((int[]) objArr);
                Intrinsics.checkNotNullExpressionValue(string3, "toString(...)");
                sb.append(string3);
            } else if (objArr instanceof long[]) {
                String string4 = Arrays.toString((long[]) objArr);
                Intrinsics.checkNotNullExpressionValue(string4, "toString(...)");
                sb.append(string4);
            } else if (objArr instanceof float[]) {
                String string5 = Arrays.toString((float[]) objArr);
                Intrinsics.checkNotNullExpressionValue(string5, "toString(...)");
                sb.append(string5);
            } else if (objArr instanceof double[]) {
                String string6 = Arrays.toString((double[]) objArr);
                Intrinsics.checkNotNullExpressionValue(string6, "toString(...)");
                sb.append(string6);
            } else if (objArr instanceof char[]) {
                String string7 = Arrays.toString((char[]) objArr);
                Intrinsics.checkNotNullExpressionValue(string7, "toString(...)");
                sb.append(string7);
            } else if (objArr instanceof boolean[]) {
                String string8 = Arrays.toString((boolean[]) objArr);
                Intrinsics.checkNotNullExpressionValue(string8, "toString(...)");
                sb.append(string8);
            } else if (objArr instanceof UByteArray) {
                UByteArray uByteArray = (UByteArray) objArr;
                sb.append(UArraysKt.m585contentToString2csIQuQ(uByteArray != null ? uByteArray.m91unboximpl() : null));
            } else if (objArr instanceof UShortArray) {
                UShortArray uShortArray = (UShortArray) objArr;
                sb.append(UArraysKt.m587contentToStringd6D3K8(uShortArray != null ? uShortArray.m354unboximpl() : null));
            } else if (objArr instanceof UIntArray) {
                UIntArray uIntArray = (UIntArray) objArr;
                sb.append(UArraysKt.m586contentToStringXUkPCBk(uIntArray != null ? uIntArray.m170unboximpl() : null));
            } else if (objArr instanceof ULongArray) {
                ULongArray uLongArray = (ULongArray) objArr;
                sb.append(UArraysKt.m588contentToStringuLth9ew(uLongArray != null ? uLongArray.m249unboximpl() : null));
            } else {
                sb.append(objArr.toString());
            }
        }
        sb.append(AbstractJsonLexerKt.END_LIST);
        list.remove(CollectionsKt.getLastIndex(list));
    }
}
