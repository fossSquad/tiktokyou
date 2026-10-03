package ni.shikatu.okio;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.OpenOption;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;

@Metadata(d1 = {"ni/shikatu/okio/Okio__JvmOkioKt", "ni/shikatu/okio/Okio__OkioKt", "ni/shikatu/okio/Okio__ZlibOkioKt"}, k = 4, mv = {2, 2, 0}, xi = 48)
public final class Okio {
    public static final Sink appendingSink(File $this$appendingSink) throws FileNotFoundException {
        return Okio__JvmOkioKt.appendingSink($this$appendingSink);
    }

    public static final FileSystem asResourceFileSystem(ClassLoader $this$asResourceFileSystem) {
        return Okio__JvmOkioKt.asResourceFileSystem($this$asResourceFileSystem);
    }

    public static final Sink blackhole() {
        return Okio__OkioKt.blackhole();
    }

    public static final BufferedSink buffer(Sink $this$buffer) {
        return Okio__OkioKt.buffer($this$buffer);
    }

    public static final BufferedSource buffer(Source $this$buffer) {
        return Okio__OkioKt.buffer($this$buffer);
    }

    public static final CipherSink cipherSink(Sink $this$cipherSink, Cipher cipher) {
        return Okio__JvmOkioKt.cipherSink($this$cipherSink, cipher);
    }

    public static final CipherSource cipherSource(Source $this$cipherSource, Cipher cipher) {
        return Okio__JvmOkioKt.cipherSource($this$cipherSource, cipher);
    }

    public static final HashingSink hashingSink(Sink $this$hashingSink, MessageDigest digest) {
        return Okio__JvmOkioKt.hashingSink($this$hashingSink, digest);
    }

    public static final HashingSink hashingSink(Sink $this$hashingSink, Mac mac) {
        return Okio__JvmOkioKt.hashingSink($this$hashingSink, mac);
    }

    public static final HashingSource hashingSource(Source $this$hashingSource, MessageDigest digest) {
        return Okio__JvmOkioKt.hashingSource($this$hashingSource, digest);
    }

    public static final HashingSource hashingSource(Source $this$hashingSource, Mac mac) {
        return Okio__JvmOkioKt.hashingSource($this$hashingSource, mac);
    }

    public static final Socket[] inMemorySocketPair(long maxBufferSize) {
        return Okio__JvmOkioKt.inMemorySocketPair(maxBufferSize);
    }

    public static final FileSystem openZip(FileSystem $this$openZip, Path zipPath) throws IOException {
        return Okio__ZlibOkioKt.openZip($this$openZip, zipPath);
    }

    public static final Sink sink(File $this$sink) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink($this$sink);
    }

    public static final Sink sink(File $this$sink, boolean append) throws FileNotFoundException {
        return Okio__JvmOkioKt.sink($this$sink, append);
    }

    public static final Sink sink(OutputStream $this$sink) {
        return Okio__JvmOkioKt.sink($this$sink);
    }

    public static final Sink sink(java.net.Socket $this$sink) throws IOException {
        return Okio__JvmOkioKt.sink($this$sink);
    }

    public static final Sink sink(java.nio.file.Path $this$sink, OpenOption... options) throws IOException {
        return Okio__JvmOkioKt.sink($this$sink, options);
    }

    public static final Socket socket(java.net.Socket $this$asOkioSocket) {
        return Okio__JvmOkioKt.socket($this$asOkioSocket);
    }

    public static final Source source(File $this$source) throws FileNotFoundException {
        return Okio__JvmOkioKt.source($this$source);
    }

    public static final Source source(InputStream $this$source) {
        return Okio__JvmOkioKt.source($this$source);
    }

    public static final Source source(java.net.Socket $this$source) throws IOException {
        return Okio__JvmOkioKt.source($this$source);
    }

    public static final Source source(java.nio.file.Path $this$source, OpenOption... options) throws IOException {
        return Okio__JvmOkioKt.source($this$source, options);
    }

    public static final <T extends Closeable, R> R use(T t, Function1<? super T, ? extends R> function1) {
        return (R) Okio__OkioKt.use(t, function1);
    }
}
