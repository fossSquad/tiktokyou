package Z;

import java.lang.reflect.Method;

import ni.shikatu.kotlin.Result;

/**
 * Bridge for Kotlin value-class inline methods of {@link Result}.
 *
 * The host shim class defines the real members under Kotlin's mangled names
 * (`constructor-impl`, `isFailure-impl`, ...), which cannot be referenced from
 * Java source. The decompiler had renamed the call sites to {@code m6constructorimpl}
 * style names; those are rewritten to this class, which dispatches to the
 * real methods reflectively.
 */
public final class RCompat {
    private static final Method CTOR = find("constructor-impl", Object.class, Object.class);
    private static final Method EXC = find("exceptionOrNull-impl", Throwable.class, Object.class);
    private static final Method FAIL = find("isFailure-impl", Boolean.TYPE, Object.class);
    private static final Method SUCC = find("isSuccess-impl", Boolean.TYPE, Object.class);
    private static final Method BOX = find("box-impl", Result.class, Object.class);

    private RCompat() {
    }

    private static Method find(String name, Class<?> returnType, Class<?> argType) {
        try {
            Method m = Result.class.getDeclaredMethod(name, argType);
            m.setAccessible(true);
            return m;
        } catch (Throwable t) {
            return null;
        }
    }

    public static Object m6constructorimpl(Object value) {
        try {
            return CTOR.invoke(null, value);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    public static Throwable m9exceptionOrNullimpl(Object value) {
        try {
            return (Throwable) EXC.invoke(null, value);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    public static boolean m12isFailureimpl(Object value) {
        try {
            return ((Boolean) FAIL.invoke(null, value)).booleanValue();
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    public static boolean m13isSuccessimpl(Object value) {
        try {
            return ((Boolean) SUCC.invoke(null, value)).booleanValue();
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    public static Result m5boximpl(Object value) {
        try {
            return (Result) BOX.invoke(null, value);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }
}
