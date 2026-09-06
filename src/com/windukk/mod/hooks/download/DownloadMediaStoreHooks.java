package com.windukk.mod.hooks.download;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import com.windukk.hook.HookBridge;
import java.util.concurrent.ConcurrentHashMap;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.text.StringsKt;

public final class DownloadMediaStoreHooks {
    public static final ThreadLocal a = new ThreadLocal();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();

    public static void a() {
        HookBridge.hookAllMethods(ContentResolver.class, "insert", new DownloadMediaStoreHooks$before$1());
        HookBridge.hookAllMethods(ContentResolver.class, "insert", new DownloadMediaStoreHooks$after$1());
        HookBridge.hookAllMethods(ContentResolver.class, "openOutputStream", new DownloadMediaStoreHooks$after$2());
        h6.a(4, h6.a("Hooked operation-scoped download MediaStore routing", new Object[0]), (Throwable) null);
    }

    public static void a(ContentValues contentValues, b4 b4Var) {
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
            if (Build.VERSION.SDK_INT >= 29) {
                contentValues.put("relative_path", new StringBuilder().append(Environment.DIRECTORY_MUSIC).append("/TikTok").toString());
                return;
            }
            return;
        }
        if (Build.VERSION.SDK_INT >= 29) {
            contentValues.put("relative_path", new StringBuilder().append(Environment.DIRECTORY_MOVIES).append("/TikTok").toString());
        }
    }

    public static final Uri a(Uri uri) {
        Object obj;
        if (Build.VERSION.SDK_INT >= 29 && uri != null) {
            try {
                Result.Companion companion = Result.Companion;
                obj = Result.constructor-impl(MediaStore.getVolumeName(uri));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            if (Result.isFailure-impl(obj)) {
                obj = null;
            }
            String str = (String) obj;
            if (str != null && !StringsKt.isBlank(str)) {
                Uri contentUri = MediaStore.Audio.Media.getContentUri(str);
                return contentUri;
            }
        }
        Uri uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        return uri2;
    }
}
