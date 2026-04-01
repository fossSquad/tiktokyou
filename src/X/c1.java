package X;

import android.view.SurfaceView;
import android.view.Window;
import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;

public abstract class c1 {
    public static void a() {
        try {
            Class cls = Integer.TYPE;
            XposedBridge.hookMethod(Window.class.getMethod("setFlags", cls, cls), new z0());
            XposedBridge.hookMethod(Window.class.getMethod("addFlags", cls), new a1());
            XposedBridge.hookMethod(SurfaceView.class.getMethod("setSecure", Boolean.TYPE), new b1());
        } catch (Exception e) {
            ArrayList arrayList = r1.a;
        }
    }
}
