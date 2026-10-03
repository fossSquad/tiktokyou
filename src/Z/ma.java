package Z;

public abstract class ma {
    public static final p8 a;
    public static final p8 b;
    public static final p8 c;

    static {
        w6 w6Var = new w6("WATERMARK_LISTENER", "com.ss.android.ugc.aweme.services.watermark.WaterMarkListener");
        a = new p8(w6Var, "ON_START", new String[]{"onStart"});
        b = new p8(w6Var, "ON_PROGRESS", new String[]{"onProgress"});
        c = new p8(w6Var, "ON_SUCCESS", new String[]{"onSuccess"});
        oa.a("method", "ON_ERROR", (String[]) new String[]{"onError"}.clone());
    }
}
