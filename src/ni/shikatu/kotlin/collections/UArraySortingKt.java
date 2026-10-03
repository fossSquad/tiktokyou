package ni.shikatu.kotlin.collections;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UByte;
import ni.shikatu.kotlin.UByteArray;
import ni.shikatu.kotlin.UIntArray;
import ni.shikatu.kotlin.ULongArray;
import ni.shikatu.kotlin.UShort;
import ni.shikatu.kotlin.UShortArray;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u0006\u0010\u0007\u001a-\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u000b\u0010\f\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u000e\u0010\u000f\u001a-\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u0010\u0010\u0011\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u0013\u0010\u0014\u001a-\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00122\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u0015\u0010\u0016\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u0018\u0010\u0019\u001a-\u0010\t\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00172\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0083\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u001a\u0010\u001b\u001a-\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0081\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\u001f\u0010\f\u001a-\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0081\u0080\u0004b\u0002\b\b¢\u0006\u0004\b \u0010\u0011\u001a-\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0081\u0080\u0004b\u0002\b\b¢\u0006\u0004\b!\u0010\u0016\u001a-\u0010\u001c\u001a\u00020\n2\u0006\u0010\u0002\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u0001H\u0081\u0080\u0004b\u0002\b\b¢\u0006\u0004\b\"\u0010\u001b¨\u0006#"}, d2 = {"partition", _UrlKt.FRAGMENT_ENCODE_SET, "array", "Lni/shikatu/kotlin/UByteArray;", "left", "right", "partition-4UcCI2c", "([BII)I", "Lni/shikatu/kotlin/ExperimentalUnsignedTypes;", "quickSort", _UrlKt.FRAGMENT_ENCODE_SET, "quickSort-4UcCI2c", "([BII)V", "Lni/shikatu/kotlin/UShortArray;", "partition-Aa5vz7o", "([SII)I", "quickSort-Aa5vz7o", "([SII)V", "Lni/shikatu/kotlin/UIntArray;", "partition-oBK06Vg", "([III)I", "quickSort-oBK06Vg", "([III)V", "Lni/shikatu/kotlin/ULongArray;", "partition--nroSd4", "([JII)I", "quickSort--nroSd4", "([JII)V", "sortArray", "fromIndex", "toIndex", "sortArray-4UcCI2c", "sortArray-Aa5vz7o", "sortArray-oBK06Vg", "sortArray--nroSd4", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class UArraySortingKt {

    private static final int m464partition4UcCI2c(byte[] array, int left, int right) {
        int i = left;
        int j = right;
        byte pivot = UByteArray.m82getw2LRezQ(array, (left + right) / 2);
        while (i <= j) {
            while (Intrinsics.compare(UByteArray.m82getw2LRezQ(array, i) & UByte.MAX_VALUE, pivot & UByte.MAX_VALUE) < 0) {
                i++;
            }
            while (Intrinsics.compare(UByteArray.m82getw2LRezQ(array, j) & UByte.MAX_VALUE, pivot & UByte.MAX_VALUE) > 0) {
                j--;
            }
            if (i <= j) {
                byte tmp = UByteArray.m82getw2LRezQ(array, i);
                UByteArray.m87setVurrAj0(array, i, UByteArray.m82getw2LRezQ(array, j));
                UByteArray.m87setVurrAj0(array, j, tmp);
                i++;
                j--;
            }
        }
        return i;
    }

    private static final void m468quickSort4UcCI2c(byte[] array, int left, int right) {
        int index = m464partition4UcCI2c(array, left, right);
        if (left < index - 1) {
            m468quickSort4UcCI2c(array, left, index - 1);
        }
        if (index < right) {
            m468quickSort4UcCI2c(array, index, right);
        }
    }

    private static final int m465partitionAa5vz7o(short[] array, int left, int right) {
        int i = left;
        int j = right;
        short pivot = UShortArray.m345getMh2AYeg(array, (left + right) / 2);
        while (i <= j) {
            while (Intrinsics.compare(UShortArray.m345getMh2AYeg(array, i) & UShort.MAX_VALUE, pivot & UShort.MAX_VALUE) < 0) {
                i++;
            }
            while (Intrinsics.compare(UShortArray.m345getMh2AYeg(array, j) & UShort.MAX_VALUE, pivot & UShort.MAX_VALUE) > 0) {
                j--;
            }
            if (i <= j) {
                short tmp = UShortArray.m345getMh2AYeg(array, i);
                UShortArray.m350set01HTLdE(array, i, UShortArray.m345getMh2AYeg(array, j));
                UShortArray.m350set01HTLdE(array, j, tmp);
                i++;
                j--;
            }
        }
        return i;
    }

    private static final void m469quickSortAa5vz7o(short[] array, int left, int right) {
        int index = m465partitionAa5vz7o(array, left, right);
        if (left < index - 1) {
            m469quickSortAa5vz7o(array, left, index - 1);
        }
        if (index < right) {
            m469quickSortAa5vz7o(array, index, right);
        }
    }

    private static final int m466partitionoBK06Vg(int[] array, int left, int right) {
        int i = left;
        int j = right;
        int pivot = UIntArray.m161getpVg5ArA(array, (left + right) / 2);
        while (i <= j) {
            while (Integer.compareUnsigned(UIntArray.m161getpVg5ArA(array, i), pivot) < 0) {
                i++;
            }
            while (Integer.compareUnsigned(UIntArray.m161getpVg5ArA(array, j), pivot) > 0) {
                j--;
            }
            if (i <= j) {
                int tmp = UIntArray.m161getpVg5ArA(array, i);
                UIntArray.m166setVXSXFK8(array, i, UIntArray.m161getpVg5ArA(array, j));
                UIntArray.m166setVXSXFK8(array, j, tmp);
                i++;
                j--;
            }
        }
        return i;
    }

    private static final void m470quickSortoBK06Vg(int[] array, int left, int right) {
        int index = m466partitionoBK06Vg(array, left, right);
        if (left < index - 1) {
            m470quickSortoBK06Vg(array, left, index - 1);
        }
        if (index < right) {
            m470quickSortoBK06Vg(array, index, right);
        }
    }

    private static final int m463partitionnroSd4(long[] array, int left, int right) {
        int i = left;
        int j = right;
        long pivot = ULongArray.m240getsVKNKU(array, (left + right) / 2);
        while (i <= j) {
            while (Long.compareUnsigned(ULongArray.m240getsVKNKU(array, i), pivot) < 0) {
                i++;
            }
            while (Long.compareUnsigned(ULongArray.m240getsVKNKU(array, j), pivot) > 0) {
                j--;
            }
            if (i <= j) {
                long tmp = ULongArray.m240getsVKNKU(array, i);
                ULongArray.m245setk8EXiF4(array, i, ULongArray.m240getsVKNKU(array, j));
                ULongArray.m245setk8EXiF4(array, j, tmp);
                i++;
                j--;
            }
        }
        return i;
    }

    private static final void m467quickSortnroSd4(long[] array, int left, int right) {
        int index = m463partitionnroSd4(array, left, right);
        if (left < index - 1) {
            m467quickSortnroSd4(array, left, index - 1);
        }
        if (index < right) {
            m467quickSortnroSd4(array, index, right);
        }
    }

    public static final void m472sortArray4UcCI2c(byte[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        m468quickSort4UcCI2c(array, fromIndex, toIndex - 1);
    }

    public static final void m473sortArrayAa5vz7o(short[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        m469quickSortAa5vz7o(array, fromIndex, toIndex - 1);
    }

    public static final void m474sortArrayoBK06Vg(int[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        m470quickSortoBK06Vg(array, fromIndex, toIndex - 1);
    }

    public static final void m471sortArraynroSd4(long[] array, int fromIndex, int toIndex) {
        Intrinsics.checkNotNullParameter(array, "array");
        m467quickSortnroSd4(array, fromIndex, toIndex - 1);
    }
}
