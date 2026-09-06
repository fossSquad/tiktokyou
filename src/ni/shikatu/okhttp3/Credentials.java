package ni.shikatu.okhttp3;

import java.nio.charset.Charset;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.JvmStatic;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.Charsets;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.ByteString;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\"\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¨\u0006\n"}, d2 = {"Lni/shikatu/okhttp3/Credentials;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "basic", _UrlKt.FRAGMENT_ENCODE_SET, "username", "password", "charset", "Ljava/nio/charset/Charset;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Credentials {
    public static final Credentials INSTANCE = new Credentials();

    @JvmStatic
    public static final String basic(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "username");
        Intrinsics.checkNotNullParameter(str2, "password");
        return basic$default(str, str2, null, 4, null);
    }

    private Credentials() {
    }

    public static  String basic$default(String str, String str2, Charset charset, int i, Object obj) {
        if ((i & 4) != 0) {
            charset = Charsets.ISO_8859_1;
        }
        return basic(str, str2, charset);
    }

    @JvmStatic
    public static final String basic(String username, String password, Charset charset) {
        Intrinsics.checkNotNullParameter(username, "username");
        Intrinsics.checkNotNullParameter(password, "password");
        Intrinsics.checkNotNullParameter(charset, "charset");
        String usernameAndPassword = username + AbstractJsonLexerKt.COLON + password;
        String encoded = ByteString.Companion.encodeString(usernameAndPassword, charset).base64();
        return "Basic " + encoded;
    }
}
