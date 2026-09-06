package ni.shikatu.kotlin.io.path;

import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.functions.Function3;
import ni.shikatu.kotlin.jvm.internal.FunctionReferenceImpl;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
final  class PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$3 extends FunctionReferenceImpl implements Function2<Path, Exception, FileVisitResult> {
    final  Path $normalizedTarget;
    final  Function3<Path, Path, Exception, OnErrorResult> $onError;
    final  Path $target;
    final  Path $this_copyToRecursively;

    PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$3(Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, Path path, Path path2, Path path3) {
        super(2, Intrinsics.Kotlin.class, "error", "copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(Lkotlin/jvm/functions/Function3;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/lang/Exception;)Ljava/nio/file/FileVisitResult;", 0);
        this.$onError = function3;
        this.$this_copyToRecursively = path;
        this.$target = path2;
        this.$normalizedTarget = path3;
    }

    @Override
    public final FileVisitResult invoke(Path p0, Exception p1) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        Intrinsics.checkNotNullParameter(p1, "p1");
        return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(this.$onError, this.$this_copyToRecursively, this.$target, this.$normalizedTarget, p0, p1);
    }
}
