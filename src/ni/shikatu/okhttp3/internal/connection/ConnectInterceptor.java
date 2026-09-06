package ni.shikatu.okhttp3.internal.connection;

import java.io.IOException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.Interceptor;
import ni.shikatu.okhttp3.Response;
import ni.shikatu.okhttp3.internal.http.RealInterceptorChain;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\b"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/ConnectInterceptor;", "Lni/shikatu/okhttp3/Interceptor;", "<init>", "()V", "intercept", "Lni/shikatu/okhttp3/Response;", "chain", "Lni/shikatu/okhttp3/Interceptor$Chain;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ConnectInterceptor implements Interceptor {
    public static final ConnectInterceptor INSTANCE = new ConnectInterceptor();

    private ConnectInterceptor() {
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        RealInterceptorChain realChain = (RealInterceptorChain) chain;
        Exchange exchange = realChain.getCall$okhttp().initExchange$okhttp(realChain);
        RealInterceptorChain connectedChain = RealInterceptorChain.copy$okhttp$default(realChain, 0, exchange, null, 0, 0, 0, 61, null);
        return connectedChain.proceed(realChain.getRequest$okhttp());
    }
}
