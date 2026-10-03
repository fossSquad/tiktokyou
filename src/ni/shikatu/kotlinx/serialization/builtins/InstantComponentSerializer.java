package ni.shikatu.kotlinx.serialization.builtins;

import java.lang.annotation.Annotation;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.time.Instant;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.MissingFieldException;
import ni.shikatu.kotlinx.serialization.SerializationException;
import ni.shikatu.kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptorsKt;
import ni.shikatu.kotlinx.serialization.encoding.CompositeDecoder;
import ni.shikatu.kotlinx.serialization.encoding.CompositeEncoder;
import ni.shikatu.kotlinx.serialization.encoding.Decoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.kotlinx.serialization.internal.LongSerializer;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\t\bB¢\u0006\u0004\b\u0003\u0010\u0004J\u0012\u0010\t\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0002H\u0096\u0080\u0004R\u0015\u0010\u0005\u001a\u00020\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0011"}, d2 = {"Lni/shikatu/kotlinx/serialization/builtins/InstantComponentSerializer;", "Lni/shikatu/kotlinx/serialization/KSerializer;", "Lni/shikatu/kotlin/time/Instant;", "<init>", "()V", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "deserialize", "decoder", "Lni/shikatu/kotlinx/serialization/encoding/Decoder;", "serialize", _UrlKt.FRAGMENT_ENCODE_SET, "encoder", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "value", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class InstantComponentSerializer implements KSerializer<Instant> {
    public static final InstantComponentSerializer INSTANCE = new InstantComponentSerializer();
    private static final SerialDescriptor descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("ni.shikatu.kotlinx.serialization.InstantComponentSerializer", new SerialDescriptor[0], new Function1() {
        @Override
        public final Object invoke(Object obj) {
            return InstantComponentSerializer.descriptor$lambda$0((ClassSerialDescriptorBuilder) obj);
        }
    });

    private InstantComponentSerializer() {
    }

    @Override
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    public static final Unit descriptor$lambda$0(ClassSerialDescriptorBuilder $this$buildClassSerialDescriptor) {
        Intrinsics.checkNotNullParameter($this$buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        List<? extends Annotation> listEmptyList = CollectionsKt.emptyList();
        SerialDescriptor descriptor$iv = LongSerializer.INSTANCE.getDescriptor();
        $this$buildClassSerialDescriptor.element("epochSeconds", descriptor$iv, listEmptyList, false);
        List<? extends Annotation> listEmptyList2 = CollectionsKt.emptyList();
        SerialDescriptor descriptor$iv2 = LongSerializer.INSTANCE.getDescriptor();
        $this$buildClassSerialDescriptor.element("nanosecondsOfSecond", descriptor$iv2, listEmptyList2, true);
        return Unit.INSTANCE;
    }

    @Override
    public Instant deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeDecoder composite$iv = decoder.beginStructure(descriptor$iv);
        boolean epochSecondsNotSeen = true;
        long epochSeconds = 0;
        int nanosecondsOfSecond = 0;
        while (true) {
            int index = composite$iv.decodeElementIndex(INSTANCE.getDescriptor());
            switch (index) {
                case -1:
                    if (epochSecondsNotSeen) {
                        throw new MissingFieldException("epochSeconds", INSTANCE.getDescriptor().getSerialName());
                    }
                    Instant instantFromEpochSeconds = Instant.Companion.fromEpochSeconds(epochSeconds, nanosecondsOfSecond);
                    composite$iv.endStructure(descriptor$iv);
                    return instantFromEpochSeconds;
                case 0:
                    epochSecondsNotSeen = false;
                    epochSeconds = composite$iv.decodeLongElement(INSTANCE.getDescriptor(), 0);
                    break;
                case 1:
                    nanosecondsOfSecond = composite$iv.decodeIntElement(INSTANCE.getDescriptor(), 1);
                    break;
                default:
                    throw new SerializationException("Unexpected index: " + index);
            }
        }
    }

    @Override
    public void serialize(Encoder encoder, Instant value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeEncoder composite$iv = encoder.beginStructure(descriptor$iv);
        composite$iv.encodeLongElement(INSTANCE.getDescriptor(), 0, value.getEpochSeconds());
        if (value.getNanosecondsOfSecond() != 0 || composite$iv.shouldEncodeElementDefault(INSTANCE.getDescriptor(), 1)) {
            composite$iv.encodeIntElement(INSTANCE.getDescriptor(), 1, value.getNanosecondsOfSecond());
        }
        composite$iv.endStructure(descriptor$iv);
    }
}
