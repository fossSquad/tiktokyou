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
import com.ss.android.ugc.profile.business.ur.ProfileNavbarNickNameProtocol;
import com.ss.android.ugc.profile.business.ur.ProfileNavbarOtherNicknameProtocol;
import com.ss.android.ugc.profile.business.ur.nickname.ProfileInfoNicknameProtocol;
import com.ss.android.ugc.profile.business.ur.nickname.ProfileInfoOtherNicknameProtocol;
import com.ss.android.ugc.profile.platform.base.data.Describe;
import com.ss.android.ugc.profile.platform.base.data.UserProfileInfo;
import com.windukk.hook.HookBridge;
import com.windukk.hook.HookMethod;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
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
import java.util.WeakHashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Supplier;
import org.json.JSONArray;
import org.json.JSONObject;

public abstract class t0 {
    public static volatile String q;
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
    public static final AtomicBoolean n = new AtomicBoolean(false);
    public static final ThreadLocal o = new ThreadLocal();
    public static final ThreadLocal p = ThreadLocal.withInitial(new Supplier() {
        @Override
        public final Object get() {
            return t0.e();
        }
    });
    public static volatile s0 r = new s0("5", "500");

    public static void a(Context context) {
        if (context == null || !n.compareAndSet(false, true)) {
            return;
        }
        String str = null;
        if (!TextUtils.isEmpty("ttmod_badges/supporters_fallback.json")) {
            try {
                InputStream inputStreamOpen = context.getAssets().open("ttmod_badges/supporters_fallback.json");
                try {
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    try {
                        byte[] bArr = new byte[4096];
                        while (true) {
                            int i2 = inputStreamOpen.read(bArr);
                            if (i2 == -1) {
                                break;
                            } else {
                                byteArrayOutputStream.write(bArr, 0, i2);
                            }
                            if (inputStreamOpen != null) {
                                try {
                                    inputStreamOpen.close();
                                } catch (Throwable th) {
                                    th.addSuppressed(th);
                                }
                            }
                            throw th;
                        }
                        String string = byteArrayOutputStream.toString(StandardCharsets.UTF_8.name());
                        byteArrayOutputStream.close();
                        inputStreamOpen.close();
                        str = string;
                    } catch (Throwable th2) {
                        try {
                            byteArrayOutputStream.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                        throw th2;
                    }
                } catch (Throwable th4) {
                    if (inputStreamOpen != null) {
                        inputStreamOpen.close();
                    }
                    throw th4;
                }
            } catch (IOException e2) {
            } catch (Throwable th5) {
                th5.getMessage();
                int i3 = v3.a;
            }
        }
        if (!TextUtils.isEmpty(str)) {
            LinkedHashMap linkedHashMapF = f(str);
            if (!linkedHashMapF.isEmpty()) {
                ConcurrentHashMap concurrentHashMap = a;
                concurrentHashMap.clear();
                if (!linkedHashMapF.isEmpty()) {
                    concurrentHashMap.putAll(linkedHashMapF);
                }
                f(context);
                linkedHashMapF.size();
                int i4 = v3.a;
            }
        }
        String strB = b(new File(b(context), "supporters_cache.txt"));
        if (!TextUtils.isEmpty(strB)) {
            LinkedHashMap linkedHashMapF2 = f(strB);
            if (!linkedHashMapF2.isEmpty()) {
                ConcurrentHashMap concurrentHashMap2 = a;
                concurrentHashMap2.clear();
                if (!linkedHashMapF2.isEmpty()) {
                    concurrentHashMap2.putAll(linkedHashMapF2);
                }
                f(context);
                linkedHashMapF2.size();
                int i5 = v3.a;
            }
        }
        h(context);
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

    public static void c(Context context) {
        try {
            byte[] bArrA = a("https://tiktokyou.yzewe.ru/api/v1/price");
            String str = bArrA == null ? null : new String(bArrA, StandardCharsets.UTF_8);
            s0 s0VarE = e(str);
            if (s0VarE == null) {
                throw new IOException("Invalid support price");
            }
            r = s0VarE;
            b(str, new File(b(context), "support_price_cache.json"));
            int i2 = v3.a;
        } catch (Throwable th) {
            th.getMessage();
            int i3 = v3.a;
        }
    }

    public static void d() {
        try {
            Context contextC = v3.c();
            a(contextC);
            if (contextC != null) {
                s0 s0VarE = e(b(new File(b(contextC), "support_price_cache.json")));
                if (s0VarE != null) {
                    r = s0VarE;
                }
                g(contextC);
            }
            c();
            b();
            i0 i0Var = new i0();
            HookBridge.hookAllMethods(BaseContact.class, "getNickName", i0Var);
            HookBridge.hookAllMethods(BaseContact.class, "getDisplayName", i0Var);
            a();
            p pVar = new p();
            HookBridge.hookAllMethods(IMConversation.class, "getConversationName", pVar);
            HookBridge.hookAllMethods(IMConversation.class, "getDisplayName", pVar);
            HookBridge.hookAllMethods(IMConversation.class, "getNickName", pVar);
            HookBridge.hookAllMethods(VideoAuthorInfoVM.class, "ez2", new q());
            try {
                HookBridge.hookAllConstructors(FriendsV3RepostModel.class, new r());
            } catch (Throwable th) {
                th.getMessage();
                int i2 = v3.a;
            }
            a(p0.a, "X.0Ssn");
            p0 p0Var = p0.b;
            a(p0Var, "X.0Ssp");
            a(p0Var, "X.0Ssj");
            try {
                HookBridge.hookAllMethods(IMFriendsServiceImpl.class, "LIZIZ", new t());
            } catch (Throwable th2) {
                th2.getMessage();
                int i3 = v3.a;
            }
            try {
                Class<?> cls = Class.forName("X.0fSh");
                u uVar = new u();
                HookBridge.hookAllMethods(cls, "LIZ", uVar);
                HookBridge.hookAllMethods(cls, "LIZIZ", uVar);
                HookBridge.hookAllMethods(cls, "LIZJ", uVar);
            } catch (Throwable th3) {
                th3.getMessage();
                int i4 = v3.a;
            }
            HookBridge.hookAllMethods(TextView.class, "setText", new v());
            HookBridge.hookAllMethods(TextView.class, "setHint", new w());
            HookBridge.hookAllMethods(TextView.class, "onTouchEvent", new x());
        } catch (Throwable th4) {
            th4.getMessage();
            int i5 = v3.a;
        }
    }

    public static  Integer e() {
        return 0;
    }

    public static LinkedHashMap f(String str) {
        m0 m0VarA;
        if (TextUtils.isEmpty(str)) {
            return new LinkedHashMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        if (!TextUtils.isEmpty(str)) {
            String strTrim = str.trim();
            if (strTrim.startsWith("[")) {
                try {
                    JSONArray jSONArray = new JSONArray(strTrim);
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        Object objOpt = jSONArray.opt(i2);
                        if ((objOpt instanceof JSONObject) && (m0VarA = a((JSONObject) objOpt)) != null) {
                            linkedHashMap.put(m0VarA.a, m0VarA);
                        }
                    }
                } catch (Throwable th) {
                    th.getMessage();
                    int i3 = v3.a;
                    return linkedHashMap;
                }
            }
        }
        return linkedHashMap;
    }

    public static void g(final Context context) {
        if (m.compareAndSet(false, true)) {
            new Thread(new Runnable() {
                @Override
                public final void run() {
                    t0.c(context);
                }
            }, "badge-price-fetch").start();
        }
    }

    public static void h(final Context context) {
        new Thread(new Runnable() {
            @Override
            public final void run() {
                t0.d(context);
            }
        }, "badge-supporters-fetch").start();
    }

    public static int i(Context context) {
        y3 y3VarA = y3.a();
        if (y3VarA == null || !y3VarA.d() || y3VarA.j != 0) {
            return -185258;
        }
        try {
            int identifier = context.getResources().getIdentifier("system_accent3_400", "color", "android");
            if (identifier != 0) {
                return context.getResources().getColor(identifier, null);
            }
        } catch (Throwable th) {
        }
        Context contextC = v3.c();
        if (contextC == null) {
            return -16524603;
        }
        return x6.a(contextC);
    }

    public static s0 e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(str.trim());
            String strA = a(jSONObject.opt("usd"));
            String strB = b(jSONObject.opt("ruble"));
            if (!TextUtils.isEmpty(strA) && !TextUtils.isEmpty(strB)) {
                return new s0(strA, strB);
            }
            return null;
        } catch (Throwable th) {
            th.getMessage();
            int i2 = v3.a;
            return null;
        }
    }

