package Z;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class ad {
    public final long a;
    public final long b;
    public final String c;

    public ad(long j, long j2, String str) {
        this.a = j;
        this.b = j2;
        this.c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ad)) {
            return false;
        }
        ad adVar = (ad) obj;
        return this.a == adVar.a && this.b == adVar.b && Intrinsics.areEqual(this.c, adVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((Long.hashCode(this.b) + (Long.hashCode(this.a) * 31)) * 31);
    }

    public final String toString() {
        long j = this.a;
        long j2 = this.b;
        return ve.a("qnQv29CIznhYHqCc7TT7oa1ZvM3dhgy6lx46Sa4tfnY=", "ZF8kD3Xyps5mUOMk", "aes", new StringBuilder().append("OtaCatalogEntry(stable=").append(j).append(", dynamic=").append(j2), this.c).append(")").toString();
    }
}
