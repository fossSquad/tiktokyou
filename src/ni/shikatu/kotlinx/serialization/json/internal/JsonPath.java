package ni.shikatu.kotlinx.serialization.json.internal;

import java.util.Arrays;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.StructureKind;
import ni.shikatu.kotlinx.serialization.json.JsonConfiguration;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u0001:\u0002\u001d\u001eB\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0086\u0080\u0004J\u0012\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\fH\u0086\u0080\u0004J\u0014\u0010\u0013\u001a\u00020\u000e2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001H\u0086\u0080\u0004J\n\u0010\u0015\u001a\u00020\u000eH\u0086\u0080\u0004J\n\u0010\u0016\u001a\u00020\u000eH\u0086\u0080\u0004J\n\u0010\u0017\u001a\u00020\u0018H\u0086\u0080\u0004J\u0014\u0010\u0019\u001a\u00020\u00182\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u0082\u0080\u0004J\n\u0010\u001b\u001a\u00020\u000eH\u0082\u0080\u0004J\n\u0010\u001c\u001a\u00020\u0018H\u0096\u0080\u0004R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0019\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0007X\u0082\u008e\b¢\u0006\u0004\n\u0002\u0010\bR\u000f\u0010\t\u001a\u00020\nX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\u000b\u001a\u00020\fX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/JsonPath;", _UrlKt.FRAGMENT_ENCODE_SET, "configuration", "Lni/shikatu/kotlinx/serialization/json/JsonConfiguration;", "<init>", "(Lkotlinx/serialization/json/JsonConfiguration;)V", "currentObjectPath", _UrlKt.FRAGMENT_ENCODE_SET, "[Ljava/lang/Object;", "indicies", _UrlKt.FRAGMENT_ENCODE_SET, "currentDepth", _UrlKt.FRAGMENT_ENCODE_SET, "pushDescriptor", _UrlKt.FRAGMENT_ENCODE_SET, "sd", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "updateDescriptorIndex", "index", "updateCurrentMapKey", "key", "resetCurrentMapKey", "popDescriptor", "getPath", _UrlKt.FRAGMENT_ENCODE_SET, "prettyString", "it", "resize", "toString", "Tombstone", "RedactedKey", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JsonPath {
    private final JsonConfiguration configuration;
    private int currentDepth;
    private Object[] currentObjectPath;
    private int[] indicies;

    public JsonPath(JsonConfiguration configuration) {
        Intrinsics.checkNotNullParameter(configuration, "configuration");
        this.configuration = configuration;
        this.currentObjectPath = new Object[8];
        int[] iArr = new int[8];
        for (int i = 0; i < 8; i++) {
            iArr[i] = -1;
        }
        this.indicies = iArr;
        this.currentDepth = -1;
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/JsonPath$Tombstone;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class Tombstone {
        public static final Tombstone INSTANCE = new Tombstone();

        private Tombstone() {
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/JsonPath$RedactedKey;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class RedactedKey {
        public static final RedactedKey INSTANCE = new RedactedKey();

        private RedactedKey() {
        }
    }

    public final void pushDescriptor(SerialDescriptor sd) {
        Intrinsics.checkNotNullParameter(sd, "sd");
        this.currentDepth++;
        int depth = this.currentDepth;
        if (depth == this.currentObjectPath.length) {
            resize();
        }
        this.currentObjectPath[depth] = sd;
    }

    public final void updateDescriptorIndex(int index) {
        this.indicies[this.currentDepth] = index;
    }

    public final void updateCurrentMapKey(Object key) {
        if (this.indicies[this.currentDepth] != -2) {
            this.currentDepth++;
            if (this.currentDepth == this.currentObjectPath.length) {
                resize();
            }
        }
        this.currentObjectPath[this.currentDepth] = this.configuration.getExceptionsWithDebugInfo() ? key : RedactedKey.INSTANCE;
        this.indicies[this.currentDepth] = -2;
    }

    public final void resetCurrentMapKey() {
        if (this.indicies[this.currentDepth] == -2) {
            this.currentObjectPath[this.currentDepth] = Tombstone.INSTANCE;
        }
    }

    public final void popDescriptor() {
        int depth = this.currentDepth;
        if (this.indicies[depth] == -2) {
            this.indicies[depth] = -1;
            this.currentDepth--;
        }
        if (this.currentDepth != -1) {
            this.currentDepth--;
        }
    }

    public final String getPath() {
        StringBuilder $this$getPath_u24lambda_u240 = new StringBuilder();
        $this$getPath_u24lambda_u240.append("$");
        int i = this.currentDepth + 1;
        for (int i2 = 0; i2 < i; i2++) {
            int it = i2;
            Object element = this.currentObjectPath[it];
            if (element instanceof SerialDescriptor) {
                if (Intrinsics.areEqual(((SerialDescriptor) element).getKind(), StructureKind.LIST.INSTANCE)) {
                    if (this.indicies[it] != -1) {
                        $this$getPath_u24lambda_u240.append("[");
                        $this$getPath_u24lambda_u240.append(this.indicies[it]);
                        $this$getPath_u24lambda_u240.append("]");
                    }
                } else {
                    int idx = this.indicies[it];
                    if (idx >= 0) {
                        $this$getPath_u24lambda_u240.append(".");
                        $this$getPath_u24lambda_u240.append(((SerialDescriptor) element).getElementName(idx));
                    }
                }
            } else if (element == RedactedKey.INSTANCE) {
                $this$getPath_u24lambda_u240.append("[<debug info disabled>]");
            } else if (element != Tombstone.INSTANCE) {
                $this$getPath_u24lambda_u240.append("[");
                $this$getPath_u24lambda_u240.append("'");
                $this$getPath_u24lambda_u240.append(element);
                $this$getPath_u24lambda_u240.append("'");
                $this$getPath_u24lambda_u240.append("]");
            }
        }
        return $this$getPath_u24lambda_u240.toString();
    }

    private final String prettyString(Object it) {
        String serialName;
        SerialDescriptor serialDescriptor = it instanceof SerialDescriptor ? (SerialDescriptor) it : null;
        return (serialDescriptor == null || (serialName = serialDescriptor.getSerialName()) == null) ? String.valueOf(it) : serialName;
    }

    private final void resize() {
        int newSize = this.currentDepth * 2;
        Object[] objArrCopyOf = Arrays.copyOf(this.currentObjectPath, newSize);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        this.currentObjectPath = objArrCopyOf;
        int[] newIndices = new int[newSize];
        for (int i = 0; i < newSize; i++) {
            newIndices[i] = -1;
        }
        ArraysKt.copyInto$default(this.indicies, newIndices, 0, 0, 0, 14, (Object) null);
        this.indicies = newIndices;
    }

    public String toString() {
        return getPath();
    }
}
