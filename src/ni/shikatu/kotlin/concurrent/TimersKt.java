package ni.shikatu.kotlin.concurrent;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a3\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a;\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a;\u0010\f\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a\u001a\u0010\r\u001a\u00020\u00022\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0001\u001aO\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001aM\u0010\r\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001aO\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001aM\u0010\u0014\u001a\u00020\u00022\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u001a'\u0010\u0015\u001a\u00020\u00012\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\u0002\b\bH\u0087\bø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016"}, d2 = {"schedule", "Ljava/util/TimerTask;", "Ljava/util/Timer;", "delay", "", "action", "Lni/shikatu/kotlin/Function1;", "", "Lni/shikatu/kotlin/ExtensionFunctionType;", "time", "Ljava/util/Date;", "period", "scheduleAtFixedRate", "timer", "name", "", "daemon", "", "initialDelay", "startAt", "fixedRateTimer", "timerTask", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class TimersKt {
    private static final TimerTask schedule(Timer $this$schedule, long delay, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$schedule, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        TimerTask task = new AnonymousClass1(function1);
        $this$schedule.schedule(task, delay);
        return task;
    }

    private static final TimerTask schedule(Timer $this$schedule, Date time, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$schedule, "<this>");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(function1, "action");
        TimerTask task = new AnonymousClass1(function1);
        $this$schedule.schedule(task, time);
        return task;
    }

    private static final TimerTask schedule(Timer $this$schedule, long delay, long period, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$schedule, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        TimerTask task = new AnonymousClass1(function1);
        $this$schedule.schedule(task, delay, period);
        return task;
    }

    private static final TimerTask schedule(Timer $this$schedule, Date time, long period, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$schedule, "<this>");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(function1, "action");
        TimerTask task = new AnonymousClass1(function1);
        $this$schedule.schedule(task, time, period);
        return task;
    }

    private static final TimerTask scheduleAtFixedRate(Timer $this$scheduleAtFixedRate, long delay, long period, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$scheduleAtFixedRate, "<this>");
        Intrinsics.checkNotNullParameter(function1, "action");
        TimerTask task = new AnonymousClass1(function1);
        $this$scheduleAtFixedRate.scheduleAtFixedRate(task, delay, period);
        return task;
    }

    private static final TimerTask scheduleAtFixedRate(Timer $this$scheduleAtFixedRate, Date time, long period, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$scheduleAtFixedRate, "<this>");
        Intrinsics.checkNotNullParameter(time, "time");
        Intrinsics.checkNotNullParameter(function1, "action");
        TimerTask task = new AnonymousClass1(function1);
        $this$scheduleAtFixedRate.scheduleAtFixedRate(task, time, period);
        return task;
    }

    public static final Timer timer(String name, boolean daemon) {
        return name == null ? new Timer(daemon) : new Timer(name, daemon);
    }

    static  Timer timer$default(String name, boolean daemon, long initialDelay, long period, Function1 action, int i, Object obj) {
        if ((i & 1) != 0) {
            name = null;
        }
        if ((i & 2) != 0) {
            daemon = false;
        }
        long initialDelay2 = (i & 4) != 0 ? 0L : initialDelay;
        Intrinsics.checkNotNullParameter(action, "action");
        Timer timer = timer(name, daemon);
        timer.schedule(new AnonymousClass1(action), initialDelay2, period);
        return timer;
    }

    private static final Timer timer(String name, boolean daemon, long initialDelay, long period, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        Timer timer = timer(name, daemon);
        timer.schedule(new AnonymousClass1(function1), initialDelay, period);
        return timer;
    }

    static  Timer timer$default(String name, boolean daemon, Date startAt, long period, Function1 action, int i, Object obj) {
        if ((i & 1) != 0) {
            name = null;
        }
        if ((i & 2) != 0) {
            daemon = false;
        }
        Intrinsics.checkNotNullParameter(startAt, "startAt");
        Intrinsics.checkNotNullParameter(action, "action");
        Timer timer = timer(name, daemon);
        timer.schedule(new AnonymousClass1(action), startAt, period);
        return timer;
    }

    private static final Timer timer(String name, boolean daemon, Date startAt, long period, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter(startAt, "startAt");
        Intrinsics.checkNotNullParameter(function1, "action");
        Timer timer = timer(name, daemon);
        timer.schedule(new AnonymousClass1(function1), startAt, period);
        return timer;
    }

    static  Timer fixedRateTimer$default(String name, boolean daemon, long initialDelay, long period, Function1 action, int i, Object obj) {
        if ((i & 1) != 0) {
            name = null;
        }
        if ((i & 2) != 0) {
            daemon = false;
        }
        long initialDelay2 = (i & 4) != 0 ? 0L : initialDelay;
        Intrinsics.checkNotNullParameter(action, "action");
        Timer timer = timer(name, daemon);
        timer.scheduleAtFixedRate(new AnonymousClass1(action), initialDelay2, period);
        return timer;
    }

    private static final Timer fixedRateTimer(String name, boolean daemon, long initialDelay, long period, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        Timer timer = timer(name, daemon);
        timer.scheduleAtFixedRate(new AnonymousClass1(function1), initialDelay, period);
        return timer;
    }

    static  Timer fixedRateTimer$default(String name, boolean daemon, Date startAt, long period, Function1 action, int i, Object obj) {
        if ((i & 1) != 0) {
            name = null;
        }
        if ((i & 2) != 0) {
            daemon = false;
        }
        Intrinsics.checkNotNullParameter(startAt, "startAt");
        Intrinsics.checkNotNullParameter(action, "action");
        Timer timer = timer(name, daemon);
        timer.scheduleAtFixedRate(new AnonymousClass1(action), startAt, period);
        return timer;
    }

    private static final Timer fixedRateTimer(String name, boolean daemon, Date startAt, long period, Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter(startAt, "startAt");
        Intrinsics.checkNotNullParameter(function1, "action");
        Timer timer = timer(name, daemon);
        timer.scheduleAtFixedRate(new AnonymousClass1(function1), startAt, period);
        return timer;
    }

    @Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"ni/shikatu/kotlin/concurrent/TimersKt$timerTask$1", "Ljava/util/TimerTask;", "run", "", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 176)
    public static final class AnonymousClass1 extends TimerTask {
        final  Function1<TimerTask, Unit> $action;

        public AnonymousClass1(Function1<? super TimerTask, Unit> function1) {
            this.$action = function1;
        }

        @Override
        public void run() {
            this.$action.invoke(this);
        }
    }

    private static final TimerTask timerTask(Function1<? super TimerTask, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "action");
        return new AnonymousClass1(function1);
    }
}
