package com.oplus.ocs.base.common.api;

import X.0VpD;
import X.0Vx6;
import X.0zxW;
import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.oplus.ocs.base.common.AuthResult;
import com.oplus.ocs.base.common.CapabilityInfo;
import com.oplus.ocs.base.common.api.OplusApi;
import com.oplus.ocs.base.internal.ClientSettings;
import com.oplus.ocs.base.task.Task;
import com.oplus.ocs.base.task.TaskImpl;
import com.oplus.ocs.base.utils.ServiceCheck;

public abstract class OplusApi<O extends Api.ApiOptions, R extends OplusApi> {
    public O a;
    public Context b;
    public Api<O> c;
    public l d;
    public ClientSettings e;
    public boolean f;

    public OplusApi(Activity activity, Api<O> api, O o, ClientSettings clientSettings) {
        this(activity, api, o, clientSettings, true);
    }

    public OplusApi(Context context, Api<O> api, O o, ClientSettings clientSettings) {
        this(context, api, o, clientSettings, true);
    }

    public OplusApi(Context context, Api<O> api, O o, ClientSettings clientSettings, boolean z) {
        com.oplus.ocs.base.utils.d.a(context, "Null context is not permitted.");
        com.oplus.ocs.base.utils.d.a(api, "Api must not be null.");
        this.b = context;
        this.c = api;
        this.a = o;
        this.e = clientSettings;
        this.f = z;
        if (z) {
            l lVarA = l.a(context);
            this.d = lVarA;
            lVarA.a(this, this.e);
        } else {
            if (api.isAuth()) {
                return;
            }
            String clientName = getClientName();
            if (TextUtils.isEmpty(clientName)) {
                Api.Client clientBuildClient = getApi().getClientBuilder().buildClient(this.b, Looper.getMainLooper(), clientSettings, null);
                if (clientBuildClient instanceof BaseClient) {
                    clientName = ((BaseClient) clientBuildClient).getClientName();
                }
            }
            if (TextUtils.isEmpty(clientName)) {
                return;
            }
            Context context2 = this.b;
            new InternalClient(context2, context2.getPackageName(), clientName, 0, false, null).connect4Stat();
        }
    }

    public OplusApi(Context context, Api<O> api, ClientSettings clientSettings) {
        this(context, api, null, clientSettings, true);
    }

    public static boolean checkInternal(Context context) {
        return ServiceCheck.a(context);
    }

    public R addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener) {
        addOnConnectionFailedListener(onConnectionFailedListener, new k93.a(Looper.getMainLooper()));
        return this;
    }

    public R addOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener, Handler handler) {
        if (this.f) {
            l.a(this, onConnectionFailedListener, handler);
        }
        return this;
    }

    public R addOnConnectionSucceedListener(OnConnectionSucceedListener onConnectionSucceedListener) {
        addOnConnectionSucceedListener(onConnectionSucceedListener, new k93.a(Looper.getMainLooper()));
        return this;
    }

    public R addOnConnectionSucceedListener(final OnConnectionSucceedListener onConnectionSucceedListener, Handler handler) {
        if (this.f) {
            this.d.a(this, onConnectionSucceedListener, handler);
        } else if (onConnectionSucceedListener != null) {
            if (handler == null) {
                onConnectionSucceedListener.onConnectionSucceed();
                return this;
            }
            0Vx6.LJJLIIIIJ(handler, new Runnable() {
                public static void com_oplus_ocs_base_common_api_OplusApi$1_com_ss_android_ugc_aweme_lancet_RunnableGuardLancet_run(AnonymousClass1 anonymousClass1) {
                    try {
                        anonymousClass1.com_oplus_ocs_base_common_api_OplusApi$1__run$___twin___();
                    } catch (Throwable th) {
                        if (!0VpD.LIZ(th)) {
                            throw th;
                        }
                    }
                }

                public void com_oplus_ocs_base_common_api_OplusApi$1__run$___twin___() {
                    onConnectionSucceedListener.onConnectionSucceed();
                }

                @Override
                public void run() {
                    0zxW.LIZ("OplusApi@9f78.addOnConnectionSucceedListener$1");
                    com_oplus_ocs_base_common_api_OplusApi$1_com_ss_android_ugc_aweme_lancet_RunnableGuardLancet_run(this);
                    0zxW.LIZIZ("OplusApi@9f78.addOnConnectionSucceedListener$1");
                }
            });
            return this;
        }
        return this;
    }

    public void addThis2Cache() {
        if (this.f) {
            this.d.a(this, this.e);
        }
    }

    public void checkAuthResult(CapabilityInfo capabilityInfo) {
    }

    public void checkCapability() {
        if (this.d != null) {
            l.a(this);
        }
    }

    public boolean checkExist() {
        return ServiceCheck.check(this.b, "com.coloros.ocs.opencapabilityservice") || ServiceCheck.check(this.b, "com.oplus.ocs");
    }

    public void disconnect() {
        if (this.f) {
            l lVar = this.d;
            Api<O> api = this.c;
            Message messageObtainMessage = lVar.b.obtainMessage();
            messageObtainMessage.what = 1;
            messageObtainMessage.obj = api;
            lVar.b.sendMessage(messageObtainMessage);
        }
    }

    public <TResult> Task<TResult> doRegisterListener(Looper looper, TaskListenerHolder.SuccessNotifier<TResult> successNotifier, TaskListenerHolder.FailureNotifier<TResult> failureNotifier) {
        com.oplus.ocs.base.utils.a.a("capability doRegisterListener");
        TaskImpl taskImpl = new TaskImpl();
        TaskListenerHolder taskListenerHolder = new TaskListenerHolder(looper, taskImpl, successNotifier, failureNotifier);
        if (this.f) {
            l.a(this, taskListenerHolder);
        }
        return taskImpl;
    }

    public <TResult> Task<TResult> doRegisterListener(TaskListenerHolder.SuccessNotifier<TResult> successNotifier, TaskListenerHolder.FailureNotifier<TResult> failureNotifier) {
        return doRegisterListener(Looper.getMainLooper(), successNotifier, failureNotifier);
    }

    public Api<O> getApi() {
        return this.c;
    }

    public AuthResult getAuthResult() {
        if (this.f) {
            return l.d(this);
        }
        return null;
    }

    public String getClientName() {
        return "";
    }

    public IBinder getRemoteService() {
        if (this.f) {
            return l.b(this);
        }
        return null;
    }

    public int getRemoteVersion() {
        if (this.f) {
            return l.c(this);
        }
        return 0;
    }

    public abstract int getVersion();

    public abstract boolean hasFeature(String str);

    public abstract void init();

    public boolean isConnected() {
        if (this.f) {
            return l.e(this);
        }
        return true;
    }

    public void releaseClientKey() {
        if (this.f) {
            l.a(this.c.getClientKey());
        }
    }
}
