package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0002\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\f\u001a\u00020\u0004H\u0096\u0080\u0004¢\u0006\u0004\b\r\u0010\nJ\u0019\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u0004H\u0096\u0082\u0004¢\u0006\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0002\u001a\u00020\u0001X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0003\u001a\u00020\u0004X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\n¨\u0006\u0012"}, d2 = {"Lni/shikatu/kotlin/time/AdjustedTimeMark;", "Lni/shikatu/kotlin/time/TimeMark;", "mark", "adjustment", "Lni/shikatu/kotlin/time/Duration;", "<init>", "(Lkotlin/time/TimeMark;JLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getMark", "()Lkotlin/time/TimeMark;", "getAdjustment-UwyO8pc", "()J", "J", "elapsedNow", "elapsedNow-UwyO8pc", "plus", "duration", "plus-LRDsOJo", "(J)Lkotlin/time/TimeMark;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
final class AdjustedTimeMark implements TimeMark {
    private final long adjustment;
    private final TimeMark mark;

    public  AdjustedTimeMark(TimeMark timeMark, long j, DefaultConstructorMarker defaultConstructorMarker) {
        this(timeMark, j);
    }

    private AdjustedTimeMark(TimeMark mark, long adjustment) {
        Intrinsics.checkNotNullParameter(mark, "mark");
        this.mark = mark;
        this.adjustment = adjustment;
    }

    public final long m1377getAdjustmentUwyO8pc() {
        return this.adjustment;
    }

    public final TimeMark getMark() {
        return this.mark;
    }

    @Override
    public /* bridge */ boolean hasNotPassedNow() {
        return TimeMark.DefaultImpls.hasNotPassedNow(this);
    }

    @Override
    public /* bridge */ boolean hasPassedNow() {
        return TimeMark.DefaultImpls.hasPassedNow(this);
    }

    @Override

    public /* bridge */ TimeMark mo1374minusLRDsOJo(long duration) {
        return TimeMark.DefaultImpls.m1502minusLRDsOJo(this, duration);
    }

    @Override

    public long mo1373elapsedNowUwyO8pc() {
        return Duration.m1413minusLRDsOJo(this.mark.mo1373elapsedNowUwyO8pc(), this.adjustment);
    }

    @Override

    public TimeMark mo1376plusLRDsOJo(long duration) {
        return new AdjustedTimeMark(this.mark, Duration.m1414plusLRDsOJo(this.adjustment, duration), null);
    }
}
