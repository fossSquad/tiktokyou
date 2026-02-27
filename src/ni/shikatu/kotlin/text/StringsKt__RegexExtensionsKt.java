package ni.shikatu.kotlin.text;

import java.util.Set;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\b\u001a\u0015\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001b\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0087\b¨\u0006\u0007"}, d2 = {"toRegex", "Lni/shikatu/kotlin/text/Regex;", "", "option", "Lni/shikatu/kotlin/text/RegexOption;", "options", "", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "ni/shikatu/kotlin/text/StringsKt")
class StringsKt__RegexExtensionsKt extends StringsKt__RegexExtensionsJVMKt {
    private static final Regex toRegex(String $this$toRegex) {
        Intrinsics.checkNotNullParameter($this$toRegex, "<this>");
        return new Regex($this$toRegex);
    }

    private static final Regex toRegex(String $this$toRegex, RegexOption option) {
        Intrinsics.checkNotNullParameter($this$toRegex, "<this>");
        Intrinsics.checkNotNullParameter(option, "option");
        return new Regex($this$toRegex, option);
    }

    private static final Regex toRegex(String $this$toRegex, Set<? extends RegexOption> set) {
        Intrinsics.checkNotNullParameter($this$toRegex, "<this>");
        Intrinsics.checkNotNullParameter(set, "options");
        return new Regex($this$toRegex, set);
    }
}
