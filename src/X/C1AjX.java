package X;

import Y.AObjectS154S0000000_17;
import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.basics.CertProviderManagerKt;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.i18n.location.api.AreaModel;
import com.bytedance.i18n.location.api.LocationClient;
import com.bytedance.i18n.location.api.LocationData;
import com.bytedance.i18n.location.api.ReversedGeo;
import com.bytedance.i18n.location.api.internal.GsonHelper;
import com.bytedance.i18n.location.core.LocationClientImpl;
import com.bytedance.i18n.location.core.network.model.response.DataModel;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.gson.Gson;
import java.util.List;
import java.util.Locale;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

public final class C1AjX {
    public static final TokenCert LJIIJJI;
    public static final Cert LJIIL;
    public final 0boT LIZ;
    public final 0bmk LIZIZ;
    public final C1AkP LIZJ;
    public final LocationClientImpl LIZLLL;
    public final C1AkW LJ;
    public final C1Ak5 LJFF;
    public final C00021Ajt LJI;
    public final Context LJII;
    public final 06vB LJIIIIZZ;
    public final 06vB LJIIIZ;
    public final 06vB LJIIJ;

    static {
        TokenCert tokenCertWith = TokenCert.Companion.with("bpea-common_decrypt_location_data");
        tokenCertWith.auth("mckd");
        LJIIJJI = tokenCertWith;
        LJIIL = CertProviderManagerKt.findCert("bpea-poi_sensor_for_lbs", 1476415508);
    }

