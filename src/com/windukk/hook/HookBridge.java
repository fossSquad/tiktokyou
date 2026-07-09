package com.windukk.hook;

import android.os.Build;
import android.util.Log;
import com.windukk.hook.HookMethod.Unhook;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import sun.misc.Unsafe;

public final class HookBridge {
    private static final String TAG = "TTMod-HookBridge";
    private static volatile Boolean hiddenApiRestrictionsDisabled;
    private static volatile boolean nativeLoaded;
    static final Object[] EMPTY_ARRAY = new Object[0];
    private static final Method CALLBACK_METHOD = resolveCallbackMethod();
    private static final HashMap<Member, HookInfo> HOOKS = new HashMap<>();

    public static final class CopyOnWriteSortedSet<E> {
        private volatile Object[] elements = HookBridge.EMPTY_ARRAY;

        private int indexOf(Object obj) {
            for (int i = 0; i < this.elements.length; i++) {
                if (obj.equals(this.elements[i])) {
                    return i;
                }
            }
            return -1;
        }

        public synchronized boolean add(E e) {
            if (indexOf(e) >= 0) {
                return false;
            }
            Object[] objArr = new Object[this.elements.length + 1];
            System.arraycopy(this.elements, 0, objArr, 0, this.elements.length);
            objArr[this.elements.length] = e;
            Arrays.sort(objArr);
            this.elements = objArr;
            return true;
        }

        public Object[] getSnapshot() {
            return this.elements;
        }

        public synchronized boolean remove(E e) {
            int iIndexOf = indexOf(e);
            if (iIndexOf < 0) {
                return false;
            }
            Object[] objArr = new Object[this.elements.length - 1];
            System.arraycopy(this.elements, 0, objArr, 0, iIndexOf);
            System.arraycopy(this.elements, iIndexOf + 1, objArr, iIndexOf, (this.elements.length - iIndexOf) - 1);
            this.elements = objArr;
            return true;
        }

        public int size() {
            return this.elements.length;
        }
    }

    public static final class HiddenApiAccess {
        private static final long ACCESSIBLE_OVERRIDE_OFFSET;
        private static final long ART_METHOD_BIAS;
        private static final long ART_METHOD_SIZE;
        private static final long CLASS_METHODS_OFFSET;
        private static final long EXECUTABLE_ART_METHOD_OFFSET;
        private static final Unsafe UNSAFE;

        public static class AccessibleObjectMirror {
            private boolean override;

            private AccessibleObjectMirror() {
            }
        }

        public static final class ClassMirror {
            private transient int accessFlags;
            private transient int classFlags;
            private transient ClassLoader classLoader;
            private transient int classSize;
            private transient int clinitThreadId;
            private transient Class<?> componentType;
            private transient short copiedMethodsOffset;
            private transient Object dexCache;
            private transient int dexClassDefIndex;
            private volatile transient int dexTypeIndex;
            private transient Object extData;
            private transient long iFields;
            private transient Object[] ifTable;
            private transient long methods;
            private transient String name;
            private transient int numReferenceInstanceFields;
            private transient int numReferenceStaticFields;
            private transient int objectSize;
            private transient int objectSizeAllocFastPath;
            private transient int primitiveType;
            private transient int referenceInstanceOffsets;
            private transient long sFields;
            private transient int status;
            private transient Class<?> superClass;
            private transient short virtualMethodsOffset;
            private transient Object vtable;

            private ClassMirror() {
            }
        }

        public static class ExecutableMirror extends AccessibleObjectMirror {
            private int accessFlags;
            private long artMethod;
            private ClassMirror declaringClass;
            private ClassMirror declaringClassOfOverriddenMethod;
            private Object[] parameters;

            private ExecutableMirror() {
                super();
            }
        }

        public static final class InvokeStub {
            private InvokeStub() {
            }

            private static Object invoke(Object... objArr) {
                throw new IllegalStateException("Hidden method trampoline was not replaced");
            }
        }

        public static final class NeverCall {
            private NeverCall() {
            }

            private static void first() {
            }

            private static void second() {
            }
        }

