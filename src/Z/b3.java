package Z;

import com.ss.android.ugc.aweme.base.model.UrlModel;
import java.util.Locale;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;

public final class b3 {
    public final UrlModel a;
    public final String b;
    public final d4 c;
    public final sg d;
    public final lb e;
    public final jg f;
    public final long g;
    public final int h;
    public final int i;
    public final int j;
    public final int k;
    public final int l;
    public final int m;
    public final int n;
    public final String o;
    public final String p;
    public final String q;
    public final String r;
    public final String s;
    public final z2 t;

    public b3(UrlModel urlModel, String str, d4 d4Var, sg sgVar, lb lbVar, jg jgVar, long j, int i, int i2, int i3, int i4, int i5, int i6, int i7, String str2, String str3, String str4, String str5, String str6, z2 z2Var) {
        this.a = urlModel;
        this.b = str;
        this.c = d4Var;
        this.d = sgVar;
        this.e = lbVar;
        this.f = jgVar;
        this.g = j;
        this.h = i;
        this.i = i2;
        this.j = i3;
        this.k = i4;
        this.l = i5;
        this.m = i6;
        this.n = i7;
        this.o = str2;
        this.p = str3;
        this.q = str4;
        this.r = str5;
        this.s = str6;
        this.t = z2Var;
    }

    public final String a() {
        String str;
        String str2;
        String lowerCase = CollectionsKt.joinToString$default(CollectionsKt.listOfNotNull(new String[]{this.p, this.q, this.o}), " ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null).toLowerCase(Locale.US);
        return (StringsKt.contains$default(lowerCase, "mp3", false, 2, (Object) null) || StringsKt.contains$default(lowerCase, "mpeg", false, 2, (Object) null) ? ".mp3" : ".m4a");
    }

    public final boolean b() {
        return this.f == jg.b;
    }

    public final boolean c() {
        return this.f == jg.c && this.t != null;
    }

    public final boolean d() {
        return this.d == sg.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof b3)) {
            return false;
        }
        b3 b3Var = (b3) obj;
        return Intrinsics.areEqual(this.a, b3Var.a) && Intrinsics.areEqual(this.b, b3Var.b) && this.c == b3Var.c && this.d == b3Var.d && this.e == b3Var.e && this.f == b3Var.f && this.g == b3Var.g && this.h == b3Var.h && this.i == b3Var.i && this.j == b3Var.j && this.k == b3Var.k && this.l == b3Var.l && this.m == b3Var.m && this.n == b3Var.n && Intrinsics.areEqual(this.o, b3Var.o) && Intrinsics.areEqual(this.p, b3Var.p) && Intrinsics.areEqual(this.q, b3Var.q) && Intrinsics.areEqual(this.r, b3Var.r) && Intrinsics.areEqual(this.s, b3Var.s) && Intrinsics.areEqual(this.t, b3Var.t);
    }

    public final int hashCode() {
        int iHashCode = (Integer.hashCode(this.n) + ((Integer.hashCode(this.m) + ((Integer.hashCode(this.l) + ((Integer.hashCode(this.k) + ((Integer.hashCode(this.j) + ((Integer.hashCode(this.i) + ((Integer.hashCode(this.h) + ((Long.hashCode(this.g) + ((this.f.hashCode() + ((this.e.hashCode() + ((this.d.hashCode() + ((this.c.hashCode() + ((this.b.hashCode() + (this.a.hashCode() * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        String str = this.o;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.p;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.q;
        int iHashCode4 = (iHashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.r;
        int iHashCode5 = (iHashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.s;
        int iHashCode6 = (iHashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        z2 z2Var = this.t;
        return iHashCode6 + (z2Var != null ? z2Var.hashCode() : 0);
    }

    public final String toString() {
        UrlModel urlModel = this.a;
        String str = this.b;
        d4 d4Var = this.c;
        sg sgVar = this.d;
        lb lbVar = this.e;
        jg jgVar = this.f;
        long j = this.g;
        int i = this.h;
        int i2 = this.i;
        int i3 = this.j;
        int i4 = this.k;
        int i5 = this.l;
        int i6 = this.m;
        int i7 = this.n;
        String str2 = this.o;
        String str3 = this.p;
        String str4 = this.q;
        String str5 = this.r;
        String str6 = this.s;
        return new StringBuilder().append("DownloadChoice(urlModel=").append(urlModel).append(", source=").append(str).append(", sourceKind=").append(d4Var).append(", watermarkStatus=").append(sgVar).append(", originalStatus=").append(lbVar).append(", trackLayout=").append(jgVar).append(", size=").append(j).append(", bitRate=").append(i).append(", qualityType=").append(i2).append(", width=").append(i3).append(", height=").append(i4).append(", resolution=").append(i5).append(", qualityScore=").append(i6).append(", priority=").append(i7).append(", gearName=").append(str2).append(", codec=").append(str3).append(", format=").append(str4).append(", miscKey=").append(str5).append(", logoType=").append(str6).append(", dashSelection=").append(this.t).append(")").toString();
    }
}
