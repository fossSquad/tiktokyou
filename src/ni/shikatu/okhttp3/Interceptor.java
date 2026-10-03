package ni.shikatu.okhttp3;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u0000 \u00062\u00020\u0001:\u0002\u0006\u0007J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lni/shikatu/okhttp3/Interceptor;", _UrlKt.FRAGMENT_ENCODE_SET, "intercept", "Lni/shikatu/okhttp3/Response;", "chain", "Lni/shikatu/okhttp3/Interceptor$Chain;", "Companion", "Chain", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface Interceptor {
    public static final Companion Companion = ni.shikatu.okhttp3.Interceptor.Companion.$$INSTANCE;

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u0003H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\tH&J\b\u0010\n\u001a\u00020\u000bH&J\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0010\u001a\u00020\u000bH&J\u0018\u0010\u0011\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH&J\b\u0010\u0012\u001a\u00020\u000bH&J\u0018\u0010\u0013\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH&¨\u0006\u0014À\u0006\u0003"}, d2 = {"Lni/shikatu/okhttp3/Interceptor$Chain;", _UrlKt.FRAGMENT_ENCODE_SET, "request", "Lni/shikatu/okhttp3/Request;", "proceed", "Lni/shikatu/okhttp3/Response;", "connection", "Lni/shikatu/okhttp3/Connection;", "call", "Lni/shikatu/okhttp3/Call;", "connectTimeoutMillis", _UrlKt.FRAGMENT_ENCODE_SET, "withConnectTimeout", "timeout", "unit", "Ljava/util/concurrent/TimeUnit;", "readTimeoutMillis", "withReadTimeout", "writeTimeoutMillis", "withWriteTimeout", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface Chain {
        Call call();

        int connectTimeoutMillis();

        Connection connection();

        Response proceed(Request request) throws IOException;

        int readTimeoutMillis();

        Request request();

        Chain withConnectTimeout(int i, TimeUnit timeUnit);

        Chain withReadTimeout(int i, TimeUnit timeUnit);

        Chain withWriteTimeout(int i, TimeUnit timeUnit);

        int writeTimeoutMillis();
    }

    Response intercept(Chain chain) throws IOException;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\u0004\u001a\u00020\u00052#\b\u0004\u0010\u0006\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0007H\u0086\nø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"Lni/shikatu/okhttp3/Interceptor$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "invoke", "Lni/shikatu/okhttp3/Interceptor;", "block", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/okhttp3/Interceptor$Chain;", "Lni/shikatu/kotlin/ParameterName;", "name", "chain", "Lni/shikatu/okhttp3/Response;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final  Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        public final Interceptor invoke(final Function1<? super Chain, Response> function1) {
            Intrinsics.checkNotNullParameter(function1, "block");
            return new Interceptor() {
                @Override
                public final Response intercept(Interceptor.Chain it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return function1.invoke(it);
                }
            };
        }
    }
}
