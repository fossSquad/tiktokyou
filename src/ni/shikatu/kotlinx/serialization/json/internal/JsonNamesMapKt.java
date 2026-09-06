package ni.shikatu.kotlinx.serialization.json.internal;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.MapsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.SerializationException;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialKind;
import ni.shikatu.kotlinx.serialization.descriptors.StructureKind;
import ni.shikatu.kotlinx.serialization.internal.JsonInternalDependenciesKt;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.kotlinx.serialization.json.JsonEncodingException;
import ni.shikatu.kotlinx.serialization.json.JsonIgnoreUnknownKeys;
import ni.shikatu.kotlinx.serialization.json.JsonNames;
import ni.shikatu.kotlinx.serialization.json.JsonNamingStrategy;
import ni.shikatu.kotlinx.serialization.json.JsonSchemaCacheKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000^\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\"\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\u001a\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0082\u0080\u0004\u001a\"\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bH\u0080\u0080\u0004\u001a)\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00030\b*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0080\u0080\u0004¢\u0006\u0002\u0010\u0013\u001a\u001e\u0010\u0014\u001a\u00020\u0003*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u0004H\u0080\u0080\u0004\u001a\u001c\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00030\u0017*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0080\u0080\u0004\u001a\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u0012*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0080\u0080\u0004\u001a\u001e\u0010\u0019\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0003H\u0082\u0080\u0004\u001a\u0016\u0010\u001b\u001a\u00020\u001c*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000bH\u0082\u0080\u0004\u001a\u001e\u0010\u001d\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u0003H\u0080\u0080\u0004\u001a(\u0010\u001e\u001a\u00020\u0004*\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u0003H\u0080\u0080\u0004\u001ad\u0010 \u001a\u00020\u001c*\u00020\r2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00042!\u0010!\u001a\u001d\u0012\u0013\u0012\u00110\u001c¢\u0006\f\b#\u0012\b\b\u001a\u0012\u0004\b\b($\u0012\u0004\u0012\u00020\u001c0\"2\u000e\u0010%\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030&2\u000e\b\u0002\u0010'\u001a\b\u0012\u0004\u0012\u00020(0&H\u0080\u0088\u0004ø\u0001\u0000\u001a\u0016\u0010)\u001a\u00020\u001c*\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0080\u0080\u0004\"'\u0010\u0000\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u00020\u0001X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"!\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\b0\u0001X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0006\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006*"}, d2 = {"JsonDeserializationNamesKey", "Lni/shikatu/kotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "getJsonDeserializationNamesKey", "()Lkotlinx/serialization/json/internal/DescriptorSchemaCache$Key;", "JsonSerializationNamesKey", _UrlKt.FRAGMENT_ENCODE_SET, "getJsonSerializationNamesKey", "buildDeserializationNamesMap", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "deserializationNamesMap", "descriptor", "serializationNamesIndices", "strategy", "Lni/shikatu/kotlinx/serialization/json/JsonNamingStrategy;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonNamingStrategy;)[Ljava/lang/String;", "getJsonElementName", "index", "getJsonEncodedNames", _UrlKt.FRAGMENT_ENCODE_SET, "namingStrategy", "getJsonNameIndexSlowPath", "name", "decodeCaseInsensitive", _UrlKt.FRAGMENT_ENCODE_SET, "getJsonNameIndex", "getJsonNameIndexOrThrow", "suffix", "tryCoerceValue", "peekNull", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/ParameterName;", "consume", "peekString", "Lni/shikatu/kotlin/Function0;", "onEnumCoercing", _UrlKt.FRAGMENT_ENCODE_SET, "ignoreUnknownKeys", "ni.shikatu.kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class JsonNamesMapKt {
    private static final DescriptorSchemaCache.Key<Map<String, Integer>> JsonDeserializationNamesKey = new DescriptorSchemaCache.Key<>();
    private static final DescriptorSchemaCache.Key<String[]> JsonSerializationNamesKey = new DescriptorSchemaCache.Key<>();

    public static final DescriptorSchemaCache.Key<Map<String, Integer>> getJsonDeserializationNamesKey() {
        return JsonDeserializationNamesKey;
    }

    public static final DescriptorSchemaCache.Key<String[]> getJsonSerializationNamesKey() {
        return JsonSerializationNamesKey;
    }

    private static final void buildDeserializationNamesMap$putOrThrow(Map<String, Integer> map, SerialDescriptor $this_buildDeserializationNamesMap, String name, int index) {
        String entity = Intrinsics.areEqual($this_buildDeserializationNamesMap.getKind(), SerialKind.ENUM.INSTANCE) ? "enum value" : "property";
        if (map.containsKey(name)) {
            throw JsonExceptionsKt.decodingExceptionOf("The suggested name '" + name + "' for " + entity + ' ' + $this_buildDeserializationNamesMap.getElementName(index) + " is already one of the names for " + entity + ' ' + $this_buildDeserializationNamesMap.getElementName(((Number) MapsKt.getValue(map, name)).intValue()) + " in " + $this_buildDeserializationNamesMap);
        }
        map.put(name, Integer.valueOf(index));
    }

    public static final Map<String, Integer> buildDeserializationNamesMap(SerialDescriptor $this$buildDeserializationNamesMap, Json json) {
        String nameToPut;
        String[] strArrNames;
        String lowerCase;
        Map builder = new LinkedHashMap();
        boolean useLowercaseEnums = decodeCaseInsensitive(json, $this$buildDeserializationNamesMap);
        JsonNamingStrategy strategyForClasses = namingStrategy($this$buildDeserializationNamesMap, json);
        int elementsCount = $this$buildDeserializationNamesMap.getElementsCount();
        for (int i = 0; i < elementsCount; i++) {
            Iterable $this$filterIsInstance$iv = $this$buildDeserializationNamesMap.getElementAnnotations(i);
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filterIsInstance$iv) {
                if (element$iv$iv instanceof JsonNames) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            JsonNames jsonNames = (JsonNames) CollectionsKt.singleOrNull((List) destination$iv$iv);
            if (jsonNames != null && (strArrNames = jsonNames.names()) != null) {
                for (String str : strArrNames) {
                    if (useLowercaseEnums) {
                        lowerCase = str.toLowerCase(Locale.ROOT);
                        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
                    } else {
                        lowerCase = str;
                    }
                    buildDeserializationNamesMap$putOrThrow(builder, $this$buildDeserializationNamesMap, lowerCase, i);
                }
            }
            if (useLowercaseEnums) {
                nameToPut = $this$buildDeserializationNamesMap.getElementName(i).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(nameToPut, "toLowerCase(...)");
            } else {
                nameToPut = strategyForClasses != null ? strategyForClasses.serialNameForJson($this$buildDeserializationNamesMap, i, $this$buildDeserializationNamesMap.getElementName(i)) : null;
            }
            if (nameToPut != null) {
                String it = nameToPut;
                buildDeserializationNamesMap$putOrThrow(builder, $this$buildDeserializationNamesMap, it, i);
            }
        }
        return builder.isEmpty() ? MapsKt.emptyMap() : builder;
    }

    public static final Map<String, Integer> deserializationNamesMap(final Json $this$deserializationNamesMap, final SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter($this$deserializationNamesMap, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return (Map) JsonSchemaCacheKt.getSchemaCache($this$deserializationNamesMap).getOrPut(descriptor, JsonDeserializationNamesKey, new Function0() {
            @Override
            public final Object invoke() {
                return JsonNamesMapKt.buildDeserializationNamesMap(descriptor, $this$deserializationNamesMap);
            }
        });
    }

    public static final String[] serializationNamesIndices(final SerialDescriptor $this$serializationNamesIndices, Json json, final JsonNamingStrategy strategy) {
        Intrinsics.checkNotNullParameter($this$serializationNamesIndices, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(strategy, "strategy");
        return (String[]) JsonSchemaCacheKt.getSchemaCache(json).getOrPut($this$serializationNamesIndices, JsonSerializationNamesKey, new Function0() {
            @Override
            public final Object invoke() {
                return JsonNamesMapKt.serializationNamesIndices$lambda$0($this$serializationNamesIndices, strategy);
            }
        });
    }

    public static final String[] serializationNamesIndices$lambda$0(SerialDescriptor $this_serializationNamesIndices, JsonNamingStrategy $strategy) {
        Set trackingSet = new LinkedHashSet();
        int elementsCount = $this_serializationNamesIndices.getElementsCount();
        String[] strArr = new String[elementsCount];
        for (int i = 0; i < elementsCount; i++) {
            String baseName = $this_serializationNamesIndices.getElementName(i);
            String name = $strategy.serialNameForJson($this_serializationNamesIndices, i, baseName);
            if (trackingSet.add(name)) {
                strArr[i] = name;
            } else {
                throw new JsonEncodingException("The transformed name '" + name + "' for property " + baseName + " already exists in " + $this_serializationNamesIndices, $this_serializationNamesIndices.getSerialName(), null, 4, null);
            }
        }
        return strArr;
    }

    public static final String getJsonElementName(SerialDescriptor $this$getJsonElementName, Json json, int index) {
        Intrinsics.checkNotNullParameter($this$getJsonElementName, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        JsonNamingStrategy strategy = namingStrategy($this$getJsonElementName, json);
        return strategy == null ? $this$getJsonElementName.getElementName(index) : serializationNamesIndices($this$getJsonElementName, json, strategy)[index];
    }

    public static final Set<String> getJsonEncodedNames(SerialDescriptor $this$getJsonEncodedNames, Json json) {
        Intrinsics.checkNotNullParameter($this$getJsonEncodedNames, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        JsonNamingStrategy strategy = namingStrategy($this$getJsonEncodedNames, json);
        return strategy == null ? JsonInternalDependenciesKt.jsonCachedSerialNames($this$getJsonEncodedNames) : ArraysKt.toSet(serializationNamesIndices($this$getJsonEncodedNames, json, strategy));
    }

    public static final JsonNamingStrategy namingStrategy(SerialDescriptor $this$namingStrategy, Json json) {
        Intrinsics.checkNotNullParameter($this$namingStrategy, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        if (Intrinsics.areEqual($this$namingStrategy.getKind(), StructureKind.CLASS.INSTANCE)) {
            return json.getConfiguration().getNamingStrategy();
        }
        return null;
    }

    private static final int getJsonNameIndexSlowPath(SerialDescriptor $this$getJsonNameIndexSlowPath, Json json, String name) {
        Integer num = deserializationNamesMap(json, $this$getJsonNameIndexSlowPath).get(name);
        if (num != null) {
            return num.intValue();
        }
        return -3;
    }

    private static final boolean decodeCaseInsensitive(Json $this$decodeCaseInsensitive, SerialDescriptor descriptor) {
        return $this$decodeCaseInsensitive.getConfiguration().getDecodeEnumsCaseInsensitive() && Intrinsics.areEqual(descriptor.getKind(), SerialKind.ENUM.INSTANCE);
    }

    public static final int getJsonNameIndex(SerialDescriptor $this$getJsonNameIndex, Json json, String name) {
        Intrinsics.checkNotNullParameter($this$getJsonNameIndex, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(name, "name");
        if (decodeCaseInsensitive(json, $this$getJsonNameIndex)) {
            String lowerCase = name.toLowerCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
            return getJsonNameIndexSlowPath($this$getJsonNameIndex, json, lowerCase);
        }
        JsonNamingStrategy strategy = namingStrategy($this$getJsonNameIndex, json);
        if (strategy != null) {
            return getJsonNameIndexSlowPath($this$getJsonNameIndex, json, name);
        }
        int index = $this$getJsonNameIndex.getElementIndex(name);
        return (index == -3 && json.getConfiguration().getUseAlternativeNames()) ? getJsonNameIndexSlowPath($this$getJsonNameIndex, json, name) : index;
    }

    public static  int getJsonNameIndexOrThrow$default(SerialDescriptor serialDescriptor, Json json, String str, String str2, int i, Object obj) {
        if ((i & 4) != 0) {
            str2 = _UrlKt.FRAGMENT_ENCODE_SET;
        }
        return getJsonNameIndexOrThrow(serialDescriptor, json, str, str2);
    }

    public static final int getJsonNameIndexOrThrow(SerialDescriptor $this$getJsonNameIndexOrThrow, Json json, String name, String suffix) {
        Intrinsics.checkNotNullParameter($this$getJsonNameIndexOrThrow, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        int index = getJsonNameIndex($this$getJsonNameIndexOrThrow, json, name);
        if (index == -3) {
            throw new SerializationException($this$getJsonNameIndexOrThrow.getSerialName() + " does not contain element with name '" + name + '\'' + suffix);
        }
        return index;
    }

    public static  boolean tryCoerceValue$default(Json $this$tryCoerceValue_u24default, SerialDescriptor descriptor, int index, Function1 peekNull, Function0 peekString, Function0 onEnumCoercing, int i, Object obj) {
        String enumValue;
        if ((i & 16) != 0) {
            Function0 onEnumCoercing2 = new Function0<Unit>() {
                @Override
                public /* bridge */  Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                public final void invoke2() {
                }
            };
            onEnumCoercing = onEnumCoercing2;
        }
        Intrinsics.checkNotNullParameter($this$tryCoerceValue_u24default, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(peekNull, "peekNull");
        Intrinsics.checkNotNullParameter(peekString, "peekString");
        Intrinsics.checkNotNullParameter(onEnumCoercing, "onEnumCoercing");
        boolean isOptional = descriptor.isElementOptional(index);
        SerialDescriptor elementDescriptor = descriptor.getElementDescriptor(index);
        if (isOptional && !elementDescriptor.isNullable() && ((Boolean) peekNull.invoke(true)).booleanValue()) {
            return true;
        }
        if (!Intrinsics.areEqual(elementDescriptor.getKind(), SerialKind.ENUM.INSTANCE) || ((elementDescriptor.isNullable() && ((Boolean) peekNull.invoke(false)).booleanValue()) || (enumValue = (String) peekString.invoke()) == null)) {
            return false;
        }
        int enumIndex = getJsonNameIndex(elementDescriptor, $this$tryCoerceValue_u24default, enumValue);
        boolean coerceToNull = !$this$tryCoerceValue_u24default.getConfiguration().getExplicitNulls() && elementDescriptor.isNullable();
        if (enumIndex == -3 && (isOptional || coerceToNull)) {
            onEnumCoercing.invoke();
            return true;
        }
        return false;
    }

    public static final boolean tryCoerceValue(Json $this$tryCoerceValue, SerialDescriptor descriptor, int index, Function1<? super Boolean, Boolean> function1, Function0<String> function0, Function0<Unit> function2) {
        String enumValue;
        Intrinsics.checkNotNullParameter($this$tryCoerceValue, "<this>");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(function1, "peekNull");
        Intrinsics.checkNotNullParameter(function0, "peekString");
        Intrinsics.checkNotNullParameter(function2, "onEnumCoercing");
        boolean isOptional = descriptor.isElementOptional(index);
        SerialDescriptor elementDescriptor = descriptor.getElementDescriptor(index);
        if (isOptional && !elementDescriptor.isNullable() && function1.invoke(true).booleanValue()) {
            return true;
        }
        if (!Intrinsics.areEqual(elementDescriptor.getKind(), SerialKind.ENUM.INSTANCE) || ((elementDescriptor.isNullable() && function1.invoke(false).booleanValue()) || (enumValue = function0.invoke()) == null)) {
            return false;
        }
        int enumIndex = getJsonNameIndex(elementDescriptor, $this$tryCoerceValue, enumValue);
        boolean coerceToNull = !$this$tryCoerceValue.getConfiguration().getExplicitNulls() && elementDescriptor.isNullable();
        if (enumIndex == -3 && (isOptional || coerceToNull)) {
            function2.invoke();
            return true;
        }
        return false;
    }

    public static final boolean ignoreUnknownKeys(SerialDescriptor $this$ignoreUnknownKeys, Json json) {
        boolean z;
        Intrinsics.checkNotNullParameter($this$ignoreUnknownKeys, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        if (json.getConfiguration().getIgnoreUnknownKeys()) {
            return true;
        }
        Iterable $this$any$iv = $this$ignoreUnknownKeys.getAnnotations();
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            z = false;
        } else {
            for (Object element$iv : $this$any$iv) {
                Annotation it = (Annotation) element$iv;
                if (it instanceof JsonIgnoreUnknownKeys) {
                    z = true;
                }
            }
            z = false;
        }
        return z;
    }
}
