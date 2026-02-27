package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.comparisons.ComparisonsKt;
import ni.shikatu.kotlin.jvm.JvmInline;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.functions.Function3;
import ni.shikatu.kotlin.jvm.functions.Function4;
import ni.shikatu.kotlin.jvm.functions.Function5;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.LongCompanionObject;
import ni.shikatu.kotlin.math.MathKt;
import ni.shikatu.kotlin.ranges.LongRange;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 \u0089\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0089\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\f\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u0010\u0010\u0016\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u0017\u0010\u0005J\u0018\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u001f\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u001f\u0010 J\u0018\u0010!\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b\"\u0010\u001bJ\u0018\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b%\u0010&J\u0018\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020'H\u0086\u0002¢\u0006\u0004\b%\u0010(J\u0018\u0010)\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\tH\u0086\u0002¢\u0006\u0004\b*\u0010&J\u0018\u0010)\u001a\u00020\u00002\u0006\u0010$\u001a\u00020'H\u0086\u0002¢\u0006\u0004\b*\u0010(J\u0018\u0010)\u001a\u00020'2\u0006\u0010\u0019\u001a\u00020\u0000H\u0086\u0002¢\u0006\u0004\b+\u0010,J\u0017\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0013H\u0000¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\r¢\u0006\u0004\b2\u0010\u000fJ\r\u00103\u001a\u00020\r¢\u0006\u0004\b4\u0010\u000fJ\r\u00105\u001a\u00020\r¢\u0006\u0004\b6\u0010\u000fJ\r\u00107\u001a\u00020\r¢\u0006\u0004\b8\u0010\u000fJ\u0018\u0010;\u001a\u00020\t2\u0006\u0010\u0019\u001a\u00020\u0000H\u0096\u0002¢\u0006\u0004\b<\u0010=J\u009d\u0001\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?2u\u0010@\u001aq\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(E\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0AH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010JJ\u0088\u0001\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?2`\u0010@\u001a\\\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(E\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0KH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010LJs\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?2K\u0010@\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(F\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0MH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010NJ^\u0010>\u001a\u0002H?\"\u0004\b\u0000\u0010?26\u0010@\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(G\u0012\u0013\u0012\u00110\t¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(H\u0012\u0004\u0012\u0002H?0OH\u0086\bø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bI\u0010PJ\u0015\u0010^\u001a\u00020'2\u0006\u0010.\u001a\u00020\u0013¢\u0006\u0004\b_\u0010`J\u0015\u0010a\u001a\u00020\u00032\u0006\u0010.\u001a\u00020\u0013¢\u0006\u0004\bb\u00100J\u0015\u0010c\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0013¢\u0006\u0004\bd\u0010eJ\u000f\u0010t\u001a\u00020uH\u0016¢\u0006\u0004\bv\u0010wJA\u0010x\u001a\u00020y*\u00060zj\u0002`{2\u0006\u0010|\u001a\u00020\t2\u0006\u0010}\u001a\u00020\t2\u0006\u0010~\u001a\u00020\t2\u0006\u0010.\u001a\u00020u2\u0006\u0010\u007f\u001a\u00020\rH\u0002¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J!\u0010t\u001a\u00020u2\u0006\u0010.\u001a\u00020\u00132\t\b\u0002\u0010\u0082\u0001\u001a\u00020\t¢\u0006\u0005\bv\u0010\u0083\u0001J\u000f\u0010\u0084\u0001\u001a\u00020u¢\u0006\u0005\b\u0085\u0001\u0010wJ\u0015\u0010\u0086\u0001\u001a\u00020\r2\t\u0010\u0019\u001a\u0005\u0018\u00010\u0087\u0001HÖ\u0003J\n\u0010\u0088\u0001\u001a\u00020\tHÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00038BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0015\u0010\b\u001a\u00020\t8Â\u0002X\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\u0012\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0011\u00109\u001a\u00020\u00008F¢\u0006\u0006\u001a\u0004\b:\u0010\u0005R\u001a\u0010Q\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\bR\u0010S\u001a\u0004\bT\u0010\u000bR\u001a\u0010U\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\bV\u0010S\u001a\u0004\bW\u0010\u000bR\u001a\u0010X\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\bY\u0010S\u001a\u0004\bZ\u0010\u000bR\u001a\u0010[\u001a\u00020\t8@X\u0081\u0004¢\u0006\f\u0012\u0004\b\\\u0010S\u001a\u0004\b]\u0010\u000bR\u0011\u0010f\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bg\u0010\u0005R\u0011\u0010h\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bi\u0010\u0005R\u0011\u0010j\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bk\u0010\u0005R\u0011\u0010l\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bm\u0010\u0005R\u0011\u0010n\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bo\u0010\u0005R\u0011\u0010p\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bq\u0010\u0005R\u0011\u0010r\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\bs\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u008a\u0001"}, d2 = {"Lni/shikatu/kotlin/time/Duration;", "", "rawValue", "", "constructor-impl", "(J)J", "value", "getValue-impl", "unitDiscriminator", "", "getUnitDiscriminator-impl", "(J)I", "isInNanos", "", "isInNanos-impl", "(J)Z", "isInMillis", "isInMillis-impl", "storageUnit", "Lni/shikatu/kotlin/time/DurationUnit;", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "unaryMinus", "unaryMinus-UwyO8pc", "plus", "other", "plus-LRDsOJo", "(JJ)J", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "minus", "minus-LRDsOJo", "times", "scale", "times-UwyO8pc", "(JI)J", "", "(JD)J", "div", "div-UwyO8pc", "div-LRDsOJo", "(JJ)D", "truncateTo", "unit", "truncateTo-UwyO8pc$kotlin_stdlib", "(JLkotlin/time/DurationUnit;)J", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "isInfinite", "isInfinite-impl", "isFinite", "isFinite-impl", "absoluteValue", "getAbsoluteValue-UwyO8pc", "compareTo", "compareTo-LRDsOJo", "(JJ)I", "toComponents", "T", "action", "Lni/shikatu/kotlin/Function5;", "Lni/shikatu/kotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lni/shikatu/kotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lni/shikatu/kotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lni/shikatu/kotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "hoursComponent", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "toDouble", "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toLong", "toLong-impl", "toInt", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "inWholeDays", "getInWholeDays-impl", "inWholeHours", "getInWholeHours-impl", "inWholeMinutes", "getInWholeMinutes-impl", "inWholeSeconds", "getInWholeSeconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds-impl", "inWholeMicroseconds", "getInWholeMicroseconds-impl", "inWholeNanoseconds", "getInWholeNanoseconds-impl", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "appendFractional", "", "Ljava/lang/StringBuilder;", "Lni/shikatu/kotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "toIsoString", "toIsoString-impl", "equals", "", "hashCode", "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@JvmInline
public final class Duration implements Comparable<Duration> {
    private final long rawValue;
    public static final Companion Companion = new Companion(null);
    private static final long ZERO = m1362constructorimpl(0);
    private static final long INFINITE = DurationKt.durationOfMillis(DurationKt.MAX_MILLIS);
    private static final long NEG_INFINITE = DurationKt.durationOfMillis(-4611686018427387903L);

    public static final  Duration m1360boximpl(long j) {
        return new Duration(j);
    }

    public static boolean m1366equalsimpl(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).m1408unboximpl();
    }

    public static final boolean m1367equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static  void getHoursComponent$annotations() {
    }

    public static  void getMinutesComponent$annotations() {
    }

    public static  void getNanosecondsComponent$annotations() {
    }

    public static  void getSecondsComponent$annotations() {
    }

    public static int m1383hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m1366equalsimpl(this.rawValue, obj);
    }

    public int hashCode() {
        return m1383hashCodeimpl(this.rawValue);
    }

    public final  long m1408unboximpl() {
        return this.rawValue;
    }

    @Override
    public /* bridge */  int compareTo(Duration duration) {
        return m1407compareToLRDsOJo(duration.m1408unboximpl());
    }

    private  Duration(long rawValue) {
        this.rawValue = rawValue;
    }

    private static final long m1382getValueimpl(long arg0) {
        return arg0 >> 1;
    }

    private static final int m1381getUnitDiscriminatorimpl(long arg0) {
        return ((int) arg0) & 1;
    }

    private static final boolean m1386isInNanosimpl(long arg0) {
        return (((int) arg0) & 1) == 0;
    }

    private static final boolean m1385isInMillisimpl(long arg0) {
        return (((int) arg0) & 1) == 1;
    }

    private static final DurationUnit m1380getStorageUnitimpl(long arg0) {
        return m1386isInNanosimpl(arg0) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    public static long m1362constructorimpl(long rawValue) {
        if (DurationJvmKt.getDurationAssertionsEnabled()) {
            if (m1386isInNanosimpl(rawValue)) {
                long jM1382getValueimpl = m1382getValueimpl(rawValue);
                if (!(-4611686018426999999L <= jM1382getValueimpl && jM1382getValueimpl < 4611686018427000000L)) {
                    throw new AssertionError(m1382getValueimpl(rawValue) + " ns is out of nanoseconds range");
                }
            } else {
                long jM1382getValueimpl2 = m1382getValueimpl(rawValue);
                if (!(-4611686018427387903L <= jM1382getValueimpl2 && jM1382getValueimpl2 < 4611686018427387904L)) {
                    throw new AssertionError(m1382getValueimpl(rawValue) + " ms is out of milliseconds range");
                }
                long jM1382getValueimpl3 = m1382getValueimpl(rawValue);
                if (-4611686018426L <= jM1382getValueimpl3 && jM1382getValueimpl3 < 4611686018427L) {
                    throw new AssertionError(m1382getValueimpl(rawValue) + " ms is denormalized");
                }
            }
        }
        return rawValue;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H\u0007J\u0015\u00100\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u000201¢\u0006\u0004\b2\u00103J\u0015\u00104\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u000201¢\u0006\u0004\b5\u00103J\u0015\u00106\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u000201¢\u0006\u0002\b7J\u0015\u00108\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000f\u001a\u000201¢\u0006\u0002\b9R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0016\u0010\u000b\u001a\u00020\u0005X\u0080\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u001f\u0010\u0013\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018R\u001f\u0010\u0013\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u001a\u001a\u0004\b\u0017\u0010\u001bR\u001f\u0010\u0013\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u001c\u001a\u0004\b\u0017\u0010\u001dR\u001f\u0010\u001e\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u0016\u001a\u0004\b \u0010\u0018R\u001f\u0010\u001e\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u001a\u001a\u0004\b \u0010\u001bR\u001f\u0010\u001e\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u001f\u0010\u001c\u001a\u0004\b \u0010\u001dR\u001f\u0010!\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u0016\u001a\u0004\b#\u0010\u0018R\u001f\u0010!\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u001a\u001a\u0004\b#\u0010\u001bR\u001f\u0010!\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\"\u0010\u001c\u001a\u0004\b#\u0010\u001dR\u001f\u0010$\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u0016\u001a\u0004\b&\u0010\u0018R\u001f\u0010$\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u001a\u001a\u0004\b&\u0010\u001bR\u001f\u0010$\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b%\u0010\u001c\u001a\u0004\b&\u0010\u001dR\u001f\u0010'\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u0016\u001a\u0004\b)\u0010\u0018R\u001f\u0010'\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u001a\u001a\u0004\b)\u0010\u001bR\u001f\u0010'\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b(\u0010\u001c\u001a\u0004\b)\u0010\u001dR\u001f\u0010*\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u0016\u001a\u0004\b,\u0010\u0018R\u001f\u0010*\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u001a\u001a\u0004\b,\u0010\u001bR\u001f\u0010*\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b+\u0010\u001c\u001a\u0004\b,\u0010\u001dR\u001f\u0010-\u001a\u00020\u0005*\u00020\u00148Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\u0016\u001a\u0004\b/\u0010\u0018R\u001f\u0010-\u001a\u00020\u0005*\u00020\u00198Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\u001a\u001a\u0004\b/\u0010\u001bR\u001f\u0010-\u001a\u00020\u0005*\u00020\u000e8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b.\u0010\u001c\u001a\u0004\b/\u0010\u001d¨\u0006:"}, d2 = {"Lni/shikatu/kotlin/time/Duration$Companion;", "", "<init>", "()V", "ZERO", "Lni/shikatu/kotlin/time/Duration;", "getZERO-UwyO8pc", "()J", "J", "INFINITE", "getINFINITE-UwyO8pc", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "convert", "", "value", "sourceUnit", "Lni/shikatu/kotlin/time/DurationUnit;", "targetUnit", "nanoseconds", "", "getNanoseconds-UwyO8pc$annotations", "(I)V", "getNanoseconds-UwyO8pc", "(I)J", "", "(J)V", "(J)J", "(D)V", "(D)J", "microseconds", "getMicroseconds-UwyO8pc$annotations", "getMicroseconds-UwyO8pc", "milliseconds", "getMilliseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", "seconds", "getSeconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "minutes", "getMinutes-UwyO8pc$annotations", "getMinutes-UwyO8pc", "hours", "getHours-UwyO8pc$annotations", "getHours-UwyO8pc", "days", "getDays-UwyO8pc$annotations", "getDays-UwyO8pc", "parse", "", "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseOrNull", "parseOrNull-FghU774", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static  void m1412getDaysUwyO8pc$annotations(double d) {
        }

        public static  void m1413getDaysUwyO8pc$annotations(int i) {
        }

        public static  void m1414getDaysUwyO8pc$annotations(long j) {
        }

        public static  void m1418getHoursUwyO8pc$annotations(double d) {
        }

        public static  void m1419getHoursUwyO8pc$annotations(int i) {
        }

        public static  void m1420getHoursUwyO8pc$annotations(long j) {
        }

        public static  void m1424getMicrosecondsUwyO8pc$annotations(double d) {
        }

        public static  void m1425getMicrosecondsUwyO8pc$annotations(int i) {
        }

        public static  void m1426getMicrosecondsUwyO8pc$annotations(long j) {
        }

        public static  void m1430getMillisecondsUwyO8pc$annotations(double d) {
        }

        public static  void m1431getMillisecondsUwyO8pc$annotations(int i) {
        }

        public static  void m1432getMillisecondsUwyO8pc$annotations(long j) {
        }

        public static  void m1436getMinutesUwyO8pc$annotations(double d) {
        }

        public static  void m1437getMinutesUwyO8pc$annotations(int i) {
        }

        public static  void m1438getMinutesUwyO8pc$annotations(long j) {
        }

        public static  void m1442getNanosecondsUwyO8pc$annotations(double d) {
        }

        public static  void m1443getNanosecondsUwyO8pc$annotations(int i) {
        }

        public static  void m1444getNanosecondsUwyO8pc$annotations(long j) {
        }

        public static  void m1448getSecondsUwyO8pc$annotations(double d) {
        }

        public static  void m1449getSecondsUwyO8pc$annotations(int i) {
        }

        public static  void m1450getSecondsUwyO8pc$annotations(long j) {
        }

        private Companion() {
        }

        public final long m1453getZEROUwyO8pc() {
            return Duration.ZERO;
        }

        public final long m1451getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        public final long m1452getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.NEG_INFINITE;
        }

        public final double convert(double value, DurationUnit sourceUnit, DurationUnit targetUnit) {
            Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
            Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
            return DurationUnitKt.convertDurationUnit(value, sourceUnit, targetUnit);
        }

        private final long m1440getNanosecondsUwyO8pc(int $this$nanoseconds) {
            return DurationKt.toDuration($this$nanoseconds, DurationUnit.NANOSECONDS);
        }

        private final long m1441getNanosecondsUwyO8pc(long $this$nanoseconds) {
            return DurationKt.toDuration($this$nanoseconds, DurationUnit.NANOSECONDS);
        }

        private final long m1439getNanosecondsUwyO8pc(double $this$nanoseconds) {
            return DurationKt.toDuration($this$nanoseconds, DurationUnit.NANOSECONDS);
        }

        private final long m1422getMicrosecondsUwyO8pc(int $this$microseconds) {
            return DurationKt.toDuration($this$microseconds, DurationUnit.MICROSECONDS);
        }

        private final long m1423getMicrosecondsUwyO8pc(long $this$microseconds) {
            return DurationKt.toDuration($this$microseconds, DurationUnit.MICROSECONDS);
        }

        private final long m1421getMicrosecondsUwyO8pc(double $this$microseconds) {
            return DurationKt.toDuration($this$microseconds, DurationUnit.MICROSECONDS);
        }

        private final long m1428getMillisecondsUwyO8pc(int $this$milliseconds) {
            return DurationKt.toDuration($this$milliseconds, DurationUnit.MILLISECONDS);
        }

        private final long m1429getMillisecondsUwyO8pc(long $this$milliseconds) {
            return DurationKt.toDuration($this$milliseconds, DurationUnit.MILLISECONDS);
        }

        private final long m1427getMillisecondsUwyO8pc(double $this$milliseconds) {
            return DurationKt.toDuration($this$milliseconds, DurationUnit.MILLISECONDS);
        }

        private final long m1446getSecondsUwyO8pc(int $this$seconds) {
            return DurationKt.toDuration($this$seconds, DurationUnit.SECONDS);
        }

        private final long m1447getSecondsUwyO8pc(long $this$seconds) {
            return DurationKt.toDuration($this$seconds, DurationUnit.SECONDS);
        }

        private final long m1445getSecondsUwyO8pc(double $this$seconds) {
            return DurationKt.toDuration($this$seconds, DurationUnit.SECONDS);
        }

        private final long m1434getMinutesUwyO8pc(int $this$minutes) {
            return DurationKt.toDuration($this$minutes, DurationUnit.MINUTES);
        }

        private final long m1435getMinutesUwyO8pc(long $this$minutes) {
            return DurationKt.toDuration($this$minutes, DurationUnit.MINUTES);
        }

        private final long m1433getMinutesUwyO8pc(double $this$minutes) {
            return DurationKt.toDuration($this$minutes, DurationUnit.MINUTES);
        }

        private final long m1416getHoursUwyO8pc(int $this$hours) {
            return DurationKt.toDuration($this$hours, DurationUnit.HOURS);
        }

        private final long m1417getHoursUwyO8pc(long $this$hours) {
            return DurationKt.toDuration($this$hours, DurationUnit.HOURS);
        }

        private final long m1415getHoursUwyO8pc(double $this$hours) {
            return DurationKt.toDuration($this$hours, DurationUnit.HOURS);
        }

        private final long m1410getDaysUwyO8pc(int $this$days) {
            return DurationKt.toDuration($this$days, DurationUnit.DAYS);
        }

        private final long m1411getDaysUwyO8pc(long $this$days) {
            return DurationKt.toDuration($this$days, DurationUnit.DAYS);
        }

        private final long m1409getDaysUwyO8pc(double $this$days) {
            return DurationKt.toDuration($this$days, DurationUnit.DAYS);
        }

        public final long m1454parseUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return DurationKt.parseDuration(value, false);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid duration string format: '" + value + "'.", e);
            }
        }

        public final long m1455parseIsoStringUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return DurationKt.parseDuration(value, true);
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e);
            }
        }

        public final Duration m1457parseOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return Duration.m1360boximpl(DurationKt.parseDuration(value, false));
            } catch (IllegalArgumentException e) {
                return null;
            }
        }

        public final Duration m1456parseIsoStringOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                return Duration.m1360boximpl(DurationKt.parseDuration(value, true));
            } catch (IllegalArgumentException e) {
                return null;
            }
        }
    }

    public static final long m1406unaryMinusUwyO8pc(long arg0) {
        return DurationKt.durationOf(-m1382getValueimpl(arg0), ((int) arg0) & 1);
    }

    public static final long m1391plusLRDsOJo(long arg0, long other) {
        if (m1387isInfiniteimpl(arg0)) {
            if (m1384isFiniteimpl(other) || (arg0 ^ other) >= 0) {
                return arg0;
            }
            throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
        }
        if (m1387isInfiniteimpl(other)) {
            return other;
        }
        if ((((int) arg0) & 1) == (((int) other) & 1)) {
            long result = m1382getValueimpl(arg0) + m1382getValueimpl(other);
            return m1386isInNanosimpl(arg0) ? DurationKt.durationOfNanosNormalized(result) : DurationKt.durationOfMillisNormalized(result);
        }
        if (m1385isInMillisimpl(arg0)) {
            return m1358addValuesMixedRangesUwyO8pc(arg0, m1382getValueimpl(arg0), m1382getValueimpl(other));
        }
        return m1358addValuesMixedRangesUwyO8pc(arg0, m1382getValueimpl(other), m1382getValueimpl(arg0));
    }

    private static final long m1358addValuesMixedRangesUwyO8pc(long arg0, long thisMillis, long otherNanos) {
        long otherMillis = DurationKt.nanosToMillis(otherNanos);
        long resultMillis = thisMillis + otherMillis;
        boolean z = false;
        if (-4611686018426L <= resultMillis && resultMillis < 4611686018427L) {
            z = true;
        }
        if (z) {
            long otherNanoRemainder = otherNanos - DurationKt.millisToNanos(otherMillis);
            return DurationKt.durationOfNanos(DurationKt.millisToNanos(resultMillis) + otherNanoRemainder);
        }
        return DurationKt.durationOfMillis(RangesKt.coerceIn(resultMillis, -4611686018427387903L, DurationKt.MAX_MILLIS));
    }

    public static final long m1390minusLRDsOJo(long arg0, long other) {
        return m1391plusLRDsOJo(arg0, m1406unaryMinusUwyO8pc(other));
    }

    public static final long m1393timesUwyO8pc(long arg0, int scale) {
        if (m1387isInfiniteimpl(arg0)) {
            if (scale != 0) {
                return scale > 0 ? arg0 : m1406unaryMinusUwyO8pc(arg0);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }
        if (scale == 0) {
            return ZERO;
        }
        long value = m1382getValueimpl(arg0);
        long result = ((long) scale) * value;
        if (!m1386isInNanosimpl(arg0)) {
            if (result / ((long) scale) == value) {
                return DurationKt.durationOfMillis(RangesKt.coerceIn(result, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
            }
            return MathKt.getSign(value) * MathKt.getSign(scale) > 0 ? INFINITE : NEG_INFINITE;
        }
        boolean z = false;
        if (-2147483647L <= value && value < 2147483648L) {
            z = true;
        }
        if (z) {
            return DurationKt.durationOfNanos(result);
        }
        if (result / ((long) scale) == value) {
            return DurationKt.durationOfNanosNormalized(result);
        }
        long millis = DurationKt.nanosToMillis(value);
        long remNanos = value - DurationKt.millisToNanos(millis);
        long resultMillis = ((long) scale) * millis;
        long totalMillis = DurationKt.nanosToMillis(((long) scale) * remNanos) + resultMillis;
        if (resultMillis / ((long) scale) != millis || (totalMillis ^ resultMillis) < 0) {
            return MathKt.getSign(value) * MathKt.getSign(scale) > 0 ? INFINITE : NEG_INFINITE;
        }
        return DurationKt.durationOfMillis(RangesKt.coerceIn(totalMillis, new LongRange(-4611686018427387903L, DurationKt.MAX_MILLIS)));
    }

    public static final long m1392timesUwyO8pc(long arg0, double scale) {
        int intScale = MathKt.roundToInt(scale);
        if (((double) intScale) == scale) {
            return m1393timesUwyO8pc(arg0, intScale);
        }
        DurationUnit unit = m1380getStorageUnitimpl(arg0);
        double result = m1398toDoubleimpl(arg0, unit) * scale;
        return DurationKt.toDuration(result, unit);
    }

    public static final long m1365divUwyO8pc(long arg0, int scale) {
        if (scale == 0) {
            if (m1389isPositiveimpl(arg0)) {
                return INFINITE;
            }
            if (m1388isNegativeimpl(arg0)) {
                return NEG_INFINITE;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        }
        if (m1386isInNanosimpl(arg0)) {
            return DurationKt.durationOfNanos(m1382getValueimpl(arg0) / ((long) scale));
        }
        if (m1387isInfiniteimpl(arg0)) {
            return m1393timesUwyO8pc(arg0, MathKt.getSign(scale));
        }
        long result = m1382getValueimpl(arg0) / ((long) scale);
        boolean z = false;
        if (-4611686018426L <= result && result < 4611686018427L) {
            z = true;
        }
        if (z) {
            long rem = DurationKt.millisToNanos(m1382getValueimpl(arg0) - (((long) scale) * result)) / ((long) scale);
            return DurationKt.durationOfNanos(DurationKt.millisToNanos(result) + rem);
        }
        long rem2 = DurationKt.durationOfMillis(result);
        return rem2;
    }

    public static final long m1364divUwyO8pc(long arg0, double scale) {
        int intScale = MathKt.roundToInt(scale);
        if ((((double) intScale) == scale) && intScale != 0) {
            return m1365divUwyO8pc(arg0, intScale);
        }
        DurationUnit unit = m1380getStorageUnitimpl(arg0);
        double result = m1398toDoubleimpl(arg0, unit) / scale;
        return DurationKt.toDuration(result, unit);
    }

    public static final double m1363divLRDsOJo(long arg0, long other) {
        DurationUnit coarserUnit = (DurationUnit) ComparisonsKt.maxOf(m1380getStorageUnitimpl(arg0), m1380getStorageUnitimpl(other));
        return m1398toDoubleimpl(arg0, coarserUnit) / m1398toDoubleimpl(other, coarserUnit);
    }

    public static final long m1405truncateToUwyO8pc$kotlin_stdlib(long arg0, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        DurationUnit storageUnit = m1380getStorageUnitimpl(arg0);
        if (unit.compareTo(storageUnit) <= 0 || m1387isInfiniteimpl(arg0)) {
            return arg0;
        }
        long scale = DurationUnitKt.convertDurationUnit(1L, unit, storageUnit);
        long result = m1382getValueimpl(arg0) - (m1382getValueimpl(arg0) % scale);
        return DurationKt.toDuration(result, storageUnit);
    }

    public static final boolean m1388isNegativeimpl(long arg0) {
        return arg0 < 0;
    }

    public static final boolean m1389isPositiveimpl(long arg0) {
        return arg0 > 0;
    }

    public static final boolean m1387isInfiniteimpl(long arg0) {
        return arg0 == INFINITE || arg0 == NEG_INFINITE;
    }

    public static final boolean m1384isFiniteimpl(long arg0) {
        return !m1387isInfiniteimpl(arg0);
    }

    public static final long m1368getAbsoluteValueUwyO8pc(long arg0) {
        return m1388isNegativeimpl(arg0) ? m1406unaryMinusUwyO8pc(arg0) : arg0;
    }

    public int m1407compareToLRDsOJo(long other) {
        return m1361compareToLRDsOJo(this.rawValue, other);
    }

    public static int m1361compareToLRDsOJo(long arg0, long other) {
        long compareBits = arg0 ^ other;
        if (compareBits < 0 || (((int) compareBits) & 1) == 0) {
            return Intrinsics.compare(arg0, other);
        }
        int r = (((int) arg0) & 1) - (((int) other) & 1);
        return m1388isNegativeimpl(arg0) ? -r : r;
    }

    public static final <T> T m1397toComponentsimpl(long arg0, Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> function5) {
        Intrinsics.checkNotNullParameter(function5, "action");
        return function5.invoke(Long.valueOf(m1370getInWholeDaysimpl(arg0)), Integer.valueOf(m1369getHoursComponentimpl(arg0)), Integer.valueOf(m1377getMinutesComponentimpl(arg0)), Integer.valueOf(m1379getSecondsComponentimpl(arg0)), Integer.valueOf(m1378getNanosecondsComponentimpl(arg0)));
    }

    public static final <T> T m1396toComponentsimpl(long arg0, Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> function4) {
        Intrinsics.checkNotNullParameter(function4, "action");
        return function4.invoke(Long.valueOf(m1371getInWholeHoursimpl(arg0)), Integer.valueOf(m1377getMinutesComponentimpl(arg0)), Integer.valueOf(m1379getSecondsComponentimpl(arg0)), Integer.valueOf(m1378getNanosecondsComponentimpl(arg0)));
    }

    public static final <T> T m1395toComponentsimpl(long arg0, Function3<? super Long, ? super Integer, ? super Integer, ? extends T> function3) {
        Intrinsics.checkNotNullParameter(function3, "action");
        return function3.invoke(Long.valueOf(m1374getInWholeMinutesimpl(arg0)), Integer.valueOf(m1379getSecondsComponentimpl(arg0)), Integer.valueOf(m1378getNanosecondsComponentimpl(arg0)));
    }

    public static final <T> T m1394toComponentsimpl(long arg0, Function2<? super Long, ? super Integer, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        return function2.invoke(Long.valueOf(m1376getInWholeSecondsimpl(arg0)), Integer.valueOf(m1378getNanosecondsComponentimpl(arg0)));
    }

    public static final int m1369getHoursComponentimpl(long arg0) {
        if (m1387isInfiniteimpl(arg0)) {
            return 0;
        }
        return (int) (m1371getInWholeHoursimpl(arg0) % ((long) 24));
    }

    public static final int m1377getMinutesComponentimpl(long arg0) {
        if (m1387isInfiniteimpl(arg0)) {
            return 0;
        }
        return (int) (m1374getInWholeMinutesimpl(arg0) % ((long) 60));
    }

    public static final int m1379getSecondsComponentimpl(long arg0) {
        if (m1387isInfiniteimpl(arg0)) {
            return 0;
        }
        return (int) (m1376getInWholeSecondsimpl(arg0) % ((long) 60));
    }

    public static final int m1378getNanosecondsComponentimpl(long arg0) {
        if (m1387isInfiniteimpl(arg0)) {
            return 0;
        }
        if (m1385isInMillisimpl(arg0)) {
            return (int) DurationKt.millisToNanos(m1382getValueimpl(arg0) % ((long) 1000));
        }
        return (int) (m1382getValueimpl(arg0) % ((long) 1000000000));
    }

    public static final double m1398toDoubleimpl(long arg0, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (arg0 == INFINITE) {
            return Double.POSITIVE_INFINITY;
        }
        if (arg0 == NEG_INFINITE) {
            return Double.NEGATIVE_INFINITY;
        }
        return DurationUnitKt.convertDurationUnit(m1382getValueimpl(arg0), m1380getStorageUnitimpl(arg0), unit);
    }

    public static final long m1401toLongimpl(long arg0, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (arg0 == INFINITE) {
            return LongCompanionObject.MAX_VALUE;
        }
        if (arg0 == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt.convertDurationUnit(m1382getValueimpl(arg0), m1380getStorageUnitimpl(arg0), unit);
    }

    public static final int m1399toIntimpl(long arg0, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (int) RangesKt.coerceIn(m1401toLongimpl(arg0, unit), -2147483648L, 2147483647L);
    }

    public static final long m1370getInWholeDaysimpl(long arg0) {
        return m1401toLongimpl(arg0, DurationUnit.DAYS);
    }

    public static final long m1371getInWholeHoursimpl(long arg0) {
        return m1401toLongimpl(arg0, DurationUnit.HOURS);
    }

    public static final long m1374getInWholeMinutesimpl(long arg0) {
        return m1401toLongimpl(arg0, DurationUnit.MINUTES);
    }

    public static final long m1376getInWholeSecondsimpl(long arg0) {
        return m1401toLongimpl(arg0, DurationUnit.SECONDS);
    }

    public static final long m1373getInWholeMillisecondsimpl(long arg0) {
        return (m1385isInMillisimpl(arg0) && m1384isFiniteimpl(arg0)) ? m1382getValueimpl(arg0) : m1401toLongimpl(arg0, DurationUnit.MILLISECONDS);
    }

    public static final long m1372getInWholeMicrosecondsimpl(long arg0) {
        return m1401toLongimpl(arg0, DurationUnit.MICROSECONDS);
    }

    public static final long m1375getInWholeNanosecondsimpl(long arg0) {
        long value = m1382getValueimpl(arg0);
        if (m1386isInNanosimpl(arg0)) {
            return value;
        }
        if (value > 9223372036854L) {
            return LongCompanionObject.MAX_VALUE;
        }
        if (value < -9223372036854L) {
            return Long.MIN_VALUE;
        }
        return DurationKt.millisToNanos(value);
    }

    public static String m1402toStringimpl(long arg0) {
        int i;
        if (arg0 == 0) {
            return "0s";
        }
        if (arg0 == INFINITE) {
            return "Infinity";
        }
        if (arg0 == NEG_INFINITE) {
            return "-Infinity";
        }
        boolean isNegative = m1388isNegativeimpl(arg0);
        StringBuilder $this$toString_impl_u24lambda_u241 = new StringBuilder();
        if (isNegative) {
            $this$toString_impl_u24lambda_u241.append('-');
        }
        long arg0$iv = m1368getAbsoluteValueUwyO8pc(arg0);
        long days = m1370getInWholeDaysimpl(arg0$iv);
        int hours = m1369getHoursComponentimpl(arg0$iv);
        int minutes = m1377getMinutesComponentimpl(arg0$iv);
        int seconds = m1379getSecondsComponentimpl(arg0$iv);
        int nanoseconds = m1378getNanosecondsComponentimpl(arg0$iv);
        boolean hasDays = days != 0;
        boolean hasHours = hours != 0;
        boolean hasMinutes = minutes != 0;
        boolean hasSeconds = (seconds == 0 && nanoseconds == 0) ? false : true;
        int components = 0;
        if (hasDays) {
            $this$toString_impl_u24lambda_u241.append(days).append('d');
            components = 0 + 1;
        }
        if (hasHours || (hasDays && (hasMinutes || hasSeconds))) {
            int components2 = components + 1;
            if (components > 0) {
                $this$toString_impl_u24lambda_u241.append(' ');
            }
            $this$toString_impl_u24lambda_u241.append(hours).append('h');
            components = components2;
        }
        if (hasMinutes || (hasSeconds && (hasHours || hasDays != 0))) {
            int components3 = components + 1;
            if (components > 0) {
                $this$toString_impl_u24lambda_u241.append(' ');
            }
            $this$toString_impl_u24lambda_u241.append(minutes).append('m');
            components = components3;
        }
        if (hasSeconds) {
            int components4 = components + 1;
            if (components > 0) {
                $this$toString_impl_u24lambda_u241.append(' ');
            }
            if (seconds != 0 || hasDays != 0 || hasHours || hasMinutes) {
                i = 1;
                m1359appendFractionalimpl(arg0, $this$toString_impl_u24lambda_u241, seconds, nanoseconds, 9, "s", false);
            } else if (nanoseconds >= 1000000) {
                components4 = components4;
                i = 1;
                m1359appendFractionalimpl(arg0, $this$toString_impl_u24lambda_u241, nanoseconds / DurationKt.NANOS_IN_MILLIS, nanoseconds % DurationKt.NANOS_IN_MILLIS, 6, "ms", false);
            } else {
                components4 = components4;
                i = 1;
                if (nanoseconds >= 1000) {
                    m1359appendFractionalimpl(arg0, $this$toString_impl_u24lambda_u241, nanoseconds / 1000, nanoseconds % 1000, 3, "us", false);
                } else {
                    $this$toString_impl_u24lambda_u241.append(nanoseconds).append("ns");
                }
            }
            components = components4;
        } else {
            i = 1;
        }
        if (isNegative && components > i) {
            $this$toString_impl_u24lambda_u241.insert(i, '(').append(')');
        }
        return $this$toString_impl_u24lambda_u241.toString();
    }

    public String toString() {
        return m1402toStringimpl(this.rawValue);
    }

    private static final void m1359appendFractionalimpl(long arg0, StringBuilder $this$appendFractional, int whole, int fractional, int fractionalSize, String unit, boolean isoZeroes) {
        $this$appendFractional.append(whole);
        if (fractional != 0) {
            $this$appendFractional.append('.');
            CharSequence fracString = StringsKt.padStart(String.valueOf(fractional), fractionalSize, '0');
            CharSequence $this$indexOfLast$iv = fracString;
            int i = -1;
            int length = $this$indexOfLast$iv.length() - 1;
            if (length >= 0) {
                do {
                    int index$iv = length;
                    length--;
                    char it = $this$indexOfLast$iv.charAt(index$iv);
                    char it2 = it != '0' ? (char) 1 : (char) 0;
                    if (it2 != 0) {
                        i = index$iv;
                        break;
                    }
                } while (length >= 0);
            }
            int nonZeroDigits = i + 1;
            if (isoZeroes || nonZeroDigits >= 3) {
                Intrinsics.checkNotNullExpressionValue($this$appendFractional.append(fracString, 0, ((nonZeroDigits + 2) / 3) * 3), "append(...)");
            } else {
                Intrinsics.checkNotNullExpressionValue($this$appendFractional.append(fracString, 0, nonZeroDigits), "append(...)");
            }
        }
        $this$appendFractional.append(unit);
    }

    public static  String m1404toStringimpl$default(long j, DurationUnit durationUnit, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m1403toStringimpl(j, durationUnit, i);
    }

    public static final String m1403toStringimpl(long arg0, DurationUnit unit, int decimals) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (!(decimals >= 0)) {
            throw new IllegalArgumentException(("decimals must be not negative, but was " + decimals).toString());
        }
        double number = m1398toDoubleimpl(arg0, unit);
        return Double.isInfinite(number) ? String.valueOf(number) : DurationJvmKt.formatToExactDecimals(number, RangesKt.coerceAtMost(decimals, 12)) + DurationUnitKt.shortName(unit);
    }

    public static final String m1400toIsoStringimpl(long arg0) {
        StringBuilder $this$toIsoString_impl_u24lambda_u245 = new StringBuilder();
        if (m1388isNegativeimpl(arg0)) {
            $this$toIsoString_impl_u24lambda_u245.append('-');
        }
        $this$toIsoString_impl_u24lambda_u245.append("PT");
        long arg0$iv = m1368getAbsoluteValueUwyO8pc(arg0);
        long hours = m1371getInWholeHoursimpl(arg0$iv);
        int minutes = m1377getMinutesComponentimpl(arg0$iv);
        int seconds = m1379getSecondsComponentimpl(arg0$iv);
        int nanoseconds = m1378getNanosecondsComponentimpl(arg0$iv);
        if (m1387isInfiniteimpl(arg0)) {
            hours = 9999999999999L;
        }
        boolean z = true;
        boolean hasHours = hours != 0;
        boolean hasSeconds = (seconds == 0 && nanoseconds == 0) ? false : true;
        if (minutes == 0 && (!hasSeconds || !hasHours)) {
            z = false;
        }
        boolean hasMinutes = z;
        if (hasHours) {
            $this$toIsoString_impl_u24lambda_u245.append(hours).append('H');
        }
        if (hasMinutes) {
            $this$toIsoString_impl_u24lambda_u245.append(minutes).append('M');
        }
        if (hasSeconds || (!hasHours && !hasMinutes)) {
            m1359appendFractionalimpl(arg0, $this$toIsoString_impl_u24lambda_u245, seconds, nanoseconds, 9, "S", true);
        }
        return $this$toIsoString_impl_u24lambda_u245.toString();
    }
}
