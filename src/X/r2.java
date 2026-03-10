package X;

import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;

public abstract class r2 {
    public static void a() {
        try {
            XposedBridge.hookAllMethods(Class.forName("X.0OUd"), "LJII", new p2());
            XposedBridge.hookAllMethods(Class.forName("X.0OUe"), "setSeekBarShowType", new q2());
            ArrayList arrayList = g1.a;
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList2 = g1.a;
        }
    }
}
