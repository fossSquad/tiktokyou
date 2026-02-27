package ni.shikatu.kotlin.text;

import ni.shikatu.kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/text/ScreenFloatValueRegEx;", "", "<init>", "()V", "value", "Lni/shikatu/kotlin/text/Regex;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class ScreenFloatValueRegEx {
    public static final ScreenFloatValueRegEx INSTANCE = new ScreenFloatValueRegEx();
    public static final Regex value;

    private ScreenFloatValueRegEx() {
    }

    static {
        ScreenFloatValueRegEx screenFloatValueRegEx = INSTANCE;
        String Exp = "[eE][+-]?(\\p{Digit}+)";
        String HexString = "(0[xX](\\p{XDigit}+)(\\.)?)|(0[xX](\\p{XDigit}+)?(\\.)(\\p{XDigit}+))";
        String Number = "((\\p{Digit}+)(\\.)?((\\p{Digit}+)?)(" + Exp + ")?)|(\\.((\\p{Digit}+))(" + Exp + ")?)|((" + HexString + ")[pP][+-]?(\\p{Digit}+))";
        String fpRegex = "[\\x00-\\x20]*[+-]?(NaN|Infinity|((" + Number + ")[fFdD]?))[\\x00-\\x20]*";
        value = new Regex(fpRegex);
    }
}
