package X;

import android.view.SurfaceView;
import android.view.Window;
import com.windukk.hook.HookBridge;

public abstract class d4 {
    public static void a() {
        try {
            Class cls = Integer.TYPE;
            HookBridge.hookMethod(Window.class.getMethod("setFlags", cls, cls), new a4());
            HookBridge.hookMethod(Window.class.getMethod("addFlags", cls), new b4());
            HookBridge.hookMethod(SurfaceView.class.getMethod("setSecure", Boolean.TYPE), new c4());
        } catch (Exception e) {
            int i = p4.a;
        }
    }
}
