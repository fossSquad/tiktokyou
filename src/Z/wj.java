package Z;

import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.internal.PluginExceptionsKt;

public final class wj {
    public final String a;
    public final String b;
    public final String c;
    public final String d;
    public final String e;
    public final boolean f;

    public wj(int i, String str, String str2, String str3, String str4, String str5, boolean z) {
        if (15 != (i & 15)) {
            PluginExceptionsKt.throwMissingFieldException(i, 15, uj.b);
        }
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        if ((i & 16) == 0) {
            this.e = "";
        } else {
            this.e = str5;
        }
        if ((i & 32) == 0) {
            this.f = true;
        } else {
            this.f = z;
        }
    }

    public final boolean a() {
        return !Intrinsics.areEqual(this.c, "alpha");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof wj)) {
            return false;
        }
        wj wjVar = (wj) obj;
        return Intrinsics.areEqual(this.a, wjVar.a) && Intrinsics.areEqual(this.b, wjVar.b) && Intrinsics.areEqual(this.c, wjVar.c) && Intrinsics.areEqual(this.d, wjVar.d) && Intrinsics.areEqual(this.e, wjVar.e) && this.f == wjVar.f;
    }

    public final int hashCode() {
        return Boolean.hashCode(this.f) + ((this.e.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "UiHideRule(id=" + this.a + ", name=" + this.b + ", type=" + this.c + ", version=" + this.d + ", path=" + this.e + ", enabled=" + this.f + ")";
    }

    public final boolean a(wj wjVar) {
        return Intrinsics.areEqual(this.a, wjVar.a) && Intrinsics.areEqual(this.e, wjVar.e) && Intrinsics.areEqual(this.d, wjVar.d);
    }

    public wj(String str, String str2, String str3, String str4, String str5, boolean z) {
        this.a = str;
        this.b = str2;
        this.c = str3;
        this.d = str4;
        this.e = str5;
        this.f = z;
    }
}
