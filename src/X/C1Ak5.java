package X;

import android.content.Context;
import com.bytedance.i18n.location.api.LocationClient;
import com.bytedance.i18n.location.api.internal.GsonHelper;
import com.bytedance.i18n.location.core.network.model.response.ResponseModel;
import com.bytedance.pumbaa.utility.method_id.MethodIDManager;
import com.google.gson.Gson;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.v;
import org.json.JSONException;
import org.json.JSONObject;

public final class C1Ak5 {
    public final 0boT LIZ;
    public final String LIZIZ;
    public final String LIZJ;

    public C1Ak5(0boT r10) {
        CharSequence charSequenceSubSequence;
        CharSequence charSequenceSubSequence2;
        this.LIZ = r10;
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append(r10.LJIIL.LIZIZ);
        sbLIZ.append("/location/submit-v2/");
        String strLJJI = v.LJJI(0wS0.LIZIZ(sbLIZ), "//", "/", false);
        int length = strLJJI.length();
        int i = 0;
        while (true) {
            charSequenceSubSequence = "";
            if (i >= length) {
                charSequenceSubSequence2 = "";
                break;
            } else {
                if (strLJJI.charAt(i) != '/') {
                    charSequenceSubSequence2 = strLJJI.subSequence(i, strLJJI.length());
                    break;
                }
                i++;
            }
        }
        this.LIZIZ = charSequenceSubSequence2.toString();
        StringBuilder sbLIZ2 = 0wS0.LIZ();
        sbLIZ2.append(this.LIZ.LJIIL.LIZIZ);
        sbLIZ2.append("/location/info/");
        String strLJJI2 = v.LJJI(0wS0.LIZIZ(sbLIZ2), "//", "/", false);
        int length2 = strLJJI2.length();
        for (int i2 = 0; i2 < length2; i2++) {
            if (strLJJI2.charAt(i2) != '/') {
                charSequenceSubSequence = strLJJI2.subSequence(i2, strLJJI2.length());
                break;
            }
        }
        this.LIZJ = charSequenceSubSequence.toString();
    }

    public final String LIZ(String str, String str2, Map map, Map map2) {
        00ce r0;
        System.currentTimeMillis();
        00ce r2 = null;
        try {
            0bn7 r1 = 0bn7.LIZ;
            StringBuilder sbLIZ = 0wS0.LIZ();
            sbLIZ.append("NetworkRequest post Path:");
            sbLIZ.append(str2);
            0bn7.LIZLLL("NetworkManager", 0wS0.LIZIZ(sbLIZ));
            0boT r3 = this.LIZ;
            if (!r3.LJIILJJIL) {
                return null;
            }
            r3.LJIIL.LIZJ.post();
            StringBuilder sbLIZ2 = 0wS0.LIZ();
            sbLIZ2.append("NetworkRequest response: ");
            sbLIZ2.append((String) null);
            0bn7.LIZIZ("NetworkManager", 0wS0.LIZIZ(sbLIZ2));
            01Sf.constructor-impl((Object) null);
            r0 = null;
        } catch (Throwable th) {
            r0 = new 00ce(th);
            01Sf.constructor-impl(r0);
        }
        Throwable th2 = 01Sf.exceptionOrNull-impl(r0);
        if (th2 == null) {
            r2 = r0;
        } else {
            0bn7 r4 = 0bn7.LIZ;
            0bn7.LIZJ("NetworkManager", "post exception:", th2);
        }
        return (String) r2;
    }

