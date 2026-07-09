package X;

import android.text.TextUtils;

public final class f1 {
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final String e;
    public final String f;

    public f1(String str, String str2, boolean z, boolean z2, String str3, String str4) {
        this.a = str;
        this.b = g1.b(str2);
        this.c = z;
        this.d = z2;
        this.e = TextUtils.isEmpty(str3) ? null : str3;
        this.f = TextUtils.isEmpty(str4) ? null : str4;
    }
}
