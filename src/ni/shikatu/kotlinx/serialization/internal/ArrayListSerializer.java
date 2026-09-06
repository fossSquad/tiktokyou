package ni.shikatu.kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.InternalSerializationApi;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012*\u0012\u0004\u0012\u0002H\u0001\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\u00010\u0004j\b\u0012\u0004\u0012\u0002H\u0001`\u00050\u0002B\u0017\bF\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0007¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0094\u0080\u0004J\u001e\u0010\u000f\u001a\u00020\u0010*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0094\u0080\u0004J$\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u0003*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005H\u0094\u0080\u0004J$\u0010\u0012\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u0005*\b\u0012\u0004\u0012\u00028\u00000\u0003H\u0094\u0080\u0004J&\u0010\u0013\u001a\u00020\u0014*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u0006\u0010\u0015\u001a\u00020\u0010H\u0094\u0080\u0004J3\u0010\u0016\u001a\u00020\u0014*\u0012\u0012\u0004\u0012\u00028\u00000\u0004j\b\u0012\u0004\u0012\u00028\u0000`\u00052\u0006\u0010\u0017\u001a\u00020\u00102\u0006\u0010\u0006\u001a\u00028\u0000H\u0094\u0080\u0004¢\u0006\u0002\u0010\u0018R\u0015\u0010\n\u001a\u00020\u000bX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/ArrayListSerializer;", "E", "Lni/shikatu/kotlinx/serialization/internal/CollectionSerializer;", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/util/ArrayList;", "Lni/shikatu/kotlin/collections/ArrayList;", "element", "Lni/shikatu/kotlinx/serialization/KSerializer;", "<init>", "(Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "builder", "builderSize", _UrlKt.FRAGMENT_ENCODE_SET, "toResult", "toBuilder", "checkCapacity", _UrlKt.FRAGMENT_ENCODE_SET, "size", "insert", "index", "(Ljava/util/ArrayList;ILjava/lang/Object;)V", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@InternalSerializationApi
public final class ArrayListSerializer<E> extends CollectionSerializer<E, List<? extends E>, ArrayList<E>> {
    private final SerialDescriptor descriptor;

    public ArrayListSerializer(KSerializer<E> kSerializer) {
        super(kSerializer);
        Intrinsics.checkNotNullParameter(kSerializer, "element");
        this.descriptor = new ArrayListClassDesc(kSerializer.getDescriptor());
    }

    @Override
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override
    public ArrayList<E> builder() {
        return new ArrayList<>();
    }

    @Override
    public int builderSize(ArrayList<E> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        return arrayList.size();
    }

    @Override
    public List<E> toResult(ArrayList<E> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        return arrayList;
    }

    @Override
    public ArrayList<E> toBuilder(List<? extends E> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        ArrayList<E> arrayList = list instanceof ArrayList ? (ArrayList) list : null;
        return arrayList == null ? new ArrayList<>(list) : arrayList;
    }

    @Override
    public void checkCapacity(ArrayList<E> arrayList, int size) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        arrayList.ensureCapacity(size);
    }

    @Override
    public void insert(ArrayList<E> arrayList, int index, E e) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        arrayList.add(index, e);
    }
}
