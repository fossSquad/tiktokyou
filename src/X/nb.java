package X;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Method;

public abstract class nb {
    public static void a() {
        try {
            t6 t6Var = i7.a;
            Method methodA = i7.a.a(Class.forName("X.1BSr"), Aweme.class);
            if (methodA.getReturnType() != Boolean.TYPE) {
                throw new NoSuchMethodException("Unexpected SeekBar should-show return type: " + methodA);
            }
            HookBridge.hookMethod(methodA, new lb());
            t6 t6Var2 = j7.a;
            Method methodA2 = j7.a.a(Class.forName("X.17kt"), Integer.TYPE);
            if (methodA2.getReturnType() != Void.TYPE) {
                throw new NoSuchMethodException("Unexpected SeekBar show-type return type: " + methodA2);
            }
            HookBridge.hookMethod(methodA2, new mb());
            methodA.getName();
            methodA2.getName();
            int i = g5.a;
        } catch (Throwable th) {
            th.toString();
            int i2 = g5.a;
        }
    }
}
