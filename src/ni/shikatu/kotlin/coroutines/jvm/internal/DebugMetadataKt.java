package ni.shikatu.kotlin.coroutines.jvm.internal;

import java.lang.reflect.Field;
import java.util.ArrayList;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0006\u001a5\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0003b\u0002\b\t¢\u0006\u0002\b\u0003\u001a\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b*\u00020\u0002H\u0082\u0080\u0004\u001a\u000e\u0010\f\u001a\u00020\r*\u00020\u0002H\u0082\u0080\u0004\u001a;\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000f*\u00020\u0002H\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006b\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000eb\u0002\b\t¢\u0006\u0002\u0010\u0011\u001a \u0010\u0014\u001a\u00020\r*\u00020\u0002H\u0081\u0080\u0004b\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015b\u0002\b\t\"\u000f\u0010\u0012\u001a\u00020\rX\u0082Ô\b¢\u0006\u0002\n\u0000\"\u000f\u0010\u0013\u001a\u00020\rX\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"getStackTraceElementImpl", "Ljava/lang/StackTraceElement;", "Lni/shikatu/kotlin/coroutines/jvm/internal/BaseContinuationImpl;", "getStackTraceElement", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "Lni/shikatu/kotlin/jvm/JvmName;", "name", "Lni/shikatu/kotlin/PublishedApi;", "getDebugMetadataAnnotation", "Lni/shikatu/kotlin/coroutines/jvm/internal/DebugMetadata;", "getLabel", _UrlKt.FRAGMENT_ENCODE_SET, "getSpilledVariableFieldMapping", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlin/coroutines/jvm/internal/BaseContinuationImpl;)[Ljava/lang/String;", "COROUTINES_DEBUG_METADATA_VERSION_1_3", "COROUTINES_DEBUG_METADATA_VERSION_2_2", "getNextLineNumber", "2.2", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class DebugMetadataKt {
    private static final int COROUTINES_DEBUG_METADATA_VERSION_1_3 = 1;
    private static final int COROUTINES_DEBUG_METADATA_VERSION_2_2 = 2;

    public static final StackTraceElement getStackTraceElement(BaseContinuationImpl $this$getStackTraceElementImpl) {
        Intrinsics.checkNotNullParameter($this$getStackTraceElementImpl, "<this>");
        DebugMetadata debugMetadata = getDebugMetadataAnnotation($this$getStackTraceElementImpl);
        if (debugMetadata == null || debugMetadata.v() < 1) {
            return null;
        }
        int label = getLabel($this$getStackTraceElementImpl);
        int lineNumber = label < 0 ? -1 : debugMetadata.l()[label];
        String moduleName = ModuleNameRetriever.INSTANCE.getModuleName($this$getStackTraceElementImpl);
        String moduleAndClass = moduleName == null ? debugMetadata.c() : moduleName + '/' + debugMetadata.c();
        return new StackTraceElement(moduleAndClass, debugMetadata.m(), debugMetadata.f(), lineNumber);
    }

    private static final DebugMetadata getDebugMetadataAnnotation(BaseContinuationImpl $this$getDebugMetadataAnnotation) {
        return (DebugMetadata) $this$getDebugMetadataAnnotation.getClass().getAnnotation(DebugMetadata.class);
    }

    private static final int getLabel(BaseContinuationImpl $this$getLabel) {
        if ($this$getLabel instanceof TailCallBaseContinuationImpl) {
            return 0;
        }
        try {
            Field field = $this$getLabel.getClass().getDeclaredField("label");
            field.setAccessible(true);
            Object obj = field.get($this$getLabel);
            Integer num = obj instanceof Integer ? (Integer) obj : null;
            return (num != null ? num.intValue() : 0) - 1;
        } catch (Exception e) {
            return -1;
        }
    }

    public static final String[] getSpilledVariableFieldMapping(BaseContinuationImpl $this$getSpilledVariableFieldMapping) {
        Intrinsics.checkNotNullParameter($this$getSpilledVariableFieldMapping, "<this>");
        DebugMetadata debugMetadata = getDebugMetadataAnnotation($this$getSpilledVariableFieldMapping);
        if (debugMetadata == null || debugMetadata.v() < 1) {
            return null;
        }
        ArrayList res = new ArrayList();
        int label = getLabel($this$getSpilledVariableFieldMapping);
        int[] iArrI = debugMetadata.i();
        int length = iArrI.length;
        for (int i = 0; i < length; i++) {
            int i2 = i;
            int labelOfIndex = iArrI[i];
            if (labelOfIndex == label) {
                res.add(debugMetadata.s()[i2]);
                res.add(debugMetadata.n()[i2]);
            }
        }
        ArrayList $this$toTypedArray$iv = res;
        return (String[]) $this$toTypedArray$iv.toArray(new String[0]);
    }

    public static final int getNextLineNumber(BaseContinuationImpl $this$getNextLineNumber) {
        int label;
        Intrinsics.checkNotNullParameter($this$getNextLineNumber, "<this>");
        DebugMetadata debugMetadata = getDebugMetadataAnnotation($this$getNextLineNumber);
        if (debugMetadata != null && debugMetadata.v() >= 2 && (label = getLabel($this$getNextLineNumber)) >= 0 && label < debugMetadata.nl().length) {
            return debugMetadata.nl()[label];
        }
        return -1;
    }
}
