package ni.shikatu.kotlinx.serialization.json.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.descriptors.ContextAwareKt;
import ni.shikatu.kotlinx.serialization.descriptors.PolymorphicKind;
import ni.shikatu.kotlinx.serialization.descriptors.PrimitiveKind;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialKind;
import ni.shikatu.kotlinx.serialization.descriptors.StructureKind;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0080\u0080\u0004\u001aT\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006\"\b\b\u0001\u0010\u0007*\u0002H\u0006\"\b\b\u0002\u0010\b*\u0002H\u0006*\u00020\u00022\u0006\u0010\t\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\b0\u000bH\u0080\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u0016\u0010\u000e\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0010H\u0080\u0080\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0011"}, d2 = {"switchMode", "Lni/shikatu/kotlinx/serialization/json/internal/WriteMode;", "Lni/shikatu/kotlinx/serialization/json/Json;", "desc", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "selectMapMode", "T", "R1", "R2", "mapDescriptor", "ifMap", "Lni/shikatu/kotlin/Function0;", "ifList", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "carrierDescriptor", "module", "Lni/shikatu/kotlinx/serialization/modules/SerializersModule;", "ni.shikatu.kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class WriteModeKt {
    public static final WriteMode switchMode(Json $this$switchMode, SerialDescriptor desc) {
        WriteMode writeMode;
        Intrinsics.checkNotNullParameter($this$switchMode, "<this>");
        Intrinsics.checkNotNullParameter(desc, "desc");
        SerialKind kind = desc.getKind();
        if (kind instanceof PolymorphicKind) {
            return WriteMode.POLY_OBJ;
        }
        if (Intrinsics.areEqual(kind, StructureKind.LIST.INSTANCE)) {
            return WriteMode.LIST;
        }
        if (!Intrinsics.areEqual(kind, StructureKind.MAP.INSTANCE)) {
            return WriteMode.OBJ;
        }
        SerialDescriptor keyDescriptor$iv = carrierDescriptor(desc.getElementDescriptor(0), $this$switchMode.getSerializersModule());
        SerialKind keyKind$iv = keyDescriptor$iv.getKind();
        if ((keyKind$iv instanceof PrimitiveKind) || Intrinsics.areEqual(keyKind$iv, SerialKind.ENUM.INSTANCE)) {
            writeMode = WriteMode.MAP;
        } else if ($this$switchMode.getConfiguration().getAllowStructuredMapKeys()) {
            writeMode = WriteMode.LIST;
        } else {
            throw JsonExceptionsKt.InvalidKeyKindException(keyDescriptor$iv);
        }
        return writeMode;
    }

    public static final <T, R1 extends T, R2 extends T> T selectMapMode(Json json, SerialDescriptor serialDescriptor, Function0<? extends R1> function0, Function0<? extends R2> function1) {
        Intrinsics.checkNotNullParameter(json, "<this>");
        Intrinsics.checkNotNullParameter(serialDescriptor, "mapDescriptor");
        Intrinsics.checkNotNullParameter(function0, "ifMap");
        Intrinsics.checkNotNullParameter(function1, "ifList");
        SerialDescriptor serialDescriptorCarrierDescriptor = carrierDescriptor(serialDescriptor.getElementDescriptor(0), json.getSerializersModule());
        SerialKind kind = serialDescriptorCarrierDescriptor.getKind();
        if ((kind instanceof PrimitiveKind) || Intrinsics.areEqual(kind, SerialKind.ENUM.INSTANCE)) {
            return function0.invoke();
        }
        if (json.getConfiguration().getAllowStructuredMapKeys()) {
            return function1.invoke();
        }
        throw JsonExceptionsKt.InvalidKeyKindException(serialDescriptorCarrierDescriptor);
    }

    public static final SerialDescriptor carrierDescriptor(SerialDescriptor $this$carrierDescriptor, SerializersModule module) {
        SerialDescriptor serialDescriptorCarrierDescriptor;
        Intrinsics.checkNotNullParameter($this$carrierDescriptor, "<this>");
        Intrinsics.checkNotNullParameter(module, "module");
        if (Intrinsics.areEqual($this$carrierDescriptor.getKind(), SerialKind.CONTEXTUAL.INSTANCE)) {
            SerialDescriptor contextualDescriptor = ContextAwareKt.getContextualDescriptor(module, $this$carrierDescriptor);
            if (contextualDescriptor != null && (serialDescriptorCarrierDescriptor = carrierDescriptor(contextualDescriptor, module)) != null) {
                return serialDescriptorCarrierDescriptor;
            }
        } else if ($this$carrierDescriptor.isInline()) {
            return carrierDescriptor($this$carrierDescriptor.getElementDescriptor(0), module);
        }
        return $this$carrierDescriptor;
    }
}
