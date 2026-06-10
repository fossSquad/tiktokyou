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

class h0 extends HookMethod {

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        x8 x8Var;
        x8 x8Var2;
        Object[] objArr;
        List list;
        Iterator it;
        boolean z;
        Integer numValueOf;
        Integer numValueOf2;
        Object[] objArr2 = hookMethodParam.args;
        if (objArr2.length >= 6) {
            char c = 4;
            Object obj = objArr2[4];
            if (obj instanceof String) {
                String str = (String) obj;
                char c2 = 5;
                Object obj2 = objArr2[5];
                boolean z2 = false;
                List list2 = obj2 instanceof List ? (List) obj2 : null;
                Object obj3 = objArr2[2];
                User user = obj3 instanceof User ? (User) obj3 : null;
                ConcurrentHashMap concurrentHashMap = a1.a;
                if (!TextUtils.isEmpty(str) && !a1.a(str)) {
                    if (list2 != null && !list2.isEmpty()) {
                        try {
                            int i = 0;
                            Constructor declaredConstructor = RepostTextExtra.class.getDeclaredConstructor(Integer.class, Integer.class, String.class, Integer.class);
                            declaredConstructor.setAccessible(true);
                            StringBuilder sb = new StringBuilder(str);
                            ArrayList arrayList = new ArrayList(list2.size());
                            Iterator it2 = list2.iterator();
                            boolean z3 = false;
                            int length = 0;
                            while (it2.hasNext()) {
                                Object next = it2.next();
                                if (next == null) {
                                    arrayList.add(z2);
                                    c = c;
                                    c2 = c2;
                                    it = it2;
                                } else {
                                    Integer num = (Integer) g8.a((Class) next.getClass(), "spanStart").get(next);
                                    Integer num2 = (Integer) g8.a((Class) next.getClass(), "spanEnd").get(next);
                                    c = c;
                                    try {
                                        String str2 = (String) g8.a((Class) next.getClass(), "mentionUserId").get(next);
                                        c2 = c2;
                                        try {
                                            Integer num3 = (Integer) g8.a((Class) next.getClass(), "mentionType").get(next);
                                            int iMax = num != null ? Math.max(i, num.intValue() + length) : i;
                                            int iMax2 = num2 != null ? Math.max(iMax, num2.intValue() + length) : iMax;
                                            c1 c1VarC = a1.c(str2);
                                            if (c1VarC == null || iMax2 > sb.length()) {
                                                it = it2;
                                                z = z3;
                                            } else {
                                                if (iMax2 >= 0) {
                                                    it = it2;
                                                    if (iMax2 < sb.length()) {
                                                        z = z3;
                                                        if ((iMax2 + 5 > sb.length() || sb.indexOf("\u2063\u2064\u2063\u2064\u2063", iMax2) != iMax2) && ((iMax2 + 1 > sb.length() || sb.indexOf("\ufdd0", iMax2) != iMax2) && (iMax2 + 3 > sb.length() || sb.indexOf("\u2063\u2063\u2064", iMax2) != iMax2))) {
                                                        }
                                                        if (num != null) {
                                                            numValueOf = Integer.valueOf(iMax);
                                                        } else {
                                                            numValueOf = null;
                                                        }
                                                        if (num2 != null) {
                                                            numValueOf2 = Integer.valueOf(iMax2);
                                                        } else {
                                                            numValueOf2 = null;
                                                        }
                                                        arrayList.add(declaredConstructor.newInstance(numValueOf, numValueOf2, str2, num3));
                                                    }
                                                } else {
                                                    it = it2;
                                                }
                                                if (iMax < iMax2) {
                                                    a1.a(sb.substring(iMax, iMax2), c1VarC);
                                                }
                                                String str3 = "\ufdd0" + ("\u2063\u2063\u2064" + a1.a(c1VarC) + "\u2064\u2063\u2063");
                                                sb.insert(iMax2, str3);
                                                length += str3.length();
                                                z3 = true;
                                                if (num != null) {
                                                    numValueOf = Integer.valueOf(iMax);
                                                } else {
                                                    numValueOf = null;
                                                }
                                                if (num2 != null) {
                                                    numValueOf2 = Integer.valueOf(iMax2);
                                                } else {
                                                    numValueOf2 = null;
                                                }
                                                arrayList.add(declaredConstructor.newInstance(numValueOf, numValueOf2, str2, num3));
                                            }
                                            z3 = z;
                                            if (num != null) {
                                                numValueOf = Integer.valueOf(iMax);
                                            } else {
                                                numValueOf = null;
                                            }
                                            if (num2 != null) {
                                                numValueOf2 = Integer.valueOf(iMax2);
                                            } else {
                                                numValueOf2 = null;
                                            }
                                            arrayList.add(declaredConstructor.newInstance(numValueOf, numValueOf2, str2, num3));
                                        } catch (Throwable th) {
                                            th = th;
                                            th.getMessage();
                                            int i2 = p4.a;
                                            x8Var2 = null;
                                            if (x8Var2 == null) {
                                                return;
                                            }
                                            objArr = hookMethodParam.args;
                                            objArr[c] = x8Var2.a;
                                            list = x8Var2.b;
                                            if (list != null) {
                                                objArr[c2] = list;
                                            }
                                        }
                                    } catch (Throwable th2) {
                                        th = th2;
                                        c2 = c2;
                                        th.getMessage();
                                        int i3 = p4.a;
                                        x8Var2 = null;
                                        if (x8Var2 == null) {
                                            return;
                                        }
                                        objArr = hookMethodParam.args;
                                        objArr[c] = x8Var2.a;
                                        list = x8Var2.b;
                                        if (list != null) {
                                            objArr[c2] = list;
                                        }
                                    }
                                }
                                c = c;
                                c2 = c2;
                                it2 = it;
                                z2 = false;
                                i = 0;
                            }
                            c = c;
                            c2 = c2;
                            if (z3) {
                                x8Var2 = new x8(sb.toString(), arrayList);
                            } else {
                                x8Var = null;
                            }
                        } catch (Throwable th3) {
                            th = th3;
                            c = c;
                        }
                    } else if (user == null) {
                        x8Var = null;
                    } else {
                        String strA = a1.a(user.getUid(), str);
                        if (TextUtils.equals(str, strA)) {
                            x8Var = null;
                        } else {
                            x8Var2 = new x8(strA, null);
                        }
                    }
                    if (x8Var2 == null) {
                        return;
                    }
                    objArr = hookMethodParam.args;
                    objArr[c] = x8Var2.a;
                    list = x8Var2.b;
                    if (list != null) {
                        objArr[c2] = list;
                    }
                }
                c = 4;
                c2 = 5;
                x8Var = null;
                x8Var2 = x8Var;
                if (x8Var2 == null) {
                    return;
                }
                objArr = hookMethodParam.args;
                objArr[c] = x8Var2.a;
                list = x8Var2.b;
                if (list != null) {
                    objArr[c2] = list;
                }
            }
        }
    }
}
