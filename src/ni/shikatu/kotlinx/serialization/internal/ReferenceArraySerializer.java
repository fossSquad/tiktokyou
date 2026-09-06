package ni.shikatu.kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.internal.ArrayIteratorKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010(\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0001\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\n\b\u0001\u0010\u0003*\u0004\u0018\u0001H\u00012*\u0012\u0004\u0012\u0002H\u0003\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00030\u0005\u0012\u0014\u0012\u0012\u0012\u0004\u0012\u0002H\u00030\u0006j\b\u0012\u0004\u0012\u0002H\u0003`\u00070\u0004B%\bF\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00010\u000b¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u0012\u001a\u00020\u0013*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0094\u0080\u0004¢\u0006\u0002\u0010\u0014J\u001f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00010\u0016*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0094\u0080\u0004¢\u0006\u0002\u0010\u0017J\u001a\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007H\u0094\u0080\u0004J\u001e\u0010\u0019\u001a\u00020\u0013*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007H\u0094\u0080\u0004J)\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007H\u0094\u0080\u0004¢\u0006\u0002\u0010\u001bJ)\u0010\u001c\u001a\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u0007*\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0094\u0080\u0004¢\u0006\u0002\u0010\u001dJ&\u0010\u001e\u001a\u00020\u001f*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00072\u0006\u0010 \u001a\u00020\u0013H\u0094\u0080\u0004J3\u0010!\u001a\u00020\u001f*\u0012\u0012\u0004\u0012\u00028\u00010\u0006j\b\u0012\u0004\u0012\u00028\u0001`\u00072\u0006\u0010\"\u001a\u00020\u00132\u0006\u0010#\u001a\u00028\u0001H\u0094\u0080\u0004¢\u0006\u0002\u0010$R\u0015\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u000e\u001a\u00020\u000fX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006%"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/ReferenceArraySerializer;", "ElementKlass", _UrlKt.FRAGMENT_ENCODE_SET, "Element", "Lni/shikatu/kotlinx/serialization/internal/CollectionLikeSerializer;", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/util/ArrayList;", "Lni/shikatu/kotlin/collections/ArrayList;", "kClass", "Lni/shikatu/kotlin/reflect/KClass;", "eSerializer", "Lni/shikatu/kotlinx/serialization/KSerializer;", "<init>", "(Lkotlin/reflect/KClass;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "collectionSize", _UrlKt.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)I", "collectionIterator", _UrlKt.FRAGMENT_ENCODE_SET, "([Ljava/lang/Object;)Ljava/util/Iterator;", "builder", "builderSize", "toResult", "(Ljava/util/ArrayList;)[Ljava/lang/Object;", "toBuilder", "([Ljava/lang/Object;)Ljava/util/ArrayList;", "checkCapacity", _UrlKt.FRAGMENT_ENCODE_SET, "size", "insert", "index", "element", "(Ljava/util/ArrayList;ILjava/lang/Object;)V", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ReferenceArraySerializer<ElementKlass, Element extends ElementKlass> extends CollectionLikeSerializer<Element, Element[], ArrayList<Element>> {
    private final SerialDescriptor descriptor;
    private final KClass<ElementKlass> kClass;

    public ReferenceArraySerializer(KClass<ElementKlass> kClass, KSerializer<Element> kSerializer) {
        super(kSerializer, null);
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(kSerializer, "eSerializer");
        this.kClass = kClass;
        this.descriptor = new ArrayClassDesc(kSerializer.getDescriptor());
    }

    @Override
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    @Override
    public int collectionSize(Element[] elementArr) {
        Intrinsics.checkNotNullParameter(elementArr, "<this>");
        return elementArr.length;
    }

    @Override
    public Iterator<Element> collectionIterator(Element[] elementArr) {
        Intrinsics.checkNotNullParameter(elementArr, "<this>");
        return ArrayIteratorKt.iterator(elementArr);
    }

    @Override
    public ArrayList<Element> builder() {
        return new ArrayList<>();
    }

    @Override
    public int builderSize(ArrayList<Element> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        return arrayList.size();
    }

    @Override
    public Element[] toResult(ArrayList<Element> arrayList) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        return (Element[]) PlatformKt.toNativeArrayImpl(arrayList, this.kClass);
    }

    @Override
    public ArrayList<Element> toBuilder(Element[] elementArr) {
        Intrinsics.checkNotNullParameter(elementArr, "<this>");
        return new ArrayList<>(ArraysKt.asList(elementArr));
    }

    @Override
    public void checkCapacity(ArrayList<Element> arrayList, int size) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        arrayList.ensureCapacity(size);
    }

    @Override
    public void insert(ArrayList<Element> arrayList, int index, Element element) {
        Intrinsics.checkNotNullParameter(arrayList, "<this>");
        arrayList.add(index, element);
    }
}
