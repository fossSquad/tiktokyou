package ni.shikatu.okhttp3.internal.idn;

import java.io.IOException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.BufferedSink;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J \u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u000fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lni/shikatu/okhttp3/internal/idn/IdnaMappingTable;", _UrlKt.FRAGMENT_ENCODE_SET, "sections", _UrlKt.FRAGMENT_ENCODE_SET, "ranges", "mappings", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getSections", "()Ljava/lang/String;", "getRanges", "getMappings", "map", _UrlKt.FRAGMENT_ENCODE_SET, "codePoint", _UrlKt.FRAGMENT_ENCODE_SET, "sink", "Lni/shikatu/okio/BufferedSink;", "findSectionsIndex", "findRangesOffset", "position", "limit", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class IdnaMappingTable {
    private final String mappings;
    private final String ranges;
    private final String sections;

    public IdnaMappingTable(String sections, String ranges, String mappings) {
        Intrinsics.checkNotNullParameter(sections, "sections");
        Intrinsics.checkNotNullParameter(ranges, "ranges");
        Intrinsics.checkNotNullParameter(mappings, "mappings");
        this.sections = sections;
        this.ranges = ranges;
        this.mappings = mappings;
    }

    public final String getSections() {
        return this.sections;
    }

    public final String getRanges() {
        return this.ranges;
    }

    public final String getMappings() {
        return this.mappings;
    }

    public final boolean map(int codePoint, BufferedSink sink) throws IOException {
        Intrinsics.checkNotNullParameter(sink, "sink");
        int sectionsIndex = findSectionsIndex(codePoint);
        int rangesPosition = IdnaMappingTableKt.read14BitInt(this.sections, sectionsIndex + 2);
        int rangesLimit = sectionsIndex + 4 < this.sections.length() ? IdnaMappingTableKt.read14BitInt(this.sections, sectionsIndex + 6) : this.ranges.length() / 4;
        int rangesIndex = findRangesOffset(codePoint, rangesPosition, rangesLimit);
        int b1 = this.ranges.charAt(rangesIndex + 1);
        if (!(b1 >= 0 && b1 < 64)) {
            if (64 <= b1 && b1 < 80) {
                int b2 = this.ranges.charAt(rangesIndex + 2);
                int b3 = this.ranges.charAt(rangesIndex + 3);
                int codepointDelta = ((b1 & 15) << 14) | (b2 << 7) | b3;
                sink.writeUtf8CodePoint(codePoint - codepointDelta);
            } else {
                if (80 <= b1 && b1 < 96) {
                    int b4 = this.ranges.charAt(rangesIndex + 2);
                    int b5 = this.ranges.charAt(rangesIndex + 3);
                    int codepointDelta2 = ((b1 & 15) << 14) | (b4 << 7) | b5;
                    sink.writeUtf8CodePoint(codePoint + codepointDelta2);
                } else if (b1 == 119) {
                    Unit unit = Unit.INSTANCE;
                } else if (b1 == 120) {
                    sink.writeUtf8CodePoint(codePoint);
                } else {
                    if (b1 == 121) {
                        sink.writeUtf8CodePoint(codePoint);
                        return false;
                    }
                    if (b1 == 122) {
                        sink.writeByte(this.ranges.charAt(rangesIndex + 2));
                    } else if (b1 == 123) {
                        sink.writeByte(this.ranges.charAt(rangesIndex + 2) | 128);
                    } else if (b1 == 124) {
                        sink.writeByte(this.ranges.charAt(rangesIndex + 2));
                        sink.writeByte(this.ranges.charAt(rangesIndex + 3));
                    } else if (b1 == 125) {
                        sink.writeByte(this.ranges.charAt(rangesIndex + 2) | 128);
                        sink.writeByte(this.ranges.charAt(rangesIndex + 3));
                    } else if (b1 == 126) {
                        sink.writeByte(this.ranges.charAt(rangesIndex + 2));
                        sink.writeByte(this.ranges.charAt(rangesIndex + 3) | 128);
                    } else if (b1 == 127) {
                        sink.writeByte(this.ranges.charAt(rangesIndex + 2) | 128);
                        sink.writeByte(this.ranges.charAt(rangesIndex + 3) | 128);
                    } else {
                        throw new IllegalStateException(("unexpected rangesIndex for " + codePoint).toString());
                    }
                }
            }
        } else {
            int beginIndex = IdnaMappingTableKt.read14BitInt(this.ranges, rangesIndex + 2);
            sink.writeUtf8(this.mappings, beginIndex, beginIndex + b1);
        }
        return true;
    }

    private final int findSectionsIndex(int codePoint) {
        int mid$iv;
        int target = (2097024 & codePoint) >> 7;
        int limit$iv = this.sections.length() / 4;
        int low$iv = 0;
        int high$iv = limit$iv - 1;
        while (low$iv <= high$iv) {
            mid$iv = (low$iv + high$iv) / 2;
            int entryIndex = mid$iv * 4;
            int b0b1 = IdnaMappingTableKt.read14BitInt(this.sections, entryIndex);
            int index = Intrinsics.compare(target, b0b1);
            if (index < 0) {
                high$iv = mid$iv - 1;
            } else {
                if (index <= 0) {
                    return mid$iv >= 0 ? mid$iv * 4 : ((-mid$iv) - 2) * 4;
                }
                low$iv = mid$iv + 1;
            }
        }
        int mid$iv2 = -low$iv;
        mid$iv = mid$iv2 - 1;
        if (mid$iv >= 0) {
        }
    }

    private final int findRangesOffset(int codePoint, int position, int limit) {
        int mid$iv;
        int target = codePoint & 127;
        int low$iv = position;
        int high$iv = limit - 1;
        while (low$iv <= high$iv) {
            mid$iv = (low$iv + high$iv) / 2;
            int entryIndex = mid$iv * 4;
            int b0 = this.ranges.charAt(entryIndex);
            int index = Intrinsics.compare(target, b0);
            if (index < 0) {
                high$iv = mid$iv - 1;
            } else {
                if (index <= 0) {
                    return mid$iv >= 0 ? mid$iv * 4 : ((-mid$iv) - 2) * 4;
                }
                low$iv = mid$iv + 1;
            }
        }
        int mid$iv2 = -low$iv;
        mid$iv = mid$iv2 - 1;
        if (mid$iv >= 0) {
        }
    }
}
