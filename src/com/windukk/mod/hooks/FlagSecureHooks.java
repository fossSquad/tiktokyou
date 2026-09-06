package com.windukk.mod.hooks;

import android.view.SurfaceView;
import android.view.Window;
import com.windukk.hook.HookBridge;

public abstract class FlagSecureHooks {
    public static void a() {
        try {
            String strDecrypt = "setFlags";
            Class cls = Integer.TYPE;
            HookBridge.hookMethod(Window.class.getMethod(strDecrypt, cls, cls), new i5());
            HookBridge.hookMethod(Window.class.getMethod("addFlags", cls), new j5());
            HookBridge.hookMethod(SurfaceView.class.getMethod("setSecure", Boolean.TYPE), new k5());
        } catch (Exception e) {
            String strDecrypt2 = "FlagSecure fail";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt2), e);
        }
    }
}
