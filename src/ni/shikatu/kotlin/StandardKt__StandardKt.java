package ni.shikatu.kotlin;

import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0010\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u000e\u0010\u0000\u001a\u00020\u0001H\u0087\u0088\u0004b\u0002\b\u0002\u001a\u0016\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\u0002\b\u0002\u001a;\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u0002H\u00060\bH\u0087\u0088\bb\u0002\b\u0002b\u0002\b\nø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\t\u001aP\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0006*\u0002H\u000b2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u00060\f¢\u0006\u0002\b\rH\u0087\u0088\bb\u0002\b\u0002b\u0002\b\nø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e\u001aT\u0010\u000f\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u00062\u0006\u0010\u0010\u001a\u0002H\u000b2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u00060\f¢\u0006\u0002\b\rH\u0087\u0088\bb\u0002\b\u0002b\u0002\b\nø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u0010\u000e\u001aJ\u0010\u0011\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\u0002H\u000b2\u0017\u0010\u0007\u001a\u0013\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00120\f¢\u0006\u0002\b\rH\u0087\u0088\bb\u0002\b\u0002b\u0002\b\nø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e\u001aS\u0010\u0013\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\u0002H\u000b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u00120\fH\u0087\u0088\bb\u0002\b\u0002b\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016b\u0002\b\nø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e\u001aK\u0010\u0017\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u000b\"\u0004\b\u0001\u0010\u0006*\u0002H\u000b2\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\u00060\fH\u0087\u0088\bb\u0002\b\u0002b\u0002\b\nø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e\u001aQ\u0010\u0018\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b*\u0002H\u000b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u001a0\fH\u0087\u0088\u0004b\u0002\b\u0002b\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e\u001aQ\u0010\u001b\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b*\u0002H\u000b2\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u00020\u001a0\fH\u0087\u0088\u0004b\u0002\b\u0002b\f\b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e\u001a8\u0010\u001c\u001a\u00020\u00122\u0006\u0010\u001d\u001a\u00020\u001e2\u0012\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00120\fH\u0087\u0088\u0004b\u0002\b\u0002ø\u0001\u0000\u0082\u0002\b\n\u0006\b\u0001\u0012\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006 "}, d2 = {"TODO", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/internal/InlineOnly;", "reason", _UrlKt.FRAGMENT_ENCODE_SET, "run", "R", "block", "Lni/shikatu/kotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lni/shikatu/kotlin/IgnorableReturnValue;", "T", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "with", "receiver", "apply", _UrlKt.FRAGMENT_ENCODE_SET, "also", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1", "let", "takeIf", "predicate", _UrlKt.FRAGMENT_ENCODE_SET, "takeUnless", "repeat", "times", _UrlKt.FRAGMENT_ENCODE_SET, "action", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/StandardKt")
class StandardKt__StandardKt {
    private static final Void TODO() {
        throw new NotImplementedError(null, 1, null);
    }

    private static final Void TODO(String reason) {
        Intrinsics.checkNotNullParameter(reason, "reason");
        throw new NotImplementedError("An operation is not implemented: " + reason);
    }

    @IgnorableReturnValue
    private static final <R> R run(Function0<? extends R> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        return function0.invoke();
    }

    @IgnorableReturnValue
    private static final <T, R> R run(T t, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        return function1.invoke(t);
    }

    @IgnorableReturnValue
    private static final <T, R> R with(T t, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        return function1.invoke(t);
    }

    @IgnorableReturnValue
    private static final <T> T apply(T t, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        function1.invoke(t);
        return t;
    }

    @IgnorableReturnValue
    private static final <T> T also(T t, Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        function1.invoke(t);
        return t;
    }

    @IgnorableReturnValue
    private static final <T, R> R let(T t, Function1<? super T, ? extends R> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        return function1.invoke(t);
    }

    private static final <T> T takeIf(T t, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (function1.invoke(t).booleanValue()) {
            return t;
        }
        return null;
    }

    private static final <T> T takeUnless(T t, Function1<? super T, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "predicate");
        if (function1.invoke(t).booleanValue()) {
            return null;
        }
        return t;
    }

    private static final void repeat(int times, Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        for (int index = 0; index < times; index++) {
            function1.invoke(Integer.valueOf(index));
        }
    }
}
