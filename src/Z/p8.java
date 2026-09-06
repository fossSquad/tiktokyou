package Z;

import java.lang.reflect.Method;
import java.util.Arrays;

public final class p8 {
    public final w6 a;
    public final String b;
    public final String[] c;

    public p8(w6 w6Var, String str, String[] strArr) {
        this.a = w6Var;
        this.b = str;
        String[] strArr2 = (String[]) strArr.clone();
        this.c = strArr2;
        oa.a("method", str, strArr2);
    }

    public final Method a(Class cls, Class... clsArr) throws NoSuchMethodException {
        for (String str : this.c) {
            try {
                return dd.a(cls, str, clsArr);
            } catch (NoSuchMethodException e) {
            }
        }
        throw new NoSuchMethodException(cls.getName() + "#" + this.b + " names=" + Arrays.toString(this.c));
    }

    public final String toString() {
        return (this.a != null ? this.a.a + "." : "") + this.b + "=" + Arrays.toString(this.c);
    }
}
