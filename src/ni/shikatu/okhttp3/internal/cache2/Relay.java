package ni.shikatu.okhttp3.internal.cache2;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal.concurrent.Lockable;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.ByteString;
import ni.shikatu.okio.Source;
import ni.shikatu.okio.Timeout;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\t\u0018\u0000 <2\u00020\u0001:\u0002;<B5\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u0007¢\u0006\u0004\b\u000b\u0010\fJ \u00103\u001a\u0002042\u0006\u00105\u001a\u00020\t2\u0006\u00106\u001a\u00020\u00072\u0006\u00107\u001a\u00020\u0007H\u0002J\u0010\u00108\u001a\u0002042\u0006\u00106\u001a\u00020\u0007H\u0002J\u000e\u00109\u001a\u0002042\u0006\u00106\u001a\u00020\u0007J\u0006\u0010\b\u001a\u00020\tJ\b\u0010:\u001a\u0004\u0018\u00010\u0005R\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0006\u001a\u00020\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\n\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u001c\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u0011\u0010 \u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\u0011\u0010*\u001a\u00020!¢\u0006\b\n\u0000\u001a\u0004\b+\u0010#R\u001a\u0010,\u001a\u00020-X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010/\"\u0004\b0\u00101R\u0011\u00102\u001a\u00020%8F¢\u0006\u0006\u001a\u0004\b2\u0010'¨\u0006="}, d2 = {"Lni/shikatu/okhttp3/internal/cache2/Relay;", "Lni/shikatu/okhttp3/internal/concurrent/Lockable;", "file", "Ljava/io/RandomAccessFile;", "upstream", "Lni/shikatu/okio/Source;", "upstreamPos", _UrlKt.FRAGMENT_ENCODE_SET, "metadata", "Lni/shikatu/okio/ByteString;", "bufferMaxSize", "<init>", "(Ljava/io/RandomAccessFile;Lokio/Source;JLokio/ByteString;J)V", "getFile", "()Ljava/io/RandomAccessFile;", "setFile", "(Ljava/io/RandomAccessFile;)V", "getUpstream", "()Lokio/Source;", "setUpstream", "(Lokio/Source;)V", "getUpstreamPos", "()J", "setUpstreamPos", "(J)V", "getBufferMaxSize", "upstreamReader", "Ljava/lang/Thread;", "getUpstreamReader", "()Ljava/lang/Thread;", "setUpstreamReader", "(Ljava/lang/Thread;)V", "upstreamBuffer", "Lni/shikatu/okio/Buffer;", "getUpstreamBuffer", "()Lokio/Buffer;", "complete", _UrlKt.FRAGMENT_ENCODE_SET, "getComplete", "()Z", "setComplete", "(Z)V", "buffer", "getBuffer", "sourceCount", _UrlKt.FRAGMENT_ENCODE_SET, "getSourceCount", "()I", "setSourceCount", "(I)V", "isClosed", "writeHeader", _UrlKt.FRAGMENT_ENCODE_SET, "prefix", "upstreamSize", "metadataSize", "writeMetadata", "commit", "newSource", "RelaySource", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Relay implements Lockable {
    private static final long FILE_HEADER_SIZE = 32;
    private static final int SOURCE_FILE = 2;
    private static final int SOURCE_UPSTREAM = 1;
    private final Buffer buffer;
    private final long bufferMaxSize;
    private boolean complete;
    private RandomAccessFile file;
    private final ByteString metadata;
    private int sourceCount;
    private Source upstream;
    private final Buffer upstreamBuffer;
    private long upstreamPos;
    private Thread upstreamReader;
    public static final Companion Companion = new Companion(null);
    public static final ByteString PREFIX_CLEAN = ByteString.Companion.encodeUtf8("OkHttp cache v1\n");
    public static final ByteString PREFIX_DIRTY = ByteString.Companion.encodeUtf8("OkHttp DIRTY :(\n");

    public  Relay(RandomAccessFile randomAccessFile, Source source, long j, ByteString byteString, long j2, DefaultConstructorMarker defaultConstructorMarker) {
        this(randomAccessFile, source, j, byteString, j2);
    }

    private Relay(RandomAccessFile file, Source upstream, long upstreamPos, ByteString metadata, long bufferMaxSize) {
        this.file = file;
        this.upstream = upstream;
        this.upstreamPos = upstreamPos;
        this.metadata = metadata;
        this.bufferMaxSize = bufferMaxSize;
        this.upstreamBuffer = new Buffer();
        this.complete = this.upstream == null;
        this.buffer = new Buffer();
    }

    public final RandomAccessFile getFile() {
        return this.file;
    }

    public final void setFile(RandomAccessFile randomAccessFile) {
        this.file = randomAccessFile;
    }

    public final Source getUpstream() {
        return this.upstream;
    }

    public final void setUpstream(Source source) {
        this.upstream = source;
    }

    public final long getUpstreamPos() {
        return this.upstreamPos;
    }

    public final void setUpstreamPos(long j) {
        this.upstreamPos = j;
    }

    public final long getBufferMaxSize() {
        return this.bufferMaxSize;
    }

    public final Thread getUpstreamReader() {
        return this.upstreamReader;
    }

    public final void setUpstreamReader(Thread thread) {
        this.upstreamReader = thread;
    }

    public final Buffer getUpstreamBuffer() {
        return this.upstreamBuffer;
    }

    public final boolean getComplete() {
        return this.complete;
    }

    public final void setComplete(boolean z) {
        this.complete = z;
    }

    public final Buffer getBuffer() {
        return this.buffer;
    }

    public final int getSourceCount() {
        return this.sourceCount;
    }

    public final void setSourceCount(int i) {
        this.sourceCount = i;
    }

    public final boolean isClosed() {
        return this.file == null;
    }

    public final void writeHeader(ByteString prefix, long upstreamSize, long metadataSize) throws IOException {
        Buffer $this$writeHeader_u24lambda_u240 = new Buffer();
        $this$writeHeader_u24lambda_u240.write(prefix);
        $this$writeHeader_u24lambda_u240.writeLong(upstreamSize);
        $this$writeHeader_u24lambda_u240.writeLong(metadataSize);
        if (!($this$writeHeader_u24lambda_u240.size() == FILE_HEADER_SIZE)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        RandomAccessFile randomAccessFile = this.file;
        Intrinsics.checkNotNull(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        Intrinsics.checkNotNullExpressionValue(channel, "getChannel(...)");
        FileOperator fileOperator = new FileOperator(channel);
        fileOperator.write(0L, $this$writeHeader_u24lambda_u240, FILE_HEADER_SIZE);
    }

    private final void writeMetadata(long upstreamSize) throws IOException {
        Buffer metadataBuffer = new Buffer();
        metadataBuffer.write(this.metadata);
        RandomAccessFile randomAccessFile = this.file;
        Intrinsics.checkNotNull(randomAccessFile);
        FileChannel channel = randomAccessFile.getChannel();
        Intrinsics.checkNotNullExpressionValue(channel, "getChannel(...)");
        FileOperator fileOperator = new FileOperator(channel);
        fileOperator.write(FILE_HEADER_SIZE + upstreamSize, metadataBuffer, this.metadata.size());
    }

    public final void commit(long upstreamSize) throws IOException {
        writeMetadata(upstreamSize);
        RandomAccessFile randomAccessFile = this.file;
        Intrinsics.checkNotNull(randomAccessFile);
        randomAccessFile.getChannel().force(false);
        writeHeader(PREFIX_CLEAN, upstreamSize, this.metadata.size());
        RandomAccessFile randomAccessFile2 = this.file;
        Intrinsics.checkNotNull(randomAccessFile2);
        randomAccessFile2.getChannel().force(false);
        synchronized (this) {
            this.complete = true;
            Unit unit = Unit.INSTANCE;
        }
        Source source = this.upstream;
        if (source != null) {
            _UtilCommonKt.closeQuietly(source);
        }
        this.upstream = null;
    }

    public final ByteString metadata() {
        return this.metadata;
    }

    public final Source newSource() {
        synchronized (this) {
            if (this.file == null) {
                return null;
            }
            this.sourceCount++;
            return new RelaySource();
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lni/shikatu/okhttp3/internal/cache2/Relay$RelaySource;", "Lni/shikatu/okio/Source;", "<init>", "(Lokhttp3/internal/cache2/Relay;)V", "timeout", "Lni/shikatu/okio/Timeout;", "fileOperator", "Lni/shikatu/okhttp3/internal/cache2/FileOperator;", "sourcePos", _UrlKt.FRAGMENT_ENCODE_SET, "read", "sink", "Lni/shikatu/okio/Buffer;", "byteCount", "close", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public final class RelaySource implements Source {
        private FileOperator fileOperator;
        private long sourcePos;
        private final Timeout timeout = new Timeout();

        public RelaySource() {
            RandomAccessFile file = Relay.this.getFile();
            Intrinsics.checkNotNull(file);
            FileChannel channel = file.getChannel();
            Intrinsics.checkNotNullExpressionValue(channel, "getChannel(...)");
            this.fileOperator = new FileOperator(channel);
        }

        @Override
        public long read(Buffer sink, long byteCount) throws IOException {
            Intrinsics.checkNotNullParameter(sink, "sink");
            int i = 1;
            if (!(this.fileOperator != null)) {
                throw new IllegalStateException("Check failed.");
            }
            Relay relay = Relay.this;
            Relay relay2 = Relay.this;
            synchronized (relay) {
                while (true) {
                    long upstreamPos = relay2.getUpstreamPos();
                    if (this.sourcePos != upstreamPos) {
                        long upstreamPos2 = relay2.getUpstreamPos();
                        long bufferPos = upstreamPos2 - relay2.getBuffer().size();
                        if (this.sourcePos < bufferPos) {
                            i = 2;
                            break;
                        }
                        long bytesToRead = Math.min(byteCount, relay2.getUpstreamPos() - this.sourcePos);
                        relay2.getBuffer().copyTo(sink, this.sourcePos - bufferPos, bytesToRead);
                        this.sourcePos += bytesToRead;
                        return bytesToRead;
                    }
                    if (!relay2.getComplete()) {
                        if (relay2.getUpstreamReader() == null) {
                            relay2.setUpstreamReader(Thread.currentThread());
                            break;
                        }
                        this.timeout.waitUntilNotified(relay2);
                    } else {
                        return -1L;
                    }
                }
                int source = i;
                if (source == 2) {
                    long bytesToRead2 = Math.min(byteCount, Relay.this.getUpstreamPos() - this.sourcePos);
                    FileOperator fileOperator = this.fileOperator;
                    Intrinsics.checkNotNull(fileOperator);
                    fileOperator.read(this.sourcePos + Relay.FILE_HEADER_SIZE, sink, bytesToRead2);
                    this.sourcePos += bytesToRead2;
                    return bytesToRead2;
                }
                try {
                    Source upstream = Relay.this.getUpstream();
                    Intrinsics.checkNotNull(upstream);
                    long upstreamBytesRead = upstream.read(Relay.this.getUpstreamBuffer(), Relay.this.getBufferMaxSize());
                    if (upstreamBytesRead == -1) {
                        Relay.this.commit(Relay.this.getUpstreamPos());
                        Relay relay3 = Relay.this;
                        Relay relay4 = Relay.this;
                        synchronized (relay3) {
                            relay4.setUpstreamReader(null);
                            Relay $this$notifyAll$iv = relay4;
                            Intrinsics.checkNotNull($this$notifyAll$iv, "null cannot be cast to non-null type java.lang.Object");
                            $this$notifyAll$iv.notifyAll();
                            Unit unit = Unit.INSTANCE;
                        }
                        return -1L;
                    }
                    long bytesRead = Math.min(upstreamBytesRead, byteCount);
                    Relay.this.getUpstreamBuffer().copyTo(sink, 0L, bytesRead);
                    this.sourcePos += bytesRead;
                    FileOperator fileOperator2 = this.fileOperator;
                    Intrinsics.checkNotNull(fileOperator2);
                    fileOperator2.write(Relay.this.getUpstreamPos() + Relay.FILE_HEADER_SIZE, Relay.this.getUpstreamBuffer().clone(), upstreamBytesRead);
                    Relay relay5 = Relay.this;
                    Relay relay6 = Relay.this;
                    synchronized (relay5) {
                        relay6.getBuffer().write(relay6.getUpstreamBuffer(), upstreamBytesRead);
                        if (relay6.getBuffer().size() > relay6.getBufferMaxSize()) {
                            relay6.getBuffer().skip(relay6.getBuffer().size() - relay6.getBufferMaxSize());
                        }
                        relay6.setUpstreamPos(relay6.getUpstreamPos() + upstreamBytesRead);
                        Unit unit2 = Unit.INSTANCE;
                    }
                    Relay relay7 = Relay.this;
                    Relay relay8 = Relay.this;
                    synchronized (relay7) {
                        relay8.setUpstreamReader(null);
                        Relay $this$notifyAll$iv2 = relay8;
                        Intrinsics.checkNotNull($this$notifyAll$iv2, "null cannot be cast to non-null type java.lang.Object");
                        $this$notifyAll$iv2.notifyAll();
                        Unit unit3 = Unit.INSTANCE;
                    }
                    return bytesRead;
                } catch (Throwable th) {
                    Relay relay9 = Relay.this;
                    Relay relay10 = Relay.this;
                    synchronized (relay9) {
                        relay10.setUpstreamReader(null);
                        Relay $this$notifyAll$iv3 = relay10;
                        Intrinsics.checkNotNull($this$notifyAll$iv3, "null cannot be cast to non-null type java.lang.Object");
                        $this$notifyAll$iv3.notifyAll();
                        Unit unit4 = Unit.INSTANCE;
                        throw th;
                    }
                }
            }
        }

        @Override
        public Timeout timeout() {
            return this.timeout;
        }

        @Override
        public void close() throws IOException {
            if (this.fileOperator == null) {
                return;
            }
            this.fileOperator = null;
            Object fileToClose = null;
            Relay relay = Relay.this;
            Relay relay2 = Relay.this;
            synchronized (relay) {
                relay2.setSourceCount(relay2.getSourceCount() - 1);
                if (relay2.getSourceCount() == 0) {
                    fileToClose = relay2.getFile();
                    relay2.setFile(null);
                }
                Unit unit = Unit.INSTANCE;
            }
            if (fileToClose != null) {
                _UtilCommonKt.closeQuietly((Closeable) fileToClose);
            }
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J&\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u000bJ\u000e\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lni/shikatu/okhttp3/internal/cache2/Relay$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "SOURCE_UPSTREAM", _UrlKt.FRAGMENT_ENCODE_SET, "SOURCE_FILE", "PREFIX_CLEAN", "Lni/shikatu/okio/ByteString;", "PREFIX_DIRTY", "FILE_HEADER_SIZE", _UrlKt.FRAGMENT_ENCODE_SET, "edit", "Lni/shikatu/okhttp3/internal/cache2/Relay;", "file", "Ljava/io/File;", "upstream", "Lni/shikatu/okio/Source;", "metadata", "bufferMaxSize", "read", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Relay edit(File file, Source upstream, ByteString metadata, long bufferMaxSize) throws IOException {
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(upstream, "upstream");
            Intrinsics.checkNotNullParameter(metadata, "metadata");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            Relay result = new Relay(randomAccessFile, upstream, 0L, metadata, bufferMaxSize, null);
            randomAccessFile.setLength(0L);
            result.writeHeader(Relay.PREFIX_DIRTY, -1L, -1L);
            return result;
        }

        public final Relay read(File file) throws IOException {
            Intrinsics.checkNotNullParameter(file, "file");
            RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
            FileChannel channel = randomAccessFile.getChannel();
            Intrinsics.checkNotNullExpressionValue(channel, "getChannel(...)");
            FileOperator fileOperator = new FileOperator(channel);
            Buffer header = new Buffer();
            fileOperator.read(0L, header, Relay.FILE_HEADER_SIZE);
            ByteString prefix = header.readByteString(Relay.PREFIX_CLEAN.size());
            if (!Intrinsics.areEqual(prefix, Relay.PREFIX_CLEAN)) {
                throw new IOException("unreadable cache file");
            }
            long upstreamSize = header.readLong();
            long metadataSize = header.readLong();
            Buffer metadataBuffer = new Buffer();
            fileOperator.read(Relay.FILE_HEADER_SIZE + upstreamSize, metadataBuffer, metadataSize);
            ByteString metadata = metadataBuffer.readByteString();
            return new Relay(randomAccessFile, null, upstreamSize, metadata, 0L, null);
        }
    }
}
