package Z;

import com.windukk.hook.HookMethod;
import java.util.function.Supplier;

class id extends HookMethod {
    final  Supplier a;

    public id(Supplier supplier) {
        this.a = supplier;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        ta.a().getClass();
        ta.d();
        hookMethodParam.setResult(this.a.get());
    }
}
