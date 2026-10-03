package ni.shikatu.kotlinx.serialization.encoding;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J-\u0010\u0002\u001a\u00020\u00032!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00030\u0005H§\u0080\u0004¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lni/shikatu/kotlinx/serialization/encoding/ChunkedDecoder;", _UrlKt.FRAGMENT_ENCODE_SET, "decodeStringChunked", _UrlKt.FRAGMENT_ENCODE_SET, "consumeChunk", "Lni/shikatu/kotlin/Function1;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ParameterName;", "name", "chunk", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ExperimentalSerializationApi
public interface ChunkedDecoder {
    @ExperimentalSerializationApi
    void decodeStringChunked(Function1<? super String, Unit> function1);
}
