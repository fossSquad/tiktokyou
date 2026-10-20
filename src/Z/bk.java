package Z;

import android.app.Activity;
import android.os.BaseBundle;
import com.windukk.hook.HookBridge;
import com.windukk.hook.ReplaceMethod;
import java.lang.reflect.Method;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class bk {
    public static final bk a;

    static {
        a = new bk();
    }

    public static void a() throws NoSuchMethodException, ClassNotFoundException {
        v9 v9Var = f9.a;
        Class<?> cls = Class.forName("com.ss.android.ugc.aweme.im.sharepanel.api.experiment.ForwardLimitSetting");
        v9 v9Var2 = f9.a;
        Class cls2 = Integer.TYPE;
        Method methodA = v9Var2.a(cls, cls2);
        if (!Intrinsics.areEqual(methodA.getReturnType(), cls2)) {
            throw new IllegalStateException(("Unexpected category share-recipient limit return type: " + methodA).toString());
        }
        HookBridge.hookMethod(methodA, ReplaceMethod.returnConstant(1000));
        methodA.getName();
    }

    public static void b() throws NoSuchMethodException, ClassNotFoundException {
        v9 v9Var = j9.a;
        Class<?> cls = Class.forName("com.ss.android.ugc.aweme.im.chatlist.impl.IMChatListImpl");
        Method methodA = j9.a.a(cls, Class.forName("X.0BeX"), Activity.class, Class.forName("X.03Vn"));
        if (!Intrinsics.areEqual(methodA.getReturnType(), Object.class)) {
            throw new IllegalStateException(("Unexpected pinned-chat guard return type: " + methodA).toString());
        }
        HookBridge.hookMethod(methodA, ReplaceMethod.returnConstant(Boolean.FALSE));
        g7.a(4, g7.a((new StringBuilder()).append("Unlocked pinned chats via ").append(cls.getName()).append("#").append(methodA.getName()).toString(), new Object[0]), (Throwable) null);
    }

    public static void c() throws NoSuchMethodException {
        HookBridge.hookMethod(BaseBundle.class.getMethod("getInt", String.class, Integer.TYPE), new bk$after$1());
    }

    public static final void d() {
        Object obj;
        Object obj2;
        Object obj3;
        bk bkVar = a;
        try {
            Result.Companion companion = Result.Companion;
            bkVar.getClass();
            b();
            obj = ResultCompat.constructor(Unit.INSTANCE);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            obj = ResultCompat.constructor(ResultKt.createFailure(th));
        }
        Throwable th2 = ResultCompat.exceptionOrNull(obj);
        if (th2 != null) {
            g7.a(6, g7.a("Pinned-chat limit hook failed", new Object[0]), th2);
        }
        bk bkVar2 = a;
        try {
            Result.Companion companion3 = Result.Companion;
            bkVar2.getClass();
            c();
            obj2 = ResultCompat.constructor(Unit.INSTANCE);
        } catch (Throwable th3) {
            Result.Companion companion4 = Result.Companion;
            obj2 = ResultCompat.constructor(ResultKt.createFailure(th3));
        }
        Throwable th4 = ResultCompat.exceptionOrNull(obj2);
        if (th4 != null) {
            g7.a(6, g7.a("Share-recipient bundle limit hook failed", new Object[0]), th4);
        }
        bk bkVar3 = a;
        try {
            Result.Companion companion5 = Result.Companion;
            bkVar3.getClass();
            a();
            obj3 = ResultCompat.constructor(Unit.INSTANCE);
        } catch (Throwable th5) {
            Result.Companion companion6 = Result.Companion;
            obj3 = ResultCompat.constructor(ResultKt.createFailure(th5));
        }
        Throwable th6 = ResultCompat.exceptionOrNull(obj3);
        if (th6 != null) {
            g7.a(6, g7.a("Category share-recipient limit hook failed", new Object[0]), th6);
        }
    }
}
