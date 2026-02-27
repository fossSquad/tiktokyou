package ni.shikatu.kotlin.jvm.internal;

import java.util.Collection;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.KotlinReflectionNotSupportedError;
import ni.shikatu.kotlin.reflect.KCallable;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0096\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0005H\u0016R\u0018\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\f0\u000b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u0016"}, d2 = {"Lni/shikatu/kotlin/jvm/internal/PackageReference;", "Lni/shikatu/kotlin/jvm/internal/ClassBasedDeclarationContainer;", "jClass", "Ljava/lang/Class;", "moduleName", "", "<init>", "(Ljava/lang/Class;Ljava/lang/String;)V", "getJClass", "()Ljava/lang/Class;", "members", "", "Lni/shikatu/kotlin/reflect/KCallable;", "getMembers", "()Ljava/util/Collection;", "equals", "", "other", "", "hashCode", "", "toString", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class PackageReference implements ClassBasedDeclarationContainer {
    private final Class<?> jClass;
    private final String moduleName;

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
        return getJClass() + " (Kotlin reflection is not available)";
    }
}
