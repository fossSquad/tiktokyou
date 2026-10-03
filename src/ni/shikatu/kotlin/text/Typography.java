package ni.shikatu.kotlin.text;

import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecatedSinceKotlin;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\f\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000f\u0010\u0004\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0006\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0007\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\b\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\t\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u000b\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\f\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\r\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u000e\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u000f\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R%\u0010\u0010\u001a\u00020\u00058\u0006X\u0087Ô\br\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014¢\u0006\b\n\u0000\u0012\u0004\b\u0011\u0010\u0003R%\u0010\u0015\u001a\u00020\u00058\u0006X\u0087Ô\br\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0003R\u000f\u0010\u0017\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0018\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0019\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u001a\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u001b\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u001c\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u001d\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u001e\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u001f\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010 \u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010!\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\"\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010#\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010$\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010%\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010&\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010'\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010(\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010)\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010*\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010+\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010,\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010-\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010.\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010/\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u00100\u001a\u00020\u0005X\u0086Ô\b¢\u0006\u0002\n\u0000RQ\u00101\u001a\u00020\u00058\u0006X\u0087Ô\br*\b3\u0012\b\b4\u0012\u0004\b\b(5\u0012\u001c\b6\u0012\u0018\b\u000bB\u0014\b7\u0012\b\b8\u0012\u0004\b\b(9\u0012\u0006\b:\u0012\u0002\b\fr\f\b;\u0012\b\b<\u0012\u0004\b\b(\u0014¢\u0006\b\n\u0000\u0012\u0004\b2\u0010\u0003RQ\u0010=\u001a\u00020\u00058\u0006X\u0087Ô\br*\b3\u0012\b\b4\u0012\u0004\b\b(?\u0012\u001c\b6\u0012\u0018\b\u000bB\u0014\b7\u0012\b\b8\u0012\u0004\b\b(@\u0012\u0006\b:\u0012\u0002\b\fr\f\b;\u0012\b\b<\u0012\u0004\b\b(\u0014¢\u0006\b\n\u0000\u0012\u0004\b>\u0010\u0003¨\u0006A"}, d2 = {"Lni/shikatu/kotlin/text/Typography;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "quote", _UrlKt.FRAGMENT_ENCODE_SET, "dollar", "amp", "less", "greater", "nbsp", "times", "cent", "pound", "section", "copyright", "leftGuillemet", "getLeftGuillemet$annotations", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.6", "rightGuillemet", "getRightGuillemet$annotations", "registered", "degree", "plusMinus", "paragraph", "middleDot", "half", "ndash", "mdash", "leftSingleQuote", "rightSingleQuote", "lowSingleQuote", "leftDoubleQuote", "rightDoubleQuote", "lowDoubleQuote", "dagger", "doubleDagger", "bullet", "ellipsis", "prime", "doublePrime", "euro", "tm", "almostEqual", "notEqual", "lessOrEqual", "greaterOrEqual", "leftGuillemete", "getLeftGuillemete$annotations", "Lni/shikatu/kotlin/Deprecated;", "message", "This constant has a typo in the name. Use leftGuillemet instead.", "replaceWith", "Lni/shikatu/kotlin/ReplaceWith;", "expression", "Typography.leftGuillemet", "imports", "Lni/shikatu/kotlin/DeprecatedSinceKotlin;", "warningSince", "rightGuillemete", "getRightGuillemete$annotations", "This constant has a typo in the name. Use rightGuillemet instead.", "Typography.rightGuillemet", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Typography {
    public static final Typography INSTANCE = new Typography();
    public static final char almostEqual = 8776;
    public static final char amp = '&';
    public static final char bullet = 8226;
    public static final char cent = 162;
    public static final char copyright = 169;
    public static final char dagger = 8224;
    public static final char degree = 176;
    public static final char dollar = '$';
    public static final char doubleDagger = 8225;
    public static final char doublePrime = 8243;
    public static final char ellipsis = 8230;
    public static final char euro = 8364;
    public static final char greater = '>';
    public static final char greaterOrEqual = 8805;
    public static final char half = 189;
    public static final char leftDoubleQuote = 8220;
    public static final char leftGuillemet = 171;
    public static final char leftGuillemete = 171;
    public static final char leftSingleQuote = 8216;
    public static final char less = '<';
    public static final char lessOrEqual = 8804;
    public static final char lowDoubleQuote = 8222;
    public static final char lowSingleQuote = 8218;
    public static final char mdash = 8212;
    public static final char middleDot = 183;
    public static final char nbsp = 160;
    public static final char ndash = 8211;
    public static final char notEqual = 8800;
    public static final char paragraph = 182;
    public static final char plusMinus = 177;
    public static final char pound = 163;
    public static final char prime = 8242;
    public static final char quote = '\"';
    public static final char registered = 174;
    public static final char rightDoubleQuote = 8221;
    public static final char rightGuillemet = 187;
    public static final char rightGuillemete = 187;
    public static final char rightSingleQuote = 8217;
    public static final char section = 167;
    public static final char times = 215;
    public static final char tm = 8482;

    public static  void getLeftGuillemet$annotations() {
    }

    @Deprecated(message = "This constant has a typo in the name. Use leftGuillemet instead.", replaceWith = @ReplaceWith(expression = "Typography.leftGuillemet", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.6")
    public static  void getLeftGuillemete$annotations() {
    }

    public static  void getRightGuillemet$annotations() {
    }

    @Deprecated(message = "This constant has a typo in the name. Use rightGuillemet instead.", replaceWith = @ReplaceWith(expression = "Typography.rightGuillemet", imports = {}))
    @DeprecatedSinceKotlin(warningSince = "1.6")
    public static  void getRightGuillemete$annotations() {
    }

    private Typography() {
    }
}
