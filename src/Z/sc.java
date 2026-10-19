package Z;

import com.windukk.hook.HookMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

class sc extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        LinkedHashMap linkedHashMap = yc.a;
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((xc) it.next()).a));
        }
        hookMethodParam.setResult(arrayList);
    }
}
