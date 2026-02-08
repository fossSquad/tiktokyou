package com.oplus.ocs.base.common.api;

import X.0zxW;
import android.os.Looper;
import android.os.Message;
import com.oplus.ocs.base.common.ConnectionResult;

public class d extends com.oplus.ocs.base.common.a {
    public OnConnectionSucceedListener a;
    public OnConnectionFailedListener b;
    public final String c;
    public c d;

    public d(Looper looper, c cVar) {
        super(looper);
        this.c = "d";
        this.d = cVar;
    }

    public void handleMessage(Message message) {
        0zxW.LIZ("d@fed1.handleMessage");
        int i = message.what;
        com.oplus.ocs.base.utils.a.a(this.c, "business handler what ".concat(String.valueOf(i)));
        if (i == 100) {
            OnConnectionSucceedListener onConnectionSucceedListener = this.a;
            if (onConnectionSucceedListener != null) {
                onConnectionSucceedListener.onConnectionSucceed();
            }
            Message messageObtain = Message.obtain();
            messageObtain.what = 5;
            this.d.sendMessage(messageObtain);
            0zxW.LIZIZ("d@fed1.handleMessage");
            return;
        }
        if (i == 101) {
            int i2 = message.arg1;
            OnConnectionFailedListener onConnectionFailedListener = this.b;
            if (onConnectionFailedListener != null) {
                onConnectionFailedListener.onConnectionFailed(new ConnectionResult(i2));
                0zxW.LIZIZ("d@fed1.handleMessage");
                return;
            } else {
                Message messageObtain2 = Message.obtain();
                messageObtain2.what = 5;
                this.d.sendMessage(messageObtain2);
            }
        }
        0zxW.LIZIZ("d@fed1.handleMessage");
    }
}
