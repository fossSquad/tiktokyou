package Z;

import Z.h6;

import com.ss.android.ugc.aweme.feed.model.Aweme;
import com.windukk.hook.HookMethod;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006¸\u0006\u0000"}, d2 = {"ni/shikatu/extensions/HookUtilsKt$after$2", "Lcom/windukk/hook/HookMethod;", "afterHookedMethod", "", "param", "Lcom/windukk/hook/HookMethod$HookMethodParam;", "ttmod:mod_release"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class PhotoHooks$after$2 extends HookMethod {

    public void afterHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        String str;
        try {
            Object[] objArr = hookMethodParam.args;
            if (objArr.length >= 4) {
                Object obj = objArr[0];
                if (obj instanceof Aweme) {
                    boolean z = true;
                    if (objArr[1] instanceof Integer) {
                        Aweme aweme = (Aweme) obj;
                        Object obj2 = hookMethodParam.args[1];
                        int iIntValue = ((Integer) obj2).intValue();
                        Object obj3 = hookMethodParam.args[3];
                        String str2 = null;
                        boolean zAreEqual = Intrinsics.areEqual(obj3 instanceof Boolean ? (Boolean) obj3 : null, Boolean.TRUE);
                        PhotoHooks ccVar = PhotoHooks.a;
                        String strA = PhotoHooks.a(aweme, iIntValue, zAreEqual);
                        Object result = hookMethodParam.getResult();
                        String str3 = result instanceof String ? (String) result : null;
                        if (strA == null) {
                            str = null;
                        } else {
                            if (StringsKt.isBlank(strA) || StringsKt.startsWith$default(strA, "file", false, 2, (Object) null) || PhotoHooks.c(strA)) {
                                str = null;
                            } else {
                                str = strA;
                            }
                        }
                        if (str3 != null) {
                            if (!StringsKt.isBlank(str3) && !StringsKt.startsWith$default(str3, "file", false, 2, (Object) null) && !PhotoHooks.c(str3)) {
                                z = false;
                            }
                            if (!z) {
                                str2 = str3;
                            }
                        }
                        if (str != null) {
                            strA = str;
                        } else if (str2 != null) {
                            strA = str2;
                        } else if (strA == null) {
                            strA = str3;
                        }
                        if (strA != null) {
                            if (strA.length() == 0 || Intrinsics.areEqual(strA, str3)) {
                                return;
                            }
                            PhotoHooks.c(strA);
                            hookMethodParam.setResult(strA);
                        }
                    }
                }
            }
        } catch (Throwable th) {
            h6.a(6, h6.a(new StringBuilder().append("Unhandled hook exception on ").append(hookMethodParam.method.getName()).toString(), new Object[0]), th);
        }
    }
}
