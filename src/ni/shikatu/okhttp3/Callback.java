package ni.shikatu.okhttp3;

import java.io.IOException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\fÀ\u0006\u0003"}, d2 = {"Lni/shikatu/okhttp3/Callback;", _UrlKt.FRAGMENT_ENCODE_SET, "onFailure", _UrlKt.FRAGMENT_ENCODE_SET, "call", "Lni/shikatu/okhttp3/Call;", "e", "Ljava/io/IOException;", "Lni/shikatu/okio/IOException;", "onResponse", "response", "Lni/shikatu/okhttp3/Response;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface Callback {
    void onFailure(Call call, IOException iOException);

    void onResponse(Call call, Response response) throws IOException;
}
