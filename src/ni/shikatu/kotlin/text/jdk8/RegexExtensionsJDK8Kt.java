package ni.shikatu.kotlin.text.jdk8;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.MatchGroup;
import ni.shikatu.kotlin.text.MatchGroupCollection;
import ni.shikatu.kotlin.text.MatchNamedGroupCollection;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a&\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0082\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¨\u0006\b"}, d2 = {"get", "Lni/shikatu/kotlin/text/MatchGroup;", "Lni/shikatu/kotlin/text/MatchGroupCollection;", "name", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.2", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, pn = "ni.shikatu.kotlin.text", xi = 48)
public final class RegexExtensionsJDK8Kt {
    public static final MatchGroup get(MatchGroupCollection $this$get, String name) {
        Intrinsics.checkNotNullParameter($this$get, "<this>");
        Intrinsics.checkNotNullParameter(name, "name");
        MatchNamedGroupCollection namedGroups = $this$get instanceof MatchNamedGroupCollection ? (MatchNamedGroupCollection) $this$get : null;
        if (namedGroups == null) {
            throw new UnsupportedOperationException("Retrieving groups by name is not supported on this platform.");
        }
        return namedGroups.get(name);
    }
}