    public C1AjX(0boT r9, final 0bmk r10, final C1AkP c1AkP, LocationClientImpl locationClientImpl) {
        this.LIZ = r9;
        this.LIZIZ = r10;
        this.LIZJ = c1AkP;
        this.LIZLLL = locationClientImpl;
        C1AkW c1AkW = new C1AkW();
        this.LJ = c1AkW;
        C1Ak5 c1Ak5 = new C1Ak5(r9);
        this.LJFF = c1Ak5;
        this.LJI = C00021Ajt.LIZ;
        final Context contextQ = 0Vx6.Q(r9.LIZ);
        this.LJII = contextQ;
        this.LJIIIIZZ = 02vO.LIZIZ(new Function0() {
            public final Object invoke() {
                final C1AjX c1AjX = this.LL;
                c1AjX.getClass();
                boolean z = 0Vx6.e0(GoogleApiAvailability.getInstance(), c1AjX.LJII) == 0;
                0N3e r0 = 0N3e.LIZ;
                0bn7 r1 = 0bn7.LIZ;
                0bn7.LIZLLL("SdkMonitorWrapper", "reportGmsStatus: " + z);
                if (0N3e.LIZ()) {
                    0Vx6.LJJLIIIIJ(0N3e.LIZJ, new 0N3U(z));
                } else {
                    0bn7.LIZLLL("SdkMonitorWrapper", "reportGmsStatus: not initialized");
                }
                return new C00111Akc(c1AjX.LJII, new Function0() {
                    public final Object invoke() {
                        int i;
                        C1AjX c1AjX2 = c1AjX;
                        if (0boR.LIZIZ(c1AjX2.LJII)) {
                            i = 2;
                        } else {
                            i = 0boR.LIZ(c1AjX2.LJII) ? 1 : 0;
                        }
                        return Integer.valueOf(i);
                    }
                });
            }
        });
        this.LJIIIZ = 02vO.LIZIZ(new Function0() {
            public final Object invoke() {
                C1AjX c1AjX = this.LL;
                return new C1AjW(c1AjX, c1AjX.LJFF);
            }
        });
        this.LJIIJ = 02vO.LIZIZ(new Function0() {
            public final Object invoke() {
                return new C1Aji(this.LL);
            }
        });
        final Function0 function0 = r9.LJIJI;
        c1AkW.LIZ("before_loc", new C1Ajj(function0) {
            public final Function0<Boolean> LIZ;

            {
                this.LIZ = function0;
            }

            @Override
            public final C1AjZ LIZ(C1Ajl c1Ajl) {
                Pair pair;
                LocationClient locationClient = 06vM.LIZ;
                if (!locationClient.isInitialized()) {
                    0bn7 r0 = 0bn7.LIZ;
                    0bn7.LIZJ("BlockStrategy", "Not initialized, block", (Throwable) null);
                    switch (locationClient.LIZLLL()) {
                        case -10004:
                            pair = new Pair(-10004, "not_initialized_config_query_failed");
                            break;
                        case -10003:
                            pair = new Pair(-10003, "not_initialized_config_not_found");
                            break;
                        case -10002:
                            pair = new Pair(-10002, "not_initialized_yu");
                            break;
                        case -10001:
                            pair = new Pair(-10001, "not_initialized_nl");
                            break;
                        default:
                            pair = new Pair(-10000, "not_initialized");
                            break;
                    }
                    return C1AjY.LIZIZ(c1Ajl, ((Number) pair.getFirst()).intValue(), (String) pair.getSecond());
                }
                if (!locationClient.LJIIJ()) {
                    0bn7 r1 = 0bn7.LIZ;
                    0bn7.LIZJ("BlockStrategy", "Not consented, block", (Throwable) null);
                    return C1AjY.LIZIZ(c1Ajl, -2003, "unconsented");
                }
                Function0<Boolean> function1 = this.LIZ;
                if (function1 != null && ((Boolean) function1.invoke()).booleanValue()) {
                    0bn7 r2 = 0bn7.LIZ;
                    0bn7.LIZJ("BlockStrategy", "Background mode, block", (Throwable) null);
                    return C1AjY.LIZIZ(c1Ajl, -2002, "bg_blocked");
                }
                if (!((Boolean) locationClient.LJIILIIL().getFirst()).booleanValue()) {
                    return C1AjY.LIZ(c1Ajl);
                }
                0bn7 r3 = 0bn7.LIZ;
                0bn7.LIZJ("BlockStrategy", "In blocked regions, block", (Throwable) null);
                return C1AjY.LIZIZ(c1Ajl, -2001, "region_blocked");
            }

            @Override
            public final boolean LIZIZ(C1Ajl c1Ajl) {
                return true;
            }

            @Override
            public final int LIZJ() {
                return -1000;
            }

            @Override
            public final String name() {
                return "block";
            }
        });
        final Function0 function1 = r9.LJJIIZI;
        c1AkW.LIZ("before_loc", new C1Ajj(this, function1) {
            public final C1AjX LIZ;
            public final Function0<String> LIZIZ;

            {
                this.LIZ = this;
                this.LIZIZ = function1;
            }

            @Override
            public final C1AjZ LIZ(C1Ajl c1Ajl) {
                String str = (String) this.LIZIZ.invoke();
                0bmk r0 = this.LIZ.LIZIZ;
                return (r0 == null || r0.LJIIL(str)) ? C1AjY.LIZ(c1Ajl) : C1AjY.LIZIZ(c1Ajl, -3001, "no_permission");
            }

            @Override
            public final boolean LIZIZ(C1Ajl c1Ajl) {
                0bmk r0 = this.LIZ.LIZIZ;
                return r0 != null && r0.LJIJ();
            }

            @Override
            public final int LIZJ() {
                return -1;
            }

            @Override
            public final String name() {
                return "permission_consent";
            }
        });
        final boolean z = r9.LJIIJ.LIZ;
        c1AkW.LIZ("before_loc", new C1Ajj(z, r10) {
            public final boolean LIZ;
            public final 0bmk LIZIZ;

            {
                this.LIZ = z;
                this.LIZIZ = r10;
            }

            @Override

            public final X.C1AjZ LIZ(X.C1Ajl r10) {

                throw new UnsupportedOperationException("Method not decompiled: X.C00161Akh.LIZ(X.1Ajl):X.1AjZ");
            }

            @Override
            public final boolean LIZIZ(C1Ajl c1Ajl) {
                return this.LIZ;
            }

            @Override
            public final int LIZJ() {
                return -10000;
            }

            @Override
            public final String name() {
                return "cert";
            }
        });
        c1AkW.LIZ("before_loc", new C00241Akp(r9.LJIIZILJ, this, new Function0() {
            public final Object invoke() {
                return this.LL.LJIIIIZZ.getValue();
            }
        }, new Function0() {
            public final Object invoke() {
                this.LL.getClass();
                return Boolean.FALSE;
            }
        }));
        final boolean z2 = r9.LJIJ;
        final Function0 function2 = new Function0() {
            public final Object invoke() {
                this.LL.getClass();
                return Boolean.FALSE;
            }
        };
        c1AkW.LIZ("after_loc", new C1Ajj(contextQ, z2, function2) {
            public final Context LIZ;
            public final boolean LIZIZ;
            public final Function0<Boolean> LIZJ;

            {
                this.LIZ = contextQ;
                this.LIZIZ = z2;
                this.LIZJ = function2;
            }

            @Override
            public final C1AjZ LIZ(C1Ajl c1Ajl) {
                LocationData locationData = c1Ajl.LIZ;
                if (locationData != null) {
                    Context context = this.LIZ;
                    double d = locationData.latitude;
                    double d2 = locationData.longitude;
                    Unit unit = null;
                    if (Geocoder.isPresent()) {
                        try {
                            List<Address> fromLocation = new Geocoder(context).getFromLocation(d, d2, 10);
                            if (fromLocation != null) {
                                for (Address address : fromLocation) {
                                    if (address.hasLatitude() && address.hasLongitude()) {
                                        locationData.LIZ = new ReversedGeo(0xGu.LJJLIL(address, new 06HP("dzBzEgAjS8/YVFkiQFyNN/m6abexR8WXbuK7oK77isJPSM93Ij6ZPnYb0yyCZ+hEXW/2+nvOYNWN", (String[]) null)), address.getAdminArea(), address.getSubAdminArea(), address.getLocality(), address.getSubLocality(), 0xGu.LJJLIIJ(address, new 06HP("dzBzEgAjS8/YVFkiQFyNN/m6abexR8WXbuK7oK77isJPSM93Ij6ZPnYb0yyCZ+hEXW/2+nvOYNWN", (String[]) null)), address.getPostalCode());
                                    }
                                }
                                unit = Unit.LIZ;
                                01Sf.constructor-impl(unit);
                            } else {
                                01Sf.constructor-impl(unit);
                            }
                        } catch (Throwable th) {
                            01Sf.constructor-impl(new 00ce(th));
                        }
                    }
                }
                return C1AjY.LIZ(c1Ajl);
            }

            @Override
            public final boolean LIZIZ(C1Ajl c1Ajl) {
                LocationData locationData = c1Ajl.LIZ;
                if (locationData == null) {
                    return false;
                }
                if (locationData.LIZIZ() && !locationData.isCache && this.LIZIZ) {
                    return true;
                }
                return ((Boolean) this.LIZJ.invoke()).booleanValue() && Intrinsics.LJFF(locationData.provider, "mock");
            }

            @Override
            public final int LIZJ() {
                return -1000;
            }

            @Override
            public final String name() {
                return "reverse_geo";
            }
        });
        final 0Ir2 r1 = r9.LJIILLIIL;
        final Function0 function3 = new Function0() {
            public final Object invoke() {
                this.LL.getClass();
                return Boolean.FALSE;
            }
        };
        c1AkW.LIZ("after_loc", new C1Ajj(r1, c1AkP, function3) {
            public final 0Ir2 LIZ;
            public final C1AkP LIZIZ;
            public final Function0<Boolean> LIZJ;

            {
                this.LIZ = r1;
                this.LIZIZ = c1AkP;
                this.LIZJ = function3;
            }

            public static void LIZLLL(LocationData locationData) throws 0Uxe {
                double d = locationData.latitude;
                double d2 = locationData.longitude;
                try {
                    String strLIZJ = 0UzY.LIZJ(d);
                    String strLIZJ2 = 0UzY.LIZJ(d2);
                    locationData.encryptedLatitude = strLIZJ;
                    locationData.encryptedLongitude = strLIZJ2;
                    locationData.latitude = 0.0d;
                    locationData.longitude = 0.0d;
                } catch (0Uxe e) {
                    throw e;
                } catch (Throwable th) {
                    String message = th.getMessage();
                    if (message == null) {
                        message = "";
                    }
                    throw new 0Uxe(-1, message);
                }
            }

            @Override
            public final C1AjZ LIZ(C1Ajl c1Ajl) throws 0Uxe {
                LocationData locationData = c1Ajl.LIZ;
                if (locationData != null) {
                    if (locationData.fuzzType != 0) {
                        LocationData locationDataLIZ = LocationData.LIZ(locationData);
                        LIZLLL(locationDataLIZ);
                        this.LIZIZ.LJ(locationDataLIZ);
                    } else {
                        LocationData locationDataLIZ2 = LocationData.LIZ(locationData);
                        LIZLLL(locationDataLIZ2);
                        this.LIZIZ.LJ(locationDataLIZ2);
                        LocationData locationDataLIZ3 = C1Ak3.LIZ(LocationData.LIZ(locationData), this.LIZ);
                        LIZLLL(locationDataLIZ3);
                        this.LIZIZ.LJ(locationDataLIZ3);
                    }
                }
                return C1AjY.LIZ(c1Ajl);
            }

            @Override
            public final boolean LIZIZ(C1Ajl c1Ajl) {
                LocationData locationData;
                LocationData locationData2;
                return (((Boolean) this.LIZJ.invoke()).booleanValue() || (locationData = c1Ajl.LIZ) == null || !locationData.LIZIZ() || (locationData2 = c1Ajl.LIZ) == null || locationData2.isCache) ? false : true;
            }

            @Override
            public final int LIZJ() {
                return 0;
            }

            @Override
            public final String name() {
                return "save_cache";
            }
        });
        final 0Ir2 r0 = r9.LJIILLIIL;
        c1AkW.LIZ("after_loc", new C1Ajj(r0, this) {
            public final 0Ir2 LIZ;
            public final C1AjX LIZIZ;

            {
                this.LIZ = r0;
                this.LIZIZ = this;
            }

            @Override
            public final C1AjZ LIZ(C1Ajl c1Ajl) {
                LocationData locationDataLIZ = c1Ajl.LIZ;
                if (locationDataLIZ != null) {
                    0Ir2 r2 = this.LIZ;
                    if (r2.LIZIZ == 2) {
                        locationDataLIZ = C1Ak3.LIZ(locationDataLIZ, r2);
                    }
                    0bn7 r3 = 0bn7.LIZ;
                    StringBuilder sbLIZ = 0wS0.LIZ();
                    sbLIZ.append("process: from ");
                    sbLIZ.append(c1Ajl.LIZ);
                    sbLIZ.append(" to ");
                    sbLIZ.append(locationDataLIZ);
                    0bn7.LIZIZ("FuzzStrategy", 0wS0.LIZIZ(sbLIZ));
                    StringBuilder sbLIZ2 = 0wS0.LIZ();
                    sbLIZ2.append("process through ");
                    sbLIZ2.append(this.LIZ);
                    0bn7.LIZLLL("FuzzStrategy", 0wS0.LIZIZ(sbLIZ2));
                    c1Ajl.LIZ = locationDataLIZ;
                }
                return C1AjY.LIZ(c1Ajl);
            }

            @Override
            public final boolean LIZIZ(C1Ajl c1Ajl) {
                LocationData locationData;
                if (!this.LIZ.LIZ || (locationData = c1Ajl.LIZ) == null || !locationData.LIZIZ()) {
                    return false;
                }
                C1AjX c1AjX = this.LIZIZ;
                if (!c1AjX.LIZ.LJJIIJ || Build.VERSION.SDK_INT > 31 || 0boR.LIZIZ(c1AjX.LJII)) {
                    LocationData locationData2 = c1Ajl.LIZ;
                    if (locationData2 == null || locationData2.fuzzType != 0) {
                        return false;
                    }
                    if (this.LIZIZ.LIZLLL.LJIIIZ() == 1 && this.LIZIZ.LIZJ()) {
                        return false;
                    }
                }
                return true;
            }

            @Override
            public final int LIZJ() {
                return -1;
            }

            @Override
            public final String name() {
                return "fuzz";
            }
        });
        final boolean z3 = r9.LIZJ;
        final Function0 function4 = new Function0() {
            public final Object invoke() {
                this.LL.getClass();
                return Boolean.FALSE;
            }
        };
        c1AkW.LIZ("after_loc", new C1Ajj(function4, z3) {
            public final boolean LIZ;
            public final Function0<Boolean> LIZIZ;

            {
                this.LIZ = z3;
                this.LIZIZ = function4;
            }

            @Override
            public final C1AjZ LIZ(C1Ajl c1Ajl) {
                054k r2;
                LocationData locationData = c1Ajl.LIZ;
                054j r3 = c1Ajl.LIZIZ;
                Cert cert = (r3 == null || (r2 = r3.LIZ) == null) ? null : r2.LIZIZ;
                if (locationData != null && cert != null) {
                    0Uzb r4 = 0UzY.LJ(locationData.latitude, locationData.longitude, cert);
                    locationData.encryptedLatitude = r4.LIZ;
                    locationData.encryptedLongitude = r4.LIZIZ;
                    locationData.latitude = 0.0d;
                    locationData.longitude = 0.0d;
                }
                return C1AjY.LIZ(c1Ajl);
            }

            @Override
            public final boolean LIZIZ(C1Ajl c1Ajl) {
                LocationData locationData;
                return (!this.LIZ || (locationData = c1Ajl.LIZ) == null || locationData.isCache || !locationData.LIZIZ() || ((Boolean) this.LIZIZ.invoke()).booleanValue()) ? false : true;
            }

            @Override
            public final int LIZJ() {
                return -10;
            }

            @Override
            public final String name() {
                return "encrypt";
            }
        });
        final Function0 function5 = null;
        c1AkW.LIZ("before_upload", new C1Ajj(function5) {
            public final Function0<Boolean> LIZ;

            {
                this.LIZ = function5;
            }

            @Override
            public final C1AjZ LIZ(C1Ajl c1Ajl) {
                Pair pair;
                LocationClient locationClient = 06vM.LIZ;
                if (!locationClient.isInitialized()) {
                    0bn7 r2 = 0bn7.LIZ;
                    0bn7.LIZJ("BlockStrategy", "Not initialized, block", (Throwable) null);
                    switch (locationClient.LIZLLL()) {
                        case -10004:
                            pair = new Pair(-10004, "not_initialized_config_query_failed");
                            break;
                        case -10003:
                            pair = new Pair(-10003, "not_initialized_config_not_found");
                            break;
                        case -10002:
                            pair = new Pair(-10002, "not_initialized_yu");
                            break;
                        case -10001:
                            pair = new Pair(-10001, "not_initialized_nl");
                            break;
                        default:
                            pair = new Pair(-10000, "not_initialized");
                            break;
                    }
                    return C1AjY.LIZIZ(c1Ajl, ((Number) pair.getFirst()).intValue(), (String) pair.getSecond());
                }
                if (!locationClient.LJIIJ()) {
                    0bn7 r3 = 0bn7.LIZ;
                    0bn7.LIZJ("BlockStrategy", "Not consented, block", (Throwable) null);
                    return C1AjY.LIZIZ(c1Ajl, -2003, "unconsented");
                }
                Function0<Boolean> function6 = this.LIZ;
                if (function6 != null && ((Boolean) function6.invoke()).booleanValue()) {
                    0bn7 r4 = 0bn7.LIZ;
                    0bn7.LIZJ("BlockStrategy", "Background mode, block", (Throwable) null);
                    return C1AjY.LIZIZ(c1Ajl, -2002, "bg_blocked");
                }
                if (!((Boolean) locationClient.LJIILIIL().getFirst()).booleanValue()) {
                    return C1AjY.LIZ(c1Ajl);
                }
                0bn7 r5 = 0bn7.LIZ;
                0bn7.LIZJ("BlockStrategy", "In blocked regions, block", (Throwable) null);
                return C1AjY.LIZIZ(c1Ajl, -2001, "region_blocked");
            }

            @Override
            public final boolean LIZIZ(C1Ajl c1Ajl) {
                return true;
            }

            @Override
            public final int LIZJ() {
                return -1000;
            }

            @Override
            public final String name() {
                return "block";
            }
        });
        final 0V1W r2 = r9.LJJIIZ;
        c1AkW.LIZ("before_upload", new C1Ajj(c1AkP, r2) {
            public final C1AkP LIZ;
            public final 0V1W LIZIZ;

            {
                this.LIZ = c1AkP;
                this.LIZIZ = r2;
            }

            @Override
            public final C1AjZ LIZ(C1Ajl c1Ajl) {
                C1AkB c1AkB;
                C1AkB c1AkB2;
                0V1V r3 = 06vM.LJ.LJ();
                if (r3 == null) {
                    String string = this.LIZ.LIZIZ().getString("wifi_rule", "");
                    if (string == null) {
                        string = "";
                    }
                    r3 = 0V1U.LIZIZ(string);
                }
                String string2 = this.LIZ.LIZIZ().getString("match_rule_info", "");
                if (string2 != null) {
                    try {
                        JSONObject jSONObject = new JSONObject(string2);
                        c1AkB = new C1AkB(jSONObject.optLong("l0_id", 0L), jSONObject.optLong("l1_id", 0L), jSONObject.optLong("l2_id", 0L), jSONObject.optString("version", "0"));
                        01Sf.constructor-impl(c1AkB);
                    } catch (Throwable th) {
                        c1AkB = new 00ce(th);
                        01Sf.constructor-impl(c1AkB);
                    }
                    if (01Sf.isFailure-impl(c1AkB)) {
                        c1AkB = null;
                    }
                    c1AkB2 = c1AkB;
                    if (c1AkB2 == null) {
                        c1AkB2 = new C1AkB(0);
                    }
                } else {
                    c1AkB2 = new C1AkB(0);
                }
                if (r3 != null && r3.LIZ == c1AkB2.LIZ && r3.LIZIZ == c1AkB2.LIZIZ && r3.LIZJ == c1AkB2.LIZJ) {
                    c1AkB2 = new C1AkB(r3.LIZ, r3.LIZIZ, r3.LIZJ, r3.LIZLLL.isEmpty() ? "0" : r3.LJ);
                }
                c1Ajl.LJFF = c1AkB2;
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
                return "pre-submit";
            }
        });
        c1AkW.LIZ("after_upload", new C1Ajj(c1AkP) {
            public final C1AkP LIZ;
            public long LIZIZ;

            {
                Long lValueOf;
                this.LIZ = c1AkP;
                try {
                    lValueOf = Long.valueOf(c1AkP.LIZIZ().getLong("country_id", 0L));
                    01Sf.constructor-impl(lValueOf);
                } catch (Throwable th) {
                    lValueOf = new 00ce(th);
                    01Sf.constructor-impl(lValueOf);
                }
                this.LIZIZ = (01Sf.exceptionOrNull-impl(lValueOf) != null ? 0L : lValueOf).longValue();
            }

            @Override
            public final C1AjZ LIZ(C1Ajl c1Ajl) {
                Long l;
                Long l2;
                Long l3;
                DataModel dataModel = c1Ajl.LIZJ;
                if (dataModel != null) {
                    long j = dataModel.cacheTTL;
                    long jLongValue = 0;
                    if (j > 0) {
                        C1AkP c1AkP2 = this.LIZ;
                        long j2 = j * ((long) 1000);
                        c1AkP2.getClass();
                        0bn7 r3 = 0bn7.LIZ;
                        String str = c1AkP2.LIZJ;
                        StringBuilder sbLIZ = 0wS0.LIZ();
                        sbLIZ.append("setCacheTimeMills: ");
                        sbLIZ.append(j2);
                        0bn7.LIZLLL(str, 0wS0.LIZIZ(sbLIZ));
                        c1AkP2.LJI = j2;
                    }
                    com.bytedance.i18n.location.api.Address address = dataModel.address;
                    if (address != null) {
                        LocationData locationData = c1Ajl.LIZ;
                        if (locationData != null) {
                            locationData.address = address;
                        }
                        C1AkP c1AkP3 = this.LIZ;
                        c1AkP3.getClass();
                        0bn7 r4 = 0bn7.LIZ;
                        String str2 = c1AkP3.LIZJ;
                        StringBuilder sbLIZ2 = 0wS0.LIZ();
                        sbLIZ2.append("setAddress: ");
                        sbLIZ2.append(address);
                        0bn7.LIZIZ(str2, 0wS0.LIZIZ(sbLIZ2));
                        c1AkP3.LJFF = address;
                        LocationData locationData2 = c1AkP3.LIZLLL;
                        if (locationData2 != null) {
                            locationData2.address = address;
                        }
                        LocationData locationData3 = c1AkP3.LJ;
                        if (locationData3 != null) {
                            locationData3.address = address;
                        }
                        c1AkP3.LIZIZ().edit().putString("server_geo", 08SS.LIZ(2, GsonProtectorUtils.toJson((Gson) GsonHelper.LIZ.getValue(), address))).apply();
                        AreaModel areaModel = address.country;
                        if (areaModel != null && (l = areaModel.geoNameId) != null) {
                            long jLongValue2 = l.longValue();
                            StringBuilder sbLIZ3 = 0wS0.LIZ();
                            sbLIZ3.append("lastCountryId=");
                            sbLIZ3.append(this.LIZIZ);
                            sbLIZ3.append(", currentCountryId=");
                            sbLIZ3.append(jLongValue2);
                            0bn7.LIZIZ("ServerResultStrategy", 0wS0.LIZIZ(sbLIZ3));
                            if (this.LIZIZ != jLongValue2) {
                                this.LIZIZ = jLongValue2;
                                this.LIZ.LIZIZ().edit().putLong("country_id", jLongValue2).apply();
                                0bn7.LIZLLL("ServerResultStrategy", "trigger region update due to country updated");
                                0bpl r5 = 0bpl.LIZ;
                                if (0bpl.LIZIZ()) {
                                    0bpl.LJ(0bpy.COUNTRY_UPDATED, (AObjectS154S0000000_17) null);
                                }
                            }
                            AreaModel areaModel2 = address.adminArea;
                            long jLongValue3 = (areaModel2 == null || (l3 = areaModel2.geoNameId) == null) ? 0L : l3.longValue();
                            AreaModel areaModel3 = address.city;
                            if (areaModel3 != null && (l2 = areaModel3.geoNameId) != null) {
                                jLongValue = l2.longValue();
                            }
                            this.LIZ.LIZIZ().edit().putString("match_rule_info", 0Vx6.M(new C1AkB(jLongValue2, jLongValue3, jLongValue, "0").LIZ())).apply();
                        }
                    }
                }
                return C1AjY.LIZ(c1Ajl);
            }

            @Override
            public final boolean LIZIZ(C1Ajl c1Ajl) {
                return true;
            }

            @Override
            public final int LIZJ() {
                return 1;
            }

            @Override
            public final String name() {
                return "server_cache";
            }
        });
        c1AkW.LIZ("after_upload", new C00261Akr(c1AkP, r9.LJJIIZ, c1Ak5));
    }

