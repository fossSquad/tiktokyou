package ni.shikatu.kotlin.ranges;

import java.util.NoSuchElementException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.UByte;
import ni.shikatu.kotlin.UInt;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.UShort;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.random.Random;
import ni.shikatu.kotlin.random.URandomKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okhttp3.internal.ws.WebSocketProtocol;

@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\u0010\t\n\u0002\b#\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a!\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\u0003\u001a!\u0010\u0000\u001a\u00020\u0007*\u00020\bH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\t\u001a\u001e\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a\u001e\u0010\n\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a!\u0010\u000b\u001a\u00020\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\u0003\u001a!\u0010\u000b\u001a\u00020\u0007*\u00020\bH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u0002\u0010\t\u001a\u001e\u0010\f\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a\u001e\u0010\f\u001a\u0004\u0018\u00010\u0007*\u00020\bH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u001a%\u0010\r\u001a\u00020\u0001*\u00020\u000eH\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011¢\u0006\u0002\u0010\u000f\u001a%\u0010\r\u001a\u00020\u0007*\u00020\u0012H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011¢\u0006\u0002\u0010\u0013\u001a)\u0010\r\u001a\u00020\u0001*\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0014H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\u0015\u001a)\u0010\r\u001a\u00020\u0007*\u00020\u00122\u0006\u0010\r\u001a\u00020\u0014H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\u0016\u001a\"\u0010\u0017\u001a\u0004\u0018\u00010\u0001*\u00020\u000eH\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011\u001a\"\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u0012H\u0087\u0088\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011\u001a&\u0010\u0017\u001a\u0004\u0018\u00010\u0001*\u00020\u000e2\u0006\u0010\r\u001a\u00020\u0014H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a&\u0010\u0017\u001a\u0004\u0018\u00010\u0007*\u00020\u00122\u0006\u0010\r\u001a\u00020\u0014H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a/\u0010\u0018\u001a\u00020\u0019*\u00020\u000e2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0087\u008a\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011¢\u0006\u0002\b\u001b\u001a/\u0010\u0018\u001a\u00020\u0019*\u00020\u00122\b\u0010\u001a\u001a\u0004\u0018\u00010\u0007H\u0087\u008a\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010b\u0002\b\u0011¢\u0006\u0002\b\u001c\u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001eH\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b\u001f\u0010 \u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001eH\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b!\u0010\"\u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u0001H\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b#\u0010$\u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u0007H\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b%\u0010&\u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u000e2\u0006\u0010\u001d\u001a\u00020'H\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b(\u0010)\u001a+\u0010\u0018\u001a\u00020\u0019*\u00020\u00122\u0006\u0010\u001d\u001a\u00020'H\u0087\u0082\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b*\u0010+\u001a+\u0010,\u001a\u00020\u0002*\u00020\u001e2\u0006\u0010-\u001a\u00020\u001eH\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b.\u0010/\u001a+\u0010,\u001a\u00020\u0002*\u00020\u00012\u0006\u0010-\u001a\u00020\u0001H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b0\u00101\u001a+\u0010,\u001a\u00020\b*\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b2\u00103\u001a+\u0010,\u001a\u00020\u0002*\u00020'2\u0006\u0010-\u001a\u00020'H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b4\u00105\u001a\u001c\u00106\u001a\u00020\u0002*\u00020\u0002H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a\u001c\u00106\u001a\u00020\b*\u00020\bH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a$\u00107\u001a\u00020\u0002*\u00020\u00022\u0006\u00107\u001a\u000208H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a$\u00107\u001a\u00020\b*\u00020\b2\u0006\u00107\u001a\u000209H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010\u001a+\u0010:\u001a\u00020\u000e*\u00020\u001e2\u0006\u0010-\u001a\u00020\u001eH\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b;\u0010<\u001a+\u0010:\u001a\u00020\u000e*\u00020\u00012\u0006\u0010-\u001a\u00020\u0001H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b=\u0010>\u001a+\u0010:\u001a\u00020\u0012*\u00020\u00072\u0006\u0010-\u001a\u00020\u0007H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b?\u0010@\u001a+\u0010:\u001a\u00020\u000e*\u00020'2\u0006\u0010-\u001a\u00020'H\u0087\u0084\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bA\u0010B\u001a+\u0010C\u001a\u00020\u0001*\u00020\u00012\u0006\u0010D\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bE\u0010F\u001a+\u0010C\u001a\u00020\u0007*\u00020\u00072\u0006\u0010D\u001a\u00020\u0007H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bG\u0010H\u001a+\u0010C\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010D\u001a\u00020\u001eH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bI\u0010J\u001a+\u0010C\u001a\u00020'*\u00020'2\u0006\u0010D\u001a\u00020'H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bK\u0010L\u001a+\u0010M\u001a\u00020\u0001*\u00020\u00012\u0006\u0010N\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bO\u0010F\u001a+\u0010M\u001a\u00020\u0007*\u00020\u00072\u0006\u0010N\u001a\u00020\u0007H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bP\u0010H\u001a+\u0010M\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010N\u001a\u00020\u001eH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bQ\u0010J\u001a+\u0010M\u001a\u00020'*\u00020'2\u0006\u0010N\u001a\u00020'H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bR\u0010L\u001a3\u0010S\u001a\u00020\u0001*\u00020\u00012\u0006\u0010D\u001a\u00020\u00012\u0006\u0010N\u001a\u00020\u0001H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bT\u0010U\u001a3\u0010S\u001a\u00020\u0007*\u00020\u00072\u0006\u0010D\u001a\u00020\u00072\u0006\u0010N\u001a\u00020\u0007H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bV\u0010W\u001a3\u0010S\u001a\u00020\u001e*\u00020\u001e2\u0006\u0010D\u001a\u00020\u001e2\u0006\u0010N\u001a\u00020\u001eH\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bX\u0010Y\u001a3\u0010S\u001a\u00020'*\u00020'2\u0006\u0010D\u001a\u00020'2\u0006\u0010N\u001a\u00020'H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\bZ\u0010[\u001a1\u0010S\u001a\u00020\u0001*\u00020\u00012\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00010]H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b^\u0010_\u001a1\u0010S\u001a\u00020\u0007*\u00020\u00072\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00070]H\u0087\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0010¢\u0006\u0004\b`\u0010a¨\u0006b"}, d2 = {"first", "Lni/shikatu/kotlin/UInt;", "Lni/shikatu/kotlin/ranges/UIntProgression;", "(Lkotlin/ranges/UIntProgression;)I", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.7", "Lni/shikatu/kotlin/ULong;", "Lni/shikatu/kotlin/ranges/ULongProgression;", "(Lkotlin/ranges/ULongProgression;)J", "firstOrNull", "last", "lastOrNull", "random", "Lni/shikatu/kotlin/ranges/UIntRange;", "(Lkotlin/ranges/UIntRange;)I", "1.5", "Lni/shikatu/kotlin/internal/InlineOnly;", "Lni/shikatu/kotlin/ranges/ULongRange;", "(Lkotlin/ranges/ULongRange;)J", "Lni/shikatu/kotlin/random/Random;", "(Lkotlin/ranges/UIntRange;Lkotlin/random/Random;)I", "(Lkotlin/ranges/ULongRange;Lkotlin/random/Random;)J", "randomOrNull", "contains", _UrlKt.FRAGMENT_ENCODE_SET, "element", "contains-biwQdVI", "contains-GYNo2lE", "value", "Lni/shikatu/kotlin/UByte;", "contains-68kG9v0", "(Lkotlin/ranges/UIntRange;B)Z", "contains-ULb-yJY", "(Lkotlin/ranges/ULongRange;B)Z", "contains-Gab390E", "(Lkotlin/ranges/ULongRange;I)Z", "contains-fz5IDCE", "(Lkotlin/ranges/UIntRange;J)Z", "Lni/shikatu/kotlin/UShort;", "contains-ZsK3CEQ", "(Lkotlin/ranges/UIntRange;S)Z", "contains-uhHAxoY", "(Lkotlin/ranges/ULongRange;S)Z", "downTo", "to", "downTo-Kr8caGY", "(BB)Lkotlin/ranges/UIntProgression;", "downTo-J1ME1BU", "(II)Lkotlin/ranges/UIntProgression;", "downTo-eb3DHEI", "(JJ)Lkotlin/ranges/ULongProgression;", "downTo-5PvTz6A", "(SS)Lkotlin/ranges/UIntProgression;", "reversed", "step", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "until", "until-Kr8caGY", "(BB)Lkotlin/ranges/UIntRange;", "until-J1ME1BU", "(II)Lkotlin/ranges/UIntRange;", "until-eb3DHEI", "(JJ)Lkotlin/ranges/ULongRange;", "until-5PvTz6A", "(SS)Lkotlin/ranges/UIntRange;", "coerceAtLeast", "minimumValue", "coerceAtLeast-J1ME1BU", "(II)I", "coerceAtLeast-eb3DHEI", "(JJ)J", "coerceAtLeast-Kr8caGY", "(BB)B", "coerceAtLeast-5PvTz6A", "(SS)S", "coerceAtMost", "maximumValue", "coerceAtMost-J1ME1BU", "coerceAtMost-eb3DHEI", "coerceAtMost-Kr8caGY", "coerceAtMost-5PvTz6A", "coerceIn", "coerceIn-WZ9TVnA", "(III)I", "coerceIn-sambcqE", "(JJJ)J", "coerceIn-b33U2AM", "(BBB)B", "coerceIn-VKSA0NQ", "(SSS)S", "range", "Lni/shikatu/kotlin/ranges/ClosedRange;", "coerceIn-wuiCnnA", "(ILkotlin/ranges/ClosedRange;)I", "coerceIn-JPwROB0", "(JLkotlin/ranges/ClosedRange;)J", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/ranges/URangesKt")
public class URangesKt___URangesKt {
    public static final int first(UIntProgression $this$first) {
        Intrinsics.checkNotNullParameter($this$first, "<this>");
        if ($this$first.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$first + " is empty.");
        }
        return $this$first.m1265getFirstpVg5ArA();
    }

    public static final long first(ULongProgression $this$first) {
        Intrinsics.checkNotNullParameter($this$first, "<this>");
        if ($this$first.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$first + " is empty.");
        }
        return $this$first.m1274getFirstsVKNKU();
    }

    public static final UInt firstOrNull(UIntProgression $this$firstOrNull) {
        Intrinsics.checkNotNullParameter($this$firstOrNull, "<this>");
        if ($this$firstOrNull.isEmpty()) {
            return null;
        }
        return UInt.m95boximpl($this$firstOrNull.m1265getFirstpVg5ArA());
    }

    public static final ULong firstOrNull(ULongProgression $this$firstOrNull) {
        Intrinsics.checkNotNullParameter($this$firstOrNull, "<this>");
        if ($this$firstOrNull.isEmpty()) {
            return null;
        }
        return ULong.m174boximpl($this$firstOrNull.m1274getFirstsVKNKU());
    }

    public static final int last(UIntProgression $this$last) {
        Intrinsics.checkNotNullParameter($this$last, "<this>");
        if ($this$last.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$last + " is empty.");
        }
        return $this$last.m1266getLastpVg5ArA();
    }

    public static final long last(ULongProgression $this$last) {
        Intrinsics.checkNotNullParameter($this$last, "<this>");
        if ($this$last.isEmpty()) {
            throw new NoSuchElementException("Progression " + $this$last + " is empty.");
        }
        return $this$last.m1275getLastsVKNKU();
    }

    public static final UInt lastOrNull(UIntProgression $this$lastOrNull) {
        Intrinsics.checkNotNullParameter($this$lastOrNull, "<this>");
        if ($this$lastOrNull.isEmpty()) {
            return null;
        }
        return UInt.m95boximpl($this$lastOrNull.m1266getLastpVg5ArA());
    }

    public static final ULong lastOrNull(ULongProgression $this$lastOrNull) {
        Intrinsics.checkNotNullParameter($this$lastOrNull, "<this>");
        if ($this$lastOrNull.isEmpty()) {
            return null;
        }
        return ULong.m174boximpl($this$lastOrNull.m1275getLastsVKNKU());
    }

    private static final int random(UIntRange $this$random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        return URangesKt.random($this$random, Random.Default);
    }

    private static final long random(ULongRange $this$random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        return URangesKt.random($this$random, Random.Default);
    }

    public static final int random(UIntRange $this$random, Random random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandomKt.nextUInt(random, $this$random);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static final long random(ULongRange $this$random, Random random) {
        Intrinsics.checkNotNullParameter($this$random, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        try {
            return URandomKt.nextULong(random, $this$random);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    private static final UInt randomOrNull(UIntRange $this$randomOrNull) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        return URangesKt.randomOrNull($this$randomOrNull, Random.Default);
    }

    private static final ULong randomOrNull(ULongRange $this$randomOrNull) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        return URangesKt.randomOrNull($this$randomOrNull, Random.Default);
    }

    public static final UInt randomOrNull(UIntRange $this$randomOrNull, Random random) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if ($this$randomOrNull.isEmpty()) {
            return null;
        }
        return UInt.m95boximpl(URandomKt.nextUInt(random, $this$randomOrNull));
    }

    public static final ULong randomOrNull(ULongRange $this$randomOrNull, Random random) {
        Intrinsics.checkNotNullParameter($this$randomOrNull, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        if ($this$randomOrNull.isEmpty()) {
            return null;
        }
        return ULong.m174boximpl(URandomKt.nextULong(random, $this$randomOrNull));
    }

    private static final boolean m1302containsbiwQdVI(UIntRange $this$contains_u2dbiwQdVI, UInt element) {
        Intrinsics.checkNotNullParameter($this$contains_u2dbiwQdVI, "$this$contains");
        return element != null && $this$contains_u2dbiwQdVI.m1270containsWZ4Q5Ns(element.m153unboximpl());
    }

    private static final boolean m1298containsGYNo2lE(ULongRange $this$contains_u2dGYNo2lE, ULong element) {
        Intrinsics.checkNotNullParameter($this$contains_u2dGYNo2lE, "$this$contains");
        return element != null && $this$contains_u2dGYNo2lE.m1279containsVKZWuLQ(element.m232unboximpl());
    }

    public static final boolean m1297contains68kG9v0(UIntRange $this$contains_u2d68kG9v0, byte value) {
        Intrinsics.checkNotNullParameter($this$contains_u2d68kG9v0, "$this$contains");
        return $this$contains_u2d68kG9v0.m1270containsWZ4Q5Ns(UInt.m101constructorimpl(value & UByte.MAX_VALUE));
    }

    public static final boolean m1300containsULbyJY(ULongRange $this$contains_u2dULb_u2dyJY, byte value) {
        Intrinsics.checkNotNullParameter($this$contains_u2dULb_u2dyJY, "$this$contains");
        return $this$contains_u2dULb_u2dyJY.m1279containsVKZWuLQ(ULong.m180constructorimpl(((long) value) & 255));
    }

    public static final boolean m1299containsGab390E(ULongRange $this$contains_u2dGab390E, int value) {
        Intrinsics.checkNotNullParameter($this$contains_u2dGab390E, "$this$contains");
        return $this$contains_u2dGab390E.m1279containsVKZWuLQ(ULong.m180constructorimpl(((long) value) & 4294967295L));
    }

    public static final boolean m1303containsfz5IDCE(UIntRange $this$contains_u2dfz5IDCE, long value) {
        Intrinsics.checkNotNullParameter($this$contains_u2dfz5IDCE, "$this$contains");
        return ULong.m180constructorimpl(value >>> 32) == 0 && $this$contains_u2dfz5IDCE.m1270containsWZ4Q5Ns(UInt.m101constructorimpl((int) value));
    }

    public static final boolean m1301containsZsK3CEQ(UIntRange $this$contains_u2dZsK3CEQ, short value) {
        Intrinsics.checkNotNullParameter($this$contains_u2dZsK3CEQ, "$this$contains");
        return $this$contains_u2dZsK3CEQ.m1270containsWZ4Q5Ns(UInt.m101constructorimpl(65535 & value));
    }

    public static final boolean m1304containsuhHAxoY(ULongRange $this$contains_u2duhHAxoY, short value) {
        Intrinsics.checkNotNullParameter($this$contains_u2duhHAxoY, "$this$contains");
        return $this$contains_u2duhHAxoY.m1279containsVKZWuLQ(ULong.m180constructorimpl(((long) value) & WebSocketProtocol.PAYLOAD_SHORT_MAX));
    }

    public static final UIntProgression m1307downToKr8caGY(byte $this$downTo_u2dKr8caGY, byte to) {
        return UIntProgression.Companion.m1267fromClosedRangeNkh28Cs(UInt.m101constructorimpl($this$downTo_u2dKr8caGY & UByte.MAX_VALUE), UInt.m101constructorimpl(to & UByte.MAX_VALUE), -1);
    }

    public static final UIntProgression m1306downToJ1ME1BU(int $this$downTo_u2dJ1ME1BU, int to) {
        return UIntProgression.Companion.m1267fromClosedRangeNkh28Cs($this$downTo_u2dJ1ME1BU, to, -1);
    }

    public static final ULongProgression m1308downToeb3DHEI(long $this$downTo_u2deb3DHEI, long to) {
        return ULongProgression.Companion.m1276fromClosedRange7ftBX0g($this$downTo_u2deb3DHEI, to, -1L);
    }

    public static final UIntProgression m1305downTo5PvTz6A(short $this$downTo_u2d5PvTz6A, short to) {
        return UIntProgression.Companion.m1267fromClosedRangeNkh28Cs(UInt.m101constructorimpl($this$downTo_u2d5PvTz6A & UShort.MAX_VALUE), UInt.m101constructorimpl(65535 & to), -1);
    }

    public static final UIntProgression reversed(UIntProgression $this$reversed) {
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        return UIntProgression.Companion.m1267fromClosedRangeNkh28Cs($this$reversed.m1266getLastpVg5ArA(), $this$reversed.m1265getFirstpVg5ArA(), -$this$reversed.getStep());
    }

    public static final ULongProgression reversed(ULongProgression $this$reversed) {
        Intrinsics.checkNotNullParameter($this$reversed, "<this>");
        return ULongProgression.Companion.m1276fromClosedRange7ftBX0g($this$reversed.m1275getLastsVKNKU(), $this$reversed.m1274getFirstsVKNKU(), -$this$reversed.getStep());
    }

    public static final UIntProgression step(UIntProgression $this$step, int step) {
        Intrinsics.checkNotNullParameter($this$step, "<this>");
        RangesKt.checkStepIsPositive(step > 0, Integer.valueOf(step));
        return UIntProgression.Companion.m1267fromClosedRangeNkh28Cs($this$step.m1265getFirstpVg5ArA(), $this$step.m1266getLastpVg5ArA(), $this$step.getStep() > 0 ? step : -step);
    }

    public static final ULongProgression step(ULongProgression $this$step, long step) {
        Intrinsics.checkNotNullParameter($this$step, "<this>");
        RangesKt.checkStepIsPositive(step > 0, Long.valueOf(step));
        return ULongProgression.Companion.m1276fromClosedRange7ftBX0g($this$step.m1274getFirstsVKNKU(), $this$step.m1275getLastsVKNKU(), $this$step.getStep() > 0 ? step : -step);
    }

    public static final UIntRange m1311untilKr8caGY(byte $this$until_u2dKr8caGY, byte to) {
        return Intrinsics.compare(to & UByte.MAX_VALUE, 0) <= 0 ? UIntRange.Companion.getEMPTY() : new UIntRange(UInt.m101constructorimpl($this$until_u2dKr8caGY & UByte.MAX_VALUE), UInt.m101constructorimpl(UInt.m101constructorimpl(to & UByte.MAX_VALUE) - 1), null);
    }

    public static final UIntRange m1310untilJ1ME1BU(int $this$until_u2dJ1ME1BU, int to) {
        return Integer.compareUnsigned(to, 0) <= 0 ? UIntRange.Companion.getEMPTY() : new UIntRange($this$until_u2dJ1ME1BU, UInt.m101constructorimpl(to - 1), null);
    }

    public static final ULongRange m1312untileb3DHEI(long $this$until_u2deb3DHEI, long to) {
        return Long.compareUnsigned(to, 0L) <= 0 ? ULongRange.Companion.getEMPTY() : new ULongRange($this$until_u2deb3DHEI, ULong.m180constructorimpl(to - ULong.m180constructorimpl(((long) 1) & 4294967295L)), null);
    }

    public static final UIntRange m1309until5PvTz6A(short $this$until_u2d5PvTz6A, short to) {
        return Intrinsics.compare(to & UShort.MAX_VALUE, 0) <= 0 ? UIntRange.Companion.getEMPTY() : new UIntRange(UInt.m101constructorimpl($this$until_u2d5PvTz6A & UShort.MAX_VALUE), UInt.m101constructorimpl(UInt.m101constructorimpl(65535 & to) - 1), null);
    }

    public static final int m1284coerceAtLeastJ1ME1BU(int $this$coerceAtLeast_u2dJ1ME1BU, int minimumValue) {
        return Integer.compareUnsigned($this$coerceAtLeast_u2dJ1ME1BU, minimumValue) < 0 ? minimumValue : $this$coerceAtLeast_u2dJ1ME1BU;
    }

    public static final long m1286coerceAtLeasteb3DHEI(long $this$coerceAtLeast_u2deb3DHEI, long minimumValue) {
        return Long.compareUnsigned($this$coerceAtLeast_u2deb3DHEI, minimumValue) < 0 ? minimumValue : $this$coerceAtLeast_u2deb3DHEI;
    }

    public static final byte m1285coerceAtLeastKr8caGY(byte $this$coerceAtLeast_u2dKr8caGY, byte minimumValue) {
        return Intrinsics.compare($this$coerceAtLeast_u2dKr8caGY & UByte.MAX_VALUE, minimumValue & UByte.MAX_VALUE) < 0 ? minimumValue : $this$coerceAtLeast_u2dKr8caGY;
    }

    public static final short m1283coerceAtLeast5PvTz6A(short $this$coerceAtLeast_u2d5PvTz6A, short minimumValue) {
        return Intrinsics.compare($this$coerceAtLeast_u2d5PvTz6A & UShort.MAX_VALUE, 65535 & minimumValue) < 0 ? minimumValue : $this$coerceAtLeast_u2d5PvTz6A;
    }

    public static final int m1288coerceAtMostJ1ME1BU(int $this$coerceAtMost_u2dJ1ME1BU, int maximumValue) {
        return Integer.compareUnsigned($this$coerceAtMost_u2dJ1ME1BU, maximumValue) > 0 ? maximumValue : $this$coerceAtMost_u2dJ1ME1BU;
    }

    public static final long m1290coerceAtMosteb3DHEI(long $this$coerceAtMost_u2deb3DHEI, long maximumValue) {
        return Long.compareUnsigned($this$coerceAtMost_u2deb3DHEI, maximumValue) > 0 ? maximumValue : $this$coerceAtMost_u2deb3DHEI;
    }

    public static final byte m1289coerceAtMostKr8caGY(byte $this$coerceAtMost_u2dKr8caGY, byte maximumValue) {
        return Intrinsics.compare($this$coerceAtMost_u2dKr8caGY & UByte.MAX_VALUE, maximumValue & UByte.MAX_VALUE) > 0 ? maximumValue : $this$coerceAtMost_u2dKr8caGY;
    }

    public static final short m1287coerceAtMost5PvTz6A(short $this$coerceAtMost_u2d5PvTz6A, short maximumValue) {
        return Intrinsics.compare($this$coerceAtMost_u2d5PvTz6A & UShort.MAX_VALUE, 65535 & maximumValue) > 0 ? maximumValue : $this$coerceAtMost_u2d5PvTz6A;
    }

    public static final int m1293coerceInWZ9TVnA(int $this$coerceIn_u2dWZ9TVnA, int minimumValue, int maximumValue) {
        if (Integer.compareUnsigned(minimumValue, maximumValue) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) UInt.m147toStringimpl(maximumValue)) + " is less than minimum " + ((Object) UInt.m147toStringimpl(minimumValue)) + '.');
        }
        if (Integer.compareUnsigned($this$coerceIn_u2dWZ9TVnA, minimumValue) < 0) {
            return minimumValue;
        }
        return Integer.compareUnsigned($this$coerceIn_u2dWZ9TVnA, maximumValue) > 0 ? maximumValue : $this$coerceIn_u2dWZ9TVnA;
    }

    public static final long m1295coerceInsambcqE(long $this$coerceIn_u2dsambcqE, long minimumValue, long maximumValue) {
        if (Long.compareUnsigned(minimumValue, maximumValue) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) ULong.m226toStringimpl(maximumValue)) + " is less than minimum " + ((Object) ULong.m226toStringimpl(minimumValue)) + '.');
        }
        if (Long.compareUnsigned($this$coerceIn_u2dsambcqE, minimumValue) < 0) {
            return minimumValue;
        }
        return Long.compareUnsigned($this$coerceIn_u2dsambcqE, maximumValue) > 0 ? maximumValue : $this$coerceIn_u2dsambcqE;
    }

    public static final byte m1294coerceInb33U2AM(byte $this$coerceIn_u2db33U2AM, byte minimumValue, byte maximumValue) {
        if (Intrinsics.compare(minimumValue & UByte.MAX_VALUE, maximumValue & UByte.MAX_VALUE) > 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) UByte.m68toStringimpl(maximumValue)) + " is less than minimum " + ((Object) UByte.m68toStringimpl(minimumValue)) + '.');
        }
        if (Intrinsics.compare($this$coerceIn_u2db33U2AM & UByte.MAX_VALUE, minimumValue & UByte.MAX_VALUE) < 0) {
            return minimumValue;
        }
        return Intrinsics.compare($this$coerceIn_u2db33U2AM & UByte.MAX_VALUE, maximumValue & UByte.MAX_VALUE) > 0 ? maximumValue : $this$coerceIn_u2db33U2AM;
    }

    public static final short m1292coerceInVKSA0NQ(short $this$coerceIn_u2dVKSA0NQ, short minimumValue, short maximumValue) {
        if (Intrinsics.compare(minimumValue & UShort.MAX_VALUE, maximumValue & UShort.MAX_VALUE) <= 0) {
            if (Intrinsics.compare($this$coerceIn_u2dVKSA0NQ & UShort.MAX_VALUE, minimumValue & UShort.MAX_VALUE) < 0) {
                return minimumValue;
            }
            return Intrinsics.compare($this$coerceIn_u2dVKSA0NQ & UShort.MAX_VALUE, 65535 & maximumValue) > 0 ? maximumValue : $this$coerceIn_u2dVKSA0NQ;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + ((Object) UShort.m331toStringimpl(maximumValue)) + " is less than minimum " + ((Object) UShort.m331toStringimpl(minimumValue)) + '.');
    }

    public static final int m1296coerceInwuiCnnA(int $this$coerceIn_u2dwuiCnnA, ClosedRange<UInt> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, "range");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((UInt) RangesKt.coerceIn(UInt.m95boximpl($this$coerceIn_u2dwuiCnnA), (ClosedFloatingPointRange<UInt>) closedRange)).m153unboximpl();
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + '.');
        }
        if (Integer.compareUnsigned($this$coerceIn_u2dwuiCnnA, ((UInt) closedRange.getStart()).m153unboximpl()) < 0) {
            return ((UInt) closedRange.getStart()).m153unboximpl();
        }
        return Integer.compareUnsigned($this$coerceIn_u2dwuiCnnA, ((UInt) closedRange.getEndInclusive()).m153unboximpl()) > 0 ? ((UInt) closedRange.getEndInclusive()).m153unboximpl() : $this$coerceIn_u2dwuiCnnA;
    }

    public static final long m1291coerceInJPwROB0(long $this$coerceIn_u2dJPwROB0, ClosedRange<ULong> closedRange) {
        Intrinsics.checkNotNullParameter(closedRange, "range");
        if (closedRange instanceof ClosedFloatingPointRange) {
            return ((ULong) RangesKt.coerceIn(ULong.m174boximpl($this$coerceIn_u2dJPwROB0), (ClosedFloatingPointRange<ULong>) closedRange)).m232unboximpl();
        }
        if (closedRange.isEmpty()) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: " + closedRange + '.');
        }
        if (Long.compareUnsigned($this$coerceIn_u2dJPwROB0, ((ULong) closedRange.getStart()).m232unboximpl()) < 0) {
            return ((ULong) closedRange.getStart()).m232unboximpl();
        }
        return Long.compareUnsigned($this$coerceIn_u2dJPwROB0, ((ULong) closedRange.getEndInclusive()).m232unboximpl()) > 0 ? ((ULong) closedRange.getEndInclusive()).m232unboximpl() : $this$coerceIn_u2dJPwROB0;
    }
}
