package X;

import android.os.SystemClock;
import com.bytedance.librarian.Librarian;
import com.uber.h3core.NativeMethods;
import com.uber.h3core.util.LatLng;
import java.util.ArrayList;
import java.util.List;

public final class C1Aje {
    public final C1Ajc LIZ;

    public C1Aje(C1Ajc c1Ajc) {
        this.LIZ = c1Ajc;
    }

    public static C1Aje LIZLLL() {
        0Bc5.LIZIZ("h3-java");
        long jUptimeMillis = SystemClock.uptimeMillis();
        Librarian.LJ("h3-java");
        0Bc5.LIZJ(jUptimeMillis, "h3-java");
        0Bc5.LIZ("h3-java");
        return new C1Aje(new C1Ajc(new NativeMethods()));
    }

    public final long LIZ(double d, double d2, int i) {
        C1Ajc c1Ajc = this.LIZ;
        c1Ajc.getClass();
        if (i < 0 || i > 15) {
            throw new IllegalArgumentException(0Vx6.m0("resolution %d is out of range (must be 0 <= res <= 15)", new Object[]{Integer.valueOf(i)}));
        }
        return c1Ajc.LIZ.latLngToCell(Math.toRadians(d), Math.toRadians(d2), i);
    }

    public final LatLng LIZIZ(long j) {
        double[] dArr = new double[2];
        this.LIZ.LIZ.cellToLatLng(j, dArr);
        return new LatLng(Math.toDegrees(dArr[0]), Math.toDegrees(dArr[1]));
    }

    public final List LIZJ(int i, long j) {
        C1Ajc c1Ajc = this.LIZ;
        long jMaxGridDiskSize = c1Ajc.LIZ.maxGridDiskSize(i);
        if (jMaxGridDiskSize < 0 || jMaxGridDiskSize > 2147483647L) {
            throw new IllegalArgumentException(0Vx6.m0("size %d is out of range", new Object[]{Long.valueOf(jMaxGridDiskSize)}));
        }
        int i2 = (int) jMaxGridDiskSize;
        long[] jArr = new long[i2];
        c1Ajc.LIZ.gridDisk(j, i, jArr);
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < i2; i3++) {
            long j2 = jArr[i3];
            if (j2 != 0) {
                arrayList.add(Long.valueOf(j2));
            }
        }
        return arrayList;
    }
}
