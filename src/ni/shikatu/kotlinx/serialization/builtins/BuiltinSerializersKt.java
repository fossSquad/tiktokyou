package ni.shikatu.kotlinx.serialization.builtins;

import java.util.List;
import java.util.Map;
import java.util.Set;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.Triple;
import ni.shikatu.kotlin.UByte;
import ni.shikatu.kotlin.UByteArray;
import ni.shikatu.kotlin.UInt;
import ni.shikatu.kotlin.UIntArray;
import ni.shikatu.kotlin.ULong;
import ni.shikatu.kotlin.ULongArray;
import ni.shikatu.kotlin.UShort;
import ni.shikatu.kotlin.UShortArray;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.internal.BooleanCompanionObject;
import ni.shikatu.kotlin.jvm.internal.ByteCompanionObject;
import ni.shikatu.kotlin.jvm.internal.CharCompanionObject;
import ni.shikatu.kotlin.jvm.internal.DoubleCompanionObject;
import ni.shikatu.kotlin.jvm.internal.FloatCompanionObject;
import ni.shikatu.kotlin.jvm.internal.IntCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.LongCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.kotlin.jvm.internal.ShortCompanionObject;
import ni.shikatu.kotlin.jvm.internal.StringCompanionObject;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.time.Duration;
import ni.shikatu.kotlin.time.Instant;
import ni.shikatu.kotlin.uuid.Uuid;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.internal.ArrayListSerializer;
import ni.shikatu.kotlinx.serialization.internal.BooleanArraySerializer;
import ni.shikatu.kotlinx.serialization.internal.BooleanSerializer;
import ni.shikatu.kotlinx.serialization.internal.ByteArraySerializer;
import ni.shikatu.kotlinx.serialization.internal.ByteSerializer;
import ni.shikatu.kotlinx.serialization.internal.CharArraySerializer;
import ni.shikatu.kotlinx.serialization.internal.CharSerializer;
import ni.shikatu.kotlinx.serialization.internal.DoubleArraySerializer;
import ni.shikatu.kotlinx.serialization.internal.DoubleSerializer;
import ni.shikatu.kotlinx.serialization.internal.DurationSerializer;
import ni.shikatu.kotlinx.serialization.internal.FloatArraySerializer;
import ni.shikatu.kotlinx.serialization.internal.FloatSerializer;
import ni.shikatu.kotlinx.serialization.internal.InstantSerializer;
import ni.shikatu.kotlinx.serialization.internal.IntArraySerializer;
import ni.shikatu.kotlinx.serialization.internal.IntSerializer;
import ni.shikatu.kotlinx.serialization.internal.LinkedHashMapSerializer;
import ni.shikatu.kotlinx.serialization.internal.LinkedHashSetSerializer;
import ni.shikatu.kotlinx.serialization.internal.LongArraySerializer;
import ni.shikatu.kotlinx.serialization.internal.LongSerializer;
import ni.shikatu.kotlinx.serialization.internal.MapEntrySerializer;
import ni.shikatu.kotlinx.serialization.internal.NothingSerializer;
import ni.shikatu.kotlinx.serialization.internal.NullableSerializer;
import ni.shikatu.kotlinx.serialization.internal.PairSerializer;
import ni.shikatu.kotlinx.serialization.internal.ReferenceArraySerializer;
import ni.shikatu.kotlinx.serialization.internal.ShortArraySerializer;
import ni.shikatu.kotlinx.serialization.internal.ShortSerializer;
import ni.shikatu.kotlinx.serialization.internal.StringSerializer;
import ni.shikatu.kotlinx.serialization.internal.TripleSerializer;
import ni.shikatu.kotlinx.serialization.internal.UByteArraySerializer;
import ni.shikatu.kotlinx.serialization.internal.UByteSerializer;
import ni.shikatu.kotlinx.serialization.internal.UIntArraySerializer;
import ni.shikatu.kotlinx.serialization.internal.UIntSerializer;
import ni.shikatu.kotlinx.serialization.internal.ULongArraySerializer;
import ni.shikatu.kotlinx.serialization.internal.ULongSerializer;
import ni.shikatu.kotlinx.serialization.internal.UShortArraySerializer;
import ni.shikatu.kotlinx.serialization.internal.UShortSerializer;
import ni.shikatu.kotlinx.serialization.internal.UnitSerializer;
import ni.shikatu.kotlinx.serialization.internal.UuidSerializer;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u009e\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010&\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0019\n\u0002\u0010\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0013\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0018\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0001\n\u0000\u001aD\u0010\b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000b0\t0\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001H\u0086\u0080\u0004\u001aD\u0010\u000e\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000b0\u000f0\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001H\u0086\u0080\u0004\u001a^\u0010\u0010\u001a\u001a\u0012\u0016\u0012\u0014\u0012\u0004\u0012\u0002H\u0012\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u0002H\u00140\u00110\u0001\"\u0004\b\u0000\u0010\u0012\"\u0004\b\u0001\u0010\u0013\"\u0004\b\u0002\u0010\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u0002H\u00120\u00012\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\u00130\u00012\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u0002H\u00140\u0001H\u0086\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u0001*\u00020\u001aH\u0086\u0080\u0004\u001a\u0010\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0001H\u0086\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001d0\u0001*\u00020\u001eH\u0086\u0080\u0004\u001a\u0010\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020 0\u0001H\u0086\u0080\u0004\u001a\u0010\u0010!\u001a\b\u0012\u0004\u0012\u00020\"0\u0001H\u0087\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020#0\u0001*\u00020$H\u0086\u0080\u0004\u001a\u0010\u0010%\u001a\b\u0012\u0004\u0012\u00020&0\u0001H\u0086\u0080\u0004\u001a\u0010\u0010'\u001a\b\u0012\u0004\u0012\u00020(0\u0001H\u0087\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020)0\u0001*\u00020*H\u0086\u0080\u0004\u001a\u0010\u0010+\u001a\b\u0012\u0004\u0012\u00020,0\u0001H\u0086\u0080\u0004\u001a\u0010\u0010-\u001a\b\u0012\u0004\u0012\u00020.0\u0001H\u0087\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020/0\u0001*\u000200H\u0086\u0080\u0004\u001a\u0010\u00101\u001a\b\u0012\u0004\u0012\u0002020\u0001H\u0086\u0080\u0004\u001a\u0010\u00103\u001a\b\u0012\u0004\u0012\u0002040\u0001H\u0087\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002050\u0001*\u000206H\u0086\u0080\u0004\u001a\u0010\u00107\u001a\b\u0012\u0004\u0012\u0002080\u0001H\u0086\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002090\u0001*\u00020:H\u0086\u0080\u0004\u001a\u0010\u0010;\u001a\b\u0012\u0004\u0012\u00020<0\u0001H\u0086\u0080\u0004\u001a\u0019\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020=0\u0001*\u00020>H\u0086\u0080\u0004¢\u0006\u0002\u0010?\u001a\u0010\u0010@\u001a\b\u0012\u0004\u0012\u00020A0\u0001H\u0086\u0080\u0004\u001a\u0019\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020B0\u0001*\u00020BH\u0086\u0080\u0004¢\u0006\u0002\u0010C\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020D0\u0001*\u00020EH\u0086\u0080\u0004\u001a>\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002HH0G0\u0001\"\n\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003\"\f\b\u0001\u0010H\u0018\u0001*\u0004\u0018\u0001H\u00022\f\u0010I\u001a\b\u0012\u0004\u0012\u0002HH0\u0001H\u0087\u0088\u0004\u001aH\u0010F\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002HH0G0\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\n\b\u0001\u0010H*\u0004\u0018\u0001H\u00022\f\u0010J\u001a\b\u0012\u0004\u0012\u0002H\u00020K2\f\u0010I\u001a\b\u0012\u0004\u0012\u0002HH0\u0001H\u0087\u0080\u0004\u001a*\u0010L\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020M0\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0086\u0080\u0004\u001a*\u0010N\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020O0\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010I\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001H\u0086\u0080\u0004\u001aD\u0010P\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u0002H\n\u0012\u0004\u0012\u0002H\u000b0Q0\u0001\"\u0004\b\u0000\u0010\n\"\u0004\b\u0001\u0010\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u0002H\n0\u00012\f\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u0001H\u0086\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020R0\u0001*\u00020SH\u0086\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020T0\u0001*\u00020UH\u0086\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020V0\u0001*\u00020WH\u0086\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020X0\u0001*\u00020YH\u0086\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020Z0\u0001*\u00020[H\u0086\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\\0\u0001*\u00020]H\u0087\u0080\u0004\u001a\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020^0\u0001*\u00020_H\u0087\u0080\u0004\u001a\u0010\u0010`\u001a\b\u0012\u0004\u0012\u00020a0\u0001H\u0087\u0080\u0004\"7\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00018FX\u0086\u0084\b¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007¨\u0006b"}, d2 = {"nullable", "Lni/shikatu/kotlinx/serialization/KSerializer;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "getNullable$annotations", "(Lkotlinx/serialization/KSerializer;)V", "getNullable", "(Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "PairSerializer", "Lni/shikatu/kotlin/Pair;", "K", "V", "keySerializer", "valueSerializer", "MapEntrySerializer", _UrlKt.FRAGMENT_ENCODE_SET, "TripleSerializer", "Lni/shikatu/kotlin/Triple;", "A", "B", "C", "aSerializer", "bSerializer", "cSerializer", "serializer", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/Char$Companion;", "CharArraySerializer", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/Byte$Companion;", "ByteArraySerializer", _UrlKt.FRAGMENT_ENCODE_SET, "UByteArraySerializer", "Lni/shikatu/kotlin/UByteArray;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/Short$Companion;", "ShortArraySerializer", _UrlKt.FRAGMENT_ENCODE_SET, "UShortArraySerializer", "Lni/shikatu/kotlin/UShortArray;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/Int$Companion;", "IntArraySerializer", _UrlKt.FRAGMENT_ENCODE_SET, "UIntArraySerializer", "Lni/shikatu/kotlin/UIntArray;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/Long$Companion;", "LongArraySerializer", _UrlKt.FRAGMENT_ENCODE_SET, "ULongArraySerializer", "Lni/shikatu/kotlin/ULongArray;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/Float$Companion;", "FloatArraySerializer", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/Double$Companion;", "DoubleArraySerializer", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/Boolean$Companion;", "(Lkotlin/jvm/internal/BooleanCompanionObject;)Lkotlinx/serialization/KSerializer;", "BooleanArraySerializer", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlin/Unit;)Lkotlinx/serialization/KSerializer;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/String$Companion;", "ArraySerializer", _UrlKt.FRAGMENT_ENCODE_SET, "E", "elementSerializer", "kClass", "Lni/shikatu/kotlin/reflect/KClass;", "ListSerializer", _UrlKt.FRAGMENT_ENCODE_SET, "SetSerializer", _UrlKt.FRAGMENT_ENCODE_SET, "MapSerializer", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/UInt;", "Lni/shikatu/kotlin/UInt$Companion;", "Lni/shikatu/kotlin/ULong;", "Lni/shikatu/kotlin/ULong$Companion;", "Lni/shikatu/kotlin/UByte;", "Lni/shikatu/kotlin/UByte$Companion;", "Lni/shikatu/kotlin/UShort;", "Lni/shikatu/kotlin/UShort$Companion;", "Lni/shikatu/kotlin/time/Duration;", "Lni/shikatu/kotlin/time/Duration$Companion;", "Lni/shikatu/kotlin/time/Instant;", "Lni/shikatu/kotlin/time/Instant$Companion;", "Lni/shikatu/kotlin/uuid/Uuid;", "Lni/shikatu/kotlin/uuid/Uuid$Companion;", "NothingSerializer", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class BuiltinSerializersKt {
    public static  void getNullable$annotations(KSerializer kSerializer) {
    }

    public static final <T> KSerializer<T> getNullable(KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "<this>");
        return kSerializer.getDescriptor().isNullable() ? kSerializer : new NullableSerializer(kSerializer);
    }

    public static final <K, V> KSerializer<Pair<K, V>> PairSerializer(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        Intrinsics.checkNotNullParameter(kSerializer, "keySerializer");
        Intrinsics.checkNotNullParameter(kSerializer2, "valueSerializer");
        return new PairSerializer(kSerializer, kSerializer2);
    }

    public static final <K, V> KSerializer<Map.Entry<K, V>> MapEntrySerializer(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        Intrinsics.checkNotNullParameter(kSerializer, "keySerializer");
        Intrinsics.checkNotNullParameter(kSerializer2, "valueSerializer");
        return new MapEntrySerializer(kSerializer, kSerializer2);
    }

    public static final <A, B, C> KSerializer<Triple<A, B, C>> TripleSerializer(KSerializer<A> kSerializer, KSerializer<B> kSerializer2, KSerializer<C> kSerializer3) {
        Intrinsics.checkNotNullParameter(kSerializer, "aSerializer");
        Intrinsics.checkNotNullParameter(kSerializer2, "bSerializer");
        Intrinsics.checkNotNullParameter(kSerializer3, "cSerializer");
        return new TripleSerializer(kSerializer, kSerializer2, kSerializer3);
    }

    public static final KSerializer<Character> serializer(CharCompanionObject $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return CharSerializer.INSTANCE;
    }

    public static final KSerializer<char[]> CharArraySerializer() {
        return CharArraySerializer.INSTANCE;
    }

    public static final KSerializer<Byte> serializer(ByteCompanionObject $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return ByteSerializer.INSTANCE;
    }

    public static final KSerializer<byte[]> ByteArraySerializer() {
        return ByteArraySerializer.INSTANCE;
    }

    @ExperimentalSerializationApi
    public static final KSerializer<UByteArray> UByteArraySerializer() {
        return UByteArraySerializer.INSTANCE;
    }

    public static final KSerializer<Short> serializer(ShortCompanionObject $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return ShortSerializer.INSTANCE;
    }

    public static final KSerializer<short[]> ShortArraySerializer() {
        return ShortArraySerializer.INSTANCE;
    }

    @ExperimentalSerializationApi
    public static final KSerializer<UShortArray> UShortArraySerializer() {
        return UShortArraySerializer.INSTANCE;
    }

    public static final KSerializer<Integer> serializer(IntCompanionObject $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return IntSerializer.INSTANCE;
    }

    public static final KSerializer<int[]> IntArraySerializer() {
        return IntArraySerializer.INSTANCE;
    }

    @ExperimentalSerializationApi
    public static final KSerializer<UIntArray> UIntArraySerializer() {
        return UIntArraySerializer.INSTANCE;
    }

    public static final KSerializer<Long> serializer(LongCompanionObject $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return LongSerializer.INSTANCE;
    }

    public static final KSerializer<long[]> LongArraySerializer() {
        return LongArraySerializer.INSTANCE;
    }

    @ExperimentalSerializationApi
    public static final KSerializer<ULongArray> ULongArraySerializer() {
        return ULongArraySerializer.INSTANCE;
    }

    public static final KSerializer<Float> serializer(FloatCompanionObject $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return FloatSerializer.INSTANCE;
    }

    public static final KSerializer<float[]> FloatArraySerializer() {
        return FloatArraySerializer.INSTANCE;
    }

    public static final KSerializer<Double> serializer(DoubleCompanionObject $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return DoubleSerializer.INSTANCE;
    }

    public static final KSerializer<double[]> DoubleArraySerializer() {
        return DoubleArraySerializer.INSTANCE;
    }

    public static final KSerializer<Boolean> serializer(BooleanCompanionObject $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return BooleanSerializer.INSTANCE;
    }

    public static final KSerializer<boolean[]> BooleanArraySerializer() {
        return BooleanArraySerializer.INSTANCE;
    }

    public static final KSerializer<Unit> serializer(Unit $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return UnitSerializer.INSTANCE;
    }

    public static final KSerializer<String> serializer(StringCompanionObject $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return StringSerializer.INSTANCE;
    }

    @ExperimentalSerializationApi
    public static final  <T, E extends T> KSerializer<E[]> ArraySerializer(KSerializer<E> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "elementSerializer");
        Intrinsics.reifiedOperationMarker(4, "T");
        return ArraySerializer(Reflection.getOrCreateKotlinClass(Object.class), kSerializer);
    }

    @ExperimentalSerializationApi
    public static final <T, E extends T> KSerializer<E[]> ArraySerializer(KClass<T> kClass, KSerializer<E> kSerializer) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(kSerializer, "elementSerializer");
        return new ReferenceArraySerializer(kClass, kSerializer);
    }

    public static final <T> KSerializer<List<T>> ListSerializer(KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "elementSerializer");
        return new ArrayListSerializer(kSerializer);
    }

    public static final <T> KSerializer<Set<T>> SetSerializer(KSerializer<T> kSerializer) {
        Intrinsics.checkNotNullParameter(kSerializer, "elementSerializer");
        return new LinkedHashSetSerializer(kSerializer);
    }

    public static final <K, V> KSerializer<Map<K, V>> MapSerializer(KSerializer<K> kSerializer, KSerializer<V> kSerializer2) {
        Intrinsics.checkNotNullParameter(kSerializer, "keySerializer");
        Intrinsics.checkNotNullParameter(kSerializer2, "valueSerializer");
        return new LinkedHashMapSerializer(kSerializer, kSerializer2);
    }

    public static final KSerializer<UInt> serializer(UInt.Companion $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return UIntSerializer.INSTANCE;
    }

    public static final KSerializer<ULong> serializer(ULong.Companion $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return ULongSerializer.INSTANCE;
    }

    public static final KSerializer<UByte> serializer(UByte.Companion $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return UByteSerializer.INSTANCE;
    }

    public static final KSerializer<UShort> serializer(UShort.Companion $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return UShortSerializer.INSTANCE;
    }

    public static final KSerializer<Duration> serializer(Duration.Companion $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return DurationSerializer.INSTANCE;
    }

    public static final KSerializer<Instant> serializer(Instant.Companion $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return InstantSerializer.INSTANCE;
    }

    public static final KSerializer<Uuid> serializer(Uuid.Companion $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        return UuidSerializer.INSTANCE;
    }

    @ExperimentalSerializationApi
    public static final KSerializer NothingSerializer() {
        return NothingSerializer.INSTANCE;
    }
}
