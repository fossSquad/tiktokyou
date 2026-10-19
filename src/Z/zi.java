package Z;

import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class zi {
    public final wj a;
    public final int b;
    public final float c;

    public zi(wj wjVar, int i, float f) {
        this.a = wjVar;
        this.b = i;
        this.c = f;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zi)) {
            return false;
        }
        zi ziVar = (zi) obj;
        return Intrinsics.areEqual(this.a, ziVar.a) && this.b == ziVar.b && Float.compare(this.c, ziVar.c) == 0;
    }

    public final int hashCode() {
        return Float.hashCode(this.c) + ((Integer.hashCode(this.b) + (this.a.hashCode() * 31)) * 31);
    }

    public final String toString() {
        return "Applied(rule=" + this.a + ", oldVisibility=" + this.b + ", oldAlpha=" + this.c + ")";
    }
}