    public static LocationData LIZIZ(C1AjZ c1AjZ) {
        if (!(c1AjZ.LIZIZ < 0)) {
            return null;
        }
        0bn7 r0 = 0bn7.LIZ;
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("Strategy error: code=");
        sbLIZ.append(c1AjZ.LIZIZ);
        sbLIZ.append(", msg=");
        sbLIZ.append(c1AjZ.LIZJ);
        0bn7.LIZJ("LocationClient", 0wS0.LIZIZ(sbLIZ), (Throwable) null);
        int i = c1AjZ.LIZIZ;
        if (i == -1001) {
            return (LocationData) LocationData.LJIIIZ.getValue();
        }
        switch (i) {
            case -10004:
                return (LocationData) LocationData.LJIILLIIL.getValue();
            case -10003:
                return (LocationData) LocationData.LJIILL.getValue();
            case -10002:
                return (LocationData) LocationData.LJIILJJIL.getValue();
            case -10001:
                return (LocationData) LocationData.LJIILIIL.getValue();
            case -10000:
                return (LocationData) LocationData.LJIIL.getValue();
            default:
                switch (i) {
                    case -2004:
                        return (LocationData) LocationData.LJIIJJI.getValue();
                    case -2003:
                        return (LocationData) LocationData.LJIIJ.getValue();
                    case -2002:
                        return (LocationData) LocationData.LJIIZILJ.getValue();
                    case -2001:
                        return (LocationData) LocationData.LJIJI.getValue();
                    default:
                        return (LocationData) LocationData.LJI.getValue();
                }
        }
    }

