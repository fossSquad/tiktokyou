package Z;
import java.util.List;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class r3 implements s3 {
    public final List a;

    public r3(List list) {
        this.a = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof r3) && Intrinsics.areEqual(this.a, ((r3) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Ready(choices=" + this.a + ")";
    }
}
