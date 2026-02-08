package com.oplus.ocs.base.common.api;

import X.0VpD;
import X.0Vx6;
import X.0zxW;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.oplus.ocs.base.common.AuthResult;
import com.oplus.ocs.base.common.CapabilityInfo;
import com.oplus.ocs.base.common.ConnectionResult;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public abstract class BaseClient<T extends IBinder> implements Api.Client, k {
    public static final String a = "BaseClient";
    public CapabilityInfo c;
    public j e;
    public i f;
    public e h;
    public Context i;
    public Looper j;
    public c k;
    public volatile int b = 4;
    public Queue<TaskListenerHolder> d = new LinkedList();
    public d g = null;

    public BaseClient(Context context, Looper looper) {
        if (context == null) {
            throw new NullPointerException("null reference");
        }
        this.i = context;
        if (looper == null) {
            throw new NullPointerException("Looper must not be null");
        }
        this.j = looper;
        this.k = c.a(this);
        b.a();
        this.h = b.a(this.i, getClientName(), this.k, this);
    }

    private void a() {
        if (!isConnected()) {
            throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
        }
    }

    private void a(TaskListenerHolder taskListenerHolder, boolean z) {
        this.d.add(taskListenerHolder);
        if (z) {
            connect();
        }
    }

    public static CapabilityInfo b(int i) {
        return new CapabilityInfo(new ArrayList(), 1, new AuthResult("", 0, 0, i, new byte[0]));
    }

    public final void a(int i) {
        com.oplus.ocs.base.utils.a.a(a, "handleAuthenticateFailure");
        if (this.g == null) {
            a((Handler) null);
        }
        Message messageObtain = Message.obtain();
        messageObtain.what = 101;
        messageObtain.arg1 = i;
        this.g.sendMessage(messageObtain);
    }

    public final void a(Handler handler) {
        k93.a aVar = this.g;
        if (aVar == null) {
            if (handler == null) {
                this.g = new d(this.j, this.k);
                return;
            } else {
                this.g = new d(handler.getLooper(), this.k);
                return;
            }
        }
        if (handler == null || aVar.getLooper() == handler.getLooper()) {
            return;
        }
        com.oplus.ocs.base.utils.a.a(a, "the new handler looper is not the same as the old one.");
    }

    public final void a(TaskListenerHolder taskListenerHolder) {
        CapabilityInfo capabilityInfo = this.c;
        if (capabilityInfo == null || capabilityInfo.getAuthResult() == null) {
            return;
        }
        if (this.c.getAuthResult().getErrrorCode() == 1001) {
            taskListenerHolder.setErrorCode(0);
        } else {
            taskListenerHolder.setErrorCode(this.c.getAuthResult().getErrrorCode());
        }
    }

    @Override
    public <T> void addQueue(TaskListenerHolder<T> taskListenerHolder) {
        if (isConnected()) {
            a(taskListenerHolder);
        } else if (this.b == 13) {
            a(taskListenerHolder, true);
        } else {
            a(taskListenerHolder, false);
        }
    }

    @Override
    public void connect() {
        e eVar = this.h;
        if (eVar != null) {
            eVar.a();
            return;
        }
        this.c = b(3);
        a(3);
        j jVar = this.e;
        if (jVar != null) {
            jVar.a();
        }
    }

    @Override
    public void disconnect() {
        this.h.c();
    }

    @Override
    public AuthResult getAuthResult() {
        return this.c.getAuthResult();
    }

    public abstract String getClientName();

    @Override
    public Looper getLooper() {
        return this.j;
    }

    @Override
    public int getMinApkVersion() {
        a();
        return this.c.getVersion();
    }

    @Override
    public T getRemoteService() {
        a();
        return (T) this.c.getBinder();
    }

    @Override
    public boolean isConnected() {
        return this.b == 1;
    }

    @Override
    public boolean isConnecting() {
        return this.b == 2;
    }

    @Override
    public void onStateChange(int i) {
        this.b = i;
    }

    @Override
    public void setOnCapabilityAuthListener(i iVar) {
        this.f = iVar;
    }

    @Override
    public void setOnClearListener(j jVar) {
        this.e = jVar;
    }

    @Override
    public void setOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener, Handler handler) {
        CapabilityInfo capabilityInfo = this.c;
        if (capabilityInfo == null || capabilityInfo.getAuthResult() == null || this.c.getAuthResult().getErrrorCode() == 1001) {
            a(handler);
            this.g.b = onConnectionFailedListener;
        } else if (onConnectionFailedListener != null) {
            onConnectionFailedListener.onConnectionFailed(new ConnectionResult(this.c.getAuthResult().getErrrorCode()));
        }
    }

    @Override
    public void setOnConnectionSucceedListener(final OnConnectionSucceedListener onConnectionSucceedListener, Handler handler) {
        CapabilityInfo capabilityInfo = this.c;
        if (capabilityInfo == null || capabilityInfo.getAuthResult() == null || this.c.getAuthResult().getErrrorCode() != 1001) {
            a(handler);
            this.g.a = onConnectionSucceedListener;
        } else if (onConnectionSucceedListener != null) {
            if (handler == null) {
                onConnectionSucceedListener.onConnectionSucceed();
            } else {
                0Vx6.LJJLIIIIJ(handler, new Runnable() {
                    public static void com_oplus_ocs_base_common_api_BaseClient$1_com_ss_android_ugc_aweme_lancet_RunnableGuardLancet_run(AnonymousClass1 anonymousClass1) {
                        try {
                            anonymousClass1.com_oplus_ocs_base_common_api_BaseClient$1__run$___twin___();
                        } catch (Throwable th) {
                            if (!0VpD.LIZ(th)) {
                                throw th;
                            }
                        }
                    }

                    public final void com_oplus_ocs_base_common_api_BaseClient$1__run$___twin___() {
                        onConnectionSucceedListener.onConnectionSucceed();
                    }

                    @Override
                    public final void run() {
                        0zxW.LIZ("BaseClient@eaba.setOnConnectionSucceedListener$1");
                        com_oplus_ocs_base_common_api_BaseClient$1_com_ss_android_ugc_aweme_lancet_RunnableGuardLancet_run(this);
                        0zxW.LIZIZ("BaseClient@eaba.setOnConnectionSucceedListener$1");
                    }
                });
            }
        }
    }
}
