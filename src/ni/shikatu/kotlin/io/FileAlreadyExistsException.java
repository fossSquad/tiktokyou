package ni.shikatu.kotlin.io;

import java.io.File;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B)\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lni/shikatu/kotlin/io/FileAlreadyExistsException;", "Lni/shikatu/kotlin/io/FileSystemException;", "file", "Ljava/io/File;", "other", "reason", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/io/File;Ljava/io/File;Ljava/lang/String;)V", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class FileAlreadyExistsException extends FileSystemException {

    public FileAlreadyExistsException(File file, File other, String reason) {
        super(file, other, reason);
        Intrinsics.checkNotNullParameter(file, "file");
    }

    public  FileAlreadyExistsException(File file, File file2, String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(file, (i & 2) != 0 ? null : file2, (i & 4) != 0 ? null : str);
    }
}
