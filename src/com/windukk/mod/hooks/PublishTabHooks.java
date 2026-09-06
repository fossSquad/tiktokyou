package com.windukk.mod.hooks;

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

public final class PublishTabHooks {
    public static final PublishTabHooks a;
    public static final boolean b;

    static {
        a = new PublishTabHooks();
        b = Random.Default.nextInt(10000) == 0;
    }

    public static final void a(PublishTabHooks wcVar, TextView textView) {
        wcVar.getClass();
        ViewGroup.LayoutParams layoutParams = textView.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = layoutParams instanceof FrameLayout.LayoutParams ? (FrameLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.width = -1;
            layoutParams2.height = -2;
            layoutParams2.gravity = 49;
            layoutParams2.topMargin = Main.a(1.0f);
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
            PublishTabHooks wcVar = a;
            try {
                Result.Companion companion = Result.Companion;
                p8 p8Var = i9.a;
                Class<?> cls = Class.forName("X.068f");
                Method methodA = i9.c.a(cls, new Class[0]);
                Field fieldA = i9.d.a(cls);
                Method methodA2 = i9.a.a(cls, new Class[0]);
                HookBridge.hookMethod(methodA2, new PublishTabHooks$after$1(wcVar));
                Method methodA3 = i9.b.a(cls, new Class[0]);
                HookMethod.Unhook unhookHookMethod = HookBridge.hookMethod(methodA3, new PublishTabHooks$after$2(methodA, fieldA, wcVar));
                obj = Result.constructor-impl(unhookHookMethod);
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.constructor-impl(ResultKt.createFailure(th));
            }
            Throwable th2 = Result.exceptionOrNull-impl(obj);
            if (th2 != null) {
                h6.a(6, h6.a("PublishTabHooks initialization error", new Object[0]), th2);
            }
        }
    }
}
