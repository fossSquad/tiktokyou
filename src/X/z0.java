package X;

import de.robv.android.xposed.XC_MethodHook;

class z0 extends XC_MethodHook {
    public void afterHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        String str;
        Object result = methodHookParam.getResult();
        if (result instanceof String) {
            String str2 = (String) result;
            if (str2.length() != 19) {
                return;
            }
            int i = 0;
            for (int i2 = 0; i2 < str2.length(); i2++) {
                if (!Character.isDigit(str2.charAt(i2))) {
                    return;
                }
            }
            r2 r2VarA = r2.a();
            if (r2VarA == null) {
                return;
            }
            String string = r2VarA.m;
            if (string == null) {
                string = r2.o.getString("random_android_id", null);
            }
            String strSubstring = str2.substring(0, 15);
            String strSubstring2 = str2.substring(15);
            if (string == null || string.length() != 19) {
                str = strSubstring + a1.a(strSubstring2);
                r2VarA.a(str);
                break;
            }
            while (true) {
                if (i >= string.length()) {
                    String strSubstring3 = string.substring(15);
                    if (strSubstring3.equals(strSubstring2)) {
                        strSubstring3 = a1.a(strSubstring2);
                    }
                    str = strSubstring + strSubstring3;
                    if (!str.equals(string)) {
                        r2VarA.a(str);
                        break;
                    }
                    break;
                }
                if (!Character.isDigit(string.charAt(i))) {
                    str = strSubstring + a1.a(strSubstring2);
                    r2VarA.a(str);
                    break;
                }
                i++;
            }
            if (str == null || str.equals(str2)) {
                return;
            }
            methodHookParam.setResult(str);
        }
    }
}
