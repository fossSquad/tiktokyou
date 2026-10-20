package Z;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class d0 {
    public final String a;
    public final String b;
    public final Object c;

    public d0(Object obj, String str, String str2) {
        this.a = str;
        this.b = str2;
        this.c = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d0)) {
            return false;
        }
        d0 d0Var = (d0) obj;
        return Intrinsics.areEqual(this.a, d0Var.a) && Intrinsics.areEqual(this.b, d0Var.b) && Intrinsics.areEqual(this.c, d0Var.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        String str = this.a;
        String str2 = this.b;
        return ((new StringBuilder()).append("AutoStreakPartner(uid=").append(str)).append(", conversationId=").append(str2).append(", streakData=").append(this.c).append(")").toString();
    }
}
