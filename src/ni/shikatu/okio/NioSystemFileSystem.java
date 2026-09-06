package ni.shikatu.okio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileAttribute;
import java.nio.file.attribute.FileTime;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0010\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\b\u001a\u00020\tH\u0004J\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\fH\u0002¢\u0006\u0002\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\u0018\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016¨\u0006\u0015"}, d2 = {"Lni/shikatu/okio/NioSystemFileSystem;", "Lni/shikatu/okio/JvmSystemFileSystem;", "<init>", "()V", "metadataOrNull", "Lni/shikatu/okio/FileMetadata;", "path", "Lni/shikatu/okio/Path;", "nioPath", "Ljava/nio/file/Path;", "zeroToNull", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/nio/file/attribute/FileTime;", "(Ljava/nio/file/attribute/FileTime;)Ljava/lang/Long;", "atomicMove", _UrlKt.FRAGMENT_ENCODE_SET, "source", "target", "createSymlink", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public class NioSystemFileSystem extends JvmSystemFileSystem {
    @Override
    public FileMetadata metadataOrNull(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return metadataOrNull(path.toNioPath());
    }

    protected final FileMetadata metadataOrNull(java.nio.file.Path nioPath) throws IOException {
        java.nio.file.Path symlinkTarget;
        Intrinsics.checkNotNullParameter(nioPath, "nioPath");
        try {
            BasicFileAttributes attributes = Files.readAttributes(nioPath, (Class<BasicFileAttributes>) BasicFileAttributes.class, LinkOption.NOFOLLOW_LINKS);
            if (attributes.isSymbolicLink()) {
                symlinkTarget = Files.readSymbolicLink(nioPath);
            } else {
                symlinkTarget = null;
            }
            boolean zIsRegularFile = attributes.isRegularFile();
            boolean zIsDirectory = attributes.isDirectory();
            Path path = symlinkTarget != null ? Path.Companion.get$default(Path.Companion, symlinkTarget, false, 1, (Object) null) : null;
            Long lValueOf = Long.valueOf(attributes.size());
            FileTime fileTimeCreationTime = attributes.creationTime();
            Long lZeroToNull = fileTimeCreationTime != null ? zeroToNull(fileTimeCreationTime) : null;
            FileTime fileTimeLastModifiedTime = attributes.lastModifiedTime();
            Long lZeroToNull2 = fileTimeLastModifiedTime != null ? zeroToNull(fileTimeLastModifiedTime) : null;
            FileTime fileTimeLastAccessTime = attributes.lastAccessTime();
            return new FileMetadata(zIsRegularFile, zIsDirectory, path, lValueOf, lZeroToNull, lZeroToNull2, fileTimeLastAccessTime != null ? zeroToNull(fileTimeLastAccessTime) : null, null, 128, null);
        } catch (NoSuchFileException e) {
            return null;
        } catch (FileSystemException e2) {
            return null;
        }
    }

    private final Long zeroToNull(FileTime $this$zeroToNull) {
        Long lValueOf = Long.valueOf($this$zeroToNull.toMillis());
        long it = lValueOf.longValue();
        if (it != 0) {
            return lValueOf;
        }
        return null;
    }

    @Override
    public void atomicMove(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        try {
            Files.move(source.toNioPath(), target.toNioPath(), StandardCopyOption.ATOMIC_MOVE, StandardCopyOption.REPLACE_EXISTING);
        } catch (UnsupportedOperationException e) {
            throw new IOException("atomic move not supported");
        } catch (NoSuchFileException e2) {
            throw new FileNotFoundException(e2.getMessage());
        }
    }

    @Override
    public void createSymlink(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        Files.createSymbolicLink(source.toNioPath(), target.toNioPath(), new FileAttribute[0]);
    }

    @Override
    public String toString() {
        return "NioSystemFileSystem";
    }
}
