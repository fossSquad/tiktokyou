package Z;

public abstract class vb {
    public static final v9 a;
    public static final v9 b;
    public static final v9 c;
    public static final v9 d;
    public static final v9 e;
    public static final v9 f;
    public static final v9 g;
    public static final v9 h;

    static {
        w7 w7Var = new w7("WATERMARK_SERVICE_IMPL", "com.ss.android.ugc.aweme.watermark.WaterMarkServiceImpl");
        a = new v9(w7Var, "WATER_MARK", new String[]{"waterMark"});
        b = new v9(w7Var, "WATER_MARK_NOW", new String[]{"watermarkForTikTokNow"});
        c = new v9(w7Var, "ADD_WATERMARK_TO_IMAGE", new String[]{"addWaterMarkToImage"});
        d = new v9(w7Var, "ADD_AI_PORTRAIT", new String[]{"addAIPortraitWatermarkToImage"});
        e = new v9(w7Var, "ADD_AI_TEXT", new String[]{"addAITextImageWaterMarkToImage"});
        f = new v9(w7Var, "ADD_AI_CHAT", new String[]{"addAiChatWaterMarkToImage"});
        g = new v9(w7Var, "CREATE_WATERMARK_FILE", new String[]{"createWaterMarkFile"});
        h = new v9(w7Var, "READ_AIGC_SINGLE", new String[]{"readAIGCAddAIPortraitWatermarkForSingleImage"});
    }
}
