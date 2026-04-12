package X;

import android.view.SurfaceView;
import android.view.Window;
import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;

public abstract class b2 {
    public static void a() {
        try {
            Class cls = Integer.TYPE;
            XposedBridge.hookMethod(Window.class.getMethod("setFlags", cls, cls), new y1());
            XposedBridge.hookMethod(Window.class.getMethod("addFlags", cls), new z1());
            XposedBridge.hookMethod(SurfaceView.class.getMethod("setSecure", Boolean.TYPE), new a2());
        } catch (Exception e) {
            ArrayList arrayList = q2.a;
        }
    }
}
