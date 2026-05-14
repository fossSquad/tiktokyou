package X;

import com.windukk.hook.HookMethod;

class v1 extends HookMethod {
    final  String a;

    public v1(String str) {
        this.a = str;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object obj;
        if ("clear".equals(this.a)) {
            h2.a((Object) "called", "prefs.write.clear");
            return;
        }
        Object[] objArr = hookMethodParam.args;
        if (objArr.length >= 1) {
            Object obj2 = objArr[0];
            if (obj2 instanceof String) {
                String str = (String) obj2;
                if (h2.a(str)) {
                    if ("remove".equals(this.a)) {
                        obj = "<remove>";
                    } else {
                        Object[] objArr2 = hookMethodParam.args;
                        if (objArr2.length < 2) {
                            obj = "<remove>";
                        } else {
                            obj = objArr2[1];
                        }
                    }
                    h2.a(obj, "prefs.write.".concat(str));
                }
            }
        }
    }
}
