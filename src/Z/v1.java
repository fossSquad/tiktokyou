package Z;

import android.app.Activity;
import android.app.Dialog;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.Layout;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.ss.android.ugc.aweme.base.vm.MentionContainerViewModel;
import com.ss.android.ugc.aweme.feed.assem.videoauthorinfo.VideoAuthorInfoVM;
import com.ss.android.ugc.aweme.friendstab.repo.FriendsV3RepostModel;
import com.ss.android.ugc.aweme.im.common.model.BaseContact;
import com.ss.android.ugc.aweme.im.contacts.api.model.IMConversation;
import com.ss.android.ugc.aweme.im.contacts.api.model.IMUser;
import com.ss.android.ugc.aweme.profile.model.User;
import com.ss.android.ugc.profile.business.ur.ProfileNavbarNickNameProtocol;
import com.ss.android.ugc.profile.business.ur.ProfileNavbarOtherNicknameProtocol;
import com.ss.android.ugc.profile.business.ur.nickname.ProfileInfoNicknameProtocol;
import com.ss.android.ugc.profile.business.ur.nickname.ProfileInfoOtherNicknameProtocol;
import com.ss.android.ugc.profile.platform.base.data.Describe;
import com.ss.android.ugc.profile.platform.base.data.UserProfileInfo;
import com.windukk.hook.HookBridge;
import com.windukk.hook.HookMethod;
import com.windukk.mod.Main;
import com.windukk.mod.hooks.BadgeHooks;
import com.windukk.stable.ResourceOverlay;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntUnaryOperator;
import java.util.function.Supplier;
import ni.shikatu.kotlin.collections.MapsKt;

public abstract class v1 {
    public static final AtomicInteger A;
    public static volatile String B;
    public static volatile rg C;
    public static final String[] a;
    public static final ConcurrentHashMap b;
    public static final ConcurrentHashMap c;
    public static final d2 d;
    public static final ConcurrentHashMap e;
    public static final ConcurrentHashMap f;
    public static final ConcurrentHashMap g;
    public static final ConcurrentHashMap h;
    public static final ConcurrentHashMap i;
    public static final ConcurrentHashMap j;
    public static final Map k;
    public static final Map l;
    public static final Map m;
    public static final AtomicInteger n;
    public static final AtomicBoolean o;
    public static final AtomicBoolean p;
    public static final AtomicBoolean q;
    public static final AtomicBoolean r;
    public static final AtomicBoolean s;
    public static volatile ScheduledExecutorService t;
    public static final ThreadLocal u;
    public static final ThreadLocal v;
    public static volatile String w;
    public static volatile String x;
    public static volatile Method y;
    public static final AtomicInteger z;

    static {
        a = new String[0];
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = new d2(4194304);
        e = new ConcurrentHashMap();
        f = new ConcurrentHashMap();
        g = new ConcurrentHashMap();
        h = new ConcurrentHashMap();
        i = new ConcurrentHashMap();
        j = new ConcurrentHashMap();
        k = Collections.synchronizedMap(new WeakHashMap());
        l = Collections.synchronizedMap(new WeakHashMap());
        m = Collections.synchronizedMap(new WeakHashMap());
        Collections.synchronizedMap(new WeakHashMap());
        n = new AtomicInteger(1);
        o = new AtomicBoolean(false);
        p = new AtomicBoolean(false);
        q = new AtomicBoolean(false);
        r = new AtomicBoolean(false);
        s = new AtomicBoolean(false);
        u = new ThreadLocal();
        v = ThreadLocal.withInitial(new Supplier() {
            @Override
            public final Object get() {
                return v1.j();
            }
        });
        z = new AtomicInteger(0);
        A = new AtomicInteger(0);
        C = new rg("5", "500");
    }

    public static  int a(int i2) {
        if (i2 > 0) {
            return i2 - 1;
        }
        return 0;
    }

    public static void c(Context context) {
        String strB = x0.b(context, "tty_badges/supporters_fallback.json");
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        LinkedHashMap linkedHashMapB = y0.b(strB);
        if (linkedHashMapB.isEmpty()) {
            return;
        }
        a(linkedHashMapB);
        try {
            x0.a(new File(x0.a(context), "supporters_cache.txt"), strB);
            x0.b(new File(x0.a(context), "supporters_fetch.stamp"));
        } catch (IOException e) {
            g7.a(6, g7.a("Failed to persist build fallback: %s", new Object[]{e.getMessage()}), (Throwable) null);
        }
        d(context);
        g7.a(4, g7.a("Loaded %d supporter uid(s) from build fallback", new Object[]{Integer.valueOf(linkedHashMapB.size())}), (Throwable) null);
    }

