package Z;

import android.view.View;
import java.util.Comparator;
import ni.shikatu.kotlin.comparisons.ComparisonsKt;

public final class nj implements Comparator {
    public final  mj a;

    public nj(mj mjVar) {
        this.a = mjVar;
    }

    @Override
    public final int compare(Object obj, Object obj2) {
        int iCompare = this.a.compare(obj, obj2);
        return iCompare != 0 ? iCompare : ComparisonsKt.compareValues(Float.valueOf(((View) obj2).getElevation()), Float.valueOf(((View) obj).getElevation()));
    }
}
