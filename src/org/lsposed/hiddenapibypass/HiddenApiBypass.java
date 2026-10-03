package org.lsposed.hiddenapibypass;

import android.util.Log;
import dalvik.system.VMRuntime;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import sun.misc.Unsafe;

public final class HiddenApiBypass {
    static final  boolean $assertionsDisabled = false;
    private static final String TAG = "HiddenApiBypass";
    private static final long artFieldBias;
    private static final long artFieldSize;
    private static final long artMethodBias;
    private static final long artMethodSize;
    private static final long artOffset;
    private static final long classOffset;
    private static final long iFieldOffset;
    private static final long methodOffset;
    private static final long methodsOffset;
    private static final long sFieldOffset;
    private static final Unsafe unsafe;

    static {
        long iField;
        long sField;
        try {
            unsafe = (Unsafe) Unsafe.class.getDeclaredMethod("getUnsafe", new Class[0]).invoke(null, new Object[0]);
            ClassLoader bootClassloader = new CoreOjClassLoader();
            Class<?> executableClass = bootClassloader.loadClass(Executable.class.getName());
            Class<?> methodHandleClass = bootClassloader.loadClass(MethodHandle.class.getName());
            Class<?> classClass = bootClassloader.loadClass(Class.class.getName());
            methodOffset = unsafe.objectFieldOffset(executableClass.getDeclaredField("artMethod"));
            classOffset = unsafe.objectFieldOffset(executableClass.getDeclaredField("declaringClass"));
            artOffset = unsafe.objectFieldOffset(methodHandleClass.getDeclaredField("artFieldOrMethod"));
            try {
                iField = unsafe.objectFieldOffset(classClass.getDeclaredField("fields"));
                sField = iField;
            } catch (NoSuchFieldException e) {
                iField = unsafe.objectFieldOffset(classClass.getDeclaredField("iFields"));
                sField = unsafe.objectFieldOffset(classClass.getDeclaredField("sFields"));
            }
            iFieldOffset = iField;
            sFieldOffset = sField;
            methodsOffset = unsafe.objectFieldOffset(classClass.getDeclaredField("methods"));
            Method mA = Helper.NeverCall.class.getDeclaredMethod("a", new Class[0]);
            Method mB = Helper.NeverCall.class.getDeclaredMethod("b", new Class[0]);
            mA.setAccessible(true);
            mB.setAccessible(true);
            MethodHandle mhA = MethodHandles.lookup().unreflect(mA);
            MethodHandle mhB = MethodHandles.lookup().unreflect(mB);
            long aAddr = unsafe.getLong(mhA, artOffset);
            long bAddr = unsafe.getLong(mhB, artOffset);
            long aMethods = unsafe.getLong(Helper.NeverCall.class, methodsOffset);
            artMethodSize = bAddr - aAddr;
            artMethodBias = (aAddr - aMethods) - artMethodSize;
            Field fI = Helper.NeverCall.class.getDeclaredField("i");
            Field fJ = Helper.NeverCall.class.getDeclaredField("j");
            fI.setAccessible(true);
            fJ.setAccessible(true);
            MethodHandle mhI = MethodHandles.lookup().unreflectGetter(fI);
            MethodHandle mhJ = MethodHandles.lookup().unreflectGetter(fJ);
            long iAddr = unsafe.getLong(mhI, artOffset);
            long jAddr = unsafe.getLong(mhJ, artOffset);
            Unsafe unsafe2 = unsafe;
            long jAddr2 = iFieldOffset;
            long iFields = unsafe2.getLong(Helper.NeverCall.class, jAddr2);
            artFieldSize = jAddr - iAddr;
            artFieldBias = iAddr - iFields;
        } catch (ReflectiveOperationException e2) {
            Log.e(TAG, "Initialize error", e2);
            throw new ExceptionInInitializerError(e2);
        }
    }

    public static Object newInstance(Class<?> clazz, Object... initargs) throws IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {
        Constructor<?> ctor;
        Method stub = Helper.InvokeStub.class.getDeclaredMethod("invoke", Object[].class);
        Constructor<?> ctor2 = Helper.InvokeStub.class.getDeclaredConstructor(Object[].class);
        ctor2.setAccessible(true);
        long methods = unsafe.getLong(clazz, methodsOffset);
        if (methods == 0) {
            throw new NoSuchMethodException("Cannot find matching constructor");
        }
        int numMethods = unsafe.getInt(methods);
        int i = 0;
        while (i < numMethods) {
            long method = artMethodBias + (((long) i) * artMethodSize) + methods;
            unsafe.putLong(stub, methodOffset, method);
            if (!"<init>".equals(stub.getName())) {
                ctor = ctor2;
            } else {
                ctor = ctor2;
                unsafe.putLong(ctor, methodOffset, method);
                unsafe.putObject(ctor, classOffset, clazz);
                Class<?>[] params = ctor.getParameterTypes();
                if (Helper.checkArgsForInvokeMethod(params, initargs)) {
                    return ctor.newInstance(initargs);
                }
            }
            i++;
            ctor2 = ctor;
        }
        throw new NoSuchMethodException("Cannot find matching constructor");
    }

