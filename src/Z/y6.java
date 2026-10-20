package Z;

public final class y6 implements Runnable {
    public final  z6 a;

    public y6(z6 z6Var) {
        this.a = z6Var;
    }

    @Override
    public final void run() {
        z6 z6Var = this.a;
        if (z6Var.i) {
            z6Var.invalidate();
            this.a.postOnAnimation(this);
        }
    }
}
