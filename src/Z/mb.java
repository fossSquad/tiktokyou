package Z;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class mb {
    public final long a;
    public final long b;
    public final String c;

    public mb(long j, long j2, String str) {
        this.a = j;
        this.b = j2;
        this.c = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof mb)) {
            return false;
        }
        mb mbVar = (mb) obj;
        return this.a == mbVar.a && this.b == mbVar.b && Intrinsics.areEqual(this.c, mbVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((Long.hashCode(this.b) + (Long.hashCode(this.a) * 31)) * 31);
    }

    public final String toString() {
        long j = this.a;
        long j2 = this.b;
        return new StringBuilder().append("OtaCatalogEntry(stable=").append(j).append(", dynamic=").append(j2).append(", url=").append(this.c).append(")").toString();
    }
}
