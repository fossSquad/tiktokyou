package Z;

public final class h2 implements Runnable {
    public final  Class a;
    public final  Object b;

    public h2(Class cls, Object obj) {
        this.a = cls;
        this.b = obj;
    }

    @Override
    public final void run() {
        try {
            ha.b.a(this.a, new Class[0]).invoke(this.b, null);
        } catch (Throwable th) {
        }
    }
}
