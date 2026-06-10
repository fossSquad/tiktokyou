package X;

public final class u implements Runnable {
    public final  v a;
    public final  long b;

    public u(v vVar, long j) {
        this.a = vVar;
        this.b = j;
    }

    @Override
    public final void run() {
        if (w.b()) {
            v vVar = this.a;
            if (vVar.e && vVar.i == this.b) {
                vVar.e = false;
                w.a(vVar, true);
            }
        }
    }
}
