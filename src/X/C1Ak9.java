package X;

import kotlin.jvm.internal.Intrinsics;

public final class C1Ak9 {
    public final C1AkJ LIZ;
    public final 00pn LIZIZ;

    public C1Ak9(C1AkJ c1AkJ, 00pn r2) {
        this.LIZ = c1AkJ;
        this.LIZIZ = r2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1Ak9)) {
            return false;
        }
        C1Ak9 c1Ak9 = (C1Ak9) obj;
        return Intrinsics.LJFF(this.LIZ, c1Ak9.LIZ) && Intrinsics.LJFF(this.LIZIZ, c1Ak9.LIZIZ);
    }

    public final int hashCode() {
        int iHashCode = this.LIZ.hashCode() * 31;
        00pn r0 = this.LIZIZ;
        return iHashCode + (r0 == null ? 0 : r0.hashCode());
    }

    public final String toString() {
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("LocationModel(sysLocation=");
        sbLIZ.append(this.LIZ);
        sbLIZ.append(", cell=");
        sbLIZ.append(this.LIZIZ);
        sbLIZ.append(')');
        return 0wS0.LIZIZ(sbLIZ);
    }
}
