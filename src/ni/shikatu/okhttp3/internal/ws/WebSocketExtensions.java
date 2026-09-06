package ni.shikatu.okhttp3.internal.ws;

import java.io.IOException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.Headers;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dBG\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0011J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003JN\u0010\u0016\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0003HÆ\u0001¢\u0006\u0002\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u00032\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÖ\u0001J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\u0006\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\fR\u0010\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lni/shikatu/okhttp3/internal/ws/WebSocketExtensions;", _UrlKt.FRAGMENT_ENCODE_SET, "perMessageDeflate", _UrlKt.FRAGMENT_ENCODE_SET, "clientMaxWindowBits", _UrlKt.FRAGMENT_ENCODE_SET, "clientNoContextTakeover", "serverMaxWindowBits", "serverNoContextTakeover", "unknownValues", "<init>", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)V", "Ljava/lang/Integer;", "noContextTakeover", "clientOriginated", "component1", "component2", "()Ljava/lang/Integer;", "component3", "component4", "component5", "component6", "copy", "(ZLjava/lang/Integer;ZLjava/lang/Integer;ZZ)Lokhttp3/internal/ws/WebSocketExtensions;", "equals", "other", "hashCode", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class WebSocketExtensions {
    public static final Companion Companion = new Companion(null);
    private static final String HEADER_WEB_SOCKET_EXTENSION = "Sec-WebSocket-Extensions";
    public final Integer clientMaxWindowBits;
    public final boolean clientNoContextTakeover;
    public final boolean perMessageDeflate;
    public final Integer serverMaxWindowBits;
    public final boolean serverNoContextTakeover;
    public final boolean unknownValues;

    public WebSocketExtensions() {
        this(false, null, false, null, false, false, 63, null);
    }

    public static  WebSocketExtensions copy$default(WebSocketExtensions webSocketExtensions, boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4, int i, Object obj) {
        if ((i & 1) != 0) {
            z = webSocketExtensions.perMessageDeflate;
        }
        if ((i & 2) != 0) {
            num = webSocketExtensions.clientMaxWindowBits;
        }
        if ((i & 4) != 0) {
            z2 = webSocketExtensions.clientNoContextTakeover;
        }
        if ((i & 8) != 0) {
            num2 = webSocketExtensions.serverMaxWindowBits;
        }
        if ((i & 16) != 0) {
            z3 = webSocketExtensions.serverNoContextTakeover;
        }
        if ((i & 32) != 0) {
            z4 = webSocketExtensions.unknownValues;
        }
        boolean z5 = z3;
        boolean z6 = z4;
        return webSocketExtensions.copy(z, num, z2, num2, z5, z6);
    }

    public final boolean component1() {
        return this.perMessageDeflate;
    }

    public final Integer component2() {
        return this.clientMaxWindowBits;
    }

    public final boolean component3() {
        return this.clientNoContextTakeover;
    }

    public final Integer component4() {
        return this.serverMaxWindowBits;
    }

    public final boolean component5() {
        return this.serverNoContextTakeover;
    }

    public final boolean component6() {
        return this.unknownValues;
    }

    public final WebSocketExtensions copy(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4) {
        return new WebSocketExtensions(z, num, z2, num2, z3, z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WebSocketExtensions)) {
            return false;
        }
        WebSocketExtensions webSocketExtensions = (WebSocketExtensions) obj;
        return this.perMessageDeflate == webSocketExtensions.perMessageDeflate && Intrinsics.areEqual(this.clientMaxWindowBits, webSocketExtensions.clientMaxWindowBits) && this.clientNoContextTakeover == webSocketExtensions.clientNoContextTakeover && Intrinsics.areEqual(this.serverMaxWindowBits, webSocketExtensions.serverMaxWindowBits) && this.serverNoContextTakeover == webSocketExtensions.serverNoContextTakeover && this.unknownValues == webSocketExtensions.unknownValues;
    }

    public int hashCode() {
        return (((((((((Boolean.hashCode(this.perMessageDeflate) * 31) + (this.clientMaxWindowBits == null ? 0 : this.clientMaxWindowBits.hashCode())) * 31) + Boolean.hashCode(this.clientNoContextTakeover)) * 31) + (this.serverMaxWindowBits != null ? this.serverMaxWindowBits.hashCode() : 0)) * 31) + Boolean.hashCode(this.serverNoContextTakeover)) * 31) + Boolean.hashCode(this.unknownValues);
    }

    public String toString() {
        return "WebSocketExtensions(perMessageDeflate=" + this.perMessageDeflate + ", clientMaxWindowBits=" + this.clientMaxWindowBits + ", clientNoContextTakeover=" + this.clientNoContextTakeover + ", serverMaxWindowBits=" + this.serverMaxWindowBits + ", serverNoContextTakeover=" + this.serverNoContextTakeover + ", unknownValues=" + this.unknownValues + ')';
    }

    public WebSocketExtensions(boolean perMessageDeflate, Integer clientMaxWindowBits, boolean clientNoContextTakeover, Integer serverMaxWindowBits, boolean serverNoContextTakeover, boolean unknownValues) {
        this.perMessageDeflate = perMessageDeflate;
        this.clientMaxWindowBits = clientMaxWindowBits;
        this.clientNoContextTakeover = clientNoContextTakeover;
        this.serverMaxWindowBits = serverMaxWindowBits;
        this.serverNoContextTakeover = serverNoContextTakeover;
        this.unknownValues = unknownValues;
    }

    public  WebSocketExtensions(boolean z, Integer num, boolean z2, Integer num2, boolean z3, boolean z4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? false : z, (i & 2) != 0 ? null : num, (i & 4) != 0 ? false : z2, (i & 8) != 0 ? null : num2, (i & 16) != 0 ? false : z3, (i & 32) != 0 ? false : z4);
    }

    public final boolean noContextTakeover(boolean clientOriginated) {
        if (clientOriginated) {
            return this.clientNoContextTakeover;
        }
        return this.serverNoContextTakeover;
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lni/shikatu/okhttp3/internal/ws/WebSocketExtensions$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "HEADER_WEB_SOCKET_EXTENSION", _UrlKt.FRAGMENT_ENCODE_SET, "parse", "Lni/shikatu/okhttp3/internal/ws/WebSocketExtensions;", "responseHeaders", "Lni/shikatu/okhttp3/Headers;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final WebSocketExtensions parse(Headers responseHeaders) throws IOException {
            Headers headers = responseHeaders;
            Intrinsics.checkNotNullParameter(headers, "responseHeaders");
            int i = 0;
            int size = headers.size();
            boolean compressionEnabled = false;
            Integer clientMaxWindowBits = null;
            boolean clientNoContextTakeover = false;
            Integer serverMaxWindowBits = null;
            boolean serverNoContextTakeover = false;
            boolean unexpectedValues = false;
            while (i < size) {
                boolean z = true;
                if (StringsKt.equals(headers.name(i), WebSocketExtensions.HEADER_WEB_SOCKET_EXTENSION, true)) {
                    String header = headers.value(i);
                    int pos = 0;
                    while (pos < header.length()) {
                        int pos2 = pos;
                        int extensionEnd = _UtilCommonKt.delimiterOffset$default(header, AbstractJsonLexerKt.COMMA, pos2, 0, 4, (Object) null);
                        String header2 = header;
                        int extensionTokenEnd = _UtilCommonKt.delimiterOffset(header2, ';', pos2, extensionEnd);
                        String extensionToken = _UtilCommonKt.trimSubstring(header2, pos2, extensionTokenEnd);
                        int pos3 = extensionTokenEnd + 1;
                        if (StringsKt.equals(extensionToken, "permessage-deflate", z)) {
                            if (compressionEnabled) {
                                unexpectedValues = true;
                            }
                            compressionEnabled = true;
                            while (pos3 < extensionEnd) {
                                int parameterEnd = _UtilCommonKt.delimiterOffset(header2, ';', pos3, extensionEnd);
                                int equals = _UtilCommonKt.delimiterOffset(header2, '=', pos3, parameterEnd);
                                String name = _UtilCommonKt.trimSubstring(header2, pos3, equals);
                                pos3 = parameterEnd + 1;
                                String value = equals < parameterEnd ? StringsKt.removeSurrounding(_UtilCommonKt.trimSubstring(header2, equals + 1, parameterEnd), (CharSequence) "\"") : null;
                                if (StringsKt.equals(name, "client_max_window_bits", true)) {
                                    if (clientMaxWindowBits != null) {
                                        unexpectedValues = true;
                                    }
                                    clientMaxWindowBits = value != null ? StringsKt.toIntOrNull(value) : null;
                                    if (clientMaxWindowBits == null) {
                                        unexpectedValues = true;
                                    }
                                    z = true;
                                } else if (StringsKt.equals(name, "client_no_context_takeover", true)) {
                                    if (clientNoContextTakeover) {
                                        unexpectedValues = true;
                                    }
                                    if (value != null) {
                                        unexpectedValues = true;
                                    }
                                    clientNoContextTakeover = true;
                                    z = true;
                                } else if (StringsKt.equals(name, "server_max_window_bits", true)) {
                                    if (serverMaxWindowBits != null) {
                                        unexpectedValues = true;
                                    }
                                    serverMaxWindowBits = value != null ? StringsKt.toIntOrNull(value) : null;
                                    if (serverMaxWindowBits == null) {
                                        unexpectedValues = true;
                                    }
                                    z = true;
                                } else if (StringsKt.equals(name, "server_no_context_takeover", true)) {
                                    if (serverNoContextTakeover) {
                                        unexpectedValues = true;
                                    }
                                    if (value != null) {
                                        unexpectedValues = true;
                                    }
                                    serverNoContextTakeover = true;
                                    z = true;
                                } else {
                                    unexpectedValues = true;
                                    z = true;
                                }
                            }
                            pos = pos3;
                            header = header2;
                        } else {
                            unexpectedValues = true;
                            pos = pos3;
                            header = header2;
                        }
                    }
                }
                i++;
                headers = responseHeaders;
            }
            return new WebSocketExtensions(compressionEnabled, clientMaxWindowBits, clientNoContextTakeover, serverMaxWindowBits, serverNoContextTakeover, unexpectedValues);
        }
    }
}
