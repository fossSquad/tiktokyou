package Z;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class b0 implements c0 {
    public final String a;

    public b0(String str) {
        this.a = str;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof b0) && Intrinsics.areEqual(this.a, ((b0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return new StringBuilder().append("Unavailable(reason=").append(this.a).append(")").toString();
    }
}
