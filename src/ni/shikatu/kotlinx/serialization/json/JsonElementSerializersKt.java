package ni.shikatu.kotlinx.serialization.json;

import java.lang.annotation.Annotation;
import java.util.List;
import ni.shikatu.kotlin.Lazy;
import ni.shikatu.kotlin.LazyKt;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialKind;
import ni.shikatu.kotlinx.serialization.encoding.Decoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0082\u0080\u0004\u001a\u0012\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u0005H\u0082\u0080\u0004\u001a\u000e\u0010\u0006\u001a\u00020\u0007*\u00020\u0005H\u0080\u0080\u0004\u001a\u000e\u0010\b\u001a\u00020\t*\u00020\u0003H\u0080\u0080\u0004\u001a\u0018\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\rH\u0082\u0080\u0004¨\u0006\u000e"}, d2 = {"verify", _UrlKt.FRAGMENT_ENCODE_SET, "encoder", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "decoder", "Lni/shikatu/kotlinx/serialization/encoding/Decoder;", "asJsonDecoder", "Lni/shikatu/kotlinx/serialization/json/JsonDecoder;", "asJsonEncoder", "Lni/shikatu/kotlinx/serialization/json/JsonEncoder;", "defer", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "deferred", "Lni/shikatu/kotlin/Function0;", "ni.shikatu.kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class JsonElementSerializersKt {

    public static final void verify(Encoder encoder) {
        asJsonEncoder(encoder);
    }

    public static final void verify(Decoder decoder) {
        asJsonDecoder(decoder);
    }

    public static final JsonDecoder asJsonDecoder(Decoder $this$asJsonDecoder) {
        Intrinsics.checkNotNullParameter($this$asJsonDecoder, "<this>");
        JsonDecoder jsonDecoder = $this$asJsonDecoder instanceof JsonDecoder ? (JsonDecoder) $this$asJsonDecoder : null;
        if (jsonDecoder == null) {
            throw new IllegalStateException("This serializer can be used only with Json format.Expected Decoder to be JsonDecoder, got " + Reflection.getOrCreateKotlinClass($this$asJsonDecoder.getClass()));
        }
        return jsonDecoder;
    }

    public static final JsonEncoder asJsonEncoder(Encoder $this$asJsonEncoder) {
        Intrinsics.checkNotNullParameter($this$asJsonEncoder, "<this>");
        JsonEncoder jsonEncoder = $this$asJsonEncoder instanceof JsonEncoder ? (JsonEncoder) $this$asJsonEncoder : null;
        if (jsonEncoder == null) {
            throw new IllegalStateException("This serializer can be used only with Json format.Expected Encoder to be JsonEncoder, got " + Reflection.getOrCreateKotlinClass($this$asJsonEncoder.getClass()));
        }
        return jsonEncoder;
    }

    public static final SerialDescriptor defer(Function0<? extends SerialDescriptor> function0) {
        return new SerialDescriptor(function0) {
            private final Lazy original$delegate;

            {
                this.original$delegate = LazyKt.lazy(function0);
            }

            @Override
            public /* bridge */ List<Annotation> getAnnotations() {
                return super.getAnnotations();
            }

            @Override
            public /* bridge */ boolean isInline() {
                return super.isInline();
            }

            @Override
            public /* bridge */ boolean isNullable() {
                return super.isNullable();
            }

            private final SerialDescriptor getOriginal() {
                return (SerialDescriptor) this.original$delegate.getValue();
            }

            @Override
            public String getSerialName() {
                return getOriginal().getSerialName();
            }

            @Override
            public SerialKind getKind() {
                return getOriginal().getKind();
            }

            @Override
            public int getElementsCount() {
                return getOriginal().getElementsCount();
            }

            @Override
            public String getElementName(int index) {
                return getOriginal().getElementName(index);
            }

            @Override
            public int getElementIndex(String name) {
                Intrinsics.checkNotNullParameter(name, "name");
                return getOriginal().getElementIndex(name);
            }

            @Override
            public List<Annotation> getElementAnnotations(int index) {
                return getOriginal().getElementAnnotations(index);
            }

            @Override
            public SerialDescriptor getElementDescriptor(int index) {
                return getOriginal().getElementDescriptor(index);
            }

            @Override
            public boolean isElementOptional(int index) {
                return getOriginal().isElementOptional(index);
            }
        };
    }
}
