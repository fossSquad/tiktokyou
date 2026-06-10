package X;

import com.windukk.hook.HookMethod;
import java.lang.reflect.Member;

class f7 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Member member;
        HookMethod hookMethod = i7.a;
        if (hookMethodParam != null && (member = hookMethodParam.method) != null) {
            member.getName();
        }
        if (a1.t.getAndSet(0) != 0) {
            int i = p4.a;
        }
    }
}
