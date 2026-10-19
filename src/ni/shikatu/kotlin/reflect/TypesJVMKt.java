package ni.shikatu.kotlin.reflect;

import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.NoSuchElementException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.JvmClassMappingKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.KTypeBase;
import ni.shikatu.kotlin.jvm.internal.KTypeParameterBase;
import ni.shikatu.kotlin.sequences.Sequence;
import ni.shikatu.kotlin.sequences.SequencesKt;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\u001c\u0010\f\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0083\u0080\u0004b\u0002\b\n\u001a(\u0010\u000f\u001a\u00020\u00012\n\u0010\u0010\u001a\u0006\u0012\u0002\b\u00030\u00112\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0083\u0080\u0004b\u0002\b\n\u001a\u0012\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0001H\u0082\u0080\u0004\"5\u0010\u0000\u001a\u00020\u0001*\u00020\u00028FX\u0087\u0084\br\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tr\u0002\b\nr\u0002\b\u000b¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"#\u0010\u0000\u001a\u00020\u0001*\u00020\u00148BX\u0083\u0084\br\u0002\b\n¢\u0006\f\u0012\u0004\b\u0003\u0010\u0015\u001a\u0004\b\u0005\u0010\u0016¨\u0006\u001a"}, d2 = {"javaType", "Ljava/lang/reflect/Type;", "Lni/shikatu/kotlin/reflect/KType;", "getJavaType$annotations", "(Lkotlin/reflect/KType;)V", "getJavaType", "(Lkotlin/reflect/KType;)Ljava/lang/reflect/Type;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.4", "Lni/shikatu/kotlin/ExperimentalStdlibApi;", "Lni/shikatu/kotlin/internal/LowPriorityInOverloadResolution;", "computeJavaType", "forceWrapper", _UrlKt.FRAGMENT_ENCODE_SET, "createPossiblyInnerType", "jClass", "Ljava/lang/Class;", "arguments", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/reflect/KTypeProjection;", "(Lkotlin/reflect/KTypeProjection;)V", "(Lkotlin/reflect/KTypeProjection;)Ljava/lang/reflect/Type;", "typeToString", _UrlKt.FRAGMENT_ENCODE_SET, "type", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class TypesJVMKt {

    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    public static final  class WhenMappings {
        public static final  int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.IN.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static  void getJavaType$annotations(KType kType) {
    }

    private static  void getJavaType$annotations(KTypeProjection kTypeProjection) {
    }

    public static final Type getJavaType(KType $this$javaType) {
        Type it;
        Intrinsics.checkNotNullParameter($this$javaType, "<this>");
        if (($this$javaType instanceof KTypeBase) && (it = ((KTypeBase) $this$javaType).getJavaType()) != null) {
            return it;
        }
        return computeJavaType$default($this$javaType, false, 1, null);
    }

    static  Type computeJavaType$default(KType kType, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return computeJavaType(kType, z);
    }

    public static final Type computeJavaType(KType $this$computeJavaType, boolean forceWrapper) {
        KClassifier classifier = $this$computeJavaType.getClassifier();
        if (classifier instanceof KTypeParameter) {
            if (!(classifier instanceof KTypeParameterBase)) {
                return new ObsoleteFallbackTypeVariableImpl((KTypeParameter) classifier);
            }
            GenericDeclaration container = ((KTypeParameterBase) classifier).getJavaContainingDeclaration$kotlin_stdlib();
            if (container == null) {
                throw new UnsupportedOperationException("javaType is not supported for this type: " + $this$computeJavaType);
            }
            Object[] typeParameters = container.getTypeParameters();
            Intrinsics.checkNotNullExpressionValue(typeParameters, "getTypeParameters(...)");
            Object[] $this$single$iv = typeParameters;
            Object single$iv = null;
            boolean found$iv = false;
            for (Object element$iv : $this$single$iv) {
                if (Intrinsics.areEqual(((TypeVariable) element$iv).getName(), ((KTypeParameterBase) classifier).getName())) {
                    if (found$iv) {
                        throw new IllegalArgumentException("Array contains more than one matching element.");
                    }
                    single$iv = element$iv;
                    found$iv = true;
                }
            }
            if (found$iv) {
                Intrinsics.checkNotNullExpressionValue(single$iv, "single(...)");
                return (Type) single$iv;
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        }
        if (classifier instanceof KClass) {
            KClass kClass = (KClass) classifier;
            Class jClass = forceWrapper ? JvmClassMappingKt.getJavaObjectType(kClass) : JvmClassMappingKt.getJavaClass(kClass);
            List<KTypeProjection> arguments = $this$computeJavaType.getArguments();
            if (arguments.isEmpty()) {
                return jClass;
            }
            if (jClass.isArray()) {
                if (jClass.getComponentType().isPrimitive()) {
                    return jClass;
                }
                KTypeProjection kTypeProjection = (KTypeProjection) CollectionsKt.singleOrNull((List) arguments);
                if (kTypeProjection == null) {
                    throw new IllegalArgumentException("ni.shikatu.kotlin.Array must have exactly one type argument: " + $this$computeJavaType);
                }
                KVariance variance = kTypeProjection.component1();
                KType elementType = kTypeProjection.component2();
                switch (variance == null ? -1 : WhenMappings.$EnumSwitchMapping$0[variance.ordinal()]) {
                    case -1:
                    case 1:
                        return jClass;
                    case 0:
                    default:
                        throw new NoWhenBranchMatchedException();
                    case 2:
                    case 3:
                        Intrinsics.checkNotNull(elementType);
                        Type javaElementType = computeJavaType$default(elementType, false, 1, null);
                        return javaElementType instanceof Class ? jClass : new GenericArrayTypeImpl(javaElementType);
                }
            }
            return createPossiblyInnerType(jClass, arguments);
        }
        throw new UnsupportedOperationException("Unsupported type classifier: " + $this$computeJavaType);
    }

    private static final Type createPossiblyInnerType(Class<?> cls, List<KTypeProjection> list) {
        Class<?> declaringClass = cls.getDeclaringClass();
        if (declaringClass == null) {
            List<KTypeProjection> $this$map$iv = list;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                KTypeProjection p0 = (KTypeProjection) item$iv$iv;
                destination$iv$iv.add(getJavaType(p0));
            }
            return new ParameterizedTypeImpl(cls, null, (List) destination$iv$iv);
        }
        if (Modifier.isStatic(cls.getModifiers())) {
            Class<?> cls2 = declaringClass;
            List<KTypeProjection> $this$map$iv2 = list;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (Object item$iv$iv2 : $this$map$iv2) {
                KTypeProjection p1 = (KTypeProjection) item$iv$iv2;
                destination$iv$iv2.add(getJavaType(p1));
            }
            return new ParameterizedTypeImpl(cls, cls2, (List) destination$iv$iv2);
        }
        int n = cls.getTypeParameters().length;
        Type typeCreatePossiblyInnerType = createPossiblyInnerType(declaringClass, list.subList(n, list.size()));
        Iterable $this$map$iv3 = list.subList(0, n);
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
        for (Object item$iv$iv3 : $this$map$iv3) {
            KTypeProjection p2 = (KTypeProjection) item$iv$iv3;
            destination$iv$iv3.add(getJavaType(p2));
        }
        return new ParameterizedTypeImpl(cls, typeCreatePossiblyInnerType, (List) destination$iv$iv3);
    }

    private static final Type getJavaType(KTypeProjection $this$javaType) {
        KVariance variance = $this$javaType.getVariance();
        if (variance == null) {
            return WildcardTypeImpl.Companion.getSTAR();
        }
        KType type = $this$javaType.getType();
        Intrinsics.checkNotNull(type);
        switch (WhenMappings.$EnumSwitchMapping$0[variance.ordinal()]) {
            case 1:
                return new WildcardTypeImpl(null, computeJavaType(type, true));
            case 2:
                return computeJavaType(type, true);
            case 3:
                return new WildcardTypeImpl(computeJavaType(type, true), null);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final String typeToString(Type type) {
        if (type instanceof Class) {
            if (((Class) type).isArray()) {
                Sequence unwrap = SequencesKt.generateSequence(type, TypesJVMKt$typeToString$unwrap$1.INSTANCE);
                return ((Class) SequencesKt.last(unwrap)).getName() + StringsKt.repeat(_UrlKt.PATH_SEGMENT_ENCODE_SET_URI, SequencesKt.count(unwrap));
            }
            String name = ((Class) type).getName();
            Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
            return name;
        }
        return type.toString();
    }
}
