package Z;

import Z.ae;
import Z.h6;
import Z.m9;
import Z.n9;
import Z.p8;
import Z.zd;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookBridge;
import java.lang.reflect.Method;

public abstract class SeekBarHooks {
    public static void a() {
        try {
            p8 p8Var = m9.a;
            Method methodA = m9.a.a(Class.forName("X.06jj"), Aweme.class);
            if (methodA.getReturnType() != Boolean.TYPE) {
                throw new NoSuchMethodException("Unexpected SeekBar should-show return type: " + methodA);
            }
            HookBridge.hookMethod(methodA, new zd());
            p8 p8Var2 = n9.a;
            Method methodA2 = n9.a.a(Class.forName("X.06hm"), Integer.TYPE);
            if (methodA2.getReturnType() != Void.TYPE) {
                throw new NoSuchMethodException("Unexpected SeekBar show-type return type: " + methodA2);
            }
            HookBridge.hookMethod(methodA2, new ae());
            methodA.getName();
            methodA2.getName();
        } catch (Throwable th) {
            String strDecrypt = "Exception during init";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }
}
