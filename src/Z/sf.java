package Z;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.FrameLayout;
import com.bytedance.ies.foundation.activity.BaseActivity;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class sf extends BaseActivity {
    public static final  int h = 0;
    public boolean a;
    public int b;
    public int c;
    public hi d;
    public tf e;
    public wf f;
    public FrameLayout g;

    public boolean a() {
        return false;
    }

    public final  FrameLayout b() {
        return this.g;
    }

    public final void c() {
        tf tfVar = this.e;
        if (tfVar != null) {
            tfVar.b();
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        wf wfVar = this.f;
        if (wfVar != null) {
            wfVar.a(i, i2, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        ac.a((Context) this);
        this.a = hi.a((Context) this);
        this.b = hi.c(this);
        this.c = hi.b((Context) this);
        hi hiVar = new hi(this, this.a, new Runnable() {
            @Override
            public final void run() {
                this.f$0.c();
            }
        });
        this.d = hiVar;
        this.e = new tf(this, hiVar, this.c, new Supplier() {
            @Override
            public final Object get() {
                return this.f$0.b();
            }
        });
        hi.a(this, this.a);
        if (a()) {
            return;
        }
        wf wfVar = new wf(this, this.d, this.b, this.c, Math.max((int) (getResources().getDisplayMetrics().heightPixels * 0.34f), this.d.a(248.0f) + this.b), new Consumer() {
            @Override
            public final void accept(Object obj) {
                this.f$0.a((FrameLayout) obj);
            }
        });
        this.f = wfVar;
        setContentView(wfVar.a());
    }

    public final void a(FrameLayout frameLayout) {
        this.g = frameLayout;
    }
}