    public static void LIZLLL(C1AjX c1AjX, 054j r8, LocationData locationData, long j) {
        c1AjX.getClass();
        List list = 0bml.LIZ;
        c1AjX.LIZLLL.getClass();
        0bml.LIZJ(j, LocationClientImpl.LJIL(r8), "GPS", r8.LIZ(), c1AjX.LIZLLL.LJJ(), locationData.errCode, locationData.LIZIZ() ? "success" : "fail", locationData.isCache, locationData.LIZIZ() ? null : locationData.errMsg);
    }

    public final void LIZ(long j, final String str) {
        0bn7 r0 = 0bn7.LIZ;
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("checkPermissionAndUploadStatus ");
        sbLIZ.append(str);
        0bn7.LIZLLL("LocationClient", 0wS0.LIZIZ(sbLIZ));
        this.LJI.getClass();
        0Vx6.LJJLIIIJJIZ(02v2.LIZ, new Runnable() {
            @Override
            public final void run() {
                C1AjX c1AjX = this.LL;
                String str2 = str;
                0zxW.LIZ("LocationManager@8f6a.checkPermissionAndUploadStatusAsync$core_release$1L");
                ((C1Aji) c1AjX.LJIIJ.getValue()).LIZ(null);
                c1AjX.LJFF.LIZJ(str2);
                0zxW.LIZIZ("LocationManager@8f6a.checkPermissionAndUploadStatusAsync$core_release$1L");
            }
        }, j);
    }

    public final boolean LIZJ() {
        String str;
        0bmk r0 = this.LIZIZ;
        if (r0 != null) {
            return r0.LIZ() == 2;
        }
        Function0 function0 = this.LIZ.LJIJJLI;
        if (function0 == null || (str = (String) function0.invoke()) == null) {
            return false;
        }
        return this.LIZ.LJIL.contains(str.toUpperCase(Locale.ROOT));
    }

    public final void LJ(int i, long j, long j2, 054j r19, String str, String str2, String str3) {
        List list = 0bml.LIZ;
        this.LIZLLL.getClass();
        0bml.LJ(LocationClientImpl.LJIL(r19), "GPS", r19.LIZ(), this.LIZLLL.LJJ(), str, str2, j, j2, i, str3);
    }
}
