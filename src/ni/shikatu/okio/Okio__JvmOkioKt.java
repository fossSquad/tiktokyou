package ni.shikatu.okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.internal.DefaultSocket;
import ni.shikatu.okio.internal.PipeSocket;
import ni.shikatu.okio.internal.ResourceFileSystem;
import ni.shikatu.okio.internal.SocketAsyncTimeout;

@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0005\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0006\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u0006\u001a\u0011\u0010\u0007\u001a\u00020\b*\u00020\u0006H\u0007¢\u0006\u0002\b\t\u001a\u0019\u0010\n\u001a\b\u0012\u0004\u0012\u00020\b0\u000b2\u0006\u0010\f\u001a\u00020\r¢\u0006\u0002\u0010\u000e\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007\u001a\n\u0010\u0012\u001a\u00020\u0001*\u00020\u000f\u001a\n\u0010\u0003\u001a\u00020\u0004*\u00020\u000f\u001a#\u0010\u0000\u001a\u00020\u0001*\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u000b\"\u00020\u0015¢\u0006\u0002\u0010\u0016\u001a#\u0010\u0003\u001a\u00020\u0004*\u00020\u00132\u0012\u0010\u0014\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00150\u000b\"\u00020\u0015¢\u0006\u0002\u0010\u0017\u001a\u0012\u0010\u0018\u001a\u00020\u0019*\u00020\u00012\u0006\u0010\u001a\u001a\u00020\u001b\u001a\u0012\u0010\u001c\u001a\u00020\u001d*\u00020\u00042\u0006\u0010\u001a\u001a\u00020\u001b\u001a\u0012\u0010\u001e\u001a\u00020\u001f*\u00020\u00012\u0006\u0010 \u001a\u00020!\u001a\u0012\u0010\"\u001a\u00020#*\u00020\u00042\u0006\u0010 \u001a\u00020!\u001a\u0012\u0010\u001e\u001a\u00020\u001f*\u00020\u00012\u0006\u0010$\u001a\u00020%\u001a\u0012\u0010\"\u001a\u00020#*\u00020\u00042\u0006\u0010$\u001a\u00020%\u001a\n\u0010&\u001a\u00020'*\u00020(¨\u0006)"}, d2 = {"sink", "Lni/shikatu/okio/Sink;", "Ljava/io/OutputStream;", "source", "Lni/shikatu/okio/Source;", "Ljava/io/InputStream;", "Ljava/net/Socket;", "asOkioSocket", "Lni/shikatu/okio/Socket;", "socket", "inMemorySocketPair", _UrlKt.FRAGMENT_ENCODE_SET, "maxBufferSize", _UrlKt.FRAGMENT_ENCODE_SET, "(J)[Lokio/Socket;", "Ljava/io/File;", "append", _UrlKt.FRAGMENT_ENCODE_SET, "appendingSink", "Ljava/nio/file/Path;", "options", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "cipherSink", "Lni/shikatu/okio/CipherSink;", "cipher", "Ljavax/crypto/Cipher;", "cipherSource", "Lni/shikatu/okio/CipherSource;", "hashingSink", "Lni/shikatu/okio/HashingSink;", "mac", "Ljavax/crypto/Mac;", "hashingSource", "Lni/shikatu/okio/HashingSource;", "digest", "Ljava/security/MessageDigest;", "asResourceFileSystem", "Lni/shikatu/okio/FileSystem;", "Ljava/lang/ClassLoader;", "ni.shikatu.okio"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "ni/shikatu/okio/Okio")
final  class Okio__JvmOkioKt {
    public static final Sink sink(File file) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(file, "<this>");
        return sink$default(file, false, 1, null);
    }

    public static final Sink sink(OutputStream $this$sink) {
        Intrinsics.checkNotNullParameter($this$sink, "<this>");
        return new OutputStreamSink($this$sink, new Timeout());
    }

    public static final Source source(InputStream $this$source) {
        Intrinsics.checkNotNullParameter($this$source, "<this>");
        return new InputStreamSource($this$source, new Timeout());
    }

    public static final Sink sink(java.net.Socket $this$sink) throws IOException {
        Intrinsics.checkNotNullParameter($this$sink, "<this>");
        SocketAsyncTimeout timeout = new SocketAsyncTimeout($this$sink);
        OutputStream outputStream = $this$sink.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "getOutputStream(...)");
        OutputStreamSink sink = new OutputStreamSink(outputStream, timeout);
        return timeout.sink(sink);
    }

    public static final Source source(java.net.Socket $this$source) throws IOException {
        Intrinsics.checkNotNullParameter($this$source, "<this>");
        SocketAsyncTimeout timeout = new SocketAsyncTimeout($this$source);
        InputStream inputStream = $this$source.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
        InputStreamSource source = new InputStreamSource(inputStream, timeout);
        return timeout.source(source);
    }

    public static final Socket socket(java.net.Socket $this$asOkioSocket) {
        Intrinsics.checkNotNullParameter($this$asOkioSocket, "<this>");
        return new DefaultSocket($this$asOkioSocket);
    }

    public static final Socket[] inMemorySocketPair(long maxBufferSize) {
        Pipe ab = new Pipe(maxBufferSize);
        Pipe ba = new Pipe(maxBufferSize);
        return new Socket[]{new PipeSocket(ab, ba), new PipeSocket(ba, ab)};
    }

    public static final Sink sink(File $this$sink, boolean append) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter($this$sink, "<this>");
        return Okio.sink(new FileOutputStream($this$sink, append));
    }

    public static  Sink sink$default(File file, boolean z, int i, Object obj) throws FileNotFoundException {
        if ((i & 1) != 0) {
            z = false;
        }
        return Okio.sink(file, z);
    }

    public static final Sink appendingSink(File $this$appendingSink) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter($this$appendingSink, "<this>");
        return Okio.sink(new FileOutputStream($this$appendingSink, true));
    }

    public static final Source source(File $this$source) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter($this$source, "<this>");
        return new InputStreamSource(new FileInputStream($this$source), Timeout.NONE);
    }

    public static final Sink sink(java.nio.file.Path $this$sink, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$sink, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        OutputStream outputStreamNewOutputStream = Files.newOutputStream($this$sink, (OpenOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(outputStreamNewOutputStream, "newOutputStream(...)");
        return Okio.sink(outputStreamNewOutputStream);
    }

    public static final Source source(java.nio.file.Path $this$source, OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$source, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        InputStream inputStreamNewInputStream = Files.newInputStream($this$source, (OpenOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(inputStreamNewInputStream, "newInputStream(...)");
        return Okio.source(inputStreamNewInputStream);
    }

    public static final CipherSink cipherSink(Sink $this$cipherSink, Cipher cipher) {
        Intrinsics.checkNotNullParameter($this$cipherSink, "<this>");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        return new CipherSink(Okio.buffer($this$cipherSink), cipher);
    }

    public static final CipherSource cipherSource(Source $this$cipherSource, Cipher cipher) {
        Intrinsics.checkNotNullParameter($this$cipherSource, "<this>");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        return new CipherSource(Okio.buffer($this$cipherSource), cipher);
    }

    public static final HashingSink hashingSink(Sink $this$hashingSink, Mac mac) {
        Intrinsics.checkNotNullParameter($this$hashingSink, "<this>");
        Intrinsics.checkNotNullParameter(mac, "mac");
        return new HashingSink($this$hashingSink, mac);
    }

    public static final HashingSource hashingSource(Source $this$hashingSource, Mac mac) {
        Intrinsics.checkNotNullParameter($this$hashingSource, "<this>");
        Intrinsics.checkNotNullParameter(mac, "mac");
        return new HashingSource($this$hashingSource, mac);
    }

    public static final HashingSink hashingSink(Sink $this$hashingSink, MessageDigest digest) {
        Intrinsics.checkNotNullParameter($this$hashingSink, "<this>");
        Intrinsics.checkNotNullParameter(digest, "digest");
        return new HashingSink($this$hashingSink, digest);
    }

    public static final HashingSource hashingSource(Source $this$hashingSource, MessageDigest digest) {
        Intrinsics.checkNotNullParameter($this$hashingSource, "<this>");
        Intrinsics.checkNotNullParameter(digest, "digest");
        return new HashingSource($this$hashingSource, digest);
    }

    public static final FileSystem asResourceFileSystem(ClassLoader $this$asResourceFileSystem) {
        Intrinsics.checkNotNullParameter($this$asResourceFileSystem, "<this>");
        return new ResourceFileSystem($this$asResourceFileSystem, true, null, 4, null);
    }
}
