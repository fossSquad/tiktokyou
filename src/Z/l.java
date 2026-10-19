package Z;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;

public final class l implements View.OnLongClickListener {
    @Override
    public final boolean onLongClick(View view) {
        ViewGroup viewGroup;
        ArrayList arrayList = new ArrayList(n.b.values());
        int size = arrayList.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayList.get(i);
            i++;
            m mVar = (m) obj;
            if (n.b() && (viewGroup = (ViewGroup) mVar.a.get()) != null) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                mVar.e = true;
                mVar.k = jUptimeMillis + 2600;
                n.a(mVar, true);
                viewGroup.postDelayed(new b(mVar, mVar.k), 2640L);
            }
        }
        return true;
    }
}
