package ni.shikatu.okhttp3.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.Response;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0001¨\u0006\u0002"}, d2 = {"stripBody", "Lni/shikatu/okhttp3/Response;", "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class UnreadableResponseBodyKt {
    public static final Response stripBody(Response $this$stripBody) {
        Intrinsics.checkNotNullParameter($this$stripBody, "<this>");
        return $this$stripBody.newBuilder().body(new UnreadableResponseBody($this$stripBody.body().contentType(), $this$stripBody.body().contentLength())).build();
    }
}
