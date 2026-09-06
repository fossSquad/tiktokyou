package ni.shikatu.kotlinx.serialization.internal;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.reflect.KClassifier;
import ni.shikatu.kotlin.reflect.KType;
import ni.shikatu.kotlin.reflect.KTypeParameter;
import ni.shikatu.kotlin.reflect.KTypeProjection;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.SerializationException;
import ni.shikatu.kotlinx.serialization.SerializationStrategy;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0080\u0080\u0004\u001a!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005*\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u0080\u0080\u0004¢\u0006\u0002\u0010\t\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f*\u0006\u0012\u0002\b\u00030\u000bH\u0081\u0088\u0004\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\r\"\u0004\b\u0000\u0010\f*\u0006\u0012\u0002\b\u00030\rH\u0081\u0088\u0004\u001a\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000e\"\u0004\b\u0000\u0010\f*\u0006\u0012\u0002\b\u00030\u000eH\u0081\u0088\u0004\u001a\u0012\u0010\u000f\u001a\u00020\u0010*\u0006\u0012\u0002\b\u00030\u0011H\u0080\u0080\u0004\u001a\u0012\u0010\u0012\u001a\u00020\u0002*\u0006\u0012\u0002\b\u00030\u0011H\u0080\u0080\u0004\u001a\u0012\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0002H\u0080\u0080\u0004\u001a\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0011*\u00020\u0016H\u0080\u0080\u0004\u001a\u000e\u0010\u0017\u001a\u00020\u0016*\u00020\u0018H\u0080\u0080\u0004\u001a7\u0010\u0019\u001a\u00020\u001a\"\u0004\b\u0000\u0010\f\"\u0004\b\u0001\u0010\u001b*\b\u0012\u0004\u0012\u0002H\f0\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u0002H\u001b0\u001eH\u0080\u0088\u0004ø\u0001\u0000\"\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001f"}, d2 = {"cachedSerialNames", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "EMPTY_DESCRIPTOR_ARRAY", _UrlKt.FRAGMENT_ENCODE_SET, "[Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "compactArray", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/util/List;)[Lkotlinx/serialization/descriptors/SerialDescriptor;", "cast", "Lni/shikatu/kotlinx/serialization/KSerializer;", "T", "Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "serializerNotRegistered", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/reflect/KClass;", "notRegisteredMessage", "className", "kclass", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/reflect/KType;", "typeOrThrow", "Lni/shikatu/kotlin/reflect/KTypeProjection;", "elementsHashCodeBy", _UrlKt.FRAGMENT_ENCODE_SET, "K", _UrlKt.FRAGMENT_ENCODE_SET, "selector", "Lni/shikatu/kotlin/Function1;", "ni.shikatu.kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class Platform_commonKt {
    private static final SerialDescriptor[] EMPTY_DESCRIPTOR_ARRAY = new SerialDescriptor[0];

    public static final Set<String> cachedSerialNames(SerialDescriptor $this$cachedSerialNames) {
        Intrinsics.checkNotNullParameter($this$cachedSerialNames, "<this>");
        if ($this$cachedSerialNames instanceof CachedNames) {
            return ((CachedNames) $this$cachedSerialNames).getSerialNames();
        }
        HashSet result = new HashSet($this$cachedSerialNames.getElementsCount());
        int elementsCount = $this$cachedSerialNames.getElementsCount();
        for (int i = 0; i < elementsCount; i++) {
            result.add($this$cachedSerialNames.getElementName(i));
        }
        return result;
    }

    public static final SerialDescriptor[] compactArray(List<? extends SerialDescriptor> list) {
        List<? extends SerialDescriptor> list2 = list;
        Collection collection = !(list2 == null || list2.isEmpty()) ? list : null;
        if (collection != null) {
            Collection $this$toTypedArray$iv = collection;
            SerialDescriptor[] serialDescriptorArr = (SerialDescriptor[]) $this$toTypedArray$iv.toArray(new SerialDescriptor[0]);
            if (serialDescriptorArr != null) {
                return serialDescriptorArr;
            }
        }
        return EMPTY_DESCRIPTOR_ARRAY;
    }

    public static final <T> KSerializer<T> cast(KSerializer<?> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "<this>");
        return kSerializer;
    }

    public static final <T> SerializationStrategy<T> cast(SerializationStrategy<?> serializationStrategy) {
        Intrinsics.checkNotNullParameter(serializationStrategy, "<this>");
        return serializationStrategy;
    }

    public static final <T> DeserializationStrategy<T> cast(DeserializationStrategy<?> deserializationStrategy) {
        Intrinsics.checkNotNullParameter(deserializationStrategy, "<this>");
        return deserializationStrategy;
    }

    public static final Void serializerNotRegistered(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        throw new SerializationException(notRegisteredMessage(kClass));
    }

    public static final String notRegisteredMessage(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        String simpleName = kClass.getSimpleName();
        if (simpleName == null) {
            simpleName = "<local class name not available>";
        }
        return notRegisteredMessage(simpleName);
    }

    public static final String notRegisteredMessage(String className) {
        Intrinsics.checkNotNullParameter(className, "className");
        return "Serializer for class '" + className + "' is not found.\nPlease ensure that class is marked as '@Serializable' and that the serialization compiler plugin is applied.\n";
    }

    public static final KClass<Object> kclass(KType $this$kclass) {
        Intrinsics.checkNotNullParameter($this$kclass, "<this>");
        KClassifier t = $this$kclass.getClassifier();
        if (t instanceof KClass) {
            return (KClass) t;
        }
        if (t instanceof KTypeParameter) {
            throw new IllegalArgumentException("Captured type parameter " + t + " from generic non-reified function. Such functionality cannot be supported because " + t + " is erased, either specify serializer explicitly or make calling function inline with reified " + t + '.');
        }
        throw new IllegalArgumentException("Only KClass supported as classifier, got " + t);
    }

    public static final KType typeOrThrow(KTypeProjection $this$typeOrThrow) {
        Intrinsics.checkNotNullParameter($this$typeOrThrow, "<this>");
        KType type = $this$typeOrThrow.getType();
        if (type != null) {
            return type;
        }
        throw new IllegalArgumentException(("Star projections in type arguments are not allowed, but had " + $this$typeOrThrow.getType()).toString());
    }

    public static final <T, K> int elementsHashCodeBy(Iterable<? extends T> iterable, Function1<? super T, ? extends K> function1) {
        Intrinsics.checkNotNullParameter(iterable, "<this>");
        Intrinsics.checkNotNullParameter(function1, "selector");
        int accumulator$iv = 1;
        for (Object element$iv : iterable) {
            int hash = accumulator$iv;
            int i = hash * 31;
            K kInvoke = function1.invoke(element$iv);
            accumulator$iv = i + (kInvoke != null ? kInvoke.hashCode() : 0);
        }
        return accumulator$iv;
    }
}
