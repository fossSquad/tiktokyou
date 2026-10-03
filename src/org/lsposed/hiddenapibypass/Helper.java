package org.lsposed.hiddenapibypass;

import java.lang.invoke.MethodType;
import java.util.HashSet;
import java.util.Set;

public class Helper {
    static final Set<String> signaturePrefixes = new HashSet();

    public static class AccessibleObject {
        private boolean override;
    }

    public static final class Class {
        private transient int accessFlags;
        private transient int classFlags;
        private transient ClassLoader classLoader;
        private transient int classSize;
        private transient int clinitThreadId;
        private transient java.lang.Class<?> componentType;
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
        private transient java.lang.Class<?> superClass;
        private transient short virtualMethodsOffset;
        private transient Object vtable;
    }

    public static final class Executable extends AccessibleObject {
        private int accessFlags;
        private long artMethod;
        private Class declaringClass;
        private Class declaringClassOfOverriddenMethod;
        private Object[] parameters;
    }

    public static class MethodHandle {
        private MethodHandle cachedSpreadInvoker;
        private MethodType nominalType;
        private final MethodType type = null;
        protected final int handleKind = 0;
        protected final long artFieldOrMethod = 0;
    }

    static boolean checkArgsForInvokeMethod(java.lang.Class<?>[] params, Object[] args) {
        if (params.length != args.length) {
            return false;
        }
        for (int i = 0; i < params.length; i++) {
            if (params[i].isPrimitive()) {
                if (params[i] == Integer.TYPE && !(args[i] instanceof Integer)) {
                    return false;
                }
                if (params[i] == Byte.TYPE && !(args[i] instanceof Byte)) {
                    return false;
                }
                if (params[i] == Character.TYPE && !(args[i] instanceof Character)) {
                    return false;
                }
                if (params[i] == Boolean.TYPE && !(args[i] instanceof Boolean)) {
                    return false;
                }
                if (params[i] == Double.TYPE && !(args[i] instanceof Double)) {
                    return false;
                }
                if (params[i] == Float.TYPE && !(args[i] instanceof Float)) {
                    return false;
                }
                if (params[i] == Long.TYPE && !(args[i] instanceof Long)) {
                    return false;
                }
                if (params[i] == Short.TYPE && !(args[i] instanceof Short)) {
                    return false;
                }
            } else if (args[i] != null && !params[i].isInstance(args[i])) {
                return false;
            }
        }
        return true;
    }

    public static class NeverCall {
        private static int s;
        private static int t;
        private int i;
        private int j;

        private static void a() {
        }

        private static void b() {
        }
    }

    public static class InvokeStub {
        private static Object invoke(Object... args) {
            throw new IllegalStateException("Failed to invoke the method");
        }

        private InvokeStub(Object... args) {
            throw new IllegalStateException("Failed to new a instance");
        }
    }
}
