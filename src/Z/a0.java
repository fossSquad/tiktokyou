package Z;
import java.util.ArrayList;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class a0 implements c0 {
    public final ArrayList a;

    public a0(ArrayList arrayList) {
        this.a = arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof a0) && Intrinsics.areEqual(this.a, ((a0) obj).a);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public final String toString() {
        return "Ready(partners=" + this.a + ")";
    }
}
