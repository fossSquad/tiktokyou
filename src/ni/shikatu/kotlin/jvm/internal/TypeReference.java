package ni.shikatu.kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.JvmClassMappingKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.reflect.KClassifier;
import ni.shikatu.kotlin.reflect.KType;
import ni.shikatu.kotlin.reflect.KTypeProjection;
import ni.shikatu.kotlin.reflect.KVariance;
import ni.shikatu.kotlinx.serialization.internal.CollectionDescriptorsKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 -2\u00020\u0001:\u0001-B?\bG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\b\u001a\u00020\t\u001a\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u0004\b\n\u0010\u000bB'\bV\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0004\b\n\u0010\u0011J\u0014\u0010!\u001a\u00020\u00102\b\u0010\"\u001a\u0004\u0018\u00010#H\u0096\u0082\u0004J\n\u0010$\u001a\u00020\tH\u0096\u0080\u0004J\n\u0010%\u001a\u00020&H\u0096\u0080\u0004J\u0012\u0010'\u001a\u00020&2\u0006\u0010(\u001a\u00020\u0010H\u0082\u0080\u0004J\u000e\u0010'\u001a\u00020&*\u00020\u0006H\u0082\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R-\u0010\u0007\u001a\u0004\u0018\u00010\u00018\u0000X\u0081\u0084\br\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R+\u0010\b\u001a\u00020\t8\u0000X\u0081\u0084\br\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u000e\n\u0000\u0012\u0004\b\u001a\u0010\u0017\u001a\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00058VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0015R\u0015\u0010\u000f\u001a\u00020\u00108VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u000f\u0010 R\u001d\u0010)\u001a\u00020&*\u0006\u0012\u0002\b\u00030*8BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b+\u0010,Ê\u0001\f\b\f\u0012\b\b\r\u0012\u0004\b\b(/¨\u0006."}, d2 = {"Lni/shikatu/kotlin/jvm/internal/TypeReference;", "Lni/shikatu/kotlin/reflect/KType;", "classifier", "Lni/shikatu/kotlin/reflect/KClassifier;", "arguments", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/reflect/KTypeProjection;", "platformTypeUpperBound", "flags", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lkotlin/reflect/KClassifier;Ljava/util/List;Lkotlin/reflect/KType;I)V", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.6", "isMarkedNullable", _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlin/reflect/KClassifier;Ljava/util/List;Z)V", "getClassifier", "()Lkotlin/reflect/KClassifier;", "getArguments", "()Ljava/util/List;", "getPlatformTypeUpperBound$kotlin_stdlib$annotations", "()V", "getPlatformTypeUpperBound$kotlin_stdlib", "()Lkotlin/reflect/KType;", "getFlags$kotlin_stdlib$annotations", "getFlags$kotlin_stdlib", "()I", "annotations", _UrlKt.FRAGMENT_ENCODE_SET, "getAnnotations", "()Z", "equals", "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "asString", "convertPrimitiveToWrapper", "arrayClassName", "Ljava/lang/Class;", "getArrayClassName", "(Ljava/lang/Class;)Ljava/lang/String;", "Companion", "ni.shikatu.kotlin-stdlib", "1.4"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class TypeReference implements KType {
    public static final Companion Companion = new Companion(null);
    public static final int IS_MARKED_NULLABLE = 1;
    public static final int IS_MUTABLE_COLLECTION_TYPE = 2;
    public static final int IS_NOTHING_TYPE = 4;
    private final List<KTypeProjection> arguments;
    private final KClassifier classifier;
    private final int flags;
    private final KType platformTypeUpperBound;

    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    public static final  class WhenMappings {
        public static final  int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[KVariance.values().length];
            try {
                iArr[KVariance.INVARIANT.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[KVariance.IN.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[KVariance.OUT.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static  void getFlags$kotlin_stdlib$annotations() {
    }

    public static  void getPlatformTypeUpperBound$kotlin_stdlib$annotations() {
    }

    public TypeReference(KClassifier classifier, List<KTypeProjection> list, KType platformTypeUpperBound, int flags) {
        Intrinsics.checkNotNullParameter(classifier, "classifier");
        Intrinsics.checkNotNullParameter(list, "arguments");
        this.classifier = classifier;
        this.arguments = list;
        this.platformTypeUpperBound = platformTypeUpperBound;
        this.flags = flags;
    }

    @Override
    public KClassifier getClassifier() {
        return this.classifier;
    }

    @Override
    public List<KTypeProjection> getArguments() {
        return this.arguments;
    }

    public final KType getPlatformTypeUpperBound$kotlin_stdlib() {
        return this.platformTypeUpperBound;
    }

    public final int getFlags$kotlin_stdlib() {
        return this.flags;
    }

    public TypeReference(KClassifier kClassifier, List<KTypeProjection> list, boolean z) {
        this(kClassifier, list, null, z ? 1 : 0);
        Intrinsics.checkNotNullParameter(kClassifier, "classifier");
        Intrinsics.checkNotNullParameter(list, "arguments");
    }

    @Override
    public List<Annotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }

    @Override
    public boolean isMarkedNullable() {
        return (this.flags & 1) != 0;
    }

    public boolean equals(Object other) {
        return (other instanceof TypeReference) && Intrinsics.areEqual(getClassifier(), ((TypeReference) other).getClassifier()) && Intrinsics.areEqual(getArguments(), ((TypeReference) other).getArguments()) && Intrinsics.areEqual(this.platformTypeUpperBound, ((TypeReference) other).platformTypeUpperBound) && this.flags == ((TypeReference) other).flags;
    }

    public int hashCode() {
        return (((getClassifier().hashCode() * 31) + getArguments().hashCode()) * 31) + Integer.hashCode(this.flags);
    }

    public String toString() {
        return asString(false) + " (Kotlin reflection is not available)";
    }

    private final String asString(boolean convertPrimitiveToWrapper) {
        String klass;
        KClassifier classifier = getClassifier();
        KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
        Class<?> javaClass = kClass != null ? JvmClassMappingKt.getJavaClass(kClass) : null;
        if (javaClass == null) {
            klass = getClassifier().toString();
        } else if ((this.flags & 4) != 0) {
            klass = "ni.shikatu.kotlin.Nothing";
        } else if (javaClass.isArray()) {
            klass = getArrayClassName(javaClass);
        } else {
            klass = (convertPrimitiveToWrapper && javaClass.isPrimitive()) ? JvmClassMappingKt.getJavaObjectType((KClass) getClassifier()).getName() : javaClass.getName();
        }
        boolean zIsEmpty = getArguments().isEmpty();
        String nullable = _UrlKt.FRAGMENT_ENCODE_SET;
        String args = zIsEmpty ? _UrlKt.FRAGMENT_ENCODE_SET : CollectionsKt.joinToString$default(getArguments(), ", ", "<", ">", 0, null, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return TypeReference.asString$lambda$0(this.f$0, (KTypeProjection) obj);
            }
        }, 24, null);
        if (isMarkedNullable()) {
            nullable = "?";
        }
        String result = klass + args + nullable;
        KType upper = this.platformTypeUpperBound;
        if (upper instanceof TypeReference) {
            String renderedUpper = ((TypeReference) upper).asString(true);
            if (!Intrinsics.areEqual(renderedUpper, result)) {
                return Intrinsics.areEqual(renderedUpper, new StringBuilder().append(result).append('?').toString()) ? result + '!' : '(' + result + ".." + renderedUpper + ')';
            }
        }
        return result;
    }

    public static final CharSequence asString$lambda$0(TypeReference this$0, KTypeProjection it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.asString(it);
    }

    private final String getArrayClassName(Class<?> cls) {
        if (Intrinsics.areEqual(cls, boolean[].class)) {
            return "ni.shikatu.kotlin.BooleanArray";
        }
        if (Intrinsics.areEqual(cls, char[].class)) {
            return "ni.shikatu.kotlin.CharArray";
        }
        if (Intrinsics.areEqual(cls, byte[].class)) {
            return "ni.shikatu.kotlin.ByteArray";
        }
        if (Intrinsics.areEqual(cls, short[].class)) {
            return "ni.shikatu.kotlin.ShortArray";
        }
        if (Intrinsics.areEqual(cls, int[].class)) {
            return "ni.shikatu.kotlin.IntArray";
        }
        if (Intrinsics.areEqual(cls, float[].class)) {
            return "ni.shikatu.kotlin.FloatArray";
        }
        if (Intrinsics.areEqual(cls, long[].class)) {
            return "ni.shikatu.kotlin.LongArray";
        }
        return Intrinsics.areEqual(cls, double[].class) ? "ni.shikatu.kotlin.DoubleArray" : CollectionDescriptorsKt.ARRAY_NAME;
    }

    private final String asString(KTypeProjection $this$asString) {
        String typeString;
        if ($this$asString.getVariance() == null) {
            return "*";
        }
        KType type = $this$asString.getType();
        TypeReference typeReference = type instanceof TypeReference ? (TypeReference) type : null;
        if (typeReference == null || (typeString = typeReference.asString(true)) == null) {
            typeString = String.valueOf($this$asString.getType());
        }
        switch (WhenMappings.$EnumSwitchMapping$0[$this$asString.getVariance().ordinal()]) {
            case 1:
                return typeString;
            case 2:
                return "in " + typeString;
            case 3:
                return "out " + typeString;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000f\u0010\u0004\u001a\u00020\u0005X\u0080Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0006\u001a\u00020\u0005X\u0080Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0007\u001a\u00020\u0005X\u0080Ô\b¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lni/shikatu/kotlin/jvm/internal/TypeReference$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "IS_MARKED_NULLABLE", _UrlKt.FRAGMENT_ENCODE_SET, "IS_MUTABLE_COLLECTION_TYPE", "IS_NOTHING_TYPE", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
