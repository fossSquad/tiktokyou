package Z;
import java.util.List;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class n3 {
    public final String a;
    public final List b;

    public n3(String str, List list) {
        this.a = str;
        this.b = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n3)) {
            return false;
        }
        n3 n3Var = (n3) obj;
        return Intrinsics.areEqual(this.a, n3Var.a) && Intrinsics.areEqual(this.b, n3Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        String str = this.a;
        return new StringBuilder().append("ChoiceGroup(title=").append(str).append(", choices=").append(this.b).append(")").toString();
    }
}
