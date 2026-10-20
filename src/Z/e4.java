package Z;
import java.util.List;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class e4 {
    public final String a;
    public final List b;

    public e4(String str, List list) {
        this.a = str;
        this.b = list;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e4)) {
            return false;
        }
        e4 e4Var = (e4) obj;
        return Intrinsics.areEqual(this.a, e4Var.a) && Intrinsics.areEqual(this.b, e4Var.b);
    }

    public final int hashCode() {
        return this.b.hashCode() + (this.a.hashCode() * 31);
    }

    public final String toString() {
        String str = this.a;
        return (new StringBuilder()).append("ChoiceGroup(title=").append(str).append(", choices=").append(this.b).append(")").toString();
    }
}
