package ni.shikatu.kotlin.coroutines.intrinsics;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.coroutines.Continuation;
import ni.shikatu.kotlin.coroutines.CoroutineContext;
import ni.shikatu.kotlin.coroutines.EmptyCoroutineContext;
import ni.shikatu.kotlin.coroutines.jvm.internal.BaseContinuationImpl;
import ni.shikatu.kotlin.coroutines.jvm.internal.ContinuationImpl;
import ni.shikatu.kotlin.coroutines.jvm.internal.DebugProbesKt;
import ni.shikatu.kotlin.coroutines.jvm.internal.RestrictedContinuationImpl;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.functions.Function3;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.TypeIntrinsics;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\t\u001aA\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\u0006\u001a=\u0010\u0007\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0001¢\u0006\u0002\u0010\u0006\u001aZ\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0002*#\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u0002H\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0087\bø\u0001\u0000¢\u0006\u0002\u0010\f\u001aV\u0010\u0007\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0002*#\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u0002H\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0001¢\u0006\u0002\u0010\f\u001an\u0010\u0000\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u0002*)\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e¢\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u0002H\b2\u0006\u0010\u000f\u001a\u0002H\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0081\bø\u0001\u0000¢\u0006\u0002\u0010\u0010\u001aj\u0010\u0007\u001a\u0004\u0018\u00010\u0001\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\r\"\u0004\b\u0002\u0010\u0002*)\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\u0004\u0012\u0002H\r\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000e¢\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u0002H\b2\u0006\u0010\u000f\u001a\u0002H\r2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0001¢\u0006\u0002\u0010\u0010\u001aA\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004\"\u0004\b\u0000\u0010\u0002*\u0018\b\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0013\u001aZ\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004\"\u0004\b\u0000\u0010\b\"\u0004\b\u0001\u0010\u0002*#\b\u0001\u0012\u0004\u0012\u0002H\b\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\t¢\u0006\u0002\b\n2\u0006\u0010\u000b\u001a\u0002H\b2\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007¢\u0006\u0002\u0010\u0014\u001a\u001e\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0007\u001aF\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00120\u0004\"\u0004\b\u0000\u0010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00042\u001c\b\u0004\u0010\u0017\u001a\u0016\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0003H\u0083\b¢\u0006\u0002\b\u0018\u001a'\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\"\u0004\b\u0000\u0010\u00022\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004H\u0002¢\u0006\u0002\b\u001a\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001b"}, d2 = {"startCoroutineUninterceptedOrReturn", "", "T", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/coroutines/Continuation;", "completion", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "wrapWithContinuationImpl", "R", "Lni/shikatu/kotlin/Function2;", "Lni/shikatu/kotlin/ExtensionFunctionType;", "receiver", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "P", "Lni/shikatu/kotlin/Function3;", "param", "(Lkotlin/jvm/functions/Function3;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "createCoroutineUnintercepted", "", "(Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Lkotlin/coroutines/Continuation;", "intercepted", "createCoroutineFromSuspendFunction", "block", "createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "createSimpleCoroutineForSuspendFunction", "createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "ni/shikatu/kotlin/coroutines/intrinsics/IntrinsicsKt")
public class IntrinsicsKt__IntrinsicsJvmKt {
    private static final <T> Object startCoroutineUninterceptedOrReturn(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return !(function1 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(function1, continuation) : ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(continuation);
    }

    public static final <T> Object wrapWithContinuationImpl(Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        Continuation newCompletion = createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(DebugProbesKt.probeCoroutineCreated(continuation));
        return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function1, 1)).invoke(newCompletion);
    }

    private static final <R, T> Object startCoroutineUninterceptedOrReturn(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function2, "<this>");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return !(function2 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(function2, r, continuation) : ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, continuation);
    }

    public static final <R, T> Object wrapWithContinuationImpl(Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, R r, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function2, "<this>");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        Continuation newCompletion = createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(DebugProbesKt.probeCoroutineCreated(continuation));
        return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function2, 2)).invoke(r, newCompletion);
    }

    private static final <R, P, T> Object startCoroutineUninterceptedOrReturn(Function3<? super R, ? super P, ? super Continuation<? super T>, ? extends Object> function3, R r, P p, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function3, "<this>");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        return !(function3 instanceof BaseContinuationImpl) ? IntrinsicsKt.wrapWithContinuationImpl(function3, r, p, continuation) : ((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function3, 3)).invoke(r, p, continuation);
    }

    public static final <R, P, T> Object wrapWithContinuationImpl(Function3<? super R, ? super P, ? super Continuation<? super T>, ? extends Object> function3, R r, P p, Continuation<? super T> continuation) {
        Intrinsics.checkNotNullParameter(function3, "<this>");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        Continuation newCompletion = createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(DebugProbesKt.probeCoroutineCreated(continuation));
        return ((Function3) TypeIntrinsics.beforeCheckcastToFunctionOfArity(function3, 3)).invoke(r, p, newCompletion);
    }

    public static final <T> Continuation<Unit> createCoroutineUnintercepted(final Function1<? super Continuation<? super T>, ? extends Object> function1, Continuation<? super T> continuation) {
        ContinuationImpl continuationImpl;
        Intrinsics.checkNotNullParameter(function1, "<this>");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        final Continuation<?> continuationProbeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        if (function1 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function1).create(continuationProbeCoroutineCreated);
        }
        final CoroutineContext context$iv = continuationProbeCoroutineCreated.getContext();
        if (context$iv == EmptyCoroutineContext.INSTANCE) {
            continuationImpl = new RestrictedContinuationImpl(continuationProbeCoroutineCreated, function1) {
                final  Function1 $this_createCoroutineUnintercepted$inlined;
                private int label;

                {
                    super(continuationProbeCoroutineCreated);
                    this.$this_createCoroutineUnintercepted$inlined = function1;
                    Intrinsics.checkNotNull(continuationProbeCoroutineCreated, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override
                protected Object invokeSuspend(Object result) throws Throwable {
                    switch (this.label) {
                        case 0:
                            this.label = 1;
                            ResultKt.throwOnFailure(result);
                            Intrinsics.checkNotNull(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                            return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(this.$this_createCoroutineUnintercepted$inlined, 1)).invoke(this);
                        case 1:
                            this.label = 2;
                            ResultKt.throwOnFailure(result);
                            return result;
                        default:
                            throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        } else {
            continuationImpl = new ContinuationImpl(continuationProbeCoroutineCreated, context$iv, function1) {
                final  Function1 $this_createCoroutineUnintercepted$inlined;
                private int label;

                {
                    super(continuationProbeCoroutineCreated, context$iv);
                    this.$this_createCoroutineUnintercepted$inlined = function1;
                    Intrinsics.checkNotNull(continuationProbeCoroutineCreated, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override
                protected Object invokeSuspend(Object result) throws Throwable {
                    switch (this.label) {
                        case 0:
                            this.label = 1;
                            ResultKt.throwOnFailure(result);
                            Intrinsics.checkNotNull(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function1<kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                            return ((Function1) TypeIntrinsics.beforeCheckcastToFunctionOfArity(this.$this_createCoroutineUnintercepted$inlined, 1)).invoke(this);
                        case 1:
                            this.label = 2;
                            ResultKt.throwOnFailure(result);
                            return result;
                        default:
                            throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        }
        return continuationImpl;
    }

    public static final <R, T> Continuation<Unit> createCoroutineUnintercepted(final Function2<? super R, ? super Continuation<? super T>, ? extends Object> function2, final R r, Continuation<? super T> continuation) {
        ContinuationImpl continuationImpl;
        Intrinsics.checkNotNullParameter(function2, "<this>");
        Intrinsics.checkNotNullParameter(continuation, "completion");
        final Continuation<?> continuationProbeCoroutineCreated = DebugProbesKt.probeCoroutineCreated(continuation);
        if (function2 instanceof BaseContinuationImpl) {
            return ((BaseContinuationImpl) function2).create(r, continuationProbeCoroutineCreated);
        }
        final CoroutineContext context$iv = continuationProbeCoroutineCreated.getContext();
        if (context$iv == EmptyCoroutineContext.INSTANCE) {
            continuationImpl = new RestrictedContinuationImpl(continuationProbeCoroutineCreated, function2, r) {
                final  Object $receiver$inlined;
                final  Function2 $this_createCoroutineUnintercepted$inlined;
                private int label;

                {
                    super(continuationProbeCoroutineCreated);
                    this.$this_createCoroutineUnintercepted$inlined = function2;
                    this.$receiver$inlined = r;
                    Intrinsics.checkNotNull(continuationProbeCoroutineCreated, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override
                protected Object invokeSuspend(Object result) throws Throwable {
                    switch (this.label) {
                        case 0:
                            this.label = 1;
                            ResultKt.throwOnFailure(result);
                            Intrinsics.checkNotNull(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                            return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, this);
                        case 1:
                            this.label = 2;
                            ResultKt.throwOnFailure(result);
                            return result;
                        default:
                            throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        } else {
            continuationImpl = new ContinuationImpl(continuationProbeCoroutineCreated, context$iv, function2, r) {
                final  Object $receiver$inlined;
                final  Function2 $this_createCoroutineUnintercepted$inlined;
                private int label;

                {
                    super(continuationProbeCoroutineCreated, context$iv);
                    this.$this_createCoroutineUnintercepted$inlined = function2;
                    this.$receiver$inlined = r;
                    Intrinsics.checkNotNull(continuationProbeCoroutineCreated, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override
                protected Object invokeSuspend(Object result) throws Throwable {
                    switch (this.label) {
                        case 0:
                            this.label = 1;
                            ResultKt.throwOnFailure(result);
                            Intrinsics.checkNotNull(this.$this_createCoroutineUnintercepted$inlined, "null cannot be cast to non-null type kotlin.Function2<R of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted, kotlin.coroutines.Continuation<T of kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt.createCoroutineUnintercepted>, kotlin.Any?>");
                            return ((Function2) TypeIntrinsics.beforeCheckcastToFunctionOfArity(this.$this_createCoroutineUnintercepted$inlined, 2)).invoke(this.$receiver$inlined, this);
                        case 1:
                            this.label = 2;
                            ResultKt.throwOnFailure(result);
                            return result;
                        default:
                            throw new IllegalStateException("This coroutine had already completed".toString());
                    }
                }
            };
        }
        return continuationImpl;
    }

    public static final <T> Continuation<T> intercepted(Continuation<? super T> continuation) {
        Continuation<T> continuation2;
        Intrinsics.checkNotNullParameter(continuation, "<this>");
        ContinuationImpl continuationImpl = continuation instanceof ContinuationImpl ? (ContinuationImpl) continuation : null;
        return (continuationImpl == null || (continuation2 = (Continuation<T>) continuationImpl.intercepted()) == null) ? continuation : continuation2;
    }

    private static final <T> Continuation<Unit> createCoroutineFromSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(final Continuation<? super T> continuation, final Function1<? super Continuation<? super T>, ? extends Object> function1) {
        final CoroutineContext context = continuation.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(continuation, function1) {
                final  Function1<Continuation<? super T>, Object> $block;
                private int label;

                {
                    super(continuation);
                    this.$block = function1;
                    Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override
                protected java.lang.Object invokeSuspend(java.lang.Object r3) {
                    /*
                        r2 = this;
                        int r0 = r2.label
                        switch(r0) {
                            case 0: goto L19;
                            case 1: goto L11;
                            default: goto L5;
                        }
                    L5:
                        java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                        java.lang.String r1 = "This coroutine had already completed"
                        java.lang.String r1 = r1.toString()
                        r0.<init>(r1)
                        throw r0
                    L11:
                        r0 = 2
                        r2.label = r0
                        ni.shikatu.kotlin.ResultKt.throwOnFailure(r3)
                        r0 = r3
                        goto L25
                    L19:
                        r0 = 1
                        r2.label = r0
                        ni.shikatu.kotlin.ResultKt.throwOnFailure(r3)
                        ni.shikatu.kotlin.jvm.functions.Function1<ni.shikatu.kotlin.coroutines.Continuation<? super T>, java.lang.Object> r0 = r2.$block
                        java.lang.Object r0 = r0.invoke(r2)
                    L25:
                        return r0
                    */
                    throw new UnsupportedOperationException("Method not decompiled: ni.shikatu.kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$1.invokeSuspend(java.lang.Object):java.lang.Object");
                }
            };
        }
        return new ContinuationImpl(continuation, context, function1) {
            final  Function1<Continuation<? super T>, Object> $block;
            private int label;

            {
                super(continuation, context);
                this.$block = function1;
                Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override
            protected java.lang.Object invokeSuspend(java.lang.Object r3) {
                /*
                    r2 = this;
                    int r0 = r2.label
                    switch(r0) {
                        case 0: goto L19;
                        case 1: goto L11;
                        default: goto L5;
                    }
                L5:
                    java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                    java.lang.String r1 = "This coroutine had already completed"
                    java.lang.String r1 = r1.toString()
                    r0.<init>(r1)
                    throw r0
                L11:
                    r0 = 2
                    r2.label = r0
                    ni.shikatu.kotlin.ResultKt.throwOnFailure(r3)
                    r0 = r3
                    goto L25
                L19:
                    r0 = 1
                    r2.label = r0
                    ni.shikatu.kotlin.ResultKt.throwOnFailure(r3)
                    ni.shikatu.kotlin.jvm.functions.Function1<ni.shikatu.kotlin.coroutines.Continuation<? super T>, java.lang.Object> r0 = r2.$block
                    java.lang.Object r0 = r0.invoke(r2)
                L25:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: ni.shikatu.kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt$createCoroutineFromSuspendFunction$2.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        };
    }

    private static final <T> Continuation<T> createSimpleCoroutineForSuspendFunction$IntrinsicsKt__IntrinsicsJvmKt(final Continuation<? super T> continuation) {
        final CoroutineContext context = continuation.getContext();
        if (context == EmptyCoroutineContext.INSTANCE) {
            return new RestrictedContinuationImpl(continuation) {

                {
                    super(continuation);
                    Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
                }

                @Override
                protected Object invokeSuspend(Object result) throws Throwable {
                    ResultKt.throwOnFailure(result);
                    return result;
                }
            };
        }
        return new ContinuationImpl(continuation, context) {

            {
                super(continuation, context);
                Intrinsics.checkNotNull(continuation, "null cannot be cast to non-null type kotlin.coroutines.Continuation<kotlin.Any?>");
            }

            @Override
            protected Object invokeSuspend(Object result) throws Throwable {
                ResultKt.throwOnFailure(result);
                return result;
            }
        };
    }
}
