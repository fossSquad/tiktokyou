package com.windukk.mod.hooks;

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

public final class SettingsHooks {
    public static final SettingsHooks a;
    public static volatile Object b;
    public static volatile Object c;
    public static volatile boolean d;
    public static volatile boolean e;
    public static volatile boolean f;

    static {
        a = new SettingsHooks();
    }

    public static final boolean a(SettingsHooks ogVar, Object obj) {
        Object obj2;
        ogVar.getClass();
        String strDecrypt = "ttmod_settings";
        z7 z7Var = t9.b;
        Object obj3 = null;
        if (obj != null) {
            try {
                Result.Companion companion = Result.Companion;
                Object obj4 = z7Var.a(obj.getClass()).get(obj);
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
        p8 p8Var = q9.a;
        Class<?> cls = Class.forName("X.0alr");
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            throw new IllegalStateException("Required value was null.".toString());
        }
        Class<?> cls2 = Class.forName("X.0aCP", false, classLoader);
        Class<?> cls3 = Class.forName("X.0aCM", false, classLoader);
        p8 p8Var2 = u9.a;
        Class<?> cls4 = Class.forName("X.1OPr", false, classLoader);
        p8 p8Var3 = t9.a;
        Class<?> cls5 = Class.forName("com.ss.android.ugc.aweme.setting.ui.rvmpcompose.group.privacy.cell.PrivacyItemVM", false, classLoader);
        p8 p8Var4 = q9.a;
        String str = p8Var4.c[0];
        Set setHookAllMethods = HookBridge.hookAllMethods(cls, str, new SettingsHooks$after$1(cls2, cls3));
        if (setHookAllMethods.isEmpty()) {
            throw new IllegalStateException(("No methods matched " + p8Var4).toString());
        }
        p8 p8Var5 = u9.a;
        String str2 = p8Var5.c[0];
        Set setHookAllMethods2 = HookBridge.hookAllMethods(cls4, str2, new SettingsHooks$before$1());
        if (setHookAllMethods2.isEmpty()) {
            throw new IllegalStateException(("No methods matched " + p8Var5).toString());
        }
        p8 p8Var6 = t9.a;
        String str3 = p8Var6.c[0];
        Set setHookAllMethods3 = HookBridge.hookAllMethods(cls5, str3, new SettingsHooks$before$2(classLoader));
        if (setHookAllMethods3.isEmpty()) {
            throw new IllegalStateException(("No methods matched " + p8Var6).toString());
        }
        w6 w6Var = p9.a;
        Pair pair = TuplesKt.to(w6Var, p9.b);
        Pair pair2 = TuplesKt.to(w6Var, p9.c);
        w6 w6Var2 = s9.a;
        for (Pair pair3 : CollectionsKt.listOf(new Pair[]{pair, pair2, TuplesKt.to(w6Var2, s9.c), TuplesKt.to(w6Var2, s9.b)})) {
            w6 w6Var3 = (w6) pair3.component1();
            p8 p8Var7 = (p8) pair3.component2();
            try {
                Result.Companion companion = Result.Companion;
                Class<?> cls6 = Class.forName(w6Var3.b, false, classLoader);
                String[] strArr = (String[]) p8Var7.c.clone();
                Set set = ArraysKt.toSet(strArr);
                Method[] declaredMethods = cls6.getDeclaredMethods();
                ArrayList arrayList = new ArrayList();
                for (Method method : declaredMethods) {
                    if (set.contains(method.getName())) {
                        arrayList.add(method);
                    }
                }
                if (arrayList.isEmpty()) {
                    throw new IllegalStateException(("No methods matched " + p8Var7).toString());
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
                    h6.a(6, h6.a("Unable to deoptimize settings caller " + p8Var7, new Object[0]), th);
                }
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th2));
            }
        }
        p8 p8Var8 = q9.a;
        p8 p8Var9 = t9.a;
    }

    public static final void c() {
        Object obj;
        Object obj2;
        SettingsHooks ogVar = a;
        try {
            Result.Companion companion = Result.Companion;
            ogVar.getClass();
            a();
            obj = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = Result.constructor-impl(ResultKt.createFailure(th));
        }
        Throwable th2 = Result.exceptionOrNull-impl(obj);
        if (th2 != null) {
            h6.a(6, h6.a("Notification icon hook unavailable", new Object[0]), th2);
        }
        SettingsHooks ogVar2 = a;
        try {
            Result.Companion companion3 = Result.Companion;
            ogVar2.getClass();
            b();
            obj2 = Result.constructor-impl(Unit.INSTANCE);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            obj2 = Result.constructor-impl(ResultKt.createFailure(th3));
        }
        Throwable th4 = Result.exceptionOrNull-impl(obj2);
        if (th4 != null) {
            h6.a(6, h6.a("Settings row hook unavailable", new Object[0]), th4);
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
                    z7 z7Var = o9.a;
                    if (Class.forName("X.0aDi", false, objFirstOrNull.getClass().getClassLoader()).isInstance(objFirstOrNull)) {
                        Object obj2 = o9.a.a(objFirstOrNull.getClass()).get(objFirstOrNull);
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
                contextA = Main.a();
            }
        } else {
            contextA = Main.a();
        }
        Intent intent = new Intent(contextA, (Class<?>) le.class);
        if (!(contextA instanceof Activity)) {
            intent.addFlags(268435456);
        }
        contextA.startActivity(intent);
    }

    public static final void a(SettingsHooks ogVar, HookMethod.HookMethodParam hookMethodParam, Class cls) {
        ogVar.getClass();
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
        HookBridge.hookMethod(method, new SettingsHooks$before$3());
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
                        return SettingsHooks.a(obj2, method, objArr);
                    }
                });
                b = objNewProxyInstance;
            }
        }
        return objNewProxyInstance;
    }

    public static final Object a(Object obj, Method method, Object[] objArr) {
        if (Intrinsics.areEqual(method.getDeclaringClass(), Object.class)) {
            SettingsHooks ogVar = a;
            String strDecrypt = "TTModSettingsItem";
            ogVar.getClass();
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
            p8 p8Var = r9.a;
            Object obj3 = null;
            if (obj != null) {
                try {
                    Result.Companion companion = Result.Companion;
                    Object objInvoke = p8Var.a(obj.getClass(), new Class[0]).invoke(obj, null);
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
                return SettingsHooks.a(str, function1, classLoader, obj, method, objArr);
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
            z7 z7Var = k8.a;
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
            obj4 = Result.constructor-impl(k8.a.a(cls).get(null));
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
        h6.a(6, h6.a("Settings row error", new Object[0]), th);
    }

    public static Object a(ClassLoader classLoader) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        Object objNewInstance;
        Class<?> cls = Class.forName("X.05p9", false, classLoader);
        Class<?> cls2 = Class.forName("X.17MP", false, classLoader);
        Class<?> cls3 = Class.forName("kotlin.jvm.functions.Function1", false, classLoader);
        Class<?> cls4 = Class.forName("kotlin.jvm.functions.Function2", false, classLoader);
        Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(cls, cls, String.class, String.class, String.class, cls3, cls4);
        declaredConstructor.setAccessible(true);
        Object objA = a(classLoader, cls3, "TTModSettingsClick", new Function1() {
            public final Object invoke(Object obj) {
                return SettingsHooks.a((Object[]) obj);
            }
        });
        Object objA2 = a(classLoader, cls4, "TTModSettingsAction", new Function1() {
            public final Object invoke(Object obj) {
                return SettingsHooks.b((Object[]) obj);
            }
        });
        try {
            Constructor<?> declaredConstructor2 = cls.getDeclaredConstructor(Integer.TYPE);
            declaredConstructor2.setAccessible(true);
            objNewInstance = declaredConstructor2.newInstance(2130976867);
        } catch (Throwable th) {
            a(th);
            objNewInstance = null;
        }
        String strDecrypt = "ttmod_settings";
        m6 m6Var = l6.a;
        Object objNewInstance2 = declaredConstructor.newInstance(objNewInstance, null, "", strDecrypt, l6.a("settings_title", "Mod Settings"), objA, objA2);
        return objNewInstance2;
    }

    public static final Unit b(Object[] objArr) {
        a.getClass();
        c(objArr);
        return Unit.INSTANCE;
    }
}
