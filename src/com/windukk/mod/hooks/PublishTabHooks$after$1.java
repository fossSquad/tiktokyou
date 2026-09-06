package com.windukk.mod.hooks;

import android.widget.TextView;
import com.windukk.hook.HookMethod;
import ni.shikatu.kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$after$1", "Lcom/windukk/hook/HookMethod;", "afterHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class PublishTabHooks$after$1 extends HookMethod {
    final  PublishTabHooks a;

    public PublishTabHooks$after$1(PublishTabHooks wcVar) {
        this.a = wcVar;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        try {
            Object result = hookMethodParam.getResult();
            TextView textView = result instanceof TextView ? (TextView) result : null;
            if (textView != null) {
                PublishTabHooks.a(this.a, textView);
            }
        } catch (Throwable th) {
            h6.a(6, h6.a(new StringBuilder().append("Unhandled hook exception on ").append(hookMethodParam.method.getName()).toString(), new Object[0]), th);
        }
    }
}
