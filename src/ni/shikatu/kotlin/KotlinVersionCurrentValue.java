package ni.shikatu.kotlin;

import ni.shikatu.kotlin.jvm.JvmStatic;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\bÂ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/KotlinVersionCurrentValue;", "", "<init>", "()V", "get", "Lni/shikatu/kotlin/KotlinVersion;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class KotlinVersionCurrentValue {
    public static final KotlinVersionCurrentValue INSTANCE = new KotlinVersionCurrentValue();

    private KotlinVersionCurrentValue() {
    }

    @JvmStatic
    public static final KotlinVersion get() {
        return new KotlinVersion(2, 1, 0);
    }
}
