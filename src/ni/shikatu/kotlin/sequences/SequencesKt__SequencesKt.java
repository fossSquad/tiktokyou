package ni.shikatu.kotlin.sequences;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.coroutines.Continuation;
import ni.shikatu.kotlin.coroutines.intrinsics.IntrinsicsKt;
import ni.shikatu.kotlin.coroutines.jvm.internal.Boxing;
import ni.shikatu.kotlin.coroutines.jvm.internal.DebugMetadata;
import ni.shikatu.kotlin.coroutines.jvm.internal.RestrictedSuspendLambda;
import ni.shikatu.kotlin.coroutines.jvm.internal.SpillingKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.random.Random;
import ni.shikatu.okhttp3.internal.http.HttpStatusCodesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000p\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\u0088\u0004b\u0002\b\u0006ø\u0001\u0000\u001a \u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086\u0080\u0004\u001a/\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\t\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\n\"\u0002H\u0002H\u0086\u0080\u0004¢\u0006\u0002\u0010\u000b\u001a1\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\f\u001a\u0002H\u0002H\u0087\u0080\u0004b\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010¢\u0006\u0002\u0010\r\u001a(\u0010\b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0087\u0088\u0004b\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010b\u0002\b\u0006\u001a\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\u0086\u0080\u0004\u001a4\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\u0088\u0004b\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013b\u0002\b\u0006\u001aB\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0087\u0080\u0004b\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0013\u001a&\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001H\u0086\u0080\u0004\u001a9\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00170\u0001H\u0087\u0080\u0004b\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u0018¢\u0006\u0002\b\u0018\u001aE\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u001b*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u00050\u001cH\u0082\u0080\u0004¢\u0006\u0002\b\u001d\u001aD\u0010\u001e\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0 0\u001f\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u001b*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u001b0\u001f0\u0001H\u0086\u0080\u0004\u001a.\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0087\u0080\u0004b\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\"\u001a6\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010#\u001a\u00020$H\u0087\u0080\u0004b\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\"\u001ad\u0010%\u001a\b\u0012\u0004\u0012\u0002H\u001b0\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010&\"\u0004\b\u0002\u0010\u001b2\f\u0010'\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010(\u001a\u0014\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H&0)2\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H&\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u001b0\u00050\u001cH\u0080\u0080\u0004\u001a \u0010+\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0086\u0080\u0004\u001a*\u0010,\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020-2\u000e\u0010.\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004H\u0086\u0080\u0004\u001aC\u0010,\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020-2\b\u0010/\u001a\u0004\u0018\u0001H\u00022\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u001cH\u0087\u0080\u0004b\u0002\b1¢\u0006\u0002\u00100\u001a@\u0010,\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020-2\u000e\u00102\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0014\u0010.\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u001cH\u0086\u0080\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00063"}, d2 = {"Sequence", "Lni/shikatu/kotlin/sequences/Sequence;", "T", "iterator", "Lni/shikatu/kotlin/Function0;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/internal/InlineOnly;", "asSequence", "sequenceOf", "elements", _UrlKt.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "element", "(Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "2.2", "emptySequence", "orEmpty", "1.3", "ifEmpty", "defaultValue", "flatten", _UrlKt.FRAGMENT_ENCODE_SET, "flattenSequenceOfIterable", "Lni/shikatu/kotlin/jvm/JvmName;", "name", "R", "Lni/shikatu/kotlin/Function1;", "flatten$SequencesKt__SequencesKt", "unzip", "Lni/shikatu/kotlin/Pair;", _UrlKt.FRAGMENT_ENCODE_SET, "shuffled", "1.4", "random", "Lni/shikatu/kotlin/random/Random;", "flatMapIndexed", "C", "source", "transform", "Lni/shikatu/kotlin/Function2;", _UrlKt.FRAGMENT_ENCODE_SET, "constrainOnce", "generateSequence", _UrlKt.FRAGMENT_ENCODE_SET, "nextFunction", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "Lni/shikatu/kotlin/internal/LowPriorityInOverloadResolution;", "seedFunction", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/sequences/SequencesKt")
public class SequencesKt__SequencesKt extends SequencesKt__SequencesJVMKt {
    private static final <T> Sequence<T> Sequence(final Function0<? extends Iterator<? extends T>> function0) {
        Intrinsics.checkNotNullParameter(function0, "iterator");
        return new Sequence<T>() {
            @Override
            public Iterator<T> iterator() {
                return function0.invoke();
            }
        };
    }

