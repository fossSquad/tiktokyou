package ni.shikatu.kotlin.collections.builders;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.MapsKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0019\bF\u0012\u000e\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003¢\u0006\u0004\b\u0004\u0010\u0005B\t\bV¢\u0006\u0004\b\u0004\u0010\u0006J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\rH\u0016J\n\u0010\u000e\u001a\u00020\u000fH\u0082\u0080\u0004R\u0017\u0010\u0002\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0003X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lni/shikatu/kotlin/collections/builders/SerializedMap;", "Ljava/io/Externalizable;", "map", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/util/Map;)V", "()V", "writeExternal", _UrlKt.FRAGMENT_ENCODE_SET, "output", "Ljava/io/ObjectOutput;", "readExternal", "input", "Ljava/io/ObjectInput;", "readResolve", _UrlKt.FRAGMENT_ENCODE_SET, "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
final class SerializedMap implements Externalizable {
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 0;
    private Map<?, ?> map;

    public SerializedMap(Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(map, "map");
        this.map = map;
    }

    public SerializedMap() {
        this(MapsKt.emptyMap());
    }

    @Override
    public void writeExternal(ObjectOutput output) throws IOException {
        Intrinsics.checkNotNullParameter(output, "output");
        output.writeByte(0);
        output.writeInt(this.map.size());
        for (Map.Entry<?, ?> entry : this.map.entrySet()) {
            output.writeObject(entry.getKey());
            output.writeObject(entry.getValue());
        }
    }

    @Override
    public void readExternal(ObjectInput input) throws ClassNotFoundException, IOException {
        Intrinsics.checkNotNullParameter(input, "input");
        int flags = input.readByte();
        if (flags != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + flags);
        }
        int size = input.readInt();
        if (size < 0) {
            throw new InvalidObjectException("Illegal size value: " + size + '.');
        }
        Map $this$readExternal_u24lambda_u240 = MapsKt.createMapBuilder(size);
        for (int i = 0; i < size; i++) {
            Object key = input.readObject();
            Object value = input.readObject();
            $this$readExternal_u24lambda_u240.put(key, value);
        }
        this.map = MapsKt.build($this$readExternal_u24lambda_u240);
    }

    private final Object readResolve() {
        return this.map;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/collections/builders/SerializedMap$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "serialVersionUID", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
