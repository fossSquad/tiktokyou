package Z;
import com.windukk.mod.hooks.download.DownloadMediaStoreHooks;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class l3 {
    public final DownloadMediaStoreHooks a;
    public final DownloadMediaStoreHooks b;

    public l3(DownloadMediaStoreHooks m3Var, DownloadMediaStoreHooks m3Var2) {
        this.a = m3Var;
        this.b = m3Var2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l3)) {
            return false;
        }
        l3 l3Var = (l3) obj;
        return Intrinsics.areEqual(this.a, l3Var.a) && Intrinsics.areEqual(this.b, l3Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        return "DashSelection(video=" + this.a + ", audio=" + this.b + ")";
    }
}
