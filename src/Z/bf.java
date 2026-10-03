package Z;
import ni.shikatu.kotlinx.serialization.internal.PluginExceptionsKt;

public final class bf {
    public final double a;
    public final double b;

    public bf(int i, double d, double d2) {
        if (3 != (i & 3)) {
            PluginExceptionsKt.throwMissingFieldException(i, 3, af.b);
        }
        this.a = d;
        this.b = d2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof bf)) {
            return false;
        }
        bf bfVar = (bf) obj;
        return Double.compare(this.a, bfVar.a) == 0 && Double.compare(this.b, bfVar.b) == 0;
    }

    public final int hashCode() {
        return Double.hashCode(this.b) + (Double.hashCode(this.a) * 31);
    }

    public final String toString() {
        return "SupportPricePayload(ruble=" + this.a + ", usd=" + this.b + ")";
    }
}
