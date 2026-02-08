package X;

import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

public final class C1AkL {
    public static final  int LJII = 0;
    public final String LIZ;
    public final long LIZIZ;
    public final long LIZJ;
    public final long LIZLLL;
    public final List<String> LJ;
    public final long LJFF;
    public final Map<String, String> LJI;

    public C1AkL(String str, long j, long j2, long j3, List<String> list, long j4, Map<String, String> map) {
        this.LIZ = str;
        this.LIZIZ = j;
        this.LIZJ = j2;
        this.LIZLLL = j3;
        this.LJ = list;
        this.LJFF = j4;
        this.LJI = map;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1AkL)) {
            return false;
        }
        C1AkL c1AkL = (C1AkL) obj;
        return Intrinsics.LJFF(this.LIZ, c1AkL.LIZ) && this.LIZIZ == c1AkL.LIZIZ && this.LIZJ == c1AkL.LIZJ && this.LIZLLL == c1AkL.LIZLLL && Intrinsics.LJFF(this.LJ, c1AkL.LJ) && this.LJFF == c1AkL.LJFF && Intrinsics.LJFF(this.LJI, c1AkL.LJI);
    }

    public final int hashCode() {
        return (((((((((((this.LIZ.hashCode() * 31) + 0Vx6.c(this.LIZIZ)) * 31) + 0Vx6.c(this.LIZJ)) * 31) + 0Vx6.c(this.LIZLLL)) * 31) + this.LJ.hashCode()) * 31) + 0Vx6.c(this.LJFF)) * 31) + this.LJI.hashCode();
    }

    public final String toString() {
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("WifiRequestModel(uploadSource=");
        sbLIZ.append(this.LIZ);
        sbLIZ.append(", l0Id=");
        sbLIZ.append(this.LIZIZ);
        sbLIZ.append(", l1Id=");
        sbLIZ.append(this.LIZJ);
        sbLIZ.append(", l2Id=");
        sbLIZ.append(this.LIZLLL);
        sbLIZ.append(", list=");
        sbLIZ.append(this.LJ);
        sbLIZ.append(", timestamp=");
        sbLIZ.append(this.LJFF);
        sbLIZ.append(", extra=");
        sbLIZ.append(this.LJI);
        sbLIZ.append(')');
        return 0wS0.LIZIZ(sbLIZ);
    }
}
