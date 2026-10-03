package ni.shikatu.kotlin.jvm.internal;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import ni.shikatu.kotlin.Function;
import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
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
import ni.shikatu.kotlinx.serialization.internal.CollectionDescriptorsKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u0000 Y2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u00032\u00020\u0004:\u0001YB\u0015\bF\u0012\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006¢\u0006\u0004\b\u0007\u0010\bJ\"\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0002H\u0097\u0080\u0004b\f\b&\u0012\b\b'\u0012\u0004\b\b((J\n\u0010P\u001a\u00020QH\u0082\u0080\u0004J\n\u0010R\u001a\u00020SH\u0096\u0080\u0004J\u0014\u0010T\u001a\u00020$2\b\u0010U\u001a\u0004\u0018\u00010\u0002H\u0096\u0082\u0004J\n\u0010V\u001a\u00020WH\u0096\u0080\u0004J\n\u0010X\u001a\u00020\fH\u0096\u0080\u0004R\u0019\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\u0004\u0018\u00010\f8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0017\u0010\u000f\u001a\u0004\u0018\u00010\f8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u000eR\u001f\u0010\u0011\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00130\u00128VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R!\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\u00170\u00128VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0015R\u001f\u0010\u0019\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\u00128VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0015R\u001b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010 \u001a\u0004\u0018\u00010\u00028VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b!\u0010\"R/\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u001c8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b((¢\u0006\f\u0012\u0004\b+\u0010,\u001a\u0004\b-\u0010\u001fR/\u0010.\u001a\b\u0012\u0004\u0012\u00020/0\u001c8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b((¢\u0006\f\u0012\u0004\b0\u0010,\u001a\u0004\b1\u0010\u001fR7\u00102\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00010\u001c8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b(5¢\u0006\f\u0012\u0004\b3\u0010,\u001a\u0004\b4\u0010\u001fR+\u00106\u001a\u0004\u0018\u0001078VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b((¢\u0006\f\u0012\u0004\b8\u0010,\u001a\u0004\b9\u0010:R)\u0010;\u001a\u00020$8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b((¢\u0006\f\u0012\u0004\b<\u0010,\u001a\u0004\b;\u0010=R)\u0010>\u001a\u00020$8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b((¢\u0006\f\u0012\u0004\b?\u0010,\u001a\u0004\b>\u0010=R)\u0010@\u001a\u00020$8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b((¢\u0006\f\u0012\u0004\bA\u0010,\u001a\u0004\b@\u0010=R)\u0010B\u001a\u00020$8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b((¢\u0006\f\u0012\u0004\bC\u0010,\u001a\u0004\bB\u0010=R)\u0010D\u001a\u00020$8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b((¢\u0006\f\u0012\u0004\bE\u0010,\u001a\u0004\bD\u0010=R)\u0010F\u001a\u00020$8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b((¢\u0006\f\u0012\u0004\bG\u0010,\u001a\u0004\bF\u0010=R)\u0010H\u001a\u00020$8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b((¢\u0006\f\u0012\u0004\bI\u0010,\u001a\u0004\bH\u0010=R)\u0010J\u001a\u00020$8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b(L¢\u0006\f\u0012\u0004\bK\u0010,\u001a\u0004\bJ\u0010=R)\u0010M\u001a\u00020$8VX\u0097\u0084\br\f\b&\u0012\b\b'\u0012\u0004\b\b(O¢\u0006\f\u0012\u0004\bN\u0010,\u001a\u0004\bM\u0010=¨\u0006Z"}, d2 = {"Lni/shikatu/kotlin/jvm/internal/ClassReference;", "Lni/shikatu/kotlin/reflect/KClass;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/jvm/internal/ClassBasedDeclarationContainer;", "Lni/shikatu/kotlin/jvm/internal/KotlinGenericDeclaration;", "jClass", "Ljava/lang/Class;", "<init>", "(Ljava/lang/Class;)V", "getJClass", "()Ljava/lang/Class;", "simpleName", _UrlKt.FRAGMENT_ENCODE_SET, "getSimpleName", "()Ljava/lang/String;", "qualifiedName", "getQualifiedName", "members", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "constructors", "Lni/shikatu/kotlin/reflect/KFunction;", "getConstructors", "nestedClasses", "getNestedClasses", "annotations", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "getAnnotations", "()Ljava/util/List;", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "isInstance", _UrlKt.FRAGMENT_ENCODE_SET, "value", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1", "typeParameters", "Lni/shikatu/kotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "()V", "getTypeParameters", "supertypes", "Lni/shikatu/kotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "1.3", "visibility", "Lni/shikatu/kotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "isFinal", "isFinal$annotations", "()Z", "isOpen", "isOpen$annotations", "isAbstract", "isAbstract$annotations", "isSealed", "isSealed$annotations", "isData", "isData$annotations", "isInner", "isInner$annotations", "isCompanion", "isCompanion$annotations", "isFun", "isFun$annotations", "1.4", "isValue", "isValue$annotations", "1.5", "error", _UrlKt.FRAGMENT_ENCODE_SET, "findJavaDeclaration", "Ljava/lang/reflect/GenericDeclaration;", "equals", "other", "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "toString", "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class ClassReference implements KClass<Object>, ClassBasedDeclarationContainer, KotlinGenericDeclaration {
    public static final Companion Companion = new Companion(null);
    private static final Map<Class<? extends Function<?>>, Integer> FUNCTION_CLASSES;
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
    public GenericDeclaration findJavaDeclaration() {
        return getJClass();
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
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0082\u0080\u0004J\u0014\u0010\f\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\nH\u0082\u0080\u0004J\u0018\u0010\r\u001a\u0004\u0018\u00010\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0086\u0080\u0004J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\n2\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0086\u0080\u0004J \u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0086\u0080\u0004R'\u0010\u0004\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\b\u0001\u0012\u0006\u0012\u0002\b\u00030\u00070\u0006\u0012\u0004\u0012\u00020\b0\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lni/shikatu/kotlin/jvm/internal/ClassReference$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "FUNCTION_CLASSES", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/lang/Class;", "Lni/shikatu/kotlin/Function;", _UrlKt.FRAGMENT_ENCODE_SET, "classFqNameOf", _UrlKt.FRAGMENT_ENCODE_SET, "type", "simpleNameOf", "getClassSimpleName", "jClass", "getClassQualifiedName", "isInstance", _UrlKt.FRAGMENT_ENCODE_SET, "value", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final String classFqNameOf(String type) {
            switch (type.hashCode()) {
                case -2061550653:
                    if (type.equals("ni.shikatu.kotlin.jvm.internal.DoubleCompanionObject")) {
                        return "ni.shikatu.kotlin.Double.Companion";
                    }
                    return null;
                case -2056817302:
                    if (type.equals("java.lang.Integer")) {
                        return "ni.shikatu.kotlin.Int";
                    }
                    return null;
                case -2034166429:
                    if (type.equals("java.lang.Cloneable")) {
                        return "ni.shikatu.kotlin.Cloneable";
                    }
                    return null;
                case -1979556166:
                    if (type.equals("java.lang.annotation.Annotation")) {
                        return "ni.shikatu.kotlin.Annotation";
                    }
                    return null;
                case -1811142716:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function10")) {
                        return "ni.shikatu.kotlin.Function10";
                    }
                    return null;
                case -1811142715:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function11")) {
                        return "ni.shikatu.kotlin.Function11";
                    }
                    return null;
                case -1811142714:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function12")) {
                        return "ni.shikatu.kotlin.Function12";
                    }
                    return null;
                case -1811142713:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function13")) {
                        return "ni.shikatu.kotlin.Function13";
                    }
                    return null;
                case -1811142712:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function14")) {
                        return "ni.shikatu.kotlin.Function14";
                    }
                    return null;
                case -1811142711:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function15")) {
                        return "ni.shikatu.kotlin.Function15";
                    }
                    return null;
                case -1811142710:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function16")) {
                        return "ni.shikatu.kotlin.Function16";
                    }
                    return null;
                case -1811142709:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function17")) {
                        return "ni.shikatu.kotlin.Function17";
                    }
                    return null;
                case -1811142708:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function18")) {
                        return "ni.shikatu.kotlin.Function18";
                    }
                    return null;
                case -1811142707:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function19")) {
                        return "ni.shikatu.kotlin.Function19";
                    }
                    return null;
                case -1811142685:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function20")) {
                        return "ni.shikatu.kotlin.Function20";
                    }
                    return null;
                case -1811142684:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function21")) {
                        return "ni.shikatu.kotlin.Function21";
                    }
                    return null;
                case -1811142683:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function22")) {
                        return "ni.shikatu.kotlin.Function22";
                    }
                    return null;
                case -1571515090:
                    if (type.equals("java.lang.Comparable")) {
                        return "ni.shikatu.kotlin.Comparable";
                    }
                    return null;
                case -1383349348:
                    if (type.equals("java.util.Map")) {
                        return "ni.shikatu.kotlin.collections.Map";
                    }
                    return null;
                case -1383343454:
                    if (type.equals("java.util.Set")) {
                        return "ni.shikatu.kotlin.collections.Set";
                    }
                    return null;
                case -1325958191:
                    if (type.equals("double")) {
                        return "ni.shikatu.kotlin.Double";
                    }
                    return null;
                case -1182275604:
                    if (type.equals("ni.shikatu.kotlin.jvm.internal.ByteCompanionObject")) {
                        return "ni.shikatu.kotlin.Byte.Companion";
                    }
                    return null;
                case -1062240117:
                    if (type.equals("java.lang.CharSequence")) {
                        return "ni.shikatu.kotlin.CharSequence";
                    }
                    return null;
                case -688322466:
                    if (type.equals("java.util.Collection")) {
                        return "ni.shikatu.kotlin.collections.Collection";
                    }
                    return null;
                case -527879800:
                    if (type.equals("java.lang.Float")) {
                        return "ni.shikatu.kotlin.Float";
                    }
                    return null;
                case -515992664:
                    if (type.equals("java.lang.Short")) {
                        return "ni.shikatu.kotlin.Short";
                    }
                    return null;
                case -246476834:
                    if (type.equals("ni.shikatu.kotlin.jvm.internal.CharCompanionObject")) {
                        return "ni.shikatu.kotlin.Char.Companion";
                    }
                    return null;
                case -207262728:
                    if (type.equals("ni.shikatu.kotlin.jvm.internal.LongCompanionObject")) {
                        return "ni.shikatu.kotlin.Long.Companion";
                    }
                    return null;
                case -165139126:
                    if (type.equals("java.util.Map$Entry")) {
                        return "ni.shikatu.kotlin.collections.Map.Entry";
                    }
                    return null;
                case 104431:
                    if (type.equals("int")) {
                        return "ni.shikatu.kotlin.Int";
                    }
                    return null;
                case 3039496:
                    if (type.equals("byte")) {
                        return "ni.shikatu.kotlin.Byte";
                    }
                    return null;
                case 3052374:
                    if (type.equals("char")) {
                        return "ni.shikatu.kotlin.Char";
                    }
                    return null;
                case 3327612:
                    if (type.equals("long")) {
                        return "ni.shikatu.kotlin.Long";
                    }
                    return null;
                case 64711720:
                    if (type.equals("boolean")) {
                        return "ni.shikatu.kotlin.Boolean";
                    }
                    return null;
                case 65821278:
                    if (type.equals("java.util.List")) {
                        return "ni.shikatu.kotlin.collections.List";
                    }
                    return null;
                case 77230534:
                    if (type.equals("ni.shikatu.kotlin.jvm.internal.ShortCompanionObject")) {
                        return "ni.shikatu.kotlin.Short.Companion";
                    }
                    return null;
                case 80123371:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function0")) {
                        return "ni.shikatu.kotlin.Function0";
                    }
                    return null;
                case 80123372:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function1")) {
                        return "ni.shikatu.kotlin.Function1";
                    }
                    return null;
                case 80123373:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function2")) {
                        return "ni.shikatu.kotlin.Function2";
                    }
                    return null;
                case 80123374:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function3")) {
                        return "ni.shikatu.kotlin.Function3";
                    }
                    return null;
                case 80123375:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function4")) {
                        return "ni.shikatu.kotlin.Function4";
                    }
                    return null;
                case 80123376:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function5")) {
                        return "ni.shikatu.kotlin.Function5";
                    }
                    return null;
                case 80123377:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function6")) {
                        return "ni.shikatu.kotlin.Function6";
                    }
                    return null;
                case 80123378:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function7")) {
                        return "ni.shikatu.kotlin.Function7";
                    }
                    return null;
                case 80123379:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function8")) {
                        return "ni.shikatu.kotlin.Function8";
                    }
                    return null;
                case 80123380:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function9")) {
                        return "ni.shikatu.kotlin.Function9";
                    }
                    return null;
                case 97526364:
                    if (type.equals("float")) {
                        return "ni.shikatu.kotlin.Float";
                    }
                    return null;
                case 109413500:
                    if (type.equals("short")) {
                        return "ni.shikatu.kotlin.Short";
                    }
                    return null;
                case 155276373:
                    if (type.equals("java.lang.Character")) {
                        return "ni.shikatu.kotlin.Char";
                    }
                    return null;
                case 226173651:
                    if (type.equals("ni.shikatu.kotlin.jvm.internal.EnumCompanionObject")) {
                        return "ni.shikatu.kotlin.Enum.Companion";
                    }
                    return null;
                case 344809556:
                    if (type.equals("java.lang.Boolean")) {
                        return "ni.shikatu.kotlin.Boolean";
                    }
                    return null;
                case 398507100:
                    if (type.equals("java.lang.Byte")) {
                        return "ni.shikatu.kotlin.Byte";
                    }
                    return null;
                case 398585941:
                    if (type.equals("java.lang.Enum")) {
                        return "ni.shikatu.kotlin.Enum";
                    }
                    return null;
                case 398795216:
                    if (type.equals("java.lang.Long")) {
                        return "ni.shikatu.kotlin.Long";
                    }
                    return null;
                case 482629606:
                    if (type.equals("ni.shikatu.kotlin.jvm.internal.FloatCompanionObject")) {
                        return "ni.shikatu.kotlin.Float.Companion";
                    }
                    return null;
                case 499831342:
                    if (type.equals("java.util.Iterator")) {
                        return "ni.shikatu.kotlin.collections.Iterator";
                    }
                    return null;
                case 577341676:
                    if (type.equals("java.util.ListIterator")) {
                        return "ni.shikatu.kotlin.collections.ListIterator";
                    }
                    return null;
                case 599019395:
                    if (type.equals("ni.shikatu.kotlin.jvm.internal.StringCompanionObject")) {
                        return "ni.shikatu.kotlin.String.Companion";
                    }
                    return null;
                case 761287205:
                    if (type.equals("java.lang.Double")) {
                        return "ni.shikatu.kotlin.Double";
                    }
                    return null;
                case 1052881309:
                    if (type.equals("java.lang.Number")) {
                        return "ni.shikatu.kotlin.Number";
                    }
                    return null;
                case 1063877011:
                    if (type.equals("java.lang.Object")) {
                        return "ni.shikatu.kotlin.Any";
                    }
                    return null;
                case 1195259493:
                    if (type.equals("java.lang.String")) {
                        return "ni.shikatu.kotlin.String";
                    }
                    return null;
                case 1275614662:
                    if (type.equals("java.lang.Iterable")) {
                        return "ni.shikatu.kotlin.collections.Iterable";
                    }
                    return null;
                case 1383693018:
                    if (type.equals("ni.shikatu.kotlin.jvm.internal.BooleanCompanionObject")) {
                        return "ni.shikatu.kotlin.Boolean.Companion";
                    }
                    return null;
                case 1630335596:
                    if (type.equals("java.lang.Throwable")) {
                        return "ni.shikatu.kotlin.Throwable";
                    }
                    return null;
                case 1877171123:
                    if (type.equals("ni.shikatu.kotlin.jvm.internal.IntCompanionObject")) {
                        return "ni.shikatu.kotlin.Int.Companion";
                    }
                    return null;
                default:
                    return null;
            }
        }

        private final String simpleNameOf(String type) {
            switch (type.hashCode()) {
                case -2061550653:
                    if (type.equals("ni.shikatu.kotlin.jvm.internal.DoubleCompanionObject")) {
                        return "Companion";
                    }
                    return null;
                case -2056817302:
                    if (type.equals("java.lang.Integer")) {
                        return "Int";
                    }
                    return null;
                case -2034166429:
                    if (type.equals("java.lang.Cloneable")) {
                        return "Cloneable";
                    }
                    return null;
                case -1979556166:
                    if (type.equals("java.lang.annotation.Annotation")) {
                        return "Annotation";
                    }
                    return null;
                case -1811142716:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function10")) {
                        return "Function10";
                    }
                    return null;
                case -1811142715:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function11")) {
                        return "Function11";
                    }
                    return null;
                case -1811142714:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function12")) {
                        return "Function12";
                    }
                    return null;
                case -1811142713:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function13")) {
                        return "Function13";
                    }
                    return null;
                case -1811142712:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function14")) {
                        return "Function14";
                    }
                    return null;
                case -1811142711:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function15")) {
                        return "Function15";
                    }
                    return null;
                case -1811142710:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function16")) {
                        return "Function16";
                    }
                    return null;
                case -1811142709:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function17")) {
                        return "Function17";
                    }
                    return null;
                case -1811142708:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function18")) {
                        return "Function18";
                    }
                    return null;
                case -1811142707:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function19")) {
                        return "Function19";
                    }
                    return null;
                case -1811142685:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function20")) {
                        return "Function20";
                    }
                    return null;
                case -1811142684:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function21")) {
                        return "Function21";
                    }
                    return null;
                case -1811142683:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function22")) {
                        return "Function22";
                    }
                    return null;
                case -1571515090:
                    if (type.equals("java.lang.Comparable")) {
                        return "Comparable";
                    }
                    return null;
                case -1383349348:
                    if (type.equals("java.util.Map")) {
                        return "Map";
                    }
                    return null;
                case -1383343454:
                    if (type.equals("java.util.Set")) {
                        return "Set";
                    }
                    return null;
                case -1325958191:
                    if (type.equals("double")) {
                        return "Double";
                    }
                    return null;
                case -1182275604:
                    if (type.equals("ni.shikatu.kotlin.jvm.internal.ByteCompanionObject")) {
                        return "Companion";
                    }
                    return null;
                case -1062240117:
                    if (type.equals("java.lang.CharSequence")) {
                        return "CharSequence";
                    }
                    return null;
                case -688322466:
                    if (type.equals("java.util.Collection")) {
                        return "Collection";
                    }
                    return null;
                case -527879800:
                    if (type.equals("java.lang.Float")) {
                        return "Float";
                    }
                    return null;
                case -515992664:
                    if (type.equals("java.lang.Short")) {
                        return "Short";
                    }
                    return null;
                case -246476834:
                    if (type.equals("ni.shikatu.kotlin.jvm.internal.CharCompanionObject")) {
                        return "Companion";
                    }
                    return null;
                case -207262728:
                    if (type.equals("ni.shikatu.kotlin.jvm.internal.LongCompanionObject")) {
                        return "Companion";
                    }
                    return null;
                case -165139126:
                    if (type.equals("java.util.Map$Entry")) {
                        return "Entry";
                    }
                    return null;
                case 104431:
                    if (type.equals("int")) {
                        return "Int";
                    }
                    return null;
                case 3039496:
                    if (type.equals("byte")) {
                        return "Byte";
                    }
                    return null;
                case 3052374:
                    if (type.equals("char")) {
                        return "Char";
                    }
                    return null;
                case 3327612:
                    if (type.equals("long")) {
                        return "Long";
                    }
                    return null;
                case 64711720:
                    if (type.equals("boolean")) {
                        return "Boolean";
                    }
                    return null;
                case 65821278:
                    if (type.equals("java.util.List")) {
                        return "List";
                    }
                    return null;
                case 77230534:
                    if (type.equals("ni.shikatu.kotlin.jvm.internal.ShortCompanionObject")) {
                        return "Companion";
                    }
                    return null;
                case 80123371:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function0")) {
                        return "Function0";
                    }
                    return null;
                case 80123372:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function1")) {
                        return "Function1";
                    }
                    return null;
                case 80123373:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function2")) {
                        return "Function2";
                    }
                    return null;
                case 80123374:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function3")) {
                        return "Function3";
                    }
                    return null;
                case 80123375:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function4")) {
                        return "Function4";
                    }
                    return null;
                case 80123376:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function5")) {
                        return "Function5";
                    }
                    return null;
                case 80123377:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function6")) {
                        return "Function6";
                    }
                    return null;
                case 80123378:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function7")) {
                        return "Function7";
                    }
                    return null;
                case 80123379:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function8")) {
                        return "Function8";
                    }
                    return null;
                case 80123380:
                    if (type.equals("ni.shikatu.kotlin.jvm.functions.Function9")) {
                        return "Function9";
                    }
                    return null;
                case 97526364:
                    if (type.equals("float")) {
                        return "Float";
                    }
                    return null;
                case 109413500:
                    if (type.equals("short")) {
                        return "Short";
                    }
                    return null;
                case 155276373:
                    if (type.equals("java.lang.Character")) {
                        return "Char";
                    }
                    return null;
                case 226173651:
                    if (type.equals("ni.shikatu.kotlin.jvm.internal.EnumCompanionObject")) {
                        return "Companion";
                    }
                    return null;
                case 344809556:
                    if (type.equals("java.lang.Boolean")) {
                        return "Boolean";
                    }
                    return null;
                case 398507100:
                    if (type.equals("java.lang.Byte")) {
                        return "Byte";
                    }
                    return null;
                case 398585941:
                    if (type.equals("java.lang.Enum")) {
                        return "Enum";
                    }
                    return null;
                case 398795216:
                    if (type.equals("java.lang.Long")) {
                        return "Long";
                    }
                    return null;
                case 482629606:
                    if (type.equals("ni.shikatu.kotlin.jvm.internal.FloatCompanionObject")) {
                        return "Companion";
                    }
                    return null;
                case 499831342:
                    if (type.equals("java.util.Iterator")) {
                        return "Iterator";
                    }
                    return null;
                case 577341676:
                    if (type.equals("java.util.ListIterator")) {
                        return "ListIterator";
                    }
                    return null;
                case 599019395:
                    if (type.equals("ni.shikatu.kotlin.jvm.internal.StringCompanionObject")) {
                        return "Companion";
                    }
                    return null;
                case 761287205:
                    if (type.equals("java.lang.Double")) {
                        return "Double";
                    }
                    return null;
                case 1052881309:
                    if (type.equals("java.lang.Number")) {
                        return "Number";
                    }
                    return null;
                case 1063877011:
                    if (type.equals("java.lang.Object")) {
                        return "Any";
                    }
                    return null;
                case 1195259493:
                    if (type.equals("java.lang.String")) {
                        return "String";
                    }
                    return null;
                case 1275614662:
                    if (type.equals("java.lang.Iterable")) {
                        return "Iterable";
                    }
                    return null;
                case 1383693018:
                    if (type.equals("ni.shikatu.kotlin.jvm.internal.BooleanCompanionObject")) {
                        return "Companion";
                    }
                    return null;
                case 1630335596:
                    if (type.equals("java.lang.Throwable")) {
                        return "Throwable";
                    }
                    return null;
                case 1877171123:
                    if (type.equals("ni.shikatu.kotlin.jvm.internal.IntCompanionObject")) {
                        return "Companion";
                    }
                    return null;
                default:
                    return null;
            }
        }

        public final String getClassSimpleName(Class<?> cls) {
            Intrinsics.checkNotNullParameter(cls, "jClass");
            String str = null;
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
            if (cls.isArray()) {
                Class<?> componentType = cls.getComponentType();
                if (componentType.isPrimitive()) {
                    String name2 = componentType.getName();
                    Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
                    String strSimpleNameOf = simpleNameOf(name2);
                    if (strSimpleNameOf != null) {
                        str = strSimpleNameOf + "Array";
                    }
                }
                return str == null ? "Array" : str;
            }
            String name3 = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name3, "getName(...)");
            String strSimpleNameOf2 = simpleNameOf(name3);
            return strSimpleNameOf2 == null ? cls.getSimpleName() : strSimpleNameOf2;
        }

        public final String getClassQualifiedName(Class<?> cls) {
            Intrinsics.checkNotNullParameter(cls, "jClass");
            String str = null;
            if (cls.isAnonymousClass() || cls.isLocalClass()) {
                return null;
            }
            if (cls.isArray()) {
                Class<?> componentType = cls.getComponentType();
                if (componentType.isPrimitive()) {
                    String name = componentType.getName();
                    Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
                    String strClassFqNameOf = classFqNameOf(name);
                    if (strClassFqNameOf != null) {
                        str = strClassFqNameOf + "Array";
                    }
                }
                return str == null ? CollectionDescriptorsKt.ARRAY_NAME : str;
            }
            String name2 = cls.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "getName(...)");
            String strClassFqNameOf2 = classFqNameOf(name2);
            return strClassFqNameOf2 == null ? cls.getCanonicalName() : strClassFqNameOf2;
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
    }
}
