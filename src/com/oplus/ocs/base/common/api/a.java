package com.oplus.ocs.base.common.api;

import X.06HP;
import X.0VpD;
import X.0Vx6;
import X.0xGu;
import X.0xPp;
import X.0xR1;
import X.0zxW;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.Message;
import android.os.Process;
import com.coloros.ocs.base.IServiceBroker;
import com.oplus.ocs.base.IAuthenticationListener;
import com.oplus.ocs.base.common.CapabilityInfo;
import com.oplus.ocs.base.utils.ServiceCheck;

public class a implements e {
    public IServiceBroker c;
    public Context d;
    public String e;
    public c f;
    public k g;
    public final String a = "a";
    public ServiceConnectionC0000a b = null;
    public IBinder.DeathRecipient h = new IBinder.DeathRecipient() {
        @Override
        public final void binderDied() {
            IBinder iBinderAsBinder;
            com.oplus.ocs.base.utils.a.d(a.this.a, "binderDied()");
            a.g(a.this);
            if (a.this.c == null || (iBinderAsBinder = a.this.c.asBinder()) == null || !iBinderAsBinder.isBinderAlive()) {
                return;
            }
            iBinderAsBinder.unlinkToDeath(a.this.h, 0);
            a.this.c = null;
        }
    };

    public class ServiceConnectionC0000a implements ServiceConnection {
        public ServiceConnectionC0000a() {
        }

        public  ServiceConnectionC0000a(a aVar, byte b) {
            this();
        }

        @Override
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (new 0xR1().LIZIZ(11064, "com/oplus/ocs/base/common/api/a$a", "onServiceConnected", this, new Object[]{componentName, iBinder}, "void", new 0xPp(false, "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", new 06HP("dzBzEg0qU9/PG1giVlyGZ6tjw1arWxFz99kP+05COQ==", (String[]) null))).LIZ) {
                return;
            }
            com.oplus.ocs.base.utils.a.a(a.this.a, "onServiceConnected");
            try {
                a.this.c = IServiceBroker.Stub.asInterface(iBinder);
                a.this.c.asBinder().linkToDeath(a.this.h, 0);
                a.this.f.sendEmptyMessage(3);
            } catch (Exception unused) {
            }
        }

        @Override
        public final void onServiceDisconnected(ComponentName componentName) {
            if (a.this.g != null) {
                a.this.g.onStateChange(13);
            }
            a.g(a.this);
            a.this.c = null;
        }
    }

    public a(Context context, String str, c cVar, k kVar) {
        this.d = context;
        this.e = str;
        this.f = cVar;
        this.g = kVar;
    }

    public void a(int i) {
        com.oplus.ocs.base.utils.a.b(this.a, "errorCode ".concat(String.valueOf(i)));
        Message messageObtain = Message.obtain();
        messageObtain.what = 2;
        messageObtain.arg1 = i;
        this.f.sendMessage(messageObtain);
    }

    public static  void a(a aVar) {
        Context context = aVar.d;
        new InternalClient(context, context.getPackageName(), aVar.e, Process.myPid(), true, true, new IAuthenticationListener.Stub() {
            @Override
            public final void onFail(int i) {
                com.oplus.ocs.base.utils.a.c(a.this.a, "handleAsyncAuthenticate, onFailed errorCode: ".concat(String.valueOf(i)));
                a.this.a(i);
            }

            @Override
            public final void onSuccess(CapabilityInfo capabilityInfo) {
                com.oplus.ocs.base.utils.a.b(a.this.a, "handleAsyncAuthenticate, onSuccess");
                a.a(a.this, capabilityInfo);
            }
        }).connect();
    }

    public static  void a(a aVar, CapabilityInfo capabilityInfo) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = capabilityInfo;
        aVar.f.sendMessage(messageObtain);
    }

    public static  ServiceConnectionC0000a g(a aVar) {
        aVar.b = null;
        return null;
    }

    @Override
    public final boolean a() {
        k kVar = this.g;
        if (kVar != null) {
            kVar.onStateChange(2);
        }
        if (ServiceCheck.b(this.d)) {
            0Vx6.k0().execute(new Runnable() {
                public static void com_oplus_ocs_base_common_api_a$1_com_ss_android_ugc_aweme_lancet_RunnableGuardLancet_run(AnonymousClass1 anonymousClass1) {
                    try {
                        anonymousClass1.com_oplus_ocs_base_common_api_a$1__run$___twin___();
                    } catch (Throwable th) {
                        if (!0VpD.LIZ(th)) {
                            throw th;
                        }
                    }
                }

                public final void com_oplus_ocs_base_common_api_a$1__run$___twin___() {
                    a.a(a.this);
                }

                @Override
                public final void run() {
                    0zxW.LIZ("a@fed4.<field>$2");
                    com_oplus_ocs_base_common_api_a$1_com_ss_android_ugc_aweme_lancet_RunnableGuardLancet_run(this);
                    0zxW.LIZIZ("a@fed4.<field>$2");
                }
            });
        } else {
            try {
                if (0Vx6.Q(this.d) == null) {
                    k kVar2 = this.g;
                    if (kVar2 != null) {
                        kVar2.onStateChange(2);
                    }
                    a(1009);
                    return true;
                }
                this.b = new ServiceConnectionC0000a();
                Context contextQ = 0Vx6.Q(this.d);
                Intent intent = new Intent("com.coloros.opencapabilityservice");
                intent.setComponent(new ComponentName("com.coloros.ocs.opencapabilityservice", "com.coloros.ocs.opencapabilityservice.service.ColorOcsService"));
                boolean zLJJJIL = 0xGu.LJJJIL(contextQ, intent, this.b, 1, new 06HP("dzBzEg0qU9/PG1giVlyGZ6tjw1arWxFz99kP+05COQ==", (String[]) null));
                com.oplus.ocs.base.utils.a.b(this.a, "connect state ".concat(String.valueOf(zLJJJIL)));
                if (!zLJJJIL) {
                    a(3);
                    return true;
                }
            } catch (Exception e) {
                com.oplus.ocs.base.utils.a.d(this.a, 0Vx6.m0("out bind get an exception %s", new Object[]{e.getMessage()}));
                return true;
            }
        }
        return true;
    }

    @Override
    public final boolean b() {
        return false;
    }

    @Override
    public final void c() {
        if (this.b == null || 0Vx6.Q(this.d) == null) {
            return;
        }
        try {
            0Vx6.Q(this.d).unbindService(this.b);
            this.c = null;
        } catch (Exception e) {
            com.oplus.ocs.base.utils.a.d(this.a, 0Vx6.m0("out unbind get an exception %s", new Object[]{e.getMessage()}));
        }
    }

    @Override
    public final void d() {
        IBinder iBinderAsBinder;
        try {
            IServiceBroker iServiceBroker = this.c;
            if (iServiceBroker == null || (iBinderAsBinder = iServiceBroker.asBinder()) == null || !iBinderAsBinder.isBinderAlive()) {
                return;
            }
            this.c.handleAuthentication(this.e, "1.0.11", new com.coloros.ocs.base.IAuthenticationListener.Stub() {
                @Override
                public final void onFail(int i) {
                    a.this.a(i);
                }

                @Override
                public final void onSuccess(CapabilityInfo capabilityInfo) {
                    if (capabilityInfo == null) {
                        a.this.a(7);
                    } else {
                        a.a(a.this, capabilityInfo);
                    }
                }
            });
        } catch (Exception e) {
            com.oplus.ocs.base.utils.a.d(this.a, "the exception that service broker authenticates is" + e.getMessage());
            a(7);
        }
    }
}
