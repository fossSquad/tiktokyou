package Z;

import android.widget.FrameLayout;
import android.widget.LinearLayout;
import java.util.function.Consumer;

public final class i0 extends sf {

    @Override
    public final boolean a() {
        final ng ngVar = new ng(this, this.d);
        setContentView(new ag(this, this.d, this.b, this.c, new Consumer() {
            @Override
            public final void accept(Object obj) {
                this.f$0.a((FrameLayout) obj);
            }
        }).a(k7.a("settings_streak"), new Consumer() {
            @Override
            public final void accept(Object obj) {
                ngVar.a((LinearLayout) obj);
            }
        }));
        return true;
    }
}
