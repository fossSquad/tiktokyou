package X;

import android.text.TextUtils;

public final class d0 {
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final String e;

    public d0(String str, String str2, boolean z, boolean z2, String str3) {
        this.a = str;
        this.b = k0.e(str2);
        this.c = z;
        this.d = z2;
        this.e = TextUtils.isEmpty(str3) ? null : str3;
    }
}
