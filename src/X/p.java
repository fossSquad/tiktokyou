package X;

import android.view.MotionEvent;
import android.widget.TextView;
import de.robv.android.xposed.XC_MethodHook;

class p extends XC_MethodHook {
    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Object obj = methodHookParam.thisObject;
        if (obj instanceof TextView) {
            TextView textView = (TextView) obj;
            Object[] objArr = methodHookParam.args;
            if (objArr.length != 0) {
                Object obj2 = objArr[0];
                if ((obj2 instanceof MotionEvent) && k0.a(textView, (MotionEvent) obj2)) {
                    methodHookParam.setResult(Boolean.TRUE);
                }
            }
        }
    }
}
