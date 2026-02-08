package X;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class C1Ak0 {
    public final int LIZ;
    public final String LIZIZ;
    public final JSONObject LIZJ;

    public C1Ak0() {
        this(0, null, null);
    }

    public C1Ak0(int i, String str, JSONObject jSONObject) {
        this.LIZ = i;
        this.LIZIZ = str;
        this.LIZJ = jSONObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1Ak0)) {
            return false;
        }
        C1Ak0 c1Ak0 = (C1Ak0) obj;
        return this.LIZ == c1Ak0.LIZ && Intrinsics.LJFF(this.LIZIZ, c1Ak0.LIZIZ) && Intrinsics.LJFF(this.LIZJ, c1Ak0.LIZJ);
    }

    public final int hashCode() {
        int i = this.LIZ * 31;
        String str = this.LIZIZ;
        int iHashCode = (i + (str == null ? 0 : str.hashCode())) * 31;
        JSONObject jSONObject = this.LIZJ;
        return iHashCode + (jSONObject != null ? jSONObject.hashCode() : 0);
    }

    public final String toString() {
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("CertCheckResult(code=");
        sbLIZ.append(this.LIZ);
        sbLIZ.append(", msg=");
        sbLIZ.append(this.LIZIZ);
        sbLIZ.append(", params=");
        sbLIZ.append(this.LIZJ);
        sbLIZ.append(')');
        return 0wS0.LIZIZ(sbLIZ);
    }
}
