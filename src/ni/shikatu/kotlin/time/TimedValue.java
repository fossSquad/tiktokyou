package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0017\u0012\u0006\u0010\u0003\u001a\u00028\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000e\u0010\u000e\u001a\u00028\u0000HÆ\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\u000f\u001a\u00020\u0005HÆ\u0003¢\u0006\u0004\b\u0010\u0010\fJ*\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0002HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\n\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\r\u001a\u0004\b\u000b\u0010\f¨\u0006\u001b"}, d2 = {"Lni/shikatu/kotlin/time/TimedValue;", "T", "", "value", "duration", "Lni/shikatu/kotlin/time/Duration;", "<init>", "(Ljava/lang/Object;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getDuration-UwyO8pc", "()J", "J", "component1", "component2", "component2-UwyO8pc", "copy", "copy-RFiDyg4", "(Ljava/lang/Object;J)Lkotlin/time/TimedValue;", "equals", "", "other", "hashCode", "", "toString", "", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class TimedValue<T> {
    private final long duration;
    private final T value;

    public  TimedValue(Object obj, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, j);
    }

    public static  TimedValue m1490copyRFiDyg4$default(TimedValue timedValue, Object obj, long j, int i, Object obj2) {
        if ((i & 1) != 0) {
            obj = timedValue.value;
        }
        if ((i & 2) != 0) {
            j = timedValue.duration;
        }
        return timedValue.m1492copyRFiDyg4(obj, j);
    }

    public final T component1() {
        return this.value;
    }

    public final long m1491component2UwyO8pc() {
        return this.duration;
    }

    public final TimedValue<T> m1492copyRFiDyg4(T t, long j) {
        return new TimedValue<>(t, j, null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TimedValue)) {
            return false;
        }
        TimedValue timedValue = (TimedValue) obj;
        return Intrinsics.areEqual(this.value, timedValue.value) && Duration.m1367equalsimpl0(this.duration, timedValue.duration);
    }

    public int hashCode() {
        return ((this.value == null ? 0 : this.value.hashCode()) * 31) + Duration.m1383hashCodeimpl(this.duration);
    }

    public String toString() {
        return "TimedValue(value=" + this.value + ", duration=" + ((Object) Duration.m1402toStringimpl(this.duration)) + ')';
    }

    private TimedValue(T t, long duration) {
        this.value = t;
        this.duration = duration;
    }

    public final long m1493getDurationUwyO8pc() {
        return this.duration;
    }

    public final T getValue() {
        return this.value;
    }
}
