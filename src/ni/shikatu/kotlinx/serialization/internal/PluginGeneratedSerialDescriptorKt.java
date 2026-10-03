package ni.shikatu.kotlinx.serialization.internal;

import java.util.Arrays;
import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptorKt;
import ni.shikatu.kotlinx.serialization.descriptors.SerialKind;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u001aO\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u0002H\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052!\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\n\u0012\u0004\u0012\u00020\u00010\u0007H\u0080\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a!\u0010\f\u001a\u00020\r*\u00020\u00032\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u000fH\u0080\u0080\u0004¢\u0006\u0002\u0010\u0010\u001a\u000e\u0010\u0011\u001a\u00020\u0012*\u00020\u0003H\u0080\u0080\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"equalsImpl", _UrlKt.FRAGMENT_ENCODE_SET, "SD", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "other", _UrlKt.FRAGMENT_ENCODE_SET, "typeParamsAreEqual", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/ParameterName;", "name", "otherDescriptor", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Z", "hashCodeImpl", _UrlKt.FRAGMENT_ENCODE_SET, "typeParams", _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlinx/serialization/descriptors/SerialDescriptor;[Lkotlinx/serialization/descriptors/SerialDescriptor;)I", "toStringImpl", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PluginGeneratedSerialDescriptorKt {
    public static final  <SD extends SerialDescriptor> boolean equalsImpl(SD sd, Object other, Function1<? super SD, Boolean> function1) {
        Intrinsics.checkNotNullParameter(sd, "<this>");
        Intrinsics.checkNotNullParameter(function1, "typeParamsAreEqual");
        if (sd == other) {
            return true;
        }
        Intrinsics.reifiedOperationMarker(3, "SD");
        if (!(other instanceof SerialDescriptor) || !Intrinsics.areEqual(sd.getSerialName(), ((SerialDescriptor) other).getSerialName()) || !function1.invoke(other).booleanValue() || sd.getElementsCount() != ((SerialDescriptor) other).getElementsCount()) {
            return false;
        }
        int elementsCount = sd.getElementsCount();
        for (int index = 0; index < elementsCount; index++) {
            if (!Intrinsics.areEqual(sd.getElementDescriptor(index).getSerialName(), ((SerialDescriptor) other).getElementDescriptor(index).getSerialName()) || !Intrinsics.areEqual(sd.getElementDescriptor(index).getKind(), ((SerialDescriptor) other).getElementDescriptor(index).getKind())) {
                return false;
            }
        }
        return true;
    }

    public static final int hashCodeImpl(SerialDescriptor $this$hashCodeImpl, SerialDescriptor[] typeParams) {
        Intrinsics.checkNotNullParameter($this$hashCodeImpl, "<this>");
        Intrinsics.checkNotNullParameter(typeParams, "typeParams");
        int result = $this$hashCodeImpl.getSerialName().hashCode();
        int result2 = (result * 31) + Arrays.hashCode(typeParams);
        Iterable<SerialDescriptor> elementDescriptors = SerialDescriptorKt.getElementDescriptors($this$hashCodeImpl);
        int accumulator$iv$iv = 1;
        Iterator<SerialDescriptor> it = elementDescriptors.iterator();
        while (true) {
            int iHashCode = 0;
            if (!it.hasNext()) {
                break;
            }
            Object element$iv$iv = it.next();
            int hash$iv = accumulator$iv$iv;
            int i = hash$iv * 31;
            SerialDescriptor it2 = (SerialDescriptor) element$iv$iv;
            String serialName = it2.getSerialName();
            if (serialName != null) {
                iHashCode = serialName.hashCode();
            }
            accumulator$iv$iv = i + iHashCode;
        }
        int accumulator$iv$iv2 = 1;
        for (Object element$iv$iv2 : elementDescriptors) {
            int hash$iv2 = accumulator$iv$iv2;
            int i2 = hash$iv2 * 31;
            SerialDescriptor it3 = (SerialDescriptor) element$iv$iv2;
            SerialKind kind = it3.getKind();
            accumulator$iv$iv2 = i2 + (kind != null ? kind.hashCode() : 0);
        }
        return (((result2 * 31) + accumulator$iv$iv) * 31) + accumulator$iv$iv2;
    }

    public static final String toStringImpl(final SerialDescriptor $this$toStringImpl) {
        Intrinsics.checkNotNullParameter($this$toStringImpl, "<this>");
        return CollectionsKt.joinToString$default(RangesKt.until(0, $this$toStringImpl.getElementsCount()), ", ", $this$toStringImpl.getSerialName() + '(', ")", 0, null, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return PluginGeneratedSerialDescriptorKt.toStringImpl$lambda$0($this$toStringImpl, ((Integer) obj).intValue());
            }
        }, 24, null);
    }

    public static final CharSequence toStringImpl$lambda$0(SerialDescriptor $this_toStringImpl, int i) {
        return $this_toStringImpl.getElementName(i) + ": " + $this_toStringImpl.getElementDescriptor(i).getSerialName();
    }
}
