package X;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public abstract class e4 {
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
}
