package Z;

import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class bj {
    public final String a;
    public final String b;

    public bj(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bj)) {
            return false;
        }
        bj bjVar = (bj) obj;
        return Intrinsics.areEqual(this.a, bjVar.a) && Intrinsics.areEqual(this.b, bjVar.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "ResolvedTarget(idName=" + this.a + ", path=" + this.b + ")";
    }
}
