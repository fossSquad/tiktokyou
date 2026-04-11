package X;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.feed.assem.videoauthorinfo.VideoAuthorInfoVM;
import com.ss.android.ugc.aweme.friendstab.repo.FriendsV3RepostModel;
import com.ss.android.ugc.aweme.im.common.model.BaseContact;
import com.ss.android.ugc.aweme.im.contacts.api.model.IMConversation;
import com.ss.android.ugc.aweme.im.contacts.api.model.IMUser;
import com.ss.android.ugc.aweme.im.saas.host.impl.friends.IMFriendsServiceImpl;
import com.ss.android.ugc.aweme.profile.model.User;
import de.robv.android.xposed.XposedBridge;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class k0 {
    public static volatile String n;
    public static final ConcurrentHashMap a = new ConcurrentHashMap();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();
    public static final ConcurrentHashMap c = new ConcurrentHashMap();
    public static final ConcurrentHashMap d = new ConcurrentHashMap();
    public static final ConcurrentHashMap e = new ConcurrentHashMap();
    public static final ConcurrentHashMap f = new ConcurrentHashMap();
    public static final ConcurrentHashMap g = new ConcurrentHashMap();
    public static final ConcurrentHashMap h = new ConcurrentHashMap();
    public static final Map i = Collections.synchronizedMap(new WeakHashMap());
    public static final Map j = Collections.synchronizedMap(new WeakHashMap());
    public static final Map k = Collections.synchronizedMap(new WeakHashMap());
    public static final AtomicInteger l = new AtomicInteger(1);
    public static final AtomicBoolean m = new AtomicBoolean(false);
    public static volatile i0 o = new i0("5", "500");

    public static void a() {
        try {
            Context contextB = p2.b();
            if (contextB != null) {
                String strB = b(new File(a(contextB), "supporters_cache.txt"));
                if (!TextUtils.isEmpty(strB)) {
                    LinkedHashMap linkedHashMapH = h(strB);
                    if (!linkedHashMapH.isEmpty()) {
                        ConcurrentHashMap concurrentHashMap = a;
                        concurrentHashMap.clear();
                        if (!linkedHashMapH.isEmpty()) {
                            concurrentHashMap.putAll(linkedHashMapH);
                        }
                        e(contextB);
                        linkedHashMapH.size();
                    }
                }
                i0 i0VarG = g(b(new File(a(contextB), "support_price_cache.json")));
                if (i0VarG != null) {
                    o = i0VarG;
                }
                g(contextB);
                f(contextB);
            }
            s sVar = new s();
            XposedBridge.hookAllMethods(User.class, "getNickname", sVar);
            XposedBridge.hookAllMethods(User.class, "getRemarkName", sVar);
            XposedBridge.hookAllMethods(User.class, "getContactName", sVar);
            t tVar = new t();
            XposedBridge.hookAllMethods(BaseContact.class, "getNickName", tVar);
            XposedBridge.hookAllMethods(BaseContact.class, "getDisplayName", tVar);
            u uVar = new u();
            XposedBridge.hookAllMethods(IMUser.class, "getDisplayName", uVar);
            XposedBridge.hookAllMethods(IMUser.class, "getRemarkName", uVar);
            XposedBridge.hookAllMethods(IMUser.class, "getContactName", uVar);
            v vVar = new v();
            XposedBridge.hookAllMethods(IMConversation.class, "getConversationName", vVar);
            XposedBridge.hookAllMethods(IMConversation.class, "getDisplayName", vVar);
            XposedBridge.hookAllMethods(IMConversation.class, "getNickName", vVar);
            XposedBridge.hookAllMethods(VideoAuthorInfoVM.class, "ez2", new w());
            try {
                XposedBridge.hookAllConstructors(FriendsV3RepostModel.class, new x());
            } catch (Throwable th) {
                th.getMessage();
                ArrayList arrayList = p2.a;
            }
            a(g0.a, "X.0qTQ");
            g0 g0Var = g0.b;
            a(g0Var, "X.0qTS");
            a(g0Var, "X.0qTW");
            try {
                XposedBridge.hookAllMethods(IMFriendsServiceImpl.class, "LIZIZ", new z());
            } catch (Throwable th2) {
                th2.getMessage();
                ArrayList arrayList2 = p2.a;
            }
            XposedBridge.hookAllMethods(TextView.class, "setText", new a0());
            XposedBridge.hookAllMethods(TextView.class, "onTouchEvent", new p());
        } catch (Throwable th3) {
            th3.getMessage();
            ArrayList arrayList3 = p2.a;
        }
    }

    public static void b(Context context) {
        try {
            byte[] bArrB = b("https://tiktokyou.yzewe.ru/api/v1/price");
            String str = bArrB == null ? null : new String(bArrB, StandardCharsets.UTF_8);
            i0 i0VarG = g(str);
            if (i0VarG == null) {
                throw new IOException("Invalid support price");
            }
            o = i0VarG;
            b(str, new File(a(context), "support_price_cache.json"));
            ArrayList arrayList = p2.a;
        } catch (Throwable th) {
            th.getMessage();
            ArrayList arrayList2 = p2.a;
        }
    }

    public static void c(final Activity activity, final Fragment fragment, final d0 d0Var, final String str) {
        if (a(activity)) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public final void run() {
                    k0.b(activity, fragment, d0Var, str);
                }
            });
        }
    }

    public static void d(Context context) {
        if (context == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/tt_ubot"));
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Throwable th) {
            th.getMessage();
            ArrayList arrayList = p2.a;
        }
    }

    public static void e(Context context) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        for (d0 d0Var : a.values()) {
            if (d0Var != null && d(d0Var.b)) {
                linkedHashSet.add(d0Var.b);
            }
        }
        for (String str : linkedHashSet) {
            if (d(str)) {
                c(context, str);
            }
        }
    }

    public static void f(final Context context) {
        if (m.compareAndSet(false, true)) {
            new Thread(new Runnable() {
                @Override
                public final void run() {
                    k0.b(context);
                }
            }, "badge-price-fetch").start();
        }
    }

    public static void g(final Context context) {
        new Thread(new Runnable() {
            @Override
            public final void run() {
                k0.c(context);
            }
        }, "badge-supporters-fetch").start();
    }

    public static LinkedHashMap h(String str) {
        d0 d0VarF;
        d0 d0VarA;
        if (TextUtils.isEmpty(str)) {
            return new LinkedHashMap();
        }
        if (str.trim().startsWith("[")) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            if (!TextUtils.isEmpty(str)) {
                String strTrim = str.trim();
                if (strTrim.startsWith("[")) {
                    try {
                        JSONArray jSONArray = new JSONArray(strTrim);
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            Object objOpt = jSONArray.opt(i2);
                            if ((objOpt instanceof JSONObject) && (d0VarA = a((JSONObject) objOpt)) != null) {
                                linkedHashMap.put(d0VarA.a, d0VarA);
                            }
                        }
                    } catch (Throwable th) {
                        th.getMessage();
                        ArrayList arrayList = p2.a;
                        return linkedHashMap;
                    }
                }
            }
            return linkedHashMap;
        }
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        if (TextUtils.isEmpty(str)) {
            return linkedHashMap2;
        }
        Scanner scanner = new Scanner(str);
        while (scanner.hasNextLine()) {
            try {
                String strTrim2 = scanner.nextLine().trim();
                if (!strTrim2.isEmpty() && !strTrim2.startsWith("#") && !strTrim2.startsWith("//") && (d0VarF = f(strTrim2)) != null) {
                    linkedHashMap2.put(d0VarF.a, d0VarF);
                }
            } catch (Throwable th2) {
                try {
                    scanner.close();
                } catch (Throwable th3) {
                    th2.addSuppressed(th3);
                }
                throw th2;
            }
        }
        scanner.close();
        return linkedHashMap2;
    }

    public static d0 i(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return null;
        }
        return (d0) a.get(strTrim);
    }

    public static String j(String str) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA-256").digest(str.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder(bArrDigest.length * 2);
            for (byte b2 : bArrDigest) {
                sb.append(String.format("%02x", Byte.valueOf(b2)));
            }
            return sb.toString();
        } catch (Throwable th) {
            return Integer.toHexString(str.hashCode());
        }
    }

    public static void c(Context context, final String str) {
        if (d(str)) {
            final File file = new File(new File(a(context), "images"), j(str) + ".img");
            File file2 = new File(new File(a(context), "images"), j(str) + ".stamp");
            if (a(file, file2, 7200000L) && f.putIfAbsent(str, Boolean.TRUE) == null) {
                c(file2);
                Runnable runnable = new Runnable() {
                    @Override
                    public final void run() {
                        k0.a(str, file);
                    }
                };
                StringBuilder sb = new StringBuilder("badge-img-");
                String strJ = j(str);
                if (strJ.length() > 8) {
                    strJ = strJ.substring(0, 8);
                }
                new Thread(runnable, sb.append(strJ).toString()).start();
            }
        }
    }

    public static boolean d(String str) {
        if (str != null) {
            return str.startsWith("https://") || str.startsWith("http://");
        }
        return false;
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return "asset:supporter.png";
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return "asset:supporter.png";
        }
        return (d(strTrim) || strTrim.startsWith("asset:")) ? strTrim : "asset:".concat(strTrim);
    }

    public static d0 f(String str) {
        String strTrim;
        String strE;
        Boolean bool;
        int length;
        String strTrim2;
        boolean z = true;
        String strE2 = "asset:supporter.png";
        if (str.contains("|")) {
            String[] strArrSplit = str.split("\\Q|\\E", 3);
            strTrim2 = strArrSplit.length > 0 ? strArrSplit[0].trim() : "";
            if (strArrSplit.length > 1 && !strArrSplit[1].trim().isEmpty()) {
                strE2 = e(strArrSplit[1].trim());
                z = false;
            }
            if (strArrSplit.length <= 2) {
                strTrim = strTrim2;
                strE = strE2;
                bool = null;
            } else {
                String strTrim3 = strArrSplit[2].trim();
                if (TextUtils.isEmpty(strTrim3)) {
                    strTrim = strTrim2;
                    strE = strE2;
                    bool = null;
                } else if ("true".equalsIgnoreCase(strTrim3)) {
                    bool = Boolean.TRUE;
                    strTrim = strTrim2;
                    strE = strE2;
                } else if ("false".equalsIgnoreCase(strTrim3)) {
                    bool = Boolean.FALSE;
                    strTrim = strTrim2;
                    strE = strE2;
                } else {
                    strTrim = strTrim2;
                    strE = strE2;
                    bool = null;
                }
            }
        } else {
            int iIndexOf = str.indexOf(58);
            if (iIndexOf > 0) {
                strTrim = str.substring(0, iIndexOf).trim();
                String strTrim4 = str.substring(iIndexOf + 1).trim();
                if (TextUtils.isEmpty(strTrim4)) {
                    length = -1;
                } else {
                    String lowerCase = strTrim4.toLowerCase();
                    if (lowerCase.endsWith(":true")) {
                        length = strTrim4.length() - 5;
                    } else if (lowerCase.endsWith(":false")) {
                        length = strTrim4.length() - 6;
                    } else {
                        length = -1;
                    }
                }
                if (length >= 0) {
                    String strTrim5 = strTrim4.substring(0, length).trim();
                    strE2 = strTrim5.isEmpty() ? "asset:supporter.png" : e(strTrim5);
                    String strTrim6 = strTrim4.substring(length + 1).trim();
                    if (!TextUtils.isEmpty(strTrim6)) {
                        if ("true".equalsIgnoreCase(strTrim6)) {
                            bool = Boolean.TRUE;
                            strE = strE2;
                            z = false;
                        } else if ("false".equalsIgnoreCase(strTrim6)) {
                            bool = Boolean.FALSE;
                            strE = strE2;
                            z = false;
                        }
                    }
                    z = false;
                    strTrim2 = strTrim;
                    strTrim = strTrim2;
                    strE = strE2;
                    bool = null;
                } else if (strTrim4.isEmpty()) {
                    strE = "asset:supporter.png";
                    bool = null;
                } else {
                    strE = e(strTrim4);
                    bool = null;
                    z = false;
                }
            } else {
                strTrim = str.trim();
                strE = "asset:supporter.png";
                bool = null;
            }
        }
        if (strTrim.isEmpty()) {
            return null;
        }
        return new d0(strTrim, strE, bool != null ? bool.booleanValue() : a(strE, z), false, null);
    }

    public static String b(Object obj) {
        if (obj == null || JSONObject.NULL.equals(obj)) {
            return null;
        }
        if (obj instanceof Number) {
            return String.valueOf((long) Math.ceil(((Number) obj).doubleValue()));
        }
        String strTrim = obj.toString().trim();
        if (strTrim.isEmpty()) {
            return null;
        }
        try {
            return String.valueOf((long) Math.ceil(Double.parseDouble(strTrim)));
        } catch (NumberFormatException e2) {
            int iIndexOf = strTrim.indexOf(46);
            return iIndexOf > 0 ? strTrim.substring(0, iIndexOf) : strTrim;
        }
    }

    public static i0 g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str.trim());
            String strA = a(jSONObject.opt("usd"));
            String strB = b(jSONObject.opt("ruble"));
            if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strB)) {
                return new i0(strA, strB);
            }
            return null;
        } catch (Throwable th) {
            th.getMessage();
            ArrayList arrayList = p2.a;
            return null;
        }
    }

    public static void c(String str) {
        b.remove(str);
        ArrayList arrayList = new ArrayList(c.keySet());
        int size = arrayList.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList.get(i2);
            i2++;
            String str2 = (String) obj;
            if (str2.startsWith(str + "|")) {
                c.remove(str2);
            }
        }
    }

    public static void c(File file) {
        try {
            a(file);
            if (!file.exists()) {
                new FileOutputStream(file).close();
            }
            file.setLastModified(System.currentTimeMillis());
        } catch (IOException e2) {
        }
    }

    public static void b(final Activity activity, Fragment fragment, d0 d0Var, String str) {
        if (a(activity)) {
            try {
                WindowManager windowManager = activity.getWindowManager();
                View decorView = activity.getWindow() != null ? activity.getWindow().getDecorView() : null;
                if (windowManager != null && decorView != null && decorView.getWindowToken() != null) {
                    Map map = j;
                    FrameLayout frameLayout = (FrameLayout) map.remove(activity);
                    if (frameLayout != null) {
                        b(activity, frameLayout);
                    }
                    final FrameLayout frameLayout2 = new FrameLayout(activity);
                    frameLayout2.setTag("ttmod_badge_bulletin_overlay");
                    int dimensionPixelSize = 0;
                    frameLayout2.setClipChildren(false);
                    frameLayout2.setClipToPadding(false);
                    frameLayout2.setClickable(false);
                    frameLayout2.setFocusable(false);
                    final FrameLayout frameLayoutA = a(activity, fragment, d0Var, str);
                    frameLayoutA.setTag("ttmod_badge_bulletin");
                    frameLayoutA.setTranslationY((int) TypedValue.applyDimension(1, 100.0f, activity.getResources().getDisplayMetrics()));
                    frameLayoutA.setAlpha(0.0f);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
                    layoutParams.gravity = 80;
                    layoutParams.setMargins((int) TypedValue.applyDimension(1, 8.0f, activity.getResources().getDisplayMetrics()), 0, (int) TypedValue.applyDimension(1, 8.0f, activity.getResources().getDisplayMetrics()), 0);
                    frameLayout2.addView(frameLayoutA, layoutParams);
                    WindowManager.LayoutParams layoutParams2 = new WindowManager.LayoutParams(-1, -2, 1003, 40, -3);
                    layoutParams2.gravity = 8388691;
                    layoutParams2.token = decorView.getWindowToken();
                    int identifier = activity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
                    if (identifier > 0) {
                        dimensionPixelSize = activity.getResources().getDimensionPixelSize(identifier);
                    }
                    layoutParams2.y = dimensionPixelSize + ((int) TypedValue.applyDimension(1, 36.0f, activity.getResources().getDisplayMetrics()));
                    windowManager.addView(frameLayout2, layoutParams2);
                    map.put(activity, frameLayout2);
                    frameLayoutA.animate().translationY(0.0f).alpha(1.0f).setDuration(300L).start();
                    a(frameLayoutA, new q(a(frameLayoutA.getContext(), 6.0f), frameLayoutA, a(frameLayoutA.getContext(), 28.0f), activity, frameLayout2));
                    frameLayoutA.postDelayed(new Runnable() {
                        @Override
                        public final void run() {
                            k0.a(activity, frameLayout2, frameLayoutA);
                        }
                    }, 2500L);
                }
            } catch (Throwable th) {
                th.getMessage();
                ArrayList arrayList = p2.a;
            }
        }
    }

    public static void c(Context context) {
        File file = new File(a(context), "supporters_cache.txt");
        File file2 = new File(a(context), "supporters_fetch.stamp");
        if (a(file, file2, 1200000L)) {
            c(file2);
            try {
                byte[] bArrB = b("https://tiktokyou.yzewe.ru/api/v1/badges");
                String str = bArrB == null ? null : new String(bArrB, StandardCharsets.UTF_8);
                if (!TextUtils.isEmpty(str)) {
                    LinkedHashMap linkedHashMapH = h(str);
                    b(str, file);
                    ConcurrentHashMap concurrentHashMap = a;
                    concurrentHashMap.clear();
                    if (!linkedHashMapH.isEmpty()) {
                        concurrentHashMap.putAll(linkedHashMapH);
                    }
                    e(context);
                    linkedHashMapH.size();
                    ArrayList arrayList = p2.a;
                    return;
                }
                throw new IOException("Empty supporters list");
            } catch (Throwable th) {
                th.getMessage();
                ArrayList arrayList2 = p2.a;
            }
        }
    }

    public static int h(Context context) {
        r2 r2VarA = r2.a();
        if (r2VarA == null || !r2VarA.d() || r2VarA.j != 0) {
            return -185258;
        }
        try {
            int identifier = context.getResources().getIdentifier("system_accent3_400", "color", "android");
            if (identifier != 0) {
                return context.getResources().getColor(identifier, null);
            }
        } catch (Throwable th) {
        }
        Context contextB = p2.b();
        if (contextB == null) {
            return -16524603;
        }
        return k5.a(contextB);
    }

    public static String a(Object obj) {
        if (obj == null || JSONObject.NULL.equals(obj)) {
            return null;
        }
        if (obj instanceof Number) {
            double dDoubleValue = ((Number) obj).doubleValue();
            long jRound = Math.round(dDoubleValue);
            if (Math.abs(dDoubleValue - jRound) < 1.0E-6d) {
                return String.valueOf(jRound);
            }
            String strSubstring = String.format(Locale.US, "%.2f", Double.valueOf(dDoubleValue));
            while (strSubstring.endsWith("0")) {
                strSubstring = strSubstring.substring(0, strSubstring.length() - 1);
            }
            return strSubstring.endsWith(".") ? strSubstring.substring(0, strSubstring.length() - 1) : strSubstring;
        }
        String strTrim = obj.toString().trim();
        if (strTrim.isEmpty()) {
            return null;
        }
        return strTrim;
    }

    public static d0 a(JSONObject jSONObject) {
        String strOptString;
        String strE;
        String strTrim;
        String strTrim2 = jSONObject.optString("uid", "").trim();
        Boolean boolValueOf = null;
        if (strTrim2.isEmpty()) {
            return null;
        }
        boolean zOptBoolean = jSONObject.optBoolean("isDeveloper", false);
        if (jSONObject.has("badgeUrl") && !jSONObject.isNull("badgeUrl")) {
            strOptString = jSONObject.optString("badgeUrl", "");
        } else {
            strOptString = "";
        }
        String strTrim3 = TextUtils.isEmpty(strOptString) ? "" : strOptString.trim();
        if (strTrim3.isEmpty()) {
            strE = zOptBoolean ? "asset:developer.png" : "asset:supporter.png";
        } else if ("supporter".equalsIgnoreCase(strTrim3)) {
            strE = "asset:supporter.png";
        } else if ("developer".equalsIgnoreCase(strTrim3)) {
            strE = "asset:developer.png";
        } else {
            strE = e(strTrim3);
        }
        if (jSONObject.has("tinted") && !jSONObject.isNull("tinted")) {
            boolValueOf = Boolean.valueOf(jSONObject.optBoolean("tinted"));
        }
        if (jSONObject.has("text") && !jSONObject.isNull("text")) {
            strTrim = jSONObject.optString("text", "").trim();
        } else {
            strTrim = "";
        }
        Boolean bool = boolValueOf;
        return new d0(strTrim2, strE, bool != null ? bool.booleanValue() : a(strE, TextUtils.isEmpty(strOptString)), zOptBoolean, strTrim);
    }

    public static void b(final Activity activity, final Fragment fragment, final d0 d0Var) {
        if (a(activity)) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public final void run() {
                    k0.a(activity, fragment, d0Var);
                }
            });
        }
    }

    public static Bitmap b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                InputStream inputStreamOpen = context.getAssets().open("mod_icons/" + str + ".png");
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                    return bitmapDecodeStream;
                } catch (Throwable th) {
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (IOException e2) {
            }
        }
        return null;
    }

    public static boolean a(String str, boolean z) {
        String strE = e(str);
        if (!z && !TextUtils.equals(strE, "asset:supporter.png") && !TextUtils.equals(strE, "asset:developer.png")) {
            int iLastIndexOf = strE.lastIndexOf(47);
            if (iLastIndexOf >= 0) {
                strE = strE.substring(iLastIndexOf + 1);
            }
            if (strE.startsWith("asset:")) {
                strE = strE.substring(6);
            }
            int iLastIndexOf2 = strE.lastIndexOf(46);
            if (iLastIndexOf2 > 0) {
                strE = strE.substring(0, iLastIndexOf2);
            }
            if (!"hz".equalsIgnoreCase(strE) && !"designer".equalsIgnoreCase(strE) && !"dev".equalsIgnoreCase(strE) && !"supporter".equalsIgnoreCase(strE) && !"developer".equalsIgnoreCase(strE)) {
                return false;
            }
        }
        return true;
    }

    public static void b(Activity activity, FrameLayout frameLayout) {
        WindowManager windowManager;
        j.remove(activity);
        if (frameLayout == null) {
            return;
        }
        if (activity != null) {
            try {
                windowManager = activity.getWindowManager();
            } catch (Throwable th) {
            }
        } else {
            windowManager = null;
        }
        if (windowManager != null) {
            windowManager.removeViewImmediate(frameLayout);
            return;
        }
        try {
            ViewParent parent = frameLayout.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(frameLayout);
            }
        } catch (Throwable th2) {
        }
    }

    public static void a(g0 g0Var, String str) {
        try {
            XposedBridge.hookAllMethods(Class.forName(str), "getName", new y(g0Var, str));
        } catch (Throwable th) {
            th.getMessage();
            ArrayList arrayList = p2.a;
        }
    }

    public static byte[] b(String str) throws Throwable {
        Throwable th;
        HttpURLConnection httpURLConnection;
        try {
            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
            try {
                httpURLConnection.setConnectTimeout(8000);
                httpURLConnection.setReadTimeout(8000);
                httpURLConnection.setInstanceFollowRedirects(true);
                httpURLConnection.setRequestProperty("User-Agent", "TTMod-BadgeHooks/1.0");
                InputStream inputStream = httpURLConnection.getInputStream();
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[8192];
                        while (true) {
                            int i2 = inputStream.read(bArr);
                            if (i2 != -1) {
                                byteArrayOutputStream.write(bArr, 0, i2);
                            } else {
                                byte[] byteArray = byteArrayOutputStream.toByteArray();
                                byteArrayOutputStream.close();
                                inputStream.close();
                                httpURLConnection.disconnect();
                                return byteArray;
                            }
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (Throwable th2) {
                                    th.addSuppressed(th2);
                                }
                            }
                            throw th;
                        }
                    } catch (Throwable th3) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                    }
                } catch (Throwable th5) {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    throw th5;
                }
            } catch (Throwable th6) {
                th = th6;
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th;
            }
        } catch (Throwable th7) {
            th = th7;
            httpURLConnection = null;
        }
    }

    public static boolean a(TextView textView, MotionEvent motionEvent) {
        Spanned spanned;
        c0 c0Var;
        Activity activity;
        Fragment fragment;
        String str;
        CharSequence text = textView.getText();
        String str2 = null;
        if (text instanceof Spanned) {
            spanned = (Spanned) text;
            c0[] c0VarArr = (c0[]) spanned.getSpans(0, spanned.length(), c0.class);
            if (c0VarArr == null || c0VarArr.length == 0) {
                spanned = null;
            }
        } else {
            spanned = null;
        }
        Map map = i;
        e0 e0Var = (e0) map.get(textView);
        int actionMasked = motionEvent.getActionMasked();
        switch (actionMasked) {
            case 0:
            case 1:
            case 2:
            case 3:
                break;
            default:
                String.valueOf(actionMasked);
                break;
        }
        ArrayList arrayList = p2.a;
        if (spanned == null) {
            if (e0Var != null) {
                map.remove(textView);
                ViewParent parent = textView.getParent();
                if (parent != null) {
                    parent.requestDisallowInterceptTouchEvent(false);
                }
            }
            return false;
        }
        switch (actionMasked) {
            case 0:
                c0 c0VarA = a(textView, spanned, motionEvent);
                if (c0VarA == null) {
                    map.remove(textView);
                    ViewParent parent2 = textView.getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(false);
                    }
                    return false;
                }
                map.put(textView, new e0(c0VarA));
                ViewParent parent3 = textView.getParent();
                if (parent3 != null) {
                    parent3.requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 1:
                if (e0Var == null) {
                    return false;
                }
                c0 c0VarA2 = a(textView, spanned, motionEvent);
                if (!e0Var.b && c0VarA2 == (c0Var = e0Var.a)) {
                    d0 d0Var = c0Var.b;
                    Context context = textView.getContext();
                    while (true) {
                        if (context instanceof ContextWrapper) {
                            if (context instanceof Activity) {
                                activity = (Activity) context;
                            } else {
                                context = ((ContextWrapper) context).getBaseContext();
                            }
                        } else {
                            activity = context instanceof Activity ? (Activity) context : null;
                        }
                    }
                    try {
                        Class<?> cls = Class.forName("androidx.fragment.app.FragmentManager", false, textView.getClass().getClassLoader());
                        try {
                            Object objInvoke = cls.getMethod("findFragment", View.class).invoke(null, textView);
                            if (objInvoke instanceof Fragment) {
                                fragment = (Fragment) objInvoke;
                            } else {
                                fragment = null;
                            }
                        } catch (Throwable th) {
                            Object objInvoke2 = cls.getMethod("LJJJJL", View.class).invoke(null, textView);
                            if (objInvoke2 instanceof Fragment) {
                                fragment = (Fragment) objInvoke2;
                            } else {
                                fragment = null;
                            }
                        }
                        break;
                    } catch (Throwable th2) {
                    }
                    CharSequence text2 = textView.getText();
                    if (text2 != null) {
                        String string = text2.toString();
                        int iIndexOf = string.indexOf(" ￼");
                        if (iIndexOf < 0) {
                            iIndexOf = string.indexOf(65532);
                        }
                        if (iIndexOf < 0) {
                            iIndexOf = string.indexOf("\u2063\u2064\u2063\u2064\u2063");
                        }
                        if (iIndexOf < 0) {
                            iIndexOf = string.indexOf("\u2063\u2063\u2064");
                        }
                        if (iIndexOf > 0) {
                            string = string.substring(0, iIndexOf);
                        }
                        String strA = a((CharSequence) string);
                        if (!TextUtils.isEmpty(strA)) {
                            str2 = strA;
                        } else if (d0Var != null) {
                            str = (String) e.get(d0Var.a);
                            if (!TextUtils.isEmpty(str)) {
                                str2 = str;
                            }
                        }
                    } else if (d0Var != null && !TextUtils.isEmpty(d0Var.a)) {
                        str = (String) e.get(d0Var.a);
                        if (!TextUtils.isEmpty(str)) {
                            str2 = str;
                        }
                    }
                    ArrayList arrayList2 = p2.a;
                    if (activity != null) {
                        c(activity, fragment, d0Var, str2);
                    }
                }
                i.remove(textView);
                ViewParent parent4 = textView.getParent();
                if (parent4 != null) {
                    parent4.requestDisallowInterceptTouchEvent(false);
                }
                return true;
            case 2:
                if (e0Var == null) {
                    return false;
                }
                e0Var.b = a(textView, spanned, motionEvent) != e0Var.a;
                return true;
            case 3:
                if (e0Var == null) {
                    return false;
                }
                map.remove(textView);
                ViewParent parent5 = textView.getParent();
                if (parent5 != null) {
                    parent5.requestDisallowInterceptTouchEvent(false);
                }
                return true;
            default:
                return e0Var != null;
        }
    }

    public static String b(File file) {
        if (!file.exists()) {
            return null;
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            try {
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                try {
                    byte[] bArr = new byte[4096];
                    while (true) {
                        int i2 = fileInputStream.read(bArr);
                        if (i2 != -1) {
                            byteArrayOutputStream.write(bArr, 0, i2);
                        } else {
                            String string = byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
                            byteArrayOutputStream.close();
                            fileInputStream.close();
                            return string;
                        }
                        try {
                            fileInputStream.close();
                        } catch (Throwable th) {
                            th.addSuppressed(th);
                        }
                        throw th;
                    }
                } catch (Throwable th2) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Throwable th3) {
                        th2.addSuppressed(th3);
                    }
                    throw th2;
                }
            } catch (Throwable th4) {
                fileInputStream.close();
                throw th4;
            }
        } catch (IOException e2) {
            file.getName();
            e2.getMessage();
            ArrayList arrayList = p2.a;
            return null;
        }
    }

    public static void b(String str, File file) throws IOException {
        a(file);
        FileOutputStream fileOutputStream = new FileOutputStream(file, false);
        try {
            fileOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
            fileOutputStream.close();
        } catch (Throwable th) {
            try {
                fileOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static String b() {
        Object objInvoke;
        String str = n;
        if (!TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            Object obj = a(Class.forName("X.0eki"), "LJFF").get(null);
            if (obj != null && (objInvoke = a(obj.getClass(), "LIZ", new Class[0]).invoke(obj, null)) != null) {
                if (!Boolean.TRUE.equals(a(objInvoke.getClass(), "isLogin", new Class[0]).invoke(objInvoke, null))) {
                    return null;
                }
                Object objInvoke2 = a(objInvoke.getClass(), "getCurUserId", new Class[0]).invoke(objInvoke, null);
                if (objInvoke2 instanceof String) {
                    String str2 = (String) objInvoke2;
                    if (!j3$$ExternalSyntheticBackport0.m(str2)) {
                        n = str2.trim();
                        return n;
                    }
                }
            } else {
                return null;
            }
        } catch (Throwable th) {
            th.getMessage();
            ArrayList arrayList = p2.a;
        }
        return null;
    }

    public static c0 a(TextView textView, Spanned spanned, MotionEvent motionEvent) {
        int iWidth;
        Layout layout = textView.getLayout();
        if (layout == null) {
            return null;
        }
        float x = (motionEvent.getX() - textView.getTotalPaddingLeft()) + textView.getScrollX();
        float y = (motionEvent.getY() - textView.getTotalPaddingTop()) + textView.getScrollY();
        if (x >= 0.0f && y >= 0.0f) {
            c0[] c0VarArr = (c0[]) spanned.getSpans(0, spanned.length(), c0.class);
            if (c0VarArr != null && c0VarArr.length != 0) {
                int scaledTouchSlop = ViewConfiguration.get(textView.getContext()).getScaledTouchSlop();
                for (c0 c0Var : c0VarArr) {
                    if (c0Var != null) {
                        int spanStart = spanned.getSpanStart(c0Var);
                        int spanEnd = spanned.getSpanEnd(c0Var);
                        if (spanStart >= 0 && spanEnd > spanStart) {
                            int lineForOffset = layout.getLineForOffset(spanStart);
                            float lineTop = layout.getLineTop(lineForOffset) - scaledTouchSlop;
                            float lineBottom = layout.getLineBottom(lineForOffset) + scaledTouchSlop;
                            if (y >= lineTop && y <= lineBottom) {
                                float fMin = Math.min(layout.getPrimaryHorizontal(spanStart), layout.getPrimaryHorizontal(spanEnd));
                                float fMax = Math.max(layout.getPrimaryHorizontal(spanStart), layout.getPrimaryHorizontal(spanEnd));
                                BitmapDrawable bitmapDrawable = c0Var.a;
                                if (bitmapDrawable != null && (iWidth = bitmapDrawable.getBounds().width()) > 0) {
                                    float f2 = iWidth;
                                    if (fMax - fMin < f2) {
                                        fMax = fMin + f2;
                                    }
                                }
                                float f3 = scaledTouchSlop;
                                if (x >= fMin - f3 && x <= fMax + f3) {
                                    return c0Var;
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void a(Fragment fragment, d0 d0Var, View view) {
        Activity activity;
        Context context = view.getContext();
        while (true) {
            if (context instanceof ContextWrapper) {
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else if (!(context instanceof Activity)) {
                activity = null;
                break;
            } else {
                activity = (Activity) context;
                break;
            }
        }
        if (activity == null) {
            return;
        }
        FrameLayout frameLayout = (FrameLayout) j.get(activity);
        if (frameLayout != null) {
            b(activity, frameLayout);
        }
        b(activity, fragment, d0Var);
    }

    public static void a(View view, q qVar) {
        view.setOnTouchListener(qVar);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(viewGroup.getChildAt(i2), qVar);
            }
        }
    }

    public static void a(final Activity activity, final FrameLayout frameLayout, View view) {
        if (frameLayout == null) {
            j.remove(activity);
        } else if (frameLayout.getParent() != null && view != null && view.getParent() != null) {
            view.animate().translationY(a(view.getContext(), 100.0f)).alpha(0.0f).setDuration(220L).withEndAction(new Runnable() {
                @Override
                public final void run() {
                    k0.b(activity, frameLayout);
                }
            }).start();
        } else {
            b(activity, frameLayout);
        }
    }

    public static  void a(final Activity activity, Fragment fragment, d0 d0Var) {
        if (a(activity)) {
            try {
                Dialog dialog = (Dialog) k.remove(activity);
                if (dialog != null) {
                    try {
                        dialog.dismiss();
                    } catch (Throwable th) {
                    }
                }
                Dialog dialog2 = new Dialog(activity);
                dialog2.requestWindowFeature(1);
                dialog2.setCancelable(true);
                dialog2.setCanceledOnTouchOutside(true);
                dialog2.setContentView(a(activity, dialog2, fragment));
                dialog2.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public final void onDismiss(DialogInterface dialogInterface) {
                        k0.k.remove(activity);
                    }
                });
                Window window = dialog2.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                    window.setLayout(-1, -2);
                    window.setGravity(80);
                }
                k.put(activity, dialog2);
                dialog2.show();
            } catch (Throwable th2) {
                th2.getMessage();
                ArrayList arrayList = p2.a;
            }
        }
    }

    public static f0 a(final Activity activity, final Dialog dialog, final Fragment fragment) {
        int color;
        o2 o2VarA = o2.a();
        boolean z = activity != null && (activity.getResources().getConfiguration().uiMode & 48) == 32;
        int color2 = z ? Color.parseColor("#1E1E1E") : -1;
        int color3 = z ? -1 : Color.parseColor("#161823");
        int color4 = Color.parseColor(z ? "#A7A9B0" : "#8A8B91");
        int color5 = z ? Color.parseColor("#303030") : Color.parseColor("#EFEFF0");
        int color6 = z ? Color.parseColor("#303030") : Color.parseColor("#F3F3F4");
        r2 r2VarA = r2.a();
        if (r2VarA != null && r2VarA.d()) {
            color = k5.a();
        } else {
            color = Color.parseColor("#FE2B54");
        }
        f0 f0Var = new f0(activity);
        f0Var.setVerticalScrollBarEnabled(false);
        f0Var.setOverScrollMode(2);
        f0Var.a = Math.max(0, Math.max((int) o.a(activity, 1, 320.0f), (int) (activity.getResources().getDisplayMetrics().heightPixels * 0.85f)));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color2);
        float fA = (int) o.a(activity, 1, 24.0f);
        gradientDrawable.setCornerRadii(new float[]{fA, fA, fA, fA, 0.0f, 0.0f, 0.0f, 0.0f});
        f0Var.setBackground(gradientDrawable);
        f0Var.setClipToOutline(true);
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        int iA = (int) o.a(activity, 1, 20.0f);
        int iA2 = (int) o.a(activity, 1, 18.0f);
        int iA3 = (int) o.a(activity, 1, 20.0f);
        int identifier = activity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        linearLayout.setPadding(iA, iA2, iA3, (identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0) + ((int) o.a(activity, 1, 18.0f)));
        f0Var.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(activity);
        linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(activity);
        textView.setText(o2VarA.a("badge_sheet_header", "Подробнее"));
        textView.setTextColor(color3);
        textView.setTextSize(2, 18.0f);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView.setGravity(17);
        frameLayout.addView(textView, new FrameLayout.LayoutParams(-1, -2));
        TextView textView2 = new TextView(activity);
        textView2.setText("×");
        textView2.setTextColor(color3);
        textView2.setTextSize(2, 24.0f);
        textView2.setGravity(17);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) o.a(activity, 1, 32.0f), (int) o.a(activity, 1, 32.0f));
        layoutParams.gravity = 8388629;
        frameLayout.addView(textView2, layoutParams);
        ImageView imageView = new ImageView(activity);
        Bitmap bitmapA = a(activity, new d0("", "asset:supporter.png", true, false, null), (int) o.a(activity, 1, 52.0f));
        if (bitmapA != null) {
            imageView.setImageBitmap(bitmapA);
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = (int) o.a(activity, 1, 20.0f);
        linearLayout.addView(imageView, layoutParams2);
        TextView textView3 = new TextView(activity);
        textView3.setText(o2VarA.a("badge_sheet_title", "Поддержите разработку"));
        textView3.setTextColor(color3);
        textView3.setTextSize(2, 18.0f);
        textView3.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView3.setGravity(17);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = (int) o.a(activity, 1, 18.0f);
        linearLayout.addView(textView3, layoutParams3);
        TextView textView4 = new TextView(activity);
        textView4.setText(o2VarA.a("badge_sheet_subtitle", "Внесите вклад в развитие разработки и получите уникальный значок."));
        textView4.setTextColor(color4);
        textView4.setTextSize(2, 14.0f);
        textView4.setGravity(17);
        textView4.setLineSpacing(0.0f, 1.1f);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = (int) o.a(activity, 1, 10.0f);
        linearLayout.addView(textView4, layoutParams4);
        String strA = o2VarA.a("badge_sheet_copy_uid", "Скопировать мой UID");
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        linearLayout2.setPadding((int) o.a(activity, 1, 14.0f), 0, (int) o.a(activity, 1, 14.0f), 0);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(color5);
        gradientDrawable2.setCornerRadius((int) TypedValue.applyDimension(1, 999.0f, activity.getResources().getDisplayMetrics()));
        linearLayout2.setBackground(gradientDrawable2);
        Bitmap bitmapB = b(activity, "ic_copy");
        if (bitmapB != null) {
            ImageView imageView2 = new ImageView(activity);
            imageView2.setImageBitmap(bitmapB);
            imageView2.setColorFilter(color3, PorterDuff.Mode.SRC_IN);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams((int) o.a(activity, 1, 13.0f), (int) o.a(activity, 1, 13.0f));
            layoutParams5.rightMargin = (int) o.a(activity, 1, 8.0f);
            linearLayout2.addView(imageView2, layoutParams5);
        }
        TextView textView5 = new TextView(activity);
        textView5.setText(strA);
        textView5.setTextColor(color3);
        textView5.setTextSize(2, 15.0f);
        textView5.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView5.setGravity(17);
        linearLayout2.addView(textView5, new LinearLayout.LayoutParams(-2, -2));
        linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                k0.a(activity, view);
            }
        });
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, (int) o.a(activity, 1, 36.0f));
        layoutParams6.gravity = 1;
        layoutParams6.topMargin = (int) o.a(activity, 1, 18.0f);
        linearLayout.addView(linearLayout2, layoutParams6);
        LinearLayout linearLayout3 = new LinearLayout(activity);
        linearLayout3.setOrientation(1);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams7.topMargin = (int) o.a(activity, 1, 20.0f);
        linearLayout.addView(linearLayout3, layoutParams7);
        i0 i0Var = o != null ? o : new i0("5", "500");
        linearLayout3.addView(a(activity, "ic_coin", String.format(o2VarA.a("badge_sheet_step1_title_format", "Пожертвуйте не менее $%1$s (%2$s₽)"), i0Var.a, i0Var.b), o2VarA.a("badge_sheet_step1_subtitle", "Переведите сумму по любым из наших реквизитов"), color6, color3, color4));
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams8.topMargin = (int) o.a(activity, 1, 8.0f);
        String strA2 = o2VarA.a("badge_sheet_step2_title", "Пришлите подтверждение и ваш UID");
        String strA3 = o2VarA.a("badge_sheet_step2_contact", "@tt_u_bot");
        String str = String.format(o2VarA.a("badge_sheet_step2_subtitle", "Отправьте чек или скриншот в %s, а также ваш UID для выдачи"), strA3);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int iIndexOf = str.indexOf(strA3);
        if (iIndexOf >= 0) {
            spannableStringBuilder.setSpan(new r(activity, color), iIndexOf, strA3.length() + iIndexOf, 33);
        }
        linearLayout3.addView(a(activity, "photo", strA2, spannableStringBuilder, color6, color3, color4), layoutParams8);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams9.topMargin = (int) o.a(activity, 1, 8.0f);
        linearLayout3.addView(a(activity, "ic_mod_logo", o2VarA.a("badge_sheet_step3_title", "Получите значок"), o2VarA.a("badge_sheet_step3_subtitle", "После проверки он появится в вашем профиле и будет виден всем"), color6, color3, color4), layoutParams9);
        LinearLayout linearLayout4 = new LinearLayout(activity);
        linearLayout4.setOrientation(0);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams10.topMargin = (int) o.a(activity, 1, 28.0f);
        linearLayout.addView(linearLayout4, layoutParams10);
        String strA4 = o2VarA.a("badge_sheet_cancel", "Отмена");
        TextView textView6 = new TextView(activity);
        textView6.setText(strA4);
        textView6.setTextColor(color3);
        textView6.setTextSize(2, 17.0f);
        textView6.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView6.setGravity(17);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(color5);
        gradientDrawable3.setCornerRadius(a(activity, 999.0f));
        textView6.setBackground(gradientDrawable3);
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(0, (int) o.a(activity, 1, 48.0f));
        layoutParams11.weight = 1.0f;
        linearLayout4.addView(textView6, layoutParams11);
        String strA5 = o2VarA.a("badge_sheet_support", "Поддержать");
        TextView textView7 = new TextView(activity);
        textView7.setText(strA5);
        textView7.setTextColor(-1);
        textView7.setTextSize(2, 17.0f);
        textView7.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView7.setGravity(17);
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setColor(color);
        gradientDrawable4.setCornerRadius(a(activity, 999.0f));
        textView7.setBackground(gradientDrawable4);
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                k0.a(fragment, activity, dialog, view);
            }
        });
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(0, (int) o.a(activity, 1, 48.0f));
        layoutParams12.weight = 1.0f;
        layoutParams12.leftMargin = (int) o.a(activity, 1, 10.0f);
        linearLayout4.addView(textView7, layoutParams12);
        return f0Var;
    }

    public static  void a(Fragment fragment, Activity activity, Dialog dialog, View view) {
        if (fragment != null) {
            ArrayList arrayList = p2.a;
        }
        d(activity);
        dialog.dismiss();
    }

    public static LinearLayout a(Activity activity, String str, String str2, CharSequence charSequence, int i2, int i3, int i4) {
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(48);
        linearLayout.setPadding(a(activity, 14.0f), (int) o.a(activity, 1, 12.0f), (int) o.a(activity, 1, 14.0f), (int) o.a(activity, 1, 12.0f));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius((int) TypedValue.applyDimension(1, 10.0f, activity.getResources().getDisplayMetrics()));
        linearLayout.setBackground(gradientDrawable);
        Bitmap bitmapB = b(activity, str);
        if (bitmapB != null) {
            ImageView imageView = new ImageView(activity);
            imageView.setImageBitmap(bitmapB);
            imageView.setColorFilter(i4, PorterDuff.Mode.SRC_IN);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) o.a(activity, 1, 18.0f), (int) o.a(activity, 1, 18.0f));
            layoutParams.topMargin = (int) o.a(activity, 1, 2.0f);
            linearLayout.addView(imageView, layoutParams);
        }
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams2.leftMargin = (int) o.a(activity, 1, 12.0f);
        linearLayout.addView(linearLayout2, layoutParams2);
        TextView textView = new TextView(activity);
        textView.setText(str2);
        textView.setTextColor(i3);
        textView.setTextSize(2, 16.0f);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(activity);
        textView2.setText(charSequence);
        textView2.setTextColor(i4);
        textView2.setTextSize(2, 14.0f);
        textView2.setLineSpacing(0.0f, 1.08f);
        if (charSequence instanceof Spanned) {
            textView2.setMovementMethod(LinkMovementMethod.getInstance());
            textView2.setHighlightColor(0);
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = (int) o.a(activity, 1, 3.0f);
        linearLayout2.addView(textView2, layoutParams3);
        return linearLayout;
    }

    public static void a(Activity activity, View view) {
        String strB = b();
        o2.a();
        if (TextUtils.isEmpty(strB)) {
            Toast.makeText(activity, o2.a().a("copy_uid_unavailable"), 0).show();
            return;
        }
        ClipboardManager clipboardManager = (ClipboardManager) activity.getSystemService("clipboard");
        if (clipboardManager == null) {
            Toast.makeText(activity, o2.a().a("copy_uid_failed"), 0).show();
            return;
        }
        try {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("uid", strB));
            Toast.makeText(activity, o2.a().a("copy_uid_copied"), 0).show();
        } catch (Throwable th) {
            Toast.makeText(activity, o2.a().a("copy_uid_failed"), 0).show();
        }
    }

    public static FrameLayout a(Activity activity, final Fragment fragment, final d0 d0Var, String str) {
        String strReplace;
        boolean z = activity != null && (activity.getResources().getConfiguration().uiMode & 48) == 32;
        int color = z ? Color.parseColor("#1E1E1E") : -1;
        int color2 = z ? -1 : Color.parseColor("#161823");
        r2 r2VarA = r2.a();
        int color3 = (r2VarA == null || !r2VarA.d()) ? Color.parseColor("#FE2B54") : k5.a();
        FrameLayout frameLayout = new FrameLayout(activity);
        int iA = a(activity, 14.0f);
        int iA2 = (int) o.a(activity, 1, 12.0f);
        frameLayout.setPadding(iA, iA2, iA, iA2);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color);
        gradientDrawable.setCornerRadius((int) TypedValue.applyDimension(1, 8.0f, activity.getResources().getDisplayMetrics()));
        frameLayout.setBackground(gradientDrawable);
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(16);
        frameLayout.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        ImageView imageView = new ImageView(activity);
        Bitmap bitmapA = a(activity, d0Var, (int) o.a(activity, 1, 26.0f));
        if (bitmapA != null) {
            imageView.setImageBitmap(bitmapA);
        }
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = (int) o.a(activity, 1, 10.0f);
        layoutParams.rightMargin = (int) o.a(activity, 1, 6.0f);
        linearLayout.addView(linearLayout2, layoutParams);
        TextView textView = new TextView(activity);
        o2 o2VarA = o2.a();
        String strA = !TextUtils.isEmpty(str) ? str : o2VarA.a("badge_bulletin_unknown_name", "Этот человек");
        if (d0Var == null || TextUtils.isEmpty(d0Var.e)) {
            strReplace = (d0Var == null || !d0Var.d) ? String.format(o2VarA.a("badge_bulletin_supporter_format", "%s поддержал разработку TikTok You"), strA) : String.format(o2VarA.a("badge_bulletin_developer_format", "%s член команды разработки TikTok You"), strA);
        } else {
            strReplace = d0Var.e.replace("${1}", strA);
        }
        textView.setText(strReplace);
        textView.setTextSize(2, 14.0f);
        textView.setLineSpacing(0.0f, 1.0f);
        textView.setTextColor(color2);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(activity);
        textView2.setText(o2.a().a("badge_bulletin_button", "Подробнее"));
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 13.0f);
        textView2.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView2.setGravity(17);
        textView2.setPadding((int) TypedValue.applyDimension(1, 16.0f, activity.getResources().getDisplayMetrics()), 0, (int) o.a(activity, 1, 16.0f), 0);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(color3);
        gradientDrawable2.setCornerRadius((int) TypedValue.applyDimension(1, 68.0f, activity.getResources().getDisplayMetrics()));
        textView2.setBackground(gradientDrawable2);
        textView2.setMinHeight((int) TypedValue.applyDimension(1, 32.0f, activity.getResources().getDisplayMetrics()));
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                k0.a(fragment, d0Var, view);
            }
        });
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-2, (int) o.a(activity, 1, 32.0f)));
        return frameLayout;
    }

    public static Bitmap a(Context context, d0 d0Var, int i2) {
        Bitmap bitmapCreateScaledBitmap;
        b0 b0VarA = a(context, d0Var);
        if (b0VarA == null || b0VarA.b == null) {
            return null;
        }
        int iMax = Math.max(1, i2);
        String str = b0VarA.a + "::bulletin::" + iMax;
        ConcurrentHashMap concurrentHashMap = c;
        Bitmap bitmap = (Bitmap) concurrentHashMap.get(str);
        if (a(bitmap)) {
            return bitmap;
        }
        Bitmap bitmap2 = b0VarA.b;
        if (!a(bitmap2)) {
            return null;
        }
        int iMax2 = Math.max(1, Math.round((iMax / bitmap2.getHeight()) * bitmap2.getWidth()));
        if (a(bitmap2)) {
            try {
                bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, Math.max(1, iMax2), Math.max(1, iMax), true);
            } catch (Throwable th) {
                th.getMessage();
                ArrayList arrayList = p2.a;
                bitmapCreateScaledBitmap = null;
            }
        } else {
            bitmapCreateScaledBitmap = null;
        }
        if (!a(bitmapCreateScaledBitmap)) {
            return null;
        }
        Bitmap bitmapA = (d0Var == null || !d0Var.c) ? bitmapCreateScaledBitmap : a(bitmapCreateScaledBitmap, h(context));
        if (a(bitmapA)) {
            bitmapCreateScaledBitmap = bitmapA;
        }
        concurrentHashMap.put(str, bitmapCreateScaledBitmap);
        return bitmapCreateScaledBitmap;
    }

    public static int a(Context context, float f2) {
        return (int) TypedValue.applyDimension(1, f2, context.getResources().getDisplayMetrics());
    }

    public static boolean a(Activity activity) {
        return (activity == null || activity.isFinishing() || activity.isDestroyed()) ? false : true;
    }

    public static String a(String str, String str2) {
        d0 d0VarI;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (d0VarI = i(str)) == null || a(str2)) {
            return str2;
        }
        a(str2, d0VarI);
        return str2 + ("\u2063\u2063\u2064" + a(d0VarI) + "\u2064\u2063\u2063");
    }

    public static CharSequence a(TextView textView, CharSequence charSequence) {
        boolean zA;
        d0 d0Var;
        int i2;
        int iIndexOf;
        int i3;
        Bitmap bitmapA;
        CharSequence charSequence2 = charSequence;
        if (charSequence2 == null) {
            return null;
        }
        int i4 = 0;
        if (charSequence2 instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence2;
            c0[] c0VarArr = (c0[]) spanned.getSpans(0, spanned.length(), c0.class);
            if (c0VarArr != null && c0VarArr.length != 0) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(spanned);
                boolean z = false;
                for (c0 c0Var : c0VarArr) {
                    if (c0Var != null) {
                        int spanStart = spannableStringBuilder.getSpanStart(c0Var);
                        int spanEnd = spannableStringBuilder.getSpanEnd(c0Var);
                        int spanFlags = spannableStringBuilder.getSpanFlags(c0Var);
                        if (spanStart >= 0 && spanEnd > spanStart && (bitmapA = a(textView.getContext(), textView, c0Var.b)) != null) {
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(textView.getResources(), bitmapA);
                            bitmapDrawable.setBounds(0, 0, bitmapA.getWidth(), bitmapA.getHeight());
                            spannableStringBuilder.removeSpan(c0Var);
                            spannableStringBuilder.setSpan(new c0(bitmapDrawable, c0Var.b), spanStart, spanEnd, spanFlags);
                            z = true;
                        }
                    }
                }
                if (z) {
                    spanned = spannableStringBuilder;
                }
            }
            if (spanned != charSequence2) {
                charSequence2 = spanned;
            }
        }
        if (charSequence2 instanceof Spanned) {
            Spanned spanned2 = (Spanned) charSequence2;
            c0[] c0VarArr2 = (c0[]) spanned2.getSpans(0, spanned2.length(), c0.class);
            if (c0VarArr2 == null || c0VarArr2.length <= 0) {
                zA = a(charSequence2.toString());
            } else {
                zA = true;
            }
        } else {
            zA = a(charSequence2.toString());
        }
        if (!zA) {
            String strA = a(charSequence2);
            d0 d0Var2 = strA.isEmpty() ? null : (d0) d.get(strA);
            if (d0Var2 != null) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(charSequence2);
                spannableStringBuilder2.append((CharSequence) ("\u2063\u2063\u2064" + a(d0Var2) + "\u2064\u2063\u2063"));
                charSequence2 = spannableStringBuilder2;
            }
        }
        String string = charSequence2.toString();
        if (string.contains("\u2063\u2064\u2063\u2064\u2063") || string.contains("\u2063\u2063\u2064")) {
            SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(charSequence2);
            int length = 0;
            boolean z2 = false;
            while (true) {
                String string2 = spannableStringBuilder3.toString();
                int iIndexOf2 = string2.indexOf("\u2063\u2063\u2064", length);
                if (iIndexOf2 < 0 || (iIndexOf = string2.indexOf("\u2064\u2063\u2063", (i2 = iIndexOf2 + 3))) < 0) {
                    break;
                }
                String strSubstring = string2.substring(i2, iIndexOf);
                d0 d0Var3 = TextUtils.isEmpty(strSubstring) ? null : (d0) g.get(strSubstring);
                if (d0Var3 == null) {
                    d0Var3 = new d0("", "asset:supporter.png", true, false, null);
                }
                int i5 = iIndexOf + 3;
                Bitmap bitmapA2 = a(textView.getContext(), textView, d0Var3);
                String str = bitmapA2 == null ? "" : " ￼";
                spannableStringBuilder3.replace(iIndexOf2, i5, (CharSequence) str);
                if (bitmapA2 == null) {
                    i3 = 0;
                } else {
                    BitmapDrawable bitmapDrawable2 = new BitmapDrawable(textView.getResources(), bitmapA2);
                    i3 = 0;
                    bitmapDrawable2.setBounds(0, 0, bitmapA2.getWidth(), bitmapA2.getHeight());
                    spannableStringBuilder3.setSpan(new c0(bitmapDrawable2, d0Var3), iIndexOf2 + 1, iIndexOf2 + 2, 33);
                }
                length = iIndexOf2 + str.length();
                z2 = true;
                i4 = i3;
            }
            if (spannableStringBuilder3.toString().contains("\u2063\u2064\u2063\u2064\u2063")) {
                String strA2 = a((CharSequence) spannableStringBuilder3);
                d0 d0Var4 = strA2.isEmpty() ? null : (d0) d.get(strA2);
                if (d0Var4 != null) {
                    d0Var = d0Var4;
                } else {
                    d0Var = new d0("", "asset:supporter.png", true, false, null);
                }
                Bitmap bitmapA3 = a(textView.getContext(), textView, d0Var);
                int length2 = i4;
                while (true) {
                    int iIndexOf3 = spannableStringBuilder3.toString().indexOf("\u2063\u2064\u2063\u2064\u2063", length2);
                    if (iIndexOf3 < 0) {
                        break;
                    }
                    int i6 = iIndexOf3 + 5;
                    String str2 = bitmapA3 != null ? " ￼" : "";
                    spannableStringBuilder3.replace(iIndexOf3, i6, (CharSequence) str2);
                    if (bitmapA3 != null) {
                        BitmapDrawable bitmapDrawable3 = new BitmapDrawable(textView.getResources(), bitmapA3);
                        bitmapDrawable3.setBounds(i4, i4, bitmapA3.getWidth(), bitmapA3.getHeight());
                        spannableStringBuilder3.setSpan(new c0(bitmapDrawable3, d0Var), iIndexOf3 + 1, iIndexOf3 + 2, 33);
                    }
                    length2 = iIndexOf3 + str2.length();
                    i4 = 0;
                }
            }
            if (z2 || spannableStringBuilder3 != charSequence2) {
                return spannableStringBuilder3;
            }
        }
        return charSequence2;
    }

    public static void a(String str, d0 d0Var) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strA = a((CharSequence) str);
        if (strA.isEmpty()) {
            return;
        }
        d.put(strA, d0Var);
        if (!TextUtils.isEmpty(d0Var.a)) {
            e.put(d0Var.a, strA);
        }
        a(d0Var);
    }

    public static String a(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence.toString().replace("\u2063\u2064\u2063\u2064\u2063", "").replace("\u2063\u2063\u2064", "").replace("\u2064\u2063\u2063", "").replace(String.valueOf((char) 8203), "").replace(String.valueOf((char) 8204), "").replace(" ￼", "").replace("￼", "").replace((char) 160, ' ').trim();
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("\u2063\u2064\u2063\u2064\u2063") || str.contains("\u2063\u2063\u2064") || str.contains(" ￼") || str.indexOf(65532) >= 0;
    }

    public static Bitmap a(Context context, TextView textView, d0 d0Var) {
        Bitmap bitmapCreateScaledBitmap;
        b0 b0VarA = a(context, d0Var);
        if (b0VarA == null || b0VarA.b == null) {
            return null;
        }
        int iMax = Math.max(1, Math.round(textView.getLineHeight() * 1.1f));
        String str = b0VarA.a + "::" + iMax;
        ConcurrentHashMap concurrentHashMap = c;
        Bitmap bitmap = (Bitmap) concurrentHashMap.get(str);
        if (a(bitmap)) {
            return bitmap;
        }
        Bitmap bitmap2 = b0VarA.b;
        if (!a(bitmap2)) {
            return null;
        }
        int iMax2 = Math.max(1, Math.round((iMax / bitmap2.getHeight()) * bitmap2.getWidth()));
        if (a(bitmap2)) {
            try {
                bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, Math.max(1, iMax2), Math.max(1, iMax), true);
            } catch (Throwable th) {
                th.getMessage();
                ArrayList arrayList = p2.a;
                bitmapCreateScaledBitmap = null;
            }
        } else {
            bitmapCreateScaledBitmap = null;
        }
        if (!a(bitmapCreateScaledBitmap)) {
            return null;
        }
        Bitmap bitmapA = (d0Var == null || !d0Var.c) ? bitmapCreateScaledBitmap : a(bitmapCreateScaledBitmap, h(context));
        if (a(bitmapA)) {
            bitmapCreateScaledBitmap = bitmapA;
        }
        concurrentHashMap.put(str, bitmapCreateScaledBitmap);
        return bitmapCreateScaledBitmap;
    }

    public static Bitmap a(Bitmap bitmap, int i2) {
        if (!a(bitmap)) {
            return null;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint(3);
            boolean z = k5.c;
            k5.c = false;
            try {
                paint.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_IN));
                k5.c = z;
                try {
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                    return bitmapCreateBitmap;
                } catch (Throwable th) {
                    th.getMessage();
                    ArrayList arrayList = p2.a;
                    return null;
                }
            } catch (Throwable th2) {
                k5.c = z;
                throw th2;
            }
        } catch (Throwable th3) {
            th3.getMessage();
            ArrayList arrayList2 = p2.a;
            return null;
        }
    }

    public static boolean a(Bitmap bitmap) {
        if (bitmap == null) {
            return false;
        }
        try {
            return !bitmap.isRecycled() && bitmap.getWidth() > 0 && bitmap.getHeight() > 0;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean a(BitmapDrawable bitmapDrawable) {
        if (bitmapDrawable == null) {
            return false;
        }
        return a(bitmapDrawable.getBitmap());
    }

    public static Bitmap a(Context context, String str) {
        String strSubstring;
        String strE = e(str);
        ConcurrentHashMap concurrentHashMap = b;
        Bitmap bitmap = (Bitmap) concurrentHashMap.get(strE);
        if (a(bitmap)) {
            return bitmap;
        }
        synchronized (k0.class) {
            Bitmap bitmap2 = (Bitmap) concurrentHashMap.get(strE);
            if (a(bitmap2)) {
                return bitmap2;
            }
            if (strE.startsWith("asset:")) {
                strSubstring = strE.substring(6);
            } else {
                strSubstring = "supporter.png";
            }
            try {
                InputStream inputStreamOpen = context.getAssets().open(strSubstring);
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                    if (bitmapDecodeStream != null) {
                        concurrentHashMap.put(strE, bitmapDecodeStream);
                    }
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                    return bitmapDecodeStream;
                } catch (Throwable th) {
                    if (inputStreamOpen != null) {
                        try {
                            inputStreamOpen.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                    }
                    throw th;
                }
            } catch (IOException e2) {
                e2.getMessage();
                ArrayList arrayList = p2.a;
                return null;
            }
        }
    }

    public static void a(String str, File file) {
        try {
            byte[] bArrB = b(str);
            if (bArrB != null && bArrB.length != 0) {
                a(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                try {
                    fileOutputStream.write(bArrB);
                    fileOutputStream.close();
                    c(str);
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrB, 0, bArrB.length);
                    if (bitmapDecodeByteArray != null) {
                        b.put(str, bitmapDecodeByteArray);
                    }
                    f.remove(str);
                    return;
                } catch (Throwable th) {
                    try {
                        fileOutputStream.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                    throw th;
                }
            }
            throw new IOException("Empty badge data");
        } catch (Throwable th3) {
            try {
                th3.getMessage();
                ArrayList arrayList = p2.a;
            } finally {
                f.remove(str);
            }
        }
    }

    public static boolean a(File file, File file2, long j2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (!file.exists() || jCurrentTimeMillis - file.lastModified() >= j2) {
            return !file2.exists() || jCurrentTimeMillis - file2.lastModified() >= 1200000;
        }
        return false;
    }

    public static void a(File file) throws IOException {
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
            throw new IOException("Failed to create " + parentFile.getAbsolutePath());
        }
    }

    public static File a(Context context) {
        return new File(context.getCacheDir() != null ? context.getCacheDir() : context.getFilesDir(), "ttmod_badges");
    }

    public static String a(IMConversation iMConversation) {
        List<String> memberIdList;
        if (iMConversation == null || (memberIdList = iMConversation.getMemberIdList()) == null || memberIdList.isEmpty()) {
            return null;
        }
        String strB = b();
        String str = null;
        for (String str2 : memberIdList) {
            if (!TextUtils.isEmpty(str2)) {
                String strTrim = str2.trim();
                if (!strTrim.isEmpty() && (TextUtils.isEmpty(strB) || !TextUtils.equals(strB, strTrim))) {
                    if (str == null) {
                        str = strTrim;
                    } else if (!TextUtils.equals(str, strTrim)) {
                        return null;
                    }
                }
            }
        }
        return str;
    }

    public static Field a(Class cls, String str) throws NoSuchFieldException {
        for (Class superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (NoSuchFieldException e2) {
            }
        }
        throw new NoSuchFieldException(cls.getName() + "#" + str);
    }

    public static Method a(Class cls, String str, Class... clsArr) throws NoSuchMethodException {
        for (Class superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException e2) {
            }
        }
        throw new NoSuchMethodException(cls.getName() + "#" + str);
    }

    public static b0 a(Context context, d0 d0Var) {
        d0 d0Var2;
        if (d0Var != null) {
            d0Var2 = new d0(d0Var.a, d0Var.b, d0Var.c, d0Var.d, d0Var.e);
        } else {
            d0Var2 = new d0("", "asset:supporter.png", true, false, null);
        }
        String str = d0Var2.b;
        ConcurrentHashMap concurrentHashMap = b;
        Bitmap bitmap = (Bitmap) concurrentHashMap.get(str);
        if (a(bitmap)) {
            return new b0(d0Var2.b + "|" + d0Var2.c + "|" + d0Var2.d, bitmap);
        }
        if (d(str)) {
            Bitmap bitmap2 = (Bitmap) concurrentHashMap.get(str);
            if (!a(bitmap2)) {
                File file = new File(new File(a(context), "images"), j(str) + ".img");
                File file2 = new File(new File(a(context), "images"), j(str) + ".stamp");
                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
                if (bitmapDecodeFile != null) {
                    concurrentHashMap.put(str, bitmapDecodeFile);
                    if (a(file, file2, 7200000L)) {
                        c(context, str);
                    }
                    bitmap2 = bitmapDecodeFile;
                } else {
                    c(context, str);
                    bitmap2 = null;
                }
            }
            if (bitmap2 != null) {
                return new b0(d0Var2.b + "|" + d0Var2.c + "|" + d0Var2.d, bitmap2);
            }
            Bitmap bitmapA = a(context, "asset:supporter.png");
            boolean z = d0Var2.c;
            boolean z2 = d0Var2.d;
            String str2 = d0Var2.e;
            String strE = e("asset:supporter.png");
            TextUtils.isEmpty(str2);
            if (bitmapA != null) {
                return new b0(strE + "|" + z + "|" + z2, bitmapA);
            }
            return null;
        }
        Bitmap bitmapA2 = a(context, str);
        if (bitmapA2 != null) {
            return new b0(d0Var2.b + "|" + d0Var2.c + "|" + d0Var2.d, bitmapA2);
        }
        return null;
    }

    public static String a(d0 d0Var) {
        String str = d0Var.e;
        if (str == null) {
            str = "";
        }
        String str2 = d0Var.a + "|" + d0Var.b + "|" + d0Var.c + "|" + d0Var.d + "|" + str;
        ConcurrentHashMap concurrentHashMap = h;
        String str3 = (String) concurrentHashMap.get(str2);
        if (str3 != null) {
            return str3;
        }
        synchronized (k0.class) {
            String str4 = (String) concurrentHashMap.get(str2);
            if (str4 != null) {
                return str4;
            }
            int andIncrement = l.getAndIncrement();
            StringBuilder sb = new StringBuilder(16);
            for (int i2 = 15; i2 >= 0; i2--) {
                sb.append(((andIncrement >> i2) & 1) == 0 ? (char) 8203 : (char) 8204);
            }
            String string = sb.toString();
            h.put(str2, string);
            g.put(string, d0Var);
            return string;
        }
    }
}
