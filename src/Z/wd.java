package Z;

import android.os.Handler;
import com.windukk.hook.HookMethod;

class wd extends HookMethod {
    final  String a;

    public wd(String str) {
        this.a = str;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object obj = hookMethodParam.thisObject;
        String str = this.a;
        float f = yd.f;
        if (obj == null || yd.a(f) || yd.h != null) {
            return;
        }
        long j = yd.j;
        if ((j <= 0 || System.currentTimeMillis() - j >= 1200) && !Boolean.TRUE.equals(yd.l.get())) {
            yd.a(obj, f);
            Handler handler = yd.k;
            handler.postDelayed(new xd(obj, f, d3.a("W2DGcy/fPQikwgakeI9ZdoWdtrnyV6sd2ZkDToA8+BU=", "XSgFIzfXX9Lp5OCb", "aes", new StringBuilder().append(str))), 80L);
            handler.postDelayed(new xd(obj, f, d3.a("z3f7btJgcYnofnbh05IQH8s8bHlas+gMYxrqQIVVJEo=", "oFUm08Tnayyi12LN", "aes", new StringBuilder().append(str))), 250L);
            handler.postDelayed(new xd(obj, f, d3.a("9sTTd/AtcV2jO+JiKqshGnNYH0hSLwSeSTPpG5QqZNo=", "5bQ3FN9k8LrsT2yQ", "aes", new StringBuilder().append(str))), 600L);
        }
    }
}
