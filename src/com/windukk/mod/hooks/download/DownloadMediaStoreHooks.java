package com.windukk.mod.hooks.download;
import Z.*;


import com.ss.android.ugc.aweme.base.model.UrlModel;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

public final class DownloadMediaStoreHooks {
    public final UrlModel a;
    public final String b;
    public final String c;
    public final String d;
    public final int e;

    public DownloadMediaStoreHooks(UrlModel urlModel, String str, String str2, String str3, int i) {
        this.a = urlModel;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = i;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof DownloadMediaStoreHooks)) {
            return false;
        }
        DownloadMediaStoreHooks m3Var = (DownloadMediaStoreHooks) obj;
        return Intrinsics.areEqual(this.a, m3Var.a) && Intrinsics.areEqual(this.b, m3Var.b) && Intrinsics.areEqual(this.c, m3Var.c) && Intrinsics.areEqual(this.d, m3Var.d) && this.e == m3Var.e;
    }

    public final int hashCode() {
        int iHashCode = this.a.hashCode() * 31;
        String str = this.b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.d;
        return Integer.hashCode(this.e) + ((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    public final String toString() {
        UrlModel urlModel = this.a;
        String str = this.b;
        String str2 = this.c;
        String str3 = this.d;
        return ve.a("flbcmplxXkVpcXjEOsa4OZ8JUBi3Yf76yazzXlBZ4JA=", "XhXnrJOr5hy8avjI", "aes", ve.a("weo7CAViA8MyytIBPB9UAKGDg6EqiBaLOi/Un0UGwE8=", "aymS05obJXCHKD2w", "aes", ve.a("wqj3Xh/Bp42HegUCd4UNzxQf+zBUXQa7gEfjl0t+vLU=", "g3pm1nBBBpUHgYrv", "aes", new StringBuilder().append("DashTrack(urlModel=").append(urlModel), str), str2), str3).append(", bitRate=").append(this.e).append(")").toString();
    }
}
