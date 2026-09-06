package ni.shikatu.okio;

import java.io.IOException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okio.internal.ZipFilesKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0012\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"openZip", "Lni/shikatu/okio/FileSystem;", "zipPath", "Lni/shikatu/okio/Path;", "ni.shikatu.okio"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "ni/shikatu/okio/Okio")
final  class Okio__ZlibOkioKt {
    public static final FileSystem openZip(FileSystem $this$openZip, Path zipPath) throws IOException {
        Intrinsics.checkNotNullParameter($this$openZip, "<this>");
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        return ZipFilesKt.openZip$default(zipPath, $this$openZip, null, 4, null);
    }
}
