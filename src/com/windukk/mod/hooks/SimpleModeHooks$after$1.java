package Z;

import Z.h6;

import android.view.View;
import com.windukk.hook.HookMethod;
import java.util.WeakHashMap;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$after$1", "Lcom/windukk/hook/HookMethod;", "afterHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class SimpleModeHooks$after$1 extends HookMethod {
    final  int[] a;
    final  Class b;

    public SimpleModeHooks$after$1(int[] iArr, Class cls) {
        this.a = iArr;
        this.b = cls;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        boolean zIsInstance;
        try {
            Object obj = hookMethodParam.thisObject;
            View view = (View) obj;
            int[] iArr = this.a;
            Class cls = this.b;
            WeakHashMap weakHashMap = SimpleModeHooks.a;
            int id = view.getId();
            int length = iArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    zIsInstance = cls.isInstance(view);
                    break;
                } else {
                    if (iArr[i] == id) {
                        zIsInstance = true;
                        break;
                    }
                    i++;
                }
            }
            if (zIsInstance) {
                WeakHashMap weakHashMap2 = SimpleModeHooks.a;
                synchronized (weakHashMap2) {
                    weakHashMap2.put(view, Boolean.TRUE);
                    Unit unit = Unit.INSTANCE;
                }
                if (SimpleModeHooks.b) {
                    view.setVisibility(8);
                }
            }
        } catch (Throwable th) {
            h6.a(6, h6.a(new StringBuilder().append("Unhandled hook exception on ").append(hookMethodParam.method.getName()).toString(), new Object[0]), th);
        }
    }
}
