package ni.shikatu.kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArrayDeque;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\u000e2\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00102\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u0013H\u0016R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lni/shikatu/kotlin/io/path/DirectoryEntriesReader;", "Ljava/nio/file/SimpleFileVisitor;", "Ljava/nio/file/Path;", "followLinks", "", "<init>", "(Z)V", "getFollowLinks", "()Z", "directoryNode", "Lni/shikatu/kotlin/io/path/PathNode;", "entries", "Lni/shikatu/kotlin/collections/ArrayDeque;", "readEntries", "", "preVisitDirectory", "Ljava/nio/file/FileVisitResult;", "dir", "attrs", "Ljava/nio/file/attribute/BasicFileAttributes;", "visitFile", "file", "ni.shikatu.kotlin-stdlib-jdk7"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class DirectoryEntriesReader extends SimpleFileVisitor<Path> {
    private PathNode directoryNode;
    private ArrayDeque<PathNode> entries = new ArrayDeque<>();
    private final boolean followLinks;

    public DirectoryEntriesReader(boolean followLinks) {
        this.followLinks = followLinks;
    }

    public final boolean getFollowLinks() {
        return this.followLinks;
    }

    public final List<PathNode> readEntries(PathNode directoryNode) throws IOException {
        Intrinsics.checkNotNullParameter(directoryNode, "directoryNode");
        this.directoryNode = directoryNode;
        Files.walkFileTree(directoryNode.getPath(), LinkFollowing.INSTANCE.toVisitOptions(this.followLinks), 1, this);
        this.entries.removeFirst();
        ArrayDeque<PathNode> arrayDeque = this.entries;
        this.entries = new ArrayDeque<>();
        return arrayDeque;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        PathNode directoryEntry = new PathNode(dir, attrs.fileKey(), this.directoryNode);
        this.entries.add(directoryEntry);
        FileVisitResult fileVisitResultPreVisitDirectory = super.preVisitDirectory(dir, attrs);
        Intrinsics.checkNotNullExpressionValue(fileVisitResultPreVisitDirectory, "preVisitDirectory(...)");
        return fileVisitResultPreVisitDirectory;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        PathNode fileEntry = new PathNode(file, null, this.directoryNode);
        this.entries.add(fileEntry);
        FileVisitResult fileVisitResultVisitFile = super.visitFile(file, attrs);
        Intrinsics.checkNotNullExpressionValue(fileVisitResultVisitFile, "visitFile(...)");
        return fileVisitResultVisitFile;
    }
}
