package Z;

public final class w7 {
    public final String a;
    public final String b;

    public w7(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final Class a() throws ClassNotFoundException {
        return Class.forName(this.b, false, w7.class.getClassLoader());
    }

    public final String toString() {
        return this.a + "=" + this.b;
    }
}
