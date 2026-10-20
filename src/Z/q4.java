package Z;

import android.os.SystemClock;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class q4 {
    public final long a;
    public final String b;
    public final boolean c;
    public final String d;
    public final String e;
    public final long f;

    public q4(long j, String str, boolean z, String str2, String str3) {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        this.a = j;
        this.b = str;
        this.c = z;
        this.d = str2;
        this.e = str3;
        this.f = jElapsedRealtime;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof q4)) {
            return false;
        }
        q4 q4Var = (q4) obj;
        return this.a == q4Var.a && Intrinsics.areEqual(this.b, q4Var.b) && this.c == q4Var.c && Intrinsics.areEqual(this.d, q4Var.d) && Intrinsics.areEqual(this.e, q4Var.e) && this.f == q4Var.f;
    }

    public final int hashCode() {
        int iHashCode = (Boolean.hashCode(this.c) + ((this.b.hashCode() + (Long.hashCode(this.a) * 31)) * 31)) * 31;
        String str = this.d;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.e;
        return Long.hashCode(this.f) + ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        long j = this.a;
        String str = this.b;
        boolean z = this.c;
        String str2 = this.d;
        String str3 = this.e;
        return ve.a("e9MTElDHssgnE1jWqwiXgGctNcp/nlJcw5SnXO9PVd0=", "Ri15VF5Hmu9I2Ig8", "aes", ve.a("3QWDxalAk9j8W5jAvXwFAFSSqoIVxEjFQj0ZU/zCrg9pQTyBiJwoJvNLivNHuFSB", "GVSacn5OHNooRtHg", "aes", ve.a("LGPf47PUBugVJ7qZN+43wD1+nEbE0lv3HoMdh12zp6g=", "2IYQc903hShR6AeL", "aes", new StringBuilder().append("MediaTarget(sessionId=").append(j), str).append(", audioOnly=").append(z), str2), str3).append(", createdAtMs=").append(this.f).append(")").toString();
    }
}
