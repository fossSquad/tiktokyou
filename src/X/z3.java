package X;

import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;

public abstract class z3 {
    public static void a() {
        try {
            XposedBridge.hookAllMethods(Class.forName("X.0OEt"), "LJII", new x3());
            XposedBridge.hookAllMethods(Class.forName("X.0OEu"), "setSeekBarShowType", new y3());
            ArrayList arrayList = q2.a;
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList2 = q2.a;
        }
    }
}
