package ni.shikatu.okio.internal;

import java.util.ArrayList;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.io.ConstantsKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Path;
import ni.shikatu.okio.Segment;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b$\n\u0002\u0010!\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B±\u0001\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\b\b\u0002\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u000e\u001a\u00020\t\u0012\b\b\u0002\u0010\u000f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0010\u001a\u00020\r\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\r¢\u0006\u0004\b\u0017\u0010\u0018J-\u00105\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\r2\b\u0010\u0015\u001a\u0004\u0018\u00010\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\rH\u0000¢\u0006\u0004\b6\u00107R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u001bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u001fR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u001fR\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0011\u0010\u000e\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b%\u0010#R\u0011\u0010\u0010\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b&\u0010#R\u0015\u0010\u0011\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010)\u001a\u0004\b'\u0010(R\u0015\u0010\u0012\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010)\u001a\u0004\b*\u0010(R\u0015\u0010\u0013\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010)\u001a\u0004\b+\u0010(R\u0015\u0010\u0014\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001a\u0004\b,\u0010-R\u0015\u0010\u0015\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001a\u0004\b/\u0010-R\u0015\u0010\u0016\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010.\u001a\u0004\b0\u0010-R\u0017\u00101\u001a\b\u0012\u0004\u0012\u00020\u000302¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0016\u00108\u001a\u0004\u0018\u00010\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b9\u0010(R\u0016\u0010:\u001a\u0004\u0018\u00010\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b;\u0010(R\u0016\u0010<\u001a\u0004\u0018\u00010\t8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b=\u0010(¨\u0006>"}, d2 = {"Lni/shikatu/okio/internal/ZipEntry;", _UrlKt.FRAGMENT_ENCODE_SET, "canonicalPath", "Lni/shikatu/okio/Path;", "isDirectory", _UrlKt.FRAGMENT_ENCODE_SET, "comment", _UrlKt.FRAGMENT_ENCODE_SET, "crc", _UrlKt.FRAGMENT_ENCODE_SET, "compressedSize", "size", "compressionMethod", _UrlKt.FRAGMENT_ENCODE_SET, "offset", "dosLastModifiedAtDate", "dosLastModifiedAtTime", "ntfsLastModifiedAtFiletime", "ntfsLastAccessedAtFiletime", "ntfsCreatedAtFiletime", "extendedLastModifiedAtSeconds", "extendedLastAccessedAtSeconds", "extendedCreatedAtSeconds", "<init>", "(Lokio/Path;ZLjava/lang/String;JJJIJIILjava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getCanonicalPath", "()Lokio/Path;", "()Z", "getComment", "()Ljava/lang/String;", "getCrc", "()J", "getCompressedSize", "getSize", "getCompressionMethod", "()I", "getOffset", "getDosLastModifiedAtDate", "getDosLastModifiedAtTime", "getNtfsLastModifiedAtFiletime", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getNtfsLastAccessedAtFiletime", "getNtfsCreatedAtFiletime", "getExtendedLastModifiedAtSeconds", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getExtendedLastAccessedAtSeconds", "getExtendedCreatedAtSeconds", "children", _UrlKt.FRAGMENT_ENCODE_SET, "getChildren", "()Ljava/util/List;", "copy", "copy$okio", "(Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/Integer;)Lokio/internal/ZipEntry;", "lastAccessedAtMillis", "getLastAccessedAtMillis$okio", "lastModifiedAtMillis", "getLastModifiedAtMillis$okio", "createdAtMillis", "getCreatedAtMillis$okio", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ZipEntry {
    private final Path canonicalPath;
    private final List<Path> children;
    private final String comment;
    private final long compressedSize;
    private final int compressionMethod;
    private final long crc;
    private final int dosLastModifiedAtDate;
    private final int dosLastModifiedAtTime;
    private final Integer extendedCreatedAtSeconds;
    private final Integer extendedLastAccessedAtSeconds;
    private final Integer extendedLastModifiedAtSeconds;
    private final boolean isDirectory;
    private final Long ntfsCreatedAtFiletime;
    private final Long ntfsLastAccessedAtFiletime;
    private final Long ntfsLastModifiedAtFiletime;
    private final long offset;
    private final long size;

    public ZipEntry(Path canonicalPath, boolean isDirectory, String comment, long crc, long compressedSize, long size, int compressionMethod, long offset, int dosLastModifiedAtDate, int dosLastModifiedAtTime, Long ntfsLastModifiedAtFiletime, Long ntfsLastAccessedAtFiletime, Long ntfsCreatedAtFiletime, Integer extendedLastModifiedAtSeconds, Integer extendedLastAccessedAtSeconds, Integer extendedCreatedAtSeconds) {
        Intrinsics.checkNotNullParameter(canonicalPath, "canonicalPath");
        Intrinsics.checkNotNullParameter(comment, "comment");
        this.canonicalPath = canonicalPath;
        this.isDirectory = isDirectory;
        this.comment = comment;
        this.crc = crc;
        this.compressedSize = compressedSize;
        this.size = size;
        this.compressionMethod = compressionMethod;
        this.offset = offset;
        this.dosLastModifiedAtDate = dosLastModifiedAtDate;
        this.dosLastModifiedAtTime = dosLastModifiedAtTime;
        this.ntfsLastModifiedAtFiletime = ntfsLastModifiedAtFiletime;
        this.ntfsLastAccessedAtFiletime = ntfsLastAccessedAtFiletime;
        this.ntfsCreatedAtFiletime = ntfsCreatedAtFiletime;
        this.extendedLastModifiedAtSeconds = extendedLastModifiedAtSeconds;
        this.extendedLastAccessedAtSeconds = extendedLastAccessedAtSeconds;
        this.extendedCreatedAtSeconds = extendedCreatedAtSeconds;
        this.children = new ArrayList();
    }

    public  ZipEntry(Path path, boolean z, String str, long j, long j2, long j3, int i, long j4, int i2, int i3, Long l, Long l2, Long l3, Integer num, Integer num2, Integer num3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this(path, (i4 & 2) != 0 ? false : z, (i4 & 4) != 0 ? _UrlKt.FRAGMENT_ENCODE_SET : str, (i4 & 8) != 0 ? -1L : j, (i4 & 16) != 0 ? -1L : j2, (i4 & 32) != 0 ? -1L : j3, (i4 & 64) != 0 ? -1 : i, (i4 & 128) == 0 ? j4 : -1L, (i4 & 256) != 0 ? -1 : i2, (i4 & ConstantsKt.MINIMUM_BLOCK_SIZE) == 0 ? i3 : -1, (i4 & Segment.SHARE_MINIMUM) != 0 ? null : l, (i4 & 2048) != 0 ? null : l2, (i4 & 4096) != 0 ? null : l3, (i4 & 8192) != 0 ? null : num, (i4 & 16384) != 0 ? null : num2, (i4 & 32768) != 0 ? null : num3);
    }

    public final Path getCanonicalPath() {
        return this.canonicalPath;
    }

    public final boolean isDirectory() {
        return this.isDirectory;
    }

    public final String getComment() {
        return this.comment;
    }

    public final long getCrc() {
        return this.crc;
    }

    public final long getCompressedSize() {
        return this.compressedSize;
    }

    public final long getSize() {
        return this.size;
    }

    public final int getCompressionMethod() {
        return this.compressionMethod;
    }

    public final long getOffset() {
        return this.offset;
    }

    public final int getDosLastModifiedAtDate() {
        return this.dosLastModifiedAtDate;
    }

    public final int getDosLastModifiedAtTime() {
        return this.dosLastModifiedAtTime;
    }

    public final Long getNtfsLastModifiedAtFiletime() {
        return this.ntfsLastModifiedAtFiletime;
    }

    public final Long getNtfsLastAccessedAtFiletime() {
        return this.ntfsLastAccessedAtFiletime;
    }

    public final Long getNtfsCreatedAtFiletime() {
        return this.ntfsCreatedAtFiletime;
    }

    public final Integer getExtendedLastModifiedAtSeconds() {
        return this.extendedLastModifiedAtSeconds;
    }

    public final Integer getExtendedLastAccessedAtSeconds() {
        return this.extendedLastAccessedAtSeconds;
    }

    public final Integer getExtendedCreatedAtSeconds() {
        return this.extendedCreatedAtSeconds;
    }

    public final List<Path> getChildren() {
        return this.children;
    }

    public final ZipEntry copy$okio(Integer extendedLastModifiedAtSeconds, Integer extendedLastAccessedAtSeconds, Integer extendedCreatedAtSeconds) {
        return new ZipEntry(this.canonicalPath, this.isDirectory, this.comment, this.crc, this.compressedSize, this.size, this.compressionMethod, this.offset, this.dosLastModifiedAtDate, this.dosLastModifiedAtTime, this.ntfsLastModifiedAtFiletime, this.ntfsLastAccessedAtFiletime, this.ntfsCreatedAtFiletime, extendedLastModifiedAtSeconds, extendedLastAccessedAtSeconds, extendedCreatedAtSeconds);
    }

    public final Long getLastAccessedAtMillis$okio() {
        if (this.ntfsLastAccessedAtFiletime != null) {
            return Long.valueOf(ZipFilesKt.filetimeToEpochMillis(this.ntfsLastAccessedAtFiletime.longValue()));
        }
        if (this.extendedLastAccessedAtSeconds != null) {
            return Long.valueOf(((long) this.extendedLastAccessedAtSeconds.intValue()) * 1000);
        }
        return null;
    }

    public final Long getLastModifiedAtMillis$okio() {
        if (this.ntfsLastModifiedAtFiletime != null) {
            return Long.valueOf(ZipFilesKt.filetimeToEpochMillis(this.ntfsLastModifiedAtFiletime.longValue()));
        }
        if (this.extendedLastModifiedAtSeconds != null) {
            return Long.valueOf(((long) this.extendedLastModifiedAtSeconds.intValue()) * 1000);
        }
        if (this.dosLastModifiedAtTime != -1) {
            return ZipFilesKt.dosDateTimeToEpochMillis(this.dosLastModifiedAtDate, this.dosLastModifiedAtTime);
        }
        return null;
    }

    public final Long getCreatedAtMillis$okio() {
        if (this.ntfsCreatedAtFiletime != null) {
            return Long.valueOf(ZipFilesKt.filetimeToEpochMillis(this.ntfsCreatedAtFiletime.longValue()));
        }
        if (this.extendedCreatedAtSeconds != null) {
            return Long.valueOf(((long) this.extendedCreatedAtSeconds.intValue()) * 1000);
        }
        return null;
    }
}
