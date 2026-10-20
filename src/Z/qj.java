package Z;

import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import java.util.Objects;
import java.util.function.Consumer;

public final class qj extends sf {
    public rj i;

    @Override
    public final boolean a() {
        hi hiVar = this.d;
        this.i = new rj(this, hiVar);
        ag agVar = new ag(this, hiVar, this.b, this.c, new Consumer() {
            @Override
            public final void accept(Object obj) {
                qj.this.a((FrameLayout) obj);
            }
        });
        String strDecrypt = "ic_restart";
        String strA = k7.a("ui_hide_clear_all");
        final rj rjVar = this.i;
        Objects.requireNonNull(rjVar);
        Runnable runnable = new Runnable() {
            @Override
            public final void run() {
                rjVar.a();
            }
        };
        agVar.f = strDecrypt;
        agVar.g = strA;
        agVar.h = runnable;
        String strA2 = k7.a("ui_hide_section");
        final rj rjVar2 = this.i;
        Objects.requireNonNull(rjVar2);
        setContentView(agVar.a(strA2, new Consumer() {
            @Override
            public final void accept(Object obj) {
                rjVar2.a((LinearLayout) obj);
            }
        }));
        rj rjVar3 = this.i;
        ImageView imageView = agVar.i;
        rjVar3.d = imageView;
        if (imageView == null) {
            return true;
        }
        imageView.setVisibility(xj.a().isEmpty() ? 8 : 0);
        return true;
    }

    public final void onResume() {
        super.onResume();
        rj rjVar = this.i;
        if (rjVar != null) {
            rjVar.b();
        }
    }
}
