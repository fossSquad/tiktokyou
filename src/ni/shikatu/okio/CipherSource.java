package ni.shikatu.okio;

import java.io.IOException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.ShortBufferException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0012H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0002J\b\u0010\u0017\u001a\u00020\u0016H\u0002J\b\u0010\u0018\u001a\u00020\u0016H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lni/shikatu/okio/CipherSource;", "Lni/shikatu/okio/Source;", "source", "Lni/shikatu/okio/BufferedSource;", "cipher", "Ljavax/crypto/Cipher;", "<init>", "(Lokio/BufferedSource;Ljavax/crypto/Cipher;)V", "getCipher", "()Ljavax/crypto/Cipher;", "blockSize", _UrlKt.FRAGMENT_ENCODE_SET, "buffer", "Lni/shikatu/okio/Buffer;", "final", _UrlKt.FRAGMENT_ENCODE_SET, "closed", "read", _UrlKt.FRAGMENT_ENCODE_SET, "sink", "byteCount", "refill", _UrlKt.FRAGMENT_ENCODE_SET, "update", "doFinal", "timeout", "Lni/shikatu/okio/Timeout;", "close", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CipherSource implements Source {
    private final int blockSize;
    private final Buffer buffer;
    private final Cipher cipher;
    private boolean closed;

    private boolean f4final;
    private final BufferedSource source;

    public CipherSource(BufferedSource source, Cipher cipher) {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        this.source = source;
        this.cipher = cipher;
        this.blockSize = this.cipher.getBlockSize();
        this.buffer = new Buffer();
        if (this.blockSize > 0) {
        } else {
            throw new IllegalArgumentException(("Block cipher required " + this.cipher).toString());
        }
    }

    public final Cipher getCipher() {
        return this.cipher;
    }

    @Override
    public long read(Buffer sink, long byteCount) throws BadPaddingException, IllegalBlockSizeException, IOException, ShortBufferException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!(byteCount >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + byteCount).toString());
        }
        if (this.closed) {
            throw new IllegalStateException("closed".toString());
        }
        if (byteCount == 0) {
            return 0L;
        }
        refill();
        return this.buffer.read(sink, byteCount);
    }

    private final void refill() throws BadPaddingException, IllegalBlockSizeException, IOException, ShortBufferException {
        while (this.buffer.size() == 0 && !this.f4final) {
            if (this.source.exhausted()) {
                this.f4final = true;
                doFinal();
                return;
            }
            update();
        }
    }

    private final void update() throws BadPaddingException, IllegalBlockSizeException, IOException, ShortBufferException {
        Segment head = this.source.getBuffer().head;
        Intrinsics.checkNotNull(head);
        int size = head.limit - head.pos;
        int outputSize = this.cipher.getOutputSize(size);
        int size2 = size;
        while (outputSize > 8192) {
            if (size2 <= this.blockSize) {
                this.f4final = true;
                Buffer buffer = this.buffer;
                byte[] bArrDoFinal = this.cipher.doFinal(this.source.readByteArray());
                Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
                buffer.write(bArrDoFinal);
                return;
            }
            size2 -= this.blockSize;
            outputSize = this.cipher.getOutputSize(size2);
        }
        Segment s = this.buffer.writableSegment$okio(outputSize);
        int ciphered = this.cipher.update(head.data, head.pos, size2, s.data, s.pos);
        this.source.skip(size2);
        s.limit += ciphered;
        Buffer buffer2 = this.buffer;
        buffer2.setSize$okio(buffer2.size() + ((long) ciphered));
        if (s.pos == s.limit) {
            this.buffer.head = s.pop();
            SegmentPool.recycle(s);
        }
    }

    private final void doFinal() throws BadPaddingException, IllegalBlockSizeException, ShortBufferException {
        int outputSize = this.cipher.getOutputSize(0);
        if (outputSize == 0) {
            return;
        }
        Segment s = this.buffer.writableSegment$okio(outputSize);
        int ciphered = this.cipher.doFinal(s.data, s.pos);
        s.limit += ciphered;
        Buffer buffer = this.buffer;
        buffer.setSize$okio(buffer.size() + ((long) ciphered));
        if (s.pos == s.limit) {
            this.buffer.head = s.pop();
            SegmentPool.recycle(s);
        }
    }

    @Override
    public Timeout timeout() {
        return this.source.timeout();
    }

    @Override
    public void close() throws IOException {
        this.closed = true;
        this.source.close();
    }
}
