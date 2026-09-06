package ni.shikatu.kotlin.io.path;

import java.nio.file.CopyOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.Arrays;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u0005*\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\tH\u0096\u0080\u0004Ê\u0001\u0002\b\u000b¨\u0006\n"}, d2 = {"Lni/shikatu/kotlin/io/path/DefaultCopyActionContext;", "Lni/shikatu/kotlin/io/path/CopyActionContext;", "<init>", "()V", "copyToIgnoringExistingDirectory", "Lni/shikatu/kotlin/io/path/CopyActionResult;", "Ljava/nio/file/Path;", "target", "followLinks", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib-jdk7", "Lni/shikatu/kotlin/io/path/ExperimentalPathApi;"}, k = 1, mv = {2, 4, 0}, xi = 48)
final class DefaultCopyActionContext implements CopyActionContext {
    public static final DefaultCopyActionContext INSTANCE = new DefaultCopyActionContext();

    private DefaultCopyActionContext() {
    }

    @Override
    public CopyActionResult copyToIgnoringExistingDirectory(Path $this$copyToIgnoringExistingDirectory, Path target, boolean followLinks) {
        Intrinsics.checkNotNullParameter($this$copyToIgnoringExistingDirectory, "<this>");
        Intrinsics.checkNotNullParameter(target, "target");
        LinkOption[] options = LinkFollowing.INSTANCE.toLinkOptions(followLinks);
        LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(options, options.length);
        if (Files.isDirectory($this$copyToIgnoringExistingDirectory, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length)) && Files.isDirectory(target, (LinkOption[]) Arrays.copyOf(new LinkOption[]{LinkOption.NOFOLLOW_LINKS}, 1))) {
            Unit unit = Unit.INSTANCE;
        } else {
            CopyOption[] copyOptionArr = (CopyOption[]) Arrays.copyOf(options, options.length);
            Intrinsics.checkNotNullExpressionValue(Files.copy($this$copyToIgnoringExistingDirectory, target, (CopyOption[]) Arrays.copyOf(copyOptionArr, copyOptionArr.length)), "copy(...)");
        }
        return CopyActionResult.CONTINUE;
    }
}
