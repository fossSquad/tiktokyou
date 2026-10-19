package ni.shikatu.kotlinx.serialization;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.MagicApiIntrinsics;
import ni.shikatu.kotlin.reflect.KType;
import ni.shikatu.kotlinx.serialization.internal.InternalHexConverter;
import ni.shikatu.kotlinx.serialization.modules.SerializersModule;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0012\n\u0002\b\u0005\u001a#\u0010\u0000\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0004\u001a\u0002H\u0002H\u0086\u0088\u0004¢\u0006\u0002\u0010\u0005\u001a#\u0010\u0006\u001a\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\u0088\u0004¢\u0006\u0002\u0010\b\u001a/\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\f2\u0006\u0010\u0004\u001a\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\r\u001a/\u0010\u000e\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0001H\u0086\u0080\u0004¢\u0006\u0002\u0010\u0012\u001a#\u0010\t\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\n2\u0006\u0010\u0004\u001a\u0002H\u0002H\u0086\u0088\u0004¢\u0006\u0002\u0010\u0013\u001a#\u0010\u000e\u001a\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\n2\u0006\u0010\u0011\u001a\u00020\u0001H\u0086\u0088\u0004¢\u0006\u0002\u0010\u0014\u001a#\u0010\u0015\u001a\u00020\u0016\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\n2\u0006\u0010\u0004\u001a\u0002H\u0002H\u0086\u0088\u0004¢\u0006\u0002\u0010\u0017\u001a#\u0010\u0018\u001a\u0002H\u0002\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0016H\u0086\u0088\u0004¢\u0006\u0002\u0010\u001a¨\u0006\u001b"}, d2 = {"encodeToString", _UrlKt.FRAGMENT_ENCODE_SET, "T", "Lni/shikatu/kotlinx/serialization/StringFormat;", "value", "(Lkotlinx/serialization/StringFormat;Ljava/lang/Object;)Ljava/lang/String;", "decodeFromString", "string", "(Lkotlinx/serialization/StringFormat;Ljava/lang/String;)Ljava/lang/Object;", "encodeToHexString", "Lni/shikatu/kotlinx/serialization/BinaryFormat;", "serializer", "Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/BinaryFormat;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)Ljava/lang/String;", "decodeFromHexString", "deserializer", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "hex", "(Lkotlinx/serialization/BinaryFormat;Lkotlinx/serialization/DeserializationStrategy;Ljava/lang/String;)Ljava/lang/Object;", "(Lkotlinx/serialization/BinaryFormat;Ljava/lang/Object;)Ljava/lang/String;", "(Lkotlinx/serialization/BinaryFormat;Ljava/lang/String;)Ljava/lang/Object;", "encodeToByteArray", _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlinx/serialization/BinaryFormat;Ljava/lang/Object;)[B", "decodeFromByteArray", "bytes", "(Lkotlinx/serialization/BinaryFormat;[B)Ljava/lang/Object;", "ni.shikatu.kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SerialFormatKt {
    public static final  <T> String encodeToString(StringFormat $this$encodeToString, T t) {
        Intrinsics.checkNotNullParameter($this$encodeToString, "<this>");
        SerializersModule serializersModule = $this$encodeToString.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.withModule");
        return $this$encodeToString.encodeToString(SerializersKt.serializer(serializersModule, (KType) null), t);
    }

    public static final  <T> T decodeFromString(StringFormat stringFormat, String str) {
        Intrinsics.checkNotNullParameter(stringFormat, "<this>");
        Intrinsics.checkNotNullParameter(str, "string");
        SerializersModule serializersModule = stringFormat.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.withModule");
        return (T) stringFormat.decodeFromString(SerializersKt.serializer(serializersModule, (KType) null), str);
    }

    public static final <T> String encodeToHexString(BinaryFormat $this$encodeToHexString, SerializationStrategy<? super T> serializationStrategy, T t) {
        Intrinsics.checkNotNullParameter($this$encodeToHexString, "<this>");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        return InternalHexConverter.INSTANCE.printHexBinary($this$encodeToHexString.encodeToByteArray(serializationStrategy, t), true);
    }

    public static final <T> T decodeFromHexString(BinaryFormat binaryFormat, DeserializationStrategy<? extends T> deserializationStrategy, String str) {
        Intrinsics.checkNotNullParameter(binaryFormat, "<this>");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        Intrinsics.checkNotNullParameter(str, "hex");
        return (T) binaryFormat.decodeFromByteArray(deserializationStrategy, InternalHexConverter.INSTANCE.parseHexBinary(str));
    }

    public static final  <T> String encodeToHexString(BinaryFormat $this$encodeToHexString, T t) {
        Intrinsics.checkNotNullParameter($this$encodeToHexString, "<this>");
        SerializersModule serializersModule = $this$encodeToHexString.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.withModule");
        return encodeToHexString($this$encodeToHexString, SerializersKt.serializer(serializersModule, (KType) null), t);
    }

    public static final  <T> T decodeFromHexString(BinaryFormat binaryFormat, String str) {
        Intrinsics.checkNotNullParameter(binaryFormat, "<this>");
        Intrinsics.checkNotNullParameter(str, "hex");
        SerializersModule serializersModule = binaryFormat.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.withModule");
        return (T) decodeFromHexString(binaryFormat, SerializersKt.serializer(serializersModule, (KType) null), str);
    }

    public static final  <T> byte[] encodeToByteArray(BinaryFormat $this$encodeToByteArray, T t) {
        Intrinsics.checkNotNullParameter($this$encodeToByteArray, "<this>");
        SerializersModule serializersModule = $this$encodeToByteArray.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.withModule");
        return $this$encodeToByteArray.encodeToByteArray(SerializersKt.serializer(serializersModule, (KType) null), t);
    }

    public static final  <T> T decodeFromByteArray(BinaryFormat binaryFormat, byte[] bArr) {
        Intrinsics.checkNotNullParameter(binaryFormat, "<this>");
        Intrinsics.checkNotNullParameter(bArr, "bytes");
        SerializersModule serializersModule = binaryFormat.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.withModule");
        return (T) binaryFormat.decodeFromByteArray(SerializersKt.serializer(serializersModule, (KType) null), bArr);
    }
}
