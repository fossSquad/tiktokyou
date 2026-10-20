package Z;

public abstract class y9 {
    public static final w7 a;
    public static final v9 b;
    public static final v9 c;
    public static final v9 d;

    static {
        w7 w7Var = new w7("OFFLINE_MODE_COUNT_META", "X.1M2V");
        a = w7Var;
        b = new v9(w7Var, "GET_COUNT", new String[]{"getCount"});
        c = new v9(w7Var, "GET_MINUTES", new String[]{"getMinutes"});
        d = new v9(w7Var, "GET_SIZE", new String[]{"getSize"});
    }
}
