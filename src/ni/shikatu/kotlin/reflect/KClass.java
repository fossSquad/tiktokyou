package ni.shikatu.kotlin.reflect;

import java.util.Collection;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u001b\n\u0002\u0010\b\n\u0000\bf\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005J\"\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0002H§\u0080\u0004b\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001eJ\u0014\u0010H\u001a\u00020\u001a2\b\u0010I\u001a\u0004\u0018\u00010\u0002H¦\u0082\u0004J\n\u0010J\u001a\u00020KH¦\u0080\u0004R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0007X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0015\u0010\n\u001a\u0004\u0018\u00010\u0007X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u001d\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\rX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001f\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00120\rX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0010R\u001d\u0010\u0014\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00000\rX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0010R\u0015\u0010\u0016\u001a\u0004\u0018\u00018\u0000X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R/\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\f\u0012\u0004\b\"\u0010#\u001a\u0004\b$\u0010%R/\u0010&\u001a\b\u0012\u0004\u0012\u00020'0 8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\f\u0012\u0004\b(\u0010#\u001a\u0004\b)\u0010%R7\u0010*\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u00000 8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(-¢\u0006\f\u0012\u0004\b+\u0010#\u001a\u0004\b,\u0010%R+\u0010.\u001a\u0004\u0018\u00010/8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\f\u0012\u0004\b0\u0010#\u001a\u0004\b1\u00102R)\u00103\u001a\u00020\u001a8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\f\u0012\u0004\b4\u0010#\u001a\u0004\b3\u00105R)\u00106\u001a\u00020\u001a8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\f\u0012\u0004\b7\u0010#\u001a\u0004\b6\u00105R)\u00108\u001a\u00020\u001a8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\f\u0012\u0004\b9\u0010#\u001a\u0004\b8\u00105R)\u0010:\u001a\u00020\u001a8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\f\u0012\u0004\b;\u0010#\u001a\u0004\b:\u00105R)\u0010<\u001a\u00020\u001a8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\f\u0012\u0004\b=\u0010#\u001a\u0004\b<\u00105R)\u0010>\u001a\u00020\u001a8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\f\u0012\u0004\b?\u0010#\u001a\u0004\b>\u00105R)\u0010@\u001a\u00020\u001a8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(\u001e¢\u0006\f\u0012\u0004\bA\u0010#\u001a\u0004\b@\u00105R)\u0010B\u001a\u00020\u001a8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(D¢\u0006\f\u0012\u0004\bC\u0010#\u001a\u0004\bB\u00105R)\u0010E\u001a\u00020\u001a8&X§\u0084\br\f\b\u001c\u0012\b\b\u001d\u0012\u0004\b\b(G¢\u0006\f\u0012\u0004\bF\u0010#\u001a\u0004\bE\u00105¨\u0006L"}, d2 = {"Lni/shikatu/kotlin/reflect/KClass;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/reflect/KDeclarationContainer;", "Lni/shikatu/kotlin/reflect/KAnnotatedElement;", "Lni/shikatu/kotlin/reflect/KClassifier;", "simpleName", _UrlKt.FRAGMENT_ENCODE_SET, "getSimpleName", "()Ljava/lang/String;", "qualifiedName", "getQualifiedName", "members", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "constructors", "Lni/shikatu/kotlin/reflect/KFunction;", "getConstructors", "nestedClasses", "getNestedClasses", "objectInstance", "getObjectInstance", "()Ljava/lang/Object;", "isInstance", _UrlKt.FRAGMENT_ENCODE_SET, "value", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1", "typeParameters", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/reflect/KTypeParameter;", "getTypeParameters$annotations", "()V", "getTypeParameters", "()Ljava/util/List;", "supertypes", "Lni/shikatu/kotlin/reflect/KType;", "getSupertypes$annotations", "getSupertypes", "sealedSubclasses", "getSealedSubclasses$annotations", "getSealedSubclasses", "1.3", "visibility", "Lni/shikatu/kotlin/reflect/KVisibility;", "getVisibility$annotations", "getVisibility", "()Lkotlin/reflect/KVisibility;", "isFinal", "isFinal$annotations", "()Z", "isOpen", "isOpen$annotations", "isAbstract", "isAbstract$annotations", "isSealed", "isSealed$annotations", "isData", "isData$annotations", "isInner", "isInner$annotations", "isCompanion", "isCompanion$annotations", "isFun", "isFun$annotations", "1.4", "isValue", "isValue$annotations", "1.5", "equals", "other", "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface KClass<T> extends KDeclarationContainer, KAnnotatedElement, KClassifier {

    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    public static final class DefaultImpls {
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
    }

    boolean equals(Object obj);

    Collection<KFunction<T>> getConstructors();

    @Override
    Collection<KCallable<?>> getMembers();

    Collection<KClass<?>> getNestedClasses();

    T getObjectInstance();

    String getQualifiedName();

    List<KClass<? extends T>> getSealedSubclasses();

    String getSimpleName();

    List<KType> getSupertypes();

    List<KTypeParameter> getTypeParameters();

    KVisibility getVisibility();

    int hashCode();

    boolean isAbstract();

    boolean isCompanion();

    boolean isData();

    boolean isFinal();

    boolean isFun();

    boolean isInner();

    boolean isInstance(Object obj);

    boolean isOpen();

    boolean isSealed();

    boolean isValue();
}
