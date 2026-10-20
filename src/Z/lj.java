package Z;

import android.graphics.Rect;
import android.view.View;
import java.util.Comparator;
import ni.shikatu.kotlin.comparisons.ComparisonsKt;
import ni.shikatu.kotlin.ranges.RangesKt;

public final class lj implements Comparator {
    @Override
    public final int compare(Object obj, Object obj2) {
        Rect rect = pj.e;
        ((View) obj).getGlobalVisibleRect(rect);
        Long lValueOf = Long.valueOf(RangesKt.coerceAtLeast(rect.height(), 1L) * RangesKt.coerceAtLeast(rect.width(), 1L));
        ((View) obj2).getGlobalVisibleRect(rect);
        return ComparisonsKt.compareValues(lValueOf, Long.valueOf(RangesKt.coerceAtLeast(rect.height(), 1L) * RangesKt.coerceAtLeast(rect.width(), 1L)));
    }
}
