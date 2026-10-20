package Z;

import java.lang.reflect.Method;
import java.util.Arrays;

public final class v9 {
    public final w7 a;
    public final String b;
    public final String[] c;

    public v9(w7 w7Var, String str, String[] strArr) {
        this.a = w7Var;
        this.b = str;
        String[] strArr2 = (String[]) strArr.clone();
        this.c = strArr2;
        wb.a("method", str, strArr2);
    }

    public final Method a(Class cls, Class... clsArr) throws NoSuchMethodException {
        for (String str : this.c) {
            try {
                return se.a(cls, str, clsArr);
            } catch (NoSuchMethodException e) {
            }
        }
        throw new NoSuchMethodException(cls.getName() + "#" + this.b + " names=" + Arrays.toString(this.c));
    }

    public final String toString() {
        return (this.a != null ? this.a.a + "." : "") + this.b + "=" + Arrays.toString(this.c);
    }
}
