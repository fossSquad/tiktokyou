package X;

import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;

public abstract class x2 {
    public static void a() {
        try {
            XposedBridge.hookAllMethods(Class.forName("X.0OPz"), "LJII", new v2());
            XposedBridge.hookAllMethods(Class.forName("X.0OQ0"), "setSeekBarShowType", new w2());
            ArrayList arrayList = r1.a;
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList2 = r1.a;
        }
    }
}
