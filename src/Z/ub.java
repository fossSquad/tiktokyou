package Z;

public abstract class ub {
    public static final v9 a;
    public static final v9 b;
    public static final v9 c;

    static {
        w7 w7Var = new w7("WATERMARK_LISTENER", "com.ss.android.ugc.aweme.services.watermark.WaterMarkListener");
        a = new v9(w7Var, "ON_START", new String[]{"onStart"});
        b = new v9(w7Var, "ON_PROGRESS", new String[]{"onProgress"});
        c = new v9(w7Var, "ON_SUCCESS", new String[]{"onSuccess"});
        wb.a("method", "ON_ERROR", (String[]) new String[]{"onError"}.clone());
    }
}
