package ni.shikatu.kotlin.io.path;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bw\u0018\u00002\u00020\u0001JB\u0010\u0002\u001a\u00020\u000326\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005H¦\u0080\u0004JB\u0010\r\u001a\u00020\u000326\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\u0005H¦\u0080\u0004JB\u0010\u000f\u001a\u00020\u000326\u0010\u0004\u001a2\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u0010¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\f0\u0005H¦\u0080\u0004JD\u0010\u0012\u001a\u00020\u000328\u0010\u0004\u001a4\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0015\u0012\u0013\u0018\u00010\u0010¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\f0\u0005H¦\u0080\u0004\u0082\u0001\u0001\u0013Ê\u0001\u0010\b\u0015\u0012\f\b\u0016\u0012\b\b\fJ\u0004\b\t0\u0017Ê\u0001\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a¨\u0006\u0014"}, d2 = {"Lni/shikatu/kotlin/io/path/FileVisitorBuilder;", _UrlKt.FRAGMENT_ENCODE_SET, "onPreVisitDirectory", _UrlKt.FRAGMENT_ENCODE_SET, "function", "Lni/shikatu/kotlin/Function2;", "Ljava/nio/file/Path;", "Lni/shikatu/kotlin/ParameterName;", "name", "directory", "Ljava/nio/file/attribute/BasicFileAttributes;", "attributes", "Ljava/nio/file/FileVisitResult;", "onVisitFile", "file", "onVisitFileFailed", "Ljava/io/IOException;", "exception", "onPostVisitDirectory", "Lni/shikatu/kotlin/io/path/FileVisitorBuilderImpl;", "ni.shikatu.kotlin-stdlib-jdk7", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/io/path/ExperimentalPathApi;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "2.1"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface FileVisitorBuilder {
    void onPostVisitDirectory(Function2<? super Path, ? super IOException, ? extends FileVisitResult> function2);

    void onPreVisitDirectory(Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function2);

    void onVisitFile(Function2<? super Path, ? super BasicFileAttributes, ? extends FileVisitResult> function2);

    void onVisitFileFailed(Function2<? super Path, ? super IOException, ? extends FileVisitResult> function2);
}
