package Z;

import android.widget.ImageView;
import com.windukk.hook.HookMethod;
import java.util.Map;

class ne extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        int[] iArr = re.a;
        if (ac.a() == null || !ac.e().x) {
            return;
        }
        Object obj = hookMethodParam.thisObject;
        if (obj instanceof ImageView) {
            ImageView imageView = (ImageView) obj;
            if (re.a(imageView)) {
                Map map = re.c;
                if (map.containsKey(imageView)) {
                    return;
                }
                map.put(imageView, Boolean.TRUE);
                imageView.post(new pe(imageView));
            }
        }
    }
}
