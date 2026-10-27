package Z;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import android.widget.Toast;
import com.windukk.mod.Main;
import com.windukk.stable.DynamicStatus;
import com.windukk.stable.DynamicUpdates;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.MapsKt;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.JsonArray;
import ni.shikatu.kotlinx.serialization.json.JsonElement;
import ni.shikatu.kotlinx.serialization.json.JsonElementKt;
import ni.shikatu.kotlinx.serialization.json.JsonObject;
import ni.shikatu.kotlinx.serialization.json.JsonPrimitive;

public final class dd {
    public static final dd a;
    public static final ScheduledExecutorService b;
    public static final Handler c;
    public static ScheduledFuture d;

    static {
        a = new dd();
        b = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
            @Override
            public final Thread newThread(Runnable runnable) {
                return dd.a(runnable);
            }
        });
        c = new Handler(Looper.getMainLooper());
    }

    public static final Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "TTModOta");
        thread.setDaemon(true);
        return thread;
    }

    public static final void b() {
        a.getClass();
        a(false, (bd) null);
    }

    public static void c(final Context context, final ad adVar) {
        try {
            t.a(new Callable() {
                @Override
                public final Object call() throws Exception {
                    return dd.d(context, adVar);
                }
            });
        } catch (Throwable th) {
            g7.a(6, g7.a("OTA install failed dynamic=%d", new Object[]{Long.valueOf(adVar.b)}), th);
            c.post(new Runnable() {
                @Override
                public final void run() {
                    dd.b(context);
                }
            });
        }
    }

    public static final Unit d(Context context, ad adVar) throws IOException {
        a.getClass();
        a(context, adVar, true);
        return Unit.INSTANCE;
    }

    public static final synchronized void a() {
        ScheduledFuture scheduledFuture = d;
        if (scheduledFuture == null || scheduledFuture.isDone()) {
            d = b.schedule(new Runnable() {
                @Override
                public final void run() {
                    dd.b();
                }
            }, q.a(), TimeUnit.MILLISECONDS);
        }
    }

    public static final void b(bd bdVar) {
        a.getClass();
        a(true, bdVar);
    }

    public static final cd b(boolean z) {
        a.getClass();
        return a(z);
    }

    public static final void b(Context context, ad adVar) {
        a.getClass();
        c(context, adVar);
    }

    public static final void b(Context context) {
        Toast.makeText(context, k7.a("ota_install_failed"), 0).show();
    }

    public static final synchronized void a(final bd bdVar) {
        ScheduledFuture scheduledFuture = d;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        d = null;
        b.execute(new Runnable() {
            @Override
            public final void run() {
                dd.b(bdVar);
            }
        });
    }

    public static void a(final boolean z, final bd bdVar) {
        cd cdVar;
        try {
            cdVar = (cd) t.a(new Callable() {
                @Override
                public final Object call() {
                    return dd.b(z);
                }
            });
        } catch (Throwable th) {
            g7.a(6, g7.a("OTA check failed", new Object[0]), th);
            cdVar = cd.FAILED;
        }
        final cd result = cdVar;
        if (bdVar != null) {
            c.post(new Runnable() {
                @Override
                public final void run() {
                    dd.a(bdVar, result);
                }
            });
        }
    }

    public static final void a(bd bdVar, cd cdVar) {
        bdVar.a(cdVar);
    }

    public static cd a(boolean z) {
        boolean z2;
        boolean z3;
        boolean z4;
        String host;
        Long longOrNull;
        Long longOrNull2;
        String contentOrNull;
        final Context contextA = Main.getApplicationContext();
        String strA = t.a("https://tiktokyou.yzewe.ru/api/v1/updates", "TTMod-Updates/5.0", 65536, MapsKt.plus(a(contextA), MapsKt.mapOf(TuplesKt.to("Cache-Control", "no-cache"))), (String) null).a();
        if (strA != null) {
            String string = StringsKt.trim(strA).toString();
            JsonElement jsonArrayB = e7.b(string);
            if (jsonArrayB != null) {
                JsonArray jsonArray = jsonArrayB instanceof JsonArray ? (JsonArray) jsonArrayB : null;
                if (jsonArray != null) {
                    ArrayList arrayList = new ArrayList(jsonArray.size());
                    for (Object element : jsonArray) {
                        JsonObject jsonObject2 = element instanceof JsonObject ? (JsonObject) element : null;
                        if (jsonObject2 != null) {
                            Object obj = jsonObject2.get("stable");
                            JsonPrimitive jsonPrimitive = obj instanceof JsonPrimitive ? (JsonPrimitive) obj : null;
                            if (jsonPrimitive == null) {
                                longOrNull = null;
                            } else {
                                Long longOrNull3 = JsonElementKt.getLongOrNull(jsonPrimitive);
                                if (longOrNull3 != null) {
                                    longOrNull = Long.valueOf(longOrNull3.longValue());
                                } else {
                                    String contentOrNull2 = JsonElementKt.getContentOrNull(jsonPrimitive);
                                    if (contentOrNull2 != null) {
                                        longOrNull = StringsKt.toLongOrNull(contentOrNull2);
                                    } else {
                                        longOrNull = null;
                                    }
                                }
                            }
                            if (longOrNull != null) {
                                long jLongValue = longOrNull.longValue();
                                Object obj2 = jsonObject2.get("dynamic");
                                JsonPrimitive jsonPrimitive2 = obj2 instanceof JsonPrimitive ? (JsonPrimitive) obj2 : null;
                                if (jsonPrimitive2 == null) {
                                    longOrNull2 = null;
                                } else {
                                    Long longOrNull4 = JsonElementKt.getLongOrNull(jsonPrimitive2);
                                    if (longOrNull4 != null) {
                                        longOrNull2 = Long.valueOf(longOrNull4.longValue());
                                    } else {
                                        String contentOrNull3 = JsonElementKt.getContentOrNull(jsonPrimitive2);
                                        if (contentOrNull3 != null) {
                                            longOrNull2 = StringsKt.toLongOrNull(contentOrNull3);
                                        } else {
                                            longOrNull2 = null;
                                        }
                                    }
                                }
                                if (longOrNull2 != null) {
                                    long jLongValue2 = longOrNull2.longValue();
                                    Object obj3 = jsonObject2.get("url");
                                    JsonPrimitive jsonPrimitive3 = obj3 instanceof JsonPrimitive ? (JsonPrimitive) obj3 : null;
                                    if (jsonPrimitive3 == null || (contentOrNull = JsonElementKt.getContentOrNull(jsonPrimitive3)) == null || contentOrNull.length() <= 0) {
                                        contentOrNull = null;
                                    }
                                    String string2 = contentOrNull != null ? StringsKt.trim(contentOrNull).toString() : null;
                                    if (string2 == null) {
                                        string2 = "";
                                    }
                                    String str = string2;
                                    if (jLongValue >= 0 && jLongValue2 >= 0 && str.length() != 0) {
                                        arrayList.add(new ad(jLongValue, jLongValue2, str));
                                    }
                                }
                            }
                        }
                    }
                    long jStableApiVersion = DynamicUpdates.stableApiVersion();
                    long jWorkingDynamicVersion = DynamicUpdates.workingDynamicVersion(contextA);
                    long jHighestAcceptedVersion = DynamicUpdates.highestAcceptedVersion(contextA);
                    long jOtaVersionFloor = DynamicUpdates.otaVersionFloor(contextA);
                    g7.a(4, g7.a("OTA catalog=%d stable=%d working=%d highest=%d floor=%d manual=%s", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(jStableApiVersion), Long.valueOf(jWorkingDynamicVersion), Long.valueOf(jHighestAcceptedVersion), Long.valueOf(jOtaVersionFloor), Boolean.valueOf(z)}), (Throwable) null);
                    if (jHighestAcceptedVersion > jOtaVersionFloor) {
                        g7.a(4, g7.a("OTA: quarantined dynamic=%d can be installed again", new Object[]{Long.valueOf(jHighestAcceptedVersion)}), (Throwable) null);
                    }
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        ad adVar = (ad) arrayList.get(i);
                        g7.a(4, g7.a("OTA entry stable=%d dynamic=%d url=%s", new Object[]{Long.valueOf(adVar.a), Long.valueOf(adVar.b), adVar.c}), (Throwable) null);
                    }
                    int size2 = arrayList.size();
                    ad adVar2 = null;
                    for (int i2 = 0; i2 < size2; i2++) {
                        ad adVar3 = (ad) arrayList.get(i2);
                        if (adVar3.a != jStableApiVersion || adVar3.b <= jOtaVersionFloor) {
                            continue;
                        }
                        try {
                            URI uri = new URI(adVar3.c);
                            host = uri.getHost();
                            if (StringsKt.equals("https", uri.getScheme(), true) && host != null && !StringsKt.isBlank(host)) {
                                if (adVar2 == null || adVar3.b > adVar2.b) {
                                    adVar2 = adVar3;
                                }
                            }
                        } catch (Throwable ignored) {
                        }
                    }
                    long j2 = jStableApiVersion;
                    int size3 = arrayList.size();
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size3) {
                            z2 = false;
                            break;
                        }
                        Object obj4 = arrayList.get(i3);
                        i3++;
                        if (((ad) obj4).a > j2) {
                            z2 = true;
                            break;
                        }
                    }
                    if (adVar2 != null && z) {
                        final ad pending = adVar2;
                        ck.a(new Runnable() {
                            @Override
                            public final void run() {
                                dd.a(contextA, pending);
                            }
                        });
                        return cd.OTA_AVAILABLE;
                    }
                    ac.a.getClass();
                    boolean z5 = ac.e().H && ac.e().F;
                    if (adVar2 == null || !z5) {
                        if (adVar2 != null) {
                            g7.a(4, g7.a("OTA: skip download dynamic=%d (consent/auto-update)", new Object[]{Long.valueOf(adVar2.b)}), (Throwable) null);
                            z3 = false;
                        } else {
                            z3 = false;
                            g7.a(4, g7.a("OTA: no matching dynamic package", new Object[0]), (Throwable) null);
                        }
                        z4 = z3;
                    } else {
                        try {
                            a(contextA, adVar2, false);
                            return cd.OTA_INSTALLED;
                        } catch (Throwable th2) {
                            g7.a(6, g7.a("OTA install failed dynamic=%d", new Object[]{Long.valueOf(adVar2.b)}), th2);
                            z4 = true;
                        }
                    }
                    if (!z2) {
                        return z4 ? cd.FAILED : cd.UP_TO_DATE;
                    }
                    int i4 = sf.h;
                    ck.b(z);
                    return cd.APK_AVAILABLE;
                }
                throw new IllegalArgumentException("updates catalog must be an array");
            }
            throw new IllegalArgumentException("updates catalog is not JSON");
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public static final void a(final Context context, final ad adVar) {
        b.execute(new Runnable() {
            @Override
            public final void run() {
                dd.b(context, adVar);
            }
        });
    }

    public static void a(Context context, ad adVar, boolean z) throws IOException {
        File file = new File(context.getCacheDir(), "tty_ota");
        if (!file.isDirectory() && !file.mkdirs()) {
            throw new IOException("Cannot create OTA cache directory");
        }
        File file2 = new File(file, "update.ttydyn");
        try {
            g7.a(4, g7.a("OTA: downloading stable=%d dynamic=%d", new Object[]{Long.valueOf(adVar.a), Long.valueOf(adVar.b)}), (Throwable) null);
            t.a(adVar.c, file2, "TTMod-Updates/5.0", a(context));
            DynamicUpdates.importPackage(context, file2);
            DynamicStatus status = DynamicUpdates.getStatus(context);
            if (status.pendingSha256 != null) {
                g7.a(4, g7.a("OTA: pending dynamic=%d sha=%s", new Object[]{Long.valueOf(adVar.b), status.pendingSha256}), (Throwable) null);
                ck.a(z);
                if (!file2.exists() || file2.delete()) {
                    return;
                }
                g7.a(6, g7.a("OTA: cannot delete %s", new Object[]{file2.getAbsolutePath()}), (Throwable) null);
                return;
            }
            throw new IOException("OTA package was not committed to the pending slot");
        } catch (Throwable th) {
            if (file2.exists() && !file2.delete()) {
                g7.a(6, g7.a("OTA: cannot delete %s", new Object[]{file2.getAbsolutePath()}), (Throwable) null);
            }
            throw th;
        }
    }

    public static Map a(Context context) {
        String strDecrypt;
        ac.a.getClass();
        if (ac.e().E) {
            strDecrypt = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } else {
            strDecrypt = "anonymous";
        }
        return (strDecrypt == null || StringsKt.isBlank(strDecrypt)) ? MapsKt.emptyMap() : MapsKt.mapOf(TuplesKt.to("X-SSAID", strDecrypt));
    }
}
