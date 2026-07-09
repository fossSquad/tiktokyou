package X;

import android.view.SurfaceView;
import android.view.Window;
import com.windukk.hook.HookBridge;

public abstract class q4 {
    public static void a() {
        try {
            Class cls = Integer.TYPE;
            HookBridge.hookMethod(Window.class.getMethod("setFlags", cls, cls), new n4());
            HookBridge.hookMethod(Window.class.getMethod("addFlags", cls), new o4());
            HookBridge.hookMethod(SurfaceView.class.getMethod("setSecure", Boolean.TYPE), new p4());
        } catch (Exception e) {
            int i = g5.a;
        }
    }
}
