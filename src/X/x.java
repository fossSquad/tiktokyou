package X;

import android.text.TextUtils;
import com.ss.android.ugc.aweme.friendstab.repo.RepostTextExtra;
import com.ss.android.ugc.aweme.profile.model.User;
import de.robv.android.xposed.XC_MethodHook;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class x extends XC_MethodHook {

    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        h0 h0Var;
        h0 h0Var2;
        Object[] objArr;
        List list;
        Iterator it;
        Object[] objArr2 = methodHookParam.args;
        if (objArr2.length >= 6) {
            char c = 4;
            Object obj = objArr2[4];
            if (obj instanceof String) {
                String str = (String) obj;
                char c2 = 5;
                Object obj2 = objArr2[5];
                boolean z = false;
                List list2 = obj2 instanceof List ? (List) obj2 : null;
                Object obj3 = objArr2[2];
                User user = obj3 instanceof User ? (User) obj3 : null;
                ConcurrentHashMap concurrentHashMap = k0.a;
                if (!TextUtils.isEmpty(str) && !k0.a(str)) {
                    if (list2 != null && !list2.isEmpty()) {
                        try {
                            int i = 0;
                            Constructor declaredConstructor = RepostTextExtra.class.getDeclaredConstructor(Integer.class, Integer.class, String.class, Integer.class);
                            declaredConstructor.setAccessible(true);
                            StringBuilder sb = new StringBuilder(str);
                            ArrayList arrayList = new ArrayList(list2.size());
                            Iterator it2 = list2.iterator();
                            boolean z2 = false;
                            int length = 0;
                            while (it2.hasNext()) {
                                Object next = it2.next();
                                if (next == null) {
                                    arrayList.add(z);
                                    c = c;
                                    c2 = c2;
                                    it = it2;
                                } else {
                                    Integer num = (Integer) k0.a(next.getClass(), "spanStart").get(next);
                                    Integer num2 = (Integer) k0.a(next.getClass(), "spanEnd").get(next);
                                    c = c;
                                    try {
                                        String str2 = (String) k0.a(next.getClass(), "mentionUserId").get(next);
                                        c2 = c2;
                                        try {
                                            Integer num3 = (Integer) k0.a(next.getClass(), "mentionType").get(next);
                                            int iMax = num != null ? Math.max(i, num.intValue() + length) : i;
                                            int iMax2 = num2 != null ? Math.max(iMax, num2.intValue() + length) : iMax;
                                            d0 d0VarI = k0.i(str2);
                                            if (d0VarI == null || iMax2 > sb.length()) {
                                                it = it2;
                                            } else {
                                                if (iMax2 < 0 || iMax2 >= sb.length()) {
                                                    it = it2;
                                                } else {
                                                    it = it2;
                                                    if ((iMax2 + 5 > sb.length() || sb.indexOf("\u2063\u2064\u2063\u2064\u2063", iMax2) != iMax2) && (iMax2 + 3 > sb.length() || sb.indexOf("\u2063\u2063\u2064", iMax2) != iMax2)) {
                                                    }
                                                }
                                                if (iMax < iMax2) {
                                                    k0.a(sb.substring(iMax, iMax2), d0VarI);
                                                }
                                                String str3 = "\u2063\u2063\u2064" + k0.a(d0VarI) + "\u2064\u2063\u2063";
                                                sb.insert(iMax2, str3);
                                                length += str3.length();
                                                z2 = true;
                                            }
                                            arrayList.add(declaredConstructor.newInstance(num != null ? Integer.valueOf(iMax) : null, num2 != null ? Integer.valueOf(iMax2) : null, str2, num3));
                                        } catch (Throwable th) {
                                            th = th;
                                            th.getMessage();
                                            ArrayList arrayList2 = q2.a;
                                            h0Var2 = null;
                                            if (h0Var2 == null) {
                                                return;
                                            }
                                            objArr = methodHookParam.args;
                                            objArr[c] = h0Var2.a;
                                            list = h0Var2.b;
                                            if (list != null) {
                                                objArr[c2] = list;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        c2 = c2;
                                        th.getMessage();
                                        ArrayList arrayList3 = q2.a;
                                        h0Var2 = null;
                                        if (h0Var2 == null) {
                                            return;
                                        }
                                        objArr = methodHookParam.args;
                                        objArr[c] = h0Var2.a;
                                        list = h0Var2.b;
                                        if (list != null) {
                                            objArr[c2] = list;
                                        }
                                    }
                                }
                                c = c;
                                c2 = c2;
                                it2 = it;
                                z = false;
                                i = 0;
                            }
                            c = c;
                            c2 = c2;
                            if (z2) {
                                h0Var2 = new h0(sb.toString(), arrayList);
                            } else {
                                h0Var = null;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            c = c;
                        }
                    } else if (user == null) {
                        h0Var = null;
                    } else {
                        String strA = k0.a(user.getUid(), str);
                        if (TextUtils.equals(str, strA)) {
                            h0Var = null;
                        } else {
                            h0Var2 = new h0(strA, null);
                        }
                    }
                    if (h0Var2 == null) {
                        return;
                    }
                    objArr = methodHookParam.args;
                    objArr[c] = h0Var2.a;
                    list = h0Var2.b;
                    if (list != null) {
                        objArr[c2] = list;
                    }
                }
                c = 4;
                c2 = 5;
                h0Var = null;
                h0Var2 = h0Var;
                if (h0Var2 == null) {
                    return;
                }
                objArr = methodHookParam.args;
                objArr[c] = h0Var2.a;
                list = h0Var2.b;
                if (list != null) {
                    objArr[c2] = list;
                }
            }
        }
    }
}
