package X;

import com.windukk.hook.HookMethod;
import java.lang.reflect.Member;

class n8 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Member member;
        HookMethod hookMethod = q8.a;
        if (hookMethodParam != null && (member = hookMethodParam.method) != null) {
            member.getName();
        }
        if (d1.w.getAndSet(0) != 0) {
            int i = g5.a;
        }
    }
}
