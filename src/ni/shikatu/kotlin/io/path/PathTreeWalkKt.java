package ni.shikatu.kotlin.io.path;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\u001a'\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0082\u0080\u0004¢\u0006\u0002\u0010\u0007\u001a\u000e\u0010\b\u001a\u00020\t*\u00020\nH\u0082\u0080\u0004¨\u0006\u000b"}, d2 = {"keyOf", _UrlKt.FRAGMENT_ENCODE_SET, "path", "Ljava/nio/file/Path;", "linkOptions", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/nio/file/LinkOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/LinkOption;)Ljava/lang/Object;", "createsCycle", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/io/path/PathNode;", "ni.shikatu.kotlin-stdlib-jdk7"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class PathTreeWalkKt {

    public static final Object keyOf(Path path, LinkOption[] linkOptions) {
        try {
            LinkOption[] linkOptionArr = (LinkOption[]) Arrays.copyOf(linkOptions, linkOptions.length);
            BasicFileAttributes attributes = Files.readAttributes(path, (Class<BasicFileAttributes>) BasicFileAttributes.class, (LinkOption[]) Arrays.copyOf(linkOptionArr, linkOptionArr.length));
            Intrinsics.checkNotNullExpressionValue(attributes, "readAttributes(...)");
            return attributes.fileKey();
        } catch (Throwable th) {
            return null;
        }
    }

    public static final boolean createsCycle(PathNode $this$createsCycle) {
        for (PathNode ancestor = $this$createsCycle.getParent(); ancestor != null; ancestor = ancestor.getParent()) {
            if (ancestor.getKey() != null && $this$createsCycle.getKey() != null) {
                if (Intrinsics.areEqual(ancestor.getKey(), $this$createsCycle.getKey())) {
                    return true;
                }
            } else {
                try {
                    if (Files.isSameFile(ancestor.getPath(), $this$createsCycle.getPath())) {
                        return true;
                    }
                } catch (IOException e) {
                } catch (SecurityException e2) {
                }
            }
        }
        return false;
    }
}
