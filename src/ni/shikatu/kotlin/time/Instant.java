package ni.shikatu.kotlin.time;

import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.NotImplementedError;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.LongCompanionObject;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0007\u0018\u0000 '2\b\u0012\u0004\u0012\u00020\u00000\u00012\u00060\u0002j\u0002`\u0003:\u0001'B\u0019\b@\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u0010\u000e\u001a\u00020\u0005H\u0086\u0080\u0004J\u0019\u0010\u000f\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\u0082\u0004¢\u0006\u0004\b\u0012\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0011H\u0086\u0082\u0004¢\u0006\u0004\b\u0015\u0010\u0013J\u0019\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0000H\u0086\u0082\u0004¢\u0006\u0004\b\u0017\u0010\u0018J\u0012\u0010\u0019\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0000H\u0096\u0082\u0004J\u0014\u0010\u001a\u001a\u00020\u001b2\b\u0010\u0016\u001a\u0004\u0018\u00010\u001cH\u0096\u0082\u0004J\n\u0010\u001d\u001a\u00020\u0007H\u0096\u0080\u0004J\n\u0010\u001e\u001a\u00020\u001fH\u0096\u0080\u0004J\n\u0010 \u001a\u00020\u001cH\u0082\u0080\u0004J\u001b\u0010!\u001a\u00020\"2\n\u0010#\u001a\u00060$j\u0002`%H\u0082\u0080\u0004¢\u0006\u0002\u0010&R\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0015\u0010\u0006\u001a\u00020\u0007X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rÊ\u0001\f\b)\u0012\b\b*\u0012\u0004\b\b(+Ê\u0001\u0010\b,\u0012\f\b-\u0012\b\b\fJ\u0004\b\t0.¨\u0006("}, d2 = {"Lni/shikatu/kotlin/time/Instant;", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/io/Serializable;", "Lni/shikatu/kotlin/io/Serializable;", "epochSeconds", _UrlKt.FRAGMENT_ENCODE_SET, "nanosecondsOfSecond", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(JI)V", "getEpochSeconds", "()J", "getNanosecondsOfSecond", "()I", "toEpochMilliseconds", "plus", "duration", "Lni/shikatu/kotlin/time/Duration;", "plus-LRDsOJo", "(J)Lkotlin/time/Instant;", "minus", "minus-LRDsOJo", "other", "minus-UwyO8pc", "(Lkotlin/time/Instant;)J", "compareTo", "equals", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "writeReplace", "readObject", _UrlKt.FRAGMENT_ENCODE_SET, "input", "Ljava/io/ObjectInputStream;", "Lni/shikatu/kotlin/internal/ReadObjectParameterType;", "(Ljava/io/ObjectInputStream;)V", "Companion", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "2.3", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/time/ExperimentalTime;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class Instant implements Comparable<Instant>, Serializable {
    private final long epochSeconds;
    private final int nanosecondsOfSecond;
    public static final Companion Companion = new Companion(null);
    private static final Instant MIN = new Instant(-31557014167219200L, 0);
    private static final Instant MAX = new Instant(31556889864403199L, 999999999);

    public Instant(long epochSeconds, int nanosecondsOfSecond) {
        this.epochSeconds = epochSeconds;
        this.nanosecondsOfSecond = nanosecondsOfSecond;
        long j = this.epochSeconds;
        boolean z = false;
        if (-31557014167219200L <= j && j < 31556889864403200L) {
            z = true;
        }
        if (!z) {
            throw new IllegalArgumentException("Instant exceeds minimum or maximum instant".toString());
        }
    }

    public final long getEpochSeconds() {
        return this.epochSeconds;
    }

    public final int getNanosecondsOfSecond() {
        return this.nanosecondsOfSecond;
    }

    public final long toEpochMilliseconds() {
        if (this.epochSeconds >= 0) {
            long a$iv = this.epochSeconds;
            if (1000 != 1) {
                if (a$iv == 1) {
                    a$iv = 1000;
                } else if (a$iv == 0 || 1000 == 0) {
                    a$iv = 0;
                } else {
                    long total$iv = a$iv * 1000;
                    if (total$iv / 1000 != a$iv || ((a$iv == Long.MIN_VALUE && 1000 == -1) || (1000 == Long.MIN_VALUE && a$iv == -1))) {
                        return LongCompanionObject.MAX_VALUE;
                    }
                    a$iv = total$iv;
                }
            }
            long b$iv = this.nanosecondsOfSecond / DurationKt.NANOS_IN_MILLIS;
            long a$iv2 = a$iv;
            long sum$iv = a$iv2 + b$iv;
            return ((a$iv2 ^ sum$iv) >= 0 || (a$iv2 ^ b$iv) < 0) ? sum$iv : LongCompanionObject.MAX_VALUE;
        }
        long millis = this.epochSeconds;
        long a$iv3 = millis + 1;
        if (1000 != 1) {
            if (a$iv3 == 1) {
                a$iv3 = 1000;
            } else if (a$iv3 == 0 || 1000 == 0) {
                a$iv3 = 0;
            } else {
                long total$iv2 = a$iv3 * 1000;
                if (total$iv2 / 1000 != a$iv3 || ((a$iv3 == Long.MIN_VALUE && 1000 == -1) || (1000 == Long.MIN_VALUE && a$iv3 == -1))) {
                    return Long.MIN_VALUE;
                }
                a$iv3 = total$iv2;
            }
        }
        long b$iv2 = (this.nanosecondsOfSecond / DurationKt.NANOS_IN_MILLIS) - 1000;
        long a$iv4 = a$iv3;
        long sum$iv2 = a$iv4 + b$iv2;
        if ((a$iv4 ^ sum$iv2) >= 0 || (a$iv4 ^ b$iv2) < 0) {
            return sum$iv2;
        }
        return Long.MIN_VALUE;
    }

    public final Instant m1490plusLRDsOJo(long duration) {
        long secondsToAdd = Duration.m1399getInWholeSecondsimpl(duration);
        int nanosecondsToAdd = Duration.m1401getNanosecondsComponentimpl(duration);
        if (secondsToAdd == 0 && nanosecondsToAdd == 0) {
            return this;
        }
        long a$iv = this.epochSeconds;
        long sum$iv = a$iv + secondsToAdd;
        if ((a$iv ^ sum$iv) < 0 && (a$iv ^ secondsToAdd) >= 0) {
            return Duration.m1412isPositiveimpl(duration) ? MAX : MIN;
        }
        int nanoAdjustment = this.nanosecondsOfSecond + nanosecondsToAdd;
        return Companion.fromEpochSeconds(sum$iv, nanoAdjustment);
    }

    public final Instant m1488minusLRDsOJo(long duration) {
        return m1490plusLRDsOJo(Duration.m1429unaryMinusUwyO8pc(duration));
    }

    public final long m1489minusUwyO8pc(Instant other) {
        Intrinsics.checkNotNullParameter(other, "other");
        Duration.Companion companion = Duration.Companion;
        long duration = DurationKt.toDuration(this.epochSeconds - other.epochSeconds, DurationUnit.SECONDS);
        Duration.Companion companion2 = Duration.Companion;
        return Duration.m1414plusLRDsOJo(duration, DurationKt.toDuration(this.nanosecondsOfSecond - other.nanosecondsOfSecond, DurationUnit.NANOSECONDS));
    }

    @Override
    public int compareTo(Instant other) {
        Intrinsics.checkNotNullParameter(other, "other");
        int s = Intrinsics.compare(this.epochSeconds, other.epochSeconds);
        if (s != 0) {
            return s;
        }
        return Intrinsics.compare(this.nanosecondsOfSecond, other.nanosecondsOfSecond);
    }

    public boolean equals(Object other) {
        return this == other || ((other instanceof Instant) && this.epochSeconds == ((Instant) other).epochSeconds && this.nanosecondsOfSecond == ((Instant) other).nanosecondsOfSecond);
    }

    public int hashCode() {
        return Long.hashCode(this.epochSeconds) + (this.nanosecondsOfSecond * 51);
    }

    public String toString() {
        return InstantKt.formatIso(this);
    }

    private final Object writeReplace() {
        return InstantJvmKt.serializedInstant(this);
    }

    private final void readObject(ObjectInputStream input) throws InvalidObjectException {
        throw new InvalidObjectException("Deserialization is supported via proxy only");
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003JH\u0010\u0004\u001a\u00020\u0005H\u0087\u0080\u0004b<\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\"\b\t\u0012\u001e\b\u000bB\u001a\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\f\b\r\u0012\b\b\fJ\u0004\b\b(\u000e\u0012\n\b\u000f\u0012\u0006\b\n0\u00108\u0011J\u0012\u0010\u0012\u001a\u00020\u00052\u0006\u0010\u0013\u001a\u00020\u0014H\u0086\u0080\u0004J\u001c\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u0014H\u0086\u0080\u0004J\u001a\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0086\u0080\u0004J\u0012\u0010\u0019\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0086\u0080\u0004J\u0014\u0010\u001c\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0086\u0080\u0004R\u0015\u0010\u001d\u001a\u00020\u00058FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0015\u0010 \u001a\u00020\u00058FX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b!\u0010\u001fR\u0015\u0010\"\u001a\u00020\u0005X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001fR\u0015\u0010$\u001a\u00020\u0005X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001f¨\u0006&"}, d2 = {"Lni/shikatu/kotlin/time/Instant$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "now", "Lni/shikatu/kotlin/time/Instant;", "Lni/shikatu/kotlin/Deprecated;", "message", "Use Clock.System.now() instead", "replaceWith", "Lni/shikatu/kotlin/ReplaceWith;", "expression", "Clock.System.now()", "imports", "ni.shikatu.kotlin.time.Clock", "level", "Lni/shikatu/kotlin/DeprecationLevel;", "ERROR", "fromEpochMilliseconds", "epochMilliseconds", _UrlKt.FRAGMENT_ENCODE_SET, "fromEpochSeconds", "epochSeconds", "nanosecondAdjustment", _UrlKt.FRAGMENT_ENCODE_SET, "parse", "input", _UrlKt.FRAGMENT_ENCODE_SET, "parseOrNull", "DISTANT_PAST", "getDISTANT_PAST", "()Lkotlin/time/Instant;", "DISTANT_FUTURE", "getDISTANT_FUTURE", "MIN", "getMIN$kotlin_stdlib", "MAX", "getMAX$kotlin_stdlib", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "Use Clock.System.now() instead", replaceWith = @ReplaceWith(expression = "Clock.System.now()", imports = {"ni.shikatu.kotlin.time.Clock"}))
        public final Instant now() {
            throw new NotImplementedError(null, 1, null);
        }

        public final Instant fromEpochMilliseconds(long epochMilliseconds) {
            long epochSeconds = epochMilliseconds / 1000;
            if ((epochMilliseconds ^ 1000) < 0 && epochSeconds * 1000 != epochMilliseconds) {
                epochSeconds--;
            }
            long j = epochMilliseconds % 1000;
            int nanosecondsOfSecond = (int) ((j + (1000 & (((j ^ 1000) & ((-j) | j)) >> 63))) * ((long) DurationKt.NANOS_IN_MILLIS));
            if (epochSeconds < -31557014167219200L) {
                return getMIN$kotlin_stdlib();
            }
            return epochSeconds > 31556889864403199L ? getMAX$kotlin_stdlib() : fromEpochSeconds(epochSeconds, nanosecondsOfSecond);
        }

        public static  Instant fromEpochSeconds$default(Companion companion, long j, long j2, int i, Object obj) {
            if ((i & 2) != 0) {
                j2 = 0;
            }
            return companion.fromEpochSeconds(j, j2);
        }

        public final Instant fromEpochSeconds(long epochSeconds, long nanosecondAdjustment) {
            long b$iv = nanosecondAdjustment / 1000000000;
            if ((nanosecondAdjustment ^ 1000000000) < 0 && b$iv * 1000000000 != nanosecondAdjustment) {
                b$iv--;
            }
            long sum$iv = epochSeconds + b$iv;
            if ((epochSeconds ^ sum$iv) < 0 && (epochSeconds ^ b$iv) >= 0) {
                return epochSeconds > 0 ? Instant.Companion.getMAX$kotlin_stdlib() : Instant.Companion.getMIN$kotlin_stdlib();
            }
            if (sum$iv < -31557014167219200L) {
                return getMIN$kotlin_stdlib();
            }
            if (sum$iv > 31556889864403199L) {
                return getMAX$kotlin_stdlib();
            }
            long j = nanosecondAdjustment % 1000000000;
            int nanoseconds = (int) (j + (1000000000 & (((j ^ 1000000000) & ((-j) | j)) >> 63)));
            return new Instant(sum$iv, nanoseconds);
        }

        public final Instant fromEpochSeconds(long epochSeconds, int nanosecondAdjustment) {
            return fromEpochSeconds(epochSeconds, nanosecondAdjustment);
        }

        public final Instant parse(CharSequence input) {
            Intrinsics.checkNotNullParameter(input, "input");
            return InstantKt.parseIso(input).toInstant();
        }

        public final Instant parseOrNull(CharSequence input) {
            Intrinsics.checkNotNullParameter(input, "input");
            return InstantKt.parseIso(input).toInstantOrNull();
        }

        public final Instant getDISTANT_PAST() {
            return fromEpochSeconds(-3217862419201L, 999999999);
        }

        public final Instant getDISTANT_FUTURE() {
            return fromEpochSeconds(3093527980800L, 0);
        }

        public final Instant getMIN$kotlin_stdlib() {
            return Instant.MIN;
        }

        public final Instant getMAX$kotlin_stdlib() {
            return Instant.MAX;
        }
    }
}