    public final String LIZIZ(String str, String str2, JSONObject jSONObject, Map<String, String> map) {
        String strLIZ;
        ResponseModel responseModel;
        long jCurrentTimeMillis = System.currentTimeMillis();
        01r3 r4 = new 01r3();
        0bn7 r0 = 0bn7.LIZ;
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("postJson: ");
        sbLIZ.append(str);
        sbLIZ.append(' ');
        sbLIZ.append(str2);
        0bn7.LIZIZ("NetworkManager", 0wS0.LIZIZ(sbLIZ));
        while (r4.element < 3) {
            0bn7 r1 = 0bn7.LIZ;
            StringBuilder sbLIZ2 = 0wS0.LIZ();
            sbLIZ2.append("postJson: ");
            sbLIZ2.append(jSONObject);
            0bn7.LIZIZ("NetworkManager", 0wS0.LIZIZ(sbLIZ2));
            StringBuilder sbLIZ3 = 0wS0.LIZ();
            sbLIZ3.append("postJson retry ");
            sbLIZ3.append(r4.element);
            sbLIZ3.append(" times");
            0bn7.LIZLLL("NetworkManager", 0wS0.LIZIZ(sbLIZ3));
            try {
                StringBuilder sbLIZ4 = 0wS0.LIZ();
                sbLIZ4.append("NetworkRequest postJson ");
                sbLIZ4.append(this.LIZ.LJIIL.LIZJ);
                sbLIZ4.append(' ');
                sbLIZ4.append(str);
                sbLIZ4.append(' ');
                sbLIZ4.append(str2);
                0bn7.LIZLLL("NetworkManager", 0wS0.LIZIZ(sbLIZ4));
                StringBuilder sbLIZ5 = 0wS0.LIZ();
                sbLIZ5.append("NetworkRequest postJson body=");
                sbLIZ5.append(jSONObject);
                sbLIZ5.append(" queries=");
                sbLIZ5.append(map);
                0bn7.LIZIZ("NetworkManager", 0wS0.LIZIZ(sbLIZ5));
                strLIZ = this.LIZ.LJIIL.LIZJ.LIZ(str, str2, map, jSONObject);
            } catch (Throwable th) {
                00ce r10 = new 00ce(th);
                01Sf.constructor-impl(r10);
                Throwable th2 = 01Sf.exceptionOrNull-impl(r10);
                if (th2 != null) {
                    0bn7 r2 = 0bn7.LIZ;
                    StringBuilder sbLIZ6 = 0wS0.LIZ();
                    sbLIZ6.append("postJson: exception: ");
                    sbLIZ6.append(th2.getClass().getSimpleName());
                    0bn7.LIZJ("NetworkManager", 0wS0.LIZIZ(sbLIZ6), th2);
                    0N3e r3 = 0N3e.LIZ;
                    0N3e.LJIIJ(str2, th2.getClass().getSimpleName());
                    r10 = null;
                }
                strLIZ = (String) r10;
            }
            0bn7 r5 = 0bn7.LIZ;
            StringBuilder sbLIZ7 = 0wS0.LIZ();
            sbLIZ7.append("NetworkRequest response: ");
            sbLIZ7.append(strLIZ);
            0bn7.LIZIZ("NetworkManager", 0wS0.LIZIZ(sbLIZ7));
            if (strLIZ != null) {
                try {
                    responseModel = (ResponseModel) ((Gson) GsonHelper.LIZ.getValue()).LJI(strLIZ, ResponseModel.class);
                    01Sf.constructor-impl(responseModel);
                } catch (Throwable th3) {
                    responseModel = new 00ce(th3);
                    01Sf.constructor-impl(responseModel);
                }
                if (01Sf.isFailure-impl(responseModel)) {
                    responseModel = null;
                }
                ResponseModel responseModel2 = responseModel;
                if (responseModel2 != null) {
                    0N3e r6 = 0N3e.LIZ;
                    0N3e.LJIIJJI(r4.element, System.currentTimeMillis() - jCurrentTimeMillis, responseModel2.errCode, str2, responseModel2.errMsg);
                }
                if (responseModel2 != null) {
                    return responseModel2.data;
                }
                return null;
            }
            r4.element++;
        }
        0N3e r7 = 0N3e.LIZ;
        0N3e.LJIIJJI(r4.element, System.currentTimeMillis() - jCurrentTimeMillis, -10000, str2, "Reached max retry times");
        return null;
    }

    public final void LIZJ(final String str) {
        boolean zLJI = MethodIDManager.LJI(202536);
        0bn7.LIZLLL("NetworkManager", "info");
        0boT r0 = this.LIZ;
        Context context = r0.LIZ;
        Locale locale = r0.LJIILL;
        if (locale == null) {
            locale = Locale.getDefault();
        }
        final C1AkH c1AkHLIZ = C1AkG.LIZ(context, locale);
        final long jCurrentTimeMillis = System.currentTimeMillis() / ((long) 1000);
        ?? r4 = new Object(c1AkHLIZ, str, jCurrentTimeMillis) {
            public static final  int LIZLLL = 0;
            public final C1AkH LIZ;
            public final String LIZIZ;
            public final long LIZJ;

            {
                this.LIZ = c1AkHLIZ;
                this.LIZIZ = str;
                this.LIZJ = jCurrentTimeMillis;
            }

            public final JSONObject LIZ() throws JSONException {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("status", this.LIZ.LIZ());
                jSONObject.put("upload_source", this.LIZIZ);
                jSONObject.put("timestamp", this.LIZJ);
                return jSONObject;
            }

            public final boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                if (!(obj instanceof C1Ak7)) {
                    return false;
                }
                C1Ak7 c1Ak7 = (C1Ak7) obj;
                return Intrinsics.LJFF(this.LIZ, c1Ak7.LIZ) && Intrinsics.LJFF(this.LIZIZ, c1Ak7.LIZIZ) && this.LIZJ == c1Ak7.LIZJ;
            }

            public final int hashCode() {
                return (((this.LIZ.hashCode() * 31) + this.LIZIZ.hashCode()) * 31) + 0Vx6.c(this.LIZJ);
            }

            public final String toString() {
                StringBuilder sbLIZ = 0wS0.LIZ();
                sbLIZ.append("InfoModel(status=");
                sbLIZ.append(this.LIZ);
                sbLIZ.append(", uploadSource=");
                sbLIZ.append(this.LIZIZ);
                sbLIZ.append(", timestamp=");
                sbLIZ.append(this.LIZJ);
                sbLIZ.append(')');
                return 0wS0.LIZIZ(sbLIZ);
            }
        };
        LocationClient.LIZ.getClass();
        Map<String, String> mapLIZJ = 0osn.LIZJ(new Pair("sdk_version", "3.3.0-alpha.65-bugfix"));
        0boT r1 = this.LIZ;
        if (!r1.LIZLLL) {
            LIZIZ(r1.LJIIL.LIZ, this.LIZJ, r4.LIZ(), mapLIZJ);
            if (zLJI) {
                MethodIDManager.LJ();
                return;
            }
            return;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String strLIZ = 08SS.LIZ(10, 0Vx6.M(r4.LIZ()));
        if (strLIZ != null) {
            linkedHashMap.put("loc_info", strLIZ);
        }
        LIZ(this.LIZ.LJIIL.LIZ, this.LIZJ, mapLIZJ, linkedHashMap);
        if (zLJI) {
            MethodIDManager.LJ();
        }
    }
}
