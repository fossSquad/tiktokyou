package X;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.i18n.location.api.Address;
import com.bytedance.i18n.location.api.LocationData;
import com.bytedance.i18n.location.api.internal.GsonHelper;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.security.SecureRandom;
import kotlin.jvm.functions.Function0;

public final class C1AkP {
    public final Context LIZ;
    public final 054i LIZIZ;
    public final String LIZJ;
    public LocationData LIZLLL;
    public LocationData LJ;
    public Address LJFF;
    public long LJI;
    public final 06vB LJII;

    public C1AkP(Context context, 054i r8) {
        LocationData locationDataLIZIZ;
        this.LIZ = context;
        this.LIZIZ = r8;
        String simpleName = C1AkP.class.getSimpleName();
        this.LIZJ = simpleName;
        this.LJII = 02vO.LIZIZ(new Function0() {
            public final Object invoke() {
                return 0Vsb.LIZJ(this.LL.LIZ, 0, "loc_cache");
            }
        });
        LIZLLL();
        LocationData locationData = null;
        String string = LIZIZ().getString("fine", null);
        0bn7 r0 = 0bn7.LIZ;
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("readFineFromSp: ");
        sbLIZ.append(string);
        0bn7.LIZIZ(simpleName, 0wS0.LIZIZ(sbLIZ));
        String strLIZIZ = 08SS.LIZIZ(2, string);
        if (strLIZIZ != null) {
            StringBuilder sbLIZ2 = 0wS0.LIZ();
            sbLIZ2.append("readFineFromSp: ");
            sbLIZ2.append(strLIZIZ);
            0bn7.LIZIZ(simpleName, 0wS0.LIZIZ(sbLIZ2));
            locationDataLIZIZ = 0xI2.LIZIZ(strLIZIZ);
            if (locationDataLIZIZ != null) {
                if (this.LJFF == null) {
                    this.LJFF = LIZJ();
                }
                locationDataLIZIZ.address = this.LJFF;
            } else {
                locationDataLIZIZ = null;
            }
        } else {
            locationDataLIZIZ = null;
        }
        this.LIZLLL = locationDataLIZIZ;
        String string2 = LIZIZ().getString("coarse", null);
        StringBuilder sbLIZ3 = 0wS0.LIZ();
        sbLIZ3.append("readCoarseFromSp: ");
        sbLIZ3.append(string2);
        0bn7.LIZIZ(simpleName, 0wS0.LIZIZ(sbLIZ3));
        String strLIZIZ2 = 08SS.LIZIZ(2, string2);
        if (strLIZIZ2 != null) {
            StringBuilder sbLIZ4 = 0wS0.LIZ();
            sbLIZ4.append("readCoarseFromSp: ");
            sbLIZ4.append(strLIZIZ2);
            0bn7.LIZIZ(simpleName, 0wS0.LIZIZ(sbLIZ4));
            LocationData locationDataLIZIZ2 = 0xI2.LIZIZ(strLIZIZ2);
            if (locationDataLIZIZ2 != null) {
                if (this.LJFF == null) {
                    this.LJFF = LIZJ();
                }
                locationDataLIZIZ2.address = this.LJFF;
                locationData = locationDataLIZIZ2;
            }
        }
        this.LJ = locationData;
    }

    public final void LIZ() {
        0bn7 r0 = 0bn7.LIZ;
        0bn7.LIZLLL(this.LIZJ, "clearCache: ");
        LIZIZ().edit().remove("fine").remove("coarse").apply();
        this.LIZLLL = null;
        this.LJ = null;
    }

    public final SharedPreferences LIZIZ() {
        return (SharedPreferences) this.LJII.getValue();
    }

    public final Address LIZJ() {
        String string = LIZIZ().getString("server_geo", null);
        0bn7 r0 = 0bn7.LIZ;
        String str = this.LIZJ;
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("readAddress: ");
        sbLIZ.append(string);
        0bn7.LIZIZ(str, 0wS0.LIZIZ(sbLIZ));
        String strLIZIZ = 08SS.LIZIZ(2, string);
        if (strLIZIZ == null) {
            return null;
        }
        String str2 = this.LIZJ;
        StringBuilder sbLIZ2 = 0wS0.LIZ();
        sbLIZ2.append("readAddress: ");
        sbLIZ2.append(strLIZIZ);
        0bn7.LIZIZ(str2, 0wS0.LIZIZ(sbLIZ2));
        return 0iv9.LIZ(strLIZIZ);
    }

    public final void LIZLLL() {
        054i r0 = this.LIZIZ;
        long j = r0.LIZIZ;
        this.LJI = (((long) new SecureRandom().nextInt((int) (r0.LIZJ - j))) + j) * 1000;
        0bn7 r1 = 0bn7.LIZ;
        String str = this.LIZJ;
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("resetCacheTime: ");
        sbLIZ.append(this.LJI);
        0bn7.LIZLLL(str, 0wS0.LIZIZ(sbLIZ));
    }

    public final void LJ(LocationData locationData) {
        0bn7 r0 = 0bn7.LIZ;
        String str = this.LIZJ;
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("setCache: loc=");
        sbLIZ.append(locationData);
        0bn7.LIZIZ(str, 0wS0.LIZIZ(sbLIZ));
        if (locationData.fuzzType != 0) {
            locationData.isCache = true;
            this.LJ = locationData;
            String str2 = this.LIZJ;
            StringBuilder sbLIZ2 = 0wS0.LIZ();
            sbLIZ2.append("saveCoarseToSp: ");
            sbLIZ2.append(locationData);
            0bn7.LIZIZ(str2, 0wS0.LIZIZ(sbLIZ2));
            LIZIZ().edit().putString("coarse", 08SS.LIZ(2, GsonProtectorUtils.toJson((Gson) GsonHelper.LIZ.getValue(), locationData))).apply();
            return;
        }
        locationData.isCache = true;
        this.LIZLLL = locationData;
        String str3 = this.LIZJ;
        StringBuilder sbLIZ3 = 0wS0.LIZ();
        sbLIZ3.append("saveFineToSp: ");
        sbLIZ3.append(locationData);
        0bn7.LIZIZ(str3, 0wS0.LIZIZ(sbLIZ3));
        LIZIZ().edit().putString("fine", 08SS.LIZ(2, GsonProtectorUtils.toJson((Gson) GsonHelper.LIZ.getValue(), locationData))).apply();
    }
}
