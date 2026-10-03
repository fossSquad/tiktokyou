package ni.shikatu.kotlinx.serialization.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Ref;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.InternalSerializationApi;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.PolymorphicSerializerKt;
import ni.shikatu.kotlinx.serialization.SerializationException;
import ni.shikatu.kotlinx.serialization.SerializationStrategy;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.encoding.CompositeDecoder;
import ni.shikatu.kotlinx.serialization.encoding.CompositeEncoder;
import ni.shikatu.kotlinx.serialization.encoding.Decoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\t\b@¢\u0006\u0004\b\u0004\u0010\u0005J\u001f\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0086\u0080\u0004¢\u0006\u0002\u0010\u000fJ\u0017\u0010\u0010\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00020\u0012H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0013J\u0017\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00020\u0016H\u0082\u0080\u0004¢\u0006\u0002\u0010\u0017J$\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u00192\u0006\u0010\u0011\u001a\u00020\u00162\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0097\u0080\u0004J'\u0010\u0018\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u001c2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00028\u0000H\u0097\u0080\u0004¢\u0006\u0002\u0010\u001dR\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\b\u0010\t¨\u0006\u001e"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/AbstractPolymorphicSerializer;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/KSerializer;", "<init>", "()V", "baseClass", "Lni/shikatu/kotlin/reflect/KClass;", "getBaseClass", "()Lkotlin/reflect/KClass;", "serialize", _UrlKt.FRAGMENT_ENCODE_SET, "encoder", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "deserialize", "decoder", "Lni/shikatu/kotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "decodeSequentially", "compositeDecoder", "Lni/shikatu/kotlinx/serialization/encoding/CompositeDecoder;", "(Lkotlinx/serialization/encoding/CompositeDecoder;)Ljava/lang/Object;", "findPolymorphicSerializerOrNull", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "klassName", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@InternalSerializationApi
public abstract class AbstractPolymorphicSerializer<T> implements KSerializer<T> {
    public abstract KClass<T> getBaseClass();

    @Override
    public final void serialize(Encoder encoder, T t) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(t, "value");
        SerializationStrategy<? super T> serializationStrategyFindPolymorphicSerializer = PolymorphicSerializerKt.findPolymorphicSerializer(this, encoder, t);
        SerialDescriptor descriptor$iv = getDescriptor();
        CompositeEncoder composite$iv = encoder.beginStructure(descriptor$iv);
        composite$iv.encodeStringElement(getDescriptor(), 0, serializationStrategyFindPolymorphicSerializer.getDescriptor().getSerialName());
        SerialDescriptor descriptor = getDescriptor();
        Intrinsics.checkNotNull(serializationStrategyFindPolymorphicSerializer, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        composite$iv.encodeSerializableElement(descriptor, 1, serializationStrategyFindPolymorphicSerializer, t);
        composite$iv.endStructure(descriptor$iv);
    }

    @Override
    public final T deserialize(Decoder decoder) {
        T t;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor);
        Ref.ObjectRef objectRef = new Ref.ObjectRef();
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            t = (T) decodeSequentially(compositeDecoderBeginStructure);
        } else {
            Object objDecodeSerializableElement$default = null;
            while (true) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(getDescriptor());
                switch (iDecodeElementIndex) {
                    case -1:
                        if (objDecodeSerializableElement$default == null) {
                            throw new IllegalArgumentException(("Polymorphic value has not been read for class " + ((String) objectRef.element)).toString());
                        }
                        Intrinsics.checkNotNull(objDecodeSerializableElement$default, "null cannot be cast to non-null type T of kotlinx.serialization.internal.AbstractPolymorphicSerializer");
                        t = (T) objDecodeSerializableElement$default;
                        break;
                        break;
                    case 0:
                        objectRef.element = (T) compositeDecoderBeginStructure.decodeStringElement(getDescriptor(), iDecodeElementIndex);
                        continue;
                    case 1:
                        T t2 = (T) objectRef.element;
                        if (t2 == null) {
                            throw new IllegalArgumentException("Cannot read polymorphic value before its type token".toString());
                        }
                        objectRef.element = t2;
                        objDecodeSerializableElement$default = CompositeDecoder.decodeSerializableElement$default(compositeDecoderBeginStructure, getDescriptor(), iDecodeElementIndex, PolymorphicSerializerKt.findPolymorphicSerializer(this, compositeDecoderBeginStructure, (String) objectRef.element), null, 8, null);
                        continue;
                        break;
                    default:
                        StringBuilder sbAppend = new StringBuilder().append("Invalid index in polymorphic deserialization of ");
                        String str = (String) objectRef.element;
                        if (str == null) {
                            str = "unknown class";
                        }
                        throw new SerializationException(sbAppend.append(str).append("\n Expected 0, 1 or DECODE_DONE(-1), but found ").append(iDecodeElementIndex).toString());
                }
            }
        }
        compositeDecoderBeginStructure.endStructure(descriptor);
        return t;
    }

    public final T decodeSequentially(CompositeDecoder compositeDecoder) {
        return (T) CompositeDecoder.decodeSerializableElement$default(compositeDecoder, getDescriptor(), 1, PolymorphicSerializerKt.findPolymorphicSerializer(this, compositeDecoder, compositeDecoder.decodeStringElement(getDescriptor(), 0)), null, 8, null);
    }

    @InternalSerializationApi
    public DeserializationStrategy<T> findPolymorphicSerializerOrNull(CompositeDecoder decoder, String klassName) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        return decoder.getSerializersModule().getPolymorphic((KClass) getBaseClass(), klassName);
    }

    @InternalSerializationApi
    public SerializationStrategy<T> findPolymorphicSerializerOrNull(Encoder encoder, T t) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(t, "value");
        return encoder.getSerializersModule().getPolymorphic(getBaseClass(), t);
    }
}
