package X;

import java.lang.reflect.Method;
import java.util.Arrays;

public final class x5 {
    public final x4 a;
    public final String b;
    public final String[] c;

    public x5(x4 x4Var, String str, String[] strArr) {
        this.a = x4Var;
        this.b = str;
        String[] strArr2 = (String[]) strArr.clone();
        this.c = strArr2;
        c7.a("method", str, strArr2);
    }

    public final Method a(Class cls, Class... clsArr) throws NoSuchMethodException {
        for (String str : this.c) {
            try {
                return g8.a(cls, str, clsArr);
            } catch (NoSuchMethodException e) {
            }
        }
        throw new NoSuchMethodException(cls.getName() + "#" + this.b + " names=" + Arrays.toString(this.c));
    }

    public final String toString() {
        return (this.a != null ? this.a.a + "." : "") + this.b + "=" + Arrays.toString(this.c);
    }
}
