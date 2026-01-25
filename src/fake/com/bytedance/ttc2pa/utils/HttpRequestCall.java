package fake.com.bytedance.ttc2pa.utils;

import X.04GS;
import X.04IR;
import X.0OsF;
import X.0Q4C;
import X.0U1i;
import X.0ncw;
import X.0vmc;
import X.0vxB;
import X.0w02;
import X.119i;
import android.util.Pair;
import com.bytedance.retrofit2.mime.TypedByteArray;
import com.bytedance.retrofit2.mime.TypedInput;
import com.bytedance.tt.reliability.monitor.catchchecker.TryCatchGuardChecker;
import fake.com.bytedance.ttc2pa.TTC2PA;
import fake.com.bytedance.ttc2pa.TtC2paNetworkCaller;
import fake.com.bytedance.ttc2pa.TtC2paNetworkResponse;
import fake.d.c;
import fake.e.b;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public final class HttpRequestCall implements TtC2paNetworkCaller {
    public static final HttpRequestCall INSTANCE = new HttpRequestCall();

    private final TtC2paNetworkResponse failResponse(String str) {
        return new TtC2paNetworkResponse(-1L, str, "", new byte[0]);
    }

    @Override
    public TtC2paNetworkResponse doPost(String str, Map map, byte[] bArr, long j, boolean z) {
        String str2;
        c.b(str, "url");
        c.b(map, "headers");
        c.b(bArr, "body");
        if (0Q4C.LJ(str)) {
            str2 = "URL empty";
        } else {
            try {
                0U1i r9 = new 0U1i();
                if (j > 0) {
                    ((0vxB) r9).LIZJ = j;
                    ((0vxB) r9).LJIIIIZZ = j;
                    ((0vxB) r9).LIZLLL = j;
                    ((0vxB) r9).LJ = j;
                }
                ArrayList arrayList = new ArrayList();
                for (Map.Entry entry : map.entrySet()) {
                    String str3 = (String) entry.getKey();
                    String str4 = (String) entry.getValue();
                    if (!0Q4C.LJ(str3) && !0Q4C.LJ(str4)) {
                        arrayList.add(new 04GS(str3, str4));
                    }
                }
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                Pair pairLIZJ = 0OsF.LIZJ(str, linkedHashMap);
                IC2paNetworkApi iC2paNetworkApi = (IC2paNetworkApi) 0w02.LJIILIIL((String) pairLIZJ.first).LIZ(IC2paNetworkApi.class);
                Object obj = pairLIZJ.second;
                c.a(obj, "urlPair.second");
                0vmc r1 = iC2paNetworkApi.postBody(z, (String) obj, new TypedByteArray("", bArr, new String[0]), arrayList, linkedHashMap, r9).execute();
                c.a((Object) r1, "call.execute()");
                return c2paResponseFromSsResponse(r1);
            } catch (Throwable th) {
                TryCatchGuardChecker.doCheck(th);
                str2 = "network request error, e:" + th;
            }
        }
        return failResponse(str2);
    }

    @Override
    public TtC2paNetworkResponse onRemoteSign(byte[] bArr) {
        c.b(bArr, "requestBody");
        return TTC2PA.INSTANCE.getMTtC2paDepend$ttc2pa_release().onRemoteSign(bArr);
    }

    private final TtC2paNetworkResponse c2paResponseFromSsResponse(0vmc r10) {
        String str;
        byte[] bArr = new byte[0];
        if (r10.LIZJ()) {
            if (0ncw.LIZIZ(r10.LIZ.LIZLLL)) {
                str = "";
            } else {
                str = "";
                for (04GS r1 : r10.LIZ.LIZLLL) {
                    if (b.a(r1.LIZ) && !0Q4C.LJ(r1.LIZIZ)) {
                        str = r1.LIZIZ;
                        c.a((Object) str, "header.value");
                    }
                }
            }
            try {
                119i r5 = new 119i((int) ((TypedInput) r10.LIZIZ).length());
                byte[] bArr2 = new byte[4096];
                InputStream inputStreamIn = ((TypedInput) r10.LIZIZ).in();
                while (true) {
                    int i = inputStreamIn.read(bArr2, 0, 4096);
                    if (i <= 0) {
                        break;
                    }
                    r5.LIZ(bArr2, i);
                }
                int i2 = r5.LIZIZ;
                bArr = new byte[i2];
                if (i2 > 0) {
                    System.arraycopy(r5.LIZ, 0, bArr, 0, i2);
                }
                c.a((Object) bArr, "buffer.toByteArray()");
            } catch (Throwable th) {
                TryCatchGuardChecker.doCheck(th);
                return new TtC2paNetworkResponse(r10.LIZ.LIZIZ, th.toString(), str, new byte[0]);
            }
        } else {
            str = "";
        }
        04IR r2 = r10.LIZ;
        long j = r2.LIZIZ;
        String str2 = 0Q4C.LJ(r2.LJI) ? "" : r10.LIZ.LJI;
        c.a((Object) str2, "if (StringUtils.isEmpty(…\" else response.message()");
        return new TtC2paNetworkResponse(j, str2, str, bArr);
    }
}
