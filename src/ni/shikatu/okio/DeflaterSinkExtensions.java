package ni.shikatu.okio;

import java.util.zip.Deflater;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\b\u0002\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005H\u0086\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"deflate", "Lni/shikatu/okio/DeflaterSink;", "Lni/shikatu/okio/Sink;", "deflater", "Ljava/util/zip/Deflater;", "Lni/shikatu/okio/Deflater;", "(Lokio/Sink;Ljava/util/zip/Deflater;)Lokio/DeflaterSink;", "ni.shikatu.okio"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class DeflaterSinkExtensions {
    public static  DeflaterSink deflate$default(Sink $this$deflate_u24default, Deflater deflater, int i, Object obj) {
        if ((i & 1) != 0) {
            deflater = new Deflater();
        }
        Intrinsics.checkNotNullParameter($this$deflate_u24default, "<this>");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
        return new DeflaterSink($this$deflate_u24default, deflater);
    }

    public static final DeflaterSink deflate(Sink $this$deflate, Deflater deflater) {
        Intrinsics.checkNotNullParameter($this$deflate, "<this>");
        Intrinsics.checkNotNullParameter(deflater, "deflater");
        return new DeflaterSink($this$deflate, deflater);
    }
}
