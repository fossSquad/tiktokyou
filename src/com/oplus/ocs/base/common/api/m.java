package com.oplus.ocs.base.common.api;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import com.oplus.ocs.base.common.AuthResult;
import com.oplus.ocs.base.internal.ClientSettings;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class m implements OplusApiClient {
    public static final String a = "m";
    public Lock b = new ReentrantLock();
    public Api c;
    public Api.Client d;

    public m(Context context, Api api, Api.ApiOptions apiOptions, ClientSettings clientSettings) {
        this.c = api;
        this.d = api.getClientBuilder().buildClient(context, Looper.getMainLooper(), clientSettings, apiOptions);
    }

    @Override
    public <T> void addQueue(TaskListenerHolder<T> taskListenerHolder) {
        Api.Client client = this.d;
        if (client != null) {
            client.addQueue(taskListenerHolder);
        }
    }

    @Override
    public void connect() {
        this.b.lock();
        try {
            Api.Client client = this.d;
            if (client != null) {
                client.connect();
            }
        } catch (Exception unused) {
        } finally {
            this.b.unlock();
        }
    }

    @Override
    public void disconnect() {
        this.b.lock();
        try {
            Api.Client client = this.d;
            if (client != null && client.isConnected()) {
                this.d.disconnect();
            }
        } catch (Exception unused) {
        } finally {
            this.b.unlock();
        }
    }

    @Override
    public Api getApi() {
        return this.c;
    }

    @Override
    public AuthResult getAuthResult() {
        Api.Client client = this.d;
        if (client != null) {
            return client.getAuthResult();
        }
        return null;
    }

    @Override
    public Looper getLooper() {
        Api.Client client = this.d;
        if (client != null) {
            return client.getLooper();
        }
        return null;
    }

    @Override
    public IBinder getRemoteService() {
        Api.Client client = this.d;
        if (client != null) {
            return client.getRemoteService();
        }
        return null;
    }

    @Override
    public int getRemoteVersion() {
        Api.Client client = this.d;
        if (client != null) {
            return client.getMinApkVersion();
        }
        return 0;
    }

    @Override
    public boolean isConnected() {
        Api.Client client = this.d;
        if (client != null) {
            return client.isConnected();
        }
        return false;
    }

    @Override
    public boolean isConnecting() {
        Api.Client client = this.d;
        if (client != null) {
            return client.isConnecting();
        }
        return false;
    }

    @Override
    public void setOnCapabilityAuthListener(i iVar) {
        Api.Client client = this.d;
        if (client != null) {
            client.setOnCapabilityAuthListener(iVar);
        }
    }

    @Override
    public void setOnClearListener(j jVar) {
        Api.Client client = this.d;
        if (client != null) {
            client.setOnClearListener(jVar);
        }
    }

    @Override
    public void setOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener, Handler handler) {
        Api.Client client = this.d;
        if (client != null) {
            client.setOnConnectionFailedListener(onConnectionFailedListener, handler);
        }
    }

    @Override
    public void setOnConnectionSucceedListener(OnConnectionSucceedListener onConnectionSucceedListener, Handler handler) {
        Api.Client client = this.d;
        if (client != null) {
            client.setOnConnectionSucceedListener(onConnectionSucceedListener, handler);
        }
    }
}
