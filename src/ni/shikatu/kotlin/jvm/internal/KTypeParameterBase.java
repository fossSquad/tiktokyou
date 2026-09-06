package ni.shikatu.kotlin.jvm.internal;

import java.lang.reflect.GenericDeclaration;
import ni.shikatu.kotlin.Lazy;
import ni.shikatu.kotlin.LazyKt;
import ni.shikatu.kotlin.LazyThreadSafetyMode;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.reflect.KTypeParameter;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b&\u0018\u00002\u00020\u0001B\u0015\bF\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0003H\u0096\u0082\u0004J\n\u0010\u0012\u001a\u00020\u0013H\u0096\u0080\u0004J\n\u0010\u0014\u001a\u00020\u0015H\u0096\u0080\u0004R\u0019\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u0004\u0018\u00010\n8@X\u0080\u0084\n¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0016"}, d2 = {"Lni/shikatu/kotlin/jvm/internal/KTypeParameterBase;", "Lni/shikatu/kotlin/reflect/KTypeParameter;", "container", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/jvm/internal/TypeParameterContainer;", "<init>", "(Ljava/lang/Object;)V", "getContainer$kotlin_stdlib", "()Ljava/lang/Object;", "javaContainingDeclaration", "Ljava/lang/reflect/GenericDeclaration;", "getJavaContainingDeclaration$kotlin_stdlib", "()Ljava/lang/reflect/GenericDeclaration;", "javaContainingDeclaration$delegate", "Lni/shikatu/kotlin/Lazy;", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "toString", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public abstract class KTypeParameterBase implements KTypeParameter {
    private final Object container;
    private final Lazy javaContainingDeclaration$delegate;

    public KTypeParameterBase(Object container) {
        Intrinsics.checkNotNullParameter(container, "container");
        this.container = container;
        this.javaContainingDeclaration$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() {
            @Override
            public final Object invoke() {
                return KTypeParameterBase.javaContainingDeclaration_delegate$lambda$0(this.f$0);
            }
        });
    }

    public final Object getContainer$kotlin_stdlib() {
        return this.container;
    }

    public final GenericDeclaration getJavaContainingDeclaration$kotlin_stdlib() {
        return (GenericDeclaration) this.javaContainingDeclaration$delegate.getValue();
    }

    public static final GenericDeclaration javaContainingDeclaration_delegate$lambda$0(KTypeParameterBase this$0) {
        Object obj = this$0.container;
        KotlinGenericDeclaration kotlinGenericDeclaration = obj instanceof KotlinGenericDeclaration ? (KotlinGenericDeclaration) obj : null;
        if (kotlinGenericDeclaration != null) {
            return kotlinGenericDeclaration.findJavaDeclaration();
        }
        return null;
    }

    public boolean equals(Object other) {
        return (other instanceof KTypeParameterBase) && Intrinsics.areEqual(getName(), ((KTypeParameterBase) other).getName()) && Intrinsics.areEqual(this.container, ((KTypeParameterBase) other).container);
    }

    public int hashCode() {
        return (this.container.hashCode() * 31) + getName().hashCode();
    }

    public String toString() {
        return TypeParameterReference.Companion.toString(this);
    }
}
