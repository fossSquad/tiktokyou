package ni.shikatu.kotlinx.serialization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.Triple;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.reflect.KClassifier;
import ni.shikatu.kotlin.reflect.KType;
import ni.shikatu.kotlin.reflect.KTypeProjection;
import ni.shikatu.kotlinx.serialization.builtins.BuiltinSerializersKt;
import ni.shikatu.kotlinx.serialization.internal.ArrayListSerializer;
import ni.shikatu.kotlinx.serialization.internal.HashMapSerializer;
import ni.shikatu.kotlinx.serialization.internal.HashSetSerializer;
import ni.shikatu.kotlinx.serialization.internal.LinkedHashMapSerializer;
import ni.shikatu.kotlinx.serialization.internal.LinkedHashSetSerializer;
import ni.shikatu.kotlinx.serialization.internal.PlatformKt;
import ni.shikatu.kotlinx.serialization.internal.Platform_commonKt;
import ni.shikatu.kotlinx.serialization.internal.PrimitivesKt;
import ni.shikatu.kotlinx.serialization.modules.SerializersModule;
import ni.shikatu.kotlinx.serialization.modules.SerializersModuleBuildersKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\u0086\u0088\u0004\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\u0003H\u0086\u0088\u0004\u001a\u001a\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u0080\u0004\u001a8\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00012\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0087\u0080\u0004\u001a\u001c\u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u0080\u0004\u001a\u001e\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u0080\u0004\u001a<\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001*\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010\t\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0087\u0080\u0004\u001a \u0010\r\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u0080\u0004\u001a-\u0010\u000e\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0001*\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00020\fH\u0082\u0080\u0004¢\u0006\u0002\b\u0010\u001aI\u0010\u0011\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0001*\u00020\u00032\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0014\u0010\t\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\n2\u0006\u0010\u000b\u001a\u00020\fH\u0082\u0080\u0004¢\u0006\u0002\b\u0013\u001a4\u0010\u0014\u001a\u0012\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0001\u0018\u00010\n*\u00020\u00032\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\n2\u0006\u0010\u000f\u001a\u00020\fH\u0080\u0080\u0004\u001a$\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0087\u0080\u0004\u001a&\u0010\r\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\bH\u0087\u0080\u0004\u001aD\u0010\u0016\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00040\b2\u0014\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\n2\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0080\u0080\u0004\u001a9\u0010\u001b\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00040\b2\u0014\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\nH\u0082\u0080\u0004¢\u0006\u0002\b\u001c\u001aI\u0010\u001d\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0004\u0018\u00010\u0001*\b\u0012\u0004\u0012\u00020\u00040\b2\u0014\u0010\u0017\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00010\n2\u000e\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0\u0019H\u0082\u0080\u0004¢\u0006\u0002\b\u001e\u001a3\u0010\u001f\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010 \u001a\u00020\fH\u0082\u0080\u0004¢\u0006\u0002\b!\u001a\u0016\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010#\u001a\u00020$H\u0081\u0080\u0004\u001a\"\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010%\u001a\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0081\u0080\u0004\u001a9\u0010\"\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010%\u001a\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010'H\u0081\u0080\u0004¢\u0006\u0002\u0010(\u001a\"\u0010)\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010%\u001a\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0081\u0080\u0004\u001a9\u0010)\u001a\u0006\u0012\u0002\b\u00030\u00012\u0006\u0010%\u001a\u00020\u00032\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\b2\u0010\u0010&\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010'H\u0081\u0080\u0004¢\u0006\u0002\u0010(¨\u0006*"}, d2 = {"serializer", "Lni/shikatu/kotlinx/serialization/KSerializer;", "T", "Lni/shikatu/kotlinx/serialization/modules/SerializersModule;", _UrlKt.FRAGMENT_ENCODE_SET, "type", "Lni/shikatu/kotlin/reflect/KType;", "kClass", "Lni/shikatu/kotlin/reflect/KClass;", "typeArgumentsSerializers", _UrlKt.FRAGMENT_ENCODE_SET, "isNullable", _UrlKt.FRAGMENT_ENCODE_SET, "serializerOrNull", "serializerByKTypeImpl", "failOnMissingTypeArgSerializer", "serializerByKTypeImpl$SerializersKt__SerializersKt", "serializerByKClassImpl", "rootClass", "serializerByKClassImpl$SerializersKt__SerializersKt", "serializersForParameters", "typeArguments", "parametrizedSerializerOrNull", "serializers", "elementClassifierIfArray", "Lni/shikatu/kotlin/Function0;", "Lni/shikatu/kotlin/reflect/KClassifier;", "compiledParametrizedSerializer", "compiledParametrizedSerializer$SerializersKt__SerializersKt", "builtinParametrizedSerializer", "builtinParametrizedSerializer$SerializersKt__SerializersKt", "nullable", "shouldBeNullable", "nullable$SerializersKt__SerializersKt", "noCompiledSerializer", "forClass", _UrlKt.FRAGMENT_ENCODE_SET, "module", "argSerializers", _UrlKt.FRAGMENT_ENCODE_SET, "(Lkotlinx/serialization/modules/SerializersModule;Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "moduleThenPolymorphic", "ni.shikatu.kotlinx-serialization-core"}, k = 5, mv = {2, 3, 0}, xi = 48, xs = "ni/shikatu/kotlinx/serialization/SerializersKt")
final  class SerializersKt__SerializersKt {
    public static final  <T> KSerializer<T> serializer() {
        Intrinsics.reifiedOperationMarker(6, "T");
        KSerializer $this$cast$iv = SerializersKt.serializer((KType) null);
        Intrinsics.checkNotNull($this$cast$iv, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return $this$cast$iv;
    }

    public static final  <T> KSerializer<T> serializer(SerializersModule $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        Intrinsics.reifiedOperationMarker(6, "T");
        KSerializer $this$cast$iv = SerializersKt.serializer($this$serializer, (KType) null);
        Intrinsics.checkNotNull($this$cast$iv, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.internal.Platform_commonKt.cast>");
        return $this$cast$iv;
    }

    public static final KSerializer<Object> serializer(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt.serializer(SerializersModuleBuildersKt.EmptySerializersModule(), type);
    }

    @ExperimentalSerializationApi
    public static final KSerializer<Object> serializer(KClass<?> kClass, List<? extends KSerializer<?>> list, boolean isNullable) {
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(list, "typeArgumentsSerializers");
        return SerializersKt.serializer(SerializersModuleBuildersKt.EmptySerializersModule(), kClass, list, isNullable);
    }

    public static final KSerializer<Object> serializerOrNull(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt.serializerOrNull(SerializersModuleBuildersKt.EmptySerializersModule(), type);
    }

    public static final KSerializer<Object> serializer(SerializersModule $this$serializer, KType type) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        KSerializer<Object> kSerializerSerializerByKTypeImpl$SerializersKt__SerializersKt = serializerByKTypeImpl$SerializersKt__SerializersKt($this$serializer, type, true);
        if (kSerializerSerializerByKTypeImpl$SerializersKt__SerializersKt != null) {
            return kSerializerSerializerByKTypeImpl$SerializersKt__SerializersKt;
        }
        PlatformKt.platformSpecificSerializerNotRegistered(Platform_commonKt.kclass(type));
        throw new KotlinNothingValueException();
    }

    @ExperimentalSerializationApi
    public static final KSerializer<Object> serializer(SerializersModule $this$serializer, KClass<?> kClass, List<? extends KSerializer<?>> list, boolean isNullable) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(list, "typeArgumentsSerializers");
        KSerializer<Object> kSerializerSerializerByKClassImpl$SerializersKt__SerializersKt = serializerByKClassImpl$SerializersKt__SerializersKt($this$serializer, (KClass<Object>) kClass, list, isNullable);
        if (kSerializerSerializerByKClassImpl$SerializersKt__SerializersKt != null) {
            return kSerializerSerializerByKClassImpl$SerializersKt__SerializersKt;
        }
        PlatformKt.platformSpecificSerializerNotRegistered(kClass);
        throw new KotlinNothingValueException();
    }

