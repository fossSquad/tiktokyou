package X;

import android.app.Activity;
import android.graphics.Bitmap;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import java.lang.reflect.Field;
import java.util.ArrayList;

class l3 extends XC_MethodReplacement {
    final  Class a;

    public l3(Class cls) {
        this.a = cls;
    }

    public Object replaceHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws IllegalAccessException, NoSuchFieldException {
        Bitmap bitmap = (Bitmap) methodHookParam.args[0];
        Object obj = methodHookParam.thisObject;
        Field declaredField = this.a.getDeclaredField("LL");
        declaredField.setAccessible(true);
        Object obj2 = declaredField.get(obj);
        Field declaredField2 = this.a.getDeclaredField("LLILIL");
        declaredField2.setAccessible(true);
        Activity activity = (Activity) declaredField2.get(obj);
        if (bitmap == null || activity == null) {
            m3.a(obj2, false);
            return null;
        }
        m3.a(obj2, m3.a(activity, bitmap));
        ArrayList arrayList = q2.a;
        return null;
    }
}
