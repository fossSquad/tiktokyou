package ni.shikatu.kotlinx.serialization.modules;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.MagicApiIntrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.reflect.KType;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.SerializersKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a8\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\n\b\u0001\u0010\u0004\u0018\u0001*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00040\u0007H\u0086\u0088\u0004\u001a8\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\n\b\u0001\u0010\u0004\u0018\u0001*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00052\f\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00040\tH\u0086\u0088\u0004\u001a*\u0010\n\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\n\b\u0001\u0010\u0004\u0018\u0001*\u0002H\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0087\u0088\u0004¨\u0006\u000b"}, d2 = {"subclass", _UrlKt.FRAGMENT_ENCODE_SET, "Base", _UrlKt.FRAGMENT_ENCODE_SET, "T", "Lni/shikatu/kotlinx/serialization/modules/PolymorphicModuleBuilder;", "serializer", "Lni/shikatu/kotlinx/serialization/KSerializer;", "clazz", "Lni/shikatu/kotlin/reflect/KClass;", "subclassesOfSealed", "ni.shikatu.kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PolymorphicModuleBuilderKt {
    public static final  <Base, T extends Base> void subclass(PolymorphicModuleBuilder<? super Base> polymorphicModuleBuilder, KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(polymorphicModuleBuilder, "<this>");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        Intrinsics.reifiedOperationMarker(4, "T");
        polymorphicModuleBuilder.subclass(Reflection.getOrCreateKotlinClass(Object.class), kSerializer);
    }

    public static final  <Base, T extends Base> void subclass(PolymorphicModuleBuilder<? super Base> polymorphicModuleBuilder, KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(polymorphicModuleBuilder, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.simple");
        polymorphicModuleBuilder.subclass(kClass, (KSerializer) SerializersKt.serializer((KType) null));
    }

    @ExperimentalSerializationApi
    public static final  <Base, T extends Base> void subclassesOfSealed(PolymorphicModuleBuilder<? super Base> polymorphicModuleBuilder) {
        Intrinsics.checkNotNullParameter(polymorphicModuleBuilder, "<this>");
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.simple");
        polymorphicModuleBuilder.subclassesOfSealed((KSerializer) SerializersKt.serializer((KType) null));
    }
}
