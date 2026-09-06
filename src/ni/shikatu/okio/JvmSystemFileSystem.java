package ni.shikatu.okio;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J\u0018\u0010\f\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0005H\u0016J \u0010\t\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J \u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0011\u001a\u00020\u0005H\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0018\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0011\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u000eH\u0016J\u0018\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\u0018\u0010\u001e\u001a\u00020\u001b2\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\u000eH\u0016J\u0018\u0010\u001f\u001a\u00020\u001b2\u0006\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u001d\u001a\u00020\u0005H\u0016J\b\u0010 \u001a\u00020!H\u0016J\f\u0010\"\u001a\u00020\u001b*\u00020\u0005H\u0002J\f\u0010#\u001a\u00020\u001b*\u00020\u0005H\u0002¨\u0006$"}, d2 = {"Lni/shikatu/okio/JvmSystemFileSystem;", "Lni/shikatu/okio/FileSystem;", "<init>", "()V", "canonicalize", "Lni/shikatu/okio/Path;", "path", "metadataOrNull", "Lni/shikatu/okio/FileMetadata;", "list", _UrlKt.FRAGMENT_ENCODE_SET, "dir", "listOrNull", "throwOnFailure", _UrlKt.FRAGMENT_ENCODE_SET, "openReadOnly", "Lni/shikatu/okio/FileHandle;", "file", "openReadWrite", "mustCreate", "mustExist", "source", "Lni/shikatu/okio/Source;", "sink", "Lni/shikatu/okio/Sink;", "appendingSink", "createDirectory", _UrlKt.FRAGMENT_ENCODE_SET, "atomicMove", "target", "delete", "createSymlink", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "requireExist", "requireCreate", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class JvmSystemFileSystem extends FileSystem {
    @Override
    public Path canonicalize(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        File canonicalFile = path.toFile().getCanonicalFile();
        if (!canonicalFile.exists()) {
            throw new FileNotFoundException("no such file");
        }
        Path.Companion companion = Path.Companion;
        Intrinsics.checkNotNull(canonicalFile);
        return Path.Companion.get$default(companion, canonicalFile, false, 1, (Object) null);
    }

    @Override
    public FileMetadata metadataOrNull(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        File file = path.toFile();
        boolean isRegularFile = file.isFile();
        boolean isDirectory = file.isDirectory();
        long lastModifiedAtMillis = file.lastModified();
        long size = file.length();
        if (!isRegularFile && !isDirectory && lastModifiedAtMillis == 0 && size == 0 && !file.exists()) {
            return null;
        }
        return new FileMetadata(isRegularFile, isDirectory, null, Long.valueOf(size), null, Long.valueOf(lastModifiedAtMillis), null, null, 128, null);
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
        File file = dir.toFile();
        String[] entries = file.list();
        if (entries == null) {
            if (throwOnFailure) {
                if (file.exists()) {
                    throw new IOException("failed to list " + dir);
                }
                throw new FileNotFoundException("no such file: " + dir);
            }
            return null;
        }
        Collection destination$iv = (List) new ArrayList();
        for (String str : entries) {
            Intrinsics.checkNotNull(str);
            destination$iv.add(dir.resolve(str));
        }
        List result = (List) destination$iv;
        CollectionsKt.sort(result);
        return result;
    }

    @Override
    public FileHandle openReadOnly(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return new JvmFileHandle(false, new RandomAccessFile(file.toFile(), "r"));
    }

    @Override
    public FileHandle openReadWrite(Path file, boolean mustCreate, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!((mustCreate && mustExist) ? false : true)) {
            throw new IllegalArgumentException("Cannot require mustCreate and mustExist at the same time.".toString());
        }
        if (mustCreate) {
            requireCreate(file);
        }
        if (mustExist) {
            requireExist(file);
        }
        return new JvmFileHandle(true, new RandomAccessFile(file.toFile(), "rw"));
    }

    @Override
    public Source source(Path file) {
        Intrinsics.checkNotNullParameter(file, "file");
        return Okio.source(file.toFile());
    }

    @Override
    public Sink sink(Path file, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (mustCreate) {
            requireCreate(file);
        }
        return Okio__JvmOkioKt.sink$default(file.toFile(), false, 1, null);
    }

    @Override
    public Sink appendingSink(Path file, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (mustExist) {
            requireExist(file);
        }
        return Okio.sink(file.toFile(), true);
    }

    @Override
    public void createDirectory(Path dir, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        if (!dir.toFile().mkdir()) {
            FileMetadata fileMetadataMetadataOrNull = metadataOrNull(dir);
            boolean alreadyExist = false;
            if (fileMetadataMetadataOrNull != null && fileMetadataMetadataOrNull.isDirectory()) {
                alreadyExist = true;
            }
            if (alreadyExist) {
                if (mustCreate) {
                    throw new IOException(dir + " already exists.");
                }
                return;
            }
            throw new IOException("failed to create directory: " + dir);
        }
    }

    @Override
    public void atomicMove(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        boolean renamed = source.toFile().renameTo(target.toFile());
        if (!renamed) {
            throw new IOException("failed to move " + source + " to " + target);
        }
    }

    @Override
    public void delete(Path path, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        if (Thread.interrupted()) {
            throw new InterruptedIOException("interrupted");
        }
        File file = path.toFile();
        boolean deleted = file.delete();
        if (!deleted) {
            if (file.exists()) {
                throw new IOException("failed to delete " + path);
            }
            if (mustExist) {
                throw new FileNotFoundException("no such file: " + path);
            }
        }
    }

    @Override
    public void createSymlink(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new IOException("unsupported");
    }

    public String toString() {
        return "JvmSystemFileSystem";
    }

    private final void requireExist(Path $this$requireExist) throws IOException {
        if (!exists($this$requireExist)) {
            throw new IOException($this$requireExist + " doesn't exist.");
        }
    }

    private final void requireCreate(Path $this$requireCreate) throws IOException {
        if (exists($this$requireCreate)) {
            throw new IOException($this$requireCreate + " already exists.");
        }
    }
}
