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
    public static boolean a;

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
        if (!a) {
            a = true;
            j.a = context.getApplicationContext() != null ? context.getApplicationContext() : context;
            g gVar = new g(context);
            File file = null;
            try {
                File fileM = gVar.m();
                try {
                    HookBridge.disableHiddenApiRestrictions();
                    ClassLoader classLoader = application.getClassLoader();
                    i.a(context, classLoader, ((e) fileM).b);
                    File file2 = ((e) fileM).c == null ? null : new File(((e) fileM).c, "resources");
                    if (file2 != null && file2.isDirectory()) {
                        file = file2;
                    }
                    ResourceOverlay.a = file;
                    a(application, context, classLoader);
                    if (((e) fileM).d) {
                        a(gVar, fileM);
                    } else {
                        gVar.a(fileM);
                    }
                    Log.i("TTModBootstrap", "Dynamic module started from " + ((e) fileM).a + " (" + ((e) fileM).e + ")");
                } catch (Throwable th) {
                    th = th;
                    file = fileM;
                    if (th instanceof InvocationTargetException) {
                        InvocationTargetException invocationTargetException = (InvocationTargetException) th;
                        if (invocationTargetException.getCause() != null) {
                            th = invocationTargetException.getCause();
                        }
                    }
                    Log.e("TTModBootstrap", "Dynamic module startup failed", th);
                    if (file != null) {
                        gVar.a(file, th);
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    public static void a(Application application, Context context, ClassLoader classLoader) throws IllegalAccessException, InvocationTargetException {
        Class.forName("com.windukk.mod.Main", true, classLoader).getMethod("start", Application.class, Context.class).invoke(null, application, context);
    }
}
