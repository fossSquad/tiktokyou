package Z;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;

public final class e0 {
    public final String a;
    public final String b;
    public final String c;
    public final int d;

    public e0(String str, String str2, String str3, int i) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = i;
    }

    public final String a() {
        String str = this.b;
        if (str != null) {
            if (StringsKt.isBlank(str)) {
                str = null;
            }
            if (str != null) {
                return str;
            }
        }
        return this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof e0)) {
            return false;
        }
        e0 e0Var = (e0) obj;
        return Intrinsics.areEqual(this.a, e0Var.a) && Intrinsics.areEqual(this.b, e0Var.b) && Intrinsics.areEqual(this.c, e0Var.c) && this.d == e0Var.d;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        return Integer.hashCode(this.d) + ((iHashCode2 + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    public final String toString() {
        String str = this.a;
        String str2 = this.b;
        String str3 = this.c;
        return ve.a("KJcwPkxUYj4dDDb2mDt7QY+ENERRC6DT+Cc0h0qFPXg=", "QNRQkmMf0ZouXjSS", "aes", ve.a("A+UMoD+pYNKCK52gw6hoTpTMarwyhKZquv3UBNcHIb4=", "khdbyDdTy1KcoEGB", "aes", ve.a("O7efznhuuFW81AkPzVCCndximfP/28rPH9VJePkpr3h+9AB6I92wPrXvjAtQCsra", "XRsBne5FRtuU84Z1", "aes", new StringBuilder(), str), str2), str3).append(", streakDays=").append(this.d).append(")").toString();
    }
}
