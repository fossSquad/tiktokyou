package X;

public final class h implements Runnable {
    public final  v a;

    public h(v vVar) {
        this.a = vVar;
    }

    @Override
    public final void run() {
        v vVar = this.a;
        vVar.f = false;
        w.b(vVar, false);
    }
}
