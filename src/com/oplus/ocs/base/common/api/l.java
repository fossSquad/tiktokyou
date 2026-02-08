package com.oplus.ocs.base.common.api;

import X.0Vx6;
import X.0zxW;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import com.bytedance.bpea.transmit.hook.HandlerHook;
import com.oplus.ocs.base.common.AuthResult;
import com.oplus.ocs.base.common.CapabilityInfo;
import com.oplus.ocs.base.internal.ClientSettings;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class l<O extends Api.ApiOptions> implements Handler.Callback {
    public static volatile l f;
    public Context a;
    public com.oplus.ocs.base.common.a b;
    public Looper e;
    public static final String d = "l";
    public static Map<Api.ClientKey, OplusApiClient> c = new ConcurrentHashMap();

    public l(Context context, Looper looper) {
        if (0Vx6.Q(context) != null) {
            this.a = 0Vx6.Q(context);
        } else {
            this.a = context;
        }
        this.e = looper;
        this.b = new com.oplus.ocs.base.common.a(this.e, this);
    }

    public static l a(Context context) {
        if (f == null) {
            synchronized (l.class) {
                if (f == null) {
                    HandlerThread handlerThread = new HandlerThread("OplusApiManager", 9);
                    handlerThread.start();
                    if (handlerThread.getLooper() != null) {
                        f = new l(context, handlerThread.getLooper());
                    } else {
                        f = new l(context, Looper.getMainLooper());
                    }
                }
            }
        }
        return f;
    }

    public static void a(Api.ClientKey clientKey) {
        c.remove(clientKey);
    }

    public static void a(OplusApi oplusApi) {
        CapabilityInfo capabilityInfo = CapabilityApiClient.getCapabilityInfo(oplusApi.getApi());
        if (capabilityInfo != null) {
            oplusApi.checkAuthResult(capabilityInfo);
        }
    }

    public static void a(OplusApi oplusApi, OnConnectionFailedListener onConnectionFailedListener, Handler handler) {
        OplusApiClient oplusApiClient;
        com.oplus.ocs.base.utils.d.a(oplusApi, "oplusApi not be null");
        if (!c.containsKey(oplusApi.getApi().getClientKey()) || (oplusApiClient = c.get(oplusApi.getApi().getClientKey())) == null) {
            return;
        }
        oplusApiClient.setOnConnectionFailedListener(onConnectionFailedListener, handler);
    }

    public static <T> void a(OplusApi oplusApi, TaskListenerHolder<T> taskListenerHolder) {
        OplusApiClient oplusApiClient;
        com.oplus.ocs.base.utils.a.a(d, "addQueue ".concat(oplusApi.getClass().getSimpleName()));
        com.oplus.ocs.base.utils.d.a(oplusApi, "oplusApi not be null");
        if (!c.containsKey(oplusApi.getApi().getClientKey()) || (oplusApiClient = c.get(oplusApi.getApi().getClientKey())) == null) {
            return;
        }
        oplusApiClient.addQueue(taskListenerHolder);
    }

    public static IBinder b(OplusApi oplusApi) {
        OplusApiClient oplusApiClient;
        com.oplus.ocs.base.utils.d.a(oplusApi, "oplusApi not be null");
        if (!c.containsKey(oplusApi.getApi().getClientKey()) || (oplusApiClient = c.get(oplusApi.getApi().getClientKey())) == null) {
            return null;
        }
        return oplusApiClient.getRemoteService();
    }

    public static int c(OplusApi oplusApi) {
        OplusApiClient oplusApiClient;
        com.oplus.ocs.base.utils.d.a(oplusApi, "oplusApi not be null");
        if (!c.containsKey(oplusApi.getApi().getClientKey()) || (oplusApiClient = c.get(oplusApi.getApi().getClientKey())) == null) {
            return 0;
        }
        return oplusApiClient.getRemoteVersion();
    }

    public static AuthResult d(OplusApi oplusApi) {
        OplusApiClient oplusApiClient;
        com.oplus.ocs.base.utils.d.a(oplusApi, "oplusApi not be null");
        if (!c.containsKey(oplusApi.getApi().getClientKey()) || (oplusApiClient = c.get(oplusApi.getApi().getClientKey())) == null) {
            return null;
        }
        return oplusApiClient.getAuthResult();
    }

    public static boolean e(OplusApi oplusApi) {
        OplusApiClient oplusApiClient;
        com.oplus.ocs.base.utils.d.a(oplusApi, "oplusApi not be null");
        if (!c.containsKey(oplusApi.getApi().getClientKey()) || (oplusApiClient = c.get(oplusApi.getApi().getClientKey())) == null) {
            return false;
        }
        return oplusApiClient.isConnected();
    }

    public final void a(Api api) {
        Message messageObtainMessage = this.b.obtainMessage();
        messageObtainMessage.what = 0;
        messageObtainMessage.obj = api;
        this.b.sendMessage(messageObtainMessage);
    }

    public final void a(OplusApi oplusApi, final OnConnectionSucceedListener onConnectionSucceedListener, Handler handler) {
        OplusApiClient oplusApiClient;
        com.oplus.ocs.base.utils.d.a(oplusApi, "oplusApi not be null");
        if (!c.containsKey(oplusApi.getApi().getClientKey()) || (oplusApiClient = c.get(oplusApi.getApi().getClientKey())) == null) {
            return;
        }
        if (oplusApi.isConnected()) {
            0Vx6.LJJLIIIJLJLI(0, new k93.a(handler == null ? Looper.getMainLooper() : handler.getLooper()) {

                public final void handleMessage(Message message) {
                    0zxW.LIZ("l@fec9.a$3");
                    super/*android.os.Handler*/.handleMessage(message);
                    OnConnectionSucceedListener onConnectionSucceedListener2 = onConnectionSucceedListener;
                    if (onConnectionSucceedListener2 != null) {
                        onConnectionSucceedListener2.onConnectionSucceed();
                    }
                    0zxW.LIZIZ("l@fec9.a$3");
                }
            });
        } else {
            oplusApiClient.setOnConnectionSucceedListener(onConnectionSucceedListener, handler);
        }
    }

    public final void a(final OplusApi oplusApi, ClientSettings clientSettings) {
        com.oplus.ocs.base.utils.d.a(oplusApi, "oplusApi not be null");
        com.oplus.ocs.base.utils.d.a(clientSettings, "clientsettings not be null");
        if (c.containsKey(oplusApi.getApi().getClientKey())) {
            return;
        }
        m mVar = new m(this.a, oplusApi.getApi(), oplusApi.a, clientSettings);
        mVar.setOnClearListener(new j() {
            @Override
            public final void a() {
                l.a(oplusApi.getApi().getClientKey());
            }
        });
        mVar.setOnCapabilityAuthListener(new i() {
            @Override
            public final void a(CapabilityInfo capabilityInfo) {
                if (capabilityInfo != null) {
                    oplusApi.checkAuthResult(capabilityInfo);
                }
            }
        });
        c.put(oplusApi.getApi().getClientKey(), mVar);
        a(oplusApi.getApi());
    }

    @Override
    public boolean handleMessage(Message message) {
        OplusApiClient oplusApiClient;
        Api api;
        OplusApiClient oplusApiClient2;
        com.oplus.ocs.base.utils.a.a(d, "handle message " + message.what);
        int i = message.what;
        if (i == 0) {
            Api api2 = (Api) HandlerHook.getMessageObj(message.obj);
            if (api2 == null || api2.getClientKey() == null || (oplusApiClient = c.get(api2.getClientKey())) == null) {
                return false;
            }
            oplusApiClient.connect();
            return false;
        }
        if (i != 1 || (api = (Api) HandlerHook.getMessageObj(message.obj)) == null || api.getClientKey() == null || (oplusApiClient2 = c.get(api.getClientKey())) == null) {
            return false;
        }
        oplusApiClient2.disconnect();
        a(api.getClientKey());
        return false;
    }
}
