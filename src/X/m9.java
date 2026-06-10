package X;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Method;

public abstract class m9 {
    public static void a() {
        try {
            x5 x5Var = h6.a;
            Method methodA = h6.a.a(Class.forName("X.19Zy"), Aweme.class);
            if (methodA.getReturnType() != Boolean.TYPE) {
                throw new NoSuchMethodException("Unexpected SeekBar should-show return type: " + methodA);
            }
            HookBridge.hookMethod(methodA, new k9());
            x5 x5Var2 = i6.a;
            Method methodA2 = i6.a.a(Class.forName("X.19TK"), Integer.TYPE);
            if (methodA2.getReturnType() != Void.TYPE) {
                throw new NoSuchMethodException("Unexpected SeekBar show-type return type: " + methodA2);
            }
            HookBridge.hookMethod(methodA2, new l9());
            methodA.getName();
            methodA2.getName();
            int i = p4.a;
        } catch (Throwable th) {
            th.toString();
            int i2 = p4.a;
        }
    }
}
