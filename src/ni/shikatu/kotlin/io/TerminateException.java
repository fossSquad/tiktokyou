package ni.shikatu.kotlin.io;

import java.io.File;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/io/TerminateException;", "Lni/shikatu/kotlin/io/FileSystemException;", "file", "Ljava/io/File;", "<init>", "(Ljava/io/File;)V", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class TerminateException extends FileSystemException {

    public TerminateException(File file) {
        super(file, null, null, 6, null);
        Intrinsics.checkNotNullParameter(file, "file");
    }
}
