package Z;

import com.windukk.hook.HookMethod;
import java.util.function.Supplier;

class xe extends HookMethod {
    final  Supplier a;

    public xe(Supplier supplier) {
        this.a = supplier;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ac.a().getClass();
        ac.e();
        hookMethodParam.setResult(this.a.get());
    }
}
