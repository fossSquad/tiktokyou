package Z;

import android.os.SystemClock;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class b4 {
    public final long a;
    public final String b;
    public final boolean c;
    public final String d;
    public final String e;
    public final long f;

    public b4(long j, String str, boolean z, String str2, String str3) {
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
        if (!(obj instanceof b4)) {
            return false;
        }
        b4 b4Var = (b4) obj;
        return this.a == b4Var.a && Intrinsics.areEqual(this.b, b4Var.b) && this.c == b4Var.c && Intrinsics.areEqual(this.d, b4Var.d) && Intrinsics.areEqual(this.e, b4Var.e) && this.f == b4Var.f;
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
        return new StringBuilder().append("MediaTarget(sessionId=").append(j).append(", fileBase=").append(str).append(", audioOnly=").append(z).append(", fileExtension=").append(str2).append(", mimeType=").append(str3).append(", createdAtMs=").append(this.f).append(")").toString();
    }
}
