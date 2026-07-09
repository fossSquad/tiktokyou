package X;

public final class h implements Runnable {
    public final  w a;
    public final  long b;

    public h(w wVar, long j) {
        this.a = wVar;
        this.b = j;
    }

    @Override
    public final void run() {
        if (x.b()) {
            w wVar = this.a;
            if (wVar.e && wVar.i == this.b) {
                wVar.e = false;
                x.a(wVar, true);
            }
        }
    }
}
