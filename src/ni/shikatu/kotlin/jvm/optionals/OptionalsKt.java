package ni.shikatu.kotlin.jvm.optionals;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.SetsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.sequences.Sequence;
import ni.shikatu.kotlin.sequences.SequencesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000>\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u001f\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a3\u0010\u0000\u001a\u0004\u0018\u0001H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\b\u0012\u0004\u0012\u0002H\u00010\u0003H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007¢\u0006\u0002\u0010\u0004\u001a<\u0010\b\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\f\u0012\b\b\u0001\u0012\u0004\b\u0002H\u00010\u00032\u0006\u0010\t\u001a\u0002H\u0001H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007ø\u0001\u0000¢\u0006\u0002\u0010\n\u001aR\u0010\u000b\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\f\u0012\b\b\u0001\u0012\u0004\b\u0002H\u00010\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\fH\u0087\u0088\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007ø\u0001\u0001ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0000¢\u0006\u0002\u0010\r\u001aO\u0010\u000e\u001a\u0002H\u000f\"\b\b\u0000\u0010\u0001*\u00020\u0002\"\u0010\b\u0001\u0010\u000f*\n\u0012\u0006\b\u0000\u0012\u0002H\u00010\u0010*\b\u0012\u0004\u0012\u0002H\u00010\u00032\u0006\u0010\u0011\u001a\u0002H\u000fH\u0087\u0080\bb\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007b\u0002\b\u0013¢\u0006\u0002\u0010\u0012\u001a4\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0015\"\b\b\u0000\u0010\u0001*\u00020\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u0003H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u001a4\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0017\"\b\b\u0000\u0010\u0001*\u00020\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u0003H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u001a4\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00010\u0019\"\b\b\u0000\u0010\u0001*\u00020\u0002*\n\u0012\u0006\b\u0001\u0012\u0002H\u00010\u0003H\u0087\u0080\u0004b\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0082\u0002\u000b\n\u0002\b9\n\u0005\b\u009920\u0001¨\u0006\u001a"}, d2 = {"getOrNull", "T", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/util/Optional;", "(Ljava/util/Optional;)Ljava/lang/Object;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.8", "getOrDefault", "defaultValue", "(Ljava/util/Optional;Ljava/lang/Object;)Ljava/lang/Object;", "getOrElse", "Lni/shikatu/kotlin/Function0;", "(Ljava/util/Optional;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "toCollection", "C", _UrlKt.FRAGMENT_ENCODE_SET, "destination", "(Ljava/util/Optional;Ljava/util/Collection;)Ljava/util/Collection;", "Lni/shikatu/kotlin/IgnorableReturnValue;", "toList", _UrlKt.FRAGMENT_ENCODE_SET, "toSet", _UrlKt.FRAGMENT_ENCODE_SET, "asSequence", "Lni/shikatu/kotlin/sequences/Sequence;", "ni.shikatu.kotlin-stdlib-jdk8"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class OptionalsKt {
    public static final <T> T getOrNull(Optional<T> optional) {
        Intrinsics.checkNotNullParameter(optional, "<this>");
        return optional.orElse(null);
    }

    public static final <T> T getOrDefault(Optional<? extends T> optional, T t) {
        Intrinsics.checkNotNullParameter(optional, "<this>");
        return optional.isPresent() ? optional.get() : t;
    }

    public static final <T> T getOrElse(Optional<? extends T> optional, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(optional, "<this>");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        return optional.isPresent() ? optional.get() : function0.invoke();
    }

    @IgnorableReturnValue
    public static final <T, C extends Collection<? super T>> C toCollection(Optional<T> optional, C c) {
        Intrinsics.checkNotNullParameter(optional, "<this>");
        Intrinsics.checkNotNullParameter(c, "destination");
        if (optional.isPresent()) {
            T t = optional.get();
            Intrinsics.checkNotNullExpressionValue(t, "get(...)");
            c.add(t);
        }
        return c;
    }

    public static final <T> List<T> toList(Optional<? extends T> optional) {
        Intrinsics.checkNotNullParameter(optional, "<this>");
        return optional.isPresent() ? CollectionsKt.listOf(optional.get()) : CollectionsKt.emptyList();
    }

    public static final <T> Set<T> toSet(Optional<? extends T> optional) {
        Intrinsics.checkNotNullParameter(optional, "<this>");
        return optional.isPresent() ? SetsKt.setOf(optional.get()) : SetsKt.emptySet();
    }

    public static final <T> Sequence<T> asSequence(Optional<? extends T> optional) {
        Intrinsics.checkNotNullParameter(optional, "<this>");
        return optional.isPresent() ? SequencesKt.sequenceOf(optional.get()) : SequencesKt.emptySequence();
    }
}
