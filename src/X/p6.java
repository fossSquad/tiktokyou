package X;

import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import com.windukk.hook.HookMethod;
import java.lang.reflect.Method;

class p6 extends HookMethod {
    final  Class a;
    final  Class b;
    final  String c;
    final  boolean d;
    final  Class e;
    final  Class f;

    public p6(Class cls, Class cls2, String str, boolean z, Class cls3, Class cls4) {
        this.a = cls;
        this.b = cls2;
        this.c = str;
        this.d = z;
        this.e = cls3;
        this.f = cls4;
    }

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Class cls;
        if (y3.a().d()) {
            try {
                Object obj = hookMethodParam.thisObject;
                int iA = x6.a();
                Object objNewInstance = this.a.getConstructor(String[].class).newInstance(new String[]{"**"});
                Method method = null;
                Object obj2 = e4.a(this.b, this.c).get(null);
                Object objNewInstance2 = (!this.d || (cls = this.e) == null) ? this.f.getConstructor(Object.class).newInstance(new PorterDuffColorFilter(iA, PorterDuff.Mode.SRC_IN)) : this.f.getConstructor(this.e).newInstance(cls.getConstructor(Integer.TYPE).newInstance(Integer.valueOf(iA)));
                for (Method method2 : obj.getClass().getMethods()) {
                    if (method2.getName().equals("addValueCallback") && method2.getParameterCount() == 3 && method2.getParameterTypes()[0].isAssignableFrom(this.a)) {
                        method = method2;
                        break;
                    }
                }
                if (method != null) {
                    method.invoke(obj, objNewInstance, obj2, objNewInstance2);
                }
            } catch (Exception e) {
            }
        }
    }
}
