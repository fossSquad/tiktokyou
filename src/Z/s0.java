package Z;

import android.text.TextUtils;
import com.ss.android.ugc.aweme.friendstab.repo.RepostTextExtra;
import com.ss.android.ugc.aweme.profile.model.User;
import com.windukk.hook.HookMethod;
import Z.BadgeHooks;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

class s0 extends HookMethod {

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Throwable th = null;
        md mdVar;
        md mdVar2 = null;
        Object[] objArr;
        List list;
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
                String[] strArr = BadgeHooks.a;
                if (!TextUtils.isEmpty(str) && !BadgeHooks.a(str)) {
                    if (list2 != null && !list2.isEmpty()) {
                        try {
                            int i = 0;
                            Constructor declaredConstructor = RepostTextExtra.class.getDeclaredConstructor(Integer.class, Integer.class, String.class, Integer.class);
                            declaredConstructor.setAccessible(true);
                            StringBuilder sb = new StringBuilder(str);
                            ArrayList arrayList = new ArrayList(list2.size());
                            boolean z2 = false;
                            int length = 0;
                            for (Object obj4 : list2) {
                                if (obj4 == null) {
                                    arrayList.add(z);
                                    c = c;
                                    c2 = c2;
                                } else {
                                    c = c;
                                    c2 = c2;
                                    try {
                                        Integer num = (Integer) dd.a((Class) obj4.getClass(), "spanStart").get(obj4);
                                        Integer num2 = (Integer) dd.a((Class) obj4.getClass(), "spanEnd").get(obj4);
                                        String str2 = (String) dd.a((Class) obj4.getClass(), "mentionUserId").get(obj4);
                                        Integer num3 = (Integer) dd.a((Class) obj4.getClass(), "mentionType").get(obj4);
                                        int iMax = num != null ? Math.max(i, num.intValue() + length) : i;
                                        int iMax2 = num2 != null ? Math.max(iMax, num2.intValue() + length) : iMax;
                                        n1 n1VarB = BadgeHooks.b(str2);
                                        if (n1VarB != null && iMax2 <= sb.length() && !BadgeHooks.a(sb, iMax2)) {
                                            if (iMax < iMax2) {
                                                BadgeHooks.a(sb.substring(iMax, iMax2), n1VarB);
                                            }
                                            String str3 = "\ufdd0" + ("⁣⁣⁤" + BadgeHooks.a(n1VarB) + "⁤⁣⁣");
                                            sb.insert(iMax2, str3);
                                            length += str3.length();
                                            z2 = true;
                                        }
                                        arrayList.add(declaredConstructor.newInstance(num != null ? Integer.valueOf(iMax) : null, num2 != null ? Integer.valueOf(iMax2) : null, str2, num3));
                                    } catch (Throwable th_2) {
                                        th = th_2;
                                        String strDecrypt = "Failed to patch repost text";
                                        Object obj5 = h6.a;
                                        h6.a(6, String.valueOf(strDecrypt), th);
                                        mdVar2 = null;
                                        if (mdVar2 == null) {
                                            return;
                                        }
                                        objArr = hookMethodParam.args;
                                        objArr[c] = mdVar2.a;
                                        list = mdVar2.b;
                                        if (list != null) {
                                            objArr[c2] = list;
                                        }
                                    }
                                }
                                c = c;
                                c2 = c2;
                                z = false;
                                i = 0;
                            }
                            c = c;
                            c2 = c2;
                            if (z2) {
                                mdVar2 = new md(sb.toString(), arrayList);
                            } else {
                                mdVar = null;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            c = c;
                            c2 = c2;
                        }
                    } else if (user == null) {
                        mdVar = null;
                    } else {
                        String strA = BadgeHooks.a(user.getUid(), str);
                        if (TextUtils.equals(str, strA)) {
                            mdVar = null;
                        } else {
                            mdVar2 = new md(strA, null);
                        }
                    }
                    if (mdVar2 == null) {
                        return;
                    }
                    objArr = hookMethodParam.args;
                    objArr[c] = mdVar2.a;
                    list = mdVar2.b;
                    if (list != null) {
                        objArr[c2] = list;
                    }
                }
                c = 4;
                c2 = 5;
                mdVar = null;
                mdVar2 = mdVar;
                if (mdVar2 == null) {
                    return;
                }
                objArr = hookMethodParam.args;
                objArr[c] = mdVar2.a;
                list = mdVar2.b;
                if (list != null) {
                    objArr[c2] = list;
                }
            }
        }
    }
}
