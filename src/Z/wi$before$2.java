package Z;

import android.view.MotionEvent;
import android.view.ViewGroup;
import com.windukk.hook.HookMethod;
import ni.shikatu.kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$before$1", "Lcom/windukk/hook/HookMethod;", "beforeHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class wi$before$2 extends HookMethod {
    final  pj a;

    public wi$before$2(pj pjVar) {
        this.a = pjVar;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            if (pj.g) {
                ViewGroup viewGroup = (ViewGroup) hookMethodParam.thisObject;
                if (viewGroup == viewGroup.getRootView()) {
                    MotionEvent motionEvent = (MotionEvent) hookMethodParam.args[0];
                    if (pj.a(this.a, motionEvent)) {
                        pj.a(this.a, viewGroup, motionEvent, hookMethodParam);
                    }
                }
            }
        } catch (Throwable th) {
            g7.a(6, g7.a("Unhandled hook exception on " + hookMethodParam.method.getName(), new Object[0]), th);
        }
    }
}
