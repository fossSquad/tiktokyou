package Z;
import java.util.List;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class y3 {
    public final List a;
    public final long b;

    public y3(List list, long j) {
        this.a = list;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof y3)) {
            return false;
        }
        y3 y3Var = (y3) obj;
        return Intrinsics.areEqual(this.a, y3Var.a) && this.b == y3Var.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "CacheEntry(choices=" + this.a + ", createdAtMs=" + this.b + ")";
    }
}
