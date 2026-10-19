package ni.shikatu.kotlinx.serialization.modules;

import java.util.List;
import java.util.Map;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.kotlin.jvm.internal.TypeIntrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.SerializationStrategy;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001Bð\u0001\bF\u0012\u0016\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012*\u0010\u0006\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u0003\u0012.\u0010\b\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\n0\tj\u0006\u0012\u0002\b\u0003`\u000b0\u0003\u0012&\u0010\f\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u0003\u0012A\u0010\u000e\u001a=\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012/\u0012-\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00120\tj\u0006\u0012\u0002\b\u0003`\u00130\u0003\u0012\u0006\u0010\u0014\u001a\u00020\u0015¢\u0006\u0004\b\u0016\u0010\u0017J9\u0010\u001a\u001a\n\u0012\u0004\u0012\u0002H\u001b\u0018\u00010\n\"\b\b\u0000\u0010\u001b*\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u001b0\u00042\u0006\u0010\u001e\u001a\u0002H\u001bH\u0096\u0080\u0004¢\u0006\u0002\u0010\u001fJ6\u0010\u001a\u001a\n\u0012\u0004\u0012\u0002H\u001b\u0018\u00010\u0012\"\b\b\u0000\u0010\u001b*\u00020\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u001b0\u00042\b\u0010 \u001a\u0004\u0018\u00010\rH\u0096\u0080\u0004J<\u0010!\u001a\n\u0012\u0004\u0012\u0002H\u001b\u0018\u00010\u0007\"\b\b\u0000\u0010\u001b*\u00020\u001c2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u00042\u0010\u0010#\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070$H\u0096\u0080\u0004J\u0012\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(H\u0096\u0080\u0004R\u001f\u0010\u0002\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0004\u0012\u00020\u00050\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R5\u0010\u0006\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u00038\u0006X\u0087\u0084\b¢\u0006\u0002\n\u0000R7\u0010\b\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\n0\tj\u0006\u0012\u0002\b\u0003`\u000b0\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R/\u0010\f\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\r\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00070\u00030\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000RJ\u0010\u000e\u001a=\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0004\u0012/\u0012-\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00120\tj\u0006\u0012\u0002\b\u0003`\u00130\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0014\u001a\u00020\u0015X\u0090\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019¨\u0006)"}, d2 = {"Lni/shikatu/kotlinx/serialization/modules/SerialModuleImpl;", "Lni/shikatu/kotlinx/serialization/modules/SerializersModule;", "class2ContextualFactory", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/reflect/KClass;", "Lni/shikatu/kotlinx/serialization/modules/ContextualProvider;", "polyBase2Serializers", "Lni/shikatu/kotlinx/serialization/KSerializer;", "polyBase2DefaultSerializerProvider", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "Lni/shikatu/kotlinx/serialization/modules/PolymorphicSerializerProvider;", "polyBase2NamedSerializers", _UrlKt.FRAGMENT_ENCODE_SET, "polyBase2DefaultDeserializerProvider", "Lni/shikatu/kotlin/ParameterName;", "name", "className", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "Lni/shikatu/kotlinx/serialization/modules/PolymorphicDeserializerProvider;", "hasInterfaceContextualSerializers", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Z)V", "getHasInterfaceContextualSerializers$kotlinx_serialization_core", "()Z", "getPolymorphic", "T", _UrlKt.FRAGMENT_ENCODE_SET, "baseClass", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "serializedClassName", "getContextual", "kClass", "typeArgumentsSerializers", _UrlKt.FRAGMENT_ENCODE_SET, "dumpTo", _UrlKt.FRAGMENT_ENCODE_SET, "collector", "Lni/shikatu/kotlinx/serialization/modules/SerializersModuleCollector;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SerialModuleImpl extends SerializersModule {
    private final Map<KClass<?>, ContextualProvider> class2ContextualFactory;
    private final boolean hasInterfaceContextualSerializers;
    private final Map<KClass<?>, Function1<String, DeserializationStrategy<?>>> polyBase2DefaultDeserializerProvider;
    private final Map<KClass<?>, Function1<?, SerializationStrategy<?>>> polyBase2DefaultSerializerProvider;
    private final Map<KClass<?>, Map<String, KSerializer<?>>> polyBase2NamedSerializers;
    public final Map<KClass<?>, Map<KClass<?>, KSerializer<?>>> polyBase2Serializers;

    public SerialModuleImpl(Map<KClass<?>, ? extends ContextualProvider> map, Map<KClass<?>, ? extends Map<KClass<?>, ? extends KSerializer<?>>> map2, Map<KClass<?>, ? extends Function1<?, ? extends SerializationStrategy<?>>> map3, Map<KClass<?>, ? extends Map<String, ? extends KSerializer<?>>> map4, Map<KClass<?>, ? extends Function1<? super String, ? extends DeserializationStrategy<?>>> map5, boolean hasInterfaceContextualSerializers) {
        super(null);
        Intrinsics.checkNotNullParameter(map, "class2ContextualFactory");
        Intrinsics.checkNotNullParameter(map2, "polyBase2Serializers");
        Intrinsics.checkNotNullParameter(map3, "polyBase2DefaultSerializerProvider");
        Intrinsics.checkNotNullParameter(map4, "polyBase2NamedSerializers");
        Intrinsics.checkNotNullParameter(map5, "polyBase2DefaultDeserializerProvider");
        this.class2ContextualFactory = map;
        this.polyBase2Serializers = map2;
        this.polyBase2DefaultSerializerProvider = map3;
        this.polyBase2NamedSerializers = map4;
        this.polyBase2DefaultDeserializerProvider = map5;
        this.hasInterfaceContextualSerializers = hasInterfaceContextualSerializers;
    }

    @Override
    public boolean getHasInterfaceContextualSerializers$kotlinx_serialization_core() {
        return this.hasInterfaceContextualSerializers;
    }

    @Override
    public <T> SerializationStrategy<T> getPolymorphic(KClass<? super T> kClass, T t) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(t, "value");
        if (!kClass.isInstance(t)) {
            return null;
        }
        Map<KClass<?>, KSerializer<?>> map = this.polyBase2Serializers.get(kClass);
        SerializationStrategy serializationStrategy = map != null ? (KSerializer) map.get(Reflection.getOrCreateKotlinClass(t.getClass())) : null;
        SerializationStrategy registered = serializationStrategy instanceof SerializationStrategy ? serializationStrategy : null;
        if (registered != null) {
            return registered;
        }
        Function1<?, SerializationStrategy<?>> function1 = this.polyBase2DefaultSerializerProvider.get(kClass);
        Function1<?, SerializationStrategy<?>> function2 = TypeIntrinsics.isFunctionOfArity(function1, 1) ? function1 : null;
        if (function2 != null) {
            return (SerializationStrategy) function2.invoke(t);
        }
        return null;
    }

    @Override
    public <T> DeserializationStrategy<T> getPolymorphic(KClass<? super T> kClass, String serializedClassName) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Map<String, KSerializer<?>> map = this.polyBase2NamedSerializers.get(kClass);
        KSerializer<?> kSerializer = map != null ? map.get(serializedClassName) : null;
        if (!(kSerializer instanceof KSerializer)) {
            kSerializer = null;
        }
        if (kSerializer != null) {
            return kSerializer;
        }
        Function1<String, DeserializationStrategy<?>> function1 = this.polyBase2DefaultDeserializerProvider.get(kClass);
        Function1<String, DeserializationStrategy<?>> function2 = TypeIntrinsics.isFunctionOfArity(function1, 1) ? function1 : null;
        if (function2 != null) {
            return (DeserializationStrategy) function2.invoke(serializedClassName);
        }
        return null;
    }

    @Override
    public <T> KSerializer<T> getContextual(KClass<T> kClass, List<? extends KSerializer<?>> list) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(list, "typeArgumentsSerializers");
        ContextualProvider contextualProvider = this.class2ContextualFactory.get(kClass);
        KSerializer<?> kSerializerInvoke = contextualProvider != null ? contextualProvider.invoke(list) : null;
        if (kSerializerInvoke instanceof KSerializer) {
            return (KSerializer<T>) kSerializerInvoke;
        }
        return null;
    }

    @Override
    public void dumpTo(SerializersModuleCollector collector) {
        Intrinsics.checkNotNullParameter(collector, "collector");
        for (Map.Entry<KClass<?>, ContextualProvider> entry : this.class2ContextualFactory.entrySet()) {
            KClass<?> key = entry.getKey();
            ContextualProvider serial = entry.getValue();
            if (serial instanceof ContextualProvider.Argless) {
                Intrinsics.checkNotNull(key, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                KSerializer<?> serializer = ((ContextualProvider.Argless) serial).getSerializer();
                Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<kotlin.Any>");
                collector.contextual(key, serializer);
            } else {
                if (!(serial instanceof ContextualProvider.WithTypeArguments)) {
                    throw new NoWhenBranchMatchedException();
                }
                collector.contextual(key, ((ContextualProvider.WithTypeArguments) serial).getProvider());
            }
        }
        Map<KClass<?>, Map<KClass<?>, KSerializer<?>>> map = this.polyBase2Serializers;
        int $i$f$forEach = 0;
        for (Map.Entry<KClass<?>, Map<KClass<?>, KSerializer<?>>> entry2 : map.entrySet()) {
            KClass<?> key2 = entry2.getKey();
            for (Map.Entry<KClass<?>, KSerializer<?>> entry3 : entry2.getValue().entrySet()) {
                KClass<?> key3 = entry3.getKey();
                KSerializer<?> value = entry3.getValue();
                Intrinsics.checkNotNull(key2, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                Intrinsics.checkNotNull(key3, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
                Intrinsics.checkNotNull(value, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
                collector.polymorphic(key2, key3, value);
                map = map;
                $i$f$forEach = $i$f$forEach;
            }
        }
        for (Map.Entry<KClass<?>, Function1<?, SerializationStrategy<?>>> entry4 : this.polyBase2DefaultSerializerProvider.entrySet()) {
            KClass<?> key4 = entry4.getKey();
            Function1<?, SerializationStrategy<?>> value2 = entry4.getValue();
            Intrinsics.checkNotNull(key4, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            Intrinsics.checkNotNull(value2, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"value\")] kotlin.Any, kotlinx.serialization.SerializationStrategy<kotlin.Any>?>");
            collector.polymorphicDefaultSerializer(key4, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(value2, 1));
        }
        for (Map.Entry<KClass<?>, Function1<String, DeserializationStrategy<?>>> entry5 : this.polyBase2DefaultDeserializerProvider.entrySet()) {
            KClass<?> key5 = entry5.getKey();
            Function1<String, DeserializationStrategy<?>> value3 = entry5.getValue();
            Intrinsics.checkNotNull(key5, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            Intrinsics.checkNotNull(value3, "null cannot be cast to non-null type kotlin.Function1<@[ParameterName(name = \"className\")] kotlin.String?, kotlinx.serialization.DeserializationStrategy<kotlin.Any>?>");
            collector.polymorphicDefaultDeserializer(key5, (Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(value3, 1));
        }
    }
}