        static {
            try {
                Unsafe unsafe = (Unsafe) Unsafe.class.getDeclaredMethod("getUnsafe", null).invoke(null, null);
                UNSAFE = unsafe;
                ACCESSIBLE_OVERRIDE_OFFSET = unsafe.objectFieldOffset(AccessibleObjectMirror.class.getDeclaredField("override"));
                long jObjectFieldOffset = unsafe.objectFieldOffset(ClassMirror.class.getDeclaredField("methods"));
                CLASS_METHODS_OFFSET = jObjectFieldOffset;
                long jObjectFieldOffset2 = unsafe.objectFieldOffset(ExecutableMirror.class.getDeclaredField("artMethod"));
                EXECUTABLE_ART_METHOD_OFFSET = jObjectFieldOffset2;
                Method declaredMethod = NeverCall.class.getDeclaredMethod("first", null);
                Method declaredMethod2 = NeverCall.class.getDeclaredMethod("second", null);
                makeAccessible(declaredMethod);
                makeAccessible(declaredMethod2);
                long j = unsafe.getLong(declaredMethod, jObjectFieldOffset2);
                long j2 = unsafe.getLong(declaredMethod2, jObjectFieldOffset2);
                long j3 = unsafe.getLong(NeverCall.class, jObjectFieldOffset);
                long j4 = j2 - j;
                ART_METHOD_SIZE = j4;
                ART_METHOD_BIAS = (j - j3) - j4;
            } catch (Throwable th) {
                throw new ExceptionInInitializerError(th);
            }
        }

        private HiddenApiAccess() {
        }

        public static void addExemptions(String... strArr) throws NoSuchMethodException, ClassNotFoundException {
            Class<?> cls = Class.forName("dalvik.system.VMRuntime");
            invokeHiddenMethod(cls, invokeHiddenMethod(cls, null, "getRuntime", new Object[0]), "setHiddenApiExemptions", strArr);
        }

        private static Object invokeHiddenMethod(Class<?> cls, Object obj, String str, Object... objArr) throws NoSuchMethodException {
            Method declaredMethod = InvokeStub.class.getDeclaredMethod("invoke", Object[].class);
            makeAccessible(declaredMethod);
            Unsafe unsafe = UNSAFE;
            long j = unsafe.getLong(cls, CLASS_METHODS_OFFSET);
            if (j == 0) {
                throw new NoSuchMethodException(cls.getName() + "." + str);
            }
            int i = unsafe.getInt(j);
            for (int i2 = 0; i2 < i; i2++) {
                UNSAFE.putLong(declaredMethod, EXECUTABLE_ART_METHOD_OFFSET, ART_METHOD_BIAS + (((long) i2) * ART_METHOD_SIZE) + j);
                if (str.equals(declaredMethod.getName()) && parametersMatch(declaredMethod.getParameterTypes(), objArr)) {
                    return declaredMethod.invoke(obj, objArr);
                }
            }
            throw new NoSuchMethodException(cls.getName() + "." + str);
        }

        private static void makeAccessible(AccessibleObject accessibleObject) {
            try {
                accessibleObject.setAccessible(true);
            } catch (Throwable th) {
                UNSAFE.putBoolean(accessibleObject, ACCESSIBLE_OVERRIDE_OFFSET, true);
            }
        }

        private static boolean parametersMatch(Class<?>[] clsArr, Object[] objArr) {
            if (clsArr.length != objArr.length) {
                return false;
            }
            for (int i = 0; i < clsArr.length; i++) {
                Object obj = objArr[i];
                Class<?> cls = clsArr[i];
                if (obj == null) {
                    if (cls.isPrimitive()) {
                        return false;
                    }
                } else if (cls.isPrimitive()) {
                    if (!primitiveParameterMatches(cls, obj)) {
                        return false;
                    }
                } else if (!cls.isInstance(obj)) {
                    return false;
                }
            }
            return true;
        }

