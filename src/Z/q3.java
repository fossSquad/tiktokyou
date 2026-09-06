package Z;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class q3 implements s3 {
    public final p3 a;

    public q3(p3 p3Var) {
        this.a = p3Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof q3) && Intrinsics.areEqual(this.a, ((q3) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Loading(loader=" + this.a + ")";
    }
}
