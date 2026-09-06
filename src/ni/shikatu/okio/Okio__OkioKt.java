package ni.shikatu.okio;

import java.io.Closeable;
import ni.shikatu.kotlin.ExceptionsKt;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.InlineMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\n\u0010\u0000\u001a\u00020\u0003*\u00020\u0004\u001a\r\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0002\b\u0006\u001aN\u0010\u0007\u001a\u0002H\b\"\u0010\b\u0000\u0010\t*\n\u0018\u00010\nj\u0004\u0018\u0001`\u000b\"\u0004\b\u0001\u0010\b*\u0002H\t2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u0002H\t\u0012\u0004\u0012\u0002H\b0\rH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f"}, d2 = {"buffer", "Lni/shikatu/okio/BufferedSource;", "Lni/shikatu/okio/Source;", "Lni/shikatu/okio/BufferedSink;", "Lni/shikatu/okio/Sink;", "blackholeSink", "blackhole", "use", "R", "T", "Ljava/io/Closeable;", "Lni/shikatu/okio/Closeable;", "block", "Lni/shikatu/kotlin/Function1;", "(Ljava/io/Closeable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ni.shikatu.okio"}, k = 5, mv = {2, 2, 0}, xi = 48, xs = "ni/shikatu/okio/Okio")
final  class Okio__OkioKt {
    public static final BufferedSource buffer(Source $this$buffer) {
        Intrinsics.checkNotNullParameter($this$buffer, "<this>");
        return new RealBufferedSource($this$buffer);
    }

    public static final BufferedSink buffer(Sink $this$buffer) {
        Intrinsics.checkNotNullParameter($this$buffer, "<this>");
        return new RealBufferedSink($this$buffer);
    }

    public static final Sink blackhole() {
        return new BlackholeSink();
    }

    public static final <T extends Closeable, R> R use(T t, Function1<? super T, ? extends R> function1) throws Throwable {
        R rInvoke;
        Intrinsics.checkNotNullParameter(function1, "block");
        Throwable thrown = null;
        try {
            rInvoke = function1.invoke(t);
            InlineMarker.finallyStart(1);
            if (t != null) {
                try {
                    t.close();
                } catch (Throwable t2) {
                    thrown = t2;
                }
            }
            InlineMarker.finallyEnd(1);
        } catch (Throwable t3) {
            thrown = t3;
            InlineMarker.finallyStart(1);
            if (t != null) {
                try {
                    t.close();
                } catch (Throwable t4) {
                    ExceptionsKt.addSuppressed(thrown, t4);
                }
            }
            InlineMarker.finallyEnd(1);
            rInvoke = null;
        }
        if (thrown != null) {
            throw thrown;
        }
        return rInvoke;
    }
}
