package Z;

import java.lang.reflect.Field;
import java.util.Arrays;

public final class e9 {
    public final w7 a;
    public final String b;
    public final String[] c;

    public e9(w7 w7Var, String str, String[] strArr) {
        this.a = w7Var;
        this.b = str;
        String[] strArr2 = (String[]) strArr.clone();
        this.c = strArr2;
        wb.a("field", str, strArr2);
    }

    public final Field a(Class cls) throws NoSuchFieldException {
        for (String str : this.c) {
            try {
                return se.a(cls, str);
            } catch (NoSuchFieldException e) {
            }
        }
        throw new NoSuchFieldException(cls.getName() + "#" + this.b + " names=" + Arrays.toString(this.c));
    }

    public final String toString() {
        return (this.a != null ? this.a.a + "." : "") + this.b + "=" + Arrays.toString(this.c);
    }
}
