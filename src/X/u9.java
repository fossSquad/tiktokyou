package X;

public final class u9 implements Runnable {
    public final Object a;
    public final float b;

    public u9(Object obj, float f, String str) {
        this.a = obj;
        this.b = f;
    }

    @Override
    public final void run() {
        if (Math.abs(v9.f - this.b) > 0.001f || v9.a(v9.f) || v9.h != null) {
            return;
        }
        long j = v9.j;
        if (j <= 0 || System.currentTimeMillis() - j >= 1200) {
            v9.a(this.a, this.b);
        }
    }
}
