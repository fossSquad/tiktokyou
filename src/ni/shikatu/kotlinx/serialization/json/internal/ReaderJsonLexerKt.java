package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0000\u001a$\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0080\u0080\u0004\"\u000f\u0010\u0000\u001a\u00020\u0001X\u0080Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010\u0002\u001a\u00020\u0001X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"BATCH_SIZE", _UrlKt.FRAGMENT_ENCODE_SET, "DEFAULT_THRESHOLD", "ReaderJsonLexer", "Lni/shikatu/kotlinx/serialization/json/internal/ReaderJsonLexer;", "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "reader", "Lni/shikatu/kotlinx/serialization/json/internal/InternalJsonReader;", "buffer", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ReaderJsonLexerKt {
    public static final int BATCH_SIZE = 16384;
    private static final int DEFAULT_THRESHOLD = 128;

    public static  ReaderJsonLexer ReaderJsonLexer$default(Json json, InternalJsonReader internalJsonReader, char[] cArr, int i, Object obj) {
        if ((i & 4) != 0) {
            cArr = CharArrayPoolBatchSize.INSTANCE.take();
        }
        return ReaderJsonLexer(json, internalJsonReader, cArr);
    }

    public static final ReaderJsonLexer ReaderJsonLexer(Json json, InternalJsonReader reader, char[] buffer) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(reader, "reader");
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        if (!json.getConfiguration().getAllowComments()) {
            return new ReaderJsonLexer(reader, buffer, json.getConfiguration());
        }
        return new ReaderJsonLexerWithComments(reader, buffer, json.getConfiguration());
    }
}
