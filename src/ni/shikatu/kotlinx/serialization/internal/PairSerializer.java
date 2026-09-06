package ni.shikatu.kotlinx.serialization.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.descriptors.ClassSerialDescriptorBuilder;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptorsKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\n\b\u0001\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022 \u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u0002\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u00040\u0003B%\bF\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ+\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00042\u0006\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001H\u0094\u0080\u0004¢\u0006\u0002\u0010\u0014R\u0015\u0010\n\u001a\u00020\u000bX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR%\u0010\u000e\u001a\u00028\u0000*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0094\u0084\b¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R%\u0010\u0011\u001a\u00028\u0001*\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00048TX\u0094\u0084\b¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010¨\u0006\u0015"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/PairSerializer;", "K", "V", "Lni/shikatu/kotlinx/serialization/internal/KeyValueSerializer;", "Lni/shikatu/kotlin/Pair;", "keySerializer", "Lni/shikatu/kotlinx/serialization/KSerializer;", "valueSerializer", "<init>", "(Lkotlinx/serialization/KSerializer;Lkotlinx/serialization/KSerializer;)V", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "key", "getKey", "(Lkotlin/Pair;)Ljava/lang/Object;", "value", "getValue", "toResult", "(Ljava/lang/Object;Ljava/lang/Object;)Lkotlin/Pair;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class PairSerializer<K, V> extends KeyValueSerializer<K, V, Pair<? extends K, ? extends V>> {
    private final SerialDescriptor descriptor;

    public PairSerializer(final KSerializer<K> kSerializer, final KSerializer<V> kSerializer2) {
        super(kSerializer, kSerializer2, null);
        Intrinsics.checkNotNullParameter(kSerializer, "keySerializer");
        Intrinsics.checkNotNullParameter(kSerializer2, "valueSerializer");
        this.descriptor = SerialDescriptorsKt.buildClassSerialDescriptor("ni.shikatu.kotlin.Pair", new SerialDescriptor[0], new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return PairSerializer.descriptor$lambda$0(kSerializer, kSerializer2, (ClassSerialDescriptorBuilder) obj);
            }
        });
    }

    @Override
    public SerialDescriptor getDescriptor() {
        return this.descriptor;
    }

    public static final Unit descriptor$lambda$0(KSerializer $keySerializer, KSerializer $valueSerializer, ClassSerialDescriptorBuilder $this$buildClassSerialDescriptor) {
        Intrinsics.checkNotNullParameter($this$buildClassSerialDescriptor, "$this$buildClassSerialDescriptor");
        ClassSerialDescriptorBuilder.element$default($this$buildClassSerialDescriptor, "first", $keySerializer.getDescriptor(), null, false, 12, null);
        ClassSerialDescriptorBuilder.element$default($this$buildClassSerialDescriptor, "second", $valueSerializer.getDescriptor(), null, false, 12, null);
        return Unit.INSTANCE;
    }

    @Override
    public K getKey(Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return pair.getFirst();
    }

    @Override
    public V getValue(Pair<? extends K, ? extends V> pair) {
        Intrinsics.checkNotNullParameter(pair, "<this>");
        return pair.getSecond();
    }

    @Override
    public Pair<K, V> toResult(K k, V v) {
        return ni.shikatu.kotlin.TuplesKt.to(k, v);
    }
}
