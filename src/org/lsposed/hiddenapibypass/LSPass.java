package org.lsposed.hiddenapibypass;

import android.util.Log;
import android.util.Property;
import dalvik.system.VMRuntime;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class LSPass {
    private static final String TAG = "LSPass";
    private static final Property<Class, Method[]> methods = Property.of(Class.class, Method[].class, "DeclaredMethods");
    private static final Property<Class, Constructor[]> constructors = Property.of(Class.class, Constructor[].class, "DeclaredConstructors");
    private static final Property<Class, Field[]> fields = Property.of(Class.class, Field[].class, "DeclaredFields");

    public static List<Method> getDeclaredMethods(Class<?> clazz) {
        return Arrays.asList(methods.get(clazz));
    }

    public static List<Constructor<?>> getDeclaredConstructors(Class<?> clazz) {
        return Arrays.asList(constructors.get(clazz));
    }

    public static List<Field> getDeclaredFields(Class<?> clazz) {
        return Arrays.asList(fields.get(clazz));
    }

    public static List<Field> getInstanceFields(Class<?> clazz) {
        ArrayList<Field> list = new ArrayList<>();
        for (Field member : getDeclaredFields(clazz)) {
            if (!Modifier.isStatic(member.getModifiers())) {
                list.add(member);
            }
        }
        return list;
    }

    public static List<Field> getStaticFields(Class<?> clazz) {
        ArrayList<Field> list = new ArrayList<>();
        for (Field member : getDeclaredFields(clazz)) {
            if (Modifier.isStatic(member.getModifiers())) {
                list.add(member);
            }
        }
        return list;
    }

    public static Method getDeclaredMethod(Class<?> clazz, String methodName, Class<?>... parameterTypes) throws NoSuchMethodException {
        List<Method> methods2 = getDeclaredMethods(clazz);
        for (Method method : methods2) {
            if (method.getName().equals(methodName)) {
                Class<?>[] expectedTypes = method.getParameterTypes();
                if (expectedTypes.length == parameterTypes.length) {
                    for (int i = 0; i < parameterTypes.length; i++) {
                        if (parameterTypes[i] == expectedTypes[i]) {
                        }
                    }
                    return method;
                }
                continue;
            }
        }
        throw new NoSuchMethodException("Cannot find matching method");
    }

    public static Constructor<?> getDeclaredConstructor(Class<?> clazz, Class<?>... parameterTypes) throws NoSuchMethodException {
        List<Constructor<?>> constructors2 = getDeclaredConstructors(clazz);
        for (Constructor<?> constructor : constructors2) {
            Class<?>[] expectedTypes = constructor.getParameterTypes();
            if (expectedTypes.length == parameterTypes.length) {
                for (int i = 0; i < parameterTypes.length; i++) {
                    if (parameterTypes[i] == expectedTypes[i]) {
                    }
                }
                return constructor;
            }
        }
        throw new NoSuchMethodException("Cannot find matching constructor");
    }

    public static Object newInstance(Class<?> clazz, Object... initargs) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        List<Constructor<?>> constructors2 = getDeclaredConstructors(clazz);
        for (Constructor<?> constructor : constructors2) {
            Class<?>[] params = constructor.getParameterTypes();
            if (Helper.checkArgsForInvokeMethod(params, initargs)) {
                constructor.setAccessible(true);
                return constructor.newInstance(initargs);
            }
        }
        throw new NoSuchMethodException("Cannot find matching constructor");
    }

    public static Object invoke(Class<?> clazz, Object thiz, String methodName, Object... args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        List<Method> methods2 = getDeclaredMethods(clazz);
        for (Method method : methods2) {
            if (method.getName().equals(methodName)) {
                Class<?>[] params = method.getParameterTypes();
                if (Helper.checkArgsForInvokeMethod(params, args)) {
                    method.setAccessible(true);
                    return method.invoke(thiz, args);
                }
            }
        }
        throw new NoSuchMethodException("Cannot find matching method");
    }

    public static boolean setHiddenApiExemptions(String... signaturePrefixes) {
        try {
            Object runtime = invoke(VMRuntime.class, null, "getRuntime", new Object[0]);
            invoke(VMRuntime.class, runtime, "setHiddenApiExemptions", signaturePrefixes);
            return true;
        } catch (ReflectiveOperationException e) {
            Log.w(TAG, "setHiddenApiExemptions", e);
            return false;
        }
    }

    public static boolean addHiddenApiExemptions(String... signaturePrefixes) {
        Helper.signaturePrefixes.addAll(Arrays.asList(signaturePrefixes));
        String[] strings = new String[Helper.signaturePrefixes.size()];
        Helper.signaturePrefixes.toArray(strings);
        return setHiddenApiExemptions(strings);
    }

    public static boolean clearHiddenApiExemptions() {
        Helper.signaturePrefixes.clear();
        return setHiddenApiExemptions(new String[0]);
    }
}
