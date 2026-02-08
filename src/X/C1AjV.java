package X;

import kotlin.jvm.internal.Intrinsics;

public final class C1AjV {
    public final 054j LIZ;
    public final long LIZIZ;

    public C1AjV(054j r1, long j) {
        this.LIZ = r1;
        this.LIZIZ = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1AjV)) {
            return false;
        }
        C1AjV c1AjV = (C1AjV) obj;
        return Intrinsics.LJFF(this.LIZ, c1AjV.LIZ) && this.LIZIZ == c1AjV.LIZIZ;
    }

    public final int hashCode() {
        return (this.LIZ.hashCode() * 31) + 0Vx6.c(this.LIZIZ);
    }

    public final String toString() {
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("ConsumerInfo(options=");
        sbLIZ.append(this.LIZ);
        sbLIZ.append(", startTime=");
        sbLIZ.append(this.LIZIZ);
        sbLIZ.append(')');
        return 0wS0.LIZIZ(sbLIZ);
    }
}
