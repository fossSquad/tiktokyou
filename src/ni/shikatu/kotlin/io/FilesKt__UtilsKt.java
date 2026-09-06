package ni.shikatu.kotlin.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecatedSinceKotlin;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.sequences.Sequence;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u001aR\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0087\u0080\u0004b\u0016\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\b\b\t\u0012\u0004\b\b(\nb\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u001aR\u0010\u000e\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001H\u0087\u0080\u0004b\u0016\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\b\b\t\u0012\u0004\b\b(\nb\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000f\u001a\u0016\u0010\u0017\u001a\u00020\u0003*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0016\u0010\u0019\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0016\u0010\u001a\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0018\u0010\u001b\u001a\u0004\u0018\u00010\u0001*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u0003*\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0082\u0080\u0004¢\u0006\u0002\b\u001d\u001a.\u0010\u001e\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020#H\u0087\u0080\bb\u0002\b$\u001a@\u0010%\u001a\u00020!*\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u00012\b\b\u0002\u0010 \u001a\u00020!2\u001a\b\u0002\u0010&\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020)0'H\u0087\u0080\bb\u0002\b$\u001a\u0012\u0010*\u001a\u00020!*\u00020\u0001H\u0087\u0080\bb\u0002\b$\u001a\u0016\u0010+\u001a\u00020!*\u00020\u00012\u0006\u0010,\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0016\u0010+\u001a\u00020!*\u00020\u00012\u0006\u0010,\u001a\u00020\u0003H\u0086\u0080\u0004\u001a\u0016\u0010-\u001a\u00020!*\u00020\u00012\u0006\u0010,\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0016\u0010-\u001a\u00020!*\u00020\u00012\u0006\u0010,\u001a\u00020\u0003H\u0086\u0080\u0004\u001a\u000e\u0010.\u001a\u00020\u0001*\u00020\u0001H\u0086\u0080\u0004\u001a\u0013\u0010.\u001a\u00020/*\u00020/H\u0082\u0080\u0004¢\u0006\u0002\b0\u001a\u001f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u000101*\b\u0012\u0004\u0012\u00020\u000101H\u0082\u0080\u0004¢\u0006\u0002\b0\u001a\u0016\u00102\u001a\u00020\u0001*\u00020\u00012\u0006\u00103\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0016\u00102\u001a\u00020\u0001*\u00020\u00012\u0006\u00103\u001a\u00020\u0003H\u0086\u0080\u0004\u001a\u0016\u00104\u001a\u00020\u0001*\u00020\u00012\u0006\u00103\u001a\u00020\u0001H\u0086\u0080\u0004\u001a\u0016\u00104\u001a\u00020\u0001*\u00020\u00012\u0006\u00103\u001a\u00020\u0003H\u0086\u0080\u0004\"\u0019\u0010\u0010\u001a\u00020\u0003*\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012\"\u0019\u0010\u0013\u001a\u00020\u0003*\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0012\"\u0019\u0010\u0015\u001a\u00020\u0003*\u00020\u00018FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0012¨\u00065"}, d2 = {"createTempDir", "Ljava/io/File;", "prefix", _UrlKt.FRAGMENT_ENCODE_SET, "suffix", "directory", "Lni/shikatu/kotlin/DeprecatedSinceKotlin;", "warningSince", "1.4", "errorSince", "2.3", "Lni/shikatu/kotlin/Deprecated;", "message", "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.", "createTempFile", "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.", "extension", "getExtension", "(Ljava/io/File;)Ljava/lang/String;", "invariantSeparatorsPath", "getInvariantSeparatorsPath", "nameWithoutExtension", "getNameWithoutExtension", "toRelativeString", "base", "relativeTo", "relativeToOrSelf", "relativeToOrNull", "toRelativeStringOrNull", "toRelativeStringOrNull$FilesKt__UtilsKt", "copyTo", "target", "overwrite", _UrlKt.FRAGMENT_ENCODE_SET, "bufferSize", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/IgnorableReturnValue;", "copyRecursively", "onError", "Lni/shikatu/kotlin/Function2;", "Ljava/io/IOException;", "Lni/shikatu/kotlin/io/OnErrorAction;", "deleteRecursively", "startsWith", "other", "endsWith", "normalize", "Lni/shikatu/kotlin/io/FilePathComponents;", "normalize$FilesKt__UtilsKt", _UrlKt.FRAGMENT_ENCODE_SET, "resolve", "relative", "resolveSibling", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/io/FilesKt")
class FilesKt__UtilsKt extends FilesKt__FileTreeWalkKt {
    public static  File createTempDir$default(String str, String str2, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "tmp";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            file = null;
        }
        return FilesKt.createTempDir(str, str2, file);
    }

    @Deprecated(message = "Avoid creating temporary directories in the default temp location with this function due to too wide permissions on the newly created directory. Use kotlin.io.path.createTempDirectory instead.")
    @DeprecatedSinceKotlin(errorSince = "2.3", warningSince = "1.4")
    public static final File createTempDir(String prefix, String suffix, File directory) throws IOException {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        File dir = File.createTempFile(prefix, suffix, directory);
        dir.delete();
        if (dir.mkdir()) {
            Intrinsics.checkNotNull(dir);
            return dir;
        }
        throw new IOException("Unable to create temporary directory " + dir + '.');
    }

    public static  File createTempFile$default(String str, String str2, File file, int i, Object obj) {
        if ((i & 1) != 0) {
            str = "tmp";
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        if ((i & 4) != 0) {
            file = null;
        }
        return FilesKt.createTempFile(str, str2, file);
    }

    @Deprecated(message = "Avoid creating temporary files in the default temp location with this function due to too wide permissions on the newly created file. Use kotlin.io.path.createTempFile instead or resort to java.io.File.createTempFile.")
    @DeprecatedSinceKotlin(errorSince = "2.3", warningSince = "1.4")
    public static final File createTempFile(String prefix, String suffix, File directory) throws IOException {
        Intrinsics.checkNotNullParameter(prefix, "prefix");
        File fileCreateTempFile = File.createTempFile(prefix, suffix, directory);
        Intrinsics.checkNotNullExpressionValue(fileCreateTempFile, "createTempFile(...)");
        return fileCreateTempFile;
    }

    public static final String getExtension(File $this$extension) {
        Intrinsics.checkNotNullParameter($this$extension, "<this>");
        String name = $this$extension.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return StringsKt.substringAfterLast(name, '.', _UrlKt.FRAGMENT_ENCODE_SET);
    }

    public static final String getInvariantSeparatorsPath(File $this$invariantSeparatorsPath) {
        Intrinsics.checkNotNullParameter($this$invariantSeparatorsPath, "<this>");
        if (File.separatorChar != '/') {
            String path = $this$invariantSeparatorsPath.getPath();
            Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
            return StringsKt.replace$default(path, File.separatorChar, '/', false, 4, (Object) null);
        }
        String path2 = $this$invariantSeparatorsPath.getPath();
        Intrinsics.checkNotNullExpressionValue(path2, "getPath(...)");
        return path2;
    }

    public static final String getNameWithoutExtension(File $this$nameWithoutExtension) {
        Intrinsics.checkNotNullParameter($this$nameWithoutExtension, "<this>");
        String name = $this$nameWithoutExtension.getName();
        Intrinsics.checkNotNullExpressionValue(name, "getName(...)");
        return StringsKt.substringBeforeLast$default(name, ".", (String) null, 2, (Object) null);
    }

    public static final String toRelativeString(File $this$toRelativeString, File base) {
        Intrinsics.checkNotNullParameter($this$toRelativeString, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        String relativeStringOrNull$FilesKt__UtilsKt = toRelativeStringOrNull$FilesKt__UtilsKt($this$toRelativeString, base);
        if (relativeStringOrNull$FilesKt__UtilsKt != null) {
            return relativeStringOrNull$FilesKt__UtilsKt;
        }
        throw new IllegalArgumentException("this and base files have different roots: " + $this$toRelativeString + " and " + base + '.');
    }

    public static final File relativeTo(File $this$relativeTo, File base) {
        Intrinsics.checkNotNullParameter($this$relativeTo, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        return new File(FilesKt.toRelativeString($this$relativeTo, base));
    }

    public static final File relativeToOrSelf(File $this$relativeToOrSelf, File base) {
        Intrinsics.checkNotNullParameter($this$relativeToOrSelf, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        String p0 = toRelativeStringOrNull$FilesKt__UtilsKt($this$relativeToOrSelf, base);
        return p0 != null ? new File(p0) : $this$relativeToOrSelf;
    }

    public static final File relativeToOrNull(File $this$relativeToOrNull, File base) {
        Intrinsics.checkNotNullParameter($this$relativeToOrNull, "<this>");
        Intrinsics.checkNotNullParameter(base, "base");
        String p0 = toRelativeStringOrNull$FilesKt__UtilsKt($this$relativeToOrNull, base);
        if (p0 != null) {
            return new File(p0);
        }
        return null;
    }

    private static final String toRelativeStringOrNull$FilesKt__UtilsKt(File $this$toRelativeStringOrNull, File base) {
        FilePathComponents thisComponents = normalize$FilesKt__UtilsKt(FilesKt.toComponents($this$toRelativeStringOrNull));
        FilePathComponents baseComponents = normalize$FilesKt__UtilsKt(FilesKt.toComponents(base));
        if (!Intrinsics.areEqual(thisComponents.getRoot(), baseComponents.getRoot())) {
            return null;
        }
        int baseCount = baseComponents.getSize();
        int thisCount = thisComponents.getSize();
        int i = 0;
        int maxSameCount = Math.min(thisCount, baseCount);
        while (i < maxSameCount && Intrinsics.areEqual(thisComponents.getSegments().get(i), baseComponents.getSegments().get(i))) {
            i++;
        }
        StringBuilder res = new StringBuilder();
        int i2 = baseCount - 1;
        if (i <= i2) {
            while (!Intrinsics.areEqual(baseComponents.getSegments().get(i2).getName(), "..")) {
                res.append("..");
                if (i2 != i) {
                    res.append(File.separatorChar);
                }
                if (i2 != i) {
                    i2--;
                }
            }
            return null;
        }
        if (i < thisCount) {
            if (i < baseCount) {
                res.append(File.separatorChar);
            }
            String str = File.separator;
            Intrinsics.checkNotNullExpressionValue(str, "separator");
            CollectionsKt.joinTo(CollectionsKt.drop(thisComponents.getSegments(), i), res, (124 & 2) != 0 ? ", " : str, (124 & 4) != 0 ? _UrlKt.FRAGMENT_ENCODE_SET : null, (124 & 8) != 0 ? _UrlKt.FRAGMENT_ENCODE_SET : null, (124 & 16) != 0 ? -1 : 0, (124 & 32) != 0 ? "..." : null, (124 & 64) != 0 ? null : null);
        }
        return res.toString();
    }

    public static  File copyTo$default(File file, File file2, boolean z, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        if ((i2 & 4) != 0) {
            i = 8192;
        }
        return FilesKt.copyTo(file, file2, z, i);
    }

    @IgnorableReturnValue
    public static final File copyTo(File $this$copyTo, File target, boolean overwrite, int bufferSize) throws IOException {
        Intrinsics.checkNotNullParameter($this$copyTo, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        if (!$this$copyTo.exists()) {
            throw new NoSuchFileException($this$copyTo, null, "The source file doesn't exist.", 2, null);
        }
        if (target.exists()) {
            if (!overwrite) {
                throw new FileAlreadyExistsException($this$copyTo, target, "The destination file already exists.");
            }
            if (!target.delete()) {
                throw new FileAlreadyExistsException($this$copyTo, target, "Tried to overwrite the destination, but failed to delete it.");
            }
        }
        if ($this$copyTo.isDirectory()) {
            if (!target.mkdirs()) {
                throw new FileSystemException($this$copyTo, target, "Failed to create target directory.");
            }
        } else {
            File parentFile = target.getParentFile();
            if (parentFile != null) {
                parentFile.mkdirs();
            }
            FileInputStream fileInputStream = new FileInputStream($this$copyTo);
            try {
                FileInputStream input = fileInputStream;
                FileOutputStream fileOutputStream = new FileOutputStream(target);
                try {
                    FileOutputStream output = fileOutputStream;
                    ByteStreamsKt.copyTo(input, output, bufferSize);
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileOutputStream, null);
                    Unit unit2 = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, null);
                } catch (Throwable th) {
                    try {
                        throw th;
                    } catch (Throwable th2) {
                        CloseableKt.closeFinally(fileOutputStream, th);
                        throw th2;
                    }
                }
            } catch (Throwable th3) {
                try {
                    throw th3;
                } catch (Throwable th4) {
                    CloseableKt.closeFinally(fileInputStream, th3);
                    throw th4;
                }
            }
        }
        return target;
    }

    public static  boolean copyRecursively$default(File file, File file2, boolean z, Function2 function2, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            function2 = new Function2() {
                @Override
                public final Object invoke(Object obj2, Object obj3) {
                    return FilesKt__UtilsKt.copyRecursively$lambda$0$FilesKt__UtilsKt((File) obj2, (IOException) obj3);
                }
            };
        }
        return FilesKt.copyRecursively(file, file2, z, function2);
    }

    public static final OnErrorAction copyRecursively$lambda$0$FilesKt__UtilsKt(File file, IOException exception) throws IOException {
        Intrinsics.checkNotNullParameter(file, "<unused var>");
        Intrinsics.checkNotNullParameter(exception, "exception");
        throw exception;
    }

    @IgnorableReturnValue
    public static final boolean copyRecursively(File $this$copyRecursively, File target, boolean overwrite, final Function2<? super File, ? super IOException, ? extends OnErrorAction> function2) {
        boolean stillExists;
        Intrinsics.checkNotNullParameter($this$copyRecursively, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        Intrinsics.checkNotNullParameter(function2, "onError");
        if (!$this$copyRecursively.exists()) {
            return function2.invoke($this$copyRecursively, new NoSuchFileException($this$copyRecursively, null, "The source file doesn't exist.", 2, null)) != OnErrorAction.TERMINATE;
        }
        try {
            for (File src : FilesKt.walkTopDown($this$copyRecursively).onFail(new Function2() {
                @Override
                public final Object invoke(Object obj, Object obj2) {
                    return FilesKt__UtilsKt.copyRecursively$lambda$1$FilesKt__UtilsKt(function2, (File) obj, (IOException) obj2);
                }
            })) {
                if (src.exists()) {
                    String relPath = FilesKt.toRelativeString(src, $this$copyRecursively);
                    File dstFile = new File(target, relPath);
                    if (dstFile.exists() && (!src.isDirectory() || !dstFile.isDirectory())) {
                        if (!overwrite) {
                            stillExists = true;
                        } else if (dstFile.isDirectory()) {
                            stillExists = !FilesKt.deleteRecursively(dstFile);
                        } else {
                            stillExists = !dstFile.delete();
                        }
                        if (stillExists) {
                            if (function2.invoke(dstFile, new FileAlreadyExistsException(src, dstFile, "The destination file already exists.")) == OnErrorAction.TERMINATE) {
                                return false;
                            }
                        }
                    }
                    boolean stillExists2 = src.isDirectory();
                    if (stillExists2) {
                        dstFile.mkdirs();
                    } else {
                        boolean overwrite2 = overwrite;
                        try {
                            if (FilesKt.copyTo$default(src, dstFile, overwrite2, 0, 4, null).length() != src.length()) {
                                if (function2.invoke(src, new IOException("Source file wasn't copied completely, length of destination file differs.")) == OnErrorAction.TERMINATE) {
                                    return false;
                                }
                                overwrite = overwrite2;
                            } else {
                                overwrite = overwrite2;
                            }
                        } catch (TerminateException e) {
                        }
                    }
                } else {
                    try {
                        if (function2.invoke(src, new NoSuchFileException(src, null, "The source file doesn't exist.", 2, null)) == OnErrorAction.TERMINATE) {
                            return false;
                        }
                    } catch (TerminateException e2) {
                    }
                }
                return false;
            }
            return true;
        } catch (TerminateException e3) {
        }
    }

    public static final Unit copyRecursively$lambda$1$FilesKt__UtilsKt(Function2 $onError, File f, IOException e) throws TerminateException {
        Intrinsics.checkNotNullParameter(f, "f");
        Intrinsics.checkNotNullParameter(e, "e");
        if ($onError.invoke(f, e) != OnErrorAction.TERMINATE) {
            return Unit.INSTANCE;
        }
        throw new TerminateException(f);
    }

    @IgnorableReturnValue
    public static final boolean deleteRecursively(File $this$deleteRecursively) {
        Intrinsics.checkNotNullParameter($this$deleteRecursively, "<this>");
        Sequence $this$fold$iv = FilesKt.walkBottomUp($this$deleteRecursively);
        boolean accumulator$iv = true;
        for (Object element$iv : $this$fold$iv) {
            File it = (File) element$iv;
            boolean res = accumulator$iv;
            accumulator$iv = (it.delete() || !it.exists()) && res;
        }
        return accumulator$iv;
    }

    public static final boolean startsWith(File $this$startsWith, File other) {
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        FilePathComponents components = FilesKt.toComponents($this$startsWith);
        FilePathComponents otherComponents = FilesKt.toComponents(other);
        if (Intrinsics.areEqual(components.getRoot(), otherComponents.getRoot()) && components.getSize() >= otherComponents.getSize()) {
            return components.getSegments().subList(0, otherComponents.getSize()).equals(otherComponents.getSegments());
        }
        return false;
    }

    public static final boolean startsWith(File $this$startsWith, String other) {
        Intrinsics.checkNotNullParameter($this$startsWith, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return FilesKt.startsWith($this$startsWith, new File(other));
    }

    public static final boolean endsWith(File $this$endsWith, File other) {
        Intrinsics.checkNotNullParameter($this$endsWith, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        FilePathComponents components = FilesKt.toComponents($this$endsWith);
        FilePathComponents otherComponents = FilesKt.toComponents(other);
        if (otherComponents.isRooted()) {
            return Intrinsics.areEqual($this$endsWith, other);
        }
        int shift = components.getSize() - otherComponents.getSize();
        if (shift < 0) {
            return false;
        }
        return components.getSegments().subList(shift, components.getSize()).equals(otherComponents.getSegments());
    }

    public static final boolean endsWith(File $this$endsWith, String other) {
        Intrinsics.checkNotNullParameter($this$endsWith, "<this>");
        Intrinsics.checkNotNullParameter(other, "other");
        return FilesKt.endsWith($this$endsWith, new File(other));
    }

    public static final File normalize(File $this$normalize) {
        Intrinsics.checkNotNullParameter($this$normalize, "<this>");
        FilePathComponents $this$normalize_u24lambda_u240 = FilesKt.toComponents($this$normalize);
        File root = $this$normalize_u24lambda_u240.getRoot();
        List<File> listNormalize$FilesKt__UtilsKt = normalize$FilesKt__UtilsKt($this$normalize_u24lambda_u240.getSegments());
        String str = File.separator;
        Intrinsics.checkNotNullExpressionValue(str, "separator");
        return FilesKt.resolve(root, CollectionsKt.joinToString$default(listNormalize$FilesKt__UtilsKt, str, null, null, 0, null, null, 62, null));
    }

    private static final FilePathComponents normalize$FilesKt__UtilsKt(FilePathComponents $this$normalize) {
        return new FilePathComponents($this$normalize.getRoot(), normalize$FilesKt__UtilsKt($this$normalize.getSegments()));
    }

    private static final List<File> normalize$FilesKt__UtilsKt(List<? extends File> list) {
        List list2 = new ArrayList(list.size());
        for (File file : list) {
            String name = file.getName();
            if (Intrinsics.areEqual(name, ".")) {
                Unit unit = Unit.INSTANCE;
            } else if (Intrinsics.areEqual(name, "..")) {
            } else {
                Boolean.valueOf(list2.add(file));
            }
        }
        return list2;
    }

    public static final File resolve(File $this$resolve, File relative) {
        Intrinsics.checkNotNullParameter($this$resolve, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        if (FilesKt.isRooted(relative)) {
            return relative;
        }
        String baseName = $this$resolve.toString();
        Intrinsics.checkNotNullExpressionValue(baseName, "toString(...)");
        return ((baseName.length() == 0) || StringsKt.endsWith$default((CharSequence) baseName, File.separatorChar, false, 2, (Object) null)) ? new File(baseName + relative) : new File(baseName + File.separatorChar + relative);
    }

    public static final File resolve(File $this$resolve, String relative) {
        Intrinsics.checkNotNullParameter($this$resolve, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        return FilesKt.resolve($this$resolve, new File(relative));
    }

    public static final File resolveSibling(File $this$resolveSibling, File relative) {
        Intrinsics.checkNotNullParameter($this$resolveSibling, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        FilePathComponents components = FilesKt.toComponents($this$resolveSibling);
        File parentSubPath = components.getSize() == 0 ? new File("..") : components.subPath(0, components.getSize() - 1);
        return FilesKt.resolve(FilesKt.resolve(components.getRoot(), parentSubPath), relative);
    }

    public static final File resolveSibling(File $this$resolveSibling, String relative) {
        Intrinsics.checkNotNullParameter($this$resolveSibling, "<this>");
        Intrinsics.checkNotNullParameter(relative, "relative");
        return FilesKt.resolveSibling($this$resolveSibling, new File(relative));
    }
}
