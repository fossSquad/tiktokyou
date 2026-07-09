package X;

import android.view.View;
import java.util.ArrayList;

public final class u implements View.OnClickListener {
    @Override
    public final void onClick(View view) {
        l8 l8VarA = l8.a();
        if (l8VarA == null) {
            return;
        }
        boolean z = l8VarA.e;
        boolean z2 = !z;
        if (!z) {
            ArrayList arrayList = new ArrayList(x.b.values());
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                x.b((w) obj);
            }
        }
        l8VarA.c(z2);
        ArrayList arrayList2 = new ArrayList(x.b.values());
        int size2 = arrayList2.size();
        int i2 = 0;
        while (i2 < size2) {
            Object obj2 = arrayList2.get(i2);
            i2++;
            w wVar = (w) obj2;
            wVar.h = z2;
            wVar.e = false;
            x.b(wVar, true);
            x.a(wVar, true);
        }
        x.c();
    }
}
