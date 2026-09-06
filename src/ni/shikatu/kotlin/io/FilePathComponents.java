package ni.shikatu.kotlin.io;

import java.io.File;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0080\b\u0018\u00002\u00020\u0001B\u001f\b@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u001a\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u0014H\u0086\u0080\u0004J\n\u0010\u001a\u001a\u00020\u0003HÆ\u0083\u0004J\u0010\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÆ\u0083\u0004J)\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005HÀ\u0081\u0004¢\u0006\u0002\b\u001dJ\u0014\u0010\u001e\u001a\u00020\u00112\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010 \u001a\u00020\u0014HÖ\u0081\u0004J\n\u0010!\u001a\u00020\rHÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001b\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\f\u001a\u00020\r8FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0015\u0010\u0010\u001a\u00020\u00118FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0012R\u0015\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\""}, d2 = {"Lni/shikatu/kotlin/io/FilePathComponents;", _UrlKt.FRAGMENT_ENCODE_SET, "root", "Ljava/io/File;", "segments", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/io/File;Ljava/util/List;)V", "getRoot", "()Ljava/io/File;", "getSegments", "()Ljava/util/List;", "rootName", _UrlKt.FRAGMENT_ENCODE_SET, "getRootName", "()Ljava/lang/String;", "isRooted", _UrlKt.FRAGMENT_ENCODE_SET, "()Z", "size", _UrlKt.FRAGMENT_ENCODE_SET, "getSize", "()I", "subPath", "beginIndex", "endIndex", "component1", "component2", "copy", "copy$kotlin_stdlib", "equals", "other", "hashCode", "toString", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class FilePathComponents {
    private final File root;
    private final List<File> segments;

    public static  FilePathComponents copy$kotlin_stdlib$default(FilePathComponents filePathComponents, File file, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            file = filePathComponents.root;
        }
        if ((i & 2) != 0) {
            list = filePathComponents.segments;
        }
        return filePathComponents.copy$kotlin_stdlib(file, list);
    }

    public final File component1() {
        return this.root;
    }

    public final List<File> component2() {
        return this.segments;
    }

    public final FilePathComponents copy$kotlin_stdlib(File file, List<? extends File> list) {
        Intrinsics.checkNotNullParameter(file, "root");
        Intrinsics.checkNotNullParameter(list, "segments");
        return new FilePathComponents(file, list);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FilePathComponents)) {
            return false;
        }
        FilePathComponents filePathComponents = (FilePathComponents) obj;
        return Intrinsics.areEqual(this.root, filePathComponents.root) && Intrinsics.areEqual(this.segments, filePathComponents.segments);
    }

    public int hashCode() {
        return (this.root.hashCode() * 31) + this.segments.hashCode();
    }

    public String toString() {
        return "FilePathComponents(root=" + this.root + ", segments=" + this.segments + ')';
    }

    public FilePathComponents(File root, List<? extends File> list) {
        Intrinsics.checkNotNullParameter(root, "root");
        Intrinsics.checkNotNullParameter(list, "segments");
        this.root = root;
        this.segments = list;
    }

    public final File getRoot() {
        return this.root;
    }

    public final List<File> getSegments() {
        return this.segments;
    }

    public final String getRootName() {
        String path = this.root.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        return path;
    }

    public final boolean isRooted() {
        String path = this.root.getPath();
        Intrinsics.checkNotNullExpressionValue(path, "getPath(...)");
        return path.length() > 0;
    }

    public final int getSize() {
        return this.segments.size();
    }

    public final File subPath(int beginIndex, int endIndex) {
        if (beginIndex < 0 || beginIndex > endIndex || endIndex > getSize()) {
            throw new IllegalArgumentException();
        }
        List<File> listSubList = this.segments.subList(beginIndex, endIndex);
        String str = File.separator;
        Intrinsics.checkNotNullExpressionValue(str, "separator");
        return new File(CollectionsKt.joinToString$default(listSubList, str, null, null, 0, null, null, 62, null));
    }
}
