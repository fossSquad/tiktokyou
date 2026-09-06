package ni.shikatu.okio.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lni/shikatu/okio/internal/EocdRecord;", _UrlKt.FRAGMENT_ENCODE_SET, "entryCount", _UrlKt.FRAGMENT_ENCODE_SET, "centralDirectoryOffset", "commentByteCount", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(JJI)V", "getEntryCount", "()J", "getCentralDirectoryOffset", "getCommentByteCount", "()I", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class EocdRecord {
    private final long centralDirectoryOffset;
    private final int commentByteCount;
    private final long entryCount;

    public EocdRecord(long entryCount, long centralDirectoryOffset, int commentByteCount) {
        this.entryCount = entryCount;
        this.centralDirectoryOffset = centralDirectoryOffset;
        this.commentByteCount = commentByteCount;
    }

    public final long getEntryCount() {
        return this.entryCount;
    }

    public final long getCentralDirectoryOffset() {
        return this.centralDirectoryOffset;
    }

    public final int getCommentByteCount() {
        return this.commentByteCount;
    }
}
