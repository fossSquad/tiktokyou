package ni.shikatu.okio;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.OpenOption;
import java.util.Arrays;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Deprecated(message = "changed in Okio 2.x")
@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u0007J\u0010\u0010\b\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J)\u0010\n\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0007¢\u0006\u0002\u0010\u0015J\u0010\u0010\n\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u0019H\u0007J)\u0010\f\u001a\u00020\r2\u0006\u0010\u0010\u001a\u00020\u00112\u0012\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00140\u0013\"\u00020\u0014H\u0007¢\u0006\u0002\u0010\u001aJ\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\b\u0010\u001b\u001a\u00020\u0005H\u0007¨\u0006\u001c"}, d2 = {"Lni/shikatu/okio/-DeprecatedOkio;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "appendingSink", "Lni/shikatu/okio/Sink;", "file", "Ljava/io/File;", "buffer", "Lni/shikatu/okio/BufferedSink;", "sink", "Lni/shikatu/okio/BufferedSource;", "source", "Lni/shikatu/okio/Source;", "outputStream", "Ljava/io/OutputStream;", "path", "Ljava/nio/file/Path;", "options", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "socket", "Ljava/net/Socket;", "inputStream", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "blackhole", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeprecatedOkio {
    public static final DeprecatedOkio INSTANCE = new DeprecatedOkio();

    private DeprecatedOkio() {
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "file.appendingSink()", imports = {"ni.shikatu.okio.appendingSink"}))
    public final Sink appendingSink(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return Okio.appendingSink(file);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "sink.buffer()", imports = {"ni.shikatu.okio.buffer"}))
    public final BufferedSink buffer(Sink sink) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        return Okio.buffer(sink);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "source.buffer()", imports = {"ni.shikatu.okio.buffer"}))
    public final BufferedSource buffer(Source source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return Okio.buffer(source);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "file.sink()", imports = {"ni.shikatu.okio.sink"}))
    public final Sink sink(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return Okio__JvmOkioKt.sink$default(file, false, 1, null);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "outputStream.sink()", imports = {"ni.shikatu.okio.sink"}))
    public final Sink sink(OutputStream outputStream) {
        Intrinsics.checkNotNullParameter(outputStream, "outputStream");
        return Okio.sink(outputStream);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "path.sink(*options)", imports = {"ni.shikatu.okio.sink"}))
    public final Sink sink(java.nio.file.Path path, OpenOption... options) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(options, "options");
        return Okio.sink(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "socket.sink()", imports = {"ni.shikatu.okio.sink"}))
    public final Sink sink(java.net.Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        return Okio.sink(socket);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "file.source()", imports = {"ni.shikatu.okio.source"}))
    public final Source source(File file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return Okio.source(file);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "inputStream.source()", imports = {"ni.shikatu.okio.source"}))
    public final Source source(InputStream inputStream) {
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        return Okio.source(inputStream);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "path.source(*options)", imports = {"ni.shikatu.okio.source"}))
    public final Source source(java.nio.file.Path path, OpenOption... options) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(options, "options");
        return Okio.source(path, (OpenOption[]) Arrays.copyOf(options, options.length));
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "socket.source()", imports = {"ni.shikatu.okio.source"}))
    public final Source source(java.net.Socket socket) {
        Intrinsics.checkNotNullParameter(socket, "socket");
        return Okio.source(socket);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "blackholeSink()", imports = {"ni.shikatu.okio.blackholeSink"}))
    public final Sink blackhole() {
        return Okio.blackhole();
    }
}
