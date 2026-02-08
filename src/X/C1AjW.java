package X;

import android.content.Context;
import android.os.SystemClock;
import android.util.ArrayMap;
import com.bytedance.i18n.location.api.Address;
import com.bytedance.i18n.location.api.AreaModel;
import com.bytedance.i18n.location.api.LocationClient;
import com.bytedance.i18n.location.api.LocationData;
import com.bytedance.i18n.location.api.ReversedGeo;
import com.bytedance.i18n.location.core.LocationClientImpl;
import com.bytedance.i18n.location.core.network.model.response.DataModel;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class C1AjW {
    public final C1Ak5 LIZ;
    public final Map<07Un<LocationData>, C1AjV> LIZIZ = new ArrayMap();
    public volatile boolean LIZJ;
    public final  C1AjX LIZLLL;

    public C1AjW(C1AjX c1AjX, C1Ak5 c1Ak5) {
        this.LIZLLL = c1AjX;
        this.LIZ = c1Ak5;
    }

    public final void LIZ(07Un<LocationData> r3, 054j r4, long j) {
        ((ArrayMap) this.LIZIZ).put(r3, new C1AjV(r4, j));
        0bn7 r0 = 0bn7.LIZ;
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("addConsumer: count=");
        sbLIZ.append(((ArrayMap) this.LIZIZ).size());
        0bn7.LIZLLL("LocationClient", 0wS0.LIZIZ(sbLIZ));
    }

    public final C1AjZ LIZIZ(LocationData locationData, 054j r20, boolean z, String str, long j, boolean z2, C00101Akb c00101Akb) throws InterruptedException {
        00jk r2;
        LocationData locationData2;
        LocationData locationData3;
        long jUptimeMillis = SystemClock.uptimeMillis() - j;
        0N3e r3 = 0N3e.LIZ;
        0N3e.LJIIIIZZ(locationData.errCode, jUptimeMillis, str, r20.LIZLLL, locationData.LIZIZ() ? "ok" : "fail", locationData.errMsg, z2, c00101Akb != null);
        C1AjZ c1AjZLIZIZ = this.LIZLLL.LJ.LIZIZ("after_loc", new C1Ajl(locationData, r20, 124));
        0bn7 r6 = 0bn7.LIZ;
        StringBuilder sbLIZ = 0wS0.LIZ();
        sbLIZ.append("consume: needUpload=");
        sbLIZ.append(z);
        sbLIZ.append(' ');
        sbLIZ.append(c1AjZLIZIZ);
        0bn7.LIZLLL("LocationClient", 0wS0.LIZIZ(sbLIZ));
        C1Ajl c1Ajl = c1AjZLIZIZ.LIZ;
        if (c1Ajl.LIZ == null) {
            c1Ajl.LIZ = locationData;
        }
        if (c1Ajl.LIZIZ == null) {
            c1Ajl.LIZIZ = r20;
        }
        if (c1AjZLIZIZ.LIZIZ != 0) {
            LIZLLL(LocationData.LJFF);
        } else {
            StringBuilder sbLIZ2 = 0wS0.LIZ();
            sbLIZ2.append("consume: notify ");
            sbLIZ2.append(((ArrayMap) this.LIZIZ).size());
            sbLIZ2.append(" consumers");
            0bn7.LIZLLL("LocationClient", 0wS0.LIZIZ(sbLIZ2));
            c1AjZLIZIZ.LIZ.LJ = 06vM.LIZLLL.LJIILJJIL(r20);
            C1Ajl c1Ajl2 = c1AjZLIZIZ.LIZ;
            if (c00101Akb != null) {
                c00101Akb.LIZIZ.await();
                r2 = c00101Akb.LIZ;
            } else {
                r2 = null;
            }
            c1Ajl2.LIZLLL = r2;
            if (r20.LJ.needServerGeocode()) {
                if (z && (locationData2 = c1AjZLIZIZ.LIZ.LIZ) != null && locationData2.LIZIZ()) {
                    c1AjZLIZIZ = LJ(c1AjZLIZIZ.LIZ, j);
                }
                LocationData locationData4 = c1AjZLIZIZ.LIZ.LIZ;
                if (locationData4 != null) {
                    LIZLLL(locationData4);
                    return c1AjZLIZIZ;
                }
            } else {
                LocationData locationData5 = c1AjZLIZIZ.LIZ.LIZ;
                if (locationData5 != null) {
                    LIZLLL(locationData5);
                }
                if (z && (locationData3 = c1AjZLIZIZ.LIZ.LIZ) != null && locationData3.LIZIZ()) {
                    return LJ(c1AjZLIZIZ.LIZ, j);
                }
            }
        }
        return c1AjZLIZIZ;
    }

    public final void LIZLLL(LocationData locationData) {
        List<Pair> listLJIL;
        Unit unit;
        synchronized (this) {
            this.LIZJ = false;
            listLJIL = 0GCz.LJIL(this.LIZIZ);
            ((ArrayMap) this.LIZIZ).clear();
        }
        if (listLJIL.isEmpty()) {
            return;
        }
        C1AjV c1AjV = (C1AjV) ((Pair) 0osB.LJJJJZI(listLJIL)).getSecond();
        long jUptimeMillis = SystemClock.uptimeMillis() - c1AjV.LIZIZ;
        C1AjX.LIZLLL(this.LIZLLL, c1AjV.LIZ, locationData, jUptimeMillis);
        C1AjX c1AjX = this.LIZLLL;
        boolean z = locationData.isCache;
        LocationClientImpl locationClientImpl = c1AjX.LIZLLL;
        if (!locationClientImpl.LJIIJ.isEmpty()) {
            0bn7 r0 = 0bn7.LIZ;
            StringBuilder sbLIZ = 0wS0.LIZ();
            sbLIZ.append("notifyObservers: notifying ");
            sbLIZ.append(locationClientImpl.LJIIJ.size());
            sbLIZ.append(" observers, duration=");
            sbLIZ.append(jUptimeMillis);
            sbLIZ.append("ms, cache=");
            sbLIZ.append(z);
            0bn7.LIZLLL("LocationClient", 0wS0.LIZIZ(sbLIZ));
            Iterator<18x3> it = locationClientImpl.LJIIJ.iterator();
            while (it.hasNext()) {
                try {
                    it.next().LIZ();
                    unit = Unit.LIZ;
                    01Sf.constructor-impl(unit);
                } catch (Throwable th) {
                    unit = new 00ce(th);
                    01Sf.constructor-impl(unit);
                }
                Throwable th2 = 01Sf.exceptionOrNull-impl(unit);
                if (th2 != null) {
                    0bn7 r1 = 0bn7.LIZ;
                    0bn7.LIZJ("LocationClient", "notifyObservers: observer callback failed", th2);
                }
            }
        }
        C1AjX c1AjX2 = this.LIZLLL;
        for (Pair pair : listLJIL) {
            07Un r5 = (07Un) pair.getFirst();
            C1AjV c1AjV2 = (C1AjV) pair.getSecond();
            0bn7 r2 = 0bn7.LIZ;
            StringBuilder sbLIZ2 = 0wS0.LIZ();
            sbLIZ2.append("consumeForEach: ");
            sbLIZ2.append(r5);
            sbLIZ2.append(' ');
            sbLIZ2.append(c1AjV2.LIZ);
            0bn7.LIZLLL("LocationClient", 0wS0.LIZIZ(sbLIZ2));
            054j r7 = c1AjV2.LIZ;
            c1AjX2.getClass();
            LocationData locationDataLIZ = LocationData.LIZ(locationData);
            if (r7.LJ.needDecrypt() && !Intrinsics.LJFF(locationData.provider, "mock")) {
                try {
                    0IeT r3 = 0UzY.LIZIZ(locationDataLIZ.encryptedLatitude, locationDataLIZ.encryptedLongitude, C1AjX.LJIIJJI);
                    locationDataLIZ.latitude = r3.LIZ;
                    locationDataLIZ.longitude = r3.LIZIZ;
                    01Sf.constructor-impl(Unit.LIZ);
                } catch (Throwable th3) {
                    01Sf.constructor-impl(new 00ce(th3));
                }
            }
            Address address = locationDataLIZ.address;
            if (address != null) {
                04iU r4 = r7.LJ;
                if (r4.compareTo(04iU.Grid) < 0) {
                    address.LIZIZ = "";
                    address.LIZ = "";
                    address.LIZJ = "";
                }
                if (r4.compareTo(04iU.District) < 0) {
                    address.district = null;
                    address.city = null;
                }
                if (r4.compareTo(04iU.Province) < 0) {
                    address.adminArea = null;
                }
            }
            r5.accept(locationDataLIZ);
        }
    }

    public final C1AjZ LJ(C1Ajl c1Ajl, long j) {
        LocationData locationData;
        String strLIZIZ;
        C1AjZ c1AjZLIZ;
        DataModel dataModel;
        DataModel dataModel2;
        List list;
        String str;
        String str2;
        String str3;
        int i;
        int i2;
        ?? r7;
        String str4;
        Map<String, String> mapLJIIIIZZ;
        0boT r1;
        LinkedHashMap linkedHashMap;
        String strLIZ;
        String str5;
        long jUptimeMillis = SystemClock.uptimeMillis();
        054j r2 = c1Ajl.LIZIZ;
        C1AjZ c1AjZLIZIZ = this.LIZLLL.LJ.LIZIZ("before_upload", c1Ajl);
        this.LIZLLL.getClass();
        LocationData locationDataLIZIZ = C1AjX.LIZIZ(c1AjZLIZIZ);
        String str6 = "";
        if (locationDataLIZIZ != null) {
            c1Ajl.LIZ = locationDataLIZIZ;
            int i3 = locationDataLIZIZ.errCode;
            String str7 = locationDataLIZIZ.errMsg;
            return C1AjY.LIZIZ(c1Ajl, i3, str7 != null ? str7 : "");
        }
        if (c1AjZLIZIZ.LIZIZ != 0) {
            return c1AjZLIZIZ;
        }
        if (r2 != null) {
            C1AjX c1AjX = this.LIZLLL;
            c1AjX.getClass();
            List list2 = 0bml.LIZ;
            c1AjX.LIZLLL.getClass();
            0bml.LJFF(LocationClientImpl.LJIL(r2), "GPS", r2.LIZ(), c1AjX.LIZLLL.LJJ());
        }
        C1Ajl c1Ajl2 = c1AjZLIZIZ.LIZ;
        054j r0 = c1Ajl2.LIZIZ;
        if (r0 == null || (locationData = c1Ajl2.LIZ) == null) {
            c1AjZLIZ = C1AjY.LIZ(c1Ajl2);
        } else {
            String str8 = locationData.fuzzType != 0 ? "coarse" : "precise";
            C1Ak5 c1Ak5 = this.LIZ;
            c1Ak5.getClass();
            0bn7.LIZLLL("NetworkManager", "submitV2");
            LocationData locationData2 = c1Ajl2.LIZ;
            if (locationData2 != null) {
                0boT r3 = c1Ak5.LIZ;
                Context context = r3.LIZ;
                Locale locale = r3.LJIILL;
                if (locale == null) {
                    locale = Locale.getDefault();
                }
                054j r8 = c1Ajl2.LIZIZ;
                final String str9 = c1Ajl2.LJI;
                final 00jk r4 = c1Ajl2.LIZLLL;
                00pn r13 = c1Ajl2.LJ;
                final C1AkB c1AkB = c1Ajl2.LJFF;
                double d = locationData2.accuracy;
                ReversedGeo reversedGeo = locationData2.LIZ;
                if (reversedGeo == null || (str = reversedGeo.countryName) == null) {
                    String str10 = "";
                    if (reversedGeo != null) {
                        str = reversedGeo.adminArea;
                        if (str == null) {
                            str = "";
                            if (reversedGeo == null) {
                            }
                        }
                        str3 = locationData2.LIZIZ;
                        if (str3 != null) {
                            str6 = str3;
                        } else if (reversedGeo != null && (str5 = reversedGeo.districtName) != null) {
                            str6 = str5;
                        }
                        i = locationData2.fuzzType;
                        if (i == 2) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                            int i4 = i == 0 ? 2 : 1;
                            final C1Ak9 c1Ak9 = new C1Ak9(new C1AkJ(d, str10, str, str2, str6, locationData2.coordinateSystem, i, i2, i4, locationData2.encryptedLatitude, locationData2.encryptedLongitude, locationData2.latitude, locationData2.longitude, locationData2.locateType, locationData2.timestamp), r13);
                            final C1AkH c1AkHLIZ = C1AkG.LIZ(context, locale);
                            if (r8 != null || (str4 = r8.LIZLLL) == null) {
                                str4 = "mock";
                                if (!Intrinsics.LJFF(locationData2.provider, "mock")) {
                                    str4 = "from_client";
                                }
                            }
                            final long jCurrentTimeMillis = System.currentTimeMillis();
                            final String str11 = str4;
                            r7 = new Object(c1Ak9, c1AkHLIZ, str11, jCurrentTimeMillis, r4, c1AkB, str9) {
                                public static final  int LJII = 0;
                                public final C1Ak9 LIZ;
                                public final C1AkH LIZIZ;
                                public final String LIZJ;
                                public final long LIZLLL;
                                public final 00jk LJ;
                                public final C1AkB LJFF;
                                public final String LJI;

                                {
                                    this.LIZ = c1Ak9;
                                    this.LIZIZ = c1AkHLIZ;
                                    this.LIZJ = str11;
                                    this.LIZLLL = jCurrentTimeMillis;
                                    this.LJ = r4;
                                    this.LJFF = c1AkB;
                                    this.LJI = str9;
                                }

                                public final JSONObject LIZ() throws JSONException {
                                    JSONObject jSONObject;
                                    List list3;
                                    JSONObject jSONObject2 = new JSONObject();
                                    C1Ak9 c1Ak10 = this.LIZ;
                                    c1Ak10.getClass();
                                    JSONObject jSONObject3 = new JSONObject();
                                    C1AkJ c1AkJ = c1Ak10.LIZ;
                                    c1AkJ.getClass();
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put("accuracy", c1AkJ.LIZ);
                                    jSONObject4.put("country", c1AkJ.LIZIZ);
                                    jSONObject4.put("province", c1AkJ.LIZJ);
                                    jSONObject4.put("city", c1AkJ.LIZLLL);
                                    jSONObject4.put("district", c1AkJ.LJ);
                                    jSONObject4.put("desensitization_type", c1AkJ.LJI);
                                    jSONObject4.put("location_accuracy_mode", c1AkJ.LJIIIIZZ);
                                    jSONObject4.put("disable_location_shift", c1AkJ.LJII);
                                    jSONObject4.put("encrypted_lat", c1AkJ.LJIIIZ);
                                    jSONObject4.put("encrypted_lng", c1AkJ.LJIIJ);
                                    jSONObject4.put("coordinate_system", c1AkJ.LJFF);
                                    jSONObject4.put("locate_type", c1AkJ.LJIILIIL);
                                    jSONObject4.put("timestamp", c1AkJ.LJIILJJIL / ((long) 1000));
                                    if (c1AkJ.LJIILIIL == 11) {
                                        jSONObject4.put("latitude", c1AkJ.LJIIJJI);
                                        jSONObject4.put("longitude", c1AkJ.LJIIL);
                                    }
                                    jSONObject3.put("sys_location", jSONObject4);
                                    00pn r5 = c1Ak10.LIZIZ;
                                    if (r5 != null && (list3 = r5.LIZ) != null && (!list3.isEmpty())) {
                                        jSONObject3.put("cell_info", new JSONArray((Collection) c1Ak10.LIZIZ.LIZ));
                                    }
                                    jSONObject2.put("location", jSONObject3);
                                    jSONObject2.put("status", this.LIZIZ.LIZ());
                                    jSONObject2.put("upload_source", this.LIZJ);
                                    jSONObject2.put("timestamp", this.LIZLLL);
                                    00jk r6 = this.LJ;
                                    if (r6 != null) {
                                        jSONObject = new JSONObject();
                                        for (Map.Entry entry : r6.LIZ.entrySet()) {
                                            jSONObject.put((String) entry.getKey(), new JSONArray((Collection) entry.getValue()));
                                        }
                                    } else {
                                        jSONObject = null;
                                    }
                                    jSONObject2.put("signals", jSONObject);
                                    C1AkB c1AkB2 = this.LJFF;
                                    jSONObject2.put("match_rule_info", c1AkB2 != null ? c1AkB2.LIZ() : null);
                                    jSONObject2.put("uuid", this.LJI);
                                    return jSONObject2;
                                }

                                public final boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (!(obj instanceof C1AkF)) {
                                        return false;
                                    }
                                    C1AkF c1AkF = (C1AkF) obj;
                                    return Intrinsics.LJFF(this.LIZ, c1AkF.LIZ) && Intrinsics.LJFF(this.LIZIZ, c1AkF.LIZIZ) && Intrinsics.LJFF(this.LIZJ, c1AkF.LIZJ) && this.LIZLLL == c1AkF.LIZLLL && Intrinsics.LJFF(this.LJ, c1AkF.LJ) && Intrinsics.LJFF(this.LJFF, c1AkF.LJFF) && Intrinsics.LJFF(this.LJI, c1AkF.LJI);
                                }

                                public final int hashCode() {
                                    int iHashCode = ((((((this.LIZ.hashCode() * 31) + this.LIZIZ.hashCode()) * 31) + this.LIZJ.hashCode()) * 31) + 0Vx6.c(this.LIZLLL)) * 31;
                                    00jk r5 = this.LJ;
                                    int iHashCode2 = (iHashCode + (r5 == null ? 0 : r5.hashCode())) * 31;
                                    C1AkB c1AkB2 = this.LJFF;
                                    return ((iHashCode2 + (c1AkB2 != null ? c1AkB2.hashCode() : 0)) * 31) + this.LJI.hashCode();
                                }

                                public final String toString() {
                                    StringBuilder sbLIZ = 0wS0.LIZ();
                                    sbLIZ.append("RequestModel(location=");
                                    sbLIZ.append(this.LIZ);
                                    sbLIZ.append(", status=");
                                    sbLIZ.append(this.LIZIZ);
                                    sbLIZ.append(", uploadSource=");
                                    sbLIZ.append(this.LIZJ);
                                    sbLIZ.append(", timestamp=");
                                    sbLIZ.append(this.LIZLLL);
                                    sbLIZ.append(", signals=");
                                    sbLIZ.append(this.LJ);
                                    sbLIZ.append(", matchRuleInfo=");
                                    sbLIZ.append(this.LJFF);
                                    sbLIZ.append(", uuid=");
                                    sbLIZ.append(this.LJI);
                                    sbLIZ.append(')');
                                    return 0wS0.LIZIZ(sbLIZ);
                                }
                            };
                            LocationClient.LIZ.getClass();
                            mapLJIIIIZZ = 0osm.LJIIIIZZ(new Pair[]{new Pair("sdk_version", "3.3.0-alpha.65-bugfix"), new Pair("enable_cache_ttl", String.valueOf(c1Ak5.LIZ.LJIIZILJ.LIZ))});
                            r1 = c1Ak5.LIZ;
                            if (r1.LIZLLL) {
                                linkedHashMap = new LinkedHashMap();
                                strLIZ = 08SS.LIZ(10, 0Vx6.M(r7.LIZ()));
                                if (strLIZ != null) {
                                    linkedHashMap.put("locinfo", strLIZ);
                                }
                                strLIZIZ = c1Ak5.LIZ(c1Ak5.LIZ.LJIIL.LIZ, c1Ak5.LIZIZ, mapLJIIIIZZ, linkedHashMap);
                            } else {
                                strLIZIZ = c1Ak5.LIZIZ(r1.LJIIL.LIZ, c1Ak5.LIZIZ, r7.LIZ(), mapLJIIIIZZ);
                            }
                        }
                        final C1Ak9 c1Ak10 = new C1Ak9(new C1AkJ(d, str10, str, str2, str6, locationData2.coordinateSystem, i, i2, i4, locationData2.encryptedLatitude, locationData2.encryptedLongitude, locationData2.latitude, locationData2.longitude, locationData2.locateType, locationData2.timestamp), r13);
                        final C1AkH c1AkHLIZ2 = C1AkG.LIZ(context, locale);
                        if (r8 != null) {
                            str4 = "mock";
                            if (!Intrinsics.LJFF(locationData2.provider, "mock")) {
                                str4 = "from_client";
                            }
                        } else {
                            str4 = "mock";
                            if (!Intrinsics.LJFF(locationData2.provider, "mock")) {
                                str4 = "from_client";
                            }
                        }
                        final long jCurrentTimeMillis2 = System.currentTimeMillis();
                        final String str12 = str4;
                        r7 = new Object(c1Ak10, c1AkHLIZ2, str12, jCurrentTimeMillis2, r4, c1AkB, str9) {
                            public static final  int LJII = 0;
                            public final C1Ak9 LIZ;
                            public final C1AkH LIZIZ;
                            public final String LIZJ;
                            public final long LIZLLL;
                            public final 00jk LJ;
                            public final C1AkB LJFF;
                            public final String LJI;

                            {
                                this.LIZ = c1Ak10;
                                this.LIZIZ = c1AkHLIZ2;
                                this.LIZJ = str12;
                                this.LIZLLL = jCurrentTimeMillis2;
                                this.LJ = r4;
                                this.LJFF = c1AkB;
                                this.LJI = str9;
                            }

                            public final JSONObject LIZ() throws JSONException {
                                JSONObject jSONObject;
                                List list3;
                                JSONObject jSONObject2 = new JSONObject();
                                C1Ak9 c1Ak11 = this.LIZ;
                                c1Ak11.getClass();
                                JSONObject jSONObject3 = new JSONObject();
                                C1AkJ c1AkJ = c1Ak11.LIZ;
                                c1AkJ.getClass();
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("accuracy", c1AkJ.LIZ);
                                jSONObject4.put("country", c1AkJ.LIZIZ);
                                jSONObject4.put("province", c1AkJ.LIZJ);
                                jSONObject4.put("city", c1AkJ.LIZLLL);
                                jSONObject4.put("district", c1AkJ.LJ);
                                jSONObject4.put("desensitization_type", c1AkJ.LJI);
                                jSONObject4.put("location_accuracy_mode", c1AkJ.LJIIIIZZ);
                                jSONObject4.put("disable_location_shift", c1AkJ.LJII);
                                jSONObject4.put("encrypted_lat", c1AkJ.LJIIIZ);
                                jSONObject4.put("encrypted_lng", c1AkJ.LJIIJ);
                                jSONObject4.put("coordinate_system", c1AkJ.LJFF);
                                jSONObject4.put("locate_type", c1AkJ.LJIILIIL);
                                jSONObject4.put("timestamp", c1AkJ.LJIILJJIL / ((long) 1000));
                                if (c1AkJ.LJIILIIL == 11) {
                                    jSONObject4.put("latitude", c1AkJ.LJIIJJI);
                                    jSONObject4.put("longitude", c1AkJ.LJIIL);
                                }
                                jSONObject3.put("sys_location", jSONObject4);
                                00pn r5 = c1Ak11.LIZIZ;
                                if (r5 != null && (list3 = r5.LIZ) != null && (!list3.isEmpty())) {
                                    jSONObject3.put("cell_info", new JSONArray((Collection) c1Ak11.LIZIZ.LIZ));
                                }
                                jSONObject2.put("location", jSONObject3);
                                jSONObject2.put("status", this.LIZIZ.LIZ());
                                jSONObject2.put("upload_source", this.LIZJ);
                                jSONObject2.put("timestamp", this.LIZLLL);
                                00jk r6 = this.LJ;
                                if (r6 != null) {
                                    jSONObject = new JSONObject();
                                    for (Map.Entry entry : r6.LIZ.entrySet()) {
                                        jSONObject.put((String) entry.getKey(), new JSONArray((Collection) entry.getValue()));
                                    }
                                } else {
                                    jSONObject = null;
                                }
                                jSONObject2.put("signals", jSONObject);
                                C1AkB c1AkB2 = this.LJFF;
                                jSONObject2.put("match_rule_info", c1AkB2 != null ? c1AkB2.LIZ() : null);
                                jSONObject2.put("uuid", this.LJI);
                                return jSONObject2;
                            }

                            public final boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (!(obj instanceof C1AkF)) {
                                    return false;
                                }
                                C1AkF c1AkF = (C1AkF) obj;
                                return Intrinsics.LJFF(this.LIZ, c1AkF.LIZ) && Intrinsics.LJFF(this.LIZIZ, c1AkF.LIZIZ) && Intrinsics.LJFF(this.LIZJ, c1AkF.LIZJ) && this.LIZLLL == c1AkF.LIZLLL && Intrinsics.LJFF(this.LJ, c1AkF.LJ) && Intrinsics.LJFF(this.LJFF, c1AkF.LJFF) && Intrinsics.LJFF(this.LJI, c1AkF.LJI);
                            }

                            public final int hashCode() {
                                int iHashCode = ((((((this.LIZ.hashCode() * 31) + this.LIZIZ.hashCode()) * 31) + this.LIZJ.hashCode()) * 31) + 0Vx6.c(this.LIZLLL)) * 31;
                                00jk r5 = this.LJ;
                                int iHashCode2 = (iHashCode + (r5 == null ? 0 : r5.hashCode())) * 31;
                                C1AkB c1AkB2 = this.LJFF;
                                return ((iHashCode2 + (c1AkB2 != null ? c1AkB2.hashCode() : 0)) * 31) + this.LJI.hashCode();
                            }

                            public final String toString() {
                                StringBuilder sbLIZ = 0wS0.LIZ();
                                sbLIZ.append("RequestModel(location=");
                                sbLIZ.append(this.LIZ);
                                sbLIZ.append(", status=");
                                sbLIZ.append(this.LIZIZ);
                                sbLIZ.append(", uploadSource=");
                                sbLIZ.append(this.LIZJ);
                                sbLIZ.append(", timestamp=");
                                sbLIZ.append(this.LIZLLL);
                                sbLIZ.append(", signals=");
                                sbLIZ.append(this.LJ);
                                sbLIZ.append(", matchRuleInfo=");
                                sbLIZ.append(this.LJFF);
                                sbLIZ.append(", uuid=");
                                sbLIZ.append(this.LJI);
                                sbLIZ.append(')');
                                return 0wS0.LIZIZ(sbLIZ);
                            }
                        };
                        LocationClient.LIZ.getClass();
                        mapLJIIIIZZ = 0osm.LJIIIIZZ(new Pair[]{new Pair("sdk_version", "3.3.0-alpha.65-bugfix"), new Pair("enable_cache_ttl", String.valueOf(c1Ak5.LIZ.LJIIZILJ.LIZ))});
                        r1 = c1Ak5.LIZ;
                        if (r1.LIZLLL) {
                            linkedHashMap = new LinkedHashMap();
                            strLIZ = 08SS.LIZ(10, 0Vx6.M(r7.LIZ()));
                            if (strLIZ != null) {
                                linkedHashMap.put("locinfo", strLIZ);
                            }
                            strLIZIZ = c1Ak5.LIZ(c1Ak5.LIZ.LJIIL.LIZ, c1Ak5.LIZIZ, mapLJIIIIZZ, linkedHashMap);
                        } else {
                            strLIZIZ = c1Ak5.LIZIZ(r1.LJIIL.LIZ, c1Ak5.LIZIZ, r7.LIZ(), mapLJIIIIZZ);
                        }
                    } else {
                        str = "";
                        if (reversedGeo == null) {
                        }
                        str3 = locationData2.LIZIZ;
                        if (str3 != null) {
                            str6 = str3;
                        } else if (reversedGeo != null) {
                            str6 = str5;
                        }
                        i = locationData2.fuzzType;
                        if (i == 2) {
                            i2 = 0;
                        } else {
                            i2 = 1;
                            if (i == 0) {
                            }
                            final C1Ak9 c1Ak11 = new C1Ak9(new C1AkJ(d, str10, str, str2, str6, locationData2.coordinateSystem, i, i2, i4, locationData2.encryptedLatitude, locationData2.encryptedLongitude, locationData2.latitude, locationData2.longitude, locationData2.locateType, locationData2.timestamp), r13);
                            final C1AkH c1AkHLIZ3 = C1AkG.LIZ(context, locale);
                            if (r8 != null) {
                                str4 = "mock";
                                if (!Intrinsics.LJFF(locationData2.provider, "mock")) {
                                    str4 = "from_client";
                                }
                            } else {
                                str4 = "mock";
                                if (!Intrinsics.LJFF(locationData2.provider, "mock")) {
                                    str4 = "from_client";
                                }
                            }
                            final long jCurrentTimeMillis3 = System.currentTimeMillis();
                            final String str13 = str4;
                            r7 = new Object(c1Ak11, c1AkHLIZ3, str13, jCurrentTimeMillis3, r4, c1AkB, str9) {
                                public static final  int LJII = 0;
                                public final C1Ak9 LIZ;
                                public final C1AkH LIZIZ;
                                public final String LIZJ;
                                public final long LIZLLL;
                                public final 00jk LJ;
                                public final C1AkB LJFF;
                                public final String LJI;

                                {
                                    this.LIZ = c1Ak11;
                                    this.LIZIZ = c1AkHLIZ3;
                                    this.LIZJ = str13;
                                    this.LIZLLL = jCurrentTimeMillis3;
                                    this.LJ = r4;
                                    this.LJFF = c1AkB;
                                    this.LJI = str9;
                                }

                                public final JSONObject LIZ() throws JSONException {
                                    JSONObject jSONObject;
                                    List list3;
                                    JSONObject jSONObject2 = new JSONObject();
                                    C1Ak9 c1Ak12 = this.LIZ;
                                    c1Ak12.getClass();
                                    JSONObject jSONObject3 = new JSONObject();
                                    C1AkJ c1AkJ = c1Ak12.LIZ;
                                    c1AkJ.getClass();
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put("accuracy", c1AkJ.LIZ);
                                    jSONObject4.put("country", c1AkJ.LIZIZ);
                                    jSONObject4.put("province", c1AkJ.LIZJ);
                                    jSONObject4.put("city", c1AkJ.LIZLLL);
                                    jSONObject4.put("district", c1AkJ.LJ);
                                    jSONObject4.put("desensitization_type", c1AkJ.LJI);
                                    jSONObject4.put("location_accuracy_mode", c1AkJ.LJIIIIZZ);
                                    jSONObject4.put("disable_location_shift", c1AkJ.LJII);
                                    jSONObject4.put("encrypted_lat", c1AkJ.LJIIIZ);
                                    jSONObject4.put("encrypted_lng", c1AkJ.LJIIJ);
                                    jSONObject4.put("coordinate_system", c1AkJ.LJFF);
                                    jSONObject4.put("locate_type", c1AkJ.LJIILIIL);
                                    jSONObject4.put("timestamp", c1AkJ.LJIILJJIL / ((long) 1000));
                                    if (c1AkJ.LJIILIIL == 11) {
                                        jSONObject4.put("latitude", c1AkJ.LJIIJJI);
                                        jSONObject4.put("longitude", c1AkJ.LJIIL);
                                    }
                                    jSONObject3.put("sys_location", jSONObject4);
                                    00pn r5 = c1Ak12.LIZIZ;
                                    if (r5 != null && (list3 = r5.LIZ) != null && (!list3.isEmpty())) {
                                        jSONObject3.put("cell_info", new JSONArray((Collection) c1Ak12.LIZIZ.LIZ));
                                    }
                                    jSONObject2.put("location", jSONObject3);
                                    jSONObject2.put("status", this.LIZIZ.LIZ());
                                    jSONObject2.put("upload_source", this.LIZJ);
                                    jSONObject2.put("timestamp", this.LIZLLL);
                                    00jk r6 = this.LJ;
                                    if (r6 != null) {
                                        jSONObject = new JSONObject();
                                        for (Map.Entry entry : r6.LIZ.entrySet()) {
                                            jSONObject.put((String) entry.getKey(), new JSONArray((Collection) entry.getValue()));
                                        }
                                    } else {
                                        jSONObject = null;
                                    }
                                    jSONObject2.put("signals", jSONObject);
                                    C1AkB c1AkB2 = this.LJFF;
                                    jSONObject2.put("match_rule_info", c1AkB2 != null ? c1AkB2.LIZ() : null);
                                    jSONObject2.put("uuid", this.LJI);
                                    return jSONObject2;
                                }

                                public final boolean equals(Object obj) {
                                    if (this == obj) {
                                        return true;
                                    }
                                    if (!(obj instanceof C1AkF)) {
                                        return false;
                                    }
                                    C1AkF c1AkF = (C1AkF) obj;
                                    return Intrinsics.LJFF(this.LIZ, c1AkF.LIZ) && Intrinsics.LJFF(this.LIZIZ, c1AkF.LIZIZ) && Intrinsics.LJFF(this.LIZJ, c1AkF.LIZJ) && this.LIZLLL == c1AkF.LIZLLL && Intrinsics.LJFF(this.LJ, c1AkF.LJ) && Intrinsics.LJFF(this.LJFF, c1AkF.LJFF) && Intrinsics.LJFF(this.LJI, c1AkF.LJI);
                                }

                                public final int hashCode() {
                                    int iHashCode = ((((((this.LIZ.hashCode() * 31) + this.LIZIZ.hashCode()) * 31) + this.LIZJ.hashCode()) * 31) + 0Vx6.c(this.LIZLLL)) * 31;
                                    00jk r5 = this.LJ;
                                    int iHashCode2 = (iHashCode + (r5 == null ? 0 : r5.hashCode())) * 31;
                                    C1AkB c1AkB2 = this.LJFF;
                                    return ((iHashCode2 + (c1AkB2 != null ? c1AkB2.hashCode() : 0)) * 31) + this.LJI.hashCode();
                                }

                                public final String toString() {
                                    StringBuilder sbLIZ = 0wS0.LIZ();
                                    sbLIZ.append("RequestModel(location=");
                                    sbLIZ.append(this.LIZ);
                                    sbLIZ.append(", status=");
                                    sbLIZ.append(this.LIZIZ);
                                    sbLIZ.append(", uploadSource=");
                                    sbLIZ.append(this.LIZJ);
                                    sbLIZ.append(", timestamp=");
                                    sbLIZ.append(this.LIZLLL);
                                    sbLIZ.append(", signals=");
                                    sbLIZ.append(this.LJ);
                                    sbLIZ.append(", matchRuleInfo=");
                                    sbLIZ.append(this.LJFF);
                                    sbLIZ.append(", uuid=");
                                    sbLIZ.append(this.LJI);
                                    sbLIZ.append(')');
                                    return 0wS0.LIZIZ(sbLIZ);
                                }
                            };
                            LocationClient.LIZ.getClass();
                            mapLJIIIIZZ = 0osm.LJIIIIZZ(new Pair[]{new Pair("sdk_version", "3.3.0-alpha.65-bugfix"), new Pair("enable_cache_ttl", String.valueOf(c1Ak5.LIZ.LJIIZILJ.LIZ))});
                            r1 = c1Ak5.LIZ;
                            if (r1.LIZLLL) {
                                linkedHashMap = new LinkedHashMap();
                                strLIZ = 08SS.LIZ(10, 0Vx6.M(r7.LIZ()));
                                if (strLIZ != null) {
                                    linkedHashMap.put("locinfo", strLIZ);
                                }
                                strLIZIZ = c1Ak5.LIZ(c1Ak5.LIZ.LJIIL.LIZ, c1Ak5.LIZIZ, mapLJIIIIZZ, linkedHashMap);
                            } else {
                                strLIZIZ = c1Ak5.LIZIZ(r1.LJIIL.LIZ, c1Ak5.LIZIZ, r7.LIZ(), mapLJIIIIZZ);
                            }
                        }
                        final C1Ak9 c1Ak12 = new C1Ak9(new C1AkJ(d, str10, str, str2, str6, locationData2.coordinateSystem, i, i2, i4, locationData2.encryptedLatitude, locationData2.encryptedLongitude, locationData2.latitude, locationData2.longitude, locationData2.locateType, locationData2.timestamp), r13);
                        final C1AkH c1AkHLIZ4 = C1AkG.LIZ(context, locale);
                        if (r8 != null) {
                            str4 = "mock";
                            if (!Intrinsics.LJFF(locationData2.provider, "mock")) {
                                str4 = "from_client";
                            }
                        } else {
                            str4 = "mock";
                            if (!Intrinsics.LJFF(locationData2.provider, "mock")) {
                                str4 = "from_client";
                            }
                        }
                        final long jCurrentTimeMillis4 = System.currentTimeMillis();
                        final String str14 = str4;
                        r7 = new Object(c1Ak12, c1AkHLIZ4, str14, jCurrentTimeMillis4, r4, c1AkB, str9) {
                            public static final  int LJII = 0;
                            public final C1Ak9 LIZ;
                            public final C1AkH LIZIZ;
                            public final String LIZJ;
                            public final long LIZLLL;
                            public final 00jk LJ;
                            public final C1AkB LJFF;
                            public final String LJI;

                            {
                                this.LIZ = c1Ak12;
                                this.LIZIZ = c1AkHLIZ4;
                                this.LIZJ = str14;
                                this.LIZLLL = jCurrentTimeMillis4;
                                this.LJ = r4;
                                this.LJFF = c1AkB;
                                this.LJI = str9;
                            }

                            public final JSONObject LIZ() throws JSONException {
                                JSONObject jSONObject;
                                List list3;
                                JSONObject jSONObject2 = new JSONObject();
                                C1Ak9 c1Ak13 = this.LIZ;
                                c1Ak13.getClass();
                                JSONObject jSONObject3 = new JSONObject();
                                C1AkJ c1AkJ = c1Ak13.LIZ;
                                c1AkJ.getClass();
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("accuracy", c1AkJ.LIZ);
                                jSONObject4.put("country", c1AkJ.LIZIZ);
                                jSONObject4.put("province", c1AkJ.LIZJ);
                                jSONObject4.put("city", c1AkJ.LIZLLL);
                                jSONObject4.put("district", c1AkJ.LJ);
                                jSONObject4.put("desensitization_type", c1AkJ.LJI);
                                jSONObject4.put("location_accuracy_mode", c1AkJ.LJIIIIZZ);
                                jSONObject4.put("disable_location_shift", c1AkJ.LJII);
                                jSONObject4.put("encrypted_lat", c1AkJ.LJIIIZ);
                                jSONObject4.put("encrypted_lng", c1AkJ.LJIIJ);
                                jSONObject4.put("coordinate_system", c1AkJ.LJFF);
                                jSONObject4.put("locate_type", c1AkJ.LJIILIIL);
                                jSONObject4.put("timestamp", c1AkJ.LJIILJJIL / ((long) 1000));
                                if (c1AkJ.LJIILIIL == 11) {
                                    jSONObject4.put("latitude", c1AkJ.LJIIJJI);
                                    jSONObject4.put("longitude", c1AkJ.LJIIL);
                                }
                                jSONObject3.put("sys_location", jSONObject4);
                                00pn r5 = c1Ak13.LIZIZ;
                                if (r5 != null && (list3 = r5.LIZ) != null && (!list3.isEmpty())) {
                                    jSONObject3.put("cell_info", new JSONArray((Collection) c1Ak13.LIZIZ.LIZ));
                                }
                                jSONObject2.put("location", jSONObject3);
                                jSONObject2.put("status", this.LIZIZ.LIZ());
                                jSONObject2.put("upload_source", this.LIZJ);
                                jSONObject2.put("timestamp", this.LIZLLL);
                                00jk r6 = this.LJ;
                                if (r6 != null) {
                                    jSONObject = new JSONObject();
                                    for (Map.Entry entry : r6.LIZ.entrySet()) {
                                        jSONObject.put((String) entry.getKey(), new JSONArray((Collection) entry.getValue()));
                                    }
                                } else {
                                    jSONObject = null;
                                }
                                jSONObject2.put("signals", jSONObject);
                                C1AkB c1AkB2 = this.LJFF;
                                jSONObject2.put("match_rule_info", c1AkB2 != null ? c1AkB2.LIZ() : null);
                                jSONObject2.put("uuid", this.LJI);
                                return jSONObject2;
                            }

                            public final boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (!(obj instanceof C1AkF)) {
                                    return false;
                                }
                                C1AkF c1AkF = (C1AkF) obj;
                                return Intrinsics.LJFF(this.LIZ, c1AkF.LIZ) && Intrinsics.LJFF(this.LIZIZ, c1AkF.LIZIZ) && Intrinsics.LJFF(this.LIZJ, c1AkF.LIZJ) && this.LIZLLL == c1AkF.LIZLLL && Intrinsics.LJFF(this.LJ, c1AkF.LJ) && Intrinsics.LJFF(this.LJFF, c1AkF.LJFF) && Intrinsics.LJFF(this.LJI, c1AkF.LJI);
                            }

                            public final int hashCode() {
                                int iHashCode = ((((((this.LIZ.hashCode() * 31) + this.LIZIZ.hashCode()) * 31) + this.LIZJ.hashCode()) * 31) + 0Vx6.c(this.LIZLLL)) * 31;
                                00jk r5 = this.LJ;
                                int iHashCode2 = (iHashCode + (r5 == null ? 0 : r5.hashCode())) * 31;
                                C1AkB c1AkB2 = this.LJFF;
                                return ((iHashCode2 + (c1AkB2 != null ? c1AkB2.hashCode() : 0)) * 31) + this.LJI.hashCode();
                            }

                            public final String toString() {
                                StringBuilder sbLIZ = 0wS0.LIZ();
                                sbLIZ.append("RequestModel(location=");
                                sbLIZ.append(this.LIZ);
                                sbLIZ.append(", status=");
                                sbLIZ.append(this.LIZIZ);
                                sbLIZ.append(", uploadSource=");
                                sbLIZ.append(this.LIZJ);
                                sbLIZ.append(", timestamp=");
                                sbLIZ.append(this.LIZLLL);
                                sbLIZ.append(", signals=");
                                sbLIZ.append(this.LJ);
                                sbLIZ.append(", matchRuleInfo=");
                                sbLIZ.append(this.LJFF);
                                sbLIZ.append(", uuid=");
                                sbLIZ.append(this.LJI);
                                sbLIZ.append(')');
                                return 0wS0.LIZIZ(sbLIZ);
                            }
                        };
                        LocationClient.LIZ.getClass();
                        mapLJIIIIZZ = 0osm.LJIIIIZZ(new Pair[]{new Pair("sdk_version", "3.3.0-alpha.65-bugfix"), new Pair("enable_cache_ttl", String.valueOf(c1Ak5.LIZ.LJIIZILJ.LIZ))});
                        r1 = c1Ak5.LIZ;
                        if (r1.LIZLLL) {
                            linkedHashMap = new LinkedHashMap();
                            strLIZ = 08SS.LIZ(10, 0Vx6.M(r7.LIZ()));
                            if (strLIZ != null) {
                                linkedHashMap.put("locinfo", strLIZ);
                            }
                            strLIZIZ = c1Ak5.LIZ(c1Ak5.LIZ.LJIIL.LIZ, c1Ak5.LIZIZ, mapLJIIIIZZ, linkedHashMap);
                        } else {
                            strLIZIZ = c1Ak5.LIZIZ(r1.LJIIL.LIZ, c1Ak5.LIZIZ, r7.LIZ(), mapLJIIIIZZ);
                        }
                    }
                    str2 = "";
                    str3 = locationData2.LIZIZ;
                    if (str3 != null) {
                        str6 = str3;
                    } else if (reversedGeo != null) {
                        str6 = str5;
                    }
                    i = locationData2.fuzzType;
                    if (i == 2) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                        if (i == 0) {
                        }
                        final C1Ak9 c1Ak13 = new C1Ak9(new C1AkJ(d, str10, str, str2, str6, locationData2.coordinateSystem, i, i2, i4, locationData2.encryptedLatitude, locationData2.encryptedLongitude, locationData2.latitude, locationData2.longitude, locationData2.locateType, locationData2.timestamp), r13);
                        final C1AkH c1AkHLIZ5 = C1AkG.LIZ(context, locale);
                        if (r8 != null) {
                            str4 = "mock";
                            if (!Intrinsics.LJFF(locationData2.provider, "mock")) {
                                str4 = "from_client";
                            }
                        } else {
                            str4 = "mock";
                            if (!Intrinsics.LJFF(locationData2.provider, "mock")) {
                                str4 = "from_client";
                            }
                        }
                        final long jCurrentTimeMillis5 = System.currentTimeMillis();
                        final String str15 = str4;
                        r7 = new Object(c1Ak13, c1AkHLIZ5, str15, jCurrentTimeMillis5, r4, c1AkB, str9) {
                            public static final  int LJII = 0;
                            public final C1Ak9 LIZ;
                            public final C1AkH LIZIZ;
                            public final String LIZJ;
                            public final long LIZLLL;
                            public final 00jk LJ;
                            public final C1AkB LJFF;
                            public final String LJI;

                            {
                                this.LIZ = c1Ak13;
                                this.LIZIZ = c1AkHLIZ5;
                                this.LIZJ = str15;
                                this.LIZLLL = jCurrentTimeMillis5;
                                this.LJ = r4;
                                this.LJFF = c1AkB;
                                this.LJI = str9;
                            }

                            public final JSONObject LIZ() throws JSONException {
                                JSONObject jSONObject;
                                List list3;
                                JSONObject jSONObject2 = new JSONObject();
                                C1Ak9 c1Ak14 = this.LIZ;
                                c1Ak14.getClass();
                                JSONObject jSONObject3 = new JSONObject();
                                C1AkJ c1AkJ = c1Ak14.LIZ;
                                c1AkJ.getClass();
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("accuracy", c1AkJ.LIZ);
                                jSONObject4.put("country", c1AkJ.LIZIZ);
                                jSONObject4.put("province", c1AkJ.LIZJ);
                                jSONObject4.put("city", c1AkJ.LIZLLL);
                                jSONObject4.put("district", c1AkJ.LJ);
                                jSONObject4.put("desensitization_type", c1AkJ.LJI);
                                jSONObject4.put("location_accuracy_mode", c1AkJ.LJIIIIZZ);
                                jSONObject4.put("disable_location_shift", c1AkJ.LJII);
                                jSONObject4.put("encrypted_lat", c1AkJ.LJIIIZ);
                                jSONObject4.put("encrypted_lng", c1AkJ.LJIIJ);
                                jSONObject4.put("coordinate_system", c1AkJ.LJFF);
                                jSONObject4.put("locate_type", c1AkJ.LJIILIIL);
                                jSONObject4.put("timestamp", c1AkJ.LJIILJJIL / ((long) 1000));
                                if (c1AkJ.LJIILIIL == 11) {
                                    jSONObject4.put("latitude", c1AkJ.LJIIJJI);
                                    jSONObject4.put("longitude", c1AkJ.LJIIL);
                                }
                                jSONObject3.put("sys_location", jSONObject4);
                                00pn r5 = c1Ak14.LIZIZ;
                                if (r5 != null && (list3 = r5.LIZ) != null && (!list3.isEmpty())) {
                                    jSONObject3.put("cell_info", new JSONArray((Collection) c1Ak14.LIZIZ.LIZ));
                                }
                                jSONObject2.put("location", jSONObject3);
                                jSONObject2.put("status", this.LIZIZ.LIZ());
                                jSONObject2.put("upload_source", this.LIZJ);
                                jSONObject2.put("timestamp", this.LIZLLL);
                                00jk r6 = this.LJ;
                                if (r6 != null) {
                                    jSONObject = new JSONObject();
                                    for (Map.Entry entry : r6.LIZ.entrySet()) {
                                        jSONObject.put((String) entry.getKey(), new JSONArray((Collection) entry.getValue()));
                                    }
                                } else {
                                    jSONObject = null;
                                }
                                jSONObject2.put("signals", jSONObject);
                                C1AkB c1AkB2 = this.LJFF;
                                jSONObject2.put("match_rule_info", c1AkB2 != null ? c1AkB2.LIZ() : null);
                                jSONObject2.put("uuid", this.LJI);
                                return jSONObject2;
                            }

                            public final boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (!(obj instanceof C1AkF)) {
                                    return false;
                                }
                                C1AkF c1AkF = (C1AkF) obj;
                                return Intrinsics.LJFF(this.LIZ, c1AkF.LIZ) && Intrinsics.LJFF(this.LIZIZ, c1AkF.LIZIZ) && Intrinsics.LJFF(this.LIZJ, c1AkF.LIZJ) && this.LIZLLL == c1AkF.LIZLLL && Intrinsics.LJFF(this.LJ, c1AkF.LJ) && Intrinsics.LJFF(this.LJFF, c1AkF.LJFF) && Intrinsics.LJFF(this.LJI, c1AkF.LJI);
                            }

                            public final int hashCode() {
                                int iHashCode = ((((((this.LIZ.hashCode() * 31) + this.LIZIZ.hashCode()) * 31) + this.LIZJ.hashCode()) * 31) + 0Vx6.c(this.LIZLLL)) * 31;
                                00jk r5 = this.LJ;
                                int iHashCode2 = (iHashCode + (r5 == null ? 0 : r5.hashCode())) * 31;
                                C1AkB c1AkB2 = this.LJFF;
                                return ((iHashCode2 + (c1AkB2 != null ? c1AkB2.hashCode() : 0)) * 31) + this.LJI.hashCode();
                            }

                            public final String toString() {
                                StringBuilder sbLIZ = 0wS0.LIZ();
                                sbLIZ.append("RequestModel(location=");
                                sbLIZ.append(this.LIZ);
                                sbLIZ.append(", status=");
                                sbLIZ.append(this.LIZIZ);
                                sbLIZ.append(", uploadSource=");
                                sbLIZ.append(this.LIZJ);
                                sbLIZ.append(", timestamp=");
                                sbLIZ.append(this.LIZLLL);
                                sbLIZ.append(", signals=");
                                sbLIZ.append(this.LJ);
                                sbLIZ.append(", matchRuleInfo=");
                                sbLIZ.append(this.LJFF);
                                sbLIZ.append(", uuid=");
                                sbLIZ.append(this.LJI);
                                sbLIZ.append(')');
                                return 0wS0.LIZIZ(sbLIZ);
                            }
                        };
                        LocationClient.LIZ.getClass();
                        mapLJIIIIZZ = 0osm.LJIIIIZZ(new Pair[]{new Pair("sdk_version", "3.3.0-alpha.65-bugfix"), new Pair("enable_cache_ttl", String.valueOf(c1Ak5.LIZ.LJIIZILJ.LIZ))});
                        r1 = c1Ak5.LIZ;
                        if (r1.LIZLLL) {
                            linkedHashMap = new LinkedHashMap();
                            strLIZ = 08SS.LIZ(10, 0Vx6.M(r7.LIZ()));
                            if (strLIZ != null) {
                                linkedHashMap.put("locinfo", strLIZ);
                            }
                            strLIZIZ = c1Ak5.LIZ(c1Ak5.LIZ.LJIIL.LIZ, c1Ak5.LIZIZ, mapLJIIIIZZ, linkedHashMap);
                        } else {
                            strLIZIZ = c1Ak5.LIZIZ(r1.LJIIL.LIZ, c1Ak5.LIZIZ, r7.LIZ(), mapLJIIIIZZ);
                        }
                    }
                    final C1Ak9 c1Ak14 = new C1Ak9(new C1AkJ(d, str10, str, str2, str6, locationData2.coordinateSystem, i, i2, i4, locationData2.encryptedLatitude, locationData2.encryptedLongitude, locationData2.latitude, locationData2.longitude, locationData2.locateType, locationData2.timestamp), r13);
                    final C1AkH c1AkHLIZ6 = C1AkG.LIZ(context, locale);
                    if (r8 != null) {
                        str4 = "mock";
                        if (!Intrinsics.LJFF(locationData2.provider, "mock")) {
                            str4 = "from_client";
                        }
                    } else {
                        str4 = "mock";
                        if (!Intrinsics.LJFF(locationData2.provider, "mock")) {
                            str4 = "from_client";
                        }
                    }
                    final long jCurrentTimeMillis6 = System.currentTimeMillis();
                    final String str16 = str4;
                    r7 = new Object(c1Ak14, c1AkHLIZ6, str16, jCurrentTimeMillis6, r4, c1AkB, str9) {
                        public static final  int LJII = 0;
                        public final C1Ak9 LIZ;
                        public final C1AkH LIZIZ;
                        public final String LIZJ;
                        public final long LIZLLL;
                        public final 00jk LJ;
                        public final C1AkB LJFF;
                        public final String LJI;

                        {
                            this.LIZ = c1Ak14;
                            this.LIZIZ = c1AkHLIZ6;
                            this.LIZJ = str16;
                            this.LIZLLL = jCurrentTimeMillis6;
                            this.LJ = r4;
                            this.LJFF = c1AkB;
                            this.LJI = str9;
                        }

                        public final JSONObject LIZ() throws JSONException {
                            JSONObject jSONObject;
                            List list3;
                            JSONObject jSONObject2 = new JSONObject();
                            C1Ak9 c1Ak15 = this.LIZ;
                            c1Ak15.getClass();
                            JSONObject jSONObject3 = new JSONObject();
                            C1AkJ c1AkJ = c1Ak15.LIZ;
                            c1AkJ.getClass();
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("accuracy", c1AkJ.LIZ);
                            jSONObject4.put("country", c1AkJ.LIZIZ);
                            jSONObject4.put("province", c1AkJ.LIZJ);
                            jSONObject4.put("city", c1AkJ.LIZLLL);
                            jSONObject4.put("district", c1AkJ.LJ);
                            jSONObject4.put("desensitization_type", c1AkJ.LJI);
                            jSONObject4.put("location_accuracy_mode", c1AkJ.LJIIIIZZ);
                            jSONObject4.put("disable_location_shift", c1AkJ.LJII);
                            jSONObject4.put("encrypted_lat", c1AkJ.LJIIIZ);
                            jSONObject4.put("encrypted_lng", c1AkJ.LJIIJ);
                            jSONObject4.put("coordinate_system", c1AkJ.LJFF);
                            jSONObject4.put("locate_type", c1AkJ.LJIILIIL);
                            jSONObject4.put("timestamp", c1AkJ.LJIILJJIL / ((long) 1000));
                            if (c1AkJ.LJIILIIL == 11) {
                                jSONObject4.put("latitude", c1AkJ.LJIIJJI);
                                jSONObject4.put("longitude", c1AkJ.LJIIL);
                            }
                            jSONObject3.put("sys_location", jSONObject4);
                            00pn r5 = c1Ak15.LIZIZ;
                            if (r5 != null && (list3 = r5.LIZ) != null && (!list3.isEmpty())) {
                                jSONObject3.put("cell_info", new JSONArray((Collection) c1Ak15.LIZIZ.LIZ));
                            }
                            jSONObject2.put("location", jSONObject3);
                            jSONObject2.put("status", this.LIZIZ.LIZ());
                            jSONObject2.put("upload_source", this.LIZJ);
                            jSONObject2.put("timestamp", this.LIZLLL);
                            00jk r6 = this.LJ;
                            if (r6 != null) {
                                jSONObject = new JSONObject();
                                for (Map.Entry entry : r6.LIZ.entrySet()) {
                                    jSONObject.put((String) entry.getKey(), new JSONArray((Collection) entry.getValue()));
                                }
                            } else {
                                jSONObject = null;
                            }
                            jSONObject2.put("signals", jSONObject);
                            C1AkB c1AkB2 = this.LJFF;
                            jSONObject2.put("match_rule_info", c1AkB2 != null ? c1AkB2.LIZ() : null);
                            jSONObject2.put("uuid", this.LJI);
                            return jSONObject2;
                        }

                        public final boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (!(obj instanceof C1AkF)) {
                                return false;
                            }
                            C1AkF c1AkF = (C1AkF) obj;
                            return Intrinsics.LJFF(this.LIZ, c1AkF.LIZ) && Intrinsics.LJFF(this.LIZIZ, c1AkF.LIZIZ) && Intrinsics.LJFF(this.LIZJ, c1AkF.LIZJ) && this.LIZLLL == c1AkF.LIZLLL && Intrinsics.LJFF(this.LJ, c1AkF.LJ) && Intrinsics.LJFF(this.LJFF, c1AkF.LJFF) && Intrinsics.LJFF(this.LJI, c1AkF.LJI);
                        }

                        public final int hashCode() {
                            int iHashCode = ((((((this.LIZ.hashCode() * 31) + this.LIZIZ.hashCode()) * 31) + this.LIZJ.hashCode()) * 31) + 0Vx6.c(this.LIZLLL)) * 31;
                            00jk r5 = this.LJ;
                            int iHashCode2 = (iHashCode + (r5 == null ? 0 : r5.hashCode())) * 31;
                            C1AkB c1AkB2 = this.LJFF;
                            return ((iHashCode2 + (c1AkB2 != null ? c1AkB2.hashCode() : 0)) * 31) + this.LJI.hashCode();
                        }

                        public final String toString() {
                            StringBuilder sbLIZ = 0wS0.LIZ();
                            sbLIZ.append("RequestModel(location=");
                            sbLIZ.append(this.LIZ);
                            sbLIZ.append(", status=");
                            sbLIZ.append(this.LIZIZ);
                            sbLIZ.append(", uploadSource=");
                            sbLIZ.append(this.LIZJ);
                            sbLIZ.append(", timestamp=");
                            sbLIZ.append(this.LIZLLL);
                            sbLIZ.append(", signals=");
                            sbLIZ.append(this.LJ);
                            sbLIZ.append(", matchRuleInfo=");
                            sbLIZ.append(this.LJFF);
                            sbLIZ.append(", uuid=");
                            sbLIZ.append(this.LJI);
                            sbLIZ.append(')');
                            return 0wS0.LIZIZ(sbLIZ);
                        }
                    };
                    LocationClient.LIZ.getClass();
                    mapLJIIIIZZ = 0osm.LJIIIIZZ(new Pair[]{new Pair("sdk_version", "3.3.0-alpha.65-bugfix"), new Pair("enable_cache_ttl", String.valueOf(c1Ak5.LIZ.LJIIZILJ.LIZ))});
                    r1 = c1Ak5.LIZ;
                    if (r1.LIZLLL) {
                        linkedHashMap = new LinkedHashMap();
                        strLIZ = 08SS.LIZ(10, 0Vx6.M(r7.LIZ()));
                        if (strLIZ != null) {
                            linkedHashMap.put("locinfo", strLIZ);
                        }
                        strLIZIZ = c1Ak5.LIZ(c1Ak5.LIZ.LJIIL.LIZ, c1Ak5.LIZIZ, mapLJIIIIZZ, linkedHashMap);
                    } else {
                        strLIZIZ = c1Ak5.LIZIZ(r1.LJIIL.LIZ, c1Ak5.LIZIZ, r7.LIZ(), mapLJIIIIZZ);
                    }
                } else {
                    str = reversedGeo.adminArea;
                    if (str == null) {
                        str = "";
                        if (reversedGeo == null) {
                            str2 = "";
                        }
                    }
                    str3 = locationData2.LIZIZ;
                    if (str3 != null) {
                        str6 = str3;
                    } else if (reversedGeo != null) {
                        str6 = str5;
                    }
                    i = locationData2.fuzzType;
                    if (i == 2) {
                        i2 = 0;
                    } else {
                        i2 = 1;
                        if (i == 0) {
                        }
                        final C1Ak9 c1Ak15 = new C1Ak9(new C1AkJ(d, str10, str, str2, str6, locationData2.coordinateSystem, i, i2, i4, locationData2.encryptedLatitude, locationData2.encryptedLongitude, locationData2.latitude, locationData2.longitude, locationData2.locateType, locationData2.timestamp), r13);
                        final C1AkH c1AkHLIZ7 = C1AkG.LIZ(context, locale);
                        if (r8 != null) {
                            str4 = "mock";
                            if (!Intrinsics.LJFF(locationData2.provider, "mock")) {
                                str4 = "from_client";
                            }
                        } else {
                            str4 = "mock";
                            if (!Intrinsics.LJFF(locationData2.provider, "mock")) {
                                str4 = "from_client";
                            }
                        }
                        final long jCurrentTimeMillis7 = System.currentTimeMillis();
                        final String str17 = str4;
                        r7 = new Object(c1Ak15, c1AkHLIZ7, str17, jCurrentTimeMillis7, r4, c1AkB, str9) {
                            public static final  int LJII = 0;
                            public final C1Ak9 LIZ;
                            public final C1AkH LIZIZ;
                            public final String LIZJ;
                            public final long LIZLLL;
                            public final 00jk LJ;
                            public final C1AkB LJFF;
                            public final String LJI;

                            {
                                this.LIZ = c1Ak15;
                                this.LIZIZ = c1AkHLIZ7;
                                this.LIZJ = str17;
                                this.LIZLLL = jCurrentTimeMillis7;
                                this.LJ = r4;
                                this.LJFF = c1AkB;
                                this.LJI = str9;
                            }

                            public final JSONObject LIZ() throws JSONException {
                                JSONObject jSONObject;
                                List list3;
                                JSONObject jSONObject2 = new JSONObject();
                                C1Ak9 c1Ak16 = this.LIZ;
                                c1Ak16.getClass();
                                JSONObject jSONObject3 = new JSONObject();
                                C1AkJ c1AkJ = c1Ak16.LIZ;
                                c1AkJ.getClass();
                                JSONObject jSONObject4 = new JSONObject();
                                jSONObject4.put("accuracy", c1AkJ.LIZ);
                                jSONObject4.put("country", c1AkJ.LIZIZ);
                                jSONObject4.put("province", c1AkJ.LIZJ);
                                jSONObject4.put("city", c1AkJ.LIZLLL);
                                jSONObject4.put("district", c1AkJ.LJ);
                                jSONObject4.put("desensitization_type", c1AkJ.LJI);
                                jSONObject4.put("location_accuracy_mode", c1AkJ.LJIIIIZZ);
                                jSONObject4.put("disable_location_shift", c1AkJ.LJII);
                                jSONObject4.put("encrypted_lat", c1AkJ.LJIIIZ);
                                jSONObject4.put("encrypted_lng", c1AkJ.LJIIJ);
                                jSONObject4.put("coordinate_system", c1AkJ.LJFF);
                                jSONObject4.put("locate_type", c1AkJ.LJIILIIL);
                                jSONObject4.put("timestamp", c1AkJ.LJIILJJIL / ((long) 1000));
                                if (c1AkJ.LJIILIIL == 11) {
                                    jSONObject4.put("latitude", c1AkJ.LJIIJJI);
                                    jSONObject4.put("longitude", c1AkJ.LJIIL);
                                }
                                jSONObject3.put("sys_location", jSONObject4);
                                00pn r5 = c1Ak16.LIZIZ;
                                if (r5 != null && (list3 = r5.LIZ) != null && (!list3.isEmpty())) {
                                    jSONObject3.put("cell_info", new JSONArray((Collection) c1Ak16.LIZIZ.LIZ));
                                }
                                jSONObject2.put("location", jSONObject3);
                                jSONObject2.put("status", this.LIZIZ.LIZ());
                                jSONObject2.put("upload_source", this.LIZJ);
                                jSONObject2.put("timestamp", this.LIZLLL);
                                00jk r6 = this.LJ;
                                if (r6 != null) {
                                    jSONObject = new JSONObject();
                                    for (Map.Entry entry : r6.LIZ.entrySet()) {
                                        jSONObject.put((String) entry.getKey(), new JSONArray((Collection) entry.getValue()));
                                    }
                                } else {
                                    jSONObject = null;
                                }
                                jSONObject2.put("signals", jSONObject);
                                C1AkB c1AkB2 = this.LJFF;
                                jSONObject2.put("match_rule_info", c1AkB2 != null ? c1AkB2.LIZ() : null);
                                jSONObject2.put("uuid", this.LJI);
                                return jSONObject2;
                            }

                            public final boolean equals(Object obj) {
                                if (this == obj) {
                                    return true;
                                }
                                if (!(obj instanceof C1AkF)) {
                                    return false;
                                }
                                C1AkF c1AkF = (C1AkF) obj;
                                return Intrinsics.LJFF(this.LIZ, c1AkF.LIZ) && Intrinsics.LJFF(this.LIZIZ, c1AkF.LIZIZ) && Intrinsics.LJFF(this.LIZJ, c1AkF.LIZJ) && this.LIZLLL == c1AkF.LIZLLL && Intrinsics.LJFF(this.LJ, c1AkF.LJ) && Intrinsics.LJFF(this.LJFF, c1AkF.LJFF) && Intrinsics.LJFF(this.LJI, c1AkF.LJI);
                            }

                            public final int hashCode() {
                                int iHashCode = ((((((this.LIZ.hashCode() * 31) + this.LIZIZ.hashCode()) * 31) + this.LIZJ.hashCode()) * 31) + 0Vx6.c(this.LIZLLL)) * 31;
                                00jk r5 = this.LJ;
                                int iHashCode2 = (iHashCode + (r5 == null ? 0 : r5.hashCode())) * 31;
                                C1AkB c1AkB2 = this.LJFF;
                                return ((iHashCode2 + (c1AkB2 != null ? c1AkB2.hashCode() : 0)) * 31) + this.LJI.hashCode();
                            }

                            public final String toString() {
                                StringBuilder sbLIZ = 0wS0.LIZ();
                                sbLIZ.append("RequestModel(location=");
                                sbLIZ.append(this.LIZ);
                                sbLIZ.append(", status=");
                                sbLIZ.append(this.LIZIZ);
                                sbLIZ.append(", uploadSource=");
                                sbLIZ.append(this.LIZJ);
                                sbLIZ.append(", timestamp=");
                                sbLIZ.append(this.LIZLLL);
                                sbLIZ.append(", signals=");
                                sbLIZ.append(this.LJ);
                                sbLIZ.append(", matchRuleInfo=");
                                sbLIZ.append(this.LJFF);
                                sbLIZ.append(", uuid=");
                                sbLIZ.append(this.LJI);
                                sbLIZ.append(')');
                                return 0wS0.LIZIZ(sbLIZ);
                            }
                        };
                        LocationClient.LIZ.getClass();
                        mapLJIIIIZZ = 0osm.LJIIIIZZ(new Pair[]{new Pair("sdk_version", "3.3.0-alpha.65-bugfix"), new Pair("enable_cache_ttl", String.valueOf(c1Ak5.LIZ.LJIIZILJ.LIZ))});
                        r1 = c1Ak5.LIZ;
                        if (r1.LIZLLL) {
                            linkedHashMap = new LinkedHashMap();
                            strLIZ = 08SS.LIZ(10, 0Vx6.M(r7.LIZ()));
                            if (strLIZ != null) {
                                linkedHashMap.put("locinfo", strLIZ);
                            }
                            strLIZIZ = c1Ak5.LIZ(c1Ak5.LIZ.LJIIL.LIZ, c1Ak5.LIZIZ, mapLJIIIIZZ, linkedHashMap);
                        } else {
                            strLIZIZ = c1Ak5.LIZIZ(r1.LJIIL.LIZ, c1Ak5.LIZIZ, r7.LIZ(), mapLJIIIIZZ);
                        }
                    }
                    final C1Ak9 c1Ak16 = new C1Ak9(new C1AkJ(d, str10, str, str2, str6, locationData2.coordinateSystem, i, i2, i4, locationData2.encryptedLatitude, locationData2.encryptedLongitude, locationData2.latitude, locationData2.longitude, locationData2.locateType, locationData2.timestamp), r13);
                    final C1AkH c1AkHLIZ8 = C1AkG.LIZ(context, locale);
                    if (r8 != null) {
                        str4 = "mock";
                        if (!Intrinsics.LJFF(locationData2.provider, "mock")) {
                            str4 = "from_client";
                        }
                    } else {
                        str4 = "mock";
                        if (!Intrinsics.LJFF(locationData2.provider, "mock")) {
                            str4 = "from_client";
                        }
                    }
                    final long jCurrentTimeMillis8 = System.currentTimeMillis();
                    final String str18 = str4;
                    r7 = new Object(c1Ak16, c1AkHLIZ8, str18, jCurrentTimeMillis8, r4, c1AkB, str9) {
                        public static final  int LJII = 0;
                        public final C1Ak9 LIZ;
                        public final C1AkH LIZIZ;
                        public final String LIZJ;
                        public final long LIZLLL;
                        public final 00jk LJ;
                        public final C1AkB LJFF;
                        public final String LJI;

                        {
                            this.LIZ = c1Ak16;
                            this.LIZIZ = c1AkHLIZ8;
                            this.LIZJ = str18;
                            this.LIZLLL = jCurrentTimeMillis8;
                            this.LJ = r4;
                            this.LJFF = c1AkB;
                            this.LJI = str9;
                        }

                        public final JSONObject LIZ() throws JSONException {
                            JSONObject jSONObject;
                            List list3;
                            JSONObject jSONObject2 = new JSONObject();
                            C1Ak9 c1Ak17 = this.LIZ;
                            c1Ak17.getClass();
                            JSONObject jSONObject3 = new JSONObject();
                            C1AkJ c1AkJ = c1Ak17.LIZ;
                            c1AkJ.getClass();
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("accuracy", c1AkJ.LIZ);
                            jSONObject4.put("country", c1AkJ.LIZIZ);
                            jSONObject4.put("province", c1AkJ.LIZJ);
                            jSONObject4.put("city", c1AkJ.LIZLLL);
                            jSONObject4.put("district", c1AkJ.LJ);
                            jSONObject4.put("desensitization_type", c1AkJ.LJI);
                            jSONObject4.put("location_accuracy_mode", c1AkJ.LJIIIIZZ);
                            jSONObject4.put("disable_location_shift", c1AkJ.LJII);
                            jSONObject4.put("encrypted_lat", c1AkJ.LJIIIZ);
                            jSONObject4.put("encrypted_lng", c1AkJ.LJIIJ);
                            jSONObject4.put("coordinate_system", c1AkJ.LJFF);
                            jSONObject4.put("locate_type", c1AkJ.LJIILIIL);
                            jSONObject4.put("timestamp", c1AkJ.LJIILJJIL / ((long) 1000));
                            if (c1AkJ.LJIILIIL == 11) {
                                jSONObject4.put("latitude", c1AkJ.LJIIJJI);
                                jSONObject4.put("longitude", c1AkJ.LJIIL);
                            }
                            jSONObject3.put("sys_location", jSONObject4);
                            00pn r5 = c1Ak17.LIZIZ;
                            if (r5 != null && (list3 = r5.LIZ) != null && (!list3.isEmpty())) {
                                jSONObject3.put("cell_info", new JSONArray((Collection) c1Ak17.LIZIZ.LIZ));
                            }
                            jSONObject2.put("location", jSONObject3);
                            jSONObject2.put("status", this.LIZIZ.LIZ());
                            jSONObject2.put("upload_source", this.LIZJ);
                            jSONObject2.put("timestamp", this.LIZLLL);
                            00jk r6 = this.LJ;
                            if (r6 != null) {
                                jSONObject = new JSONObject();
                                for (Map.Entry entry : r6.LIZ.entrySet()) {
                                    jSONObject.put((String) entry.getKey(), new JSONArray((Collection) entry.getValue()));
                                }
                            } else {
                                jSONObject = null;
                            }
                            jSONObject2.put("signals", jSONObject);
                            C1AkB c1AkB2 = this.LJFF;
                            jSONObject2.put("match_rule_info", c1AkB2 != null ? c1AkB2.LIZ() : null);
                            jSONObject2.put("uuid", this.LJI);
                            return jSONObject2;
                        }

                        public final boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (!(obj instanceof C1AkF)) {
                                return false;
                            }
                            C1AkF c1AkF = (C1AkF) obj;
                            return Intrinsics.LJFF(this.LIZ, c1AkF.LIZ) && Intrinsics.LJFF(this.LIZIZ, c1AkF.LIZIZ) && Intrinsics.LJFF(this.LIZJ, c1AkF.LIZJ) && this.LIZLLL == c1AkF.LIZLLL && Intrinsics.LJFF(this.LJ, c1AkF.LJ) && Intrinsics.LJFF(this.LJFF, c1AkF.LJFF) && Intrinsics.LJFF(this.LJI, c1AkF.LJI);
                        }

                        public final int hashCode() {
                            int iHashCode = ((((((this.LIZ.hashCode() * 31) + this.LIZIZ.hashCode()) * 31) + this.LIZJ.hashCode()) * 31) + 0Vx6.c(this.LIZLLL)) * 31;
                            00jk r5 = this.LJ;
                            int iHashCode2 = (iHashCode + (r5 == null ? 0 : r5.hashCode())) * 31;
                            C1AkB c1AkB2 = this.LJFF;
                            return ((iHashCode2 + (c1AkB2 != null ? c1AkB2.hashCode() : 0)) * 31) + this.LJI.hashCode();
                        }

                        public final String toString() {
                            StringBuilder sbLIZ = 0wS0.LIZ();
                            sbLIZ.append("RequestModel(location=");
                            sbLIZ.append(this.LIZ);
                            sbLIZ.append(", status=");
                            sbLIZ.append(this.LIZIZ);
                            sbLIZ.append(", uploadSource=");
                            sbLIZ.append(this.LIZJ);
                            sbLIZ.append(", timestamp=");
                            sbLIZ.append(this.LIZLLL);
                            sbLIZ.append(", signals=");
                            sbLIZ.append(this.LJ);
                            sbLIZ.append(", matchRuleInfo=");
                            sbLIZ.append(this.LJFF);
                            sbLIZ.append(", uuid=");
                            sbLIZ.append(this.LJI);
                            sbLIZ.append(')');
                            return 0wS0.LIZIZ(sbLIZ);
                        }
                    };
                    LocationClient.LIZ.getClass();
                    mapLJIIIIZZ = 0osm.LJIIIIZZ(new Pair[]{new Pair("sdk_version", "3.3.0-alpha.65-bugfix"), new Pair("enable_cache_ttl", String.valueOf(c1Ak5.LIZ.LJIIZILJ.LIZ))});
                    r1 = c1Ak5.LIZ;
                    if (r1.LIZLLL) {
                        linkedHashMap = new LinkedHashMap();
                        strLIZ = 08SS.LIZ(10, 0Vx6.M(r7.LIZ()));
                        if (strLIZ != null) {
                            linkedHashMap.put("locinfo", strLIZ);
                        }
                        strLIZIZ = c1Ak5.LIZ(c1Ak5.LIZ.LJIIL.LIZ, c1Ak5.LIZIZ, mapLJIIIIZZ, linkedHashMap);
                    } else {
                        strLIZIZ = c1Ak5.LIZIZ(r1.LJIIL.LIZ, c1Ak5.LIZIZ, r7.LIZ(), mapLJIIIIZZ);
                    }
                }
                str2 = reversedGeo.cityName;
                if (str2 == null) {
                    str2 = "";
                }
                str3 = locationData2.LIZIZ;
                if (str3 != null) {
                    str6 = str3;
                } else if (reversedGeo != null) {
                    str6 = str5;
                }
                i = locationData2.fuzzType;
                if (i == 2) {
                    i2 = 0;
                } else {
                    i2 = 1;
                    if (i == 0) {
                    }
                    final C1Ak9 c1Ak17 = new C1Ak9(new C1AkJ(d, str10, str, str2, str6, locationData2.coordinateSystem, i, i2, i4, locationData2.encryptedLatitude, locationData2.encryptedLongitude, locationData2.latitude, locationData2.longitude, locationData2.locateType, locationData2.timestamp), r13);
                    final C1AkH c1AkHLIZ9 = C1AkG.LIZ(context, locale);
                    if (r8 != null) {
                        str4 = "mock";
                        if (!Intrinsics.LJFF(locationData2.provider, "mock")) {
                            str4 = "from_client";
                        }
                    } else {
                        str4 = "mock";
                        if (!Intrinsics.LJFF(locationData2.provider, "mock")) {
                            str4 = "from_client";
                        }
                    }
                    final long jCurrentTimeMillis9 = System.currentTimeMillis();
                    final String str19 = str4;
                    r7 = new Object(c1Ak17, c1AkHLIZ9, str19, jCurrentTimeMillis9, r4, c1AkB, str9) {
                        public static final  int LJII = 0;
                        public final C1Ak9 LIZ;
                        public final C1AkH LIZIZ;
                        public final String LIZJ;
                        public final long LIZLLL;
                        public final 00jk LJ;
                        public final C1AkB LJFF;
                        public final String LJI;

                        {
                            this.LIZ = c1Ak17;
                            this.LIZIZ = c1AkHLIZ9;
                            this.LIZJ = str19;
                            this.LIZLLL = jCurrentTimeMillis9;
                            this.LJ = r4;
                            this.LJFF = c1AkB;
                            this.LJI = str9;
                        }

                        public final JSONObject LIZ() throws JSONException {
                            JSONObject jSONObject;
                            List list3;
                            JSONObject jSONObject2 = new JSONObject();
                            C1Ak9 c1Ak18 = this.LIZ;
                            c1Ak18.getClass();
                            JSONObject jSONObject3 = new JSONObject();
                            C1AkJ c1AkJ = c1Ak18.LIZ;
                            c1AkJ.getClass();
                            JSONObject jSONObject4 = new JSONObject();
                            jSONObject4.put("accuracy", c1AkJ.LIZ);
                            jSONObject4.put("country", c1AkJ.LIZIZ);
                            jSONObject4.put("province", c1AkJ.LIZJ);
                            jSONObject4.put("city", c1AkJ.LIZLLL);
                            jSONObject4.put("district", c1AkJ.LJ);
                            jSONObject4.put("desensitization_type", c1AkJ.LJI);
                            jSONObject4.put("location_accuracy_mode", c1AkJ.LJIIIIZZ);
                            jSONObject4.put("disable_location_shift", c1AkJ.LJII);
                            jSONObject4.put("encrypted_lat", c1AkJ.LJIIIZ);
                            jSONObject4.put("encrypted_lng", c1AkJ.LJIIJ);
                            jSONObject4.put("coordinate_system", c1AkJ.LJFF);
                            jSONObject4.put("locate_type", c1AkJ.LJIILIIL);
                            jSONObject4.put("timestamp", c1AkJ.LJIILJJIL / ((long) 1000));
                            if (c1AkJ.LJIILIIL == 11) {
                                jSONObject4.put("latitude", c1AkJ.LJIIJJI);
                                jSONObject4.put("longitude", c1AkJ.LJIIL);
                            }
                            jSONObject3.put("sys_location", jSONObject4);
                            00pn r5 = c1Ak18.LIZIZ;
                            if (r5 != null && (list3 = r5.LIZ) != null && (!list3.isEmpty())) {
                                jSONObject3.put("cell_info", new JSONArray((Collection) c1Ak18.LIZIZ.LIZ));
                            }
                            jSONObject2.put("location", jSONObject3);
                            jSONObject2.put("status", this.LIZIZ.LIZ());
                            jSONObject2.put("upload_source", this.LIZJ);
                            jSONObject2.put("timestamp", this.LIZLLL);
                            00jk r6 = this.LJ;
                            if (r6 != null) {
                                jSONObject = new JSONObject();
                                for (Map.Entry entry : r6.LIZ.entrySet()) {
                                    jSONObject.put((String) entry.getKey(), new JSONArray((Collection) entry.getValue()));
                                }
                            } else {
                                jSONObject = null;
                            }
                            jSONObject2.put("signals", jSONObject);
                            C1AkB c1AkB2 = this.LJFF;
                            jSONObject2.put("match_rule_info", c1AkB2 != null ? c1AkB2.LIZ() : null);
                            jSONObject2.put("uuid", this.LJI);
                            return jSONObject2;
                        }

                        public final boolean equals(Object obj) {
                            if (this == obj) {
                                return true;
                            }
                            if (!(obj instanceof C1AkF)) {
                                return false;
                            }
                            C1AkF c1AkF = (C1AkF) obj;
                            return Intrinsics.LJFF(this.LIZ, c1AkF.LIZ) && Intrinsics.LJFF(this.LIZIZ, c1AkF.LIZIZ) && Intrinsics.LJFF(this.LIZJ, c1AkF.LIZJ) && this.LIZLLL == c1AkF.LIZLLL && Intrinsics.LJFF(this.LJ, c1AkF.LJ) && Intrinsics.LJFF(this.LJFF, c1AkF.LJFF) && Intrinsics.LJFF(this.LJI, c1AkF.LJI);
                        }

                        public final int hashCode() {
                            int iHashCode = ((((((this.LIZ.hashCode() * 31) + this.LIZIZ.hashCode()) * 31) + this.LIZJ.hashCode()) * 31) + 0Vx6.c(this.LIZLLL)) * 31;
                            00jk r5 = this.LJ;
                            int iHashCode2 = (iHashCode + (r5 == null ? 0 : r5.hashCode())) * 31;
                            C1AkB c1AkB2 = this.LJFF;
                            return ((iHashCode2 + (c1AkB2 != null ? c1AkB2.hashCode() : 0)) * 31) + this.LJI.hashCode();
                        }

                        public final String toString() {
                            StringBuilder sbLIZ = 0wS0.LIZ();
                            sbLIZ.append("RequestModel(location=");
                            sbLIZ.append(this.LIZ);
                            sbLIZ.append(", status=");
                            sbLIZ.append(this.LIZIZ);
                            sbLIZ.append(", uploadSource=");
                            sbLIZ.append(this.LIZJ);
                            sbLIZ.append(", timestamp=");
                            sbLIZ.append(this.LIZLLL);
                            sbLIZ.append(", signals=");
                            sbLIZ.append(this.LJ);
                            sbLIZ.append(", matchRuleInfo=");
                            sbLIZ.append(this.LJFF);
                            sbLIZ.append(", uuid=");
                            sbLIZ.append(this.LJI);
                            sbLIZ.append(')');
                            return 0wS0.LIZIZ(sbLIZ);
                        }
                    };
                    LocationClient.LIZ.getClass();
                    mapLJIIIIZZ = 0osm.LJIIIIZZ(new Pair[]{new Pair("sdk_version", "3.3.0-alpha.65-bugfix"), new Pair("enable_cache_ttl", String.valueOf(c1Ak5.LIZ.LJIIZILJ.LIZ))});
                    r1 = c1Ak5.LIZ;
                    if (r1.LIZLLL) {
                        linkedHashMap = new LinkedHashMap();
                        strLIZ = 08SS.LIZ(10, 0Vx6.M(r7.LIZ()));
                        if (strLIZ != null) {
                            linkedHashMap.put("locinfo", strLIZ);
                        }
                        strLIZIZ = c1Ak5.LIZ(c1Ak5.LIZ.LJIIL.LIZ, c1Ak5.LIZIZ, mapLJIIIIZZ, linkedHashMap);
                    } else {
                        strLIZIZ = c1Ak5.LIZIZ(r1.LJIIL.LIZ, c1Ak5.LIZIZ, r7.LIZ(), mapLJIIIIZZ);
                    }
                }
                final C1Ak9 c1Ak18 = new C1Ak9(new C1AkJ(d, str10, str, str2, str6, locationData2.coordinateSystem, i, i2, i4, locationData2.encryptedLatitude, locationData2.encryptedLongitude, locationData2.latitude, locationData2.longitude, locationData2.locateType, locationData2.timestamp), r13);
                final C1AkH c1AkHLIZ10 = C1AkG.LIZ(context, locale);
                if (r8 != null) {
                    str4 = "mock";
                    if (!Intrinsics.LJFF(locationData2.provider, "mock")) {
                        str4 = "from_client";
                    }
                } else {
                    str4 = "mock";
                    if (!Intrinsics.LJFF(locationData2.provider, "mock")) {
                        str4 = "from_client";
                    }
                }
                final long jCurrentTimeMillis10 = System.currentTimeMillis();
                final String str110 = str4;
                r7 = new Object(c1Ak18, c1AkHLIZ10, str110, jCurrentTimeMillis10, r4, c1AkB, str9) {
                    public static final  int LJII = 0;
                    public final C1Ak9 LIZ;
                    public final C1AkH LIZIZ;
                    public final String LIZJ;
                    public final long LIZLLL;
                    public final 00jk LJ;
                    public final C1AkB LJFF;
                    public final String LJI;

                    {
                        this.LIZ = c1Ak18;
                        this.LIZIZ = c1AkHLIZ10;
                        this.LIZJ = str110;
                        this.LIZLLL = jCurrentTimeMillis10;
                        this.LJ = r4;
                        this.LJFF = c1AkB;
                        this.LJI = str9;
                    }

                    public final JSONObject LIZ() throws JSONException {
                        JSONObject jSONObject;
                        List list3;
                        JSONObject jSONObject2 = new JSONObject();
                        C1Ak9 c1Ak19 = this.LIZ;
                        c1Ak19.getClass();
                        JSONObject jSONObject3 = new JSONObject();
                        C1AkJ c1AkJ = c1Ak19.LIZ;
                        c1AkJ.getClass();
                        JSONObject jSONObject4 = new JSONObject();
                        jSONObject4.put("accuracy", c1AkJ.LIZ);
                        jSONObject4.put("country", c1AkJ.LIZIZ);
                        jSONObject4.put("province", c1AkJ.LIZJ);
                        jSONObject4.put("city", c1AkJ.LIZLLL);
                        jSONObject4.put("district", c1AkJ.LJ);
                        jSONObject4.put("desensitization_type", c1AkJ.LJI);
                        jSONObject4.put("location_accuracy_mode", c1AkJ.LJIIIIZZ);
                        jSONObject4.put("disable_location_shift", c1AkJ.LJII);
                        jSONObject4.put("encrypted_lat", c1AkJ.LJIIIZ);
                        jSONObject4.put("encrypted_lng", c1AkJ.LJIIJ);
                        jSONObject4.put("coordinate_system", c1AkJ.LJFF);
                        jSONObject4.put("locate_type", c1AkJ.LJIILIIL);
                        jSONObject4.put("timestamp", c1AkJ.LJIILJJIL / ((long) 1000));
                        if (c1AkJ.LJIILIIL == 11) {
                            jSONObject4.put("latitude", c1AkJ.LJIIJJI);
                            jSONObject4.put("longitude", c1AkJ.LJIIL);
                        }
                        jSONObject3.put("sys_location", jSONObject4);
                        00pn r5 = c1Ak19.LIZIZ;
                        if (r5 != null && (list3 = r5.LIZ) != null && (!list3.isEmpty())) {
                            jSONObject3.put("cell_info", new JSONArray((Collection) c1Ak19.LIZIZ.LIZ));
                        }
                        jSONObject2.put("location", jSONObject3);
                        jSONObject2.put("status", this.LIZIZ.LIZ());
                        jSONObject2.put("upload_source", this.LIZJ);
                        jSONObject2.put("timestamp", this.LIZLLL);
                        00jk r6 = this.LJ;
                        if (r6 != null) {
                            jSONObject = new JSONObject();
                            for (Map.Entry entry : r6.LIZ.entrySet()) {
                                jSONObject.put((String) entry.getKey(), new JSONArray((Collection) entry.getValue()));
                            }
                        } else {
                            jSONObject = null;
                        }
                        jSONObject2.put("signals", jSONObject);
                        C1AkB c1AkB2 = this.LJFF;
                        jSONObject2.put("match_rule_info", c1AkB2 != null ? c1AkB2.LIZ() : null);
                        jSONObject2.put("uuid", this.LJI);
                        return jSONObject2;
                    }

                    public final boolean equals(Object obj) {
                        if (this == obj) {
                            return true;
                        }
                        if (!(obj instanceof C1AkF)) {
                            return false;
                        }
                        C1AkF c1AkF = (C1AkF) obj;
                        return Intrinsics.LJFF(this.LIZ, c1AkF.LIZ) && Intrinsics.LJFF(this.LIZIZ, c1AkF.LIZIZ) && Intrinsics.LJFF(this.LIZJ, c1AkF.LIZJ) && this.LIZLLL == c1AkF.LIZLLL && Intrinsics.LJFF(this.LJ, c1AkF.LJ) && Intrinsics.LJFF(this.LJFF, c1AkF.LJFF) && Intrinsics.LJFF(this.LJI, c1AkF.LJI);
                    }

                    public final int hashCode() {
                        int iHashCode = ((((((this.LIZ.hashCode() * 31) + this.LIZIZ.hashCode()) * 31) + this.LIZJ.hashCode()) * 31) + 0Vx6.c(this.LIZLLL)) * 31;
                        00jk r5 = this.LJ;
                        int iHashCode2 = (iHashCode + (r5 == null ? 0 : r5.hashCode())) * 31;
                        C1AkB c1AkB2 = this.LJFF;
                        return ((iHashCode2 + (c1AkB2 != null ? c1AkB2.hashCode() : 0)) * 31) + this.LJI.hashCode();
                    }

                    public final String toString() {
                        StringBuilder sbLIZ = 0wS0.LIZ();
                        sbLIZ.append("RequestModel(location=");
                        sbLIZ.append(this.LIZ);
                        sbLIZ.append(", status=");
                        sbLIZ.append(this.LIZIZ);
                        sbLIZ.append(", uploadSource=");
                        sbLIZ.append(this.LIZJ);
                        sbLIZ.append(", timestamp=");
                        sbLIZ.append(this.LIZLLL);
                        sbLIZ.append(", signals=");
                        sbLIZ.append(this.LJ);
                        sbLIZ.append(", matchRuleInfo=");
                        sbLIZ.append(this.LJFF);
                        sbLIZ.append(", uuid=");
                        sbLIZ.append(this.LJI);
                        sbLIZ.append(')');
                        return 0wS0.LIZIZ(sbLIZ);
                    }
                };
                LocationClient.LIZ.getClass();
                mapLJIIIIZZ = 0osm.LJIIIIZZ(new Pair[]{new Pair("sdk_version", "3.3.0-alpha.65-bugfix"), new Pair("enable_cache_ttl", String.valueOf(c1Ak5.LIZ.LJIIZILJ.LIZ))});
                r1 = c1Ak5.LIZ;
                if (r1.LIZLLL) {
                    linkedHashMap = new LinkedHashMap();
                    strLIZ = 08SS.LIZ(10, 0Vx6.M(r7.LIZ()));
                    if (strLIZ != null) {
                        linkedHashMap.put("locinfo", strLIZ);
                    }
                    strLIZIZ = c1Ak5.LIZ(c1Ak5.LIZ.LJIIL.LIZ, c1Ak5.LIZIZ, mapLJIIIIZZ, linkedHashMap);
                } else {
                    strLIZIZ = c1Ak5.LIZIZ(r1.LJIIL.LIZ, c1Ak5.LIZIZ, r7.LIZ(), mapLJIIIIZZ);
                }
            } else {
                strLIZIZ = null;
            }
            StringBuilder sbLIZ = 0wS0.LIZ();
            sbLIZ.append("doUpload: response=");
            sbLIZ.append(strLIZIZ);
            0bn7.LIZIZ("LocationClient", 0wS0.LIZIZ(sbLIZ));
            0bn7.LIZLLL("LocationClient", "doUploadAndParseResult");
            long j2 = jUptimeMillis - j;
            long jUptimeMillis2 = SystemClock.uptimeMillis() - j;
            if (strLIZIZ != null) {
                0bn7.LIZLLL("LocationClient", "parseBody: ");
                String strLIZIZ2 = 08SS.LIZIZ(2, strLIZIZ);
                if (strLIZIZ2 != null) {
                    StringBuilder sbLIZ2 = 0wS0.LIZ();
                    sbLIZ2.append("parseBody: unpack to ");
                    sbLIZ2.append(strLIZIZ2);
                    0bn7.LIZIZ("LocationClient", 0wS0.LIZIZ(sbLIZ2));
                    0bn7.LIZIZ("DataModel", "fromJsonString2: ");
                    try {
                        JSONObject jSONObject = new JSONObject(strLIZIZ2);
                        String strOptString = jSONObject.optString("EncryptedGeohash");
                        String strOptString2 = jSONObject.optString("EncryptedH3");
                        String strOptString3 = jSONObject.optString("EncryptedS2");
                        long jOptLong = jSONObject.optLong("location_cache_ttl");
                        String strOptString4 = jSONObject.optString("wifi_conf");
                        Address addressLIZ = 0iv9.LIZ(jSONObject.optString("Location"));
                        if (addressLIZ != null && (list = addressLIZ.subdivisions) != null && (!list.isEmpty())) {
                            addressLIZ.adminArea = (AreaModel) ListProtector.get(list, 0);
                        }
                        dataModel2 = new DataModel(addressLIZ, strOptString, strOptString2, strOptString3, jOptLong, strOptString4);
                        01Sf.constructor-impl(dataModel2);
                    } catch (Throwable th) {
                        dataModel2 = new 00ce(th);
                        01Sf.constructor-impl(dataModel2);
                    }
                    Throwable th2 = 01Sf.exceptionOrNull-impl(dataModel2);
                    if (th2 != null) {
                        0bn7 r5 = 0bn7.LIZ;
                        0bn7.LIZJ("DataModel", "fromJsonString2: ", th2);
                        dataModel2 = null;
                    }
                    dataModel = dataModel2;
                    0bn7 r6 = 0bn7.LIZ;
                    StringBuilder sbLIZ3 = 0wS0.LIZ();
                    sbLIZ3.append("parseBody: ");
                    sbLIZ3.append(dataModel);
                    0bn7.LIZIZ("LocationClient", 0wS0.LIZIZ(sbLIZ3));
                } else {
                    dataModel = null;
                }
                c1Ajl2.LIZJ = dataModel;
                if (dataModel != null) {
                    this.LIZLLL.LJ(0, j2, jUptimeMillis2, r0, str8, "success", null);
                } else {
                    this.LIZLLL.LJ(-3, j2, jUptimeMillis2, r0, str8, "fail", "Response parse failed");
                }
            } else {
                this.LIZLLL.LJ(-1, j2, jUptimeMillis2, r0, str8, "fail", "Network request failed");
            }
            c1AjZLIZ = C1AjY.LIZ(c1Ajl2);
        }
        return this.LIZLLL.LJ.LIZIZ("after_upload", c1AjZLIZ.LIZ);
    }
}
