package X;

import kotlin.jvm.internal.Intrinsics;

public final class C1AkJ {
    public final double LIZ;
    public final String LIZIZ;
    public final String LIZJ;
    public final String LIZLLL;
    public final String LJ;
    public final String LJFF;
    public final int LJI;
    public final int LJII;
    public final int LJIIIIZZ;
    public final String LJIIIZ;
    public final String LJIIJ;
    public final double LJIIJJI;
    public final double LJIIL;
    public final int LJIILIIL;
    public final long LJIILJJIL;

    public C1AkJ(double d, String str, String str2, String str3, String str4, String str5, int i, int i2, int i3, String str6, String str7, double d2, double d3, int i4, long j) {
        this.LIZ = d;
        this.LIZIZ = str;
        this.LIZJ = str2;
        this.LIZLLL = str3;
        this.LJ = str4;
        this.LJFF = str5;
        this.LJI = i;
        this.LJII = i2;
        this.LJIIIIZZ = i3;
        this.LJIIIZ = str6;
        this.LJIIJ = str7;
        this.LJIIJJI = d2;
        this.LJIIL = d3;
        this.LJIILIIL = i4;
        this.LJIILJJIL = j;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1AkJ)) {
            return false;
        }
        C1AkJ c1AkJ = (C1AkJ) obj;
        return Double.compare(this.LIZ, c1AkJ.LIZ) == 0 && Intrinsics.LJFF(this.LIZIZ, c1AkJ.LIZIZ) && Intrinsics.LJFF(this.LIZJ, c1AkJ.LIZJ) && Intrinsics.LJFF(this.LIZLLL, c1AkJ.LIZLLL) && Intrinsics.LJFF(this.LJ, c1AkJ.LJ) && Intrinsics.LJFF(this.LJFF, c1AkJ.LJFF) && this.LJI == c1AkJ.LJI && this.LJII == c1AkJ.LJII && this.LJIIIIZZ == c1AkJ.LJIIIIZZ && Intrinsics.LJFF(this.LJIIIZ, c1AkJ.LJIIIZ) && Intrinsics.LJFF(this.LJIIJ, c1AkJ.LJIIJ) && Double.compare(this.LJIIJJI, c1AkJ.LJIIJJI) == 0 && Double.compare(this.LJIIL, c1AkJ.LJIIL) == 0 && this.LJIILIIL == c1AkJ.LJIILIIL && this.LJIILJJIL == c1AkJ.LJIILJJIL;
    }

    public final int hashCode() {
        return (((((((((((((((((((((((((((0Vx6.b(this.LIZ) * 31) + this.LIZIZ.hashCode()) * 31) + this.LIZJ.hashCode()) * 31) + this.LIZLLL.hashCode()) * 31) + this.LJ.hashCode()) * 31) + this.LJFF.hashCode()) * 31) + this.LJI) * 31) + this.LJII) * 31) + this.LJIIIIZZ) * 31) + this.LJIIIZ.hashCode()) * 31) + this.LJIIJ.hashCode()) * 31) + 0Vx6.b(this.LJIIJJI)) * 31) + 0Vx6.b(this.LJIIL)) * 31) + this.LJIILIIL) * 31) + 0Vx6.c(this.LJIILJJIL);
    }

    public final String toString() {
        return "SysLocationModel(accuracy=" + this.LIZ + ", country=" + this.LIZIZ + ", province=" + this.LIZJ + ", city=" + this.LIZLLL + ", district=" + this.LJ + ", coordinateSystem=" + this.LJFF + ", desensitizationType=" + this.LJI + ", disableLocationShift=" + this.LJII + ", locationAccuracyMode=" + this.LJIIIIZZ + ", encryptedLat=" + this.LJIIIZ + ", encryptedLon=" + this.LJIIJ + ", latitude=" + this.LJIIJJI + ", longitude=" + this.LJIIL + ", locateType=" + this.LJIILIIL + ", timestamp=" + this.LJIILJJIL + ')';
    }
}
