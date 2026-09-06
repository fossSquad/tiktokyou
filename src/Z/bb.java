package Z;

import com.ss.android.ugc.profile.business.ur.ui.ProfileEditActivity;
import com.ss.android.ugc.profile.business.ur.ui.ProfileEditNicknameFragment;
import com.windukk.hook.HookBridge;
import com.windukk.hook.HookMethod;
import com.windukk.mod.hooks.BadgeHooks;
import java.lang.reflect.Member;

public abstract class bb {
    public static final HookMethod a = new xa();
    public static final HookMethod b = new ya();
    public static final HookMethod c = new za();
    public static final HookMethod d = new ab();

    public static void a() {
        String strDecrypt = "onCreate";
        HookMethod hookMethod = a;
        a(ProfileEditNicknameFragment.class, strDecrypt, hookMethod);
        a(ProfileEditNicknameFragment.class, "onCreateView", hookMethod);
        a(ProfileEditNicknameFragment.class, "onResume", hookMethod);
        String strDecrypt2 = "onPause";
        HookMethod hookMethod2 = b;
        a(ProfileEditNicknameFragment.class, strDecrypt2, hookMethod2);
        a(ProfileEditNicknameFragment.class, "onDestroyView", hookMethod2);
        a(ProfileEditNicknameFragment.class, "onDestroy", hookMethod2);
        a(ProfileEditNicknameFragment.class, c9.a.c[0], c);
        a(ProfileEditNicknameFragment.class, c9.b.c[0], d);
        a(ProfileEditActivity.class, "onDestroy", hookMethod2);
    }

    public static void a(Class cls, String str, HookMethod hookMethod) {
        try {
            HookBridge.hookAllMethods(cls, str, hookMethod);
        } catch (Throwable th) {
            String strDecrypt = "Exception during nickname disabler";
            Object obj = h6.a;
            h6.a(6, String.valueOf(strDecrypt), th);
        }
    }

    public static void a(boolean z, HookMethod.HookMethodParam hookMethodParam) {
        String str;
        String str2;
        Member member;
        if (hookMethodParam == null || (member = hookMethodParam.method) == null) {
        } else {
            member.getName();
        }
        if (BadgeHooks.y.getAndSet(z ? 1 : 0) != z) {
            (z ? "enabled" : "disabled");
        }
    }
}
