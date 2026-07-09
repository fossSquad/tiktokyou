package X;

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
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class n1 {
    public static final ConcurrentHashMap a = new ConcurrentHashMap();
    public static final String[] b = {"target_url", "redirect_url", "origin_url", "original_url", "web_url", "url", "target"};

    public static void a() {
        try {
            try {
                HookBridge.hookAllMethods(BioUserWebSiteComponent.class, k5.a.c[0], new l1());
                int i = g5.a;
            } catch (Throwable th) {
                th.getMessage();
                int i2 = g5.a;
            }
            try {
                t6 t6Var = s7.a;
                HookBridge.hookAllMethods(Class.forName("X.0cQU"), s7.a.c[0], new m1());
            } catch (Throwable th2) {
                th2.getMessage();
                int i3 = g5.a;
            }
        } catch (Throwable th3) {
            th3.getMessage();
            int i4 = g5.a;
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

    public static Uri c(Uri uri) {
        String lowerCase;
        if (uri == null) {
            return null;
        }
        String scheme = uri.getScheme();
        if (TextUtils.isEmpty(scheme)) {
            return null;
        }
        Locale locale = Locale.US;
        String lowerCase2 = scheme.toLowerCase(locale);
        if (!"aweme".equals(lowerCase2) && !"sslocal".equals(lowerCase2) && !lowerCase2.startsWith("snssdk")) {
            return null;
        }
        String host = uri.getHost();
        String path = uri.getPath();
        if (!TextUtils.isEmpty(host)) {
            String lowerCase3 = host.toLowerCase(locale);
            if (!lowerCase3.contains("webview") && !lowerCase3.contains("web_view") && !lowerCase3.contains("browser") && !lowerCase3.contains("spark")) {
                if (TextUtils.isEmpty(path)) {
                    return null;
                }
                lowerCase = path.toLowerCase(locale);
                if (!lowerCase.contains("webview")) {
                    return null;
                }
            }
        } else {
            if (TextUtils.isEmpty(path)) {
                return null;
            }
            lowerCase = path.toLowerCase(locale);
            if (!lowerCase.contains("webview") && !lowerCase.contains("web_view") && !lowerCase.contains("browser") && !lowerCase.contains("spark")) {
                return null;
            }
        }
        return a(uri);
    }

    public static boolean a(Context context, String str, boolean z) {
        if (context == null) {
            context = g5.c();
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
            int i = g5.a;
            if (concurrentHashMap.size() >= 32) {
                for (Map.Entry entry : concurrentHashMap.entrySet()) {
                    if (jCurrentTimeMillis - ((Long) entry.getValue()).longValue() > 1500) {
                        a.remove(entry.getKey(), entry.getValue());
                    }
                }
            }
            return true;
        } catch (Throwable th) {
            th.getMessage();
            int i2 = g5.a;
            return false;
        }
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
        Uri uriA;
        Uri uriA2 = a(str);
        if (uriA2 == null) {
            try {
                return c(Uri.parse(str));
            } catch (Throwable th) {
                return null;
            }
        }
        if (z) {
            String host = uriA2.getHost();
            if (TextUtils.isEmpty(host) || !a(host.toLowerCase(Locale.US), "tiktoklinksafety.com")) {
                uriA = null;
            } else {
                try {
                    uriA = a(uriA2.getQueryParameter("target"));
                } catch (Throwable th2) {
                    uriA = null;
                }
            }
        } else {
            uriA = null;
        }
        if (uriA != null && b(uriA)) {
            return uriA;
        }
        if (b(uriA2)) {
            return uriA2;
        }
        Uri uriA3 = a(uriA2);
        if (uriA3 == null || !b(uriA3)) {
            return null;
        }
        return uriA3;
    }

    public static Uri a(Uri uri) {
        for (String str : b) {
            try {
                Uri uriA = a(uri.getQueryParameter(str));
                if (uriA != null && b(uriA)) {
                    return uriA;
                }
            } catch (Throwable th) {
            }
        }
        return null;
    }

    public static Uri a(String str) {
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

    public static boolean a(String str, String str2) {
        return TextUtils.equals(str, str2) || str.endsWith(".".concat(str2));
    }
}