    public static void e(Context context) {
        if (context == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/tt_ubot"));
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Throwable th) {
            th.getMessage();
            int i2 = v3.a;
        }
    }

    public static void b() {
        HookBridge.hookAllMethods(UserProfileInfo.class, "getNickname", new b0());
        a(ProfileNavbarNickNameProtocol.class);
        a(ProfileNavbarOtherNicknameProtocol.class);
        a(ProfileInfoNicknameProtocol.class);
        a(ProfileInfoOtherNicknameProtocol.class);
        a(ProfileNavbarNickNameProtocol.class, "LJLZ", 2);
        a(ProfileNavbarOtherNicknameProtocol.class, "LJLJL", 1);
        b(ProfileInfoNicknameProtocol.class, "LJLJI", 0);
        b(ProfileInfoNicknameProtocol.class, "LJLLI", 2);
        b(ProfileInfoNicknameProtocol.class, "LJLLILLLL", 2);
        b(ProfileInfoNicknameProtocol.class, "LJLLLLLL", 0);
        try {
            HookBridge.hookAllMethods(ProfileInfoNicknameProtocol.class, "LJLJJI", new h0(0));
        } catch (Throwable th) {
            th.getMessage();
            int i2 = v3.a;
        }
        b(ProfileInfoOtherNicknameProtocol.class, "qM0", 1);
        try {
            HookBridge.hookAllMethods(Describe.class, "getText", new d0());
        } catch (Throwable th2) {
            th2.getMessage();
            int i3 = v3.a;
        }
    }

