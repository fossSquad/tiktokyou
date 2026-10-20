package Z;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Type;

public abstract class vj {
    public static Object a;
    public static Method b;
    public static Method c;
    public static boolean d;

    public static synchronized boolean a() {
        boolean z = false;
        if (d) {
            return (a == null || b == null || c == null) ? false : true;
        }
        d = true;
        try {
            Class<?> cls = Class.forName("com.google.gson.Gson");
            for (Method method : cls.getDeclaredMethods()) {
                if (!Modifier.isStatic(method.getModifiers())) {
                    Class<?>[] parameterTypes = method.getParameterTypes();
                    if (parameterTypes.length == 1 && parameterTypes[0] == Object.class && method.getReturnType() == String.class) {
                        b = method;
                    } else if (parameterTypes.length == 2 && parameterTypes[0] == String.class && parameterTypes[1] == Type.class) {
                        c = method;
                    }
                }
            }
            a = cls.getConstructor(null).newInstance(null);
            Method method2 = b;
            if (method2 != null) {
                method2.setAccessible(true);
            }
            Method method3 = c;
            if (method3 != null) {
                method3.setAccessible(true);
            }
        } catch (Throwable th) {
            String strDecrypt = "GsonBridge init failed";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
        if (a != null && b != null && c != null) {
            z = true;
        }
        return z;
    }

    public static String a(Object obj) throws Throwable {
        if (a()) {
            try {
                return (String) b.invoke(a, obj);
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                Throwable cause2 = e;
                if (cause != null) {
                    cause2 = e.getCause();
                }
                if (cause2 instanceof Exception) {
                    throw cause2;
                }
                throw new RuntimeException(cause2);
            }
        }
        throw new IllegalStateException("Gson is not available");
    }

    public static Object a(String str, Type type) throws Throwable {
        if (a()) {
            try {
                return c.invoke(a, str, type);
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                Throwable cause2 = e;
                if (cause != null) {
                    cause2 = e.getCause();
                }
                if (cause2 instanceof Exception) {
                    throw cause2;
                }
                throw new RuntimeException(cause2);
            }
        }
        throw new IllegalStateException("Gson is not available");
    }

    public static boolean a(Class cls) {
        return cls == null || cls.isPrimitive() || cls == String.class || cls == Boolean.class || cls == Character.class || Number.class.isAssignableFrom(cls) || cls.isEnum();
    }
}
