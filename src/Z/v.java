package Z;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class v {
    public final String a;
    public final String b;
    public final Object c;

    public v(Object obj, String str, String str2) {
        this.a = str;
        this.b = str2;
        this.c = obj;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof v)) {
            return false;
        }
        v vVar = (v) obj;
        return Intrinsics.areEqual(this.a, vVar.a) && Intrinsics.areEqual(this.b, vVar.b) && Intrinsics.areEqual(this.c, vVar.c);
    }

    public final int hashCode() {
        return this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        String str = this.a;
        String str2 = this.b;
        return new StringBuilder().append("AutoStreakPartner(uid=").append(str).append(", conversationId=").append(str2).append(", streakData=").append(this.c).append(")").toString();
    }
}
