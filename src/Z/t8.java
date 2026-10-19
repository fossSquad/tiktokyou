package Z;

public abstract class t8 {
    public static final v9 a;
    public static final v9 b;
    public static final v9 c;
    public static final v9 d;
    public static final v9 e;

    static {
        w7 w7Var = new w7("DOWNLOAD_STATUS_PROVIDER", "X.17gS");
        a = new v9(w7Var, "SHOW", new String[]{"LIZ"});
        b = new v9(w7Var, "PROGRESS", new String[]{"onProgress"});
        c = new v9(w7Var, "SUCCESS", new String[]{"onSuccess"});
        d = new v9(w7Var, "FAILED", new String[]{"onFailed"});
        e = new v9(w7Var, "CANCEL", new String[]{"onCancel"});
    }
}
