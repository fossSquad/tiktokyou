package ni.shikatu.kotlin.text;

import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.IntRange;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001:\u0001\u0017J\f\u0010\u0016\u001a\u0004\u0018\u00010\u0000H¦\u0080\u0004R\u0013\u0010\u0002\u001a\u00020\u0003X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0006\u001a\u00020\u0007X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0013\u0010\n\u001a\u00020\u000bX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0019\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00070\u000fX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0012\u001a\u00020\u00138VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lni/shikatu/kotlin/text/MatchResult;", _UrlKt.FRAGMENT_ENCODE_SET, "range", "Lni/shikatu/kotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", _UrlKt.FRAGMENT_ENCODE_SET, "getValue", "()Ljava/lang/String;", "groups", "Lni/shikatu/kotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "groupValues", _UrlKt.FRAGMENT_ENCODE_SET, "getGroupValues", "()Ljava/util/List;", "destructured", "Lni/shikatu/kotlin/text/MatchResult$Destructured;", "getDestructured", "()Lkotlin/text/MatchResult$Destructured;", "next", "Destructured", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface MatchResult {
    Destructured getDestructured();

    List<String> getGroupValues();

    MatchGroupCollection getGroups();

    IntRange getRange();

    String getValue();

    MatchResult next();

    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    public static final class DefaultImpls {
        public static Destructured getDestructured(MatchResult $this) {
            return new Destructured($this);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0000\u0018\u00002\u00020\u0001B\u0011\b@\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\b\u001a\u00020\tH\u0087\u008a\u0004b\u0002\b\nJ\u000e\u0010\u000b\u001a\u00020\tH\u0087\u008a\u0004b\u0002\b\nJ\u000e\u0010\f\u001a\u00020\tH\u0087\u008a\u0004b\u0002\b\nJ\u000e\u0010\r\u001a\u00020\tH\u0087\u008a\u0004b\u0002\b\nJ\u000e\u0010\u000e\u001a\u00020\tH\u0087\u008a\u0004b\u0002\b\nJ\u000e\u0010\u000f\u001a\u00020\tH\u0087\u008a\u0004b\u0002\b\nJ\u000e\u0010\u0010\u001a\u00020\tH\u0087\u008a\u0004b\u0002\b\nJ\u000e\u0010\u0011\u001a\u00020\tH\u0087\u008a\u0004b\u0002\b\nJ\u000e\u0010\u0012\u001a\u00020\tH\u0087\u008a\u0004b\u0002\b\nJ\u000e\u0010\u0013\u001a\u00020\tH\u0087\u008a\u0004b\u0002\b\nJ\u0010\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\t0\u0015H\u0086\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0016"}, d2 = {"Lni/shikatu/kotlin/text/MatchResult$Destructured;", _UrlKt.FRAGMENT_ENCODE_SET, "match", "Lni/shikatu/kotlin/text/MatchResult;", "<init>", "(Lkotlin/text/MatchResult;)V", "getMatch", "()Lkotlin/text/MatchResult;", "component1", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/internal/InlineOnly;", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "component10", "toList", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Destructured {
        private final MatchResult match;

        public Destructured(MatchResult match) {
            Intrinsics.checkNotNullParameter(match, "match");
            this.match = match;
        }

        public final MatchResult getMatch() {
            return this.match;
        }

        private final String component1() {
            return getMatch().getGroupValues().get(1);
        }

        private final String component2() {
            return getMatch().getGroupValues().get(2);
        }

        private final String component3() {
            return getMatch().getGroupValues().get(3);
        }

        private final String component4() {
            return getMatch().getGroupValues().get(4);
        }

        private final String component5() {
            return getMatch().getGroupValues().get(5);
        }

        private final String component6() {
            return getMatch().getGroupValues().get(6);
        }

        private final String component7() {
            return getMatch().getGroupValues().get(7);
        }

        private final String component8() {
            return getMatch().getGroupValues().get(8);
        }

        private final String component9() {
            return getMatch().getGroupValues().get(9);
        }

        private final String component10() {
            return getMatch().getGroupValues().get(10);
        }

        public final List<String> toList() {
            return this.match.getGroupValues().subList(1, this.match.getGroupValues().size());
        }
    }
}
