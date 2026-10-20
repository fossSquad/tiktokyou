package Z;

public final class t2 implements Runnable {
    public final  Class a;
    public final  Object b;

    public t2(Class cls, Object obj) {
        this.a = cls;
        this.b = obj;
    }

    @Override
    public final void run() {
        try {
            pb.b.a(this.a, new Class[0]).invoke(this.b, null);
        } catch (Throwable th) {
        }
    }
}
