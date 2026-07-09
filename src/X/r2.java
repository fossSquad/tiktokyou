package X;

import com.windukk.hook.HookMethod;

class r2 extends HookMethod {
    final  String a;

    public r2(String str) {
        this.a = str;
    }

    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object obj;
        if ("clear".equals(this.a)) {
            d3.a((Object) "called", "prefs.write.clear");
            return;
        }
        Object[] objArr = hookMethodParam.args;
        if (objArr.length >= 1) {
            Object obj2 = objArr[0];
            if (obj2 instanceof String) {
                String str = (String) obj2;
                if (d3.a(str)) {
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
                    d3.a(obj, "prefs.write.".concat(str));
                }
            }
        }
    }
}
