package fake.com.bytedance.ttc2pa;

import X.0Vqr;
import X.0upF;
import X.11IG;
import android.os.SystemClock;
import fake.a.d;
import fake.com.bytedance.ttc2pa.TTC2PA;
import fake.com.bytedance.ttc2pa.localfiles.SignCertManager;
import fake.com.bytedance.ttc2pa.localfiles.SignCertManager$CertState;
import fake.com.bytedance.ttc2pa.utils.C2paThreadFactory;
import fake.com.bytedance.ttc2pa.utils.HttpRequestCall;
import fake.com.bytedance.ttc2pa.utils.Logger;
import fake.d.c;
import fake.e.a;
import java.util.concurrent.ScheduledExecutorService;
import org.json.JSONException;
import org.json.JSONObject;

public final class TTC2PA {
    public static final TTC2PA INSTANCE = new TTC2PA();
    public static final String TAG = "TTC2PA";
    public static ScheduledExecutorService mExecutor;
    public static volatile ITTC2PADepend mTtC2paDepend;

    public static final void asyncReadAndVerifyFromPath$lambda$3(String str, JSONObject jSONObject, long j, TTC2PACallback tTC2PACallback) throws JSONException {
        c.b(str, "$filePath");
        c.b(jSONObject, "$event");
        c.b(tTC2PACallback, "$callback");
        TtC2paResult ttC2paResultTtc2paReadAndVerifyFromPath = Tt_c2pa_sdkKt.ttc2paReadAndVerifyFromPath(str);
        jSONObject.put("cost", SystemClock.uptimeMillis() - j);
        jSONObject.put("error_code", ttC2paResultTtc2paReadAndVerifyFromPath.getErrorCode());
        jSONObject.put("error_desc", ttC2paResultTtc2paReadAndVerifyFromPath.getErrorDesc());
        INSTANCE.reportEventLog("c2pa_read_manifest", jSONObject);
        tTC2PACallback.onResult((int) ttC2paResultTtc2paReadAndVerifyFromPath.getErrorCode(), ttC2paResultTtc2paReadAndVerifyFromPath.getErrorDesc(), ttC2paResultTtc2paReadAndVerifyFromPath.getResultJson());
        Logger.INSTANCE.d(TAG, "read callback: code:" + ttC2paResultTtc2paReadAndVerifyFromPath.getErrorCode() + ", desc:" + ttC2paResultTtc2paReadAndVerifyFromPath.getErrorDesc() + ", manifest:" + ttC2paResultTtc2paReadAndVerifyFromPath.getResultJson());
    }

    public static final void asyncReadAsIngredientFromPath$lambda$2(String str, JSONObject jSONObject, long j, TTC2PACallback tTC2PACallback) throws JSONException {
        c.b(str, "$filePath");
        c.b(jSONObject, "$event");
        c.b(tTC2PACallback, "$callback");
        TtC2paResult ttC2paResultTtc2paReadIngredientFromPath = Tt_c2pa_sdkKt.ttc2paReadIngredientFromPath(str);
        jSONObject.put("cost", SystemClock.uptimeMillis() - j);
        jSONObject.put("error_code", ttC2paResultTtc2paReadIngredientFromPath.getErrorCode());
        jSONObject.put("error_desc", ttC2paResultTtc2paReadIngredientFromPath.getErrorDesc());
        INSTANCE.reportEventLog("c2pa_read_ingredient", jSONObject);
        tTC2PACallback.onResult((int) ttC2paResultTtc2paReadIngredientFromPath.getErrorCode(), ttC2paResultTtc2paReadIngredientFromPath.getErrorDesc(), ttC2paResultTtc2paReadIngredientFromPath.getResultJson());
        Logger.INSTANCE.d(TAG, "read callback: code:" + ttC2paResultTtc2paReadIngredientFromPath.getErrorCode() + ", desc:" + ttC2paResultTtc2paReadIngredientFromPath.getErrorDesc() + ", manifest:" + ttC2paResultTtc2paReadIngredientFromPath.getResultJson());
    }

