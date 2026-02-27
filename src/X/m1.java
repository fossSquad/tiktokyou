package X;

import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;

public abstract class m1 {
    public static void a() {
        try {
            XposedBridge.hookAllMethods(Class.forName("X.0OUd"), "LJII", new k1());
            XposedBridge.hookAllMethods(Class.forName("X.0OUe"), "setSeekBarShowType", new l1());
            ArrayList arrayList = q0.a;
        } catch (Exception e) {
            e.getMessage();
            ArrayList arrayList2 = q0.a;
        }
    }
}
