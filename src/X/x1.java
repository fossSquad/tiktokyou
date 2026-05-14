package X;

import com.windukk.hook.HookMethod;

class x1 extends HookMethod {

    public void beforeHookedMethod(HookMethod.HookMethodParam hookMethodParam) {
        Object[] objArr = hookMethodParam.args;
        byte b = 0;
        String str = (String) objArr[0];
        if (objArr[1] instanceof String) {
            str.getClass();
            switch (str.hashCode()) {
                case -1534836170:
                    if (!str.equals("google_aid")) {
                        b = -1;
                    }
                    break;
                case -631728658:
                    if (!str.equals("cliend_udid")) {
                        b = -1;
                    } else {
                        b = 1;
                    }
                    break;
                case -503667404:
                    if (!str.equals("openudid")) {
                        b = -1;
                    } else {
                        b = 2;
                    }
                    break;
                case 3048764:
                    if (!str.equals("cdid")) {
                        b = -1;
                    } else {
                        b = 3;
                    }
                    break;
                case 722989291:
                    if (!str.equals("android_id")) {
                        b = -1;
                    } else {
                        b = 4;
                    }
                    break;
                case 1103415861:
                    if (!str.equals("clientudid")) {
                        b = -1;
                    } else {
                        b = 5;
                    }
                    break;
                default:
                    b = -1;
                    break;
            }
            switch (b) {
                case 0:
                    hookMethodParam.args[1] = h2.c;
                    break;
                case 1:
                case 5:
                    hookMethodParam.args[1] = h2.d;
                    break;
                case 2:
                case 4:
                    hookMethodParam.args[1] = h2.b;
                    break;
                case 3:
                    hookMethodParam.args[1] = h2.e;
                    break;
            }
        }
    }
}
