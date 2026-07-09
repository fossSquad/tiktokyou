package X;

import android.view.ViewGroup;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;

public final class w {
    public final WeakReference a;
    public r d;
    public boolean e;
    public boolean f;
    public boolean g;
    public long i;
    public long j;
    public final ArrayList b = new ArrayList(12);
    public final WeakHashMap c = new WeakHashMap();
    public boolean h = x.b();

    public w(ViewGroup viewGroup) {
        this.a = new WeakReference(viewGroup);
    }
}
