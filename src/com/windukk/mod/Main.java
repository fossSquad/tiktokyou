package com.windukk.mod;

import Z.ac;
import Z.b0;
import Z.b3;
import Z.bd;
import Z.bg;
import Z.bk;
import Z.d7;
import Z.dd;
import Z.df;
import Z.dg;
import Z.f3;
import Z.g6;
import Z.g7;
import Z.h2;
import Z.i7;
import Z.j7;
import Z.k2;
import Z.k7;
import Z.kg;
import Z.l7;
import Z.le;
import Z.m5;
import Z.m7;
import Z.mi;
import Z.n;
import Z.n6;
import Z.o6;
import Z.of;
import Z.pj;
import Z.qd;
import Z.qg;
import Z.rf;
import Z.u2;
import Z.v1;
import Z.v3;
import Z.y;
import Z.yc;
import Z.yd;
import Z.ye;
import Z.z2;
import Z.zh;
import android.app.Application;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.TypedValue;
import com.ss.android.ugc.aweme.utils.CommonUtils;
import com.windukk.hook.HookBridge;
import java.io.File;
import java.util.ArrayList;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.io.FilesKt;
import ni.shikatu.kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u000e\u001a\u00020\u000bH\u0007b\u0002\b\u000fJ\u0014\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012H\u0007b\u0002\b\u000fJ\u001c\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u000bH\u0007b\u0002\b\u000fJ\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0015\u0010\u0006\u001a\u00020\u00058\u0006X\u0087\u0004\u0092\u0002\u0002\b\u0007¢\u0006\u0002\n\u0000R\u0015\u0010\b\u001a\u00020\t8\u0006X\u0087D\u0092\u0002\u0002\b\u0007¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e\u0092\u0002\u0002\b\u0007¢\u0006\u0002\n\u0000Ê\u0001\u0010\b\u001b\u0012\f\b\u001c\u0012\b\b\fJ\u0004\b\b(\u001d¨\u0006\u001a"}, d2 = {"Lcom/windukk/mod/Main;", "", "<init>", "()V", "REAL_VERSION", "", "MOD_VERSION", "Lkotlin/jvm/JvmField;", "versionCode", "", "appContext", "Landroid/content/Context;", "mainApplication", "Landroid/app/Application;", "getApplicationContext", "Lkotlin/jvm/JvmStatic;", "dp", "px", "", "start", "", "application", "baseContext", "isDebugHookEnabled", "", "key", "ttmod:mod_release", "Landroid/annotation/SuppressLint;", "value", "StaticFieldLeak"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Main {
    public static final Main INSTANCE;
    public static final String MOD_VERSION;
    public static final int versionCode;
    public static Context appContext;
    public static Application mainApplication;

    static {
        INSTANCE = new Main();
        b = "v5.0";
        c = 1792428213;
    }

    public static final Context getApplicationContext() {
        Context context = appContext;
        if (context != null) {
            return context;
        }
        Context applicationContext = mainApplication.getApplicationContext();
        appContext = applicationContext;
        return applicationContext;
    }

    @JvmStatic
    public static final void start(Application application, final Context context) {
        ComponentName componentName;
        mainApplication = application;
        appContext = context;
        File filesDir = context.getFilesDir();
        g7.b(FilesKt.resolve(filesDir, "tiktokyoulogs"));
        f3.a((ContextWrapper) application);
        f3.a((Context) application);
        CommonUtils.init(context);
        try {
            HookBridge.disableHiddenApiRestrictions();
        } catch (Throwable th) {
        }
        bg.a(new Runnable() {
            @Override
            public final void run() {
                Main.verifySignature(context);
            }
        });
        ac.a(context);
        l7 l7Var = k7.a;
        int i = qg.a;
        try {
            ArrayList arrayListA = j7.a(context);
            if (!arrayListA.isEmpty()) {
                String strA = j7.a();
                int size = arrayListA.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        componentName = null;
                        break;
                    }
                    Object obj = arrayListA.get(i2);
                    i2++;
                    i7 i7Var = (i7) obj;
                    if (i7Var.a.equals(strA)) {
                        componentName = i7Var.b;
                        break;
                    }
                }
                if (componentName == null) {
                    strA = "default";
                    int size2 = arrayListA.size();
                    int i3 = 0;
                    while (i3 < size2) {
                        Object obj2 = arrayListA.get(i3);
                        i3++;
                        i7 i7Var2 = (i7) obj2;
                        if (i7Var2.a.equals("default")) {
                            componentName = i7Var2.b;
                            break;
                        }
                    }
                }
                if (componentName != null && context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                    j7.a(context, strA);
                }
            }
        } catch (Throwable th2) {
            g7.a(6, "Reconcile failed", th2);
        }
        try {
            o6.a();
            mi.c();
            le.a();
            k2.a();
            pj.g();
            Main main = INSTANCE;
            main.getClass();
            bg.f();
            n.a();
            m7.a();
            v1.h();
            z2.a();
            b3.a();
            ye.a();
            m5.b();
            yd.a();
            kg.a();
            of.e();
            v3.d();
            qd.i();
            u2.a();
            df.a();
            rf.a();
            bk.d();
            yc.a();
            y.a();
            d7.a();
            n6.a();
            b0.a();
            zh.b();
            g6.a();
            h2.c();
        } catch (Exception e2) {
            g7.a(6, g7.a("Exception during hooks setup", new Object[0]), e2);
        }
        dg dgVar = dg.a;
        ac.a.getClass();
        if (!ac.e().H) {
            dg.a.getClass();
            dg.a(0);
        }
        dd.a.getClass();
        dd.a(false, (bd) null);
    }

    public static final int dp(float f) {
        return (int) TypedValue.applyDimension(1, f, getApplicationContext().getResources().getDisplayMetrics());
    }

    public static final void verifySignature(Context context) {
        CommonUtils.verifySignatureNative(context);
    }
}
