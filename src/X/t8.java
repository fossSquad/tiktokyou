package X;

import com.windukk.hook.HookMethod;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;

class t8 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        LinkedHashMap linkedHashMap = z8.a;
        ArrayList arrayList = new ArrayList(linkedHashMap.size());
        Iterator it = linkedHashMap.values().iterator();
        while (it.hasNext()) {
            arrayList.add(Integer.valueOf(((y8) it.next()).a));
        }
        hookMethodParam.setResult(arrayList);
    }
}
