package Z;

import android.content.Intent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import java.util.Objects;
import java.util.function.Consumer;

public final class t5 extends sf {
    public u5 i;

    static {
    }

    @Override
    public final boolean a() {
        if ("anti_burnout".equals(getIntent().getStringExtra("ttmod_section"))) {
            final p pVar = new p(this, this.d);
            setContentView(new ag(this, this.d, this.b, this.c, new Consumer() {
                @Override
                public final void accept(Object obj) {
                    t5.this.a((FrameLayout) obj);
                }
            }).a(k7.a("anti_burnout"), new Consumer() {
                @Override
                public final void accept(Object obj) {
                    pVar.a((LinearLayout) obj);
                }
            }));
            return true;
        }
        this.i = new u5(this, this.d);
        ag agVar = new ag(this, this.d, this.b, this.c, new Consumer() {
            @Override
            public final void accept(Object obj) {
                t5.this.a((FrameLayout) obj);
            }
        });
        String strA = k7.a("settings_feed");
        final u5 u5Var = this.i;
        Objects.requireNonNull(u5Var);
        setContentView(agVar.a(strA, new Consumer() {
            @Override
            public final void accept(Object obj) {
                u5Var.a((LinearLayout) obj);
            }
        }));
        return true;
    }

    @Override
    public final void onActivityResult(int i, int i2, Intent intent) {
        Runnable runnable;
        super.onActivityResult(i, i2, intent);
        u5 u5Var = this.i;
        if (u5Var == null || i != 1004) {
            return;
        }
        u5Var.g();
        if (i2 != -1 || (runnable = u5Var.b.c) == null) {
            return;
        }
        runnable.run();
    }
}
