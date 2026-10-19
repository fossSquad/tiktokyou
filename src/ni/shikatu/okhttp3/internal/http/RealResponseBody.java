package ni.shikatu.okhttp3.internal.http;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.MediaType;
import ni.shikatu.okhttp3.ResponseBody;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.BufferedSource;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lni/shikatu/okhttp3/internal/http/RealResponseBody;", "Lni/shikatu/okhttp3/ResponseBody;", "contentTypeString", _UrlKt.FRAGMENT_ENCODE_SET, "contentLength", _UrlKt.FRAGMENT_ENCODE_SET, "source", "Lni/shikatu/okio/BufferedSource;", "<init>", "(Ljava/lang/String;JLokio/BufferedSource;)V", "contentType", "Lni/shikatu/okhttp3/MediaType;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class RealResponseBody extends ResponseBody {
    private final long contentLength;
    private final String contentTypeString;
    private final BufferedSource source;

    public RealResponseBody(String contentTypeString, long contentLength, BufferedSource source) {
        Intrinsics.checkNotNullParameter(source, "source");
        this.contentTypeString = contentTypeString;
        this.contentLength = contentLength;
        this.source = source;
    }

    @Override
    public long contentLength() {
        return this.contentLength;
    }

    @Override
    public MediaType contentType() {
        String str = this.contentTypeString;
        if (str != null) {
            return MediaType.Companion.parse(str);
        }
        return null;
    }

    @Override
    public BufferedSource source() {
        return this.source;
    }
}
