package ni.shikatu.kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.MagicApiIntrinsics;
import ni.shikatu.kotlin.reflect.KType;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.InternalSerializationApi;
import ni.shikatu.kotlinx.serialization.SerializersKt;
import ni.shikatu.kotlinx.serialization.internal.ArrayListClassDesc;
import ni.shikatu.kotlinx.serialization.internal.HashMapClassDesc;
import ni.shikatu.kotlinx.serialization.internal.HashSetClassDesc;
import ni.shikatu.kotlinx.serialization.internal.PrimitivesKt;
import ni.shikatu.kotlinx.serialization.internal.SerialDescriptorForNullable;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000b\n\u0000\u001aF\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005\"\u00020\u00012\u0019\b\u0002\u0010\u0006\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0086\u0080\u0004¢\u0006\u0002\u0010\u000b\u001a\u001a\u0010\f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000eH\u0086\u0080\u0004\u001a\u001a\u0010\u000f\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u0001H\u0086\u0080\u0004\u001aN\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u00122\u0012\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0005\"\u00020\u00012\u0019\b\u0002\u0010\u0013\u001a\u0013\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007¢\u0006\u0002\b\nH\u0087\u0080\u0004¢\u0006\u0002\u0010\u0014\u001a\u0012\u0010\u0015\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0016\u0018\u0001H\u0086\u0088\u0004\u001a\u0012\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u0018H\u0086\u0080\u0004\u001a\u0012\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0087\u0080\u0004\u001a\u0012\u0010\u0019\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0016\u0018\u0001H\u0087\u0088\u0004\u001a\u001a\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u00012\u0006\u0010\u001d\u001a\u00020\u0001H\u0087\u0080\u0004\u001a\u001a\u0010\u001b\u001a\u00020\u0001\"\u0006\b\u0000\u0010\u001e\u0018\u0001\"\u0006\b\u0001\u0010\u001f\u0018\u0001H\u0087\u0088\u0004\u001a\u0012\u0010 \u001a\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u0001H\u0087\u0080\u0004\u001a\u0012\u0010 \u001a\u00020\u0001\"\u0006\b\u0000\u0010\u0016\u0018\u0001H\u0087\u0088\u0004\u001a8\u0010)\u001a\u00020\t\"\u0006\b\u0000\u0010\u0016\u0018\u0001*\u00020\b2\u0006\u0010*\u001a\u00020\u00032\u000e\b\u0002\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,2\b\b\u0002\u0010.\u001a\u00020/H\u0086\u0088\u0004\"\u001f\u0010!\u001a\u00020\u0001*\u00020\u00018FX\u0086\u0084\b¢\u0006\f\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%\"\u001f\u0010&\u001a\u00020\u0001*\u00020\u00018FX\u0087\u0084\b¢\u0006\f\u0012\u0004\b'\u0010#\u001a\u0004\b(\u0010%¨\u00060"}, d2 = {"buildClassSerialDescriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "serialName", _UrlKt.FRAGMENT_ENCODE_SET, "typeParameters", _UrlKt.FRAGMENT_ENCODE_SET, "builderAction", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ExtensionFunctionType;", "(Ljava/lang/String;[Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function1;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "PrimitiveSerialDescriptor", "kind", "Lni/shikatu/kotlinx/serialization/descriptors/PrimitiveKind;", "SerialDescriptor", "original", "buildSerialDescriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialKind;", "builder", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialKind;[Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function1;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialDescriptor", "T", "type", "Lni/shikatu/kotlin/reflect/KType;", "listSerialDescriptor", "elementDescriptor", "mapSerialDescriptor", "keyDescriptor", "valueDescriptor", "K", "V", "setSerialDescriptor", "nullable", "getNullable$annotations", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getNullable", "(Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/descriptors/SerialDescriptor;", "nonNullOriginal", "getNonNullOriginal$annotations", "getNonNullOriginal", "element", "elementName", "annotations", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "isOptional", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SerialDescriptorsKt {
    @ExperimentalSerializationApi
    public static  void getNonNullOriginal$annotations(SerialDescriptor serialDescriptor) {
    }

    public static  void getNullable$annotations(SerialDescriptor serialDescriptor) {
    }

    public static  SerialDescriptor buildClassSerialDescriptor$default(String str, SerialDescriptor[] serialDescriptorArr, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1() {
                @Override
                public final Object invoke(Object obj2) {
                    return SerialDescriptorsKt.buildClassSerialDescriptor$lambda$0((ClassSerialDescriptorBuilder) obj2);
                }
            };
        }
        return buildClassSerialDescriptor(str, serialDescriptorArr, function1);
    }

    public static final Unit buildClassSerialDescriptor$lambda$0(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "<this>");
        return Unit.INSTANCE;
    }

    public static final SerialDescriptor buildClassSerialDescriptor(String serialName, SerialDescriptor[] typeParameters, Function1<? super ClassSerialDescriptorBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        if (StringsKt.isBlank(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited".toString());
        }
        ClassSerialDescriptorBuilder sdBuilder = new ClassSerialDescriptorBuilder(serialName);
        function1.invoke(sdBuilder);
        return new SerialDescriptorImpl(serialName, StructureKind.CLASS.INSTANCE, sdBuilder.getElementNames$kotlinx_serialization_core().size(), ArraysKt.toList(typeParameters), sdBuilder);
    }

    public static final SerialDescriptor PrimitiveSerialDescriptor(String serialName, PrimitiveKind kind) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        if (StringsKt.isBlank(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited".toString());
        }
        return PrimitivesKt.PrimitiveDescriptorSafe(serialName, kind);
    }

    public static final SerialDescriptor SerialDescriptor(String serialName, SerialDescriptor original) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(original, "original");
        if (StringsKt.isBlank(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited".toString());
        }
        if (Intrinsics.areEqual(serialName, original.getSerialName())) {
            throw new IllegalArgumentException(("The name of the wrapped descriptor (" + serialName + ") cannot be the same as the name of the original descriptor (" + original.getSerialName() + ')').toString());
        }
        if (original.getKind() instanceof PrimitiveKind) {
            PrimitivesKt.checkNameIsNotAPrimitive(serialName);
        }
        return new WrappedSerialDescriptor(serialName, original);
    }

    public static  SerialDescriptor buildSerialDescriptor$default(String str, SerialKind serialKind, SerialDescriptor[] serialDescriptorArr, Function1 function1, int i, Object obj) {
        if ((i & 8) != 0) {
            function1 = new Function1() {
                @Override
                public final Object invoke(Object obj2) {
                    return SerialDescriptorsKt.buildSerialDescriptor$lambda$0((ClassSerialDescriptorBuilder) obj2);
                }
            };
        }
        return buildSerialDescriptor(str, serialKind, serialDescriptorArr, function1);
    }

    public static final Unit buildSerialDescriptor$lambda$0(ClassSerialDescriptorBuilder classSerialDescriptorBuilder) {
        Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "<this>");
        return Unit.INSTANCE;
    }

    @InternalSerializationApi
    public static final SerialDescriptor buildSerialDescriptor(String serialName, SerialKind kind, SerialDescriptor[] typeParameters, Function1<? super ClassSerialDescriptorBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(typeParameters, "typeParameters");
        Intrinsics.checkNotNullParameter(function1, "builder");
        if (StringsKt.isBlank(serialName)) {
            throw new IllegalArgumentException("Blank serial names are prohibited".toString());
        }
        if (Intrinsics.areEqual(kind, StructureKind.CLASS.INSTANCE)) {
            throw new IllegalArgumentException("For StructureKind.CLASS please use 'buildClassSerialDescriptor' instead".toString());
        }
        ClassSerialDescriptorBuilder sdBuilder = new ClassSerialDescriptorBuilder(serialName);
        function1.invoke(sdBuilder);
        return new SerialDescriptorImpl(serialName, kind, sdBuilder.getElementNames$kotlinx_serialization_core().size(), ArraysKt.toList(typeParameters), sdBuilder);
    }

    public static final  <T> SerialDescriptor serialDescriptor() {
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.simple");
        return SerializersKt.serializer((KType) null).getDescriptor();
    }

    public static final SerialDescriptor serialDescriptor(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt.serializer(type).getDescriptor();
    }

    @ExperimentalSerializationApi
    public static final SerialDescriptor listSerialDescriptor(SerialDescriptor elementDescriptor) {
        Intrinsics.checkNotNullParameter(elementDescriptor, "elementDescriptor");
        return new ArrayListClassDesc(elementDescriptor);
    }

    @ExperimentalSerializationApi
    public static final  <T> SerialDescriptor listSerialDescriptor() {
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.simple");
        return listSerialDescriptor(SerializersKt.serializer((KType) null).getDescriptor());
    }

    @ExperimentalSerializationApi
    public static final SerialDescriptor mapSerialDescriptor(SerialDescriptor keyDescriptor, SerialDescriptor valueDescriptor) {
        Intrinsics.checkNotNullParameter(keyDescriptor, "keyDescriptor");
        Intrinsics.checkNotNullParameter(valueDescriptor, "valueDescriptor");
        return new HashMapClassDesc(keyDescriptor, valueDescriptor);
    }

    @ExperimentalSerializationApi
    public static final  <K, V> SerialDescriptor mapSerialDescriptor() {
        Intrinsics.reifiedOperationMarker(6, "K");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.simple");
        SerialDescriptor descriptor = SerializersKt.serializer((KType) null).getDescriptor();
        Intrinsics.reifiedOperationMarker(6, "V");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.simple");
        return mapSerialDescriptor(descriptor, SerializersKt.serializer((KType) null).getDescriptor());
    }

    @ExperimentalSerializationApi
    public static final SerialDescriptor setSerialDescriptor(SerialDescriptor elementDescriptor) {
        Intrinsics.checkNotNullParameter(elementDescriptor, "elementDescriptor");
        return new HashSetClassDesc(elementDescriptor);
    }

    @ExperimentalSerializationApi
    public static final  <T> SerialDescriptor setSerialDescriptor() {
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.simple");
        return setSerialDescriptor(SerializersKt.serializer((KType) null).getDescriptor());
    }

    public static final SerialDescriptor getNullable(SerialDescriptor $this$nullable) {
        Intrinsics.checkNotNullParameter($this$nullable, "<this>");
        return $this$nullable.isNullable() ? $this$nullable : new SerialDescriptorForNullable($this$nullable);
    }

    public static final SerialDescriptor getNonNullOriginal(SerialDescriptor $this$nonNullOriginal) {
        Intrinsics.checkNotNullParameter($this$nonNullOriginal, "<this>");
        return $this$nonNullOriginal instanceof SerialDescriptorForNullable ? ((SerialDescriptorForNullable) $this$nonNullOriginal).getOriginal$kotlinx_serialization_core() : $this$nonNullOriginal;
    }

    public static  void element$default(ClassSerialDescriptorBuilder classSerialDescriptorBuilder, String elementName, List annotations, boolean isOptional, int i, Object obj) {
        if ((i & 2) != 0) {
            annotations = CollectionsKt.emptyList();
        }
        if ((i & 4) != 0) {
            isOptional = false;
        }
        Intrinsics.checkNotNullParameter(classSerialDescriptorBuilder, "<this>");
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.simple");
        SerialDescriptor descriptor = SerializersKt.serializer((KType) null).getDescriptor();
        classSerialDescriptorBuilder.element(elementName, descriptor, annotations, isOptional);
    }

    public static final  <T> void element(ClassSerialDescriptorBuilder $this$element, String elementName, List<? extends Annotation> list, boolean isOptional) {
        Intrinsics.checkNotNullParameter($this$element, "<this>");
        Intrinsics.checkNotNullParameter(elementName, "elementName");
        Intrinsics.checkNotNullParameter(list, "annotations");
        Intrinsics.reifiedOperationMarker(6, "T");
        MagicApiIntrinsics.voidMagicApiCall("ni.shikatu.kotlinx.serialization.serializer.simple");
        SerialDescriptor descriptor = SerializersKt.serializer((KType) null).getDescriptor();
        $this$element.element(elementName, descriptor, list, isOptional);
    }
}
