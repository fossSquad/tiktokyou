package X;

import com.windukk.hook.HookMethod;
import java.lang.reflect.Member;

class m8 extends HookMethod {
    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Member member;
        HookMethod hookMethod = q8.a;
        if (hookMethodParam != null && (member = hookMethodParam.method) != null) {
            member.getName();
        }
        if (d1.w.getAndSet(1) != 1) {
            int i = g5.a;
        }
    }
}
