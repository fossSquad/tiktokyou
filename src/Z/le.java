package Z;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.windukk.hook.HookBridge;
import com.windukk.hook.HookMethod;
import com.windukk.mod.Main;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.random.Random;

public final class le {
    public static final le a;
    public static final boolean b;

    static {
        a = new le();
        b = Random.Default.nextInt(10000) == 0;
    }

    public static final void a(le leVar, TextView textView) {
        leVar.getClass();
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.width = -1;
            layoutParams2.height = -2;
            layoutParams2.gravity = 49;
            layoutParams2.topMargin = Main.dp(1.0f);
            layoutParams2.bottomMargin = 0;
            layoutParams2.setMarginStart(0);
            layoutParams2.setMarginEnd(0);
            textView.setLayoutParams(layoutParams2);
        }
        textView.setText("rfbrt❤️");
        textView.setGravity(17);
        textView.setTranslationY(0.0f);
        textView.setVisibility(0);
        textView.bringToFront();
    }

    public static final void a() {
        Object obj;
        if (b) {
            le leVar = a;
            try {
                Result.Companion companion = Result.Companion;
                v9 v9Var = pa.a;
                Class<?> cls = Class.forName("X.069e");
                Method methodA = pa.c.a(cls, new Class[0]);
                Field fieldA = pa.d.a(cls);
                Method methodA2 = pa.a.a(cls, new Class[0]);
                HookBridge.hookMethod(methodA2, new le$after$1(leVar));
                Method methodA3 = pa.b.a(cls, new Class[0]);
                HookMethod.Unhook unhookHookMethod = HookBridge.hookMethod(methodA3, new le$after$2(methodA, fieldA, leVar));
                obj = ResultCompat.constructor(unhookHookMethod);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = ResultCompat.constructor(ResultKt.createFailure(th));
            }
            Throwable th2 = ResultCompat.exceptionOrNull(obj);
            if (th2 != null) {
                g7.a(6, g7.a("PublishTabHooks initialization error", new Object[0]), th2);
            }
        }
    }
}
