package ni.shikatu.kotlinx.serialization.modules;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.collections.MapsKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.SerializationStrategy;
import ni.shikatu.kotlinx.serialization.internal.PlatformKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001B\t\bA¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0018\u001a\u00020\u0019\"\b\b\u0000\u0010\u001a*\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00062\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001a0\tH\u0096\u0080\u0004JS\u0010\u0018\u001a\u00020\u0019\"\b\b\u0000\u0010\u001a*\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00062/\u0010\u001e\u001a+\u0012\u001d\u0012\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u001f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b( \u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u000bH\u0096\u0080\u0004JH\u0010!\u001a\u00020\u0019\"\b\b\u0000\u0010\"*\u00020\u001b\"\b\b\u0001\u0010#*\u0002H\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\"0\u00062\f\u0010%\u001a\b\u0012\u0004\u0012\u0002H#0\u00062\f\u0010&\u001a\b\u0012\u0004\u0012\u0002H#0\tH\u0096\u0080\u0004JM\u0010'\u001a\u00020\u0019\"\b\b\u0000\u0010\"*\u00020\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\"0\u00062)\u0010(\u001a%\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b()\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\"\u0018\u00010\f0\u000bH\u0096\u0080\u0004JO\u0010*\u001a\u00020\u0019\"\b\b\u0000\u0010\"*\u00020\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\"0\u00062+\u0010+\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\"\u0018\u00010\u00140\u000bH\u0096\u0080\u0004J\u0012\u0010,\u001a\u00020\u00192\u0006\u0010-\u001a\u00020.H\u0086\u0080\u0004J4\u0010/\u001a\u00020\u0019\"\b\b\u0000\u0010\u001a*\u00020\u001b2\f\u00100\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u00062\u0006\u0010\u001e\u001a\u00020\u00072\b\b\u0002\u00101\u001a\u00020\u0017H\u0081\u0080\u0004JU\u00102\u001a\u00020\u0019\"\b\b\u0000\u0010\"*\u00020\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\"0\u00062)\u0010(\u001a%\u0012\u0013\u0012\u0011H\"¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b()\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\"\u0018\u00010\f0\u000b2\u0006\u00101\u001a\u00020\u0017H\u0081\u0080\u0004JW\u00103\u001a\u00020\u0019\"\b\b\u0000\u0010\"*\u00020\u001b2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\"0\u00062+\u0010+\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\"\u0018\u00010\u00140\u000b2\u0006\u00101\u001a\u00020\u0017H\u0081\u0080\u0004JR\u00104\u001a\u00020\u0019\"\b\b\u0000\u0010\"*\u00020\u001b\"\b\b\u0001\u0010#*\u0002H\"2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\"0\u00062\f\u00105\u001a\b\u0012\u0004\u0012\u0002H#0\u00062\f\u00106\u001a\b\u0012\u0004\u0012\u0002H#0\t2\b\b\u0002\u00101\u001a\u00020\u0017H\u0081\u0080\u0004J\n\u00107\u001a\u00020.H\u0081\u0080\u0004R\u001f\u0010\u0004\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0004\u0012\u00020\u00070\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R3\u0010\b\u001a&\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0018\u0012\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00050\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R7\u0010\n\u001a*\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u001c\u0012\u001a\u0012\u0002\b\u0003\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\f0\u000bj\u0006\u0012\u0002\b\u0003`\r0\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R/\u0010\u000e\u001a\"\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u00020\u000f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\t0\u00050\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000RJ\u0010\u0010\u001a=\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0006\u0012/\u0012-\u0012\u0015\u0012\u0013\u0018\u00010\u000f¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00140\u000bj\u0006\u0012\u0002\b\u0003`\u00150\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0016\u001a\u00020\u0017X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u00068"}, d2 = {"Lni/shikatu/kotlinx/serialization/modules/SerializersModuleBuilder;", "Lni/shikatu/kotlinx/serialization/modules/SerializersModuleCollector;", "<init>", "()V", "class2ContextualProvider", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/reflect/KClass;", "Lni/shikatu/kotlinx/serialization/modules/ContextualProvider;", "polyBase2Serializers", "Lni/shikatu/kotlinx/serialization/KSerializer;", "polyBase2DefaultSerializerProvider", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "Lni/shikatu/kotlinx/serialization/modules/PolymorphicSerializerProvider;", "polyBase2NamedSerializers", _UrlKt.FRAGMENT_ENCODE_SET, "polyBase2DefaultDeserializerProvider", "Lni/shikatu/kotlin/ParameterName;", "name", "className", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "Lni/shikatu/kotlinx/serialization/modules/PolymorphicDeserializerProvider;", "hasInterfaceContextualSerializers", _UrlKt.FRAGMENT_ENCODE_SET, "contextual", _UrlKt.FRAGMENT_ENCODE_SET, "T", _UrlKt.FRAGMENT_ENCODE_SET, "kClass", "serializer", "provider", _UrlKt.FRAGMENT_ENCODE_SET, "typeArgumentsSerializers", "polymorphic", "Base", "Sub", "baseClass", "actualClass", "actualSerializer", "polymorphicDefaultSerializer", "defaultSerializerProvider", "value", "polymorphicDefaultDeserializer", "defaultDeserializerProvider", "include", "module", "Lni/shikatu/kotlinx/serialization/modules/SerializersModule;", "registerSerializer", "forClass", "allowOverwrite", "registerDefaultPolymorphicSerializer", "registerDefaultPolymorphicDeserializer", "registerPolymorphicSerializer", "concreteClass", "concreteSerializer", "build", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SerializersModuleBuilder implements SerializersModuleCollector {
    private boolean hasInterfaceContextualSerializers;
    private final Map<KClass<?>, ContextualProvider> class2ContextualProvider = new HashMap();
    private final Map<KClass<?>, Map<KClass<?>, KSerializer<?>>> polyBase2Serializers = new HashMap();
    private final Map<KClass<?>, Function1<?, SerializationStrategy<?>>> polyBase2DefaultSerializerProvider = new HashMap();
    private final Map<KClass<?>, Map<String, KSerializer<?>>> polyBase2NamedSerializers = new HashMap();
    private final Map<KClass<?>, Function1<String, DeserializationStrategy<?>>> polyBase2DefaultDeserializerProvider = new HashMap();

    @Override
    public <T> void contextual(KClass<T> kClass, KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        registerSerializer$default(this, kClass, new ContextualProvider.Argless(kSerializer), false, 4, null);
    }

    @Override
    public <T> void contextual(KClass<T> kClass, Function1<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> function1) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(function1, "provider");
        registerSerializer$default(this, kClass, new ContextualProvider.WithTypeArguments(function1), false, 4, null);
    }

    @Override
    public <Base, Sub extends Base> void polymorphic(KClass<Base> kClass, KClass<Sub> kClass2, KSerializer<Sub> kSerializer) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(kClass2, "actualClass");
        Intrinsics.checkNotNullParameter(kSerializer, "actualSerializer");
        registerPolymorphicSerializer$default(this, kClass, kClass2, kSerializer, false, 8, null);
    }

    @Override
    public <Base> void polymorphicDefaultSerializer(KClass<Base> kClass, Function1<? super Base, ? extends SerializationStrategy<? super Base>> function1) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(function1, "defaultSerializerProvider");
        registerDefaultPolymorphicSerializer(kClass, function1, false);
    }

    @Override
    public <Base> void polymorphicDefaultDeserializer(KClass<Base> kClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(function1, "defaultDeserializerProvider");
        registerDefaultPolymorphicDeserializer(kClass, function1, false);
    }

    public final void include(SerializersModule module) {
        Intrinsics.checkNotNullParameter(module, "module");
        module.dumpTo(this);
    }

    public static  void registerSerializer$default(SerializersModuleBuilder serializersModuleBuilder, KClass kClass, ContextualProvider contextualProvider, boolean z, int i, Object obj) {
        if ((i & 4) != 0) {
            z = false;
        }
        serializersModuleBuilder.registerSerializer(kClass, contextualProvider, z);
    }

    public final <T> void registerSerializer(KClass<T> kClass, ContextualProvider provider, boolean allowOverwrite) {
        ContextualProvider previous;
        Intrinsics.checkNotNullParameter(kClass, "forClass");
        Intrinsics.checkNotNullParameter(provider, "provider");
        if (!allowOverwrite && (previous = this.class2ContextualProvider.get(kClass)) != null && !Intrinsics.areEqual(previous, provider)) {
            throw new SerializerAlreadyRegisteredException("Contextual serializer or serializer provider for " + kClass + " already registered in this module");
        }
        this.class2ContextualProvider.put(kClass, provider);
        if (PlatformKt.isInterface(kClass)) {
            this.hasInterfaceContextualSerializers = true;
        }
    }

    public final <Base> void registerDefaultPolymorphicSerializer(KClass<Base> kClass, Function1<? super Base, ? extends SerializationStrategy<? super Base>> function1, boolean allowOverwrite) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(function1, "defaultSerializerProvider");
        Function1<?, SerializationStrategy<?>> function2 = this.polyBase2DefaultSerializerProvider.get(kClass);
        if (function2 != null && !Intrinsics.areEqual(function2, function1) && !allowOverwrite) {
            throw new IllegalArgumentException("Default serializers provider for " + kClass + " is already registered: " + function2);
        }
        this.polyBase2DefaultSerializerProvider.put(kClass, (Function1) function1);
    }

    public final <Base> void registerDefaultPolymorphicDeserializer(KClass<Base> kClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1, boolean allowOverwrite) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(function1, "defaultDeserializerProvider");
        Function1<String, DeserializationStrategy<?>> function2 = this.polyBase2DefaultDeserializerProvider.get(kClass);
        if (function2 != null && !Intrinsics.areEqual(function2, function1) && !allowOverwrite) {
            throw new IllegalArgumentException("Default deserializers provider for " + kClass + " is already registered: " + function2);
        }
        this.polyBase2DefaultDeserializerProvider.put(kClass, (Function1) function1);
    }

    public static  void registerPolymorphicSerializer$default(SerializersModuleBuilder serializersModuleBuilder, KClass kClass, KClass kClass2, KSerializer kSerializer, boolean z, int i, Object obj) {
        if ((i & 8) != 0) {
            z = false;
        }
        serializersModuleBuilder.registerPolymorphicSerializer(kClass, kClass2, kSerializer, z);
    }

    public final <Base, Sub extends Base> void registerPolymorphicSerializer(KClass<Base> kClass, KClass<Sub> kClass2, KSerializer<Sub> kSerializer, boolean allowOverwrite) {
        Map<KClass<?>, KSerializer<?>> map;
        Map<String, KSerializer<?>> map2;
        Object next;
        KClass previousClass;
        Map.Entry it;
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(kClass2, "concreteClass");
        Intrinsics.checkNotNullParameter(kSerializer, "concreteSerializer");
        String name = kSerializer.getDescriptor().getSerialName();
        Map<KClass<?>, Map<KClass<?>, KSerializer<?>>> map3 = this.polyBase2Serializers;
        Map<KClass<?>, KSerializer<?>> map4 = map3.get(kClass);
        if (map4 == null) {
            map = new HashMap<>();
            map3.put(kClass, map);
        } else {
            map = map4;
        }
        Map<KClass<?>, KSerializer<?>> map5 = map;
        Map<KClass<?>, Map<String, KSerializer<?>>> map6 = this.polyBase2NamedSerializers;
        Map<String, KSerializer<?>> map7 = map6.get(kClass);
        if (map7 == null) {
            map2 = new HashMap<>();
            map6.put(kClass, map2);
        } else {
            map2 = map7;
        }
        Map<String, KSerializer<?>> map8 = map2;
        KSerializer<?> kSerializer2 = map5.get(kClass2);
        if (kSerializer2 != null && !Intrinsics.areEqual(kSerializer2, kSerializer)) {
            if (!allowOverwrite) {
                throw new SerializerAlreadyRegisteredException(kClass, kClass2);
            }
            map8.remove(kSerializer2.getDescriptor().getSerialName());
        }
        KSerializer<?> kSerializer3 = map8.get(name);
        if (kSerializer3 != null && !Intrinsics.areEqual(kSerializer3, kSerializer)) {
            Iterator it2 = MapsKt.asSequence(map5).iterator();
            do {
                if (!it2.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it2.next();
                    it = (Map.Entry) next;
                }
            } while (!(it.getValue() == kSerializer3));
            Map.Entry entry = (Map.Entry) next;
            if (entry == null || (previousClass = (KClass) entry.getKey()) == null) {
                throw new IllegalStateException(("Name " + name + " is registered in the module but no Kotlin class is associated with it.").toString());
            }
            if (!allowOverwrite) {
                throw new IllegalArgumentException("Multiple polymorphic serializers in a scope of '" + kClass + "' have the same serial name '" + name + "': " + kSerializer + " for '" + kClass2 + "' and " + kSerializer3 + " for '" + previousClass + '\'');
            }
            map5.remove(previousClass);
        }
        map5.put(kClass2, kSerializer);
        map8.put(name, kSerializer);
    }

    public final SerializersModule build() {
        return new SerialModuleImpl(this.class2ContextualProvider, this.polyBase2Serializers, this.polyBase2DefaultSerializerProvider, this.polyBase2NamedSerializers, this.polyBase2DefaultDeserializerProvider, this.hasInterfaceContextualSerializers);
    }
}
