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
import android.os.RemoteException;
import com.oplus.ocs.base.IAuthenticationListener;
import com.oplus.ocs.base.IServiceBroker;
import com.oplus.ocs.base.common.CapabilityInfo;
import com.oplus.ocs.base.utils.ServiceCheck;

public final class g implements e {
    public IServiceBroker c;
    public Context d;
    public String e;
    public c f;
    public k g;
    public final String a = "a";
    public a b = null;
    public IBinder.DeathRecipient h = new IBinder.DeathRecipient() {
        @Override
        public final void binderDied() {
            IBinder iBinderAsBinder;
            com.oplus.ocs.base.utils.a.d(g.this.a, "binderDied()");
            g gVar = g.this;
            gVar.b = null;
            IServiceBroker iServiceBroker = gVar.c;
            if (iServiceBroker == null || (iBinderAsBinder = iServiceBroker.asBinder()) == null || !iBinderAsBinder.isBinderAlive()) {
                return;
            }
            iBinderAsBinder.unlinkToDeath(g.this.h, 0);
            g.this.c = null;
        }
    };

    public class a implements ServiceConnection {
        public a() {
        }

        public  a(g gVar, byte b) {
            this();
        }

        @Override
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (new 0xR1().LIZIZ(11064, "com/oplus/ocs/base/common/api/g$a", "onServiceConnected", this, new Object[]{componentName, iBinder}, "void", new 0xPp(false, "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", new 06HP("dzBzEg0qU9/PG1giVlyGZ6tjw1arWxFz99kP+05CPw==", (String[]) null))).LIZ) {
                return;
            }
            com.oplus.ocs.base.utils.a.a(g.this.a, "new ocs onServiceConnected");
            try {
                g.this.c = IServiceBroker.Stub.asInterface(iBinder);
                g.this.c.asBinder().linkToDeath(g.this.h, 0);
                g.this.f.sendEmptyMessage(3);
            } catch (RemoteException unused) {
            }
        }

        @Override
        public final void onServiceDisconnected(ComponentName componentName) {
            k kVar = g.this.g;
            if (kVar != null) {
                kVar.onStateChange(13);
            }
            g gVar = g.this;
            gVar.b = null;
            gVar.c = null;
        }
    }

    public g(Context context, String str, c cVar, k kVar) {
        this.d = context;
        this.e = str;
        this.f = cVar;
        this.g = kVar;
    }

    public static  void a(g gVar, CapabilityInfo capabilityInfo) {
        Message messageObtain = Message.obtain();
        messageObtain.what = 1;
        messageObtain.obj = capabilityInfo;
        gVar.f.sendMessage(messageObtain);
    }

    public final void a(int i) {
        com.oplus.ocs.base.utils.a.b(this.a, "errorCode ".concat(String.valueOf(i)));
        Message messageObtain = Message.obtain();
        messageObtain.what = 2;
        messageObtain.arg1 = i;
        this.f.sendMessage(messageObtain);
    }

    @Override
    public final boolean a() {
        k kVar = this.g;
        if (kVar != null) {
            kVar.onStateChange(2);
        }
        if (ServiceCheck.b(this.d)) {
            0Vx6.k0().execute(new Runnable() {
                public static void com_oplus_ocs_base_common_api_g$1_com_ss_android_ugc_aweme_lancet_RunnableGuardLancet_run(AnonymousClass1 anonymousClass1) {
                    try {
                        anonymousClass1.com_oplus_ocs_base_common_api_g$1__run$___twin___();
                    } catch (Throwable th) {
                        if (!0VpD.LIZ(th)) {
                            throw th;
                        }
                    }
                }

                public final void com_oplus_ocs_base_common_api_g$1__run$___twin___() {
                    final g gVar = g.this;
                    Context context = gVar.d;
                    new InternalClient(context, context.getPackageName(), gVar.e, Process.myPid(), true, true, new IAuthenticationListener.Stub() {
                        @Override
                        public final void onFail(int i) {
                            com.oplus.ocs.base.utils.a.c(g.this.a, "handleAsyncAuthenticate, onFailed errorCode: ".concat(String.valueOf(i)));
                            g.this.a(i);
                        }

                        @Override
                        public final void onSuccess(CapabilityInfo capabilityInfo) {
                            com.oplus.ocs.base.utils.a.b(g.this.a, "handleAsyncAuthenticate, onSuccess");
                            g.a(g.this, capabilityInfo);
                        }
                    }).connect();
                }

                @Override
                public final void run() {
                    0zxW.LIZ("g@fece.<field>$2");
                    com_oplus_ocs_base_common_api_g$1_com_ss_android_ugc_aweme_lancet_RunnableGuardLancet_run(this);
                    0zxW.LIZIZ("g@fece.<field>$2");
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
                this.b = new a();
                Context contextQ = 0Vx6.Q(this.d);
                Intent intent = new Intent("com.oplus.ocs.openauthenticate");
                intent.setComponent(new ComponentName("com.oplus.ocs", "com.oplus.ocs.service.OpenAuthenticateService"));
                boolean zLJJJIL = 0xGu.LJJJIL(contextQ, intent, this.b, 1, new 06HP("dzBzEg0qU9/PG1giVlyGZ6tjw1arWxFz99kP+05CPw==", (String[]) null));
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
            this.c.handleAuthentication(this.e, "1.0.11", new IAuthenticationListener.Stub() {
                @Override
                public final void onFail(int i) {
                    g.this.a(i);
                }

                @Override
                public final void onSuccess(CapabilityInfo capabilityInfo) {
                    g.a(g.this, capabilityInfo);
                }
            });
        } catch (Exception e) {
            com.oplus.ocs.base.utils.a.d(this.a, "the exception that service broker authenticates is" + e.getMessage());
            a(7);
        }
    }
}
