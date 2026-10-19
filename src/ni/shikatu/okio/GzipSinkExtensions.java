package ni.shikatu.okio;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0086\b¨\u0006\u0003"}, d2 = {"gzip", "Lni/shikatu/okio/GzipSink;", "Lni/shikatu/okio/Sink;", "ni.shikatu.okio"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class GzipSinkExtensions {
    public static final GzipSink gzip(Sink $this$gzip) {
        Intrinsics.checkNotNullParameter($this$gzip, "<this>");
        return new GzipSink($this$gzip);
    }
}
