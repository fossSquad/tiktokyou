package X;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public final class v implements View.OnLongClickListener {
    @Override
    public final boolean onLongClick(View view) {
        ViewGroup viewGroup;
        ArrayList arrayList = new ArrayList(x.b.values());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            w wVar = (w) obj;
            if (x.b() && (viewGroup = (ViewGroup) wVar.a.get()) != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                wVar.e = true;
                wVar.i = jUptimeMillis + 2600;
                x.a(wVar, true);
                viewGroup.postDelayed(new h(wVar, wVar.i), 2640L);
            }
        }
        return true;
    }
}
