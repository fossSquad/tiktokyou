package X;

import android.text.TextUtils;

public final class m0 {
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final String e;

    public m0(String str, String str2, boolean z, boolean z2, String str3) {
        this.a = str;
        this.b = t0.d(str2);
        this.c = z;
        this.d = z2;
        this.e = TextUtils.isEmpty(str3) ? null : str3;
    }
}
