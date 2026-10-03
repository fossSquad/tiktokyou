package Z;

import android.widget.ImageView;
import com.windukk.hook.HookMethod;
import java.util.Map;

class yc extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int[] iArr = cd.a;
        if (ta.a() == null || !ta.d().s) {
            return;
        }
        Object obj = hookMethodParam.thisObject;
        if (obj instanceof ImageView) {
            ImageView imageView = (ImageView) obj;
            if (cd.a(imageView)) {
                Map map = cd.c;
                if (map.containsKey(imageView)) {
                    return;
                }
                map.put(imageView, Boolean.TRUE);
                imageView.post(new ad(imageView));
            }
        }
    }
}
