package Z;

import com.windukk.hook.HookMethod;
import Z.OfflineModeHooks;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

class eb extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        LinkedHashMap linkedHashMap = OfflineModeHooks.a;
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((jb) it.next()).a));
        }
        hookMethodParam.setResult(arrayList);
    }
}
