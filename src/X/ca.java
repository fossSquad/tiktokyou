package X;

import android.widget.ImageView;
import com.windukk.hook.HookMethod;
import java.util.Map;

class ca extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int[] iArr = ga.a;
        l8 l8VarA = l8.a();
        if (l8VarA == null || !l8VarA.r) {
            return;
        }
        Object obj = hookMethodParam.thisObject;
        if (obj instanceof ImageView) {
            ImageView imageView = (ImageView) obj;
            if (ga.a(imageView)) {
                Map map = ga.c;
                if (map.containsKey(imageView)) {
                    return;
                }
                map.put(imageView, Boolean.TRUE);
                imageView.post(new ea(imageView));
            }
        }
    }
}
