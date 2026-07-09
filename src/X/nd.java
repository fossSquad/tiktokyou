package X;

import android.app.Activity;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Icon;
import com.windukk.hook.HookBridge;
import com.windukk.hook.HookMethod;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class nd {
    public static volatile Object a;
    public static volatile Object b;
    public static volatile boolean c;
    public static volatile boolean d;
    public static volatile boolean e;

    public static void a() throws ClassNotFoundException {
        t6 t6Var = l7.a;
        Class<?> cls = Class.forName("X.0puz");
        ClassLoader classLoader = cls.getClassLoader();
        Class<?> cls2 = Class.forName("X.0pq0", false, classLoader);
        Class<?> cls3 = Class.forName("X.08zZ", false, classLoader);
        t6 t6Var2 = o7.a;
        Class<?> cls4 = Class.forName("X.12WT", false, classLoader);
        t6 t6Var3 = n7.a;
        Class<?> cls5 = Class.forName("com.ss.android.ugc.aweme.setting.ui.rvmpcompose.group.privacy.cell.PrivacyItemVM", false, classLoader);
        HookBridge.hookAllMethods(cls, l7.a.c[0], new jd(cls2, cls3));
        HookBridge.hookAllMethods(cls4, o7.a.c[0], new kd());
        HookBridge.hookAllMethods(cls5, n7.a.c[0], new ld(classLoader));
        int i = g5.a;
    }

    public static void b() {
        try {
            HookBridge.hookMethod(Notification.Builder.class.getMethod("setSmallIcon", Icon.class), new id());
            a();
        } catch (Exception e2) {
            e2.getMessage();
            int i = g5.a;
        }
    }

    public static void c(Object[] objArr) {
        Context contextC;
        if (objArr.length > 0) {
            Object obj = objArr[0];
            if (obj instanceof Context) {
                contextC = (Context) obj;
            } else if (obj == null) {
                contextC = null;
            } else {
                try {
                    k6 k6Var = k7.a;
                    if (Class.forName("X.06xI", false, obj.getClass().getClassLoader()).isInstance(obj)) {
                        Object obj2 = k7.a.a(obj.getClass()).get(obj);
                        if (obj2 instanceof Context) {
                            contextC = (Context) obj2;
                        }
                    }
                } catch (Throwable th) {
                }
                contextC = null;
            }
        } else {
            contextC = null;
        }
        if (contextC == null) {
            contextC = g5.c();
        }
        if (contextC == null) {
            return;
        }
        Intent intent = new Intent(contextC, (Class<?>) vb.class);
        if (!(contextC instanceof Activity)) {
            intent.addFlags(268435456);
        }
        contextC.startActivity(intent);
    }

    public static  Object b(Object[] objArr) {
        c(objArr);
        return null;
    }

    public static void a(HookMethod.HookMethodParam hookMethodParam, Class cls) {
        Object result = hookMethodParam.getResult();
        if (result instanceof List) {
            List list = (List) result;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (a(it.next())) {
                    return;
                }
            }
            ArrayList arrayList = new ArrayList(list.size() + 1);
            arrayList.addAll(list);
            arrayList.add(a(cls));
            hookMethodParam.setResult(arrayList);
            if (d) {
                return;
            }
            d = true;
            int i = g5.a;
        }
    }

    public static Object a(Class cls) {
        Object obj = a;
        if (obj != null) {
            return obj;
        }
        synchronized (nd.class) {
            Object obj2 = a;
            if (obj2 != null) {
                return obj2;
            }
            a = Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {
                @Override
                public final Object invoke(Object obj3, Method method, Object[] objArr) {
                    return nd.a(obj3, method, objArr);
                }
            });
            return a;
        }
    }

    public static Object a(Object obj, Method method, Object[] objArr) {
        byte b2 = 2;
        Object obj2 = null;
        if (method.getDeclaringClass() == Object.class) {
            String name = method.getName();
            name.getClass();
            switch (name.hashCode()) {
                case -1776922004:
                    b2 = !name.equals("toString") ? (byte) -1 : (byte) 0;
                    break;
                case -1295482945:
                    b2 = !name.equals("equals") ? (byte) -1 : (byte) 1;
                    break;
                case 147696667:
                    if (!name.equals("hashCode")) {
                        b2 = -1;
                    }
                    break;
                default:
                    b2 = -1;
                    break;
            }
            switch (b2) {
                case 0:
                    return "TTModSettingsItem";
                case 1:
                    if (objArr != null && objArr.length > 0) {
                        obj2 = objArr[0];
                    }
                    return Boolean.valueOf(obj == obj2);
                case 2:
                    return Integer.valueOf(System.identityHashCode(obj));
                default:
                    return null;
            }
        }
        String name2 = method.getName();
        name2.getClass();
        switch (name2.hashCode()) {
            case -1916181345:
                b2 = !name2.equals("getIdentifier") ? (byte) -1 : (byte) 0;
                break;
            case -1249358039:
                b2 = !name2.equals("getKey") ? (byte) -1 : (byte) 1;
                break;
            case -1249349532:
                if (!name2.equals("getTag")) {
                    b2 = -1;
                }
                break;
            case -1029400035:
                b2 = !name2.equals("getContentType") ? (byte) -1 : (byte) 3;
                break;
            case -309468417:
                b2 = !name2.equals("getHeadingItem") ? (byte) -1 : (byte) 4;
                break;
            default:
                b2 = -1;
                break;
        }
        switch (b2) {
            case 0:
            case 1:
            case 2:
                return "ttmod_settings";
            case 3:
                return "ttmod_settings_cell";
            case 4:
                return Boolean.FALSE;
            default:
                return null;
        }
    }

    public static  Object a(Object[] objArr) {
        c(objArr);
        return null;
    }

    public static boolean a(Object obj) {
        if (obj != a) {
            t6 t6Var = m7.a;
            String str = null;
            if (obj != null) {
                try {
                    Object objInvoke = t6Var.a(obj.getClass(), new Class[0]).invoke(obj, null);
                    if (objInvoke instanceof String) {
                        str = (String) objInvoke;
                    }
                } catch (Throwable th) {
                }
            }
            if (!"ttmod_settings".equals(str)) {
                return false;
            }
        }
        return true;
    }

    public static Object a(final ClassLoader classLoader, Class cls, final String str, final md mdVar) {
        return Proxy.newProxyInstance(cls.getClassLoader(), new Class[]{cls}, new InvocationHandler() {
            @Override
            public final Object invoke(Object obj, Method method, Object[] objArr) {
                return nd.a(str, mdVar, classLoader, obj, method, objArr);
            }
        });
    }

    public static Object a(String str, md mdVar, ClassLoader classLoader, Object obj, Method method, Object[] objArr) {
        Object obj2 = null;
        if (method.getDeclaringClass() == Object.class) {
            String name = method.getName();
            name.getClass();
            switch (name) {
                case "toString":
                    return str;
                case "equals":
                    if (objArr != null && objArr.length > 0) {
                        obj2 = objArr[0];
                    }
                    return Boolean.valueOf(obj == obj2);
                case "hashCode":
                    return Integer.valueOf(System.identityHashCode(obj));
                default:
                    return null;
            }
        }
        if (!"invoke".equals(method.getName())) {
            return null;
        }
        if (objArr == null) {
            objArr = new Object[0];
        }
        mdVar.a(objArr);
        try {
            k6 k6Var = p6.a;
            return Class.forName("kotlin.Unit", false, classLoader).getField("INSTANCE").get(null);
        } catch (Throwable th) {
            try {
                return p6.a.a(Class.forName("kotlin.Unit", false, classLoader)).get(null);
            } catch (Throwable th2) {
                return null;
            }
        }
    }

    public static Object a(ClassLoader classLoader) throws IllegalAccessException, NoSuchMethodException, InstantiationException, ClassNotFoundException, InvocationTargetException {
        Object objNewInstance;
        Class<?> cls = Class.forName("X.08tJ", false, classLoader);
        Class<?> cls2 = Class.forName("X.090D", false, classLoader);
        Class<?> cls3 = Class.forName("kotlin.jvm.functions.Function1", false, classLoader);
        Class<?> cls4 = Class.forName("kotlin.jvm.functions.Function2", false, classLoader);
        Constructor<?> declaredConstructor = cls2.getDeclaredConstructor(cls, cls, String.class, String.class, String.class, cls3, cls4);
        declaredConstructor.setAccessible(true);
        Object objA = a(classLoader, cls3, "TTModSettingsClick", new md() {
            @Override
            public final Object a(Object[] objArr) {
                return nd.a(objArr);
            }
        });
        Object objA2 = a(classLoader, cls4, "TTModSettingsAction", new md() {
            @Override
            public final Object a(Object[] objArr) {
                return nd.b(objArr);
            }
        });
        try {
            Constructor<?> declaredConstructor2 = cls.getDeclaredConstructor(Integer.TYPE);
            declaredConstructor2.setAccessible(true);
            objNewInstance = declaredConstructor2.newInstance(2130976632);
        } catch (Throwable th) {
            if (!c) {
                c = true;
                th.getMessage();
                int i = g5.a;
            }
            objNewInstance = null;
        }
        return declaredConstructor.newInstance(objNewInstance, null, "", "ttmod_settings", f5.a().a("settings_title", "Mod Settings"), objA, objA2);
    }
}
