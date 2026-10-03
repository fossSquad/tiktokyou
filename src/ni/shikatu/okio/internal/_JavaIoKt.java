package ni.shikatu.okio.internal;

import java.util.logging.Logger;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\"\u0016\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001c\u0010\u0003\u001a\u00020\u0004*\u00060\u0005j\u0002`\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0007¨\u0006\b"}, d2 = {"logger", "Ljava/util/logging/Logger;", "ni.shikatu.kotlin.jvm.PlatformType", "isAndroidGetsocknameError", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/lang/AssertionError;", "Lni/shikatu/kotlin/AssertionError;", "(Ljava/lang/AssertionError;)Z", "ni.shikatu.okio"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class _JavaIoKt {
    private static final Logger logger = Logger.getLogger("ni.shikatu.okio.Okio");

    public static final boolean isAndroidGetsocknameError(AssertionError $this$isAndroidGetsocknameError) {
        Intrinsics.checkNotNullParameter($this$isAndroidGetsocknameError, "<this>");
        if ($this$isAndroidGetsocknameError.getCause() == null) {
            return false;
        }
        String message = $this$isAndroidGetsocknameError.getMessage();
        return message != null ? StringsKt.contains$default((CharSequence) message, (CharSequence) "getsockname failed", false, 2, (Object) null) : false;
    }
}
