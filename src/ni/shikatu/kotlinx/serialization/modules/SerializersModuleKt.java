package ni.shikatu.kotlinx.serialization.modules;

import java.util.List;
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
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0006\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\u0082\u0004\u001a\u0016\u0010\b\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u0001H\u0086\u0084\u0004\"\u001d\u0010\u0000\u001a\u00020\u00018\u0006X\u0087\u0084\b¢\u0006\u000e\n\u0000\u0012\u0004\b\u0002\u0010\u0003\u001a\u0004\b\u0004\u0010\u0005*\\\b\u0000\u0010\t\u001a\u0004\b\u0000\u0010\n\"'\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\u00100\u000b2'\u0012\u0015\u0012\u0013\u0018\u00010\f¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000f\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\u00100\u000b*X\b\u0000\u0010\u0011\u001a\u0004\b\u0000\u0010\n\"%\u0012\u0013\u0012\u0011H\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\u00130\u000b2%\u0012\u0013\u0012\u0011H\n¢\u0006\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u0012\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\n\u0018\u00010\u00130\u000b¨\u0006\u0014"}, d2 = {"EmptySerializersModule", "Lni/shikatu/kotlinx/serialization/modules/SerializersModule;", "getEmptySerializersModule$annotations", "()V", "getEmptySerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "plus", "other", "overwriteWith", "PolymorphicDeserializerProvider", "Base", "Lni/shikatu/kotlin/Function1;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ParameterName;", "name", "className", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "PolymorphicSerializerProvider", "value", "Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "ni.shikatu.kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SerializersModuleKt {
    private static final SerializersModule EmptySerializersModule = new SerialModuleImpl(MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap(), MapsKt.emptyMap(), false);

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in the favour of 'EmptySerializersModule()'", replaceWith = @ReplaceWith(expression = "EmptySerializersModule()", imports = {}))
    public static  void getEmptySerializersModule$annotations() {
    }

    public static final SerializersModule getEmptySerializersModule() {
        return EmptySerializersModule;
    }

    public static final SerializersModule plus(SerializersModule $this$plus, SerializersModule other) {
        Intrinsics.checkNotNullParameter($this$plus, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        SerializersModuleBuilder builder$iv = new SerializersModuleBuilder();
        builder$iv.include($this$plus);
        builder$iv.include(other);
        return builder$iv.build();
    }

    public static final SerializersModule overwriteWith(SerializersModule $this$overwriteWith, SerializersModule other) {
        Intrinsics.checkNotNullParameter($this$overwriteWith, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        final SerializersModuleBuilder builder$iv = new SerializersModuleBuilder();
        builder$iv.include($this$overwriteWith);
        other.dumpTo(new SerializersModuleCollector() {
            @Override
            @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of function with more precise name: polymorphicDefaultDeserializer", replaceWith = @ReplaceWith(expression = "polymorphicDefaultDeserializer(baseClass, defaultDeserializerProvider)", imports = {}))
            public /* bridge */ <Base> void polymorphicDefault(KClass<Base> kClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1) {
                super.polymorphicDefault(kClass, function1);
            }

            @Override
            public <T> void contextual(KClass<T> kClass, KSerializer<T> kSerializer) {
                Intrinsics.checkNotNullParameter(kClass, "kClass");
                Intrinsics.checkNotNullParameter(kSerializer, "serializer");
                builder$iv.registerSerializer(kClass, new ContextualProvider.Argless(kSerializer), true);
            }

            @Override
            public <T> void contextual(KClass<T> kClass, Function1<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> function1) {
                Intrinsics.checkNotNullParameter(kClass, "kClass");
                Intrinsics.checkNotNullParameter(function1, "provider");
                builder$iv.registerSerializer(kClass, new ContextualProvider.WithTypeArguments(function1), true);
            }

            @Override
            public <Base, Sub extends Base> void polymorphic(KClass<Base> kClass, KClass<Sub> kClass2, KSerializer<Sub> kSerializer) {
                Intrinsics.checkNotNullParameter(kClass, "baseClass");
                Intrinsics.checkNotNullParameter(kClass2, "actualClass");
                Intrinsics.checkNotNullParameter(kSerializer, "actualSerializer");
                builder$iv.registerPolymorphicSerializer(kClass, kClass2, kSerializer, true);
            }

            @Override
            public <Base> void polymorphicDefaultSerializer(KClass<Base> kClass, Function1<? super Base, ? extends SerializationStrategy<? super Base>> function1) {
                Intrinsics.checkNotNullParameter(kClass, "baseClass");
                Intrinsics.checkNotNullParameter(function1, "defaultSerializerProvider");
                builder$iv.registerDefaultPolymorphicSerializer(kClass, function1, true);
            }

            @Override
            public <Base> void polymorphicDefaultDeserializer(KClass<Base> kClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1) {
                Intrinsics.checkNotNullParameter(kClass, "baseClass");
                Intrinsics.checkNotNullParameter(function1, "defaultDeserializerProvider");
                builder$iv.registerDefaultPolymorphicDeserializer(kClass, function1, true);
            }
        });
        return builder$iv.build();
    }
}
