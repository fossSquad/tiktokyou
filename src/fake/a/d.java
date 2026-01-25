package fake.a;

import java.io.Serializable;

public final class d implements Serializable {
    public final Object a;
    public final Object b;

    public d(Boolean bool, String str) {
        this.a = bool;
        this.b = str;
    }

    public final Object a() {
        return this.a;
    }

    public final Object b() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof d)) {
            return false;
        }
        d dVar = (d) obj;
        return fake.d.c.a(this.a, dVar.a) && fake.d.c.a(this.b, dVar.b);
    }

    public final int hashCode() {
        Object obj = this.a;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.b;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.a + ", " + this.b + ')';
    }
}
