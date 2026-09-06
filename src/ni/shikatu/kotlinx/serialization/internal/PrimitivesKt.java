package ni.shikatu.kotlinx.serialization.internal;

import java.util.Map;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.text.CharsKt;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.descriptors.PrimitiveKind;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\u001a\u001a\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0080\u0080\u0004\u001a\u0012\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0006\u001a\u00020\u0007H\u0080\u0080\u0004\u001a\u000e\u0010\f\u001a\u00020\u0007*\u00020\u0007H\u0082\u0080\u0004\u001a&\u0010\r\u001a\n\u0012\u0004\u0012\u0002H\u000e\u0018\u00010\u0003\"\b\b\u0000\u0010\u000e*\u00020\u000f*\b\u0012\u0004\u0012\u0002H\u000e0\u0002H\u0080\u0080\u0004\"#\u0010\u0000\u001a\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0002\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0001X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"BUILTIN_SERIALIZERS", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/reflect/KClass;", "Lni/shikatu/kotlinx/serialization/KSerializer;", "PrimitiveDescriptorSafe", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "serialName", _UrlKt.FRAGMENT_ENCODE_SET, "kind", "Lni/shikatu/kotlinx/serialization/descriptors/PrimitiveKind;", "checkNameIsNotAPrimitive", _UrlKt.FRAGMENT_ENCODE_SET, "capitalize", "builtinSerializerOrNull", "T", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PrimitivesKt {
    private static final Map<KClass<?>, KSerializer<?>> BUILTIN_SERIALIZERS = PlatformKt.initBuiltins();

    public static final SerialDescriptor PrimitiveDescriptorSafe(String serialName, PrimitiveKind kind) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        checkNameIsNotAPrimitive(serialName);
        return new PrimitiveSerialDescriptor(serialName, kind);
    }

    public static final void checkNameIsNotAPrimitive(String serialName) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        for (KSerializer<?> kSerializer : BUILTIN_SERIALIZERS.values()) {
            String primitiveName = kSerializer.getDescriptor().getSerialName();
            if (Intrinsics.areEqual(serialName, primitiveName)) {
                throw new IllegalArgumentException(StringsKt.trimIndent("\n                The name of serial descriptor should uniquely identify associated serializer.\n                For serial name " + serialName + " there already exists " + Reflection.getOrCreateKotlinClass(kSerializer.getClass()).getSimpleName() + ".\n                Please refer to SerialDescriptor documentation for additional information.\n            "));
            }
        }
    }

    private static final String capitalize(String $this$capitalize) {
        if (!($this$capitalize.length() > 0)) {
            return $this$capitalize;
        }
        StringBuilder sb = new StringBuilder();
        char it = $this$capitalize.charAt(0);
        StringBuilder sbAppend = sb.append((Object) (Character.isLowerCase(it) ? CharsKt.titlecase(it) : String.valueOf(it)));
        String strSubstring = $this$capitalize.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return sbAppend.append(strSubstring).toString();
    }

    public static final <T> KSerializer<T> builtinSerializerOrNull(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return (KSerializer) BUILTIN_SERIALIZERS.get(kClass);
    }
}
