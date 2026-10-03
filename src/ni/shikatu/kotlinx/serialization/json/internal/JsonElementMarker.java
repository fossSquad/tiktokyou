package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.internal.ElementMarker;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0080\u0080\u0004¢\u0006\u0002\b\u0011J\u000f\u0010\u0012\u001a\u00020\u0010H\u0080\u0080\u0004¢\u0006\u0002\b\u0013J\u001a\u0010\u0014\u001a\u00020\t2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0010H\u0082\u0080\u0004R\u000f\u0010\u0006\u001a\u00020\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001f\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0080\u008e\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/JsonElementMarker;", _UrlKt.FRAGMENT_ENCODE_SET, "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "<init>", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "origin", "Lni/shikatu/kotlinx/serialization/internal/ElementMarker;", "value", _UrlKt.FRAGMENT_ENCODE_SET, "isUnmarkedNull", "isUnmarkedNull$kotlinx_serialization_json", "()Z", "mark", _UrlKt.FRAGMENT_ENCODE_SET, "index", _UrlKt.FRAGMENT_ENCODE_SET, "mark$kotlinx_serialization_json", "nextUnmarkedIndex", "nextUnmarkedIndex$kotlinx_serialization_json", "readIfAbsent", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JsonElementMarker {
    private boolean isUnmarkedNull;
    private final ElementMarker origin;

    public JsonElementMarker(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.origin = new ElementMarker(descriptor, new JsonElementMarker$origin$1(this));
    }

    public final boolean isUnmarkedNull$kotlinx_serialization_json() {
        return this.isUnmarkedNull;
    }

    public final void mark$kotlinx_serialization_json(int index) {
        this.origin.mark(index);
    }

    public final int nextUnmarkedIndex$kotlinx_serialization_json() {
        return this.origin.nextUnmarkedIndex();
    }

    public final boolean readIfAbsent(SerialDescriptor descriptor, int index) {
        this.isUnmarkedNull = !descriptor.isElementOptional(index) && descriptor.getElementDescriptor(index).isNullable();
        return this.isUnmarkedNull;
    }
}
