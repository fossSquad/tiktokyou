package ni.shikatu.kotlinx.serialization.descriptors;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.internal.SerialDescriptorForNullable;
import ni.shikatu.kotlinx.serialization.modules.SerialModuleImpl;
import ni.shikatu.kotlinx.serialization.modules.SerializersModule;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001a\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u0002*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0087\u0080\u0004\u001a\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\u000b*\u00020\b2\u0006\u0010\t\u001a\u00020\u0002H\u0087\u0080\u0004\u001a\u001a\u0010\f\u001a\u00020\u0002*\u00020\u00022\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u0001H\u0080\u0080\u0004\"%\u0010\u0000\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0001*\u00020\u00028FX\u0087\u0084\b¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000e"}, d2 = {"capturedKClass", "Lni/shikatu/kotlin/reflect/KClass;", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getCapturedKClass$annotations", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getCapturedKClass", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlin/reflect/KClass;", "getContextualDescriptor", "Lni/shikatu/kotlinx/serialization/modules/SerializersModule;", "descriptor", "getPolymorphicDescriptors", _UrlKt.FRAGMENT_ENCODE_SET, "withContext", "context", "ni.shikatu.kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ContextAwareKt {
    @ExperimentalSerializationApi
    public static  void getCapturedKClass$annotations(SerialDescriptor serialDescriptor) {
    }

    public static final KClass<?> getCapturedKClass(SerialDescriptor $this$capturedKClass) {
        Intrinsics.checkNotNullParameter($this$capturedKClass, "<this>");
        if ($this$capturedKClass instanceof ContextDescriptor) {
            return ((ContextDescriptor) $this$capturedKClass).kClass;
        }
        if ($this$capturedKClass instanceof SerialDescriptorForNullable) {
            return getCapturedKClass(((SerialDescriptorForNullable) $this$capturedKClass).getOriginal$kotlinx_serialization_core());
        }
        return null;
    }

    @ExperimentalSerializationApi
    public static final SerialDescriptor getContextualDescriptor(SerializersModule $this$getContextualDescriptor, SerialDescriptor descriptor) {
        KSerializer contextual$default;
        Intrinsics.checkNotNullParameter($this$getContextualDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        KClass<?> capturedKClass = getCapturedKClass(descriptor);
        if (capturedKClass == null || (contextual$default = SerializersModule.getContextual$default($this$getContextualDescriptor, capturedKClass, null, 2, null)) == null) {
            return null;
        }
        return contextual$default.getDescriptor();
    }

    @ExperimentalSerializationApi
    public static final List<SerialDescriptor> getPolymorphicDescriptors(SerializersModule $this$getPolymorphicDescriptors, SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter($this$getPolymorphicDescriptors, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        KClass<?> capturedKClass = getCapturedKClass(descriptor);
        if (capturedKClass == null) {
            return CollectionsKt.emptyList();
        }
        Map<KClass<?>, KSerializer<?>> map = ((SerialModuleImpl) $this$getPolymorphicDescriptors).polyBase2Serializers.get(capturedKClass);
        Iterable iterableValues = map != null ? map.values() : null;
        if (iterableValues == null) {
            iterableValues = CollectionsKt.emptyList();
        }
        Iterable $this$map$iv = iterableValues;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KSerializer it = (KSerializer) item$iv$iv;
            destination$iv$iv.add(it.getDescriptor());
        }
        return (List) destination$iv$iv;
    }

    public static final SerialDescriptor withContext(SerialDescriptor $this$withContext, KClass<?> kClass) {
        Intrinsics.checkNotNullParameter($this$withContext, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "context");
        return new ContextDescriptor($this$withContext, kClass);
    }
}