    public static Object invoke(Class<?> clazz, Object thiz, String methodName, Object... args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        if (thiz != null && !clazz.isInstance(thiz)) {
            throw new IllegalArgumentException("this object is not an instance of the given class");
        }
        Method stub = Helper.InvokeStub.class.getDeclaredMethod("invoke", Object[].class);
        stub.setAccessible(true);
        long methods = unsafe.getLong(clazz, methodsOffset);
        if (methods == 0) {
            throw new NoSuchMethodException("Cannot find matching method");
        }
        int numMethods = unsafe.getInt(methods);
        for (int i = 0; i < numMethods; i++) {
            long method = artMethodBias + (((long) i) * artMethodSize) + methods;
            unsafe.putLong(stub, methodOffset, method);
            if (methodName.equals(stub.getName())) {
                Class<?>[] params = stub.getParameterTypes();
                if (Helper.checkArgsForInvokeMethod(params, args)) {
                    return stub.invoke(thiz, args);
                }
            }
        }
        throw new NoSuchMethodException("Cannot find matching method");
    }

    public static List<Executable> getDeclaredMethods(Class<?> clazz) {
        if (clazz.isPrimitive() || clazz.isArray()) {
            return Collections.EMPTY_LIST;
        }
        try {
            Method mA = Helper.NeverCall.class.getDeclaredMethod("a", new Class[0]);
            mA.setAccessible(true);
            MethodHandle mh = MethodHandles.lookup().unreflect(mA);
            long methods = unsafe.getLong(clazz, methodsOffset);
            if (methods == 0) {
                return Collections.EMPTY_LIST;
            }
            int numMethods = unsafe.getInt(methods);
            List<Executable> list = new ArrayList<>(numMethods);
            for (int i = 0; i < numMethods; i++) {
                long method = artMethodBias + (((long) i) * artMethodSize) + methods;
                unsafe.putLong(mh, artOffset, method);
                Executable member = (Executable) MethodHandles.reflectAs(Executable.class, mh);
                list.add(member);
            }
            return list;
        } catch (IllegalAccessException | NoSuchMethodException e) {
            return Collections.EMPTY_LIST;
        }
    }

    public static Method getDeclaredMethod(Class<?> clazz, String methodName, Class<?>... parameterTypes) throws NoSuchMethodException {
        List<Executable> methods = getDeclaredMethods(clazz);
        for (Executable method : methods) {
            if (method.getName().equals(methodName) && (method instanceof Method)) {
                Class<?>[] expectedTypes = method.getParameterTypes();
                if (expectedTypes.length == parameterTypes.length) {
                    for (int i = 0; i < parameterTypes.length; i++) {
                        if (parameterTypes[i] == expectedTypes[i]) {
                        }
                    }
                    return (Method) method;
                }
                continue;
            }
        }
        throw new NoSuchMethodException("Cannot find matching method");
    }

    public static Constructor<?> getDeclaredConstructor(Class<?> clazz, Class<?>... parameterTypes) throws NoSuchMethodException {
        List<Executable> methods = getDeclaredMethods(clazz);
        for (Executable method : methods) {
            if (method instanceof Constructor) {
                Class<?>[] expectedTypes = method.getParameterTypes();
                if (expectedTypes.length == parameterTypes.length) {
                    for (int i = 0; i < parameterTypes.length; i++) {
                        if (parameterTypes[i] == expectedTypes[i]) {
                        }
                    }
                    return (Constructor) method;
                }
                continue;
            }
        }
        throw new NoSuchMethodException("Cannot find matching constructor");
    }

    public static List<Field> getInstanceFields(Class<?> clazz) {
        if (clazz.isPrimitive() || clazz.isArray()) {
            return Collections.EMPTY_LIST;
        }
        try {
            Field fI = Helper.NeverCall.class.getDeclaredField("i");
            fI.setAccessible(true);
            MethodHandle mh = MethodHandles.lookup().unreflectGetter(fI);
            long fields = unsafe.getLong(clazz, iFieldOffset);
            if (fields == 0) {
                return Collections.EMPTY_LIST;
            }
            int numFields = unsafe.getInt(fields);
            List<Field> list = new ArrayList<>(numFields);
            for (int i = 0; i < numFields; i++) {
                long field = artFieldBias + (((long) i) * artFieldSize) + fields;
                unsafe.putLong(mh, artOffset, field);
                Field member = (Field) MethodHandles.reflectAs(Field.class, mh);
                if (!Modifier.isStatic(member.getModifiers())) {
                    list.add(member);
                }
            }
            return list;
        } catch (IllegalAccessException | NoSuchFieldException e) {
            return Collections.EMPTY_LIST;
        }
    }

    public static List<Field> getStaticFields(Class<?> clazz) {
        if (clazz.isPrimitive() || clazz.isArray()) {
            return Collections.EMPTY_LIST;
        }
        try {
            Field fS = Helper.NeverCall.class.getDeclaredField("s");
            fS.setAccessible(true);
            MethodHandle mh = MethodHandles.lookup().unreflectGetter(fS);
            long fields = unsafe.getLong(clazz, sFieldOffset);
            if (fields == 0) {
                return Collections.EMPTY_LIST;
            }
            int numFields = unsafe.getInt(fields);
            List<Field> list = new ArrayList<>(numFields);
            for (int i = 0; i < numFields; i++) {
                long field = artFieldBias + (((long) i) * artFieldSize) + fields;
                unsafe.putLong(mh, artOffset, field);
                Field member = (Field) MethodHandles.reflectAs(Field.class, mh);
                if (Modifier.isStatic(member.getModifiers())) {
                    list.add(member);
                }
            }
            return list;
        } catch (IllegalAccessException | NoSuchFieldException e) {
            return Collections.EMPTY_LIST;
        }
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
