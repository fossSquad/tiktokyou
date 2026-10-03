package ni.shikatu.okhttp3.internal.connection;

import java.io.IOException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.Call;
import ni.shikatu.okhttp3.Connection;
import ni.shikatu.okhttp3.Route;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b \u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J$\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\n\u0010\u000b\u001a\u00060\fj\u0002`\rH\u0016J \u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016J\u0018\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0016J\u0018\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0016"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/ConnectionListener;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "connectStart", _UrlKt.FRAGMENT_ENCODE_SET, "route", "Lni/shikatu/okhttp3/Route;", "call", "Lni/shikatu/okhttp3/Call;", "connectFailed", "failure", "Ljava/io/IOException;", "Lni/shikatu/okio/IOException;", "connectEnd", "connection", "Lni/shikatu/okhttp3/Connection;", "connectionClosed", "connectionAcquired", "connectionReleased", "noNewExchanges", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ConnectionListener {
    public static final Companion Companion = new Companion(null);
    private static final ConnectionListener NONE = new ConnectionListener() {
    };

    public void connectStart(Route route, Call call) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void connectFailed(Route route, Call call, IOException failure) {
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(call, "call");
        Intrinsics.checkNotNullParameter(failure, "failure");
    }

    public void connectEnd(Connection connection, Route route, Call call) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(route, "route");
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void connectionClosed(Connection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
    }

    public void connectionAcquired(Connection connection, Call call) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void connectionReleased(Connection connection, Call call) {
        Intrinsics.checkNotNullParameter(connection, "connection");
        Intrinsics.checkNotNullParameter(call, "call");
    }

    public void noNewExchanges(Connection connection) {
        Intrinsics.checkNotNullParameter(connection, "connection");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lni/shikatu/okhttp3/internal/connection/ConnectionListener$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "NONE", "Lni/shikatu/okhttp3/internal/connection/ConnectionListener;", "getNONE", "()Lokhttp3/internal/connection/ConnectionListener;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ConnectionListener getNONE() {
            return ConnectionListener.NONE;
        }
    }
}
