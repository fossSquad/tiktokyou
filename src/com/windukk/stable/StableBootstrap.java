package com.windukk.stable;

import a.d;
import a.e;
import a.f;
import a.g;
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

    public static void a(final e eVar, final d dVar) {
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public final void run() {
                StableBootstrap.b(eVar, dVar);
            }
        }, 10000L);
    }

    public static  void b(e eVar, d dVar) {
        try {
            eVar.a(dVar);
            Log.i("TTModBootstrap", "Dynamic module health confirmed (" + dVar.e + ")");
        } catch (IOException e) {
            Log.e("TTModBootstrap", "Cannot confirm dynamic module health", e);
        }
    }

    public static synchronized void start(Application application, Context context) {
        if (!a) {
            a = true;
            g.a = context.getApplicationContext() != null ? context.getApplicationContext() : context;
            e eVar = new e(context);
            File file = null;
            try {
                File fileJ = eVar.j();
                try {
                    HookBridge.disableHiddenApiRestrictions();
                    ClassLoader classLoader = application.getClassLoader();
                    f.a(context, classLoader, ((d) fileJ).b);
                    File file2 = ((d) fileJ).c == null ? null : new File(((d) fileJ).c, "resources");
                    if (file2 != null && file2.isDirectory()) {
                        file = file2;
                    }
                    ResourceOverlay.a = file;
                    a(application, context, classLoader);
                    if (((d) fileJ).d) {
                        a(eVar, fileJ);
                    } else {
                        eVar.a(fileJ);
                    }
                    Log.i("TTModBootstrap", "Dynamic module started from " + ((d) fileJ).a + " (" + ((d) fileJ).e + ")");
                } catch (Throwable th) {
                    th = th;
                    file = fileJ;
                    if (th instanceof InvocationTargetException) {
                        InvocationTargetException invocationTargetException = (InvocationTargetException) th;
                        if (invocationTargetException.getCause() != null) {
                            th = invocationTargetException.getCause();
                        }
                    }
                    Log.e("TTModBootstrap", "Dynamic module startup failed", th);
                    if (file != null) {
                        eVar.a(file, th);
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
