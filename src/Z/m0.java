package Z;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class m0 {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final boolean e;

    public m0(String str, String str2, String str3, String str4, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = z;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof m0)) {
            return false;
        }
        m0 m0Var = (m0) obj;
        return Intrinsics.areEqual(this.a, m0Var.a) && Intrinsics.areEqual(this.b, m0Var.b) && Intrinsics.areEqual(this.c, m0Var.c) && Intrinsics.areEqual(this.d, m0Var.d) && this.e == m0Var.e;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        return Boolean.hashCode(this.e) + ((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    public final String toString() {
        String str = this.a;
        String str2 = this.b;
        String str3 = this.c;
        String str4 = this.d;
        return ((((new StringBuilder()).append("AutoStreakSticker(interactionName=").append(str)).append(", stickerId=").append(str2)).append(", stickerSetId=").append(str3)).append(", url=").append(str4).append(", isDefault=").append(this.e).append(")").toString();
    }
}
