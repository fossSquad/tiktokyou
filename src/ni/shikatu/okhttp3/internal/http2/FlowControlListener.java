package ni.shikatu.okhttp3.internal.http2;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.http2.flowcontrol.WindowCounter;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\u000bJ \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/FlowControlListener;", _UrlKt.FRAGMENT_ENCODE_SET, "receivingStreamWindowChanged", _UrlKt.FRAGMENT_ENCODE_SET, "streamId", _UrlKt.FRAGMENT_ENCODE_SET, "windowCounter", "Lni/shikatu/okhttp3/internal/http2/flowcontrol/WindowCounter;", "bufferSize", _UrlKt.FRAGMENT_ENCODE_SET, "receivingConnectionWindowChanged", "None", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface FlowControlListener {
    void receivingConnectionWindowChanged(WindowCounter windowCounter);

    void receivingStreamWindowChanged(int i, WindowCounter windowCounter, long j);

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\tH\u0016¨\u0006\r"}, d2 = {"Lni/shikatu/okhttp3/internal/http2/FlowControlListener$None;", "Lni/shikatu/okhttp3/internal/http2/FlowControlListener;", "<init>", "()V", "receivingStreamWindowChanged", _UrlKt.FRAGMENT_ENCODE_SET, "streamId", _UrlKt.FRAGMENT_ENCODE_SET, "windowCounter", "Lni/shikatu/okhttp3/internal/http2/flowcontrol/WindowCounter;", "bufferSize", _UrlKt.FRAGMENT_ENCODE_SET, "receivingConnectionWindowChanged", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class None implements FlowControlListener {
        public static final None INSTANCE = new None();

        private None() {
        }

        @Override
        public void receivingStreamWindowChanged(int streamId, WindowCounter windowCounter, long bufferSize) {
            Intrinsics.checkNotNullParameter(windowCounter, "windowCounter");
        }

        @Override
        public void receivingConnectionWindowChanged(WindowCounter windowCounter) {
            Intrinsics.checkNotNullParameter(windowCounter, "windowCounter");
        }
    }
}
