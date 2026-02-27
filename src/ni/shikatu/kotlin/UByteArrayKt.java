package ni.shikatu.kotlin;

import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a-\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001c\u0010\b\u001a\u00020\u00012\n\u0010\t\u001a\u00020\u0001\"\u00020\u0006H\u0087\b¢\u0006\u0004\b\n\u0010\u000b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\f"}, d2 = {"UByteArray", "Lni/shikatu/kotlin/UByteArray;", "size", "", "init", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/UByte;", "(ILkotlin/jvm/functions/Function1;)[B", "ubyteArrayOf", "elements", "ubyteArrayOf-GBYM_sE", "([B)[B", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class UByteArrayKt {
    private static final byte[] UByteArray(int size, Function1<? super Integer, UByte> function1) {
        Intrinsics.checkNotNullParameter(function1, "init");
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            bArr[i] = function1.invoke(Integer.valueOf(i)).m72unboximpl();
        }
        return UByteArray.m75constructorimpl(bArr);
    }

    private static final byte[] m91ubyteArrayOfGBYM_sE(byte... elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return elements;
    }
}
