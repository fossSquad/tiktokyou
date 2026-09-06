package Z;

public abstract class s8 {
    public static final w6 a;
    public static final p8 b;
    public static final p8 c;
    public static final p8 d;

    static {
        w6 w6Var = new w6("OFFLINE_MODE_COUNT_META", "X.1HOq");
        a = w6Var;
        b = new p8(w6Var, "GET_COUNT", new String[]{"getCount"});
        c = new p8(w6Var, "GET_MINUTES", new String[]{"getMinutes"});
        d = new p8(w6Var, "GET_SIZE", new String[]{"getSize"});
    }
}
