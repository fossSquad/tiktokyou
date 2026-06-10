package X;

public final class x7 implements Runnable {
    public final Object a;
    public final float b;

    public x7(Object obj, float f, String str) {
        this.a = obj;
        this.b = f;
    }

    @Override
    public final void run() {
        if (Math.abs(y7.f - this.b) > 0.001f || y7.a(y7.f) || y7.h != null) {
            return;
        }
        long j = y7.j;
        if (j <= 0 || System.currentTimeMillis() - j >= 1200) {
            y7.a(this.a, this.b);
        }
    }
}
