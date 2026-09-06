package ni.shikatu.kotlinx.serialization.modules;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a0\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086\u0080\u0004\u001a$\u0010\u0000\u001a\u00020\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086\u0088\u0004\u001a&\u0010\b\u001a\u00020\u00012\u0017\u0010\t\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\u0086\u0088\u0004ø\u0001\u0000\u001a\n\u0010\u000e\u001a\u00020\u0001H\u0086\u0080\u0004\u001a(\u0010\u000f\u001a\u00020\f\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003*\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0007H\u0086\u0088\u0004\u001a\\\u0010\u0010\u001a\u00020\f\"\b\b\u0000\u0010\u0011*\u00020\u0003*\u00020\u000b2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00110\u00052\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u0002H\u0011\u0018\u00010\u00072\u001f\b\u0002\u0010\t\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00110\u0014\u0012\u0004\u0012\u00020\f0\n¢\u0006\u0002\b\rH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0015"}, d2 = {"serializersModuleOf", "Lni/shikatu/kotlinx/serialization/modules/SerializersModule;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "kClass", "Lni/shikatu/kotlin/reflect/KClass;", "serializer", "Lni/shikatu/kotlinx/serialization/KSerializer;", "SerializersModule", "builderAction", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlinx/serialization/modules/SerializersModuleBuilder;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ExtensionFunctionType;", "EmptySerializersModule", "contextual", "polymorphic", "Base", "baseClass", "baseSerializer", "Lni/shikatu/kotlinx/serialization/modules/PolymorphicModuleBuilder;", "ni.shikatu.kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SerializersModuleBuildersKt {
    public static final <T> SerializersModule serializersModuleOf(KClass<T> kClass, KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        SerializersModuleBuilder builder$iv = new SerializersModuleBuilder();
        builder$iv.contextual(kClass, kSerializer);
        return builder$iv.build();
    }

    public static final  <T> SerializersModule serializersModuleOf(KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        Intrinsics.reifiedOperationMarker(4, "T");
        return serializersModuleOf(Reflection.getOrCreateKotlinClass(Object.class), kSerializer);
    }

    public static final SerializersModule SerializersModule(Function1<? super SerializersModuleBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        SerializersModuleBuilder builder = new SerializersModuleBuilder();
        function1.invoke(builder);
        return builder.build();
    }

    public static final SerializersModule EmptySerializersModule() {
        return SerializersModuleKt.getEmptySerializersModule();
    }

    public static final  <T> void contextual(SerializersModuleBuilder $this$contextual, KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter($this$contextual, "<this>");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        Intrinsics.reifiedOperationMarker(4, "T");
        $this$contextual.contextual(Reflection.getOrCreateKotlinClass(Object.class), kSerializer);
    }

    public static  void polymorphic$default(SerializersModuleBuilder $this$polymorphic_u24default, KClass baseClass, KSerializer baseSerializer, Function1 builderAction, int i, Object obj) {
        if ((i & 2) != 0) {
            baseSerializer = null;
        }
        if ((i & 4) != 0) {
            Function1 builderAction2 = new Function1<PolymorphicModuleBuilder<? super Base>, Unit>() {
                @Override
                public /* bridge */  Unit invoke(Object p1) {
                    invoke((PolymorphicModuleBuilder) p1);
                    return Unit.INSTANCE;
                }

                public final void invoke(PolymorphicModuleBuilder<? super Base> polymorphicModuleBuilder) {
                    Intrinsics.checkNotNullParameter(polymorphicModuleBuilder, "<this>");
                }
            };
            builderAction = builderAction2;
        }
        Intrinsics.checkNotNullParameter($this$polymorphic_u24default, "<this>");
        Intrinsics.checkNotNullParameter(baseClass, "baseClass");
        Intrinsics.checkNotNullParameter(builderAction, "builderAction");
        PolymorphicModuleBuilder builder = new PolymorphicModuleBuilder(baseClass, baseSerializer);
        builderAction.invoke(builder);
        builder.buildTo($this$polymorphic_u24default);
    }

    public static final <Base> void polymorphic(SerializersModuleBuilder $this$polymorphic, KClass<Base> kClass, KSerializer<Base> kSerializer, Function1<? super PolymorphicModuleBuilder<? super Base>, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$polymorphic, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        PolymorphicModuleBuilder builder = new PolymorphicModuleBuilder(kClass, kSerializer);
        function1.invoke(builder);
        builder.buildTo($this$polymorphic);
    }
}
