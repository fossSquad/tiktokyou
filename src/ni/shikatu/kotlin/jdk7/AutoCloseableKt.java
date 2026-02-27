package ni.shikatu.kotlin.jdk7;

import ni.shikatu.kotlin.ExceptionsKt;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.InlineMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000.\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\u001a \u0010\u0000\u001a\u00060\u0001j\u0002`\u00052\u000e\b\u0004\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0087\bø\u0001\u0000\u001aN\u0010\t\u001a\u0002H\n\"\u0010\b\u0000\u0010\u000b*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0005\"\u0004\b\u0001\u0010\n*\u0002H\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\u000b\u0012\u0004\u0012\u0002H\n0\rH\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e\u001a\u001e\u0010\u000f\u001a\u00020\b*\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0001*\u001a\b\u0007\u0010\u0000\"\u00020\u00012\u00020\u0001B\f\b\u0002\u0012\b\b\u0003\u0012\u0004\b\b(\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"AutoCloseable", "Ljava/lang/AutoCloseable;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "2.0", "Lni/shikatu/kotlin/AutoCloseable;", "closeAction", "Lni/shikatu/kotlin/Function0;", "", "use", "R", "T", "block", "Lni/shikatu/kotlin/Function1;", "(Ljava/lang/AutoCloseable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "closeFinally", "cause", "", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, pn = "ni.shikatu.kotlin", xi = 48)
public final class AutoCloseableKt {
    public static  void AutoCloseable$annotations() {
    }

    private static final AutoCloseable AutoCloseable(final Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "closeAction");
        return new AutoCloseable() {
            @Override
            public final void close() {
                function0.invoke();
            }
        };
    }

    private static final <T extends AutoCloseable, R> R use(T t, Function1<? super T, ? extends R> function1) throws Exception {
        Intrinsics.checkNotNullParameter(function1, "block");
        try {
            R rInvoke = function1.invoke(t);
            InlineMarker.finallyStart(1);
            closeFinally(t, null);
            InlineMarker.finallyEnd(1);
            return rInvoke;
        } catch (Throwable e) {
            try {
                throw e;
            } catch (Throwable e2) {
                InlineMarker.finallyStart(1);
                closeFinally(t, e);
                InlineMarker.finallyEnd(1);
                throw e2;
            }
        }
    }

    public static final void closeFinally(AutoCloseable $this$closeFinally, Throwable cause) throws Exception {
        if ($this$closeFinally != null) {
            if (cause == null) {
                AutoCloseableKt$$ExternalSyntheticAutoCloseableDispatcher0.m($this$closeFinally);
                return;
            }
            try {
                AutoCloseableKt$$ExternalSyntheticAutoCloseableDispatcher0.m($this$closeFinally);
            } catch (Throwable closeException) {
                ExceptionsKt.addSuppressed(cause, closeException);
            }
        }
    }
}
