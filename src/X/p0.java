package X;

import android.view.SurfaceView;
import android.view.Window;
import de.robv.android.xposed.XposedBridge;
import java.util.ArrayList;

public abstract class p0 {
    public static void a() {
        try {
            Class cls = Integer.TYPE;
            XposedBridge.hookMethod(Window.class.getMethod("setFlags", cls, cls), new m0());
            XposedBridge.hookMethod(Window.class.getMethod("addFlags", cls), new n0());
            XposedBridge.hookMethod(SurfaceView.class.getMethod("setSecure", Boolean.TYPE), new o0());
        } catch (Exception e) {
            ArrayList arrayList = g1.a;
        }
    }
}
