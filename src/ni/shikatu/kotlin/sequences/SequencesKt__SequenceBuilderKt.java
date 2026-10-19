package ni.shikatu.kotlin.sequences;

import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.coroutines.Continuation;
import ni.shikatu.kotlin.coroutines.intrinsics.IntrinsicsKt;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010(\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a^\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u000223\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\t:\u0002\b\nH\u0087\u0080\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u0002\u0010\u000b\u001a^\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0010\"\u0004\b\u0000\u0010\u000223\b\u0001\u0010\u0003\u001a)\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0004¢\u0006\u0002\b\t:\u0002\b\nH\u0087\u0080\u0004b\f\b\f\u0012\b\b\r\u0012\u0004\b\b(\u000e¢\u0006\u0002\u0010\u0011\"\u0013\u0010\u0014\u001a\u00060\u0013j\u0002`\u0015X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u0013\u0010\u0016\u001a\u00060\u0013j\u0002`\u0015X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u0013\u0010\u0017\u001a\u00060\u0013j\u0002`\u0015X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u0013\u0010\u0018\u001a\u00060\u0013j\u0002`\u0015X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u0013\u0010\u0019\u001a\u00060\u0013j\u0002`\u0015X\u0082Ô\b¢\u0006\u0002\n\u0000\"\u0013\u0010\u001a\u001a\u00060\u0013j\u0002`\u0015X\u0082Ô\b¢\u0006\u0002\n\u0000*\f\b\u0002\u0010\u0012\"\u00020\u00132\u00020\u0013¨\u0006\u001b"}, d2 = {"sequence", "Lni/shikatu/kotlin/sequences/Sequence;", "T", "block", "Lni/shikatu/kotlin/Function2;", "Lni/shikatu/kotlin/sequences/SequenceScope;", "Lni/shikatu/kotlin/coroutines/Continuation;", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ExtensionFunctionType;", "Lni/shikatu/kotlin/BuilderInference;", "(Lkotlin/jvm/functions/Function2;)Lkotlin/sequences/Sequence;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "iterator", _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlin/jvm/functions/Function2;)Ljava/util/Iterator;", "State", _UrlKt.FRAGMENT_ENCODE_SET, "State_NotReady", "Lni/shikatu/kotlin/sequences/State;", "State_ManyNotReady", "State_ManyReady", "State_Ready", "State_Done", "State_Failed", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/sequences/SequencesKt")
public class SequencesKt__SequenceBuilderKt {
    private static final int State_Done = 4;
    private static final int State_Failed = 5;
    private static final int State_ManyNotReady = 1;
    private static final int State_ManyReady = 2;
    private static final int State_NotReady = 0;
    private static final int State_Ready = 3;

    public static final <T> Sequence<T> sequence(final Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        return new Sequence<T>() {
            @Override
            public Iterator<T> iterator() {
                return SequencesKt.iterator(function2);
            }
        };
    }

    public static final <T> Iterator<T> iterator(Function2<? super SequenceScope<? super T>, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        SequenceBuilderIterator iterator = new SequenceBuilderIterator();
        iterator.setNextStep(IntrinsicsKt.createCoroutineUnintercepted(function2, iterator, iterator));
        return iterator;
    }
}
