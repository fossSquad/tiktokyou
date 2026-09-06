package ni.shikatu.kotlinx.serialization.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Triple;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.SerializationException;
import ni.shikatu.kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptorsKt;
import ni.shikatu.kotlinx.serialization.encoding.CompositeDecoder;
import ni.shikatu.kotlinx.serialization.encoding.CompositeEncoder;
import ni.shikatu.kotlinx.serialization.encoding.Decoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00030\u00050\u0004B3\bF\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004¢\u0006\u0004\b\t\u0010\nJ,\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0018\u0010\u0013\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u0005H\u0096\u0080\u0004J$\u0010\u0014\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0016H\u0096\u0080\u0004J$\u0010\u0017\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0082\u0080\u0004J$\u0010\u001a\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0012\u0004\u0012\u00028\u00020\u00052\u0006\u0010\u0018\u001a\u00020\u0019H\u0082\u0080\u0004R\u0015\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00020\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u000b\u001a\u00020\fX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001b"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/TripleSerializer;", "A", "B", "C", "Lni/shikatu/kotlinx/serialization/KSerializer;", "Lni/shikatu/kotlin/Triple;", "aSerializer", "bSerializer", "cSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", _UrlKt.FRAGMENT_ENCODE_SET, "encoder", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lni/shikatu/kotlinx/serialization/encoding/Decoder;", "decodeSequentially", "composite", "Lni/shikatu/kotlinx/serialization/encoding/CompositeDecoder;", "decodeStructure", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class TripleSerializer<A, B, C> implements KSerializer<Triple<? extends A, ? extends B, ? extends C>> {
    private final KSerializer<A> aSerializer;
    private final KSerializer<B> bSerializer;
    private final KSerializer<C> cSerializer;
    private final SerialDescriptor descriptor;

    public TripleSerializer(KSerializer<A> kSerializer, KSerializer<B> kSerializer2, KSerializer<C> kSerializer3) {
        Intrinsics.checkNotNullParameter(kSerializer, "aSerializer");
        Intrinsics.checkNotNullParameter(kSerializer2, "bSerializer");
        Intrinsics.checkNotNullParameter(kSerializer3, "cSerializer");
        this.aSerializer = kSerializer;
        this.bSerializer = kSerializer2;
        this.cSerializer = kSerializer3;
        this.descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("ni.shikatu.kotlin.Triple", new SerialDescriptor[0], new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return TripleSerializer.descriptor$lambda$0(this.f$0, (ClassSerialDescriptorBuilder) obj);
            }
        });
    }

    @Override
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public static final Unit descriptor$lambda$0(TripleSerializer this$0, ClassSerialDescriptorBuilder $this$buildClassSerialDescriptor) {
        Intrinsics.checkNotNullParameter($this$buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default($this$buildClassSerialDescriptor, "first", this$0.aSerializer.getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default($this$buildClassSerialDescriptor, "second", this$0.bSerializer.getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default($this$buildClassSerialDescriptor, "third", this$0.cSerializer.getDescriptor(), null, false, 12, null);
        return Unit.INSTANCE;
    }

    @Override
    public void serialize(Encoder encoder, Triple<? extends A, ? extends B, ? extends C> triple) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(triple, "value");
        CompositeEncoder structuredEncoder = encoder.beginStructure(getDescriptor());
        structuredEncoder.encodeSerializableElement(getDescriptor(), 0, this.aSerializer, triple.getFirst());
        structuredEncoder.encodeSerializableElement(getDescriptor(), 1, this.bSerializer, triple.getSecond());
        structuredEncoder.encodeSerializableElement(getDescriptor(), 2, this.cSerializer, triple.getThird());
        structuredEncoder.endStructure(getDescriptor());
    }

    @Override
    public Triple<A, B, C> deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        CompositeDecoder composite = decoder.beginStructure(getDescriptor());
        if (composite.decodeSequentially()) {
            return decodeSequentially(composite);
        }
        return decodeStructure(composite);
    }

    private final Triple<A, B, C> decodeSequentially(CompositeDecoder composite) {
        Object a = CompositeDecoder.decodeSerializableElement$default(composite, getDescriptor(), 0, this.aSerializer, null, 8, null);
        Object b = CompositeDecoder.decodeSerializableElement$default(composite, getDescriptor(), 1, this.bSerializer, null, 8, null);
        Object c = CompositeDecoder.decodeSerializableElement$default(composite, getDescriptor(), 2, this.cSerializer, null, 8, null);
        composite.endStructure(getDescriptor());
        return new Triple<>(a, b, c);
    }

    private final Triple<A, B, C> decodeStructure(CompositeDecoder composite) {
        Object a = TuplesKt.NULL;
        Object b = TuplesKt.NULL;
        Object c = TuplesKt.NULL;
        while (true) {
            int index = composite.decodeElementIndex(getDescriptor());
            switch (index) {
                case -1:
                    composite.endStructure(getDescriptor());
                    if (a != TuplesKt.NULL) {
                        if (b != TuplesKt.NULL) {
                            if (c == TuplesKt.NULL) {
                                throw new SerializationException("Element 'third' is missing");
                            }
                            return new Triple<>(a, b, c);
                        }
                        throw new SerializationException("Element 'second' is missing");
                    }
                    throw new SerializationException("Element 'first' is missing");
                case 0:
                    CompositeDecoder composite2 = composite;
                    a = CompositeDecoder.decodeSerializableElement$default(composite2, getDescriptor(), 0, this.aSerializer, null, 8, null);
                    composite = composite2;
                    break;
                case 1:
                    CompositeDecoder composite3 = composite;
                    b = CompositeDecoder.decodeSerializableElement$default(composite3, getDescriptor(), 1, this.bSerializer, null, 8, null);
                    composite = composite3;
                    break;
                case 2:
                    c = CompositeDecoder.decodeSerializableElement$default(composite, getDescriptor(), 2, this.cSerializer, null, 8, null);
                    break;
                default:
                    throw new SerializationException("Unexpected index " + index);
            }
        }
    }
}
