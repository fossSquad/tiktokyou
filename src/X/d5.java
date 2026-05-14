package X;

import com.ss.android.ugc.aweme.discover.model.Banner;
import com.windukk.hook.HookMethod;
import java.util.ArrayList;
import java.util.List;

class d5 extends HookMethod {

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        if (y3.a().d) {
            List list = (List) hookMethodParam.getResult();
            if (y3.a().d && list != null && !list.isEmpty()) {
                int size = list.size();
                ArrayList arrayList = null;
                for (int i = 0; i < size; i++) {
                    Banner banner = (Banner) list.get(i);
                    if (banner != null) {
                        try {
                            if (banner.adData != null) {
                                if (arrayList == null) {
                                    arrayList = new ArrayList(Math.max(0, size - 1));
                                    for (int i2 = 0; i2 < i; i2++) {
                                        arrayList.add((Banner) list.get(i2));
                                    }
                                }
                            } else if (arrayList != null) {
                                arrayList.add(banner);
                            }
                        } catch (Throwable th) {
                        }
                    } else if (arrayList != null) {
                        arrayList.add(banner);
                    }
                }
                if (arrayList != null) {
                    list = arrayList;
                }
            }
            hookMethodParam.setResult(list);
        }
    }
}
