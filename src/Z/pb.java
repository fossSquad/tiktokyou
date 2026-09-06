package Z;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.provider.Settings;
import com.windukk.mod.Main;
import com.windukk.stable.DynamicStatus;
import com.windukk.stable.DynamicUpdates;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.collections.MapsKt;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.JsonArray;
import ni.shikatu.kotlinx.serialization.json.JsonElementKt;
import ni.shikatu.kotlinx.serialization.json.JsonObject;
import ni.shikatu.kotlinx.serialization.json.JsonPrimitive;

public final class pb {
    public static final pb a;
    public static final ExecutorService b;
    public static final Handler c;

    static {
        a = new pb();
        b = Executors.newSingleThreadExecutor(new ThreadFactory() {
            @Override
            public final Thread newThread(Runnable runnable) {
                return pb.a(runnable);
            }
        });
        c = new Handler(Looper.getMainLooper());
    }

    public static final Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "TTModOta");
        thread.setDaemon(true);
        return thread;
    }

    public static final void b(boolean z, final nb nbVar) {
        final ob obVarA;
        try {
            a.getClass();
            obVarA = a(z);
        } catch (Throwable th) {
            h6.a(6, h6.a("OTA check failed", new Object[0]), th);
            obVarA = ob.d;
        }
        if (nbVar != null) {
            c.post(new Runnable() {
                @Override
                public final void run() {
                    pb.a(nbVar, obVarA);
                }
            });
        }
    }

    public static void a(final boolean z, final nb nbVar) {
        b.execute(new Runnable() {
            @Override
            public final void run() {
                pb.b(z, nbVar);
            }
        });
    }

    public static final void a(nb nbVar, ob obVar) {
        nbVar.a(obVar);
    }

    public static ob a(boolean z) {
        boolean z2;
        boolean z3;
        long j;
        String host;
        Long longOrNull;
        Long longOrNull2;
        String contentOrNull;
        String string;
        Context contextA = Main.a();
        String strA = p.a("https://tiktokyou.yzewe.ru/api/v1/updates", "TTMod-Updates/1.0", null, 65536, MapsKt.plus(a(contextA), MapsKt.mapOf(TuplesKt.to("Cache-Control", "no-cache")))).a();
        if (strA != null) {
            String string2 = StringsKt.trim(strA).toString();
            JsonArray jsonArrayB = f6.b(string2);
            if (jsonArrayB != null) {
                JsonArray<JsonObject> jsonArray = jsonArrayB instanceof JsonArray ? jsonArrayB : null;
                if (jsonArray != null) {
                    ArrayList arrayList = new ArrayList(jsonArray.size());
                    for (JsonObject jsonObject : jsonArray) {
                        JsonObject jsonObject2 = jsonObject instanceof JsonObject ? jsonObject : null;
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
                                    if (contentOrNull == null) {
                                        string = null;
                                    } else {
                                        string = StringsKt.trim(contentOrNull).toString();
                                    }
                                    if (string == null) {
                                        string = "";
                                    }
                                    String str = string;
                                    if (jLongValue >= 0 && jLongValue2 >= 0 && str.length() != 0) {
                                        arrayList.add(new mb(jLongValue, jLongValue2, str));
                                    }
                                }
                            }
                        }
                    }
                    long jStableApiVersion = DynamicUpdates.stableApiVersion();
                    long jWorkingDynamicVersion = DynamicUpdates.workingDynamicVersion(contextA);
                    long jHighestAcceptedVersion = DynamicUpdates.highestAcceptedVersion(contextA);
                    long jMax = Math.max(jWorkingDynamicVersion, jHighestAcceptedVersion);
                    h6.a(4, h6.a("OTA catalog=%d stable=%d working=%d highest=%d floor=%d manual=%s", new Object[]{Integer.valueOf(arrayList.size()), Long.valueOf(jStableApiVersion), Long.valueOf(jWorkingDynamicVersion), Long.valueOf(jHighestAcceptedVersion), Long.valueOf(jMax), Boolean.valueOf(z)}), (Throwable) null);
                    int size = arrayList.size();
                    for (int i = 0; i < size; i++) {
                        mb mbVar = (mb) arrayList.get(i);
                        h6.a(4, h6.a("OTA entry stable=%d dynamic=%d url=%s", new Object[]{Long.valueOf(mbVar.a), Long.valueOf(mbVar.b), mbVar.c}), (Throwable) null);
                    }
                    int size2 = arrayList.size();
                    int i2 = 0;
                    mb mbVar2 = null;
                    while (i2 < size2) {
                        i2++;
                        mb mbVar3 = (mb) arrayList.get(i2);
                        if (mbVar3.a != jStableApiVersion) {
                            j = jStableApiVersion;
                        } else if (mbVar3.b <= jMax) {
                            j = jStableApiVersion;
                        } else {
                            String str2 = mbVar3.c;
                            try {
                                URI uri = new URI(str2);
                                if (!StringsKt.equals("https", uri.getScheme(), true) || (host = uri.getHost()) == null) {
                                    j = jStableApiVersion;
                                } else if (StringsKt.isBlank(host)) {
                                    j = jStableApiVersion;
                                } else {
                                    if (mbVar2 != null) {
                                        j = jStableApiVersion;
                                        if (mbVar3.b > mbVar2.b) {
                                        }
                                    } else {
                                        j = jStableApiVersion;
                                    }
                                    mbVar2 = mbVar3;
                                    jStableApiVersion = j;
                                }
                            } catch (Throwable th) {
                                j = jStableApiVersion;
                            }
                        }
                        jStableApiVersion = j;
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
                        if (((mb) obj4).a > j2) {
                            z2 = true;
                            break;
                        }
                    }
                    ta.a.getClass();
                    boolean z4 = ta.d().B && (z || ta.d().A);
                    if (mbVar2 != null && z4) {
                        try {
                            a(contextA, mbVar2, z);
                            return ob.b;
                        } catch (Throwable th2) {
                            h6.a(6, h6.a("OTA install failed dynamic=%d", new Object[]{Long.valueOf(mbVar2.b)}), th2);
                            z3 = true;
                        }
                    } else if (mbVar2 != null) {
                        h6.a(4, h6.a("OTA: skip download dynamic=%d (consent/auto-update)", new Object[]{Long.valueOf(mbVar2.b)}), (Throwable) null);
                        z3 = false;
                    } else {
                        z3 = false;
                        h6.a(4, h6.a("OTA: no matching dynamic package", new Object[0]), (Throwable) null);
                    }
                    if (!z2) {
                        return z3 ? ob.d : ob.a;
                    }
                    le.y = true;
                    rg.b(z);
                    return ob.c;
                }
                throw new IllegalArgumentException("updates catalog must be an array");
            }
            throw new IllegalArgumentException("updates catalog is not JSON");
        }
        throw new IllegalStateException("Required value was null.".toString());
    }

    public static void a(Context context, mb mbVar, boolean z) throws IOException {
        File file = new File(context.getCacheDir(), "tty_ota");
        if (!file.isDirectory() && !file.mkdirs()) {
            throw new IOException("Cannot create OTA cache directory");
        }
        File file2 = new File(file, "update.ttydyn");
        try {
            h6.a(4, h6.a("OTA: downloading stable=%d dynamic=%d", new Object[]{Long.valueOf(mbVar.a), Long.valueOf(mbVar.b)}), (Throwable) null);
            p.a(mbVar.c, file2, "TTMod-Updates/1.0", a(context));
            DynamicUpdates.importPackage(context, file2);
            DynamicStatus status = DynamicUpdates.getStatus(context);
            if (status.pendingSha256 != null) {
                h6.a(4, h6.a("OTA: pending dynamic=%d sha=%s", new Object[]{Long.valueOf(mbVar.b), status.pendingSha256}), (Throwable) null);
                rg.a(z);
                if (!file2.exists() || file2.delete()) {
                    return;
                }
                h6.a(6, h6.a("OTA: cannot delete %s", new Object[]{file2.getAbsolutePath()}), (Throwable) null);
                return;
            }
            throw new IOException("OTA package was not committed to the pending slot");
        } catch (Throwable th) {
            if (file2.exists() && !file2.delete()) {
                h6.a(6, h6.a("OTA: cannot delete %s", new Object[]{file2.getAbsolutePath()}), (Throwable) null);
            }
            throw th;
        }
    }

    public static Map a(Context context) {
        String strDecrypt;
        ta.a.getClass();
        if (ta.d().z) {
            strDecrypt = Settings.Secure.getString(context.getContentResolver(), "android_id");
        } else {
            strDecrypt = "anonymous";
        }
        return (strDecrypt == null || StringsKt.isBlank(strDecrypt)) ? MapsKt.emptyMap() : MapsKt.mapOf(TuplesKt.to("X-SSAID", strDecrypt));
    }
}
