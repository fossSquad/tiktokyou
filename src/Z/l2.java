package Z;

import android.view.View;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.CommentStickerHooks;

class l2 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        n2 n2Var = (n2) CommentStickerHooks.a.get();
        if (n2Var == null) {
            return;
        }
        Object[] objArr = hookMethodParam.args;
        try {
            CommentStickerHooks.a((View) hookMethodParam.thisObject, (objArr == null || objArr.length <= 0) ? null : objArr[0], n2Var);
        } catch (Throwable th) {
            String strDecrypt = "Exception during addButton";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }
}
