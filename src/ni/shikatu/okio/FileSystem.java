package ni.shikatu.okio;

import java.io.Closeable;
import java.io.IOException;
import java.util.List;
import ni.shikatu.kotlin.ExceptionsKt;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.JvmStatic;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.InlineMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.sequences.Sequence;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.internal.ResourceFileSystem;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u000b\b&\u0018\u0000 72\u00060\u0001j\u0002`\u0002:\u00017B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H&J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\u0006J\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0007\u001a\u00020\u0006H&J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u0006J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00060\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H&J\u0018\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u0006H&J \u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0013\u001a\u00020\fH\u0016J\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00122\u0006\u0010\u000f\u001a\u00020\u0006J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H&J$\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\f2\b\b\u0002\u0010\u0019\u001a\u00020\fH&J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u0006H&JG\u0010\u001c\u001a\u0002H\u001d\"\u0004\b\u0000\u0010\u001d2\u0006\u0010\u0016\u001a\u00020\u00062\u0017\u0010\u001e\u001a\u0013\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u0002H\u001d0\u001f¢\u0006\u0002\b!H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0004\b\"\u0010#J\u001a\u0010$\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\fH&J\u000e\u0010$\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020\u0006JQ\u0010&\u001a\u0002H\u001d\"\u0004\b\u0000\u0010\u001d2\u0006\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\f2\u0017\u0010'\u001a\u0013\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u0002H\u001d0\u001f¢\u0006\u0002\b!H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001¢\u0006\u0004\b)\u0010*J\u001a\u0010+\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\fH&J\u000e\u0010+\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020\u0006J\u001a\u0010,\u001a\u00020-2\u0006\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\fH&J\u000e\u0010,\u001a\u00020-2\u0006\u0010\u000f\u001a\u00020\u0006J\u0018\u0010.\u001a\u00020-2\u0006\u0010\u000f\u001a\u00020\u00062\b\b\u0002\u0010\u0018\u001a\u00020\fJ\u000e\u0010.\u001a\u00020-2\u0006\u0010\u000f\u001a\u00020\u0006J\u0018\u0010/\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0006H&J\u0018\u00101\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0006H\u0016J\u001a\u00102\u001a\u00020-2\u0006\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\fH&J\u000e\u00102\u001a\u00020-2\u0006\u0010\u0007\u001a\u00020\u0006J\u001a\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020\u00062\b\b\u0002\u0010\u0019\u001a\u00020\fH\u0016J\u000e\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020\u0006J\u0018\u00105\u001a\u00020-2\u0006\u0010\u001a\u001a\u00020\u00062\u0006\u00100\u001a\u00020\u0006H&J\b\u00106\u001a\u00020-H\u0016\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00068"}, d2 = {"Lni/shikatu/okio/FileSystem;", "Ljava/io/Closeable;", "Lni/shikatu/okio/Closeable;", "<init>", "()V", "canonicalize", "Lni/shikatu/okio/Path;", "path", "metadata", "Lni/shikatu/okio/FileMetadata;", "metadataOrNull", "exists", _UrlKt.FRAGMENT_ENCODE_SET, "list", _UrlKt.FRAGMENT_ENCODE_SET, "dir", "listOrNull", "listRecursively", "Lni/shikatu/kotlin/sequences/Sequence;", "followSymlinks", "openReadOnly", "Lni/shikatu/okio/FileHandle;", "file", "openReadWrite", "mustCreate", "mustExist", "source", "Lni/shikatu/okio/Source;", "read", "T", "readerAction", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/okio/BufferedSource;", "Lni/shikatu/kotlin/ExtensionFunctionType;", "-read", "(Lokio/Path;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "sink", "Lni/shikatu/okio/Sink;", "write", "writerAction", "Lni/shikatu/okio/BufferedSink;", "-write", "(Lokio/Path;ZLkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "appendingSink", "createDirectory", _UrlKt.FRAGMENT_ENCODE_SET, "createDirectories", "atomicMove", "target", "copy", "delete", "deleteRecursively", "fileOrDirectory", "createSymlink", "close", "Companion", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class FileSystem implements Closeable {
    public static final Companion Companion = new Companion(null);
    public static final FileSystem RESOURCES;
    public static final FileSystem SYSTEM;
    public static final Path SYSTEM_TEMPORARY_DIRECTORY;

    public abstract Sink appendingSink(Path path, boolean z) throws IOException;

    public abstract void atomicMove(Path path, Path path2) throws IOException;

    public abstract Path canonicalize(Path path) throws IOException;

    public abstract void createDirectory(Path path, boolean z) throws IOException;

    public abstract void createSymlink(Path path, Path path2) throws IOException;

    public abstract void delete(Path path, boolean z) throws IOException;

    public abstract List<Path> list(Path path) throws IOException;

    public abstract List<Path> listOrNull(Path path);

    public abstract FileMetadata metadataOrNull(Path path) throws IOException;

    public abstract FileHandle openReadOnly(Path path) throws IOException;

    public abstract FileHandle openReadWrite(Path path, boolean z, boolean z2) throws IOException;

    public abstract Sink sink(Path path, boolean z) throws IOException;

    public abstract Source source(Path path) throws IOException;

    public final FileMetadata metadata(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        return ni.shikatu.okio.internal.FileSystem.commonMetadata(this, path);
    }

    public final boolean exists(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        return ni.shikatu.okio.internal.FileSystem.commonExists(this, path);
    }

    public static  Sequence listRecursively$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: listRecursively");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return fileSystem.listRecursively(path, z);
    }

    public Sequence<Path> listRecursively(Path dir, boolean followSymlinks) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        return ni.shikatu.okio.internal.FileSystem.commonListRecursively(this, dir, followSymlinks);
    }

    public final Sequence<Path> listRecursively(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        return listRecursively(dir, false);
    }

    public static  FileHandle openReadWrite$default(FileSystem fileSystem, Path path, boolean z, boolean z2, int i, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openReadWrite");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        if ((i & 4) != 0) {
            z2 = false;
        }
        return fileSystem.openReadWrite(path, z, z2);
    }

    public final FileHandle openReadWrite(Path file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        return openReadWrite(file, false, false);
    }

    public static  Sink sink$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sink");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return fileSystem.sink(path, z);
    }

    public final Sink sink(Path file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        return sink(file, false);
    }

    public static  Object m1762write$default(FileSystem $this, Path file, boolean mustCreate, Function1 writerAction, int i, Object obj) throws Throwable {
        Object result$iv;
        if (obj == null) {
            if ((i & 2) != 0) {
                mustCreate = false;
            }
            Intrinsics.checkNotNullParameter(file, "file");
            Intrinsics.checkNotNullParameter(writerAction, "writerAction");
            Closeable $this$use$iv = Okio.buffer($this.sink(file, mustCreate));
            Throwable thrown$iv = null;
            try {
                BufferedSink it = (BufferedSink) $this$use$iv;
                result$iv = writerAction.invoke(it);
                InlineMarker.finallyStart(1);
                if ($this$use$iv != null) {
                    try {
                        $this$use$iv.close();
                    } catch (Throwable t$iv) {
                        thrown$iv = t$iv;
                    }
                }
                InlineMarker.finallyEnd(1);
            } catch (Throwable t$iv2) {
                thrown$iv = t$iv2;
                InlineMarker.finallyStart(1);
                if ($this$use$iv != null) {
                    try {
                        $this$use$iv.close();
                    } catch (Throwable t$iv3) {
                        ExceptionsKt.addSuppressed(thrown$iv, t$iv3);
                    }
                }
                InlineMarker.finallyEnd(1);
                result$iv = null;
            }
            if (thrown$iv == null) {
                return result$iv;
            }
            throw thrown$iv;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: write");
    }

    public static  Sink appendingSink$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: appendingSink");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        return fileSystem.appendingSink(path, z);
    }

    public final Sink appendingSink(Path file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        return appendingSink(file, false);
    }

    public static  void createDirectory$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectory");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        fileSystem.createDirectory(path, z);
    }

    public final void createDirectory(Path dir) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        createDirectory(dir, false);
    }

    public static  void createDirectories$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createDirectories");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        fileSystem.createDirectories(path, z);
    }

    public final void createDirectories(Path dir, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        ni.shikatu.okio.internal.FileSystem.commonCreateDirectories(this, dir, mustCreate);
    }

    public final void createDirectories(Path dir) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        createDirectories(dir, false);
    }

    public void copy(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        ni.shikatu.okio.internal.FileSystem.commonCopy(this, source, target);
    }

    public static  void delete$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: delete");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        fileSystem.delete(path, z);
    }

    public final void delete(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        delete(path, false);
    }

    public static  void deleteRecursively$default(FileSystem fileSystem, Path path, boolean z, int i, Object obj) throws IOException {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: deleteRecursively");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        fileSystem.deleteRecursively(path, z);
    }

    public void deleteRecursively(Path fileOrDirectory, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(fileOrDirectory, "fileOrDirectory");
        ni.shikatu.okio.internal.FileSystem.commonDeleteRecursively(this, fileOrDirectory, mustExist);
    }

    public final void deleteRecursively(Path fileOrDirectory) throws IOException {
        Intrinsics.checkNotNullParameter(fileOrDirectory, "fileOrDirectory");
        deleteRecursively(fileOrDirectory, false);
    }

    @Override
    public void close() throws IOException {
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\t\u001a\u00020\u0005*\u00020\nH\u0007¢\u0006\u0002\b\u000bR\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lni/shikatu/okio/FileSystem$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "SYSTEM", "Lni/shikatu/okio/FileSystem;", "SYSTEM_TEMPORARY_DIRECTORY", "Lni/shikatu/okio/Path;", "RESOURCES", "asOkioFileSystem", "Ljava/nio/file/FileSystem;", "get", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final FileSystem get(java.nio.file.FileSystem $this$asOkioFileSystem) {
            Intrinsics.checkNotNullParameter($this$asOkioFileSystem, "<this>");
            return new NioFileSystemWrappingFileSystem($this$asOkioFileSystem);
        }
    }

    static {
        NioSystemFileSystem jvmSystemFileSystem;
        Companion companion = Companion;
        try {
            Class.forName("java.nio.file.Files");
            jvmSystemFileSystem = new NioSystemFileSystem();
        } catch (ClassNotFoundException e) {
            jvmSystemFileSystem = new JvmSystemFileSystem();
        }
        SYSTEM = jvmSystemFileSystem;
        Path.Companion companion2 = Path.Companion;
        String property = System.getProperty("java.io.tmpdir");
        Intrinsics.checkNotNullExpressionValue(property, "getProperty(...)");
        SYSTEM_TEMPORARY_DIRECTORY = Path.Companion.get$default(companion2, property, false, 1, (Object) null);
        ClassLoader classLoader = ResourceFileSystem.class.getClassLoader();
        Intrinsics.checkNotNullExpressionValue(classLoader, "getClassLoader(...)");
        RESOURCES = new ResourceFileSystem(classLoader, false, null, 4, null);
    }

    @JvmStatic
    public static final FileSystem get(java.nio.file.FileSystem $this$get) {
        return Companion.get($this$get);
    }

    public final <T> T m1763read(Path file, Function1<? super BufferedSource, ? extends T> function1) throws Throwable {
        T tInvoke;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(function1, "readerAction");
        Closeable $this$use$iv = Okio.buffer(source(file));
        Throwable thrown$iv = null;
        try {
            BufferedSource it = (BufferedSource) $this$use$iv;
            tInvoke = function1.invoke(it);
            InlineMarker.finallyStart(1);
            if ($this$use$iv != null) {
                try {
                    $this$use$iv.close();
                } catch (Throwable t$iv) {
                    thrown$iv = t$iv;
                }
            }
            InlineMarker.finallyEnd(1);
        } catch (Throwable t$iv2) {
            thrown$iv = t$iv2;
            InlineMarker.finallyStart(1);
            if ($this$use$iv != null) {
                try {
                    $this$use$iv.close();
                } catch (Throwable t$iv3) {
                    ExceptionsKt.addSuppressed(thrown$iv, t$iv3);
                }
            }
            InlineMarker.finallyEnd(1);
            tInvoke = null;
        }
        if (thrown$iv == null) {
            return tInvoke;
        }
        throw thrown$iv;
    }

    public final <T> T m1764write(Path file, boolean mustCreate, Function1<? super BufferedSink, ? extends T> function1) throws Throwable {
        T tInvoke;
        Intrinsics.checkNotNullParameter(file, "file");
        Intrinsics.checkNotNullParameter(function1, "writerAction");
        Closeable $this$use$iv = Okio.buffer(sink(file, mustCreate));
        Throwable thrown$iv = null;
        try {
            BufferedSink it = (BufferedSink) $this$use$iv;
            tInvoke = function1.invoke(it);
            InlineMarker.finallyStart(1);
            if ($this$use$iv != null) {
                try {
                    $this$use$iv.close();
                } catch (Throwable t$iv) {
                    thrown$iv = t$iv;
                }
            }
            InlineMarker.finallyEnd(1);
        } catch (Throwable t$iv2) {
            thrown$iv = t$iv2;
            InlineMarker.finallyStart(1);
            if ($this$use$iv != null) {
                try {
                    $this$use$iv.close();
                } catch (Throwable t$iv3) {
                    ExceptionsKt.addSuppressed(thrown$iv, t$iv3);
                }
            }
            InlineMarker.finallyEnd(1);
            tInvoke = null;
        }
        if (thrown$iv == null) {
            return tInvoke;
        }
        throw thrown$iv;
    }
}
