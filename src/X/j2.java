package X;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.Video;
import com.windukk.hook.HookMethod;

class j2 extends HookMethod {
    final  Class a;
    final  Class b;
    final  Class c;

    public j2(Class cls, Class cls2, Class cls3) {
        this.a = cls;
        this.b = cls2;
        this.c = cls3;
    }

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Video video;
        m2 m2VarA;
        try {
            Object obj = hookMethodParam.args[0];
            Object obj2 = e4.a(this.a, "LJIILJJIL").get(obj);
            if (obj2 == null) {
                return;
            }
            Object obj3 = e4.a(this.b, "LJFF").get(obj);
            if (!(obj3 instanceof Aweme) || (video = ((Aweme) obj3).getVideo()) == null || (m2VarA = o2.a(video, null, "protocol")) == null) {
                return;
            }
            e4.a(this.c, "LIZ").set(obj2, m2VarA.a);
            int i = v3.a;
        } catch (Exception e) {
            e.getMessage();
            int i2 = v3.a;
        }
    }
}
