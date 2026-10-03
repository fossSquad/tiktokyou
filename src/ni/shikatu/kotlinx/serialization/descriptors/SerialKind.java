package ni.shikatu.kotlinx.serialization.descriptors;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\b\tB\t\bD¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u00020\u0005H\u0096\u0080\u0004J\n\u0010\u0006\u001a\u00020\u0007H\u0096\u0080\u0004\u0082\u0001\u0005\n\u000b\f\r\u000e¨\u0006\u000f"}, d2 = {"Lni/shikatu/kotlinx/serialization/descriptors/SerialKind;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "ENUM", "CONTEXTUAL", "Lni/shikatu/kotlinx/serialization/descriptors/PolymorphicKind;", "Lni/shikatu/kotlinx/serialization/descriptors/PrimitiveKind;", "Lni/shikatu/kotlinx/serialization/descriptors/SerialKind$CONTEXTUAL;", "Lni/shikatu/kotlinx/serialization/descriptors/SerialKind$ENUM;", "Lni/shikatu/kotlinx/serialization/descriptors/StructureKind;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public abstract class SerialKind {
    public  SerialKind(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private SerialKind() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lni/shikatu/kotlinx/serialization/descriptors/SerialKind$ENUM;", "Lni/shikatu/kotlinx/serialization/descriptors/SerialKind;", "<init>", "()V", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class ENUM extends SerialKind {
        public static final ENUM INSTANCE = new ENUM();

        private ENUM() {
            super(null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lni/shikatu/kotlinx/serialization/descriptors/SerialKind$CONTEXTUAL;", "Lni/shikatu/kotlinx/serialization/descriptors/SerialKind;", "<init>", "()V", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public static final class CONTEXTUAL extends SerialKind {
        public static final CONTEXTUAL INSTANCE = new CONTEXTUAL();

        private CONTEXTUAL() {
            super(null);
        }
    }

    public String toString() {
        String simpleName = Reflection.getOrCreateKotlinClass(getClass()).getSimpleName();
        Intrinsics.checkNotNull(simpleName);
        return simpleName;
    }

    public int hashCode() {
        return toString().hashCode();
    }
}
