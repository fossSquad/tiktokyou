package X;

import android.content.Context;

public final  class C1Ajm implements Runnable {
    public final  C00001Ajr LL;
    public final  Context LLILL;

    public  C1Ajm(C00001Ajr c00001Ajr, Context context) {
        this.LL = c00001Ajr;
        this.LLILL = context;
    }

    @Override
    public final void run() {
        Context contextQ;
        C00001Ajr c00001Ajr = this.LL;
        Context context = this.LLILL;
        0zxW.LIZ("AppStatusManager@9e6.unregisterReceiver$1L");
        if (c00001Ajr.LIZLLL.getAndSet(false) && (contextQ = 0Vx6.Q(context)) != null) {
            0Vx6.LJIIIZ(contextQ, c00001Ajr.LIZJ);
        }
        0zxW.LIZIZ("AppStatusManager@9e6.unregisterReceiver$1L");
    }
}
