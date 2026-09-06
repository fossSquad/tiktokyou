package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\b\n\u0000\"\u000f\u0010\u0000\u001a\u00020\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0002"}, d2 = {"MAX_CHARS_IN_POOL", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class ArrayPoolsKt {
    private static final int MAX_CHARS_IN_POOL;

    static {
        Object objM6constructorimpl;
        try {
            Result.Companion companion = Result.Companion;
            String property = System.getProperty("ni.shikatu.kotlinx.serialization.json.pool.size");
            objM6constructorimpl = Result.m6constructorimpl(property != null ? StringsKt.toIntOrNull(property) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.Companion;
            objM6constructorimpl = Result.m6constructorimpl(ResultKt.createFailure(th));
        }
        Integer num = (Integer) (Result.m12isFailureimpl(objM6constructorimpl) ? null : objM6constructorimpl);
        MAX_CHARS_IN_POOL = num != null ? num.intValue() : 2097152;
    }
}
