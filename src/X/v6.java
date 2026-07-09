package X;

public abstract class v6 {
    public static final o5 a;
    public static final t6 b;
    public static final t6 c;
    public static final t6 d;

    static {
        o5 o5Var = new o5("OFFLINE_MODE_COUNT_META", "X.0MlM");
        a = o5Var;
        b = new t6(o5Var, "GET_COUNT", new String[]{"getCount"});
        c = new t6(o5Var, "GET_MINUTES", new String[]{"getMinutes"});
        d = new t6(o5Var, "GET_SIZE", new String[]{"getSize"});
    }
}
