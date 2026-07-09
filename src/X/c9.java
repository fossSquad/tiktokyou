package X;

import com.windukk.hook.HookMethod;

class c9 extends HookMethod {
    final  int a;
    final  int b;
    final  String c;

    public c9(int i, int i2, String str) {
        this.a = i;
        this.b = i2;
        this.c = str;
    }

    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            if (n9.a(hookMethodParam.args, this.a, this.b)) {
                hookMethodParam.setResult(null);
                int i = g5.a;
            }
        } catch (Throwable th) {
            th.getMessage();
            int i2 = g5.a;
        }
    }
}
