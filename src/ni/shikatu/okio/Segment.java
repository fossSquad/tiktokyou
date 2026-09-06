package ni.shikatu.okio;

import java.util.Arrays;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0000\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B1\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u0002\u0010\fJ\u0006\u0010\u000f\u001a\u00020\u0000J\u0006\u0010\u0010\u001a\u00020\u0000J\b\u0010\u0011\u001a\u0004\u0018\u00010\u0000J\u000e\u0010\u0012\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0000J\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0007J\u0006\u0010\u0016\u001a\u00020\u0017J\u0016\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u000b\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lni/shikatu/okio/Segment;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "data", _UrlKt.FRAGMENT_ENCODE_SET, "pos", _UrlKt.FRAGMENT_ENCODE_SET, "limit", "shared", _UrlKt.FRAGMENT_ENCODE_SET, "owner", "([BIIZZ)V", "next", "prev", "sharedCopy", "unsharedCopy", "pop", "push", "segment", "split", "byteCount", "compact", _UrlKt.FRAGMENT_ENCODE_SET, "writeTo", "sink", "Companion", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Segment {
    public static final Companion Companion = new Companion(null);
    public static final int SHARE_MINIMUM = 1024;
    public static final int SIZE = 8192;
    public final byte[] data;
    public int limit;
    public Segment next;
    public boolean owner;
    public int pos;
    public Segment prev;
    public boolean shared;

    public Segment() {
        this.data = new byte[8192];
        this.owner = true;
        this.shared = false;
    }

    public Segment(byte[] data, int pos, int limit, boolean shared, boolean owner) {
        Intrinsics.checkNotNullParameter(data, "data");
        this.data = data;
        this.pos = pos;
        this.limit = limit;
        this.shared = shared;
        this.owner = owner;
    }

    public final Segment sharedCopy() {
        this.shared = true;
        return new Segment(this.data, this.pos, this.limit, true, false);
    }

    public final Segment unsharedCopy() {
        byte[] bArr = this.data;
        byte[] bArrCopyOf = Arrays.copyOf(bArr, bArr.length);
        Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
        return new Segment(bArrCopyOf, this.pos, this.limit, false, true);
    }

    public final Segment pop() {
        Segment result = this.next != this ? this.next : null;
        Segment segment = this.prev;
        Intrinsics.checkNotNull(segment);
        segment.next = this.next;
        Segment segment2 = this.next;
        Intrinsics.checkNotNull(segment2);
        segment2.prev = this.prev;
        this.next = null;
        this.prev = null;
        return result;
    }

    public final Segment push(Segment segment) {
        Intrinsics.checkNotNullParameter(segment, "segment");
        segment.prev = this;
        segment.next = this.next;
        Segment segment2 = this.next;
        Intrinsics.checkNotNull(segment2);
        segment2.prev = segment;
        this.next = segment;
        return segment;
    }

    public final Segment split(int byteCount) {
        Segment prefix;
        if (!(byteCount > 0 && byteCount <= this.limit - this.pos)) {
            throw new IllegalArgumentException("byteCount out of range".toString());
        }
        if (byteCount >= 1024) {
            prefix = sharedCopy();
        } else {
            prefix = SegmentPool.take();
            ArraysKt.copyInto$default(this.data, prefix.data, 0, this.pos, this.pos + byteCount, 2, (Object) null);
        }
        prefix.limit = prefix.pos + byteCount;
        this.pos += byteCount;
        Segment segment = this.prev;
        Intrinsics.checkNotNull(segment);
        segment.push(prefix);
        return prefix;
    }

    public final void compact() {
        int i = 0;
        if (!(this.prev != this)) {
            throw new IllegalStateException("cannot compact".toString());
        }
        Segment segment = this.prev;
        Intrinsics.checkNotNull(segment);
        if (segment.owner) {
            int byteCount = this.limit - this.pos;
            Segment segment2 = this.prev;
            Intrinsics.checkNotNull(segment2);
            int i2 = 8192 - segment2.limit;
            Segment segment3 = this.prev;
            Intrinsics.checkNotNull(segment3);
            if (!segment3.shared) {
                Segment segment4 = this.prev;
                Intrinsics.checkNotNull(segment4);
                i = segment4.pos;
            }
            int availableByteCount = i2 + i;
            if (byteCount > availableByteCount) {
                return;
            }
            Segment segment5 = this.prev;
            Intrinsics.checkNotNull(segment5);
            writeTo(segment5, byteCount);
            pop();
            SegmentPool.recycle(this);
        }
    }

    public final void writeTo(Segment sink, int byteCount) {
        Intrinsics.checkNotNullParameter(sink, "sink");
        if (!sink.owner) {
            throw new IllegalStateException("only owner can write".toString());
        }
        if (sink.limit + byteCount > 8192) {
            if (sink.shared) {
                throw new IllegalArgumentException();
            }
            if ((sink.limit + byteCount) - sink.pos > 8192) {
                throw new IllegalArgumentException();
            }
            ArraysKt.copyInto$default(sink.data, sink.data, 0, sink.pos, sink.limit, 2, (Object) null);
            sink.limit -= sink.pos;
            sink.pos = 0;
        }
        ArraysKt.copyInto(this.data, sink.data, sink.limit, this.pos, this.pos + byteCount);
        sink.limit += byteCount;
        this.pos += byteCount;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lni/shikatu/okio/Segment$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "SIZE", _UrlKt.FRAGMENT_ENCODE_SET, "SHARE_MINIMUM", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
