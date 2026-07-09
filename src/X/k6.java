package X;

import java.lang.reflect.Field;
import java.util.Arrays;

public final class k6 {
    public final o5 a;
    public final String b;
    public final String[] c;

    public k6(o5 o5Var, String str, String[] strArr) {
        this.a = o5Var;
        this.b = str;
        String[] strArr2 = (String[]) strArr.clone();
        this.c = strArr2;
        g8.a("field", str, strArr2);
    }

    public final Field a(Class cls) throws NoSuchFieldException {
        for (String str : this.c) {
            try {
                return ha.a(cls, str);
            } catch (NoSuchFieldException e) {
            }
        }
        throw new NoSuchFieldException(cls.getName() + "#" + this.b + " names=" + Arrays.toString(this.c));
    }

    public final String toString() {
        return (this.a != null ? this.a.a + "." : "") + this.b + "=" + Arrays.toString(this.c);
    }
}
