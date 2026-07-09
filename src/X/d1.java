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
import android.view.Window;
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
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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

public abstract class d1 {
    public static final ConcurrentHashMap a = new ConcurrentHashMap();
    public static final ConcurrentHashMap b = new ConcurrentHashMap();
    public static final ConcurrentHashMap c = new ConcurrentHashMap();
    public static final ConcurrentHashMap d = new ConcurrentHashMap();
    public static final ConcurrentHashMap e = new ConcurrentHashMap();
    public static final ConcurrentHashMap f = new ConcurrentHashMap();
    public static final ConcurrentHashMap g = new ConcurrentHashMap();
    public static final ConcurrentHashMap h = new ConcurrentHashMap();
    public static final ConcurrentHashMap i = new ConcurrentHashMap();
    public static final Map j = Collections.synchronizedMap(new WeakHashMap());
    public static final Map k = Collections.synchronizedMap(new WeakHashMap());
    public static final Map l = Collections.synchronizedMap(new WeakHashMap());
    public static final AtomicInteger m;
    public static final AtomicBoolean n;
    public static final AtomicBoolean o;
    public static final AtomicBoolean p;
    public static final AtomicBoolean q;
    public static final AtomicBoolean r;
    public static volatile ScheduledExecutorService s;
    public static final ThreadLocal t;
    public static final ThreadLocal u;
    public static volatile String v;
    public static final AtomicInteger w;
    public static final AtomicInteger x;
    public static volatile String y;
    public static volatile bc z;

    static {
        Collections.synchronizedMap(new WeakHashMap());
        m = new AtomicInteger(1);
        n = new AtomicBoolean(false);
        o = new AtomicBoolean(false);
        p = new AtomicBoolean(false);
        q = new AtomicBoolean(false);
        r = new AtomicBoolean(false);
        t = new ThreadLocal();
        u = ThreadLocal.withInitial(new Supplier() {
            @Override
            public final Object get() {
                return d1.f();
            }
        });
        w = new AtomicInteger(0);
        x = new AtomicInteger(0);
        z = new bc("5", "500");
    }

    public static b0 a(Context context, f1 f1Var) {
        f1 f1Var2 = f1Var != null ? new f1(f1Var.a, f1Var.b, f1Var.c, f1Var.d, f1Var.e, f1Var.f) : new f1("", "asset:supporter.png", true, false, null, null);
        String strC = g1.a(f1Var2.b) ? c(context, f1Var2.b) : f1Var2.b;
        ConcurrentHashMap concurrentHashMap = b;
        Bitmap bitmap = (Bitmap) concurrentHashMap.get(strC);
        if (a(bitmap)) {
            boolean z2 = f1Var2.c;
            boolean z3 = f1Var2.d;
            String str = f1Var2.e;
            String str2 = f1Var2.f;
            String strB = g1.b(strC);
            TextUtils.isEmpty(str);
            TextUtils.isEmpty(str2);
            return new b0(strB + "|" + z2 + "|" + z3, bitmap);
        }
        if (!g1.a(strC)) {
            Bitmap bitmapA = a(context, strC);
            if (bitmapA != null) {
                return new b0(f1Var2.b + "|" + f1Var2.c + "|" + f1Var2.d, bitmapA);
            }
            return null;
        }
        String strC2 = c(context, strC);
        File file = new File(new File(d0.a(context), "images"), d0.c(strC2) + ".img");
        File file2 = new File(new File(d0.a(context), "images"), d0.c(strC2) + ".stamp");
        Bitmap bitmapDecodeFile = (Bitmap) concurrentHashMap.get(strC2);
        if (!a(bitmapDecodeFile)) {
            bitmapDecodeFile = BitmapFactory.decodeFile(file.getAbsolutePath());
            if (bitmapDecodeFile != null) {
                concurrentHashMap.put(strC2, bitmapDecodeFile);
                if (d0.a(file, file2, 10800000L)) {
                    d(context, strC2);
                }
            } else {
                if (file.exists()) {
                    if (file.exists()) {
                        file.setLastModified(0L);
                    }
                    if (file2.exists()) {
                        file2.setLastModified(0L);
                    }
                    String strC3 = d0.c(strC2);
                    if (strC3.length() > 8) {
                        strC3.substring(0, 8);
                    }
                    int i2 = g5.a;
                }
                d(context, strC2);
                bitmapDecodeFile = null;
            }
        } else if (d0.a(file, file2, 10800000L)) {
            d(context, strC2);
        }
        if (bitmapDecodeFile != null) {
            boolean z4 = f1Var2.c;
            boolean z5 = f1Var2.d;
            String str3 = f1Var2.e;
            String str4 = f1Var2.f;
            String strB2 = g1.b(strC);
            TextUtils.isEmpty(str3);
            TextUtils.isEmpty(str4);
            return new b0(strB2 + "|" + z4 + "|" + z5, bitmapDecodeFile);
        }
        Bitmap bitmapA2 = a(context, "asset:supporter.png");
        boolean z6 = f1Var2.c;
        boolean z7 = f1Var2.d;
        String str5 = f1Var2.e;
        String str6 = f1Var2.f;
        String strB3 = g1.b("asset:supporter.png");
        TextUtils.isEmpty(str5);
        TextUtils.isEmpty(str6);
        if (bitmapA2 != null) {
            return new b0(strB3 + "|" + z6 + "|" + z7, bitmapA2);
        }
        return null;
    }

