package ni.shikatu.kotlinx.serialization;
import java.util.Map.Entry;

import java.lang.annotation.Annotation;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ni.shikatu.kotlin.Lazy;
import ni.shikatu.kotlin.LazyKt;
import ni.shikatu.kotlin.LazyThreadSafetyMode;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.Grouping;
import ni.shikatu.kotlin.collections.MapsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.kotlin.jvm.internal.StringCompanionObject;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.text.Typography;
import ni.shikatu.kotlinx.serialization.builtins.BuiltinSerializersKt;
import ni.shikatu.kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import ni.shikatu.kotlinx.serialization.descriptors.PolymorphicKind;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptorsKt;
import ni.shikatu.kotlinx.serialization.descriptors.SerialKind;
import ni.shikatu.kotlinx.serialization.encoding.CompositeDecoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003BK\bF\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00070\t\u0012\u0014\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b0\t¢\u0006\u0004\b\f\u0010\rBY\bQ\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007\u0012\u0014\u0010\b\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00070\t\u0012\u0014\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b0\t\u0012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000f0\t¢\u0006\u0004\b\f\u0010\u0010J$\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010!2\u0006\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0005H\u0096\u0080\u0004J'\u0010 \u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00028\u0000H\u0096\u0080\u0004¢\u0006\u0002\u0010)R\u001b\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u000f0\u0014X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u001b\u0010\u0015\u001a\u00020\u00168VX\u0096\u0084\n¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u0017\u0010\u0018R1\u0010\u001b\u001a\u001e\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u0007\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b0\u001cX\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR#\u0010\u001f\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000b0\u001cX\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lni/shikatu/kotlinx/serialization/SealedClassSerializer;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/internal/AbstractPolymorphicSerializer;", "serialName", _UrlKt.FRAGMENT_ENCODE_SET, "baseClass", "Lni/shikatu/kotlin/reflect/KClass;", "subclasses", _UrlKt.FRAGMENT_ENCODE_SET, "subclassSerializers", "Lni/shikatu/kotlinx/serialization/KSerializer;", "<init>", "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)V", "classAnnotations", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/String;Lkotlin/reflect/KClass;[Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;[Ljava/lang/annotation/Annotation;)V", "getBaseClass", "()Lkotlin/reflect/KClass;", "_annotations", _UrlKt.FRAGMENT_ENCODE_SET, "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "descriptor$delegate", "Lni/shikatu/kotlin/Lazy;", "class2Serializer", _UrlKt.FRAGMENT_ENCODE_SET, "getClass2Serializer$kotlinx_serialization_core", "()Ljava/util/Map;", "serialName2Serializer", "findPolymorphicSerializerOrNull", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "decoder", "Lni/shikatu/kotlinx/serialization/encoding/CompositeDecoder;", "klassName", "Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "encoder", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "value", "(Lkotlinx/serialization/encoding/Encoder;Ljava/lang/Object;)Lkotlinx/serialization/SerializationStrategy;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@InternalSerializationApi
public final class SealedClassSerializer<T> extends AbstractPolymorphicSerializer<T> {
    private List<? extends Annotation> _annotations;
    private final KClass<T> baseClass;
    private final Map<KClass<? extends T>, KSerializer<? extends T>> class2Serializer;
    private final Lazy descriptor$delegate;
    private final Map<String, KSerializer<? extends T>> serialName2Serializer;

