package ni.shikatu.kotlinx.serialization.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ni.shikatu.kotlin.Lazy;
import ni.shikatu.kotlin.LazyKt;
import ni.shikatu.kotlin.LazyThreadSafetyMode;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.MapsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialKind;
import ni.shikatu.kotlinx.serialization.descriptors.StructureKind;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\u0018\n\u0000\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010$\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0011\u0018\u00002\u00020\u00012\u00020\u0002B)\bF\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\u001c\u00105\u001a\u0002062\u0006\u00107\u001a\u00020\u00042\b\b\u0002\u00108\u001a\u000209H\u0086\u0080\u0004J\u0012\u0010:\u001a\u0002062\u0006\u0010;\u001a\u00020\u0015H\u0086\u0080\u0004J\u0012\u0010<\u001a\u0002062\u0006\u0010=\u001a\u00020\u0015H\u0086\u0080\u0004J\u0012\u0010>\u001a\u00020\u00012\u0006\u0010?\u001a\u00020\bH\u0096\u0080\u0004J\u0012\u0010@\u001a\u0002092\u0006\u0010?\u001a\u00020\bH\u0096\u0080\u0004J\u0018\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010?\u001a\u00020\bH\u0096\u0080\u0004J\u0012\u0010B\u001a\u00020\u00042\u0006\u0010?\u001a\u00020\bH\u0096\u0080\u0004J\u0012\u0010C\u001a\u00020\b2\u0006\u00107\u001a\u00020\u0004H\u0096\u0080\u0004J\u0016\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0'H\u0082\u0080\u0004J\u0014\u0010E\u001a\u0002092\b\u0010F\u001a\u0004\u0018\u00010GH\u0096\u0082\u0004J\n\u0010H\u001a\u00020\bH\u0096\u0080\u0004J\n\u0010I\u001a\u00020\u0004H\u0096\u0080\u0004R\u0015\u0010\u0003\u001a\u00020\u0004X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u0015\u0010\u0007\u001a\u00020\bX\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u000f\u001a\u00020\u00108VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00148VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000f\u0010\u0018\u001a\u00020\bX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00040\u001aX\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u001bR\u001f\u0010\u001c\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001d0\u001aX\u0082\u0084\b¢\u0006\u0004\n\u0002\u0010\u001eR\u0017\u0010\u001f\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u001dX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010 \u001a\u00020!X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001b\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00040#8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b$\u0010%R\u001b\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\b0'X\u0082\u008e\b¢\u0006\u0002\n\u0000R%\u0010(\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030)0\u001a8BX\u0082\u0084\n¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b*\u0010+R!\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00010\u001a8@X\u0080\u0084\n¢\u0006\f\n\u0004\b1\u0010-\u001a\u0004\b/\u00100R\u001b\u00102\u001a\u00020\b8BX\u0082\u0084\n¢\u0006\f\n\u0004\b4\u0010-\u001a\u0004\b3\u0010\u000e¨\u0006J"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/PluginGeneratedSerialDescriptor;", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "Lni/shikatu/kotlinx/serialization/internal/CachedNames;", "serialName", _UrlKt.FRAGMENT_ENCODE_SET, "generatedSerializer", "Lni/shikatu/kotlinx/serialization/internal/GeneratedSerializer;", "elementsCount", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;Lkotlinx/serialization/internal/GeneratedSerializer;I)V", "getSerialName", "()Ljava/lang/String;", "getElementsCount", "()I", "kind", "Lni/shikatu/kotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "annotations", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "getAnnotations", "()Ljava/util/List;", "added", "names", _UrlKt.FRAGMENT_ENCODE_SET, "[Ljava/lang/String;", "propertiesAnnotations", _UrlKt.FRAGMENT_ENCODE_SET, "[Ljava/util/List;", "classAnnotations", "elementsOptionality", _UrlKt.FRAGMENT_ENCODE_SET, "serialNames", _UrlKt.FRAGMENT_ENCODE_SET, "getSerialNames", "()Ljava/util/Set;", "indices", _UrlKt.FRAGMENT_ENCODE_SET, "childSerializers", "Lni/shikatu/kotlinx/serialization/KSerializer;", "getChildSerializers", "()[Lkotlinx/serialization/KSerializer;", "childSerializers$delegate", "Lni/shikatu/kotlin/Lazy;", "typeParameterDescriptors", "getTypeParameterDescriptors$kotlinx_serialization_core", "()[Lkotlinx/serialization/descriptors/SerialDescriptor;", "typeParameterDescriptors$delegate", "_hashCode", "get_hashCode", "_hashCode$delegate", "addElement", _UrlKt.FRAGMENT_ENCODE_SET, "name", "isOptional", _UrlKt.FRAGMENT_ENCODE_SET, "pushAnnotation", "annotation", "pushClassAnnotation", "a", "getElementDescriptor", "index", "isElementOptional", "getElementAnnotations", "getElementName", "getElementIndex", "buildIndices", "equals", "other", _UrlKt.FRAGMENT_ENCODE_SET, "hashCode", "toString", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public class PluginGeneratedSerialDescriptor implements SerialDescriptor, CachedNames {
    private final Lazy _hashCode$delegate;
    private int added;
    private final Lazy childSerializers$delegate;
    private List<Annotation> classAnnotations;
    private final int elementsCount;
    private final boolean[] elementsOptionality;
    private final GeneratedSerializer<?> generatedSerializer;
    private Map<String, Integer> indices;
    private final String[] names;
    private final List<Annotation>[] propertiesAnnotations;
    private final String serialName;
    private final Lazy typeParameterDescriptors$delegate;

    public PluginGeneratedSerialDescriptor(String serialName, GeneratedSerializer<?> generatedSerializer, int elementsCount) {
        Intrinsics.checkNotNullParameter(serialName, "serialName");
        this.serialName = serialName;
        this.generatedSerializer = generatedSerializer;
        this.elementsCount = elementsCount;
        this.added = -1;
        int i = this.elementsCount;
        String[] strArr = new String[i];
        for (int i2 = 0; i2 < i; i2++) {
            strArr[i2] = "[UNINITIALIZED]";
        }
        this.names = strArr;
        this.propertiesAnnotations = new List[this.elementsCount];
        this.elementsOptionality = new boolean[this.elementsCount];
        this.indices = MapsKt.emptyMap();
        this.childSerializers$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() {
            @Override
            public final Object invoke() {
                return PluginGeneratedSerialDescriptor.childSerializers_delegate$lambda$0(this.f$0);
            }
        });
        this.typeParameterDescriptors$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() {
            @Override
            public final Object invoke() {
                return PluginGeneratedSerialDescriptor.typeParameterDescriptors_delegate$lambda$0(this.f$0);
            }
        });
        this._hashCode$delegate = LazyKt.lazy(LazyThreadSafetyMode.PUBLICATION, new Function0() {
            @Override
            public final Object invoke() {
                return Integer.valueOf(PluginGeneratedSerialDescriptor._hashCode_delegate$lambda$0(this.f$0));
            }
        });
    }

    public  PluginGeneratedSerialDescriptor(String str, GeneratedSerializer generatedSerializer, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i2 & 2) != 0 ? null : generatedSerializer, i);
    }

    @Override
    public String getSerialName() {
        return this.serialName;
    }

    @Override
    public final int getElementsCount() {
        return this.elementsCount;
    }

    @Override
    public SerialKind getKind() {
        return StructureKind.CLASS.INSTANCE;
    }

    @Override
    public List<Annotation> getAnnotations() {
        List<Annotation> list = this.classAnnotations;
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @Override
    public Set<String> getSerialNames() {
        return this.indices.keySet();
    }

    public static final KSerializer[] childSerializers_delegate$lambda$0(PluginGeneratedSerialDescriptor this$0) {
        KSerializer<?>[] kSerializerArrChildSerializers;
        GeneratedSerializer<?> generatedSerializer = this$0.generatedSerializer;
        return (generatedSerializer == null || (kSerializerArrChildSerializers = generatedSerializer.childSerializers()) == null) ? PluginHelperInterfacesKt.EMPTY_SERIALIZER_ARRAY : kSerializerArrChildSerializers;
    }

    private final KSerializer<?>[] getChildSerializers() {
        return (KSerializer[]) this.childSerializers$delegate.getValue();
    }

    public final SerialDescriptor[] getTypeParameterDescriptors$kotlinx_serialization_core() {
        return (SerialDescriptor[]) this.typeParameterDescriptors$delegate.getValue();
    }

    public static final SerialDescriptor[] typeParameterDescriptors_delegate$lambda$0(PluginGeneratedSerialDescriptor this$0) {
        ArrayList arrayList;
        KSerializer<?>[] kSerializerArrTypeParametersSerializers;
        GeneratedSerializer<?> generatedSerializer = this$0.generatedSerializer;
        if (generatedSerializer == null || (kSerializerArrTypeParametersSerializers = generatedSerializer.typeParametersSerializers()) == null) {
            arrayList = null;
        } else {
            Collection destination$iv$iv = new ArrayList(kSerializerArrTypeParametersSerializers.length);
            for (KSerializer<?> kSerializer : kSerializerArrTypeParametersSerializers) {
                destination$iv$iv.add(kSerializer.getDescriptor());
            }
            arrayList = (List) destination$iv$iv;
        }
        return Platform_commonKt.compactArray(arrayList);
    }

    public static final int _hashCode_delegate$lambda$0(PluginGeneratedSerialDescriptor this$0) {
        return PluginGeneratedSerialDescriptorKt.hashCodeImpl(this$0, this$0.getTypeParameterDescriptors$kotlinx_serialization_core());
    }

    private final int get_hashCode() {
        return ((Number) this._hashCode$delegate.getValue()).intValue();
    }

    public static  void addElement$default(PluginGeneratedSerialDescriptor pluginGeneratedSerialDescriptor, String str, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addElement");
        }
        if ((i & 2) != 0) {
            z = false;
        }
        pluginGeneratedSerialDescriptor.addElement(str, z);
    }

    public final void addElement(String name, boolean isOptional) {
        Intrinsics.checkNotNullParameter(name, "name");
        String[] strArr = this.names;
        this.added++;
        strArr[this.added] = name;
        this.elementsOptionality[this.added] = isOptional;
        this.propertiesAnnotations[this.added] = null;
        if (this.added == this.elementsCount - 1) {
            this.indices = buildIndices();
        }
    }

    public final void pushAnnotation(Annotation annotation) {
        ArrayList arrayList;
        Intrinsics.checkNotNullParameter(annotation, "annotation");
        List<Annotation> list = this.propertiesAnnotations[this.added];
        if (list == null) {
            ArrayList result = new ArrayList(1);
            this.propertiesAnnotations[this.added] = result;
            arrayList = result;
        } else {
            arrayList = list;
        }
        arrayList.add(annotation);
    }

    public final void pushClassAnnotation(Annotation a) {
        Intrinsics.checkNotNullParameter(a, "a");
        if (this.classAnnotations == null) {
            this.classAnnotations = new ArrayList(1);
        }
        List<Annotation> list = this.classAnnotations;
        Intrinsics.checkNotNull(list);
        list.add(a);
    }

    @Override
    public SerialDescriptor getElementDescriptor(int index) {
        return getChildSerializers()[index].getDescriptor();
    }

    @Override
    public boolean isElementOptional(int index) {
        boolean[] $this$getChecked$iv = this.elementsOptionality;
        return $this$getChecked$iv[index];
    }

    @Override
    public List<Annotation> getElementAnnotations(int index) {
        List<Annotation> list = this.propertiesAnnotations[index];
        return list == null ? CollectionsKt.emptyList() : list;
    }

    @Override
    public String getElementName(int index) {
        return this.names[index];
    }

    @Override
    public int getElementIndex(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        Integer num = this.indices.get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    private final Map<String, Integer> buildIndices() {
        HashMap indices = new HashMap();
        int length = this.names.length;
        for (int i = 0; i < length; i++) {
            indices.put(this.names[i], Integer.valueOf(i));
        }
        return indices;
    }

    public boolean equals(Object other) {
        int index$iv;
        PluginGeneratedSerialDescriptor $this$equalsImpl$iv = this;
        if ($this$equalsImpl$iv == other) {
            return true;
        }
        if ((other instanceof PluginGeneratedSerialDescriptor) && Intrinsics.areEqual($this$equalsImpl$iv.getSerialName(), ((SerialDescriptor) other).getSerialName())) {
            PluginGeneratedSerialDescriptor otherDescriptor = (PluginGeneratedSerialDescriptor) other;
            if (Arrays.equals(getTypeParameterDescriptors$kotlinx_serialization_core(), otherDescriptor.getTypeParameterDescriptors$kotlinx_serialization_core()) && $this$equalsImpl$iv.getElementsCount() == ((SerialDescriptor) other).getElementsCount()) {
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
