package Z;

import android.view.MotionEvent;
import android.widget.TextView;
import com.windukk.hook.HookMethod;

class k1 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object obj = hookMethodParam.thisObject;
        if (obj instanceof TextView) {
            TextView textView = (TextView) obj;
            Object[] objArr = hookMethodParam.args;
            if (objArr.length != 0) {
                Object obj2 = objArr[0];
                if ((obj2 instanceof MotionEvent) && v1.a(textView, (MotionEvent) obj2)) {
                    hookMethodParam.setResult(Boolean.TRUE);
                }
            }
        }
    }
}
