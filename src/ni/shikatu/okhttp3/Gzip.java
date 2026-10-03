package ni.shikatu.okhttp3;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.BufferedSource;
import ni.shikatu.okio.GzipSource;
import ni.shikatu.okio.Source;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lni/shikatu/okhttp3/Gzip;", "Lni/shikatu/okhttp3/CompressionInterceptor$DecompressionAlgorithm;", "<init>", "()V", "encoding", _UrlKt.FRAGMENT_ENCODE_SET, "getEncoding", "()Ljava/lang/String;", "decompress", "Lni/shikatu/okio/Source;", "compressedSource", "Lni/shikatu/okio/BufferedSource;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Gzip implements CompressionInterceptor.DecompressionAlgorithm {
    public static final Gzip INSTANCE = new Gzip();

    private Gzip() {
    }

    @Override
    public String getEncoding() {
        return "gzip";
    }

    @Override
    public Source decompress(BufferedSource compressedSource) {
        Intrinsics.checkNotNullParameter(compressedSource, "compressedSource");
        return new GzipSource(compressedSource);
    }
}
