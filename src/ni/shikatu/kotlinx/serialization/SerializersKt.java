package ni.shikatu.kotlinx.serialization;

import java.lang.reflect.Type;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.MagicApiIntrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.reflect.KClassifier;
import ni.shikatu.kotlin.reflect.KType;
import ni.shikatu.kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"ni/shikatu/kotlinx/serialization/SerializersKt__SerializersJvmKt", "ni/shikatu/kotlinx/serialization/SerializersKt__SerializersKt"}, k = 4, mv = {2, 3, 0}, xi = 48)
public final class SerializersKt {
    public static final KSerializer<?> moduleThenPolymorphic(SerializersModule module, KClass<?> kClass) {
        return SerializersKt__SerializersKt.moduleThenPolymorphic(module, kClass);
    }

    public static final KSerializer<?> moduleThenPolymorphic(SerializersModule module, KClass<?> kClass, KSerializer<?>[] kSerializerArr) {
        return SerializersKt__SerializersKt.moduleThenPolymorphic(module, kClass, kSerializerArr);
    }

    public static final KSerializer<?> noCompiledSerializer(String forClass) {
        return SerializersKt__SerializersKt.noCompiledSerializer(forClass);
    }

    public static final KSerializer<?> noCompiledSerializer(SerializersModule module, KClass<?> kClass) {
        return SerializersKt__SerializersKt.noCompiledSerializer(module, kClass);
    }

    public static final KSerializer<?> noCompiledSerializer(SerializersModule module, KClass<?> kClass, KSerializer<?>[] kSerializerArr) {
        return SerializersKt__SerializersKt.noCompiledSerializer(module, kClass, kSerializerArr);
    }

    public static final KSerializer<? extends Object> parametrizedSerializerOrNull(KClass<Object> kClass, List<? extends KSerializer<Object>> list, Function0<? extends KClassifier> function0) {
        return SerializersKt__SerializersKt.parametrizedSerializerOrNull(kClass, list, function0);
    }

    public static final  <T> KSerializer<T> serializer() {
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.simple");
        return (KSerializer<T>) serializer((KType) null);
    }

    public static final KSerializer<Object> serializer(Type type) {
        return SerializersKt__SerializersJvmKt.serializer(type);
    }

    @InternalSerializationApi
    public static final <T> KSerializer<T> serializer(KClass<T> kClass) {
        return SerializersKt__SerializersKt.serializer(kClass);
    }

    @ExperimentalSerializationApi
    public static final KSerializer<Object> serializer(KClass<?> kClass, List<? extends KSerializer<?>> list, boolean isNullable) {
        return SerializersKt__SerializersKt.serializer(kClass, list, isNullable);
    }

    public static final KSerializer<Object> serializer(KType type) {
        return SerializersKt__SerializersKt.serializer(type);
    }

    public static final  <T> KSerializer<T> serializer(SerializersModule serializersModule) {
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.withModule");
        return (KSerializer<T>) serializer(serializersModule, (KType) null);
    }

    public static final KSerializer<Object> serializer(SerializersModule $this$serializer, Type type) {
        return SerializersKt__SerializersJvmKt.serializer($this$serializer, type);
    }

    @ExperimentalSerializationApi
    public static final KSerializer<Object> serializer(SerializersModule $this$serializer, KClass<?> kClass, List<? extends KSerializer<?>> list, boolean isNullable) {
        return SerializersKt__SerializersKt.serializer($this$serializer, kClass, list, isNullable);
    }

    public static final KSerializer<Object> serializer(SerializersModule $this$serializer, KType type) {
        return SerializersKt__SerializersKt.serializer($this$serializer, type);
    }

    public static final KSerializer<Object> serializerOrNull(Type type) {
        return SerializersKt__SerializersJvmKt.serializerOrNull(type);
    }

    @InternalSerializationApi
    public static final <T> KSerializer<T> serializerOrNull(KClass<T> kClass) {
        return SerializersKt__SerializersKt.serializerOrNull(kClass);
    }

    public static final KSerializer<Object> serializerOrNull(KType type) {
        return SerializersKt__SerializersKt.serializerOrNull(type);
    }

    public static final KSerializer<Object> serializerOrNull(SerializersModule $this$serializerOrNull, Type type) {
        return SerializersKt__SerializersJvmKt.serializerOrNull($this$serializerOrNull, type);
    }

    public static final KSerializer<Object> serializerOrNull(SerializersModule $this$serializerOrNull, KType type) {
        return SerializersKt__SerializersKt.serializerOrNull($this$serializerOrNull, type);
    }

    public static final List<KSerializer<Object>> serializersForParameters(SerializersModule $this$serializersForParameters, List<? extends KType> list, boolean failOnMissingTypeArgSerializer) {
        return SerializersKt__SerializersKt.serializersForParameters($this$serializersForParameters, list, failOnMissingTypeArgSerializer);
    }
}
