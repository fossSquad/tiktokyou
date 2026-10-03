package Z;

public final class w6 {
    public final String a;
    public final String b;

    public w6(String str, String str2) {
        this.a = str;
        this.b = str2;
    }

    public final Class a() {
        try {
            return Class.forName(this.b, false, w6.class.getClassLoader());
        } catch (ClassNotFoundException e) {
            return null;
        }
    }

    public final String toString() {
        return this.a + "=" + this.b;
    }
}
