package X;

public final class v0 implements Runnable {
    public final  Class a;
    public final  Object b;

    public v0(Class cls, Object obj) {
        this.a = cls;
        this.b = obj;
    }

    @Override
    public final void run() {
        try {
            this.a.getDeclaredMethod("LJIIJ", null).invoke(this.b, null);
        } catch (Throwable th) {
        }
    }
}
