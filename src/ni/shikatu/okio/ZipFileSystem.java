package ni.shikatu.okio;

import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.zip.Inflater;
import ni.shikatu.kotlin.ExceptionsKt;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.internal.FixedLengthSource;
import ni.shikatu.okio.internal.ZipEntry;
import ni.shikatu.okio.internal.ZipFilesKt;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0000\u0018\u0000 (2\u00020\u0001:\u0001(B7\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0001\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u000e\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u0003H\u0002J\u0012\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\r\u001a\u00020\u0003H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J \u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0003H\u0016J \u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0016H\u0002J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u0003H\u0016J\u0018\u0010\u001f\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010!\u001a\u00020 2\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010\"\u001a\u00020#2\u0006\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0018\u0010$\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0016J\u0018\u0010&\u001a\u00020#2\u0006\u0010\r\u001a\u00020\u00032\u0006\u0010\u0017\u001a\u00020\u0016H\u0016J\u0018\u0010'\u001a\u00020#2\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006)"}, d2 = {"Lni/shikatu/okio/ZipFileSystem;", "Lni/shikatu/okio/FileSystem;", "zipPath", "Lni/shikatu/okio/Path;", "fileSystem", "entries", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okio/internal/ZipEntry;", "comment", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Lokio/Path;Lokio/FileSystem;Ljava/util/Map;Ljava/lang/String;)V", "canonicalize", "path", "canonicalizeInternal", "metadataOrNull", "Lni/shikatu/okio/FileMetadata;", "openReadOnly", "Lni/shikatu/okio/FileHandle;", "file", "openReadWrite", "mustCreate", _UrlKt.FRAGMENT_ENCODE_SET, "mustExist", "list", _UrlKt.FRAGMENT_ENCODE_SET, "dir", "listOrNull", "throwOnFailure", "source", "Lni/shikatu/okio/Source;", "sink", "Lni/shikatu/okio/Sink;", "appendingSink", "createDirectory", _UrlKt.FRAGMENT_ENCODE_SET, "atomicMove", "target", "delete", "createSymlink", "Companion", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ZipFileSystem extends FileSystem {
    private static final Companion Companion = new Companion(null);
    private static final Path ROOT = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);
    private final String comment;
    private final Map<Path, ZipEntry> entries;
    private final FileSystem fileSystem;
    private final Path zipPath;

    public ZipFileSystem(Path zipPath, FileSystem fileSystem, Map<Path, ZipEntry> map, String comment) {
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
        Intrinsics.checkNotNullParameter(map, "entries");
        this.zipPath = zipPath;
        this.fileSystem = fileSystem;
        this.entries = map;
        this.comment = comment;
    }

    @Override
    public Path canonicalize(Path path) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(path, "path");
        Path canonical = canonicalizeInternal(path);
        if (!this.entries.containsKey(canonical)) {
            throw new FileNotFoundException(String.valueOf(path));
        }
        return canonical;
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    @Override
    public FileMetadata metadataOrNull(Path path) throws Throwable {
        ZipEntry fullEntry;
        Object result$iv;
        Object result$iv2;
        Intrinsics.checkNotNullParameter(path, "path");
        Path canonicalPath = canonicalizeInternal(path);
        ZipEntry centralDirectoryEntry = this.entries.get(canonicalPath);
        if (centralDirectoryEntry == null) {
            return null;
        }
        if (centralDirectoryEntry.getOffset() != -1) {
            Closeable $this$use$iv = this.fileSystem.openReadOnly(this.zipPath);
            Throwable thrown$iv = null;
            try {
                FileHandle fileHandle = (FileHandle) $this$use$iv;
                Closeable $this$use$iv2 = Okio.buffer(fileHandle.source(centralDirectoryEntry.getOffset()));
                Throwable thrown$iv2 = null;
                try {
                    BufferedSource source = (BufferedSource) $this$use$iv2;
                    result$iv2 = ZipFilesKt.readLocalHeader(source, centralDirectoryEntry);
                    if ($this$use$iv2 != null) {
                        try {
                            $this$use$iv2.close();
                        } catch (Throwable t$iv) {
                            thrown$iv2 = t$iv;
                        }
                    }
                } catch (Throwable t$iv2) {
                    thrown$iv2 = t$iv2;
                    if ($this$use$iv2 != null) {
                        try {
                            $this$use$iv2.close();
                        } catch (Throwable t$iv3) {
                            ExceptionsKt.addSuppressed(thrown$iv2, t$iv3);
                        }
                    }
                    result$iv2 = null;
                }
                if (thrown$iv2 != null) {
                    throw thrown$iv2;
                }
                result$iv = (ZipEntry) result$iv2;
                if ($this$use$iv != null) {
                    try {
                        $this$use$iv.close();
                    } catch (Throwable t$iv4) {
                        thrown$iv = t$iv4;
                    }
                }
                if (thrown$iv != null) {
                    throw thrown$iv;
                }
                fullEntry = (ZipEntry) result$iv;
            } catch (Throwable t$iv5) {
                thrown$iv = t$iv5;
                if ($this$use$iv != null) {
                    try {
                        $this$use$iv.close();
                    } catch (Throwable t$iv6) {
                        ExceptionsKt.addSuppressed(thrown$iv, t$iv6);
                    }
                }
                result$iv = null;
            }
        } else {
            fullEntry = centralDirectoryEntry;
        }
        return new FileMetadata(!fullEntry.isDirectory(), fullEntry.isDirectory(), null, fullEntry.isDirectory() ? null : Long.valueOf(fullEntry.getSize()), fullEntry.getCreatedAtMillis$okio(), fullEntry.getLastModifiedAtMillis$okio(), fullEntry.getLastAccessedAtMillis$okio(), null, 128, null);
    }

    @Override
    public FileHandle openReadOnly(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new UnsupportedOperationException("not implemented yet!");
    }

    @Override
    public FileHandle openReadWrite(Path file, boolean mustCreate, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("zip entries are not writable");
    }

    @Override
    public List<Path> list(Path dir) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        List<Path> list = list(dir, true);
        Intrinsics.checkNotNull(list);
        return list;
    }

    @Override
    public List<Path> listOrNull(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        return list(dir, false);
    }

    private final List<Path> list(Path dir, boolean throwOnFailure) throws IOException {
        Path canonicalDir = canonicalizeInternal(dir);
        ZipEntry entry = this.entries.get(canonicalDir);
        if (entry == null) {
            if (throwOnFailure) {
                throw new IOException("not a directory: " + dir);
            }
            return null;
        }
        return CollectionsKt.toList(entry.getChildren());
    }

    @Override
    public Source source(Path file) throws Throwable {
        Object result$iv;
        Intrinsics.checkNotNullParameter(file, "file");
        Path canonicalPath = canonicalizeInternal(file);
        ZipEntry entry = this.entries.get(canonicalPath);
        if (entry == null) {
            throw new FileNotFoundException("no such file: " + file);
        }
        Closeable $this$use$iv = this.fileSystem.openReadOnly(this.zipPath);
        Throwable thrown$iv = null;
        try {
            FileHandle fileHandle = (FileHandle) $this$use$iv;
            result$iv = Okio.buffer(fileHandle.source(entry.getOffset()));
            if ($this$use$iv != null) {
                try {
                    $this$use$iv.close();
                } catch (Throwable t$iv) {
                    thrown$iv = t$iv;
                }
            }
        } catch (Throwable t$iv2) {
            thrown$iv = t$iv2;
            if ($this$use$iv != null) {
                try {
                    $this$use$iv.close();
                } catch (Throwable t$iv3) {
                    ExceptionsKt.addSuppressed(thrown$iv, t$iv3);
                }
            }
            result$iv = null;
        }
        if (thrown$iv == null) {
            BufferedSource source = (BufferedSource) result$iv;
            ZipFilesKt.skipLocalHeader(source);
            if (entry.getCompressionMethod() == 0) {
                return new FixedLengthSource(source, entry.getSize(), true);
            }
            InflaterSource inflaterSource = new InflaterSource(new FixedLengthSource(source, entry.getCompressedSize(), true), new Inflater(true));
            return new FixedLengthSource(inflaterSource, entry.getSize(), false);
        }
        throw thrown$iv;
    }

    @Override
    public Sink sink(Path file, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override
    public Sink appendingSink(Path file, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("zip file systems are read-only");
    }

    @Override
    public void createDirectory(Path dir, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        throw new IOException("zip file systems are read-only");
    }

    @Override
    public void atomicMove(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Override
    public void delete(Path path, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        throw new IOException("zip file systems are read-only");
    }

    @Override
    public void createSymlink(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new IOException("zip file systems are read-only");
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lni/shikatu/okio/ZipFileSystem$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "ROOT", "Lni/shikatu/okio/Path;", "getROOT", "()Lokio/Path;", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Path getROOT() {
            return ZipFileSystem.ROOT;
        }
    }
}
