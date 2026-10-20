package Z;

public abstract class ea {
    public static final v9 a;
    public static final v9 b;

    static {
        w7 w7Var = new w7("PHOTO_MODE_IMAGE_INFO", "com.ss.android.ugc.aweme.feed.model.PhotoModeImageInfo");
        a = new v9(w7Var, "GET_IMAGE_LIST", new String[]{"getImageList"});
        b = new v9(w7Var, "GET_IMAGE_POST_COVER", new String[]{"getImagePostCover"});
    }
}
