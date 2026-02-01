package com.windukk.mod;

import Z.a;
import Z.b;
import Z.c;
import Z.d;
import Z.e;
import Z.f;
import Z.g;
import Z.i;
import Z.j;
import Z.k;
import Z.m;
import Z.n;
import Z.o;
import android.content.Context;
import android.content.pm.PackageManager;
import android.util.Log;
import android.util.TypedValue;
import com.ss.android.ugc.aweme.app.host.AwemeHostApplication;
import com.ss.android.ugc.aweme.utils.CommonUtils;
import de.robv.android.xposed.XC_MethodHook;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

public class Main {
    public static final String a = CommonUtils.getStringNative(0);
    public static final String b = CommonUtils.getStringNative(1);
    private static final ArrayList<XC_MethodHook.Unhook> c = new ArrayList<>();
    public static int d = 0;
    public static AwemeHostApplication e;

    public static void a(XC_MethodHook.Unhook... unhookArr) {
        c.addAll(Arrays.asList(unhookArr));
    }

    public static void start(AwemeHostApplication awemeHostApplication, Context context) {
        e = awemeHostApplication;
        try {
            CommonUtils.init(context);
            if (!CommonUtils.verifySignatureNative(context)) {
                System.exit(1);
                return;
            }
            try {
                d = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
            } catch (PackageManager.NameNotFoundException e2) {
                d = 0;
            }
            f.a(context);
            e.b();
            try {
                i.a();
                o.a();
                d.a();
                c.a();
                g.a();
                b.a();
                j.a();
                k.a();
                a.a();
                m.a();
                n.b();
            } catch (Exception e3) {
                Log.d(a, e3.toString());
            }
        } catch (Throwable th) {
            System.exit(1);
        }
    }

    @SafeVarargs
    public static void a(Set<XC_MethodHook.Unhook>... setArr) {
        for (Set<XC_MethodHook.Unhook> set : setArr) {
            c.addAll(set);
        }
    }

    public static Context a() {
        return e.getApplicationContext();
    }

    public static void a(String str, Object... objArr) {
        Log.d(a, ("{(" + b + ")}: ").concat(String.format(str, objArr)));
    }

    public static int a(float f) {
        return (int) TypedValue.applyDimension(1, f, a().getResources().getDisplayMetrics());
    }
}
