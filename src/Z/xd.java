package Z;

public final class xd implements Runnable {
    public final Object a;
    public final float b;

    public xd(Object obj, float f, String str) {
        this.a = obj;
        this.b = f;
    }

    @Override
    public final void run() {
        if (Math.abs(yd.f - this.b) > 0.001f || yd.a(yd.f) || yd.h != null) {
            return;
        }
        long j = yd.j;
        if (j <= 0 || System.currentTimeMillis() - j >= 1200) {
            yd.a(this.a, this.b);
        }
    }
}
