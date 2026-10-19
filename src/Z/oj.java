package Z;

import android.view.View;
import java.util.Comparator;
import ni.shikatu.kotlin.comparisons.ComparisonsKt;

public final class oj implements Comparator {
    public final  nj a;

    public oj(nj njVar) {
        this.a = njVar;
    }

    @Override
    public final int compare(Object obj, Object obj2) {
        int iCompare = this.a.compare(obj, obj2);
        return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(Float.valueOf(((View) obj2).getZ()), Float.valueOf(((View) obj).getZ()));
    }
}
