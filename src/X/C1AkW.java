package X;

import android.os.SystemClock;
import com.bytedance.i18n.location.api.LocationData;
import java.util.AbstractSequentialList;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public final class C1AkW {
    public final Map<String, LinkedList<C1Ajj>> LIZ = new LinkedHashMap();

    public final void LIZ(String str, C1Ajj c1Ajj) {
        LinkedList linkedList = (LinkedList) ((LinkedHashMap) this.LIZ).get(str);
        if (linkedList != null) {
            linkedList.add(c1Ajj);
            return;
        }
        Map<String, LinkedList<C1Ajj>> map = this.LIZ;
        LinkedList<C1Ajj> linkedList2 = new LinkedList<>();
        linkedList2.add(c1Ajj);
        map.put(str, linkedList2);
    }

    public final C1AjZ LIZIZ(String str, C1Ajl c1Ajl) {
        AbstractSequentialList<C1Ajj> abstractSequentialList = (AbstractSequentialList) ((LinkedHashMap) this.LIZ).get(str);
        if (abstractSequentialList == null) {
            return C1AjY.LIZ(c1Ajl);
        }
        for (C1Ajj c1Ajj : abstractSequentialList) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            if (c1Ajj.LIZIZ(c1Ajl)) {
                0bn7 r0 = 0bn7.LIZ;
                StringBuilder sbLIZ = 0wS0.LIZ();
                sbLIZ.append("process: stage=");
                sbLIZ.append(str);
                sbLIZ.append(" name=");
                sbLIZ.append(c1Ajj.name());
                0bn7.LIZLLL("StrategyManager", 0wS0.LIZIZ(sbLIZ));
                C1AjZ c1AjZLIZ = c1Ajj.LIZ(c1Ajl);
                StringBuilder sbLIZ2 = 0wS0.LIZ();
                sbLIZ2.append("process: stage=");
                sbLIZ2.append(str);
                sbLIZ2.append(" name=");
                sbLIZ2.append(c1Ajj.name());
                sbLIZ2.append(" result=");
                sbLIZ2.append(c1AjZLIZ);
                0bn7.LIZIZ("StrategyManager", 0wS0.LIZIZ(sbLIZ2));
                C1Ajl c1Ajl2 = c1AjZLIZ.LIZ;
                LocationData locationData = c1Ajl2.LIZ;
                if (locationData != null) {
                    c1Ajl.LIZ = locationData;
                }
                054j r1 = c1Ajl2.LIZIZ;
                if (r1 != null) {
                    c1Ajl.LIZIZ = r1;
                }
                long jUptimeMillis2 = SystemClock.uptimeMillis() - jUptimeMillis;
                if (c1AjZLIZ.LIZIZ != 0) {
                    0N3e r2 = 0N3e.LIZ;
                    0N3e.LJIILLIIL(2, jUptimeMillis2, c1Ajj.name());
                    return c1AjZLIZ;
                }
                0N3e r3 = 0N3e.LIZ;
                0N3e.LJIILLIIL(1, jUptimeMillis2, c1Ajj.name());
            }
        }
        return C1AjY.LIZ(c1Ajl);
    }
}
