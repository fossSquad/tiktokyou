package Z;

import Z.h6;
import Z.p8;
import Z.tg;
import Z.z7;

import Z.b4;

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

public final class DownloadMediaStoreHooks {
    public static final AtomicBoolean c = new AtomicBoolean(false);
    public static final ThreadLocal a = new ThreadLocal();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();

    public static void a() {
        Object obj;
        Object obj2;
        if (c.compareAndSet(false, true)) {
            HookBridge.hookAllMethods(ContentResolver.class, "insert", new DownloadMediaStoreHooks$before$1());
            HookBridge.hookAllMethods(ContentResolver.class, "insert", new DownloadMediaStoreHooks$after$1());
            HookBridge.hookAllMethods(ContentResolver.class, "openOutputStream", new DownloadMediaStoreHooks$after$2());
            try {
                Result.Companion companion = Result.Companion;
                c();
                obj = RCompat.m6constructorimpl(Unit.INSTANCE);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
            }
            Throwable th2 = RCompat.m9exceptionOrNullimpl(obj);
            if (th2 != null) {
                h6.a(6, h6.a("Stock MediaStore album redirect unavailable", new Object[0]), th2);
            }
            try {
                Result.Companion companion3 = Result.Companion;
                b();
                obj2 = RCompat.m6constructorimpl(Unit.INSTANCE);
            } catch (Throwable th3) {
                Result.Companion companion4 = Result.Companion;
                obj2 = RCompat.m6constructorimpl(ResultKt.createFailure(th3));
            }
            Throwable th4 = RCompat.m9exceptionOrNullimpl(obj2);
            if (th4 != null) {
                h6.a(6, h6.a("Photo gallery temp-dir redirect unavailable", new Object[0]), th4);
            }
            h6.a(4, h6.a("Hooked download MediaStore routing to Download/TikTokYou", new Object[0]), (Throwable) null);
        }
    }

    public static void b() throws NoSuchFieldException, ClassNotFoundException {
        z7 z7Var = com.windukk.mod.f.a;
        Class<?> cls = Class.forName("X.167s");
        Field fieldA = com.windukk.mod.f.a.a(cls);
        fieldA.setAccessible(true);
        HookBridge.hookAllConstructors(cls, new DownloadMediaStoreHooks$hookPhotoGalleryTempDir$1(new File(Main.getApplicationContext().getCacheDir(), "tiktokyou_photo_save"), fieldA));
    }

    public static void c() throws ClassNotFoundException {
        p8 p8Var = com.windukk.mod.e.a;
        Class<?> cls = Class.forName("X.01BB");
        String str = com.windukk.mod.e.a.c[0];
        HookBridge.hookAllMethods(cls, str, new DownloadMediaStoreHooks$before$2());
        String str2 = com.windukk.mod.e.b.c[0];
        HookBridge.hookAllMethods(cls, str2, new DownloadMediaStoreHooks$before$3());
    }

    public static void a(ContentValues contentValues, b4 b4Var, Uri uri) {
        String asString = contentValues.getAsString("_display_name");
        if (b4Var.c) {
            String strDecrypt = b4Var.d;
            if (strDecrypt == null) {
                strDecrypt = ".m4a";
            }
            String strDecrypt2 = "mime_type";
            String strDecrypt3 = b4Var.e;
            if (strDecrypt3 == null) {
                strDecrypt3 = "audio/mp4";
            }
            contentValues.put(strDecrypt2, strDecrypt3);
            if (asString != null && !StringsKt.endsWith(asString, strDecrypt, true)) {
                contentValues.put("_display_name", StringsKt.substringBeforeLast$default(asString, '.', (String) null, 2, (Object) null) + strDecrypt);
            }
        }
        tg.a(contentValues, uri, b4Var.c);
    }

    public static final void a(HookMethod.HookMethodParam hookMethodParam, ContentValues contentValues, Uri uri) {
        if (Build.VERSION.SDK_INT >= 29 && tg.a(contentValues.getAsString("relative_path"))) {
            Uri uriA = tg.a(uri);
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
        String strA = !tg.a(str3, str) ? str3 : tg.a(str2, false, null, str3);
        if (strA == null || Intrinsics.areEqual(strA, str3)) {
            return;
        }
        hookMethodParam.args[3] = strA;
    }
}
