package Z;

import android.view.View;
import java.util.Comparator;
import ni.shikatu.kotlin.comparisons.ComparisonsKt;

public final class mj implements Comparator {
    public final  lj a;

    public mj(lj ljVar) {
        this.a = ljVar;
    }

    @Override
    public final int compare(Object obj, Object obj2) {
        int iCompare = this.a.compare(obj, obj2);
        if (iCompare != 0) {
            return iCompare;
        }
        View view = (View) obj;
        pj pjVar = pj.a;
        View view2 = (View) obj2;
        return ComparisonsKt.compareValues((view.isClickable() || view.isLongClickable() || view.isFocusable()) ? 0 : 1, (view2.isClickable() || view2.isLongClickable() || view2.isFocusable()) ? 0 : 1);
    }
}