    public static void d(Context context) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        for (x1 x1Var : ((Map<String, x1>) b).values()) {
            if (x1Var != null && a2.a(x1Var.b)) {
                linkedHashSet.add(b(context, x1Var.b));
            }
        }
        for (String str : linkedHashSet) {
            if (a2.a(str)) {
                c(context, str);
            }
        }
    }

    public static void e(final Context context) {
        char[] cArr = x0.a;
        File file = new File(x0.a(context), "support_price_cache.json");
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (file.exists() && file.length() > 0) {
            long jLastModified = jCurrentTimeMillis - file.lastModified();
            if (jLastModified >= 0 && jLastModified < 21600000) {
                return;
            }
        }
        if (o.compareAndSet(false, true)) {
            new Thread(new Runnable() {
                @Override
                public final void run() {
                    v1.b(context);
                }
            }, "badge-price-fetch").start();
        }
    }

    public static void f() {
        HookBridge.hookAllMethods(UserProfileInfo.class, "getNickname", new m1());
        a(ProfileNavbarNickNameProtocol.class, na.a);
        a(ProfileNavbarOtherNicknameProtocol.class, oa.a);
        a(ProfileInfoNicknameProtocol.class, ka.a);
        a(ProfileInfoOtherNicknameProtocol.class, la.a);
        a(ProfileNavbarNickNameProtocol.class, na.c, na.d, 2);
        a(ProfileNavbarOtherNicknameProtocol.class, oa.c, oa.d, 1);
        a(ProfileNavbarOtherNicknameProtocol.class, oa.e, 0);
        a(ProfileInfoNicknameProtocol.class, ka.c, 0);
        a(ProfileInfoNicknameProtocol.class, ka.d, 2);
        a(ProfileInfoNicknameProtocol.class, ka.e, 2);
        a(ProfileInfoNicknameProtocol.class, ka.f, 0);
        try {
            a(ProfileInfoNicknameProtocol.class, ka.g, new t1(0));
        } catch (Throwable th) {
            String strDecrypt = "%s: failed to hook nickname charsequence argument";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
        a(ProfileInfoOtherNicknameProtocol.class, la.c, 1);
        try {
            HookBridge.hookAllMethods(Describe.class, "getText", new o1());
        } catch (Throwable th2) {
            String strDecrypt2 = "Failed to hook profile describe text: %s";
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(strDecrypt2), th2);
        }
        try {
            HookBridge.hookAllMethods(Class.forName("com.ss.android.ugc.profile.business.profile.ui.v2.I18nUserProfileFragment"), "getUser", new p1());
        } catch (Throwable th3) {
            String strDecrypt3 = "Failed to hook profile user capture: %s";
            Object obj3 = g7.a;
            g7.a(6, String.valueOf(strDecrypt3), th3);
        }
    }

    public static void g(Context context) {
        if (context != null && s.compareAndSet(false, true)) {
            t = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
                @Override
                public final Thread newThread(Runnable runnable) {
                    return v1.a(runnable);
                }
            });
            t.scheduleWithFixedDelay(new Runnable() {
                @Override
                public final void run() {
                    v1.i();
                }
            }, Z.q.a() + 3600000, 3600000L, TimeUnit.MILLISECONDS);
        }
    }

    public static void h() {
        try {
            Context contextA = Main.getApplicationContext();
            a(contextA);
            g(contextA);
            if (contextA != null) {
                char[] cArr = x0.a;
                rg rgVarA = y0.a(x0.a(new File(x0.a(contextA), "support_price_cache.json")));
                if (rgVarA != null) {
                    C = rgVarA;
                }
                e(contextA);
            }
            pc.a();
            HookMethod hookMethod = yb.a;
            try {
                HookBridge.hookAllMethods(MentionContainerViewModel.class, u9.a.c[0], yb.a);
            } catch (Throwable th) {
                String strDecrypt = "Exception during mention hooks";
                Object obj = g7.a;
                g7.a(6, String.valueOf(strDecrypt), th);
            }
            g();
            f();
            z0 z0Var = new z0();
            HookBridge.hookAllMethods(BaseContact.class, "getNickName", z0Var);
            HookBridge.hookAllMethods(BaseContact.class, "getDisplayName", z0Var);
            e();
            c();
            HookBridge.hookAllMethods(VideoAuthorInfoVM.class, rb.a.c[0], new c1());
            try {
                HookBridge.hookAllConstructors(FriendsV3RepostModel.class, new d1());
            } catch (Throwable th2) {
                String strDecrypt2 = "Failed to hook FriendsV3RepostModel";
                Object obj2 = g7.a;
                g7.a(6, String.valueOf(strDecrypt2), th2);
            }
            w7 w7Var = u7.a;
            v9 v9Var = u7.b;
            i2 i2Var = i2.a;
            a(w7Var, v9Var, i2Var);
            a(v7.a, v7.b, i2Var);
            d();
            b();
            HookBridge.hookAllMethods(TextView.class, "setText", new h1());
            HookBridge.hookAllMethods(TextView.class, "setHint", new i1());
            HookBridge.hookAllMethods(TextView.class, "onTouchEvent", new k1());
            String strDecrypt3 = "Initialized";
            Object obj3 = g7.a;
            g7.a(4, String.valueOf(strDecrypt3), (Throwable) null);
        } catch (Throwable th3) {
            String strDecrypt4 = "Init failed";
            Object obj4 = g7.a;
            g7.a(6, String.valueOf(strDecrypt4), th3);
        }
    }

    public static void i() {
        try {
            Context contextA = Main.getApplicationContext();
            if (contextA != null) {
                a(contextA, false, (u1) null);
                e(contextA);
            }
        } catch (Throwable th) {
            String strDecrypt = "Periodic supporter refresh failed";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static  Integer j() {
        return 0;
    }

    public static void k() {
        if (A.updateAndGet(new IntUnaryOperator() {
            @Override
            public final int applyAsInt(int i2) {
                return v1.a(i2);
            }
        }) == 0) {
        }
    }

    public static String l() {
        Object objInvoke;
        try {
            e9 e9Var = l9.a;
            Class<?> cls = Class.forName("X.03Rm");
            v9 v9Var = l9.b;
            Method methodA = v9Var.a(cls, new Class[0]);
            if (Modifier.isStatic(methodA.getModifiers())) {
                objInvoke = methodA.invoke(null, null);
            } else {
                Object obj = l9.a.a(cls).get(null);
                if (obj == null) {
                    B = null;
                    return null;
                }
                objInvoke = v9Var.a(obj.getClass(), new Class[0]).invoke(obj, null);
            }
            if (objInvoke == null) {
                B = null;
                return null;
            }
            if (!Boolean.TRUE.equals(se.a(objInvoke.getClass(), "isLogin", new Class[0]).invoke(objInvoke, null))) {
                B = null;
                return null;
            }
            Object objInvoke2 = se.a(objInvoke.getClass(), "getCurUserId", new Class[0]).invoke(objInvoke, null);
            if (objInvoke2 instanceof String) {
                String str = (String) objInvoke2;
                if (!StringUtils.isBlank(str)) {
                    B = str.trim();
                    return B;
                }
            }
            B = null;
            return null;
        } catch (Throwable th) {
            String strDecrypt = "Failed to resolve current user uid";
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
        return null;
    }

    public static Bitmap a(Context context, TextView textView, x1 x1Var) {
        x1 x1Var2 = x1Var != null ? new x1(x1Var.a, x1Var.b, x1Var.c, x1Var.d, x1Var.e, x1Var.f) : x1.a();
        String strB = a2.a(x1Var2.b) ? b(context, x1Var2.b) : x1Var2.b;
        int iMax = 1;
        int iMax2 = Math.max(1, Math.round(textView.getLineHeight() * 1.0f));
        StringBuilder sb = new StringBuilder();
        boolean z2 = x1Var2.c;
        boolean z3 = x1Var2.d;
        String str = x1Var2.e;
        String str2 = x1Var2.f;
        String strB2 = a2.b(strB);
        if (str != null) {
            str.isEmpty();
        }
        if (str2 != null) {
            str2.isEmpty();
        }
        String string = sb.append(strB2 + "|" + z2 + "|" + z3).append("::").append(iMax2).toString();
        d2 d2Var = d;
        Bitmap bitmap = (Bitmap) d2Var.get(string);
        if (a(bitmap)) {
            return bitmap;
        }
        v0 v0VarA = a(context, x1Var);
        if (v0VarA == null) {
            return null;
        }
        String str3 = v0VarA.a + "::" + iMax2;
        Bitmap bitmap2 = (Bitmap) d2Var.get(str3);
        if (a(bitmap2)) {
            return bitmap2;
        }
        Bitmap bitmap3 = v0VarA.b;
        if (!a(bitmap3)) {
            return null;
        }
        if (a(bitmap3)) {
            iMax = Math.max(1, Math.round(Math.max(1, iMax2) * Math.min(4.0f, Math.max(0.25f, bitmap3.getWidth() / bitmap3.getHeight()))));
        }
        Bitmap bitmapA = a(bitmap3, iMax, iMax2);
        if (!a(bitmapA)) {
            return null;
        }
        Bitmap bitmapA2 = (x1Var == null || !x1Var.c) ? bitmapA : a(bitmapA, f(context));
        if (a(bitmapA2)) {
            bitmapA = bitmapA2;
        }
        d2Var.put(str3, bitmapA);
        return bitmapA;
    }

    public static void b(final u1 u1Var, final boolean z2, final int i2, final String str) {
        if (u1Var == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public final void run() {
                u1Var.a(z2, i2, str);
            }
        });
    }

    public static void b(Context context) {
        try {
            String strA = x0.a("https://tiktokyou.yzewe.ru/api/v1/price");
            rg rgVarA = y0.a(strA);
            if (rgVarA != null) {
                C = rgVarA;
                x0.a(new File(x0.a(context), "support_price_cache.json"), strA);
                g7.a(4, g7.a("Loaded support price usd=%s ruble=%s", new Object[]{rgVarA.a, rgVarA.b}), (Throwable) null);
                o.set(false);
                return;
            }
            throw new IOException("Invalid support price");
        } catch (Throwable th) {
            try {
                String strDecrypt = "Failed to load support price: %s";
                Object obj = g7.a;
                g7.a(6, String.valueOf(strDecrypt), th);
            } finally {
                o.set(false);
            }
        }
    }

    public static String d(String str) {
        try {
            Method methodA = y;
            if (methodA == null) {
                v9 v9Var = p7.a;
                v9 v9Var2 = p7.a;
                methodA = v9Var.a(Class.forName("X.08zB"), String.class);
                y = methodA;
            }
            Object objInvoke = methodA.invoke(null, str);
            if (objInvoke instanceof String) {
                return a((CharSequence) objInvoke);
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static void c() {
        b1 b1Var = new b1();
        HookBridge.hookAllMethods(IMConversation.class, "getConversationName", b1Var);
        HookBridge.hookAllMethods(IMConversation.class, "getDisplayName", b1Var);
        HookBridge.hookAllMethods(IMConversation.class, "getNickName", b1Var);
    }

    public static void d() {
        try {
            v9 v9Var = k9.a;
            HookBridge.hookAllMethods(Class.forName("com.ss.android.ugc.aweme.im.saas.host.impl.feature.friends.FriendsFeatureImpl"), k9.a.c[0], new f1());
        } catch (Throwable th) {
            String strDecrypt = "Failed to hook FriendsFeatureImpl";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static void g() {
        j1 j1Var = new j1();
        HookBridge.hookAllMethods(User.class, "getNickname", j1Var);
        HookBridge.hookAllMethods(User.class, "getRemarkName", j1Var);
        HookBridge.hookAllMethods(User.class, "getContactName", j1Var);
        HookBridge.hookAllMethods(User.class, "getUserDisplayName", j1Var);
        HookBridge.hookAllMethods(User.class, "getSearchUserName", j1Var);
    }

    public static Object b(Object obj) {
        v9 v9Var;
        Class<?> cls = obj.getClass();
        if (ProfileNavbarNickNameProtocol.class.isAssignableFrom(cls)) {
            v9Var = na.b;
        } else if (ProfileNavbarOtherNicknameProtocol.class.isAssignableFrom(cls)) {
            v9Var = oa.b;
        } else if (ProfileInfoNicknameProtocol.class.isAssignableFrom(cls)) {
            v9Var = ka.b;
        } else {
            v9Var = ProfileInfoOtherNicknameProtocol.class.isAssignableFrom(cls) ? la.b : null;
        }
        if (v9Var == null) {
            return null;
        }
        for (String str : (String[]) v9Var.c.clone()) {
            try {
                Object objInvoke = se.a(obj.getClass(), str, new Class[0]).invoke(obj, null);
                if (objInvoke != null) {
                    return objInvoke;
                }
            } catch (Throwable th) {
            }
        }
        return null;
    }

    public static void e() {
        a1 a1Var = new a1();
        HookBridge.hookAllMethods(IMUser.class, "getDisplayName", a1Var);
        HookBridge.hookAllMethods(IMUser.class, "getDisplayUserName", a1Var);
        HookBridge.hookAllMethods(IMUser.class, "getRawNickNameForDisplay", a1Var);
        HookBridge.hookAllMethods(IMUser.class, "getRemarkName", a1Var);
        HookBridge.hookAllMethods(IMUser.class, "getContactName", a1Var);
    }

    public static void c(final Activity activity, final Fragment fragment, final x1 x1Var, final String str) {
        if (c2.b(activity)) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public final void run() {
                    v1.b(activity, fragment, x1Var, str);
                }
            });
        }
    }

    public static x1 c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return null;
        }
        return (x1) b.get(strTrim);
    }

    public static void b() {
        try {
            v9 v9Var = p7.a;
            Class<?> cls = Class.forName("X.08zB");
            g1 g1Var = new g1();
            for (String str : (String[]) p7.a.c.clone()) {
                HookBridge.hookAllMethods(cls, str, g1Var);
            }
        } catch (Throwable th) {
            String strDecrypt = "Failed to hook alias display names";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static void c(final Context context, String str) {
        final String strB = b(context, str);
        if (a2.a(strB)) {
            char[] cArr = x0.a;
            File fileA = x0.a(context);
            char[] cArr2 = x0.c;
            File file = new File(fileA, new String(cArr2));
            char[] cArr3 = x0.a;
            String str2 = strB != null ? strB : "";
            Charset charset = StandardCharsets.UTF_8;
            File file2 = new File(file, r6.a(str2.getBytes(charset)) + new String(cArr3));
            File file3 = new File(new File(x0.a(context), new String(cArr2)), r6.a((strB != null ? strB : "").getBytes(charset)) + new String(x0.b));
            if (x0.a(file2, file3, 21600000L) && h.putIfAbsent(strB, Boolean.TRUE) == null) {
                x0.b(file3);
                Runnable runnable = new Runnable() {
                    @Override
                    public final void run() {
                        v1.a(strB, context);
                    }
                };
                StringBuilder sbAppend = new StringBuilder().append("badge-img-");
                String strA = r6.a(strB.getBytes(charset));
                if (strA.length() > 8) {
                    strA = strA.substring(0, 8);
                }
                new Thread(runnable, sbAppend.append(strA).toString()).start();
            }
        }
    }

    public static v0 a(Context context, x1 x1Var) {
        x1 x1VarA;
        String strB;
        if (x1Var != null) {
            x1VarA = new x1(x1Var.a, x1Var.b, x1Var.c, x1Var.d, x1Var.e, x1Var.f);
        } else {
            x1VarA = x1.a();
        }
        if (a2.a(x1VarA.b)) {
            strB = b(context, x1VarA.b);
        } else {
            strB = x1VarA.b;
        }
        if (a2.a(strB)) {
            String strB2 = b(context, strB);
            char[] cArr = x0.a;
            File fileA = x0.a(context);
            char[] cArr2 = x0.c;
            File file = new File(fileA, new String(cArr2));
            char[] cArr3 = x0.a;
            String str = strB2 != null ? strB2 : "";
            Charset charset = StandardCharsets.UTF_8;
            File file2 = new File(file, r6.a(str.getBytes(charset)) + new String(cArr3));
            File file3 = new File(new File(x0.a(context), new String(cArr2)), r6.a((strB2 != null ? strB2 : "").getBytes(charset)) + new String(x0.b));
            Bitmap bitmapA = w4.a(file2, 512);
            if (bitmapA != null) {
                if (x0.a(file2, file3, 21600000L)) {
                    c(context, strB2);
                }
            } else {
                if (file2.exists()) {
                    if (file2.exists()) {
                        file2.setLastModified(0L);
                    }
                    if (file3.exists()) {
                        file3.setLastModified(0L);
                    }
                    String strDecrypt = "Ignored invalid badge image cache %s";
                    String strA = r6.a(strB2.getBytes(charset));
                    if (strA.length() > 8) {
                        strA = strA.substring(0, 8);
                    }
                    g7.a(6, g7.a(strDecrypt, new Object[]{strA}), (Throwable) null);
                }
                c(context, strB2);
                bitmapA = null;
            }
            if (bitmapA != null) {
                boolean z2 = x1VarA.c;
                boolean z3 = x1VarA.d;
                String str2 = x1VarA.e;
                String str3 = x1VarA.f;
                String strB3 = a2.b(strB);
                if (str2 != null) {
                    str2.isEmpty();
                }
                if (str3 != null) {
                    str3.isEmpty();
                }
                return new v0(strB3 + "|" + z2 + "|" + z3, bitmapA);
            }
            Bitmap bitmapA2 = a(context, "asset:supporter.png");
            String strDecrypt2 = "asset:supporter.png";
            boolean z4 = x1VarA.c;
            boolean z5 = x1VarA.d;
            String str4 = x1VarA.e;
            String str5 = x1VarA.f;
            String strB4 = a2.b(strDecrypt2);
            if (str4 != null) {
                str4.isEmpty();
            }
            if (str5 != null) {
                str5.isEmpty();
            }
            if (bitmapA2 != null) {
                return new v0(strB4 + "|" + z4 + "|" + z5, bitmapA2);
            }
            return null;
        }
        Bitmap bitmapA3 = a(context, strB);
        if (bitmapA3 != null) {
            return new v0(x1VarA.b + "|" + x1VarA.c + "|" + x1VarA.d, bitmapA3);
        }
        return null;
    }

    public static int f(Context context) {
        ac acVarA = ac.a();
        if (acVarA == null || !acVarA.g() || ac.e().r != 0) {
            return -185258;
        }
        try {
            int identifier = context.getResources().getIdentifier("system_accent3_400", "color", "android");
            if (identifier != 0) {
                return context.getResources().getColor(identifier, null);
            }
        } catch (Throwable th) {
        }
        Context contextA = Main.getApplicationContext();
        if (contextA == null) {
            return -16524603;
        }
        return zh.a(contextA);
    }

    public static void b(final Activity activity, Fragment fragment, x1 x1Var, String str) {
        if (c2.b(activity)) {
            try {
                WindowManager windowManager = activity.getWindowManager();
                View decorView = activity.getWindow() != null ? activity.getWindow().getDecorView() : null;
                if (windowManager != null && decorView != null && decorView.getWindowToken() != null) {
                    Map map = l;
                    FrameLayout frameLayout = (FrameLayout) map.remove(activity);
                    if (frameLayout != null) {
                        b(activity, frameLayout);
                    }
                    final FrameLayout frameLayout2 = new FrameLayout(activity);
                    frameLayout2.setTag("ttmod_badge_bulletin_overlay");
                    frameLayout2.setClipChildren(false);
                    frameLayout2.setClipToPadding(false);
                    frameLayout2.setClickable(false);
                    frameLayout2.setFocusable(false);
                    final FrameLayout frameLayoutA = a(activity, fragment, x1Var, str);
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
                    layoutParams2.y = c2.a(activity) + ((int) TypedValue.applyDimension(1, 36.0f, activity.getResources().getDisplayMetrics()));
                    windowManager.addView(frameLayout2, layoutParams2);
                    map.put(activity, frameLayout2);
                    frameLayoutA.animate().translationY(0.0f).alpha(1.0f).setDuration(300L).start();
                    a(frameLayoutA, new BadgeHooks((int) TypedValue.applyDimension(1, 6.0f, frameLayoutA.getContext().getResources().getDisplayMetrics()), frameLayoutA, (int) TypedValue.applyDimension(1, 28.0f, frameLayoutA.getContext().getResources().getDisplayMetrics()), activity, frameLayout2));
                    frameLayoutA.postDelayed(new Runnable() {
                        @Override
                        public final void run() {
                            v1.a(activity, frameLayout2, frameLayoutA);
                        }
                    }, 2500L);
                }
            } catch (Throwable th) {
                String strDecrypt = "Badge bulletin failed: %s";
                Object obj = g7.a;
                g7.a(6, String.valueOf(strDecrypt), th);
            }
        }
    }

    public static String a(x1 x1Var) {
        String str = x1Var.e;
        if (str == null) {
            str = "";
        }
        String str2 = x1Var.a + "|" + x1Var.b + "|" + x1Var.c + "|" + x1Var.d + "|" + str;
        ConcurrentHashMap concurrentHashMap = j;
        String str3 = (String) concurrentHashMap.get(str2);
        if (str3 != null) {
            return str3;
        }
        synchronized (v1.class) {
            String str4 = (String) concurrentHashMap.get(str2);
            if (str4 != null) {
                return str4;
            }
            int andIncrement = n.getAndIncrement();
            StringBuilder sb = new StringBuilder(16);
            for (int i2 = 15; i2 >= 0; i2--) {
                sb.append(((andIncrement >> i2) & 1) == 0 ? (char) 8203 : (char) 8204);
            }
            String string = sb.toString();
            j.put(str2, string);
            i.put(string, x1Var);
            return string;
        }
    }

    public static  Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "badge-supporters-refresh");
        thread.setDaemon(true);
        return thread;
    }

    public static CharSequence a(TextView textView, CharSequence charSequence) {
        CharSequence spannableStringBuilder;
        int length;
        int iIndexOf;
        x1 x1Var;
        Bitmap bitmapA;
        CharSequence charSequence2 = charSequence;
        if (charSequence2 == null) {
            return null;
        }
        if (z.get() > 0 || A.get() > 0) {
            return b(charSequence2);
        }
        int iIndexOf2 = 0;
        if (charSequence2 instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence2;
            w1[] w1VarArr = (w1[]) spanned.getSpans(0, spanned.length(), w1.class);
            if (w1VarArr != null && w1VarArr.length != 0) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spanned);
                boolean z2 = false;
                for (w1 w1Var : w1VarArr) {
                    if (w1Var != null) {
                        int spanStart = spannableStringBuilder2.getSpanStart(w1Var);
                        int spanEnd = spannableStringBuilder2.getSpanEnd(w1Var);
                        int spanFlags = spannableStringBuilder2.getSpanFlags(w1Var);
                        if (spanStart >= 0 && spanEnd > spanStart && (bitmapA = a(textView.getContext(), textView, w1Var.b)) != null) {
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(textView.getResources(), bitmapA);
                            bitmapDrawable.setBounds(0, 0, bitmapA.getWidth(), bitmapA.getHeight());
                            spannableStringBuilder2.removeSpan(w1Var);
                            spannableStringBuilder2.setSpan(new w1(bitmapDrawable, w1Var.b), spanStart, spanEnd, spanFlags);
                            z2 = true;
                        }
                    }
                }
                if (z2) {
                    spanned = spannableStringBuilder2;
                }
            }
            if (spanned != charSequence2) {
                charSequence2 = spanned;
            }
        }
        String string = charSequence2.toString();
        if (!string.contains("\ufdd0") || string.contains("⁣⁣⁤")) {
            spannableStringBuilder = charSequence2;
        } else {
            SpannableStringBuilder builder = new SpannableStringBuilder(charSequence2);
            int iIndexOf3 = 0;
            while (true) {
                iIndexOf3 = builder.toString().indexOf("\ufdd0", iIndexOf3);
                if (iIndexOf3 < 0) {
                    break;
                }
                builder.replace(iIndexOf3, iIndexOf3 + 1, "");
            }
            if (!charSequence2.toString().contains("\ufdd0")) {
                x1Var = null;
            } else {
                String strA = a(charSequence2);
                if (strA.isEmpty()) {
                    x1Var = null;
                } else {
                    x1Var = (x1) f.get(strA);
                }
            }
            if (x1Var != null && !builder.toString().contains("⁣⁣⁤")) {
                builder.append("⁣⁣⁤" + a(x1Var) + "⁤⁣⁣");
            }
            spannableStringBuilder = builder;
        }
        String string2 = spannableStringBuilder.toString();
        if (!string2.contains("⁣⁣⁤") && !string2.contains("\ufdd0")) {
            return spannableStringBuilder;
        }
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(spannableStringBuilder);
        int length2 = 0;
        boolean z3 = false;
        while (true) {
            String string3 = spannableStringBuilder3.toString();
            int iIndexOf4 = string3.indexOf("⁣⁣⁤", length2);
            if (iIndexOf4 < 0 || (iIndexOf = string3.indexOf("⁤⁣⁣", (length = "⁣⁣⁤".length() + iIndexOf4))) < 0) {
                break;
            }
            String strSubstring = string3.substring(length, iIndexOf);
            x1 x1VarA = TextUtils.isEmpty(strSubstring) ? null : (x1) i.get(strSubstring);
            if (x1VarA == null) {
                x1VarA = x1.a();
            }
            int length3 = "⁤⁣⁣".length() + iIndexOf;
            Bitmap bitmapA2 = a(textView.getContext(), textView, x1VarA);
            String str = bitmapA2 != null ? " ￼" : "";
            spannableStringBuilder3.replace(iIndexOf4, length3, (CharSequence) str);
            if (bitmapA2 != null) {
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(textView.getResources(), bitmapA2);
                bitmapDrawable2.setBounds(0, 0, bitmapA2.getWidth(), bitmapA2.getHeight());
                spannableStringBuilder3.setSpan(new w1(bitmapDrawable2, x1VarA), iIndexOf4 + 1, iIndexOf4 + 2, 33);
            }
            length2 = iIndexOf4 + str.length();
            z3 = true;
        }
        boolean z4 = false;
        while (true) {
            iIndexOf2 = spannableStringBuilder3.toString().indexOf("\ufdd0", iIndexOf2);
            if (iIndexOf2 < 0) {
                break;
            }
            spannableStringBuilder3.replace(iIndexOf2, iIndexOf2 + 1, (CharSequence) "");
            z4 = true;
        }
        return (z3 || z4 || spannableStringBuilder != charSequence2) ? spannableStringBuilder3 : charSequence2;
    }

    public static void b(final Activity activity, final Fragment fragment) {
        if (c2.b(activity)) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public final void run() {
                    v1.a(activity, fragment);
                }
            });
        }
    }

    public static void b(Activity activity, FrameLayout frameLayout) {
        WindowManager windowManager = null;
        l.remove(activity);
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

    public static CharSequence b(CharSequence charSequence) {
        if (charSequence == null) {
            return null;
        }
        String string = charSequence.toString();
        if (TextUtils.isEmpty(string) || !(a(string) || string.contains(" ￼"))) {
            return charSequence;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(charSequence);
        a(spannableStringBuilder, "⁣⁤⁣⁤⁣");
        int iIndexOf = 0;
        int iIndexOf2 = 0;
        while (true) {
            iIndexOf2 = spannableStringBuilder.toString().indexOf("\ufdd0", iIndexOf2);
            if (iIndexOf2 < 0) {
                break;
            }
            spannableStringBuilder.replace(iIndexOf2, iIndexOf2 + 1, (CharSequence) "");
        }
        while (true) {
            String string2 = spannableStringBuilder.toString();
            iIndexOf = string2.indexOf("⁣⁣⁤", iIndexOf);
            if (iIndexOf < 0) {
                a(spannableStringBuilder, " ￼");
                a(spannableStringBuilder, String.valueOf((char) 65532));
                return spannableStringBuilder;
            }
            int iIndexOf3 = string2.indexOf("⁤⁣⁣", "⁣⁣⁤".length() + iIndexOf);
            if (iIndexOf3 < 0) {
                spannableStringBuilder.replace(iIndexOf, "⁣⁣⁤".length() + iIndexOf, (CharSequence) "");
            } else {
                spannableStringBuilder.replace(iIndexOf, "⁤⁣⁣".length() + iIndexOf3, (CharSequence) "");
            }
        }
    }

    public static String b(Context context, String str) {
        String strB = a2.b(str);
        if (a2.a(strB)) {
            if (context != null && r.compareAndSet(false, true)) {
                try {
                    for (Map.Entry entry : ((Map<?, ?>) x0.b(context)).entrySet()) {
                        String strB2 = a2.b((String) entry.getKey());
                        String strB3 = a2.b((String) entry.getValue());
                        if (a2.a(strB2) && a2.a(strB3)) {
                            e.put(strB2, strB3);
                        }
                    }
                } catch (Throwable th) {
                    String strDecrypt = "Failed to read badge image redirects: %s";
                    Object obj = g7.a;
                    g7.a(6, String.valueOf(strDecrypt), th);
                }
            }
            String str2 = (String) e.get(strB);
            if (!TextUtils.isEmpty(str2)) {
                String strB4 = a2.b(str2);
                return a2.a(strB4) ? strB4 : strB;
            }
        }
        return strB;
    }

    public static String a(String str, String str2) {
        x1 x1VarC;
        if (z.get() > 0 || A.get() > 0) {
            CharSequence charSequenceB = b((CharSequence) str2);
            if (charSequenceB != null) {
                return charSequenceB.toString();
            }
            return null;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (x1VarC = c(str)) == null || a(str2)) {
            return str2;
        }
        a(str2, x1VarC);
        return str2 + "\ufdd0" + ("⁣⁣⁤" + a(x1VarC) + "⁤⁣⁣");
    }

    public static void a(Context context) {
        String[] strArr;
        if (b.isEmpty() && (strArr = a) != null && strArr.length != 0) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    String strTrim = str.trim();
                    if (!strTrim.isEmpty()) {
                        linkedHashMap.put(strTrim, new x1(strTrim, "asset:supporter.png", true, false, null, null));
                    }
                }
            }
            if (!linkedHashMap.isEmpty()) {
                a(linkedHashMap);
            }
        }
        if (context == null) {
            return;
        }
        if (p.compareAndSet(false, true)) {
            char[] cArr = x0.a;
            File file = new File(x0.a(context), "supporters_cache.txt");
            String strA = x0.a(file);
            if (!TextUtils.isEmpty(strA)) {
                LinkedHashMap linkedHashMapB = y0.b(strA);
                if (linkedHashMapB.isEmpty()) {
                    if (file.exists()) {
                        file.setLastModified(0L);
                    }
                    File file2 = new File(x0.a(context), "supporters_fetch.stamp");
                    if (file2.exists()) {
                        file2.setLastModified(0L);
                    }
                    String strDecrypt = "Ignored invalid supporters cache";
                    Object obj = g7.a;
                    g7.a(4, String.valueOf(strDecrypt), (Throwable) null);
                    c(context);
                } else {
                    a(linkedHashMapB);
                    if (!x0.a(new File(x0.a(context), "supporters_cache.txt"), new File(x0.a(context), "supporters_fetch.stamp"), 7200000L)) {
                        d(context);
                    }
                    g7.a(4, g7.a("Loaded %d supporter uid(s) from cache", new Object[]{Integer.valueOf(linkedHashMapB.size())}), (Throwable) null);
                }
            } else {
                c(context);
            }
        }
        a(context, false, (u1) null);
    }

    public static boolean a(final Context context, final boolean z2, final u1 u1Var) {
        if (context == null) {
            return false;
        }
        char[] cArr = x0.a;
        final File file = new File(x0.a(context), "supporters_cache.txt");
        File file2 = new File(x0.a(context), "supporters_fetch.stamp");
        if ((!z2 && !x0.a(new File(x0.a(context), "supporters_cache.txt"), new File(x0.a(context), "supporters_fetch.stamp"), 7200000L)) || !q.compareAndSet(false, true)) {
            return false;
        }
        x0.b(file2);
        new Thread(new Runnable() {
            @Override
            public final void run() {
                v1.a(context, file, z2, u1Var);
            }
        }, "badge-supporters-fetch").start();
        return true;
    }

    public static void a(Context context, File file, boolean z2, u1 u1Var) {
        Throwable thU = null;
        int r13 = 0;
        boolean z3;
        String strValueOf = "aes";
        String str = null;
        try {
            char[] cArr = x0.a;
            File file2 = new File(x0.a(context), "supporters_cache.etag");
            String strA = file.exists() ? x0.a(file2) : null;
            w0 w0VarA = a(strA, z2);
            z3 = true;
            try {
                try {
                    if (w0VarA.a == 304) {
                        x0.b(file);
                        int size = b.size();
                        String strDecrypt = "Supporters list not modified";
                        q.set(false);
                        b(u1Var, true, size, strDecrypt);
                        return;
                    }
                    String strA2 = w0VarA.b;
                    if (w0VarA.d && (strA2 = y0.a(x0.a(file), strA2, strA)) == null) {
                        String strDecrypt2 = "Supporters delta did not apply, fetching the full list";
                        Object obj = g7.a;
                        g7.a(4, String.valueOf(strDecrypt2), (Throwable) null);
                        w0VarA = a((String) null, z2);
                        strA2 = w0VarA.b;
                    }
                    if (TextUtils.isEmpty(strA2)) {
                        throw new IOException("Empty supporters list");
                    }
                    LinkedHashMap linkedHashMapB = y0.b(strA2);
                    if (linkedHashMapB.isEmpty()) {
                        throw new IOException("Invalid supporters list");
                    }
                    x0.a(file, strA2);
                    if (!TextUtils.isEmpty(w0VarA.c)) {
                        x0.a(file2, w0VarA.c);
                    } else if (file2.exists()) {
                        file2.delete();
                    }
                    a(linkedHashMapB);
                    d(context);
                    int size2 = linkedHashMapB.size();
                    String str2 = "Loaded " + size2 + " supporter uid(s)";
                    try {
                        g7.a(4, g7.a("Loaded %d supporter uid(s) from GitHub", new Object[]{Integer.valueOf(linkedHashMapB.size())}), (Throwable) null);
                        q.set(false);
                        b(u1Var, true, size2, str2);
                    } catch (Throwable th) {
                        r13 = size2;
                        th = th;
                        str = str2;
                        try {
                            String strDecrypt3 = "Failed to load supporters list: %s";
                            Object obj2 = g7.a;
                            strValueOf = String.valueOf(strDecrypt3);
                            g7.a(6, strValueOf, th);
                            if (b.isEmpty()) {
                                c(context);
                            }
                        } finally {
                            q.set(false);
                            b(u1Var, z3, (int) r13, str);
                        }
                    }
                } catch (Throwable th2) {
                    r13 = 0;
                    thU = th2;
                }
            } catch (Throwable th3) {
                thU = th3;
                r13 = 0;
            }
        } catch (Throwable th4) {
            thU = th4;
            r13 = 0;
            z3 = false;
        }
    }

    public static w0 a(final String str, boolean z2) {
        if (z2) {
            return (w0) Z.t.a(new Callable() {
                @Override
                public final Object call() {
                    return x0.a("https://tiktokyou.yzewe.ru/api/v1/badges", str);
                }
            });
        }
        return x0.a("https://tiktokyou.yzewe.ru/api/v1/badges", str);
    }

    public static void a(LinkedHashMap linkedHashMap) {
        if (linkedHashMap.isEmpty()) {
            return;
        }
        ConcurrentHashMap concurrentHashMap = b;
        concurrentHashMap.clear();
        concurrentHashMap.putAll(linkedHashMap);
        f.clear();
        g.clear();
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (x1 x1Var : ((Map<String, x1>) linkedHashMap).values()) {
            if (x1Var != null && !TextUtils.isEmpty(x1Var.a) && !TextUtils.isEmpty(x1Var.f)) {
                linkedHashMap2.put(x1Var.a, x1Var.f);
            }
        }
    }

    public static void a(Class cls, v9 v9Var) {
        try {
            a(cls, v9Var, new n1());
        } catch (Throwable th) {
            String strDecrypt = "Failed to hook nickname context";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static void a(Class cls, v9 v9Var, v9 v9Var2, int i2) {
        try {
            a(cls, v9Var, new q1());
            a(cls, v9Var2, new r1(i2));
        } catch (Throwable th) {
            String strDecrypt = "Failed to hook nickname builders";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static void a(Class cls, v9 v9Var, int i2) {
        try {
            a(cls, v9Var, new s1(i2));
        } catch (Throwable th) {
            String strDecrypt = "Failed to hook nickname text argument";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static void a(HookMethod.HookMethodParam hookMethodParam, int i2) {
        Object objAppend;
        ae aeVarA;
        Object[] objArr = hookMethodParam.args;
        if (objArr.length > i2) {
            Object obj = objArr[i2];
            if (obj instanceof String) {
                String str = (String) obj;
                Object obj2 = hookMethodParam.thisObject;
                if (TextUtils.isEmpty(str) || (aeVarA = a(obj2)) == null) {
                    objAppend = str;
                } else {
                    String string = str.toString();
                    String strA = a(aeVarA.a, string);
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

    public static ae a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            Object objB = b(obj);
            if (objB != null) {
                Object objInvoke = se.a(objB.getClass(), "getUserProfileInfo", new Class[0]).invoke(objB, null);
                if (objInvoke instanceof UserProfileInfo) {
                    UserProfileInfo userProfileInfo = (UserProfileInfo) objInvoke;
                    String uid = userProfileInfo.getUid();
                    if (!TextUtils.isEmpty(uid) && c(uid) != null) {
                        return new ae(uid, a((CharSequence) userProfileInfo.getNickname()), d(uid));
                    }
                }
            }
        } catch (Throwable th) {
        }
        String str = w;
        if (TextUtils.isEmpty(str) || c(str) == null) {
            return null;
        }
        return new ae(str, x, d(str));
    }

    public static boolean a(TextView textView, MotionEvent motionEvent) {
        Spanned spanned;
        w1 w1Var;
        Activity activity;
        Fragment fragment = null;
        String str;
        CharSequence text = textView.getText();
        String str2 = null;
        if (text instanceof Spanned) {
            spanned = (Spanned) text;
            w1[] w1VarArr = (w1[]) spanned.getSpans(0, spanned.length(), w1.class);
            if (w1VarArr == null || w1VarArr.length == 0) {
                spanned = null;
            }
        } else {
            spanned = null;
        }
        Map map = k;
        b2 b2Var = (b2) map.get(textView);
        int actionMasked = motionEvent.getActionMasked();
        switch (actionMasked) {
            case 0:
                break;
            case 1:
                break;
            case 2:
                break;
            case 3:
                break;
            default:
                String.valueOf(actionMasked);
                break;
        }
        if (spanned == null) {
            if (b2Var != null) {
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
                w1 w1VarA = a(textView, spanned, motionEvent);
                if (w1VarA == null) {
                    map.remove(textView);
                    ViewParent parent2 = textView.getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(false);
                    }
                    return false;
                }
                if (w1VarA.b == null) {
                }
                map.put(textView, new b2(w1VarA));
                ViewParent parent3 = textView.getParent();
                if (parent3 != null) {
                    parent3.requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 1:
                if (b2Var == null) {
                    return false;
                }
                w1 w1VarA2 = a(textView, spanned, motionEvent);
                if (!b2Var.b && w1VarA2 == (w1Var = b2Var.a)) {
                    x1 x1Var = w1Var.b;
                    Context context = textView.getContext();
                    while (true) {
                        if (context instanceof ContextWrapper) {
                            if (context instanceof Activity) {
                                activity = (Activity) context;
                                break;
                            } else {
                                context = ((ContextWrapper) context).getBaseContext();
                            }
                        } else {
                            activity = context instanceof Activity ? (Activity) context : null;
                            break;
                        }
                    }
                    try {
                        Class<?> cls = Class.forName("androidx.fragment.app.FragmentManager", false, textView.getClass().getClassLoader());
                        String[] strArr = (String[]) g9.a.c.clone();
                        int length = strArr.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 < length) {
                                try {
                                    Object objInvoke = se.a(cls, strArr[i2], View.class).invoke(null, textView);
                                    if (objInvoke instanceof Fragment) {
                                        fragment = (Fragment) objInvoke;
                                    }
                                } catch (Throwable th) {
                                    i2++;
                                }
                            }
                            fragment = null;
                        }
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
                            iIndexOf = string.indexOf("⁣⁤⁣⁤⁣");
                        }
                        if (iIndexOf < 0) {
                            iIndexOf = string.indexOf("⁣⁣⁤");
                        }
                        if (iIndexOf > 0) {
                            string = string.substring(0, iIndexOf);
                        }
                        String strA = a((CharSequence) string);
                        if (!TextUtils.isEmpty(strA)) {
                            str2 = strA;
                        } else if (x1Var != null) {
                            str = (String) g.get(x1Var.a);
                            if (!TextUtils.isEmpty(str)) {
                                str2 = str;
                            }
                        }
                    } else if (x1Var != null && !TextUtils.isEmpty(x1Var.a)) {
                        str = (String) g.get(x1Var.a);
                        if (!TextUtils.isEmpty(str)) {
                            str2 = str;
                        }
                    }
                    if (x1Var == null) {
                    }
                    if (activity == null) {
                    }
                    if (fragment == null) {
                    }
                    if (activity != null) {
                        c(activity, fragment, x1Var, str2);
                    }
                }
                k.remove(textView);
                ViewParent parent4 = textView.getParent();
                if (parent4 != null) {
                    parent4.requestDisallowInterceptTouchEvent(false);
                }
                return true;
            case 2:
                if (b2Var == null) {
                    return false;
                }
                b2Var.b = a(textView, spanned, motionEvent) != b2Var.a;
                return true;
            case 3:
                if (b2Var == null) {
                    return false;
                }
                map.remove(textView);
                ViewParent parent5 = textView.getParent();
                if (parent5 != null) {
                    parent5.requestDisallowInterceptTouchEvent(false);
                }
                return true;
            default:
                return b2Var != null;
        }
    }

    public static w1 a(TextView textView, Spanned spanned, MotionEvent motionEvent) {
        int iWidth;
        Layout layout = textView.getLayout();
        if (layout == null) {
            return null;
        }
        float x2 = (motionEvent.getX() - textView.getTotalPaddingLeft()) + textView.getScrollX();
        float y2 = (motionEvent.getY() - textView.getTotalPaddingTop()) + textView.getScrollY();
        if (x2 >= 0.0f && y2 >= 0.0f) {
            w1[] w1VarArr = (w1[]) spanned.getSpans(0, spanned.length(), w1.class);
            if (w1VarArr != null && w1VarArr.length != 0) {
                int scaledTouchSlop = ViewConfiguration.get(textView.getContext()).getScaledTouchSlop();
                for (w1 w1Var : w1VarArr) {
                    if (w1Var != null) {
                        int spanStart = spanned.getSpanStart(w1Var);
                        int spanEnd = spanned.getSpanEnd(w1Var);
                        if (spanStart >= 0 && spanEnd > spanStart) {
                            int lineForOffset = layout.getLineForOffset(spanStart);
                            float lineTop = layout.getLineTop(lineForOffset) - scaledTouchSlop;
                            float lineBottom = layout.getLineBottom(lineForOffset) + scaledTouchSlop;
                            if (y2 >= lineTop && y2 <= lineBottom) {
                                float fMin = Math.min(layout.getPrimaryHorizontal(spanStart), layout.getPrimaryHorizontal(spanEnd));
                                float fMax = Math.max(layout.getPrimaryHorizontal(spanStart), layout.getPrimaryHorizontal(spanEnd));
                                BitmapDrawable bitmapDrawable = w1Var.a;
                                if (bitmapDrawable != null && (iWidth = bitmapDrawable.getBounds().width()) > 0) {
                                    float f2 = iWidth;
                                    if (fMax - fMin < f2) {
                                        fMax = fMin + f2;
                                    }
                                }
                                float f3 = scaledTouchSlop;
                                if (x2 >= fMin - f3 && x2 <= fMax + f3) {
                                    return w1Var;
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void a(w7 w7Var, v9 v9Var, i2 i2Var) {
        try {
            HookBridge.hookAllMethods(Class.forName(w7Var.b), v9Var.c[0], new e1(i2Var));
        } catch (Throwable th) {
            String strDecrypt = "Failed to hook ChatListNameModel#getName";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static void a(Fragment fragment, x1 x1Var, View view) {
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
        FrameLayout frameLayout = (FrameLayout) l.get(activity);
        if (frameLayout != null) {
            b(activity, frameLayout);
        }
        b(activity, fragment);
    }

    public static void a(Class cls, v9 v9Var, HookMethod hookMethod) {
        for (String str : (String[]) v9Var.c.clone()) {
            try {
                HookBridge.hookAllMethods(cls, str, hookMethod);
            } catch (Throwable th) {
            }
        }
    }

    public static void a(View view, BadgeHooks l1Var) {
        view.setOnTouchListener(l1Var);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(viewGroup.getChildAt(i2), l1Var);
            }
        }
    }

    public static void a(final Activity activity, final FrameLayout frameLayout, View view) {
        if (frameLayout == null) {
            l.remove(activity);
        } else if (frameLayout.getParent() != null && view != null && view.getParent() != null) {
            view.animate().translationY((int) TypedValue.applyDimension(1, 100.0f, view.getContext().getResources().getDisplayMetrics())).alpha(0.0f).setDuration(220L).withEndAction(new Runnable() {
                @Override
                public final void run() {
                    v1.b(activity, frameLayout);
                }
            }).start();
        } else {
            b(activity, frameLayout);
        }
    }

    public static void a(final Activity activity, final Fragment fragment) {
        if (c2.b(activity)) {
            try {
                Dialog dialog = (Dialog) m.remove(activity);
                if (dialog != null) {
                    try {
                        dialog.dismiss();
                    } catch (Throwable th) {
                    }
                }
                fc fcVarA = new fc(activity).b("ic_startup_logo").b((CharSequence) k7.a("badge_sheet_title", "Поддержите разработку")).a((CharSequence) k7.a("badge_sheet_subtitle", "Станьте спонсором разработки и получите уникальный значок в профиль"));
                LinearLayout linearLayoutA = fcVarA.a(4);
                LinearLayout linearLayoutA2 = fcVarA.a("ic_coin", a(), k7.a("badge_sheet_step1_subtitle", "Переведите сумму по любым из наших реквизитов"), null, null);
                linearLayoutA2.setGravity(48);
                linearLayoutA.addView(linearLayoutA2);
                LinearLayout linearLayoutA3 = fcVarA.a("ic_mod_logo", k7.a("badge_sheet_step3_title", "Получите значок"), k7.a("badge_sheet_step3_subtitle", "После проверки он появится в вашем профиле и будет виден всем"), null, null);
                linearLayoutA3.setGravity(48);
                linearLayoutA.addView(linearLayoutA3);
                fcVarA.a().addView(linearLayoutA);
                fcVarA.b(k7.a("badge_sheet_support", "Пожертвовать"), new Runnable() {
                    @Override
                    public final void run() {
                        v1.a(fragment, activity);
                    }
                });
                fcVarA.c(k7.a("badge_sheet_copy_uid", "Скопировать мой UID"), new Runnable() {
                    @Override
                    public final void run() {
                        v1.a(activity);
                    }
                });
                fcVarA.x = new Runnable() {
                    @Override
                    public final void run() {
                        v1.m.remove(activity);
                    }
                };
                m.put(activity, fcVarA.b);
                fcVarA.g();
            } catch (Throwable th2) {
                String strDecrypt = "Supporter details sheet failed";
                Object obj = g7.a;
                g7.a(6, String.valueOf(strDecrypt), th2);
            }
        }
    }

    public static void a(Fragment fragment, Activity activity) {
        if (fragment != null) {
        }
        if (activity == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/tt_ubot"));
            intent.addFlags(268435456);
            activity.startActivity(intent);
        } catch (Throwable th) {
            String strDecrypt = "Failed to open support bot";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static String a() {
        rg rgVar = C != null ? C : new rg("5", "500");
        return String.format(k7.a("badge_sheet_step1_title_format", "Пожертвуйте не менее $%1$s (%2$s₽)"), rgVar.a, rgVar.b);
    }

    public static void a(Activity activity) {
        String strL = l();
        if (TextUtils.isEmpty(strL)) {
            Toast.makeText(activity, k7.a("copy_uid_unavailable"), 0).show();
            return;
        }
        ClipboardManager clipboardManager = (ClipboardManager) activity.getSystemService("clipboard");
        if (clipboardManager == null) {
            Toast.makeText(activity, k7.a("copy_uid_failed"), 0).show();
            return;
        }
        try {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("uid", strL));
            Toast.makeText(activity, k7.a("copy_uid_copied"), 0).show();
        } catch (Throwable th) {
            Toast.makeText(activity, k7.a("copy_uid_failed"), 0).show();
        }
    }

    public static FrameLayout a(Activity activity, final Fragment fragment, final x1 x1Var, String str) {
        String strReplace;
        int iMax;
        boolean z2 = activity != null && (activity.getResources().getConfiguration().uiMode & 48) == 32;
        int color = z2 ? Color.parseColor("#1E1E1E") : -1;
        int color2 = z2 ? -1 : Color.parseColor("#161823");
        ac acVarA = ac.a();
        int color3 = (acVarA == null || !acVarA.g()) ? Color.parseColor("#FE2B54") : zh.a();
        FrameLayout frameLayout = new FrameLayout(activity);
        int iA = (int) c3.a(activity, 1, 14.0f);
        int iA2 = (int) c3.a(activity, 1, 12.0f);
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
        int iA3 = (int) c3.a(activity, 1, 26.0f);
        x1 x1Var2 = x1Var != null ? new x1(x1Var.a, x1Var.b, x1Var.c, x1Var.d, x1Var.e, x1Var.f) : x1.a();
        String strB = a2.a(x1Var2.b) ? b(activity, x1Var2.b) : x1Var2.b;
        int iMax2 = Math.max(1, iA3);
        StringBuilder sb = new StringBuilder();
        boolean z3 = x1Var2.c;
        boolean z4 = x1Var2.d;
        String str2 = x1Var2.e;
        String str3 = x1Var2.f;
        String strB2 = a2.b(strB);
        if (str2 != null) {
            str2.isEmpty();
        }
        if (str3 != null) {
            str3.isEmpty();
        }
        String string = sb.append(strB2 + "|" + z3 + "|" + z4).append("::bulletin::").append(iMax2).toString();
        d2 d2Var = d;
        Bitmap bitmapA = (Bitmap) d2Var.get(string);
        if (!a(bitmapA)) {
            v0 v0VarA = a(activity, x1Var);
            if (v0VarA != null) {
                String str4 = v0VarA.a + "::bulletin::" + iMax2;
                Bitmap bitmap = (Bitmap) d2Var.get(str4);
                if (a(bitmap)) {
                    bitmapA = bitmap;
                } else {
                    Bitmap bitmap2 = v0VarA.b;
                    if (a(bitmap2)) {
                        if (a(bitmap2)) {
                            iMax = Math.max(1, Math.round(Math.max(1, iMax2) * Math.min(4.0f, Math.max(0.25f, bitmap2.getWidth() / bitmap2.getHeight()))));
                        } else {
                            iMax = 1;
                        }
                        bitmapA = a(bitmap2, iMax, iMax2);
                        if (a(bitmapA)) {
                            Bitmap bitmapA2 = (x1Var == null || !x1Var.c) ? bitmapA : a(bitmapA, f(activity));
                            if (a(bitmapA2)) {
                                bitmapA = bitmapA2;
                            }
                            d2Var.put(str4, bitmapA);
                        } else {
                            bitmapA = null;
                        }
                    } else {
                        bitmapA = null;
                    }
                }
            } else {
                bitmapA = null;
            }
        }
        if (bitmapA != null) {
            imageView.setImageBitmap(bitmapA);
        }
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = (int) c3.a(activity, 1, 10.0f);
        layoutParams.rightMargin = (int) c3.a(activity, 1, 6.0f);
        linearLayout.addView(linearLayout2, layoutParams);
        TextView textView = new TextView(activity);
        String strA = !TextUtils.isEmpty(str) ? str : k7.a("badge_bulletin_unknown_name", "Этот человек");
        if (x1Var == null || TextUtils.isEmpty(x1Var.e)) {
            strReplace = (x1Var == null || !x1Var.d) ? String.format(k7.a("badge_bulletin_supporter_format", "%s поддержал разработку TikTok You"), strA) : String.format(k7.a("badge_bulletin_developer_format", "%s член команды разработки TikTok You"), strA);
        } else {
            strReplace = x1Var.e.replace("${1}", strA);
        }
        textView.setText(strReplace);
        textView.setTextSize(2, 14.0f);
        textView.setLineSpacing(0.0f, 1.0f);
        textView.setTextColor(color2);
        x5.a("o7PbV/KpOYK2cDA6H5IAWw322y1LSKFLaHehOtvbT4qGQhVJTWd4UJnH0QNz9Lzx", "c59bmeUnGKmWfVTm", "aes", 0, textView);
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(activity);
        textView2.setText(k7.a("badge_bulletin_button", "Подробнее"));
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 13.0f);
        x5.a("DhfR5td8Kn0amzgT+yF/a2K+vm1S8xyVU+1iDe+DX2x5UQXzeJku5UYV3H7BPDoG", "LJ4gvxwFntoU78P3", "aes", 0, textView2);
        textView2.setGravity(17);
        textView2.setPadding((int) TypedValue.applyDimension(1, 16.0f, activity.getResources().getDisplayMetrics()), 0, (int) c3.a(activity, 1, 16.0f), 0);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(color3);
        gradientDrawable2.setCornerRadius((int) TypedValue.applyDimension(1, 68.0f, activity.getResources().getDisplayMetrics()));
        textView2.setBackground(gradientDrawable2);
        textView2.setMinHeight((int) TypedValue.applyDimension(1, 32.0f, activity.getResources().getDisplayMetrics()));
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                v1.a(fragment, x1Var, view);
            }
        });
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-2, (int) c3.a(activity, 1, 32.0f)));
        return frameLayout;
    }

    public static boolean a(ae aeVar, String str) {
        if (!TextUtils.isEmpty(str) && str.charAt(0) != '@') {
            String strA = a((CharSequence) str);
            if (!strA.isEmpty() && strA.indexOf(10) < 0) {
                if (TextUtils.isEmpty(aeVar.b)) {
                    return true;
                }
                String str2 = aeVar.b;
                if (TextUtils.isEmpty(str2) || (!TextUtils.equals(strA, str2) && !strA.startsWith(str2) && !str2.startsWith(strA))) {
                    String str3 = aeVar.c;
                    if (TextUtils.isEmpty(str3) || (!TextUtils.equals(strA, str3) && !strA.startsWith(str3) && !str3.startsWith(strA))) {
                        return false;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static boolean a(StringBuilder sb, int i2) {
        if (i2 >= 0 && i2 < sb.length()) {
            if ("⁣⁤⁣⁤⁣".length() + i2 <= sb.length() && sb.indexOf("⁣⁤⁣⁤⁣", i2) == i2) {
                return true;
            }
            if (i2 + 1 <= sb.length() && sb.indexOf("\ufdd0", i2) == i2) {
                return true;
            }
            if ("⁣⁣⁤".length() + i2 <= sb.length() && sb.indexOf("⁣⁣⁤", i2) == i2) {
                return true;
            }
        }
        return false;
    }

    public static void a(SpannableStringBuilder spannableStringBuilder, String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        int iIndexOf = 0;
        while (true) {
            iIndexOf = spannableStringBuilder.toString().indexOf(str, iIndexOf);
            if (iIndexOf < 0) {
                return;
            } else {
                spannableStringBuilder.replace(iIndexOf, str.length() + iIndexOf, "");
            }
        }
    }

    public static void a(String str, x1 x1Var) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strA = a((CharSequence) str);
        if (strA.isEmpty()) {
            return;
        }
        f.put(strA, x1Var);
        if (!TextUtils.isEmpty(x1Var.a)) {
            g.put(x1Var.a, strA);
        }
        a(x1Var);
    }

    public static String a(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence.toString().replace("⁣⁤⁣⁤⁣", "").replace("\ufdd0", "").replace("⁣⁣⁤", "").replace("⁤⁣⁣", "").replace(String.valueOf((char) 8203), "").replace(String.valueOf((char) 8204), "").replace(" ￼", "").replace("￼", "").replace((char) 160, ' ').trim();
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("⁣⁤⁣⁤⁣") || str.contains("\ufdd0") || str.contains("⁣⁣⁤");
    }

    public static Bitmap a(Bitmap bitmap, int i2) {
        if (!a(bitmap)) {
            return null;
        }
        try {
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
            Canvas canvas = new Canvas(bitmapCreateBitmap);
            Paint paint = new Paint(3);
            boolean z2 = zh.d;
            zh.d = false;
            try {
                paint.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_IN));
                zh.d = z2;
                try {
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                    return bitmapCreateBitmap;
                } catch (Throwable th) {
                    String strDecrypt = "Failed to tint badge bitmap";
                    Object obj = g7.a;
                    g7.a(6, String.valueOf(strDecrypt), th);
                    return null;
                }
            } catch (Throwable th2) {
                zh.d = z2;
                throw th2;
            }
        } catch (Throwable th3) {
            String strDecrypt2 = "Failed to allocate tinted badge bitmap";
            Object obj2 = g7.a;
            g7.a(6, String.valueOf(strDecrypt2), th3);
            return null;
        }
    }

    public static Bitmap a(Bitmap bitmap, int i2, int i3) {
        if (!a(bitmap)) {
            return null;
        }
        try {
            return Bitmap.createScaledBitmap(bitmap, Math.max(1, i2), Math.max(1, i3), true);
        } catch (Throwable th) {
            String strDecrypt = "Failed to scale badge bitmap: %s";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
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

    public static Bitmap a(Context context, String str) {
        String strDecrypt;
        String strB = a2.b(str);
        ConcurrentHashMap concurrentHashMap = c;
        Bitmap bitmap = (Bitmap) concurrentHashMap.get(strB);
        if (a(bitmap)) {
            return bitmap;
        }
        synchronized (v1.class) {
            Bitmap bitmap2 = (Bitmap) concurrentHashMap.get(strB);
            if (a(bitmap2)) {
                return bitmap2;
            }
            if (strB.startsWith("asset:")) {
                strDecrypt = strB.substring("asset:".length());
            } else {
                strDecrypt = "supporter.png";
            }
            try {
                InputStream inputStreamOpen = ResourceOverlay.open(context, strDecrypt);
                try {
                    Bitmap bitmapDecodeStream = BitmapFactory.decodeStream(inputStreamOpen);
                    if (bitmapDecodeStream != null) {
                        concurrentHashMap.put(strB, bitmapDecodeStream);
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
                g7.a(6, g7.a("Failed to load asset badge %s: %s", new Object[]{strDecrypt, e2}), (Throwable) null);
                return null;
            }
        }
    }

    public static void a(String str, Context context, String str2) {
        if (context == null) {
            return;
        }
        String strB = a2.b(str);
        String strB2 = a2.b(str2);
        if (a2.a(strB) && a2.a(strB2) && !TextUtils.equals(strB, strB2)) {
            ConcurrentHashMap concurrentHashMap = e;
            concurrentHashMap.put(strB, strB2);
            char[] cArr = x0.a;
            if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : ((Map<?, ?>) concurrentHashMap).entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                    sb.append((String) entry.getKey()).append('\t').append((String) entry.getValue()).append('\n');
                }
            }
            try {
                x0.a(new File(x0.a(context), "image_redirects.txt"), sb.toString());
            } catch (IOException e) {
                g7.a(6, g7.a("Failed to write badge image redirects: %s", new Object[]{e.getMessage()}), (Throwable) null);
            }
        }
    }

    public static void a(String str, Context context) {
        Bitmap bitmap = null;
        try {
            char[] cArr = x0.a;
            String strDecrypt = "TTMod-BadgeHooks/5.0";
            AtomicBoolean atomicBoolean = Z.t.a;
            s sVarA = Z.t.a(str, strDecrypt, 16777216, MapsKt.emptyMap(), (String) null);
            byte[] bArr = sVarA.b;
            String str2 = sVarA.d;
            if (bArr != null && bArr.length != 0) {
                Bitmap bitmapA = w4.a(bArr, 512);
                if (bitmapA != null) {
                    String strB = a2.b(str2);
                    w4.a(x0.a(context, strB), bitmapA);
                    if (!TextUtils.equals(strB, str)) {
                        a(str, context, strB);
                    }
                    d2 d2Var = d;
                    d2Var.a(str + "|");
                    d2Var.a(strB + "|");
                    if (a(bitmapA)) {
                        bitmapA.recycle();
                    }
                    h.remove(str);
                    return;
                }
                throw new IOException("Invalid badge image");
            }
            throw new IOException("Empty badge data");
        } catch (Throwable th) {
            try {
                g7.a(6, g7.a("Failed to download custom badge: %s", new Object[]{str}), th);
            } finally {
                if (a((Bitmap) null)) {
                    bitmap.recycle();
                }
                h.remove(str);
            }
        }
    }

    public static String a(IMConversation iMConversation) {
        List<String> memberIdList;
        if (iMConversation == null || (memberIdList = iMConversation.getMemberIdList()) == null || memberIdList.isEmpty()) {
            return null;
        }
        String strL = l();
        String str = null;
        for (String str2 : memberIdList) {
            if (!TextUtils.isEmpty(str2)) {
                String strTrim = str2.trim();
                if (!strTrim.isEmpty() && (TextUtils.isEmpty(strL) || !TextUtils.equals(strL, strTrim))) {
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
}
