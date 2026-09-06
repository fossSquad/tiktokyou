package ni.shikatu.kotlinx.serialization.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.SerializationException;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.encoding.CompositeDecoder;
import ni.shikatu.kotlinx.serialization.encoding.CompositeEncoder;
import ni.shikatu.kotlinx.serialization.encoding.Decoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b1\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u0002*\u0004\b\u0002\u0010\u00032\b\u0012\u0004\u0012\u0002H\u00030\u0004B%\bD\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\u0011\u001a\u00028\u00022\u0006\u0010\f\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00028\u0001H¤\u0080\u0004¢\u0006\u0002\u0010\u0012J\u001f\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000f\u001a\u00028\u0002H\u0096\u0080\u0004¢\u0006\u0002\u0010\u0017J\u0017\u0010\u0018\u001a\u00028\u00022\u0006\u0010\u0019\u001a\u00020\u001aH\u0096\u0080\u0004¢\u0006\u0002\u0010\u001bR\u001b\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0084\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004X\u0084\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\f\u001a\u00028\u0000*\u00028\u0002X¤\u0084\b¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\u00028\u0001*\u00028\u0002X¤\u0084\b¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000e\u0082\u0001\u0002\u001c\u001d¨\u0006\u001e"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/KeyValueSerializer;", "K", "V", "R", "Lni/shikatu/kotlinx/serialization/KSerializer;", "keySerializer", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "getKeySerializer", "()Lkotlinx/serialization/KSerializer;", "getValueSerializer", "key", "getKey", "(Ljava/lang/Object;)Ljava/lang/Object;", "value", "getValue", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "serialize", _UrlKt.FRAGMENT_ENCODE_SET, "encoder", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)V", "deserialize", "decoder", "Lni/shikatu/kotlinx/serialization/encoding/Decoder;", "(Lkotlinx/serialization/encoding/Decoder;)Ljava/lang/Object;", "Lni/shikatu/kotlinx/serialization/internal/MapEntrySerializer;", "Lni/shikatu/kotlinx/serialization/internal/PairSerializer;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class KeyValueSerializer<K, V, R> implements KSerializer<R> {
    private final KSerializer<K> keySerializer;
    private final KSerializer<V> valueSerializer;

    public  KeyValueSerializer(KSerializer kSerializer, KSerializer kSerializer2, DefaultConstructorMarker defaultConstructorMarker) {
        this(kSerializer, kSerializer2);
    }

    protected abstract K getKey(R r);

    protected abstract V getValue(R r);

    protected abstract R toResult(K k, V v);

    private KeyValueSerializer(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        this.keySerializer = kSerializer;
        this.valueSerializer = kSerializer2;
    }

    protected final KSerializer<K> getKeySerializer() {
        return this.keySerializer;
    }

    protected final KSerializer<V> getValueSerializer() {
        return this.valueSerializer;
    }

    @Override
    public void serialize(Encoder encoder, R r) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        CompositeEncoder structuredEncoder = encoder.beginStructure(getDescriptor());
        structuredEncoder.encodeSerializableElement(getDescriptor(), 0, this.keySerializer, getKey(r));
        structuredEncoder.encodeSerializableElement(getDescriptor(), 1, this.valueSerializer, getValue(r));
        structuredEncoder.endStructure(getDescriptor());
    }

    @Override
    public R deserialize(Decoder decoder) {
        R r;
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        SerialDescriptor descriptor = getDescriptor();
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(descriptor);
        if (!compositeDecoderBeginStructure.decodeSequentially()) {
            Object objDecodeSerializableElement$default = TuplesKt.NULL;
            Object objDecodeSerializableElement$default2 = TuplesKt.NULL;
            while (true) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(getDescriptor());
                switch (iDecodeElementIndex) {
                    case -1:
                        if (objDecodeSerializableElement$default != TuplesKt.NULL) {
                            if (objDecodeSerializableElement$default2 == TuplesKt.NULL) {
                                throw new SerializationException("Element 'value' is missing");
                            }
                            r = (R) toResult(objDecodeSerializableElement$default, objDecodeSerializableElement$default2);
                        } else {
                            throw new SerializationException("Element 'key' is missing");
                        }
                        break;
                    case 0:
                        objDecodeSerializableElement$default = CompositeDecoder.decodeSerializableElement$default(compositeDecoderBeginStructure, getDescriptor(), 0, getKeySerializer(), null, 8, null);
                        continue;
                    case 1:
                        objDecodeSerializableElement$default2 = CompositeDecoder.decodeSerializableElement$default(compositeDecoderBeginStructure, getDescriptor(), 1, getValueSerializer(), null, 8, null);
                        continue;
                    default:
                        throw new SerializationException("Invalid index: " + iDecodeElementIndex);
                }
            }
        } else {
            r = (R) toResult(CompositeDecoder.decodeSerializableElement$default(compositeDecoderBeginStructure, getDescriptor(), 0, getKeySerializer(), null, 8, null), CompositeDecoder.decodeSerializableElement$default(compositeDecoderBeginStructure, getDescriptor(), 1, getValueSerializer(), null, 8, null));
        }
        compositeDecoderBeginStructure.endStructure(descriptor);
        return r;
    }
}
