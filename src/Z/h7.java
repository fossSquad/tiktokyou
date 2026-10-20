package Z;

import java.util.Comparator;

public final class h7 implements Comparator {
    @Override
    public final int compare(Object obj, Object obj2) {
        i7 i7Var = (i7) obj;
        i7 i7Var2 = (i7) obj2;
        if ("default".equals(i7Var.a) != "default".equals(i7Var2.a)) {
            return "default".equals(i7Var.a) ? -1 : 1;
        }
        return i7Var.a().compareToIgnoreCase(i7Var2.a());
    }
}
