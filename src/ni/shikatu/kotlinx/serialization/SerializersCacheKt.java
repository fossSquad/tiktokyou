package ni.shikatu.kotlinx.serialization;

import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.reflect.KClassifier;
import ni.shikatu.kotlin.reflect.KType;
import ni.shikatu.kotlinx.serialization.builtins.BuiltinSerializersKt;
import ni.shikatu.kotlinx.serialization.internal.CachingKt;
import ni.shikatu.kotlinx.serialization.internal.ParametrizedSerializerCache;
import ni.shikatu.kotlinx.serialization.internal.PlatformKt;
import ni.shikatu.kotlinx.serialization.internal.SerializerCache;
import ni.shikatu.kotlinx.serialization.modules.SerializersModuleBuildersKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a*\u0010\t\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0080\u0080\u0004\u001aC\u0010\u000f\u001a\u0012\u0012\u000e\u0012\f\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0018\u00010\n0\u00102\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\f2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\r\u001a\u00020\u000eH\u0080\u0080\u0004¢\u0006\u0002\u0010\u0014\u001a\u001c\u0010\u0015\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u0016*\u0006\u0012\u0002\b\u00030\fH\u0080\u0088\u0004\"\u001f\u0010\u0000\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00018\u0000X\u0081\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\"\u0019\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00018\u0002X\u0083\u0084\b¢\u0006\u0002\n\u0000\"\u0019\u0010\u0006\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00078\u0002X\u0083\u0084\b¢\u0006\u0002\n\u0000\"\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u00078\u0002X\u0083\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"SERIALIZERS_CACHE", "Lni/shikatu/kotlinx/serialization/internal/SerializerCache;", _UrlKt.FRAGMENT_ENCODE_SET, "getSERIALIZERS_CACHE", "()Lkotlinx/serialization/internal/SerializerCache;", "SERIALIZERS_CACHE_NULLABLE", "PARAMETRIZED_SERIALIZERS_CACHE", "Lni/shikatu/kotlinx/serialization/internal/ParametrizedSerializerCache;", "PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE", "findCachedSerializer", "Lni/shikatu/kotlinx/serialization/KSerializer;", "clazz", "Lni/shikatu/kotlin/reflect/KClass;", "isNullable", _UrlKt.FRAGMENT_ENCODE_SET, "findParametrizedCachedSerializer", "Lni/shikatu/kotlin/Result;", "types", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/reflect/KType;", "(Lkotlin/reflect/KClass;Ljava/util/List;Z)Ljava/lang/Object;", "polymorphicIfInterface", "Lni/shikatu/kotlinx/serialization/PolymorphicSerializer;", "ni.shikatu.kotlinx-serialization-core"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class SerializersCacheKt {
    private static final SerializerCache<? extends Object> SERIALIZERS_CACHE = CachingKt.createCache(new Function1() {
        @Override
        public final Object invoke(Object obj) {
            return SerializersCacheKt.SERIALIZERS_CACHE$lambda$0((KClass) obj);
        }
    });
    private static final SerializerCache<Object> SERIALIZERS_CACHE_NULLABLE = CachingKt.createCache(new Function1() {
        @Override
        public final Object invoke(Object obj) {
            return SerializersCacheKt.SERIALIZERS_CACHE_NULLABLE$lambda$0((KClass) obj);
        }
    });
    private static final ParametrizedSerializerCache<? extends Object> PARAMETRIZED_SERIALIZERS_CACHE = CachingKt.createParametrizedCache(new Function2() {
        @Override
        public final Object invoke(Object obj, Object obj2) {
            return SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE$lambda$0((KClass) obj, (List) obj2);
        }
    });
    private static final ParametrizedSerializerCache<Object> PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE = CachingKt.createParametrizedCache(new Function2() {
        @Override
        public final Object invoke(Object obj, Object obj2) {
            return SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$lambda$0((KClass) obj, (List) obj2);
        }
    });

    public static final KSerializer SERIALIZERS_CACHE$lambda$0(KClass it) {
        Intrinsics.checkNotNullParameter(it, "it");
        KSerializer kSerializerSerializerOrNull = SerializersKt.serializerOrNull(it);
        if (kSerializerSerializerOrNull != null) {
            return kSerializerSerializerOrNull;
        }
        return PlatformKt.isInterface(it) ? new PolymorphicSerializer(it) : null;
    }

    public static final SerializerCache<? extends Object> getSERIALIZERS_CACHE() {
        return SERIALIZERS_CACHE;
    }

    public static final KSerializer SERIALIZERS_CACHE_NULLABLE$lambda$0(KClass it) {
        KSerializer $this$cast$iv;
        Intrinsics.checkNotNullParameter(it, "it");
        PolymorphicSerializer polymorphicSerializerSerializerOrNull = SerializersKt.serializerOrNull(it);
        if (polymorphicSerializerSerializerOrNull == null) {
            polymorphicSerializerSerializerOrNull = PlatformKt.isInterface(it) ? new PolymorphicSerializer(it) : null;
        }
        if (polymorphicSerializerSerializerOrNull == null || ($this$cast$iv = BuiltinSerializersKt.getNullable(polymorphicSerializerSerializerOrNull)) == null) {
            return null;
        }
        return $this$cast$iv;
    }

    public static final KSerializer PARAMETRIZED_SERIALIZERS_CACHE$lambda$0(KClass clazz, final List types) {
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(types, "types");
        List<KSerializer<Object>> listSerializersForParameters = SerializersKt.serializersForParameters(SerializersModuleBuildersKt.EmptySerializersModule(), types, true);
        Intrinsics.checkNotNull(listSerializersForParameters);
        return SerializersKt.parametrizedSerializerOrNull(clazz, listSerializersForParameters, new Function0() {
            @Override
            public final Object invoke() {
                return SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE$lambda$0$0(types);
            }
        });
    }

    public static final KClassifier PARAMETRIZED_SERIALIZERS_CACHE$lambda$0$0(List $types) {
        return ((KType) $types.get(0)).getClassifier();
    }

    public static final KSerializer PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$lambda$0(KClass clazz, final List types) {
        KSerializer nullable;
        Intrinsics.checkNotNullParameter(clazz, "clazz");
        Intrinsics.checkNotNullParameter(types, "types");
        List<KSerializer<Object>> listSerializersForParameters = SerializersKt.serializersForParameters(SerializersModuleBuildersKt.EmptySerializersModule(), types, true);
        Intrinsics.checkNotNull(listSerializersForParameters);
        KSerializer<? extends Object> kSerializerParametrizedSerializerOrNull = SerializersKt.parametrizedSerializerOrNull(clazz, listSerializersForParameters, new Function0() {
            @Override
            public final Object invoke() {
                return SerializersCacheKt.PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$lambda$0$0(types);
            }
        });
        if (kSerializerParametrizedSerializerOrNull == null || (nullable = BuiltinSerializersKt.getNullable(kSerializerParametrizedSerializerOrNull)) == null) {
            return null;
        }
        return nullable;
    }

    public static final KClassifier PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE$lambda$0$0(List $types) {
        return ((KType) $types.get(0)).getClassifier();
    }

    public static final KSerializer<Object> findCachedSerializer(KClass<Object> kClass, boolean isNullable) {
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        if (!isNullable) {
            KSerializer<? extends Object> kSerializer = SERIALIZERS_CACHE.get(kClass);
            if (kSerializer != null) {
                return kSerializer;
            }
            return null;
        }
        return SERIALIZERS_CACHE_NULLABLE.get(kClass);
    }

    public static final Object findParametrizedCachedSerializer(KClass<Object> kClass, List<? extends KType> list, boolean isNullable) {
        Intrinsics.checkNotNullParameter(kClass, "clazz");
        Intrinsics.checkNotNullParameter(list, "types");
        if (!isNullable) {
            return PARAMETRIZED_SERIALIZERS_CACHE.mo1535getgIAlus(kClass, list);
        }
        return PARAMETRIZED_SERIALIZERS_CACHE_NULLABLE.mo1535getgIAlus(kClass, list);
    }

    public static final PolymorphicSerializer<? extends Object> polymorphicIfInterface(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        if (PlatformKt.isInterface(kClass)) {
            return new PolymorphicSerializer<>(kClass);
        }
        return null;
    }
}
