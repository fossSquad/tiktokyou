package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0002\u0018\u0000 !2\u00020\u0001:\u0001!BA\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003¢\u0006\u0004\b\n\u0010\u000bJX\u0010\u0014\u001a\u0002H\u0015\"\u0004\b\u0000\u0010\u00152\u0006\u0010\u0016\u001a\u00020\u000326\u0010\u0017\u001a2\u0012\u0013\u0012\u00110\u0019¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001c\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u001a\u0012\b\b\u001b\u0012\u0004\b\b(\u001d\u0012\u0004\u0012\u0002H\u00150\u0018H\u0086\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\n\u0010\u001f\u001a\u00020 H\u0096\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\u0004\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0015\u0010\u0005\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\rR\u0015\u0010\u0006\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\rR\u0015\u0010\u0007\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0015\u0010\b\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0015\u0010\t\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\""}, d2 = {"Lni/shikatu/kotlin/time/UnboundLocalDateTime;", _UrlKt.FRAGMENT_ENCODE_SET, "year", _UrlKt.FRAGMENT_ENCODE_SET, "month", "day", "hour", "minute", "second", "nanosecond", "<init>", "(IIIIIII)V", "getYear", "()I", "getMonth", "getDay", "getHour", "getMinute", "getSecond", "getNanosecond", "toInstant", "T", "offsetSeconds", "buildInstant", "Lni/shikatu/kotlin/Function2;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ParameterName;", "name", "epochSeconds", "nanosecondOfSecond", "(ILkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
final class UnboundLocalDateTime {
    public static final Companion Companion = new Companion(null);
    private final int day;
    private final int hour;
    private final int minute;
    private final int month;
    private final int nanosecond;
    private final int second;
    private final int year;

    public UnboundLocalDateTime(int year, int month, int day, int hour, int minute, int second, int nanosecond) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.hour = hour;
        this.minute = minute;
        this.second = second;
        this.nanosecond = nanosecond;
    }

    public final int getYear() {
        return this.year;
    }

    public final int getMonth() {
        return this.month;
    }

    public final int getDay() {
        return this.day;
    }

    public final int getHour() {
        return this.hour;
    }

    public final int getMinute() {
        return this.minute;
    }

    public final int getSecond() {
        return this.second;
    }

    public final int getNanosecond() {
        return this.nanosecond;
    }

    public final <T> T toInstant(int offsetSeconds, Function2<? super Long, ? super Integer, ? extends T> function2) {
        long total;
        Intrinsics.checkNotNullParameter(function2, "buildInstant");
        UnboundLocalDateTime $this$toInstant_u24lambda_u240 = this;
        long y = $this$toInstant_u24lambda_u240.getYear();
        long total2 = ((long) 365) * y;
        if (y >= 0) {
            total = total2 + (((((long) 3) + y) / ((long) 4)) - ((((long) 99) + y) / ((long) 100))) + ((((long) 399) + y) / ((long) 400));
        } else {
            total = total2 - (((y / ((long) (-4))) - (y / ((long) (-100)))) + (y / ((long) (-400))));
        }
        long total3 = total + ((long) ((($this$toInstant_u24lambda_u240.getMonth() * 367) - 362) / 12)) + ((long) ($this$toInstant_u24lambda_u240.getDay() - 1));
        if ($this$toInstant_u24lambda_u240.getMonth() > 2) {
            total3--;
            if (!InstantKt.isLeapYear($this$toInstant_u24lambda_u240.getYear())) {
                total3--;
            }
        }
        long epochDays = total3 - ((long) 719528);
        int daySeconds = ($this$toInstant_u24lambda_u240.getHour() * 3600) + ($this$toInstant_u24lambda_u240.getMinute() * 60) + $this$toInstant_u24lambda_u240.getSecond();
        long epochSeconds = ((((long) 86400) * epochDays) + ((long) daySeconds)) - ((long) offsetSeconds);
        return function2.invoke(Long.valueOf(epochSeconds), Integer.valueOf(getNanosecond()));
    }

    public String toString() {
        return "UnboundLocalDateTime(" + this.year + '-' + this.month + '-' + this.day + ' ' + this.hour + AbstractJsonLexerKt.COLON + this.minute + AbstractJsonLexerKt.COLON + this.second + '.' + this.nanosecond + ')';
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0086\u0080\u0004¨\u0006\b"}, d2 = {"Lni/shikatu/kotlin/time/UnboundLocalDateTime$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "fromInstant", "Lni/shikatu/kotlin/time/UnboundLocalDateTime;", "instant", "Lni/shikatu/kotlin/time/Instant;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final UnboundLocalDateTime fromInstant(Instant instant) {
            int i;
            long doyEst;
            Intrinsics.checkNotNullParameter(instant, "instant");
            long localSecond = instant.getEpochSeconds();
            long epochDays = localSecond / 86400;
            if ((localSecond ^ 86400) < 0 && epochDays * 86400 != localSecond) {
                epochDays--;
            }
            long j = localSecond % 86400;
            int secsOfDay = (int) (j + (((((-j) | j) & (j ^ 86400)) >> 63) & 86400));
            long zeroDay = (((long) 719528) + epochDays) - ((long) 60);
            long adjust = 0;
            if (zeroDay < 0) {
                long j2 = 146097;
                long adjustCycles = ((zeroDay + 1) / j2) - 1;
                i = 400;
                adjust = adjustCycles * ((long) 400);
                zeroDay += (-adjustCycles) * j2;
            } else {
                i = 400;
            }
            long j3 = i;
            long yearEst = ((j3 * zeroDay) + ((long) 591)) / ((long) 146097);
            long j4 = 365;
            long j5 = j4 * yearEst;
            long j6 = 4;
            long j7 = j5 + (yearEst / j6);
            long j8 = 100;
            long doyEst2 = zeroDay - ((j7 - (yearEst / j8)) + (yearEst / j3));
            if (doyEst2 >= 0) {
                doyEst = doyEst2;
            } else {
                yearEst--;
                doyEst = zeroDay - ((((j4 * yearEst) + (yearEst / j6)) - (yearEst / j8)) + (yearEst / j3));
            }
            int marchDoy0 = (int) doyEst;
            int marchMonth0 = ((marchDoy0 * 5) + 2) / 153;
            int month = ((marchMonth0 + 2) % 12) + 1;
            int month2 = marchMonth0 * 306;
            int day = (marchDoy0 - ((month2 + 5) / 10)) + 1;
            int year = (int) (((long) (marchMonth0 / 10)) + yearEst + adjust);
            int hours = secsOfDay / 3600;
            int secondWithoutHours = secsOfDay - (hours * 3600);
            int minutes = secondWithoutHours / 60;
            int second = secondWithoutHours - (minutes * 60);
            return new UnboundLocalDateTime(year, month, day, hours, minutes, second, instant.getNanosecondsOfSecond());
        }
    }
}
