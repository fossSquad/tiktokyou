package X;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.Video;
import de.robv.android.xposed.XC_MethodHook;
import java.lang.reflect.Field;
import java.util.ArrayList;

class d0 extends XC_MethodHook {
    final  Class a;
    final  Class b;
    final  Class c;

    public d0(Class cls, Class cls2, Class cls3) {
        this.a = cls;
        this.b = cls2;
        this.c = cls3;
    }

    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        Video video;
        g0 g0VarA;
        try {
            Object obj = methodHookParam.args[0];
            Object obj2 = this.a.getField("LJIIL").get(obj);
            if (obj2 == null) {
                return;
            }
            Object obj3 = this.b.getField("LJFF").get(obj);
            if (!(obj3 instanceof Aweme) || (video = ((Aweme) obj3).getVideo()) == null || (g0VarA = i0.a(video, null, "protocol")) == null) {
                return;
            }
            Field field = this.c.getField("LIZ");
            field.setAccessible(true);
            field.set(obj2, g0VarA.a);
            ArrayList arrayList = r1.a;
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList2 = r1.a;
        }
    }
}
