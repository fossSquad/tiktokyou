package ni.shikatu.okio.internal;

import java.io.IOException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.TypedOptions;

@Metadata(d1 = {"\u0000\u0016\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0005H\u0080\b¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {"commonSelect", "T", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okio/BufferedSource;", "options", "Lni/shikatu/okio/TypedOptions;", "(Lokio/BufferedSource;Lokio/TypedOptions;)Ljava/lang/Object;", "ni.shikatu.okio"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BufferedSource {
    public static final <T> T commonSelect(ni.shikatu.okio.BufferedSource $this$commonSelect, TypedOptions<T> typedOptions) throws IOException {
        Intrinsics.checkNotNullParameter($this$commonSelect, "<this>");
        Intrinsics.checkNotNullParameter(typedOptions, "options");
        int index = $this$commonSelect.select(typedOptions.getOptions$okio());
        if (index == -1) {
            return null;
        }
        return typedOptions.get(index);
    }
}
