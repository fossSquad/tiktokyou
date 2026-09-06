package ni.shikatu.kotlin.jvm.internal;

import java.util.Collection;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.KotlinReflectionNotSupportedError;
import ni.shikatu.kotlin.reflect.KCallable;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001d\bF\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0014\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0096\u0082\u0004J\n\u0010\u0015\u001a\u00020\u0016H\u0096\u0080\u0004J\n\u0010\u0017\u001a\u00020\u0005H\u0096\u0080\u0004R\u0019\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\b\n\u0000\u0012\u0004\b\n\u0010\u000bR\u001f\u0010\f\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000e0\r8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010Ê\u0001\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b¨\u0006\u0018"}, d2 = {"Lni/shikatu/kotlin/jvm/internal/PackageReference;", "Lni/shikatu/kotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "moduleName", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/Class;Ljava/lang/String;)V", "getJClass", "()Ljava/lang/Class;", "getModuleName$annotations", "()V", "members", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "toString", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class PackageReference implements ClassBasedDeclarationContainer {
    private final Class<?> jClass;
    private final String moduleName;

    private static  void getModuleName$annotations() {
    }

    public PackageReference(Class<?> cls, String moduleName) {
        Intrinsics.checkNotNullParameter(cls, "jClass");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        this.jClass = cls;
        this.moduleName = moduleName;
    }

    @Override
    public Class<?> getJClass() {
        return this.jClass;
    }

    @Override
    public Collection<KCallable<?>> getMembers() {
        throw new KotlinReflectionNotSupportedError();
    }

    public boolean equals(Object other) {
        return (other instanceof PackageReference) && Intrinsics.areEqual(getJClass(), ((PackageReference) other).getJClass());
    }

    public int hashCode() {
        return getJClass().hashCode();
    }

    public String toString() {
        return getJClass().toString() + " (Kotlin reflection is not available)";
    }
}
