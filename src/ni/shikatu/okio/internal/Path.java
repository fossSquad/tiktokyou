package ni.shikatu.okio.internal;

import java.io.EOFException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.ByteString;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\u0005\n\u0002\b\u0002\u001a\u000f\u0010\u0006\u001a\u0004\u0018\u00010\u0007*\u00020\u0007H\u0080\b\u001a\u0013\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t*\u00020\u0007H\u0080\b\u001a\u0013\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\t*\u00020\u0007H\u0080\b\u001a\f\u0010\f\u001a\u00020\r*\u00020\u0007H\u0002\u001a\r\u0010\u000e\u001a\u00020\u000f*\u00020\u0007H\u0080\b\u001a\r\u0010\u0010\u001a\u00020\u000f*\u00020\u0007H\u0080\b\u001a\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u0012*\u00020\u0007H\u0080\b¢\u0006\u0002\u0010\u0013\u001a\r\u0010\u0017\u001a\u00020\u0001*\u00020\u0007H\u0080\b\u001a\r\u0010\u0018\u001a\u00020\n*\u00020\u0007H\u0080\b\u001a\u000f\u0010\u0019\u001a\u0004\u0018\u00010\u0007*\u00020\u0007H\u0080\b\u001a\f\u0010\u001a\u001a\u00020\u000f*\u00020\u0007H\u0002\u001a\r\u0010\u001b\u001a\u00020\u000f*\u00020\u0007H\u0080\b\u001a\u001d\u0010\u001c\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000fH\u0080\b\u001a\u001d\u0010\u001c\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00012\u0006\u0010\u001e\u001a\u00020\u000fH\u0080\b\u001a\u001d\u0010\u001c\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u000fH\u0080\b\u001a\u001c\u0010\u001c\u001a\u00020\u0007*\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u000fH\u0000\u001a\u0015\u0010 \u001a\u00020\u0007*\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0080\b\u001a\r\u0010\"\u001a\u00020\u0007*\u00020\u0007H\u0080\b\u001a\u0015\u0010&\u001a\u00020\r*\u00020\u00072\u0006\u0010!\u001a\u00020\u0007H\u0080\b\u001a\u0017\u0010'\u001a\u00020\u000f*\u00020\u00072\b\u0010!\u001a\u0004\u0018\u00010(H\u0080\b\u001a\r\u0010)\u001a\u00020\r*\u00020\u0007H\u0080\b\u001a\r\u0010*\u001a\u00020\n*\u00020\u0007H\u0080\b\u001a\u0014\u0010+\u001a\u00020\u0007*\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000fH\u0000\u001a\u0014\u0010,\u001a\u00020\u0007*\u00020\u001f2\u0006\u0010\u001e\u001a\u00020\u000fH\u0000\u001a\f\u0010-\u001a\u00020\u0001*\u00020\nH\u0002\u001a\f\u0010-\u001a\u00020\u0001*\u00020.H\u0002\u001a\u0014\u0010/\u001a\u00020\u000f*\u00020\u001f2\u0006\u0010#\u001a\u00020\u0001H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0018\u0010\u0014\u001a\u00020\r*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016\"\u001a\u0010#\u001a\u0004\u0018\u00010\u0001*\u00020\u00078BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010%¨\u00060"}, d2 = {"SLASH", "Lni/shikatu/okio/ByteString;", "BACKSLASH", "ANY_SLASH", "DOT", "DOT_DOT", "commonRoot", "Lni/shikatu/okio/Path;", "commonSegments", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "commonSegmentsBytes", "rootLength", _UrlKt.FRAGMENT_ENCODE_SET, "commonIsAbsolute", _UrlKt.FRAGMENT_ENCODE_SET, "commonIsRelative", "commonVolumeLetter", _UrlKt.FRAGMENT_ENCODE_SET, "(Lokio/Path;)Ljava/lang/Character;", "indexOfLastSlash", "getIndexOfLastSlash", "(Lokio/Path;)I", "commonNameBytes", "commonName", "commonParent", "lastSegmentIsDotDot", "commonIsRoot", "commonResolve", "child", "normalize", "Lni/shikatu/okio/Buffer;", "commonRelativeTo", "other", "commonNormalized", "slash", "getSlash", "(Lokio/Path;)Lokio/ByteString;", "commonCompareTo", "commonEquals", _UrlKt.FRAGMENT_ENCODE_SET, "commonHashCode", "commonToString", "commonToPath", "toPath", "toSlash", _UrlKt.FRAGMENT_ENCODE_SET, "startsWithVolumeLetterAndColon", "ni.shikatu.okio"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class Path {
    private static final ByteString SLASH = ByteString.Companion.encodeUtf8("/");
    private static final ByteString BACKSLASH = ByteString.Companion.encodeUtf8("\\");
    private static final ByteString ANY_SLASH = ByteString.Companion.encodeUtf8("/\\");
    private static final ByteString DOT = ByteString.Companion.encodeUtf8(".");
    private static final ByteString DOT_DOT = ByteString.Companion.encodeUtf8("..");

    public static final ni.shikatu.okio.Path commonRoot(ni.shikatu.okio.Path $this$commonRoot) {
        Intrinsics.checkNotNullParameter($this$commonRoot, "<this>");
        int rootLength = rootLength($this$commonRoot);
        if (rootLength == -1) {
            return null;
        }
        return new ni.shikatu.okio.Path($this$commonRoot.getBytes$okio().substring(0, rootLength));
    }

    public static final List<String> commonSegments(ni.shikatu.okio.Path $this$commonSegments) {
        Intrinsics.checkNotNullParameter($this$commonSegments, "<this>");
        Iterable result$iv = (List) new ArrayList();
        int segmentStart$iv = rootLength($this$commonSegments);
        if (segmentStart$iv == -1) {
            segmentStart$iv = 0;
        } else if (segmentStart$iv < $this$commonSegments.getBytes$okio().size() && $this$commonSegments.getBytes$okio().getByte(segmentStart$iv) == 92) {
            segmentStart$iv++;
        }
        int size = $this$commonSegments.getBytes$okio().size();
        for (int i$iv = segmentStart$iv; i$iv < size; i$iv++) {
            if ($this$commonSegments.getBytes$okio().getByte(i$iv) == 47 || $this$commonSegments.getBytes$okio().getByte(i$iv) == 92) {
                ((Collection) result$iv).add($this$commonSegments.getBytes$okio().substring(segmentStart$iv, i$iv));
                segmentStart$iv = i$iv + 1;
            }
        }
        if (segmentStart$iv < $this$commonSegments.getBytes$okio().size()) {
            ((Collection) result$iv).add($this$commonSegments.getBytes$okio().substring(segmentStart$iv, $this$commonSegments.getBytes$okio().size()));
        }
        Iterable $this$map$iv = result$iv;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            ByteString it = (ByteString) item$iv$iv;
            destination$iv$iv.add(it.utf8());
        }
        return (List) destination$iv$iv;
    }

    public static final List<ByteString> commonSegmentsBytes(ni.shikatu.okio.Path $this$commonSegmentsBytes) {
        Intrinsics.checkNotNullParameter($this$commonSegmentsBytes, "<this>");
        List result = new ArrayList();
        int segmentStart = rootLength($this$commonSegmentsBytes);
        if (segmentStart == -1) {
            segmentStart = 0;
        } else if (segmentStart < $this$commonSegmentsBytes.getBytes$okio().size() && $this$commonSegmentsBytes.getBytes$okio().getByte(segmentStart) == 92) {
            segmentStart++;
        }
        int size = $this$commonSegmentsBytes.getBytes$okio().size();
        for (int i = segmentStart; i < size; i++) {
            if ($this$commonSegmentsBytes.getBytes$okio().getByte(i) == 47 || $this$commonSegmentsBytes.getBytes$okio().getByte(i) == 92) {
                result.add($this$commonSegmentsBytes.getBytes$okio().substring(segmentStart, i));
                segmentStart = i + 1;
            }
        }
        if (segmentStart < $this$commonSegmentsBytes.getBytes$okio().size()) {
            result.add($this$commonSegmentsBytes.getBytes$okio().substring(segmentStart, $this$commonSegmentsBytes.getBytes$okio().size()));
        }
        return result;
    }

    public static final int rootLength(ni.shikatu.okio.Path $this$rootLength) {
        if ($this$rootLength.getBytes$okio().size() == 0) {
            return -1;
        }
        boolean z = false;
        if ($this$rootLength.getBytes$okio().getByte(0) == 47) {
            return 1;
        }
        if ($this$rootLength.getBytes$okio().getByte(0) == 92) {
            if ($this$rootLength.getBytes$okio().size() <= 2 || $this$rootLength.getBytes$okio().getByte(1) != 92) {
                return 1;
            }
            int uncRootEnd = $this$rootLength.getBytes$okio().indexOf(BACKSLASH, 2);
            return uncRootEnd == -1 ? $this$rootLength.getBytes$okio().size() : uncRootEnd;
        }
        if ($this$rootLength.getBytes$okio().size() <= 2 || $this$rootLength.getBytes$okio().getByte(1) != 58 || $this$rootLength.getBytes$okio().getByte(2) != 92) {
            return -1;
        }
        char c = (char) $this$rootLength.getBytes$okio().getByte(0);
        if ('a' <= c && c < '{') {
            return 3;
        }
        if ('A' <= c && c < '[') {
            z = true;
        }
        return !z ? -1 : 3;
    }

    public static final boolean commonIsAbsolute(ni.shikatu.okio.Path $this$commonIsAbsolute) {
        Intrinsics.checkNotNullParameter($this$commonIsAbsolute, "<this>");
        return rootLength($this$commonIsAbsolute) != -1;
    }

    public static final boolean commonIsRelative(ni.shikatu.okio.Path $this$commonIsRelative) {
        Intrinsics.checkNotNullParameter($this$commonIsRelative, "<this>");
        return rootLength($this$commonIsRelative) == -1;
    }

    public static final Character commonVolumeLetter(ni.shikatu.okio.Path $this$commonVolumeLetter) {
        Intrinsics.checkNotNullParameter($this$commonVolumeLetter, "<this>");
        boolean z = false;
        if (ByteString.indexOf$default($this$commonVolumeLetter.getBytes$okio(), SLASH, 0, 2, (Object) null) != -1 || $this$commonVolumeLetter.getBytes$okio().size() < 2 || $this$commonVolumeLetter.getBytes$okio().getByte(1) != 58) {
            return null;
        }
        char c = (char) $this$commonVolumeLetter.getBytes$okio().getByte(0);
        if (!('a' <= c && c < '{')) {
            if ('A' <= c && c < '[') {
                z = true;
            }
            if (!z) {
                return null;
            }
        }
        return Character.valueOf(c);
    }

    public static final int getIndexOfLastSlash(ni.shikatu.okio.Path $this$indexOfLastSlash) {
        int lastSlash = ByteString.lastIndexOf$default($this$indexOfLastSlash.getBytes$okio(), SLASH, 0, 2, (Object) null);
        return lastSlash != -1 ? lastSlash : ByteString.lastIndexOf$default($this$indexOfLastSlash.getBytes$okio(), BACKSLASH, 0, 2, (Object) null);
    }

    public static final ByteString commonNameBytes(ni.shikatu.okio.Path $this$commonNameBytes) {
        Intrinsics.checkNotNullParameter($this$commonNameBytes, "<this>");
        int lastSlash = getIndexOfLastSlash($this$commonNameBytes);
        if (lastSlash != -1) {
            return ByteString.substring$default($this$commonNameBytes.getBytes$okio(), lastSlash + 1, 0, 2, null);
        }
        return ($this$commonNameBytes.volumeLetter() == null || $this$commonNameBytes.getBytes$okio().size() != 2) ? $this$commonNameBytes.getBytes$okio() : ByteString.EMPTY;
    }

    public static final String commonName(ni.shikatu.okio.Path $this$commonName) {
        Intrinsics.checkNotNullParameter($this$commonName, "<this>");
        return $this$commonName.nameBytes().utf8();
    }

    public static final ni.shikatu.okio.Path commonParent(ni.shikatu.okio.Path $this$commonParent) {
        Intrinsics.checkNotNullParameter($this$commonParent, "<this>");
        if (Intrinsics.areEqual($this$commonParent.getBytes$okio(), DOT) || Intrinsics.areEqual($this$commonParent.getBytes$okio(), SLASH) || Intrinsics.areEqual($this$commonParent.getBytes$okio(), BACKSLASH) || lastSegmentIsDotDot($this$commonParent)) {
            return null;
        }
        int lastSlash = getIndexOfLastSlash($this$commonParent);
        if (lastSlash == 2 && $this$commonParent.volumeLetter() != null) {
            if ($this$commonParent.getBytes$okio().size() == 3) {
                return null;
            }
            return new ni.shikatu.okio.Path(ByteString.substring$default($this$commonParent.getBytes$okio(), 0, 3, 1, null));
        }
        if (lastSlash == 1 && $this$commonParent.getBytes$okio().startsWith(BACKSLASH)) {
            return null;
        }
        if (lastSlash == -1 && $this$commonParent.volumeLetter() != null) {
            if ($this$commonParent.getBytes$okio().size() == 2) {
                return null;
            }
            return new ni.shikatu.okio.Path(ByteString.substring$default($this$commonParent.getBytes$okio(), 0, 2, 1, null));
        }
        if (lastSlash == -1) {
            return new ni.shikatu.okio.Path(DOT);
        }
        if (lastSlash == 0) {
            return new ni.shikatu.okio.Path(ByteString.substring$default($this$commonParent.getBytes$okio(), 0, 1, 1, null));
        }
        return new ni.shikatu.okio.Path(ByteString.substring$default($this$commonParent.getBytes$okio(), 0, lastSlash, 1, null));
    }

    public static final boolean lastSegmentIsDotDot(ni.shikatu.okio.Path $this$lastSegmentIsDotDot) {
        return $this$lastSegmentIsDotDot.getBytes$okio().endsWith(DOT_DOT) && ($this$lastSegmentIsDotDot.getBytes$okio().size() == 2 || $this$lastSegmentIsDotDot.getBytes$okio().rangeEquals($this$lastSegmentIsDotDot.getBytes$okio().size() + (-3), SLASH, 0, 1) || $this$lastSegmentIsDotDot.getBytes$okio().rangeEquals($this$lastSegmentIsDotDot.getBytes$okio().size() + (-3), BACKSLASH, 0, 1));
    }

    public static final boolean commonIsRoot(ni.shikatu.okio.Path $this$commonIsRoot) {
        Intrinsics.checkNotNullParameter($this$commonIsRoot, "<this>");
        return rootLength($this$commonIsRoot) == $this$commonIsRoot.getBytes$okio().size();
    }

    public static final ni.shikatu.okio.Path commonResolve(ni.shikatu.okio.Path $this$commonResolve, String child, boolean normalize) {
        Intrinsics.checkNotNullParameter($this$commonResolve, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        Buffer child$iv = new Buffer().writeUtf8(child);
        return commonResolve($this$commonResolve, toPath(child$iv, false), normalize);
    }

    public static final ni.shikatu.okio.Path commonResolve(ni.shikatu.okio.Path $this$commonResolve, ByteString child, boolean normalize) {
        Intrinsics.checkNotNullParameter($this$commonResolve, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        Buffer child$iv = new Buffer().write(child);
        return commonResolve($this$commonResolve, toPath(child$iv, false), normalize);
    }

    public static final ni.shikatu.okio.Path commonResolve(ni.shikatu.okio.Path $this$commonResolve, Buffer child, boolean normalize) {
        Intrinsics.checkNotNullParameter($this$commonResolve, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        return commonResolve($this$commonResolve, toPath(child, false), normalize);
    }

    public static final ni.shikatu.okio.Path commonResolve(ni.shikatu.okio.Path $this$commonResolve, ni.shikatu.okio.Path child, boolean normalize) {
        Intrinsics.checkNotNullParameter($this$commonResolve, "<this>");
        Intrinsics.checkNotNullParameter(child, "child");
        if (child.isAbsolute() || child.volumeLetter() != null) {
            return child;
        }
        ByteString slash = getSlash($this$commonResolve);
        if (slash == null && (slash = getSlash(child)) == null) {
            slash = toSlash(ni.shikatu.okio.Path.DIRECTORY_SEPARATOR);
        }
        Buffer buffer = new Buffer();
        buffer.write($this$commonResolve.getBytes$okio());
        if (buffer.size() > 0) {
            buffer.write(slash);
        }
        buffer.write(child.getBytes$okio());
        return toPath(buffer, normalize);
    }

    public static final ni.shikatu.okio.Path commonRelativeTo(ni.shikatu.okio.Path $this$commonRelativeTo, ni.shikatu.okio.Path other) {
        Intrinsics.checkNotNullParameter($this$commonRelativeTo, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        if (!Intrinsics.areEqual($this$commonRelativeTo.getRoot(), other.getRoot())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + $this$commonRelativeTo + " and " + other).toString());
        }
        List<ByteString> segmentsBytes = $this$commonRelativeTo.getSegmentsBytes();
        List<ByteString> segmentsBytes2 = other.getSegmentsBytes();
        int firstNewSegmentIndex = 0;
        int minSegmentsSize = Math.min(segmentsBytes.size(), segmentsBytes2.size());
        while (firstNewSegmentIndex < minSegmentsSize && Intrinsics.areEqual(segmentsBytes.get(firstNewSegmentIndex), segmentsBytes2.get(firstNewSegmentIndex))) {
            firstNewSegmentIndex++;
        }
        if (firstNewSegmentIndex != minSegmentsSize || $this$commonRelativeTo.getBytes$okio().size() != other.getBytes$okio().size()) {
            if (segmentsBytes2.subList(firstNewSegmentIndex, segmentsBytes2.size()).indexOf(DOT_DOT) == -1) {
                if (Intrinsics.areEqual(other.getBytes$okio(), DOT)) {
                    return $this$commonRelativeTo;
                }
                Buffer buffer = new Buffer();
                ByteString slash = getSlash(other);
                if (slash == null && (slash = getSlash($this$commonRelativeTo)) == null) {
                    slash = toSlash(ni.shikatu.okio.Path.DIRECTORY_SEPARATOR);
                }
                int size = segmentsBytes2.size();
                for (int i = firstNewSegmentIndex; i < size; i++) {
                    buffer.write(DOT_DOT);
                    buffer.write(slash);
                }
                int size2 = segmentsBytes.size();
                for (int i2 = firstNewSegmentIndex; i2 < size2; i2++) {
                    buffer.write(segmentsBytes.get(i2));
                    buffer.write(slash);
                }
                return toPath(buffer, false);
            }
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + $this$commonRelativeTo + " and " + other).toString());
        }
        return ni.shikatu.okio.Path.Companion.get$default(ni.shikatu.okio.Path.Companion, ".", false, 1, (Object) null);
    }

    public static final ni.shikatu.okio.Path commonNormalized(ni.shikatu.okio.Path $this$commonNormalized) {
        Intrinsics.checkNotNullParameter($this$commonNormalized, "<this>");
        return ni.shikatu.okio.Path.Companion.get($this$commonNormalized.toString(), true);
    }

    public static final ByteString getSlash(ni.shikatu.okio.Path $this$slash) {
        if (ByteString.indexOf$default($this$slash.getBytes$okio(), SLASH, 0, 2, (Object) null) != -1) {
            return SLASH;
        }
        if (ByteString.indexOf$default($this$slash.getBytes$okio(), BACKSLASH, 0, 2, (Object) null) != -1) {
            return BACKSLASH;
        }
        return null;
    }

    public static final int commonCompareTo(ni.shikatu.okio.Path $this$commonCompareTo, ni.shikatu.okio.Path other) {
        Intrinsics.checkNotNullParameter($this$commonCompareTo, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return $this$commonCompareTo.getBytes$okio().compareTo(other.getBytes$okio());
    }

    public static final boolean commonEquals(ni.shikatu.okio.Path $this$commonEquals, Object other) {
        Intrinsics.checkNotNullParameter($this$commonEquals, "<this>");
        return (other instanceof ni.shikatu.okio.Path) && Intrinsics.areEqual(((ni.shikatu.okio.Path) other).getBytes$okio(), $this$commonEquals.getBytes$okio());
    }

    public static final int commonHashCode(ni.shikatu.okio.Path $this$commonHashCode) {
        Intrinsics.checkNotNullParameter($this$commonHashCode, "<this>");
        return $this$commonHashCode.getBytes$okio().hashCode();
    }

    public static final String commonToString(ni.shikatu.okio.Path $this$commonToString) {
        Intrinsics.checkNotNullParameter($this$commonToString, "<this>");
        return $this$commonToString.getBytes$okio().utf8();
    }

    public static final ni.shikatu.okio.Path commonToPath(String $this$commonToPath, boolean normalize) {
        Intrinsics.checkNotNullParameter($this$commonToPath, "<this>");
        return toPath(new Buffer().writeUtf8($this$commonToPath), normalize);
    }

    public static final ni.shikatu.okio.Path toPath(Buffer $this$toPath, boolean normalize) throws EOFException {
        long j;
        ByteString slash;
        ByteString part;
        long j2;
        Intrinsics.checkNotNullParameter($this$toPath, "<this>");
        ByteString slash2 = null;
        Buffer result = new Buffer();
        int leadingSlashCount = 0;
        while (true) {
            j = 0;
            if (!$this$toPath.rangeEquals(0L, SLASH) && !$this$toPath.rangeEquals(0L, BACKSLASH)) {
                break;
            }
            slash2 = slash2 == null ? toSlash($this$toPath.readByte()) : slash2;
            leadingSlashCount++;
        }
        boolean windowsUncPath = leadingSlashCount >= 2 && Intrinsics.areEqual(slash2, BACKSLASH);
        if (windowsUncPath) {
            Intrinsics.checkNotNull(slash2);
            result.write(slash2);
            result.write(slash2);
        } else if (leadingSlashCount > 0) {
            Intrinsics.checkNotNull(slash2);
            result.write(slash2);
        } else {
            long limit = $this$toPath.indexOfElement(ANY_SLASH);
            if (slash2 != null) {
                slash = slash2;
            } else {
                slash = limit == -1 ? toSlash(ni.shikatu.okio.Path.DIRECTORY_SEPARATOR) : toSlash($this$toPath.getByte(limit));
            }
            slash2 = slash;
            if (startsWithVolumeLetterAndColon($this$toPath, slash2)) {
                if (limit == 2) {
                    result.write($this$toPath, 3L);
                } else {
                    result.write($this$toPath, 2L);
                }
            }
            Unit unit = Unit.INSTANCE;
        }
        boolean absolute = result.size() > 0;
        List canonicalParts = new ArrayList();
        while (!$this$toPath.exhausted()) {
            long limit2 = $this$toPath.indexOfElement(ANY_SLASH);
            if (limit2 == -1) {
                part = $this$toPath.readByteString();
            } else {
                part = $this$toPath.readByteString(limit2);
                $this$toPath.readByte();
            }
            if (Intrinsics.areEqual(part, DOT_DOT)) {
                if (!absolute || !canonicalParts.isEmpty()) {
                    if (normalize) {
                        if (absolute) {
                            j2 = j;
                        } else {
                            if (!canonicalParts.isEmpty()) {
                                j2 = j;
                                if (Intrinsics.areEqual(CollectionsKt.last(canonicalParts), DOT_DOT)) {
                                }
                            }
                            canonicalParts.add(part);
                            j = j2;
                        }
                        if (windowsUncPath && canonicalParts.size() == 1) {
                            j = j2;
                        } else {
                            CollectionsKt.removeLastOrNull(canonicalParts);
                            j = j2;
                        }
                    }
                    j2 = j;
                    canonicalParts.add(part);
                    j = j2;
                }
            } else {
                long j3 = j;
                if (Intrinsics.areEqual(part, DOT) || Intrinsics.areEqual(part, ByteString.EMPTY)) {
                    j = j3;
                } else {
                    canonicalParts.add(part);
                    j = j3;
                }
            }
        }
        long j4 = j;
        int size = canonicalParts.size();
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                result.write(slash2);
            }
            result.write((ByteString) canonicalParts.get(i));
        }
        if (result.size() == j4) {
            result.write(DOT);
        }
        return new ni.shikatu.okio.Path(result.readByteString());
    }

    public static final ByteString toSlash(String $this$toSlash) {
        if (Intrinsics.areEqual($this$toSlash, "/")) {
            return SLASH;
        }
        if (Intrinsics.areEqual($this$toSlash, "\\")) {
            return BACKSLASH;
        }
        throw new IllegalArgumentException("not a directory separator: " + $this$toSlash);
    }

    private static final ByteString toSlash(byte $this$toSlash) {
        switch ($this$toSlash) {
            case 47:
                return SLASH;
            case 92:
                return BACKSLASH;
            default:
                throw new IllegalArgumentException("not a directory separator: " + ((int) $this$toSlash));
        }
    }

    private static final boolean startsWithVolumeLetterAndColon(Buffer $this$startsWithVolumeLetterAndColon, ByteString slash) {
        if (!Intrinsics.areEqual(slash, BACKSLASH) || $this$startsWithVolumeLetterAndColon.size() < 2 || $this$startsWithVolumeLetterAndColon.getByte(1L) != 58) {
            return false;
        }
        char b = (char) $this$startsWithVolumeLetterAndColon.getByte(0L);
        if (!('a' <= b && b < '{')) {
            if (!('A' <= b && b < '[')) {
                return false;
            }
        }
        return true;
    }
}
