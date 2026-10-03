package ni.shikatu.okhttp3.internal.concurrent;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.InlineMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.StringCompanionObject;
import ni.shikatu.kotlin.time.DurationKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000*\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\t\n\u0000\u001a.\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH\u0080\bø\u0001\u0000\u001a9\u0010\n\u001a\u0002H\u000b\"\u0004\b\u0000\u0010\u000b*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\u000b0\bH\u0080\bø\u0001\u0000¢\u0006\u0002\u0010\r\u001a$\u0010\u000e\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\tH\u0002\u001a\u000e\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0012\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"taskLog", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/util/logging/Logger;", "task", "Lni/shikatu/okhttp3/internal/concurrent/Task;", "queue", "Lni/shikatu/okhttp3/internal/concurrent/TaskQueue;", "messageBlock", "Lni/shikatu/kotlin/Function0;", _UrlKt.FRAGMENT_ENCODE_SET, "logElapsed", "T", "block", "(Ljava/util/logging/Logger;Lokhttp3/internal/concurrent/Task;Lokhttp3/internal/concurrent/TaskQueue;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "log", "message", "formatDuration", "ns", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class TaskLoggerKt {
    public static final void taskLog(Logger $this$taskLog, Task task, TaskQueue queue, Function0<String> function0) {
        Intrinsics.checkNotNullParameter($this$taskLog, "<this>");
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(queue, "queue");
        Intrinsics.checkNotNullParameter(function0, "messageBlock");
        if ($this$taskLog.isLoggable(Level.FINE)) {
            log($this$taskLog, task, queue, function0.invoke());
        }
    }

    public static final <T> T logElapsed(Logger $this$logElapsed, Task task, TaskQueue queue, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter($this$logElapsed, "<this>");
        Intrinsics.checkNotNullParameter(task, "task");
        Intrinsics.checkNotNullParameter(queue, "queue");
        Intrinsics.checkNotNullParameter(function0, "block");
        long startNs = -1;
        boolean loggingEnabled = $this$logElapsed.isLoggable(Level.FINE);
        if (loggingEnabled) {
            startNs = queue.getTaskRunner$okhttp().getBackend().nanoTime();
            log($this$logElapsed, task, queue, "starting");
        }
        try {
            T tInvoke = function0.invoke();
            InlineMarker.finallyStart(1);
            if (loggingEnabled) {
                log($this$logElapsed, task, queue, "finished run in " + formatDuration(queue.getTaskRunner$okhttp().getBackend().nanoTime() - startNs));
            }
            return tInvoke;
        } finally {
            InlineMarker.finallyStart(1);
            if (loggingEnabled) {
                long elapsedNs = queue.getTaskRunner$okhttp().getBackend().nanoTime() - startNs;
                if (0 != 0) {
                    log($this$logElapsed, task, queue, "finished run in " + formatDuration(elapsedNs));
                } else {
                    log($this$logElapsed, task, queue, "failed a run in " + formatDuration(elapsedNs));
                }
            }
            InlineMarker.finallyEnd(1);
        }
    }

    public static final void log(Logger $this$log, Task task, TaskQueue queue, String message) {
        StringBuilder sbAppend = new StringBuilder().append(queue.getName$okhttp()).append(' ');
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%-22s", Arrays.copyOf(new Object[]{message}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        $this$log.fine(sbAppend.append(str).append(": ").append(task.getName()).toString());
    }

    public static final String formatDuration(long ns) {
        String s;
        if (ns <= -999500000) {
            s = ((ns - ((long) 500000000)) / ((long) 1000000000)) + " s ";
        } else if (ns <= -999500) {
            s = ((ns - ((long) 500000)) / ((long) DurationKt.NANOS_IN_MILLIS)) + " ms";
        } else if (ns <= 0) {
            s = ((ns - ((long) 500)) / ((long) 1000)) + " µs";
        } else if (ns < 999500) {
            s = ((((long) 500) + ns) / ((long) 1000)) + " µs";
        } else {
            s = ns < 999500000 ? ((((long) 500000) + ns) / ((long) DurationKt.NANOS_IN_MILLIS)) + " ms" : ((((long) 500000000) + ns) / ((long) 1000000000)) + " s ";
        }
        StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
        String str = String.format("%6s", Arrays.copyOf(new Object[]{s}, 1));
        Intrinsics.checkNotNullExpressionValue(str, "format(...)");
        return str;
    }
}
