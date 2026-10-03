package Z;

import java.util.Comparator;

public final class i6 implements Comparator {
    @Override
    public final int compare(Object obj, Object obj2) {
        j6 j6Var = (j6) obj;
        j6 j6Var2 = (j6) obj2;
        if ("default".equals(j6Var.a) != "default".equals(j6Var2.a)) {
            return "default".equals(j6Var.a) ? -1 : 1;
        }
        return j6Var.a().compareToIgnoreCase(j6Var2.a());
    }
}
