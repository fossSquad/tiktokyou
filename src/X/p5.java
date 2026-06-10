package X;

import java.lang.reflect.Field;
import java.util.Arrays;

public final class p5 {
    public final x4 a;
    public final String b;
    public final String[] c;

    public p5(x4 x4Var, String str, String[] strArr) {
        this.a = x4Var;
        this.b = str;
        String[] strArr2 = (String[]) strArr.clone();
        this.c = strArr2;
        c7.a("field", str, strArr2);
    }

    public final Field a(Class cls) throws NoSuchFieldException {
        for (String str : this.c) {
            try {
                return g8.a(cls, str);
            } catch (NoSuchFieldException e) {
            }
        }
        throw new NoSuchFieldException(cls.getName() + "#" + this.b + " names=" + Arrays.toString(this.c));
    }

    public final String toString() {
        return (this.a != null ? this.a.a + "." : "") + this.b + "=" + Arrays.toString(this.c);
    }
}
