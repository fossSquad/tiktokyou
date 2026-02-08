package com.oplus.ocs.base.common.api;

import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.oplus.ocs.base.common.AuthResult;

public interface OplusApiClient {
    <T> void addQueue(TaskListenerHolder<T> taskListenerHolder);

    void connect();

    void disconnect();

    Api getApi();

    AuthResult getAuthResult();

    Looper getLooper();

    IBinder getRemoteService();

    int getRemoteVersion();

    boolean isConnected();

    boolean isConnecting();

    void setOnCapabilityAuthListener(i iVar);

    void setOnClearListener(j jVar);

    void setOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener, Handler handler);

    void setOnConnectionSucceedListener(OnConnectionSucceedListener onConnectionSucceedListener, Handler handler);
}
