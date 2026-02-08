package com.oplus.ocs.base.common.api;

import X.0zxW;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.bytedance.bpea.transmit.hook.HandlerHook;
import com.oplus.ocs.base.common.CapabilityInfo;

public class c extends com.oplus.ocs.base.common.a {
    public static volatile int a;
    public final String b;
    public BaseClient c;

    public c(Looper looper, BaseClient baseClient) {
        super(looper);
        this.b = "c";
        this.c = baseClient;
    }

    public static synchronized c a(BaseClient baseClient) {
        StringBuilder sb = new StringBuilder("base_client_");
        int i = a;
        a = i + 1;
        sb.append(i);
        HandlerThread handlerThread = new HandlerThread(sb.toString());
        handlerThread.start();
        if (handlerThread.getLooper() != null) {
            return new c(handlerThread.getLooper(), baseClient);
        }
        return new c(Looper.getMainLooper(), baseClient);
    }

    public void handleMessage(Message message) {
        0zxW.LIZ("c@fed2.handleMessage");
        int i = message.what;
        com.oplus.ocs.base.utils.a.a(this.b, "base client handler what ".concat(String.valueOf(i)));
        if (i == 1) {
            BaseClient baseClient = this.c;
            CapabilityInfo capabilityInfo = (CapabilityInfo) HandlerHook.getMessageObj(message.obj);
            String str = BaseClient.a;
            com.oplus.ocs.base.utils.a.b(str, "onAuthenticateSucceed");
            baseClient.b = 1;
            baseClient.c = capabilityInfo;
            i iVar = baseClient.f;
            if (iVar != null) {
                iVar.a(capabilityInfo);
            }
            com.oplus.ocs.base.utils.a.a(str, "handleAuthenticateSuccess");
            if (baseClient.g == null) {
                baseClient.a((Handler) null);
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 100;
            baseClient.g.sendMessage(messageObtain);
            baseClient.disconnect();
            0zxW.LIZIZ("c@fed2.handleMessage");
            return;
        }
        if (i != 2) {
            if (i == 3) {
                this.c.h.d();
                0zxW.LIZIZ("c@fed2.handleMessage");
                return;
            }
            if (i == 5) {
                BaseClient baseClient2 = this.c;
                while (baseClient2.d.size() > 0) {
                    com.oplus.ocs.base.utils.a.a(BaseClient.a, "handleQue");
                    baseClient2.a(baseClient2.d.poll());
                }
                com.oplus.ocs.base.utils.a.a(BaseClient.a, "task queue is end");
            }
            0zxW.LIZIZ("c@fed2.handleMessage");
            return;
        }
        BaseClient baseClient3 = this.c;
        int i2 = message.arg1;
        baseClient3.b = 4;
        baseClient3.disconnect();
        CapabilityInfo capabilityInfoB = BaseClient.b(i2);
        baseClient3.c = capabilityInfoB;
        i iVar2 = baseClient3.f;
        if (iVar2 != null) {
            iVar2.a(capabilityInfoB);
        }
        com.oplus.ocs.base.utils.a.a(BaseClient.a, "connect failed , error code is ".concat(String.valueOf(i2)));
        baseClient3.a(i2);
        j jVar = baseClient3.e;
        if (jVar != null) {
            jVar.a();
        }
        0zxW.LIZIZ("c@fed2.handleMessage");
    }
}
