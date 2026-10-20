package Z;

import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class aj {
    public final int a;
    public final String b;
    public final String c;

    public aj(int i, String str, String str2) {
        this.a = i;
        this.b = str;
        this.c = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof aj)) {
            return false;
        }
        aj ajVar = (aj) obj;
        return this.a == ajVar.a && Intrinsics.areEqual(this.b, ajVar.b) && Intrinsics.areEqual(this.c, ajVar.c);
    }

    public final int hashCode() {
        int iHashCode = Integer.hashCode(this.a) * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    public final String toString() {
        return "PathStep(index=" + this.a + ", className=" + this.b + ", leafId=" + this.c + ")";
    }
}
