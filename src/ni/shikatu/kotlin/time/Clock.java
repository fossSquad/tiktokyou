package ni.shikatu.kotlin.time;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\bg\u0018\u0000 \u00052\u00020\u0001:\u0002\u0004\u0005J\n\u0010\u0002\u001a\u00020\u0003H¦\u0080\u0004Ê\u0001\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\tÊ\u0001\u0010\b\n\u0012\f\b\u000b\u0012\b\b\fJ\u0004\b\t0\f¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/time/Clock;", _UrlKt.FRAGMENT_ENCODE_SET, "now", "Lni/shikatu/kotlin/time/Instant;", "System", "Companion", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "2.3", "Lni/shikatu/kotlin/WasExperimental;", "markerClass", "Lni/shikatu/kotlin/time/ExperimentalTime;"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface Clock {
    public static final Companion Companion = ni.shikatu.kotlin.time.Clock.Companion.$$INSTANCE;

    Instant now();

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005H\u0096\u0080\u0004¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/time/Clock$System;", "Lni/shikatu/kotlin/time/Clock;", "<init>", "()V", "now", "Lni/shikatu/kotlin/time/Instant;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class System implements Clock {
        public static final System INSTANCE = new System();

        private System() {
        }

        @Override
        public Instant now() {
            return InstantJvmKt.systemClockNow();
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lni/shikatu/kotlin/time/Clock$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        static final  Companion $$INSTANCE = new Companion();

        private Companion() {
        }
    }
}
