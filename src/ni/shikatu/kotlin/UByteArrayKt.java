package ni.shikatu.kotlin;

import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001aD\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\u0088\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nb\u0002\b\u000bb\u0002\b\fø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a3\u0010\r\u001a\u00020\u00012\n\u0010\u000e\u001a\u00020\u0001\"\u00020\u0006H\u0087\u0088\u0004b\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nb\u0002\b\u000bb\u0002\b\f¢\u0006\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0011"}, d2 = {"UByteArray", "Lni/shikatu/kotlin/UByteArray;", "size", _UrlKt.FRAGMENT_ENCODE_SET, "init", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/UByte;", "(ILkotlin/jvm/functions/Function1;)[B", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "Lni/shikatu/kotlin/ExperimentalUnsignedTypes;", "Lni/shikatu/kotlin/internal/InlineOnly;", "ubyteArrayOf", "elements", "ubyteArrayOf-GBYM_sE", "([B)[B", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class UByteArrayKt {
    private static final byte[] UByteArray(int size, Function1<? super Integer, UByte> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            bArr[i] = function1.invoke(Integer.valueOf(i)).m74unboximpl();
        }
        return UByteArray.m77constructorimpl(bArr);
    }

    private static final byte[] m93ubyteArrayOfGBYM_sE(byte... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements;
    }
}
