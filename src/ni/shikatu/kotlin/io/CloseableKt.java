package ni.shikatu.kotlin.io;

import java.io.Closeable;
import java.io.IOException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.internal.PlatformImplementationsKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.InlineMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\u001aH\u0010\u0000\u001a\u0002H\u0001\"\n\b\u0000\u0010\u0002*\u0004\u0018\u00010\u0003\"\u0004\b\u0001\u0010\u0001*\u0002H\u00022\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u0002H\u00010\u0005H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0006\u001a\u0018\u0010\u0007\u001a\u00020\b*\u0004\u0018\u00010\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000b"}, d2 = {"use", "R", "T", "Ljava/io/Closeable;", "block", "Lni/shikatu/kotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "closeFinally", "", "cause", "", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class CloseableKt {
    private static final <T extends Closeable, R> R use(T t, Function1<? super T, ? extends R> function1) throws IOException {
        Intrinsics.checkNotNullParameter(function1, "block");
        try {
            R rInvoke = function1.invoke(t);
            InlineMarker.finallyStart(1);
            if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                closeFinally(t, null);
            } else if (t != null) {
                t.close();
            }
            InlineMarker.finallyEnd(1);
            return rInvoke;
        } catch (Throwable e) {
            try {
                throw e;
            } catch (Throwable e2) {
                InlineMarker.finallyStart(1);
                if (PlatformImplementationsKt.apiVersionIsAtLeast(1, 1, 0)) {
                    closeFinally(t, e);
                } else if (t != null) {
                    try {
                        t.close();
                    } catch (Throwable th) {
                    }
                }
                InlineMarker.finallyEnd(1);
                throw e2;
            }
        }
    }

    public static final void closeFinally(Closeable $this$closeFinally, Throwable cause) throws IOException {
        if ($this$closeFinally != null) {
            if (cause == null) {
                $this$closeFinally.close();
                return;
            }
            try {
                $this$closeFinally.close();
            } catch (Throwable closeException) {
                ni.shikatu.kotlin.ExceptionsKt.addSuppressed(cause, closeException);
            }
        }
    }
}
