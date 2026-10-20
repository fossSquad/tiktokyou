package Z;

import android.content.ContentValues;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import java.util.Locale;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;

public final class w3 {
    public static final w3 a;

    static {
        a = new w3();
    }

    public static final String a() {
        w3 w3Var = a;
        String strDecrypt = "Videos";
        w3Var.getClass();
        return b(strDecrypt);
    }

    public static String b(String str) {
        return (new StringBuilder().append(Environment.DIRECTORY_DOWNLOADS)).append("/TikTokYou").toString() + "/" + str + "/";
    }

    public static final String a(String str, boolean z, Uri uri, String str2) {
        if (z) {
            w3 w3Var = a;
            String strDecrypt = "Audio";
            w3Var.getClass();
            return b(strDecrypt);
        }
        if (str == null) {
            str = "";
        }
        Locale locale = Locale.US;
        String lowerCase = str.toLowerCase(locale);
        if (StringsKt.startsWith$default(lowerCase, "image/", false, 2, (Object) null)) {
            w3 w3Var2 = a;
            String strDecrypt2 = "Photos";
            w3Var2.getClass();
            return b(strDecrypt2);
        }
        if (StringsKt.startsWith$default(lowerCase, "video/", false, 2, (Object) null)) {
            return a();
        }
        if (StringsKt.startsWith$default(lowerCase, "audio/", false, 2, (Object) null)) {
            w3 w3Var3 = a;
            String strDecrypt3 = "Audio";
            w3Var3.getClass();
            return b(strDecrypt3);
        }
        String string = uri != null ? uri.toString() : null;
        if (string == null) {
            string = "";
        }
        String lowerCase2 = string.toLowerCase(locale);
        if (StringsKt.contains$default(lowerCase2, "/images", false, 2, (Object) null)) {
            w3 w3Var4 = a;
            String strDecrypt4 = "Photos";
            w3Var4.getClass();
            return b(strDecrypt4);
        }
        if (StringsKt.contains$default(lowerCase2, "/video", false, 2, (Object) null)) {
            return a();
        }
        if (StringsKt.contains$default(lowerCase2, "/audio", false, 2, (Object) null)) {
            w3 w3Var5 = a;
            String strDecrypt5 = "Audio";
            w3Var5.getClass();
            return b(strDecrypt5);
        }
        if (str2 == null) {
            str2 = "";
        }
        String lowerCase3 = str2.toLowerCase(locale);
        if (StringsKt.contains$default(lowerCase3, "picture", false, 2, (Object) null) || StringsKt.contains$default(lowerCase3, "dcim", false, 2, (Object) null)) {
            w3 w3Var6 = a;
            String strDecrypt6 = "Photos";
            w3Var6.getClass();
            return b(strDecrypt6);
        }
        if (StringsKt.contains$default(lowerCase3, "movie", false, 2, (Object) null)) {
            return a();
        }
        if (!StringsKt.contains$default(lowerCase3, "music", false, 2, (Object) null)) {
            return a();
        }
        w3 w3Var7 = a;
        String strDecrypt7 = "Audio";
        w3Var7.getClass();
        return b(strDecrypt7);
    }

    public static final void a(ContentValues contentValues, Uri uri, boolean z) {
        if (Build.VERSION.SDK_INT < 29) {
            return;
        }
        contentValues.put("relative_path", a(contentValues.getAsString("mime_type"), z, uri, contentValues.getAsString("relative_path")));
    }

    public static final boolean a(String str) {
        String str2;
        a.getClass();
        if (str != null) {
            str2 = str;
        } else {
            str2 = "";
        }
        String strTrim = StringsKt.trim(StringsKt.trim(StringsKt.replace$default(str2, '\\', '/', false, 4, (Object) null)).toString(), new char[]{'/'});
        Locale locale = Locale.US;
        String lowerCase = strTrim.toLowerCase(locale);
        if (lowerCase.length() == 0) {
            return false;
        }
        String lowerCase2 = (Environment.DIRECTORY_DOWNLOADS + "/TikTokYou").toLowerCase(locale);
        return Intrinsics.areEqual(lowerCase, lowerCase2) || StringsKt.startsWith$default(lowerCase, new StringBuilder().append(lowerCase2).append("/").toString(), false, 2, (Object) null);
    }

    public static final Uri a(Uri uri) {
        String str;
        String strDecrypt;
        Object obj;
        if (Build.VERSION.SDK_INT < 29 || uri == null) {
            str = null;
        } else {
            try {
                Result.Companion companion = Result.Companion;
                obj = ResultCompat.constructor(MediaStore.getVolumeName(uri));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = ResultCompat.constructor(ResultKt.createFailure(th));
            }
            if (ResultCompat.isFailure(obj)) {
                obj = null;
            }
            str = (String) obj;
        }
        if (str == null) {
            strDecrypt = "external_primary";
        } else {
            strDecrypt = StringsKt.isBlank(str) ? null : str;
            if (strDecrypt == null) {
                strDecrypt = "external_primary";
            }
        }
        Uri contentUri = MediaStore.Downloads.getContentUri(strDecrypt);
        return contentUri;
    }

    public static final boolean a(String str, String str2) {
        String str3;
        a.getClass();
        if (str != null) {
            str3 = str;
        } else {
            str3 = "";
        }
        String strTrim = StringsKt.trim(StringsKt.trim(StringsKt.replace$default(str3, '\\', '/', false, 4, (Object) null)).toString(), new char[]{'/'});
        Locale locale = Locale.US;
        String lowerCase = strTrim.toLowerCase(locale);
        String lowerCase2 = (Environment.DIRECTORY_DOWNLOADS + "/TikTokYou").toLowerCase(locale);
        if (!Intrinsics.areEqual(lowerCase, lowerCase2) && !StringsKt.startsWith$default(lowerCase, lowerCase2 + "/", false, 2, (Object) null)) {
            if (StringsKt.contains$default(lowerCase, "tiktok", false, 2, (Object) null)) {
                return true;
            }
            if (StringsKt.startsWith(str2 == null ? "" : str2, "TikTok_", true)) {
                return true;
            }
            if (Intrinsics.areEqual(lowerCase, "dcim/camera") || StringsKt.startsWith$default(lowerCase, "dcim/camera/", false, 2, (Object) null)) {
                if (str2 == null) {
                    str2 = "";
                }
                String strSubstringBeforeLast$default = StringsKt.substringBeforeLast$default(str2, '.', (String) null, 2, (Object) null);
                if (strSubstringBeforeLast$default.length() == 32) {
                    for (int i = 0; i < strSubstringBeforeLast$default.length(); i++) {
                        char cCharAt = strSubstringBeforeLast$default.charAt(i);
                        if (Character.isDigit(cCharAt) || (('a' <= cCharAt && cCharAt < 'g') || ('A' <= cCharAt && cCharAt < 'G'))) {
                        }
                    }
                    return true;
                }
            }
        }
        return false;
    }
}
