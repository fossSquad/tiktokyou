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

    public static synchronized void a(Context context, ClassLoader classLoader, List list) throws Exception {
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

        Field pathListField = null;
        for (Class<?> superclass = BaseDexClassLoader.class; superclass != null; superclass = superclass.getSuperclass()) {
            try {
                pathListField = superclass.getDeclaredField("pathList");
                break;
            } catch (NoSuchFieldException ignored) {
            }
        }
        if (pathListField == null) {
            throw new NoSuchFieldException(BaseDexClassLoader.class.getName() + ".pathList");
        }
        pathListField.setAccessible(true);
        Object obj = pathListField.get(classLoader);
        Class<?> cls = obj.getClass();

        Field dexElementsField = null;
        for (Class<?> superclass2 = cls; superclass2 != null; superclass2 = superclass2.getSuperclass()) {
            try {
                dexElementsField = superclass2.getDeclaredField("dexElements");
                break;
            } catch (NoSuchFieldException ignored) {
            }
        }
        if (dexElementsField == null) {
            throw new NoSuchFieldException(cls.getName() + ".dexElements");
        }
        dexElementsField.setAccessible(true);

        ArrayList<IOException> arrayList = new ArrayList<>();
        Method declaredMethod;
        Object[] objArr;
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
            for (IOException ioe : arrayList) {
                illegalStateException.addSuppressed(ioe);
            }
            throw illegalStateException;
        }

        Object[] objArr3 = (Object[]) dexElementsField.get(obj);
        if (objArr2.length != list.size()) {
            throw new IllegalStateException("Expected " + list.size() + " dynamic dex elements, got " + objArr2.length);
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length + objArr3.length);
        System.arraycopy(objArr3, 0, objArrCopyOf, objArr2.length, objArr3.length);
        dexElementsField.set(obj, objArrCopyOf);
        f3a = true;
    }
}

