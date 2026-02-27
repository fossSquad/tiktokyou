package ni.shikatu.kotlin.text;

import java.util.List;
import java.util.regex.Matcher;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.AbstractList;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.IntRange;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0005\b\u0002\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0001H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\t8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0015X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00110\u00198VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006\u001e"}, d2 = {"Lni/shikatu/kotlin/text/MatcherMatchResult;", "Lni/shikatu/kotlin/text/MatchResult;", "matcher", "Ljava/util/regex/Matcher;", "input", "", "<init>", "(Ljava/util/regex/Matcher;Ljava/lang/CharSequence;)V", "matchResult", "Ljava/util/regex/MatchResult;", "getMatchResult", "()Ljava/util/regex/MatchResult;", "range", "Lni/shikatu/kotlin/ranges/IntRange;", "getRange", "()Lkotlin/ranges/IntRange;", "value", "", "getValue", "()Ljava/lang/String;", "groups", "Lni/shikatu/kotlin/text/MatchGroupCollection;", "getGroups", "()Lkotlin/text/MatchGroupCollection;", "groupValues_", "", "groupValues", "getGroupValues", "()Ljava/util/List;", "next", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class MatcherMatchResult implements MatchResult {
    private List<String> groupValues_;
    private final MatchGroupCollection groups;
    private final CharSequence input;
    private final Matcher matcher;

    public MatcherMatchResult(Matcher matcher, CharSequence input) {
        Intrinsics.checkNotNullParameter(matcher, "matcher");
        Intrinsics.checkNotNullParameter(input, "input");
        this.matcher = matcher;
        this.input = input;
        this.groups = new MatcherMatchResult$groups$1(this);
    }

    @Override
    public MatchResult.Destructured getDestructured() {
        return MatchResult.DefaultImpls.getDestructured(this);
    }

    public final java.util.regex.MatchResult getMatchResult() {
        return this.matcher;
    }

    @Override
    public IntRange getRange() {
        return RegexKt.range(getMatchResult());
    }

    @Override
    public String getValue() {
        String strGroup = getMatchResult().group();
        Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
        return strGroup;
    }

    @Override
    public MatchGroupCollection getGroups() {
        return this.groups;
    }

    @Override
    public List<String> getGroupValues() {
        if (this.groupValues_ == null) {
            this.groupValues_ = new AbstractList<String>() {
                @Override
                public final /* bridge */ boolean contains(Object element) {
                    if (element instanceof String) {
                        return contains((String) element);
                    }
                    return false;
                }

                public /* bridge */ boolean contains(String element) {
                    return super.contains(element);
                }

                @Override
                public final /* bridge */ int indexOf(Object element) {
                    if (element instanceof String) {
                        return indexOf((String) element);
                    }
                    return -1;
                }

                public /* bridge */ int indexOf(String element) {
                    return super.indexOf(element);
                }

                @Override
                public final /* bridge */ int lastIndexOf(Object element) {
                    if (element instanceof String) {
                        return lastIndexOf((String) element);
                    }
                    return -1;
                }

                public /* bridge */ int lastIndexOf(String element) {
                    return super.lastIndexOf(element);
                }

                @Override
                public int getSize() {
                    return this.this$0.getMatchResult().groupCount() + 1;
                }

                @Override
                public String get(int index) {
                    String strGroup = this.this$0.getMatchResult().group(index);
                    return strGroup == null ? "" : strGroup;
                }
            };
        }
        List<String> list = this.groupValues_;
        Intrinsics.checkNotNull(list);
        return list;
    }

    @Override
    public MatchResult next() {
        int nextIndex = getMatchResult().end() + (getMatchResult().end() == getMatchResult().start() ? 1 : 0);
        if (nextIndex > this.input.length()) {
            return null;
        }
        Matcher matcher = this.matcher.pattern().matcher(this.input);
        Intrinsics.checkNotNullExpressionValue(matcher, "matcher(...)");
        return RegexKt.findNext(matcher, nextIndex, this.input);
    }
}
