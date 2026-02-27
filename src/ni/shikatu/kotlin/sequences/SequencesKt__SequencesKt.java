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
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.random.Random;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010(\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\u001a.\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0014\b\u0004\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004H\u0087\bø\u0001\u0000\u001a\u001c\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0005\u001a+\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0012\u0010\b\u001a\n\u0012\u0006\b\u0001\u0012\u0002H\u00020\t\"\u0002H\u0002¢\u0006\u0002\u0010\n\u001a\u0012\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002\u001a!\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001H\u0087\b\u001a2\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0012\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0004H\u0007\u001a\"\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00010\u0001\u001a)\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00100\u0001H\u0007¢\u0006\u0002\b\u0011\u001aC\u0010\u000f\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0012*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u0002\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u00050\u0013H\u0002¢\u0006\u0002\b\u0014\u001a@\u0010\u0015\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0017\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u00170\u0016\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u0012*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00120\u00160\u0001\u001a\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0007\u001a&\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0019\u001a\u00020\u001aH\u0007\u001ab\u0010\u001b\u001a\b\u0012\u0004\u0012\u0002H\u00120\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u001c\"\u0004\b\u0002\u0010\u00122\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0018\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u001c0\u001f2\u0018\u0010\u0003\u001a\u0014\u0012\u0004\u0012\u0002H\u001c\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00120\u00050\u0013H\u0000\u001a\u001c\u0010!\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0001\u001a&\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020#2\u000e\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0004\u001a=\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020#2\b\u0010%\u001a\u0004\u0018\u0001H\u00022\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0013H\u0007¢\u0006\u0002\u0010&\u001a<\u0010\"\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020#2\u000e\u0010'\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u00042\u0014\u0010$\u001a\u0010\u0012\u0004\u0012\u0002H\u0002\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006("}, d2 = {"Sequence", "Lni/shikatu/kotlin/sequences/Sequence;", "T", "iterator", "Lni/shikatu/kotlin/Function0;", "", "asSequence", "sequenceOf", "elements", "", "([Ljava/lang/Object;)Lkotlin/sequences/Sequence;", "emptySequence", "orEmpty", "ifEmpty", "defaultValue", "flatten", "", "flattenSequenceOfIterable", "R", "Lni/shikatu/kotlin/Function1;", "flatten$SequencesKt__SequencesKt", "unzip", "Lni/shikatu/kotlin/Pair;", "", "shuffled", "random", "Lni/shikatu/kotlin/random/Random;", "flatMapIndexed", "C", "source", "transform", "Lni/shikatu/kotlin/Function2;", "", "constrainOnce", "generateSequence", "", "nextFunction", "seed", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Lkotlin/sequences/Sequence;", "seedFunction", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "ni/shikatu/kotlin/sequences/SequencesKt")
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

    public static final <T> Sequence<T> emptySequence() {
        return EmptySequence.INSTANCE;
    }

    private static final <T> Sequence<T> orEmpty(Sequence<? extends T> sequence) {
        return sequence == 0 ? SequencesKt.emptySequence() : sequence;
    }

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lni/shikatu/kotlin/sequences/SequenceScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "ni.shikatu.kotlin.sequences.SequencesKt__SequencesKt$ifEmpty$1", f = "Sequences.kt", i = {}, l = {69, 71}, m = "invokeSuspend", n = {}, s = {})
    static final class C00091<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {
        final  Function0<Sequence<T>> $defaultValue;
        final  Sequence<T> $this_ifEmpty;
        private  Object L$0;
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
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    SequenceScope sequenceScope = (SequenceScope) this.L$0;
                    Iterator<? extends T> it = this.$this_ifEmpty.iterator();
                    if (it.hasNext()) {
                        this.label = 1;
                        if (sequenceScope.yieldAll(it, this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        this.label = 2;
                        if (sequenceScope.yieldAll(this.$defaultValue.invoke(), this) == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    }
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
                return SequencesKt__SequencesKt.flatten$lambda$1$SequencesKt__SequencesKt((Sequence) obj);
            }
        });
    }

    public static final Iterator flatten$lambda$1$SequencesKt__SequencesKt(Sequence it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.iterator();
    }

    public static final Iterator flatten$lambda$2$SequencesKt__SequencesKt(Iterable it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return it.iterator();
    }

    public static final <T> Sequence<T> flattenSequenceOfIterable(Sequence<? extends Iterable<? extends T>> sequence) {
        Intrinsics.checkNotNullParameter(sequence, "<this>");
        return flatten$SequencesKt__SequencesKt(sequence, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return SequencesKt__SequencesKt.flatten$lambda$2$SequencesKt__SequencesKt((Iterable) obj);
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
                return SequencesKt__SequencesKt.flatten$lambda$3$SequencesKt__SequencesKt(obj);
            }
        }, function1);
    }

    public static final Object flatten$lambda$3$SequencesKt__SequencesKt(Object it) {
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

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "T", "Lni/shikatu/kotlin/sequences/SequenceScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "ni.shikatu.kotlin.sequences.SequencesKt__SequencesKt$shuffled$1", f = "Sequences.kt", i = {0, 0}, l = {145}, m = "invokeSuspend", n = {"$this$sequence", "buffer"}, s = {"L$0", "L$1"})
    static final class C00101<T> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super T>, Continuation<? super Unit>, Object> {
        final  Random $random;
        final  Sequence<T> $this_shuffled;
        private  Object L$0;
        Object L$1;
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
        public final Object invokeSuspend(Object obj) throws Throwable {
            SequenceScope sequenceScope;
            List mutableList;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    SequenceScope sequenceScope2 = (SequenceScope) this.L$0;
                    sequenceScope = sequenceScope2;
                    mutableList = SequencesKt.toMutableList(this.$this_shuffled);
                    break;
                case 1:
                    mutableList = (List) this.L$1;
                    SequenceScope sequenceScope3 = (SequenceScope) this.L$0;
                    ResultKt.throwOnFailure(obj);
                    sequenceScope = sequenceScope3;
                    break;
                default:
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            while (!mutableList.isEmpty()) {
                int iNextInt = this.$random.nextInt(mutableList.size());
                Object objRemoveLast = CollectionsKt.removeLast(mutableList);
                if (iNextInt < mutableList.size()) {
                    objRemoveLast = mutableList.set(iNextInt, objRemoveLast);
                }
                this.L$0 = sequenceScope;
                this.L$1 = mutableList;
                this.label = 1;
                if (sequenceScope.yield(objRemoveLast, this) == coroutine_suspended) {
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

    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0003H\n"}, d2 = {"<anonymous>", "", "R", "Lni/shikatu/kotlin/sequences/SequenceScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "ni.shikatu.kotlin.sequences.SequencesKt__SequencesKt$flatMapIndexed$1", f = "Sequences.kt", i = {0, 0}, l = {350}, m = "invokeSuspend", n = {"$this$sequence", "index"}, s = {"L$0", "I$0"})
    static final class C00081<R> extends RestrictedSuspendLambda implements Function2<SequenceScope<? super R>, Continuation<? super Unit>, Object> {
        final  Function1<C, Iterator<R>> $iterator;
        final  Sequence<T> $source;
        final  Function2<Integer, T, C> $transform;
        int I$0;
        private  Object L$0;
        Object L$1;
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
            SequenceScope sequenceScope;
            int i;
            Iterator it;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            switch (this.label) {
                case 0:
                    ResultKt.throwOnFailure(obj);
                    sequenceScope = (SequenceScope) this.L$0;
                    i = 0;
                    it = this.$source.iterator();
                    break;
                case 1:
                    i = this.I$0;
                    it = (Iterator) this.L$1;
                    sequenceScope = (SequenceScope) this.L$0;
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
                return SequencesKt__SequencesKt.generateSequence$lambda$4$SequencesKt__SequencesKt(function0, obj);
            }
        }));
    }

    public static final Object generateSequence$lambda$4$SequencesKt__SequencesKt(Function0 $nextFunction, Object it) {
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
                return SequencesKt__SequencesKt.generateSequence$lambda$5$SequencesKt__SequencesKt(t);
            }
        }, function1);
    }

    public static final Object generateSequence$lambda$5$SequencesKt__SequencesKt(Object $seed) {
        return $seed;
    }

    public static final <T> Sequence<T> generateSequence(Function0<? extends T> function0, Function1<? super T, ? extends T> function1) {
        Intrinsics.checkNotNullParameter(function0, "seedFunction");
        Intrinsics.checkNotNullParameter(function1, "nextFunction");
        return new GeneratorSequence(function0, function1);
    }
}
