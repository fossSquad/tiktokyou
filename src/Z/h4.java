package Z;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class h4 implements j4 {
    public final g4 a;

    public h4(g4 g4Var) {
        this.a = g4Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof h4) && Intrinsics.areEqual(this.a, ((h4) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Loading(loader=" + this.a + ")";
    }
}
