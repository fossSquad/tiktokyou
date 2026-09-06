package ni.shikatu.kotlin.io;

import java.io.File;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086\u0080\u0004\u001a\u000e\u0010\u0005\u001a\u00020\u0001*\u00020\u0002H\u0086\u0080\u0004\u001a\u000e\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0086\u0080\u0004¨\u0006\u0007"}, d2 = {"walk", "Lni/shikatu/kotlin/io/FileTreeWalk;", "Ljava/io/File;", "direction", "Lni/shikatu/kotlin/io/FileWalkDirection;", "walkTopDown", "walkBottomUp", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/io/FilesKt")
class FilesKt__FileTreeWalkKt extends FilesKt__FileReadWriteKt {
    public static  FileTreeWalk walk$default(File file, FileWalkDirection fileWalkDirection, int i, Object obj) {
        if ((i & 1) != 0) {
            fileWalkDirection = FileWalkDirection.TOP_DOWN;
        }
        return FilesKt.walk(file, fileWalkDirection);
    }

    public static final FileTreeWalk walk(File $this$walk, FileWalkDirection direction) {
        Intrinsics.checkNotNullParameter($this$walk, "<this>");
        Intrinsics.checkNotNullParameter(direction, "direction");
        return new FileTreeWalk($this$walk, direction);
    }

    public static final FileTreeWalk walkTopDown(File $this$walkTopDown) {
        Intrinsics.checkNotNullParameter($this$walkTopDown, "<this>");
        return FilesKt.walk($this$walkTopDown, FileWalkDirection.TOP_DOWN);
    }

    public static final FileTreeWalk walkBottomUp(File $this$walkBottomUp) {
        Intrinsics.checkNotNullParameter($this$walkBottomUp, "<this>");
        return FilesKt.walk($this$walkBottomUp, FileWalkDirection.BOTTOM_UP);
    }
}
