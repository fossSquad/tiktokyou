package ni.shikatu.kotlin.reflect;

import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0011\bF\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016J\b\u0010\n\u001a\u00020\u0002H\u0016J\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fH\u0016¢\u0006\u0002\u0010\u000eJ\n\u0010\u000f\u001a\u00020\tH\u0096\u0080\u0004J\u0014\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0096\u0082\u0004J\n\u0010\u0014\u001a\u00020\u0015H\u0096\u0080\u0004J\n\u0010\u0016\u001a\u00020\tH\u0096\u0080\u0004J)\u0010\u0017\u001a\u0004\u0018\u0001H\u0018\"\b\b\u0000\u0010\u0018*\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u0002H\u00180\u001bH\u0086\u0080\u0004¢\u0006\u0002\u0010\u001cJ\u0015\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00190\fH\u0086\u0080\u0004¢\u0006\u0002\u0010\u001eJ\u0015\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\fH\u0086\u0080\u0004¢\u0006\u0002\u0010\u001eR\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000Ê\u0001\u0002\b!¨\u0006 "}, d2 = {"Lni/shikatu/kotlin/reflect/ObsoleteFallbackTypeVariableImpl;", "Ljava/lang/reflect/TypeVariable;", "Ljava/lang/reflect/GenericDeclaration;", "Lni/shikatu/kotlin/reflect/TypeImpl;", "typeParameter", "Lni/shikatu/kotlin/reflect/KTypeParameter;", "<init>", "(Lkotlin/reflect/KTypeParameter;)V", "getName", _UrlKt.FRAGMENT_ENCODE_SET, "getGenericDeclaration", "getBounds", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/lang/reflect/Type;", "()[Ljava/lang/reflect/Type;", "getTypeName", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "toString", "getAnnotation", "T", _UrlKt.FRAGMENT_ENCODE_SET, "annotationClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)Ljava/lang/annotation/Annotation;", "getAnnotations", "()[Ljava/lang/annotation/Annotation;", "getDeclaredAnnotations", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/ExperimentalStdlibApi;"}, k = 1, mv = {2, 4, 0}, xi = 48)
final class ObsoleteFallbackTypeVariableImpl implements TypeVariable<GenericDeclaration>, TypeImpl {
    private final KTypeParameter typeParameter;

    public ObsoleteFallbackTypeVariableImpl(KTypeParameter typeParameter) {
        Intrinsics.checkNotNullParameter(typeParameter, "typeParameter");
        this.typeParameter = typeParameter;
    }

    @Override
    public String getName() {
        return this.typeParameter.getName();
    }

    @Override
    public GenericDeclaration getGenericDeclaration() {
        throw new UnsupportedOperationException("getGenericDeclaration() is not supported for type variables created from KType: " + this.typeParameter + ".\nUpdate kotlin-reflect dependency to 2.3.20+.");
    }

    @Override
    public Type[] getBounds() {
        Iterable $this$map$iv = this.typeParameter.getUpperBounds();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KType it = (KType) item$iv$iv;
            destination$iv$iv.add(TypesJVMKt.computeJavaType(it, true));
        }
        Collection $this$toTypedArray$iv = (List) destination$iv$iv;
        return (Type[]) $this$toTypedArray$iv.toArray(new Type[0]);
    }

    @Override
    public String getTypeName() {
        return getName();
    }

    public boolean equals(Object other) {
        return (other instanceof TypeVariable) && Intrinsics.areEqual(getName(), ((TypeVariable) other).getName()) && Intrinsics.areEqual(getGenericDeclaration(), ((TypeVariable) other).getGenericDeclaration());
    }

    public int hashCode() {
        return getName().hashCode() ^ getGenericDeclaration().hashCode();
    }

    public String toString() {
        return getTypeName();
    }

    public final <T extends Annotation> T getAnnotation(Class<T> cls) {
        Intrinsics.checkNotNullParameter(cls, "annotationClass");
        return null;
    }

    public final Annotation[] getAnnotations() {
        return new Annotation[0];
    }

    public final Annotation[] getDeclaredAnnotations() {
        return new Annotation[0];
    }
}
