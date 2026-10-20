package Z;

import android.telephony.TelephonyManager;
import com.windukk.hook.HookBridge;
import com.windukk.mod.hooks.StoryEngagementHooks;
import java.util.function.Supplier;

public abstract class ye {
    public static void a() {
        a("getNetworkType", new Supplier() {
            @Override
            public final Object get() {
                return ye.b();
            }
        });
        a("getDataNetworkType", new Supplier() {
            @Override
            public final Object get() {
                return ye.c();
            }
        });
        a("getVoiceNetworkType", new Supplier() {
            @Override
            public final Object get() {
                return ye.f();
            }
        });
        a("hasIccCard", new Supplier() {
            @Override
            public final Object get() {
                return Boolean.TRUE;
            }
        });
        a("getSimState", new Supplier() {
            @Override
            public final Object get() {
                return ye.h();
            }
        });
        a("getPhoneType", new Supplier() {
            @Override
            public final Object get() {
                return ye.i();
            }
        });
        a("getSimCountryIso", new Supplier() {
            @Override
            public final Object get() {
                return ye.j();
            }
        });
        a("getNetworkCountryIso", new Supplier() {
            @Override
            public final Object get() {
                return ye.k();
            }
        });
        a("getSimOperator", new Supplier() {
            @Override
            public final Object get() {
                return ye.l();
            }
        });
        a("getNetworkOperator", new Supplier() {
            @Override
            public final Object get() {
                return ye.m();
            }
        });
        a("getSimOperatorName", new Supplier() {
            @Override
            public final Object get() {
                return ye.d();
            }
        });
        a("getNetworkOperatorName", new Supplier() {
            @Override
            public final Object get() {
                return ye.e();
            }
        });
    }

    public static  Object b() {
        return 13;
    }

    public static  Object c() {
        return 13;
    }

    public static  Object d() {
        ac.a().getClass();
        return ac.d().f;
    }

    public static  Object e() {
        ac.a().getClass();
        return ac.d().f;
    }

    public static  Object f() {
        return 13;
    }

    public static  Object h() {
        return 5;
    }

    public static  Object i() {
        return 1;
    }

    public static  Object j() {
        ac.a().getClass();
        return ac.d().d;
    }

    public static  Object k() {
        ac.a().getClass();
        return ac.d().d;
    }

    public static  Object l() {
        ac.a().getClass();
        return ac.d().e;
    }

    public static  Object m() {
        ac.a().getClass();
        return ac.d().e;
    }

    public static void a(String str, Supplier supplier) {
        try {
            HookBridge.hookAllMethods(TelephonyManager.class, str, new StoryEngagementHooks(supplier));
        } catch (Throwable th) {
            String strA = ((new StringBuilder()).append("TelephonyManager.").append(str)).append(" hook failed: ").toString();
            Object obj = g7.a;
            g7.a(6, String.valueOf(strA), th);
        }
    }
}
