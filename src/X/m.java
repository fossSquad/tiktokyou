package X;

public final class m implements Runnable {
    public final  w a;

    public m(w wVar) {
        this.a = wVar;
    }

    @Override
    public final void run() {
        w wVar = this.a;
        wVar.f = false;
        x.b(wVar, false);
    }
}
