package ni.shikatu.kotlinx.serialization.internal;

import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlinx.serialization.SerializationException;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a \u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0081\u0080\u0004\u001a\"\u0010\u0000\u001a\u00020\u00012\n\u0010\u0006\u001a\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H\u0081\u0080\u0004¨\u0006\u0007"}, d2 = {"throwSubtypeNotRegistered", _UrlKt.FRAGMENT_ENCODE_SET, "subClassName", _UrlKt.FRAGMENT_ENCODE_SET, "baseClass", "Lni/shikatu/kotlin/reflect/KClass;", "subClass", "ni.shikatu.kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class AbstractPolymorphicSerializerKt {
    public static final Void throwSubtypeNotRegistered(String subClassName, KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "baseClass");
        String scope = "in the polymorphic scope of '" + kClass.getSimpleName() + '\'';
        throw new SerializationException(subClassName == null ? "Class discriminator was missing and no default serializers were registered " + scope + '.' : "Serializer for subclass '" + subClassName + "' is not found " + scope + ".\nCheck if class with serial name '" + subClassName + "' exists and serializer is registered in a corresponding SerializersModule.\nTo be registered automatically, class '" + subClassName + "' has to be '@Serializable', and the base class '" + kClass.getSimpleName() + "' has to be sealed and '@Serializable'.");
    }

    public static final Void throwSubtypeNotRegistered(KClass<?> kClass, KClass<?> kClass2) {
        Intrinsics.checkNotNullParameter(kClass, "subClass");
        Intrinsics.checkNotNullParameter(kClass2, "baseClass");
        String simpleName = kClass.getSimpleName();
        if (simpleName == null) {
            simpleName = String.valueOf(kClass);
        }
        throwSubtypeNotRegistered(simpleName, kClass2);
        throw new KotlinNothingValueException();
    }
}
