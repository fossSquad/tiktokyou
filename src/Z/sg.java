package Z;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.UnknownFieldException;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.encoding.CompositeDecoder;
import ni.shikatu.kotlinx.serialization.encoding.CompositeEncoder;
import ni.shikatu.kotlinx.serialization.encoding.Decoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.kotlinx.serialization.internal.DoubleSerializer;
import ni.shikatu.kotlinx.serialization.internal.GeneratedSerializer;
import ni.shikatu.kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;

public final  class sg implements GeneratedSerializer {
    public static final sg a;
    public static final PluginGeneratedSerialDescriptor b;

    static {
        sg sgVar = new sg();
        a = sgVar;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.windukk.mod.hooks.badge.SupportPricePayload", sgVar, 2);
        pluginGeneratedSerialDescriptor.addElement("ruble", false);
        pluginGeneratedSerialDescriptor.addElement("usd", false);
        b = pluginGeneratedSerialDescriptor;
    }

    public final KSerializer[] childSerializers() {
        DoubleSerializer doubleSerializer = DoubleSerializer.INSTANCE;
        return new KSerializer[]{doubleSerializer, doubleSerializer};
    }

    public final Object deserialize(Decoder decoder) throws UnknownFieldException {
        int i;
        double dDecodeDoubleElement;
        double d;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(pluginGeneratedSerialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            double dDecodeDoubleElement2 = compositeDecoderBeginStructure.decodeDoubleElement(pluginGeneratedSerialDescriptor, 0);
            dDecodeDoubleElement = compositeDecoderBeginStructure.decodeDoubleElement(pluginGeneratedSerialDescriptor, 1);
            d = dDecodeDoubleElement2;
            i = 3;
        } else {
            double dDecodeDoubleElement3 = 0.0d;
            boolean z = true;
            int i2 = 0;
            double dDecodeDoubleElement4 = 0.0d;
            while (z) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(pluginGeneratedSerialDescriptor);
                if (iDecodeElementIndex == -1) {
                    z = false;
                } else if (iDecodeElementIndex == 0) {
                    dDecodeDoubleElement4 = compositeDecoderBeginStructure.decodeDoubleElement(pluginGeneratedSerialDescriptor, 0);
                    i2 |= 1;
                } else {
                    if (iDecodeElementIndex != 1) {
                        throw new UnknownFieldException(iDecodeElementIndex);
                    }
                    dDecodeDoubleElement3 = compositeDecoderBeginStructure.decodeDoubleElement(pluginGeneratedSerialDescriptor, 1);
                    i2 |= 2;
                }
            }
            i = i2;
            dDecodeDoubleElement = dDecodeDoubleElement3;
            d = dDecodeDoubleElement4;
        }
        compositeDecoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
        return new tg(i, d, dDecodeDoubleElement);
    }

    public final SerialDescriptor getDescriptor() {
        return b;
    }

    public final void serialize(Encoder encoder, Object obj) {
        tg tgVar = (tg) obj;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(pluginGeneratedSerialDescriptor);
        compositeEncoderBeginStructure.encodeDoubleElement(pluginGeneratedSerialDescriptor, 0, tgVar.a);
        compositeEncoderBeginStructure.encodeDoubleElement(pluginGeneratedSerialDescriptor, 1, tgVar.b);
        compositeEncoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
    }
}
