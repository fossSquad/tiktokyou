package X;

import de.robv.android.xposed.XC_MethodHook;

class v1 extends XC_MethodHook {

    public void beforeHookedMethod(XC_MethodHook.MethodHookParam methodHookParam) {
        String str;
        if (i1.a().a) {
            byte b = 0;
            String str2 = (String) methodHookParam.args[0];
            int i = m2.a;
            if (str2 != null) {
                o1 o1VarB = i1.a().b();
                switch (str2.hashCode()) {
                    case -1990206200:
                        if (!str2.equals("gsm.sim.operator.iso-country")) {
                            b = -1;
                        }
                        break;
                    case -1092762352:
                        if (!str2.equals("gsm.operator.numeric")) {
                            b = -1;
                        } else {
                            b = 1;
                        }
                        break;
                    case -822345695:
                        if (!str2.equals("gsm.operator.alpha")) {
                            b = -1;
                        } else {
                            b = 2;
                        }
                        break;
                    case -719264057:
                        if (!str2.equals("gsm.sim.operator.numeric")) {
                            b = -1;
                        } else {
                            b = 3;
                        }
                        break;
                    case 287955924:
                        if (!str2.equals("persist.sys.timezone")) {
                            b = -1;
                        } else {
                            b = 4;
                        }
                        break;
                    case 1010443160:
                        if (!str2.equals("gsm.sim.operator.alpha")) {
                            b = -1;
                        } else {
                            b = 5;
                        }
                        break;
                    case 1865482649:
                        if (!str2.equals("gsm.operator.country")) {
                            b = -1;
                        } else {
                            b = 6;
                        }
                        break;
                    case 1904373457:
                        if (!str2.equals("gsm.operator.iso-country")) {
                            b = -1;
                        } else {
                            b = 7;
                        }
                        break;
                    default:
                        b = -1;
                        break;
                }
                switch (b) {
                    case 0:
                    case 6:
                    case 7:
                        str = o1VarB.b;
                        break;
                    case 1:
                    case 3:
                        str = o1VarB.c;
                        break;
                    case 2:
                    case 5:
                        str = o1VarB.d;
                        break;
                    case 4:
                        str = o1VarB.e;
                        break;
                    default:
                        str = null;
                        break;
                }
            } else {
                str = null;
            }
            if (str != null) {
                methodHookParam.setResult(str);
            }
        }
    }
}
