package Z;
import com.windukk.hook.HookBridge;
import com.windukk.hook.HookMethod;
import java.util.ArrayList;
import java.util.List;

class n7 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object obj = hookMethodParam.args[0];
        if (obj instanceof List) {
            List list = (List) obj;
            try {
                hookMethodParam.setResult(HookBridge.invokeOriginalMethod(hookMethodParam.method, hookMethodParam.thisObject, new Object[]{new ArrayList(list)}));
            } catch (Throwable e) {
                Throwable cause = e.getCause() != null ? e.getCause() : e;
                if (!(cause instanceof IndexOutOfBoundsException)) {
                    throw new RuntimeException(e);
                }
                String str = "FavoriteListReorderGuard: reorder failed, keeping original order: " + cause;
                g7.a(4, String.valueOf(str), (Throwable) null);
                hookMethodParam.setResult(list);
            }
        }
    }
}
