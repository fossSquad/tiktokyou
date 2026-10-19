package ni.shikatu.okio;

import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.JvmStatic;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u0000 /2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001/B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\rH\u0087\u0002¢\u0006\u0002\b J\u0016\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0003H\u0087\u0002¢\u0006\u0002\b J\u0016\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0002\b J\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\r2\b\b\u0002\u0010!\u001a\u00020\u0013J\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00032\b\b\u0002\u0010!\u001a\u00020\u0013J\u0018\u0010 \u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010!\u001a\u00020\u0013J\u000e\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0000J\u0006\u0010$\u001a\u00020\u0000J\u0006\u0010%\u001a\u00020&J\u0006\u0010'\u001a\u00020(J\u0011\u0010)\u001a\u00020*2\u0006\u0010#\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010+\u001a\u00020\u00132\b\u0010#\u001a\u0004\u0018\u00010,H\u0096\u0002J\b\u0010-\u001a\u00020*H\u0016J\b\u0010.\u001a\u00020\rH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\b\u001a\u0004\u0018\u00010\u00008F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\f8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0012\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0014R\u0011\u0010\u0015\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0014R\u0013\u0010\u0016\u001a\u0004\u0018\u00010\u00178G¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\r8G¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0013\u0010\u001c\u001a\u0004\u0018\u00010\u00008G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\nR\u0011\u0010\u001d\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0014¨\u00060"}, d2 = {"Lni/shikatu/okio/Path;", _UrlKt.FRAGMENT_ENCODE_SET, "bytes", "Lni/shikatu/okio/ByteString;", "<init>", "(Lokio/ByteString;)V", "getBytes$okio", "()Lokio/ByteString;", "root", "getRoot", "()Lokio/Path;", "segments", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "getSegments", "()Ljava/util/List;", "segmentsBytes", "getSegmentsBytes", "isAbsolute", _UrlKt.FRAGMENT_ENCODE_SET, "()Z", "isRelative", "volumeLetter", _UrlKt.FRAGMENT_ENCODE_SET, "()Ljava/lang/Character;", "nameBytes", "name", "()Ljava/lang/String;", "parent", "isRoot", "div", "child", "resolve", "normalize", "relativeTo", "other", "normalized", "toFile", "Ljava/io/File;", "toNioPath", "Ljava/nio/file/Path;", "compareTo", _UrlKt.FRAGMENT_ENCODE_SET, "equals", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "toString", "Companion", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Path implements Comparable<Path> {
    public static final Companion Companion = new Companion(null);
    public static final String DIRECTORY_SEPARATOR;
    private final ByteString bytes;

    public Path(ByteString bytes) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        this.bytes = bytes;
    }

    public final ByteString getBytes$okio() {
        return this.bytes;
    }

    public final Path getRoot() {
        int rootLength$iv = ni.shikatu.okio.internal.Path.rootLength(this);
        if (rootLength$iv == -1) {
            return null;
        }
        return new Path(getBytes$okio().substring(0, rootLength$iv));
    }

    public final List<String> getSegments() {
        Iterable result$iv$iv = (List) new ArrayList();
        int segmentStart$iv$iv = ni.shikatu.okio.internal.Path.rootLength(this);
        if (segmentStart$iv$iv == -1) {
            segmentStart$iv$iv = 0;
        } else if (segmentStart$iv$iv < getBytes$okio().size() && getBytes$okio().getByte(segmentStart$iv$iv) == 92) {
            segmentStart$iv$iv++;
        }
        int size = getBytes$okio().size();
        for (int i$iv$iv = segmentStart$iv$iv; i$iv$iv < size; i$iv$iv++) {
            if (getBytes$okio().getByte(i$iv$iv) == 47 || getBytes$okio().getByte(i$iv$iv) == 92) {
                ((Collection) result$iv$iv).add(getBytes$okio().substring(segmentStart$iv$iv, i$iv$iv));
                segmentStart$iv$iv = i$iv$iv + 1;
            }
        }
        if (segmentStart$iv$iv < getBytes$okio().size()) {
            ((Collection) result$iv$iv).add(getBytes$okio().substring(segmentStart$iv$iv, getBytes$okio().size()));
        }
        Iterable $this$map$iv$iv = result$iv$iv;
        Collection destination$iv$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv$iv, 10));
        for (Object item$iv$iv$iv : $this$map$iv$iv) {
            ByteString it$iv = (ByteString) item$iv$iv$iv;
            destination$iv$iv$iv.add(it$iv.utf8());
        }
        return (List) destination$iv$iv$iv;
    }

    public final List<ByteString> getSegmentsBytes() {
        List result$iv = new ArrayList();
        int segmentStart$iv = ni.shikatu.okio.internal.Path.rootLength(this);
        if (segmentStart$iv == -1) {
            segmentStart$iv = 0;
        } else if (segmentStart$iv < getBytes$okio().size() && getBytes$okio().getByte(segmentStart$iv) == 92) {
            segmentStart$iv++;
        }
        int size = getBytes$okio().size();
        for (int i$iv = segmentStart$iv; i$iv < size; i$iv++) {
            if (getBytes$okio().getByte(i$iv) == 47 || getBytes$okio().getByte(i$iv) == 92) {
                result$iv.add(getBytes$okio().substring(segmentStart$iv, i$iv));
                segmentStart$iv = i$iv + 1;
            }
        }
        if (segmentStart$iv < getBytes$okio().size()) {
            result$iv.add(getBytes$okio().substring(segmentStart$iv, getBytes$okio().size()));
        }
        return result$iv;
    }

    public final boolean isAbsolute() {
        return ni.shikatu.okio.internal.Path.rootLength(this) != -1;
    }

    public final boolean isRelative() {
        return ni.shikatu.okio.internal.Path.rootLength(this) == -1;
    }

    public final Character volumeLetter() {
        boolean z = false;
        if (ByteString.indexOf$default(getBytes$okio(), ni.shikatu.okio.internal.Path.SLASH, 0, 2, (Object) null) != -1 || getBytes$okio().size() < 2 || getBytes$okio().getByte(1) != 58) {
            return null;
        }
        char c$iv = (char) getBytes$okio().getByte(0);
        if (!('a' <= c$iv && c$iv < '{')) {
            if ('A' <= c$iv && c$iv < '[') {
                z = true;
            }
            if (!z) {
                return null;
            }
        }
        return Character.valueOf(c$iv);
    }

    public final ByteString nameBytes() {
        int lastSlash$iv = ni.shikatu.okio.internal.Path.getIndexOfLastSlash(this);
        if (lastSlash$iv != -1) {
            return ByteString.substring$default(getBytes$okio(), lastSlash$iv + 1, 0, 2, null);
        }
        return (volumeLetter() == null || getBytes$okio().size() != 2) ? getBytes$okio() : ByteString.EMPTY;
    }

    public final String name() {
        return nameBytes().utf8();
    }

    public final Path parent() {
        if (Intrinsics.areEqual(getBytes$okio(), ni.shikatu.okio.internal.Path.DOT) || Intrinsics.areEqual(getBytes$okio(), ni.shikatu.okio.internal.Path.SLASH) || Intrinsics.areEqual(getBytes$okio(), ni.shikatu.okio.internal.Path.BACKSLASH) || ni.shikatu.okio.internal.Path.lastSegmentIsDotDot(this)) {
            return null;
        }
        int lastSlash$iv = ni.shikatu.okio.internal.Path.getIndexOfLastSlash(this);
        if (lastSlash$iv == 2 && volumeLetter() != null) {
            if (getBytes$okio().size() == 3) {
                return null;
            }
            return new Path(ByteString.substring$default(getBytes$okio(), 0, 3, 1, null));
        }
        if (lastSlash$iv == 1 && getBytes$okio().startsWith(ni.shikatu.okio.internal.Path.BACKSLASH)) {
            return null;
        }
        if (lastSlash$iv == -1 && volumeLetter() != null) {
            if (getBytes$okio().size() == 2) {
                return null;
            }
            return new Path(ByteString.substring$default(getBytes$okio(), 0, 2, 1, null));
        }
        if (lastSlash$iv == -1) {
            return new Path(ni.shikatu.okio.internal.Path.DOT);
        }
        if (lastSlash$iv == 0) {
            return new Path(ByteString.substring$default(getBytes$okio(), 0, 1, 1, null));
        }
        return new Path(ByteString.substring$default(getBytes$okio(), 0, lastSlash$iv, 1, null));
    }

    public final boolean isRoot() {
        return ni.shikatu.okio.internal.Path.rootLength(this) == getBytes$okio().size();
    }

    public final Path resolve(String child) {
        Intrinsics.checkNotNullParameter(child, "child");
        Buffer child$iv$iv = new Buffer().writeUtf8(child);
        return ni.shikatu.okio.internal.Path.commonResolve(this, ni.shikatu.okio.internal.Path.toPath(child$iv$iv, false), false);
    }

    public final Path resolve(ByteString child) {
        Intrinsics.checkNotNullParameter(child, "child");
        Buffer child$iv$iv = new Buffer().write(child);
        return ni.shikatu.okio.internal.Path.commonResolve(this, ni.shikatu.okio.internal.Path.toPath(child$iv$iv, false), false);
    }

    public final Path resolve(Path child) {
        Intrinsics.checkNotNullParameter(child, "child");
        return ni.shikatu.okio.internal.Path.commonResolve(this, child, false);
    }

    public static  Path resolve$default(Path path, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return path.resolve(str, z);
    }

    public final Path resolve(String child, boolean normalize) {
        Intrinsics.checkNotNullParameter(child, "child");
        Buffer child$iv$iv = new Buffer().writeUtf8(child);
        return ni.shikatu.okio.internal.Path.commonResolve(this, ni.shikatu.okio.internal.Path.toPath(child$iv$iv, false), normalize);
    }

    public static  Path resolve$default(Path path, ByteString byteString, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return path.resolve(byteString, z);
    }

    public final Path resolve(ByteString child, boolean normalize) {
        Intrinsics.checkNotNullParameter(child, "child");
        Buffer child$iv$iv = new Buffer().write(child);
        return ni.shikatu.okio.internal.Path.commonResolve(this, ni.shikatu.okio.internal.Path.toPath(child$iv$iv, false), normalize);
    }

    public static  Path resolve$default(Path path, Path path2, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return path.resolve(path2, z);
    }

    public final Path resolve(Path child, boolean normalize) {
        Intrinsics.checkNotNullParameter(child, "child");
        return ni.shikatu.okio.internal.Path.commonResolve(this, child, normalize);
    }

    public final Path relativeTo(Path other) {
        Intrinsics.checkNotNullParameter(other, "other");
        if (!Intrinsics.areEqual(getRoot(), other.getRoot())) {
            throw new IllegalArgumentException(("Paths of different roots cannot be relative to each other: " + this + " and " + other).toString());
        }
        List<ByteString> segmentsBytes = getSegmentsBytes();
        List<ByteString> segmentsBytes2 = other.getSegmentsBytes();
        int firstNewSegmentIndex$iv = 0;
        int minSegmentsSize$iv = Math.min(segmentsBytes.size(), segmentsBytes2.size());
        while (firstNewSegmentIndex$iv < minSegmentsSize$iv && Intrinsics.areEqual(segmentsBytes.get(firstNewSegmentIndex$iv), segmentsBytes2.get(firstNewSegmentIndex$iv))) {
            firstNewSegmentIndex$iv++;
        }
        if (firstNewSegmentIndex$iv != minSegmentsSize$iv || getBytes$okio().size() != other.getBytes$okio().size()) {
            if (segmentsBytes2.subList(firstNewSegmentIndex$iv, segmentsBytes2.size()).indexOf(ni.shikatu.okio.internal.Path.DOT_DOT) == -1) {
                if (Intrinsics.areEqual(other.getBytes$okio(), ni.shikatu.okio.internal.Path.DOT)) {
                    return this;
                }
                Buffer buffer$iv = new Buffer();
                ByteString slash$iv = ni.shikatu.okio.internal.Path.getSlash(other);
                if (slash$iv == null && (slash$iv = ni.shikatu.okio.internal.Path.getSlash(this)) == null) {
                    slash$iv = ni.shikatu.okio.internal.Path.toSlash(DIRECTORY_SEPARATOR);
                }
                int size = segmentsBytes2.size();
                for (int i$iv = firstNewSegmentIndex$iv; i$iv < size; i$iv++) {
                    buffer$iv.write(ni.shikatu.okio.internal.Path.DOT_DOT);
                    buffer$iv.write(slash$iv);
                }
                int size2 = segmentsBytes.size();
                for (int i$iv2 = firstNewSegmentIndex$iv; i$iv2 < size2; i$iv2++) {
                    buffer$iv.write(segmentsBytes.get(i$iv2));
                    buffer$iv.write(slash$iv);
                }
                return ni.shikatu.okio.internal.Path.toPath(buffer$iv, false);
            }
            throw new IllegalArgumentException(("Impossible relative path to resolve: " + this + " and " + other).toString());
        }
        return Companion.get$default(Companion, ".", false, 1, (Object) null);
    }

    public final Path normalized() {
        Path $this$commonNormalized$iv = Companion.get(toString(), true);
        return $this$commonNormalized$iv;
    }

    public final File toFile() {
        return new File(toString());
    }

    public final java.nio.file.Path toNioPath() {
        java.nio.file.Path path = Paths.get(toString(), new String[0]);
        Intrinsics.checkNotNullExpressionValue(path, "get(...)");
        return path;
    }

    @Override
    public int compareTo(Path other) {
        Intrinsics.checkNotNullParameter(other, "other");
        return getBytes$okio().compareTo(other.getBytes$okio());
    }

    public boolean equals(Object other) {
        return (other instanceof Path) && Intrinsics.areEqual(((Path) other).getBytes$okio(), getBytes$okio());
    }

    public int hashCode() {
        return getBytes$okio().hashCode();
    }

    public String toString() {
        return getBytes$okio().utf8();
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001b\u0010\u0006\u001a\u00020\u0007*\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u001b\u0010\u000b\u001a\u00020\u0007*\u00020\f2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nJ\u001b\u0010\u000b\u001a\u00020\u0007*\u00020\r2\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\b\nR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lni/shikatu/okio/Path$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "DIRECTORY_SEPARATOR", _UrlKt.FRAGMENT_ENCODE_SET, "toPath", "Lni/shikatu/okio/Path;", "normalize", _UrlKt.FRAGMENT_ENCODE_SET, "get", "toOkioPath", "Ljava/io/File;", "Ljava/nio/file/Path;", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final Path get(File file) {
            Intrinsics.checkNotNullParameter(file, "<this>");
            return get$default(this, file, false, 1, (Object) null);
        }

        @JvmStatic
        public final Path get(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            return get$default(this, str, false, 1, (Object) null);
        }

        @JvmStatic
        public final Path get(java.nio.file.Path path) {
            Intrinsics.checkNotNullParameter(path, "<this>");
            return get$default(this, path, false, 1, (Object) null);
        }

        private Companion() {
        }

        public static  Path get$default(Companion companion, String str, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.get(str, z);
        }

        @JvmStatic
        public final Path get(String $this$toPath, boolean normalize) {
            Intrinsics.checkNotNullParameter($this$toPath, "<this>");
            return ni.shikatu.okio.internal.Path.commonToPath($this$toPath, normalize);
        }

        public static  Path get$default(Companion companion, File file, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.get(file, z);
        }

        @JvmStatic
        public final Path get(File $this$toOkioPath, boolean normalize) {
            Intrinsics.checkNotNullParameter($this$toOkioPath, "<this>");
            String string = $this$toOkioPath.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return get(string, normalize);
        }

        public static  Path get$default(Companion companion, java.nio.file.Path path, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                z = false;
            }
            return companion.get(path, z);
        }

        @JvmStatic
        public final Path get(java.nio.file.Path $this$toOkioPath, boolean normalize) {
            Intrinsics.checkNotNullParameter($this$toOkioPath, "<this>");
            return get($this$toOkioPath.toString(), normalize);
        }
    }

    static {
        String str = File.separator;
        Intrinsics.checkNotNullExpressionValue(str, "separator");
        DIRECTORY_SEPARATOR = str;
    }

    @JvmStatic
    public static final Path get(String $this$get) {
        return Companion.get($this$get);
    }

    @JvmStatic
    public static final Path get(String $this$get, boolean normalize) {
        return Companion.get($this$get, normalize);
    }

    @JvmStatic
    public static final Path get(File $this$get) {
        return Companion.get($this$get);
    }

    @JvmStatic
    public static final Path get(File $this$get, boolean normalize) {
        return Companion.get($this$get, normalize);
    }

    @JvmStatic
    public static final Path get(java.nio.file.Path $this$get) {
        return Companion.get($this$get);
    }

    @JvmStatic
    public static final Path get(java.nio.file.Path $this$get, boolean normalize) {
        return Companion.get($this$get, normalize);
    }
}
