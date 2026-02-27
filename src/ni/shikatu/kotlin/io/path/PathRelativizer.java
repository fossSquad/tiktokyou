package ni.shikatu.kotlin.io.path;

import java.nio.file.Path;
import java.nio.file.Paths;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005R\u0018\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u0018\u0010\b\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007¨\u0006\f"}, d2 = {"Lni/shikatu/kotlin/io/path/PathRelativizer;", "", "<init>", "()V", "emptyPath", "Ljava/nio/file/Path;", "ni.shikatu.kotlin.jvm.PlatformType", "Ljava/nio/file/Path;", "parentPath", "tryRelativeTo", "path", "base", "ni.shikatu.kotlin-stdlib-jdk7"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class PathRelativizer {
    public static final PathRelativizer INSTANCE = new PathRelativizer();
    private static final Path emptyPath = Paths.get("", new String[0]);
    private static final Path parentPath = Paths.get("..", new String[0]);

    private PathRelativizer() {
    }

    public final Path tryRelativeTo(Path path, Path base) {
        Path r;
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(base, "base");
        Path bn = base.normalize();
        Path pn = path.normalize();
        Path rn = bn.relativize(pn);
        int iMin = Math.min(bn.getNameCount(), pn.getNameCount());
        for (int i = 0; i < iMin && Intrinsics.areEqual(bn.getName(i), parentPath); i++) {
            if (!Intrinsics.areEqual(pn.getName(i), parentPath)) {
                throw new IllegalArgumentException("Unable to compute relative path");
            }
        }
        if (!Intrinsics.areEqual(pn, bn) && Intrinsics.areEqual(bn, emptyPath)) {
            r = pn;
        } else {
            String rnString = rn.toString();
            String separator = rn.getFileSystem().getSeparator();
            Intrinsics.checkNotNullExpressionValue(separator, "getSeparator(...)");
            if (StringsKt.endsWith$default(rnString, separator, false, 2, (Object) null)) {
                r = rn.getFileSystem().getPath(StringsKt.dropLast(rnString, rn.getFileSystem().getSeparator().length()), new String[0]);
            } else {
                r = rn;
            }
        }
        Intrinsics.checkNotNull(r);
        return r;
    }
}
