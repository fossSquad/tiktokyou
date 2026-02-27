package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.JvmInline;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bg\u0018\u0000 \u00062\u00020\u0001:\u0003\u0004\u0005\u0006J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0007"}, d2 = {"Lni/shikatu/kotlin/time/TimeSource;", "", "markNow", "Lni/shikatu/kotlin/time/TimeMark;", "WithComparableMarks", "Monotonic", "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public interface TimeSource {
    public static final Companion Companion = Companion.$$INSTANCE;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bg\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&¨\u0006\u0004"}, d2 = {"Lni/shikatu/kotlin/time/TimeSource$WithComparableMarks;", "Lni/shikatu/kotlin/time/TimeSource;", "markNow", "Lni/shikatu/kotlin/time/ComparableTimeMark;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public interface WithComparableMarks extends TimeSource {
        @Override
        ComparableTimeMark markNow();
    }

    TimeMark markNow();

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\nB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000f\u0010\u0004\u001a\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0016¨\u0006\u000b"}, d2 = {"Lni/shikatu/kotlin/time/TimeSource$Monotonic;", "Lni/shikatu/kotlin/time/TimeSource$WithComparableMarks;", "<init>", "()V", "markNow", "Lni/shikatu/kotlin/time/TimeSource$Monotonic$ValueTimeMark;", "markNow-z9LOYto", "()J", "toString", "", "ValueTimeMark", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Monotonic implements WithComparableMarks {
        public static final Monotonic INSTANCE = new Monotonic();

        private Monotonic() {
        }

        @Override
        public /* bridge */  ComparableTimeMark markNow() {
            return ValueTimeMark.m1472boximpl(m1471markNowz9LOYto());
        }

        @Override
        public /* bridge */  TimeMark markNow() {
            return ValueTimeMark.m1472boximpl(m1471markNowz9LOYto());
        }

        public long m1471markNowz9LOYto() {
            return MonotonicTimeSource.INSTANCE.m1466markNowz9LOYto();
        }

        public String toString() {
            return MonotonicTimeSource.INSTANCE.toString();
        }

        @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087@\u0018\u00002\u00020\u0001B\u0015\b\u0000\u0012\n\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004¢\u0006\u0004\b\u0005\u0010\u0006J\u000f\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0018\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\tH\u0096\u0002¢\u0006\u0004\b\u0010\u0010\u000eJ\u000f\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\u0012H\u0016¢\u0006\u0004\b\u0016\u0010\u0014J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0001H\u0096\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u0018\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001a\u0010\u000eJ\u0018\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u0017\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00122\b\u0010\u0017\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u001cHÖ\u0001J\t\u0010\"\u001a\u00020#HÖ\u0001R\u0014\u0010\u0002\u001a\u00060\u0003j\u0002`\u0004X\u0080\u0004¢\u0006\u0004\n\u0002\u0010\u0007\u0088\u0001\u0002\u0092\u0001\u00060\u0003j\u0002`\u0004¨\u0006$"}, d2 = {"Lni/shikatu/kotlin/time/TimeSource$Monotonic$ValueTimeMark;", "Lni/shikatu/kotlin/time/ComparableTimeMark;", "reading", "", "Lni/shikatu/kotlin/time/ValueTimeMarkReading;", "constructor-impl", "(J)J", "J", "elapsedNow", "Lni/shikatu/kotlin/time/Duration;", "elapsedNow-UwyO8pc", "plus", "duration", "plus-LRDsOJo", "(JJ)J", "minus", "minus-LRDsOJo", "hasPassedNow", "", "hasPassedNow-impl", "(J)Z", "hasNotPassedNow", "hasNotPassedNow-impl", "other", "minus-UwyO8pc", "(JLkotlin/time/ComparableTimeMark;)J", "minus-6eNON_k", "compareTo", "", "compareTo-6eNON_k", "(JJ)I", "equals", "", "hashCode", "toString", "", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
        @JvmInline
        public static final class ValueTimeMark implements ComparableTimeMark {
            private final long reading;

            public static final  ValueTimeMark m1472boximpl(long j) {
                return new ValueTimeMark(j);
            }

            public static long m1475constructorimpl(long j) {
                return j;
            }

            public static boolean m1477equalsimpl(long j, Object obj) {
                return (obj instanceof ValueTimeMark) && j == ((ValueTimeMark) obj).m1489unboximpl();
            }

            public static final boolean m1478equalsimpl0(long j, long j2) {
                return j == j2;
            }

            public static int m1481hashCodeimpl(long j) {
                return Long.hashCode(j);
            }

            public static String m1486toStringimpl(long j) {
                return "ValueTimeMark(reading=" + j + ')';
            }

            @Override
            public boolean equals(Object obj) {
                return m1477equalsimpl(this.reading, obj);
            }

            @Override
            public int hashCode() {
                return m1481hashCodeimpl(this.reading);
            }

            public String toString() {
                return m1486toStringimpl(this.reading);
            }

            public final  long m1489unboximpl() {
                return this.reading;
            }

            public static int m1474compareToimpl(long arg0, ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                return m1472boximpl(arg0).compareTo(other);
            }

            @Override
            public int compareTo(ComparableTimeMark other) {
                return ComparableTimeMark.DefaultImpls.compareTo(this, other);
            }

            @Override

            public /* bridge */  ComparableTimeMark mo1353minusLRDsOJo(long duration) {
                return m1472boximpl(m1487minusLRDsOJo(duration));
            }

            @Override

            public /* bridge */  TimeMark mo1353minusLRDsOJo(long duration) {
                return m1472boximpl(m1487minusLRDsOJo(duration));
            }

            @Override

            public /* bridge */  ComparableTimeMark mo1355plusLRDsOJo(long duration) {
                return m1472boximpl(m1488plusLRDsOJo(duration));
            }

            @Override

            public /* bridge */  TimeMark mo1355plusLRDsOJo(long duration) {
                return m1472boximpl(m1488plusLRDsOJo(duration));
            }

            private  ValueTimeMark(long reading) {
                this.reading = reading;
            }

            public static long m1476elapsedNowUwyO8pc(long arg0) {
                return MonotonicTimeSource.INSTANCE.m1465elapsedFrom6eNON_k(arg0);
            }

            @Override

            public long mo1352elapsedNowUwyO8pc() {
                return m1476elapsedNowUwyO8pc(this.reading);
            }

            public static long m1485plusLRDsOJo(long arg0, long duration) {
                return MonotonicTimeSource.INSTANCE.m1463adjustReading6QKq23U(arg0, duration);
            }

            public long m1488plusLRDsOJo(long duration) {
                return m1485plusLRDsOJo(this.reading, duration);
            }

            public static long m1483minusLRDsOJo(long arg0, long duration) {
                return MonotonicTimeSource.INSTANCE.m1463adjustReading6QKq23U(arg0, Duration.m1406unaryMinusUwyO8pc(duration));
            }

            public long m1487minusLRDsOJo(long duration) {
                return m1483minusLRDsOJo(this.reading, duration);
            }

            public static boolean m1480hasPassedNowimpl(long arg0) {
                return !Duration.m1388isNegativeimpl(m1476elapsedNowUwyO8pc(arg0));
            }

            @Override
            public boolean hasPassedNow() {
                return m1480hasPassedNowimpl(this.reading);
            }

            public static boolean m1479hasNotPassedNowimpl(long arg0) {
                return Duration.m1388isNegativeimpl(m1476elapsedNowUwyO8pc(arg0));
            }

            @Override
            public boolean hasNotPassedNow() {
                return m1479hasNotPassedNowimpl(this.reading);
            }

            @Override

            public long mo1354minusUwyO8pc(ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                return m1484minusUwyO8pc(this.reading, other);
            }

            public static long m1484minusUwyO8pc(long arg0, ComparableTimeMark other) {
                Intrinsics.checkNotNullParameter(other, "other");
                if (!(other instanceof ValueTimeMark)) {
                    throw new IllegalArgumentException("Subtracting or comparing time marks from different time sources is not possible: " + ((Object) m1486toStringimpl(arg0)) + " and " + other);
                }
                return m1482minus6eNON_k(arg0, ((ValueTimeMark) other).m1489unboximpl());
            }

            public static final long m1482minus6eNON_k(long arg0, long other) {
                return MonotonicTimeSource.INSTANCE.m1464differenceBetweenfRLX17w(arg0, other);
            }

            public static final int m1473compareTo6eNON_k(long arg0, long other) {
                return Duration.m1361compareToLRDsOJo(m1482minus6eNON_k(arg0, other), Duration.Companion.m1453getZEROUwyO8pc());
            }
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lni/shikatu/kotlin/time/TimeSource$Companion;", "", "<init>", "()V", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        static final  Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
