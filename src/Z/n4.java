package Z;
import java.util.List;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class n4 {
    public final List a;
    public final long b;

    public n4(List list, long j) {
        this.a = list;
        this.b = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n4)) {
            return false;
        }
        n4 n4Var = (n4) obj;
        return Intrinsics.areEqual(this.a, n4Var.a) && this.b == n4Var.b;
    }

    public final int hashCode() {
        return Long.hashCode(this.b) + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "CacheEntry(choices=" + this.a + ", createdAtMs=" + this.b + ")";
    }
}
