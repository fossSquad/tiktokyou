package X;

import kotlin.jvm.internal.Intrinsics;

public final class C1AjZ {
    public static final  int LIZLLL = 0;
    public final C1Ajl LIZ;
    public final int LIZIZ;
    public final String LIZJ;

    public C1AjZ(C1Ajl c1Ajl, int i, String str) {
        this.LIZ = c1Ajl;
        this.LIZIZ = i;
        this.LIZJ = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1AjZ)) {
            return false;
        }
        C1AjZ c1AjZ = (C1AjZ) obj;
        return Intrinsics.LJFF(this.LIZ, c1AjZ.LIZ) && this.LIZIZ == c1AjZ.LIZIZ && Intrinsics.LJFF(this.LIZJ, c1AjZ.LIZJ);
    }

    public final int hashCode() {
        return (((this.LIZ.hashCode() * 31) + this.LIZIZ) * 31) + this.LIZJ.hashCode();
    }

    public final String toString() {
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("StrategyResult(context=");
        sbLIZ.append(this.LIZ);
        sbLIZ.append(", errCode=");
        sbLIZ.append(this.LIZIZ);
        sbLIZ.append(", errMsg=");
        sbLIZ.append(this.LIZJ);
        sbLIZ.append(')');
        return 0wS0.LIZIZ(sbLIZ);
    }
}
