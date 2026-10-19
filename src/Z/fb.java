package Z;

public abstract class fb {
    public static final v9 a;
    public static final v9 b;

    static {
        w7 w7Var = new w7("SOCIAL_DOWNLOAD_INFO", "com.ss.android.socialbase.downloader.model.DownloadInfo");
        a = new v9(w7Var, "GET_SAVE_PATH", new String[]{"getSavePath"});
        b = new v9(w7Var, "GET_NAME", new String[]{"getName"});
    }
}
