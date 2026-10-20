package Z;

import com.bytedance.lobby.google.GoogleAuth;
import com.ss.android.ugc.aweme.account.login.googleonetap.GoogleOneTapService;
import com.windukk.hook.HookBridge;
import com.windukk.hook.ReplaceMethod;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

public abstract class y {
    public static void a() {
        try {
            Method method = GoogleAuth.class.getMethod("isAvailable", null);
            Boolean bool = Boolean.FALSE;
            HookBridge.hookMethod(method, ReplaceMethod.returnConstant(bool));
            HookBridge.hookMethod(h9.a.a(GoogleOneTapService.class, String.class, WeakReference.class), ReplaceMethod.returnConstant(bool));
        } catch (Exception e) {
        }
    }
}
