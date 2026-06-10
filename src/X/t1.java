package X;

public final class t1 implements Runnable {
    public final  Class a;
    public final  Object b;

    public t1(Class cls, Object obj) {
        this.a = cls;
        this.b = obj;
    }

    @Override
    public final void run() {
        try {
            u6.b.a(this.a, new Class[0]).invoke(this.b, null);
        } catch (Throwable th) {
        }
    }
}
