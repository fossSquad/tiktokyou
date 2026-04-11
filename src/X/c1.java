package X;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.Video;
import de.robv.android.xposed.XC_MethodHook;
import java.lang.reflect.Field;
import java.util.ArrayList;

class c1 extends XC_MethodHook {
    final  Class a;
    final  Class b;
    final  Class c;

    public c1(Class cls, Class cls2, Class cls3) {
        this.a = cls;
        this.b = cls2;
        this.c = cls3;
    }

    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Video video;
        f1 f1VarA;
        try {
            Object obj = methodHookParam.args[0];
            Object obj2 = this.a.getField("LJIILJJIL").get(obj);
            if (obj2 == null) {
                return;
            }
            Object obj3 = this.b.getField("LJFF").get(obj);
            if (!(obj3 instanceof Aweme) || (video = ((Aweme) obj3).getVideo()) == null || (f1VarA = h1.a(video, null, "protocol")) == null) {
                return;
            }
            Field field = this.c.getField("LIZ");
            field.setAccessible(true);
            field.set(obj2, f1VarA.a);
            ArrayList arrayList = p2.a;
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList2 = p2.a;
        }
    }
}
