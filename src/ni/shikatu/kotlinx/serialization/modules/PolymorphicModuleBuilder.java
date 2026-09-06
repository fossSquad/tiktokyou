package ni.shikatu.kotlinx.serialization.modules;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.MagicApiIntrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.reflect.KType;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.SealedClassSerializer;
import ni.shikatu.kotlinx.serialization.SerializersKt;
import ni.shikatu.kotlinx.serialization.descriptors.PolymorphicKind;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u0000*\n\b\u0000\u0010\u0001 \u0000*\u00020\u00022\u00020\u0002B)\bA\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0016\u0010\u0010\u001a\u00020\u0011\"\n\b\u0001\u0010\u0012\u0018\u0001*\u00028\u0000H\u0087\u0088\u0004J\"\u0010\u0010\u001a\u00020\u0011\"\b\b\u0001\u0010\u0012*\u00028\u00002\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0006H\u0087\u0080\u0004J0\u0010\u0014\u001a\u00020\u0011\"\b\b\u0001\u0010\u0012*\u00028\u00002\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00042\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0006H\u0086\u0080\u0004J7\u0010\u0015\u001a\u00020\u00112+\u0010\f\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000f0\rH\u0086\u0080\u0004J7\u0010\u0019\u001a\u00020\u00112+\u0010\u001a\u001a'\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000f0\rH\u0087\u0080\u0004J\u0012\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u001c\u001a\u00020\u001dH\u0081\u0080\u0004R\u0015\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000R1\u0010\t\u001a$\u0012 \u0012\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00060\u000b0\nX\u0082\u0084\b¢\u0006\u0002\n\u0000R'\u0010\f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u000e\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000f\u0018\u00010\rX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lni/shikatu/kotlinx/serialization/modules/PolymorphicModuleBuilder;", "Base", _UrlKt.FRAGMENT_ENCODE_SET, "baseClass", "Lni/shikatu/kotlin/reflect/KClass;", "baseSerializer", "Lni/shikatu/kotlinx/serialization/KSerializer;", "<init>", "(Lkotlin/reflect/KClass;Lkotlinx/serialization/KSerializer;)V", "subclasses", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/Pair;", "defaultDeserializerProvider", "Lni/shikatu/kotlin/Function1;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "subclassesOfSealed", _UrlKt.FRAGMENT_ENCODE_SET, "T", "serializer", "subclass", "defaultDeserializer", "Lni/shikatu/kotlin/ParameterName;", "name", "className", "default", "defaultSerializerProvider", "buildTo", "builder", "Lni/shikatu/kotlinx/serialization/modules/SerializersModuleBuilder;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PolymorphicModuleBuilder<Base> {
    private final KClass<Base> baseClass;
    private final KSerializer<Base> baseSerializer;
    private Function1<? super String, ? extends DeserializationStrategy<? extends Base>> defaultDeserializerProvider;
    private final List<Pair<KClass<? extends Base>, KSerializer<? extends Base>>> subclasses;

    public PolymorphicModuleBuilder(KClass<Base> kClass, KSerializer<Base> kSerializer) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        this.baseClass = kClass;
        this.baseSerializer = kSerializer;
        this.subclasses = new ArrayList();
    }

    public  PolymorphicModuleBuilder(KClass kClass, KSerializer kSerializer, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kClass, (i & 2) != 0 ? null : kSerializer);
    }

    @ExperimentalSerializationApi
    public final  <T extends Base> void subclassesOfSealed() {
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.simple");
        subclassesOfSealed(SerializersKt.serializer((KType) null));
    }

    @ExperimentalSerializationApi
    public final <T extends Base> void subclassesOfSealed(KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        if (!(kSerializer instanceof SealedClassSerializer)) {
            throw new IllegalArgumentException("subclassesOfSealed only supports automatic adding of subclasses of sealed types with standard serializers.".toString());
        }
        for (Map.Entry entry : ((SealedClassSerializer) kSerializer).getClass2Serializer$kotlinx_serialization_core().entrySet()) {
            KClass<T> kClass = (KClass) entry.getKey();
            KSerializer<T> kSerializer2 = (KSerializer) entry.getValue();
            if (Intrinsics.areEqual(kSerializer2.getDescriptor().getKind(), PolymorphicKind.OPEN.INSTANCE)) {
                throw new IllegalArgumentException(("It is not possible to register subclasses (" + ((SealedClassSerializer) kSerializer).getDescriptor().getSerialName() + ") of sealed types when those subclasses themselves are (open) polymorphic, as this would represent an incomplete hierarchy.").toString());
            }
            Intrinsics.checkNotNull(kClass, "null cannot be cast to non-null type kotlin.reflect.KClass<T of kotlinx.serialization.modules.PolymorphicModuleBuilder.subclassesOfSealed>");
            Intrinsics.checkNotNull(kSerializer2, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.modules.PolymorphicModuleBuilder.subclassesOfSealed>");
            subclass(kClass, kSerializer2);
        }
    }

    public final <T extends Base> void subclass(KClass<T> kClass, KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kClass, "subclass");
        Intrinsics.checkNotNullParameter(kSerializer, "serializer");
        this.subclasses.add(TuplesKt.to(kClass, kSerializer));
    }

    public final void defaultDeserializer(Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1) {
        Intrinsics.checkNotNullParameter(function1, "defaultDeserializerProvider");
        if (!(this.defaultDeserializerProvider == null)) {
            throw new IllegalArgumentException(("Default deserializer provider is already registered for class " + this.baseClass + ": " + this.defaultDeserializerProvider).toString());
        }
        this.defaultDeserializerProvider = function1;
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Deprecated in favor of function with more precise name: defaultDeserializer", replaceWith = @ReplaceWith(expression = "defaultDeserializer(defaultSerializerProvider)", imports = {}))

    public final void m1589default(Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1) {
        Intrinsics.checkNotNullParameter(function1, "defaultSerializerProvider");
        defaultDeserializer(function1);
    }

    public final void buildTo(SerializersModuleBuilder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        if (this.baseSerializer != null) {
            SerializersModuleBuilder.registerPolymorphicSerializer$default(builder, this.baseClass, this.baseClass, this.baseSerializer, false, 8, null);
        }
        Iterable $this$forEach$iv = this.subclasses;
        for (Object element$iv : $this$forEach$iv) {
            Pair pair = (Pair) element$iv;
            KClass kclass = (KClass) pair.component1();
            KSerializer serializer = (KSerializer) pair.component2();
            KClass<Base> kClass = this.baseClass;
            Intrinsics.checkNotNull(kclass, "null cannot be cast to non-null type kotlin.reflect.KClass<Base of kotlinx.serialization.modules.PolymorphicModuleBuilder>");
            Intrinsics.checkNotNull(serializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
            SerializersModuleBuilder.registerPolymorphicSerializer$default(builder, kClass, kclass, serializer, false, 8, null);
        }
        Function1<? super String, ? extends DeserializationStrategy<? extends Base>> function1 = this.defaultDeserializerProvider;
        if (function1 != null) {
            builder.registerDefaultPolymorphicDeserializer(this.baseClass, function1, false);
        }
    }
}
