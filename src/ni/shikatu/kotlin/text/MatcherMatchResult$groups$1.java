package ni.shikatu.kotlin.text;

import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.AbstractCollection;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.internal.PlatformImplementationsKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.IntRange;
import ni.shikatu.kotlin.sequences.SequencesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000/\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0002J\n\u0010\b\u001a\u00020\tH\u0096\u0080\u0004J\u0012\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u000bH\u0096\u0082\u0004J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\r\u001a\u00020\u0005H\u0096\u0082\u0004J\u0014\u0010\f\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0082\u0004R\u0015\u0010\u0004\u001a\u00020\u00058VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0010"}, d2 = {"ni/shikatu/kotlin/text/MatcherMatchResult$groups$1", "Lni/shikatu/kotlin/text/MatchNamedGroupCollection;", "Lni/shikatu/kotlin/collections/AbstractCollection;", "Lni/shikatu/kotlin/text/MatchGroup;", "size", _UrlKt.FRAGMENT_ENCODE_SET, "getSize", "()I", "isEmpty", _UrlKt.FRAGMENT_ENCODE_SET, "iterator", _UrlKt.FRAGMENT_ENCODE_SET, "get", "index", "name", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class MatcherMatchResult$groups$1 extends AbstractCollection<MatchGroup> implements MatchNamedGroupCollection {
    final  MatcherMatchResult this$0;

    MatcherMatchResult$groups$1(MatcherMatchResult $receiver) {
        this.this$0 = $receiver;
    }

    @Override
    public final /* bridge */ boolean contains(Object element) {
        if (element == null ? true : element instanceof MatchGroup) {
            return contains((MatchGroup) element);
        }
        return false;
    }

    public /* bridge */ boolean contains(MatchGroup element) {
        return super.contains((Object) element);
    }

    @Override
    public int getSize() {
        return this.this$0.getMatchResult().groupCount() + 1;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public Iterator<MatchGroup> iterator() {
        return SequencesKt.map(CollectionsKt.asSequence(CollectionsKt.getIndices(this)), new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return this.f$0.get(((Integer) obj).intValue());
            }
        }).iterator();
    }

    @Override
    public MatchGroup get(int index) {
        IntRange range = RegexKt.range(this.this$0.getMatchResult(), index);
        if (range.getStart().intValue() >= 0) {
            String strGroup = this.this$0.getMatchResult().group(index);
            Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
            return new MatchGroup(strGroup, range);
        }
        return null;
    }

    @Override
    public MatchGroup get(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        return PlatformImplementationsKt.IMPLEMENTATIONS.getMatchResultNamedGroup(this.this$0.getMatchResult(), name);
    }
}
