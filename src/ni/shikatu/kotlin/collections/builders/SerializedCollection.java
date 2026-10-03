package ni.shikatu.kotlin.collections.builders;

import java.io.Externalizable;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.SetsKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0000\u0018\u0000 \u00122\u00020\u0001:\u0001\u0012B\u001d\bF\u0012\n\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007B\t\bV¢\u0006\u0004\b\u0006\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\n\u0010\u0010\u001a\u00020\u0011H\u0082\u0080\u0004R\u0013\u0010\u0002\u001a\u0006\u0012\u0002\b\u00030\u0003X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lni/shikatu/kotlin/collections/builders/SerializedCollection;", "Ljava/io/Externalizable;", "collection", _UrlKt.FRAGMENT_ENCODE_SET, "tag", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/util/Collection;I)V", "()V", "writeExternal", _UrlKt.FRAGMENT_ENCODE_SET, "output", "Ljava/io/ObjectOutput;", "readExternal", "input", "Ljava/io/ObjectInput;", "readResolve", _UrlKt.FRAGMENT_ENCODE_SET, "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final class SerializedCollection implements Externalizable {
    public static final Companion Companion = new Companion(null);
    private static final long serialVersionUID = 0;
    public static final int tagList = 0;
    public static final int tagSet = 1;
    private Collection<?> collection;
    private final int tag;

    public SerializedCollection(Collection<?> collection, int tag) {
        Intrinsics.checkNotNullParameter(collection, "collection");
        this.collection = collection;
        this.tag = tag;
    }

    public SerializedCollection() {
        this(CollectionsKt.emptyList(), 0);
    }

    @Override
    public void writeExternal(ObjectOutput output) throws IOException {
        Intrinsics.checkNotNullParameter(output, "output");
        output.writeByte(this.tag);
        output.writeInt(this.collection.size());
        for (Object element : this.collection) {
            output.writeObject(element);
        }
    }

    @Override
    public void readExternal(ObjectInput input) throws InvalidObjectException {
        List listBuild;
        Intrinsics.checkNotNullParameter(input, "input");
        int flags = input.readByte();
        int tag = flags & 1;
        int other = flags & (-2);
        if (other != 0) {
            throw new InvalidObjectException("Unsupported flags value: " + flags + '.');
        }
        int size = input.readInt();
        if (size < 0) {
            throw new InvalidObjectException("Illegal size value: " + size + '.');
        }
        int i = 0;
        switch (tag) {
            case 0:
                List $this$readExternal_u24lambda_u240 = CollectionsKt.createListBuilder(size);
                while (i < size) {
                    $this$readExternal_u24lambda_u240.add(input.readObject());
                    i++;
                }
                listBuild = CollectionsKt.build($this$readExternal_u24lambda_u240);
                break;
            case 1:
                Set $this$readExternal_u24lambda_u241 = SetsKt.createSetBuilder(size);
                while (i < size) {
                    $this$readExternal_u24lambda_u241.add(input.readObject());
                    i++;
                }
                listBuild = SetsKt.build($this$readExternal_u24lambda_u241);
                break;
            default:
                throw new InvalidObjectException("Unsupported collection type tag: " + tag + '.');
        }
        this.collection = listBuild;
    }

    private final Object readResolve() {
        return this.collection;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003R\u000f\u0010\u0004\u001a\u00020\u0005X\u0082Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0006\u001a\u00020\u0007X\u0086Ô\b¢\u0006\u0002\n\u0000R\u000f\u0010\b\u001a\u00020\u0007X\u0086Ô\b¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lni/shikatu/kotlin/collections/builders/SerializedCollection$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "serialVersionUID", _UrlKt.FRAGMENT_ENCODE_SET, "tagList", _UrlKt.FRAGMENT_ENCODE_SET, "tagSet", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
