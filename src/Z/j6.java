package Z;

import android.content.ComponentName;
import java.util.Objects;

public final class j6 {
    public final String a;
    public final ComponentName b;
    public final int c;

    private  boolean $record$equals(Object obj) {
        if (!(obj instanceof j6)) {
            return false;
        }
        j6 j6Var = (j6) obj;
        return this.c == j6Var.c && Objects.equals(this.a, j6Var.a) && Objects.equals(this.b, j6Var.b);
    }

    private  Object[] $record$getFieldsAsObjects() {
        return new Object[]{this.a, this.b, Integer.valueOf(this.c)};
    }

    public j6(String str, ComponentName componentName, int i) {
        this.a = str;
        this.b = componentName;
        this.c = i;
    }

    public final String a() {
        String strA = l6.a("launcher_icon_" + this.a, null);
        if (strA != null) {
            return strA;
        }
        return "default".equals(this.a) ? l6.a("launcher_icon_default", "Default") : k6.a(this.a);
    }

    public final boolean equals(Object obj) {
        return $record$equals(obj);
    }

    public final int hashCode() {
        return ((this.c * 31) + Objects.hashCode(this.a)) * 31 + Objects.hashCode(this.b);
    }

    public final String toString() {
        Object[] fields = $record$getFieldsAsObjects();
        String[] names = "a;b;c".split(";");
        StringBuilder sb = new StringBuilder();
        sb.append(j6.class.getSimpleName()).append("[");
        for (int i = 0; i < names.length; i++) {
            sb.append(names[i]).append("=").append(fields[i]);
            if (i != names.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
