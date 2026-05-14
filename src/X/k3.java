package X;

import android.view.SurfaceView;
import android.view.Window;
import com.windukk.hook.HookBridge;

public abstract class k3 {
    public static void a() {
        try {
            Class cls = Integer.TYPE;
            HookBridge.hookMethod(Window.class.getMethod("setFlags", cls, cls), new h3());
            HookBridge.hookMethod(Window.class.getMethod("addFlags", cls), new i3());
            HookBridge.hookMethod(SurfaceView.class.getMethod("setSecure", Boolean.TYPE), new j3());
        } catch (Exception e) {
            int i = v3.a;
        }
    }
}
