package com.oplus.ocs.base.common.api;

import X.06HP;
import X.0Vx6;
import X.0xGu;
import X.0xPp;
import X.0xR1;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.IBinder;
import com.oplus.ocs.base.IAuthenticationListener;
import com.oplus.ocs.base.common.CapabilityInfo;

public class f implements e {
    public Context b;
    public ServiceConnection c;
    public IAuthenticationListener d;
    public InternalClient e;
    public final String a = "f";
    public com.coloros.ocs.base.IAuthenticationListener f = new com.coloros.ocs.base.IAuthenticationListener.Stub() {
        @Override
        public final void onFail(int i) {
            if (f.this.d != null) {
                f.this.d.onFail(i);
            }
        }

        @Override
        public final void onSuccess(CapabilityInfo capabilityInfo) {
            if (f.this.d != null) {
                if (capabilityInfo == null) {
                    f.this.d.onFail(7);
                } else {
                    f.this.d.onSuccess(capabilityInfo);
                }
            }
        }
    };

    public class a implements ServiceConnection {
        public a() {
        }

        public  a(f fVar, byte b) {
            this();
        }

        @Override
        public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (new 0xR1().LIZIZ(11064, "com/oplus/ocs/base/common/api/f$a", "onServiceConnected", this, new Object[]{componentName, iBinder}, "void", new 0xPp(false, "(Landroid/content/ComponentName;Landroid/os/IBinder;)V", new 06HP("dzBzEg0qU9/PG1giVlyGZ6tjw1arWxFz99kP+05CPg==", (String[]) null))).LIZ) {
                return;
            }
            try {
                if (f.this.e != null) {
                    f.this.e.serviceUnbind();
                }
            } catch (Exception unused) {
            }
        }

        @Override
        public final void onServiceDisconnected(ComponentName componentName) {
            com.oplus.ocs.base.utils.a.b(f.this.a, "onServiceDisconnected()");
            f.d(f.this);
        }
    }

    public f(Context context, InternalClient internalClient, IAuthenticationListener iAuthenticationListener) {
        this.b = context;
        this.e = internalClient;
        this.d = iAuthenticationListener;
    }

    public static  ServiceConnection d(f fVar) {
        fVar.c = null;
        return null;
    }

    @Override
    public final boolean a() {
        boolean zLJJJIL;
        IAuthenticationListener iAuthenticationListener;
        try {
            if (0Vx6.Q(this.b) == null) {
                IAuthenticationListener iAuthenticationListener2 = this.d;
                if (iAuthenticationListener2 == null) {
                    return false;
                }
                iAuthenticationListener2.onFail(1009);
                return false;
            }
            this.c = new a();
            Context contextQ = 0Vx6.Q(this.b);
            com.coloros.ocs.base.IAuthenticationListener iAuthenticationListener3 = this.f;
            Intent serviceIntent = this.e.getServiceIntent("com.coloros.opencapabilityservice", "com.coloros.ocs.opencapabilityservice", "com.coloros.ocs.opencapabilityservice.service.ColorOcsService");
            if (iAuthenticationListener3 != null) {
                Bundle bundle = new Bundle();
                0Vx6.LJIILJJIL(bundle, iAuthenticationListener3.asBinder(), "internal_binder");
                serviceIntent.putExtra("internal_bundle", bundle);
            }
            zLJJJIL = 0xGu.LJJJIL(contextQ, serviceIntent, this.c, 1, new 06HP("dzBzEg0qU9/PG1giVlyGZ6tjw1arWxFz99kP+05CPg==", (String[]) null));
            try {
                com.oplus.ocs.base.utils.a.d(this.a, "connect state - ".concat(String.valueOf(zLJJJIL)));
                if (zLJJJIL || (iAuthenticationListener = this.d) == null) {
                    return zLJJJIL;
                }
                iAuthenticationListener.onFail(3);
                return zLJJJIL;
            } catch (Exception e) {
                e = e;
                com.oplus.ocs.base.utils.a.d(this.a, 0Vx6.m0("in bind get an exception %s", new Object[]{e.getMessage()}));
                return zLJJJIL;
            }
        } catch (Exception e2) {
            e = e2;
            zLJJJIL = false;
        }
    }

    @Override
    public final boolean b() {
        boolean zLJJJIL;
        IAuthenticationListener iAuthenticationListener;
        try {
            if (0Vx6.Q(this.b) == null) {
                IAuthenticationListener iAuthenticationListener2 = this.d;
                if (iAuthenticationListener2 == null) {
                    return false;
                }
                iAuthenticationListener2.onFail(1009);
                return false;
            }
            this.c = new a();
            zLJJJIL = 0xGu.LJJJIL(0Vx6.Q(this.b), this.e.getServiceIntent4Stat("com.coloros.opencapabilityservice", "com.coloros.ocs.opencapabilityservice", "com.coloros.ocs.opencapabilityservice.service.ColorOcsService"), this.c, 1, new 06HP("dzBzEg0qU9/PG1giVlyGZ6tjw1arWxFz99kP+05CPg==", (String[]) null));
            try {
                com.oplus.ocs.base.utils.a.d(this.a, "connect stat state - ".concat(String.valueOf(zLJJJIL)));
                if (zLJJJIL || (iAuthenticationListener = this.d) == null) {
                    return zLJJJIL;
                }
                iAuthenticationListener.onFail(3);
                return zLJJJIL;
            } catch (Exception e) {
                e = e;
                com.oplus.ocs.base.utils.a.d(this.a, 0Vx6.m0("in bind get an exception %s", new Object[]{e.getMessage()}));
                return zLJJJIL;
            }
        } catch (Exception e2) {
            e = e2;
            zLJJJIL = false;
        }
    }

    @Override
    public final void c() {
        if (this.c == null) {
            com.oplus.ocs.base.utils.a.d(this.a, "mServiceConnectionImpl is null");
        } else if (0Vx6.Q(this.b) != null) {
            try {
                0Vx6.Q(this.b).unbindService(this.c);
            } catch (Exception e) {
                com.oplus.ocs.base.utils.a.d(this.a, 0Vx6.m0("in unbind get an exception %s", new Object[]{e.getMessage()}));
            }
        }
    }

    @Override
    public final void d() {
    }
}
