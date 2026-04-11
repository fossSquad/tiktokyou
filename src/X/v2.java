package X;

import de.robv.android.xposed.XC_MethodHook;
import java.util.ArrayList;
import java.util.List;

class v2 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        List<String> list = (List) methodHookParam.getResult();
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
            methodHookParam.setResult(arrayList);
        }
    }
}
