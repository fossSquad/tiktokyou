package ni.shikatu.kotlinx.serialization.descriptors;

import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.markers.KMappedMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0010(\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\n\u0010\u0005\u001a\u00020\u0006H\u0096\u0082\u0004J\n\u0010\u0007\u001a\u00020\u0002H\u0096\u0082\u0004R\u000f\u0010\u0003\u001a\u00020\u0004X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"ni/shikatu/kotlinx/serialization/descriptors/SerialDescriptorKt$elementNames$1$1", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "elementsLeft", _UrlKt.FRAGMENT_ENCODE_SET, "hasNext", _UrlKt.FRAGMENT_ENCODE_SET, "next", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SerialDescriptorKt$elementNames$1$1 implements Iterator<String>, KMappedMarker {
    final  SerialDescriptor $this_elementNames;
    private int elementsLeft;

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    SerialDescriptorKt$elementNames$1$1(SerialDescriptor $receiver) {
        this.$this_elementNames = $receiver;
        this.elementsLeft = $receiver.getElementsCount();
    }

    @Override
    public boolean hasNext() {
        return this.elementsLeft > 0;
    }

    @Override
    public String next() {
        SerialDescriptor serialDescriptor = this.$this_elementNames;
        int elementsCount = this.$this_elementNames.getElementsCount();
        int i = this.elementsLeft;
        this.elementsLeft = i - 1;
        return serialDescriptor.getElementName(elementsCount - i);
    }
}
