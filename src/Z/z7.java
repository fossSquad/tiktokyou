package Z;

import java.lang.reflect.Field;
import java.util.Arrays;

public final class z7 {
    public final w6 a;
    public final String b;
    public final String[] c;

    public z7(w6 w6Var, String str, String[] strArr) {
        this.a = w6Var;
        this.b = str;
        String[] strArr2 = (String[]) strArr.clone();
        this.c = strArr2;
        oa.a("field", str, strArr2);
    }

    public final Field a(Class cls) throws NoSuchFieldException {
        for (String str : this.c) {
            try {
                return dd.a(cls, str);
            } catch (NoSuchFieldException e) {
            }
        }
        throw new NoSuchFieldException(cls.getName() + "#" + this.b + " names=" + Arrays.toString(this.c));
    }

    public final String toString() {
        return (this.a != null ? this.a.a + "." : "") + this.b + "=" + Arrays.toString(this.c);
    }
}
