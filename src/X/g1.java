package X;

public final class g1 implements Runnable {
    public final  Class a;
    public final  Object b;

    public g1(Class cls, Object obj) {
        this.a = cls;
        this.b = obj;
    }

    @Override
    public final void run() {
        try {
            e4.a(this.a, "LJIIJ", new Class[0]).invoke(this.b, null);
        } catch (Throwable th) {
        }
    }
}
