package X;

import android.content.ComponentName;
import com.android.tools.r8.RecordTag;
import java.util.Objects;

public final class d5 extends RecordTag {
    public final String a;
    public final ComponentName b;
    public final int c;

    private  boolean $record$equals(Object obj) {
        if (!(obj instanceof d5)) {
            return false;
        }
        d5 d5Var = (d5) obj;
        return this.c == d5Var.c && Objects.equals(this.a, d5Var.a) && Objects.equals(this.b, d5Var.b);
    }

    private  Object[] $record$getFieldsAsObjects() {
        return new Object[]{this.a, this.b, Integer.valueOf(this.c)};
    }

    public d5(String str, ComponentName componentName, int i) {
        this.a = str;
        this.b = componentName;
        this.c = i;
    }

    public final String a() {
        String strA = f5.a().a("launcher_icon_" + this.a, null);
        if (strA != null) {
            return strA;
        }
        return "default".equals(this.a) ? f5.a().a("launcher_icon_default", "Default") : e5.a(this.a);
    }

    public final boolean equals(Object obj) {
        return $record$equals(obj);
    }

    public final int hashCode() {
        return d5$$ExternalSyntheticRecord0.m(this.c, this.a, this.b);
    }

    public final String toString() {
        return d5$$ExternalSyntheticRecord1.m($record$getFieldsAsObjects(), d5.class, "a;b;c");
    }
}
