package X;

public final class o5 {
    public final String a;
    public final String b;

    public o5(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final Class a() {
        return Class.forName(this.b, false, o5.class.getClassLoader());
    }

    public final String toString() {
        return this.a + "=" + this.b;
    }
}
