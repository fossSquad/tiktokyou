package X;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public final class t implements View.OnLongClickListener {
    @Override
    public final boolean onLongClick(View view) {
        ViewGroup viewGroup;
        ArrayList arrayList = new ArrayList(w.b.values());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            v vVar = (v) obj;
            if (w.b() && (viewGroup = (ViewGroup) vVar.a.get()) != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                vVar.e = true;
                vVar.i = jUptimeMillis + 2600;
                w.a(vVar, true);
                viewGroup.postDelayed(new u(vVar, vVar.i), 2640L);
            }
        }
        return true;
    }
}
