package Z;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import com.windukk.hook.HookBridge;
import com.windukk.hook.HookMethod;
import com.windukk.mod.Main;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class mi {
    public static final mi a;
    public static volatile Object b;
    public static volatile Object c;
    public static volatile boolean d;
    public static volatile boolean e;
    public static volatile boolean f;

    static {
        a = new mi();
    }

    public static final boolean a(mi miVar, Object obj) {
        Object obj2;
        miVar.getClass();
        String strDecrypt = "ttmod_settings";
        e9 e9Var = ab.b;
        Object obj3 = null;
        if (obj != null) {
            try {
                Result.Companion companion = Result.Companion;
                Object obj4 = e9Var.a(obj.getClass()).get(obj);
                obj2 = Result.constructor-impl(obj4 instanceof String ? (String) obj4 : null);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj2 = Result.constructor-impl(ResultKt.createFailure(th));
            }
            obj3 = (String) (Result.isFailure-impl(obj2) ? null : obj2);
        }
        return Intrinsics.areEqual(strDecrypt, obj3);
    }

    public static void b() throws ClassNotFoundException {
        Object obj;
        v9 v9Var = xa.a;
        Class<?> cls = Class.forName("X.1OEw");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Class<?> cls2 = Class.forName("X.18ib", false, classLoader);
        Class<?> cls3 = Class.forName("X.0yHL", false, classLoader);
        v9 v9Var2 = bb.a;
        Class<?> cls4 = Class.forName("X.1TlR", false, classLoader);
        v9 v9Var3 = ab.a;
        Class<?> cls5 = Class.forName("com.ss.android.ugc.aweme.setting.ui.rvmpcompose.group.privacy.cell.PrivacyItemVM", false, classLoader);
        v9 v9Var4 = xa.a;
        String str = v9Var4.c[0];
        Set setHookAllMethods = HookBridge.hookAllMethods(cls, str, new mi$after$1(cls2, cls3));
        if (setHookAllMethods.isEmpty()) {
            throw new IllegalStateException(("No methods matched " + v9Var4).toString());
        }
        v9 v9Var5 = bb.a;
        String str2 = v9Var5.c[0];
        Set setHookAllMethods2 = HookBridge.hookAllMethods(cls4, str2, new mi$before$1());
        if (setHookAllMethods2.isEmpty()) {
            throw new IllegalStateException(("No methods matched " + v9Var5).toString());
        }
        v9 v9Var6 = ab.a;
        String str3 = v9Var6.c[0];
        Set setHookAllMethods3 = HookBridge.hookAllMethods(cls5, str3, new mi$before$2(classLoader));
        if (setHookAllMethods3.isEmpty()) {
            throw new IllegalStateException(("No methods matched " + v9Var6).toString());
        }
        w7 w7Var = wa.a;
        Pair pair = TuplesKt.to(w7Var, wa.b);
        Pair pair2 = TuplesKt.to(w7Var, wa.c);
        w7 w7Var2 = za.a;
        for (Pair pair3 : CollectionsKt.listOf(new Pair[]{pair, pair2, TuplesKt.to(w7Var2, za.c), TuplesKt.to(w7Var2, za.b)})) {
            w7 w7Var3 = (w7) pair3.component1();
            v9 v9Var7 = (v9) pair3.component2();
            try {
                Result.Companion companion = Result.Companion;
                Class<?> cls6 = Class.forName(w7Var3.b, false, classLoader);
                String[] strArr = (String[]) v9Var7.c.clone();
                Set set = ArraysKt.toSet(strArr);
                Method[] declaredMethods = cls6.getDeclaredMethods();
                ArrayList arrayList = new ArrayList();
                for (Method method : declaredMethods) {
                    if (set.contains(method.getName())) {
                        arrayList.add(method);
                    }
                }
                if (arrayList.isEmpty()) {
                    throw new IllegalStateException(("No methods matched " + v9Var7).toString());
                }
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    Method method2 = (Method) obj2;
                    if (!HookBridge.deoptimizeMethod(method2)) {
                        throw new IllegalStateException(("Failed to deoptimize " + cls6.getName() + "#" + method2.getName()).toString());
                    }
                }
                arrayList.size();
                obj = Result.constructor-impl(Unit.INSTANCE);
                Throwable th = Result.exceptionOrNull-impl(obj);
                if (th != null) {
                    g7.a(6, g7.a("Unable to deoptimize settings caller " + v9Var7, new Object[0]), th);
                }
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th2));
            }
        }
        v9 v9Var8 = xa.a;
        v9 v9Var9 = ab.a;
    }

    public static final void c() {
        Object obj;
        Object obj2;
        mi miVar = a;
        try {
            Result.Companion companion = Result.Companion;
            miVar.getClass();
            a();
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            g7.a(6, g7.a("Notification icon hook unavailable", new Object[0]), th2);
        }
        mi miVar2 = a;
        try {
            Result.Companion companion3 = Result.Companion;
            miVar2.getClass();
            b();
            obj2 = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th3));
        }
        Throwable th4 = Result.exceptionOrNull-impl(obj2);
        if (th4 != null) {
            g7.a(6, g7.a("Settings row hook unavailable", new Object[0]), th4);
        }
    }

    public static void c(Object[] objArr) {
        Context contextA;
        Object obj;
        Context context;
        Object objFirstOrNull = ArraysKt.firstOrNull(objArr);
        if (objFirstOrNull != null) {
            if (objFirstOrNull instanceof Context) {
                contextA = (Context) objFirstOrNull;
            } else {
                try {
                    Result.Companion companion = Result.Companion;
                    e9 e9Var = va.a;
                    if (Class.forName("X.0mH5", false, objFirstOrNull.getClass().getClassLoader()).isInstance(objFirstOrNull)) {
                        Object obj2 = va.a.a(objFirstOrNull.getClass()).get(objFirstOrNull);
                        if (obj2 instanceof Context) {
                            context = (Context) obj2;
                        }
                        obj = Result.constructor-impl(context);
                        contextA = (Context) (Result.isFailure-impl(obj) ? null : obj);
                    }
                    context = null;
                    obj = Result.constructor-impl(context);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj = Result.constructor-impl(ResultKt.createFailure(th));
                }
                contextA = (Context) (Result.isFailure-impl(obj) ? null : obj);
            }
            if (contextA == null) {
                contextA = Main.getApplicationContext();
            }
        } else {
            contextA = Main.getApplicationContext();
        }
        Intent intent = new Intent(contextA, (Class<?>) sf.class);
        if (!(contextA instanceof Activity)) {
            intent.addFlags(268435456);
        }
        contextA.startActivity(intent);
    }

    public static final void a(mi miVar, HookMethod.HookMethodParam hookMethodParam, Class cls) {
        miVar.getClass();
        Object result = hookMethodParam.getResult();
        List list = result instanceof List ? (List) result : null;
        if (list == null) {
            return;
        }
        if (!list.isEmpty()) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (a(it.next())) {
                    return;
                }
            }
        }
        ArrayList arrayList = new ArrayList(list.size() + 1);
        arrayList.addAll(list);
        arrayList.add(a.a(cls));
        hookMethodParam.setResult(arrayList);
        if (e) {
            return;
        }
        e = true;
    }

    public static void a() throws NoSuchMethodException {
        Method method = Notification.Builder.class.getMethod("setSmallIcon", Icon.class);
        HookBridge.hookMethod(method, new mi$before$3());
    }

    public final Object a(Class cls) {
        Object objNewProxyInstance;
        Object obj = b;
        if (obj != null) {
            return obj;
        }
        synchronized (this) {
            objNewProxyInstance = b;
            if (objNewProxyInstance == null) {
                objNewProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {
                    @Override
                    public final Object invoke(Object obj2, Method method, Object[] objArr) {
                        return mi.a(obj2, method, objArr);
                    }
                });
                b = objNewProxyInstance;
            }
        }
        return objNewProxyInstance;
    }

    public static final Object a(Object obj, Method method, Object[] objArr) {
        if (Intrinsics.areEqual(method.getDeclaringClass(), Object.class)) {
            mi miVar = a;
            String strDecrypt = "TTModSettingsItem";
            miVar.getClass();
            return a(obj, method, objArr, strDecrypt);
        }
        String name = method.getName();
        if (name == null) {
            return null;
        }
        switch (name.hashCode()) {
            case -1916181345:
                if (!name.equals("getIdentifier")) {
                    return null;
                }
                break;
            case -1249358039:
                if (!name.equals("getKey")) {
                    return null;
                }
                break;
            case -1249349532:
                if (!name.equals("getTag")) {
                    return null;
                }
                break;
            case -1029400035:
                if (name.equals("getContentType")) {
                    return "ttmod_settings_cell";
                }
                return null;
            case -309468417:
                if (name.equals("getHeadingItem")) {
                    return Boolean.FALSE;
                }
                return null;
            default:
                return null;
        }
        return "ttmod_settings";
    }

    public static final Unit a(Object[] objArr) {
        a.getClass();
        c(objArr);
        return Unit.INSTANCE;
    }

    public static boolean a(Object obj) {
        Object obj2;
        if (obj != b) {
            String strDecrypt = "ttmod_settings";
            v9 v9Var = ya.a;
            Object obj3 = null;
            if (obj != null) {
                try {
                    Result.Companion companion = Result.Companion;
                    Object objInvoke = v9Var.a(obj.getClass(), new Class[0]).invoke(obj, null);
                    obj2 = Result.constructor-impl(objInvoke instanceof String ? (String) objInvoke : null);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.Companion;
                    obj2 = Result.constructor-impl(ResultKt.createFailure(th));
                }
                obj3 = (String) (Result.isFailure-impl(obj2) ? null : obj2);
            }
            if (!Intrinsics.areEqual(strDecrypt, obj3)) {
                return false;
            }
        }
        return true;
    }

    public static Object a(final ClassLoader classLoader, Class cls, final String str, final Function1 function1) {
        Object objNewProxyInstance = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {
            @Override
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return mi.a(str, function1, classLoader, obj, method, objArr);
            }
        });
        return objNewProxyInstance;
    }

    public static final Object a(String str, Function1 function1, ClassLoader classLoader, Object obj, Method method, Object[] objArr) {
        Object obj2;
        Object obj3;
        Object obj4;
        if (Intrinsics.areEqual(method.getDeclaringClass(), Object.class)) {
            a.getClass();
            return a(obj, method, objArr, str);
        }
        if (!Intrinsics.areEqual(method.getName(), "invoke")) {
            return null;
        }
        if (objArr == null) {
            objArr = new Object[0];
        }
        function1.invoke(objArr);
        a.getClass();
        try {
            Result.Companion companion = Result.Companion;
            e9 e9Var = p9.a;
            obj2 = Result.constructor-impl(Class.forName("kotlin.Unit", false, classLoader));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th));
        }
        if (Result.isFailure-impl(obj2)) {
            obj2 = null;
        }
        Class cls = (Class) obj2;
        if (cls == null) {
            return null;
        }
        try {
            Result.Companion companion3 = Result.Companion;
            obj3 = Result.constructor-impl(cls.getField("INSTANCE").get(null));
        } catch (Throwable th2) {
            Result.Companion companion4 = Result.Companion;
            obj3 = Result.constructor-impl(ResultKt.createFailure(th2));
        }
        if (Result.exceptionOrNull-impl(obj3) == null) {
            return obj3;
        }
        try {
            Result.Companion companion5 = Result.Companion;
            obj4 = Result.constructor-impl(p9.a.a(cls).get(null));
        } catch (Throwable th3) {
            Result.Companion companion6 = Result.Companion;
            obj4 = Result.constructor-impl(ResultKt.createFailure(th3));
        }
        if (Result.isFailure-impl(obj4)) {
            return null;
        }
        return obj4;
    }

    public static Object a(Object obj, Method method, Object[] objArr, String str) {
        String name = method.getName();
        if (name != null) {
            int iHashCode = name.hashCode();
            if (iHashCode != -1776922004) {
                if (iHashCode != -1295482945) {
                    if (iHashCode == 147696667 && name.equals("hashCode")) {
                        return Integer.valueOf(System.identityHashCode(obj));
                    }
                } else if (name.equals("equals")) {
                    return Boolean.valueOf(obj == (objArr != null ? ArraysKt.firstOrNull(objArr) : null));
                }
            } else if (name.equals("toString")) {
                return str;
            }
        }
        return null;
    }

    public static void a(Throwable th) {
        if (d) {
            return;
        }
        d = true;
        g7.a(6, g7.a("Settings row error", new Object[0]), th);
    }

    public static Object a(ClassLoader classLoader) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        Object objNewInstance;
        Class<?> cls = Class.forName("X.05xk", false, classLoader);
        Class<?> cls2 = Class.forName("X.0yI7", false, classLoader);
        Class<?> cls3 = Class.forName("kotlin.jvm.functions.Function1", false, classLoader);
        Class<?> cls4 = Class.forName("kotlin.jvm.functions.Function2", false, classLoader);
        Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(cls, cls, String.class, String.class, String.class, cls3, cls4);
        declaredConstructor.setAccessible(true);
        Object objA = a(classLoader, cls3, "TTModSettingsClick", new Function1() {
            public final Object invoke(Object obj) {
                return mi.a((Object[]) obj);
            }
        });
        Object objA2 = a(classLoader, cls4, "TTModSettingsAction", new Function1() {
            public final Object invoke(Object obj) {
                return mi.b((Object[]) obj);
            }
        });
        try {
            Constructor<?> declaredConstructor2 = cls.getDeclaredConstructor(Integer.TYPE);
            declaredConstructor2.setAccessible(true);
            objNewInstance = declaredConstructor2.newInstance(2130976889);
        } catch (Throwable th) {
            a(th);
            objNewInstance = null;
        }
        Object objNewInstance2 = declaredConstructor.newInstance(objNewInstance, null, "", "ttmod_settings", k7.a("settings_title", "Mod Settings"), objA, objA2);
        return objNewInstance2;
    }

    public static final Unit b(Object[] objArr) {
        a.getClass();
        c(objArr);
        return Unit.INSTANCE;
    }
}
