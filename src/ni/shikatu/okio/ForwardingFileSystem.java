package ni.shikatu.okio;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.kotlin.sequences.Sequence;
import ni.shikatu.kotlin.sequences.SequencesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\b&\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0001¢\u0006\u0004\b\u0003\u0010\u0004J \u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\r\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\u0007H\u0016J\u0016\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u0018\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u00112\u0006\u0010\u0012\u001a\u00020\u0007H\u0016J\u001e\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00070\u00152\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J \u0010\u001b\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00172\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\u0018\u0010 \u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\u0018\u0010\"\u001a\u00020!2\u0006\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\u0018\u0010#\u001a\u00020$2\u0006\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u0017H\u0016J\u0018\u0010%\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0016J\u0018\u0010'\u001a\u00020$2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0017H\u0016J\u0018\u0010(\u001a\u00020$2\u0006\u0010\u001e\u001a\u00020\u00072\u0006\u0010&\u001a\u00020\u0007H\u0016J\b\u0010)\u001a\u00020$H\u0016J\b\u0010*\u001a\u00020\nH\u0016R\u0013\u0010\u0002\u001a\u00020\u00018\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0005¨\u0006+"}, d2 = {"Lni/shikatu/okio/ForwardingFileSystem;", "Lni/shikatu/okio/FileSystem;", "delegate", "<init>", "(Lokio/FileSystem;)V", "()Lokio/FileSystem;", "onPathParameter", "Lni/shikatu/okio/Path;", "path", "functionName", _UrlKt.FRAGMENT_ENCODE_SET, "parameterName", "onPathResult", "canonicalize", "metadataOrNull", "Lni/shikatu/okio/FileMetadata;", "list", _UrlKt.FRAGMENT_ENCODE_SET, "dir", "listOrNull", "listRecursively", "Lni/shikatu/kotlin/sequences/Sequence;", "followSymlinks", _UrlKt.FRAGMENT_ENCODE_SET, "openReadOnly", "Lni/shikatu/okio/FileHandle;", "file", "openReadWrite", "mustCreate", "mustExist", "source", "Lni/shikatu/okio/Source;", "sink", "Lni/shikatu/okio/Sink;", "appendingSink", "createDirectory", _UrlKt.FRAGMENT_ENCODE_SET, "atomicMove", "target", "delete", "createSymlink", "close", "toString", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ForwardingFileSystem extends FileSystem {
    private final FileSystem delegate;

    public ForwardingFileSystem(FileSystem delegate) {
        Intrinsics.checkNotNullParameter(delegate, "delegate");
        this.delegate = delegate;
    }

    public final FileSystem delegate() {
        return this.delegate;
    }

    public Path onPathParameter(Path path, String functionName, String parameterName) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        Intrinsics.checkNotNullParameter(parameterName, "parameterName");
        return path;
    }

    public Path onPathResult(Path path, String functionName) {
        Intrinsics.checkNotNullParameter(path, "path");
        Intrinsics.checkNotNullParameter(functionName, "functionName");
        return path;
    }

    @Override
    public Path canonicalize(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        Path result = this.delegate.canonicalize(onPathParameter(path, "canonicalize", "path"));
        return onPathResult(result, "canonicalize");
    }

    @Override
    public FileMetadata metadataOrNull(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        FileMetadata metadataOrNull = this.delegate.metadataOrNull(onPathParameter(path, "metadataOrNull", "path"));
        if (metadataOrNull == null) {
            return null;
        }
        if (metadataOrNull.getSymlinkTarget() == null) {
            return metadataOrNull;
        }
        Path symlinkTarget = onPathResult(metadataOrNull.getSymlinkTarget(), "metadataOrNull");
        return FileMetadata.copy$default(metadataOrNull, false, false, symlinkTarget, null, null, null, null, null, 251, null);
    }

    @Override
    public List<Path> list(Path dir) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Iterable $this$mapTo$iv = this.delegate.list(onPathParameter(dir, "list", "dir"));
        Collection destination$iv = (List) new ArrayList();
        for (Object item$iv : $this$mapTo$iv) {
            Path it = (Path) item$iv;
            destination$iv.add(onPathResult(it, "list"));
        }
        List paths = (List) destination$iv;
        CollectionsKt.sort(paths);
        return paths;
    }

    @Override
    public List<Path> listOrNull(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        Iterable iterableListOrNull = this.delegate.listOrNull(onPathParameter(dir, "listOrNull", "dir"));
        if (iterableListOrNull == null) {
            return null;
        }
        Iterable $this$mapTo$iv = iterableListOrNull;
        Collection destination$iv = (List) new ArrayList();
        for (Object item$iv : $this$mapTo$iv) {
            Path it = (Path) item$iv;
            destination$iv.add(onPathResult(it, "listOrNull"));
        }
        List paths = (List) destination$iv;
        CollectionsKt.sort(paths);
        return paths;
    }

    @Override
    public Sequence<Path> listRecursively(Path dir, boolean followSymlinks) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        return SequencesKt.map(this.delegate.listRecursively(onPathParameter(dir, "listRecursively", "dir"), followSymlinks), new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return ForwardingFileSystem.listRecursively$lambda$0(this.f$0, (Path) obj);
            }
        });
    }

    public static final Path listRecursively$lambda$0(ForwardingFileSystem this$0, Path it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return this$0.onPathResult(it, "listRecursively");
    }

    @Override
    public FileHandle openReadOnly(Path file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        return this.delegate.openReadOnly(onPathParameter(file, "openReadOnly", "file"));
    }

    @Override
    public FileHandle openReadWrite(Path file, boolean mustCreate, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        return this.delegate.openReadWrite(onPathParameter(file, "openReadWrite", "file"), mustCreate, mustExist);
    }

    @Override
    public Source source(Path file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        return this.delegate.source(onPathParameter(file, "source", "file"));
    }

    @Override
    public Sink sink(Path file, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        return this.delegate.sink(onPathParameter(file, "sink", "file"), mustCreate);
    }

    @Override
    public Sink appendingSink(Path file, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        return this.delegate.appendingSink(onPathParameter(file, "appendingSink", "file"), mustExist);
    }

    @Override
    public void createDirectory(Path dir, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        this.delegate.createDirectory(onPathParameter(dir, "createDirectory", "dir"), mustCreate);
    }

    @Override
    public void atomicMove(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        this.delegate.atomicMove(onPathParameter(source, "atomicMove", "source"), onPathParameter(target, "atomicMove", "target"));
    }

    @Override
    public void delete(Path path, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        this.delegate.delete(onPathParameter(path, "delete", "path"), mustExist);
    }

    @Override
    public void createSymlink(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        this.delegate.createSymlink(onPathParameter(source, "createSymlink", "source"), onPathParameter(target, "createSymlink", "target"));
    }

    @Override
    public void close() throws IOException {
        this.delegate.close();
    }

    public String toString() {
        return Reflection.getOrCreateKotlinClass(getClass()).getSimpleName() + '(' + this.delegate + ')';
    }
}
