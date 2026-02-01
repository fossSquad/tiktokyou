package fake.d;

import X.0XIQ;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import fake.a.g;
import java.util.Arrays;

public final class c {
    public static void a(Object obj) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException();
        a((RuntimeException) nullPointerException);
        throw nullPointerException;
    }

    public static void a(Object obj, String str) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException(str.concat(" must not be null"));
        a((RuntimeException) nullPointerException);
        throw nullPointerException;
    }

    public static boolean a(Object obj, Object obj2) {
        if (obj == null) {
            return obj2 == null;
        }
        return obj.equals(obj2);
    }

    public static Throwable a(RuntimeException runtimeException) {
        String name = c.class.getName();
        StackTraceElement[] stackTrace = runtimeException.getStackTrace();
        int length = stackTrace.length;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            if (name.equals(stackTrace[i2].getClassName())) {
                i = i2;
            }
        }
        runtimeException.setStackTrace((StackTraceElement[]) Arrays.copyOfRange(stackTrace, i + 1, length));
        return runtimeException;
    }

    public static void b(Object obj) {
        if (obj != null) {
            return;
        }
        NullPointerException nullPointerException = new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        a((RuntimeException) nullPointerException);
        throw nullPointerException;
    }

    public static void a(String str) {
        g gVar = new g("lateinit property " + str + " has not been initialized");
        a((RuntimeException) gVar);
        throw gVar;
    }

    public static void b(Object obj, String str) {
        if (obj != null) {
            return;
        }
        StackTraceElement stackTraceElement = ThreadMethodProxy.getStackTrace(0XIQ.y())[4];
        NullPointerException nullPointerException = new NullPointerException("Parameter specified as non-null is null: method " + stackTraceElement.getClassName() + "." + stackTraceElement.getMethodName() + ", parameter " + str);
        a((RuntimeException) nullPointerException);
        throw nullPointerException;
    }
}
