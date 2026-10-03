package com.windukk.mod;

import Z.p8;
import Z.w6;

public abstract class c {
    public static final p8 a;
    public static final p8 b;
    public static final p8 c;

    static {
        w6 w6Var = new w6("FEED_PAGER_LEGACY_STORE", "X.07md");
        a = new p8(w6Var, "FEED_PAGER_LEGACY_REPLACE_ALL", new String[]{"LJI"});
        b = new p8(w6Var, "FEED_PAGER_LEGACY_INSERT", new String[]{"LJFF"});
        c = new p8(w6Var, "FEED_PAGER_LEGACY_REPLACE_ONE", new String[]{"LJII"});
    }
}
