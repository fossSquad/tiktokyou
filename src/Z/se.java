package Z;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.mod.Main;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import ni.shikatu.kotlin.Lazy;
import ni.shikatu.kotlin.LazyKt;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.ranges.RangesKt;

public final class se {
    public static final Lazy f = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return se.e();
        }
    });
    public static final Lazy g = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return se.f();
        }
    });
    public static final Lazy h = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return se.g();
        }
    });
    public static final Lazy i = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return se.c();
        }
    });
    public static final Lazy j = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return se.d();
        }
    });
    public static final Lazy k = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return se.b();
        }
    });
    public static final Lazy l = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return se.a();
        }
    });
    public final a4 a;
    public final Handler b;
    public final AtomicInteger c;
    public final AtomicBoolean d;
    public Object e;

    public se(a4 a4Var) {
        this.a = a4Var;
        Handler handler = new Handler(Looper.getMainLooper());
        this.b = handler;
        this.c = new AtomicInteger(-1);
        this.d = new AtomicBoolean(false);
        handler.post(new Runnable() {
            @Override
            public final void run() {
                se.a(this.f$0);
            }
        });
    }

    public static final void a(se seVar) {
        Object obj;
        Object obj2;
        seVar.getClass();
        try {
            Result.Companion companion = Result.Companion;
            Constructor constructor = (Constructor) g.getValue();
            String strDecrypt = seVar.a.e;
            if (strDecrypt == null) {
                strDecrypt = "download";
            }
            obj = Result.constructor-impl(constructor.newInstance(strDecrypt, "download", seVar.a.c));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            h6.a(6, h6.a("Stock download progress provider unavailable", new Object[0]), th2);
        }
        if (Result.isFailure-impl(obj)) {
            obj = null;
        }
        seVar.e = obj;
        if (obj != null) {
            try {
                Result.Companion companion3 = Result.Companion;
                Method method = (Method) h.getValue();
                Activity activity = (Activity) u2.f.get();
                method.invoke(obj, (activity == null || activity.isFinishing() || activity.isDestroyed()) ? Main.a() : activity);
                obj2 = Result.constructor-impl(((Method) i.getValue()).invoke(obj, Integer.valueOf(RangesKt.coerceAtLeast(seVar.c.get(), 0))));
            } catch (Throwable th3) {
                Result.Companion companion4 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th3));
            }
            Throwable th4 = Result.exceptionOrNull-impl(obj2);
            if (th4 != null) {
                h6.a(6, h6.a("Stock download progress could not be shown", new Object[0]), th4);
                seVar.e = null;
            }
        }
    }

    public static final Method b() {
        return t7.d.a((Class) f.getValue(), Integer.TYPE);
    }

    public static final Method c() {
        return t7.b.a((Class) f.getValue(), Integer.TYPE);
    }

    public static final Method d() {
        return t7.c.a((Class) f.getValue(), new Class[0]);
    }

    public static final Class e() {
        p8 p8Var = t7.a;
        return Class.forName("com.ss.android.ugc.trill.download.ui.DownloadDialogProvider", false, se.class.getClassLoader());
    }

    public static final Constructor f() throws NoSuchMethodException {
        Constructor declaredConstructor = ((Class) f.getValue()).getDeclaredConstructor(String.class, String.class, Aweme.class);
        declaredConstructor.setAccessible(true);
        return declaredConstructor;
    }

    public static final Method g() {
        return t7.a.a((Class) f.getValue(), Context.class);
    }

    public final void a(int i2) {
        if (this.d.get()) {
            return;
        }
        final int iCoerceIn = RangesKt.coerceIn(i2, 0, 99);
        if (this.c.getAndSet(iCoerceIn) == iCoerceIn) {
            return;
        }
        this.b.post(new Runnable() {
            @Override
            public final void run() {
                se.a(this.f$0, iCoerceIn);
            }
        });
    }

    public static final void a(se seVar, int i2) {
        Object obj;
        Object obj2;
        if (seVar.d.get() || (obj = seVar.e) == null) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj2 = Result.constructor-impl(((Method) i.getValue()).invoke(obj, Integer.valueOf(i2)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj2);
        if (th2 != null) {
            h6.a(6, h6.a("Stock download progress update failed", new Object[0]), th2);
        }
    }

    public final void a(final re reVar, final Function0 function0) {
        if (this.d.compareAndSet(false, true)) {
            this.b.post(new Runnable() {
                @Override
                public final void run() {
                    se.a(this.f$0, function0, reVar);
                }
            });
        }
    }

    public static final void a(se seVar, Function0 function0, re reVar) {
        Object obj;
        Object objInvoke;
        Object obj2 = seVar.e;
        if (obj2 != null) {
            try {
                Result.Companion companion = Result.Companion;
                int iOrdinal = reVar.ordinal();
                if (iOrdinal == 0) {
                    objInvoke = ((Method) j.getValue()).invoke(obj2, null);
                } else if (iOrdinal == 1) {
                    objInvoke = ((Method) k.getValue()).invoke(obj2, -1);
                } else if (iOrdinal == 2) {
                    objInvoke = ((Method) l.getValue()).invoke(obj2, null);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                obj = Result.constructor-impl(objInvoke);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                h6.a(6, h6.a("Stock download progress completion failed", new Object[0]), th2);
            }
            Result.box-impl(obj);
        }
        seVar.e = null;
        function0.invoke();
    }

    public static final Method a() {
        return t7.e.a((Class) f.getValue(), new Class[0]);
    }
}
