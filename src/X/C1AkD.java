package X;

public final class C1AkD {
    public final int LIZ;
    public final int LIZIZ;
    public final int LIZJ;
    public final int LIZLLL;

    public C1AkD(int i, int i2, int i3, int i4) {
        this.LIZ = i;
        this.LIZIZ = i2;
        this.LIZJ = i3;
        this.LIZLLL = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1AkD)) {
            return false;
        }
        C1AkD c1AkD = (C1AkD) obj;
        return this.LIZ == c1AkD.LIZ && this.LIZIZ == c1AkD.LIZIZ && this.LIZJ == c1AkD.LIZJ && this.LIZLLL == c1AkD.LIZLLL;
    }

    public final int hashCode() {
        return (((((this.LIZ * 31) + this.LIZIZ) * 31) + this.LIZJ) * 31) + this.LIZLLL;
    }

    public final String toString() {
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("PermissionModel(inAppPreciseMode=");
        sbLIZ.append(this.LIZ);
        sbLIZ.append(", overallPermissionStatus=");
        sbLIZ.append(this.LIZIZ);
        sbLIZ.append(", systemPermissionStatus=");
        sbLIZ.append(this.LIZJ);
        sbLIZ.append(", locationServiceStatus=");
        sbLIZ.append(this.LIZLLL);
        sbLIZ.append(')');
        return 0wS0.LIZIZ(sbLIZ);
    }
}
