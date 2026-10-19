package Z;
import java.util.ArrayList;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class j0 implements l0 {
    public final ArrayList a;

    public j0(ArrayList arrayList) {
        this.a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof j0) && Intrinsics.areEqual(this.a, ((j0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Ready(partners=" + this.a + ")";
    }
}
