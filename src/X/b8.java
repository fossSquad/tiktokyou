package X;

import android.widget.ImageView;
import com.windukk.hook.HookMethod;
import java.util.Map;

class b8 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int[] iArr = f8.a;
        d7 d7VarA = d7.a();
        if (d7VarA == null || !d7VarA.q) {
            return;
        }
        Object obj = hookMethodParam.thisObject;
        if (obj instanceof ImageView) {
            ImageView imageView = (ImageView) obj;
            if (f8.a(imageView)) {
                Map map = f8.c;
                if (map.containsKey(imageView)) {
                    return;
                }
                map.put(imageView, Boolean.TRUE);
                imageView.post(new d8(imageView));
            }
        }
    }
}