    public static final KSerializer<Object> serializerOrNull(SerializersModule $this$serializerOrNull, KType type) {
        Intrinsics.checkNotNullParameter($this$serializerOrNull, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return serializerByKTypeImpl$SerializersKt__SerializersKt($this$serializerOrNull, type, false);
    }

    private static final KSerializer<Object> serializerByKTypeImpl$SerializersKt__SerializersKt(SerializersModule $this$serializerByKTypeImpl, KType type, boolean failOnMissingTypeArgSerializer) {
        KSerializer<Object> kSerializerFindCachedSerializer;
        PolymorphicSerializer polymorphicSerializerParametrizedSerializerOrNull;
        KClass<Object> kclass = Platform_commonKt.kclass(type);
        boolean isNullable = type.isMarkedNullable();
        Iterable $this$map$iv = type.getArguments();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KTypeProjection p0 = (KTypeProjection) item$iv$iv;
            destination$iv$iv.add(Platform_commonKt.typeOrThrow(p0));
        }
        final List typeArguments = (List) destination$iv$iv;
        if (typeArguments.isEmpty()) {
            if (PlatformKt.isInterface(kclass) && SerializersModule.getContextual$default($this$serializerByKTypeImpl, kclass, null, 2, null) != null) {
                kSerializerFindCachedSerializer = null;
            } else {
                kSerializerFindCachedSerializer = SerializersCacheKt.findCachedSerializer(kclass, isNullable);
            }
        } else if ($this$serializerByKTypeImpl.getHasInterfaceContextualSerializers$kotlinx_serialization_core()) {
            kSerializerFindCachedSerializer = null;
        } else {
            Object objFindParametrizedCachedSerializer = SerializersCacheKt.findParametrizedCachedSerializer(kclass, typeArguments, isNullable);
            if (ni.shikatu.kotlin.Result.m12isFailureimpl(objFindParametrizedCachedSerializer)) {
                objFindParametrizedCachedSerializer = null;
            }
            kSerializerFindCachedSerializer = (KSerializer) objFindParametrizedCachedSerializer;
        }
        if (kSerializerFindCachedSerializer != null) {
            return kSerializerFindCachedSerializer;
        }
        if (typeArguments.isEmpty()) {
            polymorphicSerializerParametrizedSerializerOrNull = (PolymorphicSerializer) SerializersKt.serializerOrNull(kclass);
            if (polymorphicSerializerParametrizedSerializerOrNull == null && (polymorphicSerializerParametrizedSerializerOrNull = (PolymorphicSerializer) SerializersModule.getContextual$default($this$serializerByKTypeImpl, kclass, null, 2, null)) == null) {
                polymorphicSerializerParametrizedSerializerOrNull = PlatformKt.isInterface(kclass) ? new PolymorphicSerializer(kclass) : null;
            }
        } else {
            List<KSerializer<Object>> listSerializersForParameters = SerializersKt.serializersForParameters($this$serializerByKTypeImpl, typeArguments, failOnMissingTypeArgSerializer);
            if (listSerializersForParameters == null) {
                return null;
            }
            polymorphicSerializerParametrizedSerializerOrNull = (PolymorphicSerializer) SerializersKt.parametrizedSerializerOrNull(kclass, listSerializersForParameters, new Function0() {
                @Override
                public final Object invoke() {
                    return SerializersKt__SerializersKt.serializerByKTypeImpl$lambda$0$SerializersKt__SerializersKt(typeArguments);
                }
            });
            if (polymorphicSerializerParametrizedSerializerOrNull == null && (polymorphicSerializerParametrizedSerializerOrNull = (PolymorphicSerializer) $this$serializerByKTypeImpl.getContextual(kclass, listSerializersForParameters)) == null) {
                polymorphicSerializerParametrizedSerializerOrNull = PlatformKt.isInterface(kclass) ? new PolymorphicSerializer(kclass) : null;
            }
        }
        if (polymorphicSerializerParametrizedSerializerOrNull != null) {
            return nullable$SerializersKt__SerializersKt(polymorphicSerializerParametrizedSerializerOrNull, isNullable);
        }
        return null;
    }

