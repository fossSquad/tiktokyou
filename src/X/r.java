package X;

import android.text.TextUtils;
import com.ss.android.ugc.aweme.friendstab.repo.RepostTextExtra;
import com.ss.android.ugc.aweme.profile.model.User;
import com.windukk.hook.HookMethod;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

class r extends HookMethod {

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        r0 r0Var;
        r0 r0Var2;
        Object[] objArr;
        List list;
        Integer num;
        Iterator it;
        Object[] objArr2 = hookMethodParam.args;
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
                ConcurrentHashMap concurrentHashMap = t0.a;
                if (TextUtils.isEmpty(str)) {
                    c = 4;
                    c2 = 5;
                    r0Var = null;
                } else {
                    if (TextUtils.isEmpty(str) || !(str.contains("\u2063\u2064\u2063\u2064\u2063") || str.contains("\ufdd0") || str.contains("\u2063\u2063\u2064") || str.contains(" ￼") || str.indexOf(65532) >= 0)) {
                        if (list2 != null && !list2.isEmpty()) {
                            try {
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
                                        c = c;
                                        try {
                                            c2 = c2;
                                            try {
                                                Integer num2 = (Integer) e4.a(next.getClass(), "spanStart").get(next);
                                                Integer num3 = (Integer) e4.a(next.getClass(), "spanEnd").get(next);
                                                String str2 = (String) e4.a(next.getClass(), "mentionUserId").get(next);
                                                Integer num4 = (Integer) e4.a(next.getClass(), "mentionType").get(next);
                                                int iMax = num2 != null ? Math.max(0, num2.intValue() + length) : 0;
                                                int iMax2 = num3 != null ? Math.max(iMax, num3.intValue() + length) : iMax;
                                                m0 m0VarG = t0.g(str2);
                                                if (m0VarG != null) {
                                                    num = num3;
                                                    if (iMax2 <= sb.length()) {
                                                        if (iMax2 < 0 || iMax2 >= sb.length()) {
                                                            it = it2;
                                                        } else {
                                                            it = it2;
                                                            if ((iMax2 + 5 > sb.length() || sb.indexOf("\u2063\u2064\u2063\u2064\u2063", iMax2) != iMax2) && ((iMax2 + 1 > sb.length() || sb.indexOf("\ufdd0", iMax2) != iMax2) && (iMax2 + 3 > sb.length() || sb.indexOf("\u2063\u2063\u2064", iMax2) != iMax2))) {
                                                            }
                                                        }
                                                        if (iMax < iMax2) {
                                                            t0.a(sb.substring(iMax, iMax2), m0VarG);
                                                        }
                                                        String str3 = "\ufdd0" + ("\u2063\u2063\u2064" + t0.a(m0VarG) + "\u2064\u2063\u2063");
                                                        sb.insert(iMax2, str3);
                                                        length += str3.length();
                                                        z2 = true;
                                                    } else {
                                                        it = it2;
                                                    }
                                                } else {
                                                    num = num3;
                                                    it = it2;
                                                }
                                                arrayList.add(declaredConstructor.newInstance(num2 != null ? Integer.valueOf(iMax) : null, num != null ? Integer.valueOf(iMax2) : null, str2, num4));
                                            } catch (Throwable th) {
                                                th = th;
                                                th.getMessage();
                                                int i = v3.a;
                                                r0Var2 = null;
                                                if (r0Var2 == null) {
                                                    return;
                                                }
                                                objArr = hookMethodParam.args;
                                                objArr[c] = r0Var2.a;
                                                list = r0Var2.b;
                                                if (list != null) {
                                                    objArr[c2] = list;
                                                }
                                            }
                                        } catch (Throwable th2) {
                                            th = th2;
                                            c2 = c2;
                                            th.getMessage();
                                            int i2 = v3.a;
                                            r0Var2 = null;
                                            if (r0Var2 == null) {
                                                return;
                                            }
                                            objArr = hookMethodParam.args;
                                            objArr[c] = r0Var2.a;
                                            list = r0Var2.b;
                                            if (list != null) {
                                                objArr[c2] = list;
                                            }
                                        }
                                    }
                                    c = c;
                                    c2 = c2;
                                    it2 = it;
                                    z = false;
                                }
                                c = c;
                                c2 = c2;
                                if (z2) {
                                    r0Var2 = new r0(sb.toString(), arrayList);
                                } else {
                                    r0Var = null;
                                }
                            } catch (Throwable th3) {
                                th = th3;
                                c = c;
                            }
                        } else if (user == null) {
                            r0Var = null;
                        } else {
                            String strA = t0.a(user.getUid(), str);
                            if (TextUtils.equals(str, strA)) {
                                r0Var = null;
                            } else {
                                r0Var2 = new r0(strA, null);
                            }
                        }
                        if (r0Var2 == null) {
                            return;
                        }
                        objArr = hookMethodParam.args;
                        objArr[c] = r0Var2.a;
                        list = r0Var2.b;
                        if (list != null) {
                            objArr[c2] = list;
                        }
                    }
                    c = 4;
                    c2 = 5;
                    r0Var = null;
                }
                r0Var2 = r0Var;
                if (r0Var2 == null) {
                    return;
                }
                objArr = hookMethodParam.args;
                objArr[c] = r0Var2.a;
                list = r0Var2.b;
                if (list != null) {
                    objArr[c2] = list;
                }
            }
        }
    }
}
