package Z;
import Z.EdgeSpeedupHooks;

public final class jc implements Runnable {
    public final Object a;
    public final float b;

    public jc(Object obj, float f, String str) {
        this.a = obj;
        this.b = f;
    }

    @Override
    public final void run() {
        if (Math.abs(EdgeSpeedupHooks.f - this.b) > 0.001f || EdgeSpeedupHooks.a(EdgeSpeedupHooks.f) || EdgeSpeedupHooks.h != null) {
            return;
        }
        long j = EdgeSpeedupHooks.j;
        if (j <= 0 || System.currentTimeMillis() - j >= 1200) {
            EdgeSpeedupHooks.a(this.a, this.b);
        }
    }
}
