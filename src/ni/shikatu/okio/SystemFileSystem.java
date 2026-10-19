package ni.shikatu.okio;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\"\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"SYSTEM", "Lni/shikatu/okio/FileSystem;", "Lni/shikatu/okio/FileSystem$Companion;", "getSYSTEM$annotations", "(Lokio/FileSystem$Companion;)V", "getSYSTEM", "(Lokio/FileSystem$Companion;)Lokio/FileSystem;", "ni.shikatu.okio"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class SystemFileSystem {
    public static  void getSYSTEM$annotations(FileSystem.Companion companion) {
    }

    public static final  FileSystem getSYSTEM(FileSystem.Companion $this$SYSTEM) {
        Intrinsics.checkNotNullParameter($this$SYSTEM, "<this>");
        return FileSystem.SYSTEM;
    }
}
