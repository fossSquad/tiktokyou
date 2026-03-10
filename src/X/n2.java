package X;

import android.app.Activity;
import android.graphics.Bitmap;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XC_MethodReplacement;
import java.lang.reflect.Field;
import java.util.ArrayList;

class n2 extends XC_MethodReplacement {
    final  Class a;

    public n2(Class cls) {
        this.a = cls;
    }

    public Object replaceHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) throws IllegalAccessException, NoSuchFieldException {
        Bitmap bitmap = (Bitmap) methodHookParam.args[0];
        Object obj = methodHookParam.thisObject;
        Field declaredField = this.a.getDeclaredField("LL");
        declaredField.setAccessible(true);
        Object obj2 = declaredField.get(obj);
        Field declaredField2 = this.a.getDeclaredField("LLILL");
        declaredField2.setAccessible(true);
        Activity activity = (Activity) declaredField2.get(obj);
        if (bitmap == null || activity == null) {
            o2.a(obj2, false);
            return null;
        }
        o2.a(obj2, o2.a(activity, bitmap));
        ArrayList arrayList = g1.a;
        return null;
    }
}
