package a;

import android.content.Context;
import dalvik.system.BaseDexClassLoader;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class i {

    public static boolean f3a;

    public static synchronized void a(Context context, ClassLoader classLoader, List list) {
        Method declaredMethod;
        Object[] objArr;
        if (f3a) {
            throw new IllegalStateException("Dynamic dex was already prepended");
        }
        if (list == null || list.isEmpty()) {
            throw new IllegalStateException("Dynamic dex set is empty");
        }
        if (!(classLoader instanceof BaseDexClassLoader)) {
            throw new IllegalStateException("Application classloader is not BaseDexClassLoader: " + classLoader);
        }
        File file = new File(context.getCodeCacheDir(), "tty_dynamic_oat");
        if (!file.isDirectory() && !file.mkdirs()) {
            throw new IllegalStateException("Cannot create dynamic oat directory");
        }
        String strDecrypt = "pathList";
        for (Class superclass = BaseDexClassLoader.class; superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(strDecrypt);
                declaredField.setAccessible(true);
                Object obj = declaredField.get(classLoader);
                Class<?> cls = obj.getClass();
                String strDecrypt2 = "dexElements";
                for (Class<?> superclass2 = cls; superclass2 != null; superclass2 = superclass2.getSuperclass()) {
                    try {
                        Field declaredField2 = superclass2.getDeclaredField(strDecrypt2);
                        declaredField2.setAccessible(true);
                        ArrayList arrayList = new ArrayList();
                        int i = 0;
                        try {
                            declaredMethod = obj.getClass().getDeclaredMethod("makeDexElements", List.class, File.class, List.class, ClassLoader.class, Boolean.TYPE);
                            objArr = new Object[]{new ArrayList(list), file, arrayList, classLoader, Boolean.FALSE};
                        } catch (NoSuchMethodException e) {
                            declaredMethod = obj.getClass().getDeclaredMethod("makeDexElements", List.class, File.class, List.class, ClassLoader.class);
                            objArr = new Object[]{new ArrayList(list), file, arrayList, classLoader};
                        }
                        declaredMethod.setAccessible(true);
                        Object[] objArr2 = (Object[]) declaredMethod.invoke(null, objArr);
                        if (!arrayList.isEmpty()) {
                            IllegalStateException illegalStateException = new IllegalStateException("Cannot create dynamic dex elements");
                            int size = arrayList.size();
                            while (i < size) {
                                Object obj2 = arrayList.get(i);
                                i++;
                                illegalStateException.addSuppressed((IOException) obj2);
                            }
                            throw illegalStateException;
                        }
                        Object[] objArr3 = (Object[]) declaredField2.get(obj);
                        if (objArr2.length != list.size()) {
                            throw new IllegalStateException("Expected " + list.size() + " dynamic dex elements, got " + objArr2.length);
                        }
                        Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length + objArr3.length);
                        System.arraycopy(objArr3, 0, objArrCopyOf, objArr2.length, objArr3.length);
                        declaredField2.set(obj, objArrCopyOf);
                        f3a = true;
                    } catch (NoSuchFieldException e2) {
                    }
                }
                throw new NoSuchFieldException(cls.getName() + "." + strDecrypt2);
            } catch (NoSuchFieldException e3) {
            }
        }
        throw new NoSuchFieldException(BaseDexClassLoader.class.getName() + "." + strDecrypt);
    }
}
