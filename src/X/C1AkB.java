package X;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

public final class C1AkB {
    public static final  int LJ = 0;
    public final long LIZ;
    public final long LIZIZ;
    public final long LIZJ;
    public final String LIZLLL;

    public C1AkB() {
        this(0);
    }

    public  C1AkB(int i) {
        this(0L, 0L, 0L, "0");
    }

    public C1AkB(long j, long j2, long j3, String str) {
        this.LIZ = j;
        this.LIZIZ = j2;
        this.LIZJ = j3;
        this.LIZLLL = str;
    }

    public final JSONObject LIZ() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("l0_id", this.LIZ);
        jSONObject.put("l1_id", this.LIZIZ);
        jSONObject.put("l2_id", this.LIZJ);
        jSONObject.put("version", this.LIZLLL);
        return jSONObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1AkB)) {
            return false;
        }
        C1AkB c1AkB = (C1AkB) obj;
        return this.LIZ == c1AkB.LIZ && this.LIZIZ == c1AkB.LIZIZ && this.LIZJ == c1AkB.LIZJ && Intrinsics.LJFF(this.LIZLLL, c1AkB.LIZLLL);
    }

    public final int hashCode() {
        return (((((0Vx6.c(this.LIZ) * 31) + 0Vx6.c(this.LIZIZ)) * 31) + 0Vx6.c(this.LIZJ)) * 31) + this.LIZLLL.hashCode();
    }

    public final String toString() {
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("MatchRuleInfo(l0Id=");
        sbLIZ.append(this.LIZ);
        sbLIZ.append(", l1Id=");
        sbLIZ.append(this.LIZIZ);
        sbLIZ.append(", l2Id=");
        sbLIZ.append(this.LIZJ);
        sbLIZ.append(", version=");
        sbLIZ.append(this.LIZLLL);
        sbLIZ.append(')');
        return 0wS0.LIZIZ(sbLIZ);
    }
}
