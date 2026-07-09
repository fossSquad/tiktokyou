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

public abstract class n3 {
    public static  void a(Activity activity, List list, m3 m3Var) {
        if (b(activity, list, m3Var)) {
            return;
        }
        int i = g5.a;
    }

    public static boolean b(Activity activity, List list, final m3 m3Var) {
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
                Object objInvoke2 = ha.a(activity.getClass(), "getSupportFragmentManager", new Class[0]).invoke(activity2, null);
                fragmentManager = objInvoke2 instanceof FragmentManager ? (FragmentManager) objInvoke2 : null;
            } catch (Throwable th) {
            }
        } catch (Throwable th2) {
            activity2 = activity;
        }
        if (fragmentManager != null) {
            try {
                Object objB = ha.b(fragmentManager, "isStateSaved");
                int i2 = 1;
                if (objB instanceof Boolean) {
                    try {
                        if (((Boolean) objB).booleanValue()) {
                            objArr = true;
                        }
                        if (objArr == false) {
                            ClassLoader classLoader = activity2.getClassLoader();
                            k6 k6Var = a8.a;
                            Class<?> cls4 = Class.forName("X.0y0X", false, classLoader);
                            k6 k6Var2 = b8.a;
                            cls = Class.forName("X.0c9N", false, classLoader);
                            k6 k6Var3 = z7.a;
                            cls2 = Class.forName("X.0c9M", false, classLoader);
                            cls3 = Class.forName("kotlin.jvm.functions.Function1", false, classLoader);
                            Object objNewInstance2 = cls4.getDeclaredConstructor(null).newInstance(null);
                            Object obj = a8.a.a(cls4).get(objNewInstance2);
                            y7.a.a(obj.getClass()).set(obj, f5.a().a("download_quality_title", "Выберите качество"));
                            atomicReference = new AtomicReference();
                            objNewInstance = Array.newInstance(cls, list.size());
                            i = 0;
                            while (i < list.size()) {
                                final o3 o3Var = (o3) list.get(i);
                                Object objNewInstance3 = cls.getDeclaredConstructor(clsArr).newInstance(clsArr);
                                z7.a.a(cls2).set(objNewInstance3, p3.c(o3Var));
                                b8.a.a(cls).set(objNewInstance3, p3.b(o3Var));
                                ClassLoader classLoader2 = cls3.getClassLoader();
                                Class[] clsArr2 = new Class[i2];
                                clsArr2[z2 ? 1 : 0] = cls3;
                                z = z2 ? 1 : 0;
                                try {
                                    Object objNewProxyInstance = Proxy.newProxyInstance(classLoader2, clsArr2, new InvocationHandler() {
                                        @Override
                                        public final Object invoke(Object obj2, Method method, Object[] objArr2) {
                                            return n3.a(atomicReference, m3Var, o3Var, obj2, method, objArr2);
                                        }
                                    });
                                    t6 t6Var = z7.b;
                                    Class[] clsArr3 = new Class[1];
                                    clsArr3[z ? 1 : 0] = cls3;
                                    t6Var.a(cls2, clsArr3).invoke(objNewInstance3, objNewProxyInstance);
                                    Array.set(objNewInstance, i, objNewInstance3);
                                    i++;
                                    z2 = z ? 1 : 0;
                                    clsArr = null;
                                    i2 = 1;
                                } catch (Throwable th3) {
                                    th = th3;
                                    th.getMessage();
                                    int i3 = g5.a;
                                    return z;
                                }
                            }
                            int i4 = z2 ? 1 : 0;
                            t6 t6Var2 = a8.b;
                            Class[] clsArr4 = new Class[1];
                            clsArr4[i4] = objNewInstance.getClass();
                            t6Var2.a(cls4, clsArr4).invoke(objNewInstance2, objNewInstance);
                            objInvoke = a8.c.a(cls4, new Class[i4]).invoke(objNewInstance2, null);
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
                        int i5 = g5.a;
                        return z;
                    }
                }
                objArr = false;
                if (objArr == false) {
                    ClassLoader classLoader3 = activity2.getClassLoader();
                    k6 k6Var4 = a8.a;
                    Class<?> cls5 = Class.forName("X.0y0X", false, classLoader3);
                    k6 k6Var5 = b8.a;
                    cls = Class.forName("X.0c9N", false, classLoader3);
                    k6 k6Var6 = z7.a;
                    cls2 = Class.forName("X.0c9M", false, classLoader3);
                    cls3 = Class.forName("kotlin.jvm.functions.Function1", false, classLoader3);
                    Object objNewInstance4 = cls5.getDeclaredConstructor(null).newInstance(null);
                    Object obj2 = a8.a.a(cls5).get(objNewInstance4);
                    y7.a.a(obj2.getClass()).set(obj2, f5.a().a("download_quality_title", "Выберите качество"));
                    atomicReference = new AtomicReference();
                    objNewInstance = Array.newInstance(cls, list.size());
                    i = 0;
                    while (i < list.size()) {
                        final o3 o3Var2 = (o3) list.get(i);
                        Object objNewInstance5 = cls.getDeclaredConstructor(clsArr).newInstance(clsArr);
                        z7.a.a(cls2).set(objNewInstance5, p3.c(o3Var2));
                        b8.a.a(cls).set(objNewInstance5, p3.b(o3Var2));
                        ClassLoader classLoader4 = cls3.getClassLoader();
                        Class[] clsArr5 = new Class[i2];
                        clsArr5[z2 ? 1 : 0] = cls3;
                        z = z2 ? 1 : 0;
                        Object objNewProxyInstance2 = Proxy.newProxyInstance(classLoader4, clsArr5, new InvocationHandler() {
                            @Override
                            public final Object invoke(Object obj3, Method method, Object[] objArr2) {
                                return n3.a(atomicReference, m3Var, o3Var2, obj3, method, objArr2);
                            }
                        });
                        t6 t6Var3 = z7.b;
                        Class[] clsArr6 = new Class[1];
                        clsArr6[z ? 1 : 0] = cls3;
                        t6Var3.a(cls2, clsArr6).invoke(objNewInstance5, objNewProxyInstance2);
                        Array.set(objNewInstance, i, objNewInstance5);
                        i++;
                        z2 = z ? 1 : 0;
                        clsArr = null;
                        i2 = 1;
                    }
                    int i6 = z2 ? 1 : 0;
                    t6 t6Var4 = a8.b;
                    Class[] clsArr7 = new Class[1];
                    clsArr7[i6] = objNewInstance.getClass();
                    t6Var4.a(cls5, clsArr7).invoke(objNewInstance4, objNewInstance);
                    objInvoke = a8.c.a(cls5, new Class[i6]).invoke(objNewInstance4, null);
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
            Object objB2 = ha.b(fragmentManager, "isStateSaved");
            if (!(objB2 instanceof Boolean) || ((Boolean) objB2).booleanValue()) {
            }
        }
        int i7 = g5.a;
        return false;
    }

    public static  Object a(AtomicReference atomicReference, m3 m3Var, o3 o3Var, Object obj, Method method, Object[] objArr) {
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
            m3Var.a(o3Var);
        }
        return null;
    }

    public static boolean a(Context context, final List list, final m3 m3Var) {
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
                activity = (Activity) i2.f.get();
                if (activity != null && !activity.isFinishing() && !activity.isDestroyed()) {
                    break;
                }
                activity = null;
                break;
            }
        }
        if (activity != null && !activity.isFinishing() && !activity.isDestroyed() && !list.isEmpty() && m3Var != null) {
            Runnable runnable = new Runnable() {
                @Override
                public final void run() {
                    n3.a(activity, list, m3Var);
                }
            };
            if (Looper.myLooper() == Looper.getMainLooper()) {
                return b(activity, list, m3Var);
            }
            activity.runOnUiThread(runnable);
            return true;
        }
        list.size();
        int i = g5.a;
        return false;
    }
}
