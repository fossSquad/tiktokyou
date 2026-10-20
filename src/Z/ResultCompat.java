package Z;

import ni.shikatu.kotlin.Result;

/**
 * Java-callable stand-in for the Kotlin Result value class. The shaded Kotlin
 * runtime exposes JVM-mangled methods (constructor-impl, isFailure-impl, ...)
 * that javac cannot reference, so the decompiled call sites go through here.
 */
public final class ResultCompat {
    private ResultCompat() {
    }

    public static Object constructor(Object value) {
        return value;
    }

    public static Object box(Object value) {
        return value;
    }

    public static boolean isFailure(Object value) {
        return value instanceof Result.Failure;
    }

    public static boolean isSuccess(Object value) {
        return !(value instanceof Result.Failure);
    }

    public static Throwable exceptionOrNull(Object value) {
        if (value instanceof Result.Failure) {
            return ((Result.Failure) value).exception;
        }
        return null;
    }
}
