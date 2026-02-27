package ni.shikatu.kotlin.io.path;

import java.io.IOException;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystemException;
import java.nio.file.FileSystemLoopException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.SecureDirectoryStream;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributeView;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import ni.shikatu.kotlin.ExceptionsKt;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.io.CloseableKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.functions.Function3;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.SpreadBuilder;

@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\f\u001aw\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012Q\b\u0002\u0010\u0003\u001aK\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u00150\bj\u0002`\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0007\u001a´\u0001\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012Q\b\u0002\u0010\u0003\u001aK\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0017\u0012\u00150\bj\u0002`\n¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u000b0\u00042\u0006\u0010\f\u001a\u00020\r2C\b\u0002\u0010\u000f\u001a=\u0012\u0004\u0012\u00020\u0010\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0002\u0012\u0004\u0012\u00020\u00110\u0004¢\u0006\u0002\b\u0012H\u0007\u001a\u0011\u0010\u0013\u001a\u00020\u0014*\u00020\u0011H\u0003¢\u0006\u0002\b\u0015\u001a\u0011\u0010\u0013\u001a\u00020\u0014*\u00020\u000bH\u0003¢\u0006\u0002\b\u0015\u001a\f\u0010\u0016\u001a\u00020\u0017*\u00020\u0001H\u0007\u001a\u001b\u0010\u0018\u001a\f\u0012\b\u0012\u00060\bj\u0002`\n0\u0019*\u00020\u0001H\u0002¢\u0006\u0002\b\u001a\u001a$\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u001c\u001a\u00020\u001d2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00170\u001fH\u0082\b¢\u0006\u0002\b \u001a&\u0010!\u001a\u0004\u0018\u0001H\"\"\u0004\b\u0000\u0010\"2\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u0002H\"0\u001fH\u0082\b¢\u0006\u0004\b#\u0010$\u001a1\u0010%\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\u00010&2\u0006\u0010\u0006\u001a\u00020\u00012\b\u0010'\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001c\u001a\u00020\u001dH\u0002¢\u0006\u0002\b(\u001a'\u0010)\u001a\u00020\u0017*\b\u0012\u0004\u0012\u00020\u00010&2\u0006\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001dH\u0002¢\u0006\u0002\b*\u001a5\u0010+\u001a\u00020\r*\b\u0012\u0004\u0012\u00020\u00010&2\u0006\u0010,\u001a\u00020\u00012\u0012\u0010-\u001a\n\u0012\u0006\b\u0001\u0012\u00020/0.\"\u00020/H\u0002¢\u0006\u0004\b0\u00101\u001a'\u00102\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u00012\b\u0010'\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u001c\u001a\u00020\u001dH\u0002¢\u0006\u0002\b4\u001a\u001d\u00105\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u00012\u0006\u0010\u001c\u001a\u00020\u001dH\u0002¢\u0006\u0002\b7\u001a\f\u00108\u001a\u00020\u0017*\u00020\u0001H\u0000\u001a\u0019\u00109\u001a\u00020\u0017*\u00020\u00012\u0006\u0010'\u001a\u00020\u0001H\u0002¢\u0006\u0002\b:¨\u0006;"}, d2 = {"copyToRecursively", "Ljava/nio/file/Path;", "target", "onError", "Lni/shikatu/kotlin/Function3;", "Lni/shikatu/kotlin/ParameterName;", "name", "source", "Ljava/lang/Exception;", "exception", "Lni/shikatu/kotlin/Exception;", "Lni/shikatu/kotlin/io/path/OnErrorResult;", "followLinks", "", "overwrite", "copyAction", "Lni/shikatu/kotlin/io/path/CopyActionContext;", "Lni/shikatu/kotlin/io/path/CopyActionResult;", "Lni/shikatu/kotlin/ExtensionFunctionType;", "toFileVisitResult", "Ljava/nio/file/FileVisitResult;", "toFileVisitResult$PathsKt__PathRecursiveFunctionsKt", "deleteRecursively", "", "deleteRecursivelyImpl", "", "deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt", "collectIfThrows", "collector", "Lni/shikatu/kotlin/io/path/ExceptionsCollector;", "function", "Lni/shikatu/kotlin/Function0;", "collectIfThrows$PathsKt__PathRecursiveFunctionsKt", "tryIgnoreNoSuchFileException", "R", "tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "handleEntry", "Ljava/nio/file/SecureDirectoryStream;", "parent", "handleEntry$PathsKt__PathRecursiveFunctionsKt", "enterDirectory", "enterDirectory$PathsKt__PathRecursiveFunctionsKt", "isDirectory", "entryName", "options", "", "Ljava/nio/file/LinkOption;", "isDirectory$PathsKt__PathRecursiveFunctionsKt", "(Ljava/nio/file/SecureDirectoryStream;Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Z", "insecureHandleEntry", "entry", "insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt", "insecureEnterDirectory", "path", "insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt", "checkFileName", "checkNotSameAs", "checkNotSameAs$PathsKt__PathRecursiveFunctionsKt", "ni.shikatu.kotlin-stdlib-jdk7"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "ni/shikatu/kotlin/io/path/PathsKt")
class PathsKt__PathRecursiveFunctionsKt extends PathsKt__PathReadWriteKt {

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public  class WhenMappings {
        public static final  int[] $EnumSwitchMapping$0;
        public static final  int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[CopyActionResult.values().length];
            try {
                iArr[CopyActionResult.CONTINUE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[CopyActionResult.TERMINATE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[CopyActionResult.SKIP_SUBTREE.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[OnErrorResult.values().length];
            try {
                iArr2[OnErrorResult.TERMINATE.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                iArr2[OnErrorResult.SKIP_SUBTREE.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public static  Path copyToRecursively$default(Path path, Path path2, Function3 function3, boolean z, boolean z2, int i, Object obj) {
        if ((i & 2) != 0) {
            function3 = new Function3() {
                @Override
                public final Void invoke(Path path3, Path path4, Exception exception) throws Exception {
                    Intrinsics.checkNotNullParameter(path3, "<unused var>");
                    Intrinsics.checkNotNullParameter(path4, "<unused var>");
                    Intrinsics.checkNotNullParameter(exception, "exception");
                    throw exception;
                }
            };
        }
        return PathsKt.copyToRecursively(path, path2, (Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult>) function3, z, z2);
    }

    public static final Path copyToRecursively(Path $this$copyToRecursively, Path target, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, final boolean followLinks, boolean overwrite) {
        Intrinsics.checkNotNullParameter($this$copyToRecursively, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(function3, "onError");
        if (overwrite) {
            return PathsKt.copyToRecursively($this$copyToRecursively, target, function3, followLinks, (Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult>) new Function3() {
                @Override
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$0$PathsKt__PathRecursiveFunctionsKt(followLinks, (CopyActionContext) obj, (Path) obj2, (Path) obj3);
                }
            });
        }
        return PathsKt.copyToRecursively$default($this$copyToRecursively, target, function3, followLinks, (Function3) null, 8, (Object) null);
    }

    public static final CopyActionResult copyToRecursively$lambda$0$PathsKt__PathRecursiveFunctionsKt(boolean $followLinks, CopyActionContext $this$copyToRecursively, Path src, Path dst) {
        Intrinsics.checkNotNullParameter($this$copyToRecursively, "$this$copyToRecursively");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        LinkOption[] options = LinkFollowing.INSTANCE.toLinkOptions($followLinks);
        boolean dstIsDirectory = Files.isDirectory(dst, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1));
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(options, options.length);
        boolean srcIsDirectory = Files.isDirectory(src, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
        if (!srcIsDirectory || !dstIsDirectory) {
            if (dstIsDirectory) {
                PathsKt.deleteRecursively(dst);
            }
            SpreadBuilder spreadBuilder = new SpreadBuilder(2);
            spreadBuilder.addSpread(options);
            spreadBuilder.add(StandardCopyOption.REPLACE_EXISTING);
            CopyOption[] copyOptionArr = (CopyOption[]) spreadBuilder.toArray(new CopyOption[spreadBuilder.size()]);
            Intrinsics.checkNotNullExpressionValue(Files.copy(src, dst, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length)), "copy(...)");
        }
        return CopyActionResult.CONTINUE;
    }

    public static  Path copyToRecursively$default(Path path, Path path2, Function3 function3, final boolean z, Function3 function4, int i, Object obj) {
        if ((i & 2) != 0) {
            function3 = new Function3() {
                @Override
                public final Void invoke(Path path3, Path path4, Exception exception) throws Exception {
                    Intrinsics.checkNotNullParameter(path3, "<unused var>");
                    Intrinsics.checkNotNullParameter(path4, "<unused var>");
                    Intrinsics.checkNotNullParameter(exception, "exception");
                    throw exception;
                }
            };
        }
        if ((i & 8) != 0) {
            function4 = new Function3() {
                @Override
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$1$PathsKt__PathRecursiveFunctionsKt(z, (CopyActionContext) obj2, (Path) obj3, (Path) obj4);
                }
            };
        }
        return PathsKt.copyToRecursively(path, path2, (Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult>) function3, z, (Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult>) function4);
    }

    public static final CopyActionResult copyToRecursively$lambda$1$PathsKt__PathRecursiveFunctionsKt(boolean $followLinks, CopyActionContext copyActionContext, Path src, Path dst) {
        Intrinsics.checkNotNullParameter(copyActionContext, "<this>");
        Intrinsics.checkNotNullParameter(src, "src");
        Intrinsics.checkNotNullParameter(dst, "dst");
        return copyActionContext.copyToIgnoringExistingDirectory(src, dst, $followLinks);
    }

    public static final Path copyToRecursively(final Path $this$copyToRecursively, final Path target, final Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, boolean followLinks, final Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> function4) throws FileSystemException {
        Intrinsics.checkNotNullParameter($this$copyToRecursively, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(function3, "onError");
        Intrinsics.checkNotNullParameter(function4, "copyAction");
        LinkOption[] linkOptions = LinkFollowing.INSTANCE.toLinkOptions(followLinks);
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
        if (!Files.exists($this$copyToRecursively, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length))) {
            throw new NoSuchFileException($this$copyToRecursively.toString(), target.toString(), "The source file doesn't exist.");
        }
        boolean isSubdirectory = false;
        if (Files.exists($this$copyToRecursively, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && (followLinks || !Files.isSymbolicLink($this$copyToRecursively))) {
            boolean targetExistsAndNotSymlink = Files.exists(target, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && !Files.isSymbolicLink(target);
            if (!targetExistsAndNotSymlink || !Files.isSameFile($this$copyToRecursively, target)) {
                if (Intrinsics.areEqual($this$copyToRecursively.getFileSystem(), target.getFileSystem())) {
                    if (targetExistsAndNotSymlink) {
                        isSubdirectory = target.toRealPath(new LinkOption[0]).startsWith($this$copyToRecursively.toRealPath(new LinkOption[0]));
                    } else {
                        Path it = target.getParent();
                        if (it != null && Files.exists(it, (LinkOption[]) Arrays.copyOf(new LinkOption[0], 0)) && it.toRealPath(new LinkOption[0]).startsWith($this$copyToRecursively.toRealPath(new LinkOption[0]))) {
                            isSubdirectory = true;
                        }
                    }
                }
                if (isSubdirectory) {
                    throw new FileSystemException($this$copyToRecursively.toString(), target.toString(), "Recursively copying a directory into its subdirectory is prohibited.");
                }
            }
        }
        final Path normalizedTarget = target.normalize();
        final ArrayList stack = new ArrayList();
        PathsKt.visitFileTree$default($this$copyToRecursively, 0, followLinks, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$6$PathsKt__PathRecursiveFunctionsKt(stack, function4, $this$copyToRecursively, target, normalizedTarget, function3, (FileVisitorBuilder) obj);
            }
        }, 1, (Object) null);
        return target;
    }

    private static final Path copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt(Path $this_copyToRecursively, Path $target, Path normalizedTarget, Path source) throws IllegalFileNameException {
        Path relativePath = PathsKt.relativeTo(source, $this_copyToRecursively);
        Path destination = $target.resolve(relativePath.toString());
        if (!destination.normalize().startsWith(normalizedTarget)) {
            throw new IllegalFileNameException(source, destination, "Copying files to outside the specified target directory is prohibited. The directory being recursively copied might contain an entry with an illegal name.");
        }
        Intrinsics.checkNotNull(destination);
        return destination;
    }

    public static final FileVisitResult copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function3, Path $this_copyToRecursively, Path $target, Path normalizedTarget, Path source, Exception exception) {
        return toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(function3.invoke(source, copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt($this_copyToRecursively, $target, normalizedTarget, source), exception));
    }

    public static final FileVisitResult copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt(ArrayList<Path> arrayList, Function3<? super CopyActionContext, ? super Path, ? super Path, ? extends CopyActionResult> function3, Path $this_copyToRecursively, Path $target, Path normalizedTarget, Function3<? super Path, ? super Path, ? super Exception, ? extends OnErrorResult> function4, Path source, BasicFileAttributes attributes) {
        try {
            if (!arrayList.isEmpty()) {
                PathsKt.checkFileName(source);
                Object objLast = CollectionsKt.last((List<? extends Object>) arrayList);
                Intrinsics.checkNotNullExpressionValue(objLast, "last(...)");
                checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(source, (Path) objLast);
            }
            return toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(function3.invoke(DefaultCopyActionContext.INSTANCE, source, copyToRecursively$destination$PathsKt__PathRecursiveFunctionsKt($this_copyToRecursively, $target, normalizedTarget, source)));
        } catch (Exception exception) {
            return copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt(function4, $this_copyToRecursively, $target, normalizedTarget, source, exception);
        }
    }

    public static final Unit copyToRecursively$lambda$6$PathsKt__PathRecursiveFunctionsKt(final ArrayList $stack, final Function3 $copyAction, final Path $this_copyToRecursively, final Path $target, final Path $normalizedTarget, final Function3 $onError, FileVisitorBuilder $this$visitFileTree) {
        Intrinsics.checkNotNullParameter($this$visitFileTree, "$this$visitFileTree");
        $this$visitFileTree.onPreVisitDirectory(new Function2() {
            @Override
            public final Object invoke(Object obj, Object obj2) {
                return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$6$lambda$4$PathsKt__PathRecursiveFunctionsKt($stack, $copyAction, $this_copyToRecursively, $target, $normalizedTarget, $onError, (Path) obj, (BasicFileAttributes) obj2);
            }
        });
        $this$visitFileTree.onVisitFile(new PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$2($stack, $copyAction, $this_copyToRecursively, $target, $normalizedTarget, $onError));
        $this$visitFileTree.onVisitFileFailed(new PathsKt__PathRecursiveFunctionsKt$copyToRecursively$5$3($onError, $this_copyToRecursively, $target, $normalizedTarget));
        $this$visitFileTree.onPostVisitDirectory(new Function2() {
            @Override
            public final Object invoke(Object obj, Object obj2) {
                return PathsKt__PathRecursiveFunctionsKt.copyToRecursively$lambda$6$lambda$5$PathsKt__PathRecursiveFunctionsKt($stack, $onError, $this_copyToRecursively, $target, $normalizedTarget, (Path) obj, (IOException) obj2);
            }
        });
        return Unit.INSTANCE;
    }

    public static final FileVisitResult copyToRecursively$lambda$6$lambda$4$PathsKt__PathRecursiveFunctionsKt(ArrayList $stack, Function3 $copyAction, Path $this_copyToRecursively, Path $target, Path $normalizedTarget, Function3 $onError, Path directory, BasicFileAttributes attributes) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        Intrinsics.checkNotNullParameter(attributes, "attributes");
        FileVisitResult it = copyToRecursively$copy$PathsKt__PathRecursiveFunctionsKt($stack, $copyAction, $this_copyToRecursively, $target, $normalizedTarget, $onError, directory, attributes);
        if (it == FileVisitResult.CONTINUE) {
            $stack.add(directory);
        }
        return it;
    }

    public static final FileVisitResult copyToRecursively$lambda$6$lambda$5$PathsKt__PathRecursiveFunctionsKt(ArrayList $stack, Function3 $onError, Path $this_copyToRecursively, Path $target, Path $normalizedTarget, Path directory, IOException exception) {
        Intrinsics.checkNotNullParameter(directory, "directory");
        CollectionsKt.removeLast($stack);
        if (exception == null) {
            return FileVisitResult.CONTINUE;
        }
        return copyToRecursively$error$PathsKt__PathRecursiveFunctionsKt($onError, $this_copyToRecursively, $target, $normalizedTarget, directory, exception);
    }

    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(CopyActionResult $this$toFileVisitResult) {
        switch (WhenMappings.$EnumSwitchMapping$0[$this$toFileVisitResult.ordinal()]) {
            case 1:
                return FileVisitResult.CONTINUE;
            case 2:
                return FileVisitResult.TERMINATE;
            case 3:
                return FileVisitResult.SKIP_SUBTREE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private static final FileVisitResult toFileVisitResult$PathsKt__PathRecursiveFunctionsKt(OnErrorResult $this$toFileVisitResult) {
        switch (WhenMappings.$EnumSwitchMapping$1[$this$toFileVisitResult.ordinal()]) {
            case 1:
                return FileVisitResult.TERMINATE;
            case 2:
                return FileVisitResult.SKIP_SUBTREE;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public static final void deleteRecursively(Path $this$deleteRecursively) throws IOException {
        Intrinsics.checkNotNullParameter($this$deleteRecursively, "<this>");
        Iterable iterableDeleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt = deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt($this$deleteRecursively);
        if (!((Collection) iterableDeleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt).isEmpty()) {
            FileSystemException $this$deleteRecursively_u24lambda_u248 = new FileSystemException("Failed to delete one or more files. See suppressed exceptions for details.");
            Iterable $this$forEach$iv = iterableDeleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt;
            for (Object element$iv : $this$forEach$iv) {
                Exception it = (Exception) element$iv;
                ExceptionsKt.addSuppressed($this$deleteRecursively_u24lambda_u248, it);
            }
            throw $this$deleteRecursively_u24lambda_u248;
        }
    }

    private static final List<Exception> deleteRecursivelyImpl$PathsKt__PathRecursiveFunctionsKt(Path $this$deleteRecursivelyImpl) throws IOException {
        DirectoryStream<Path> directoryStreamNewDirectoryStream;
        ExceptionsCollector collector = new ExceptionsCollector(0, 1, null);
        boolean useInsecure = true;
        Path parent = $this$deleteRecursivelyImpl.getParent();
        if (parent != null) {
            try {
                directoryStreamNewDirectoryStream = Files.newDirectoryStream(parent);
            } catch (Throwable th) {
                directoryStreamNewDirectoryStream = null;
            }
            if (directoryStreamNewDirectoryStream != null) {
                DirectoryStream<Path> directoryStream = directoryStreamNewDirectoryStream;
                try {
                    DirectoryStream<Path> directoryStream2 = directoryStream;
                    if (directoryStream2 instanceof SecureDirectoryStream) {
                        useInsecure = false;
                        collector.setPath(parent);
                        Path fileName = $this$deleteRecursivelyImpl.getFileName();
                        Intrinsics.checkNotNullExpressionValue(fileName, "getFileName(...)");
                        handleEntry$PathsKt__PathRecursiveFunctionsKt((SecureDirectoryStream) directoryStream2, fileName, null, collector);
                    }
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(directoryStream, null);
                } catch (Throwable th2) {
                    try {
                        throw th2;
                    } catch (Throwable th3) {
                        CloseableKt.closeFinally(directoryStream, th2);
                        throw th3;
                    }
                }
            }
        }
        if (useInsecure) {
            insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt($this$deleteRecursivelyImpl, null, collector);
        }
        return collector.getCollectedExceptions();
    }

    private static final void collectIfThrows$PathsKt__PathRecursiveFunctionsKt(ExceptionsCollector collector, Function0<Unit> function0) {
        try {
            function0.invoke();
        } catch (Exception exception) {
            collector.collect(exception);
        }
    }

    private static final <R> R tryIgnoreNoSuchFileException$PathsKt__PathRecursiveFunctionsKt(Function0<? extends R> function0) {
        try {
            return function0.invoke();
        } catch (NoSuchFileException e) {
            return null;
        }
    }

    private static final void handleEntry$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> secureDirectoryStream, Path name, Path parent, ExceptionsCollector collector) {
        int preEnterTotalExceptions;
        collector.enterEntry(name);
        if (parent != null) {
            try {
                Path entry = collector.getPath();
                Intrinsics.checkNotNull(entry);
                PathsKt.checkFileName(entry);
                checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(entry, parent);
                if (isDirectory$PathsKt__PathRecursiveFunctionsKt(secureDirectoryStream, name, LinkOption.NOFOLLOW_LINKS)) {
                    preEnterTotalExceptions = collector.getTotalExceptions();
                    enterDirectory$PathsKt__PathRecursiveFunctionsKt(secureDirectoryStream, name, collector);
                    if (preEnterTotalExceptions == collector.getTotalExceptions()) {
                        try {
                            secureDirectoryStream.deleteDirectory(name);
                            Unit unit = Unit.INSTANCE;
                        } catch (NoSuchFileException e) {
                        }
                    }
                } else {
                    try {
                        secureDirectoryStream.deleteFile(name);
                        Unit unit2 = Unit.INSTANCE;
                    } catch (NoSuchFileException e2) {
                    }
                }
            } catch (Exception exception$iv) {
                collector.collect(exception$iv);
            }
        } else if (isDirectory$PathsKt__PathRecursiveFunctionsKt(secureDirectoryStream, name, LinkOption.NOFOLLOW_LINKS)) {
            preEnterTotalExceptions = collector.getTotalExceptions();
            enterDirectory$PathsKt__PathRecursiveFunctionsKt(secureDirectoryStream, name, collector);
            if (preEnterTotalExceptions == collector.getTotalExceptions()) {
                secureDirectoryStream.deleteDirectory(name);
                Unit unit3 = Unit.INSTANCE;
            }
        } else {
            secureDirectoryStream.deleteFile(name);
            Unit unit4 = Unit.INSTANCE;
        }
        collector.exitEntry(name);
    }

    private static final void enterDirectory$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> secureDirectoryStream, Path name, ExceptionsCollector collector) {
        SecureDirectoryStream<Path> secureDirectoryStreamNewDirectoryStream;
        try {
            try {
                secureDirectoryStreamNewDirectoryStream = secureDirectoryStream.newDirectoryStream(name, LinkOption.NOFOLLOW_LINKS);
            } catch (Exception exception$iv) {
                collector.collect(exception$iv);
                return;
            }
        } catch (NoSuchFileException e) {
            secureDirectoryStreamNewDirectoryStream = null;
        }
        if (secureDirectoryStreamNewDirectoryStream != null) {
            SecureDirectoryStream<Path> secureDirectoryStream2 = secureDirectoryStreamNewDirectoryStream;
            try {
                SecureDirectoryStream<Path> secureDirectoryStream3 = secureDirectoryStream2;
                Iterator<Path> it = secureDirectoryStream3.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    Path entry = it.next();
                    Path fileName = entry.getFileName();
                    Intrinsics.checkNotNullExpressionValue(fileName, "getFileName(...)");
                    handleEntry$PathsKt__PathRecursiveFunctionsKt(secureDirectoryStream3, fileName, collector.getPath(), collector);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(secureDirectoryStream2, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(secureDirectoryStream2, th);
                    throw th2;
                }
            }
        }
    }

    private static final boolean isDirectory$PathsKt__PathRecursiveFunctionsKt(SecureDirectoryStream<Path> secureDirectoryStream, Path entryName, LinkOption... options) {
        Boolean boolValueOf;
        try {
            boolValueOf = Boolean.valueOf(((BasicFileAttributeView) secureDirectoryStream.getFileAttributeView(entryName, BasicFileAttributeView.class, (LinkOption[]) Arrays.copyOf(options, options.length))).readAttributes().isDirectory());
        } catch (NoSuchFileException e) {
            boolValueOf = null;
        }
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        return false;
    }

    private static final void insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(Path entry, Path parent, ExceptionsCollector collector) {
        if (parent != null) {
            try {
                PathsKt.checkFileName(entry);
                checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(entry, parent);
            } catch (Exception exception$iv) {
                collector.collect(exception$iv);
                return;
            }
        }
        if (Files.isDirectory(entry, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
            int preEnterTotalExceptions = collector.getTotalExceptions();
            insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(entry, collector);
            if (preEnterTotalExceptions == collector.getTotalExceptions()) {
                Files.deleteIfExists(entry);
                return;
            }
            return;
        }
        Files.deleteIfExists(entry);
    }

    private static final void insecureEnterDirectory$PathsKt__PathRecursiveFunctionsKt(Path path, ExceptionsCollector collector) {
        DirectoryStream<Path> directoryStreamNewDirectoryStream;
        try {
            try {
                directoryStreamNewDirectoryStream = Files.newDirectoryStream(path);
            } catch (Exception exception$iv) {
                collector.collect(exception$iv);
                return;
            }
        } catch (NoSuchFileException e) {
            directoryStreamNewDirectoryStream = null;
        }
        if (directoryStreamNewDirectoryStream != null) {
            DirectoryStream<Path> directoryStream = directoryStreamNewDirectoryStream;
            try {
                Iterator<Path> it = directoryStream.iterator();
                Intrinsics.checkNotNullExpressionValue(it, "iterator(...)");
                while (it.hasNext()) {
                    Path entry = it.next();
                    Intrinsics.checkNotNull(entry);
                    insecureHandleEntry$PathsKt__PathRecursiveFunctionsKt(entry, path, collector);
                }
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(directoryStream, null);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(directoryStream, th);
                    throw th2;
                }
            }
        }
    }

    public static final void checkFileName(Path $this$checkFileName) throws IllegalFileNameException {
        Intrinsics.checkNotNullParameter($this$checkFileName, "<this>");
        String fileName = PathsKt.getName($this$checkFileName);
        switch (fileName.hashCode()) {
            case 46:
                if (!fileName.equals(".")) {
                    return;
                }
                break;
            case 1472:
                if (!fileName.equals("..")) {
                    return;
                }
                break;
            case 1473:
                if (!fileName.equals("./")) {
                    return;
                }
                break;
            case 1518:
                if (!fileName.equals(".\\")) {
                    return;
                }
                break;
            case 45679:
                if (!fileName.equals("../")) {
                    return;
                }
                break;
            case 45724:
                if (!fileName.equals("..\\")) {
                    return;
                }
                break;
            default:
                return;
        }
        throw new IllegalFileNameException($this$checkFileName);
    }

    private static final void checkNotSameAs$PathsKt__PathRecursiveFunctionsKt(Path $this$checkNotSameAs, Path parent) throws FileSystemLoopException {
        if (!Files.isSymbolicLink($this$checkNotSameAs) && Files.isSameFile($this$checkNotSameAs, parent)) {
            throw new FileSystemLoopException($this$checkNotSameAs.toString());
        }
    }
}
