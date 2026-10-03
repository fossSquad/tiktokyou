package ni.shikatu.okio.internal;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.JarURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import ni.shikatu.kotlin.Lazy;
import ni.shikatu.kotlin.LazyKt;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.FileHandle;
import ni.shikatu.okio.FileMetadata;
import ni.shikatu.okio.FileSystem;
import ni.shikatu.okio.Okio;
import ni.shikatu.okio.Path;
import ni.shikatu.okio.Sink;
import ni.shikatu.okio.Source;
import ni.shikatu.okio.ZipFileSystem;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 02\u00020\u0001:\u00010B#\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0010\u0010\u0013\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fH\u0002J\u0016\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\f0\n2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0018\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\n2\u0006\u0010\u0015\u001a\u00020\fH\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\fH\u0016J \u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0012\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u0012\u001a\u00020\fH\u0016J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0019\u001a\u00020\fH\u0016J\u0018\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0018\u0010#\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0018\u0010$\u001a\u00020%2\u0006\u0010\u0015\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u0005H\u0016J\u0018\u0010&\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010'\u001a\u00020\fH\u0016J\u0018\u0010(\u001a\u00020%2\u0006\u0010\u0012\u001a\u00020\f2\u0006\u0010\u001c\u001a\u00020\u0005H\u0016J\u0018\u0010)\u001a\u00020%2\u0006\u0010\u001f\u001a\u00020\f2\u0006\u0010'\u001a\u00020\fH\u0016J\f\u0010*\u001a\u00020+*\u00020\fH\u0002J\u001e\u0010,\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000b0\n*\u00020\u0003H\u0002J\u001a\u0010-\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b*\u00020.H\u0002J\u001a\u0010/\u001a\u0010\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b*\u00020.H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R-\u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\f0\u000b0\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000e¨\u00061"}, d2 = {"Lni/shikatu/okio/internal/ResourceFileSystem;", "Lni/shikatu/okio/FileSystem;", "classLoader", "Ljava/lang/ClassLoader;", "indexEagerly", _UrlKt.FRAGMENT_ENCODE_SET, "systemFileSystem", "<init>", "(Ljava/lang/ClassLoader;ZLokio/FileSystem;)V", "roots", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/Pair;", "Lni/shikatu/okio/Path;", "getRoots", "()Ljava/util/List;", "roots$delegate", "Lni/shikatu/kotlin/Lazy;", "canonicalize", "path", "canonicalizeInternal", "list", "dir", "listOrNull", "openReadOnly", "Lni/shikatu/okio/FileHandle;", "file", "openReadWrite", "mustCreate", "mustExist", "metadataOrNull", "Lni/shikatu/okio/FileMetadata;", "source", "Lni/shikatu/okio/Source;", "sink", "Lni/shikatu/okio/Sink;", "appendingSink", "createDirectory", _UrlKt.FRAGMENT_ENCODE_SET, "atomicMove", "target", "delete", "createSymlink", "toRelativePath", _UrlKt.FRAGMENT_ENCODE_SET, "toClasspathRoots", "toFileRoot", "Ljava/net/URL;", "toJarRoot", "Companion", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ResourceFileSystem extends FileSystem {
    private static final Companion Companion = new Companion(null);
    private static final Path ROOT = Path.Companion.get$default(Path.Companion, "/", false, 1, (Object) null);
    private final ClassLoader classLoader;
    private final Lazy roots$delegate;
    private final FileSystem systemFileSystem;

    public ResourceFileSystem(ClassLoader classLoader, boolean indexEagerly, FileSystem systemFileSystem) {
        Intrinsics.checkNotNullParameter(classLoader, "classLoader");
        Intrinsics.checkNotNullParameter(systemFileSystem, "systemFileSystem");
        this.classLoader = classLoader;
        this.systemFileSystem = systemFileSystem;
        this.roots$delegate = LazyKt.lazy(new Function0() {
            @Override
            public final Object invoke() {
                return ResourceFileSystem.roots_delegate$lambda$0(this.f$0);
            }
        });
        if (!indexEagerly) {
            return;
        }
        getRoots().size();
    }

    public  ResourceFileSystem(ClassLoader classLoader, boolean z, FileSystem fileSystem, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(classLoader, z, (i & 4) != 0 ? FileSystem.SYSTEM : fileSystem);
    }

    private final List<Pair<FileSystem, Path>> getRoots() {
        return (List) this.roots$delegate.getValue();
    }

    public static final List roots_delegate$lambda$0(ResourceFileSystem this$0) {
        return this$0.toClasspathRoots(this$0.classLoader);
    }

    @Override
    public Path canonicalize(Path path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return canonicalizeInternal(path);
    }

    private final Path canonicalizeInternal(Path path) {
        return ROOT.resolve(path, true);
    }

    @Override
    public List<Path> list(Path dir) throws FileNotFoundException {
        String relativePath;
        Intrinsics.checkNotNullParameter(dir, "dir");
        String relativePath2 = toRelativePath(dir);
        Set result = new LinkedHashSet();
        Iterator<Pair<FileSystem, Path>> it = getRoots().iterator();
        boolean foundAny = false;
        while (foundAny) {
            Pair<FileSystem, Path> next = it.next();
            FileSystem fileSystem = next.component1();
            Path base = next.component2();
            try {
                Set set = result;
                Iterable $this$filter$iv = fileSystem.list(base.resolve(relativePath2));
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    Path it2 = (Path) element$iv$iv;
                    relativePath = relativePath2;
                    try {
                        if (Companion.keepPath(it2)) {
                            destination$iv$iv.add(element$iv$iv);
                        }
                        relativePath2 = relativePath;
                    } catch (IOException e) {
                        relativePath2 = relativePath;
                    }
                }
                String relativePath3 = relativePath2;
                Iterable $this$map$iv = (List) destination$iv$iv;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Path it3 = (Path) item$iv$iv;
                    destination$iv$iv2.add(Companion.removeBase(it3, base));
                    $this$map$iv = $this$map$iv;
                }
                CollectionsKt.addAll(set, (List) destination$iv$iv2);
                foundAny = true;
                relativePath2 = relativePath3;
            } catch (IOException e2) {
                relativePath = relativePath2;
            }
        }
        if (!foundAny) {
            throw new FileNotFoundException("file not found: " + dir);
        }
        return CollectionsKt.toList(result);
    }

    @Override
    public List<Path> listOrNull(Path dir) {
        Intrinsics.checkNotNullParameter(dir, "dir");
        String relativePath = toRelativePath(dir);
        Set result = new LinkedHashSet();
        boolean foundAny = false;
        Iterator<Pair<FileSystem, Path>> it = getRoots().iterator();
        while (true) {
            Collection baseResult = null;
            if (!it.hasNext()) {
                break;
            }
            Pair<FileSystem, Path> next = it.next();
            FileSystem fileSystem = next.component1();
            Path base = next.component2();
            Iterable iterableListOrNull = fileSystem.listOrNull(base.resolve(relativePath));
            if (iterableListOrNull != null) {
                Iterable $this$filter$iv = iterableListOrNull;
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    Path it2 = (Path) element$iv$iv;
                    String relativePath2 = relativePath;
                    if (Companion.keepPath(it2)) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                    relativePath = relativePath2;
                }
                relativePath = relativePath;
                Iterable $this$map$iv = (List) destination$iv$iv;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
                for (Object item$iv$iv : $this$map$iv) {
                    Path it3 = (Path) item$iv$iv;
                    destination$iv$iv2.add(Companion.removeBase(it3, base));
                }
                baseResult = (List) destination$iv$iv2;
            } else {
                relativePath = relativePath;
            }
            if (baseResult != null) {
                CollectionsKt.addAll(result, baseResult);
                foundAny = true;
            }
        }
        if (foundAny) {
            return CollectionsKt.toList(result);
        }
        return null;
    }

    @Override
    public FileHandle openReadOnly(Path file) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter(file, "file");
        String str = "file not found: ";
        if (!Companion.keepPath(file)) {
            throw new FileNotFoundException("file not found: " + file);
        }
        String relativePath = toRelativePath(file);
        for (Pair<FileSystem, Path> pair : getRoots()) {
            FileSystem fileSystem = pair.component1();
            Path base = pair.component2();
            try {
                return fileSystem.openReadOnly(base.resolve(relativePath));
            } catch (FileNotFoundException e) {
            }
        }
        throw new FileNotFoundException(str + file);
    }

    @Override
    public FileHandle openReadWrite(Path file, boolean mustCreate, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException("resources are not writable");
    }

    @Override
    public FileMetadata metadataOrNull(Path path) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        if (!Companion.keepPath(path)) {
            return null;
        }
        String relativePath = toRelativePath(path);
        for (Pair<FileSystem, Path> pair : getRoots()) {
            FileSystem fileSystem = pair.component1();
            Path base = pair.component2();
            FileMetadata fileMetadataMetadataOrNull = fileSystem.metadataOrNull(base.resolve(relativePath));
            if (fileMetadataMetadataOrNull != null) {
                return fileMetadataMetadataOrNull;
            }
        }
        return null;
    }

    @Override
    public Source source(Path file) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        if (!Companion.keepPath(file)) {
            throw new FileNotFoundException("file not found: " + file);
        }
        Path relativePath = Path.resolve$default(ROOT, file, false, 2, (Object) null).relativeTo(ROOT);
        URL resource = this.classLoader.getResource(relativePath.toString());
        if (resource == null) {
            throw new FileNotFoundException("file not found: " + file);
        }
        URLConnection urlConnection = resource.openConnection();
        if (urlConnection instanceof JarURLConnection) {
            ((JarURLConnection) urlConnection).setUseCaches(false);
        }
        InputStream inputStream = urlConnection.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream(...)");
        return Okio.source(inputStream);
    }

    @Override
    public Sink sink(Path file, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override
    public Sink appendingSink(Path file, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(file, "file");
        throw new IOException(this + " is read-only");
    }

    @Override
    public void createDirectory(Path dir, boolean mustCreate) throws IOException {
        Intrinsics.checkNotNullParameter(dir, "dir");
        throw new IOException(this + " is read-only");
    }

    @Override
    public void atomicMove(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new IOException(this + " is read-only");
    }

    @Override
    public void delete(Path path, boolean mustExist) throws IOException {
        Intrinsics.checkNotNullParameter(path, "path");
        throw new IOException(this + " is read-only");
    }

    @Override
    public void createSymlink(Path source, Path target) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        Intrinsics.checkNotNullParameter(target, "target");
        throw new IOException(this + " is read-only");
    }

    private final String toRelativePath(Path $this$toRelativePath) {
        Path canonicalThis = canonicalizeInternal($this$toRelativePath);
        return canonicalThis.relativeTo(ROOT).toString();
    }

    private final List<Pair<FileSystem, Path>> toClasspathRoots(ClassLoader $this$toClasspathRoots) throws IOException {
        Enumeration<URL> resources = $this$toClasspathRoots.getResources(_UrlKt.FRAGMENT_ENCODE_SET);
        Intrinsics.checkNotNullExpressionValue(resources, "getResources(...)");
        Iterable list = Collections.list(resources);
        Intrinsics.checkNotNullExpressionValue(list, "list(...)");
        Iterable $this$mapNotNull$iv = (List) list;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv$iv : $this$mapNotNull$iv) {
            URL it = (URL) element$iv$iv$iv;
            Intrinsics.checkNotNull(it);
            Pair<FileSystem, Path> fileRoot = toFileRoot(it);
            if (fileRoot != null) {
                destination$iv$iv.add(fileRoot);
            }
        }
        Collection collection = (List) destination$iv$iv;
        Enumeration<URL> resources2 = $this$toClasspathRoots.getResources("META-INF/MANIFEST.MF");
        Intrinsics.checkNotNullExpressionValue(resources2, "getResources(...)");
        Iterable list2 = Collections.list(resources2);
        Intrinsics.checkNotNullExpressionValue(list2, "list(...)");
        Iterable $this$mapNotNull$iv2 = (List) list2;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv$iv2 : $this$mapNotNull$iv2) {
            URL it2 = (URL) element$iv$iv$iv2;
            Intrinsics.checkNotNull(it2);
            Pair<FileSystem, Path> jarRoot = toJarRoot(it2);
            if (jarRoot != null) {
                destination$iv$iv2.add(jarRoot);
            }
        }
        return CollectionsKt.plus(collection, destination$iv$iv2);
    }

    private final Pair<FileSystem, Path> toFileRoot(URL $this$toFileRoot) {
        if (Intrinsics.areEqual($this$toFileRoot.getProtocol(), "file")) {
            return TuplesKt.to(this.systemFileSystem, Path.Companion.get$default(Path.Companion, new File($this$toFileRoot.toURI()), false, 1, (Object) null));
        }
        return null;
    }

    private final Pair<FileSystem, Path> toJarRoot(URL $this$toJarRoot) throws IOException {
        int suffixStart;
        String urlString = $this$toJarRoot.toString();
        Intrinsics.checkNotNullExpressionValue(urlString, "toString(...)");
        if (!StringsKt.startsWith$default(urlString, "jar:file:", false, 2, (Object) null) || (suffixStart = StringsKt.lastIndexOf$default((CharSequence) urlString, "!", 0, false, 6, (Object) null)) == -1) {
            return null;
        }
        Path.Companion companion = Path.Companion;
        String strSubstring = urlString.substring(4, suffixStart);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        Path path = Path.Companion.get$default(companion, new File(URI.create(strSubstring)), false, 1, (Object) null);
        ZipFileSystem zip = ZipFilesKt.openZip(path, this.systemFileSystem, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return Boolean.valueOf(ResourceFileSystem.toJarRoot$lambda$0((ZipEntry) obj));
            }
        });
        return TuplesKt.to(zip, ROOT);
    }

    public static final boolean toJarRoot$lambda$0(ZipEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        return Companion.keepPath(entry.getCanonicalPath());
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\t\u001a\u00020\u0005J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u0002R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r"}, d2 = {"Lni/shikatu/okio/internal/ResourceFileSystem$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "ROOT", "Lni/shikatu/okio/Path;", "getROOT", "()Lokio/Path;", "removeBase", "base", "keepPath", _UrlKt.FRAGMENT_ENCODE_SET, "path", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Path getROOT() {
            return ResourceFileSystem.ROOT;
        }

        public final Path removeBase(Path $this$removeBase, Path base) {
            Intrinsics.checkNotNullParameter($this$removeBase, "<this>");
            Intrinsics.checkNotNullParameter(base, "base");
            String prefix = base.toString();
            return getROOT().resolve(StringsKt.replace$default(StringsKt.removePrefix($this$removeBase.toString(), (CharSequence) prefix), AbstractJsonLexerKt.STRING_ESC, '/', false, 4, (Object) null));
        }

        public final boolean keepPath(Path path) {
            return !StringsKt.endsWith(path.name(), ".class", true);
        }
    }
}
