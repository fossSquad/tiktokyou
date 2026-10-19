package ni.shikatu.okhttp3;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.concurrent.TimeUnit;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.http1.HeadersReader;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.BufferedSource;
import ni.shikatu.okio.ByteString;
import ni.shikatu.okio.Okio;
import ni.shikatu.okio.Options;
import ni.shikatu.okio.Source;
import ni.shikatu.okio.Timeout;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u001f2\u00020\u0001:\u0003\u001d\u001e\u001fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\u0011\b\u0016\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\u0006\u0010\nJ\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\b\u0010\u001b\u001a\u00020\u001cH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0018\u00010\u0015R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lni/shikatu/okhttp3/MultipartReader;", "Ljava/io/Closeable;", "source", "Lni/shikatu/okio/BufferedSource;", "boundary", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lokio/BufferedSource;Ljava/lang/String;)V", "response", "Lni/shikatu/okhttp3/ResponseBody;", "(Lokhttp3/ResponseBody;)V", "()Ljava/lang/String;", "dashDashBoundary", "Lni/shikatu/okio/ByteString;", "crlfDashDashBoundary", "partCount", _UrlKt.FRAGMENT_ENCODE_SET, "closed", _UrlKt.FRAGMENT_ENCODE_SET, "noMoreParts", "currentPart", "Lni/shikatu/okhttp3/MultipartReader$PartSource;", "nextPart", "Lni/shikatu/okhttp3/MultipartReader$Part;", "currentPartBytesRemaining", _UrlKt.FRAGMENT_ENCODE_SET, "maxByteCount", "close", _UrlKt.FRAGMENT_ENCODE_SET, "PartSource", "Part", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MultipartReader implements Closeable {
    public static final Companion Companion = new Companion(null);
    private static final Options afterBoundaryOptions = Options.Companion.of(ByteString.Companion.encodeUtf8("\r\n"), ByteString.Companion.encodeUtf8("--"), ByteString.Companion.encodeUtf8(" "), ByteString.Companion.encodeUtf8("\t"));
    private final String boundary;
    private boolean closed;
    private final ByteString crlfDashDashBoundary;
    private PartSource currentPart;
    private final ByteString dashDashBoundary;
    private boolean noMoreParts;
    private int partCount;
    private final BufferedSource source;

    public MultipartReader(BufferedSource source, String boundary) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(boundary, "boundary");
        this.source = source;
        this.boundary = boundary;
        this.dashDashBoundary = new Buffer().writeUtf8("--").writeUtf8(this.boundary).readByteString();
        this.crlfDashDashBoundary = new Buffer().writeUtf8("\r\n--").writeUtf8(this.boundary).readByteString();
    }

    public final String boundary() {
        return this.boundary;
    }

    public MultipartReader(ResponseBody response) throws IOException {
        String strParameter;
        Intrinsics.checkNotNullParameter(response, "response");
        BufferedSource bufferedSourceSource = response.source();
        MediaType mediaTypeContentType = response.contentType();
        if (mediaTypeContentType != null && (strParameter = mediaTypeContentType.parameter("boundary")) != null) {
            this(bufferedSourceSource, strParameter);
            return;
        }
        throw new ProtocolException("expected the Content-Type to have a boundary parameter");
    }

    public final Part nextPart() throws IOException {
        if (!this.closed) {
            if (!this.noMoreParts) {
                if (this.partCount == 0 && this.source.rangeEquals(0L, this.dashDashBoundary)) {
                    this.source.skip(this.dashDashBoundary.size());
                } else {
                    while (true) {
                        long toSkip = currentPartBytesRemaining(8192L);
                        if (toSkip == 0) {
                            break;
                        }
                        this.source.skip(toSkip);
                    }
                    this.source.skip(this.crlfDashDashBoundary.size());
                }
                boolean whitespace = false;
                while (true) {
                    switch (this.source.select(afterBoundaryOptions)) {
                        case -1:
                            throw new ProtocolException("unexpected characters after boundary");
                        case 0:
                            this.partCount++;
                            Headers headers = new HeadersReader(this.source).readHeaders();
                            PartSource partSource = new PartSource();
                            this.currentPart = partSource;
                            return new Part(headers, Okio.buffer(partSource));
                        case 1:
                            if (whitespace) {
                                throw new ProtocolException("unexpected characters after boundary");
                            }
                            if (this.partCount == 0) {
                                throw new ProtocolException("expected at least 1 part");
                            }
                            this.noMoreParts = true;
                            return null;
                        case 2:
                        case 3:
                            whitespace = true;
                            break;
                    }
                }
            } else {
                return null;
            }
        } else {
            throw new IllegalStateException("closed".toString());
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\tH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lni/shikatu/okhttp3/MultipartReader$PartSource;", "Lni/shikatu/okio/Source;", "<init>", "(Lokhttp3/MultipartReader;)V", "timeout", "Lni/shikatu/okio/Timeout;", "close", _UrlKt.FRAGMENT_ENCODE_SET, "read", _UrlKt.FRAGMENT_ENCODE_SET, "sink", "Lni/shikatu/okio/Buffer;", "byteCount", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private final class PartSource implements Source {
        private final Timeout timeout = new Timeout();

        public PartSource() {
        }

        @Override
        public void close() {
            if (Intrinsics.areEqual(MultipartReader.this.currentPart, this)) {
                MultipartReader.this.currentPart = null;
            }
        }

        @Override
        public long read(Buffer sink, long byteCount) {
            long limit;
            Timeout other$iv;
            Intrinsics.checkNotNullParameter(sink, "sink");
            if (byteCount >= 0) {
                if (!Intrinsics.areEqual(MultipartReader.this.currentPart, this)) {
                    throw new IllegalStateException("closed".toString());
                }
                Timeout this_$iv = MultipartReader.this.source.timeout();
                Timeout other$iv2 = this.timeout;
                MultipartReader multipartReader = MultipartReader.this;
                long originalTimeout$iv = this_$iv.timeoutNanos();
                this_$iv.timeout(Timeout.Companion.minTimeout(other$iv2.timeoutNanos(), this_$iv.timeoutNanos()), TimeUnit.NANOSECONDS);
                if (this_$iv.hasDeadline()) {
                    long originalDeadline$iv = this_$iv.deadlineNanoTime();
                    if (!other$iv2.hasDeadline()) {
                        other$iv = other$iv2;
                    } else {
                        other$iv = other$iv2;
                        this_$iv.deadlineNanoTime(Math.min(this_$iv.deadlineNanoTime(), other$iv.deadlineNanoTime()));
                    }
                    try {
                        long limit2 = multipartReader.currentPartBytesRemaining(byteCount);
                        limit = limit2 == 0 ? -1L : multipartReader.source.read(sink, limit2);
                        this_$iv.timeout(originalTimeout$iv, TimeUnit.NANOSECONDS);
                        if (other$iv.hasDeadline()) {
                            this_$iv.deadlineNanoTime(originalDeadline$iv);
                        }
                    } catch (Throwable th) {
                        this_$iv.timeout(originalTimeout$iv, TimeUnit.NANOSECONDS);
                        if (other$iv.hasDeadline()) {
                            this_$iv.deadlineNanoTime(originalDeadline$iv);
                        }
                        throw th;
                    }
                } else {
                    if (other$iv2.hasDeadline()) {
                        this_$iv.deadlineNanoTime(other$iv2.deadlineNanoTime());
                    }
                    try {
                        long limit3 = multipartReader.currentPartBytesRemaining(byteCount);
                        limit = limit3 == 0 ? -1L : multipartReader.source.read(sink, limit3);
                    } finally {
                        this_$iv.timeout(originalTimeout$iv, TimeUnit.NANOSECONDS);
                        if (other$iv2.hasDeadline()) {
                            this_$iv.clearDeadline();
                        }
                    }
                }
                return limit;
            }
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }

        @Override
        public Timeout timeout() {
            return this.timeout;
        }
    }

    public final long currentPartBytesRemaining(long maxByteCount) throws IOException {
        long toIndex = Math.min(this.source.getBuffer().size(), maxByteCount) + 1;
        long boundaryIndex = this.source.indexOf(this.crlfDashDashBoundary, 0L, toIndex);
        if (boundaryIndex != -1) {
            return boundaryIndex;
        }
        if (this.source.getBuffer().size() >= toIndex) {
            return Math.min(toIndex, maxByteCount);
        }
        throw new EOFException();
    }

    @Override
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.currentPart = null;
        this.source.close();
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\n\u001a\u00020\u000bH\u0096\u0001R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\bR\u0013\u0010\u0004\u001a\u00020\u00058\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\t¨\u0006\f"}, d2 = {"Lni/shikatu/okhttp3/MultipartReader$Part;", "Ljava/io/Closeable;", "headers", "Lni/shikatu/okhttp3/Headers;", "body", "Lni/shikatu/okio/BufferedSource;", "<init>", "(Lokhttp3/Headers;Lokio/BufferedSource;)V", "()Lokhttp3/Headers;", "()Lokio/BufferedSource;", "close", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Part implements Closeable {
        private final BufferedSource body;
        private final Headers headers;

        @Override
        public void close() {
            this.body.close();
        }

        public Part(Headers headers, BufferedSource body) {
            Intrinsics.checkNotNullParameter(headers, "headers");
            Intrinsics.checkNotNullParameter(body, "body");
            this.headers = headers;
            this.body = body;
        }

        public final Headers headers() {
            return this.headers;
        }

        public final BufferedSource body() {
            return this.body;
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lni/shikatu/okhttp3/MultipartReader$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "afterBoundaryOptions", "Lni/shikatu/okio/Options;", "getAfterBoundaryOptions", "()Lokio/Options;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Options getAfterBoundaryOptions() {
            return MultipartReader.afterBoundaryOptions;
        }
    }
}
