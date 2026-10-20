package Z;

import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class yj {
    public final String a;
    public final String b;

    public yj(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof yj)) {
            return false;
        }
        yj yjVar = (yj) obj;
        return Intrinsics.areEqual(this.a, yjVar.a) && Intrinsics.areEqual(this.b, yjVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "Target(idName=" + this.a + ", path=" + this.b + ")";
    }
}
