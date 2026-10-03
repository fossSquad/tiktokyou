package com.windukk.mod;

import Z.FeedHooks;
import Z.FrameMetricsLeakHooks;
import Z.SeekBarHooks;
import Z.PhotoHooks;
import Z.CleanLinkHooks;
import Z.e6;
import Z.SimpleModeHooks;
import Z.h6;
import Z.i3;
import Z.ThemeHooks;
import Z.j2;
import Z.j6;
import Z.RegionHooks;
import Z.k6;
import Z.OfflineModeHooks;
import Z.EdgeSpeedupHooks;
import Z.BadgeHooks;
import Z.FlagSecureHooks;
import Z.l6;
import Z.m6;
import Z.SignatureFakerHooks;
import Z.n;
import Z.MandatoryLoginHooks;
import Z.nb;
import Z.CommentStickerHooks;
import Z.SavePhotoHooks;
import Z.SettingsHooks;
import Z.pb;
import Z.q;
import Z.ConfigHooks;
import Z.qe;
import Z.UnlockLimitsHooks;
import Z.FontHooks;
import Z.t;
import Z.ta;
import Z.u2;
import Z.PublishTabHooks;
import Z.StoryEngagementHooks;
import Z.BrowserHooks;
import Z.SearchHooks;
import Z.ye;
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
        MOD_VERSION = "v4.4";
        versionCode = 1790876728;
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
        h6.b(FilesKt.resolve(filesDir, "tiktokyoulogs"));
        u2.a((ContextWrapper) application);
        u2.a((Context) application);
        CommonUtils.init(context);
        try {
            HookBridge.disableHiddenApiRestrictions();
        } catch (Throwable th) {
        }
        SignatureFakerHooks.a(new Runnable() {
            @Override
            public final void run() {
                Main.verifySignature(context);
            }
        });
        ta.a(context);
        m6 m6Var = l6.a;
        int i = ye.a;
        try {
            ArrayList arrayListA = k6.a(context);
            if (!arrayListA.isEmpty()) {
                String strA = k6.a();
                int size = arrayListA.size();
                int i2 = 0;
                while (true) {
                    if (i2 >= size) {
                        componentName = null;
                        break;
                    }
                    Object obj = arrayListA.get(i2);
                    i2++;
                    j6 j6Var = (j6) obj;
                    if (j6Var.a.equals(strA)) {
                        componentName = j6Var.b;
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
                        j6 j6Var2 = (j6) obj2;
                        if (j6Var2.a.equals("default")) {
                            componentName = j6Var2.b;
                            break;
                        }
                    }
                }
                if (componentName != null && context.getPackageManager().getComponentEnabledSetting(componentName) != 1) {
                    k6.a(context, strA);
                }
            }
        } catch (Throwable th2) {
            h6.a(6, "Reconcile failed", th2);
        }
        try {
            FrameMetricsLeakHooks.a();
            SettingsHooks.c();
            PublishTabHooks.a();
            CleanLinkHooks.a();
            SimpleModeHooks.a();
            Main main = INSTANCE;
            main.getClass();
            SignatureFakerHooks.f();
            n.a();
            MandatoryLoginHooks.a();
            BadgeHooks.f();
            CommentStickerHooks.a();
            ConfigHooks.a();
            RegionHooks.a();
            FeedHooks.d();
            EdgeSpeedupHooks.a();
            StoryEngagementHooks.a();
            SearchHooks.e();
            i3.d();
            PhotoHooks.i();
            j2.a();
            SavePhotoHooks.a();
            SeekBarHooks.a();
            UnlockLimitsHooks.d();
            OfflineModeHooks.a();
            q.a();
            e6.a();
            FontHooks.a();
            t.a();
            ThemeHooks.b();
            FlagSecureHooks.a();
            BrowserHooks.c();
        } catch (Exception e2) {
            h6.a(6, h6.a("Exception during hooks setup", new Object[0]), e2);
        }
        qe qeVar = qe.a;
        ta.a.getClass();
        if (!ta.d().B) {
            qe.a.getClass();
            qe.a(0);
        }
        pb.a.getClass();
        pb.a(false, (nb) null);
    }

    public static final int dp(float f) {
        return (int) TypedValue.applyDimension(1, f, getApplicationContext().getResources().getDisplayMetrics());
    }

    public static final void verifySignature(Context context) {
        // Disabled: bypass native mod author signature check for repacked builds
    }
}
