package Z;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.mod.Main;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
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
import ni.shikatu.kotlin.text.StringsKt;

public final class se {
    public static final Lazy f = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return se.e();
        }
    });
    public static final Lazy g = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            try {
                return se.f();
            } catch (NoSuchMethodException e) {
                return null;
            }
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
    public static final Lazy m = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return se.i();
        }
    });
    public static final Lazy n = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return se.h();
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
                se.a(se.this);
            }
        });
    }

    public static String a(a4 a4Var) {
        Object obj;
        Field field = (Field) n.getValue();
        String str = null;
        if (field != null) {
            try {
                Result.Companion companion = Result.Companion;
                Object obj2 = field.get(a4Var.b);
                obj = RCompat.m6constructorimpl(obj2 instanceof String ? (String) obj2 : null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
            }
            if (RCompat.m12isFailureimpl(obj)) {
                obj = null;
            }
            String str2 = (String) obj;
            if (str2 != null) {
                if (StringsKt.isBlank(str2)) {
                    str2 = null;
                }
                if (str2 != null) {
                    return str2;
                }
            }
        }
        String str3 = a4Var.e;
        if (str3 != null && !StringsKt.isBlank(str3)) {
            str = str3;
        }
        return str == null ? "download" : str;
    }

    public static final Method b() {
        try {
            return com.windukk.mod.a.d.a((Class) f.getValue(), Integer.TYPE);
        } catch (Throwable t) {
            return null;
        }
    }

    public static final Method c() {
        try {
            return com.windukk.mod.a.b.a((Class) f.getValue(), Integer.TYPE);
        } catch (Throwable t) {
            return null;
        }
    }

    public static final Method d() {
        try {
            return com.windukk.mod.a.c.a((Class) f.getValue(), new Class[0]);
        } catch (Throwable t) {
            return null;
        }
    }

    public static final Class e() {
        try {
            p8 p8Var = com.windukk.mod.a.a;
            return Class.forName("X.164V", false, se.class.getClassLoader());
        } catch (Throwable t) {
            return null;
        }
    }

    public static final Constructor f() throws NoSuchMethodException {
        Constructor declaredConstructor = ((Class) f.getValue()).getDeclaredConstructor(Integer.TYPE, Aweme.class, String.class);
        declaredConstructor.setAccessible(true);
        return declaredConstructor;
    }

    public static final Method g() {
        try {
            return com.windukk.mod.a.a.a((Class) f.getValue(), Context.class);
        } catch (Throwable t) {
            return null;
        }
    }

    public static final Field h() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            z7 z7Var = r7.b;
            z7 z7Var2 = r7.a;
            obj = RCompat.m6constructorimpl(z7Var.a(Class.forName("X.167M", false, se.class.getClassLoader())));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        if (RCompat.m12isFailureimpl(obj)) {
            obj = null;
        }
        return (Field) obj;
    }

    public static final Field i() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            z7 z7Var = r7.c;
            z7 z7Var2 = r7.a;
            obj = RCompat.m6constructorimpl(z7Var.a(Class.forName("X.167M", false, se.class.getClassLoader())));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        if (RCompat.m12isFailureimpl(obj)) {
            obj = null;
        }
        return (Field) obj;
    }

    public static final void a(se seVar) {
        Object obj;
        Object obj2;
        Object obj3;
        int iIntValue;
        seVar.getClass();
        try {
            Result.Companion companion = Result.Companion;
            Constructor constructor = (Constructor) g.getValue();
            a4 a4Var = seVar.a;
            Field field = (Field) m.getValue();
            if (field != null) {
                try {
                    obj3 = RCompat.m6constructorimpl(Integer.valueOf(field.getInt(a4Var.b)));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj3 = RCompat.m6constructorimpl(ResultKt.createFailure(th));
                }
                if (RCompat.m12isFailureimpl(obj3)) {
                    obj3 = null;
                }
                Integer num = (Integer) obj3;
                if (num != null) {
                    iIntValue = num.intValue();
                } else {
                    iIntValue = 0;
                }
                Integer numValueOf = Integer.valueOf(iIntValue);
                a4 a4Var2 = seVar.a;
                obj = RCompat.m6constructorimpl(constructor.newInstance(numValueOf, a4Var2.c, a(a4Var2)));
            } else {
                iIntValue = 0;
                Integer numValueOf2 = Integer.valueOf(iIntValue);
                a4 a4Var3 = seVar.a;
                obj = RCompat.m6constructorimpl(constructor.newInstance(numValueOf2, a4Var3.c, a(a4Var3)));
            }
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th2));
        }
        Throwable th3 = RCompat.m9exceptionOrNullimpl(obj);
        if (th3 != null) {
            h6.a(6, h6.a("Stock download progress provider unavailable", new Object[0]), th3);
        }
        if (RCompat.m12isFailureimpl(obj)) {
            obj = null;
        }
        seVar.e = obj;
        if (obj != null) {
            try {
                Result.Companion companion4 = Result.Companion;
                Method method = (Method) h.getValue();
                Activity activity = (Activity) u2.f.get();
                method.invoke(obj, (activity == null || activity.isFinishing() || activity.isDestroyed()) ? Main.getApplicationContext() : activity);
                obj2 = RCompat.m6constructorimpl(((Method) i.getValue()).invoke(obj, Integer.valueOf(RangesKt.coerceAtLeast(seVar.c.get(), 0))));
            } catch (Throwable th4) {
                Result.Companion companion5 = Result.Companion;
                obj2 = RCompat.m6constructorimpl(ResultKt.createFailure(th4));
            }
            Throwable th5 = RCompat.m9exceptionOrNullimpl(obj2);
            if (th5 != null) {
                h6.a(6, h6.a("Stock download progress could not be shown", new Object[0]), th5);
                seVar.e = null;
            }
        }
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
                se.a(se.this, iCoerceIn);
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
            obj2 = RCompat.m6constructorimpl(((Method) i.getValue()).invoke(obj, Integer.valueOf(i2)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        Throwable th2 = RCompat.m9exceptionOrNullimpl(obj2);
        if (th2 != null) {
            h6.a(6, h6.a("Stock download progress update failed", new Object[0]), th2);
        }
    }

    public final void a(final re reVar, final Function0 function0) {
        if (this.d.compareAndSet(false, true)) {
            this.b.post(new Runnable() {
                @Override
                public final void run() {
                    se.a(se.this, function0, reVar);
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
                obj = RCompat.m6constructorimpl(objInvoke);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
            }
            Throwable th2 = RCompat.m9exceptionOrNullimpl(obj);
            if (th2 != null) {
                h6.a(6, h6.a("Stock download progress completion failed", new Object[0]), th2);
            }
            RCompat.m5boximpl(obj);
        }
        seVar.e = null;
        function0.invoke();
    }

    public static final Method a() {
        try {
            return com.windukk.mod.a.e.a((Class) f.getValue(), new Class[0]);
        } catch (Throwable t) {
            return null;
        }
    }
}