        private static boolean primitiveParameterMatches(Class<?> cls, Object obj) {
            if (cls == Boolean.TYPE) {
                return obj instanceof Boolean;
            }
            if (cls == Byte.TYPE) {
                return obj instanceof Byte;
            }
            if (cls == Character.TYPE) {
                return obj instanceof Character;
            }
            if (cls == Short.TYPE) {
                return obj instanceof Short;
            }
            if (cls == Integer.TYPE) {
                return obj instanceof Integer;
            }
            if (cls == Long.TYPE) {
                return obj instanceof Long;
            }
            if (cls == Float.TYPE) {
                return obj instanceof Float;
            }
            if (cls == Double.TYPE) {
                return obj instanceof Double;
            }
            return false;
        }
    }

    public static final class HookInfo {
        private Member backup;
        final CopyOnWriteSortedSet<HookMethod> callbacks = new CopyOnWriteSortedSet<>();
        private final boolean isStatic;
        private final Member method;
        private final Class<?> returnType;

        public HookInfo(Member member) {
            this.method = member;
            this.isStatic = Modifier.isStatic(member.getModifiers());
            if (!(member instanceof Method)) {
                this.returnType = null;
            } else {
                Class<?> returnType = ((Method) member).getReturnType();
                this.returnType = returnType.isPrimitive() ? null : returnType;
            }
        }

        public Object callback(Object[] objArr) {
            return CallbackDispatcher.dispatch(this, objArr);
        }

        public Member getBackup() {
            return this.backup;
        }

        public CopyOnWriteSortedSet<HookMethod> getCallbacks() {
            return this.callbacks;
        }

        public Member getMethod() {
            return this.method;
        }

        public Class<?> getReturnType() {
            return this.returnType;
        }

        public boolean isStaticHook() {
            return this.isStatic;
        }

        public void setBackup(Member member) {
            this.backup = member;
        }
    }

    static {
        loadNative();
    }

    private HookBridge() {
    }

    private static native boolean deoptimize0(Member member);

    public static boolean deoptimizeMethod(Member member) {
        requireHookableMethod(member);
        requireNativeLoaded();
        return deoptimize0(member);
    }

    public static boolean disableHiddenApiRestrictions() {
        Boolean bool = hiddenApiRestrictionsDisabled;
        if (bool != null) {
            return bool.booleanValue();
        }
        synchronized (HookBridge.class) {
            Boolean bool2 = hiddenApiRestrictionsDisabled;
            if (bool2 != null) {
                return bool2.booleanValue();
            }
            boolean zTryDisableHiddenApiRestrictions = tryDisableHiddenApiRestrictions();
            hiddenApiRestrictionsDisabled = Boolean.valueOf(zTryDisableHiddenApiRestrictions);
            return zTryDisableHiddenApiRestrictions;
        }
    }

    public static boolean disableProfileSaver() {
        return false;
    }

    private static native Member hook0(Object obj, Member member, Method method);

    public static Set<HookMethod.Unhook> hookAllConstructors(Class<?> cls, HookMethod hookMethod) {
        if (cls == null) {
            throw new NullPointerException("hookClass");
        }
        HashSet hashSet = new HashSet();
        for (Constructor<?> constructor : cls.getDeclaredConstructors()) {
            hashSet.add(hookMethod(constructor, hookMethod));
        }
        return hashSet;
    }

    public static Set<HookMethod.Unhook> hookAllMethods(Class<?> cls, String str, HookMethod hookMethod) {
        if (cls == null) {
            throw new NullPointerException("hookClass");
        }
        if (str == null) {
            throw new NullPointerException("methodName");
        }
        HashSet hashSet = new HashSet();
        for (Method method : cls.getDeclaredMethods()) {
            if (str.equals(method.getName())) {
                hashSet.add(hookMethod(method, hookMethod));
            }
        }
        return hashSet;
    }

    public static HookMethod.Unhook hookMethod(Member member, HookMethod hookMethod) {
        requireHookableMethod(member);
        if (hookMethod == null) {
            throw new NullPointerException("callback");
        }
        requireNativeLoaded();
        HashMap<Member, HookInfo> map = HOOKS;
        synchronized (map) {
            HookInfo hookInfo = map.get(member);
            if (hookInfo == null) {
                hookInfo = new HookInfo(member);
                Member memberHook0 = hook0(hookInfo, member, CALLBACK_METHOD);
                if (memberHook0 == null) {
                    throw new IllegalStateException("Failed to hook method");
                }
                hookInfo.setBackup(memberHook0);
                map.put(member, hookInfo);
            }
            hookInfo.callbacks.add(hookMethod);
        }
        return hookMethod.new Unhook(member);
    }