    public static void b(final c1 c1Var, final boolean z2, final int i2, final String str) {
        if (c1Var == null) {
            return;
        }
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            @Override
            public final void run() {
                c1Var.a(z2, i2, str);
            }
        });
    }

    public static void c() {
        q0 q0Var = new q0();
        HookBridge.hookAllMethods(User.class, "getNickname", q0Var);
        HookBridge.hookAllMethods(User.class, "getRemarkName", q0Var);
        HookBridge.hookAllMethods(User.class, "getContactName", q0Var);
        HookBridge.hookAllMethods(User.class, "getUserDisplayName", q0Var);
        HookBridge.hookAllMethods(User.class, "getSearchUserName", q0Var);
    }

    public static void d() {
        try {
            Context contextC = g5.c();
            a(contextC);
            g(contextC);
            if (contextC != null) {
                bc bcVarA = e0.a(d0.b(new File(d0.a(contextC), "support_price_cache.json")));
                if (bcVarA != null) {
                    z = bcVarA;
                }
                e(contextC);
            }
            q8.a();
            HookMethod hookMethod = i8.a;
            try {
                HookBridge.hookAllMethods(MentionContainerViewModel.class, s6.a.c[0], i8.a).size();
            } catch (Throwable th) {
                th.getMessage();
                int i2 = g5.a;
            }
            c();
            b();
            f0 f0Var = new f0();
            HookBridge.hookAllMethods(BaseContact.class, "getNickName", f0Var);
            HookBridge.hookAllMethods(BaseContact.class, "getDisplayName", f0Var);
            a();
            h0 h0Var = new h0();
            HookBridge.hookAllMethods(IMConversation.class, "getConversationName", h0Var);
            HookBridge.hookAllMethods(IMConversation.class, "getDisplayName", h0Var);
            HookBridge.hookAllMethods(IMConversation.class, "getNickName", h0Var);
            HookBridge.hookAllMethods(VideoAuthorInfoVM.class, d8.a.c[0], new i0());
            try {
                HookBridge.hookAllConstructors(FriendsV3RepostModel.class, new k0());
            } catch (Throwable th2) {
                th2.getMessage();
                int i3 = g5.a;
            }
            a(l5.a, l5.b, o1.a);
            o5 o5Var = m5.a;
            t6 t6Var = m5.b;
            o1 o1Var = o1.b;
            a(o5Var, t6Var, o1Var);
            a(n5.a, n5.b, o1Var);
            try {
                HookBridge.hookAllMethods(IMFriendsServiceImpl.class, n6.a.c[0], new m0());
            } catch (Throwable th3) {
                String str = n6.a.b;
                th3.getMessage();
                int i4 = g5.a;
            }
            try {
                t6 t6Var2 = i5.a;
                Class<?> cls = Class.forName("X.0T8b");
                n0 n0Var = new n0();
                for (String str2 : (String[]) i5.a.c.clone()) {
                    HookBridge.hookAllMethods(cls, str2, n0Var);
                }
            } catch (Throwable th4) {
                th4.getMessage();
                int i5 = g5.a;
            }
            HookBridge.hookAllMethods(TextView.class, "setText", new o0());
            HookBridge.hookAllMethods(TextView.class, "setHint", new p0());
            HookBridge.hookAllMethods(TextView.class, "onTouchEvent", new r0());
            int i6 = g5.a;
        } catch (Throwable th5) {
            th5.getMessage();
            int i7 = g5.a;
        }
    }

    public static void e() {
        try {
            Context contextC = g5.c();
            if (contextC != null) {
                a(contextC, true, (c1) null);
                e(contextC);
            }
        } catch (Throwable th) {
            th.getMessage();
            int i2 = g5.a;
        }
    }

    public static  Integer f() {
        return 0;
    }

    public static void g(Context context) {
        if (context != null && r.compareAndSet(false, true)) {
            s = Executors.newSingleThreadScheduledExecutor(new ThreadFactory() {
                @Override
                public final Thread newThread(Runnable runnable) {
                    return d1.a(runnable);
                }
            });
            s.scheduleWithFixedDelay(new Runnable() {
                @Override
                public final void run() {
                    d1.e();
                }
            }, 3600000L, 3600000L, TimeUnit.MILLISECONDS);
            int i2 = g5.a;
        }
    }

    public static String h() {
        try {
            k6 k6Var = o6.a;
            Object obj = o6.a.a(Class.forName("X.0HQS")).get(null);
            if (obj == null) {
                y = null;
                return null;
            }
            Object objInvoke = o6.b.a(obj.getClass(), new Class[0]).invoke(obj, null);
            if (objInvoke == null) {
                y = null;
                return null;
            }
            if (!Boolean.TRUE.equals(ha.a(objInvoke.getClass(), "isLogin", new Class[0]).invoke(objInvoke, null))) {
                y = null;
                return null;
            }
            Object objInvoke2 = ha.a(objInvoke.getClass(), "getCurUserId", new Class[0]).invoke(objInvoke, null);
            if (objInvoke2 instanceof String) {
                String str = (String) objInvoke2;
                if (!d1$$ExternalSyntheticBackport0.m(str)) {
                    y = str.trim();
                    return y;
                }
            }
            y = null;
            return null;
        } catch (Throwable th) {
            th.getMessage();
            int i2 = g5.a;
        }
    }

    public static void b(Context context) {
        try {
            String strB = d0.b("https://tiktokyou.yzewe.ru/api/v1/price");
            bc bcVarA = e0.a(strB);
            if (bcVarA == null) {
                throw new IOException("Invalid support price");
            }
            z = bcVarA;
            d0.a(new File(d0.a(context), "support_price_cache.json"), strB);
            int i2 = g5.a;
        } catch (Throwable th) {
            th.getMessage();
            int i3 = g5.a;
        }
    }

    public static int f(Context context) {
        l8 l8VarA = l8.a();
        if (l8VarA == null || !l8VarA.d() || l8VarA.l != 0) {
            return -185258;
        }
        try {
            int identifier = context.getResources().getIdentifier("system_accent3_400", "color", "android");
            if (identifier != 0) {
                return context.getResources().getColor(identifier, null);
            }
        } catch (Throwable th) {
        }
        Context contextC = g5.c();
        if (contextC == null) {
            return -16524603;
        }
        return hd.a(contextC);
    }

    public static void e(final Context context) {
        if (n.compareAndSet(false, true)) {
            new Thread(new Runnable() {
                @Override
                public final void run() {
                    d1.b(context);
                }
            }, "badge-price-fetch").start();
        }
    }

    public static void c(final Activity activity, final Fragment fragment, final f1 f1Var, final String str) {
        if (i1.a(activity)) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public final void run() {
                    d1.b(activity, fragment, f1Var, str);
                }
            });
        }
    }

    public static void b() {
        HookBridge.hookAllMethods(UserProfileInfo.class, "getNickname", new u0());
        a(ProfileNavbarNickNameProtocol.class, e7.a);
        a(ProfileNavbarOtherNicknameProtocol.class, f7.a);
        a(ProfileInfoNicknameProtocol.class, c7.a);
        a(ProfileInfoOtherNicknameProtocol.class, d7.a);
        a(ProfileNavbarNickNameProtocol.class, e7.c, e7.d, 2);
        a(ProfileNavbarOtherNicknameProtocol.class, f7.c, f7.d, 1);
        a(ProfileNavbarOtherNicknameProtocol.class, f7.e, 0);
        a(ProfileInfoNicknameProtocol.class, c7.c, 0);
        a(ProfileInfoNicknameProtocol.class, c7.d, 2);
        a(ProfileInfoNicknameProtocol.class, c7.e, 2);
        a(ProfileInfoNicknameProtocol.class, c7.f, 0);
        t6 t6Var = c7.g;
        try {
            HookBridge.hookAllMethods(ProfileInfoNicknameProtocol.class, t6Var.c[0], new b1(0));
        } catch (Throwable th) {
            String str = t6Var.c[0];
            th.getMessage();
            int i2 = g5.a;
        }
        a(ProfileInfoOtherNicknameProtocol.class, d7.c, 1);
        try {
            HookBridge.hookAllMethods(Describe.class, "getText", new w0());
        } catch (Throwable th2) {
            th2.getMessage();
            int i3 = g5.a;
        }
        try {
            HookBridge.hookAllMethods(Class.forName("com.ss.android.ugc.profile.business.profile.ui.v2.I18nUserProfileFragment"), "getUser", new x0());
        } catch (Throwable th3) {
            th3.getMessage();
            int i4 = g5.a;
        }
    }

    public static void c(Context context) {
        if (context == null) {
            return;
        }
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://t.me/tt_ubot"));
            intent.addFlags(268435456);
            context.startActivity(intent);
        } catch (Throwable th) {
            th.getMessage();
            int i2 = g5.a;
        }
    }

    public static void g() {
        if (x.updateAndGet(new IntUnaryOperator() {
            @Override
            public final int applyAsInt(int i2) {
                return d1.a(i2);
            }
        }) == 0) {
            int i2 = g5.a;
        }
    }

    public static f1 c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return null;
        }
        return (f1) a.get(strTrim);
    }

    public static String c(Context context, String str) {
        String strB = g1.b(str);
        if (g1.a(strB)) {
            if (context != null && q.compareAndSet(false, true)) {
                try {
                    for (Map.Entry entry : d0.b(context).entrySet()) {
                        String strB2 = g1.b((String) entry.getKey());
                        String strB3 = g1.b((String) entry.getValue());
                        if (g1.a(strB2) && g1.a(strB3)) {
                            d.put(strB2, strB3);
                        }
                    }
                } catch (Throwable th) {
                    th.getMessage();
                    int i2 = g5.a;
                }
            }
            String str2 = (String) d.get(strB);
            if (!TextUtils.isEmpty(str2)) {
                String strB4 = g1.b(str2);
                return g1.a(strB4) ? strB4 : strB;
            }
        }
        return strB;
    }

    public static Object b(Object obj) {
        t6 t6Var;
        Class<?> cls = obj.getClass();
        if (ProfileNavbarNickNameProtocol.class.isAssignableFrom(cls)) {
            t6Var = e7.b;
        } else if (ProfileNavbarOtherNicknameProtocol.class.isAssignableFrom(cls)) {
            t6Var = f7.b;
        } else if (ProfileInfoNicknameProtocol.class.isAssignableFrom(cls)) {
            t6Var = c7.b;
        } else {
            t6Var = ProfileInfoOtherNicknameProtocol.class.isAssignableFrom(cls) ? d7.b : null;
        }
        if (t6Var == null) {
            return null;
        }
        for (String str : (String[]) t6Var.c.clone()) {
            try {
                Object objInvoke = ha.a(obj.getClass(), str, new Class[0]).invoke(obj, null);
                if (objInvoke != null) {
                    return objInvoke;
                }
            } catch (Throwable th) {
            }
        }
        return null;
    }

    public static String a(f1 f1Var) {
        String str = f1Var.e;
        if (str == null) {
            str = "";
        }
        String str2 = f1Var.a + "|" + f1Var.b + "|" + f1Var.c + "|" + f1Var.d + "|" + str;
        ConcurrentHashMap concurrentHashMap = i;
        String str3 = (String) concurrentHashMap.get(str2);
        if (str3 != null) {
            return str3;
        }
        synchronized (d1.class) {
            String str4 = (String) concurrentHashMap.get(str2);
            if (str4 != null) {
                return str4;
            }
            int andIncrement = m.getAndIncrement();
            StringBuilder sb = new StringBuilder(16);
            for (int i2 = 15; i2 >= 0; i2--) {
                sb.append(((andIncrement >> i2) & 1) == 0 ? (char) 8203 : (char) 8204);
            }
            String string = sb.toString();
            i.put(str2, string);
            h.put(string, f1Var);
            return string;
        }
    }

    public static void b(final Activity activity, Fragment fragment, f1 f1Var, String str) {
        if (i1.a(activity)) {
            try {
                WindowManager windowManager = activity.getWindowManager();
                View decorView = activity.getWindow() != null ? activity.getWindow().getDecorView() : null;
                if (windowManager != null && decorView != null && decorView.getWindowToken() != null) {
                    Map map = k;
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
                    final FrameLayout frameLayoutA = a(activity, fragment, f1Var, str);
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
                    a(frameLayoutA, new s0(i1.a(frameLayoutA.getContext(), 6.0f), frameLayoutA, i1.a(frameLayoutA.getContext(), 28.0f), activity, frameLayout2));
                    frameLayoutA.postDelayed(new Runnable() {
                        @Override
                        public final void run() {
                            d1.a(activity, frameLayout2, frameLayoutA);
                        }
                    }, 2500L);
                }
            } catch (Throwable th) {
                th.getMessage();
                int i2 = g5.a;
            }
        }
    }

    public static boolean a(final Context context, boolean z2, final c1 c1Var) {
        if (context == null) {
            return false;
        }
        final File file = new File(d0.a(context), "supporters_cache.txt");
        File file2 = new File(d0.a(context), "supporters_fetch.stamp");
        if ((!z2 && !d0.a(new File(d0.a(context), "supporters_cache.txt"), new File(d0.a(context), "supporters_fetch.stamp"), 3600000L)) || !p.compareAndSet(false, true)) {
            return false;
        }
        d0.c(file2);
        new Thread(new Runnable() {
            @Override
            public final void run() {
                d1.a(file, context, c1Var);
            }
        }, "badge-supporters-fetch").start();
        return true;
    }

    public static void d(Context context) {
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet();
        for (f1 f1Var : a.values()) {
            if (f1Var != null && g1.a(f1Var.b)) {
                linkedHashSet.add(c(context, f1Var.b));
            }
        }
        for (String str : linkedHashSet) {
            if (g1.a(str)) {
                d(context, str);
            }
        }
    }

    public static  Thread a(Runnable runnable) {
        Thread thread = new Thread(runnable, "badge-supporters-refresh");
        thread.setDaemon(true);
        return thread;
    }

    public static CharSequence a(TextView textView, CharSequence charSequence) {
        ?? spannableStringBuilder;
        int i2;
        int iIndexOf;
        f1 f1Var;
        Bitmap bitmapA;
        CharSequence charSequence2 = charSequence;
        if (charSequence2 == null) {
            return null;
        }
        if (w.get() > 0 || x.get() > 0) {
            return b(charSequence2);
        }
        int iIndexOf2 = 0;
        if (charSequence2 instanceof Spanned) {
            Spanned spanned = (Spanned) charSequence2;
            e1[] e1VarArr = (e1[]) spanned.getSpans(0, spanned.length(), e1.class);
            if (e1VarArr != null && e1VarArr.length != 0) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(spanned);
                boolean z2 = false;
                for (e1 e1Var : e1VarArr) {
                    if (e1Var != null) {
                        int spanStart = spannableStringBuilder2.getSpanStart(e1Var);
                        int spanEnd = spannableStringBuilder2.getSpanEnd(e1Var);
                        int spanFlags = spannableStringBuilder2.getSpanFlags(e1Var);
                        if (spanStart >= 0 && spanEnd > spanStart && (bitmapA = a(textView.getContext(), textView, e1Var.b)) != null) {
                            BitmapDrawable bitmapDrawable = new BitmapDrawable(textView.getResources(), bitmapA);
                            bitmapDrawable.setBounds(0, 0, bitmapA.getWidth(), bitmapA.getHeight());
                            spannableStringBuilder2.removeSpan(e1Var);
                            spannableStringBuilder2.setSpan(new e1(bitmapDrawable, e1Var.b), spanStart, spanEnd, spanFlags);
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
                f1Var = null;
            } else {
                String strA = a(charSequence2);
                if (strA.isEmpty()) {
                    f1Var = null;
                } else {
                    f1Var = (f1) e.get(strA);
                }
            }
            if (f1Var != null && !spannableStringBuilder.toString().contains("\u2063\u2063\u2064")) {
                spannableStringBuilder.append("\u2063\u2063\u2064" + a(f1Var) + "\u2064\u2063\u2063");
            }
        }
        String string2 = spannableStringBuilder.toString();
        if (!string2.contains("\u2063\u2063\u2064") && !string2.contains("\ufdd0")) {
            return spannableStringBuilder;
        }
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(spannableStringBuilder);
        int length = 0;
        boolean z3 = false;
        while (true) {
            String string3 = spannableStringBuilder3.toString();
            int iIndexOf4 = string3.indexOf("\u2063\u2063\u2064", length);
            if (iIndexOf4 < 0 || (iIndexOf = string3.indexOf("\u2064\u2063\u2063", (i2 = iIndexOf4 + 3))) < 0) {
                break;
            }
            String strSubstring = string3.substring(i2, iIndexOf);
            f1 f1Var2 = TextUtils.isEmpty(strSubstring) ? null : (f1) h.get(strSubstring);
            if (f1Var2 == null) {
                f1Var2 = new f1("", "asset:supporter.png", true, false, null, null);
            }
            int i3 = iIndexOf + 3;
            Bitmap bitmapA2 = a(textView.getContext(), textView, f1Var2);
            String str = bitmapA2 != null ? " ￼" : "";
            spannableStringBuilder3.replace(iIndexOf4, i3, (CharSequence) str);
            if (bitmapA2 != null) {
                BitmapDrawable bitmapDrawable2 = new BitmapDrawable(textView.getResources(), bitmapA2);
                bitmapDrawable2.setBounds(0, 0, bitmapA2.getWidth(), bitmapA2.getHeight());
                spannableStringBuilder3.setSpan(new e1(bitmapDrawable2, f1Var2), iIndexOf4 + 1, iIndexOf4 + 2, 33);
            }
            length = iIndexOf4 + str.length();
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

    public static void d(final Context context, String str) {
        final String strC = c(context, str);
        if (g1.a(strC)) {
            File file = new File(new File(d0.a(context), "images"), d0.c(strC) + ".img");
            File file2 = new File(new File(d0.a(context), "images"), d0.c(strC) + ".stamp");
            if (d0.a(file, file2, 10800000L) && g.putIfAbsent(strC, Boolean.TRUE) == null) {
                d0.c(file2);
                Runnable runnable = new Runnable() {
                    @Override
                    public final void run() {
                        d1.a(strC, context);
                    }
                };
                StringBuilder sb = new StringBuilder("badge-img-");
                String strC2 = d0.c(strC);
                if (strC2.length() > 8) {
                    strC2 = strC2.substring(0, 8);
                }
                new Thread(runnable, sb.append(strC2).toString()).start();
            }
        }
    }

    public static void b(final Activity activity, final Fragment fragment, final f1 f1Var) {
        if (i1.a(activity)) {
            activity.runOnUiThread(new Runnable() {
                @Override
                public final void run() {
                    d1.a(activity, fragment, f1Var);
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

    public static void b(Activity activity, FrameLayout frameLayout) {
        WindowManager windowManager;
        k.remove(activity);
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
        a(spannableStringBuilder, "\u2063\u2064\u2063\u2064\u2063");
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
            iIndexOf = string2.indexOf("\u2063\u2063\u2064", iIndexOf);
            if (iIndexOf < 0) {
                a(spannableStringBuilder, " ￼");
                a(spannableStringBuilder, String.valueOf((char) 65532));
                return spannableStringBuilder;
            }
            int i2 = iIndexOf + 3;
            int iIndexOf3 = string2.indexOf("\u2064\u2063\u2063", i2);
            if (iIndexOf3 < 0) {
                spannableStringBuilder.replace(iIndexOf, i2, (CharSequence) "");
            } else {
                spannableStringBuilder.replace(iIndexOf, iIndexOf3 + 3, (CharSequence) "");
            }
        }
    }

    public static String a(String str, String str2) {
        f1 f1VarC;
        if (w.get() > 0 || x.get() > 0) {
            CharSequence charSequenceB = b((CharSequence) str2);
            if (charSequenceB != null) {
                return charSequenceB.toString();
            }
            return null;
        }
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str) || (f1VarC = c(str)) == null || a(str2)) {
            return str2;
        }
        a(str2, f1VarC);
        return str2 + "\ufdd0" + ("\u2063\u2063\u2064" + a(f1VarC) + "\u2064\u2063\u2063");
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

    public static  int a(int i2) {
        if (i2 > 0) {
            return i2 - 1;
        }
        return 0;
    }

    public static void a(Context context) {
        String strC;
        LinkedHashMap linkedHashMapB;
        a.isEmpty();
        if (context == null) {
            return;
        }
        if (o.compareAndSet(false, true)) {
            File file = new File(d0.a(context), "supporters_cache.txt");
            String strB = d0.b(file);
            if (!TextUtils.isEmpty(strB)) {
                LinkedHashMap linkedHashMapB2 = e0.b(strB);
                if (linkedHashMapB2.isEmpty()) {
                    if (file.exists()) {
                        file.setLastModified(0L);
                    }
                    File file2 = new File(d0.a(context), "supporters_fetch.stamp");
                    if (file2.exists()) {
                        file2.setLastModified(0L);
                    }
                    int i2 = g5.a;
                    if (!d0.a(new File(d0.a(context), "supporters_cache.txt"), new File(d0.a(context), "supporters_fetch.stamp"), 3600000L)) {
                        strC = d0.c(context);
                        if (!TextUtils.isEmpty(strC)) {
                            linkedHashMapB = e0.b(strC);
                            if (!linkedHashMapB.isEmpty()) {
                                a(linkedHashMapB);
                                d(context);
                                linkedHashMapB.size();
                                int i3 = g5.a;
                            }
                        }
                    }
                } else {
                    a(linkedHashMapB2);
                    if (!d0.a(new File(d0.a(context), "supporters_cache.txt"), new File(d0.a(context), "supporters_fetch.stamp"), 3600000L)) {
                        d(context);
                    }
                    linkedHashMapB2.size();
                    int i4 = g5.a;
                }
            } else if (!d0.a(new File(d0.a(context), "supporters_cache.txt"), new File(d0.a(context), "supporters_fetch.stamp"), 3600000L)) {
                strC = d0.c(context);
                if (!TextUtils.isEmpty(strC)) {
                    linkedHashMapB = e0.b(strC);
                    if (!linkedHashMapB.isEmpty()) {
                        a(linkedHashMapB);
                        d(context);
                        linkedHashMapB.size();
                        int i5 = g5.a;
                    }
                }
            }
        }
        a(context, false, (c1) null);
    }

    public static void a(File file, Context context, c1 c1Var) {
        boolean z2;
        int size;
        String message = null;
        try {
            String strB = d0.b("https://tiktokyou.yzewe.ru/api/v1/badges");
            if (!TextUtils.isEmpty(strB)) {
                LinkedHashMap linkedHashMapB = e0.b(strB);
                if (!linkedHashMapB.isEmpty()) {
                    d0.a(file, strB);
                    a(linkedHashMapB);
                    d(context);
                    z2 = true;
                    try {
                        size = linkedHashMapB.size();
                        try {
                            message = "Loaded " + size + " supporter uid(s)";
                            linkedHashMapB.size();
                            int i2 = g5.a;
                            p.set(false);
                            b(c1Var, true, size, message);
                        } catch (Throwable th) {
                            th = th;
                            try {
                                message = th.getMessage();
                                int i3 = g5.a;
                                if (a.isEmpty()) {
                                    String strC = d0.c(context);
                                    if (!TextUtils.isEmpty(strC)) {
                                        LinkedHashMap linkedHashMapB2 = e0.b(strC);
                                        if (!linkedHashMapB2.isEmpty()) {
                                            a(linkedHashMapB2);
                                            d(context);
                                            linkedHashMapB2.size();
                                        }
                                    }
                                }
                            } finally {
                                p.set(false);
                                b(c1Var, z2, size, message);
                            }
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        size = 0;
                    }
                } else {
                    throw new IOException("Invalid supporters list");
                }
            } else {
                throw new IOException("Empty supporters list");
            }
        } catch (Throwable th3) {
            th = th3;
            z2 = false;
            size = 0;
        }
    }

    public static void a(LinkedHashMap linkedHashMap) {
        if (linkedHashMap.isEmpty()) {
            return;
        }
        ConcurrentHashMap concurrentHashMap = a;
        concurrentHashMap.clear();
        concurrentHashMap.putAll(linkedHashMap);
        e.clear();
        f.clear();
        for (f1 f1Var : linkedHashMap.values()) {
            if (f1Var != null && !TextUtils.isEmpty(f1Var.a)) {
                String str = f1Var.a;
                String str2 = f1Var.f;
                ConcurrentHashMap concurrentHashMap2 = aa.a;
                if (!TextUtils.isEmpty(str)) {
                    if (TextUtils.isEmpty(str2)) {
                        aa.a.remove(str);
                    } else {
                        aa.a.put(str, str2);
                    }
                }
            }
        }
    }

    public static void a(Class cls, t6 t6Var) {
        try {
            v0 v0Var = new v0();
            for (String str : (String[]) t6Var.c.clone()) {
                HookBridge.hookAllMethods(cls, str, v0Var);
            }
        } catch (Throwable th) {
            th.getMessage();
            int i2 = g5.a;
        }
    }

    public static void a(Class cls, t6 t6Var, t6 t6Var2, int i2) {
        try {
            HookBridge.hookAllMethods(cls, t6Var.c[0], new y0());
            HookBridge.hookAllMethods(cls, t6Var2.c[0], new z0(i2));
        } catch (Throwable th) {
            th.getMessage();
            int i3 = g5.a;
        }
    }

    public static void a(HookMethod.HookMethodParam hookMethodParam, int i2) {
        Object objAppend;
        w9 w9VarA;
        Object[] objArr = hookMethodParam.args;
        if (objArr.length > i2) {
            Object obj = objArr[i2];
            if (obj instanceof String) {
                String str = (String) obj;
                Object obj2 = hookMethodParam.thisObject;
                if (TextUtils.isEmpty(str) || (w9VarA = a(obj2)) == null) {
                    objAppend = str;
                } else {
                    String string = str.toString();
                    String strA = a(w9VarA.a, string);
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

    public static w9 a(Object obj) {
        if (obj == null) {
            return null;
        }
        try {
            Object objB = b(obj);
            if (objB != null) {
                Object objInvoke = ha.a(objB.getClass(), "getUserProfileInfo", new Class[0]).invoke(objB, null);
                if (objInvoke instanceof UserProfileInfo) {
                    UserProfileInfo userProfileInfo = (UserProfileInfo) objInvoke;
                    String uid = userProfileInfo.getUid();
                    if (!TextUtils.isEmpty(uid) && c(uid) != null) {
                        a((CharSequence) userProfileInfo.getNickname());
                        return new w9(uid);
                    }
                }
            }
        } catch (Throwable th) {
        }
        String str = v;
        if (TextUtils.isEmpty(str) || c(str) == null) {
            return null;
        }
        return new w9(str);
    }

    public static void a() {
        g0 g0Var = new g0();
        HookBridge.hookAllMethods(IMUser.class, "getDisplayName", g0Var);
        HookBridge.hookAllMethods(IMUser.class, "getDisplayUserName", g0Var);
        HookBridge.hookAllMethods(IMUser.class, "getRawNickNameForDisplay", g0Var);
        HookBridge.hookAllMethods(IMUser.class, "getRemarkName", g0Var);
        HookBridge.hookAllMethods(IMUser.class, "getContactName", g0Var);
    }

    public static void a(o5 o5Var, t6 t6Var, o1 o1Var) {
        try {
            HookBridge.hookAllMethods(Class.forName(o5Var.b), t6Var.c[0], new l0(o1Var, o5Var));
        } catch (Throwable th) {
            th.getMessage();
            int i2 = g5.a;
        }
    }

    public static void a(Class cls, t6 t6Var, int i2) {
        try {
            HookBridge.hookAllMethods(cls, t6Var.c[0], new a1(i2));
        } catch (Throwable th) {
            String str = t6Var.c[0];
            th.getMessage();
            int i3 = g5.a;
        }
    }

    public static boolean a(TextView textView, MotionEvent motionEvent) {
        Spanned spanned;
        e1 e1Var;
        Activity activity;
        Fragment fragment;
        String str;
        CharSequence text = textView.getText();
        String str2 = null;
        if (text instanceof Spanned) {
            spanned = (Spanned) text;
            e1[] e1VarArr = (e1[]) spanned.getSpans(0, spanned.length(), e1.class);
            if (e1VarArr == null || e1VarArr.length == 0) {
                spanned = null;
            }
        } else {
            spanned = null;
        }
        Map map = j;
        h1 h1Var = (h1) map.get(textView);
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
        int i2 = g5.a;
        if (spanned == null) {
            if (h1Var != null) {
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
                e1 e1VarA = a(textView, spanned, motionEvent);
                if (e1VarA == null) {
                    map.remove(textView);
                    ViewParent parent2 = textView.getParent();
                    if (parent2 != null) {
                        parent2.requestDisallowInterceptTouchEvent(false);
                    }
                    return false;
                }
                map.put(textView, new h1(e1VarA));
                ViewParent parent3 = textView.getParent();
                if (parent3 != null) {
                    parent3.requestDisallowInterceptTouchEvent(true);
                }
                return true;
            case 1:
                if (h1Var == null) {
                    return false;
                }
                e1 e1VarA2 = a(textView, spanned, motionEvent);
                if (!h1Var.b && e1VarA2 == (e1Var = h1Var.a)) {
                    f1 f1Var = e1Var.b;
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
                        String[] strArr = (String[]) l6.a.c.clone();
                        int length = strArr.length;
                        int i3 = 0;
                        while (true) {
                            if (i3 < length) {
                                try {
                                    Object objInvoke = ha.a(cls, strArr[i3], View.class).invoke(null, textView);
                                    if (objInvoke instanceof Fragment) {
                                        fragment = (Fragment) objInvoke;
                                    }
                                } catch (Throwable th) {
                                    i3++;
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
                        } else if (f1Var != null) {
                            str = (String) f.get(f1Var.a);
                            if (!TextUtils.isEmpty(str)) {
                                str2 = str;
                            }
                        }
                    } else if (f1Var != null && !TextUtils.isEmpty(f1Var.a)) {
                        str = (String) f.get(f1Var.a);
                        if (!TextUtils.isEmpty(str)) {
                            str2 = str;
                        }
                    }
                    int i4 = g5.a;
                    if (activity != null) {
                        c(activity, fragment, f1Var, str2);
                    }
                }
                j.remove(textView);
                ViewParent parent4 = textView.getParent();
                if (parent4 != null) {
                    parent4.requestDisallowInterceptTouchEvent(false);
                }
                return true;
            case 2:
                if (h1Var == null) {
                    return false;
                }
                h1Var.b = a(textView, spanned, motionEvent) != h1Var.a;
                return true;
            case 3:
                if (h1Var == null) {
                    return false;
                }
                map.remove(textView);
                ViewParent parent5 = textView.getParent();
                if (parent5 != null) {
                    parent5.requestDisallowInterceptTouchEvent(false);
                }
                return true;
            default:
                return h1Var != null;
        }
    }

    public static e1 a(TextView textView, Spanned spanned, MotionEvent motionEvent) {
        int iWidth;
        Layout layout = textView.getLayout();
        if (layout == null) {
            return null;
        }
        float x2 = (motionEvent.getX() - textView.getTotalPaddingLeft()) + textView.getScrollX();
        float y2 = (motionEvent.getY() - textView.getTotalPaddingTop()) + textView.getScrollY();
        if (x2 >= 0.0f && y2 >= 0.0f) {
            e1[] e1VarArr = (e1[]) spanned.getSpans(0, spanned.length(), e1.class);
            if (e1VarArr != null && e1VarArr.length != 0) {
                int scaledTouchSlop = ViewConfiguration.get(textView.getContext()).getScaledTouchSlop();
                for (e1 e1Var : e1VarArr) {
                    if (e1Var != null) {
                        int spanStart = spanned.getSpanStart(e1Var);
                        int spanEnd = spanned.getSpanEnd(e1Var);
                        if (spanStart >= 0 && spanEnd > spanStart) {
                            int lineForOffset = layout.getLineForOffset(spanStart);
                            float lineTop = layout.getLineTop(lineForOffset) - scaledTouchSlop;
                            float lineBottom = layout.getLineBottom(lineForOffset) + scaledTouchSlop;
                            if (y2 >= lineTop && y2 <= lineBottom) {
                                float fMin = Math.min(layout.getPrimaryHorizontal(spanStart), layout.getPrimaryHorizontal(spanEnd));
                                float fMax = Math.max(layout.getPrimaryHorizontal(spanStart), layout.getPrimaryHorizontal(spanEnd));
                                BitmapDrawable bitmapDrawable = e1Var.a;
                                if (bitmapDrawable != null && (iWidth = bitmapDrawable.getBounds().width()) > 0) {
                                    float f2 = iWidth;
                                    if (fMax - fMin < f2) {
                                        fMax = fMin + f2;
                                    }
                                }
                                float f3 = scaledTouchSlop;
                                if (x2 >= fMin - f3 && x2 <= fMax + f3) {
                                    return e1Var;
                                }
                            }
                        }
                    }
                }
            }
        }
        return null;
    }

    public static void a(Fragment fragment, f1 f1Var, View view) {
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
        FrameLayout frameLayout = (FrameLayout) k.get(activity);
        if (frameLayout != null) {
            b(activity, frameLayout);
        }
        b(activity, fragment, f1Var);
    }

    public static void a(View view, s0 s0Var) {
        view.setOnTouchListener(s0Var);
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i2 = 0; i2 < viewGroup.getChildCount(); i2++) {
                a(viewGroup.getChildAt(i2), s0Var);
            }
        }
    }

    public static void a(final Activity activity, final FrameLayout frameLayout, View view) {
        if (frameLayout == null) {
            k.remove(activity);
        } else if (frameLayout.getParent() != null && view != null && view.getParent() != null) {
            view.animate().translationY(i1.a(view.getContext(), 100.0f)).alpha(0.0f).setDuration(220L).withEndAction(new Runnable() {
                @Override
                public final void run() {
                    d1.b(activity, frameLayout);
                }
            }).start();
        } else {
            b(activity, frameLayout);
        }
    }

    public static  void a(final Activity activity, Fragment fragment, f1 f1Var) {
        if (i1.a(activity)) {
            try {
                Dialog dialog = (Dialog) l.remove(activity);
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
                        d1.l.remove(activity);
                    }
                });
                Window window = dialog2.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                    window.setLayout(-1, -2);
                    window.setGravity(80);
                }
                l.put(activity, dialog2);
                dialog2.show();
            } catch (Throwable th2) {
                th2.getMessage();
                int i2 = g5.a;
            }
        }
    }

    public static k1 a(final Activity activity, final Dialog dialog, final Fragment fragment) {
        int color;
        f5 f5VarA = f5.a();
        boolean z2 = activity != null && (activity.getResources().getConfiguration().uiMode & 48) == 32;
        int color2 = z2 ? Color.parseColor("#1E1E1E") : -1;
        int color3 = z2 ? -1 : Color.parseColor("#161823");
        int color4 = Color.parseColor(z2 ? "#A7A9B0" : "#8A8B91");
        int color5 = z2 ? Color.parseColor("#303030") : Color.parseColor("#EFEFF0");
        int color6 = z2 ? Color.parseColor("#303030") : Color.parseColor("#F3F3F4");
        l8 l8VarA = l8.a();
        if (l8VarA != null && l8VarA.d()) {
            color = hd.a();
        } else {
            color = Color.parseColor("#FE2B54");
        }
        k1 k1Var = new k1(activity);
        k1Var.setVerticalScrollBarEnabled(false);
        k1Var.setOverScrollMode(2);
        k1Var.a = Math.max(0, Math.max((int) g2.a(activity, 1, 320.0f), (int) (activity.getResources().getDisplayMetrics().heightPixels * 0.85f)));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(color2);
        float fA = (int) g2.a(activity, 1, 24.0f);
        gradientDrawable.setCornerRadii(new float[]{fA, fA, fA, fA, 0.0f, 0.0f, 0.0f, 0.0f});
        k1Var.setBackground(gradientDrawable);
        k1Var.setClipToOutline(true);
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(1);
        int iA = (int) g2.a(activity, 1, 20.0f);
        int iA2 = (int) g2.a(activity, 1, 18.0f);
        int iA3 = (int) g2.a(activity, 1, 20.0f);
        int identifier = activity.getResources().getIdentifier("navigation_bar_height", "dimen", "android");
        linearLayout.setPadding(iA, iA2, iA3, (identifier > 0 ? activity.getResources().getDimensionPixelSize(identifier) : 0) + ((int) g2.a(activity, 1, 18.0f)));
        k1Var.addView(linearLayout, new FrameLayout.LayoutParams(-1, -2));
        FrameLayout frameLayout = new FrameLayout(activity);
        linearLayout.addView(frameLayout, new LinearLayout.LayoutParams(-1, -2));
        TextView textView = new TextView(activity);
        textView.setText(f5VarA.a("badge_sheet_header", "Подробнее"));
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
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams((int) g2.a(activity, 1, 32.0f), (int) g2.a(activity, 1, 32.0f));
        layoutParams.gravity = 8388629;
        frameLayout.addView(textView2, layoutParams);
        ImageView imageView = new ImageView(activity);
        Bitmap bitmapA = a(activity, new f1("", "asset:supporter.png", true, false, null, null), (int) g2.a(activity, 1, 52.0f));
        if (bitmapA != null) {
            imageView.setImageBitmap(bitmapA);
        }
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
        layoutParams2.gravity = 1;
        layoutParams2.topMargin = (int) g2.a(activity, 1, 20.0f);
        linearLayout.addView(imageView, layoutParams2);
        TextView textView3 = new TextView(activity);
        textView3.setText(f5VarA.a("badge_sheet_title", "Поддержите разработку"));
        textView3.setTextColor(color3);
        textView3.setTextSize(2, 18.0f);
        textView3.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView3.setGravity(17);
        LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams3.topMargin = (int) g2.a(activity, 1, 18.0f);
        linearLayout.addView(textView3, layoutParams3);
        TextView textView4 = new TextView(activity);
        textView4.setText(f5VarA.a("badge_sheet_subtitle", "Внесите вклад в развитие разработки и получите уникальный значок."));
        textView4.setTextColor(color4);
        textView4.setTextSize(2, 14.0f);
        textView4.setGravity(17);
        textView4.setLineSpacing(0.0f, 1.1f);
        LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams4.topMargin = (int) g2.a(activity, 1, 10.0f);
        linearLayout.addView(textView4, layoutParams4);
        String strA = f5VarA.a("badge_sheet_copy_uid", "Скопировать мой UID");
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(0);
        linearLayout2.setGravity(17);
        linearLayout2.setPadding((int) g2.a(activity, 1, 14.0f), 0, (int) g2.a(activity, 1, 14.0f), 0);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(color5);
        gradientDrawable2.setCornerRadius((int) TypedValue.applyDimension(1, 999.0f, activity.getResources().getDisplayMetrics()));
        linearLayout2.setBackground(gradientDrawable2);
        Bitmap bitmapB = b(activity, "ic_copy");
        if (bitmapB != null) {
            ImageView imageView2 = new ImageView(activity);
            imageView2.setImageBitmap(bitmapB);
            imageView2.setColorFilter(color3, PorterDuff.Mode.SRC_IN);
            LinearLayout.LayoutParams layoutParams5 = new LinearLayout.LayoutParams((int) g2.a(activity, 1, 13.0f), (int) g2.a(activity, 1, 13.0f));
            layoutParams5.rightMargin = (int) g2.a(activity, 1, 8.0f);
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
                d1.a(activity, view);
            }
        });
        LinearLayout.LayoutParams layoutParams6 = new LinearLayout.LayoutParams(-2, (int) g2.a(activity, 1, 36.0f));
        layoutParams6.gravity = 1;
        layoutParams6.topMargin = (int) g2.a(activity, 1, 18.0f);
        linearLayout.addView(linearLayout2, layoutParams6);
        LinearLayout linearLayout3 = new LinearLayout(activity);
        linearLayout3.setOrientation(1);
        LinearLayout.LayoutParams layoutParams7 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams7.topMargin = (int) g2.a(activity, 1, 20.0f);
        linearLayout.addView(linearLayout3, layoutParams7);
        bc bcVar = z != null ? z : new bc("5", "500");
        linearLayout3.addView(a(activity, "ic_coin", String.format(f5VarA.a("badge_sheet_step1_title_format", "Пожертвуйте не менее $%1$s (%2$s₽)"), bcVar.a, bcVar.b), f5VarA.a("badge_sheet_step1_subtitle", "Переведите сумму по любым из наших реквизитов"), color6, color3, color4));
        LinearLayout.LayoutParams layoutParams8 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams8.topMargin = (int) g2.a(activity, 1, 8.0f);
        String strA2 = f5VarA.a("badge_sheet_step2_title", "Пришлите подтверждение и ваш UID");
        String strA3 = f5VarA.a("badge_sheet_step2_contact", "@tt_u_bot");
        String str = String.format(f5VarA.a("badge_sheet_step2_subtitle", "Отправьте чек или скриншот в %s, а также ваш UID для выдачи"), strA3);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(str);
        int iIndexOf = str.indexOf(strA3);
        if (iIndexOf >= 0) {
            spannableStringBuilder.setSpan(new t0(activity, color), iIndexOf, strA3.length() + iIndexOf, 33);
        }
        linearLayout3.addView(a(activity, "photo", strA2, spannableStringBuilder, color6, color3, color4), layoutParams8);
        LinearLayout.LayoutParams layoutParams9 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams9.topMargin = (int) g2.a(activity, 1, 8.0f);
        linearLayout3.addView(a(activity, "ic_mod_logo", f5VarA.a("badge_sheet_step3_title", "Получите значок"), f5VarA.a("badge_sheet_step3_subtitle", "После проверки он появится в вашем профиле и будет виден всем"), color6, color3, color4), layoutParams9);
        LinearLayout linearLayout4 = new LinearLayout(activity);
        linearLayout4.setOrientation(0);
        LinearLayout.LayoutParams layoutParams10 = new LinearLayout.LayoutParams(-1, -2);
        layoutParams10.topMargin = (int) g2.a(activity, 1, 28.0f);
        linearLayout.addView(linearLayout4, layoutParams10);
        String strA4 = f5VarA.a("badge_sheet_cancel", "Отмена");
        TextView textView6 = new TextView(activity);
        textView6.setText(strA4);
        textView6.setTextColor(color3);
        textView6.setTextSize(2, 17.0f);
        textView6.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView6.setGravity(17);
        GradientDrawable gradientDrawable3 = new GradientDrawable();
        gradientDrawable3.setColor(color5);
        gradientDrawable3.setCornerRadius(i1.a(activity, 999.0f));
        textView6.setBackground(gradientDrawable3);
        textView6.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                dialog.dismiss();
            }
        });
        LinearLayout.LayoutParams layoutParams11 = new LinearLayout.LayoutParams(0, (int) g2.a(activity, 1, 48.0f));
        layoutParams11.weight = 1.0f;
        linearLayout4.addView(textView6, layoutParams11);
        String strA5 = f5VarA.a("badge_sheet_support", "Поддержать");
        TextView textView7 = new TextView(activity);
        textView7.setText(strA5);
        textView7.setTextColor(-1);
        textView7.setTextSize(2, 17.0f);
        textView7.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView7.setGravity(17);
        GradientDrawable gradientDrawable4 = new GradientDrawable();
        gradientDrawable4.setColor(color);
        gradientDrawable4.setCornerRadius(i1.a(activity, 999.0f));
        textView7.setBackground(gradientDrawable4);
        textView7.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                d1.a(fragment, activity, dialog, view);
            }
        });
        LinearLayout.LayoutParams layoutParams12 = new LinearLayout.LayoutParams(0, (int) g2.a(activity, 1, 48.0f));
        layoutParams12.weight = 1.0f;
        layoutParams12.leftMargin = (int) g2.a(activity, 1, 10.0f);
        linearLayout4.addView(textView7, layoutParams12);
        return k1Var;
    }

    public static  void a(Fragment fragment, Activity activity, Dialog dialog, View view) {
        if (fragment != null) {
            int i2 = g5.a;
        }
        c(activity);
        dialog.dismiss();
    }

    public static LinearLayout a(Activity activity, String str, String str2, CharSequence charSequence, int i2, int i3, int i4) {
        LinearLayout linearLayout = new LinearLayout(activity);
        linearLayout.setOrientation(0);
        linearLayout.setGravity(48);
        linearLayout.setPadding(i1.a(activity, 14.0f), (int) g2.a(activity, 1, 12.0f), (int) g2.a(activity, 1, 14.0f), (int) g2.a(activity, 1, 12.0f));
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setColor(i2);
        gradientDrawable.setCornerRadius((int) TypedValue.applyDimension(1, 10.0f, activity.getResources().getDisplayMetrics()));
        linearLayout.setBackground(gradientDrawable);
        Bitmap bitmapB = b(activity, str);
        if (bitmapB != null) {
            ImageView imageView = new ImageView(activity);
            imageView.setImageBitmap(bitmapB);
            imageView.setColorFilter(i4, PorterDuff.Mode.SRC_IN);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams((int) g2.a(activity, 1, 18.0f), (int) g2.a(activity, 1, 18.0f));
            layoutParams.topMargin = (int) g2.a(activity, 1, 2.0f);
            linearLayout.addView(imageView, layoutParams);
        }
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams2.leftMargin = (int) g2.a(activity, 1, 12.0f);
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
        layoutParams3.topMargin = (int) g2.a(activity, 1, 3.0f);
        linearLayout2.addView(textView2, layoutParams3);
        return linearLayout;
    }

    public static void a(Activity activity, View view) {
        String strH = h();
        f5.a();
        if (TextUtils.isEmpty(strH)) {
            Toast.makeText(activity, f5.a().a("copy_uid_unavailable"), 0).show();
            return;
        }
        ClipboardManager clipboardManager = (ClipboardManager) activity.getSystemService("clipboard");
        if (clipboardManager == null) {
            Toast.makeText(activity, f5.a().a("copy_uid_failed"), 0).show();
            return;
        }
        try {
            clipboardManager.setPrimaryClip(ClipData.newPlainText("uid", strH));
            Toast.makeText(activity, f5.a().a("copy_uid_copied"), 0).show();
        } catch (Throwable th) {
            Toast.makeText(activity, f5.a().a("copy_uid_failed"), 0).show();
        }
    }

    public static FrameLayout a(Activity activity, final Fragment fragment, final f1 f1Var, String str) {
        String strReplace;
        boolean z2 = activity != null && (activity.getResources().getConfiguration().uiMode & 48) == 32;
        int color = z2 ? Color.parseColor("#1E1E1E") : -1;
        int color2 = z2 ? -1 : Color.parseColor("#161823");
        l8 l8VarA = l8.a();
        int color3 = (l8VarA == null || !l8VarA.d()) ? Color.parseColor("#FE2B54") : hd.a();
        FrameLayout frameLayout = new FrameLayout(activity);
        int iA = i1.a(activity, 14.0f);
        int iA2 = (int) g2.a(activity, 1, 12.0f);
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
        Bitmap bitmapA = a(activity, f1Var, (int) g2.a(activity, 1, 26.0f));
        if (bitmapA != null) {
            imageView.setImageBitmap(bitmapA);
        }
        linearLayout.addView(imageView, new LinearLayout.LayoutParams(-2, -2));
        LinearLayout linearLayout2 = new LinearLayout(activity);
        linearLayout2.setOrientation(1);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, -2, 1.0f);
        layoutParams.leftMargin = (int) g2.a(activity, 1, 10.0f);
        layoutParams.rightMargin = (int) g2.a(activity, 1, 6.0f);
        linearLayout.addView(linearLayout2, layoutParams);
        TextView textView = new TextView(activity);
        f5 f5VarA = f5.a();
        String strA = !TextUtils.isEmpty(str) ? str : f5VarA.a("badge_bulletin_unknown_name", "Этот человек");
        if (f1Var == null || TextUtils.isEmpty(f1Var.e)) {
            strReplace = (f1Var == null || !f1Var.d) ? String.format(f5VarA.a("badge_bulletin_supporter_format", "%s поддержал разработку TikTok You"), strA) : String.format(f5VarA.a("badge_bulletin_developer_format", "%s член команды разработки TikTok You"), strA);
        } else {
            strReplace = f1Var.e.replace("${1}", strA);
        }
        textView.setText(strReplace);
        textView.setTextSize(2, 14.0f);
        textView.setLineSpacing(0.0f, 1.0f);
        textView.setTextColor(color2);
        textView.setTypeface(Typeface.create("sans-serif-medium", 0));
        linearLayout2.addView(textView);
        TextView textView2 = new TextView(activity);
        textView2.setText(f5.a().a("badge_bulletin_button", "Подробнее"));
        textView2.setTextColor(-1);
        textView2.setTextSize(2, 13.0f);
        textView2.setTypeface(Typeface.create("sans-serif-medium", 0));
        textView2.setGravity(17);
        textView2.setPadding((int) TypedValue.applyDimension(1, 16.0f, activity.getResources().getDisplayMetrics()), 0, (int) g2.a(activity, 1, 16.0f), 0);
        GradientDrawable gradientDrawable2 = new GradientDrawable();
        gradientDrawable2.setColor(color3);
        gradientDrawable2.setCornerRadius((int) TypedValue.applyDimension(1, 68.0f, activity.getResources().getDisplayMetrics()));
        textView2.setBackground(gradientDrawable2);
        textView2.setMinHeight((int) TypedValue.applyDimension(1, 32.0f, activity.getResources().getDisplayMetrics()));
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public final void onClick(View view) {
                d1.a(fragment, f1Var, view);
            }
        });
        linearLayout.addView(textView2, new LinearLayout.LayoutParams(-2, (int) g2.a(activity, 1, 32.0f)));
        return frameLayout;
    }

    public static Bitmap a(Context context, f1 f1Var, int i2) {
        Bitmap bitmapCreateScaledBitmap;
        b0 b0VarA = a(context, f1Var);
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
                int i3 = g5.a;
                bitmapCreateScaledBitmap = null;
            }
        } else {
            bitmapCreateScaledBitmap = null;
        }
        if (!a(bitmapCreateScaledBitmap)) {
            return null;
        }
        Bitmap bitmapA = (f1Var == null || !f1Var.c) ? bitmapCreateScaledBitmap : a(bitmapCreateScaledBitmap, f(context));
        if (a(bitmapA)) {
            bitmapCreateScaledBitmap = bitmapA;
        }
        concurrentHashMap.put(str, bitmapCreateScaledBitmap);
        return bitmapCreateScaledBitmap;
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

    public static void a(String str, f1 f1Var) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strA = a((CharSequence) str);
        if (strA.isEmpty()) {
            return;
        }
        e.put(strA, f1Var);
        if (!TextUtils.isEmpty(f1Var.a)) {
            f.put(f1Var.a, strA);
        }
        a(f1Var);
    }

    public static String a(CharSequence charSequence) {
        return charSequence == null ? "" : charSequence.toString().replace("\u2063\u2064\u2063\u2064\u2063", "").replace("\ufdd0", "").replace("\u2063\u2063\u2064", "").replace("\u2064\u2063\u2063", "").replace(String.valueOf((char) 8203), "").replace(String.valueOf((char) 8204), "").replace(" ￼", "").replace("￼", "").replace((char) 160, ' ').trim();
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.contains("\u2063\u2064\u2063\u2064\u2063") || str.contains("\ufdd0") || str.contains("\u2063\u2063\u2064");
    }

    public static Bitmap a(Context context, TextView textView, f1 f1Var) {
        Bitmap bitmapCreateScaledBitmap;
        b0 b0VarA = a(context, f1Var);
        if (b0VarA == null || b0VarA.b == null) {
            return null;
        }
        int iMax = Math.max(1, Math.round(textView.getLineHeight() * 1.0f));
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
                int i2 = g5.a;
                bitmapCreateScaledBitmap = null;
            }
        } else {
            bitmapCreateScaledBitmap = null;
        }
        if (!a(bitmapCreateScaledBitmap)) {
            return null;
        }
        Bitmap bitmapA = (f1Var == null || !f1Var.c) ? bitmapCreateScaledBitmap : a(bitmapCreateScaledBitmap, f(context));
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
            boolean z2 = hd.c;
            hd.c = false;
            try {
                paint.setColorFilter(new PorterDuffColorFilter(i2, PorterDuff.Mode.SRC_IN));
                hd.c = z2;
                try {
                    canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
                    return bitmapCreateBitmap;
                } catch (Throwable th) {
                    th.getMessage();
                    int i3 = g5.a;
                    return null;
                }
            } catch (Throwable th2) {
                hd.c = z2;
                throw th2;
            }
        } catch (Throwable th3) {
            th3.getMessage();
            int i4 = g5.a;
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
        String strSubstring;
        String strB = g1.b(str);
        ConcurrentHashMap concurrentHashMap = b;
        Bitmap bitmap = (Bitmap) concurrentHashMap.get(strB);
        if (a(bitmap)) {
            return bitmap;
        }
        synchronized (d1.class) {
            Bitmap bitmap2 = (Bitmap) concurrentHashMap.get(strB);
            if (a(bitmap2)) {
                return bitmap2;
            }
            if (strB.startsWith("asset:")) {
                strSubstring = strB.substring(6);
            } else {
                strSubstring = "supporter.png";
            }
            try {
                InputStream inputStreamOpen = context.getAssets().open(strSubstring);
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
                e2.getMessage();
                int i2 = g5.a;
                return null;
            }
        }
    }

    public static void a(String str, Context context, String str2) {
        String strB = g1.b(str);
        String strB2 = g1.b(str2);
        if (g1.a(strB) && g1.a(strB2) && !TextUtils.equals(strB, strB2)) {
            ConcurrentHashMap concurrentHashMap = d;
            concurrentHashMap.put(strB, strB2);
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
                d0.a(new File(d0.a(context), "image_redirects.txt"), sb.toString());
            } catch (IOException e2) {
                e2.getMessage();
                int i2 = g5.a;
            }
        }
    }

    public static void a(String str, Context context) {
        try {
            c0 c0VarA = d0.a(str);
            byte[] bArr = c0VarA.a;
            if (bArr != null && bArr.length != 0) {
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                if (bitmapDecodeByteArray != null) {
                    String strB = g1.b(c0VarA.b);
                    d0.a(new File(new File(d0.a(context), "images"), d0.c(strB) + ".img"), bArr);
                    if (!TextUtils.equals(strB, str)) {
                        a(str, context, strB);
                    }
                    b(str);
                    b(strB);
                    b.put(strB, bitmapDecodeByteArray);
                    g.remove(str);
                    return;
                }
                throw new IOException("Invalid badge image");
            }
            throw new IOException("Empty badge data");
        } catch (Throwable th) {
            try {
                th.getMessage();
                int i2 = g5.a;
            } finally {
                g.remove(str);
            }
        }
    }

    public static String a(IMConversation iMConversation) {
        List<String> memberIdList;
        if (iMConversation == null || (memberIdList = iMConversation.getMemberIdList()) == null || memberIdList.isEmpty()) {
            return null;
        }
        String strH = h();
        String str = null;
        for (String str2 : memberIdList) {
            if (!TextUtils.isEmpty(str2)) {
                String strTrim = str2.trim();
                if (!strTrim.isEmpty() && (TextUtils.isEmpty(strH) || !TextUtils.equals(strH, strTrim))) {
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
