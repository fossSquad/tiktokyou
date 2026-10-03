package Z;

public final class n1 {
    public final String a;
    public final String b;
    public final boolean c;
    public final boolean d;
    public final String e;
    public final String f;

    public n1(String str, String str2, boolean z, boolean z2, String str3, String str4) {
        this.a = str;
        this.b = q1.b(str2);
        this.c = z;
        this.d = z2;
        this.e = (str3 == null || str3.isEmpty()) ? null : str3;
        this.f = (str4 == null || str4.isEmpty()) ? null : str4;
    }

    public static n1 a() {
        return new n1("", "asset:supporter.png", true, false, null, null);
    }
}
