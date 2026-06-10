package X;

import android.view.View;
import java.util.ArrayList;

public final class s implements View.OnClickListener {
    @Override
    public final void onClick(View view) {
        d7 d7VarA = d7.a();
        if (d7VarA == null) {
            return;
        }
        boolean z = d7VarA.f;
        boolean z2 = !z;
        if (!z) {
            ArrayList arrayList = new ArrayList(w.b.values());
            int size = arrayList.size();
            int i = 0;
            while (i < size) {
                Object obj = arrayList.get(i);
                i++;
                w.b((v) obj);
            }
        }
        d7VarA.b(z2);
        ArrayList arrayList2 = new ArrayList(w.b.values());
        int size2 = arrayList2.size();
        int i2 = 0;
        while (i2 < size2) {
            Object obj2 = arrayList2.get(i2);
            i2++;
            v vVar = (v) obj2;
            vVar.h = z2;
            vVar.e = false;
            w.b(vVar, true);
            w.a(vVar, true);
        }
        w.c();
    }
}
