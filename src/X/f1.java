package X;

public final class f1 implements Runnable {
    public final  Class a;
    public final  Object b;

    public f1(Class cls, Object obj) {
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
