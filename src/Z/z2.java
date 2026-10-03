package Z;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class z2 {
    public final a3 a;
    public final a3 b;

    public z2(a3 a3Var, a3 a3Var2) {
        this.a = a3Var;
        this.b = a3Var2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z2)) {
            return false;
        }
        z2 z2Var = (z2) obj;
        return Intrinsics.areEqual(this.a, z2Var.a) && Intrinsics.areEqual(this.b, z2Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "DashSelection(video=" + this.a + ", audio=" + this.b + ")";
    }
}
