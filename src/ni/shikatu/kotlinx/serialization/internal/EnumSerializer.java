package ni.shikatu.kotlinx.serialization.internal;

import java.lang.Enum;
import java.util.Arrays;
import ni.shikatu.kotlin.Lazy;
import ni.shikatu.kotlin.LazyKt;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.Typography;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.SerializationException;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.encoding.Decoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0001\u0018\u0000*\u000e\b\u0000\u0010\u0001*\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u001f\bF\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tB'\bP\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\b\u0010\fJ\u0012\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0082\u0080\u0004J\u001f\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0019J\u0017\u0010\u001a\u001a\u00028\u00002\u0006\u0010\u001b\u001a\u00020\u001cH\u0096\u0080\u0004¢\u0006\u0002\u0010\u001dJ\n\u0010\u001e\u001a\u00020\u0005H\u0096\u0080\u0004R\u0017\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\rR\u0011\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u001b\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\n¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/EnumSerializer;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/KSerializer;", "serialName", _UrlKt.FRAGMENT_ENCODE_SET, "values", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;[Ljava/lang/Enum;)V", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "(Ljava/lang/String;[Ljava/lang/Enum;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "[Ljava/lang/Enum;", "overriddenDescriptor", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lni/shikatu/kotlin/Lazy;", "createUnmarkedDescriptor", "serialize", _UrlKt.FRAGMENT_ENCODE_SET, "encoder", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Enum;)V", "deserialize", "decoder", "Lni/shikatu/kotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Enum;", "toString", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class EnumSerializer<T extends Enum<T>> implements KSerializer<T> {
    private final Lazy descriptor$delegate;
    private SerialDescriptor overriddenDescriptor;
    private final T[] values;

    public EnumSerializer(final String serialName, T[] tArr) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(tArr, "values");
        this.values = tArr;
        this.descriptor$delegate = LazyKt.lazy(new Function0() {
            @Override
            public final Object invoke() {
                return EnumSerializer.descriptor_delegate$lambda$0(this.f$0, serialName);
            }
        });
    }

    public EnumSerializer(String serialName, T[] tArr, SerialDescriptor descriptor) {
        this(serialName, tArr);
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(tArr, "values");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.overriddenDescriptor = descriptor;
    }

    @Override
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor$delegate.getValue();
    }

    public static final SerialDescriptor descriptor_delegate$lambda$0(EnumSerializer this$0, String $serialName) {
        SerialDescriptor serialDescriptor = this$0.overriddenDescriptor;
        return serialDescriptor == null ? this$0.createUnmarkedDescriptor($serialName) : serialDescriptor;
    }

    private final SerialDescriptor createUnmarkedDescriptor(String serialName) {
        EnumDescriptor d = new EnumDescriptor(serialName, this.values.length);
        for (T t : this.values) {
            PluginGeneratedSerialDescriptor.addElement$default(d, t.name(), false, 2, null);
        }
        return d;
    }

    @Override
    public void serialize(Encoder encoder, T t) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(t, "value");
        int index = ArraysKt.indexOf(this.values, t);
        if (index == -1) {
            StringBuilder sbAppend = new StringBuilder().append(t).append(" is not a valid enum ").append(getDescriptor().getSerialName()).append(", must be one of ");
            String string = Arrays.toString(this.values);
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            throw new SerializationException(sbAppend.append(string).toString());
        }
        encoder.encodeEnum(getDescriptor(), index);
    }

    @Override
    public T deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        int index = decoder.decodeEnum(getDescriptor());
        boolean z = false;
        if (index >= 0 && index < this.values.length) {
            z = true;
        }
        if (!z) {
            throw new SerializationException(index + " is not among valid " + getDescriptor().getSerialName() + " enum values, values size is " + this.values.length);
        }
        return this.values[index];
    }

    public String toString() {
        return "ni.shikatu.kotlinx.serialization.internal.EnumSerializer<" + getDescriptor().getSerialName() + Typography.greater;
    }
}
