package fake.d;

import java.io.Serializable;

public abstract class d implements Serializable {
    public final int arity;

    public d(int i) {
        this.arity = i;
    }

    public int getArity() {
        return this.arity;
    }

    public String toString() {
        String strA = e.a(this);
        c.a((Object) strA, "renderLambdaToString(this)");
        return strA;
    }
}