    public static final KClassifier serializerByKTypeImpl$lambda$0$SerializersKt__SerializersKt(List $typeArguments) {
        return ((KType) $typeArguments.get(0)).getClassifier();
    }

    private static final KSerializer<Object> serializerByKClassImpl$SerializersKt__SerializersKt(SerializersModule $this$serializerByKClassImpl, KClass<Object> kClass, List<? extends KSerializer<Object>> list, boolean isNullable) {
        KSerializer<? extends Object> kSerializerParametrizedSerializerOrNull;
        if (list.isEmpty()) {
            kSerializerParametrizedSerializerOrNull = SerializersKt.serializerOrNull(kClass);
            if (kSerializerParametrizedSerializerOrNull == null) {
                kSerializerParametrizedSerializerOrNull = SerializersModule.getContextual$default($this$serializerByKClassImpl, kClass, null, 2, null);
            }
        } else {
            try {
                kSerializerParametrizedSerializerOrNull = SerializersKt.parametrizedSerializerOrNull(kClass, list, new Function0() {
                    @Override
                    public final Object invoke() {
                        return SerializersKt__SerializersKt.serializerByKClassImpl$lambda$0$SerializersKt__SerializersKt();
                    }
                });
                if (kSerializerParametrizedSerializerOrNull == null) {
                    kSerializerParametrizedSerializerOrNull = $this$serializerByKClassImpl.getContextual(kClass, list);
                }
            } catch (IndexOutOfBoundsException e) {
                throw new SerializationException("Unable to retrieve a serializer, the number of passed type serializers differs from the actual number of generic parameters", e);
            }
        }
        if (kSerializerParametrizedSerializerOrNull != null) {
            return nullable$SerializersKt__SerializersKt(kSerializerParametrizedSerializerOrNull, isNullable);
        }
        return null;
    }

