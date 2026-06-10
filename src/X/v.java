package X;

import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

public final class v {
    public final WeakReference a;
    public p d;
    public boolean e;
    public boolean f;
    public boolean g;
    public long i;
    public long j;
    public final ArrayList b = new ArrayList(12);
    public final WeakHashMap c = new WeakHashMap();
    public boolean h = w.b();

    public v(ViewGroup viewGroup) {
        this.a = new WeakReference(viewGroup);
    }
}
