package org.lsposed.hiddenapibypass;

import dalvik.system.PathClassLoader;
import java.lang.invoke.MethodHandle;
import java.lang.reflect.Executable;

final class CoreOjClassLoader extends PathClassLoader {
    static final  boolean $assertionsDisabled = false;

    private static String getCoreOjPath() {
        String bootClassPath = System.getProperty("java.boot.class.path", "");
        return bootClassPath.split(":", 2)[0];
    }

    CoreOjClassLoader() {
        super(getCoreOjPath(), null);
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        if (Object.class.getName().equals(name)) {
            return Object.class;
        }
        try {
            return findClass(name);
        } catch (ClassNotFoundException e) {
            if (Executable.class.getName().equals(name)) {
                return Helper.Executable.class;
            }
            if (MethodHandle.class.getName().equals(name)) {
                return Helper.MethodHandle.class;
            }
            if (Class.class.getName().equals(name)) {
                return Helper.Class.class;
            }
            return super.loadClass(name);
        }
    }
}