    public static final void asyncWriteAndSignManifest$lambda$1(TTC2PACallback tTC2PACallback, JSONObject jSONObject, String str, long j, boolean z) throws JSONException {
        TtC2paResult ttC2paResultTtc2paWriteAndSignManifest;
        c.b(tTC2PACallback, "$callback");
        c.b(jSONObject, "$event");
        c.b(str, "$manifestJson");
        long jUptimeMillis = SystemClock.uptimeMillis();
        TTC2PA ttc2pa = INSTANCE;
        d dVarCheckTempDir = ttc2pa.checkTempDir();
        String str2 = "";
        if (((Boolean) dVarCheckTempDir.a()).booleanValue()) {
            SignCertManager signCertManager = SignCertManager.INSTANCE;
            SignCertManager$CertState signCertManager$CertStateCurrentCertState = signCertManager.currentCertState();
            if (signCertManager$CertStateCurrentCertState.getCertInfo() == null) {
                signCertManager.retryRefreshCertIfNeed();
                ttC2paResultTtc2paWriteAndSignManifest = new TtC2paResult(-2L, "Cert not ready, retry later, code:" + signCertManager$CertStateCurrentCertState.getErrorCode() + ", " + signCertManager$CertStateCurrentCertState.getErrorDesc(), "");
            } else {
                if (ttc2pa.getMTtC2paDepend$ttc2pa_release().getTimeStampRequestHost().length() > 0) {
                    str2 = "https://" + ttc2pa.getMTtC2paDepend$ttc2pa_release().getTimeStampRequestHost();
                    c.a((Object) str2, "StringBuilder(\"https://\"…              .toString()");
                }
                byte[] bytes = signCertManager$CertStateCurrentCertState.getCertInfo().getCertContent().getBytes(a.a);
                c.a((Object) bytes, "this as java.lang.String).getBytes(charset)");
                ttC2paResultTtc2paWriteAndSignManifest = Tt_c2pa_sdkKt.ttc2paWriteAndSignManifest(str, bytes, signCertManager$CertStateCurrentCertState.getCertInfo().getCertFingerPrint(), str2, j, z, HttpRequestCall.INSTANCE);
                long errorCode = ttC2paResultTtc2paWriteAndSignManifest.getErrorCode();
                if (errorCode == 83) {
                    signCertManager.markLocalCertMisMatch(ttC2paResultTtc2paWriteAndSignManifest.getErrorDesc());
                } else if (errorCode == 28 || errorCode == 31 || errorCode == 32 || errorCode == 33) {
                    signCertManager.retryRefreshCertIfNeed();
                }
            }
        } else {
            ttC2paResultTtc2paWriteAndSignManifest = new TtC2paResult(-15L, "Temp path check failed:" + ((String) dVarCheckTempDir.b()), "");
        }
        ttc2pa.onWriteComplete(tTC2PACallback, jSONObject, jUptimeMillis, ttC2paResultTtc2paWriteAndSignManifest);
    }

    private final d checkTempDir() {
        boolean zMkdir;
        11IG r3 = new 11IG(0Vqr.LLLZLL(getMTtC2paDepend$ttc2pa_release().getContext()), "/ttc2pa_cache/");
        if (r3.exists()) {
            zMkdir = r3.isDirectory() || (r3.delete() && r3.mkdir());
        } else {
            zMkdir = r3.mkdir();
        }
        return new d(Boolean.valueOf(zMkdir), r3.getPath());
    }

    public static final void init$lambda$0() {
        Tt_c2pa_sdkKt.ttc2paSetTempDir((String) INSTANCE.checkTempDir().b());
        SignCertManager.INSTANCE.init();
    }

    private final void onWriteComplete(TTC2PACallback tTC2PACallback, JSONObject jSONObject, long j, TtC2paResult ttC2paResult) throws JSONException {
        jSONObject.put("cost", SystemClock.uptimeMillis() - j);
        jSONObject.put("error_code", ttC2paResult.getErrorCode());
        jSONObject.put("error_desc", ttC2paResult.getErrorDesc());
        reportEventLog("c2pa_write", jSONObject);
        tTC2PACallback.onResult((int) ttC2paResult.getErrorCode(), ttC2paResult.getErrorDesc(), ttC2paResult.getResultJson());
        Logger.INSTANCE.d(TAG, "write callback: code:" + ttC2paResult.getErrorCode() + ", desc:" + ttC2paResult.getErrorDesc() + ", manifest:" + ttC2paResult.getResultJson());
    }

