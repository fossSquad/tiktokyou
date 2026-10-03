package ni.shikatu.kotlin.io.path;

import java.nio.file.Path;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u001e\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H¦\u0080\u0004Ê\u0001\u0002\b\tÊ\u0001\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¨\u0006\b"}, d2 = {"Lni/shikatu/kotlin/io/path/CopyActionContext;", _UrlKt.FRAGMENT_ENCODE_SET, "copyToIgnoringExistingDirectory", "Lni/shikatu/kotlin/io/path/CopyActionResult;", "Ljava/nio/file/Path;", "target", "followLinks", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib-jdk7", "Lni/shikatu/kotlin/io/path/ExperimentalPathApi;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.8"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface CopyActionContext {
    CopyActionResult copyToIgnoringExistingDirectory(Path path, Path path2, boolean z);
}
