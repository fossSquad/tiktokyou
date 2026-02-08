package com.bytedance.i18n.location.core;

import X.00ce;
import X.00zH;
import X.01Sf;
import X.02dx;
import X.02v2;
import X.03qq;
import X.054j;
import X.054k;
import X.06Va;
import X.06vM;
import X.07Un;
import X.0Ir2;
import X.0N3e;
import X.0N3h;
import X.0TTF;
import X.0V1X;
import X.0VOC;
import X.0Vx6;
import X.0aj3;
import X.0bWK;
import X.0bmk;
import X.0bml;
import X.0bn7;
import X.0bnV;
import X.0bnm;
import X.0boR;
import X.0boT;
import X.0wS0;
import X.18x3;
import X.C00001Ajr;
import X.C1AjW;
import X.C1AjX;
import X.C1Ajm;
import X.C1Ak0;
import X.C1Ak1;
import X.C1AkP;
import X.RunnableC00061Ajx;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.SystemClock;
import com.bytedance.bpea.basics.Cert;
import com.bytedance.bpea.cert.token.TokenCert;
import com.bytedance.i18n.location.api.InstrumentationProvider;
import com.bytedance.i18n.location.api.LocationClient;
import com.bytedance.i18n.location.api.LocationData;
import com.bytedance.i18n.location.api.SensorClient;
import com.bytedance.i18n.location.core.LocationClientImpl;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import k93.a;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.AwS411S0200000_17;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

public final class LocationClientImpl implements LocationClient {
    public static final  int LJIIJJI = 0;
    public C1AjX LIZJ;
    public 0bmk LIZLLL;
    public C00001Ajr LJ;
    public C1AkP LJFF;
    public 0boT LJI;
    public Context LJII;
    public long LJIIIIZZ;
    public int LJIIIZ;
    public final AtomicBoolean LIZIZ = new AtomicBoolean(false);
    public final CopyOnWriteArrayList<18x3> LJIIJ = new CopyOnWriteArrayList<>();

    public static LocationClient LJIJJLI() {
        Object objLIZ = 06Va.LIZ(LocationClient.class, false);
        if (objLIZ != null) {
            return (LocationClient) objLIZ;
        }
        if (06Va.LJJIIZ == null) {
            synchronized (LocationClient.class) {
                if (06Va.LJJIIZ == null) {
                    06Va.LJJIIZ = new LocationClientImpl();
                }
            }
        }
        return (LocationClientImpl) 06Va.LJJIIZ;
    }

    public static String LJIL(054j r0) {
        Cert cert;
        String strCertToken;
        054k r1 = r0.LIZ;
        return (r1 == null || (cert = r1.LIZIZ) == null || (strCertToken = cert.certToken()) == null) ? "no_cert" : strCertToken;
    }

