package Z;

public abstract class ga {
    public static final v9 a;
    public static final v9 b;

    static {
        w7 w7Var = new w7("PHOTO_VIDEO", "com.ss.android.ugc.aweme.feed.model.Video");
        a = new v9(w7Var, "GET_DOWNLOAD_ADDR", new String[]{"getDownloadAddr"});
        b = new v9(w7Var, "GET_DOWNLOAD_NO_WATERMARK_ADDR", new String[]{"getDownloadNoWatermarkAddr"});
    }
}
