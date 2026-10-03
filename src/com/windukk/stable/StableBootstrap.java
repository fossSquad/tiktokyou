package com.windukk.stable;

import a.e;
import a.g;
import a.i;
import a.j;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.windukk.hook.HookBridge;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public final class StableBootstrap {

    public static boolean f6a;

    static {
    }

    public static void a(final g gVar, final e eVar) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public final void run() {
                StableBootstrap.b(gVar, eVar);
            }
        }, 10000L);
    }

    public static  void b(g gVar, e eVar) {
        try {
            gVar.a(eVar);
            Log.i("TTModBootstrap", "Dynamic module health confirmed (" + eVar.e + ")");
        } catch (IOException e) {
            Log.e("TTModBootstrap", "Cannot confirm dynamic module health", e);
        }
    }

    public static synchronized void start(Application application, Context context) {
        Throwable th = null;
        if (!f6a) {
            f6a = true;
            j.f4a = context.getApplicationContext() != null ? context.getApplicationContext() : context;
            g gVar = new g(context);
            e eVar = null;
            File file = null;
            try {
                e eVarM = gVar.m();
                try {
                    HookBridge.disableHiddenApiRestrictions();
                    ClassLoader classLoader = application.getClassLoader();
                    i.a(context, classLoader, eVarM.b);
                    File file2 = eVarM.c == null ? null : new File(eVarM.c, "resources");
                    if (file2 != null && file2.isDirectory()) {
                        file = file2;
                    }
                    ResourceOverlay.f5a = file;
                    a(application, context, classLoader);
                    if (eVarM.d) {
                        a(gVar, eVarM);
                    } else {
                        gVar.a(eVarM);
                    }
                    Log.i("TTModBootstrap", "Dynamic module started from " + eVarM.f1a + " (" + eVarM.e + ")");
                } catch (Throwable th_c) {
                    th = th_c;
                    eVar = eVarM;
                    if (th instanceof InvocationTargetException) {
                        InvocationTargetException invocationTargetException = (InvocationTargetException) th;
                        if (invocationTargetException.getCause() != null) {
                            th = invocationTargetException.getCause();
                        }
                    }
                    Log.e("TTModBootstrap", "Dynamic module startup failed", th);
                    if (eVar != null) {
                        gVar.a(eVar, th);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static void a(Application application, Context context, ClassLoader classLoader) throws IllegalAccessException, InvocationTargetException, ClassNotFoundException, NoSuchMethodException {
        Class.forName("com.windukk.mod.Main", true, classLoader).getMethod("start", Application.class, Context.class).invoke(null, application, context);
    }
}