    private final void reportEventLog(String str, JSONObject jSONObject) {
        ITTC2PADepend mTtC2paDepend$ttc2pa_release = getMTtC2paDepend$ttc2pa_release();
        String strT = 0Vqr.T(jSONObject);
        c.a((Object) strT, "content.toString()");
        mTtC2paDepend$ttc2pa_release.monitorLogSend(str, strT);
        Logger.INSTANCE.d(TAG, "report type:" + str + ", content:" + jSONObject);
    }

    public final void asyncReadAndVerifyFromPath(final String str, final TTC2PACallback tTC2PACallback) {
        c.b(str, "filePath");
        c.b(tTC2PACallback, "callback");
        if (mTtC2paDepend == null) {
            tTC2PACallback.onResult(-1, "Must call init before use", "");
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        final long jUptimeMillis = SystemClock.uptimeMillis();
        getMExecutor$ttc2pa_release().submit(new Runnable() {
            @Override
            public final void run() throws JSONException {
                TTC2PA.asyncReadAndVerifyFromPath$lambda$3(str, jSONObject, jUptimeMillis, tTC2PACallback);
            }
        });
    }

    public final void asyncReadAsIngredientFromPath(final String str, final TTC2PACallback tTC2PACallback) {
        c.b(str, "filePath");
        c.b(tTC2PACallback, "callback");
        if (mTtC2paDepend == null) {
            tTC2PACallback.onResult(-1, "Must call init before use", "");
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        final long jUptimeMillis = SystemClock.uptimeMillis();
        getMExecutor$ttc2pa_release().submit(new Runnable() {
            @Override
            public final void run() throws JSONException {
                TTC2PA.asyncReadAsIngredientFromPath$lambda$2(str, jSONObject, jUptimeMillis, tTC2PACallback);
            }
        });
    }

    public final void asyncWriteAndSignManifest(final String str, final long j, final boolean z, final TTC2PACallback tTC2PACallback) throws JSONException {
        c.b(str, "manifestJson");
        c.b(tTC2PACallback, "callback");
        if (mTtC2paDepend == null) {
            tTC2PACallback.onResult(-1, "Must call init before use", "");
            return;
        }
        final JSONObject jSONObject = new JSONObject();
        jSONObject.put("tsa_timeout", j);
        getMExecutor$ttc2pa_release().submit(new Runnable() {
            @Override
            public final void run() throws JSONException {
                TTC2PA.asyncWriteAndSignManifest$lambda$1(tTC2PACallback, jSONObject, str, j, z);
            }
        });
    }

    public final ScheduledExecutorService getMExecutor$ttc2pa_release() {
        ScheduledExecutorService scheduledExecutorService = mExecutor;
        if (scheduledExecutorService != null) {
            return scheduledExecutorService;
        }
        c.a("mExecutor");
        throw null;
    }

    public final ITTC2PADepend getMTtC2paDepend$ttc2pa_release() {
        ITTC2PADepend iTTC2PADepend = mTtC2paDepend;
        if (iTTC2PADepend != null) {
            return iTTC2PADepend;
        }
        c.a("mTtC2paDepend");
        throw null;
    }

    public final void init(ITTC2PADepend iTTC2PADepend) {
        ScheduledExecutorService ioExecutor;
        c.b(iTTC2PADepend, "depend");
        if (mTtC2paDepend != null) {
            return;
        }
        setMTtC2paDepend$ttc2pa_release(iTTC2PADepend);
        if (getMTtC2paDepend$ttc2pa_release().enableDebug()) {
            Logger.INSTANCE.setLogLevel(3);
        }
        if (getMTtC2paDepend$ttc2pa_release().getIoExecutor() != null) {
            ioExecutor = getMTtC2paDepend$ttc2pa_release().getIoExecutor();
            c.a(ioExecutor);
        } else {
            ioExecutor = new 0upF(1, new C2paThreadFactory());
        }
        setMExecutor$ttc2pa_release(ioExecutor);
        getMExecutor$ttc2pa_release().submit(new Runnable() {
            @Override
            public final void run() {
                TTC2PA.init$lambda$0();
            }
        });
    }

    public final void setMExecutor$ttc2pa_release(ScheduledExecutorService scheduledExecutorService) {
        c.b(scheduledExecutorService, "<set-?>");
        mExecutor = scheduledExecutorService;
    }

    public final void setMTtC2paDepend$ttc2pa_release(ITTC2PADepend iTTC2PADepend) {
        c.b(iTTC2PADepend, "<set-?>");
        mTtC2paDepend = iTTC2PADepend;
    }
}
