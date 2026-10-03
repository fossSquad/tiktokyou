package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0002\u0005\u0006J\n\u0010\u0002\u001a\u00020\u0003H¦\u0080\u0004J\f\u0010\u0004\u001a\u0004\u0018\u00010\u0003H¦\u0080\u0004\u0082\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lni/shikatu/kotlin/time/InstantParseResult;", _UrlKt.FRAGMENT_ENCODE_SET, "toInstant", "Lni/shikatu/kotlin/time/Instant;", "toInstantOrNull", "Success", "Failure", "Lni/shikatu/kotlin/time/InstantParseResult$Failure;", "Lni/shikatu/kotlin/time/InstantParseResult$Success;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
interface InstantParseResult {
    Instant toInstant();

    Instant toInstantOrNull();

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004J\f\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lni/shikatu/kotlin/time/InstantParseResult$Success;", "Lni/shikatu/kotlin/time/InstantParseResult;", "epochSeconds", _UrlKt.FRAGMENT_ENCODE_SET, "nanosecondsOfSecond", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(JI)V", "getEpochSeconds", "()J", "getNanosecondsOfSecond", "()I", "toInstant", "Lni/shikatu/kotlin/time/Instant;", "toInstantOrNull", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Success implements InstantParseResult {
        private final long epochSeconds;
        private final int nanosecondsOfSecond;

        public Success(long epochSeconds, int nanosecondsOfSecond) {
            this.epochSeconds = epochSeconds;
            this.nanosecondsOfSecond = nanosecondsOfSecond;
        }

        public final long getEpochSeconds() {
            return this.epochSeconds;
        }

        public final int getNanosecondsOfSecond() {
            return this.nanosecondsOfSecond;
        }

        @Override
        public Instant toInstant() {
            if (this.epochSeconds < Instant.Companion.getMIN$kotlin_stdlib().getEpochSeconds() || this.epochSeconds > Instant.Companion.getMAX$kotlin_stdlib().getEpochSeconds()) {
                throw new InstantFormatException("The parsed date is outside the range representable by Instant (Unix epoch second " + this.epochSeconds + ')');
            }
            return Instant.Companion.fromEpochSeconds(this.epochSeconds, this.nanosecondsOfSecond);
        }

        @Override
        public Instant toInstantOrNull() {
            if (this.epochSeconds < Instant.Companion.getMIN$kotlin_stdlib().getEpochSeconds() || this.epochSeconds > Instant.Companion.getMAX$kotlin_stdlib().getEpochSeconds()) {
                return null;
            }
            return Instant.Companion.fromEpochSeconds(this.epochSeconds, this.nanosecondsOfSecond);
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\n\u0010\f\u001a\u00020\rH\u0096\u0080\u0004J\f\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0096\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0015\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u000f"}, d2 = {"Lni/shikatu/kotlin/time/InstantParseResult$Failure;", "Lni/shikatu/kotlin/time/InstantParseResult;", "error", _UrlKt.FRAGMENT_ENCODE_SET, "input", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;Ljava/lang/CharSequence;)V", "getError", "()Ljava/lang/String;", "getInput", "()Ljava/lang/CharSequence;", "toInstant", "Lni/shikatu/kotlin/time/Instant;", "toInstantOrNull", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Failure implements InstantParseResult {
        private final String error;
        private final CharSequence input;

        public Failure(String error, CharSequence input) {
            Intrinsics.checkNotNullParameter(error, "error");
            Intrinsics.checkNotNullParameter(input, "input");
            this.error = error;
            this.input = input;
        }

        public final String getError() {
            return this.error;
        }

        public final CharSequence getInput() {
            return this.input;
        }

        @Override
        public Instant toInstant() {
            throw new InstantFormatException(this.error + " when parsing an Instant from \"" + InstantKt.truncateForErrorMessage(this.input, 64) + '\"');
        }

        @Override
        public Instant toInstantOrNull() {
            return null;
        }
    }
}
