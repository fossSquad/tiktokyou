package com.windukk.mod.hooks;

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
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
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
import com.windukk.mod.Main;
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

public abstract class BadgeHooks {
    public static volatile String A;
    public static volatile ze B;
    public static final String[] a;
    public static final ConcurrentHashMap b;
    public static final ConcurrentHashMap c;
    public static final t1 d;
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
    public static final AtomicInteger y;
    public static final AtomicInteger z;

    static {
        a = new String[0];
        b = new ConcurrentHashMap();
        c = new ConcurrentHashMap();
        d = new t1(4194304);
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
                return BadgeHooks.h();
            }
        });
        y = new AtomicInteger(0);
        z = new AtomicInteger(0);
        B = new ze("5", "500");
    }

    public static  int a(int i2) {
        if (i2 > 0) {
            return i2 - 1;
        }
        return 0;
    }

    public static void b(final k1 k1Var, final boolean z2, final int i2, final String str) {
        if (k1Var == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public final void run() {
                k1Var.a(z2, i2, str);
            }
        });
    }

    public static void c(Context context) {
        String strB = m0.b(context, "tty_badges/supporters_fallback.json");
        if (TextUtils.isEmpty(strB)) {
            return;
        }
        LinkedHashMap linkedHashMapB = n0.b(strB);
        if (linkedHashMapB.isEmpty()) {
            return;
        }
        a(linkedHashMapB);
        try {
            m0.a(new File(m0.a(context), "supporters_cache.txt"), strB);
            m0.b(new File(m0.a(context), "supporters_fetch.stamp"));
        } catch (IOException e2) {
            h6.a(6, h6.a("Failed to persist build fallback: %s", new Object[]{e2.getMessage()}), (Throwable) null);
        }
        e(context);
        h6.a(4, h6.a("Loaded %d supporter uid(s) from build fallback", new Object[]{Integer.valueOf(linkedHashMapB.size())}), (Throwable) null);
    }

    public static void d() {
        HookBridge.hookAllMethods(UserProfileInfo.class, "getNickname", new c1());
        a(ProfileNavbarNickNameProtocol.class, g9.a);
        a(ProfileNavbarOtherNicknameProtocol.class, h9.a);
        a(ProfileInfoNicknameProtocol.class, d9.a);
        a(ProfileInfoOtherNicknameProtocol.class, e9.a);
        a(ProfileNavbarNickNameProtocol.class, g9.c, g9.d, 2);
        a(ProfileNavbarOtherNicknameProtocol.class, h9.c, h9.d, 1);
        a(ProfileNavbarOtherNicknameProtocol.class, h9.e, 0);
        a(ProfileInfoNicknameProtocol.class, d9.c, 0);
        a(ProfileInfoNicknameProtocol.class, d9.d, 2);
        a(ProfileInfoNicknameProtocol.class, d9.e, 2);
        a(ProfileInfoNicknameProtocol.class, d9.f, 0);
        try {
            a(ProfileInfoNicknameProtocol.class, d9.g, new j1(0));
        } catch (Throwable th) {
            String strDecrypt = "%s: failed to hook nickname charsequence argument";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
        a(ProfileInfoOtherNicknameProtocol.class, e9.c, 1);
        try {
            HookBridge.hookAllMethods(Describe.class, "getText", new e1());
        } catch (Throwable th2) {
            String strDecrypt2 = "Failed to hook profile describe text: %s";
            Object obj2 = h6.a;
            h6.a(6, String.valueOf(strDecrypt2), th2);
        }
        try {
            HookBridge.hookAllMethods(Class.forName("com.ss.android.ugc.profile.business.profile.ui.v2.I18nUserProfileFragment"), "getUser", new f1());
        } catch (Throwable th3) {
            String strDecrypt3 = "Failed to hook profile user capture: %s";
            Object obj3 = h6.a;
            h6.a(6, String.valueOf(strDecrypt3), th3);
        }
    }

    public static void e(Context context) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        for (n1 n1Var : b.values()) {
            if (n1Var != null && q1.a(n1Var.b)) {
                linkedHashSet.add(c(context, n1Var.b));
            }
        }
        for (String str : linkedHashSet) {
            if (q1.a(str)) {
                d(context, str);
            }
        }
    }

    public static void f() {
        try {
            Context contextA = Main.a();
            a(contextA);
            h(contextA);
            if (contextA != null) {
                char[] cArr = m0.a;
                ze zeVarA = n0.a(m0.a(new File(m0.a(contextA), "support_price_cache.json")));
                if (zeVarA != null) {
                    B = zeVarA;
                }
                f(contextA);
            }
            bb.a();
            HookMethod hookMethod = qa.a;
            try {
                HookBridge.hookAllMethods(MentionContainerViewModel.class, o8.a.c[0], qa.a);
            } catch (Throwable th) {
                String strDecrypt = "Exception during mention hooks";
                Object obj = h6.a;
                h6.a(6, String.valueOf(strDecrypt), th);
            }
            e();
            d();
            o0 o0Var = new o0();
            HookBridge.hookAllMethods(BaseContact.class, "getNickName", o0Var);
            HookBridge.hookAllMethods(BaseContact.class, "getDisplayName", o0Var);
            c();
            b();
            HookBridge.hookAllMethods(VideoAuthorInfoVM.class, ja.a.c[0], new r0());
            try {
                HookBridge.hookAllConstructors(FriendsV3RepostModel.class, new s0());
            } catch (Throwable th2) {
                String strDecrypt2 = "Failed to hook FriendsV3RepostModel";
                Object obj2 = h6.a;
                h6.a(6, String.valueOf(strDecrypt2), th2);
            }
            a(t6.a, t6.b, z1.a);
            w6 w6Var = u6.a;
            p8 p8Var = u6.b;
            z1 z1Var = z1.b;
            a(w6Var, p8Var, z1Var);
            a(v6.a, v6.b, z1Var);
            try {
                HookBridge.hookAllMethods(IMFriendsServiceImpl.class, f8.a.c[0], new u0());
            } catch (Throwable th3) {
                String strDecrypt3 = "Failed to hook IMFriendsServiceImpl";
                Object obj3 = h6.a;
                h6.a(6, String.valueOf(strDecrypt3), th3);
            }
            a();
            HookBridge.hookAllMethods(TextView.class, "setText", new w0());
            HookBridge.hookAllMethods(TextView.class, "setHint", new x0());
            HookBridge.hookAllMethods(TextView.class, "onTouchEvent", new z0());
            String strDecrypt4 = "Initialized";
            Object obj4 = h6.a;
            h6.a(4, String.valueOf(strDecrypt4), (Throwable) null);
        } catch (Throwable th4) {
            String strDecrypt5 = "Init failed";
            Object obj5 = h6.a;
            h6.a(6, String.valueOf(strDecrypt5), th4);
        }
    }

    public static void g() {
        try {
            Context contextA = Main.a();
            if (contextA != null) {
                a(contextA, false, (k1) null);
                f(contextA);
            }
        } catch (Throwable th) {
            String strDecrypt = "Periodic supporter refresh failed";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static  Integer h() {
        return 0;
    }

    public static void i() {
        if (z.updateAndGet(new IntUnaryOperator() {
            @Override
            public final int applyAsInt(int i2) {
                return BadgeHooks.a(i2);
            }
        }) == 0) {
        }
    }

    public static String j() {
        Object objInvoke;
        try {
            z7 z7Var = g8.a;
            Class<?> cls = Class.forName("X.03XD");
            p8 p8Var = g8.b;
            Method methodA = p8Var.a(cls, new Class[0]);
            if (Modifier.isStatic(methodA.getModifiers())) {
                objInvoke = methodA.invoke(null, null);
            } else {
                Object obj = g8.a.a(cls).get(null);
                if (obj == null) {
                    A = null;
                    return null;
                }
                objInvoke = p8Var.a(obj.getClass(), new Class[0]).invoke(obj, null);
            }
            if (objInvoke == null) {
                A = null;
                return null;
            }
            if (!Boolean.TRUE.equals(dd.a(objInvoke.getClass(), "isLogin", new Class[0]).invoke(objInvoke, null))) {
                A = null;
                return null;
            }
            Object objInvoke2 = dd.a(objInvoke.getClass(), "getCurUserId", new Class[0]).invoke(objInvoke, null);
            if (objInvoke2 instanceof String) {
                String str = (String) objInvoke2;
                if (!hd$$ExternalSyntheticBackport0.m(str)) {
                    A = str.trim();
                    return A;
                }
            }
            A = null;
            return null;
        } catch (Throwable th) {
            String strDecrypt = "Failed to resolve current user uid";
            Object obj2 = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static Bitmap a(Context context, n1 n1Var, int i2) {
        n1 n1Var2 = n1Var != null ? new n1(n1Var.a, n1Var.b, n1Var.c, n1Var.d, n1Var.e, n1Var.f) : n1.a();
        String strC = q1.a(n1Var2.b) ? c(context, n1Var2.b) : n1Var2.b;
        int iMax = 1;
        int iMax2 = Math.max(1, i2);
        StringBuilder sb = new StringBuilder();
        boolean z2 = n1Var2.c;
        boolean z3 = n1Var2.d;
        String str = n1Var2.e;
        String str2 = n1Var2.f;
        String strB = q1.b(strC);
        if (str != null) {
            str.isEmpty();
        }
        if (str2 != null) {
            str2.isEmpty();
        }
        String string = sb.append(strB + "|" + z2 + "|" + z3).append("::bulletin::").append(iMax2).toString();
        t1 t1Var = d;
        Bitmap bitmap = (Bitmap) t1Var.get(string);
        if (a(bitmap)) {
            return bitmap;
        }
        l0 l0VarA = a(context, n1Var);
        if (l0VarA == null) {
            return null;
        }
        String str3 = l0VarA.a + "::bulletin::" + iMax2;
        Bitmap bitmap2 = (Bitmap) t1Var.get(str3);
        if (a(bitmap2)) {
            return bitmap2;
        }
        Bitmap bitmap3 = l0VarA.b;
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
        Bitmap bitmapA2 = (n1Var == null || !n1Var.c) ? bitmapA : a(bitmapA, g(context));
        if (a(bitmapA2)) {
            bitmapA = bitmapA2;
        }
        t1Var.put(str3, bitmapA);
        return bitmapA;
    }

    public static void b(Context context) {
        try {
            String strA = m0.a("https://tiktokyou.yzewe.ru/api/v1/price");
            ze zeVarA = n0.a(strA);
            if (zeVarA == null) {
                throw new IOException("Invalid support price");
            }
            B = zeVarA;
            m0.a(new File(m0.a(context), "support_price_cache.json"), strA);
            h6.a(4, h6.a("Loaded support price usd=%s ruble=%s", new Object[]{zeVarA.a, zeVarA.b}), (Throwable) null);
            o.set(false);
        } catch (Throwable th) {
            try {
                String strDecrypt = "Failed to load support price: %s";
                Object obj = h6.a;
                h6.a(6, String.valueOf(strDecrypt), th);
            } finally {
                o.set(false);
            }
        }
    }

    public static void h(Context context) {
        if (context != null && s.compareAndSet(false, true)) {
            t = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
                @Override
                public final Thread newThread(Runnable runnable) {
                    return BadgeHooks.a(runnable);
                }
            });
            t.scheduleWithFixedDelay(new Runnable() {
                @Override
                public final void run() {
                    BadgeHooks.g();
                }
            }, 3600000L, 3600000L, TimeUnit.MILLISECONDS);
        }
    }

    public static int g(Context context) {
        ta taVarA = ta.a();
        if (taVarA == null || !taVarA.f() || ta.d().m != 0) {
            return -185258;
        }
        try {
            int identifier = context.getResources().getIdentifier("system_accent3_400", "color", "android");
            if (identifier != 0) {
                return context.getResources().getColor(identifier, null);
            }
        } catch (Throwable th) {
        }
        Context contextA = Main.a();
        if (contextA == null) {
            return -16524603;
        }
        return ThemeHooks.a(contextA);
    }

    public static void e() {
        y0 y0Var = new y0();
        HookBridge.hookAllMethods(User.class, "getNickname", y0Var);
        HookBridge.hookAllMethods(User.class, "getRemarkName", y0Var);
        HookBridge.hookAllMethods(User.class, "getContactName", y0Var);
        HookBridge.hookAllMethods(User.class, "getUserDisplayName", y0Var);
        HookBridge.hookAllMethods(User.class, "getSearchUserName", y0Var);
    }

    public static void c() {
        p0 p0Var = new p0();
        HookBridge.hookAllMethods(IMUser.class, "getDisplayName", p0Var);
        HookBridge.hookAllMethods(IMUser.class, "getDisplayUserName", p0Var);
        HookBridge.hookAllMethods(IMUser.class, "getRawNickNameForDisplay", p0Var);
        HookBridge.hookAllMethods(IMUser.class, "getRemarkName", p0Var);
        HookBridge.hookAllMethods(IMUser.class, "getContactName", p0Var);
    }

    public static Object b(Object obj) {
        p8 p8Var;
        Class<?> cls = obj.getClass();
        if (ProfileNavbarNickNameProtocol.class.isAssignableFrom(cls)) {
            p8Var = g9.b;
        } else if (ProfileNavbarOtherNicknameProtocol.class.isAssignableFrom(cls)) {
            p8Var = h9.b;
        } else if (ProfileInfoNicknameProtocol.class.isAssignableFrom(cls)) {
            p8Var = d9.b;
        } else {
            p8Var = ProfileInfoOtherNicknameProtocol.class.isAssignableFrom(cls) ? e9.b : null;
        }
        if (p8Var == null) {
            return null;
        }
        for (String str : (String[]) p8Var.c.clone()) {
            try {
                Object objInvoke = dd.a(obj.getClass(), str, new Class[0]).invoke(obj, null);
                if (objInvoke != null) {
                    return objInvoke;
                }
            } catch (Throwable th) {
            }
        }
        return null;
    }

    public static void c(final Activity activity, final Fragment fragment, final n1 n1Var, final String str) {
        if (s1.b(activity)) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public final void run() {
                    BadgeHooks.b(activity, fragment, n1Var, str);
                }
            });
        }
    }

    public static String c(Context context, String str) {
        String strB = q1.b(str);
        if (q1.a(strB)) {
            if (context != null && r.compareAndSet(false, true)) {
                try {
                    for (Map.Entry entry : m0.b(context).entrySet()) {
                        String strB2 = q1.b((String) entry.getKey());
                        String strB3 = q1.b((String) entry.getValue());
                        if (q1.a(strB2) && q1.a(strB3)) {
                            e.put(strB2, strB3);
                        }
                    }
                } catch (Throwable th) {
                    String strDecrypt = "Failed to read badge image redirects: %s";
                    Object obj = h6.a;
                    h6.a(6, String.valueOf(strDecrypt), th);
                }
            }
            String str2 = (String) e.get(strB);
            if (!TextUtils.isEmpty(str2)) {
                String strB4 = q1.b(str2);
                return q1.a(strB4) ? strB4 : strB;
            }
        }
        return strB;
    }

    public static void b() {
        q0 q0Var = new q0();
        HookBridge.hookAllMethods(IMConversation.class, "getConversationName", q0Var);
        HookBridge.hookAllMethods(IMConversation.class, "getDisplayName", q0Var);
        HookBridge.hookAllMethods(IMConversation.class, "getNickName", q0Var);
    }

    public static void b(final Activity activity, Fragment fragment, n1 n1Var, String str) {
        if (s1.b(activity)) {
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
                    final FrameLayout frameLayoutA = a(activity, fragment, n1Var, str);
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
                    layoutParams2.y = s1.a(activity) + ((int) TypedValue.applyDimension(1, 36.0f, activity.getResources().getDisplayMetrics()));
                    windowManager.addView(frameLayout2, layoutParams2);
                    map.put(activity, frameLayout2);
                    frameLayoutA.animate().translationY(0.0f).alpha(1.0f).setDuration(300L).start();
                    a(frameLayoutA, new a1(s1.a(frameLayoutA.getContext(), 6.0f), frameLayoutA, s1.a(frameLayoutA.getContext(), 28.0f), activity, frameLayout2));
                    frameLayoutA.postDelayed(new Runnable() {
                        @Override
                        public final void run() {
                            BadgeHooks.a(activity, frameLayout2, frameLayoutA);
                        }
                    }, 2500L);
                }
            } catch (Throwable th) {
                String strDecrypt = "Badge bulletin failed: %s";
                Object obj = h6.a;
                h6.a(6, String.valueOf(strDecrypt), th);
            }
        }
    }

    public static Bitmap a(Context context, TextView textView, n1 n1Var) {
        n1 n1VarA;
        String strC;
        if (n1Var != null) {
            n1VarA = new n1(n1Var.a, n1Var.b, n1Var.c, n1Var.d, n1Var.e, n1Var.f);
        } else {
            n1VarA = n1.a();
        }
        if (q1.a(n1VarA.b)) {
            strC = c(context, n1VarA.b);
        } else {
            strC = n1VarA.b;
        }
        int iMax = 1;
        int iMax2 = Math.max(1, Math.round(textView.getLineHeight() * 1.0f));
        StringBuilder sb = new StringBuilder();
        boolean z2 = n1VarA.c;
        boolean z3 = n1VarA.d;
        String str = n1VarA.e;
        String str2 = n1VarA.f;
        String strB = q1.b(strC);
        if (str != null) {
            str.isEmpty();
        }
        if (str2 != null) {
            str2.isEmpty();
        }
        String string = sb.append(strB + "|" + z2 + "|" + z3).append("::").append(iMax2).toString();
        t1 t1Var = d;
        Bitmap bitmap = (Bitmap) t1Var.get(string);
        if (a(bitmap)) {
            return bitmap;
        }
        l0 l0VarA = a(context, n1Var);
        if (l0VarA == null) {
            return null;
        }
        String str3 = l0VarA.a + "::" + iMax2;
        Bitmap bitmap2 = (Bitmap) t1Var.get(str3);
        if (a(bitmap2)) {
            return bitmap2;
        }
        Bitmap bitmap3 = l0VarA.b;
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
        Bitmap bitmapA2 = (n1Var == null || !n1Var.c) ? bitmapA : a(bitmapA, g(context));
        if (a(bitmapA2)) {
            bitmapA = bitmapA2;
        }
        t1Var.put(str3, bitmapA);
        return bitmapA;
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
            String strDecrypt = "Failed to open support bot";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static void d(final Context context, String str) {
        final String strC = c(context, str);
        if (q1.a(strC)) {
            char[] cArr = m0.a;
            File fileA = m0.a(context);
            char[] cArr2 = m0.c;
            File file = new File(fileA, new String(cArr2));
            char[] cArr3 = m0.a;
            String str2 = strC != null ? strC : "";
            Charset charset = StandardCharsets.UTF_8;
            File file2 = new File(file, v5.a(str2.getBytes(charset)) + new String(cArr3));
            File file3 = new File(new File(m0.a(context), new String(cArr2)), v5.a((strC != null ? strC : "").getBytes(charset)) + new String(m0.b));
            if (m0.a(file2, file3, 21600000L) && h.putIfAbsent(strC, Boolean.TRUE) == null) {
                m0.b(file3);
                Runnable runnable = new Runnable() {
                    @Override
                    public final void run() {
                        BadgeHooks.a(strC, context);
                    }
                };
                StringBuilder sbAppend = new StringBuilder().append("badge-img-");
                String strA = v5.a(strC.getBytes(charset));
                if (strA.length() > 8) {
                    strA = strA.substring(0, 8);
                }
                new Thread(runnable, sbAppend.append(strA).toString()).start();
            }
        }
    }

    public static void f(final Context context) {
        char[] cArr = m0.a;
        File file = new File(m0.a(context), "support_price_cache.json");
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
                    BadgeHooks.b(context);
                }
            }, "badge-price-fetch").start();
        }
    }

    public static l0 a(Context context, n1 n1Var) {
        n1 n1VarA;
        String strC;
        if (n1Var != null) {
            n1VarA = new n1(n1Var.a, n1Var.b, n1Var.c, n1Var.d, n1Var.e, n1Var.f);
        } else {
            n1VarA = n1.a();
        }
        if (q1.a(n1VarA.b)) {
            strC = c(context, n1VarA.b);
        } else {
            strC = n1VarA.b;
        }
        if (q1.a(strC)) {
            String strC2 = c(context, strC);
            char[] cArr = m0.a;
            File fileA = m0.a(context);
            char[] cArr2 = m0.c;
            File file = new File(fileA, new String(cArr2));
            char[] cArr3 = m0.a;
            String str = strC2 != null ? strC2 : "";
            Charset charset = StandardCharsets.UTF_8;
            File file2 = new File(file, v5.a(str.getBytes(charset)) + new String(cArr3));
            File file3 = new File(new File(m0.a(context), new String(cArr2)), v5.a((strC2 != null ? strC2 : "").getBytes(charset)) + new String(m0.b));
            Bitmap bitmapA = h4.a(file2, 512);
            if (bitmapA != null) {
                if (m0.a(file2, file3, 21600000L)) {
                    d(context, strC2);
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
                    String strA = v5.a(strC2.getBytes(charset));
                    if (strA.length() > 8) {
                        strA = strA.substring(0, 8);
                    }
                    h6.a(6, h6.a(strDecrypt, new Object[]{strA}), (Throwable) null);
                }
                d(context, strC2);
                bitmapA = null;
            }
            if (bitmapA != null) {
                boolean z2 = n1VarA.c;
                boolean z3 = n1VarA.d;
                String str2 = n1VarA.e;
                String str3 = n1VarA.f;
                String strB = q1.b(strC);
                if (str2 != null) {
                    str2.isEmpty();
                }
                if (str3 != null) {
                    str3.isEmpty();
                }
                return new l0(strB + "|" + z2 + "|" + z3, bitmapA);
            }
            Bitmap bitmapA2 = a(context, "asset:supporter.png");
            String strDecrypt2 = "asset:supporter.png";
            boolean z4 = n1VarA.c;
            boolean z5 = n1VarA.d;
            String str4 = n1VarA.e;
            String str5 = n1VarA.f;
            String strB2 = q1.b(strDecrypt2);
            if (str4 != null) {
                str4.isEmpty();
            }
            if (str5 != null) {
                str5.isEmpty();
            }
            if (bitmapA2 != null) {
                return new l0(strB2 + "|" + z4 + "|" + z5, bitmapA2);
            }
            return null;
        }
        Bitmap bitmapA3 = a(context, strC);
        if (bitmapA3 != null) {
            return new l0(n1VarA.b + "|" + n1VarA.c + "|" + n1VarA.d, bitmapA3);
        }
        return null;
    }

    public static void b(final Activity activity, final Fragment fragment, final n1 n1Var) {
        if (s1.b(activity)) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public final void run() {
                    BadgeHooks.a(activity, fragment, n1Var);
                }
            });
        }
    }

    public static String a(n1 n1Var) {
        String str = n1Var.e;
        if (str == null) {
            str = "";
        }
        String str2 = n1Var.a + "|" + n1Var.b + "|" + n1Var.c + "|" + n1Var.d + "|" + str;
        ConcurrentHashMap concurrentHashMap = j;
        String str3 = (String) concurrentHashMap.get(str2);
        if (str3 != null) {
            return str3;
        }
        synchronized (BadgeHooks.class) {
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
            i.put(string, n1Var);
            return string;
        }
    }

    public static Bitmap b(Context context, String str) {
        if (context != null && !TextUtils.isEmpty(str)) {
            try {
                InputStream inputStreamOpen = ResourceOverlay.open(context, "mod_icons/" + str + ".png");
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

    public static void b(Activity activity, FrameLayout frameLayout) {
        WindowManager windowManager;
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

    public static  Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "badge-supporters-refresh");
        thread.setDaemon(true);
        return thread;
    }

    public static CharSequence a(TextView textView, CharSequence charSequence) {
        ?? spannableStringBuilder;
        int length;
        int iIndexOf;
        n1 n1Var;
        Bitmap bitmapA;
        CharSequence charSequence2 = charSequence;
        if (charSequence2 == null) {
            return null;
        }
        if (y.get() > 0 || z.get() > 0) {
            return b(charSequence2);
        }
        int iIndexOf2 = 0;
        if (charSequence2 instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence2;
            m1[] m1VarArr = (m1[]) spanned.getSpans(0, spanned.length(), m1.class);
            if (m1VarArr != null && m1VarArr.length != 0) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spanned);
                boolean z2 = false;
                for (m1 m1Var : m1VarArr) {
                    if (m1Var != null) {
                        int spanStart = spannableStringBuilder2.getSpanStart(m1Var);
                        int spanEnd = spannableStringBuilder2.getSpanEnd(m1Var);
                        int spanFlags = spannableStringBuilder2.getSpanFlags(m1Var);
                        if (spanStart >= 0 && spanEnd > spanStart && (bitmapA = a(textView.getContext(), textView, m1Var.b)) != null) {
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(textView.getResources(), bitmapA);
                            bitmapDrawable.setBounds(0, 0, bitmapA.getWidth(), bitmapA.getHeight());
                            spannableStringBuilder2.removeSpan(m1Var);
                            spannableStringBuilder2.setSpan(new m1(bitmapDrawable, m1Var.b), spanStart, spanEnd, spanFlags);
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
                n1Var = null;
            } else {
                String strA = a(charSequence2);
                if (strA.isEmpty()) {
                    n1Var = null;
                } else {
                    n1Var = (n1) f.get(strA);
                }
            }
            if (n1Var != null && !spannableStringBuilder.toString().contains("⁣⁣⁤")) {
                spannableStringBuilder.append("⁣⁣⁤" + a(n1Var) + "⁤⁣⁣");
            }
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
            n1 n1VarA = TextUtils.isEmpty(strSubstring) ? null : (n1) i.get(strSubstring);
            if (n1VarA == null) {
                n1VarA = n1.a();
            }
            int length3 = "⁤⁣⁣".length() + iIndexOf;
            Bitmap bitmapA2 = a(textView.getContext(), textView, n1VarA);
            String str = bitmapA2 != null ? " ￼" : "";
            spannableStringBuilder3.replace(iIndexOf4, length3, (CharSequence) str);
            if (bitmapA2 != null) {
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(textView.getResources(), bitmapA2);
                bitmapDrawable2.setBounds(0, 0, bitmapA2.getWidth(), bitmapA2.getHeight());
                spannableStringBuilder3.setSpan(new m1(bitmapDrawable2, n1VarA), iIndexOf4 + 1, iIndexOf4 + 2, 33);
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

    public static n1 b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return null;
        }
        return (n1) b.get(strTrim);
    }

    public static String a(String str, String str2) {
        n1 n1VarB;
        if (y.get() > 0 || z.get() > 0) {
            CharSequence charSequenceB = b((CharSequence) str2);
            if (charSequenceB != null) {
                return charSequenceB.toString();
            }
            return null;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (n1VarB = b(str)) == null || a(str2)) {
            return str2;
        }
        a(str2, n1VarB);
        return str2 + "\ufdd0" + ("⁣⁣⁤" + a(n1VarB) + "⁤⁣⁣");
    }

    public static void a(Context context) {
        String[] strArr;
        if (b.isEmpty() && (strArr = a) != null && strArr.length != 0) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (String str : strArr) {
                if (!TextUtils.isEmpty(str)) {
                    String strTrim = str.trim();
                    if (!strTrim.isEmpty()) {
                        linkedHashMap.put(strTrim, new n1(strTrim, "asset:supporter.png", true, false, null, null));
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
            char[] cArr = m0.a;
            File file = new File(m0.a(context), "supporters_cache.txt");
            String strA = m0.a(file);
            if (!TextUtils.isEmpty(strA)) {
                LinkedHashMap linkedHashMapB = n0.b(strA);
                if (linkedHashMapB.isEmpty()) {
                    if (file.exists()) {
                        file.setLastModified(0L);
                    }
                    File file2 = new File(m0.a(context), "supporters_fetch.stamp");
                    if (file2.exists()) {
                        file2.setLastModified(0L);
                    }
                    String strDecrypt = "Ignored invalid supporters cache";
                    Object obj = h6.a;
                    h6.a(4, String.valueOf(strDecrypt), (Throwable) null);
                    c(context);
                } else {
                    a(linkedHashMapB);
                    if (!m0.a(new File(m0.a(context), "supporters_cache.txt"), new File(m0.a(context), "supporters_fetch.stamp"), 7200000L)) {
                        e(context);
                    }
                    h6.a(4, h6.a("Loaded %d supporter uid(s) from cache", new Object[]{Integer.valueOf(linkedHashMapB.size())}), (Throwable) null);
                }
            } else {
                c(context);
            }
        }
        a(context, false, (k1) null);
    }

    public static boolean a(final Context context, boolean z2, final k1 k1Var) {
        if (context == null) {
            return false;
        }
        char[] cArr = m0.a;
        final File file = new File(m0.a(context), "supporters_cache.txt");
        File file2 = new File(m0.a(context), "supporters_fetch.stamp");
        if ((!z2 && !m0.a(new File(m0.a(context), "supporters_cache.txt"), new File(m0.a(context), "supporters_fetch.stamp"), 7200000L)) || !q.compareAndSet(false, true)) {
            return false;
        }
        m0.b(file2);
        new Thread(new Runnable() {
            @Override
            public final void run() {
                BadgeHooks.a(context, file, k1Var);
            }
        }, "badge-supporters-fetch").start();
        return true;
    }

    public static void a(Context context, File file, k1 k1Var) {
        boolean z2;
        ?? r3;
        ?? r2 = 0;
        try {
            char[] cArr = m0.a;
            File file2 = new File(m0.a(context), "supporters_cache.etag");
            String strA = file.exists() ? m0.a(file2) : null;
            String strDecrypt = "https://tiktokyou.yzewe.ru/api/v1/badges";
            String strDecrypt2 = "TTMod-BadgeHooks/1.0";
            AtomicBoolean atomicBoolean = p.a;
            o oVarA = p.a(strDecrypt, strDecrypt2, strA, 2097152, MapsKt.emptyMap());
            int i2 = oVarA.a;
            String strA2 = oVarA.a();
            String str = oVarA.c;
            z2 = true;
            try {
                try {
                    if (i2 == 304) {
                        m0.b(file);
                        int size = b.size();
                        String strDecrypt3 = "Supporters list not modified";
                        q.set(false);
                        b(k1Var, true, size, strDecrypt3);
                        return;
                    }
                    if (TextUtils.isEmpty(strA2)) {
                        throw new IOException("Empty supporters list");
                    }
                    LinkedHashMap linkedHashMapB = n0.b(strA2);
                    if (linkedHashMapB.isEmpty()) {
                        throw new IOException("Invalid supporters list");
                    }
                    m0.a(file, strA2);
                    if (!TextUtils.isEmpty(str)) {
                        m0.a(file2, str);
                    } else if (file2.exists()) {
                        file2.delete();
                    }
                    a(linkedHashMapB);
                    e(context);
                    int size2 = linkedHashMapB.size();
                    r3 = "Loaded " + size2 + " supporter uid(s)";
                    try {
                        h6.a(4, h6.a("Loaded %d supporter uid(s) from GitHub", new Object[]{Integer.valueOf(linkedHashMapB.size())}), (Throwable) null);
                        q.set(false);
                        b(k1Var, true, size2, (String) r3);
                        return;
                    } catch (Throwable th) {
                        r2 = size2;
                        th = th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    r3 = r2;
                    r2 = 0;
                }
            } catch (Throwable th3) {
                r2 = file;
                th = th3;
                r3 = 0;
            }
        } catch (Throwable th4) {
            th = th4;
            z2 = false;
            r3 = 0;
            r2 = 0;
        }
        try {
            String strDecrypt4 = "Failed to load supporters list: %s";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt4), th);
            if (b.isEmpty()) {
                c(context);
            }
        } finally {
            q.set(false);
            b(k1Var, z2, (int) r2, (String) r3);
        }
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
        for (n1 n1Var : linkedHashMap.values()) {
            if (n1Var != null && !TextUtils.isEmpty(n1Var.a) && !TextUtils.isEmpty(n1Var.f)) {
                linkedHashMap2.put(n1Var.a, n1Var.f);
            }
        }
        qc.a(linkedHashMap2);
    }

    public static void a(Class cls, p8 p8Var) {
        try {
            a(cls, p8Var, new d1());
        } catch (Throwable th) {
            String strDecrypt = "Failed to hook nickname context";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static void a(Class cls, p8 p8Var, p8 p8Var2, int i2) {
        try {
            a(cls, p8Var, new g1());
            a(cls, p8Var2, new h1(i2));
        } catch (Throwable th) {
            String strDecrypt = "Failed to hook nickname builders";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static void a(Class cls, p8 p8Var, int i2) {
        try {
            a(cls, p8Var, new i1(i2));
        } catch (Throwable th) {
            String strDecrypt = "Failed to hook nickname text argument";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static void a(HookMethod.HookMethodParam hookMethodParam, int i2) {
        Object objAppend;
        lc lcVarA;
        Object[] objArr = hookMethodParam.args;
        if (objArr.length > i2) {
            Object obj = objArr[i2];
            if (obj instanceof String) {
                String str = (String) obj;
                Object obj2 = hookMethodParam.thisObject;
                if (TextUtils.isEmpty(str) || (lcVarA = a(obj2)) == null) {
                    objAppend = str;
                } else {
                    String string = str.toString();
                    String strA = a(lcVarA.a, string);
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

    public static lc a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            Object objB = b(obj);
            if (objB != null) {
                Object objInvoke = dd.a(objB.getClass(), "getUserProfileInfo", new Class[0]).invoke(objB, null);
                if (objInvoke instanceof UserProfileInfo) {
                    UserProfileInfo userProfileInfo = (UserProfileInfo) objInvoke;
                    String uid = userProfileInfo.getUid();
                    if (!TextUtils.isEmpty(uid) && b(uid) != null) {
                        return new lc(uid, a((CharSequence) userProfileInfo.getNickname()));
                    }
                }
            }
        } catch (Throwable th) {
        }
        String str = w;
        if (TextUtils.isEmpty(str) || b(str) == null) {
            return null;
        }
        return new lc(str, x);
    }

    public static void a() {
        try {
            p8 p8Var = o6.a;
            Class<?> cls = Class.forName("X.08vU");
            v0 v0Var = new v0();
            for (String str : (String[]) o6.a.c.clone()) {
                HookBridge.hookAllMethods(cls, str, v0Var);
            }
        } catch (Throwable th) {
            String strDecrypt = "Failed to hook alias display names";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static boolean a(TextView textView, MotionEvent motionEvent) {
        Spanned spanned;
        m1 m1Var;
        Activity activity;
        Fragment fragment;
        String str;
        CharSequence text = textView.getText();
        String str2 = null;
        if (text instanceof Spanned) {
            spanned = (Spanned) text;
            m1[] m1VarArr = (m1[]) spanned.getSpans(0, spanned.length(), m1.class);
            if (m1VarArr == null || m1VarArr.length == 0) {
                spanned = null;
            }
        } else {
            spanned = null;
        }
        Map map = k;
        r1 r1Var = (r1) map.get(textView);
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
            if (r1Var != null) {
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
                m1 m1VarA = a(textView, spanned, motionEvent);
                if (m1VarA == null) {
                    map.remove(textView);
                    ViewParent parent2 = textView.getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(false);
                    }
                    return false;
                }
                if (m1VarA.b == null) {
                }
                map.put(textView, new r1(m1VarA));
                ViewParent parent3 = textView.getParent();
                if (parent3 != null) {
                    parent3.requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 1:
                if (r1Var == null) {
                    return false;
                }
                m1 m1VarA2 = a(textView, spanned, motionEvent);
                if (!r1Var.b && m1VarA2 == (m1Var = r1Var.a)) {
                    n1 n1Var = m1Var.b;
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
                        String[] strArr = (String[]) b8.a.c.clone();
                        int length = strArr.length;
                        int i2 = 0;
                        while (true) {
                            if (i2 < length) {
                                try {
                                    Object objInvoke = dd.a(cls, strArr[i2], View.class).invoke(null, textView);
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
                        } else if (n1Var != null) {
                            str = (String) g.get(n1Var.a);
                            if (!TextUtils.isEmpty(str)) {
                                str2 = str;
                            }
                        }
                    } else if (n1Var != null && !TextUtils.isEmpty(n1Var.a)) {
                        str = (String) g.get(n1Var.a);
                        if (!TextUtils.isEmpty(str)) {
                            str2 = str;
                        }
                    }
                    if (n1Var == null) {
                    }
                    if (activity == null) {
                    }
                    if (fragment == null) {
                    }
                    if (activity != null) {
                        c(activity, fragment, n1Var, str2);
                    }
                }
                k.remove(textView);
                ViewParent parent4 = textView.getParent();
                if (parent4 != null) {
                    parent4.requestDisallowInterceptTouchEvent(false);
                }
                return true;
            case 2:
                if (r1Var == null) {
                    return false;
                }
                r1Var.b = a(textView, spanned, motionEvent) != r1Var.a;
                return true;
            case 3:
                if (r1Var == null) {
                    return false;
                }
                map.remove(textView);
                ViewParent parent5 = textView.getParent();
                if (parent5 != null) {
                    parent5.requestDisallowInterceptTouchEvent(false);
                }
                return true;
            default:
                return r1Var != null;
        }
    }

    public static m1 a(TextView textView, Spanned spanned, MotionEvent motionEvent) {
        int iWidth;
        Layout layout = textView.getLayout();
        if (layout == null) {
            return null;
        }
        float x2 = (motionEvent.getX() - textView.getTotalPaddingLeft()) + textView.getScrollX();
        float y2 = (motionEvent.getY() - textView.getTotalPaddingTop()) + textView.getScrollY();
        if (x2 >= 0.0f && y2 >= 0.0f) {
            m1[] m1VarArr = (m1[]) spanned.getSpans(0, spanned.length(), m1.class);
            if (m1VarArr != null && m1VarArr.length != 0) {
                int scaledTouchSlop = ViewConfiguration.get(textView.getContext()).getScaledTouchSlop();
                for (m1 m1Var : m1VarArr) {
                    if (m1Var != null) {
                        int spanStart = spanned.getSpanStart(m1Var);
                        int spanEnd = spanned.getSpanEnd(m1Var);
                        if (spanStart >= 0 && spanEnd > spanStart) {
                            int lineForOffset = layout.getLineForOffset(spanStart);
                            float lineTop = layout.getLineTop(lineForOffset) - scaledTouchSlop;
                            float lineBottom = layout.getLineBottom(lineForOffset) + scaledTouchSlop;
                            if (y2 >= lineTop && y2 <= lineBottom) {
                                float fMin = Math.min(layout.getPrimaryHorizontal(spanStart), layout.getPrimaryHorizontal(spanEnd));
                                float fMax = Math.max(layout.getPrimaryHorizontal(spanStart), layout.getPrimaryHorizontal(spanEnd));
                                BitmapDrawable bitmapDrawable = m1Var.a;
                                if (bitmapDrawable != null && (iWidth = bitmapDrawable.getBounds().width()) > 0) {
                                    float f2 = iWidth;
                                    if (fMax - fMin < f2) {
                                        fMax = fMin + f2;
                                    }
                                }
                                float f3 = scaledTouchSlop;
                                if (x2 >= fMin - f3 && x2 <= fMax + f3) {
                                    return m1Var;
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void a(w6 w6Var, p8 p8Var, z1 z1Var) {
        try {
            HookBridge.hookAllMethods(Class.forName(w6Var.b), p8Var.c[0], new t0(z1Var));
        } catch (Throwable th) {
            String strDecrypt = "Failed to hook ChatListNameModel#getName";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static void a(Class cls, p8 p8Var, HookMethod hookMethod) {
        for (String str : (String[]) p8Var.c.clone()) {
            try {
                HookBridge.hookAllMethods(cls, str, hookMethod);
            } catch (Throwable th) {
            }
        }
    }

    public static void a(Fragment fragment, n1 n1Var, View view) {
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
        b(activity, fragment, n1Var);
    }

    public static void a(View view, a1 a1Var) {
        view.setOnTouchListener(a1Var);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(viewGroup.getChildAt(i2), a1Var);
            }
        }
    }

    public static void a(final Activity activity, final FrameLayout frameLayout, View view) {
        if (frameLayout == null) {
            l.remove(activity);
        } else if (frameLayout.getParent() != null && view != null && view.getParent() != null) {
            view.animate().translationY(s1.a(view.getContext(), 100.0f)).alpha(0.0f).setDuration(220L).withEndAction(new Runnable() {
                @Override
                public final void run() {
                    BadgeHooks.b(activity, frameLayout);
                }
            }).start();
        } else {
            b(activity, frameLayout);
        }
    }

    public static void a(final Activity activity, Fragment fragment, n1 n1Var) {
        if (s1.b(activity)) {
            try {
                Dialog dialog = (Dialog) m.remove(activity);
                if (dialog != null) {
                    try {
                        dialog.dismiss();
                    } catch (Throwable th) {
                    }
                }
                int color = activity != null && (activity.getResources().getConfiguration().uiMode & 48) == 32 ? Color.parseColor("#1E1E1E") : -1;
                final Dialog dialogA = wa.a(activity);
                dialogA.setCancelable(true);
                dialogA.setCanceledOnTouchOutside(true);
                v1 v1VarA = a(activity, dialogA, fragment);
                dialogA.setContentView(wa.a(activity, v1VarA, -2, new View.OnClickListener() {
                    @Override
                    public final void onClick(View view) {
                        dialogA.dismiss();
                    }
                }));
                dialogA.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public final void onDismiss(DialogInterface dialogInterface) {
                        BadgeHooks.m.remove(activity);
                    }
                });
                wa.a(dialogA, v1VarA, color, 0.55f);
                m.put(activity, dialogA);
                dialogA.show();
            } catch (Throwable th2) {
                String strDecrypt = "Supporter details sheet failed";
                Object obj = h6.a;
                h6.a(6, String.valueOf(strDecrypt), th2);
            }
        }
    }

    public static v1 a(final Activity activity, final Dialog dialog, final Fragment fragment) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        int color;
        m6 m6Var = l6.a;
        boolean z2 = activity != null && (activity.getResources().getConfiguration().uiMode & 48) == 32;
        int color2 = z2 ? Color.parseColor("#1E1E1E") : -1;
        int color3 = z2 ? -1 : Color.parseColor("#161823");
        int color4 = Color.parseColor((z2 ? "#A7A9B0" : "#8A8B91"));
        int color5 = Color.parseColor((z2 ? "#303030" : "#EFEFF0"));
        int color6 = Color.parseColor((z2 ? "#303030" : "#F3F3F4"));
        ta taVarA = ta.a();
        if (taVarA == null || !taVarA.f()) {
            color = Color.parseColor("#FE2B54");
        } else {
            color = ThemeHooks.a();
        }
        v1 v1Var = new v1(activity);
        v1Var.setVerticalScrollBarEnabled(false);
        v1Var.setOverScrollMode(2);
        v1Var.a = Math.max(0, Math.max((int) r2.a(activity, 1, 320.0f), (int) (activity.getResources().getDisplayMetrics().heightPixels * 0.85f)));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color2);
        float fA = (int) r2.a(activity, 1, 24.0f);
        gradientDrawable.setCornerRadii(new float[]{fA, fA, fA, fA, 0.0f, 0.0f, 0.0f, 0.0f});
        v1Var.setBackground(gradientDrawable);
        v1Var.setClipToOutline(true);
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        linearLayout.setPadding((int) r2.a(activity, 1, 20.0f), (int) r2.a(activity, 1, 18.0f), (int) r2.a(activity, 1, 20.0f), (int) r2.a(activity, 1, 18.0f));
        v1Var.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(activity);
        int iA = (int) r2.a(activity, 1, 32.0f);
        frameLayout.setMinimumHeight(iA);
        linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(activity);
        textView.setText(l6.a("badge_sheet_header", "Подробнее"));
        textView.setTextColor(color3);
        textView.setTextSize(2, 18.0f);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView.setGravity(17);
        textView.setIncludeFontPadding(false);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2, 16);
        layoutParams.leftMargin = iA;
        layoutParams.rightMargin = iA;
        frameLayout.addView(textView, layoutParams);
        TextView textView2 = new TextView(activity);
        textView2.setText("×");
        textView2.setTextColor(color3);
        textView2.setTextSize(2, 24.0f);
        textView2.setGravity(17);
        textView2.setIncludeFontPadding(false);
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(iA, iA);
        layoutParams2.gravity = 8388629;
        frameLayout.addView(textView2, layoutParams2);
        ImageView imageView = new ImageView(activity);
        Bitmap bitmapA = a(activity, n1.a(), (int) r2.a(activity, 1, 52.0f));
        if (bitmapA != null) {
            imageView.setImageBitmap(bitmapA);
        }
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams3.gravity = 1;
        layoutParams3.topMargin = (int) r2.a(activity, 1, 20.0f);
        linearLayout.addView(imageView, layoutParams3);
        TextView textView3 = new TextView(activity);
        textView3.setText(l6.a("badge_sheet_title", "Поддержите разработку"));
        textView3.setTextColor(color3);
        textView3.setTextSize(2, 18.0f);
        textView3.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView3.setGravity(17);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = (int) r2.a(activity, 1, 18.0f);
        linearLayout.addView(textView3, layoutParams4);
        TextView textView4 = new TextView(activity);
        textView4.setText(l6.a("badge_sheet_subtitle", "Внесите вклад в развитие разработки и получите уникальный значок."));
        textView4.setTextColor(color4);
        textView4.setTextSize(2, 14.0f);
        textView4.setGravity(17);
        textView4.setLineSpacing(0.0f, 1.1f);
        LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams5.topMargin = (int) r2.a(activity, 1, 10.0f);
        linearLayout.addView(textView4, layoutParams5);
        String strA = l6.a("badge_sheet_copy_uid", "Скопировать мой UID");
        String strDecrypt = "ic_copy";
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        linearLayout2.setPadding((int) r2.a(activity, 1, 14.0f), 0, (int) r2.a(activity, 1, 14.0f), 0);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(color5);
        gradientDrawable2.setCornerRadius((int) TypedValue.applyDimension(1, 999.0f, activity.getResources().getDisplayMetrics()));
        linearLayout2.setBackground(gradientDrawable2);
        Bitmap bitmapB = b(activity, strDecrypt);
        if (bitmapB != null) {
            ImageView imageView2 = new ImageView(activity);
            imageView2.setImageBitmap(bitmapB);
            imageView2.setColorFilter(color3, PorterDuff.Mode.SRC_IN);
            LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams((int) r2.a(activity, 1, 13.0f), (int) r2.a(activity, 1, 13.0f));
            layoutParams6.rightMargin = (int) r2.a(activity, 1, 8.0f);
            linearLayout2.addView(imageView2, layoutParams6);
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
                BadgeHooks.a(activity, view);
            }
        });
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-2, (int) r2.a(activity, 1, 36.0f));
        layoutParams7.gravity = 1;
        layoutParams7.topMargin = (int) r2.a(activity, 1, 18.0f);
        linearLayout.addView(linearLayout2, layoutParams7);
        LinearLayout linearLayout3 = new LinearLayout(activity);
        linearLayout3.setOrientation(1);
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams8.topMargin = (int) r2.a(activity, 1, 20.0f);
        linearLayout.addView(linearLayout3, layoutParams8);
        String strDecrypt2 = "ic_coin";
        ze zeVar = B != null ? B : new ze("5", "500");
        linearLayout3.addView(a(activity, strDecrypt2, String.format(l6.a("badge_sheet_step1_title_format", "Пожертвуйте не менее $%1$s (%2$s₽)"), zeVar.a, zeVar.b), l6.a("badge_sheet_step1_subtitle", "Переведите сумму по любым из наших реквизитов"), color6, color3, color4));
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams9.topMargin = (int) r2.a(activity, 1, 8.0f);
        String strDecrypt3 = "photo";
        String strA2 = l6.a("badge_sheet_step2_title", "Пришлите подтверждение и ваш UID");
        String strA3 = l6.a("badge_sheet_step2_contact", "@tt_u_bot");
        String str7 = String.format(l6.a("badge_sheet_step2_subtitle", "Отправьте чек или скриншот в %s, а также ваш UID для выдачи"), strA3);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str7);
        int iIndexOf = str7.indexOf(strA3);
        if (iIndexOf >= 0) {
            spannableStringBuilder.setSpan(new b1(activity, color), iIndexOf, strA3.length() + iIndexOf, 33);
        }
        linearLayout3.addView(a(activity, strDecrypt3, strA2, spannableStringBuilder, color6, color3, color4), layoutParams9);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams10.topMargin = (int) r2.a(activity, 1, 8.0f);
        linearLayout3.addView(a(activity, "ic_mod_logo", l6.a("badge_sheet_step3_title", "Получите значок"), l6.a("badge_sheet_step3_subtitle", "После проверки он появится в вашем профиле и будет виден всем"), color6, color3, color4), layoutParams10);
        LinearLayout linearLayout4 = new LinearLayout(activity);
        linearLayout4.setOrientation(0);
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams11.topMargin = (int) r2.a(activity, 1, 28.0f);
        linearLayout.addView(linearLayout4, layoutParams11);
        String strA4 = l6.a("badge_sheet_cancel", "Отмена");
        TextView textView6 = new TextView(activity);
        textView6.setText(strA4);
        textView6.setTextColor(color3);
        textView6.setTextSize(2, 17.0f);
        textView6.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView6.setGravity(17);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(color5);
        gradientDrawable3.setCornerRadius(s1.a(activity, 999.0f));
        textView6.setBackground(gradientDrawable3);
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(0, (int) r2.a(activity, 1, 48.0f));
        layoutParams12.weight = 1.0f;
        linearLayout4.addView(textView6, layoutParams12);
        String strA5 = l6.a("badge_sheet_support", "Поддержать");
        TextView textView7 = new TextView(activity);
        textView7.setText(strA5);
        textView7.setTextColor(-1);
        textView7.setTextSize(2, 17.0f);
        textView7.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView7.setGravity(17);
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setColor(color);
        gradientDrawable4.setCornerRadius(s1.a(activity, 999.0f));
        textView7.setBackground(gradientDrawable4);
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                BadgeHooks.a(fragment, activity, dialog, view);
            }
        });
        LinearLayout.LayoutParams layoutParams13 = new LinearLayout.LayoutParams(0, (int) r2.a(activity, 1, 48.0f));
        layoutParams13.weight = 1.0f;
        layoutParams13.leftMargin = (int) r2.a(activity, 1, 10.0f);
        linearLayout4.addView(textView7, layoutParams13);
        return v1Var;
    }

    public static  void a(Fragment fragment, Activity activity, Dialog dialog, View view) {
        if (fragment != null) {
        }
        d(activity);
        dialog.dismiss();
    }

    public static LinearLayout a(Activity activity, String str, String str2, CharSequence charSequence, int i2, int i3, int i4) {
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(48);
        linearLayout.setPadding(s1.a(activity, 14.0f), (int) r2.a(activity, 1, 12.0f), (int) r2.a(activity, 1, 14.0f), (int) r2.a(activity, 1, 12.0f));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius((int) TypedValue.applyDimension(1, 10.0f, activity.getResources().getDisplayMetrics()));
        linearLayout.setBackground(gradientDrawable);
        Bitmap bitmapB = b(activity, str);
        if (bitmapB != null) {
            ImageView imageView = new ImageView(activity);
            imageView.setImageBitmap(bitmapB);
            imageView.setColorFilter(i4, PorterDuff.Mode.SRC_IN);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) r2.a(activity, 1, 18.0f), (int) r2.a(activity, 1, 18.0f));
            layoutParams.topMargin = (int) r2.a(activity, 1, 2.0f);
            linearLayout.addView(imageView, layoutParams);
        }
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams2.leftMargin = (int) r2.a(activity, 1, 12.0f);
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
        layoutParams3.topMargin = (int) r2.a(activity, 1, 3.0f);
        linearLayout2.addView(textView2, layoutParams3);
        return linearLayout;
    }

    public static void a(Activity activity, View view) {
        String strJ = j();
        m6 m6Var = l6.a;
        if (TextUtils.isEmpty(strJ)) {
            Toast.makeText(activity, l6.a("copy_uid_unavailable"), 0).show();
            return;
        }
        ClipboardManager clipboardManager = (ClipboardManager) activity.getSystemService("clipboard");
        if (clipboardManager == null) {
            Toast.makeText(activity, l6.a("copy_uid_failed"), 0).show();
            return;
        }
        try {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("uid", strJ));
            Toast.makeText(activity, l6.a("copy_uid_copied"), 0).show();
        } catch (Throwable th) {
            m6 m6Var2 = l6.a;
            Toast.makeText(activity, l6.a("copy_uid_failed"), 0).show();
        }
    }

    public static FrameLayout a(Activity activity, final Fragment fragment, final n1 n1Var, String str) {
        String strReplace;
        boolean z2 = activity != null && (activity.getResources().getConfiguration().uiMode & 48) == 32;
        int color = z2 ? Color.parseColor("#1E1E1E") : -1;
        int color2 = z2 ? -1 : Color.parseColor("#161823");
        ta taVarA = ta.a();
        int color3 = (taVarA == null || !taVarA.f()) ? Color.parseColor("#FE2B54") : ThemeHooks.a();
        FrameLayout frameLayout = new FrameLayout(activity);
        int iA = s1.a(activity, 14.0f);
        int iA2 = (int) r2.a(activity, 1, 12.0f);
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
        Bitmap bitmapA = a(activity, n1Var, (int) r2.a(activity, 1, 26.0f));
        if (bitmapA != null) {
            imageView.setImageBitmap(bitmapA);
        }
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = (int) r2.a(activity, 1, 10.0f);
        layoutParams.rightMargin = (int) r2.a(activity, 1, 6.0f);
        linearLayout.addView(linearLayout2, layoutParams);
        TextView textView = new TextView(activity);
        m6 m6Var = l6.a;
        String strA = !TextUtils.isEmpty(str) ? str : l6.a("badge_bulletin_unknown_name", "Этот человек");
        if (n1Var == null || TextUtils.isEmpty(n1Var.e)) {
            strReplace = (n1Var == null || !n1Var.d) ? String.format(l6.a("badge_bulletin_supporter_format", "%s поддержал разработку TikTok You"), strA) : String.format(l6.a("badge_bulletin_developer_format", "%s член команды разработки TikTok You"), strA);
        } else {
            strReplace = n1Var.e.replace("${1}", strA);
        }
        textView.setText(strReplace);
        textView.setTextSize(2, 14.0f);
        textView.setLineSpacing(0.0f, 1.0f);
        textView.setTextColor(color2);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(activity);
        textView2.setText(l6.a("badge_bulletin_button", "Подробнее"));
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 13.0f);
        textView2.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView2.setGravity(17);
        textView2.setPadding((int) TypedValue.applyDimension(1, 16.0f, activity.getResources().getDisplayMetrics()), 0, (int) r2.a(activity, 1, 16.0f), 0);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(color3);
        gradientDrawable2.setCornerRadius((int) TypedValue.applyDimension(1, 68.0f, activity.getResources().getDisplayMetrics()));
        textView2.setBackground(gradientDrawable2);
        textView2.setMinHeight((int) TypedValue.applyDimension(1, 32.0f, activity.getResources().getDisplayMetrics()));
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                BadgeHooks.a(fragment, n1Var, view);
            }
        });
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-2, (int) r2.a(activity, 1, 32.0f)));
        return frameLayout;
    }

    public static boolean a(lc lcVar, String str) {
        if (!TextUtils.isEmpty(str) && str.charAt(0) != '@') {
            String strA = a((CharSequence) str);
            if (!strA.isEmpty() && strA.indexOf(10) < 0) {
                return TextUtils.isEmpty(lcVar.b) || TextUtils.equals(strA, lcVar.b) || strA.startsWith(lcVar.b) || lcVar.b.startsWith(strA);
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

    public static void a(String str, n1 n1Var) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strA = a((CharSequence) str);
        if (strA.isEmpty()) {
            return;
        }
        f.put(strA, n1Var);
        if (!TextUtils.isEmpty(n1Var.a)) {
            g.put(n1Var.a, strA);
        }
        a(n1Var);
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
            boolean z2 = ThemeHooks.d;
            ThemeHooks.d = false;
            try {
                paint.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_IN));
                ThemeHooks.d = z2;
                try {
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                    return bitmapCreateBitmap;
                } catch (Throwable th) {
                    String strDecrypt = "Failed to tint badge bitmap";
                    Object obj = h6.a;
                    h6.a(6, String.valueOf(strDecrypt), th);
                    return null;
                }
            } catch (Throwable th2) {
                ThemeHooks.d = z2;
                throw th2;
            }
        } catch (Throwable th3) {
            String strDecrypt2 = "Failed to allocate tinted badge bitmap";
            Object obj2 = h6.a;
            h6.a(6, String.valueOf(strDecrypt2), th3);
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
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
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
        String strB = q1.b(str);
        ConcurrentHashMap concurrentHashMap = c;
        Bitmap bitmap = (Bitmap) concurrentHashMap.get(strB);
        if (a(bitmap)) {
            return bitmap;
        }
        synchronized (BadgeHooks.class) {
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
                h6.a(6, h6.a("Failed to load asset badge %s: %s", new Object[]{strDecrypt, e2}), (Throwable) null);
                return null;
            }
        }
    }

    public static void a(String str, Context context, String str2) {
        if (context == null) {
            return;
        }
        String strB = q1.b(str);
        String strB2 = q1.b(str2);
        if (q1.a(strB) && q1.a(strB2) && !TextUtils.equals(strB, strB2)) {
            ConcurrentHashMap concurrentHashMap = e;
            concurrentHashMap.put(strB, strB2);
            char[] cArr = m0.a;
            if (concurrentHashMap == null || concurrentHashMap.isEmpty()) {
                return;
            }
            StringBuilder sb = new StringBuilder();
            for (Map.Entry entry : concurrentHashMap.entrySet()) {
                if (!TextUtils.isEmpty((CharSequence) entry.getKey()) && !TextUtils.isEmpty((CharSequence) entry.getValue())) {
                    sb.append((String) entry.getKey()).append('\t').append((String) entry.getValue()).append('\n');
                }
            }
            try {
                m0.a(new File(m0.a(context), "image_redirects.txt"), sb.toString());
            } catch (IOException e2) {
                h6.a(6, h6.a("Failed to write badge image redirects: %s", new Object[]{e2.getMessage()}), (Throwable) null);
            }
        }
    }

    public static void a(String str, Context context) {
        Bitmap bitmap = null;
        try {
            char[] cArr = m0.a;
            String strDecrypt = "TTMod-BadgeHooks/1.0";
            AtomicBoolean atomicBoolean = p.a;
            o oVarA = p.a(str, strDecrypt, null, 16777216, MapsKt.emptyMap());
            byte[] bArr = oVarA.b;
            String str2 = oVarA.d;
            if (bArr != null && bArr.length != 0) {
                Bitmap bitmapA = h4.a(bArr, 512);
                if (bitmapA != null) {
                    String strB = q1.b(str2);
                    h4.a(m0.a(context, strB), bitmapA);
                    if (!TextUtils.equals(strB, str)) {
                        a(str, context, strB);
                    }
                    t1 t1Var = d;
                    t1Var.a(str + "|");
                    t1Var.a(strB + "|");
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
                h6.a(6, h6.a("Failed to download custom badge: %s", new Object[]{str}), th);
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
        String strJ = j();
        String str = null;
        for (String str2 : memberIdList) {
            if (!TextUtils.isEmpty(str2)) {
                String strTrim = str2.trim();
                if (!strTrim.isEmpty() && (TextUtils.isEmpty(strJ) || !TextUtils.equals(strJ, strTrim))) {
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
