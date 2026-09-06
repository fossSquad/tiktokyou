package Z;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.internal.PluginExceptionsKt;

public final class p1 {
    public final String a;
    public final boolean b;
    public final String c;
    public final String d;
    public final Boolean e;
    public final String f;
    public final String g;

    public p1(int i, String str, boolean z, String str2, String str3, Boolean bool, String str4, String str5) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, o1.b);
        }
        this.a = str;
        if ((i & 2) == 0) {
            this.b = false;
        } else {
            this.b = z;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = str2;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = str3;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = bool;
        }
        if ((i & 32) == 0) {
            this.f = null;
        } else {
            this.f = str4;
        }
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = str5;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p1)) {
            return false;
        }
        p1 p1Var = (p1) obj;
        return Intrinsics.areEqual(this.a, p1Var.a) && this.b == p1Var.b && Intrinsics.areEqual(this.c, p1Var.c) && Intrinsics.areEqual(this.d, p1Var.d) && Intrinsics.areEqual(this.e, p1Var.e) && Intrinsics.areEqual(this.f, p1Var.f) && Intrinsics.areEqual(this.g, p1Var.g);
    }

    public final int hashCode() {
        int iHashCode = (Boolean.hashCode(this.b) + (this.a.hashCode() * 31)) * 31;
        String str = this.c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.e;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.f;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.g;
        return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        String str = this.a;
        boolean z = this.b;
        String str2 = this.c;
        String str3 = this.d;
        Boolean bool = this.e;
        String str4 = this.f;
        return new StringBuilder().append("BadgePayload(uid=").append(str).append(", isDeveloper=").append(z).append(", status=").append(str2).append(", badgeUrl=").append(str3).append(", tinted=").append(bool).append(", text=").append(str4).append(", bannerUrl=").append(this.g).append(")").toString();
    }
}