    public static final KClassifier serializerByKClassImpl$lambda$0$SerializersKt__SerializersKt() {
        throw new SerializationException("It is not possible to retrieve an array serializer using KClass alone, use KType instead or ArraySerializer factory");
    }

    public static final List<KSerializer<Object>> serializersForParameters(SerializersModule $this$serializersForParameters, List<? extends KType> list, boolean failOnMissingTypeArgSerializer) {
        Intrinsics.checkNotNullParameter($this$serializersForParameters, "<this>");
        Intrinsics.checkNotNullParameter(list, "typeArguments");
        if (failOnMissingTypeArgSerializer) {
            List<? extends KType> $this$map$iv = list;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                KType it = (KType) item$iv$iv;
                destination$iv$iv.add(SerializersKt.serializer($this$serializersForParameters, it));
            }
            List serializers = (List) destination$iv$iv;
            return serializers;
        }
        List<? extends KType> $this$map$iv2 = list;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (Object item$iv$iv2 : $this$map$iv2) {
            KType it2 = (KType) item$iv$iv2;
            KSerializer<Object> kSerializerSerializerOrNull = SerializersKt.serializerOrNull($this$serializersForParameters, it2);
            if (kSerializerSerializerOrNull == null) {
                return null;
            }
            destination$iv$iv2.add(kSerializerSerializerOrNull);
        }
        List serializers2 = (List) destination$iv$iv2;
        return serializers2;
    }

    @InternalSerializationApi
    public static final <T> KSerializer<T> serializer(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        KSerializer<T> kSerializerSerializerOrNull = SerializersKt.serializerOrNull(kClass);
        if (kSerializerSerializerOrNull != null) {
            return kSerializerSerializerOrNull;
        }
        Platform_commonKt.serializerNotRegistered(kClass);
        throw new KotlinNothingValueException();
    }

    @InternalSerializationApi
    public static final <T> KSerializer<T> serializerOrNull(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        KSerializer<T> kSerializerCompiledSerializerImpl = PlatformKt.compiledSerializerImpl(kClass);
        return kSerializerCompiledSerializerImpl == null ? PrimitivesKt.builtinSerializerOrNull(kClass) : kSerializerCompiledSerializerImpl;
    }

    public static final KSerializer<? extends Object> parametrizedSerializerOrNull(KClass<Object> kClass, List<? extends KSerializer<Object>> list, Function0<? extends KClassifier> function0) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        Intrinsics.checkNotNullParameter(list, "serializers");
        Intrinsics.checkNotNullParameter(function0, "elementClassifierIfArray");
        KSerializer<? extends Object> kSerializerBuiltinParametrizedSerializer$SerializersKt__SerializersKt = builtinParametrizedSerializer$SerializersKt__SerializersKt(kClass, list, function0);
        return kSerializerBuiltinParametrizedSerializer$SerializersKt__SerializersKt == null ? compiledParametrizedSerializer$SerializersKt__SerializersKt(kClass, list) : kSerializerBuiltinParametrizedSerializer$SerializersKt__SerializersKt;
    }

    private static final KSerializer<? extends Object> compiledParametrizedSerializer$SerializersKt__SerializersKt(KClass<Object> kClass, List<? extends KSerializer<Object>> list) {
        List<? extends KSerializer<Object>> $this$toTypedArray$iv = list;
        KSerializer[] kSerializerArr = (KSerializer[]) $this$toTypedArray$iv.toArray(new KSerializer[0]);
        return PlatformKt.constructSerializerForGivenTypeArgs(kClass, (KSerializer<Object>[]) Arrays.copyOf(kSerializerArr, kSerializerArr.length));
    }

    private static final KSerializer<? extends Object> builtinParametrizedSerializer$SerializersKt__SerializersKt(KClass<Object> kClass, List<? extends KSerializer<Object>> list, Function0<? extends KClassifier> function0) {
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Collection.class)) || Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(List.class)) || Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(List.class)) || Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(ArrayList.class))) {
            return new ArrayListSerializer(list.get(0));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(HashSet.class))) {
            return new HashSetSerializer(list.get(0));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Set.class)) || Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Set.class)) || Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(LinkedHashSet.class))) {
            return new LinkedHashSetSerializer(list.get(0));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(HashMap.class))) {
            return new HashMapSerializer(list.get(0), list.get(1));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Map.class)) || Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Map.class)) || Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(LinkedHashMap.class))) {
            return new LinkedHashMapSerializer(list.get(0), list.get(1));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Map.Entry.class))) {
            return BuiltinSerializersKt.MapEntrySerializer(list.get(0), list.get(1));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Pair.class))) {
            return BuiltinSerializersKt.PairSerializer(list.get(0), list.get(1));
        }
        if (Intrinsics.areEqual(kClass, Reflection.getOrCreateKotlinClass(Triple.class))) {
            return BuiltinSerializersKt.TripleSerializer(list.get(0), list.get(1), list.get(2));
        }
        if (PlatformKt.isReferenceArray(kClass)) {
            KClassifier kClassifierInvoke = function0.invoke();
            Intrinsics.checkNotNull(kClassifierInvoke, "null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
            return BuiltinSerializersKt.ArraySerializer((KClass) kClassifierInvoke, list.get(0));
        }
        return null;
    }

    private static final <T> KSerializer<T> nullable$SerializersKt__SerializersKt(KSerializer<T> kSerializer, boolean shouldBeNullable) {
        if (shouldBeNullable) {
            return BuiltinSerializersKt.getNullable(kSerializer);
        }
        Intrinsics.checkNotNull(kSerializer, "null cannot be cast to non-null type kotlinx.serialization.KSerializer<T of kotlinx.serialization.SerializersKt__SerializersKt.nullable?>");
        return kSerializer;
    }

    public static final KSerializer<?> noCompiledSerializer(String forClass) {
        Intrinsics.checkNotNullParameter(forClass, "forClass");
        throw new SerializationException(Platform_commonKt.notRegisteredMessage(forClass));
    }

    public static final KSerializer<?> noCompiledSerializer(SerializersModule module, KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        KSerializer<?> contextual$default = SerializersModule.getContextual$default(module, kClass, null, 2, null);
        if (contextual$default != null) {
            return contextual$default;
        }
        Platform_commonKt.serializerNotRegistered(kClass);
        throw new KotlinNothingValueException();
    }

    public static final KSerializer<?> noCompiledSerializer(SerializersModule module, KClass<?> kClass, KSerializer<?>[] kSerializerArr) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(kSerializerArr, "argSerializers");
        KSerializer<?> contextual = module.getContextual(kClass, ArraysKt.asList(kSerializerArr));
        if (contextual != null) {
            return contextual;
        }
        Platform_commonKt.serializerNotRegistered(kClass);
        throw new KotlinNothingValueException();
    }

    public static final KSerializer<?> moduleThenPolymorphic(SerializersModule module, KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        KSerializer<?> contextual$default = SerializersModule.getContextual$default(module, kClass, null, 2, null);
        return contextual$default == null ? new PolymorphicSerializer(kClass) : contextual$default;
    }

    public static final KSerializer<?> moduleThenPolymorphic(SerializersModule module, KClass<?> kClass, KSerializer<?>[] kSerializerArr) {
        Intrinsics.checkNotNullParameter(module, "module");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(kSerializerArr, "argSerializers");
        KSerializer<?> contextual = module.getContextual(kClass, ArraysKt.asList(kSerializerArr));
        return contextual == null ? new PolymorphicSerializer(kClass) : contextual;
    }
}
