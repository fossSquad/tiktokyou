package ni.shikatu.kotlin.io.path;

import java.nio.file.FileSystemException;
import java.nio.file.Path;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B%\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0011\bV\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0007\u0010\t¨\u0006\n"}, d2 = {"Lni/shikatu/kotlin/io/path/IllegalFileNameException;", "Ljava/nio/file/FileSystemException;", "file", "Ljava/nio/file/Path;", "other", "message", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/nio/file/Path;Ljava/nio/file/Path;Ljava/lang/String;)V", "(Ljava/nio/file/Path;)V", "ni.shikatu.kotlin-stdlib-jdk7"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class IllegalFileNameException extends FileSystemException {

    public IllegalFileNameException(Path file, Path other, String message) {
        super(file.toString(), other != null ? other.toString() : null, message);
        Intrinsics.checkNotNullParameter(file, "file");
    }

    public IllegalFileNameException(Path file) {
        this(file, null, null);
        Intrinsics.checkNotNullParameter(file, "file");
    }
}
