package de.robv.android.xposed;

import android.util.Log;
import de.robv.android.xposed.XC_MethodHook.Unhook;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class XposedBridge {
    private static final Object[] EMPTY_ARRAY;
    private static final String TAG = "AliuHook-XposedBridge";
    private static final Method callbackMethod;
    private static final Map<Member, HookInfo> hookRecords;

    private static native Object allocateInstance0(Class<?> cls);

    private static native boolean deoptimize0(Member member);

    public static native boolean disableHiddenApiRestrictions();

    public static native boolean disableProfileSaver();

    private static native Method hook0(Object obj, Member member, Method method);

    private static native boolean invokeConstructor0(Object obj, Constructor<?> constructor, Object[] objArr);

    private static native boolean isHooked0(Member member);

    private static native boolean makeClassInheritable0(Class<?> cls);

    private static native boolean unhook0(Member member);

    static {
        try {
            callbackMethod = HookInfo.class.getMethod("callback", Object[].class);
            System.loadLibrary("aliuhook");
            EMPTY_ARRAY = new Object[0];
            hookRecords = new HashMap();
        } catch (Throwable t) {
            throw new RuntimeException("Failed to initialize", t);
        }
    }

    private static void checkMethod(Member method) {
        if (method == null) {
            throw new NullPointerException("method must not be null");
        }
        if (!(method instanceof Method) && !(method instanceof Constructor)) {
            throw new IllegalArgumentException("method must be a Method or Constructor");
        }
        int modifiers = method.getModifiers();
        if (Modifier.isAbstract(modifiers)) {
            throw new IllegalArgumentException("method must not be abstract");
        }
    }

    public static boolean isHooked(Member method) {
        return hookRecords.containsKey(method);
    }

    public static boolean makeClassInheritable(Class<?> clazz) {
        if (clazz == null) {
            throw new NullPointerException("class must not be null");
        }
        return makeClassInheritable0(clazz);
    }

    public static boolean deoptimizeMethod(Member method) {
        checkMethod(method);
        return deoptimize0(method);
    }

    public static XC_MethodHook.Unhook hookMethod(Member method, XC_MethodHook callback) {
        HookInfo hookRecord;
        checkMethod(method);
        if (callback == null) {
            throw new NullPointerException("callback must not be null");
        }
        synchronized (hookRecords) {
            hookRecord = hookRecords.get(method);
            if (hookRecord == null) {
                hookRecord = new HookInfo(method);
                Method backup = hook0(hookRecord, method, callbackMethod);
                if (backup == null) {
                    throw new IllegalStateException("Failed to hook method");
                }
                hookRecord.backup = backup;
                hookRecords.put(method, hookRecord);
            }
        }
        hookRecord.callbacks.add(callback);
        callback.getClass();
        return callback.new Unhook(method);
    }

    public static Set<XC_MethodHook.Unhook> hookAllMethods(Class<?> hookClass, String methodName, XC_MethodHook callback) {
        Set<XC_MethodHook.Unhook> unhooks = new HashSet<>();
        for (Member method : hookClass.getDeclaredMethods()) {
            if (method.getName().equals(methodName)) {
                unhooks.add(hookMethod(method, callback));
            }
        }
        return unhooks;
    }

    public static Set<XC_MethodHook.Unhook> hookAllConstructors(Class<?> hookClass, XC_MethodHook callback) {
        Set<XC_MethodHook.Unhook> unhooks = new HashSet<>();
        for (Member constructor : hookClass.getDeclaredConstructors()) {
            unhooks.add(hookMethod(constructor, callback));
        }
        return unhooks;
    }

    @Deprecated
    public static void unhookMethod(Member method, XC_MethodHook callback) {
        synchronized (hookRecords) {
            HookInfo record = hookRecords.get(method);
            if (record != null) {
                record.callbacks.remove(callback);
                if (record.callbacks.size() == 0) {
                    hookRecords.remove(method);
                    unhook0(method);
                }
            }
        }
    }

    public static Object invokeOriginalMethod(Member method, Object thisObject, Object[] args) throws IllegalAccessException, IllegalArgumentException, NullPointerException, InvocationTargetException {
        if (args == null) {
            args = EMPTY_ARRAY;
        }
        HookInfo hookRecord = hookRecords.get(method);
        try {
            if (hookRecord != null) {
                return invokeMethod(hookRecord.backup, thisObject, args);
            }
            checkMethod(method);
            return invokeMethod(method, thisObject, args);
        } catch (InstantiationException e) {
            throw new IllegalArgumentException("The class this Constructor belongs to is abstract and cannot be instantiated");
        }
    }

    public static Object invokeMethod(Member member, Object thisObject, Object[] args) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        if (member instanceof Method) {
            Method method = (Method) member;
            method.setAccessible(true);
            return method.invoke(thisObject, args);
        }
        Constructor<?> ctor = (Constructor) member;
        ctor.setAccessible(true);
        return ctor.newInstance(args);
    }

    public static <T> T allocateInstance(Class<T> cls) {
        cls.getClass();
        return (T) allocateInstance0(cls);
    }

    public static <S, T extends S> boolean invokeConstructor(T instance, Constructor<S> constructor, Object... args) {
        instance.getClass();
        constructor.getClass();
        if (constructor.isVarArgs()) {
            throw new IllegalArgumentException("varargs parameters are not supported");
        }
        if (args.length == 0) {
            args = null;
        }
        return invokeConstructor0(instance, constructor, args);
    }

    public static final class CopyOnWriteSortedSet<E> {
        private volatile transient Object[] elements = XposedBridge.EMPTY_ARRAY;

        public int size() {
            return this.elements.length;
        }

        public synchronized boolean add(E e) {
            int index = indexOf(e);
            if (index >= 0) {
                return false;
            }
            Object[] newElements = new Object[this.elements.length + 1];
            System.arraycopy(this.elements, 0, newElements, 0, this.elements.length);
            newElements[this.elements.length] = e;
            Arrays.sort(newElements);
            this.elements = newElements;
            return true;
        }

        public synchronized boolean remove(E e) {
            int index = indexOf(e);
            if (index == -1) {
                return false;
            }
            Object[] newElements = new Object[this.elements.length - 1];
            System.arraycopy(this.elements, 0, newElements, 0, index);
            System.arraycopy(this.elements, index + 1, newElements, index, (this.elements.length - index) - 1);
            this.elements = newElements;
            return true;
        }

        private int indexOf(Object o) {
            for (int i = 0; i < this.elements.length; i++) {
                if (o.equals(this.elements[i])) {
                    return i;
                }
            }
            return -1;
        }

        public Object[] getSnapshot() {
            return this.elements;
        }
    }

    public static class HookInfo {
        Member backup;
        final CopyOnWriteSortedSet<XC_MethodHook> callbacks = new CopyOnWriteSortedSet<>();
        private final boolean isStatic;
        private final Member method;
        private final Class<?> returnType;

        public HookInfo(Member method) {
            this.method = method;
            this.isStatic = Modifier.isStatic(method.getModifiers());
            if (method instanceof Method) {
                Class<?> rt = ((Method) method).getReturnType();
                if (!rt.isPrimitive()) {
                    this.returnType = rt;
                    return;
                }
            }
            this.returnType = null;
        }

        public Object callback(Object[] args) throws Throwable {
            int beforeIdx;
            XC_MethodHook.MethodHookParam param = new XC_MethodHook.MethodHookParam();
            param.method = this.method;
            if (this.isStatic) {
                param.thisObject = null;
                param.args = args;
            } else {
                param.thisObject = args[0];
                param.args = new Object[args.length - 1];
                System.arraycopy(args, 1, param.args, 0, args.length - 1);
            }
            Object[] hooks = this.callbacks.getSnapshot();
            int hookCount = hooks.length;
            if (hookCount == 0) {
                try {
                    return XposedBridge.invokeMethod(this.backup, param.thisObject, param.args);
                } catch (InvocationTargetException e) {
                    throw e.getCause();
                }
            }
            int beforeIdx2 = 0;
            while (true) {
                try {
                    ((XC_MethodHook) hooks[beforeIdx2]).beforeHookedMethod(param);
                    if (param.returnEarly) {
                        beforeIdx = beforeIdx2 + 1;
                        break;
                    }
                    beforeIdx2++;
                    if (beforeIdx2 >= hookCount) {
                        beforeIdx = beforeIdx2;
                        break;
                    }
                } catch (Throwable t) {
                    XposedBridge.log(t);
                    param.setResult(null);
                    param.returnEarly = false;
                }
            }
            if (!param.returnEarly) {
                try {
                    param.setResult(XposedBridge.invokeMethod(this.backup, param.thisObject, param.args));
                } catch (InvocationTargetException e2) {
                    param.setThrowable(e2.getCause());
                }
            }
            int afterIdx = beforeIdx - 1;
            do {
                Object lastResult = param.getResult();
                Throwable lastThrowable = param.getThrowable();
                try {
                    ((XC_MethodHook) hooks[afterIdx]).afterHookedMethod(param);
                } catch (Throwable t2) {
                    XposedBridge.log(t2);
                    if (lastThrowable == null) {
                        param.setResult(lastResult);
                    } else {
                        param.setThrowable(lastThrowable);
                    }
                }
                afterIdx--;
            } while (afterIdx >= 0);
            Object result = param.getResultOrThrowable();
            if (this.returnType != null) {
                return this.returnType.cast(result);
            }
            return result;
        }
    }

    public static void log(Throwable t) {
        Log.e(TAG, "Uncaught Exception", t);
    }
}
