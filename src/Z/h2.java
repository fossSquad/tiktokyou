package Z;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import com.ss.android.ugc.profile.business.ur.platform.business.BioUserWebSiteComponent;
import com.windukk.hook.HookBridge;
import com.windukk.mod.Main;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class h2 {
    public static final ConcurrentHashMap a;
    public static final String[] b;

    static {
        a = new ConcurrentHashMap();
        b = new String[]{"target_url", "redirect_url", "origin_url", "original_url", "web_url", "url", "target"};
    }

    public static void a() {
        try {
            HookBridge.hookAllMethods(BioUserWebSiteComponent.class, t7.a.c[0], new f2());
        } catch (Throwable th) {
            String strDecrypt = "Failed to hook profile bio links: %s";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static void b() {
        try {
            v9 v9Var = gb.a;
            HookBridge.hookAllMethods(Class.forName("X.044H"), gb.a.c[0], new g2());
        } catch (Throwable th) {
            String strDecrypt = "Failed to hook SparkThird bio routes";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static void c() {
        try {
            a();
            b();
            String strDecrypt = "Initialized";
            Object obj = g7.a;
            g7.a(4, String.valueOf(strDecrypt), (Throwable) null);
        } catch (Throwable th) {
            String strDecrypt2 = "Init failed: %s";
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(strDecrypt2), th);
        }
    }

    public static Uri c(Uri uri) {
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return null;
        }
        String lowerCase = scheme.toLowerCase(Locale.US);
        if (!"aweme".equals(lowerCase) && !"sslocal".equals(lowerCase) && !lowerCase.startsWith("snssdk")) {
            return null;
        }
        String host = uri.getHost();
        String path = uri.getPath();
        if (a(host) || a(path)) {
            return a(uri);
        }
        return null;
    }

    public static boolean a(Context context, String str, boolean z) {
        if (context == null) {
            context = Main.getApplicationContext();
        }
        Uri uriA = a(str, z);
        if (uriA == null) {
            return false;
        }
        String string = uriA.toString();
        long jCurrentTimeMillis = System.currentTimeMillis();
        ConcurrentHashMap concurrentHashMap = a;
        Long l = (Long) concurrentHashMap.put(string, Long.valueOf(jCurrentTimeMillis));
        if (l != null && jCurrentTimeMillis - l.longValue() < 1500) {
            return true;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", uriA);
            intent.addCategory("android.intent.category.BROWSABLE");
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            a(context, intent);
            context.startActivity(intent);
            if (concurrentHashMap.size() >= 32) {
                for (Map.Entry entry : ((Map<?, ?>) concurrentHashMap).entrySet()) {
                    if (jCurrentTimeMillis - ((Long) entry.getValue()).longValue() > 1500) {
                        a.remove(entry.getKey(), entry.getValue());
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            g7.a(6, g7.a("Failed to open external url: %s", new Object[]{string}), th);
            return false;
        }
    }

    public static Uri b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            String strTrim = str.trim();
            Uri uri = Uri.parse(strTrim);
            String scheme = uri.getScheme();
            if (TextUtils.isEmpty(scheme)) {
                if ((TextUtils.isEmpty(strTrim) || strTrim.contains(" ") || strTrim.indexOf(46) <= 0 || strTrim.startsWith("/") || strTrim.startsWith("#")) ? false : true) {
                    uri = Uri.parse("https://" + strTrim);
                    scheme = uri.getScheme();
                }
            }
            if (("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) && uri.getHost() != null) {
                return uri;
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static boolean b(Uri uri) {
        String host = uri.getHost();
        if (TextUtils.isEmpty(host)) {
            return false;
        }
        String lowerCase = host.toLowerCase(Locale.US);
        return !(a(lowerCase, "tiktok.com") || a(lowerCase, "tiktokv.com") || a(lowerCase, "tiktokcdn.com") || a(lowerCase, "tiktokcdn-us.com") || a(lowerCase, "tiktokcdn-eu.com") || a(lowerCase, "musical.ly") || a(lowerCase, "muscdn.com") || a(lowerCase, "byteoversea.com") || a(lowerCase, "ibytedtos.com") || a(lowerCase, "ibyteimg.com"));
    }

    public static void a(Context context, Intent intent) {
        try {
            String packageName = context.getPackageName();
            for (ResolveInfo resolveInfo : context.getPackageManager().queryIntentActivities(intent, 0)) {
                ActivityInfo activityInfo = resolveInfo.activityInfo;
                if (activityInfo != null && !TextUtils.equals(activityInfo.packageName, packageName)) {
                    ActivityInfo activityInfo2 = resolveInfo.activityInfo;
                    intent.setComponent(new ComponentName(activityInfo2.packageName, activityInfo2.name));
                    return;
                }
            }
        } catch (Throwable th) {
        }
    }

    public static Uri a(String str, boolean z) {
        Uri uriB;
        Uri uriB2 = b(str);
        if (uriB2 == null) {
            try {
                return c(Uri.parse(str));
            } catch (Throwable th) {
                return null;
            }
        }
        if (z) {
            String host = uriB2.getHost();
            if (TextUtils.isEmpty(host) || !a(host.toLowerCase(Locale.US), "tiktoklinksafety.com")) {
                uriB = null;
            } else {
                try {
                    uriB = b(uriB2.getQueryParameter("target"));
                } catch (Throwable th2) {
                    uriB = null;
                }
            }
        } else {
            uriB = null;
        }
        if (uriB != null && b(uriB)) {
            return uriB;
        }
        if (b(uriB2)) {
            return uriB2;
        }
        Uri uriA = a(uriB2);
        if (uriA == null || !b(uriA)) {
            return null;
        }
        return uriA;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.US);
        return lowerCase.contains("webview") || lowerCase.contains("web_view") || lowerCase.contains("browser") || lowerCase.contains("spark");
    }

    public static Uri a(Uri uri) {
        for (String str : b) {
            try {
                Uri uriB = b(uri.getQueryParameter(str));
                if (uriB != null && b(uriB)) {
                    return uriB;
                }
            } catch (Throwable th) {
            }
        }
        return null;
    }

    public static boolean a(String str, String str2) {
        return TextUtils.equals(str, str2) || str.endsWith(new StringBuilder(".").append(str2).toString());
    }
}
