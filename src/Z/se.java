package Z;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.List;

public abstract class se {
    public static Field a(Class cls, String str) throws NoSuchFieldException {
        for (Class superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                declaredField.setAccessible(true);
                return declaredField;
            } catch (NoSuchFieldException e) {
            }
        }
        throw new NoSuchFieldException(cls.getName() + "#" + str);
    }

    public static Method b(Class cls, String str, Class cls2, int i, Class... clsArr) throws NoSuchMethodException {
        for (Class superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            Method methodA = a(superclass, str, cls2, i, clsArr);
            if (methodA != null) {
                return methodA;
            }
            Method methodC = c(superclass, str, cls2, i, clsArr);
            if (methodC != null) {
                return methodC;
            }
        }
        StringBuilder sbAppend = new StringBuilder().append(cls.getName()).append("#");
        StringBuilder sb = new StringBuilder();
        if (str != null) {
            sb.append(str);
        } else {
            sb.append("<any>");
        }
        sb.append(" return=");
        sb.append(cls2 != null ? cls2.getName() : "<any>");
        sb.append(" params=");
        sb.append(i);
        sb.append(" prefix=");
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            if (i2 > 0) {
                sb.append(',');
            }
            Class cls3 = clsArr[i2];
            sb.append(cls3 != null ? cls3.getName() : "<any>");
        }
        throw new NoSuchMethodException(sbAppend.append(sb.toString()).toString());
    }

    public static Method c(Class cls, String str, Class cls2, int i, Class... clsArr) {
        for (Class<?> cls3 : cls.getInterfaces()) {
            Method methodA = a(cls3, str, cls2, i, clsArr);
            if (methodA != null) {
                return methodA;
            }
            Method methodC = c(cls3, str, cls2, i, clsArr);
            if (methodC != null) {
                return methodC;
            }
        }
        return null;
    }

    public static Method a(Class cls, String str, Class... clsArr) throws NoSuchMethodException {
        for (Class superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                Method methodB = b(superclass, str, clsArr);
                if (methodB != null) {
                    return methodB;
                }
            }
        }
        throw new NoSuchMethodException(cls.getName() + "#" + str);
    }

    public static Method a(Class cls, String str, Class cls2, int i, Class... clsArr) {
        for (Method method : cls.getDeclaredMethods()) {
            Class<?>[] parameterTypes = method.getParameterTypes();
            if ((str == null || method.getName().equals(str)) && ((cls2 == null || method.getReturnType().equals(cls2)) && parameterTypes.length == i && clsArr.length <= parameterTypes.length)) {
                int i2 = 0;
                while (true) {
                    if (i2 < clsArr.length) {
                        Class cls3 = clsArr[i2];
                        if (cls3 != null && !cls3.isAssignableFrom(parameterTypes[i2])) {
                            break;
                        }
                        i2++;
                    } else {
                        method.setAccessible(true);
                        return method;
                    }
                }
            }
        }
        return null;
    }

    public static Object a(Class cls, Object obj, String str) {
        if (obj == null) {
            return null;
        }
        try {
            Object obj2 = a((Class) obj.getClass(), str).get(obj);
            if (cls.isInstance(obj2)) {
                return cls.cast(obj2);
            }
            return null;
        } catch (Throwable th) {
            return null;
        }
    }

    public static List a(Object obj, String str) {
        Object objB = b(obj, str);
        if (objB instanceof List) {
            return (List) objB;
        }
        return null;
    }

    public static Method b(Class cls, String str, Class... clsArr) {
        for (Class<?> cls2 : cls.getInterfaces()) {
            try {
                Method declaredMethod = cls2.getDeclaredMethod(str, clsArr);
                declaredMethod.setAccessible(true);
                return declaredMethod;
            } catch (NoSuchMethodException e) {
                Method methodB = b(cls2, str, clsArr);
                if (methodB != null) {
                    return methodB;
                }
            }
        }
        return null;
    }

    public static Object b(Object obj, String str) {
        if (obj == null) {
            return null;
        }
        try {
            return a(obj.getClass(), str, new Class[0]).invoke(obj, null);
        } catch (Throwable th) {
            return null;
        }
    }
}
