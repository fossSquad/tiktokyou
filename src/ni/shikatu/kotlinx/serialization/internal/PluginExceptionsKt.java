package ni.shikatu.kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.InternalSerializationApi;
import ni.shikatu.kotlinx.serialization.MissingFieldException;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0087\u0080\u0004\u001a\"\u0010\u0007\u001a\u00020\u00012\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\u0006H\u0087\u0080\u0004¨\u0006\u000b"}, d2 = {"throwMissingFieldException", _UrlKt.FRAGMENT_ENCODE_SET, "seen", _UrlKt.FRAGMENT_ENCODE_SET, "goldenMask", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "throwArrayMissingFieldException", "seenArray", _UrlKt.FRAGMENT_ENCODE_SET, "goldenMaskArray", "ni.shikatu.kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PluginExceptionsKt {
    @InternalSerializationApi
    public static final void throwMissingFieldException(int seen, int goldenMask, SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        List missingFields = new ArrayList();
        int missingFieldsBits = (~seen) & goldenMask;
        for (int i = 0; i < 32; i++) {
            if ((missingFieldsBits & 1) != 0) {
                missingFields.add(descriptor.getElementName(i));
            }
            missingFieldsBits >>>= 1;
        }
        throw new MissingFieldException((List<String>) missingFields, descriptor.getSerialName());
    }

    @InternalSerializationApi
    public static final void throwArrayMissingFieldException(int[] seenArray, int[] goldenMaskArray, SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(seenArray, "seenArray");
        Intrinsics.checkNotNullParameter(goldenMaskArray, "goldenMaskArray");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        List missingFields = new ArrayList();
        int length = goldenMaskArray.length;
        for (int maskSlot = 0; maskSlot < length; maskSlot++) {
            int missingFieldsBits = goldenMaskArray[maskSlot] & (~seenArray[maskSlot]);
            if (missingFieldsBits != 0) {
                for (int i = 0; i < 32; i++) {
                    if ((missingFieldsBits & 1) != 0) {
                        missingFields.add(descriptor.getElementName((maskSlot * 32) + i));
                    }
                    missingFieldsBits >>>= 1;
                }
            }
        }
        throw new MissingFieldException((List<String>) missingFields, descriptor.getSerialName());
    }
}
