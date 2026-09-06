package ni.shikatu.kotlinx.serialization.modules;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\b@\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0004\b\u0005\u0010\u0006B!\bP\u0012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b\u0012\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\b¢\u0006\u0004\b\u0005\u0010\n¨\u0006\u000b"}, d2 = {"Lni/shikatu/kotlinx/serialization/modules/SerializerAlreadyRegisteredException;", "Ljava/lang/IllegalArgumentException;", "Lni/shikatu/kotlin/IllegalArgumentException;", "msg", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;)V", "baseClass", "Lni/shikatu/kotlin/reflect/KClass;", "concreteClass", "(Lkotlin/reflect/KClass;Lkotlin/reflect/KClass;)V", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class SerializerAlreadyRegisteredException extends IllegalArgumentException {

    public SerializerAlreadyRegisteredException(String msg) {
        super(msg);
        Intrinsics.checkNotNullParameter(msg, "msg");
    }

    public SerializerAlreadyRegisteredException(KClass<?> kClass, KClass<?> kClass2) {
        this("Serializer for " + kClass2 + " already registered in the scope of " + kClass);
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        Intrinsics.checkNotNullParameter(kClass2, "concreteClass");
    }
}
