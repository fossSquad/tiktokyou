package ni.shikatu.kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ni.shikatu.kotlin.Lazy;
import ni.shikatu.kotlin.LazyKt;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.TuplesKt;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.IndexedValue;
import ni.shikatu.kotlin.collections.MapsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.internal.CachedNames;
import ni.shikatu.kotlinx.serialization.internal.Platform_commonKt;
import ni.shikatu.kotlinx.serialization.internal.PluginGeneratedSerialDescriptorKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u001b\n\u0002\b\u0005\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0006\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010$\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B7\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\u0012\u0010/\u001a\u00020\u00042\u0006\u00100\u001a\u00020\bH\u0096\u0080\u0004J\u0012\u00101\u001a\u00020\b2\u0006\u00102\u001a\u00020\u0004H\u0096\u0080\u0004J\u0018\u00103\u001a\b\u0012\u0004\u0012\u00020\u00160\n2\u0006\u00100\u001a\u00020\bH\u0096\u0080\u0004J\u0012\u00104\u001a\u00020\u00012\u0006\u00100\u001a\u00020\bH\u0096\u0080\u0004J\u0012\u00105\u001a\u0002062\u0006\u00100\u001a\u00020\bH\u0096\u0080\u0004J\u0014\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u000109H\u0096\u0082\u0004J\n\u0010:\u001a\u00020\bH\u0096\u0080\u0004J\n\u0010;\u001a\u00020\u0004H\u0096\u0080\u0004R\u0015\u0010\u0003\u001a\u00020\u0004X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0005\u001a\u00020\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0007\u001a\u00020\bX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R!\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\nX\u0096\u0084\b¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u001aR\u001b\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00040\u001cX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040 X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010!R\u0017\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010 X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010#R\u001d\u0010$\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\n0 X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010%R\u000f\u0010&\u001a\u00020'X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001b\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0)X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0017\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00010 X\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010#R\u001b\u0010+\u001a\u00020\b8BX\u0082\u0084\n¢\u0006\f\n\u0004\b-\u0010.\u001a\u0004\b,\u0010\u0014¨\u0006<"}, d2 = {"Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptorImpl;", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "Lni/shikatu/kotlinx/serialization/internal/CachedNames;", "serialName", _UrlKt.FRAGMENT_ENCODE_SET, "kind", "Lni/shikatu/kotlinx/serialization/descriptors/SerialKind;", "elementsCount", _UrlKt.FRAGMENT_ENCODE_SET, "typeParameters", _UrlKt.FRAGMENT_ENCODE_SET, "builder", "Lni/shikatu/kotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;", "<init>", "(Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialKind;ILjava/util/List;Lkotlinx/serialization/descriptors/ClassSerialDescriptorBuilder;)V", "getSerialName", "()Ljava/lang/String;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "getElementsCount", "()I", "annotations", _UrlKt.FRAGMENT_ENCODE_SET, "getAnnotations$annotations", "()V", "getAnnotations", "()Ljava/util/List;", "serialNames", _UrlKt.FRAGMENT_ENCODE_SET, "getSerialNames", "()Ljava/util/Set;", "elementNames", _UrlKt.FRAGMENT_ENCODE_SET, "[Ljava/lang/String;", "elementDescriptors", "[Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "elementAnnotations", "[Ljava/util/List;", "elementOptionality", _UrlKt.FRAGMENT_ENCODE_SET, "name2Index", _UrlKt.FRAGMENT_ENCODE_SET, "typeParametersDescriptors", "_hashCode", "get_hashCode", "_hashCode$delegate", "Lni/shikatu/kotlin/Lazy;", "getElementName", "index", "getElementIndex", "name", "getElementAnnotations", "getElementDescriptor", "isElementOptional", _UrlKt.FRAGMENT_ENCODE_SET, "equals", "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "toString", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class SerialDescriptorImpl implements SerialDescriptor, CachedNames {
    private final Lazy _hashCode$delegate;
    private final List<Annotation> annotations;
    private final List<Annotation>[] elementAnnotations;
    private final SerialDescriptor[] elementDescriptors;
    private final String[] elementNames;
    private final boolean[] elementOptionality;
    private final int elementsCount;
    private final SerialKind kind;
    private final Map<String, Integer> name2Index;
    private final String serialName;
    private final Set<String> serialNames;
    private final SerialDescriptor[] typeParametersDescriptors;

    public static  void getAnnotations$annotations() {
    }

    public SerialDescriptorImpl(String serialName, SerialKind kind, int elementsCount, List<? extends SerialDescriptor> list, ClassSerialDescriptorBuilder builder) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        Intrinsics.checkNotNullParameter(kind, "kind");
        Intrinsics.checkNotNullParameter(list, "typeParameters");
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.serialName = serialName;
        this.kind = kind;
        this.elementsCount = elementsCount;
        this.annotations = builder.getAnnotations();
        this.serialNames = CollectionsKt.toHashSet(builder.getElementNames$kotlinx_serialization_core());
        Collection $this$toTypedArray$iv = builder.getElementNames$kotlinx_serialization_core();
        this.elementNames = (String[]) $this$toTypedArray$iv.toArray(new String[0]);
        this.elementDescriptors = Platform_commonKt.compactArray(builder.getElementDescriptors$kotlinx_serialization_core());
        Collection $this$toTypedArray$iv2 = builder.getElementAnnotations$kotlinx_serialization_core();
        this.elementAnnotations = (List[]) $this$toTypedArray$iv2.toArray(new List[0]);
        this.elementOptionality = CollectionsKt.toBooleanArray(builder.getElementOptionality$kotlinx_serialization_core());
        Iterable $this$map$iv = ArraysKt.withIndex(this.elementNames);
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            IndexedValue it = (IndexedValue) item$iv$iv;
            destination$iv$iv.add(TuplesKt.to(it.getValue(), Integer.valueOf(it.getIndex())));
        }
        this.name2Index = MapsKt.toMap((List) destination$iv$iv);
        this.typeParametersDescriptors = Platform_commonKt.compactArray(list);
        this._hashCode$delegate = LazyKt.lazy(new Function0() {
            @Override
            public final Object invoke() {
                return Integer.valueOf(SerialDescriptorImpl._hashCode_delegate$lambda$0(this.f$0));
            }
        });
    }

    @Override
    public String getSerialName() {
        return this.serialName;
    }

    @Override
    public SerialKind getKind() {
        return this.kind;
    }

    @Override
    public int getElementsCount() {
        return this.elementsCount;
    }

    @Override
    public List<Annotation> getAnnotations() {
        return this.annotations;
    }

    @Override
    public Set<String> getSerialNames() {
        return this.serialNames;
    }

    public static final int _hashCode_delegate$lambda$0(SerialDescriptorImpl this$0) {
        return PluginGeneratedSerialDescriptorKt.hashCodeImpl(this$0, this$0.typeParametersDescriptors);
    }

    private final int get_hashCode() {
        return ((Number) this._hashCode$delegate.getValue()).intValue();
    }

    @Override
    public String getElementName(int index) {
        return this.elementNames[index];
    }

    @Override
    public int getElementIndex(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer num = this.name2Index.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    @Override
    public List<Annotation> getElementAnnotations(int index) {
        return this.elementAnnotations[index];
    }

    @Override
    public SerialDescriptor getElementDescriptor(int index) {
        return this.elementDescriptors[index];
    }

    @Override
    public boolean isElementOptional(int index) {
        boolean[] $this$getChecked$iv = this.elementOptionality;
        return $this$getChecked$iv[index];
    }

    public boolean equals(Object other) {
        int index$iv;
        SerialDescriptorImpl $this$equalsImpl$iv = this;
        if ($this$equalsImpl$iv == other) {
            return true;
        }
        if ((other instanceof SerialDescriptorImpl) && Intrinsics.areEqual($this$equalsImpl$iv.getSerialName(), ((SerialDescriptor) other).getSerialName())) {
            SerialDescriptorImpl otherDescriptor = (SerialDescriptorImpl) other;
            if (Arrays.equals(this.typeParametersDescriptors, otherDescriptor.typeParametersDescriptors) && $this$equalsImpl$iv.getElementsCount() == ((SerialDescriptor) other).getElementsCount()) {
                int elementsCount = $this$equalsImpl$iv.getElementsCount();
                while (index$iv < elementsCount) {
                    index$iv = (Intrinsics.areEqual($this$equalsImpl$iv.getElementDescriptor(index$iv).getSerialName(), ((SerialDescriptor) other).getElementDescriptor(index$iv).getSerialName()) && Intrinsics.areEqual($this$equalsImpl$iv.getElementDescriptor(index$iv).getKind(), ((SerialDescriptor) other).getElementDescriptor(index$iv).getKind())) ? index$iv + 1 : 0;
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

    public int hashCode() {
        return get_hashCode();
    }

    public String toString() {
        return PluginGeneratedSerialDescriptorKt.toStringImpl(this);
    }
}
