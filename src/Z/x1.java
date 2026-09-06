package Z;

import android.content.Context;
import android.text.TextUtils;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.BrowserHooks;
import java.util.concurrent.ConcurrentHashMap;

class x1 extends HookMethod {
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String str;
        String str2;
        Object[] objArr = hookMethodParam.args;
        if (objArr.length >= 2) {
            boolean zEquals = false;
            Object obj = objArr[0];
            if (obj instanceof Context) {
                Context context = (Context) obj;
                Object obj2 = objArr[1];
                ConcurrentHashMap concurrentHashMap = BrowserHooks.a;
                if (obj2 == null || !TextUtils.equals(obj2.getClass().getName(), "com.bytedance.hybrid.spark.third.router.SparkThirdContext")) {
                    return;
                }
                Object obj3 = hookMethodParam.args[1];
                try {
                    Object obj4 = dd.a((Class) obj3.getClass(), "url").get(obj3);
                    str = obj4 instanceof String ? (String) obj4 : null;
                } catch (Throwable th) {
                }
                Object obj5 = hookMethodParam.args[1];
                try {
                    Object obj6 = dd.a((Class) obj5.getClass(), "seclinkConfig").get(obj5);
                    if (obj6 != null) {
                        try {
                            Object obj7 = dd.a((Class) obj6.getClass(), "scene").get(obj6);
                            str2 = obj7 instanceof String ? (String) obj7 : null;
                        } catch (Throwable th2) {
                        }
                        zEquals = TextUtils.equals(str2, "bio_url");
                    }
                } catch (Throwable th3) {
                }
                if (zEquals && BrowserHooks.a(context, str, true)) {
                    hookMethodParam.setResult((Object) null);
                }
            }
        }
    }
}