    public final void LIZIZ(07Un r18, final 054j r19) {
        String string;
        LocationData locationData;
        String strCertToken;
        Cert cert;
        0bn7 r0 = 0bn7.LIZ;
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("getCurrentLocation: ");
        C1AjX c1AjX = this.LIZJ;
        if (c1AjX == null || (string = c1AjX.toString()) == null) {
            string = "not initialized";
        }
        sbLIZ.append(string);
        sbLIZ.append(' ');
        sbLIZ.append(r19);
        0bn7.LIZLLL("LocationClient", 0wS0.LIZIZ(sbLIZ));
        long jUptimeMillis = SystemClock.uptimeMillis();
        List list = 0bml.LIZ;
        0bml.LIZLLL(LJIL(r19), "GPS", LJJ());
        final C1AjX c1AjX2 = this.LIZJ;
        if (c1AjX2 == null) {
            switch (LIZLLL()) {
                case -10004:
                    locationData = (LocationData) LocationData.LJIILLIIL.getValue();
                    break;
                case -10003:
                    locationData = (LocationData) LocationData.LJIILL.getValue();
                    break;
                case -10002:
                    locationData = (LocationData) LocationData.LJIILJJIL.getValue();
                    break;
                case -10001:
                    locationData = (LocationData) LocationData.LJIILIIL.getValue();
                    break;
                default:
                    locationData = (LocationData) LocationData.LJIIL.getValue();
                    break;
            }
            long jUptimeMillis2 = SystemClock.uptimeMillis() - jUptimeMillis;
            0bml.LIZJ(jUptimeMillis2, LJIL(r19), "GPS", r19.LIZ(), LJJ(), locationData.errCode, "fail", locationData.isCache, locationData.errMsg);
            0N3e r2 = 0N3e.LIZ;
            0N3e.LJIIIIZZ(locationData.errCode, jUptimeMillis2, "get_location", r19.LIZLLL, "fail", locationData.errMsg, locationData.isCache, false);
            r18.accept(locationData);
            return;
        }
        long jUptimeMillis3 = SystemClock.uptimeMillis();
        LocationClientImpl locationClientImpl = c1AjX2.LIZLLL;
        Context context = c1AjX2.LJII;
        locationClientImpl.getClass();
        int i = (!0boR.LIZJ(context) ? 1 : 0) | ((!c1AjX2.LIZLLL.isLocationPermissionGranted(c1AjX2.LJII) ? 1 : 0) << 1);
        if (i == 0) {
            054k r3 = r19.LIZ;
            if (r3 != null) {
                r3.LIZ = "getCurrentLocation";
            }
            c1AjX2.LJI.getClass();
            final a aVar = 02v2.LIZ;
            final 0TTF r6 = new 0TTF() {
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    ((0xI3) c1AjX2.LJIIIIZZ.getValue()).LIZ((Cert) obj, (Handler) obj2, (07Un) obj3);
                    return Unit.LIZ;
                }
            };
            final long jUptimeMillis4 = SystemClock.uptimeMillis();
            C1AjW c1AjW = (C1AjW) c1AjX2.LJIIIZ.getValue();
            synchronized (c1AjW) {
                c1AjW.LIZ(r18, r19, jUptimeMillis4);
                if (c1AjW.LIZJ) {
                    0bn7.LIZLLL("LocationClient", "tryAddConsumer: already started, skip");
                    0bn7.LIZLLL("LocationClient", "getLocationAsync: request merged, waiting for result");
                    return;
                } else {
                    c1AjW.LIZJ = true;
                    final 00zH r12 = new 00zH();
                    0Vx6.LJJLIIIIJ(aVar, new Runnable() {
                        public final  String LLILLJJLI = "getCurrent";

                        @Override
                        public final void run() throws InterruptedException {
                            final C1AjX c1AjX3 = c1AjX2;
                            final 054j r13 = r19;
                            00zH r4 = r12;
                            final String str = this.LLILLJJLI;
                            final long j = jUptimeMillis4;
                            0TTF r7 = r6;
                            Handler handler = aVar;
                            0zxW.LIZ("LocationManager@8f6a.getLocationAsync$1L");
                            try {
                                C1AjZ c1AjZLIZIZ = c1AjX3.LJ.LIZIZ("before_loc", new C1Ajl(null, r13, 124));
                                LocationData locationDataLIZIZ = C1AjX.LIZIZ(c1AjZLIZIZ);
                                if (locationDataLIZIZ != null) {
                                    ((C1AjW) c1AjX3.LJIIIZ.getValue()).LIZIZ(locationDataLIZIZ, r13, false, str, j, false, null);
                                } else {
                                    LocationData locationData2 = c1AjZLIZIZ.LIZ.LIZ;
                                    r4.element = locationData2;
                                    if (locationData2 != null) {
                                        ((C1AjW) c1AjX3.LJIIIZ.getValue()).LIZIZ(locationData2, r13, !locationData2.isCache, str, j, true, null);
                                    } else {
                                        final 00zH r8 = new 00zH();
                                        if (c1AjX3.LIZ.LJJIFFI) {
                                            r8.element = new C00101Akb();
                                            SensorClient sensorClient = 06vM.LIZJ;
                                            c1AjX3.LJI.getClass();
                                            sensorClient.LIZ(0N3h.LIZ, C1AjX.LJIIL, (078h) r8.element);
                                        }
                                        054k r1 = r13.LIZ;
                                        try {
                                            r7.invoke(r1 != null ? r1.LIZIZ : null, handler, new 07Un() {
                                                public final void accept(Object obj) throws InterruptedException {
                                                    C1AjX c1AjX4 = c1AjX3;
                                                    054j r5 = r13;
                                                    String str2 = str;
                                                    long j2 = j;
                                                    00zH r9 = r8;
                                                    ((C1AjW) c1AjX4.LJIIIZ.getValue()).LIZIZ((LocationData) obj, r5, true, str2, j2, false, (C00101Akb) r9.element);
                                                }
                                            });
                                        } catch (Exception e) {
                                            e = e;
                                            0bn7 r5 = 0bn7.LIZ;
                                            0bn7.LIZJ("LocationClient", "Unexpected exception in getLocationAsync", e);
                                            ((C1AjW) c1AjX3.LJIIIZ.getValue()).LIZIZ((LocationData) LocationData.LJI.getValue(), r13, false, str, j, false, null);
                                        }
                                    }
                                }
                            } catch (Exception e2) {
                                e = e2;
                            }
                            0zxW.LIZIZ("LocationManager@8f6a.getLocationAsync$1L");
                        }
                    });
                    return;
                }
            }
        }
        0bn7.LIZJ("LocationClient", "NO PERMISSION", (Throwable) null);
        LocationData locationData2 = (LocationData) LocationData.LJII.getValue();
        long jUptimeMillis5 = SystemClock.uptimeMillis() - jUptimeMillis3;
        C1AjX.LIZLLL(c1AjX2, r19, locationData2, jUptimeMillis5);
        0N3e r1 = 0N3e.LIZ;
        054k r4 = r19.LIZ;
        if (r4 == null || (cert = r4.LIZIZ) == null || (strCertToken = cert.certToken()) == null) {
            strCertToken = r19.LIZLLL;
        }
        int i2 = locationData2.errCode;
        String str = locationData2.errMsg;
        StringBuilder sbLIZ2 = 0wS0.LIZ();
        sbLIZ2.append(str);
        sbLIZ2.append('-');
        sbLIZ2.append(i);
        0N3e.LJIIIIZZ(i2, jUptimeMillis5, "getCurrent", strCertToken, "fail", 0wS0.LIZIZ(sbLIZ2), false, false);
        r18.accept(locationData2);
    }

    public final void LIZJ() {
        C1AjX c1AjX;
        if (!this.LIZIZ.get() || (c1AjX = this.LIZJ) == null) {
            return;
        }
        c1AjX.LIZ(0L, "in_app_precise_mode_update");
    }

    public final int LIZLLL() {
        int i = this.LJIIIZ;
        if (i != 0) {
            return i;
        }
        0bmk r0 = this.LIZLLL;
        if (r0 != null) {
            return r0.LJFF();
        }
        return 0;
    }

    public final void LJI() {
        C1AjX c1AjX;
        C1AkP c1AkP;
        if (!this.LIZIZ.get() || (c1AjX = this.LIZJ) == null || (c1AkP = c1AjX.LIZJ) == null) {
            return;
        }
        c1AkP.LIZ();
    }

    public final int LJII(Context context) {
        C1AjX c1AjX;
        if (context == null || !0boR.LIZJ(context)) {
            return 0;
        }
        if (0boR.LIZIZ(context) && LJIIIZ() == 1 && this.LIZIZ.get() && (c1AjX = this.LIZJ) != null && c1AjX.LIZJ()) {
            return 2;
        }
        return 0boR.LIZ(context) ? 1 : 0;
    }

    public final int LJIIIZ() {
        if (!this.LIZIZ.get()) {
            return 0;
        }
        0bmk r0 = this.LIZLLL;
        if (r0 != null) {
            return r0.LJII();
        }
        0boT r1 = this.LJI;
        if (r1 == null) {
            r1 = null;
        }
        return r1.LJJIIJZLJL.get();
    }

    public final boolean LJIIJ() {
        if (!isInitialized()) {
            return false;
        }
        0boT r0 = this.LJI;
        if (r0 == null) {
            r0 = null;
        }
        return r0.LJIILJJIL;
    }

    public final boolean LJIIJJI(Context context) {
        return 0boR.LIZ(context);
    }

    public final boolean LJIIL(Context context) {
        return 0boR.LIZIZ(context);
    }

    public final Pair<Boolean, String> LJIILIIL() {
        String str;
        if (!this.LIZIZ.get()) {
            return new Pair<>(Boolean.FALSE, (Object) null);
        }
        0boT r2 = this.LJI;
        if (r2 == null) {
            r2 = null;
        }
        Function0 function0 = r2.LJIJJLI;
        String upperCase = (function0 == null || (str = (String) function0.invoke()) == null) ? null : str.toUpperCase(Locale.ROOT);
        Set set = r2.LJJ;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator it = set.iterator();
            while (it.hasNext()) {
                if (Intrinsics.LJFF(((String) it.next()).toUpperCase(Locale.ROOT), upperCase)) {
                    return new Pair<>(Boolean.TRUE, upperCase);
                }
            }
        }
        return new Pair<>(Boolean.FALSE, (Object) null);
    }

    public final int LJIILL(Context context) {
        TokenCert tokenCert = C1AjX.LJIIJJI;
        if (context == null || !0boR.LIZJ(context)) {
            return 0;
        }
        if (0boR.LIZIZ(context)) {
            return 2;
        }
        return 0boR.LIZ(context) ? 1 : 0;
    }

    public final void LJIJ(final 0boT r18, 0bmk r19, final AwS411S0200000_17 awS411S0200000_17) {
        String str;
        0bWK r0;
        Long l;
        Long l2;
        final long jUptimeMillis = SystemClock.uptimeMillis();
        if (this.LJFF == null) {
            C1AkP c1AkP = new C1AkP(0Vx6.Q(r18.LIZ), r18.LJIIZILJ);
            this.LJFF = c1AkP;
            this.LJIIIIZZ = c1AkP.LIZIZ().getLong("last_load_timestamp", 0L);
        }
        ?? r5 = new Function2() {

            public final Object invoke(Object obj, Object obj2) {
                String str2;
                String str3;
                long j;
                long j2;
                long j3;
                long j4;
                long j5;
                long j6;
                0bmk r11;
                String str4;
                String str5;
                long jCurrentTimeMillis;
                C1AkP c1AkP2;
                0bmk r2;
                0bWK r3;
                Map mapLJIIJ;
                0bWK r12;
                LocationClientImpl locationClientImpl = this.LL;
                0boT r4 = r18;
                long j7 = jUptimeMillis;
                Function2 function2 = awS411S0200000_17;
                int iIntValue = ((Integer) obj).intValue();
                String str6 = (String) obj2;
                locationClientImpl.getClass();
                long jUptimeMillis2 = SystemClock.uptimeMillis();
                Map mapLJIIZILJ = 0osm.LJIIZILJ(r4.LJJIJIIJI);
                if (iIntValue == 0) {
                    str2 = "success";
                    if (iIntValue == 0) {
                        locationClientImpl.LJIIIZ = 0;
                    }
                    C1AjT c1AjT = new C1AjT(j7, jUptimeMillis2, mapLJIIZILJ);
                    List list = 0bml.LIZ;
                    str3 = c1AjT.LIZLLL;
                    j = c1AjT.LJFF;
                    j2 = locationClientImpl.LJIIIIZZ;
                    j3 = c1AjT.LJII;
                    j4 = c1AjT.LJIIIZ;
                    j5 = c1AjT.LJIIJ;
                    j6 = c1AjT.LJIIJJI;
                    r11 = locationClientImpl.LIZLLL;
                    str4 = null;
                    if (r11 != null || (r12 = r11.LJIIIIZZ()) == null) {
                        str5 = null;
                    } else {
                        str5 = r12.LJIIIIZZ;
                    }
                    if (0bml.LIZ()) {
                        mapLJIIJ = 0osm.LJIIJ(new Pair[]{new Pair("load_type", str3), new Pair("location_sdk_result", str2), new Pair("error_code", Integer.valueOf(iIntValue))});
                        if (str5 != null) {
                            mapLJIIJ.put("config_source", str5);
                        }
                        if (str6 != null && str6.length() != 0) {
                            mapLJIIJ.put("error_msg", str6);
                        }
                        0bml.LIZIZ("pns_location_sdk_load_result", mapLJIIJ, 0osm.LJIIJ(new Pair[]{new Pair("cold_start_to_load_start_duration", Long.valueOf(j)), new Pair("last_load_timestamp", Long.valueOf(j2)), new Pair("load_start_to_settings_duration", Long.valueOf(j3)), new Pair("settings_to_load_duration", Long.valueOf(j4)), new Pair("load_to_result_duration", Long.valueOf(j5)), new Pair("load_start_to_result_duration", Long.valueOf(j6))}));
                    }
                    jCurrentTimeMillis = System.currentTimeMillis();
                    locationClientImpl.LJIIIIZZ = jCurrentTimeMillis;
                    c1AkP2 = locationClientImpl.LJFF;
                    if (c1AkP2 != null) {
                        c1AkP2.LIZIZ().edit().putLong("last_load_timestamp", jCurrentTimeMillis).apply();
                    }
                    if (function2 != null) {
                        function2.invoke(Integer.valueOf(iIntValue), str6);
                    }
                    0N3e r1 = 0N3e.LIZ;
                    long j8 = c1AjT.LJIIJ;
                    Long l3 = c1AjT.LJ;
                    Long l4 = c1AjT.LJI;
                    Long l5 = c1AjT.LJIIIIZZ;
                    r2 = locationClientImpl.LIZLLL;
                    if (r2 != null && (r3 = r2.LJIIIIZZ()) != null) {
                        str4 = r3.LJIIIIZZ;
                    }
                    0N3e.LJII(iIntValue, j8, l3, l4, l5, "location_client", str6, str4);
                    return Unit.LIZ;
                }
                str2 = "fail";
                locationClientImpl.LJIIIZ = iIntValue;
                C1AjT c1AjT2 = new C1AjT(j7, jUptimeMillis2, mapLJIIZILJ);
                List list2 = 0bml.LIZ;
                str3 = c1AjT2.LIZLLL;
                j = c1AjT2.LJFF;
                j2 = locationClientImpl.LJIIIIZZ;
                j3 = c1AjT2.LJII;
                j4 = c1AjT2.LJIIIZ;
                j5 = c1AjT2.LJIIJ;
                j6 = c1AjT2.LJIIJJI;
                r11 = locationClientImpl.LIZLLL;
                str4 = null;
                if (r11 != null) {
                    str5 = null;
                } else {
                    str5 = null;
                }
                if (0bml.LIZ()) {
                    mapLJIIJ = 0osm.LJIIJ(new Pair[]{new Pair("load_type", str3), new Pair("location_sdk_result", str2), new Pair("error_code", Integer.valueOf(iIntValue))});
                    if (str5 != null) {
                        mapLJIIJ.put("config_source", str5);
                    }
                    if (str6 != null) {
                        mapLJIIJ.put("error_msg", str6);
                    }
                    0bml.LIZIZ("pns_location_sdk_load_result", mapLJIIJ, 0osm.LJIIJ(new Pair[]{new Pair("cold_start_to_load_start_duration", Long.valueOf(j)), new Pair("last_load_timestamp", Long.valueOf(j2)), new Pair("load_start_to_settings_duration", Long.valueOf(j3)), new Pair("settings_to_load_duration", Long.valueOf(j4)), new Pair("load_to_result_duration", Long.valueOf(j5)), new Pair("load_start_to_result_duration", Long.valueOf(j6))}));
                }
                jCurrentTimeMillis = System.currentTimeMillis();
                locationClientImpl.LJIIIIZZ = jCurrentTimeMillis;
                c1AkP2 = locationClientImpl.LJFF;
                if (c1AkP2 != null) {
                    c1AkP2.LIZIZ().edit().putLong("last_load_timestamp", jCurrentTimeMillis).apply();
                }
                if (function2 != null) {
                    function2.invoke(Integer.valueOf(iIntValue), str6);
                }
                0N3e r6 = 0N3e.LIZ;
                long j9 = c1AjT2.LJIIJ;
                Long l6 = c1AjT2.LJ;
                Long l7 = c1AjT2.LJI;
                Long l8 = c1AjT2.LJIIIIZZ;
                r2 = locationClientImpl.LIZLLL;
                if (r2 != null) {
                    str4 = r3.LJIIIIZZ;
                }
                0N3e.LJII(iIntValue, j9, l6, l7, l8, "location_client", str6, str4);
                return Unit.LIZ;
            }
        };
        synchronized (this) {
            this.LIZLLL = r19;
            Object obj = r18.LJJIJIIJI.get("cold_start_time");
            String str2 = null;
            long jLongValue = (!(obj instanceof Long) || (l2 = (Long) obj) == null) ? 0L : l2.longValue();
            Object obj2 = r18.LJJIJIIJI.get("location_task_load_start_time");
            if ((obj2 instanceof Long) && (l = (Long) obj2) != null) {
                jUptimeMillis = l.longValue();
            }
            long j = jLongValue > 0 ? jUptimeMillis - jLongValue : 0L;
            List list = 0bml.LIZ;
            Object obj3 = r18.LJJIJIIJI.get("load_type");
            if (!(obj3 instanceof String) || (str = (String) obj3) == null) {
                str = "cold_start";
            }
            long j2 = this.LJIIIIZZ;
            0bmk r1 = this.LIZLLL;
            if (r1 != null && (r0 = r1.LJIIIIZZ()) != null) {
                str2 = r0.LJIIIIZZ;
            }
            0bml.LJI(j, j2, str, str2);
            0bmk r3 = this.LIZLLL;
            if (r3 != null && !r3.LJIIJJI()) {
                0bn7 r2 = 0bn7.LIZ;
                StringBuilder sbLIZ = 0wS0.LIZ();
                sbLIZ.append("Initialization not allowed: ");
                sbLIZ.append(r3.LJI());
                sbLIZ.append(", deInit");
                0bn7.LJ("LocationClient", 0wS0.LIZIZ(sbLIZ));
                r5.invoke(Integer.valueOf(r3.LJFF()), r3.LJI());
                deInit();
                return;
            }
            Pair<Boolean, String> pairLJIILIIL = LJIILIIL();
            if (((Boolean) pairLJIILIIL.getFirst()).booleanValue()) {
                0bn7 r4 = 0bn7.LIZ;
                StringBuilder sbLIZ2 = 0wS0.LIZ();
                sbLIZ2.append("In blocked region ");
                sbLIZ2.append((String) pairLJIILIIL.getSecond());
                sbLIZ2.append(", deInit");
                0bn7.LJ("LocationClient", 0wS0.LIZIZ(sbLIZ2));
                r5.invoke(-1001, "region_blocked");
                deInit();
                return;
            }
            if (this.LIZIZ.get()) {
                0bn7.LJ("LocationClient", "already initialized!");
            } else {
                0bn7 r6 = 0bn7.LIZ;
                StringBuilder sbLIZ3 = 0wS0.LIZ();
                sbLIZ3.append("start init: ");
                sbLIZ3.append(r18);
                0bn7.LIZLLL("LocationClient", 0wS0.LIZIZ(sbLIZ3));
                this.LJI = r18;
                this.LJII = 0Vx6.Q(r18.LIZ);
                if (r18.LIZIZ) {
                    0bn7.LIZJ = 2;
                } else {
                    0bn7.LIZJ = 4;
                }
                if (!LJIJJ(r18)) {
                    r5.invoke(-2001, "cert_invalid");
                    this.LIZIZ.set(false);
                    return;
                }
                0bnV r7 = r18.LJIILIIL;
                if (r7 != null) {
                    r6.LIZ(r7);
                }
                long jUptimeMillis2 = SystemClock.uptimeMillis();
                0bn7.LIZLLL("LocationClient", "checkConsentAsync:");
                0Vx6.LJJLIIIIJ(02v2.LIZ, new RunnableC00061Ajx(this, jUptimeMillis2, r5));
            }
        }
    }

    public final boolean LJIJI(Context context) {
        return 0boR.LIZJ(context);
    }

    public final boolean LJIJJ(0boT r13) throws JSONException {
        JSONObject jSONObject;
        String strM;
        0bn7 r0 = 0bn7.LIZ;
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("checkInitCert: ");
        sbLIZ.append(r13.LJIIJ.LIZ);
        0bn7.LIZLLL("LocationClient", 0wS0.LIZIZ(sbLIZ));
        02dx r1 = r13.LJIIJ;
        if (r1.LIZ) {
            Cert cert = r1.LIZIZ;
            if (cert == null) {
                return false;
            }
            StringBuilder sbLIZ2 = 0wS0.LIZ();
            sbLIZ2.append("update params: ");
            sbLIZ2.append(cert);
            0bn7.LIZLLL("LocationClient", 0wS0.LIZIZ(sbLIZ2));
            0bmk r2 = this.LIZLLL;
            if (r2 != null) {
                0aj3 r4 = r2.LJIIIIZZ().LIZ;
                StringBuilder sbLIZ3 = 0wS0.LIZ();
                sbLIZ3.append("update params from location controller: ");
                sbLIZ3.append(r4);
                0bn7.LIZLLL("LocationClient", 0wS0.LIZIZ(sbLIZ3));
                0N3e r3 = 0N3e.LIZ;
                if (r4 != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("auto_report", r4.LIZ);
                    jSONObject2.put("max_count_per_day", r4.LIZIZ);
                    jSONObject2.put("min_interval", r4.LIZJ / ((long) 1000));
                    jSONObject2.put("h3_distance", r4.LJ);
                    jSONObject2.put("h3_resolution", r4.LJFF);
                    jSONObject2.put("accuracy", r4.LJI);
                    strM = 0Vx6.M(jSONObject2);
                } else {
                    strM = null;
                }
                0N3e.LJ("init_cert", strM);
                if (r4 != null) {
                    03qq r5 = r13.LJIIJJI;
                    r5.LIZ = r4.LIZ;
                    r5.LIZIZ = r4.LIZIZ;
                    r5.LIZJ = r4.LIZJ;
                    0Ir2 r6 = r13.LJIILLIIL;
                    r6.LIZ = true;
                    r6.LIZJ = r4.LJ;
                    r6.LIZLLL = r4.LJFF;
                }
            } else {
                C1Ak0 c1Ak0LIZ = C1Ak1.LIZ(cert, "init");
                StringBuilder sbLIZ4 = 0wS0.LIZ();
                sbLIZ4.append("update params from cert: ");
                sbLIZ4.append(c1Ak0LIZ);
                0bn7.LIZLLL("LocationClient", 0wS0.LIZIZ(sbLIZ4));
                if (c1Ak0LIZ != null && (jSONObject = c1Ak0LIZ.LIZJ) != null) {
                    StringBuilder sbLIZ5 = 0wS0.LIZ();
                    sbLIZ5.append("checkInitCert: ");
                    sbLIZ5.append(jSONObject);
                    0bn7.LIZLLL("LocationClient", 0wS0.LIZIZ(sbLIZ5));
                    StringBuilder sbLIZ6 = 0wS0.LIZ();
                    sbLIZ6.append("update ");
                    sbLIZ6.append(jSONObject);
                    0bn7.LIZLLL("InitParams", 0wS0.LIZIZ(sbLIZ6));
                    03qq r7 = r13.LJIIJJI;
                    r7.LIZ = jSONObject.optBoolean("report_at_start", false);
                    r7.LIZIZ = jSONObject.optInt("upload_max_count", 0);
                    r7.LIZJ = jSONObject.optLong("overseas_upload_interval", TimeUnit.DAYS.toSeconds(1L)) * ((long) 1000);
                    0Ir2 r8 = r13.LJIILLIIL;
                    r8.LIZ = jSONObject.optInt("enable_h3", 0) == 1;
                    r8.LIZJ = jSONObject.optInt("h3_distance", 1);
                    r8.LIZLLL = jSONObject.optInt("h3_resolution", 7);
                    StringBuilder sbLIZ7 = 0wS0.LIZ();
                    sbLIZ7.append("update: autoReportConfig=");
                    sbLIZ7.append(r13.LJIIJJI);
                    sbLIZ7.append(" fuzzMode=");
                    sbLIZ7.append(r13.LJIILLIIL);
                    0bn7.LIZLLL("InitParams", 0wS0.LIZIZ(sbLIZ7));
                    return true;
                }
            }
        }
        return true;
    }

    public final String LJJ() {
        if (!this.LIZIZ.get()) {
            return "none";
        }
        Context context = this.LJII;
        if (context == null) {
            context = null;
        }
        int iLJII = LJII(context);
        if (iLJII == 0) {
            return "none";
        }
        if (iLJII != 1) {
            return iLJII == 2 ? "precise" : "none";
        }
        return "coarse";
    }

    public final void LJJI(Function2 function2) {
        00ce r0;
        C1AjX c1AjX;
        C1AkP c1AkP;
        0bn7.LIZLLL("LocationClient", "initLocationManager: ");
        C1AkP c1AkP2 = this.LJFF;
        if (c1AkP2 == null) {
            Context context = this.LJII;
            if (context == null) {
                context = null;
            }
            0boT r1 = this.LJI;
            if (r1 == null) {
                r1 = null;
            }
            c1AkP2 = new C1AkP(context, r1.LJIIZILJ);
        }
        0boT r2 = this.LJI;
        if (r2 == null) {
            r2 = null;
        }
        C1AjX c1AjX2 = new C1AjX(r2, this.LIZLLL, c1AkP2, this);
        0boT r3 = this.LJI;
        if (r3 == null) {
            r3 = null;
        }
        this.LJ = new C00001Ajr(r3, c1AjX2);
        this.LIZJ = c1AjX2;
        0boT r4 = this.LJI;
        if (r4 == null) {
            r4 = null;
        }
        0VOC r5 = r4.LJJII;
        if (r5 != null && r5.LIZIZ) {
            06vM.LIZJ.LJIIZILJ(r5);
        }
        0boT r6 = this.LJI;
        if (r6 == null) {
            r6 = null;
        }
        0V1X r7 = r6.LJJIII;
        if (r7 != null && r7.LIZIZ) {
            06vM.LIZLLL.LJIILLIIL(r7);
        }
        char c = 1;
        this.LIZIZ.set(true);
        int iLJIIIZ = LJIIIZ();
        0N3e r8 = 0N3e.LIZ;
        0N3e.LJIIL("in_app_permission", 0bnm.LIZIZ[iLJIIIZ]);
        0boT r9 = this.LJI;
        if (r9 == null) {
            r9 = null;
        }
        if (0boR.LIZIZ(r9.LIZ)) {
            c = 2;
        } else {
            0boT r10 = this.LJI;
            if (r10 == null) {
                r10 = null;
            }
            if (!0boR.LIZ(r10.LIZ)) {
                c = 0;
            }
        }
        0N3e.LJIIL("system_permission", 0bnm.LIZ[c]);
        if (c == 0 && (c1AjX = this.LIZJ) != null && (c1AkP = c1AjX.LIZJ) != null) {
            c1AkP.LIZ();
        }
        0boT r11 = this.LJI;
        if (r11 == null) {
            r11 = null;
        }
        Context context2 = r11.LIZ;
        try {
            InstrumentationProvider instrumentationProvider = (InstrumentationProvider) 06vM.LJFF.getValue();
            if (instrumentationProvider != null) {
                0Vx6.Q(context2);
                instrumentationProvider.LIZIZ();
                0Vx6.Q(context2);
                instrumentationProvider.LIZ();
            }
            01Sf.constructor-impl((Object) null);
            r0 = null;
        } catch (Throwable th) {
            r0 = new 00ce(th);
            01Sf.constructor-impl(r0);
        }
        Throwable th2 = 01Sf.exceptionOrNull-impl(r0);
        if (th2 != null) {
            0bn7 r12 = 0bn7.LIZ;
            0bn7.LIZJ("LocationClient", "registerInstrumentationComponents: failed", th2);
        }
        if (function2 != null) {
            function2.invoke(0, (Object) null);
        }
        0bn7 r13 = 0bn7.LIZ;
        StringBuilder sb = new StringBuilder("init finished: ");
        0boT r14 = this.LJI;
        sb.append(r14 != null ? r14 : null);
        0bn7.LIZLLL("LocationClient", sb.toString());
    }

    public final void deInit() {
        if (this.LIZIZ.get()) {
            0bn7.LIZLLL("LocationClient", "deInit:");
            C00001Ajr c00001Ajr = this.LJ;
            if (c00001Ajr != null) {
                0boT r0 = this.LJI;
                if (r0 == null) {
                    r0 = null;
                }
                Context context = r0.LIZ;
                0bn7.LIZLLL("AppStatus", "stopTasks");
                a aVar = 0N3h.LIZ;
                aVar.removeCallbacks(c00001Ajr.LJFF);
                0bn7.LIZLLL("AppStatus", "unregisterReceiver");
                0Vx6.LJJLIIIIJ(aVar, new C1Ajm(c00001Ajr, context));
            }
            this.LJ = null;
            this.LIZJ = null;
            this.LIZLLL = null;
        }
        this.LIZIZ.set(false);
        this.LJIIIZ = 0;
        this.LJIIJ.clear();
    }

    public final boolean isInitialized() {
        return this.LIZIZ.get();
    }

    public final boolean isLocationPermissionGranted(Context context) {
        return 0boR.LIZIZ(context) | 0boR.LIZ(context);
    }

    public final void onAppBackground() {
        C00001Ajr c00001Ajr;
        if (!isInitialized() || (c00001Ajr = this.LJ) == null) {
            return;
        }
        0boT r0 = this.LJI;
        if (r0 == null) {
            r0 = null;
        }
        Context context = r0.LIZ;
        0bn7.LIZLLL("AppStatus", "onAppBackground");
        0bn7.LIZLLL("AppStatus", "unregisterReceiver");
        a aVar = 0N3h.LIZ;
        0Vx6.LJJLIIIIJ(aVar, new C1Ajm(c00001Ajr, context));
        aVar.removeCallbacks(c00001Ajr.LJFF);
    }

    public final void onAppForeground() {
        if (isInitialized()) {
            0bn7.LIZLLL("LocationClient", "onAppForeground: ");
            a aVar = 02v2.LIZ;
            0Vx6.LJJLIIIIJ(aVar, new Runnable() {
                @Override
                public final void run() {
                    C1AkP c1AkP;
                    LocationClientImpl locationClientImpl = this.LL;
                    0zxW.LIZ("LocationClientImpl@13bd.onAppForeground$1L");
                    final C00001Ajr c00001Ajr = locationClientImpl.LJ;
                    if (c00001Ajr != null) {
                        0boT r0 = locationClientImpl.LJI;
                        if (r0 == null) {
                            r0 = null;
                        }
                        final Context context = r0.LIZ;
                        0bn7.LIZLLL("AppStatus", "onAppForeground");
                        0bn7.LIZLLL("AppStatus", "registerReceiver");
                        a aVar2 = 0N3h.LIZ;
                        0Vx6.LJJLIIIIJ(aVar2, new Runnable() {
                            @Override
                            public final void run() {
                                C00001Ajr c00001Ajr2 = c00001Ajr;
                                Context context2 = context;
                                0zxW.LIZ("AppStatusManager@9e6.registerReceiver$1L");
                                if (!c00001Ajr2.LIZLLL.getAndSet(true)) {
                                    IntentFilter intentFilter = new IntentFilter("android.location.MODE_CHANGED");
                                    Context contextQ = 0Vx6.Q(context2);
                                    if (contextQ != null) {
                                        0Vx6.LJFF(contextQ, c00001Ajr2.LIZJ, intentFilter);
                                    }
                                }
                                0zxW.LIZIZ("AppStatusManager@9e6.registerReceiver$1L");
                            }
                        });
                        0Vx6.LJJLIIIJJIZ(aVar2, c00001Ajr.LJFF, 3000L);
                    }
                    C1AjX c1AjX = locationClientImpl.LIZJ;
                    if (c1AjX != null && (c1AkP = c1AjX.LIZJ) != null) {
                        c1AkP.LIZLLL();
                    }
                    final C1AjX c1AjX2 = locationClientImpl.LIZJ;
                    if (c1AjX2 != null) {
                        0bn7 r1 = 0bn7.LIZ;
                        StringBuilder sbLIZ = 0wS0.LIZ();
                        sbLIZ.append("uploadStatusIfPermissionChanged ");
                        sbLIZ.append("permission_changed");
                        0bn7.LIZLLL("LocationClient", 0wS0.LIZIZ(sbLIZ));
                        c1AjX2.LJI.getClass();
                        0Vx6.LJJLIIIJJIZ(02v2.LIZ, new Runnable() {
                            public final  String LLILL = "permission_changed";

                            @Override
                            public final void run() {
                                final C1AjX c1AjX3 = c1AjX2;
                                final String str = this.LLILL;
                                0zxW.LIZ("LocationManager@8f6a.uploadStatusIfPermissionChangedAsync$core_release$1L");
                                ((C1Aji) c1AjX3.LJIIJ.getValue()).LIZ(new Function0() {
                                    public final Object invoke() {
                                        C1AjX c1AjX4 = c1AjX3;
                                        c1AjX4.LJFF.LIZJ(str);
                                        return Unit.LIZ;
                                    }
                                });
                                0zxW.LIZIZ("LocationManager@8f6a.uploadStatusIfPermissionChangedAsync$core_release$1L");
                            }
                        }, 1000L);
                    }
                    0zxW.LIZIZ("LocationClientImpl@13bd.onAppForeground$1L");
                }
            });
            0Vx6.LJJLIIIJJIZ(aVar, new Runnable() {
                @Override
                public final void run() {
                    LocationClientImpl locationClientImpl = this.LL;
                    0zxW.LIZ("LocationClientImpl@13bd.onAppForeground$2L");
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    locationClientImpl.getClass();
                    0bn7.LIZLLL("LocationClient", "checkConsentAsync:");
                    0Vx6.LJJLIIIIJ(02v2.LIZ, new RunnableC00061Ajx(locationClientImpl, jCurrentTimeMillis, null));
                    0zxW.LIZIZ("LocationClientImpl@13bd.onAppForeground$2L");
                }
            }, 1000L);
        }
    }
}
