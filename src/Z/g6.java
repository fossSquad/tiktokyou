package Z;

import android.view.SurfaceView;
import android.view.Window;
import com.windukk.hook.HookBridge;

public abstract class g6 {
    public static void a() {
        try {
            String strDecrypt = "setFlags";
            Class cls = Integer.TYPE;
            HookBridge.hookMethod(Window.class.getMethod(strDecrypt, cls, cls), new d6());
            HookBridge.hookMethod(Window.class.getMethod("addFlags", cls), new e6());
            HookBridge.hookMethod(SurfaceView.class.getMethod("setSecure", Boolean.TYPE), new f6());
        } catch (Exception e) {
            String strDecrypt2 = "FlagSecure fail";
            Object obj = g7.a;
            g7.a(6, String.valueOf(strDecrypt2), e);
        }
    }
}
