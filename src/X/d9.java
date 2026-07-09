package X;

import android.graphics.Point;
import android.util.Size;
import com.windukk.hook.HookMethod;
import kotlin.Pair;

class d9 extends HookMethod {

    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String str;
        try {
            Object[] objArr = hookMethodParam.args;
            if (objArr == null || objArr.length <= 3) {
                str = null;
            } else {
                Object obj = objArr[3];
                if (obj instanceof String) {
                    str = (String) obj;
                } else {
                    str = null;
                }
            }
            if (str == null || str.isEmpty()) {
                hookMethodParam.setResult(new Pair((Object) null, (Object) null));
            } else {
                n9.b(str);
                hookMethodParam.setResult(new Pair(new Point(1, 1), new Size(1, 1)));
            }
            int i = g5.a;
        } catch (Throwable th) {
            th.getMessage();
            int i2 = g5.a;
        }
    }
}
