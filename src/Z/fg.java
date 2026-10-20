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

public final class fg {
    public static final Lazy f = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return fg.f();
        }
    });
    public static final Lazy g = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return fg.g();
        }
    });
    public static final Lazy h = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return fg.h();
        }
    });
    public static final Lazy i = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return fg.d();
        }
    });
    public static final Lazy j = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return fg.e();
        }
    });
    public static final Lazy k = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return fg.c();
        }
    });
    public static final Lazy l = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return fg.b();
        }
    });
    public static final Lazy m = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return fg.i();
        }
    });
    public static final Lazy n = LazyKt.lazy(new Function0() {
        public final Object invoke() {
            return fg.a();
        }
    });
    public final p4 a;
    public final Handler b;
    public final AtomicInteger c;
    public final AtomicBoolean d;
    public Object e;

    public fg(p4 p4Var) {
        this.a = p4Var;
        Handler handler = new Handler(Looper.getMainLooper());
        this.b = handler;
        this.c = new AtomicInteger(-1);
        this.d = new AtomicBoolean(false);
        handler.post(new Runnable() {
            @Override
            public final void run() {
                fg.a(fg.this);
            }
        });
    }

    public static String a(p4 p4Var) {
        Object obj;
        Field field = (Field) n.getValue();
        String str = null;
        if (field != null) {
            try {
                Result.Companion companion = Result.Companion;
                Object obj2 = field.get(p4Var.b);
                obj = ResultCompat.constructor(obj2 instanceof String ? (String) obj2 : null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = ResultCompat.constructor(ResultKt.createFailure(th));
            }
            if (ResultCompat.isFailure(obj)) {
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
        String str3 = p4Var.e;
        if (str3 != null && !StringsKt.isBlank(str3)) {
            str = str3;
        }
        return str == null ? "download" : str;
    }

    public static final Method b() {
        try {
            return t8.e.a((Class) f.getValue(), new Class[0]);
        } catch (Throwable th) {
            return null;
        }
    }

    public static final Method c() {
        try {
            return t8.d.a((Class) f.getValue(), Integer.TYPE);
        } catch (Throwable th) {
            return null;
        }
    }

    public static final Method d() {
        try {
            return t8.b.a((Class) f.getValue(), Integer.TYPE);
        } catch (Throwable th) {
            return null;
        }
    }

    public static final Method e() {
        try {
            return t8.c.a((Class) f.getValue(), new Class[0]);
        } catch (Throwable th) {
            return null;
        }
    }

    public static final Class f() {
        try {
            v9 v9Var = t8.a;
            return Class.forName("X.17gS", false, fg.class.getClassLoader());
        } catch (Throwable th) {
            return null;
        }
    }

    public static final Constructor g() {
        try {
            Constructor declaredConstructor = ((Class) f.getValue()).getDeclaredConstructor(Integer.TYPE, Aweme.class, String.class);
            declaredConstructor.setAccessible(true);
            return declaredConstructor;
        } catch (Throwable th) {
            return null;
        }
    }

    public static final Method h() {
        try {
            return t8.a.a((Class) f.getValue(), Context.class);
        } catch (Throwable th) {
            return null;
        }
    }

    public static final Field i() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            e9 e9Var = q8.c;
            e9 e9Var2 = q8.a;
            obj = ResultCompat.constructor(e9Var.a(Class.forName("X.1IG0", false, fg.class.getClassLoader())));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = ResultCompat.constructor(ResultKt.createFailure(th));
        }
        if (ResultCompat.isFailure(obj)) {
            obj = null;
        }
        return (Field) obj;
    }

    public static final void a(fg fgVar) {
        Object obj;
        Object obj2;
        Object obj3;
        int iIntValue;
        fgVar.getClass();
        try {
            Result.Companion companion = Result.Companion;
            Constructor constructor = (Constructor) g.getValue();
            p4 p4Var = fgVar.a;
            Field field = (Field) m.getValue();
            if (field != null) {
                try {
                    obj3 = ResultCompat.constructor(Integer.valueOf(field.getInt(p4Var.b)));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj3 = ResultCompat.constructor(ResultKt.createFailure(th));
                }
                if (ResultCompat.isFailure(obj3)) {
                    obj3 = null;
                }
                Integer num = (Integer) obj3;
                if (num != null) {
                    iIntValue = num.intValue();
                } else {
                    iIntValue = 0;
                }
                Integer numValueOf = Integer.valueOf(iIntValue);
                p4 p4Var2 = fgVar.a;
                obj = ResultCompat.constructor(constructor.newInstance(numValueOf, p4Var2.c, a(p4Var2)));
            } else {
                iIntValue = 0;
                Integer numValueOf2 = Integer.valueOf(iIntValue);
                p4 p4Var3 = fgVar.a;
                obj = ResultCompat.constructor(constructor.newInstance(numValueOf2, p4Var3.c, a(p4Var3)));
            }
        } catch (Throwable th2) {
            Result.Companion companion3 = Result.Companion;
            obj = ResultCompat.constructor(ResultKt.createFailure(th2));
        }
        Throwable th3 = ResultCompat.exceptionOrNull(obj);
        if (th3 != null) {
            g7.a(6, g7.a("Stock download progress provider unavailable", new Object[0]), th3);
        }
        if (ResultCompat.isFailure(obj)) {
            obj = null;
        }
        fgVar.e = obj;
        if (obj != null) {
            try {
                Result.Companion companion4 = Result.Companion;
                Method method = (Method) h.getValue();
                Activity activity = (Activity) f3.f.get();
                method.invoke(obj, (activity == null || activity.isFinishing() || activity.isDestroyed()) ? Main.getApplicationContext() : activity);
                obj2 = ResultCompat.constructor(((Method) i.getValue()).invoke(obj, Integer.valueOf(RangesKt.coerceAtLeast(fgVar.c.get(), 0))));
            } catch (Throwable th4) {
                Result.Companion companion5 = Result.Companion;
                obj2 = ResultCompat.constructor(ResultKt.createFailure(th4));
            }
            Throwable th5 = ResultCompat.exceptionOrNull(obj2);
            if (th5 != null) {
                g7.a(6, g7.a("Stock download progress could not be shown", new Object[0]), th5);
                fgVar.e = null;
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
                fg.a(fg.this, iCoerceIn);
            }
        });
    }

    public static final void a(fg fgVar, int i2) {
        Object obj;
        Object obj2;
        if (fgVar.d.get() || (obj = fgVar.e) == null) {
            return;
        }
        try {
            Result.Companion companion = Result.Companion;
            obj2 = ResultCompat.constructor(((Method) i.getValue()).invoke(obj, Integer.valueOf(i2)));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = ResultCompat.constructor(ResultKt.createFailure(th));
        }
        Throwable th2 = ResultCompat.exceptionOrNull(obj2);
        if (th2 != null) {
            g7.a(6, g7.a("Stock download progress update failed", new Object[0]), th2);
        }
    }

    public final void a(final eg egVar, final Function0 function0) {
        if (this.d.compareAndSet(false, true)) {
            this.b.post(new Runnable() {
                @Override
                public final void run() {
                    fg.a(fg.this, function0, egVar);
                }
            });
        }
    }

    public static final void a(fg fgVar, Function0 function0, eg egVar) {
        Object obj;
        Object objInvoke;
        Object obj2 = fgVar.e;
        if (obj2 != null) {
            try {
                Result.Companion companion = Result.Companion;
                int iOrdinal = egVar.ordinal();
                if (iOrdinal == 0) {
                    objInvoke = ((Method) j.getValue()).invoke(obj2, null);
                } else if (iOrdinal == 1) {
                    objInvoke = ((Method) k.getValue()).invoke(obj2, -1);
                } else if (iOrdinal == 2) {
                    objInvoke = ((Method) l.getValue()).invoke(obj2, null);
                } else {
                    throw new NoWhenBranchMatchedException();
                }
                obj = ResultCompat.constructor(objInvoke);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = ResultCompat.constructor(ResultKt.createFailure(th));
            }
            Throwable th2 = ResultCompat.exceptionOrNull(obj);
            if (th2 != null) {
                g7.a(6, g7.a("Stock download progress completion failed", new Object[0]), th2);
            }
            ResultCompat.box(obj);
        }
        fgVar.e = null;
        function0.invoke();
    }

    public static final Field a() {
        Object obj;
        try {
            Result.Companion companion = Result.Companion;
            e9 e9Var = q8.b;
            e9 e9Var2 = q8.a;
            obj = ResultCompat.constructor(e9Var.a(Class.forName("X.1IG0", false, fg.class.getClassLoader())));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = ResultCompat.constructor(ResultKt.createFailure(th));
        }
        if (ResultCompat.isFailure(obj)) {
            obj = null;
        }
        return (Field) obj;
    }
}
