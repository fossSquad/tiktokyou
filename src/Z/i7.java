package Z;

import android.content.ComponentName;
import com.android.tools.r8.RecordTag;
import java.util.Objects;

public final class i7 extends RecordTag {
    public final String a;
    public final ComponentName b;
    public final int c;

    private  boolean $record$equals(Object obj) {
        if (!(obj instanceof i7)) {
            return false;
        }
        i7 i7Var = (i7) obj;
        return this.c == i7Var.c && Objects.equals(this.a, i7Var.a) && Objects.equals(this.b, i7Var.b);
    }

    private  Object[] $record$getFieldsAsObjects() {
        return new Object[]{this.a, this.b, Integer.valueOf(this.c)};
    }

    public i7(String str, ComponentName componentName, int i) {
        this.a = str;
        this.b = componentName;
        this.c = i;
    }

    public final String a() {
        String strA = k7.a("launcher_icon_" + this.a, null);
        if (strA != null) {
            return strA;
        }
        return "default".equals(this.a) ? k7.a("launcher_icon_default", "Default") : j7.a(this.a);
    }

    public final boolean equals(Object obj) {
        return $record$equals(obj);
    }

    public final int hashCode() {
        return i7$$ExternalSyntheticRecord0.m(this.c, this.a, this.b);
    }

    public final String toString() {
        return i7$$ExternalSyntheticRecord1.m($record$getFieldsAsObjects(), i7.class, "a;b;c");
    }
}
