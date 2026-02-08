package X;

import android.os.SystemClock;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.i18n.location.api.Address;
import com.bytedance.i18n.location.api.AreaModel;
import com.bytedance.i18n.location.api.LocationClient;
import com.bytedance.i18n.location.api.LocationData;
import com.bytedance.i18n.location.api.WifiClient;
import com.bytedance.i18n.location.core.network.model.response.DataModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class C00261Akr implements C1Ajj {
    public final C1AkP LIZ;
    public final 0V1W LIZIZ;
    public final C1Ak5 LIZJ;
    public 0V1V LIZLLL;

    public C00261Akr(C1AkP c1AkP, 0V1W r5, C1Ak5 c1Ak5) {
        this.LIZ = c1AkP;
        this.LIZIZ = r5;
        this.LIZJ = c1Ak5;
        String string = c1AkP.LIZIZ().getString("wifi_rule", "");
        String str = string != null ? string : "";
        0bn7 r0 = 0bn7.LIZ;
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("lastWifiRule: ");
        sbLIZ.append(str);
        0bn7.LIZIZ("WifiStrategy", 0wS0.LIZIZ(sbLIZ));
        this.LIZLLL = 0V1U.LIZIZ(str);
    }

    public static void LIZLLL(C00261Akr c00261Akr, 054j r11, String str, long j, long j2, int i, String str2) {
        String strCertToken;
        054k r0;
        Cert cert;
        c00261Akr.getClass();
        List list = 0bml.LIZ;
        if (r11 == null || (r0 = r11.LIZ) == null || (cert = r0.LIZIZ) == null || (strCertToken = cert.certToken()) == null) {
            strCertToken = "no_cert";
        }
        0bml.LJ(strCertToken, "Wifi", (String) null, "precise", "precise", str, j, j2, i, str2);
    }

    @Override
    public final C1AjZ LIZ(final C1Ajl c1Ajl) throws JSONException {
        final 0V1V r11;
        Address address;
        AreaModel areaModel;
        Long l;
        Address address2;
        AreaModel areaModel2;
        Long l2;
        Address address3;
        AreaModel areaModel3;
        Long l3;
        String str;
        DataModel dataModel = c1Ajl.LIZJ;
        if (dataModel == null || (str = dataModel.wifiRule) == null) {
            0bn7.LIZLLL("WifiStrategy", "process: wifi rule: null");
            0N3e.LJIJ((Integer) null, (Long) null, "rule", "null");
            r11 = this.LIZLLL;
            if (r11 != null) {
            }
            return C1AjY.LIZ(c1Ajl);
        }
        0bn7 r0 = 0bn7.LIZ;
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("process: wifi rule: ");
        sbLIZ.append(str);
        0bn7.LIZLLL("WifiStrategy", 0wS0.LIZIZ(sbLIZ));
        r11 = 0V1U.LIZIZ(str);
        if (r11 != null) {
            0V1V r3 = this.LIZLLL;
            if (r3 != null) {
                if (r11.LJ.length() != 0 && !Intrinsics.LJFF(r11.LJ, "0")) {
                    Intrinsics.LJFF(r3.LJ, r11.LJ);
                }
            }
        } else {
            0bn7.LIZLLL("WifiStrategy", "process: wifi rule: null");
            0N3e.LJIJ((Integer) null, (Long) null, "rule", "null");
        }
        r11 = this.LIZLLL;
        if (r11 != null) {
        }
        return C1AjY.LIZ(c1Ajl);
        if (!0V1U.LIZ(r11, this.LIZLLL)) {
            C1AkP c1AkP = this.LIZ;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("l0_id", r11.LIZ);
            jSONObject.put("l1_id", r11.LIZIZ);
            jSONObject.put("l2_id", r11.LIZJ);
            jSONObject.put("version", r11.LJ);
            JSONArray jSONArray = new JSONArray();
            for (0V1T r8 : r11.LIZLLL) {
                r8.getClass();
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("keywords", r8.LIZ);
                jSONObject2.put("name", r8.LIZIZ);
                jSONObject2.put("priority", r8.LIZJ);
                jSONObject2.put("rule", r8.LIZLLL);
                jSONArray.put(jSONObject2);
            }
            jSONObject.put("conf_list", jSONArray);
            c1AkP.LIZIZ().edit().putString("wifi_rule", 0Vx6.M(jSONObject)).apply();
            this.LIZLLL = r11;
        }
        DataModel dataModel2 = c1Ajl.LIZJ;
        if (dataModel2 == null || (address = dataModel2.address) == null || (areaModel = address.country) == null || (l = areaModel.geoNameId) == null) {
            return C1AjY.LIZ(c1Ajl);
        }
        final long jLongValue = l.longValue();
        DataModel dataModel3 = c1Ajl.LIZJ;
        final long jLongValue2 = (dataModel3 == null || (address3 = dataModel3.address) == null || (areaModel3 = address3.adminArea) == null || (l3 = areaModel3.geoNameId) == null) ? 0L : l3.longValue();
        DataModel dataModel4 = c1Ajl.LIZJ;
        final long jLongValue3 = (dataModel4 == null || (address2 = dataModel4.address) == null || (areaModel2 = address2.city) == null || (l2 = areaModel2.geoNameId) == null) ? 0L : l2.longValue();
        WifiClient wifiClient = 06vM.LJ;
        wifiClient.LJFF(this.LIZIZ, r11);
        wifiClient.LJIIIIZZ(jLongValue, jLongValue2, jLongValue3, new 06vP() {

            public final void LIZ(List<String> list, long j, long j2) throws JSONException {
                String str2;
                String strCertToken;
                054k r5;
                Cert cert;
                if (!(list != null && (((ArrayList) list).isEmpty() ^ true))) {
                    0bn7.LIZLLL("WifiStrategy", "Wifi fetching failed");
                    return;
                }
                0bn7.LIZLLL("WifiStrategy", "Wifi fetching success");
                C00261Akr c00261Akr = this.LIZ;
                0V1V r12 = r11;
                long j3 = jLongValue;
                long j4 = jLongValue2;
                long j5 = jLongValue3;
                c00261Akr.getClass();
                if (!r12.LIZ(j3, j4, j5)) {
                    0bn7.LIZLLL("WifiStrategy", "Wifi submit not allowed");
                    0N3e r1 = 0N3e.LIZ;
                    0N3e.LJIJ(2, Long.valueOf(jLongValue3), "submit", "denied");
                    return;
                }
                0N3e.LJIJ((Integer) null, (Long) null, "submit", "allowed");
                054j r2 = c1Ajl.LIZIZ;
                if (r2 == null || (str2 = r2.LIZLLL) == null) {
                    str2 = "from_client";
                }
                long jCurrentTimeMillis = System.currentTimeMillis();
                Map mapLJIIIIZZ = 0osm.LJIIIIZZ(new Pair[]{new Pair("wifi_scan_start_ts", String.valueOf(j)), new Pair("wifi_match_start_ts", String.valueOf(j2)), new Pair("wifi_submit_start_ts", String.valueOf(jCurrentTimeMillis)), new Pair("uuid", c1Ajl.LJI)});
                long j6 = jLongValue;
                long j7 = jLongValue2;
                long j8 = jLongValue3;
                LocationData locationData = c1Ajl.LIZ;
                long j9 = locationData != null ? locationData.timestamp : jCurrentTimeMillis;
                C1AkL c1AkL = new C1AkL(str2, j6, j7, j8, list, j9, mapLJIIIIZZ);
                054j r13 = c1Ajl.LIZIZ;
                long jUptimeMillis = SystemClock.uptimeMillis();
                this.LIZ.getClass();
                List list2 = 0bml.LIZ;
                if (r13 == null || (r5 = r13.LIZ) == null || (cert = r5.LIZIZ) == null || (strCertToken = cert.certToken()) == null) {
                    strCertToken = "no_cert";
                }
                0bml.LJFF(strCertToken, "Wifi", (String) null, "precise");
                C1Ak5 c1Ak5 = this.LIZ.LIZJ;
                c1Ak5.getClass();
                StringBuilder sbLIZ2 = 0wS0.LIZ();
                sbLIZ2.append("submitWifi ");
                sbLIZ2.append(j9);
                0bn7.LIZLLL("NetworkManager", 0wS0.LIZIZ(sbLIZ2));
                LocationClient.LIZ.getClass();
                Map<String, String> mapLJIIIIZZ2 = 0osm.LJIIIIZZ(new Pair[]{new Pair("sdk_version", "3.3.0-alpha.65-bugfix"), new Pair("enable_cache_ttl", String.valueOf(c1Ak5.LIZ.LJIIZILJ.LIZ))});
                String str3 = c1Ak5.LIZ.LJIIL.LIZ;
                String str4 = c1Ak5.LIZIZ;
                JSONObject jSONObject3 = new JSONObject();
                for (Map.Entry entry : mapLJIIIIZZ.entrySet()) {
                    jSONObject3.put((String) entry.getKey(), entry.getValue());
                }
                JSONObject jSONObject4 = new JSONObject();
                jSONObject4.put("upload_source", c1AkL.LIZ);
                jSONObject4.put("l0_id", c1AkL.LIZIZ);
                jSONObject4.put("l1_id", c1AkL.LIZJ);
                jSONObject4.put("l2_id", c1AkL.LIZLLL);
                JSONArray jSONArray2 = new JSONArray();
                Iterator<String> it = c1AkL.LJ.iterator();
                while (it.hasNext()) {
                    jSONArray2.put(it.next());
                }
                jSONObject4.put("list", jSONArray2);
                jSONObject4.put("timestamp", c1AkL.LJFF / ((long) 1000));
                jSONObject4.put("extra", jSONObject3);
                JSONObject jSONObject5 = new JSONObject();
                jSONObject5.put("wifi_info", jSONObject4);
                String strLIZIZ = c1Ak5.LIZIZ(str3, str4, jSONObject5, mapLJIIIIZZ2);
                long jUptimeMillis2 = SystemClock.uptimeMillis() - jUptimeMillis;
                long j10 = jCurrentTimeMillis - j2;
                if (strLIZIZ != null) {
                    String strLIZIZ2 = 08SS.LIZIZ(10, strLIZIZ);
                    if (strLIZIZ2 != null) {
                        0bn7 r4 = 0bn7.LIZ;
                        StringBuilder sbLIZ3 = 0wS0.LIZ();
                        sbLIZ3.append("submitWifi: ");
                        sbLIZ3.append(strLIZIZ2);
                        0bn7.LIZIZ("WifiStrategy", 0wS0.LIZIZ(sbLIZ3));
                        C00261Akr.LIZLLL(this.LIZ, r13, "success", j10, jUptimeMillis2, 0, null);
                    } else {
                        C00261Akr.LIZLLL(this.LIZ, r13, "fail", j10, jUptimeMillis2, -4002, "parse_resp_failed");
                    }
                } else {
                    C00261Akr.LIZLLL(this.LIZ, r13, "fail", j10, jUptimeMillis2, -4001, "net_exception");
                }
                0N3e r6 = 0N3e.LIZ;
                0N3e.LJIIZILJ((Integer) null, jUptimeMillis2, "submit");
            }
        });
        return C1AjY.LIZ(c1Ajl);
    }

    @Override
    public final boolean LIZIZ(C1Ajl c1Ajl) {
        return this.LIZIZ.LIZ();
    }

    @Override
    public final int LIZJ() {
        return 0;
    }

    @Override
    public final String name() {
        return "wifi";
    }
}