    public static final <T> Sequence<T> asSequence(final Iterator<? extends T> it) {
        Intrinsics.checkNotNullParameter(it, "<this>");
        return SequencesKt.constrainOnce(new Sequence<T>() {
            @Override
            public Iterator<T> iterator() {
                return it;
            }
        });
    }

    public static final <T> Sequence<T> sequenceOf(T... tArr) {
        Intrinsics.checkNotNullParameter(tArr, "elements");
        return ArraysKt.asSequence(tArr);
    }

    public static final <T> Sequence<T> sequenceOf(final T t) {
        return new Sequence<T>() {
            @Override
            public Iterator<T> iterator() {
                return new SequencesKt__SequencesKt$sequenceOf$1$1(t);
            }
        };
    }

    private static final <T> Sequence<T> sequenceOf() {
        return SequencesKt.emptySequence();
    }

    public static final <T> Sequence<T> emptySequence() {
        return EmptySequence.INSTANCE;
    }

    private static final <T> Sequence<T> orEmpty(Sequence<? extends T> sequence) {
        return sequence == 0 ? SequencesKt.emptySequence() : sequence;
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", _UrlKt.FRAGMENT_ENCODE_SET, "T", "Lni/shikatu/kotlin/sequences/SequenceScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "ni.shikatu.kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f = "Sequences.kt", i = {0, 0, 1, 1}, l = {HttpStatusCodesKt.HTTP_PROCESSING, 104}, m = "invokeSuspend", n = {"$this$sequence", "iterator", "$this$sequence", "iterator"}, nl = {104, 106}, s = {"L$0", "L$1", "L$0", "L$1"}, v = 2)
    static final class C00091<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {
        final  Function0<Sequence<T>> $defaultValue;
        final  Sequence<T> $this_ifEmpty;
        private  Object L$0;
        Object L$1;
        int label;

        C00091(Sequence<? extends T> sequence, Function0<? extends Sequence<? extends T>> function0, Continuation<? super C00091> continuation) {
            super(2, continuation);
            this.$this_ifEmpty = sequence;
            this.$defaultValue = function0;
        }

        @Override
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00091 c00091 = new C00091(this.$this_ifEmpty, this.$defaultValue, continuation);
            c00091.L$0 = obj;
            return c00091;
        }

        @Override
        public final Object invoke(SequenceScope<? super T> sequenceScope, Continuation<? super Unit> continuation) {
            return ((C00091) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override
        public final Object invokeSuspend(Object obj) throws Throwable {
            SequenceScope sequenceScope = (SequenceScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    Iterator<? extends T> it = this.$this_ifEmpty.iterator();
                    if (it.hasNext()) {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(it);
                        this.label = 1;
                        if (sequenceScope.yieldAll(it, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        this.L$0 = SpillingKt.nullOutSpilledVariable(sequenceScope);
                        this.L$1 = SpillingKt.nullOutSpilledVariable(it);
                        this.label = 2;
                        if (sequenceScope.yieldAll(this.$defaultValue.invoke(), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
                    break;
                case 1:
                    ResultKt.throwOnFailure(obj);
                    break;
                case 2:
                    ResultKt.throwOnFailure(obj);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.INSTANCE;
        }
    }

    public static final <T> Sequence<T> ifEmpty(Sequence<? extends T> sequence, Function0<? extends Sequence<? extends T>> function0) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(function0, "defaultValue");
        return SequencesKt.sequence(new C00091(sequence, function0, null));
    }

    public static final <T> Sequence<T> flatten(Sequence<? extends Sequence<? extends T>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return flatten$SequencesKt__SequencesKt(sequence, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return SequencesKt__SequencesKt.flatten$lambda$0$SequencesKt__SequencesKt((Sequence) obj);
            }
        });
    }

    public static final Iterator flatten$lambda$0$SequencesKt__SequencesKt(Sequence it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.iterator();
    }

    public static final Iterator flatten$lambda$1$SequencesKt__SequencesKt(Iterable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.iterator();
    }

    public static final <T> Sequence<T> flattenSequenceOfIterable(Sequence<? extends Iterable<? extends T>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return flatten$SequencesKt__SequencesKt(sequence, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return SequencesKt__SequencesKt.flatten$lambda$1$SequencesKt__SequencesKt((Iterable) obj);
            }
        });
    }

    private static final <T, R> Sequence<R> flatten$SequencesKt__SequencesKt(Sequence<? extends T> sequence, Function1<? super T, ? extends Iterator<? extends R>> function1) {
        if (sequence instanceof TransformingSequence) {
            return ((TransformingSequence) sequence).flatten$kotlin_stdlib(function1);
        }
        return new FlatteningSequence(sequence, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return SequencesKt__SequencesKt.flatten$lambda$2$SequencesKt__SequencesKt(obj);
            }
        }, function1);
    }

    public static final Object flatten$lambda$2$SequencesKt__SequencesKt(Object it) {
        return it;
    }

    public static final <T, R> Pair<List<T>, List<R>> unzip(Sequence<? extends Pair<? extends T, ? extends R>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        ArrayList listT = new ArrayList();
        ArrayList listR = new ArrayList();
        for (Pair<? extends T, ? extends R> pair : sequence) {
            listT.add(pair.getFirst());
            listR.add(pair.getSecond());
        }
        return TuplesKt.to(listT, listR);
    }

    public static final <T> Sequence<T> shuffled(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return SequencesKt.shuffled(sequence, Random.Default);
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", _UrlKt.FRAGMENT_ENCODE_SET, "T", "Lni/shikatu/kotlin/sequences/SequenceScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "ni.shikatu.kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", i = {0, 0, 0, 0, 0}, l = {178}, m = "invokeSuspend", n = {"$this$sequence", "buffer", "last", "value", "j"}, nl = {180}, s = {"L$0", "L$1", "L$2", "L$3", "I$0"}, v = 2)
    static final class C00101<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {
        final  Random $random;
        final  Sequence<T> $this_shuffled;
        int I$0;
        private  Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        C00101(Sequence<? extends T> sequence, Random random, Continuation<? super C00101> continuation) {
            super(2, continuation);
            this.$this_shuffled = sequence;
            this.$random = random;
        }

        @Override
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00101 c00101 = new C00101(this.$this_shuffled, this.$random, continuation);
            c00101.L$0 = obj;
            return c00101;
        }

        @Override
        public final Object invoke(SequenceScope<? super T> sequenceScope, Continuation<? super Unit> continuation) {
            return ((C00101) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override
        public final Object invokeSuspend(Object $result) throws Throwable {
            List buffer;
            SequenceScope sequenceScope = (SequenceScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure($result);
                    buffer = SequencesKt.toMutableList(this.$this_shuffled);
                    break;
                case 1:
                    int i = this.I$0;
                    Object obj = this.L$3;
                    Object obj2 = this.L$2;
                    buffer = (List) this.L$1;
                    ResultKt.throwOnFailure($result);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            while (!buffer.isEmpty()) {
                int j = this.$random.nextInt(buffer.size());
                Object last = CollectionsKt.removeLast(buffer);
                Object value = j < buffer.size() ? buffer.set(j, last) : last;
                this.L$0 = sequenceScope;
                this.L$1 = buffer;
                this.L$2 = SpillingKt.nullOutSpilledVariable(last);
                this.L$3 = SpillingKt.nullOutSpilledVariable(value);
                this.I$0 = j;
                this.label = 1;
                if (sequenceScope.yield(value, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    public static final <T> Sequence<T> shuffled(Sequence<? extends T> sequence, Random random) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        Intrinsics.checkNotNullParameter(random, "random");
        return SequencesKt.sequence(new C00101(sequence, random, null));
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", _UrlKt.FRAGMENT_ENCODE_SET, "R", "Lni/shikatu/kotlin/sequences/SequenceScope;"}, k = 3, mv = {2, 4, 0}, xi = 48)
    @DebugMetadata(c = "ni.shikatu.kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", i = {0, 0, 0, 0}, l = {383}, m = "invokeSuspend", n = {"$this$sequence", "element", "result", "index"}, nl = {385}, s = {"L$0", "L$2", "L$3", "I$0"}, v = 2)
    static final class C00081<R> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
        final  Function1<C, Iterator<R>> $iterator;
        final  Sequence<T> $source;
        final  Function2<Integer, T, C> $transform;
        int I$0;
        private  Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        C00081(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, ? extends C> function2, Function1<? super C, ? extends Iterator<? extends R>> function1, Continuation<? super C00081> continuation) {
            super(2, continuation);
            this.$source = sequence;
            this.$transform = function2;
            this.$iterator = function1;
        }

        @Override
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C00081 c00081 = new C00081(this.$source, this.$transform, this.$iterator, continuation);
            c00081.L$0 = obj;
            return c00081;
        }

        @Override
        public final Object invoke(SequenceScope<? super R> sequenceScope, Continuation<? super Unit> continuation) {
            return ((C00081) create(sequenceScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override
        public final Object invokeSuspend(Object obj) throws Throwable {
            int i;
            Iterator it;
            SequenceScope sequenceScope = (SequenceScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    i = 0;
                    it = this.$source.iterator();
                    break;
                case 1:
                    i = this.I$0;
                    Object obj2 = this.L$3;
                    Object obj3 = this.L$2;
                    it = (Iterator) this.L$1;
                    ResultKt.throwOnFailure(obj);
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            while (it.hasNext()) {
                Object next = it.next();
                Function2<Integer, T, C> function2 = this.$transform;
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                Object objInvoke = function2.invoke(Boxing.boxInt(i), (T) next);
                this.L$0 = sequenceScope;
                this.L$1 = it;
                this.L$2 = SpillingKt.nullOutSpilledVariable(next);
                this.L$3 = SpillingKt.nullOutSpilledVariable(objInvoke);
                this.I$0 = i2;
                this.label = 1;
                if (sequenceScope.yieldAll(this.$iterator.invoke((C) objInvoke), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                i = i2;
            }
            return Unit.INSTANCE;
        }
    }

    public static final <T, C, R> Sequence<R> flatMapIndexed(Sequence<? extends T> sequence, Function2<? super Integer, ? super T, ? extends C> function2, Function1<? super C, ? extends Iterator<? extends R>> function1) {
        Intrinsics.checkNotNullParameter(sequence, "source");
        Intrinsics.checkNotNullParameter(function2, "transform");
        Intrinsics.checkNotNullParameter(function1, "iterator");
        return SequencesKt.sequence(new C00081(sequence, function2, function1, null));
    }

    public static final <T> Sequence<T> constrainOnce(Sequence<? extends T> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return sequence instanceof ConstrainedOnceSequence ? sequence : new ConstrainedOnceSequence(sequence);
    }

    public static final <T> Sequence<T> generateSequence(final Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "nextFunction");
        return SequencesKt.constrainOnce(new GeneratorSequence(function0, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return SequencesKt__SequencesKt.generateSequence$lambda$0$SequencesKt__SequencesKt(function0, obj);
            }
        }));
    }

    public static final Object generateSequence$lambda$0$SequencesKt__SequencesKt(Function0 $nextFunction, Object it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return $nextFunction.invoke();
    }

    public static final <T> Sequence<T> generateSequence(final T t, Function1<? super T, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function1, "nextFunction");
        if (t == null) {
            return EmptySequence.INSTANCE;
        }
        return new GeneratorSequence(new Function0() {
            @Override
            public final Object invoke() {
                return SequencesKt__SequencesKt.generateSequence$lambda$1$SequencesKt__SequencesKt(t);
            }
        }, function1);
    }

    public static final Object generateSequence$lambda$1$SequencesKt__SequencesKt(Object $seed) {
        return $seed;
    }

    public static final <T> Sequence<T> generateSequence(Function0<? extends T> function0, Function1<? super T, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function0, "seedFunction");
        Intrinsics.checkNotNullParameter(function1, "nextFunction");
        return new GeneratorSequence(function0, function1);
    }
}
