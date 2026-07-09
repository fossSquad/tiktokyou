package X;

import com.windukk.hook.HookMethod;
import java.util.ArrayList;
import java.util.List;

class h9 extends HookMethod {
    @Override
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        List<String> list = (List) hookMethodParam.getResult();
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (String str : list) {
            if (n9.a(str)) {
                String strReplaceAll = str.replace("watermark", "origin").replace("water_mark", "origin").replaceAll("q[0-9]{1,3}", "q100").replaceAll("shrink:[0-9]+:[0-9]+", "shrink:0:0");
                arrayList.add(strReplaceAll);
                if (!str.equals(strReplaceAll)) {
                    z = true;
                }
            } else {
                arrayList.add(str);
            }
        }
        if (z) {
            hookMethodParam.setResult(arrayList);
        }
    }
}
