package Z;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.ss.android.ugc.aweme.feed.model.AwemeExtKt;
import com.ss.android.ugc.aweme.search.pages.result.topsearch.core.model.SearchMixFeed;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class a {
    public static List a(List list) {
        if (y5.a().d && list != null && !list.isEmpty()) {
            int size = list.size();
            ArrayList arrayList = null;
            for (int i = 0; i < size; i++) {
                Aweme aweme = (Aweme) list.get(i);
                if (a(aweme)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(Math.max(0, size - 1));
                        for (int i2 = 0; i2 < i; i2++) {
                            arrayList.add((Aweme) list.get(i2));
                        }
                    }
                } else if (arrayList != null) {
                    arrayList.add(aweme);
                }
            }
            if (arrayList != null) {
                return arrayList;
            }
        }
        return list;
    }

    public static List b(List list) {
        if (y5.a().d && list != null && !list.isEmpty()) {
            int size = list.size();
            ArrayList arrayList = null;
            for (int i = 0; i < size; i++) {
                SearchMixFeed searchMixFeed = (SearchMixFeed) list.get(i);
                boolean zB = b(searchMixFeed);
                a(searchMixFeed);
                if (zB) {
                    if (arrayList == null) {
                        arrayList = new ArrayList(Math.max(0, size - 1));
                        for (int i2 = 0; i2 < i; i2++) {
                            arrayList.add((SearchMixFeed) list.get(i2));
                        }
                    }
                } else if (arrayList != null) {
                    arrayList.add(searchMixFeed);
                }
            }
            if (arrayList != null) {
                return arrayList;
            }
        }
        return list;
    }

    public static void a(SearchMixFeed searchMixFeed) {
        if (!y5.a().d || searchMixFeed == null) {
            return;
        }
        List list = searchMixFeed.awemePoolAwemeList;
        if (list != null) {
            searchMixFeed.awemePoolAwemeList = a(list);
        }
        if (a(searchMixFeed.aweme)) {
            searchMixFeed.aweme = null;
        }
        if (searchMixFeed.preciseAd != null) {
            searchMixFeed.preciseAd = null;
        }
    }

    public static boolean b(SearchMixFeed searchMixFeed) {
        List list;
        if (searchMixFeed == null) {
            return false;
        }
        if (searchMixFeed.preciseAd != null || a(searchMixFeed.aweme)) {
            return true;
        }
        try {
            Set adCidList = searchMixFeed.getAdCidList();
            if (adCidList != null && !adCidList.isEmpty()) {
                return true;
            }
        } catch (Throwable th) {
        }
        if (searchMixFeed.aweme != null || (list = searchMixFeed.awemePoolAwemeList) == null || list.isEmpty()) {
            return false;
        }
        return a(searchMixFeed.awemePoolAwemeList).isEmpty();
    }

    public static boolean a(Aweme aweme) {
        if (aweme == null) {
            return false;
        }
        try {
            if (AwemeExtKt.getMonetizationData(aweme) != null) {
                return true;
            }
        } catch (Throwable th) {
        }
        try {
            if (AwemeExtKt.isAdFiled(aweme)) {
                return true;
            }
        } catch (Throwable th2) {
        }
        try {
            if (AwemeExtKt.isAdTraffic(aweme)) {
                return true;
            }
        } catch (Throwable th3) {
        }
        try {
            if (AwemeExtKt.isMonetizationTraffic(aweme)) {
                return true;
            }
        } catch (Throwable th4) {
        }
        try {
            if (AwemeExtKt.isPseudoAd(aweme)) {
                return true;
            }
        } catch (Throwable th5) {
        }
        try {
            return AwemeExtKt.isSearchPreciseAd(aweme);
        } catch (Throwable th6) {
            return false;
        }
    }
}
