package ni.shikatu.okio;

import java.util.zip.Inflater;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\b\u0002\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005H\u0086\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"inflate", "Lni/shikatu/okio/InflaterSource;", "Lni/shikatu/okio/Source;", "inflater", "Ljava/util/zip/Inflater;", "Lni/shikatu/okio/Inflater;", "(Lokio/Source;Ljava/util/zip/Inflater;)Lokio/InflaterSource;", "ni.shikatu.okio"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class InflaterSourceExtensions {
    public static  InflaterSource inflate$default(Source $this$inflate_u24default, Inflater inflater, int i, Object obj) {
        if ((i & 1) != 0) {
            inflater = new Inflater();
        }
        Intrinsics.checkNotNullParameter($this$inflate_u24default, "<this>");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return new InflaterSource($this$inflate_u24default, inflater);
    }

    public static final InflaterSource inflate(Source $this$inflate, Inflater inflater) {
        Intrinsics.checkNotNullParameter($this$inflate, "<this>");
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return new InflaterSource($this$inflate, inflater);
    }
}
