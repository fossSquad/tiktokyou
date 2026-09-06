package Z;

import android.view.View;
import java.util.ArrayList;

public final class k implements View.OnClickListener {
    @Override
    public final void onClick(View view) {
        if (ta.a() == null) {
            return;
        }
        boolean z = ta.d().f;
        boolean z2 = !z;
        if (!z) {
            ArrayList arrayList = new ArrayList(n.b.values());
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                n.b((m) obj);
            }
        }
        ta.d().c(z2);
        ArrayList arrayList2 = new ArrayList(n.b.values());
        int size2 = arrayList2.size();
        int i2 = 0;
        while (i2 < size2) {
            Object obj2 = arrayList2.get(i2);
            i2++;
            m mVar = (m) obj2;
            mVar.h = z2;
            mVar.e = false;
            n.b(mVar, true);
            n.a(mVar, true);
        }
        n.c();
    }
}
