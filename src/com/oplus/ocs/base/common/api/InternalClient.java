package com.oplus.ocs.base.common.api;

import X.0Vx6;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import com.oplus.ocs.base.IAuthenticationListener;

public class InternalClient implements Handler.Callback {
    public static final String TAG = "InternalClient";
    public e mAuthenticateCustomer;
    public String mClient;
    public Context mContext;
    public Handler mHandler;
    public boolean mIsActiveWritePermits;
    public boolean mIsWaitService;
    public IAuthenticationListener mListener;
    public String mPackageName;
    public int mThirdPid;

    public InternalClient(Context context, String str, String str2, int i, boolean z, IAuthenticationListener iAuthenticationListener) {
        this(context, str, str2, i, z, false, iAuthenticationListener);
    }

    public InternalClient(Context context, String str, String str2, int i, boolean z, boolean z2, IAuthenticationListener iAuthenticationListener) {
        this.mContext = 0Vx6.Q(context);
        this.mListener = iAuthenticationListener;
        this.mPackageName = str;
        this.mClient = str2;
        this.mThirdPid = i;
        this.mIsActiveWritePermits = z;
        this.mIsWaitService = z2;
        HandlerThread handlerThread = new HandlerThread("internal");
        handlerThread.start();
        if (handlerThread.getLooper() != null) {
            this.mHandler = new k93.a(handlerThread.getLooper(), this);
        } else {
            this.mHandler = new k93.a(this);
        }
        b.a();
        this.mAuthenticateCustomer = b.a(this.mContext, this, this.mListener);
    }

    public boolean connect() {
        e eVar = this.mAuthenticateCustomer;
        if (eVar != null) {
            return eVar.a();
        }
        return false;
    }

    public boolean connect4Stat() {
        e eVar = this.mAuthenticateCustomer;
        if (eVar != null) {
            return eVar.b();
        }
        return false;
    }

    public Intent getServiceIntent(String str, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.setComponent(new ComponentName(str2, str3));
        intent.putExtra("bind_type", 1);
        intent.putExtra("internal_third_packagename", this.mPackageName);
        intent.putExtra("internal_capability_client", this.mClient);
        intent.putExtra("internal_third_pid", this.mThirdPid);
        intent.putExtra("internal_active_write_permits", this.mIsActiveWritePermits);
        intent.putExtra("internal_base_version", "1.0.11");
        intent.putExtra("internal_wait_service", this.mIsWaitService);
        intent.setType("internal_service_" + this.mClient);
        return intent;
    }

    public Intent getServiceIntent4Stat(String str, String str2, String str3) {
        Intent intent = new Intent(str);
        intent.setComponent(new ComponentName(str2, str3));
        intent.putExtra("bind_type", 2);
        intent.putExtra("internal_third_packagename", this.mPackageName);
        intent.putExtra("internal_capability_client", this.mClient);
        intent.setType("internal_service_" + this.mClient);
        return intent;
    }

    @Override
    public boolean handleMessage(Message message) {
        e eVar;
        com.oplus.ocs.base.utils.a.a(TAG, 0Vx6.m0("current thread - %s and what - %d", new Object[]{0Vx6.x().getName(), Integer.valueOf(message.what)}));
        if (message.what == 1001 && (eVar = this.mAuthenticateCustomer) != null) {
            eVar.c();
        }
        return false;
    }

    public void serviceUnbind() {
        0Vx6.LJJLIIIJLJLI(1001, this.mHandler);
    }
}
