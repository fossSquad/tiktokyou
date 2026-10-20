package Z;

import com.ss.android.ugc.aweme.base.model.UrlModel;
import com.ss.android.ugc.aweme.feed.model.Aweme;
import java.util.concurrent.atomic.AtomicBoolean;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class p4 {
    public final long a;
    public final Object b;
    public final Aweme c;
    public final UrlModel d;
    public final String e;
    public final AtomicBoolean f;
    public volatile o3 g;
    public volatile String h;

    public p4(long j, Object obj, Aweme aweme, UrlModel urlModel, String str) {
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        this.a = j;
        this.b = obj;
        this.c = aweme;
        this.d = urlModel;
        this.e = str;
        this.f = atomicBoolean;
        this.g = null;
        this.h = null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof p4)) {
            return false;
        }
        p4 p4Var = (p4) obj;
        return this.a == p4Var.a && Intrinsics.areEqual(this.b, p4Var.b) && Intrinsics.areEqual(this.c, p4Var.c) && Intrinsics.areEqual(this.d, p4Var.d) && Intrinsics.areEqual(this.e, p4Var.e) && Intrinsics.areEqual(this.f, p4Var.f) && Intrinsics.areEqual(this.g, p4Var.g) && Intrinsics.areEqual(this.h, p4Var.h);
    }

    public final int hashCode() {
        int iHashCode = (this.c.hashCode() + ((this.b.hashCode() + (Long.hashCode(this.a) * 31)) * 31)) * 31;
        UrlModel urlModel = this.d;
        int iHashCode2 = (iHashCode + (urlModel == null ? 0 : urlModel.hashCode())) * 31;
        String str = this.e;
        return ((((this.f.hashCode() + ((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31)) * 31) + (this.g == null ? 0 : this.g.hashCode())) * 31) + (this.h != null ? this.h.hashCode() : 0);
    }

    public final String toString() {
        long j = this.a;
        Object obj = this.b;
        Aweme aweme = this.c;
        UrlModel urlModel = this.d;
        String str = this.e;
        AtomicBoolean atomicBoolean = this.f;
        o3 o3Var = this.g;
        return ((new StringBuilder().append("DownloadSession(id=").append(j).append(", downloadData=").append(obj).append(", aweme=").append(aweme).append(", originalUrl=").append(urlModel)).append(", miscScene=").append(str).append(", handled=").append(atomicBoolean).append(", selected=").append(o3Var)).append(", fileBase=").append(this.h).append(")").toString();
    }
}
