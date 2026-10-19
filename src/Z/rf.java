package Z;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Method;

public abstract class rf {
    public static void a() {
        try {
            v9 v9Var = ta.a;
            Method methodA = ta.a.a(Class.forName("X.06qw"), Aweme.class);
            if (methodA.getReturnType() != Boolean.TYPE) {
                throw new NoSuchMethodException("Unexpected SeekBar should-show return type: " + methodA);
            }
            HookBridge.hookMethod(methodA, new pf());
            v9 v9Var2 = ua.a;
            Method methodA2 = ua.a.a(Class.forName("X.06oF"), Integer.TYPE);
            if (methodA2.getReturnType() != Void.TYPE) {
                throw new NoSuchMethodException("Unexpected SeekBar show-type return type: " + methodA2);
            }
            HookBridge.hookMethod(methodA2, new qf());
            methodA.getName();
            methodA2.getName();
        } catch (Throwable th) {
            String strDecrypt = "Exception during init";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt), th);
        }
    }
}
