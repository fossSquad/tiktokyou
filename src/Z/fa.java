package Z;

public abstract class fa {
    public static final e9 a;
    public static final e9 b;
    public static final e9 c;
    public static final e9 d;
    public static final e9 e;

    static {
        w7 w7Var = new w7("PHOTO_MODE_IMAGE_URL_MODEL", "com.ss.android.ugc.aweme.feed.model.PhotoModeImageUrlModel");
        a = new e9(w7Var, "DISPLAY_NO_WATERMARK", new String[]{"displayImageNoWatermark"});
        b = new e9(w7Var, "OWNER_WATERMARK", new String[]{"ownerWatermarkImage"});
        c = new e9(w7Var, "USER_WATERMARK", new String[]{"userWatermarkImage"});
        d = new e9(w7Var, "BITRATE_IMAGES", new String[]{"bitrateImages"});
        e = new e9(w7Var, "LIVE_PHOTO", new String[]{"livePhotoStruct"});
    }
}
