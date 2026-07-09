package X;

public final class w1 implements Runnable {
    public final  Class a;
    public final  Object b;

    public w1(Class cls, Object obj) {
        this.a = cls;
        this.b = obj;
    }

    @Override
    public final void run() {
        try {
            x7.b.a(this.a, new Class[0]).invoke(this.b, null);
        } catch (Throwable th) {
        }
    }
}
