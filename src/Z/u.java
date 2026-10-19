package Z;

import android.content.Intent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import java.util.Objects;
import java.util.function.Consumer;

public final class u extends sf {
    public x i;

    @Override
    public final boolean a() {
        hi hiVar = this.d;
        this.i = new x(this, hiVar);
        ag agVar = new ag(this, hiVar, this.b, this.c, new Consumer() {
            @Override
            public final void accept(Object obj) {
                this.f$0.a((FrameLayout) obj);
            }
        });
        String strA = k7.a("section_appearance");
        final x xVar = this.i;
        Objects.requireNonNull(xVar);
        setContentView(agVar.a(strA, new Consumer() {
            @Override
            public final void accept(Object obj) {
                xVar.a((LinearLayout) obj);
            }
        }));
        return true;
    }

    @Override
    public final void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        x xVar = this.i;
        if (xVar != null) {
            xVar.a(i, i2, intent);
        }
    }

    public final void onResume() {
        super.onResume();
        x xVar = this.i;
        if (xVar != null) {
            xVar.l();
            xVar.j();
        }
    }
}
