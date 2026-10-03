package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
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
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0096\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0006\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b \n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0087@\u0018\u0000 \u0090\u00012\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0002\u0090\u0001B+\bA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u001a\u0018\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\n\b\t\u0012\u0006\b\n0\n8\u000b¢\u0006\u0004\b\u0004\u0010\u0005J\u0011\u0010\u0012\u001a\u00020\u0013H\u0082\u0080\u0004¢\u0006\u0004\b\u0014\u0010\u0015J\u0011\u0010\u0016\u001a\u00020\u0013H\u0082\u0080\u0004¢\u0006\u0004\b\u0017\u0010\u0015J\u0011\u0010\u001c\u001a\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b\u001d\u0010\u0005J\u0019\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b \u0010!J!\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u0003H\u0082\u0080\u0004¢\u0006\u0004\b%\u0010&J\u0019\u0010'\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b(\u0010!J\u0019\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u000fH\u0086\u0082\u0004¢\u0006\u0004\b+\u0010,J\u0019\u0010)\u001a\u00020\u00002\u0006\u0010*\u001a\u00020-H\u0086\u0082\u0004¢\u0006\u0004\b+\u0010.J\u0019\u0010/\u001a\u00020\u00002\u0006\u0010*\u001a\u00020\u000fH\u0086\u0082\u0004¢\u0006\u0004\b0\u0010,J\u0019\u0010/\u001a\u00020\u00002\u0006\u0010*\u001a\u00020-H\u0086\u0082\u0004¢\u0006\u0004\b0\u0010.J\u0019\u0010/\u001a\u00020-2\u0006\u0010\u001f\u001a\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b1\u00102J\u0019\u00103\u001a\u00020\u00002\u0006\u00104\u001a\u00020\u0019H\u0080\u0080\u0004¢\u0006\u0004\b5\u00106J\u0011\u00107\u001a\u00020\u0013H\u0086\u0080\u0004¢\u0006\u0004\b8\u0010\u0015J\u0011\u00109\u001a\u00020\u0013H\u0086\u0080\u0004¢\u0006\u0004\b:\u0010\u0015J\u0011\u0010;\u001a\u00020\u0013H\u0086\u0080\u0004¢\u0006\u0004\b<\u0010\u0015J\u0011\u0010=\u001a\u00020\u0013H\u0086\u0080\u0004¢\u0006\u0004\b>\u0010\u0015J\u0019\u0010A\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0000H\u0096\u0082\u0004¢\u0006\u0004\bB\u0010CJ\u009e\u0001\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2u\u0010F\u001aq\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(J\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0GH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bO\u0010PJ\u0089\u0001\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2`\u0010F\u001a\\\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(K\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0QH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bO\u0010RJt\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E2K\u0010F\u001aG\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(L\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0SH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bO\u0010TJ_\u0010D\u001a\u0002HE\"\u0004\b\u0000\u0010E26\u0010F\u001a2\u0012\u0013\u0012\u00110\u0003¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(M\u0012\u0013\u0012\u00110\u000f¢\u0006\f\bH\u0012\b\bI\u0012\u0004\b\b(N\u0012\u0004\u0012\u0002HE0UH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001¢\u0006\u0004\bO\u0010VJ\u0019\u0010e\u001a\u00020-2\u0006\u00104\u001a\u00020\u0019H\u0086\u0080\u0004¢\u0006\u0004\bf\u0010gJ\u0019\u0010h\u001a\u00020\u00032\u0006\u00104\u001a\u00020\u0019H\u0086\u0080\u0004¢\u0006\u0004\bi\u00106J\u0019\u0010j\u001a\u00020\u000f2\u0006\u00104\u001a\u00020\u0019H\u0086\u0080\u0004¢\u0006\u0004\bk\u0010lJ\u0011\u0010{\u001a\u00020|H\u0096\u0080\u0004¢\u0006\u0004\b}\u0010~JJ\u0010\u007f\u001a\u00030\u0080\u0001*\b0\u0081\u0001j\u0003`\u0082\u00012\u0007\u0010\u0083\u0001\u001a\u00020\u000f2\u0007\u0010\u0084\u0001\u001a\u00020\u000f2\u0007\u0010\u0085\u0001\u001a\u00020\u000f2\u0006\u00104\u001a\u00020|2\u0007\u0010\u0086\u0001\u001a\u00020\u0013H\u0082\u0080\u0004¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J%\u0010{\u001a\u00020|2\u0006\u00104\u001a\u00020\u00192\t\b\u0002\u0010\u0089\u0001\u001a\u00020\u000fH\u0086\u0080\u0004¢\u0006\u0005\b}\u0010\u008a\u0001J\u0013\u0010\u008b\u0001\u001a\u00020|H\u0086\u0080\u0004¢\u0006\u0005\b\u008c\u0001\u0010~J\u0016\u0010\u008d\u0001\u001a\u00020\u00132\t\u0010\u001f\u001a\u0005\u0018\u00010\u008e\u0001HÖ\u0083\u0004J\u000b\u0010\u008f\u0001\u001a\u00020\u000fHÖ\u0081\u0004R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\f\u001a\u00020\u00038BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\r\u0010\u0005R\u0016\u0010\u000e\u001a\u00020\u000f8Â\u0002X\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0015\u0010\u0018\u001a\u00020\u00198BX\u0082\u0084\b¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010?\u001a\u00020\u00008FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b@\u0010\u0005R\u001f\u0010W\u001a\u00020\u000f8@X\u0081\u0084\br\u0002\b[¢\u0006\f\u0012\u0004\bX\u0010Y\u001a\u0004\bZ\u0010\u0011R\u001f\u0010\\\u001a\u00020\u000f8@X\u0081\u0084\br\u0002\b[¢\u0006\f\u0012\u0004\b]\u0010Y\u001a\u0004\b^\u0010\u0011R\u001f\u0010_\u001a\u00020\u000f8@X\u0081\u0084\br\u0002\b[¢\u0006\f\u0012\u0004\b`\u0010Y\u001a\u0004\ba\u0010\u0011R\u001f\u0010b\u001a\u00020\u000f8@X\u0081\u0084\br\u0002\b[¢\u0006\f\u0012\u0004\bc\u0010Y\u001a\u0004\bd\u0010\u0011R\u0015\u0010m\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bn\u0010\u0005R\u0015\u0010o\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bp\u0010\u0005R\u0015\u0010q\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\br\u0010\u0005R\u0015\u0010s\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bt\u0010\u0005R\u0015\u0010u\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bv\u0010\u0005R\u0015\u0010w\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bx\u0010\u0005R\u0015\u0010y\u001a\u00020\u00038FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\bz\u0010\u0005\u0088\u0001\u0002\u0092\u0001\u00020\u0003Ê\u0001\u000f\b\u0092\u0001\u0012\n\b\u0093\u0001\u0012\u0005\b\b(\u0094\u0001Ê\u0001\u0003\b\u0095\u0001\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0091\u0001"}, d2 = {"Lni/shikatu/kotlin/time/Duration;", _UrlKt.FRAGMENT_ENCODE_SET, "rawValue", _UrlKt.FRAGMENT_ENCODE_SET, "constructor-impl", "(J)J", "Lni/shikatu/kotlin/Deprecated;", "message", "Don't call this constructor directly.", "level", "Lni/shikatu/kotlin/DeprecationLevel;", "ERROR", "value", "getValue-impl", "unitDiscriminator", _UrlKt.FRAGMENT_ENCODE_SET, "getUnitDiscriminator-impl", "(J)I", "isInNanos", _UrlKt.FRAGMENT_ENCODE_SET, "isInNanos-impl", "(J)Z", "isInMillis", "isInMillis-impl", "storageUnit", "Lni/shikatu/kotlin/time/DurationUnit;", "getStorageUnit-impl", "(J)Lkotlin/time/DurationUnit;", "unaryMinus", "unaryMinus-UwyO8pc", "plus", "other", "plus-LRDsOJo", "(JJ)J", "addValuesMixedRanges", "thisMillis", "otherNanos", "addValuesMixedRanges-UwyO8pc", "(JJJ)J", "minus", "minus-LRDsOJo", "times", "scale", "times-UwyO8pc", "(JI)J", _UrlKt.FRAGMENT_ENCODE_SET, "(JD)J", "div", "div-UwyO8pc", "div-LRDsOJo", "(JJ)D", "truncateTo", "unit", "truncateTo-UwyO8pc$kotlin_stdlib", "(JLkotlin/time/DurationUnit;)J", "isNegative", "isNegative-impl", "isPositive", "isPositive-impl", "isInfinite", "isInfinite-impl", "isFinite", "isFinite-impl", "absoluteValue", "getAbsoluteValue-UwyO8pc", "compareTo", "compareTo-LRDsOJo", "(JJ)I", "toComponents", "T", "action", "Lni/shikatu/kotlin/Function5;", "Lni/shikatu/kotlin/ParameterName;", "name", "days", "hours", "minutes", "seconds", "nanoseconds", "toComponents-impl", "(JLkotlin/jvm/functions/Function5;)Ljava/lang/Object;", "Lni/shikatu/kotlin/Function4;", "(JLkotlin/jvm/functions/Function4;)Ljava/lang/Object;", "Lni/shikatu/kotlin/Function3;", "(JLkotlin/jvm/functions/Function3;)Ljava/lang/Object;", "Lni/shikatu/kotlin/Function2;", "(JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "hoursComponent", "getHoursComponent$annotations", "()V", "getHoursComponent-impl", "Lni/shikatu/kotlin/PublishedApi;", "minutesComponent", "getMinutesComponent$annotations", "getMinutesComponent-impl", "secondsComponent", "getSecondsComponent$annotations", "getSecondsComponent-impl", "nanosecondsComponent", "getNanosecondsComponent$annotations", "getNanosecondsComponent-impl", "toDouble", "toDouble-impl", "(JLkotlin/time/DurationUnit;)D", "toLong", "toLong-impl", "toInt", "toInt-impl", "(JLkotlin/time/DurationUnit;)I", "inWholeDays", "getInWholeDays-impl", "inWholeHours", "getInWholeHours-impl", "inWholeMinutes", "getInWholeMinutes-impl", "inWholeSeconds", "getInWholeSeconds-impl", "inWholeMilliseconds", "getInWholeMilliseconds-impl", "inWholeMicroseconds", "getInWholeMicroseconds-impl", "inWholeNanoseconds", "getInWholeNanoseconds-impl", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "toString-impl", "(J)Ljava/lang/String;", "appendFractional", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/lang/StringBuilder;", "Lni/shikatu/kotlin/text/StringBuilder;", "whole", "fractional", "fractionalSize", "isoZeroes", "appendFractional-impl", "(JLjava/lang/StringBuilder;IIILjava/lang/String;Z)V", "decimals", "(JLkotlin/time/DurationUnit;I)Ljava/lang/String;", "toIsoString", "toIsoString-impl", "equals", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "Companion", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.6", "Lni/shikatu/kotlin/jvm/JvmInline;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@JvmInline
public final class Duration implements Comparable<Duration> {
    private final long rawValue;
    public static final Companion Companion = new Companion(null);
    private static final long ZERO = m1385constructorimpl(0);
    private static final long INFINITE = DurationKt.durationOfMillis(DurationKt.MAX_MILLIS);
    private static final long NEG_INFINITE = DurationKt.durationOfMillis(-4611686018427387903L);
    public static final long INVALID_RAW_VALUE = 9223372036854759646L;
    private static final long INVALID = m1385constructorimpl(INVALID_RAW_VALUE);

    public static final  Duration m1383boximpl(long j) {
        return new Duration(j);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Don't call this constructor directly.")

    public static long m1385constructorimpl(long j) {
        return j;
    }

    public static boolean m1389equalsimpl(long j, Object obj) {
        return (obj instanceof Duration) && j == ((Duration) obj).m1431unboximpl();
    }

    public static final boolean m1390equalsimpl0(long j, long j2) {
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

    public static int m1406hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    public boolean equals(Object obj) {
        return m1389equalsimpl(this.rawValue, obj);
    }

    public int hashCode() {
        return m1406hashCodeimpl(this.rawValue);
    }

    public final  long m1431unboximpl() {
        return this.rawValue;
    }

    @Override
    public /* bridge */  int compareTo(Duration duration) {
        return m1430compareToLRDsOJo(duration.m1431unboximpl());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "Don't call this constructor directly.")
    private  Duration(long rawValue) {
        this.rawValue = rawValue;
    }

    public static final long m1405getValueimpl(long arg0) {
        return arg0 >> 1;
    }

    private static final int m1404getUnitDiscriminatorimpl(long arg0) {
        return ((int) arg0) & 1;
    }

    public static final boolean m1409isInNanosimpl(long arg0) {
        return (((int) arg0) & 1) == 0;
    }

    private static final boolean m1408isInMillisimpl(long arg0) {
        return (((int) arg0) & 1) == 1;
    }

    private static final DurationUnit m1403getStorageUnitimpl(long arg0) {
        return m1409isInNanosimpl(arg0) ? DurationUnit.NANOSECONDS : DurationUnit.MILLISECONDS;
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000e\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0080\u0080\u0004¢\u0006\u0004\b\b\u0010\tJ&\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bH\u0087\u0080\u0004b\u0002\b\u001dJ\u0019\u0010:\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020;H\u0086\u0080\u0004¢\u0006\u0004\b<\u0010=J\u0019\u0010>\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020;H\u0086\u0080\u0004¢\u0006\u0004\b?\u0010=J\u0019\u0010@\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020;H\u0086\u0080\u0004¢\u0006\u0002\bAJ\u0019\u0010B\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0019\u001a\u00020;H\u0086\u0080\u0004¢\u0006\u0002\bCR\u001d\u0010\n\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\rR\u0017\u0010\u000f\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0010\u0010\rR\u0017\u0010\u0011\u001a\u00020\u0005X\u0080\u0084\b¢\u0006\n\n\u0002\u0010\u000e\u001a\u0004\b\u0012\u0010\rR\u000f\u0010\u0013\u001a\u00020\u0007X\u0080Ô\b¢\u0006\u0002\n\u0000R\u001d\u0010\u0014\u001a\u00020\u0005X\u0080\u0084\b¢\u0006\u0010\n\u0002\u0010\u000e\u0012\u0004\b\u0015\u0010\u0003\u001a\u0004\b\u0016\u0010\rR$\u0010\u001e\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b \u0010!\u001a\u0004\b\"\u0010#R$\u0010\u001e\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b \u0010%\u001a\u0004\b\"\u0010\tR$\u0010\u001e\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b \u0010&\u001a\u0004\b\"\u0010'R$\u0010(\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b)\u0010!\u001a\u0004\b*\u0010#R$\u0010(\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b)\u0010%\u001a\u0004\b*\u0010\tR$\u0010(\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b)\u0010&\u001a\u0004\b*\u0010'R$\u0010+\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b,\u0010!\u001a\u0004\b-\u0010#R$\u0010+\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b,\u0010%\u001a\u0004\b-\u0010\tR$\u0010+\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b,\u0010&\u001a\u0004\b-\u0010'R$\u0010.\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b/\u0010!\u001a\u0004\b0\u0010#R$\u0010.\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b/\u0010%\u001a\u0004\b0\u0010\tR$\u0010.\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b/\u0010&\u001a\u0004\b0\u0010'R$\u00101\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b2\u0010!\u001a\u0004\b3\u0010#R$\u00101\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b2\u0010%\u001a\u0004\b3\u0010\tR$\u00101\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b2\u0010&\u001a\u0004\b3\u0010'R$\u00104\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b5\u0010!\u001a\u0004\b6\u0010#R$\u00104\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b5\u0010%\u001a\u0004\b6\u0010\tR$\u00104\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b5\u0010&\u001a\u0004\b6\u0010'R$\u00107\u001a\u00020\u0005*\u00020\u001f8Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b8\u0010!\u001a\u0004\b9\u0010#R$\u00107\u001a\u00020\u0005*\u00020\u00078Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b8\u0010%\u001a\u0004\b9\u0010\tR$\u00107\u001a\u00020\u0005*\u00020\u00188Æ\u0002X\u0087\u0084\br\u0002\b$¢\u0006\f\u0012\u0004\b8\u0010&\u001a\u0004\b9\u0010'¨\u0006D"}, d2 = {"Lni/shikatu/kotlin/time/Duration$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "fromRawValue", "Lni/shikatu/kotlin/time/Duration;", "rawValue", _UrlKt.FRAGMENT_ENCODE_SET, "fromRawValue-UwyO8pc$kotlin_stdlib", "(J)J", "ZERO", "getZERO-UwyO8pc$annotations", "getZERO-UwyO8pc", "()J", "J", "INFINITE", "getINFINITE-UwyO8pc", "NEG_INFINITE", "getNEG_INFINITE-UwyO8pc$kotlin_stdlib", "INVALID_RAW_VALUE", "INVALID", "getINVALID-UwyO8pc$kotlin_stdlib$annotations", "getINVALID-UwyO8pc$kotlin_stdlib", "convert", _UrlKt.FRAGMENT_ENCODE_SET, "value", "sourceUnit", "Lni/shikatu/kotlin/time/DurationUnit;", "targetUnit", "Lni/shikatu/kotlin/time/ExperimentalTime;", "nanoseconds", _UrlKt.FRAGMENT_ENCODE_SET, "getNanoseconds-UwyO8pc$annotations", "(I)V", "getNanoseconds-UwyO8pc", "(I)J", "Lni/shikatu/kotlin/internal/InlineOnly;", "(J)V", "(D)V", "(D)J", "microseconds", "getMicroseconds-UwyO8pc$annotations", "getMicroseconds-UwyO8pc", "milliseconds", "getMilliseconds-UwyO8pc$annotations", "getMilliseconds-UwyO8pc", "seconds", "getSeconds-UwyO8pc$annotations", "getSeconds-UwyO8pc", "minutes", "getMinutes-UwyO8pc$annotations", "getMinutes-UwyO8pc", "hours", "getHours-UwyO8pc$annotations", "getHours-UwyO8pc", "days", "getDays-UwyO8pc$annotations", "getDays-UwyO8pc", "parse", _UrlKt.FRAGMENT_ENCODE_SET, "parse-UwyO8pc", "(Ljava/lang/String;)J", "parseIsoString", "parseIsoString-UwyO8pc", "parseOrNull", "parseOrNull-FghU774", "parseIsoStringOrNull", "parseIsoStringOrNull-FghU774", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static  void m1435getDaysUwyO8pc$annotations(double d) {
        }

        public static  void m1436getDaysUwyO8pc$annotations(int i) {
        }

        public static  void m1437getDaysUwyO8pc$annotations(long j) {
        }

        public static  void m1441getHoursUwyO8pc$annotations(double d) {
        }

        public static  void m1442getHoursUwyO8pc$annotations(int i) {
        }

        public static  void m1443getHoursUwyO8pc$annotations(long j) {
        }

        public static  void m1444getINVALIDUwyO8pc$kotlin_stdlib$annotations() {
        }

        public static  void m1448getMicrosecondsUwyO8pc$annotations(double d) {
        }

        public static  void m1449getMicrosecondsUwyO8pc$annotations(int i) {
        }

        public static  void m1450getMicrosecondsUwyO8pc$annotations(long j) {
        }

        public static  void m1454getMillisecondsUwyO8pc$annotations(double d) {
        }

        public static  void m1455getMillisecondsUwyO8pc$annotations(int i) {
        }

        public static  void m1456getMillisecondsUwyO8pc$annotations(long j) {
        }

        public static  void m1460getMinutesUwyO8pc$annotations(double d) {
        }

        public static  void m1461getMinutesUwyO8pc$annotations(int i) {
        }

        public static  void m1462getMinutesUwyO8pc$annotations(long j) {
        }

        public static  void m1466getNanosecondsUwyO8pc$annotations(double d) {
        }

        public static  void m1467getNanosecondsUwyO8pc$annotations(int i) {
        }

        public static  void m1468getNanosecondsUwyO8pc$annotations(long j) {
        }

        public static  void m1472getSecondsUwyO8pc$annotations(double d) {
        }

        public static  void m1473getSecondsUwyO8pc$annotations(int i) {
        }

        public static  void m1474getSecondsUwyO8pc$annotations(long j) {
        }

        public static  void m1475getZEROUwyO8pc$annotations() {
        }

        private Companion() {
        }

        public final long m1476fromRawValueUwyO8pc$kotlin_stdlib(long rawValue) {
            long $this$fromRawValue_UwyO8pc_u24lambda_u240 = Duration.m1385constructorimpl(rawValue);
            if (DurationJvmKt.getDurationAssertionsEnabled()) {
                if (Duration.m1409isInNanosimpl($this$fromRawValue_UwyO8pc_u24lambda_u240)) {
                    long jM1405getValueimpl = Duration.m1405getValueimpl($this$fromRawValue_UwyO8pc_u24lambda_u240);
                    if (!(-4611686018426999999L <= jM1405getValueimpl && jM1405getValueimpl < 4611686018427000000L)) {
                        throw new AssertionError(Duration.m1405getValueimpl($this$fromRawValue_UwyO8pc_u24lambda_u240) + " ns is out of nanoseconds range");
                    }
                } else {
                    long jM1405getValueimpl2 = Duration.m1405getValueimpl($this$fromRawValue_UwyO8pc_u24lambda_u240);
                    if (!(-4611686018427387903L < jM1405getValueimpl2 && jM1405getValueimpl2 < DurationKt.MAX_MILLIS)) {
                        long jM1405getValueimpl3 = Duration.m1405getValueimpl($this$fromRawValue_UwyO8pc_u24lambda_u240);
                        if (!(jM1405getValueimpl3 == DurationKt.MAX_MILLIS || jM1405getValueimpl3 == -4611686018427387903L)) {
                            throw new AssertionError(Duration.m1405getValueimpl($this$fromRawValue_UwyO8pc_u24lambda_u240) + " ms is out of milliseconds range");
                        }
                    }
                    long jM1405getValueimpl4 = Duration.m1405getValueimpl($this$fromRawValue_UwyO8pc_u24lambda_u240);
                    if (-4611686018426L <= jM1405getValueimpl4 && jM1405getValueimpl4 < 4611686018427L) {
                        throw new AssertionError(Duration.m1405getValueimpl($this$fromRawValue_UwyO8pc_u24lambda_u240) + " ms is denormalized");
                    }
                }
            }
            return $this$fromRawValue_UwyO8pc_u24lambda_u240;
        }

        public final long m1480getZEROUwyO8pc() {
            return Duration.ZERO;
        }

        public final long m1477getINFINITEUwyO8pc() {
            return Duration.INFINITE;
        }

        public final long m1479getNEG_INFINITEUwyO8pc$kotlin_stdlib() {
            return Duration.NEG_INFINITE;
        }

        public final long m1478getINVALIDUwyO8pc$kotlin_stdlib() {
            return Duration.INVALID;
        }

        public final double convert(double value, DurationUnit sourceUnit, DurationUnit targetUnit) {
            Intrinsics.checkNotNullParameter(sourceUnit, "sourceUnit");
            Intrinsics.checkNotNullParameter(targetUnit, "targetUnit");
            return DurationUnitKt.convertDurationUnit(value, sourceUnit, targetUnit);
        }

        private final long m1464getNanosecondsUwyO8pc(int $this$nanoseconds) {
            return DurationKt.toDuration($this$nanoseconds, DurationUnit.NANOSECONDS);
        }

        private final long m1465getNanosecondsUwyO8pc(long $this$nanoseconds) {
            return DurationKt.toDuration($this$nanoseconds, DurationUnit.NANOSECONDS);
        }

        private final long m1463getNanosecondsUwyO8pc(double $this$nanoseconds) {
            return DurationKt.toDuration($this$nanoseconds, DurationUnit.NANOSECONDS);
        }

        private final long m1446getMicrosecondsUwyO8pc(int $this$microseconds) {
            return DurationKt.toDuration($this$microseconds, DurationUnit.MICROSECONDS);
        }

        private final long m1447getMicrosecondsUwyO8pc(long $this$microseconds) {
            return DurationKt.toDuration($this$microseconds, DurationUnit.MICROSECONDS);
        }

        private final long m1445getMicrosecondsUwyO8pc(double $this$microseconds) {
            return DurationKt.toDuration($this$microseconds, DurationUnit.MICROSECONDS);
        }

        private final long m1452getMillisecondsUwyO8pc(int $this$milliseconds) {
            return DurationKt.toDuration($this$milliseconds, DurationUnit.MILLISECONDS);
        }

        private final long m1453getMillisecondsUwyO8pc(long $this$milliseconds) {
            return DurationKt.toDuration($this$milliseconds, DurationUnit.MILLISECONDS);
        }

        private final long m1451getMillisecondsUwyO8pc(double $this$milliseconds) {
            return DurationKt.toDuration($this$milliseconds, DurationUnit.MILLISECONDS);
        }

        private final long m1470getSecondsUwyO8pc(int $this$seconds) {
            return DurationKt.toDuration($this$seconds, DurationUnit.SECONDS);
        }

        private final long m1471getSecondsUwyO8pc(long $this$seconds) {
            return DurationKt.toDuration($this$seconds, DurationUnit.SECONDS);
        }

        private final long m1469getSecondsUwyO8pc(double $this$seconds) {
            return DurationKt.toDuration($this$seconds, DurationUnit.SECONDS);
        }

        private final long m1458getMinutesUwyO8pc(int $this$minutes) {
            return DurationKt.toDuration($this$minutes, DurationUnit.MINUTES);
        }

        private final long m1459getMinutesUwyO8pc(long $this$minutes) {
            return DurationKt.toDuration($this$minutes, DurationUnit.MINUTES);
        }

        private final long m1457getMinutesUwyO8pc(double $this$minutes) {
            return DurationKt.toDuration($this$minutes, DurationUnit.MINUTES);
        }

        private final long m1439getHoursUwyO8pc(int $this$hours) {
            return DurationKt.toDuration($this$hours, DurationUnit.HOURS);
        }

        private final long m1440getHoursUwyO8pc(long $this$hours) {
            return DurationKt.toDuration($this$hours, DurationUnit.HOURS);
        }

        private final long m1438getHoursUwyO8pc(double $this$hours) {
            return DurationKt.toDuration($this$hours, DurationUnit.HOURS);
        }

        private final long m1433getDaysUwyO8pc(int $this$days) {
            return DurationKt.toDuration($this$days, DurationUnit.DAYS);
        }

        private final long m1434getDaysUwyO8pc(long $this$days) {
            return DurationKt.toDuration($this$days, DurationUnit.DAYS);
        }

        private final long m1432getDaysUwyO8pc(double $this$days) {
            return DurationKt.toDuration($this$days, DurationUnit.DAYS);
        }

        public final long m1481parseUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                long $this$parse_UwyO8pc_u24lambda_u240 = DurationKt.parseDuration$default(value, false, false, 4, null);
                if (Duration.m1390equalsimpl0($this$parse_UwyO8pc_u24lambda_u240, Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib())) {
                    throw new IllegalStateException("invariant failed".toString());
                }
                return $this$parse_UwyO8pc_u24lambda_u240;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid duration string format: '" + value + "'.", e);
            }
        }

        public final long m1482parseIsoStringUwyO8pc(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            try {
                long $this$parseIsoString_UwyO8pc_u24lambda_u240 = DurationKt.parseDuration$default(value, true, false, 4, null);
                if (Duration.m1390equalsimpl0($this$parseIsoString_UwyO8pc_u24lambda_u240, Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib())) {
                    throw new IllegalStateException("invariant failed".toString());
                }
                return $this$parseIsoString_UwyO8pc_u24lambda_u240;
            } catch (IllegalArgumentException e) {
                throw new IllegalArgumentException("Invalid ISO duration string format: '" + value + "'.", e);
            }
        }

        public final Duration m1484parseOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            long $this$onInvalid_u2dge6A_vg$iv = DurationKt.parseDuration(value, false, false);
            if (Duration.m1390equalsimpl0($this$onInvalid_u2dge6A_vg$iv, Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib())) {
                return null;
            }
            return Duration.m1383boximpl($this$onInvalid_u2dge6A_vg$iv);
        }

        public final Duration m1483parseIsoStringOrNullFghU774(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            long $this$onInvalid_u2dge6A_vg$iv = DurationKt.parseDuration(value, true, false);
            if (Duration.m1390equalsimpl0($this$onInvalid_u2dge6A_vg$iv, Duration.Companion.m1478getINVALIDUwyO8pc$kotlin_stdlib())) {
                return null;
            }
            return Duration.m1383boximpl($this$onInvalid_u2dge6A_vg$iv);
        }
    }

    public static final long m1429unaryMinusUwyO8pc(long arg0) {
        return DurationKt.durationOf(-m1405getValueimpl(arg0), ((int) arg0) & 1);
    }

    public static final long m1414plusLRDsOJo(long arg0, long other) {
        boolean z = true;
        if ((((int) arg0) & 1) != (((int) other) & 1)) {
            return m1408isInMillisimpl(arg0) ? m1381addValuesMixedRangesUwyO8pc(arg0, m1405getValueimpl(arg0), m1405getValueimpl(other)) : m1381addValuesMixedRangesUwyO8pc(arg0, m1405getValueimpl(other), m1405getValueimpl(arg0));
        }
        if (m1409isInNanosimpl(arg0)) {
            return DurationKt.durationOfNanosNormalized(m1405getValueimpl(arg0) + m1405getValueimpl(other));
        }
        long it = DurationKt.addMillisWithoutOverflow(m1405getValueimpl(arg0), m1405getValueimpl(other));
        if (it != INVALID_RAW_VALUE) {
            if (it != DurationKt.MAX_MILLIS && it != -4611686018427387903L) {
                z = false;
            }
            return z ? DurationKt.durationOfMillis(it) : DurationKt.durationOfMillisNormalized(it);
        }
        throw new IllegalArgumentException("Summing infinite durations of different signs yields an undefined result.");
    }

    private static final long m1381addValuesMixedRangesUwyO8pc(long arg0, long thisMillis, long otherNanos) {
        long otherMillis = DurationKt.nanosToMillis(otherNanos);
        long resultMillis = DurationKt.addMillisWithoutOverflow(thisMillis, otherMillis);
        boolean z = false;
        if (-4611686018426L <= resultMillis && resultMillis < 4611686018427L) {
            z = true;
        }
        if (z) {
            long otherNanoRemainder = otherNanos - DurationKt.millisToNanos(otherMillis);
            return DurationKt.durationOfNanos(DurationKt.millisToNanos(resultMillis) + otherNanoRemainder);
        }
        return DurationKt.durationOfMillis(resultMillis);
    }

    public static final long m1413minusLRDsOJo(long arg0, long other) {
        return m1414plusLRDsOJo(arg0, m1429unaryMinusUwyO8pc(other));
    }

    public static final long m1416timesUwyO8pc(long arg0, int scale) {
        if (m1410isInfiniteimpl(arg0)) {
            if (scale != 0) {
                return scale > 0 ? arg0 : m1429unaryMinusUwyO8pc(arg0);
            }
            throw new IllegalArgumentException("Multiplying infinite duration by zero yields an undefined result.");
        }
        if (scale == 0) {
            return ZERO;
        }
        long value = m1405getValueimpl(arg0);
        long result = ((long) scale) * value;
        if (!m1409isInNanosimpl(arg0)) {
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

    public static final long m1415timesUwyO8pc(long arg0, double scale) {
        int intScale = MathKt.roundToInt(scale);
        if (((double) intScale) == scale) {
            return m1416timesUwyO8pc(arg0, intScale);
        }
        DurationUnit unit = m1403getStorageUnitimpl(arg0);
        double result = m1421toDoubleimpl(arg0, unit) * scale;
        return DurationKt.toDuration(result, unit);
    }

    public static final long m1388divUwyO8pc(long arg0, int scale) {
        if (scale == 0) {
            if (m1412isPositiveimpl(arg0)) {
                return INFINITE;
            }
            if (m1411isNegativeimpl(arg0)) {
                return NEG_INFINITE;
            }
            throw new IllegalArgumentException("Dividing zero duration by zero yields an undefined result.");
        }
        if (m1409isInNanosimpl(arg0)) {
            return DurationKt.durationOfNanos(m1405getValueimpl(arg0) / ((long) scale));
        }
        if (m1410isInfiniteimpl(arg0)) {
            return m1416timesUwyO8pc(arg0, MathKt.getSign(scale));
        }
        long result = m1405getValueimpl(arg0) / ((long) scale);
        boolean z = false;
        if (-4611686018426L <= result && result < 4611686018427L) {
            z = true;
        }
        if (z) {
            long rem = DurationKt.millisToNanos(m1405getValueimpl(arg0) - (((long) scale) * result)) / ((long) scale);
            return DurationKt.durationOfNanos(DurationKt.millisToNanos(result) + rem);
        }
        long rem2 = DurationKt.durationOfMillis(result);
        return rem2;
    }

    public static final long m1387divUwyO8pc(long arg0, double scale) {
        int intScale = MathKt.roundToInt(scale);
        if ((((double) intScale) == scale) && intScale != 0) {
            return m1388divUwyO8pc(arg0, intScale);
        }
        DurationUnit unit = m1403getStorageUnitimpl(arg0);
        double result = m1421toDoubleimpl(arg0, unit) / scale;
        return DurationKt.toDuration(result, unit);
    }

    public static final double m1386divLRDsOJo(long arg0, long other) {
        DurationUnit coarserUnit = (DurationUnit) ComparisonsKt.maxOf(m1403getStorageUnitimpl(arg0), m1403getStorageUnitimpl(other));
        return m1421toDoubleimpl(arg0, coarserUnit) / m1421toDoubleimpl(other, coarserUnit);
    }

    public static final long m1428truncateToUwyO8pc$kotlin_stdlib(long arg0, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        DurationUnit storageUnit = m1403getStorageUnitimpl(arg0);
        if (unit.compareTo(storageUnit) <= 0 || m1410isInfiniteimpl(arg0)) {
            return arg0;
        }
        long scale = DurationUnitKt.convertDurationUnit(1L, unit, storageUnit);
        long result = m1405getValueimpl(arg0) - (m1405getValueimpl(arg0) % scale);
        return DurationKt.toDuration(result, storageUnit);
    }

    public static final boolean m1411isNegativeimpl(long arg0) {
        return arg0 < 0;
    }

    public static final boolean m1412isPositiveimpl(long arg0) {
        return arg0 > 0;
    }

    public static final boolean m1410isInfiniteimpl(long arg0) {
        return arg0 == INFINITE || arg0 == NEG_INFINITE;
    }

    public static final boolean m1407isFiniteimpl(long arg0) {
        return !m1410isInfiniteimpl(arg0);
    }

    public static final long m1391getAbsoluteValueUwyO8pc(long arg0) {
        return m1411isNegativeimpl(arg0) ? m1429unaryMinusUwyO8pc(arg0) : arg0;
    }

    public int m1430compareToLRDsOJo(long other) {
        return m1384compareToLRDsOJo(this.rawValue, other);
    }

    public static int m1384compareToLRDsOJo(long arg0, long other) {
        long compareBits = arg0 ^ other;
        if (compareBits < 0 || (((int) compareBits) & 1) == 0) {
            return Intrinsics.compare(arg0, other);
        }
        int r = (((int) arg0) & 1) - (((int) other) & 1);
        return m1411isNegativeimpl(arg0) ? -r : r;
    }

    public static final <T> T m1420toComponentsimpl(long arg0, Function5<? super Long, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? extends T> function5) {
        Intrinsics.checkNotNullParameter(function5, "action");
        return function5.invoke(Long.valueOf(m1393getInWholeDaysimpl(arg0)), Integer.valueOf(m1392getHoursComponentimpl(arg0)), Integer.valueOf(m1400getMinutesComponentimpl(arg0)), Integer.valueOf(m1402getSecondsComponentimpl(arg0)), Integer.valueOf(m1401getNanosecondsComponentimpl(arg0)));
    }

    public static final <T> T m1419toComponentsimpl(long arg0, Function4<? super Long, ? super Integer, ? super Integer, ? super Integer, ? extends T> function4) {
        Intrinsics.checkNotNullParameter(function4, "action");
        return function4.invoke(Long.valueOf(m1394getInWholeHoursimpl(arg0)), Integer.valueOf(m1400getMinutesComponentimpl(arg0)), Integer.valueOf(m1402getSecondsComponentimpl(arg0)), Integer.valueOf(m1401getNanosecondsComponentimpl(arg0)));
    }

    public static final <T> T m1418toComponentsimpl(long arg0, Function3<? super Long, ? super Integer, ? super Integer, ? extends T> function3) {
        Intrinsics.checkNotNullParameter(function3, "action");
        return function3.invoke(Long.valueOf(m1397getInWholeMinutesimpl(arg0)), Integer.valueOf(m1402getSecondsComponentimpl(arg0)), Integer.valueOf(m1401getNanosecondsComponentimpl(arg0)));
    }

    public static final <T> T m1417toComponentsimpl(long arg0, Function2<? super Long, ? super Integer, ? extends T> function2) {
        Intrinsics.checkNotNullParameter(function2, "action");
        return function2.invoke(Long.valueOf(m1399getInWholeSecondsimpl(arg0)), Integer.valueOf(m1401getNanosecondsComponentimpl(arg0)));
    }

    public static final int m1392getHoursComponentimpl(long arg0) {
        if (m1410isInfiniteimpl(arg0)) {
            return 0;
        }
        return (int) (m1394getInWholeHoursimpl(arg0) % ((long) 24));
    }

    public static final int m1400getMinutesComponentimpl(long arg0) {
        if (m1410isInfiniteimpl(arg0)) {
            return 0;
        }
        return (int) (m1397getInWholeMinutesimpl(arg0) % ((long) 60));
    }

    public static final int m1402getSecondsComponentimpl(long arg0) {
        if (m1410isInfiniteimpl(arg0)) {
            return 0;
        }
        return (int) (m1399getInWholeSecondsimpl(arg0) % ((long) 60));
    }

    public static final int m1401getNanosecondsComponentimpl(long arg0) {
        if (m1410isInfiniteimpl(arg0)) {
            return 0;
        }
        if (m1408isInMillisimpl(arg0)) {
            return (int) DurationKt.millisToNanos(m1405getValueimpl(arg0) % ((long) 1000));
        }
        return (int) (m1405getValueimpl(arg0) % ((long) 1000000000));
    }

    public static final double m1421toDoubleimpl(long arg0, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (arg0 == INFINITE) {
            return Double.POSITIVE_INFINITY;
        }
        if (arg0 == NEG_INFINITE) {
            return Double.NEGATIVE_INFINITY;
        }
        return DurationUnitKt.convertDurationUnit(m1405getValueimpl(arg0), m1403getStorageUnitimpl(arg0), unit);
    }

    public static final long m1424toLongimpl(long arg0, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (arg0 == INFINITE) {
            return LongCompanionObject.MAX_VALUE;
        }
        if (arg0 == NEG_INFINITE) {
            return Long.MIN_VALUE;
        }
        return DurationUnitKt.convertDurationUnit(m1405getValueimpl(arg0), m1403getStorageUnitimpl(arg0), unit);
    }

    public static final int m1422toIntimpl(long arg0, DurationUnit unit) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        return (int) RangesKt.coerceIn(m1424toLongimpl(arg0, unit), -2147483648L, 2147483647L);
    }

    public static final long m1393getInWholeDaysimpl(long arg0) {
        return m1424toLongimpl(arg0, DurationUnit.DAYS);
    }

    public static final long m1394getInWholeHoursimpl(long arg0) {
        return m1424toLongimpl(arg0, DurationUnit.HOURS);
    }

    public static final long m1397getInWholeMinutesimpl(long arg0) {
        return m1424toLongimpl(arg0, DurationUnit.MINUTES);
    }

    public static final long m1399getInWholeSecondsimpl(long arg0) {
        return m1424toLongimpl(arg0, DurationUnit.SECONDS);
    }

    public static final long m1396getInWholeMillisecondsimpl(long arg0) {
        return (m1408isInMillisimpl(arg0) && m1407isFiniteimpl(arg0)) ? m1405getValueimpl(arg0) : m1424toLongimpl(arg0, DurationUnit.MILLISECONDS);
    }

    public static final long m1395getInWholeMicrosecondsimpl(long arg0) {
        return m1424toLongimpl(arg0, DurationUnit.MICROSECONDS);
    }

    public static final long m1398getInWholeNanosecondsimpl(long arg0) {
        long value = m1405getValueimpl(arg0);
        if (m1409isInNanosimpl(arg0)) {
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

    public static String m1425toStringimpl(long arg0) {
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
        boolean isNegative = m1411isNegativeimpl(arg0);
        StringBuilder $this$toString_impl_u24lambda_u240 = new StringBuilder();
        if (isNegative) {
            $this$toString_impl_u24lambda_u240.append('-');
        }
        long arg0$iv = m1391getAbsoluteValueUwyO8pc(arg0);
        long days = m1393getInWholeDaysimpl(arg0$iv);
        int hours = m1392getHoursComponentimpl(arg0$iv);
        int minutes = m1400getMinutesComponentimpl(arg0$iv);
        int seconds = m1402getSecondsComponentimpl(arg0$iv);
        int nanoseconds = m1401getNanosecondsComponentimpl(arg0$iv);
        boolean hasDays = days != 0;
        boolean hasHours = hours != 0;
        boolean hasMinutes = minutes != 0;
        boolean hasSeconds = (seconds == 0 && nanoseconds == 0) ? false : true;
        int components = 0;
        if (hasDays) {
            $this$toString_impl_u24lambda_u240.append(days).append('d');
            components = 0 + 1;
        }
        if (hasHours || (hasDays && (hasMinutes || hasSeconds))) {
            int components2 = components + 1;
            if (components > 0) {
                $this$toString_impl_u24lambda_u240.append(' ');
            }
            $this$toString_impl_u24lambda_u240.append(hours).append('h');
            components = components2;
        }
        if (hasMinutes || (hasSeconds && (hasHours || hasDays))) {
            int components3 = components + 1;
            if (components > 0) {
                $this$toString_impl_u24lambda_u240.append(' ');
            }
            $this$toString_impl_u24lambda_u240.append(minutes).append('m');
            components = components3;
        }
        if (hasSeconds) {
            int components4 = components + 1;
            if (components > 0) {
                $this$toString_impl_u24lambda_u240.append(' ');
            }
            if (seconds != 0 || hasDays || hasHours || hasMinutes) {
                i = 1;
                m1382appendFractionalimpl(arg0, $this$toString_impl_u24lambda_u240, seconds, nanoseconds, 9, "s", false);
            } else if (nanoseconds >= 1000000) {
                components4 = components4;
                i = 1;
                m1382appendFractionalimpl(arg0, $this$toString_impl_u24lambda_u240, nanoseconds / DurationKt.NANOS_IN_MILLIS, nanoseconds % DurationKt.NANOS_IN_MILLIS, 6, "ms", false);
            } else {
                components4 = components4;
                i = 1;
                if (nanoseconds >= 1000) {
                    m1382appendFractionalimpl(arg0, $this$toString_impl_u24lambda_u240, nanoseconds / 1000, nanoseconds % 1000, 3, "us", false);
                } else {
                    $this$toString_impl_u24lambda_u240.append(nanoseconds).append("ns");
                }
            }
            components = components4;
        } else {
            i = 1;
        }
        if (isNegative && components > i) {
            $this$toString_impl_u24lambda_u240.insert(i, '(').append(')');
        }
        return $this$toString_impl_u24lambda_u240.toString();
    }

    public String toString() {
        return m1425toStringimpl(this.rawValue);
    }

    private static final void m1382appendFractionalimpl(long arg0, StringBuilder $this$appendFractional, int whole, int fractional, int fractionalSize, String unit, boolean isoZeroes) {
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

    public static  String m1427toStringimpl$default(long j, DurationUnit durationUnit, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        return m1426toStringimpl(j, durationUnit, i);
    }

    public static final String m1426toStringimpl(long arg0, DurationUnit unit, int decimals) {
        Intrinsics.checkNotNullParameter(unit, "unit");
        if (!(decimals >= 0)) {
            throw new IllegalArgumentException(("decimals must be not negative, but was " + decimals).toString());
        }
        double number = m1421toDoubleimpl(arg0, unit);
        return Double.isInfinite(number) ? String.valueOf(number) : DurationJvmKt.formatToExactDecimals(number, RangesKt.coerceAtMost(decimals, 12)) + DurationUnitKt.shortName(unit);
    }

    public static final String m1423toIsoStringimpl(long arg0) {
        StringBuilder $this$toIsoString_impl_u24lambda_u240 = new StringBuilder();
        if (m1411isNegativeimpl(arg0)) {
            $this$toIsoString_impl_u24lambda_u240.append('-');
        }
        $this$toIsoString_impl_u24lambda_u240.append("PT");
        long arg0$iv = m1391getAbsoluteValueUwyO8pc(arg0);
        long hours = m1394getInWholeHoursimpl(arg0$iv);
        int minutes = m1400getMinutesComponentimpl(arg0$iv);
        int seconds = m1402getSecondsComponentimpl(arg0$iv);
        int nanoseconds = m1401getNanosecondsComponentimpl(arg0$iv);
        if (m1410isInfiniteimpl(arg0)) {
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
            $this$toIsoString_impl_u24lambda_u240.append(hours).append('H');
        }
        if (hasMinutes) {
            $this$toIsoString_impl_u24lambda_u240.append(minutes).append('M');
        }
        if (hasSeconds || (!hasHours && !hasMinutes)) {
            m1382appendFractionalimpl(arg0, $this$toIsoString_impl_u24lambda_u240, seconds, nanoseconds, 9, "S", true);
        }
        return $this$toIsoString_impl_u24lambda_u240.toString();
    }
}
