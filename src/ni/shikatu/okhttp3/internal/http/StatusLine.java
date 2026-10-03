package ni.shikatu.okhttp3.internal.http;

import java.io.IOException;
import java.net.ProtocolException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.Protocol;
import ni.shikatu.okhttp3.Response;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\n\u001a\u00020\u0007H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lni/shikatu/okhttp3/internal/http/StatusLine;", _UrlKt.FRAGMENT_ENCODE_SET, "protocol", "Lni/shikatu/okhttp3/Protocol;", "code", _UrlKt.FRAGMENT_ENCODE_SET, "message", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lokhttp3/Protocol;ILjava/lang/String;)V", "toString", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class StatusLine {
    public static final Companion Companion = new Companion(null);
    public final int code;
    public final String message;
    public final Protocol protocol;

    public StatusLine(Protocol protocol, int code, String message) {
        Intrinsics.checkNotNullParameter(protocol, "protocol");
        Intrinsics.checkNotNullParameter(message, "message");
        this.protocol = protocol;
        this.code = code;
        this.message = message;
    }

    public String toString() {
        StringBuilder $this$toString_u24lambda_u240 = new StringBuilder();
        if (this.protocol == Protocol.HTTP_1_0) {
            $this$toString_u24lambda_u240.append("HTTP/1.0");
        } else {
            $this$toString_u24lambda_u240.append("HTTP/1.1");
        }
        $this$toString_u24lambda_u240.append(' ').append(this.code);
        $this$toString_u24lambda_u240.append(' ').append(this.message);
        return $this$toString_u24lambda_u240.toString();
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lni/shikatu/okhttp3/internal/http/StatusLine$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "get", "Lni/shikatu/okhttp3/internal/http/StatusLine;", "response", "Lni/shikatu/okhttp3/Response;", "parse", "statusLine", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final StatusLine get(Response response) {
            Intrinsics.checkNotNullParameter(response, "response");
            return new StatusLine(response.protocol(), response.code(), response.message());
        }

        public final StatusLine parse(String statusLine) throws IOException {
            Protocol protocol;
            int codeStart;
            Intrinsics.checkNotNullParameter(statusLine, "statusLine");
            if (StringsKt.startsWith$default(statusLine, "HTTP/1.", false, 2, (Object) null)) {
                if (statusLine.length() < 9 || statusLine.charAt(8) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
                int httpMinorVersion = statusLine.charAt(7) - '0';
                codeStart = 9;
                switch (httpMinorVersion) {
                    case 0:
                        protocol = Protocol.HTTP_1_0;
                        break;
                    case 1:
                        protocol = Protocol.HTTP_1_1;
                        break;
                    default:
                        throw new ProtocolException("Unexpected status line: " + statusLine);
                }
            } else if (StringsKt.startsWith$default(statusLine, "ICY ", false, 2, (Object) null)) {
                protocol = Protocol.HTTP_1_0;
                codeStart = 4;
            } else if (StringsKt.startsWith$default(statusLine, "SOURCETABLE ", false, 2, (Object) null)) {
                protocol = Protocol.HTTP_1_1;
                codeStart = 12;
            } else {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            }
            if (statusLine.length() < codeStart + 3) {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            }
            String strSubstring = statusLine.substring(codeStart, codeStart + 3);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            Integer intOrNull = StringsKt.toIntOrNull(strSubstring);
            if (intOrNull == null) {
                throw new ProtocolException("Unexpected status line: " + statusLine);
            }
            int code = intOrNull.intValue();
            String message = _UrlKt.FRAGMENT_ENCODE_SET;
            if (statusLine.length() > codeStart + 3) {
                if (statusLine.charAt(codeStart + 3) != ' ') {
                    throw new ProtocolException("Unexpected status line: " + statusLine);
                }
                String strSubstring2 = statusLine.substring(codeStart + 4);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                message = strSubstring2;
            }
            return new StatusLine(protocol, code, message);
        }
    }
}
