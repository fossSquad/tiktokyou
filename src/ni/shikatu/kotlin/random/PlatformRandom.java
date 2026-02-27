package ni.shikatu.kotlin.random;

import java.io.Serializable;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0002\u0018\u0000 \n2\u00020\u00012\u00060\u0002j\u0002`\u0003:\u0001\nB\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u000b"}, d2 = {"Lni/shikatu/kotlin/random/PlatformRandom;", "Lni/shikatu/kotlin/random/AbstractPlatformRandom;", "Ljava/io/Serializable;", "Lni/shikatu/kotlin/io/Serializable;", "impl", "Ljava/util/Random;", "<init>", "(Ljava/util/Random;)V", "getImpl", "()Ljava/util/Random;", "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class PlatformRandom extends AbstractPlatformRandom implements Serializable {
    private static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 0;
    private final java.util.Random impl;

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/random/PlatformRandom$Companion;", "", "<init>", "()V", "serialVersionUID", "", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    private static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public PlatformRandom(java.util.Random impl) {
        Intrinsics.checkNotNullParameter(impl, "impl");
        this.impl = impl;
    }

    @Override
    public java.util.Random getImpl() {
        return this.impl;
    }
}