    public static Object invokeMember(Member member, Object obj, Object[] objArr) {
        if (objArr == null) {
            objArr = EMPTY_ARRAY;
        }
        if (member instanceof Method) {
            Method method = (Method) member;
            method.setAccessible(true);
            return method.invoke(obj, objArr);
        }
        Constructor constructor = (Constructor) member;
        constructor.setAccessible(true);
        return constructor.newInstance(objArr);
    }

    public static Object invokeOriginalMethod(Member member, Object obj, Object[] objArr) {
        HookInfo hookInfo;
        HashMap<Member, HookInfo> map = HOOKS;
        synchronized (map) {
            hookInfo = map.get(member);
        }
        if (hookInfo != null) {
            try {
                member = hookInfo.getBackup();
            } catch (InstantiationException e) {
                throw new IllegalArgumentException("Constructor invocation failed", e);
            }
        }
        return invokeMember(member, obj, objArr);
    }

    public static boolean isHooked(Member member) {
        boolean z;
        requireNativeLoaded();
        HashMap<Member, HookInfo> map = HOOKS;
        synchronized (map) {
            z = map.containsKey(member) || isHooked0(member);
        }
        return z;
    }

    private static native boolean isHooked0(Member member);

    private static boolean loadNative() {
        if (nativeLoaded) {
            return true;
        }
        synchronized (HookBridge.class) {
            if (nativeLoaded) {
                return true;
            }
            try {
                System.loadLibrary("ttmod");
                nativeLoaded = true;
            } catch (Throwable th) {
                Log.e(TAG, "Failed to load ttmod native library", th);
            }
            return nativeLoaded;
        }
    }

    public static void log(Throwable th) {
        Log.e(TAG, "Uncaught hook callback exception", th);
    }

    public static boolean makeClassInheritable(Class<?> cls) {
        if (cls == null) {
            throw new NullPointerException("clazz");
        }
        requireNativeLoaded();
        return makeClassInheritable0(cls);
    }

    private static native boolean makeClassInheritable0(Class<?> cls);

    private static void requireHookableMethod(Member member) {
        if (member == null) {
            throw new NullPointerException("method");
        }
        if (!(member instanceof Method) && !(member instanceof Constructor)) {
            throw new IllegalArgumentException("method must be a Method or Constructor");
        }
        if (Modifier.isAbstract(member.getModifiers())) {
            throw new IllegalArgumentException("method must not be abstract");
        }
    }

    private static void requireNativeLoaded() {
        if (!loadNative()) {
            throw new IllegalStateException("ttmod native library is not loaded");
        }
    }

    private static Method resolveCallbackMethod() {
        try {
            return HookInfo.class.getMethod("callback", Object[].class);
        } catch (Throwable th) {
            throw new RuntimeException("Failed to initialize callback bridge", th);
        }
    }

    private static boolean tryDisableHiddenApiRestrictions() {
        if (Build.VERSION.SDK_INT < 28) {
            return true;
        }
        try {
            HiddenApiAccess.addExemptions("");
            return true;
        } catch (Throwable th) {
            Log.w(TAG, "Failed to disable hidden API restrictions", th);
            return false;
        }
    }

    private static native boolean unhook0(Member member);

    @Deprecated
    public static void unhookMethod(Member member, HookMethod hookMethod) {
        requireNativeLoaded();
        HashMap<Member, HookInfo> map = HOOKS;
        synchronized (map) {
            HookInfo hookInfo = map.get(member);
            if (hookInfo == null) {
                return;
            }
            hookInfo.callbacks.remove(hookMethod);
            if (hookInfo.callbacks.size() == 0) {
                map.remove(member);
                unhook0(member);
            }
        }
    }
}
