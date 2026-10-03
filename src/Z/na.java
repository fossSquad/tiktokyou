package Z;

public abstract class na {
    public static final p8 a;
    public static final p8 b;
    public static final p8 c;
    public static final p8 d;
    public static final p8 e;
    public static final p8 f;
    public static final p8 g;
    public static final p8 h;

    static {
        w6 w6Var = new w6("WATERMARK_SERVICE_IMPL", "com.ss.android.ugc.aweme.watermark.WaterMarkServiceImpl");
        a = new p8(w6Var, "WATER_MARK", new String[]{"waterMark"});
        b = new p8(w6Var, "WATER_MARK_NOW", new String[]{"watermarkForTikTokNow"});
        c = new p8(w6Var, "ADD_WATERMARK_TO_IMAGE", new String[]{"addWaterMarkToImage"});
        d = new p8(w6Var, "ADD_AI_PORTRAIT", new String[]{"addAIPortraitWatermarkToImage"});
        e = new p8(w6Var, "ADD_AI_TEXT", new String[]{"addAITextImageWaterMarkToImage"});
        f = new p8(w6Var, "ADD_AI_CHAT", new String[]{"addAiChatWaterMarkToImage"});
        g = new p8(w6Var, "CREATE_WATERMARK_FILE", new String[]{"createWaterMarkFile"});
        h = new p8(w6Var, "READ_AIGC_SINGLE", new String[]{"readAIGCAddAIPortraitWatermarkForSingleImage"});
    }
}
