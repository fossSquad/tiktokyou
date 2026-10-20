package Z;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.internal.PluginExceptionsKt;

public final class z1 {
    public final String a;
    public final boolean b;
    public final String c;
    public final String d;
    public final Boolean e;
    public final String f;
    public final String g;

    public z1(int i, String str, boolean z, String str2, String str3, Boolean bool, String str4, String str5) {
        if (1 != (i & 1)) {
            PluginExceptionsKt.throwMissingFieldException(i, 1, y1.b);
        }
        this.a = str;
        if ((i & 2) == 0) {
            this.b = false;
        } else {
            this.b = z;
        }
        if ((i & 4) == 0) {
            this.c = null;
        } else {
            this.c = str2;
        }
        if ((i & 8) == 0) {
            this.d = null;
        } else {
            this.d = str3;
        }
        if ((i & 16) == 0) {
            this.e = null;
        } else {
            this.e = bool;
        }
        if ((i & 32) == 0) {
            this.f = null;
        } else {
            this.f = str4;
        }
        if ((i & 64) == 0) {
            this.g = null;
        } else {
            this.g = str5;
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof z1)) {
            return false;
        }
        z1 z1Var = (z1) obj;
        return Intrinsics.areEqual(this.a, z1Var.a) && this.b == z1Var.b && Intrinsics.areEqual(this.c, z1Var.c) && Intrinsics.areEqual(this.d, z1Var.d) && Intrinsics.areEqual(this.e, z1Var.e) && Intrinsics.areEqual(this.f, z1Var.f) && Intrinsics.areEqual(this.g, z1Var.g);
    }

    public final int hashCode() {
        int iHashCode = (Boolean.hashCode(this.b) + (this.a.hashCode() * 31)) * 31;
        String str = this.c;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.d;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Boolean bool = this.e;
        int iHashCode4 = (iHashCode3 + (bool == null ? 0 : bool.hashCode())) * 31;
        String str3 = this.f;
        int iHashCode5 = (iHashCode4 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.g;
        return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
    }

    public final String toString() {
        String str = this.a;
        boolean z = this.b;
        String str2 = this.c;
        String str3 = this.d;
        Boolean bool = this.e;
        String str4 = this.f;
        return ve.a("gekKutQZl+NcUqzvS+c1AO6VmwLK+vXKc2wGBCfsyn0=", "bLc6OiNr3ruCq1vy", "aes", ve.a("q3Pvii5FfCOQ8Yv+DX97cW4YALCjvw+BJ1UvP3O8pwM=", "8Nr7OwrlnYxUnh7C", "aes", ve.a("VsJ8Q08Na7KE60hBBbzUZq5itBbKbiGtshfaKJjQLTI=", "fQICMLlAPxTOx74i", "aes", ve.a("UvOYVJLn0Puo2rNQ6XwPzS3ycJqD7p13e0Bj8bjm/6E=", "xiqdx6Kd6gNoF7CC", "aes", ve.a("r3Gf901f7QKaoYnMi2+OIFUnBISK+5Y55Gt8u7Ic5JgOmf2mRTnJjLU5UMCruhxQ", "Xy2o7u6lTLu8OTEp", "aes", new StringBuilder(), str).append(", isDeveloper=").append(z), str2), str3).append(", tinted=").append(bool), str4), this.g).append(")").toString();
    }
}
