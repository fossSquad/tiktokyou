package ni.shikatu.kotlinx.serialization.modules;

import java.util.List;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.SerializationStrategy;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J0\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00040\bH\u0096\u0080\u0004JS\u0010\u0002\u001a\u00020\u0003\"\b\b\u0000\u0010\u0004*\u00020\u00012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00040\u00062/\u0010\t\u001a+\u0012\u001d\u0012\u001b\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\u000b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b0\nH¦\u0080\u0004JH\u0010\u000f\u001a\u00020\u0003\"\b\b\u0000\u0010\u0010*\u00020\u0001\"\b\b\u0001\u0010\u0011*\u0002H\u00102\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00062\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00062\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00110\bH¦\u0080\u0004JM\u0010\u0015\u001a\u00020\u0003\"\b\b\u0000\u0010\u0010*\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00062)\u0010\u0016\u001a%\u0012\u0013\u0012\u0011H\u0010¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u0017\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u00180\nH¦\u0080\u0004JO\u0010\u0019\u001a\u00020\u0003\"\b\b\u0000\u0010\u0010*\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00062+\u0010\u001a\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001c\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u001d0\nH¦\u0080\u0004JO\u0010\u001e\u001a\u00020\u0003\"\b\b\u0000\u0010\u0010*\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00100\u00062+\u0010\u001a\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u001c\u0012\f\u0012\n\u0012\u0004\u0012\u0002H\u0010\u0018\u00010\u001d0\nH\u0097\u0080\u0004¨\u0006\u001fÀ\u0006\u0003"}, d2 = {"Lni/shikatu/kotlinx/serialization/modules/SerializersModuleCollector;", _UrlKt.FRAGMENT_ENCODE_SET, "contextual", _UrlKt.FRAGMENT_ENCODE_SET, "T", "kClass", "Lni/shikatu/kotlin/reflect/KClass;", "serializer", "Lni/shikatu/kotlinx/serialization/KSerializer;", "provider", "Lni/shikatu/kotlin/Function1;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ParameterName;", "name", "typeArgumentsSerializers", "polymorphic", "Base", "Sub", "baseClass", "actualClass", "actualSerializer", "polymorphicDefaultSerializer", "defaultSerializerProvider", "value", "Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "polymorphicDefaultDeserializer", "defaultDeserializerProvider", _UrlKt.FRAGMENT_ENCODE_SET, "className", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "polymorphicDefault", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ExperimentalSerializationApi
public interface SerializersModuleCollector {
    <T> void contextual(KClass<T> kClass, Function1<? super List<? extends KSerializer<?>>, ? extends KSerializer<?>> function1);

    <Base, Sub extends Base> void polymorphic(KClass<Base> kClass, KClass<Sub> kClass2, KSerializer<Sub> kSerializer);

    <Base> void polymorphicDefaultDeserializer(KClass<Base> kClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1);

    <Base> void polymorphicDefaultSerializer(KClass<Base> kClass, Function1<? super Base, ? extends SerializationStrategy<? super Base>> function1);

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static <T> void contextual(SerializersModuleCollector $this, KClass<T> kClass, KSerializer<T> kSerializer) {
            Intrinsics.checkNotNullParameter(kClass, "kClass");
            Intrinsics.checkNotNullParameter(kSerializer, "serializer");
            SerializersModuleCollector.super.contextual(kClass, kSerializer);
        }

        @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of function with more precise name: polymorphicDefaultDeserializer", replaceWith = @ReplaceWith(expression = "polymorphicDefaultDeserializer(baseClass, defaultDeserializerProvider)", imports = {}))
        @Deprecated
        public static <Base> void polymorphicDefault(SerializersModuleCollector $this, KClass<Base> kClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1) {
            Intrinsics.checkNotNullParameter(kClass, "baseClass");
            Intrinsics.checkNotNullParameter(function1, "defaultDeserializerProvider");
            SerializersModuleCollector.super.polymorphicDefault(kClass, function1);
        }
    }

    static KSerializer contextual$lambda$0(KSerializer $serializer, List it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return $serializer;
    }

    default <T> void contextual(KClass<T> kClass, final KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        contextual(kClass, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return SerializersModuleCollector.contextual$lambda$0(kSerializer, (List) obj);
            }
        });
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of function with more precise name: polymorphicDefaultDeserializer", replaceWith = @ReplaceWith(expression = "polymorphicDefaultDeserializer(baseClass, defaultDeserializerProvider)", imports = {}))
    default <Base> void polymorphicDefault(KClass<Base> kClass, Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(function1, "defaultDeserializerProvider");
        polymorphicDefaultDeserializer(kClass, function1);
    }
}
