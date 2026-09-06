package ni.shikatu.kotlin.io;

import java.io.InputStream;
import java.nio.charset.Charset;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecatedSinceKotlin;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\u0010\f\n\u0002\u0010\u000b\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005H\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\bH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\tH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\nH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\fH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\rH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0018\u0010\u000e\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0005H\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0006H\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0007H\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\bH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\tH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\nH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u000bH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\fH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0016\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\rH\u0087\u0088\u0004b\u0002\b\u0004\u001a\u000e\u0010\u000e\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0004\u001a\u0018\u0010\u000f\u001a\u00020\u0010H\u0087\u0080\u0004b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u001a\u001a\u0010\u0014\u001a\u0004\u0018\u00010\u0010H\u0087\u0080\u0004b\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013\u001a(\u0010\u0015\u001a\u0004\u0018\u00010\u0010H\u0087\u0080\u0004b\f\b\u0016\u0012\b\b\u0002\u0012\u0004\b\b(\u0017b\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a¨\u0006\u001b"}, d2 = {"print", _UrlKt.FRAGMENT_ENCODE_SET, "message", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/internal/InlineOnly;", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "println", "readln", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.6", "readlnOrNull", "readLine", "Lni/shikatu/kotlin/Deprecated;", "Use `readln()` instead of `readLine()!!`, and `readlnOrNull()` instead of `readLine()`.", "Lni/shikatu/kotlin/DeprecatedSinceKotlin;", "warningSince", "2.4", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class ConsoleKt {
    private static final void print(Object message) {
        System.out.print(message);
    }

    private static final void print(int message) {
        System.out.print(message);
    }

    private static final void print(long message) {
        System.out.print(message);
    }

    private static final void print(byte message) {
        System.out.print(Byte.valueOf(message));
    }

    private static final void print(short message) {
        System.out.print(Short.valueOf(message));
    }

    private static final void print(char message) {
        System.out.print(message);
    }

    private static final void print(boolean message) {
        System.out.print(message);
    }

    private static final void print(float message) {
        System.out.print(message);
    }

    private static final void print(double message) {
        System.out.print(message);
    }

    private static final void print(char[] message) {
        Intrinsics.checkNotNullParameter(message, "message");
        System.out.print(message);
    }

    private static final void println(Object message) {
        System.out.println(message);
    }

    private static final void println(int message) {
        System.out.println(message);
    }

    private static final void println(long message) {
        System.out.println(message);
    }

    private static final void println(byte message) {
        System.out.println(Byte.valueOf(message));
    }

    private static final void println(short message) {
        System.out.println(Short.valueOf(message));
    }

    private static final void println(char message) {
        System.out.println(message);
    }

    private static final void println(boolean message) {
        System.out.println(message);
    }

    private static final void println(float message) {
        System.out.println(message);
    }

    private static final void println(double message) {
        System.out.println(message);
    }

    private static final void println(char[] message) {
        Intrinsics.checkNotNullParameter(message, "message");
        System.out.println(message);
    }

    private static final void println() {
        System.out.println();
    }

    public static final String readln() {
        String str = readlnOrNull();
        if (str != null) {
            return str;
        }
        throw new ReadAfterEOFException("EOF has already been reached");
    }

    public static final String readlnOrNull() {
        LineReader lineReader = LineReader.INSTANCE;
        InputStream inputStream = System.in;
        Intrinsics.checkNotNullExpressionValue(inputStream, "in");
        Charset charsetDefaultCharset = Charset.defaultCharset();
        Intrinsics.checkNotNullExpressionValue(charsetDefaultCharset, "defaultCharset(...)");
        return lineReader.readLine(inputStream, charsetDefaultCharset);
    }

    @Deprecated(message = "Use `readln()` instead of `readLine()!!`, and `readlnOrNull()` instead of `readLine()`.")
    @DeprecatedSinceKotlin(warningSince = "2.4")
    public static final String readLine() {
        return readlnOrNull();
    }
}
