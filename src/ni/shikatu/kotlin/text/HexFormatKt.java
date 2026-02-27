package ni.shikatu.kotlin.text;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.uuid.Uuid;

@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\u0010\u000e\n\u0000\u001a%\u0010\u0000\u001a\u00020\u00012\u0017\u0010\u0002\u001a\u0013\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\u0002\b\u0006H\u0087\bø\u0001\u0000\u001a\f\u0010\u0007\u001a\u00020\b*\u00020\tH\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n"}, d2 = {"HexFormat", "Lni/shikatu/kotlin/text/HexFormat;", "builderAction", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/text/HexFormat$Builder;", "", "Lni/shikatu/kotlin/ExtensionFunctionType;", "isCaseSensitive", "", "", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class HexFormatKt {
    private static final HexFormat HexFormat(Function1<? super HexFormat.Builder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        HexFormat.Builder builder = new HexFormat.Builder();
        function1.invoke(builder);
        return builder.build();
    }

    public static final boolean isCaseSensitive(String $this$isCaseSensitive) {
        String $this$any$iv = $this$isCaseSensitive;
        for (int i = 0; i < $this$any$iv.length(); i++) {
            char element$iv = $this$any$iv.charAt(i);
            char it = (Intrinsics.compare((int) element$iv, Uuid.SIZE_BITS) >= 0 || Character.isLetter(element$iv)) ? (char) 1 : (char) 0;
            if (it != 0) {
                return true;
            }
        }
        return false;
    }
}
