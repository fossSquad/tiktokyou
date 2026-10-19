package Z;

import android.widget.TextView;
import com.windukk.hook.HookMethod;
import ni.shikatu.kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$after$1", "Lcom/windukk/hook/HookMethod;", "afterHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class le$after$1 extends HookMethod {
    final  le a;

    public le$after$1(le leVar) {
        this.a = leVar;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            Object result = hookMethodParam.getResult();
            TextView textView = result instanceof TextView ? (TextView) result : null;
            if (textView != null) {
                le.a(this.a, textView);
            }
        } catch (Throwable th) {
            g7.a(6, g7.a(di.a("Rxv1TGSdnjLigFKNFVTg3ozTdNdAe2+I5K+aiZXYL9p4Gywp/atavW9E4kbxy/iU", "b97kfJ900CE0nrV5", "aes", new StringBuilder(), hookMethodParam.method.getName()), new Object[0]), th);
        }
    }
}
