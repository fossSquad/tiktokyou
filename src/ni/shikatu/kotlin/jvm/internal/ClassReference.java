package ni.shikatu.kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import ni.shikatu.kotlin.Function;
import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.MapsKt;
import ni.shikatu.kotlin.jvm.JvmClassMappingKt;
import ni.shikatu.kotlin.jvm.KotlinReflectionNotSupportedError;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function10;
import ni.shikatu.kotlin.jvm.functions.Function11;
import ni.shikatu.kotlin.jvm.functions.Function12;
import ni.shikatu.kotlin.jvm.functions.Function13;
import ni.shikatu.kotlin.jvm.functions.Function14;
import ni.shikatu.kotlin.jvm.functions.Function15;
import ni.shikatu.kotlin.jvm.functions.Function16;
import ni.shikatu.kotlin.jvm.functions.Function17;
import ni.shikatu.kotlin.jvm.functions.Function18;
import ni.shikatu.kotlin.jvm.functions.Function19;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.functions.Function20;
import ni.shikatu.kotlin.jvm.functions.Function21;
import ni.shikatu.kotlin.jvm.functions.Function22;
import ni.shikatu.kotlin.jvm.functions.Function3;
import ni.shikatu.kotlin.jvm.functions.Function4;
import ni.shikatu.kotlin.jvm.functions.Function5;
import ni.shikatu.kotlin.jvm.functions.Function6;
import ni.shikatu.kotlin.jvm.functions.Function7;
import ni.shikatu.kotlin.jvm.functions.Function8;
import ni.shikatu.kotlin.jvm.functions.Function9;
import ni.shikatu.kotlin.reflect.KCallable;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.reflect.KFunction;
import ni.shikatu.kotlin.reflect.KType;
import ni.shikatu.kotlin.reflect.KTypeParameter;
import ni.shikatu.kotlin.reflect.KVisibility;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlin.text.Typography;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 P2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001PB\u0013\u0012\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0012\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010\u0002H\u0017J\b\u0010I\u001a\u00020JH\u0002J\u0013\u0010K\u001a\u00020#2\b\u0010L\u001a\u0004\u0018\u00010\u0002H\u0096\u0002J\b\u0010M\u001a\u00020NH\u0016J\b\u0010O\u001a\u00020\u000bH\u0016R\u0018\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0016\u0010\n\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\rR\u001e\u0010\u0010\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00120\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00160\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0014R\u001e\u0010\u0018\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0014R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001c0\u001b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u001f\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R \u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u001b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b'\u0010(\u001a\u0004\b)\u0010\u001eR \u0010*\u001a\b\u0012\u0004\u0012\u00020+0\u001b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b,\u0010(\u001a\u0004\b-\u0010\u001eR(\u0010.\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\u001b8VX\u0097\u0004¢\u0006\f\u0012\u0004\b/\u0010(\u001a\u0004\b0\u0010\u001eR\u001c\u00101\u001a\u0004\u0018\u0001028VX\u0097\u0004¢\u0006\f\u0012\u0004\b3\u0010(\u001a\u0004\b4\u00105R\u001a\u00106\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b7\u0010(\u001a\u0004\b6\u00108R\u001a\u00109\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b:\u0010(\u001a\u0004\b9\u00108R\u001a\u0010;\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b<\u0010(\u001a\u0004\b;\u00108R\u001a\u0010=\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b>\u0010(\u001a\u0004\b=\u00108R\u001a\u0010?\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\b@\u0010(\u001a\u0004\b?\u00108R\u001a\u0010A\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\bB\u0010(\u001a\u0004\bA\u00108R\u001a\u0010C\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\bD\u0010(\u001a\u0004\bC\u00108R\u001a\u0010E\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\bF\u0010(\u001a\u0004\bE\u00108R\u001a\u0010G\u001a\u00020#8VX\u0097\u0004¢\u0006\f\u0012\u0004\bH\u0010(\u001a\u0004\bG\u00108¨\u0006Q"}, d2 = {"Lni/shikatu/kotlin/jvm/internal/ClassReference;", "Lni/shikatu/kotlin/reflect/KClass;", "", "Lni/shikatu/kotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "simpleName", "", "getSimpleName", "()Ljava/lang/String;", "qualifiedName", "getQualifiedName", "members", "", "Lni/shikatu/kotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "constructors", "Lni/shikatu/kotlin/reflect/KFunction;", "getConstructors", "nestedClasses", "getNestedClasses", "annotations", "", "", "getAnnotations", "()Ljava/util/List;", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "isInstance", "", "value", "typeParameters", "Lni/shikatu/kotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "()V", "getTypeParameters", "supertypes", "Lni/shikatu/kotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "visibility", "Lni/shikatu/kotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "isFinal", "isFinal$annotations", "()Z", "isOpen", "isOpen$annotations", "isAbstract", "isAbstract$annotations", "isSealed", "isSealed$annotations", "isData", "isData$annotations", "isInner", "isInner$annotations", "isCompanion", "isCompanion$annotations", "isFun", "isFun$annotations", "isValue", "isValue$annotations", "error", "", "equals", "other", "hashCode", "", "toString", "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer {
    public static final Companion Companion = new Companion(null);
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES;
    private static final HashMap<String, String> classFqNames;
    private static final HashMap<String, String> primitiveFqNames;
    private static final HashMap<String, String> primitiveWrapperFqNames;
    private static final Map<String, String> simpleNames;
    private final Class<?> jClass;

    public static  void getSealedSubclasses$annotations() {
    }

    public static  void getSupertypes$annotations() {
    }

    public static  void getTypeParameters$annotations() {
    }

    public static  void getVisibility$annotations() {
    }

    public static  void isAbstract$annotations() {
    }

    public static  void isCompanion$annotations() {
    }

    public static  void isData$annotations() {
    }

    public static  void isFinal$annotations() {
    }

    public static  void isFun$annotations() {
    }

    public static  void isInner$annotations() {
    }

    public static  void isOpen$annotations() {
    }

    public static  void isSealed$annotations() {
    }

    public static  void isValue$annotations() {
    }

    public ClassReference(Class<?> cls) {
        Intrinsics.checkNotNullParameter(cls, "jClass");
        this.jClass = cls;
    }

    @Override
    public Class<?> getJClass() {
        return this.jClass;
    }

    @Override
    public String getSimpleName() {
        return Companion.getClassSimpleName(getJClass());
    }

    @Override
    public String getQualifiedName() {
        return Companion.getClassQualifiedName(getJClass());
    }

    @Override
    public Collection<KCallable<?>> getMembers() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override
    public Collection<KFunction<Object>> getConstructors() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override
    public Collection<KClass<?>> getNestedClasses() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override
    public List<Annotation> getAnnotations() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override
    public Object getObjectInstance() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override
    public boolean isInstance(Object value) {
        return Companion.isInstance(value, getJClass());
    }

    @Override
    public List<KTypeParameter> getTypeParameters() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override
    public List<KType> getSupertypes() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override
    public List<KClass<? extends Object>> getSealedSubclasses() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override
    public KVisibility getVisibility() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override
    public boolean isFinal() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override
    public boolean isOpen() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override
    public boolean isAbstract() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override
    public boolean isSealed() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override
    public boolean isData() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override
    public boolean isInner() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override
    public boolean isCompanion() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override
    public boolean isFun() {
        error();
        throw new KotlinNothingValueException();
    }

    @Override
    public boolean isValue() {
        error();
        throw new KotlinNothingValueException();
    }

    private final Void error() {
        throw new KotlinReflectionNotSupportedError();
    }

    @Override
    public boolean equals(Object other) {
        return (other instanceof ClassReference) && Intrinsics.areEqual(JvmClassMappingKt.getJavaObjectType(this), JvmClassMappingKt.getJavaObjectType((KClass) other));
    }

    @Override
    public int hashCode() {
        return JvmClassMappingKt.getJavaObjectType(this).hashCode();
    }

    public String toString() {
        return getJClass() + " (Kotlin reflection is not available)";
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u000b2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0006J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\u000b2\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0006J\u001c\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00012\n\u0010\u0012\u001a\u0006\u0012\u0002\b\u00030\u0006R&\u0010\u0004\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\t\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\r\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\u000e\u001a\u001e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nj\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`\fX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0016\u0012\f\u0012\n \u0010*\u0004\u0018\u00010\u000b0\u000b\u0012\u0004\u0012\u00020\u000b0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lni/shikatu/kotlin/jvm/internal/ClassReference$Companion;", "", "<init>", "()V", "FUNCTION_CLASSES", "", "Ljava/lang/Class;", "Lni/shikatu/kotlin/Function;", "", "primitiveFqNames", "Ljava/util/HashMap;", "", "Lni/shikatu/kotlin/collections/HashMap;", "primitiveWrapperFqNames", "classFqNames", "simpleNames", "ni.shikatu.kotlin.jvm.PlatformType", "getClassSimpleName", "jClass", "getClassQualifiedName", "isInstance", "", "value", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getClassSimpleName(Class<?> cls) {
            String str;
            Intrinsics.checkNotNullParameter(cls, "jClass");
            String str2 = null;
            if (cls.isAnonymousClass()) {
                return null;
            }
            if (cls.isLocalClass()) {
                String name = cls.getSimpleName();
                Method method = cls.getEnclosingMethod();
                if (method != null) {
                    Intrinsics.checkNotNull(name);
                    String strSubstringAfter$default = StringsKt.substringAfter$default(name, method.getName() + Typography.dollar, (String) null, 2, (Object) null);
                    if (strSubstringAfter$default != null) {
                        return strSubstringAfter$default;
                    }
                }
                Constructor<?> enclosingConstructor = cls.getEnclosingConstructor();
                if (enclosingConstructor != null) {
                    Intrinsics.checkNotNull(name);
                    return StringsKt.substringAfter$default(name, enclosingConstructor.getName() + Typography.dollar, (String) null, 2, (Object) null);
                }
                Intrinsics.checkNotNull(name);
                return StringsKt.substringAfter$default(name, Typography.dollar, (String) null, 2, (Object) null);
            }
            if (!cls.isArray()) {
                String str3 = (String) ClassReference.simpleNames.get(cls.getName());
                return str3 == null ? cls.getSimpleName() : str3;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (str = (String) ClassReference.simpleNames.get(componentType.getName())) != null) {
                str2 = str + "Array";
            }
            return str2 == null ? "Array" : str2;
        }

        public final String getClassQualifiedName(Class<?> cls) {
            String str;
            Intrinsics.checkNotNullParameter(cls, "jClass");
            String str2 = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (!cls.isArray()) {
                String str3 = (String) ClassReference.classFqNames.get(cls.getName());
                return str3 == null ? cls.getCanonicalName() : str3;
            }
            Class<?> componentType = cls.getComponentType();
            if (componentType.isPrimitive() && (str = (String) ClassReference.classFqNames.get(componentType.getName())) != null) {
                str2 = str + "Array";
            }
            return str2 == null ? "ni.shikatu.kotlin.Array" : str2;
        }

        public final boolean isInstance(Object value, Class<?> cls) {
            Intrinsics.checkNotNullParameter(cls, "jClass");
            Map map = ClassReference.FUNCTION_CLASSES;
            Intrinsics.checkNotNull(map, "null cannot be cast to non-null type kotlin.collections.Map<K of kotlin.collections.MapsKt__MapsKt.get, V of kotlin.collections.MapsKt__MapsKt.get>");
            Integer num = (Integer) map.get(cls);
            if (num != null) {
                int arity = num.intValue();
                return TypeIntrinsics.isFunctionOfArity(value, arity);
            }
            return (cls.isPrimitive() ? JvmClassMappingKt.getJavaObjectType(JvmClassMappingKt.getKotlinClass(cls)) : cls).isInstance(value);
        }
    }

    static {
        Iterable $this$mapIndexed$iv = CollectionsKt.listOf((Object[]) new Class[]{Function0.class, Function1.class, Function2.class, Function3.class, Function4.class, Function5.class, Function6.class, Function7.class, Function8.class, Function9.class, Function10.class, Function11.class, Function12.class, Function13.class, Function14.class, Function15.class, Function16.class, Function17.class, Function18.class, Function19.class, Function20.class, Function21.class, Function22.class});
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$mapIndexed$iv, 10));
        int index$iv$iv = 0;
        for (Object item$iv$iv : $this$mapIndexed$iv) {
            int index$iv$iv2 = index$iv$iv + 1;
            if (index$iv$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            Class clazz = (Class) item$iv$iv;
            destination$iv$iv.add(TuplesKt.to(clazz, Integer.valueOf(index$iv$iv)));
            index$iv$iv = index$iv$iv2;
        }
        FUNCTION_CLASSES = MapsKt.toMap((List) destination$iv$iv);
        HashMap<String, String> map = new HashMap<>();
        map.put("boolean", "ni.shikatu.kotlin.Boolean");
        map.put("char", "ni.shikatu.kotlin.Char");
        map.put("byte", "ni.shikatu.kotlin.Byte");
        map.put("short", "ni.shikatu.kotlin.Short");
        map.put("int", "ni.shikatu.kotlin.Int");
        map.put("float", "ni.shikatu.kotlin.Float");
        map.put("long", "ni.shikatu.kotlin.Long");
        map.put("double", "ni.shikatu.kotlin.Double");
        primitiveFqNames = map;
        HashMap<String, String> map2 = new HashMap<>();
        map2.put("java.lang.Boolean", "ni.shikatu.kotlin.Boolean");
        map2.put("java.lang.Character", "ni.shikatu.kotlin.Char");
        map2.put("java.lang.Byte", "ni.shikatu.kotlin.Byte");
        map2.put("java.lang.Short", "ni.shikatu.kotlin.Short");
        map2.put("java.lang.Integer", "ni.shikatu.kotlin.Int");
        map2.put("java.lang.Float", "ni.shikatu.kotlin.Float");
        map2.put("java.lang.Long", "ni.shikatu.kotlin.Long");
        map2.put("java.lang.Double", "ni.shikatu.kotlin.Double");
        primitiveWrapperFqNames = map2;
        HashMap<String, String> map3 = new HashMap<>();
        map3.put("java.lang.Object", "ni.shikatu.kotlin.Any");
        map3.put("java.lang.String", "ni.shikatu.kotlin.String");
        map3.put("java.lang.CharSequence", "ni.shikatu.kotlin.CharSequence");
        map3.put("java.lang.Throwable", "ni.shikatu.kotlin.Throwable");
        map3.put("java.lang.Cloneable", "ni.shikatu.kotlin.Cloneable");
        map3.put("java.lang.Number", "ni.shikatu.kotlin.Number");
        map3.put("java.lang.Comparable", "ni.shikatu.kotlin.Comparable");
        map3.put("java.lang.Enum", "ni.shikatu.kotlin.Enum");
        map3.put("java.lang.annotation.Annotation", "ni.shikatu.kotlin.Annotation");
        map3.put("java.lang.Iterable", "ni.shikatu.kotlin.collections.Iterable");
        map3.put("java.util.Iterator", "ni.shikatu.kotlin.collections.Iterator");
        map3.put("java.util.Collection", "ni.shikatu.kotlin.collections.Collection");
        map3.put("java.util.List", "ni.shikatu.kotlin.collections.List");
        map3.put("java.util.Set", "ni.shikatu.kotlin.collections.Set");
        map3.put("java.util.ListIterator", "ni.shikatu.kotlin.collections.ListIterator");
        map3.put("java.util.Map", "ni.shikatu.kotlin.collections.Map");
        map3.put("java.util.Map$Entry", "ni.shikatu.kotlin.collections.Map.Entry");
        map3.put("ni.shikatu.kotlin.jvm.internal.StringCompanionObject", "ni.shikatu.kotlin.String.Companion");
        map3.put("ni.shikatu.kotlin.jvm.internal.EnumCompanionObject", "ni.shikatu.kotlin.Enum.Companion");
        map3.putAll(primitiveFqNames);
        map3.putAll(primitiveWrapperFqNames);
        Iterable iterableValues = primitiveFqNames.values();
        Intrinsics.checkNotNullExpressionValue(iterableValues, "<get-values>(...)");
        Iterable $this$associateTo$iv = iterableValues;
        for (Object element$iv : $this$associateTo$iv) {
            String kotlinName = (String) element$iv;
            StringBuilder sbAppend = new StringBuilder().append("ni.shikatu.kotlin.jvm.internal.");
            Intrinsics.checkNotNull(kotlinName);
            Pair pair = TuplesKt.to(sbAppend.append(StringsKt.substringAfterLast$default(kotlinName, '.', (String) null, 2, (Object) null)).append("CompanionObject").toString(), kotlinName + ".Companion");
            map3.put(pair.getFirst(), pair.getSecond());
        }
        for (Map.Entry<Class<? extends Function<?>>, Integer> entry : FUNCTION_CLASSES.entrySet()) {
            Class<? extends Function<?>> key = entry.getKey();
            int arity = entry.getValue().intValue();
            map3.put(key.getName(), "ni.shikatu.kotlin.Function" + arity);
        }
        classFqNames = map3;
        Map $this$mapValues$iv = classFqNames;
        Map destination$iv$iv2 = new LinkedHashMap(MapsKt.mapCapacity($this$mapValues$iv.size()));
        Iterable $this$associateByTo$iv$iv$iv = $this$mapValues$iv.entrySet();
        for (Object element$iv$iv$iv : $this$associateByTo$iv$iv$iv) {
            Map.Entry it$iv$iv = (Map.Entry) element$iv$iv$iv;
            Object key2 = it$iv$iv.getKey();
            String fqName = (String) ((Map.Entry) element$iv$iv$iv).getValue();
            Intrinsics.checkNotNull(fqName);
            destination$iv$iv2.put(key2, StringsKt.substringAfterLast$default(fqName, '.', (String) null, 2, (Object) null));
        }
        simpleNames = destination$iv$iv2;
    }
}
