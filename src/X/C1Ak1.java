package X;

import Y.ARunnableS64S0100000_10;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.entry.auth.CertAuthEntry;
import org.json.JSONObject;

public final class C1Ak1 {
    public static final  int LIZ = 0;

    public static C1Ak0 LIZ(Cert cert, String str) {
        C1Ak0 c1Ak0;
        int i;
        String str2;
        C1Ak0 c1Ak1 = null;
        try {
            0Uxc r0 = CertAuthEntry.Companion.checkCert(cert, new String[]{"location"}, "locationSDK", str, "Collect");
            JSONObject jSONObjectLIZIZ = r0 != null ? 0UxQ.LIZIZ(r0) : null;
            if (r0 != null) {
                i = r0.LIZ;
                str2 = r0.LIZIZ;
            } else {
                i = 0;
                str2 = null;
            }
            c1Ak0 = new C1Ak0(i, str2, jSONObjectLIZIZ);
            if (cert != null) {
                0N3e r1 = 0N3e.LIZ;
                0N3e.LIZJ(i, cert.certToken(), str2, jSONObjectLIZIZ);
            }
            01Sf.constructor-impl(c1Ak0);
        } catch (Throwable th) {
            c1Ak0 = new 00ce(th);
            01Sf.constructor-impl(c1Ak0);
        }
        if (01Sf.exceptionOrNull-impl(c1Ak0) == null) {
            c1Ak1 = c1Ak0;
        } else {
            0N3e r2 = 0N3e.LIZ;
            0bn7 r3 = 0bn7.LIZ;
            0bn7.LIZLLL("SdkMonitorWrapper", "reportBpeaException: " + cert);
            if (0N3e.LIZ()) {
                0Vx6.LJJLIIIIJ(0N3e.LIZJ, new ARunnableS64S0100000_10(cert, 218));
            } else {
                0bn7.LIZLLL("SdkMonitorWrapper", "reportBpeaException: not initialized");
            }
        }
        return c1Ak1;
    }
}
