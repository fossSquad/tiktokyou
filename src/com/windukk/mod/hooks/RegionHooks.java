package com.windukk.mod.hooks;

import android.telephony.TelephonyManager;
import com.windukk.hook.HookBridge;
import java.util.function.Supplier;

public abstract class RegionHooks {
    public static void a() {
        a("getNetworkType", new Supplier() {
            @Override
            public final Object get() {
                return RegionHooks.b();
            }
        });
        a("getDataNetworkType", new Supplier() {
            @Override
            public final Object get() {
                return RegionHooks.c();
            }
        });
        a("getVoiceNetworkType", new Supplier() {
            @Override
            public final Object get() {
                return RegionHooks.f();
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
                return RegionHooks.h();
            }
        });
        a("getPhoneType", new Supplier() {
            @Override
            public final Object get() {
                return RegionHooks.i();
            }
        });
        a("getSimCountryIso", new Supplier() {
            @Override
            public final Object get() {
                return RegionHooks.j();
            }
        });
        a("getNetworkCountryIso", new Supplier() {
            @Override
            public final Object get() {
                return RegionHooks.k();
            }
        });
        a("getSimOperator", new Supplier() {
            @Override
            public final Object get() {
                return RegionHooks.l();
            }
        });
        a("getNetworkOperator", new Supplier() {
            @Override
            public final Object get() {
                return RegionHooks.m();
            }
        });
        a("getSimOperatorName", new Supplier() {
            @Override
            public final Object get() {
                return RegionHooks.d();
            }
        });
        a("getNetworkOperatorName", new Supplier() {
            @Override
            public final Object get() {
                return RegionHooks.e();
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
        ta.a().getClass();
        return ta.c().f;
    }

    public static  Object e() {
        ta.a().getClass();
        return ta.c().f;
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
        ta.a().getClass();
        return ta.c().d;
    }

    public static  Object k() {
        ta.a().getClass();
        return ta.c().d;
    }

    public static  Object l() {
        ta.a().getClass();
        return ta.c().e;
    }

    public static  Object m() {
        ta.a().getClass();
        return ta.c().e;
    }

    public static void a(String str, Supplier supplier) {
        try {
            HookBridge.hookAllMethods(TelephonyManager.class, str, new id(supplier));
        } catch (Throwable th) {
            String strA = new StringBuilder().append("TelephonyManager.").append(str).append(" hook failed: ").toString();
            Object obj = h6.a;
            h6.a(6, String.valueOf(strA), th);
        }
    }
}
