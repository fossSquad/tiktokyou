package com.oplus.ocs.base.common.api;

import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.oplus.ocs.base.common.AuthResult;
import com.oplus.ocs.base.common.api.Api.ApiOptions;
import com.oplus.ocs.base.internal.ClientSettings;

public class Api<O extends ApiOptions> {
    public AbstractClientBuilder<?, O> mClientBuilder;
    public ClientKey<?> mClientKey;
    public boolean mIsAuth;
    public String mName;

    public static abstract class AbstractClientBuilder<T extends Client, O> extends BaseClientBuilder<T, O> {
        public abstract T buildClient(Context context, Looper looper, ClientSettings clientSettings, O o);
    }

    public interface AnyClient {
    }

    public static class AnyClientKey<C extends AnyClient> {
    }

    public interface ApiOptions {

        public interface HasOptions extends ApiOptions {
        }

        public static class NoOptions implements NotRequiredOptions {
        }

        public interface NotRequiredOptions extends ApiOptions {
        }

        public interface Optional extends HasOptions, NotRequiredOptions {
        }
    }

    public static abstract class BaseClientBuilder<T extends AnyClient, O> {
        public int getPriority() {
            return Integer.MAX_VALUE;
        }
    }

    public interface Client extends AnyClient {
        <T> void addQueue(TaskListenerHolder<T> taskListenerHolder);

        void connect();

        void disconnect();

        AuthResult getAuthResult();

        Looper getLooper();

        int getMinApkVersion();

        IBinder getRemoteService();

        boolean isConnected();

        boolean isConnecting();

        void setOnCapabilityAuthListener(i iVar);

        void setOnClearListener(j jVar);

        void setOnConnectionFailedListener(OnConnectionFailedListener onConnectionFailedListener, Handler handler);

        void setOnConnectionSucceedListener(OnConnectionSucceedListener onConnectionSucceedListener, Handler handler);
    }

    public static class ClientKey<C extends Client> extends AnyClientKey<C> {
    }

    public interface SimpleClient<T extends IInterface> extends AnyClient {
        T createServiceInterface(IBinder iBinder);

        Context getContext();

        String getServiceDescriptor();

        String getStartServiceAction();

        void setState(int i, T t);
    }

    public <C extends Client> Api(String str, AbstractClientBuilder<C, O> abstractClientBuilder, ClientKey<C> clientKey) {
        this(str, abstractClientBuilder, clientKey, true);
    }

    public <C extends Client> Api(String str, AbstractClientBuilder<C, O> abstractClientBuilder, ClientKey<C> clientKey, boolean z) {
        com.oplus.ocs.base.utils.d.a(abstractClientBuilder, "can not construct whit the null AbstractClientBuilder");
        com.oplus.ocs.base.utils.d.a(clientKey, "can not construct with the null ClientKey");
        this.mName = str;
        this.mClientBuilder = abstractClientBuilder;
        this.mClientKey = clientKey;
        this.mIsAuth = z;
    }

    public BaseClientBuilder<?, O> getBaseClientBuilder() {
        return this.mClientBuilder;
    }

    public AbstractClientBuilder<?, O> getClientBuilder() {
        com.oplus.ocs.base.utils.d.a(this.mClientBuilder != null, "The ClientBuilder is null");
        return this.mClientBuilder;
    }

    public ClientKey<?> getClientKey() {
        ClientKey<?> clientKey = this.mClientKey;
        if (clientKey != null) {
            return clientKey;
        }
        throw new IllegalStateException("This API was constructed with null clientKey.");
    }

    public String getName() {
        return this.mName;
    }

    public boolean isAuth() {
        return this.mIsAuth;
    }
}
