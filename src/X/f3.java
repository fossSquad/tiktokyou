package X;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Looper;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public abstract class f3 {
    public static  void a(Activity activity, List list, e3 e3Var) {
        if (b(activity, list, e3Var)) {
            return;
        }
        int i = p4.a;
    }

    public static boolean b(Activity activity, List list, final e3 e3Var) {
        Activity activity2;
        FragmentManager fragmentManager;
        boolean z;
        Object[] objArr;
        Class<?> cls;
        Class<?> cls2;
        Class<?> cls3;
        final AtomicReference atomicReference;
        Object objNewInstance;
        int i;
        Object objInvoke;
        Class<?>[] clsArr = null;
        boolean z2 = false;
        z2 = false;
        try {
            activity2 = activity;
            try {
                Object objInvoke2 = g8.a(activity.getClass(), "getSupportFragmentManager", new Class[0]).invoke(activity2, null);
                fragmentManager = objInvoke2 instanceof FragmentManager ? (FragmentManager) objInvoke2 : null;
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
            activity2 = activity;
        }
        if (fragmentManager != null) {
            try {
                Object objB = g8.b(fragmentManager, "isStateSaved");
                int i2 = 1;
                if (objB instanceof Boolean) {
                    try {
                        if (((Boolean) objB).booleanValue()) {
                            objArr = true;
                        }
                        if (objArr == false) {
                            ClassLoader classLoader = activity2.getClassLoader();
                            p5 p5Var = x6.a;
                            Class<?> cls4 = Class.forName("X.0oN5", false, classLoader);
                            p5 p5Var2 = y6.a;
                            cls = Class.forName("X.0nnh", false, classLoader);
                            p5 p5Var3 = w6.a;
                            cls2 = Class.forName("X.0nng", false, classLoader);
                            cls3 = Class.forName("kotlin.jvm.functions.Function1", false, classLoader);
                            Object objNewInstance2 = cls4.getDeclaredConstructor(null).newInstance(null);
                            Object obj = x6.a.a(cls4).get(objNewInstance2);
                            v6.a.a(obj.getClass()).set(obj, o4.a().a("download_quality_title", "Выберите качество"));
                            atomicReference = new AtomicReference();
                            objNewInstance = Array.newInstance(cls, list.size());
                            i = 0;
                            while (i < list.size()) {
                                final g3 g3Var = (g3) list.get(i);
                                Object objNewInstance3 = cls.getDeclaredConstructor(clsArr).newInstance(clsArr);
                                w6.a.a(cls2).set(objNewInstance3, h3.c(g3Var));
                                y6.a.a(cls).set(objNewInstance3, h3.b(g3Var));
                                ClassLoader classLoader2 = cls3.getClassLoader();
                                Class[] clsArr2 = new Class[i2];
                                clsArr2[z2 ? 1 : 0] = cls3;
                                z = z2 ? 1 : 0;
                                try {
                                    Object objNewProxyInstance = Proxy.newProxyInstance(classLoader2, clsArr2, new InvocationHandler() {
                                        @Override
                                        public final Object invoke(Object obj2, Method method, Object[] objArr2) {
                                            return f3.a(atomicReference, e3Var, g3Var, obj2, method, objArr2);
                                        }
                                    });
                                    x5 x5Var = w6.b;
                                    Class[] clsArr3 = new Class[1];
                                    clsArr3[z ? 1 : 0] = cls3;
                                    x5Var.a(cls2, clsArr3).invoke(objNewInstance3, objNewProxyInstance);
                                    Array.set(objNewInstance, i, objNewInstance3);
                                    i++;
                                    z2 = z ? 1 : 0;
                                    clsArr = null;
                                    i2 = 1;
                                } catch (Throwable th3) {
                                    th = th3;
                                    th.getMessage();
                                    int i3 = p4.a;
                                    return z;
                                }
                            }
                            int i4 = z2 ? 1 : 0;
                            x5 x5Var2 = x6.b;
                            Class[] clsArr4 = new Class[1];
                            clsArr4[i4] = objNewInstance.getClass();
                            x5Var2.a(cls4, clsArr4).invoke(objNewInstance2, objNewInstance);
                            objInvoke = x6.c.a(cls4, new Class[i4]).invoke(objNewInstance2, null);
                            if (!(objInvoke instanceof DialogFragment)) {
                                return false;
                            }
                            DialogFragment dialogFragment = (DialogFragment) objInvoke;
                            atomicReference.set(dialogFragment);
                            dialogFragment.show(fragmentManager, "TTModDownloadQuality");
                            return true;
                        }
                    } catch (Throwable th4) {
                        th = th4;
                        z = z2;
                        th.getMessage();
                        int i5 = p4.a;
                        return z;
                    }
                }
                objArr = false;
                if (objArr == false) {
                    ClassLoader classLoader3 = activity2.getClassLoader();
                    p5 p5Var4 = x6.a;
                    Class<?> cls5 = Class.forName("X.0oN5", false, classLoader3);
                    p5 p5Var5 = y6.a;
                    cls = Class.forName("X.0nnh", false, classLoader3);
                    p5 p5Var6 = w6.a;
                    cls2 = Class.forName("X.0nng", false, classLoader3);
                    cls3 = Class.forName("kotlin.jvm.functions.Function1", false, classLoader3);
                    Object objNewInstance4 = cls5.getDeclaredConstructor(null).newInstance(null);
                    Object obj2 = x6.a.a(cls5).get(objNewInstance4);
                    v6.a.a(obj2.getClass()).set(obj2, o4.a().a("download_quality_title", "Выберите качество"));
                    atomicReference = new AtomicReference();
                    objNewInstance = Array.newInstance(cls, list.size());
                    i = 0;
                    while (i < list.size()) {
                        final g3 g3Var2 = (g3) list.get(i);
                        Object objNewInstance5 = cls.getDeclaredConstructor(clsArr).newInstance(clsArr);
                        w6.a.a(cls2).set(objNewInstance5, h3.c(g3Var2));
                        y6.a.a(cls).set(objNewInstance5, h3.b(g3Var2));
                        ClassLoader classLoader4 = cls3.getClassLoader();
                        Class[] clsArr5 = new Class[i2];
                        clsArr5[z2 ? 1 : 0] = cls3;
                        z = z2 ? 1 : 0;
                        Object objNewProxyInstance2 = Proxy.newProxyInstance(classLoader4, clsArr5, new InvocationHandler() {
                            @Override
                            public final Object invoke(Object obj3, Method method, Object[] objArr2) {
                                return f3.a(atomicReference, e3Var, g3Var2, obj3, method, objArr2);
                            }
                        });
                        x5 x5Var3 = w6.b;
                        Class[] clsArr6 = new Class[1];
                        clsArr6[z ? 1 : 0] = cls3;
                        x5Var3.a(cls2, clsArr6).invoke(objNewInstance5, objNewProxyInstance2);
                        Array.set(objNewInstance, i, objNewInstance5);
                        i++;
                        z2 = z ? 1 : 0;
                        clsArr = null;
                        i2 = 1;
                    }
                    int i6 = z2 ? 1 : 0;
                    x5 x5Var4 = x6.b;
                    Class[] clsArr7 = new Class[1];
                    clsArr7[i6] = objNewInstance.getClass();
                    x5Var4.a(cls5, clsArr7).invoke(objNewInstance4, objNewInstance);
                    objInvoke = x6.c.a(cls5, new Class[i6]).invoke(objNewInstance4, null);
                    if (!(objInvoke instanceof DialogFragment)) {
                        return false;
                    }
                    DialogFragment dialogFragment2 = (DialogFragment) objInvoke;
                    atomicReference.set(dialogFragment2);
                    dialogFragment2.show(fragmentManager, "TTModDownloadQuality");
                    return true;
                }
            } catch (Throwable th5) {
                th = th5;
                z = false;
            }
        }
        if (fragmentManager != null) {
            Object objB2 = g8.b(fragmentManager, "isStateSaved");
            if (!(objB2 instanceof Boolean) || ((Boolean) objB2).booleanValue()) {
            }
        }
        int i7 = p4.a;
        return false;
    }

    public static  Object a(AtomicReference atomicReference, e3 e3Var, g3 g3Var, Object obj, Method method, Object[] objArr) {
        Object obj2 = null;
        if (method.getDeclaringClass() == Object.class) {
            String name = method.getName();
            if ("hashCode".equals(name)) {
                return Integer.valueOf(System.identityHashCode(obj));
            }
            if ("equals".equals(name)) {
                if (objArr != null && objArr.length > 0) {
                    obj2 = objArr[0];
                }
                return Boolean.valueOf(obj == obj2);
            }
            if ("toString".equals(name)) {
                return "TTModDownloadQuality";
            }
        }
        if ("invoke".equals(method.getName())) {
            DialogFragment dialogFragment = (DialogFragment) atomicReference.get();
            if (dialogFragment != null) {
                dialogFragment.dismissAllowingStateLoss();
            }
            e3Var.a(g3Var);
        }
        return null;
    }

    public static boolean a(Context context, final List list, final e3 e3Var) {
        final Activity activity;
        while (true) {
            if (context instanceof ContextWrapper) {
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                if (context instanceof Activity) {
                    activity = (Activity) context;
                    break;
                }
                activity = (Activity) a2.f.get();
                if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                    break;
                }
                activity = null;
                break;
            }
        }
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed() && !list.isEmpty() && e3Var != null) {
            Runnable runnable = new Runnable() {
                @Override
                public final void run() {
                    f3.a(activity, list, e3Var);
                }
            };
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return b(activity, list, e3Var);
            }
            activity.runOnUiThread(runnable);
            return true;
        }
        list.size();
        int i = p4.a;
        return false;
    }
}