    public static m0 g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return null;
        }
        return (m0) a.get(strTrim);
    }

    public static void c() {
        y yVar = new y();
        HookBridge.hookAllMethods(User.class, "getNickname", yVar);
        HookBridge.hookAllMethods(User.class, "getRemarkName", yVar);
        HookBridge.hookAllMethods(User.class, "getContactName", yVar);
        HookBridge.hookAllMethods(User.class, "getUserDisplayName", yVar);
        HookBridge.hookAllMethods(User.class, "getSearchUserName", yVar);
    }

    public static String h(String str) {
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

    public static void f(Context context) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        for (m0 m0Var : a.values()) {
            if (m0Var != null && c(m0Var.b)) {
                linkedHashSet.add(m0Var.b);
            }
        }
        for (String str : linkedHashSet) {
            if (c(str)) {
                c(context, str);
            }
        }
    }

    public static q0 c(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            Object objInvoke = e4.a(obj.getClass(), "LJIILIIL", new Class[0]).invoke(obj, null);
            if (objInvoke == null) {
                return null;
            }
            Object objInvoke2 = e4.a(objInvoke.getClass(), "getUserProfileInfo", new Class[0]).invoke(objInvoke, null);
            if (objInvoke2 instanceof UserProfileInfo) {
                UserProfileInfo userProfileInfo = (UserProfileInfo) objInvoke2;
                String uid = userProfileInfo.getUid();
                if (!TextUtils.isEmpty(uid) && g(uid) != null) {
                    a((CharSequence) userProfileInfo.getNickname());
                    return new q0(uid);
                }
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static String f() {
        try {
            Object obj = e4.a(Class.forName("X.06Gl"), "LJFF").get(null);
            if (obj != null) {
                Object objInvoke = e4.a(obj.getClass(), "LIZ", new Class[0]).invoke(obj, null);
                if (objInvoke == null) {
                    q = null;
                    return null;
                }
                if (Boolean.TRUE.equals(e4.a(objInvoke.getClass(), "isLogin", new Class[0]).invoke(objInvoke, null))) {
                    Object objInvoke2 = e4.a(objInvoke.getClass(), "getCurUserId", new Class[0]).invoke(objInvoke, null);
                    if (objInvoke2 instanceof String) {
                        String str = (String) objInvoke2;
                        if (!h4$$ExternalSyntheticBackport0.m(str)) {
                            q = str.trim();
                            return q;
                        }
                    }
                    q = null;
                    return null;
                }
                q = null;
                return null;
            }
            q = null;
            return null;
        } catch (Throwable th) {
            th.getMessage();
            int i2 = v3.a;
        }
    }

    public static void c(final Activity activity, final Fragment fragment, final m0 m0Var, final String str) {
        if (a(activity)) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public final void run() {
                    t0.b(activity, fragment, m0Var, str);
                }
            });
        }
    }

    public static void c(Context context, final String str) {
        if (c(str)) {
            final File file = new File(new File(b(context), "images"), h(str) + ".img");
            File file2 = new File(new File(b(context), "images"), h(str) + ".stamp");
            if (a(file, file2, 7200000L) && f.putIfAbsent(str, Boolean.TRUE) == null) {
                c(file2);
                Runnable runnable = new Runnable() {
                    @Override
                    public final void run() {
                        t0.a(str, file);
                    }
                };
                StringBuilder sb = new StringBuilder("badge-img-");
                String strH = h(str);
                if (strH.length() > 8) {
                    strH = strH.substring(0, 8);
                }
                new Thread(runnable, sb.append(strH).toString()).start();
            }
        }
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

    public static void b(Class cls, String str, int i2) {
        try {
            HookBridge.hookAllMethods(cls, str, new g0(i2));
        } catch (Throwable th) {
            th.getMessage();
            int i3 = v3.a;
        }
    }

    public static void b(final Activity activity, Fragment fragment, m0 m0Var, String str) {
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
                    final FrameLayout frameLayoutA = a(activity, fragment, m0Var, str);
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
                    a(frameLayoutA, new z(a(frameLayoutA.getContext(), 6.0f), frameLayoutA, a(frameLayoutA.getContext(), 28.0f), activity, frameLayout2));
                    frameLayoutA.postDelayed(new Runnable() {
                        @Override
                        public final void run() {
                            t0.a(activity, frameLayout2, frameLayoutA);
                        }
                    }, 2500L);
                }
            } catch (Throwable th) {
                th.getMessage();
                int i2 = v3.a;
            }
        }
    }

    public static boolean c(String str) {
        if (str != null) {
            return str.startsWith("https://") || str.startsWith("http://");
        }
        return false;
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

    public static m0 a(JSONObject jSONObject) {
        String strOptString;
        String strD;
        String strTrim;
        String strTrim2 = jSONObject.optString("uid", "").trim();
        Boolean boolValueOf = null;
        if (strTrim2.isEmpty()) {
            return null;
        }
        boolean zBooleanValue = false;
        boolean zOptBoolean = jSONObject.optBoolean("isDeveloper", false);
        if (jSONObject.has("badgeUrl") && !jSONObject.isNull("badgeUrl")) {
            strOptString = jSONObject.optString("badgeUrl", "");
        } else {
            strOptString = "";
        }
        String strTrim3 = TextUtils.isEmpty(strOptString) ? "" : strOptString.trim();
        if (strTrim3.isEmpty()) {
            strD = zOptBoolean ? "asset:developer.png" : "asset:supporter.png";
        } else if ("supporter".equalsIgnoreCase(strTrim3)) {
            strD = "asset:supporter.png";
        } else if ("developer".equalsIgnoreCase(strTrim3)) {
            strD = "asset:developer.png";
        } else {
            strD = d(strTrim3);
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
        if (bool != null) {
            zBooleanValue = bool.booleanValue();
        } else {
            boolean zIsEmpty = TextUtils.isEmpty(strOptString);
            String strD2 = d(strD);
            if (zIsEmpty || TextUtils.equals(strD2, "asset:supporter.png") || TextUtils.equals(strD2, "asset:developer.png")) {
                zBooleanValue = true;
            } else {
                int iLastIndexOf = strD2.lastIndexOf(47);
                if (iLastIndexOf >= 0) {
                    strD2 = strD2.substring(iLastIndexOf + 1);
                }
                if (strD2.startsWith("asset:")) {
                    strD2 = strD2.substring(6);
                }
                int iLastIndexOf2 = strD2.lastIndexOf(46);
                if (iLastIndexOf2 > 0) {
                    strD2 = strD2.substring(0, iLastIndexOf2);
                }
                if ("hz".equalsIgnoreCase(strD2) || "designer".equalsIgnoreCase(strD2) || "dev".equalsIgnoreCase(strD2) || "supporter".equalsIgnoreCase(strD2) || "developer".equalsIgnoreCase(strD2)) {
                    zBooleanValue = true;
                }
            }
        }
        return new m0(strTrim2, strD, zBooleanValue, zOptBoolean, strTrim);
    }

    public static String d(String str) {
        if (TextUtils.isEmpty(str)) {
            return "asset:supporter.png";
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return "asset:supporter.png";
        }
        return (c(strTrim) || strTrim.startsWith("asset:")) ? strTrim : "asset:".concat(strTrim);
    }

    public static void d(Context context) {
        File file = new File(b(context), "supporters_cache.txt");
        File file2 = new File(b(context), "supporters_fetch.stamp");
        if (a(file, file2, 1200000L)) {
            c(file2);
            try {
                byte[] bArrA = a("https://tiktokyou.yzewe.ru/api/v1/badges");
                String str = bArrA == null ? null : new String(bArrA, StandardCharsets.UTF_8);
                if (!TextUtils.isEmpty(str)) {
                    LinkedHashMap linkedHashMapF = f(str);
                    b(str, file);
                    ConcurrentHashMap concurrentHashMap = a;
                    concurrentHashMap.clear();
                    if (!linkedHashMapF.isEmpty()) {
                        concurrentHashMap.putAll(linkedHashMapF);
                    }
                    f(context);
                    linkedHashMapF.size();
                    int i2 = v3.a;
                    return;
                }
                throw new IOException("Empty supporters list");
            } catch (Throwable th) {
                th.getMessage();
                int i3 = v3.a;
            }
        }
    }

    public static void a(Class cls) {
        try {
            c0 c0Var = new c0();
            HookBridge.hookAllMethods(cls, "LJJLIIIJILLIZJL", c0Var);
            HookBridge.hookAllMethods(cls, "LJJLIIIJJIZ", c0Var);
        } catch (Throwable th) {
            th.getMessage();
            int i2 = v3.a;
        }
    }

    public static void a(Class cls, String str, int i2) {
        try {
            HookBridge.hookAllMethods(cls, "LJLJI", new e0());
            HookBridge.hookAllMethods(cls, str, new f0(i2));
        } catch (Throwable th) {
            th.getMessage();
            int i3 = v3.a;
        }
    }

    public static void a(HookMethod.HookMethodParam hookMethodParam, int i2) {
        Object objAppend;
        q0 q0VarC;
        Object[] objArr = hookMethodParam.args;
        if (objArr.length > i2) {
            Object obj = objArr[i2];
            if (obj instanceof String) {
                String str = (String) obj;
                Object obj2 = hookMethodParam.thisObject;
                if (TextUtils.isEmpty(str) || (q0VarC = c(obj2)) == null) {
                    objAppend = str;
                } else {
                    String string = str.toString();
                    String strA = a(q0VarC.a, string);
                    if (TextUtils.equals(strA, string)) {
                        objAppend = str;
                    } else {
                        objAppend = new SpannableStringBuilder(str).append((CharSequence) strA.substring(string.length()));
                    }
                }
                if (objAppend instanceof String) {
                    String str2 = (String) objAppend;
                    if (!TextUtils.equals(str2, str)) {
                        hookMethodParam.args[i2] = str2;
                        return;
                    }
                }
                if (objAppend != str) {
                    hookMethodParam.args[i2] = objAppend.toString();
                }
            }
        }
    }

    public static void b(final Activity activity, final Fragment fragment, final m0 m0Var) {
        if (a(activity)) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public final void run() {
                    t0.a(activity, fragment, m0Var);
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

    public static void a() {
        o oVar = new o();
        HookBridge.hookAllMethods(IMUser.class, "getDisplayName", oVar);
        HookBridge.hookAllMethods(IMUser.class, "getDisplayUserName", oVar);
        HookBridge.hookAllMethods(IMUser.class, "getRawNickNameForDisplay", oVar);
        HookBridge.hookAllMethods(IMUser.class, "getRemarkName", oVar);
        HookBridge.hookAllMethods(IMUser.class, "getContactName", oVar);
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

    public static void a(p0 p0Var, String str) {
        try {
            HookBridge.hookAllMethods(Class.forName(str), "getName", new s(p0Var, str));
        } catch (Throwable th) {
            th.getMessage();
            int i2 = v3.a;
        }
    }

    public static void b(String str) {
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

    public static boolean a(TextView textView, MotionEvent motionEvent) {
        Spanned spanned;
        l0 l0Var;
        Activity activity;
        Fragment fragment;
        String str;
        CharSequence text = textView.getText();
        String str2 = null;
        if (text instanceof Spanned) {
            spanned = (Spanned) text;
            l0[] l0VarArr = (l0[]) spanned.getSpans(0, spanned.length(), l0.class);
            if (l0VarArr == null || l0VarArr.length == 0) {
                spanned = null;
            }
        } else {
            spanned = null;
        }
        Map map = i;
        n0 n0Var = (n0) map.get(textView);
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
        int i2 = v3.a;
        if (spanned == null) {
            if (n0Var != null) {
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
                l0 l0VarA = a(textView, spanned, motionEvent);
                if (l0VarA == null) {
                    map.remove(textView);
                    ViewParent parent2 = textView.getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(false);
                    }
                    return false;
                }
                map.put(textView, new n0(l0VarA));
                ViewParent parent3 = textView.getParent();
                if (parent3 != null) {
                    parent3.requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 1:
                if (n0Var == null) {
                    return false;
                }
                l0 l0VarA2 = a(textView, spanned, motionEvent);
                if (!n0Var.b && l0VarA2 == (l0Var = n0Var.a)) {
                    m0 m0Var = l0Var.b;
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
                            Object objInvoke = e4.a(cls, "findFragment", View.class).invoke(null, textView);
                            if (objInvoke instanceof Fragment) {
                                fragment = (Fragment) objInvoke;
                            } else {
                                fragment = null;
                            }
                        } catch (Throwable th) {
                            Object objInvoke2 = e4.a(cls, "LJJJJL", View.class).invoke(null, textView);
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
                        } else if (m0Var != null) {
                            str = (String) e.get(m0Var.a);
                            if (!TextUtils.isEmpty(str)) {
                                str2 = str;
                            }
                        }
                    } else if (m0Var != null && !TextUtils.isEmpty(m0Var.a)) {
                        str = (String) e.get(m0Var.a);
                        if (!TextUtils.isEmpty(str)) {
                            str2 = str;
                        }
                    }
                    int i3 = v3.a;
                    if (activity != null) {
                        c(activity, fragment, m0Var, str2);
                    }
                }
                i.remove(textView);
                ViewParent parent4 = textView.getParent();
                if (parent4 != null) {
                    parent4.requestDisallowInterceptTouchEvent(false);
                }
                return true;
            case 2:
                if (n0Var == null) {
                    return false;
                }
                n0Var.b = a(textView, spanned, motionEvent) != n0Var.a;
                return true;
            case 3:
                if (n0Var == null) {
                    return false;
                }
                map.remove(textView);
                ViewParent parent5 = textView.getParent();
                if (parent5 != null) {
                    parent5.requestDisallowInterceptTouchEvent(false);
                }
                return true;
            default:
                return n0Var != null;
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
            int i3 = v3.a;
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

    public static File b(Context context) {
        return new File(context.getCacheDir() != null ? context.getCacheDir() : context.getFilesDir(), "ttmod_badges");
    }

    public static l0 a(TextView textView, Spanned spanned, MotionEvent motionEvent) {
        int iWidth;
        Layout layout = textView.getLayout();
        if (layout == null) {
            return null;
        }
        float x = (motionEvent.getX() - textView.getTotalPaddingLeft()) + textView.getScrollX();
        float y = (motionEvent.getY() - textView.getTotalPaddingTop()) + textView.getScrollY();
        if (x >= 0.0f && y >= 0.0f) {
            l0[] l0VarArr = (l0[]) spanned.getSpans(0, spanned.length(), l0.class);
            if (l0VarArr != null && l0VarArr.length != 0) {
                int scaledTouchSlop = ViewConfiguration.get(textView.getContext()).getScaledTouchSlop();
                for (l0 l0Var : l0VarArr) {
                    if (l0Var != null) {
                        int spanStart = spanned.getSpanStart(l0Var);
                        int spanEnd = spanned.getSpanEnd(l0Var);
                        if (spanStart >= 0 && spanEnd > spanStart) {
                            int lineForOffset = layout.getLineForOffset(spanStart);
                            float lineTop = layout.getLineTop(lineForOffset) - scaledTouchSlop;
                            float lineBottom = layout.getLineBottom(lineForOffset) + scaledTouchSlop;
                            if (y >= lineTop && y <= lineBottom) {
                                float fMin = Math.min(layout.getPrimaryHorizontal(spanStart), layout.getPrimaryHorizontal(spanEnd));
                                float fMax = Math.max(layout.getPrimaryHorizontal(spanStart), layout.getPrimaryHorizontal(spanEnd));
                                BitmapDrawable bitmapDrawable = l0Var.a;
                                if (bitmapDrawable != null && (iWidth = bitmapDrawable.getBounds().width()) > 0) {
                                    float f2 = iWidth;
                                    if (fMax - fMin < f2) {
                                        fMax = fMin + f2;
                                    }
                                }
                                float f3 = scaledTouchSlop;
                                if (x >= fMin - f3 && x <= fMax + f3) {
                                    return l0Var;
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void a(Fragment fragment, m0 m0Var, View view) {
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
        b(activity, fragment, m0Var);
    }

    public static void a(View view, z zVar) {
        view.setOnTouchListener(zVar);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(viewGroup.getChildAt(i2), zVar);
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
                    t0.b(activity, frameLayout);
                }
            }).start();
        } else {
            b(activity, frameLayout);
        }
    }

    public static  void a(final Activity activity, Fragment fragment, m0 m0Var) {
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
                        t0.k.remove(activity);
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
                int i2 = v3.a;
            }
        }
    }

    public static o0 a(final Activity activity, final Dialog dialog, final Fragment fragment) {
        int color;
        u3 u3VarA = u3.a();
        boolean z = activity != null && (activity.getResources().getConfiguration().uiMode & 48) == 32;
        int color2 = z ? Color.parseColor("#1E1E1E") : -1;
        int color3 = z ? -1 : Color.parseColor("#161823");
        int color4 = Color.parseColor(z ? "#A7A9B0" : "#8A8B91");
        int color5 = z ? Color.parseColor("#303030") : Color.parseColor("#EFEFF0");
        int color6 = z ? Color.parseColor("#303030") : Color.parseColor("#F3F3F4");
        y3 y3VarA = y3.a();
        if (y3VarA != null && y3VarA.d()) {
            color = x6.a();
        } else {
            color = Color.parseColor("#FE2B54");
        }
        o0 o0Var = new o0(activity);
        o0Var.setVerticalScrollBarEnabled(false);
        o0Var.setOverScrollMode(2);
        o0Var.a = Math.max(0, Math.max((int) k1.a(activity, 1, 320.0f), (int) (activity.getResources().getDisplayMetrics().heightPixels * 0.85f)));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color2);
        float fA = (int) k1.a(activity, 1, 24.0f);
        gradientDrawable.setCornerRadii(new float[]{fA, fA, fA, fA, 0.0f, 0.0f, 0.0f, 0.0f});
        o0Var.setBackground(gradientDrawable);
        o0Var.setClipToOutline(true);
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        int iA = (int) k1.a(activity, 1, 20.0f);
        int iA2 = (int) k1.a(activity, 1, 18.0f);
        int iA3 = (int) k1.a(activity, 1, 20.0f);
        int identifier = activity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        linearLayout.setPadding(iA, iA2, iA3, (identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0) + ((int) k1.a(activity, 1, 18.0f)));
        o0Var.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(activity);
        linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(activity);
        textView.setText(u3VarA.a("badge_sheet_header", "Подробнее"));
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
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) k1.a(activity, 1, 32.0f), (int) k1.a(activity, 1, 32.0f));
        layoutParams.gravity = 8388629;
        frameLayout.addView(textView2, layoutParams);
        ImageView imageView = new ImageView(activity);
        Bitmap bitmapA = a(activity, new m0("", "asset:supporter.png", true, false, null), (int) k1.a(activity, 1, 52.0f));
        if (bitmapA != null) {
            imageView.setImageBitmap(bitmapA);
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = (int) k1.a(activity, 1, 20.0f);
        linearLayout.addView(imageView, layoutParams2);
        TextView textView3 = new TextView(activity);
        textView3.setText(u3VarA.a("badge_sheet_title", "Поддержите разработку"));
        textView3.setTextColor(color3);
        textView3.setTextSize(2, 18.0f);
        textView3.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView3.setGravity(17);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = (int) k1.a(activity, 1, 18.0f);
        linearLayout.addView(textView3, layoutParams3);
        TextView textView4 = new TextView(activity);
        textView4.setText(u3VarA.a("badge_sheet_subtitle", "Внесите вклад в развитие разработки и получите уникальный значок."));
        textView4.setTextColor(color4);
        textView4.setTextSize(2, 14.0f);
        textView4.setGravity(17);
        textView4.setLineSpacing(0.0f, 1.1f);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = (int) k1.a(activity, 1, 10.0f);
        linearLayout.addView(textView4, layoutParams4);
        String strA = u3VarA.a("badge_sheet_copy_uid", "Скопировать мой UID");
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        linearLayout2.setPadding((int) k1.a(activity, 1, 14.0f), 0, (int) k1.a(activity, 1, 14.0f), 0);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(color5);
        gradientDrawable2.setCornerRadius((int) TypedValue.applyDimension(1, 999.0f, activity.getResources().getDisplayMetrics()));
        linearLayout2.setBackground(gradientDrawable2);
        Bitmap bitmapB = b(activity, "ic_copy");
        if (bitmapB != null) {
            ImageView imageView2 = new ImageView(activity);
            imageView2.setImageBitmap(bitmapB);
            imageView2.setColorFilter(color3, PorterDuff.Mode.SRC_IN);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams((int) k1.a(activity, 1, 13.0f), (int) k1.a(activity, 1, 13.0f));
            layoutParams5.rightMargin = (int) k1.a(activity, 1, 8.0f);
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
                t0.a(activity, view);
            }
        });
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, (int) k1.a(activity, 1, 36.0f));
        layoutParams6.gravity = 1;
        layoutParams6.topMargin = (int) k1.a(activity, 1, 18.0f);
        linearLayout.addView(linearLayout2, layoutParams6);
        LinearLayout linearLayout3 = new LinearLayout(activity);
        linearLayout3.setOrientation(1);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams7.topMargin = (int) k1.a(activity, 1, 20.0f);
        linearLayout.addView(linearLayout3, layoutParams7);
        s0 s0Var = r != null ? r : new s0("5", "500");
        linearLayout3.addView(a(activity, "ic_coin", String.format(u3VarA.a("badge_sheet_step1_title_format", "Пожертвуйте не менее $%1$s (%2$s₽)"), s0Var.a, s0Var.b), u3VarA.a("badge_sheet_step1_subtitle", "Переведите сумму по любым из наших реквизитов"), color6, color3, color4));
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams8.topMargin = (int) k1.a(activity, 1, 8.0f);
        String strA2 = u3VarA.a("badge_sheet_step2_title", "Пришлите подтверждение и ваш UID");
        String strA3 = u3VarA.a("badge_sheet_step2_contact", "@tt_u_bot");
        String str = String.format(u3VarA.a("badge_sheet_step2_subtitle", "Отправьте чек или скриншот в %s, а также ваш UID для выдачи"), strA3);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int iIndexOf = str.indexOf(strA3);
        if (iIndexOf >= 0) {
            spannableStringBuilder.setSpan(new a0(activity, color), iIndexOf, strA3.length() + iIndexOf, 33);
        }
        linearLayout3.addView(a(activity, "photo", strA2, spannableStringBuilder, color6, color3, color4), layoutParams8);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams9.topMargin = (int) k1.a(activity, 1, 8.0f);
        linearLayout3.addView(a(activity, "ic_mod_logo", u3VarA.a("badge_sheet_step3_title", "Получите значок"), u3VarA.a("badge_sheet_step3_subtitle", "После проверки он появится в вашем профиле и будет виден всем"), color6, color3, color4), layoutParams9);
        LinearLayout linearLayout4 = new LinearLayout(activity);
        linearLayout4.setOrientation(0);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams10.topMargin = (int) k1.a(activity, 1, 28.0f);
        linearLayout.addView(linearLayout4, layoutParams10);
        String strA4 = u3VarA.a("badge_sheet_cancel", "Отмена");
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
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(0, (int) k1.a(activity, 1, 48.0f));
        layoutParams11.weight = 1.0f;
        linearLayout4.addView(textView6, layoutParams11);
        String strA5 = u3VarA.a("badge_sheet_support", "Поддержать");
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
                t0.a(fragment, activity, dialog, view);
            }
        });
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(0, (int) k1.a(activity, 1, 48.0f));
        layoutParams12.weight = 1.0f;
        layoutParams12.leftMargin = (int) k1.a(activity, 1, 10.0f);
        linearLayout4.addView(textView7, layoutParams12);
        return o0Var;
    }

    public static  void a(Fragment fragment, Activity activity, Dialog dialog, View view) {
        if (fragment != null) {
            int i2 = v3.a;
        }
        e(activity);
        dialog.dismiss();
    }

    public static LinearLayout a(Activity activity, String str, String str2, CharSequence charSequence, int i2, int i3, int i4) {
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(48);
        linearLayout.setPadding(a(activity, 14.0f), (int) k1.a(activity, 1, 12.0f), (int) k1.a(activity, 1, 14.0f), (int) k1.a(activity, 1, 12.0f));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius((int) TypedValue.applyDimension(1, 10.0f, activity.getResources().getDisplayMetrics()));
        linearLayout.setBackground(gradientDrawable);
        Bitmap bitmapB = b(activity, str);
        if (bitmapB != null) {
            ImageView imageView = new ImageView(activity);
            imageView.setImageBitmap(bitmapB);
            imageView.setColorFilter(i4, PorterDuff.Mode.SRC_IN);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) k1.a(activity, 1, 18.0f), (int) k1.a(activity, 1, 18.0f));
            layoutParams.topMargin = (int) k1.a(activity, 1, 2.0f);
            linearLayout.addView(imageView, layoutParams);
        }
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams2.leftMargin = (int) k1.a(activity, 1, 12.0f);
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
        layoutParams3.topMargin = (int) k1.a(activity, 1, 3.0f);
        linearLayout2.addView(textView2, layoutParams3);
        return linearLayout;
    }

    public static void a(Activity activity, View view) {
        String strF = f();
        u3.a();
        if (TextUtils.isEmpty(strF)) {
            Toast.makeText(activity, u3.a().a("copy_uid_unavailable"), 0).show();
            return;
        }
        ClipboardManager clipboardManager = (ClipboardManager) activity.getSystemService("clipboard");
        if (clipboardManager == null) {
            Toast.makeText(activity, u3.a().a("copy_uid_failed"), 0).show();
            return;
        }
        try {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("uid", strF));
            Toast.makeText(activity, u3.a().a("copy_uid_copied"), 0).show();
        } catch (Throwable th) {
            Toast.makeText(activity, u3.a().a("copy_uid_failed"), 0).show();
        }
    }

    public static FrameLayout a(Activity activity, final Fragment fragment, final m0 m0Var, String str) {
        String strReplace;
        boolean z = activity != null && (activity.getResources().getConfiguration().uiMode & 48) == 32;
        int color = z ? Color.parseColor("#1E1E1E") : -1;
        int color2 = z ? -1 : Color.parseColor("#161823");
        y3 y3VarA = y3.a();
        int color3 = (y3VarA == null || !y3VarA.d()) ? Color.parseColor("#FE2B54") : x6.a();
        FrameLayout frameLayout = new FrameLayout(activity);
        int iA = a(activity, 14.0f);
        int iA2 = (int) k1.a(activity, 1, 12.0f);
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
        Bitmap bitmapA = a(activity, m0Var, (int) k1.a(activity, 1, 26.0f));
        if (bitmapA != null) {
            imageView.setImageBitmap(bitmapA);
        }
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = (int) k1.a(activity, 1, 10.0f);
        layoutParams.rightMargin = (int) k1.a(activity, 1, 6.0f);
        linearLayout.addView(linearLayout2, layoutParams);
        TextView textView = new TextView(activity);
        u3 u3VarA = u3.a();
        String strA = !TextUtils.isEmpty(str) ? str : u3VarA.a("badge_bulletin_unknown_name", "Этот человек");
        if (m0Var == null || TextUtils.isEmpty(m0Var.e)) {
            strReplace = (m0Var == null || !m0Var.d) ? String.format(u3VarA.a("badge_bulletin_supporter_format", "%s поддержал разработку TikTok You"), strA) : String.format(u3VarA.a("badge_bulletin_developer_format", "%s член команды разработки TikTok You"), strA);
        } else {
            strReplace = m0Var.e.replace("${1}", strA);
        }
        textView.setText(strReplace);
        textView.setTextSize(2, 14.0f);
        textView.setLineSpacing(0.0f, 1.0f);
        textView.setTextColor(color2);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(activity);
        textView2.setText(u3.a().a("badge_bulletin_button", "Подробнее"));
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 13.0f);
        textView2.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView2.setGravity(17);
        textView2.setPadding((int) TypedValue.applyDimension(1, 16.0f, activity.getResources().getDisplayMetrics()), 0, (int) k1.a(activity, 1, 16.0f), 0);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(color3);
        gradientDrawable2.setCornerRadius((int) TypedValue.applyDimension(1, 68.0f, activity.getResources().getDisplayMetrics()));
        textView2.setBackground(gradientDrawable2);
        textView2.setMinHeight((int) TypedValue.applyDimension(1, 32.0f, activity.getResources().getDisplayMetrics()));
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                t0.a(fragment, m0Var, view);
            }
        });
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-2, (int) k1.a(activity, 1, 32.0f)));
        return frameLayout;
    }

    public static Bitmap a(Context context, m0 m0Var, int i2) {
        Bitmap bitmapCreateScaledBitmap;
        k0 k0VarA = a(context, m0Var);
        if (k0VarA == null || k0VarA.b == null) {
            return null;
        }
        int iMax = Math.max(1, i2);
        String str = k0VarA.a + "::bulletin::" + iMax;
        ConcurrentHashMap concurrentHashMap = c;
        Bitmap bitmap = (Bitmap) concurrentHashMap.get(str);
        if (a(bitmap)) {
            return bitmap;
        }
        Bitmap bitmap2 = k0VarA.b;
        if (!a(bitmap2)) {
            return null;
        }
        int iMax2 = Math.max(1, Math.round((iMax / bitmap2.getHeight()) * bitmap2.getWidth()));
        if (a(bitmap2)) {
            try {
                bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, Math.max(1, iMax2), Math.max(1, iMax), true);
            } catch (Throwable th) {
                th.getMessage();
                int i3 = v3.a;
                bitmapCreateScaledBitmap = null;
            }
        } else {
            bitmapCreateScaledBitmap = null;
        }
        if (!a(bitmapCreateScaledBitmap)) {
            return null;
        }
        Bitmap bitmapA = (m0Var == null || !m0Var.c) ? bitmapCreateScaledBitmap : a(bitmapCreateScaledBitmap, i(context));
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
        m0 m0VarG;
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (m0VarG = g(str)) == null) {
            return str2;
        }
        if (!TextUtils.isEmpty(str2) && (str2.contains("\u2063\u2064\u2063\u2064\u2063") || str2.contains("\ufdd0") || str2.contains("\u2063\u2063\u2064") || str2.contains(" ￼") || str2.indexOf(65532) >= 0)) {
            return str2;
        }
        a(str2, m0VarG);
        return str2 + "\ufdd0" + ("\u2063\u2063\u2064" + a(m0VarG) + "\u2064\u2063\u2063");
    }

    public static CharSequence a(TextView textView, CharSequence charSequence) {
        ?? spannableStringBuilder;
        int i2;
        int iIndexOf;
        m0 m0Var;
        Bitmap bitmapA;
        CharSequence charSequence2 = charSequence;
        if (charSequence2 == null) {
            return null;
        }
        int iIndexOf2 = 0;
        if (charSequence2 instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence2;
            l0[] l0VarArr = (l0[]) spanned.getSpans(0, spanned.length(), l0.class);
            if (l0VarArr != null && l0VarArr.length != 0) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spanned);
                boolean z = false;
                for (l0 l0Var : l0VarArr) {
                    if (l0Var != null) {
                        int spanStart = spannableStringBuilder2.getSpanStart(l0Var);
                        int spanEnd = spannableStringBuilder2.getSpanEnd(l0Var);
                        int spanFlags = spannableStringBuilder2.getSpanFlags(l0Var);
                        if (spanStart >= 0 && spanEnd > spanStart && (bitmapA = a(textView.getContext(), textView, l0Var.b)) != null) {
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(textView.getResources(), bitmapA);
                            bitmapDrawable.setBounds(0, 0, bitmapA.getWidth(), bitmapA.getHeight());
                            spannableStringBuilder2.removeSpan(l0Var);
                            spannableStringBuilder2.setSpan(new l0(bitmapDrawable, l0Var.b), spanStart, spanEnd, spanFlags);
                            z = true;
                        }
                    }
                }
                if (z) {
                    spanned = spannableStringBuilder2;
                }
            }
            if (spanned != charSequence2) {
                charSequence2 = spanned;
            }
        }
        String string = charSequence2.toString();
        if (!string.contains("\ufdd0") || string.contains("\u2063\u2063\u2064")) {
            spannableStringBuilder = charSequence2;
        } else {
            spannableStringBuilder = new SpannableStringBuilder(charSequence2);
            int iIndexOf3 = 0;
            while (true) {
                iIndexOf3 = spannableStringBuilder.toString().indexOf("\ufdd0", iIndexOf3);
                if (iIndexOf3 < 0) {
                    break;
                }
                spannableStringBuilder.replace(iIndexOf3, iIndexOf3 + 1, "");
            }
            if (!charSequence2.toString().contains("\ufdd0")) {
                m0Var = null;
            } else {
                String strA = a(charSequence2);
                if (strA.isEmpty()) {
                    m0Var = null;
                } else {
                    m0Var = (m0) d.get(strA);
                }
            }
            if (m0Var != null && !spannableStringBuilder.toString().contains("\u2063\u2063\u2064")) {
                spannableStringBuilder.append("\u2063\u2063\u2064" + a(m0Var) + "\u2064\u2063\u2063");
            }
        }
        String string2 = spannableStringBuilder.toString();
        if (!string2.contains("\u2063\u2063\u2064") && !string2.contains("\ufdd0")) {
            return spannableStringBuilder;
        }
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(spannableStringBuilder);
        int length = 0;
        boolean z2 = false;
        while (true) {
            String string3 = spannableStringBuilder3.toString();
            int iIndexOf4 = string3.indexOf("\u2063\u2063\u2064", length);
            if (iIndexOf4 < 0 || (iIndexOf = string3.indexOf("\u2064\u2063\u2063", (i2 = iIndexOf4 + 3))) < 0) {
                break;
            }
            String strSubstring = string3.substring(i2, iIndexOf);
            m0 m0Var2 = TextUtils.isEmpty(strSubstring) ? null : (m0) g.get(strSubstring);
            if (m0Var2 == null) {
                m0Var2 = new m0("", "asset:supporter.png", true, false, null);
            }
            int i3 = iIndexOf + 3;
            Bitmap bitmapA2 = a(textView.getContext(), textView, m0Var2);
            String str = bitmapA2 != null ? " ￼" : "";
            spannableStringBuilder3.replace(iIndexOf4, i3, (CharSequence) str);
            if (bitmapA2 != null) {
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(textView.getResources(), bitmapA2);
                bitmapDrawable2.setBounds(0, 0, bitmapA2.getWidth(), bitmapA2.getHeight());
                spannableStringBuilder3.setSpan(new l0(bitmapDrawable2, m0Var2), iIndexOf4 + 1, iIndexOf4 + 2, 33);
            }
            length = iIndexOf4 + str.length();
            z2 = true;
        }
        boolean z3 = false;
        while (true) {
            iIndexOf2 = spannableStringBuilder3.toString().indexOf("\ufdd0", iIndexOf2);
            if (iIndexOf2 < 0) {
                break;
            }
            spannableStringBuilder3.replace(iIndexOf2, iIndexOf2 + 1, (CharSequence) "");
            z3 = true;
        }
        return (z2 || z3 || spannableStringBuilder != charSequence2) ? spannableStringBuilder3 : charSequence2;
    }

    public static void a(String str, m0 m0Var) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strA = a((CharSequence) str);
        if (strA.isEmpty()) {
            return;
        }
        d.put(strA, m0Var);
        if (!TextUtils.isEmpty(m0Var.a)) {
            e.put(m0Var.a, strA);
        }
        a(m0Var);
    }

    public static String a(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence.toString().replace("\u2063\u2064\u2063\u2064\u2063", "").replace("\ufdd0", "").replace("\u2063\u2063\u2064", "").replace("\u2064\u2063\u2063", "").replace(String.valueOf((char) 8203), "").replace(String.valueOf((char) 8204), "").replace(" ￼", "").replace("￼", "").replace((char) 160, ' ').trim();
    }

    public static Bitmap a(Context context, TextView textView, m0 m0Var) {
        Bitmap bitmapCreateScaledBitmap;
        k0 k0VarA = a(context, m0Var);
        if (k0VarA == null || k0VarA.b == null) {
            return null;
        }
        int iMax = Math.max(1, Math.round(textView.getLineHeight() * 1.0f));
        String str = k0VarA.a + "::" + iMax;
        ConcurrentHashMap concurrentHashMap = c;
        Bitmap bitmap = (Bitmap) concurrentHashMap.get(str);
        if (a(bitmap)) {
            return bitmap;
        }
        Bitmap bitmap2 = k0VarA.b;
        if (!a(bitmap2)) {
            return null;
        }
        int iMax2 = Math.max(1, Math.round((iMax / bitmap2.getHeight()) * bitmap2.getWidth()));
        if (a(bitmap2)) {
            try {
                bitmapCreateScaledBitmap = Bitmap.createScaledBitmap(bitmap2, Math.max(1, iMax2), Math.max(1, iMax), true);
            } catch (Throwable th) {
                th.getMessage();
                int i2 = v3.a;
                bitmapCreateScaledBitmap = null;
            }
        } else {
            bitmapCreateScaledBitmap = null;
        }
        if (!a(bitmapCreateScaledBitmap)) {
            return null;
        }
        Bitmap bitmapA = (m0Var == null || !m0Var.c) ? bitmapCreateScaledBitmap : a(bitmapCreateScaledBitmap, i(context));
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
            boolean z = x6.c;
            x6.c = false;
            try {
                paint.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_IN));
                x6.c = z;
                try {
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                    return bitmapCreateBitmap;
                } catch (Throwable th) {
                    th.getMessage();
                    int i3 = v3.a;
                    return null;
                }
            } catch (Throwable th2) {
                x6.c = z;
                throw th2;
            }
        } catch (Throwable th3) {
            th3.getMessage();
            int i4 = v3.a;
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
        String strD = d(str);
        ConcurrentHashMap concurrentHashMap = b;
        Bitmap bitmap = (Bitmap) concurrentHashMap.get(strD);
        if (a(bitmap)) {
            return bitmap;
        }
        synchronized (t0.class) {
            Bitmap bitmap2 = (Bitmap) concurrentHashMap.get(strD);
            if (a(bitmap2)) {
                return bitmap2;
            }
            if (strD.startsWith("asset:")) {
                strSubstring = strD.substring(6);
            } else {
                strSubstring = "supporter.png";
            }
            try {
                InputStream inputStreamOpen = context.getAssets().open(strSubstring);
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                    if (bitmapDecodeStream != null) {
                        concurrentHashMap.put(strD, bitmapDecodeStream);
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
                int i2 = v3.a;
                return null;
            }
        }
    }

    public static void a(String str, File file) {
        try {
            byte[] bArrA = a(str);
            if (bArrA != null && bArrA.length != 0) {
                a(file);
                FileOutputStream fileOutputStream = new FileOutputStream(file, false);
                try {
                    fileOutputStream.write(bArrA);
                    fileOutputStream.close();
                    b(str);
                    Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArrA, 0, bArrA.length);
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
                int i2 = v3.a;
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

    public static byte[] a(String str) throws Throwable {
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

    public static void a(File file) throws IOException {
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists() && !parentFile.mkdirs() && !parentFile.exists()) {
            throw new IOException("Failed to create " + parentFile.getAbsolutePath());
        }
    }

    public static String a(IMConversation iMConversation) {
        List<String> memberIdList;
        if (iMConversation == null || (memberIdList = iMConversation.getMemberIdList()) == null || memberIdList.isEmpty()) {
            return null;
        }
        String strF = f();
        String str = null;
        for (String str2 : memberIdList) {
            if (!TextUtils.isEmpty(str2)) {
                String strTrim = str2.trim();
                if (!strTrim.isEmpty() && (TextUtils.isEmpty(strF) || !TextUtils.equals(strF, strTrim))) {
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

    public static k0 a(Context context, m0 m0Var) {
        m0 m0Var2;
        if (m0Var != null) {
            m0Var2 = new m0(m0Var.a, m0Var.b, m0Var.c, m0Var.d, m0Var.e);
        } else {
            m0Var2 = new m0("", "asset:supporter.png", true, false, null);
        }
        String str = m0Var2.b;
        ConcurrentHashMap concurrentHashMap = b;
        Bitmap bitmap = (Bitmap) concurrentHashMap.get(str);
        if (a(bitmap)) {
            return new k0(m0Var2.b + "|" + m0Var2.c + "|" + m0Var2.d, bitmap);
        }
        if (c(str)) {
            Bitmap bitmap2 = (Bitmap) concurrentHashMap.get(str);
            if (!a(bitmap2)) {
                File file = new File(new File(b(context), "images"), h(str) + ".img");
                File file2 = new File(new File(b(context), "images"), h(str) + ".stamp");
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
                return new k0(m0Var2.b + "|" + m0Var2.c + "|" + m0Var2.d, bitmap2);
            }
            Bitmap bitmapA = a(context, "asset:supporter.png");
            boolean z = m0Var2.c;
            boolean z2 = m0Var2.d;
            String str2 = m0Var2.e;
            String strD = d("asset:supporter.png");
            TextUtils.isEmpty(str2);
            if (bitmapA != null) {
                return new k0(strD + "|" + z + "|" + z2, bitmapA);
            }
            return null;
        }
        Bitmap bitmapA2 = a(context, str);
        if (bitmapA2 != null) {
            return new k0(m0Var2.b + "|" + m0Var2.c + "|" + m0Var2.d, bitmapA2);
        }
        return null;
    }

    public static String a(m0 m0Var) {
        String str = m0Var.e;
        if (str == null) {
            str = "";
        }
        String str2 = m0Var.a + "|" + m0Var.b + "|" + m0Var.c + "|" + m0Var.d + "|" + str;
        ConcurrentHashMap concurrentHashMap = h;
        String str3 = (String) concurrentHashMap.get(str2);
        if (str3 != null) {
            return str3;
        }
        synchronized (t0.class) {
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
            g.put(string, m0Var);
            return string;
        }
    }
}
