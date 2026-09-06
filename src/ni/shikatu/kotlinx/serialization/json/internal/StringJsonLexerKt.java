package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u001a\u001a\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0080\u0080\u0004¨\u0006\u0006"}, d2 = {"StringJsonLexer", "Lni/shikatu/kotlinx/serialization/json/internal/StringJsonLexer;", "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "source", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class StringJsonLexerKt {
    public static final StringJsonLexer StringJsonLexer(Json json, String source) {
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(source, "source");
        if (!json.getConfiguration().getAllowComments()) {
            return new StringJsonLexer(source, json.getConfiguration());
        }
        return new StringJsonLexerWithComments(source, json.getConfiguration());
    }
}
