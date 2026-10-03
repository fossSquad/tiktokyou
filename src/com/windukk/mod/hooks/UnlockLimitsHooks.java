package Z;

import Z.a8;
import Z.e8;
import Z.h6;
import Z.p8;

import android.app.Activity;
import android.os.BaseBundle;
import com.windukk.hook.HookBridge;
import com.windukk.hook.ReplaceMethod;
import java.lang.reflect.Method;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class UnlockLimitsHooks {
    public static final UnlockLimitsHooks a;

    static {
        a = new UnlockLimitsHooks();
    }

    public static void a() throws NoSuchMethodException, ClassNotFoundException {
        p8 p8Var = a8.a;
        Class<?> cls = Class.forName("com.ss.android.ugc.aweme.im.sharepanel.api.experiment.ForwardLimitSetting");
        p8 p8Var2 = a8.a;
        Class cls2 = Integer.TYPE;
        Method methodA = p8Var2.a(cls, cls2);
        if (!Intrinsics.areEqual(methodA.getReturnType(), cls2)) {
            throw new IllegalStateException(("Unexpected category share-recipient limit return type: " + methodA).toString());
        }
        HookBridge.hookMethod(methodA, ReplaceMethod.returnConstant(1000));
        methodA.getName();
    }

    public static void b() throws NoSuchMethodException, ClassNotFoundException {
        p8 p8Var = e8.a;
        Class<?> cls = Class.forName("com.ss.android.ugc.aweme.im.chatlist.impl.IMChatListImpl");
        Method methodA = e8.a.a(cls, Class.forName("X.0Bgf"), Activity.class, Class.forName("X.03XF"));
        if (!Intrinsics.areEqual(methodA.getReturnType(), Object.class)) {
            throw new IllegalStateException(("Unexpected pinned-chat guard return type: " + methodA).toString());
        }
        HookBridge.hookMethod(methodA, ReplaceMethod.returnConstant(Boolean.FALSE));
        h6.a(4, h6.a(new StringBuilder().append("Unlocked pinned chats via ").append(cls.getName()).append("#").append(methodA.getName()).toString(), new Object[0]), (Throwable) null);
    }

    public static void c() {
        try {
            HookBridge.hookMethod(BaseBundle.class.getMethod("getInt", String.class, Integer.TYPE), new UnlockLimitsHooks$after$1());
        } catch (NoSuchMethodException e) {
            // method missing on this build; skip hook
        }
    }

    public static final void d() {
        Object obj;
        Object obj2;
        Object obj3;
        UnlockLimitsHooks qgVar = a;
        try {
            Result.Companion companion = Result.Companion;
            qgVar.getClass();
            b();
            obj = RCompat.m6constructorimpl(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = RCompat.m6constructorimpl(ResultKt.createFailure(th));
        }
        Throwable th2 = RCompat.m9exceptionOrNullimpl(obj);
        if (th2 != null) {
            h6.a(6, h6.a("Pinned-chat limit hook failed", new Object[0]), th2);
        }
        UnlockLimitsHooks qgVar2 = a;
        try {
            Result.Companion companion3 = Result.Companion;
            qgVar2.getClass();
            c();
            obj2 = RCompat.m6constructorimpl(Unit.INSTANCE);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            obj2 = RCompat.m6constructorimpl(ResultKt.createFailure(th3));
        }
        Throwable th4 = RCompat.m9exceptionOrNullimpl(obj2);
        if (th4 != null) {
            h6.a(6, h6.a("Share-recipient bundle limit hook failed", new Object[0]), th4);
        }
        UnlockLimitsHooks qgVar3 = a;
        try {
            Result.Companion companion5 = Result.Companion;
            qgVar3.getClass();
            a();
            obj3 = RCompat.m6constructorimpl(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion6 = Result.Companion;
            obj3 = RCompat.m6constructorimpl(ResultKt.createFailure(th5));
        }
        Throwable th6 = RCompat.m9exceptionOrNullimpl(obj3);
        if (th6 != null) {
            h6.a(6, h6.a("Category share-recipient limit hook failed", new Object[0]), th6);
        }
    }
}
