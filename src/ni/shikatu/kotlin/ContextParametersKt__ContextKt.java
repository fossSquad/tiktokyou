package ni.shikatu.kotlin;

import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.functions.Function3;
import ni.shikatu.kotlin.jvm.functions.Function4;
import ni.shikatu.kotlin.jvm.functions.Function5;
import ni.shikatu.kotlin.jvm.functions.Function6;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000D\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001ah\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0002\"\u0004\b\u0001\u0010\u00012\u0006\u0010\u0003\u001a\u0002H\u00022!\u0010\u0004\u001a\u001d\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\u0003\u0010\u0002H\u0087\u0088\u0004b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\b\u001a|\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u00012\u0006\u0010\u000f\u001a\u0002H\r2\u0006\u0010\u0010\u001a\u0002H\u000e2'\u0010\u0004\u001a#\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u00010\u0011¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\u0003\u0010\u0004H\u0087\u0088\u0004b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0003 \u0001¢\u0006\u0002\u0010\u0012\u001a\u0090\u0001\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u0013\"\u0004\b\u0003\u0010\u00012\u0006\u0010\u000f\u001a\u0002H\r2\u0006\u0010\u0010\u001a\u0002H\u000e2\u0006\u0010\u0014\u001a\u0002H\u00132-\u0010\u0004\u001a)\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00010\u0015¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\u0003\u0010\u0006H\u0087\u0088\u0004b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0004 \u0001¢\u0006\u0002\u0010\u0016\u001a¤\u0001\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u0013\"\u0004\b\u0003\u0010\u0017\"\u0004\b\u0004\u0010\u00012\u0006\u0010\u000f\u001a\u0002H\r2\u0006\u0010\u0010\u001a\u0002H\u000e2\u0006\u0010\u0014\u001a\u0002H\u00132\u0006\u0010\u0018\u001a\u0002H\u001723\u0010\u0004\u001a/\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u00010\u0019¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\u0003\u0010\bH\u0087\u0088\u0004b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0005 \u0001¢\u0006\u0002\u0010\u001a\u001a¸\u0001\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u0013\"\u0004\b\u0003\u0010\u0017\"\u0004\b\u0004\u0010\u001b\"\u0004\b\u0005\u0010\u00012\u0006\u0010\u000f\u001a\u0002H\r2\u0006\u0010\u0010\u001a\u0002H\u000e2\u0006\u0010\u0014\u001a\u0002H\u00132\u0006\u0010\u0018\u001a\u0002H\u00172\u0006\u0010\u001c\u001a\u0002H\u001b29\u0010\u0004\u001a5\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u00010\u001d¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\u0003\u0010\nH\u0087\u0088\u0004b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0006 \u0001¢\u0006\u0002\u0010\u001e\u001aÌ\u0001\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\r\"\u0004\b\u0001\u0010\u000e\"\u0004\b\u0002\u0010\u0013\"\u0004\b\u0003\u0010\u0017\"\u0004\b\u0004\u0010\u001b\"\u0004\b\u0005\u0010\u001f\"\u0004\b\u0006\u0010\u00012\u0006\u0010\u000f\u001a\u0002H\r2\u0006\u0010\u0010\u001a\u0002H\u000e2\u0006\u0010\u0014\u001a\u0002H\u00132\u0006\u0010\u0018\u001a\u0002H\u00172\u0006\u0010\u001c\u001a\u0002H\u001b2\u0006\u0010 \u001a\u0002H\u001f2?\u0010\u0004\u001a;\u0012\u0004\u0012\u0002H\r\u0012\u0004\u0012\u0002H\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u0017\u0012\u0004\u0012\u0002H\u001b\u0012\u0004\u0012\u0002H\u001f\u0012\u0004\u0012\u0002H\u00010!¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\u0003\u0010\fH\u0087\u0088\u0004b\u0002\b\tb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0007 \u0001¢\u0006\u0002\u0010\"\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, d2 = {"context", "R", "T", "with", "block", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/ContextFunctionTypeParams;", "count", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lni/shikatu/kotlin/internal/InlineOnly;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "2.2", "A", "B", "a", "b", "Lni/shikatu/kotlin/Function2;", "(Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "C", "c", "Lni/shikatu/kotlin/Function3;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "D", "d", "Lni/shikatu/kotlin/Function4;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "E", "e", "Lni/shikatu/kotlin/Function5;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "F", "f", "Lni/shikatu/kotlin/Function6;", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Lkotlin/jvm/functions/Function6;)Ljava/lang/Object;", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/ContextParametersKt")
class ContextParametersKt__ContextKt {
    private static final <T, R> R context(T t, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        return function1.invoke(t);
    }

    private static final <A, B, R> R context(A a, B b, Function2<? super A, ? super B, ? extends R> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        return function2.invoke(a, b);
    }

    private static final <A, B, C, R> R context(A a, B b, C c, Function3<? super A, ? super B, ? super C, ? extends R> function3) {
        Intrinsics.checkNotNullParameter(function3, "block");
        return function3.invoke(a, b, c);
    }

    private static final <A, B, C, D, R> R context(A a, B b, C c, D d, Function4<? super A, ? super B, ? super C, ? super D, ? extends R> function4) {
        Intrinsics.checkNotNullParameter(function4, "block");
        return function4.invoke(a, b, c, d);
    }

    private static final <A, B, C, D, E, R> R context(A a, B b, C c, D d, E e, Function5<? super A, ? super B, ? super C, ? super D, ? super E, ? extends R> function5) {
        Intrinsics.checkNotNullParameter(function5, "block");
        return function5.invoke(a, b, c, d, e);
    }

    private static final <A, B, C, D, E, F, R> R context(A a, B b, C c, D d, E e, F f, Function6<? super A, ? super B, ? super C, ? super D, ? super E, ? super F, ? extends R> function6) {
        Intrinsics.checkNotNullParameter(function6, "block");
        return function6.invoke(a, b, c, d, e, f);
    }
}
