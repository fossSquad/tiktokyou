package X;

import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;

public abstract class y3 {
    public static void a() {
        try {
            XposedBridge.hookAllMethods(Class.forName("X.0OEt"), "LJII", new w3());
            XposedBridge.hookAllMethods(Class.forName("X.0OEu"), "setSeekBarShowType", new x3());
            ArrayList arrayList = p2.a;
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList2 = p2.a;
        }
    }
}
