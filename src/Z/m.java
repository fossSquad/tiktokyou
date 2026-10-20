package Z;

import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

public final class m {
    public final WeakReference a;
    public h d;
    public boolean e;
    public boolean f;
    public boolean g;
    public boolean i;
    public boolean j;
    public long k;
    public long l;
    public final ArrayList b = new ArrayList(12);
    public final WeakHashMap c = new WeakHashMap();
    public boolean h = n.b();

    public m(ViewGroup viewGroup) {
        this.a = new WeakReference(viewGroup);
    }
}
