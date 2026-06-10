package X;

import com.ss.android.ugc.profile.business.ur.ui.ProfileEditActivity;
import com.ss.android.ugc.profile.business.ur.ui.ProfileEditNicknameFragment;
import com.windukk.hook.HookBridge;
import com.windukk.hook.HookMethod;

public abstract class i7 {
    public static final HookMethod a = new e7();
    public static final HookMethod b = new f7();
    public static final HookMethod c = new g7();
    public static final HookMethod d = new h7();

    public static void a() {
        HookMethod hookMethod = a;
        a(ProfileEditNicknameFragment.class, "onCreate", hookMethod);
        a(ProfileEditNicknameFragment.class, "onCreateView", hookMethod);
        a(ProfileEditNicknameFragment.class, "onResume", hookMethod);
        HookMethod hookMethod2 = b;
        a(ProfileEditNicknameFragment.class, "onPause", hookMethod2);
        a(ProfileEditNicknameFragment.class, "onDestroyView", hookMethod2);
        a(ProfileEditNicknameFragment.class, "onDestroy", hookMethod2);
        a(ProfileEditNicknameFragment.class, a6.a.c[0], c);
        a(ProfileEditNicknameFragment.class, a6.b.c[0], d);
        a(ProfileEditActivity.class, "onDestroy", hookMethod2);
    }

    public static void a(Class cls, String str, HookMethod hookMethod) {
        try {
            if (HookBridge.hookAllMethods(cls, str, hookMethod).size() > 0) {
                int i = p4.a;
            }
        } catch (Throwable th) {
            th.getMessage();
            int i2 = p4.a;
        }
    }
}
