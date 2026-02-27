package ni.shikatu.kotlin.jvm;

import java.lang.annotation.Annotation;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.jvm.internal.ClassBasedDeclarationContainer;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.kotlin.reflect.KClass;

@Metadata(d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u0010\n\u0002\b\u0005\u001a\u001f\u0010\u0014\u001a\u00020\u0015\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\t*\u0006\u0012\u0002\b\u00030\u0016¢\u0006\u0002\u0010\u0017\"-\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00038G¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"-\u0010\b\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\n\u0010\u0007\"+\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\f\u0010\u0007\"+\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00020\u00018G¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f\"&\u0010\u0010\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\t*\u0002H\u00028Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0011\";\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\t*\b\u0012\u0004\u0012\u0002H\u00020\u00038Ç\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0005\u001a\u0004\b\u0013\u0010\u0007\"'\u0010\u0018\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\u0003\"\b\b\u0000\u0010\u0002*\u00020\u0019*\u0002H\u00028F¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b\";\u0010\u001c\u001a\b\u0012\u0004\u0012\u0002H\u001d0\u0001\"\u000e\b\u0000\u0010\u001d*\b\u0012\u0004\u0012\u0002H\u001d0\u001e*\b\u0012\u0004\u0012\u0002H\u001d0\u001e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010 \u001a\u0004\b!\u0010\"¨\u0006#"}, d2 = {"java", "Ljava/lang/Class;", "T", "Lni/shikatu/kotlin/reflect/KClass;", "getJavaClass$annotations", "(Lkotlin/reflect/KClass;)V", "getJavaClass", "(Lkotlin/reflect/KClass;)Ljava/lang/Class;", "javaPrimitiveType", "", "getJavaPrimitiveType", "javaObjectType", "getJavaObjectType", "ni.shikatu.kotlin", "getKotlinClass", "(Ljava/lang/Class;)Lkotlin/reflect/KClass;", "javaClass", "(Ljava/lang/Object;)Ljava/lang/Class;", "getRuntimeClassOfKClassInstance$annotations", "getRuntimeClassOfKClassInstance", "isArrayOf", "", "", "([Ljava/lang/Object;)Z", "annotationClass", "", "getAnnotationClass", "(Ljava/lang/annotation/Annotation;)Lkotlin/reflect/KClass;", "declaringJavaClass", "E", "", "getDeclaringJavaClass$annotations", "(Ljava/lang/Enum;)V", "getDeclaringJavaClass", "(Ljava/lang/Enum;)Ljava/lang/Class;", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class JvmClassMappingKt {
    public static  void getDeclaringJavaClass$annotations(Enum r0) {
    }

    public static  void getJavaClass$annotations(KClass kClass) {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Use 'java' property to get Java class corresponding to this Kotlin class or cast this instance to Any if you really want to get the runtime Java class of this implementation of KClass.", replaceWith = @ReplaceWith(expression = "(this as Any).javaClass", imports = {}))
    public static  void getRuntimeClassOfKClassInstance$annotations(KClass kClass) {
    }

    public static final <T> Class<T> getJavaClass(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Class<T> cls = (Class<T>) ((ClassBasedDeclarationContainer) kClass).getJClass();
        Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        return cls;
    }

    public static final <T> Class<T> getJavaPrimitiveType(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Class thisJClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (thisJClass.isPrimitive()) {
            Intrinsics.checkNotNull(thisJClass, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaPrimitiveType>>");
            return thisJClass;
        }
        String name = thisJClass.getName();
        if (name != null) {
            switch (name.hashCode()) {
                case -2056817302:
                    if (name.equals("java.lang.Integer")) {
                        return Integer.TYPE;
                    }
                    break;
                case -527879800:
                    if (name.equals("java.lang.Float")) {
                        return Float.TYPE;
                    }
                    break;
                case -515992664:
                    if (name.equals("java.lang.Short")) {
                        return Short.TYPE;
                    }
                    break;
                case 155276373:
                    if (name.equals("java.lang.Character")) {
                        return Character.TYPE;
                    }
                    break;
                case 344809556:
                    if (name.equals("java.lang.Boolean")) {
                        return Boolean.TYPE;
                    }
                    break;
                case 398507100:
                    if (name.equals("java.lang.Byte")) {
                        return Byte.TYPE;
                    }
                    break;
                case 398795216:
                    if (name.equals("java.lang.Long")) {
                        return Long.TYPE;
                    }
                    break;
                case 399092968:
                    if (name.equals("java.lang.Void")) {
                        return Void.TYPE;
                    }
                    break;
                case 761287205:
                    if (name.equals("java.lang.Double")) {
                        return Double.TYPE;
                    }
                    break;
            }
        }
        return null;
    }

    public static final <T> Class<T> getJavaObjectType(KClass<T> kClass) {
        Class cls;
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Class thisJClass = ((ClassBasedDeclarationContainer) kClass).getJClass();
        if (!thisJClass.isPrimitive()) {
            Intrinsics.checkNotNull(thisJClass, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
            return thisJClass;
        }
        String name = thisJClass.getName();
        if (name != null) {
            switch (name) {
                case "double":
                    cls = Double.class;
                    break;
                case "int":
                    cls = Integer.class;
                    break;
                case "byte":
                    cls = Byte.class;
                    break;
                case "char":
                    cls = Character.class;
                    break;
                case "long":
                    cls = Long.class;
                    break;
                case "void":
                    cls = Void.class;
                    break;
                case "boolean":
                    cls = Boolean.class;
                    break;
                case "float":
                    cls = Float.class;
                    break;
                case "short":
                    cls = Short.class;
                    break;
                default:
                    cls = thisJClass;
                    break;
            }
        } else {
            cls = thisJClass;
        }
        Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaObjectType>>");
        return cls;
    }

    public static final <T> KClass<T> getKotlinClass(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "<this>");
        return Reflection.getOrCreateKotlinClass(cls);
    }

    public static final <T> Class<T> getJavaClass(T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Class<T> cls = (Class<T>) t.getClass();
        Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>");
        return cls;
    }

    public static final <T> Class<KClass<T>> getRuntimeClassOfKClassInstance(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Class<KClass<T>> cls = (Class<KClass<T>>) kClass.getClass();
        Intrinsics.checkNotNull(cls, "null cannot be cast to non-null type java.lang.Class<kotlin.reflect.KClass<T of kotlin.jvm.JvmClassMappingKt.<get-javaClass>>>");
        return cls;
    }

    public static final  boolean isArrayOf(Object[] $this$isArrayOf) {
        Intrinsics.checkNotNullParameter($this$isArrayOf, "<this>");
        Intrinsics.reifiedOperationMarker(4, "T");
        return Object.class.isAssignableFrom($this$isArrayOf.getClass().getComponentType());
    }

    public static final <T extends Annotation> KClass<? extends T> getAnnotationClass(T t) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Class<? extends Annotation> clsAnnotationType = t.annotationType();
        Intrinsics.checkNotNullExpressionValue(clsAnnotationType, "annotationType(...)");
        KClass<? extends T> kotlinClass = getKotlinClass(clsAnnotationType);
        Intrinsics.checkNotNull(kotlinClass, "null cannot be cast to non-null type kotlin.reflect.KClass<out T of kotlin.jvm.JvmClassMappingKt.<get-annotationClass>>");
        return kotlinClass;
    }

    private static final <E extends Enum<E>> Class<E> getDeclaringJavaClass(Enum<E> r2) {
        Intrinsics.checkNotNullParameter(r2, "<this>");
        Class<E> declaringClass = r2.getDeclaringClass();
        Intrinsics.checkNotNullExpressionValue(declaringClass, "getDeclaringClass(...)");
        return declaringClass;
    }
}
