package X;

import java.lang.reflect.Method;
import java.util.Arrays;

public final class t6 {
    public final o5 a;
    public final String b;
    public final String[] c;

    public t6(o5 o5Var, String str, String[] strArr) {
        this.a = o5Var;
        this.b = str;
        String[] strArr2 = (String[]) strArr.clone();
        this.c = strArr2;
        g8.a("method", str, strArr2);
    }

    public final Method a(Class cls, Class... clsArr) throws NoSuchMethodException {
        for (String str : this.c) {
            try {
                return ha.a(cls, str, clsArr);
            } catch (NoSuchMethodException e) {
            }
        }
        throw new NoSuchMethodException(cls.getName() + "#" + this.b + " names=" + Arrays.toString(this.c));
    }

    public final String toString() {
        return (this.a != null ? this.a.a + "." : "") + this.b + "=" + Arrays.toString(this.c);
    }
}
