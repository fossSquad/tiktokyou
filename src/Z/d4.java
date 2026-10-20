package Z;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import com.windukk.hook.HookBridge;
import com.windukk.hook.HookMethod;
import com.windukk.mod.Main;
import java.io.File;
import java.lang.reflect.Field;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;

public final class d4 {
    public static final AtomicBoolean a = new AtomicBoolean(false);
    public static final ThreadLocal b = new ThreadLocal();
    public static final ConcurrentHashMap c = new ConcurrentHashMap();

    public static void a(ContentValues contentValues, q4 q4Var, Uri uri) {
        String asString = contentValues.getAsString("_display_name");
        if (q4Var.c) {
            String strDecrypt = q4Var.d;
            if (strDecrypt == null) {
                strDecrypt = ".m4a";
            }
            String strDecrypt2 = "mime_type";
            String strDecrypt3 = q4Var.e;
            if (strDecrypt3 == null) {
                strDecrypt3 = "audio/mp4";
            }
            contentValues.put(strDecrypt2, strDecrypt3);
            if (asString != null && !StringsKt.endsWith(asString, strDecrypt, true)) {
                contentValues.put("_display_name", StringsKt.substringBeforeLast$default(asString, '.', (String) null, 2, (Object) null) + strDecrypt);
            }
        }
        w3.a(contentValues, uri, q4Var.c);
    }

    public static void b() throws ClassNotFoundException {
        v9 v9Var = t9.a;
        Class<?> cls = Class.forName("X.01BZ");
        String str = t9.a.c[0];
        HookBridge.hookAllMethods(cls, str, new d4$before$1());
        String str2 = t9.b.c[0];
        HookBridge.hookAllMethods(cls, str2, new d4$before$2());
    }

    public static void c() {
        Object obj;
        Object obj2;
        if (a.compareAndSet(false, true)) {
            HookBridge.hookAllMethods(ContentResolver.class, "insert", new d4$before$3());
            HookBridge.hookAllMethods(ContentResolver.class, "insert", new d4$after$1());
            HookBridge.hookAllMethods(ContentResolver.class, "openOutputStream", new d4$after$2());
            try {
                Result.Companion companion = Result.Companion;
                b();
                obj = ResultCompat.constructor(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = ResultCompat.constructor(ResultKt.createFailure(th));
            }
            Throwable th2 = ResultCompat.exceptionOrNull(obj);
            if (th2 != null) {
                g7.a(6, g7.a("Stock MediaStore album redirect unavailable", new Object[0]), th2);
            }
            try {
                Result.Companion companion3 = Result.Companion;
                a();
                obj2 = ResultCompat.constructor(Unit.INSTANCE);
            } catch (Throwable th3) {
                Result.Companion companion4 = Result.Companion;
                obj2 = ResultCompat.constructor(ResultKt.createFailure(th3));
            }
            Throwable th4 = ResultCompat.exceptionOrNull(obj2);
            if (th4 != null) {
                g7.a(6, g7.a("Photo gallery temp-dir redirect unavailable", new Object[0]), th4);
            }
            g7.a(4, g7.a("Hooked download MediaStore routing to Download/TikTokYou", new Object[0]), (Throwable) null);
        }
    }

    public static final void a(HookMethod.HookMethodParam hookMethodParam, ContentValues contentValues, Uri uri) {
        if (Build.VERSION.SDK_INT >= 29 && w3.a(contentValues.getAsString("relative_path"))) {
            Uri uriA = w3.a(uri);
            if (Intrinsics.areEqual(uri, uriA)) {
                return;
            }
            hookMethodParam.args[0] = uriA;
        }
    }

    public static final void a(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        if (objArr.length < 4) {
            return;
        }
        Object obj = objArr[1];
        String str = obj instanceof String ? (String) obj : null;
        Object obj2 = objArr[2];
        String str2 = obj2 instanceof String ? (String) obj2 : null;
        Object obj3 = objArr[3];
        String str3 = obj3 instanceof String ? (String) obj3 : null;
        String strA = !w3.a(str3, str) ? str3 : w3.a(str2, false, null, str3);
        if (strA == null || Intrinsics.areEqual(strA, str3)) {
            return;
        }
        hookMethodParam.args[3] = strA;
    }

    public static void a() throws NoSuchFieldException, ClassNotFoundException {
        e9 e9Var = da.a;
        Class<?> cls = Class.forName("X.1IG3");
        Field fieldA = da.a.a(cls);
        fieldA.setAccessible(true);
        HookBridge.hookAllConstructors(cls, new d4$hookPhotoGalleryTempDir$1(new File(Main.getApplicationContext().getCacheDir(), "tiktokyou_photo_save"), fieldA));
    }
}