    public SealedClassSerializer(final String serialName, KClass<T> kClass, KClass<? extends T>[] kClassArr, KSerializer<? extends T>[] kSerializerArr) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(kClassArr, "subclasses");
        Intrinsics.checkNotNullParameter(kSerializerArr, "subclassSerializers");
        this.baseClass = kClass;
        this._annotations = CollectionsKt.emptyList();
        this.descriptor$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() {
            @Override
            public final Object invoke() {
                return SealedClassSerializer.descriptor_delegate$lambda$0(serialName, SealedClassSerializer.this);
            }
        });
        if (kClassArr.length != kSerializerArr.length) {
            throw new IllegalArgumentException("All subclasses of sealed class " + getBaseClass().getSimpleName() + " should be marked @Serializable");
        }
        this.class2Serializer = MapsKt.toMap(ArraysKt.zip(kClassArr, kSerializerArr));
        final Iterable $this$groupingBy$iv = this.class2Serializer.entrySet();
        Grouping<Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>>, String> grouping = new Grouping<Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>>, String>() {
            @Override
            public Iterator<Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>>> sourceIterator() {
                return $this$groupingBy$iv.iterator();
            }

            @Override
            public String keyOf(Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>> entry) {
                return entry.getValue().getDescriptor().getSerialName();
            }
        };
        Map $this$mapValues$iv = new LinkedHashMap();
        Iterator<Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>>> itSourceIterator = grouping.sourceIterator();
        while (itSourceIterator.hasNext()) {
            Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>> next = itSourceIterator.next();
            String strKeyOf = grouping.keyOf(next);
            Object accumulator$iv$iv = $this$mapValues$iv.get(strKeyOf);
            if (accumulator$iv$iv == null) {
                $this$mapValues$iv.containsKey(strKeyOf);
            }
            Map.Entry<? extends KClass<? extends T>, ? extends KSerializer<? extends T>> entry = next;
            Map.Entry accumulator = (Map.Entry) accumulator$iv$iv;
            String key = strKeyOf;
            if (accumulator != null) {
                throw new IllegalStateException(("Multiple sealed subclasses of '" + getBaseClass() + "' have the same serial name '" + key + "': '" + accumulator.getKey() + "', '" + entry.getKey() + '\'').toString());
            }
            $this$mapValues$iv.put(strKeyOf, entry);
        }
        Map destination$iv$iv = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
        Iterable $this$associateByTo$iv$iv$iv = $this$mapValues$iv.entrySet();
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
            Map.Entry it = (Map.Entry) element$iv$iv$iv;
            destination$iv$iv.put(it$iv$iv.getKey(), (KSerializer) ((Map.Entry) it.getValue()).getValue());
        }
        this.serialName2Serializer = destination$iv$iv;
    }

    @Override
    public KClass<T> getBaseClass() {
        return this.baseClass;
    }

    public SealedClassSerializer(String serialName, KClass<T> kClass, KClass<? extends T>[] kClassArr, KSerializer<? extends T>[] kSerializerArr, Annotation[] classAnnotations) {
        this(serialName, kClass, kClassArr, kSerializerArr);
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(kClassArr, "subclasses");
        Intrinsics.checkNotNullParameter(kSerializerArr, "subclassSerializers");
        Intrinsics.checkNotNullParameter(classAnnotations, "classAnnotations");
        this._annotations = ArraysKt.asList(classAnnotations);
    }

    @Override
    public SerialDescriptor getDescriptor() {
        return (SerialDescriptor) this.descriptor$delegate.getValue();
    }

    public static final SerialDescriptor descriptor_delegate$lambda$0(String $serialName, final SealedClassSerializer this$0) {
        return SerialDescriptorsKt.buildSerialDescriptor($serialName, PolymorphicKind.SEALED.INSTANCE, new SerialDescriptor[0], new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return SealedClassSerializer.descriptor_delegate$lambda$0$0(this$0, (ClassSerialDescriptorBuilder) obj);
            }
        });
    }

    public static final Unit descriptor_delegate$lambda$0$0(final SealedClassSerializer this$0, ClassSerialDescriptorBuilder $this$buildSerialDescriptor) {
        Intrinsics.checkNotNullParameter($this$buildSerialDescriptor, "$this$buildSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default($this$buildSerialDescriptor, "type", BuiltinSerializersKt.serializer(StringCompanionObject.INSTANCE).getDescriptor(), null, false, 12, null);
        SerialDescriptor elementDescriptor = SerialDescriptorsKt.buildSerialDescriptor("ni.shikatu.kotlinx.serialization.Sealed<" + this$0.getBaseClass().getSimpleName() + Typography.greater, SerialKind.CONTEXTUAL.INSTANCE, new SerialDescriptor[0], new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return SealedClassSerializer.descriptor_delegate$lambda$0$0$0(this$0, (ClassSerialDescriptorBuilder) obj);
            }
        });
        ClassSerialDescriptorBuilder.element$default($this$buildSerialDescriptor, "value", elementDescriptor, null, false, 12, null);
        $this$buildSerialDescriptor.setAnnotations(this$0._annotations);
        return Unit.INSTANCE;
    }

    public static final <T> Unit descriptor_delegate$lambda$0$0$0(SealedClassSerializer<T> this$0, ClassSerialDescriptorBuilder $this$buildSerialDescriptor) {
        Intrinsics.checkNotNullParameter($this$buildSerialDescriptor, "$this$buildSerialDescriptor");
        for (Map.Entry<String, KSerializer<? extends T>> entry : (Iterable<Map.Entry<String, KSerializer<? extends T>>>) this$0.serialName2Serializer.entrySet()) {
            String name = entry.getKey();
            ClassSerialDescriptorBuilder.element$default($this$buildSerialDescriptor, name, entry.getValue().getDescriptor(), null, false, 12, null);
        }
        return Unit.INSTANCE;
    }

    public final Map<KClass<? extends T>, KSerializer<? extends T>> getClass2Serializer$kotlinx_serialization_core() {
        return this.class2Serializer;
    }

    @Override
    public DeserializationStrategy<T> findPolymorphicSerializerOrNull(CompositeDecoder decoder, String klassName) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        KSerializer<? extends T> kSerializer = this.serialName2Serializer.get(klassName);
        return (DeserializationStrategy<T>) (kSerializer != null ? kSerializer : super.findPolymorphicSerializerOrNull(decoder, klassName));
    }

    @Override
    public SerializationStrategy<T> findPolymorphicSerializerOrNull(Encoder encoder, T t) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(t, "value");
        KSerializer<? extends T> kSerializer = this.class2Serializer.get(Reflection.getOrCreateKotlinClass(t.getClass()));
        KSerializer<? extends T> kSerializerFindPolymorphicSerializerOrNull = (KSerializer<? extends T>) (kSerializer != null ? kSerializer : super.findPolymorphicSerializerOrNull(encoder, t));
        if (kSerializerFindPolymorphicSerializerOrNull != null) {
            return (SerializationStrategy<T>) kSerializerFindPolymorphicSerializerOrNull;
        }
        return null;
    }
}
