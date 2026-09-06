package ni.shikatu.okhttp3;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.internal.http.HttpHeaders;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.BufferedSource;
import ni.shikatu.okio.Okio;
import ni.shikatu.okio.Source;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u00002\u00020\u0001:\u0001\u0018B\u001b\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\u0015\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u0014J\u0017\u0010\u0015\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u000bH\u0000¢\u0006\u0002\b\u0017R\u001b\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\n\u001a\u00020\u000bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lni/shikatu/okhttp3/CompressionInterceptor;", "Lni/shikatu/okhttp3/Interceptor;", "algorithms", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/CompressionInterceptor$DecompressionAlgorithm;", "<init>", "([Lokhttp3/CompressionInterceptor$DecompressionAlgorithm;)V", "getAlgorithms", "()[Lokhttp3/CompressionInterceptor$DecompressionAlgorithm;", "[Lni/shikatu/okhttp3/CompressionInterceptor$DecompressionAlgorithm;", "acceptEncoding", _UrlKt.FRAGMENT_ENCODE_SET, "getAcceptEncoding$okhttp", "()Ljava/lang/String;", "intercept", "Lni/shikatu/okhttp3/Response;", "chain", "Lni/shikatu/okhttp3/Interceptor$Chain;", "decompress", "response", "decompress$okhttp", "lookupDecompressor", "encoding", "lookupDecompressor$okhttp", "DecompressionAlgorithm", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class CompressionInterceptor implements Interceptor {
    private final String acceptEncoding;
    private final DecompressionAlgorithm[] algorithms;

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lni/shikatu/okhttp3/CompressionInterceptor$DecompressionAlgorithm;", _UrlKt.FRAGMENT_ENCODE_SET, "encoding", _UrlKt.FRAGMENT_ENCODE_SET, "getEncoding", "()Ljava/lang/String;", "decompress", "Lni/shikatu/okio/Source;", "compressedSource", "Lni/shikatu/okio/BufferedSource;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface DecompressionAlgorithm {
        Source decompress(BufferedSource bufferedSource);

        String getEncoding();
    }

    public CompressionInterceptor(DecompressionAlgorithm... algorithms) {
        Intrinsics.checkNotNullParameter(algorithms, "algorithms");
        this.algorithms = algorithms;
        DecompressionAlgorithm[] decompressionAlgorithmArr = this.algorithms;
        Collection destination$iv$iv = new ArrayList(decompressionAlgorithmArr.length);
        for (DecompressionAlgorithm decompressionAlgorithm : decompressionAlgorithmArr) {
            destination$iv$iv.add(decompressionAlgorithm.getEncoding());
        }
        this.acceptEncoding = CollectionsKt.joinToString$default((List) destination$iv$iv, ", ", null, null, 0, null, null, 62, null);
    }

    public final DecompressionAlgorithm[] getAlgorithms() {
        return this.algorithms;
    }

    public final String getAcceptEncoding$okhttp() {
        return this.acceptEncoding;
    }

    @Override
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Intrinsics.checkNotNullParameter(chain, "chain");
        if (!(this.algorithms.length == 0) && chain.request().header("Accept-Encoding") == null) {
            Request request = chain.request().newBuilder().header("Accept-Encoding", this.acceptEncoding).build();
            Response response = chain.proceed(request);
            return decompress$okhttp(response);
        }
        return chain.proceed(chain.request());
    }

    public final Response decompress$okhttp(Response response) {
        DecompressionAlgorithm algorithm;
        Intrinsics.checkNotNullParameter(response, "response");
        if (!HttpHeaders.promisesBody(response)) {
            return response;
        }
        ResponseBody body = response.body();
        String encoding = Response.header$default(response, "Content-Encoding", null, 2, null);
        if (encoding == null || (algorithm = lookupDecompressor$okhttp(encoding)) == null) {
            return response;
        }
        BufferedSource decompressedSource = Okio.buffer(algorithm.decompress(body.source()));
        return response.newBuilder().removeHeader("Content-Encoding").removeHeader("Content-Length").body(ResponseBody.Companion.create(decompressedSource, body.contentType(), -1L)).build();
    }

    public final DecompressionAlgorithm lookupDecompressor$okhttp(String encoding) {
        Intrinsics.checkNotNullParameter(encoding, "encoding");
        for (DecompressionAlgorithm it : this.algorithms) {
            if (StringsKt.equals(it.getEncoding(), encoding, true)) {
                return it;
            }
        }
        return null;
    }
}
