package X;

import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

public final class C1AkH {
    public static final  int LJIIIZ = 0;
    public final String LIZ;
    public final String LIZIZ;
    public final String LIZJ;
    public final int LIZLLL;
    public final String LJ;
    public final String LJFF;
    public final int LJI;
    public final String LJII;
    public final C1AkD LJIIIIZZ;

    public C1AkH(String str, String str2, String str3, int i, String str4, String str5, int i2, String str6, C1AkD c1AkD) {
        this.LIZ = str;
        this.LIZIZ = str2;
        this.LIZJ = str3;
        this.LIZLLL = i;
        this.LJ = str4;
        this.LJFF = str5;
        this.LJI = i2;
        this.LJII = str6;
        this.LJIIIIZZ = c1AkD;
    }

    public final JSONObject LIZ() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        C1AkD c1AkD = this.LJIIIIZZ;
        c1AkD.getClass();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("in_app_precise_mode", c1AkD.LIZ);
        jSONObject2.put("overall_location_permission_status", c1AkD.LIZIZ);
        jSONObject2.put("system_app_permission_status", c1AkD.LIZJ);
        jSONObject2.put("system_location_service_status", c1AkD.LIZLLL);
        jSONObject.put("unified_location_permission", jSONObject2);
        String str = this.LIZ;
        if (str == null) {
            str = "";
        }
        jSONObject.put("carrier_region", str);
        String str2 = this.LJFF;
        if (str2 == null) {
            str2 = "";
        }
        jSONObject.put("network_sim_region", str2);
        String str3 = this.LJII;
        if (str3 == null) {
            str3 = "";
        }
        jSONObject.put("system_region", str3);
        String str4 = this.LJ;
        if (str4 == null) {
            str4 = "";
        }
        jSONObject.put("mcc_mnc", str4);
        String str5 = this.LJ;
        if (str5 == null) {
            str5 = "";
        }
        jSONObject.put("mccmnc", str5);
        String str6 = this.LIZIZ;
        jSONObject.put("system_language", str6 != null ? str6 : "");
        jSONObject.put("locale", this.LIZJ);
        jSONObject.put("permission", this.LJI);
        jSONObject.put("location_mode", this.LIZLLL);
        return jSONObject;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1AkH)) {
            return false;
        }
        C1AkH c1AkH = (C1AkH) obj;
        return Intrinsics.LJFF(this.LIZ, c1AkH.LIZ) && Intrinsics.LJFF(this.LIZIZ, c1AkH.LIZIZ) && Intrinsics.LJFF(this.LIZJ, c1AkH.LIZJ) && this.LIZLLL == c1AkH.LIZLLL && Intrinsics.LJFF(this.LJ, c1AkH.LJ) && Intrinsics.LJFF(this.LJFF, c1AkH.LJFF) && this.LJI == c1AkH.LJI && Intrinsics.LJFF(this.LJII, c1AkH.LJII) && Intrinsics.LJFF(this.LJIIIIZZ, c1AkH.LJIIIIZZ);
    }

    public final int hashCode() {
        String str = this.LIZ;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.LIZIZ;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.LIZJ;
        int iHashCode3 = (((iHashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31) + this.LIZLLL) * 31;
        String str4 = this.LJ;
        int iHashCode4 = (iHashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.LJFF;
        int iHashCode5 = (((iHashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31) + this.LJI) * 31;
        String str6 = this.LJII;
        return ((iHashCode5 + (str6 != null ? str6.hashCode() : 0)) * 31) + this.LJIIIIZZ.hashCode();
    }

    public final String toString() {
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("StatusModel(carrierRegion=");
        sbLIZ.append(this.LIZ);
        sbLIZ.append(", systemLanguage=");
        sbLIZ.append(this.LIZIZ);
        sbLIZ.append(", locale=");
        sbLIZ.append(this.LIZJ);
        sbLIZ.append(", locationMode=");
        sbLIZ.append(this.LIZLLL);
        sbLIZ.append(", mccMnc=");
        sbLIZ.append(this.LJ);
        sbLIZ.append(", networkSimRegion=");
        sbLIZ.append(this.LJFF);
        sbLIZ.append(", permission=");
        sbLIZ.append(this.LJI);
        sbLIZ.append(", systemRegion=");
        sbLIZ.append(this.LJII);
        sbLIZ.append(", permissionModel=");
        sbLIZ.append(this.LJIIIIZZ);
        sbLIZ.append(')');
        return 0wS0.LIZIZ(sbLIZ);
    }
}
