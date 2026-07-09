package X;

import java.util.Comparator;

public final class c5 implements Comparator {
    @Override
    public final int compare(Object obj, Object obj2) {
        d5 d5Var = (d5) obj;
        d5 d5Var2 = (d5) obj2;
        if ("default".equals(d5Var.a) != "default".equals(d5Var2.a)) {
            return "default".equals(d5Var.a) ? -1 : 1;
        }
        return d5Var.a().compareToIgnoreCase(d5Var2.a());
    }
}
