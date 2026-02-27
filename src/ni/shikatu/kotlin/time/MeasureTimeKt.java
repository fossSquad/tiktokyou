package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a,\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0005\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\u0007\u001a0\u0010\u0000\u001a\u00020\u0001*\u00020\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0002\u0010\t\u001a3\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\f0\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a7\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f*\u00020\u00062\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\f0\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001a7\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\f0\u000b\"\u0004\b\u0000\u0010\f*\u00020\b2\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u0002H\f0\u0003H\u0087\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r"}, d2 = {"measureTime", "Lni/shikatu/kotlin/time/Duration;", "block", "Lni/shikatu/kotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)J", "Lni/shikatu/kotlin/time/TimeSource;", "(Lkotlin/time/TimeSource;Lkotlin/jvm/functions/Function0;)J", "Lni/shikatu/kotlin/time/TimeSource$Monotonic;", "(Lkotlin/time/TimeSource$Monotonic;Lkotlin/jvm/functions/Function0;)J", "measureTimedValue", "Lni/shikatu/kotlin/time/TimedValue;", "T", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class MeasureTimeKt {
    public static final long measureTime(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        TimeSource.Monotonic $this$measureTime$iv = TimeSource.Monotonic.INSTANCE;
        long mark$iv = $this$measureTime$iv.m1471markNowz9LOYto();
        function0.invoke();
        return TimeSource.Monotonic.ValueTimeMark.m1476elapsedNowUwyO8pc(mark$iv);
    }

    public static final long measureTime(TimeSource $this$measureTime, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter($this$measureTime, "<this>");
        Intrinsics.checkNotNullParameter(function0, "block");
        TimeMark mark = $this$measureTime.markNow();
        function0.invoke();
        return mark.mo1352elapsedNowUwyO8pc();
    }

    public static final long measureTime(TimeSource.Monotonic $this$measureTime, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter($this$measureTime, "<this>");
        Intrinsics.checkNotNullParameter(function0, "block");
        long mark = $this$measureTime.m1471markNowz9LOYto();
        function0.invoke();
        return TimeSource.Monotonic.ValueTimeMark.m1476elapsedNowUwyO8pc(mark);
    }

    public static final <T> TimedValue<T> measureTimedValue(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "block");
        TimeSource.Monotonic $this$measureTimedValue$iv = TimeSource.Monotonic.INSTANCE;
        long mark$iv = $this$measureTimedValue$iv.m1471markNowz9LOYto();
        Object result$iv = function0.invoke();
        return new TimedValue<>(result$iv, TimeSource.Monotonic.ValueTimeMark.m1476elapsedNowUwyO8pc(mark$iv), null);
    }

    public static final <T> TimedValue<T> measureTimedValue(TimeSource $this$measureTimedValue, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter($this$measureTimedValue, "<this>");
        Intrinsics.checkNotNullParameter(function0, "block");
        TimeMark mark = $this$measureTimedValue.markNow();
        Object result = function0.invoke();
        return new TimedValue<>(result, mark.mo1352elapsedNowUwyO8pc(), null);
    }

    public static final <T> TimedValue<T> measureTimedValue(TimeSource.Monotonic $this$measureTimedValue, Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter($this$measureTimedValue, "<this>");
        Intrinsics.checkNotNullParameter(function0, "block");
        long mark = $this$measureTimedValue.m1471markNowz9LOYto();
        Object result = function0.invoke();
        return new TimedValue<>(result, TimeSource.Monotonic.ValueTimeMark.m1476elapsedNowUwyO8pc(mark), null);
    }
}
