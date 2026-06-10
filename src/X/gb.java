package X;

import com.windukk.hook.HookMethod;

class gb extends HookMethod {
    final  ClassLoader a;

    public gb(ClassLoader classLoader) {
        this.a = classLoader;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String str;
        Object obj = hookMethodParam.thisObject;
        p5 p5Var = m6.b;
        if (obj == null) {
            str = null;
        } else {
            try {
                Object obj2 = p5Var.a(obj.getClass()).get(obj);
                if (obj2 instanceof String) {
                    str = (String) obj2;
                } else {
                    str = null;
                }
            } catch (Throwable th) {
            }
        }
        if ("ttmod_settings".equals(str)) {
            try {
                ClassLoader classLoader = this.a;
                Object obj3 = ib.b;
                if (obj3 == null) {
                    synchronized (ib.class) {
                        Object obj4 = ib.b;
                        if (obj4 != null) {
                            obj3 = obj4;
                        } else {
                            ib.b = ib.a(classLoader);
                            obj3 = ib.b;
                        }
                    }
                }
                hookMethodParam.setResult(obj3);
                if (ib.e) {
                    return;
                }
                ib.e = true;
                int i = p4.a;
            } catch (Throwable th2) {
                if (ib.c) {
                    return;
                }
                ib.c = true;
                th2.getMessage();
                int i2 = p4.a;
            }
        }
    }
}
