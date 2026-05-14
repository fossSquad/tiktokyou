package X;

import com.windukk.hook.HookMethod;
import java.util.ArrayList;
import java.util.List;

class c4 extends HookMethod {
    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        List<String> list = (List) hookMethodParam.getResult();
        if (list == null || list.isEmpty()) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        boolean z = false;
        for (String str : list) {
            if (str == null || !str.contains("watermark")) {
                arrayList.add(str);
            } else {
                String strReplaceAll = str.replace("watermark", "origin").replaceAll("q[0-9]{1,3}", "q100").replaceAll("shrink:[0-9]+:[0-9]+", "shrink:0:0");
                arrayList.add(strReplaceAll);
                if (!str.equals(strReplaceAll)) {
                    z = true;
                }
            }
        }
        if (z) {
            hookMethodParam.setResult(arrayList);
        }
    }
}
