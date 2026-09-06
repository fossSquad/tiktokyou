package Z;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.UnknownFieldException;
import ni.shikatu.kotlinx.serialization.builtins.BuiltinSerializersKt;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.encoding.CompositeDecoder;
import ni.shikatu.kotlinx.serialization.encoding.CompositeEncoder;
import ni.shikatu.kotlinx.serialization.encoding.Decoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.kotlinx.serialization.internal.BooleanSerializer;
import ni.shikatu.kotlinx.serialization.internal.GeneratedSerializer;
import ni.shikatu.kotlinx.serialization.internal.PluginGeneratedSerialDescriptor;
import ni.shikatu.kotlinx.serialization.internal.StringSerializer;

public final  class o1 implements GeneratedSerializer {
    public static final o1 a;
    public static final PluginGeneratedSerialDescriptor b;

    static {
        o1 o1Var = new o1();
        a = o1Var;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = new PluginGeneratedSerialDescriptor("com.windukk.mod.hooks.badge.BadgePayload", o1Var, 7);
        pluginGeneratedSerialDescriptor.addElement("uid", false);
        pluginGeneratedSerialDescriptor.addElement("isDeveloper", true);
        pluginGeneratedSerialDescriptor.addElement("status", true);
        pluginGeneratedSerialDescriptor.addElement("badgeUrl", true);
        pluginGeneratedSerialDescriptor.addElement("tinted", true);
        pluginGeneratedSerialDescriptor.addElement("text", true);
        pluginGeneratedSerialDescriptor.addElement("bannerUrl", true);
        b = pluginGeneratedSerialDescriptor;
    }

    public final KSerializer[] childSerializers() {
        KSerializer kSerializer = StringSerializer.INSTANCE;
        KSerializer kSerializer2 = BooleanSerializer.INSTANCE;
        return new KSerializer[]{kSerializer, kSerializer2, BuiltinSerializersKt.getNullable(kSerializer), BuiltinSerializersKt.getNullable(kSerializer), BuiltinSerializersKt.getNullable(kSerializer2), BuiltinSerializersKt.getNullable(kSerializer), BuiltinSerializersKt.getNullable(kSerializer)};
    }

    public final Object deserialize(Decoder decoder) throws UnknownFieldException {
        String strDecodeStringElement;
        int i;
        String str;
        String str2;
        Boolean bool;
        String str3;
        String str4;
        boolean z;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
        CompositeDecoder compositeDecoderBeginStructure = decoder.beginStructure(pluginGeneratedSerialDescriptor);
        if (compositeDecoderBeginStructure.decodeSequentially()) {
            String strDecodeStringElement2 = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 0);
            boolean zDecodeBooleanElement = compositeDecoderBeginStructure.decodeBooleanElement(pluginGeneratedSerialDescriptor, 1);
            StringSerializer stringSerializer = StringSerializer.INSTANCE;
            String str5 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 2, stringSerializer, (Object) null);
            String str6 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 3, stringSerializer, (Object) null);
            Boolean bool2 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 4, BooleanSerializer.INSTANCE, (Object) null);
            String str7 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 5, stringSerializer, (Object) null);
            strDecodeStringElement = strDecodeStringElement2;
            str = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 6, stringSerializer, (Object) null);
            str2 = str7;
            str3 = str6;
            bool = bool2;
            str4 = str5;
            z = zDecodeBooleanElement;
            i = 127;
        } else {
            boolean z2 = true;
            boolean zDecodeBooleanElement2 = false;
            strDecodeStringElement = null;
            String str8 = null;
            String str9 = null;
            Boolean bool3 = null;
            String str10 = null;
            i = 0;
            String str11 = null;
            while (z2) {
                int iDecodeElementIndex = compositeDecoderBeginStructure.decodeElementIndex(pluginGeneratedSerialDescriptor);
                switch (iDecodeElementIndex) {
                    case -1:
                        z2 = false;
                        continue;
                    case 0:
                        i |= 1;
                        strDecodeStringElement = compositeDecoderBeginStructure.decodeStringElement(pluginGeneratedSerialDescriptor, 0);
                        continue;
                    case 1:
                        zDecodeBooleanElement2 = compositeDecoderBeginStructure.decodeBooleanElement(pluginGeneratedSerialDescriptor, 1);
                        i |= 2;
                        continue;
                    case 2:
                        str8 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 2, StringSerializer.INSTANCE, str8);
                        i |= 4;
                        break;
                    case 3:
                        str9 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 3, StringSerializer.INSTANCE, str9);
                        i |= 8;
                        break;
                    case 4:
                        bool3 = (Boolean) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 4, BooleanSerializer.INSTANCE, bool3);
                        i |= 16;
                        break;
                    case 5:
                        str10 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 5, StringSerializer.INSTANCE, str10);
                        i |= 32;
                        break;
                    case 6:
                        str11 = (String) compositeDecoderBeginStructure.decodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 6, StringSerializer.INSTANCE, str11);
                        i |= 64;
                        break;
                    default:
                        throw new UnknownFieldException(iDecodeElementIndex);
                }
            }
            str = str11;
            str2 = str10;
            bool = bool3;
            str3 = str9;
            str4 = str8;
            z = zDecodeBooleanElement2;
        }
        compositeDecoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
        return new p1(i, strDecodeStringElement, z, str4, str3, bool, str2, str);
    }

    public final SerialDescriptor getDescriptor() {
        return b;
    }

    public final void serialize(Encoder encoder, Object obj) {
        p1 p1Var = (p1) obj;
        PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor = b;
        CompositeEncoder compositeEncoderBeginStructure = encoder.beginStructure(pluginGeneratedSerialDescriptor);
        compositeEncoderBeginStructure.encodeStringElement(pluginGeneratedSerialDescriptor, 0, p1Var.a);
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(pluginGeneratedSerialDescriptor, 1) || p1Var.b) {
            compositeEncoderBeginStructure.encodeBooleanElement(pluginGeneratedSerialDescriptor, 1, p1Var.b);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(pluginGeneratedSerialDescriptor, 2) || p1Var.c != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 2, StringSerializer.INSTANCE, p1Var.c);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(pluginGeneratedSerialDescriptor, 3) || p1Var.d != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 3, StringSerializer.INSTANCE, p1Var.d);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(pluginGeneratedSerialDescriptor, 4) || p1Var.e != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 4, BooleanSerializer.INSTANCE, p1Var.e);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(pluginGeneratedSerialDescriptor, 5) || p1Var.f != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 5, StringSerializer.INSTANCE, p1Var.f);
        }
        if (compositeEncoderBeginStructure.shouldEncodeElementDefault(pluginGeneratedSerialDescriptor, 6) || p1Var.g != null) {
            compositeEncoderBeginStructure.encodeNullableSerializableElement(pluginGeneratedSerialDescriptor, 6, StringSerializer.INSTANCE, p1Var.g);
        }
        compositeEncoderBeginStructure.endStructure(pluginGeneratedSerialDescriptor);
    }
}
