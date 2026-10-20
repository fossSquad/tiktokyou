package Z;

import android.text.TextUtils;
import com.ss.android.ugc.aweme.friendstab.repo.RepostTextExtra;
import com.ss.android.ugc.aweme.profile.model.User;
import com.windukk.hook.HookMethod;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class d1 extends HookMethod {

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Throwable thU = null;
        bf bfVar;
        bf bfVar2 = null;
        Object[] objArr;
        List list;
        Integer num;
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
                String[] strArr = v1.a;
                if (!TextUtils.isEmpty(str) && !v1.a(str)) {
                    if (list2 != null && !list2.isEmpty()) {
                        try {
                            Constructor declaredConstructor = RepostTextExtra.class.getDeclaredConstructor(Integer.class, Integer.class, String.class, Integer.class, String.class);
                            declaredConstructor.setAccessible(true);
                            StringBuilder sb = new StringBuilder(str);
                            ArrayList arrayList = new ArrayList(list2.size());
                            Iterator it = list2.iterator();
                            boolean z2 = false;
                            int length = 0;
                            while (it.hasNext()) {
                                Object next = it.next();
                                if (next == null) {
                                    arrayList.add(z);
                                    c = c;
                                    c2 = c2;
                                    it = it;
                                } else {
                                    c = c;
                                    c2 = c2;
                                    try {
                                        Integer num2 = (Integer) se.a((Class) next.getClass(), "spanStart").get(next);
                                        Integer num3 = (Integer) se.a((Class) next.getClass(), "spanEnd").get(next);
                                        String str2 = (String) se.a((Class) next.getClass(), "mentionUserId").get(next);
                                        Integer num4 = (Integer) se.a((Class) next.getClass(), "mentionType").get(next);
                                        String str3 = (String) se.a((Class) next.getClass(), "emojiId").get(next);
                                        int iMax = num2 != null ? Math.max(0, num2.intValue() + length) : 0;
                                        int iMax2 = num3 != null ? Math.max(iMax, num3.intValue() + length) : iMax;
                                        x1 x1VarC = v1.c(str2);
                                        if (x1VarC != null) {
                                            num = num2;
                                            if (iMax2 <= sb.length() && !v1.a(sb, iMax2)) {
                                                if (iMax < iMax2) {
                                                    v1.a(sb.substring(iMax, iMax2), x1VarC);
                                                }
                                                String str4 = "\ufdd0" + ("⁣⁣⁤" + v1.a(x1VarC) + "⁤⁣⁣");
                                                sb.insert(iMax2, str4);
                                                length += str4.length();
                                                z2 = true;
                                            }
                                        } else {
                                            num = num2;
                                        }
                                        arrayList.add(declaredConstructor.newInstance(num != null ? Integer.valueOf(iMax) : null, num3 != null ? Integer.valueOf(iMax2) : null, str2, num4, str3));
                                    } catch (Throwable th) {
                                        th = th;
                                        String strDecrypt = "Failed to patch repost text";
                                        Object obj4 = g7.a;
                                        g7.a(6, String.valueOf(strDecrypt), th);
                                        bfVar2 = null;
                                        if (bfVar2 == null) {
                                            return;
                                        }
                                        objArr = hookMethodParam.args;
                                        objArr[c] = bfVar2.a;
                                        list = bfVar2.b;
                                        if (list != null) {
                                            objArr[c2] = list;
                                        }
                                    }
                                }
                                c = c;
                                c2 = c2;
                                it = it;
                                z = false;
                            }
                            c = c;
                            c2 = c2;
                            if (z2) {
                                bfVar2 = new bf(sb.toString(), arrayList);
                            } else {
                                bfVar = null;
                            }
                        } catch (Throwable th2) {
                            thU = th2;
                            c = c;
                            c2 = c2;
                        }
                    } else if (user == null) {
                        bfVar = null;
                    } else {
                        String strA = v1.a(user.getUid(), str);
                        if (TextUtils.equals(str, strA)) {
                            bfVar = null;
                        } else {
                            bfVar2 = new bf(strA, null);
                        }
                    }
                    if (bfVar2 == null) {
                        return;
                    }
                    objArr = hookMethodParam.args;
                    objArr[c] = bfVar2.a;
                    list = bfVar2.b;
                    if (list != null) {
                        objArr[c2] = list;
                    }
                }
                c = 4;
                c2 = 5;
                bfVar = null;
                bfVar2 = bfVar;
                if (bfVar2 == null) {
                    return;
                }
                objArr = hookMethodParam.args;
                objArr[c] = bfVar2.a;
                list = bfVar2.b;
                if (list != null) {
                    objArr[c2] = list;
                }
            }
        }
    }
}
