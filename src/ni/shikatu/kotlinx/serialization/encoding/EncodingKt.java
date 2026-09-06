package ni.shikatu.kotlinx.serialization.encoding;

import java.util.Collection;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function3;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000:\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a4\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0086\u0088\u0004ø\u0001\u0000\u001a<\u0010\t\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b2\u0019\b\u0004\u0010\u0005\u001a\u0013\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006¢\u0006\u0002\b\bH\u0086\u0088\u0004ø\u0001\u0000\u001ac\u0010\t\u001a\u00020\u0001\"\u0004\b\u0000\u0010\f*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\f0\u000e24\b\u0004\u0010\u0005\u001a.\u0012\u0004\u0012\u00020\u0007\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u0002H\f\u0012\u0004\u0012\u00020\u00010\u000f¢\u0006\u0002\b\bH\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013"}, d2 = {"encodeStructure", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "block", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlinx/serialization/encoding/CompositeEncoder;", "Lni/shikatu/kotlin/ExtensionFunctionType;", "encodeCollection", "collectionSize", _UrlKt.FRAGMENT_ENCODE_SET, "E", "collection", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/Function3;", "Lni/shikatu/kotlin/ParameterName;", "name", "index", "ni.shikatu.kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class EncodingKt {
    public static final void encodeStructure(Encoder $this$encodeStructure, SerialDescriptor descriptor, Function1<? super CompositeEncoder, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$encodeStructure, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(function1, "block");
        CompositeEncoder composite = $this$encodeStructure.beginStructure(descriptor);
        function1.invoke(composite);
        composite.endStructure(descriptor);
    }

    public static final void encodeCollection(Encoder $this$encodeCollection, SerialDescriptor descriptor, int collectionSize, Function1<? super CompositeEncoder, Unit> function1) {
        Intrinsics.checkNotNullParameter($this$encodeCollection, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(function1, "block");
        CompositeEncoder composite = $this$encodeCollection.beginCollection(descriptor, collectionSize);
        function1.invoke(composite);
        composite.endStructure(descriptor);
    }

    public static final <E> void encodeCollection(Encoder $this$encodeCollection, SerialDescriptor descriptor, Collection<? extends E> collection, Function3<? super CompositeEncoder, ? super Integer, ? super E, Unit> function3) {
        Intrinsics.checkNotNullParameter($this$encodeCollection, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(collection, "collection");
        Intrinsics.checkNotNullParameter(function3, "block");
        int $i$f$encodeCollection = 0;
        int collectionSize$iv = collection.size();
        CompositeEncoder composite$iv = $this$encodeCollection.beginCollection(descriptor, collectionSize$iv);
        Collection<? extends E> $this$forEachIndexed$iv = collection;
        int index$iv = 0;
        for (Object item$iv : $this$forEachIndexed$iv) {
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            function3.invoke(composite$iv, Integer.valueOf(index$iv), item$iv);
            index$iv = index$iv2;
            $i$f$encodeCollection = $i$f$encodeCollection;
        }
        composite$iv.endStructure(descriptor);
    }
}
