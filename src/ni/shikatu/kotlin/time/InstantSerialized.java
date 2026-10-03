package ni.shikatu.kotlin.time;

import java.io.Externalizable;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0019\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\bV¢\u0006\u0004\b\u0006\u0010\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\n\u0010\u0018\u001a\u00020\u0019H\u0082\u0080\u0004R\u001b\u0010\u0002\u001a\u00020\u0003X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001b\u0010\u0004\u001a\u00020\u0005X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, d2 = {"Lni/shikatu/kotlin/time/InstantSerialized;", "Ljava/io/Externalizable;", "epochSeconds", _UrlKt.FRAGMENT_ENCODE_SET, "nanosecondsOfSecond", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(JI)V", "()V", "getEpochSeconds", "()J", "setEpochSeconds", "(J)V", "getNanosecondsOfSecond", "()I", "setNanosecondsOfSecond", "(I)V", "writeExternal", _UrlKt.FRAGMENT_ENCODE_SET, "output", "Ljava/io/ObjectOutput;", "readExternal", "input", "Ljava/io/ObjectInput;", "readResolve", _UrlKt.FRAGMENT_ENCODE_SET, "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
final class InstantSerialized implements Externalizable {
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 0;
    private long epochSeconds;
    private int nanosecondsOfSecond;

    public InstantSerialized(long epochSeconds, int nanosecondsOfSecond) {
        this.epochSeconds = epochSeconds;
        this.nanosecondsOfSecond = nanosecondsOfSecond;
    }

    public final long getEpochSeconds() {
        return this.epochSeconds;
    }

    public final void setEpochSeconds(long j) {
        this.epochSeconds = j;
    }

    public final int getNanosecondsOfSecond() {
        return this.nanosecondsOfSecond;
    }

    public final void setNanosecondsOfSecond(int i) {
        this.nanosecondsOfSecond = i;
    }

    public InstantSerialized() {
        this(0L, 0);
    }

    @Override
    public void writeExternal(ObjectOutput output) {
        Intrinsics.checkNotNullParameter(output, "output");
        output.writeLong(this.epochSeconds);
        output.writeInt(this.nanosecondsOfSecond);
    }

    @Override
    public void readExternal(ObjectInput input) {
        Intrinsics.checkNotNullParameter(input, "input");
        this.epochSeconds = input.readLong();
        this.nanosecondsOfSecond = input.readInt();
    }

    private final Object readResolve() {
        return Instant.Companion.fromEpochSeconds(this.epochSeconds, this.nanosecondsOfSecond);
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/time/InstantSerialized$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "serialVersionUID", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
