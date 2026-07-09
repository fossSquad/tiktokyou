package X;

import com.windukk.hook.HookMethod;

class ld extends HookMethod {
    final  ClassLoader a;

    public ld(ClassLoader classLoader) {
        this.a = classLoader;
    }

    @Override
    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String str;
        Object obj = hookMethodParam.thisObject;
        k6 k6Var = n7.b;
        if (obj == null) {
            str = null;
        } else {
            try {
                Object obj2 = k6Var.a(obj.getClass()).get(obj);
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
                Object obj3 = nd.b;
                if (obj3 == null) {
                    synchronized (nd.class) {
                        Object obj4 = nd.b;
                        if (obj4 != null) {
                            obj3 = obj4;
                        } else {
                            nd.b = nd.a(classLoader);
                            obj3 = nd.b;
                        }
                    }
                }
                hookMethodParam.setResult(obj3);
                if (nd.e) {
                    return;
                }
                nd.e = true;
                int i = g5.a;
            } catch (Throwable th2) {
                if (nd.c) {
                    return;
                }
                nd.c = true;
                th2.getMessage();
                int i2 = g5.a;
            }
        }
    }
}
