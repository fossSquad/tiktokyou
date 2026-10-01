package com.windukk.mod;

import Z.p8;
import Z.w6;

public abstract class a {
    public static final p8 a;
    public static final p8 b;
    public static final p8 c;
    public static final p8 d;
    public static final p8 e;

    static {
        w6 w6Var = new w6("DOWNLOAD_STATUS_PROVIDER", "X.164V");
        a = new p8(w6Var, "SHOW", new String[]{"LIZ"});
        b = new p8(w6Var, "PROGRESS", new String[]{"onProgress"});
        c = new p8(w6Var, "SUCCESS", new String[]{"onSuccess"});
        d = new p8(w6Var, "FAILED", new String[]{"onFailed"});
        e = new p8(w6Var, "CANCEL", new String[]{"onCancel"});
    }
}
