package ni.shikatu.okio;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0015\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u001f\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000fH\u0016J\b\u0010\u0013\u001a\u00020\u000fH\u0016J\b\u0010\u0014\u001a\u00020\u0001H\u0016J\b\u0010\u0015\u001a\u00020\u0001H\u0016J\u0015\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u000fH\u0010¢\u0006\u0002\b\u0018J\u001d\u0010\u0019\u001a\u00020\u00012\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0001H\u0010¢\u0006\u0002\b\u001bJ\b\u0010\u001c\u001a\u00020\u000fH\u0016J\u001c\u0010\u001d\u001a\u00020\u00012\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u001fH\u0016J\u0015\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u001fH\u0010¢\u0006\u0002\b$J\r\u0010%\u001a\u00020\u001fH\u0010¢\u0006\u0002\b&J\b\u0010'\u001a\u00020\u0004H\u0016J\b\u0010(\u001a\u00020)H\u0016J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020-H\u0016J%\u0010*\u001a\u00020+2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001fH\u0010¢\u0006\u0002\b2J(\u00103\u001a\u0002042\u0006\u00100\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u00012\u0006\u00106\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001fH\u0016J(\u00103\u001a\u0002042\u0006\u00100\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u00042\u0006\u00106\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001fH\u0016J,\u00107\u001a\u00020+2\b\b\u0002\u00100\u001a\u00020\u001f2\u0006\u00108\u001a\u00020\u00042\b\b\u0002\u00109\u001a\u00020\u001f2\u0006\u00101\u001a\u00020\u001fH\u0016J\u001a\u0010:\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u00042\b\b\u0002\u0010;\u001a\u00020\u001fH\u0016J\u001a\u0010<\u001a\u00020\u001f2\u0006\u00105\u001a\u00020\u00042\b\b\u0002\u0010;\u001a\u00020\u001fH\u0016J\b\u0010=\u001a\u00020\u0001H\u0002J\r\u0010>\u001a\u00020\u0004H\u0010¢\u0006\u0002\b?J\u0013\u0010@\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010AH\u0096\u0002J\b\u0010B\u001a\u00020\u001fH\u0016J\b\u0010C\u001a\u00020\u000fH\u0016J\b\u0010D\u001a\u00020EH\u0002R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006F"}, d2 = {"Lni/shikatu/okio/SegmentedByteString;", "Lni/shikatu/okio/ByteString;", "segments", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "directory", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "([[B[I)V", "getSegments$okio", "()[[B", "[[B", "getDirectory$okio", "()[I", "string", _UrlKt.FRAGMENT_ENCODE_SET, "charset", "Ljava/nio/charset/Charset;", "base64", "hex", "toAsciiLowercase", "toAsciiUppercase", "digest", "algorithm", "digest$okio", "hmac", "key", "hmac$okio", "base64Url", "substring", "beginIndex", _UrlKt.FRAGMENT_ENCODE_SET, "endIndex", "internalGet", _UrlKt.FRAGMENT_ENCODE_SET, "pos", "internalGet$okio", "getSize", "getSize$okio", "toByteArray", "asByteBuffer", "Ljava/nio/ByteBuffer;", "write", _UrlKt.FRAGMENT_ENCODE_SET, "out", "Ljava/io/OutputStream;", "buffer", "Lni/shikatu/okio/Buffer;", "offset", "byteCount", "write$okio", "rangeEquals", _UrlKt.FRAGMENT_ENCODE_SET, "other", "otherOffset", "copyInto", "target", "targetOffset", "indexOf", "fromIndex", "lastIndexOf", "toByteString", "internalArray", "internalArray$okio", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "toString", "writeReplace", "Ljava/lang/Object;", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class C0026SegmentedByteString extends ByteString {
    private final transient int[] directory;
    private final transient byte[][] segments;

    public C0026SegmentedByteString(byte[][] segments, int[] directory) {
        super(ByteString.EMPTY.getData$okio());
        Intrinsics.checkNotNullParameter(segments, "segments");
        Intrinsics.checkNotNullParameter(directory, "directory");
        this.segments = segments;
        this.directory = directory;
    }

    public final byte[][] getSegments$okio() {
        return this.segments;
    }

    public final int[] getDirectory$okio() {
        return this.directory;
    }

    @Override
    public String string(Charset charset) {
        Intrinsics.checkNotNullParameter(charset, "charset");
        return toByteString().string(charset);
    }

    @Override
    public String base64() {
        return toByteString().base64();
    }

    @Override
    public String hex() {
        return toByteString().hex();
    }

    @Override
    public ByteString toAsciiLowercase() {
        return toByteString().toAsciiLowercase();
    }

    @Override
    public ByteString toAsciiUppercase() {
        return toByteString().toAsciiUppercase();
    }

    @Override
    public ByteString digest$okio(String algorithm) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        MessageDigest $this$digest_u24lambda_u240 = MessageDigest.getInstance(algorithm);
        int segmentCount$iv = getSegments$okio().length;
        int pos$iv = 0;
        for (int s$iv = 0; s$iv < segmentCount$iv; s$iv++) {
            int segmentPos$iv = getDirectory$okio()[segmentCount$iv + s$iv];
            int nextSegmentOffset$iv = getDirectory$okio()[s$iv];
            byte[] data = getSegments$okio()[s$iv];
            int byteCount = nextSegmentOffset$iv - pos$iv;
            $this$digest_u24lambda_u240.update(data, segmentPos$iv, byteCount);
            pos$iv = nextSegmentOffset$iv;
        }
        byte[] digestBytes = $this$digest_u24lambda_u240.digest();
        Intrinsics.checkNotNull(digestBytes);
        return new ByteString(digestBytes);
    }

    @Override
    public ByteString hmac$okio(String algorithm, ByteString key) throws NoSuchAlgorithmException {
        Intrinsics.checkNotNullParameter(algorithm, "algorithm");
        Intrinsics.checkNotNullParameter(key, "key");
        try {
            Mac mac = Mac.getInstance(algorithm);
            mac.init(new SecretKeySpec(key.toByteArray(), algorithm));
            int segmentCount$iv = getSegments$okio().length;
            int pos$iv = 0;
            for (int s$iv = 0; s$iv < segmentCount$iv; s$iv++) {
                int segmentPos$iv = getDirectory$okio()[segmentCount$iv + s$iv];
                int nextSegmentOffset$iv = getDirectory$okio()[s$iv];
                byte[] data = getSegments$okio()[s$iv];
                int byteCount = nextSegmentOffset$iv - pos$iv;
                mac.update(data, segmentPos$iv, byteCount);
                pos$iv = nextSegmentOffset$iv;
            }
            byte[] bArrDoFinal = mac.doFinal();
            Intrinsics.checkNotNullExpressionValue(bArrDoFinal, "doFinal(...)");
            return new ByteString(bArrDoFinal);
        } catch (InvalidKeyException e) {
            throw new IllegalArgumentException(e);
        }
    }

    @Override
    public String base64Url() {
        return toByteString().base64Url();
    }

    @Override
    public ByteString substring(int beginIndex, int endIndex) {
        int endIndex$iv = SegmentedByteString.resolveDefaultParameter(this, endIndex);
        if (!(beginIndex >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + beginIndex + " < 0").toString());
        }
        if (!(endIndex$iv <= size())) {
            throw new IllegalArgumentException(("endIndex=" + endIndex$iv + " > length(" + size() + ')').toString());
        }
        int subLen$iv = endIndex$iv - beginIndex;
        if (!(subLen$iv >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + endIndex$iv + " < beginIndex=" + beginIndex).toString());
        }
        if (beginIndex == 0 && endIndex$iv == size()) {
            return this;
        }
        if (beginIndex == endIndex$iv) {
            return ByteString.EMPTY;
        }
        int beginSegment$iv = ni.shikatu.okio.internal.SegmentedByteString.segment(this, beginIndex);
        int endSegment$iv = ni.shikatu.okio.internal.SegmentedByteString.segment(this, endIndex$iv - 1);
        byte[][] newSegments$iv = (byte[][]) ArraysKt.copyOfRange(getSegments$okio(), beginSegment$iv, endSegment$iv + 1);
        int[] newDirectory$iv = new int[newSegments$iv.length * 2];
        int index$iv = 0;
        int s$iv = beginSegment$iv;
        if (s$iv <= endSegment$iv) {
            while (true) {
                newDirectory$iv[index$iv] = Math.min(getDirectory$okio()[s$iv] - beginIndex, subLen$iv);
                int index$iv2 = index$iv + 1;
                newDirectory$iv[index$iv + newSegments$iv.length] = getDirectory$okio()[getSegments$okio().length + s$iv];
                if (s$iv == endSegment$iv) {
                    break;
                }
                s$iv++;
                index$iv = index$iv2;
            }
        }
        int segmentOffset$iv = beginSegment$iv != 0 ? getDirectory$okio()[beginSegment$iv - 1] : 0;
        int length = newSegments$iv.length;
        newDirectory$iv[length] = newDirectory$iv[length] + (beginIndex - segmentOffset$iv);
        return new C0026SegmentedByteString(newSegments$iv, newDirectory$iv);
    }

    @Override
    public byte internalGet$okio(int pos) {
        SegmentedByteString.checkOffsetAndCount(getDirectory$okio()[getSegments$okio().length - 1], pos, 1L);
        int segment$iv = ni.shikatu.okio.internal.SegmentedByteString.segment(this, pos);
        int segmentOffset$iv = segment$iv == 0 ? 0 : getDirectory$okio()[segment$iv - 1];
        int segmentPos$iv = getDirectory$okio()[getSegments$okio().length + segment$iv];
        return getSegments$okio()[segment$iv][(pos - segmentOffset$iv) + segmentPos$iv];
    }

    @Override
    public int getSize$okio() {
        return getDirectory$okio()[getSegments$okio().length - 1];
    }

    @Override
    public byte[] toByteArray() {
        byte[] result$iv = new byte[size()];
        int resultPos$iv = 0;
        int segmentCount$iv$iv = getSegments$okio().length;
        int pos$iv$iv = 0;
        for (int s$iv$iv = 0; s$iv$iv < segmentCount$iv$iv; s$iv$iv++) {
            int segmentPos$iv$iv = getDirectory$okio()[segmentCount$iv$iv + s$iv$iv];
            int nextSegmentOffset$iv$iv = getDirectory$okio()[s$iv$iv];
            byte[] data$iv = getSegments$okio()[s$iv$iv];
            int byteCount$iv = nextSegmentOffset$iv$iv - pos$iv$iv;
            ArraysKt.copyInto(data$iv, result$iv, resultPos$iv, segmentPos$iv$iv, segmentPos$iv$iv + byteCount$iv);
            resultPos$iv += byteCount$iv;
            pos$iv$iv = nextSegmentOffset$iv$iv;
        }
        return result$iv;
    }

    @Override
    public ByteBuffer asByteBuffer() {
        ByteBuffer byteBufferAsReadOnlyBuffer = ByteBuffer.wrap(toByteArray()).asReadOnlyBuffer();
        Intrinsics.checkNotNullExpressionValue(byteBufferAsReadOnlyBuffer, "asReadOnlyBuffer(...)");
        return byteBufferAsReadOnlyBuffer;
    }

    @Override
    public void write(OutputStream out) throws IOException {
        Intrinsics.checkNotNullParameter(out, "out");
        int segmentCount$iv = getSegments$okio().length;
        int pos$iv = 0;
        for (int s$iv = 0; s$iv < segmentCount$iv; s$iv++) {
            int segmentPos$iv = getDirectory$okio()[segmentCount$iv + s$iv];
            int nextSegmentOffset$iv = getDirectory$okio()[s$iv];
            byte[] data = getSegments$okio()[s$iv];
            int byteCount = nextSegmentOffset$iv - pos$iv;
            out.write(data, segmentPos$iv, byteCount);
            pos$iv = nextSegmentOffset$iv;
        }
    }

    @Override
    public void write$okio(Buffer buffer, int offset, int byteCount) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        int offset$iv = offset;
        int endIndex$iv$iv = offset$iv + byteCount;
        int s$iv$iv = ni.shikatu.okio.internal.SegmentedByteString.segment(this, offset$iv);
        int pos$iv$iv = offset$iv;
        while (pos$iv$iv < endIndex$iv$iv) {
            int segmentOffset$iv$iv = s$iv$iv == 0 ? 0 : getDirectory$okio()[s$iv$iv - 1];
            int segmentSize$iv$iv = getDirectory$okio()[s$iv$iv] - segmentOffset$iv$iv;
            int segmentPos$iv$iv = getDirectory$okio()[getSegments$okio().length + s$iv$iv];
            int byteCount$iv$iv = Math.min(endIndex$iv$iv, segmentOffset$iv$iv + segmentSize$iv$iv) - pos$iv$iv;
            int offset$iv$iv = segmentPos$iv$iv + (pos$iv$iv - segmentOffset$iv$iv);
            byte[] data$iv = getSegments$okio()[s$iv$iv];
            Segment segment$iv = new Segment(data$iv, offset$iv$iv, offset$iv$iv + byteCount$iv$iv, true, false);
            if (buffer.head == null) {
                segment$iv.prev = segment$iv;
                segment$iv.next = segment$iv.prev;
                buffer.head = segment$iv.next;
            } else {
                Segment segment = buffer.head;
                Intrinsics.checkNotNull(segment);
                Segment segment2 = segment.prev;
                Intrinsics.checkNotNull(segment2);
                segment2.push(segment$iv);
            }
            pos$iv$iv += byteCount$iv$iv;
            s$iv$iv++;
            offset$iv = offset$iv;
        }
        buffer.setSize$okio(buffer.size() + ((long) byteCount));
    }

    @Override
    public boolean rangeEquals(int offset, ByteString other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        int byteCount$iv = byteCount;
        int offset$iv = offset;
        if (offset$iv < 0 || offset$iv > size() - byteCount$iv) {
            return false;
        }
        int endIndex$iv$iv = offset$iv + byteCount$iv;
        int s$iv$iv = ni.shikatu.okio.internal.SegmentedByteString.segment(this, offset$iv);
        int pos$iv$iv = offset$iv;
        int otherOffset$iv = otherOffset;
        while (pos$iv$iv < endIndex$iv$iv) {
            int segmentOffset$iv$iv = s$iv$iv == 0 ? 0 : getDirectory$okio()[s$iv$iv - 1];
            int segmentSize$iv$iv = getDirectory$okio()[s$iv$iv] - segmentOffset$iv$iv;
            int segmentPos$iv$iv = getDirectory$okio()[getSegments$okio().length + s$iv$iv];
            int byteCount$iv2 = byteCount$iv;
            int byteCount$iv$iv = Math.min(endIndex$iv$iv, segmentOffset$iv$iv + segmentSize$iv$iv) - pos$iv$iv;
            int offset$iv$iv = segmentPos$iv$iv + (pos$iv$iv - segmentOffset$iv$iv);
            byte[] data$iv = getSegments$okio()[s$iv$iv];
            int offset$iv2 = offset$iv;
            if (!other.rangeEquals(otherOffset$iv, data$iv, offset$iv$iv, byteCount$iv$iv)) {
                return false;
            }
            otherOffset$iv += byteCount$iv$iv;
            pos$iv$iv += byteCount$iv$iv;
            s$iv$iv++;
            byteCount$iv = byteCount$iv2;
            offset$iv = offset$iv2;
        }
        return true;
    }

    @Override
    public boolean rangeEquals(int offset, byte[] other, int otherOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(other, "other");
        int byteCount$iv = byteCount;
        int offset$iv = offset;
        if (offset$iv < 0 || offset$iv > size() - byteCount$iv || otherOffset < 0 || otherOffset > other.length - byteCount$iv) {
            return false;
        }
        int endIndex$iv$iv = offset$iv + byteCount$iv;
        int s$iv$iv = ni.shikatu.okio.internal.SegmentedByteString.segment(this, offset$iv);
        int pos$iv$iv = offset$iv;
        int otherOffset$iv = otherOffset;
        while (pos$iv$iv < endIndex$iv$iv) {
            int segmentOffset$iv$iv = s$iv$iv == 0 ? 0 : getDirectory$okio()[s$iv$iv - 1];
            int segmentSize$iv$iv = getDirectory$okio()[s$iv$iv] - segmentOffset$iv$iv;
            int segmentPos$iv$iv = getDirectory$okio()[getSegments$okio().length + s$iv$iv];
            int byteCount$iv2 = byteCount$iv;
            int byteCount$iv$iv = Math.min(endIndex$iv$iv, segmentOffset$iv$iv + segmentSize$iv$iv) - pos$iv$iv;
            int offset$iv$iv = segmentPos$iv$iv + (pos$iv$iv - segmentOffset$iv$iv);
            byte[] data$iv = getSegments$okio()[s$iv$iv];
            int offset$iv2 = offset$iv;
            if (!SegmentedByteString.arrayRangeEquals(data$iv, offset$iv$iv, other, otherOffset$iv, byteCount$iv$iv)) {
                return false;
            }
            otherOffset$iv += byteCount$iv$iv;
            pos$iv$iv += byteCount$iv$iv;
            s$iv$iv++;
            byteCount$iv = byteCount$iv2;
            offset$iv = offset$iv2;
        }
        return true;
    }

    @Override
    public void copyInto(int offset, byte[] target, int targetOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(target, "target");
        int byteCount$iv = byteCount;
        int offset$iv = offset;
        SegmentedByteString.checkOffsetAndCount(size(), offset$iv, byteCount$iv);
        SegmentedByteString.checkOffsetAndCount(target.length, targetOffset, byteCount$iv);
        int endIndex$iv$iv = offset$iv + byteCount$iv;
        int s$iv$iv = ni.shikatu.okio.internal.SegmentedByteString.segment(this, offset$iv);
        int pos$iv$iv = offset$iv;
        int targetOffset$iv = targetOffset;
        while (pos$iv$iv < endIndex$iv$iv) {
            int segmentOffset$iv$iv = s$iv$iv == 0 ? 0 : getDirectory$okio()[s$iv$iv - 1];
            int segmentSize$iv$iv = getDirectory$okio()[s$iv$iv] - segmentOffset$iv$iv;
            int byteCount$iv2 = byteCount$iv;
            int segmentPos$iv$iv = getDirectory$okio()[getSegments$okio().length + s$iv$iv];
            int segmentPos$iv$iv2 = segmentOffset$iv$iv + segmentSize$iv$iv;
            int byteCount$iv$iv = Math.min(endIndex$iv$iv, segmentPos$iv$iv2) - pos$iv$iv;
            int offset$iv$iv = segmentPos$iv$iv + (pos$iv$iv - segmentOffset$iv$iv);
            byte[] data$iv = getSegments$okio()[s$iv$iv];
            ArraysKt.copyInto(data$iv, target, targetOffset$iv, offset$iv$iv, offset$iv$iv + byteCount$iv$iv);
            targetOffset$iv += byteCount$iv$iv;
            pos$iv$iv += byteCount$iv$iv;
            s$iv$iv++;
            byteCount$iv = byteCount$iv2;
            offset$iv = offset$iv;
        }
    }

    @Override
    public int indexOf(byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        return toByteString().indexOf(other, fromIndex);
    }

    @Override
    public int lastIndexOf(byte[] other, int fromIndex) {
        Intrinsics.checkNotNullParameter(other, "other");
        return toByteString().lastIndexOf(other, fromIndex);
    }

    private final ByteString toByteString() {
        return new ByteString(toByteArray());
    }

    @Override
    public byte[] internalArray$okio() {
        return toByteArray();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (other instanceof ByteString) {
            return ((ByteString) other).size() == size() && rangeEquals(0, (ByteString) other, 0, size());
        }
        return false;
    }

    @Override
    public int hashCode() {
        int result$iv = getHashCode$okio();
        if (result$iv == 0) {
            result$iv = 1;
            int segmentCount$iv$iv = getSegments$okio().length;
            int pos$iv$iv = 0;
            for (int s$iv$iv = 0; s$iv$iv < segmentCount$iv$iv; s$iv$iv++) {
                int segmentPos$iv$iv = getDirectory$okio()[segmentCount$iv$iv + s$iv$iv];
                int nextSegmentOffset$iv$iv = getDirectory$okio()[s$iv$iv];
                byte[] data$iv = getSegments$okio()[s$iv$iv];
                int byteCount$iv = nextSegmentOffset$iv$iv - pos$iv$iv;
                int limit$iv = segmentPos$iv$iv + byteCount$iv;
                for (int i$iv = segmentPos$iv$iv; i$iv < limit$iv; i$iv++) {
                    result$iv = (result$iv * 31) + data$iv[i$iv];
                }
                pos$iv$iv = nextSegmentOffset$iv$iv;
            }
            setHashCode$okio(result$iv);
        }
        return result$iv;
    }

    @Override
    public String toString() {
        return toByteString().toString();
    }

    private final Object writeReplace() {
        ByteString byteString = toByteString();
        Intrinsics.checkNotNull(byteString, "null cannot be cast to non-null type java.lang.Object");
        return byteString;
    }
}
