package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.JvmInline;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\bg\u0018\u0000 \u00062\u00020\u0001:\u0003\u0004\u0005\u0006J\n\u0010\u0002\u001a\u00020\u0003H¦\u0080\u0004Ê\u0001\f\b\b\u0012\b\b\t\u0012\u0004\b\b(\nÊ\u0001\u0010\b\u000b\u0012\f\b\f\u0012\b\b\fJ\u0004\b\t0\r¨\u0006\u0007"}, d2 = {"Lni/shikatu/kotlin/time/TimeSource;", _UrlKt.FRAGMENT_ENCODE_SET, "markNow", "Lni/shikatu/kotlin/time/TimeMark;", "WithComparableMarks", "Monotonic", "Companion", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.9", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/time/ExperimentalTime;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface TimeSource {
    public static final Companion Companion = ni.shikatu.kotlin.time.TimeSource.Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\bg\u0018\u00002\u00020\u0001J\n\u0010\u0002\u001a\u00020\u0003H¦\u0080\u0004Ê\u0001\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007Ê\u0001\u0010\b\b\u0012\f\b\t\u0012\b\b\fJ\u0004\b\t0\n¨\u0006\u0004"}, d2 = {"Lni/shikatu/kotlin/time/TimeSource$WithComparableMarks;", "Lni/shikatu/kotlin/time/TimeSource;", "markNow", "Lni/shikatu/kotlin/time/ComparableTimeMark;", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.9", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/time/ExperimentalTime;"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public interface WithComparableMarks extends TimeSource {
        @Override
        ComparableTimeMark markNow();
    }

    TimeMark markNow();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005H\u0096\u0080\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\b\u001a\u00020\tH\u0096\u0080\u0004¨\u0006\u000b"}, d2 = {"Lni/shikatu/kotlin/time/TimeSource$Monotonic;", "Lni/shikatu/kotlin/time/TimeSource$WithComparableMarks;", "<init>", "()V", "markNow", "Lni/shikatu/kotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "ValueTimeMark", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Monotonic implements WithComparableMarks {
        public static final Monotonic INSTANCE = new Monotonic();

        private Monotonic() {
        }

        @Override
        public long m1504markNowz9LOYto() {
            return MonotonicTimeSource.INSTANCE.m1499markNowz9LOYto();
        }

        public String toString() {
            return MonotonicTimeSource.INSTANCE.toString();
        }

        @Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\b\u0087@\u0018\u00002\u00020\u0001B\u0015\b@\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\b\u001a\u00020\tH\u0096\u0080\u0004¢\u0006\u0004\b\n\u0010\u0006J\u0019\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tH\u0096\u0082\u0004¢\u0006\u0004\b\r\u0010\u000eJ\u0019\u0010\u000f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tH\u0096\u0082\u0004¢\u0006\u0004\b\u0010\u0010\u000eJ\u0011\u0010\u0011\u001a\u00020\u0012H\u0096\u0080\u0004¢\u0006\u0004\b\u0013\u0010\u0014J\u0011\u0010\u0015\u001a\u00020\u0012H\u0096\u0080\u0004¢\u0006\u0004\b\u0016\u0010\u0014J\u0019\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0001H\u0096\u0082\u0004¢\u0006\u0004\b\u0018\u0010\u0019J\u0019\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b\u001a\u0010\u000eJ\u0019\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b\u001d\u0010\u001eJ\u0014\u0010\u001f\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010 HÖ\u0083\u0004J\n\u0010!\u001a\u00020\u001cHÖ\u0081\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004R\u0015\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0084\b¢\u0006\u0004\n\u0002\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00060\u0003j\u0002`\u0004Ê\u0001\f\b%\u0012\b\b&\u0012\u0004\b\b('Ê\u0001\u0010\b(\u0012\f\b)\u0012\b\b\fJ\u0004\b\t0*Ê\u0001\u0002\b+¨\u0006$"}, d2 = {"Lni/shikatu/kotlin/time/TimeSource$Monotonic$ValueTimeMark;", "Lni/shikatu/kotlin/time/ComparableTimeMark;", "reading", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/time/ValueTimeMarkReading;", "constructor-impl", "(J)J", "J", "elapsedNow", "Lni/shikatu/kotlin/time/Duration;", "elapsedNow-UwyO8pc", "plus", "duration", "plus-LRDsOJo", "(JJ)J", "minus", "minus-LRDsOJo", "hasPassedNow", _UrlKt.FRAGMENT_ENCODE_SET, "hasPassedNow-impl", "(J)Z", "hasNotPassedNow", "hasNotPassedNow-impl", "other", "minus-UwyO8pc", "(JLkotlin/time/ComparableTimeMark;)J", "minus-6eNON_k", "compareTo", _UrlKt.FRAGMENT_ENCODE_SET, "compareTo-6eNON_k", "(JJ)I", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.9", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/time/ExperimentalTime;", "Lni/shikatu/kotlin/jvm/JvmInline;"}, k = 1, mv = {2, 4, 0}, xi = 48)
        @JvmInline
        public static final class ValueTimeMark implements ComparableTimeMark {
            private final long reading;

            public static final  ValueTimeMark m1505boximpl(long j) {
                return new ValueTimeMark(j);
            }

            public static long m1508constructorimpl(long j) {
                return j;
            }

            public static boolean m1510equalsimpl(long j, Object obj) {
                return (obj instanceof ValueTimeMark) && j == ((ValueTimeMark) obj).m1522unboximpl();
            }

            public static final boolean m1511equalsimpl0(long j, long j2) {
                return j == j2;
            }

            public static int m1514hashCodeimpl(long j) {
                return Long.hashCode(j);
            }

            public static String m1519toStringimpl(long j) {
                return "ValueTimeMark(reading=" + j + ')';
            }

            @Override
            public boolean equals(Object obj) {
                return m1510equalsimpl(this.reading, obj);
            }

            @Override
            public int hashCode() {
                return m1514hashCodeimpl(this.reading);
            }

            public String toString() {
                return m1519toStringimpl(this.reading);
            }

            public final  long m1522unboximpl() {
                return this.reading;
            }

            public static int m1507compareToimpl(long arg0, ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                return m1505boximpl(arg0).compareTo(other);
            }

            @Override
            public /* bridge */ int compareTo(ComparableTimeMark other) {
                return ComparableTimeMark.DefaultImpls.compareTo(this, other);
            }


            private  ValueTimeMark(long reading) {
                this.reading = reading;
            }

            public static long m1509elapsedNowUwyO8pc(long arg0) {
                return MonotonicTimeSource.INSTANCE.m1498elapsedFrom6eNON_k(arg0);
            }

            @Override

            public long mo1373elapsedNowUwyO8pc() {
                return m1509elapsedNowUwyO8pc(this.reading);
            }

            public static long m1518plusLRDsOJo(long arg0, long duration) {
                return MonotonicTimeSource.INSTANCE.m1496adjustReading6QKq23U(arg0, duration);
            }

            public long m1521plusLRDsOJo(long duration) {
                return m1518plusLRDsOJo(this.reading, duration);
            }

            public static long m1516minusLRDsOJo(long arg0, long duration) {
                return MonotonicTimeSource.INSTANCE.m1496adjustReading6QKq23U(arg0, Duration.m1429unaryMinusUwyO8pc(duration));
            }

            public long m1520minusLRDsOJo(long duration) {
                return m1516minusLRDsOJo(this.reading, duration);
            }

            public static boolean m1513hasPassedNowimpl(long arg0) {
                return !Duration.m1411isNegativeimpl(m1509elapsedNowUwyO8pc(arg0));
            }

            @Override
            public boolean hasPassedNow() {
                return m1513hasPassedNowimpl(this.reading);
            }

            public static boolean m1512hasNotPassedNowimpl(long arg0) {
                return Duration.m1411isNegativeimpl(m1509elapsedNowUwyO8pc(arg0));
            }

            @Override
            public boolean hasNotPassedNow() {
                return m1512hasNotPassedNowimpl(this.reading);
            }

            @Override

            public long mo1375minusUwyO8pc(ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                return m1517minusUwyO8pc(this.reading, other);
            }

            public static long m1517minusUwyO8pc(long arg0, ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                if (!(other instanceof ValueTimeMark)) {
                    throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + ((Object) m1519toStringimpl(arg0)) + " and " + other);
                }
                return m1515minus6eNON_k(arg0, ((ValueTimeMark) other).m1522unboximpl());
            }

            public static final long m1515minus6eNON_k(long arg0, long other) {
                return MonotonicTimeSource.INSTANCE.m1497differenceBetweenfRLX17w(arg0, other);
            }

            public static final int m1506compareTo6eNON_k(long arg0, long other) {
                return Duration.m1384compareToLRDsOJo(m1515minus6eNON_k(arg0, other), Duration.Companion.m1480getZEROUwyO8pc());
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lni/shikatu/kotlin/time/TimeSource$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        static final  Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
