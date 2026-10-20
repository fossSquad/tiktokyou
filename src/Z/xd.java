package Z;
import com.windukk.mod.hooks.SearchHooks;


public final class xd implements Runnable {
    public final Object a;
    public final float b;

    public xd(Object obj, float f, String str) {
        this.a = obj;
        this.b = f;
    }

    @Override
    public final void run() {
        if (Math.abs(SearchHooks.f - this.b) > 0.001f || SearchHooks.a(SearchHooks.f) || SearchHooks.h != null) {
            return;
        }
        long j = SearchHooks.j;
        if (j <= 0 || System.currentTimeMillis() - j >= 1200) {
            SearchHooks.a(this.a, this.b);
        }
    }
}
