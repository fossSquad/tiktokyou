package ni.shikatu.kotlinx.serialization.json.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.MapsKt;
import ni.shikatu.kotlin.collections.SetsKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.kotlinx.serialization.descriptors.PolymorphicKind;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialKind;
import ni.shikatu.kotlinx.serialization.encoding.CompositeDecoder;
import ni.shikatu.kotlinx.serialization.internal.JsonInternalDependenciesKt;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.kotlinx.serialization.json.JsonConfiguration;
import ni.shikatu.kotlinx.serialization.json.JsonDecoder;
import ni.shikatu.kotlinx.serialization.json.JsonDecodingException;
import ni.shikatu.kotlinx.serialization.json.JsonElement;
import ni.shikatu.kotlinx.serialization.json.JsonElementKt;
import ni.shikatu.kotlinx.serialization.json.JsonNamingStrategy;
import ni.shikatu.kotlinx.serialization.json.JsonNull;
import ni.shikatu.kotlinx.serialization.json.JsonObject;
import ni.shikatu.kotlinx.serialization.json.JsonPrimitive;
import ni.shikatu.kotlinx.serialization.json.JsonSchemaCacheKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B1\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\tH\u0096\u0080\u0004J\u001a\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000fH\u0082\u0080\u0004J\n\u0010\u0016\u001a\u00020\u0011H\u0096\u0080\u0004J\u001a\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0015\u001a\u00020\u000fH\u0094\u0080\u0004J\u0012\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0094\u0080\u0004J\u0014\u0010\u001b\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0007H\u0086\u0080\u0004J\u0012\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\tH\u0096\u0080\u0004J\u0012\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0013\u001a\u00020\tH\u0096\u0080\u0004R\u0015\u0010\u0004\u001a\u00020\u0005X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u000e\u001a\u00020\u000fX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0010\u001a\u00020\u0011X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/JsonTreeDecoder;", "Lni/shikatu/kotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "value", "Lni/shikatu/kotlinx/serialization/json/JsonObject;", "polymorphicDiscriminator", _UrlKt.FRAGMENT_ENCODE_SET, "polyDescriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "<init>", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "position", _UrlKt.FRAGMENT_ENCODE_SET, "forceNull", _UrlKt.FRAGMENT_ENCODE_SET, "decodeElementIndex", "descriptor", "setForceNull", "index", "decodeNotNullMark", "elementName", "currentElement", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "tag", "currentElementOrNull", "beginStructure", "Lni/shikatu/kotlinx/serialization/encoding/CompositeDecoder;", "endStructure", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
class JsonTreeDecoder extends AbstractJsonTreeDecoder {
    private boolean forceNull;
    private final SerialDescriptor polyDescriptor;
    private int position;
    private final JsonObject value;

    public JsonTreeDecoder(Json json, JsonObject value, String polymorphicDiscriminator, SerialDescriptor polyDescriptor) {
        super(json, value, polymorphicDiscriminator, null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(value, "value");
        this.value = value;
        this.polyDescriptor = polyDescriptor;
    }

    public  JsonTreeDecoder(Json json, JsonObject jsonObject, String str, SerialDescriptor serialDescriptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, jsonObject, (i & 4) != 0 ? null : str, (i & 8) != 0 ? null : serialDescriptor);
    }

    @Override
    public JsonObject getValue() {
        return this.value;
    }

    @Override
    public int decodeElementIndex(SerialDescriptor descriptor) {
        JsonElement jsonElementCurrentElementOrNull;
        JsonPrimitive jsonPrimitive;
        String enumValue$iv;
        int enumIndex$iv;
        boolean coerceToNull$iv;
        boolean it;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        while (this.position < descriptor.getElementsCount()) {
            int i = this.position;
            this.position = i + 1;
            String name = getTag(descriptor, i);
            boolean z = true;
            int index = this.position - 1;
            this.forceNull = false;
            if (getValue().containsKey((Object) name) || setForceNull(descriptor, index)) {
                if (!this.configuration.getCoerceInputValues()) {
                    return index;
                }
                Json $this$tryCoerceValue$iv = getJson();
                boolean isOptional$iv = descriptor.isElementOptional(index);
                SerialDescriptor elementDescriptor$iv = descriptor.getElementDescriptor(index);
                if (isOptional$iv && !elementDescriptor$iv.isNullable()) {
                    boolean it2 = currentElementOrNull(name) instanceof JsonNull;
                    if (!it2) {
                        if (!Intrinsics.areEqual(elementDescriptor$iv.getKind(), SerialKind.ENUM.INSTANCE)) {
                            if (elementDescriptor$iv.isNullable()) {
                                it = currentElementOrNull(name) instanceof JsonNull;
                                if (it) {
                                    jsonElementCurrentElementOrNull = currentElementOrNull(name);
                                    if (jsonElementCurrentElementOrNull instanceof JsonPrimitive) {
                                        jsonPrimitive = (JsonPrimitive) jsonElementCurrentElementOrNull;
                                    } else {
                                        jsonPrimitive = null;
                                    }
                                    if (jsonPrimitive != null) {
                                    }
                                    if (enumValue$iv == null) {
                                        z = false;
                                    } else {
                                        enumIndex$iv = JsonNamesMapKt.getJsonNameIndex(elementDescriptor$iv, $this$tryCoerceValue$iv, enumValue$iv);
                                        if ($this$tryCoerceValue$iv.getConfiguration().getExplicitNulls()) {
                                            coerceToNull$iv = false;
                                        } else {
                                            coerceToNull$iv = false;
                                        }
                                        if (enumIndex$iv != -3) {
                                            z = false;
                                        } else {
                                            z = false;
                                        }
                                    }
                                } else {
                                    z = false;
                                }
                            } else {
                                jsonElementCurrentElementOrNull = currentElementOrNull(name);
                                if (jsonElementCurrentElementOrNull instanceof JsonPrimitive) {
                                    jsonPrimitive = (JsonPrimitive) jsonElementCurrentElementOrNull;
                                } else {
                                    jsonPrimitive = null;
                                }
                                if (jsonPrimitive != null) {
                                }
                                if (enumValue$iv == null) {
                                    z = false;
                                } else {
                                    enumIndex$iv = JsonNamesMapKt.getJsonNameIndex(elementDescriptor$iv, $this$tryCoerceValue$iv, enumValue$iv);
                                    if ($this$tryCoerceValue$iv.getConfiguration().getExplicitNulls()) {
                                        coerceToNull$iv = false;
                                    } else {
                                        coerceToNull$iv = false;
                                    }
                                    if (enumIndex$iv != -3) {
                                        z = false;
                                    } else {
                                        z = false;
                                    }
                                }
                            }
                        } else {
                            z = false;
                        }
                    }
                } else if (!Intrinsics.areEqual(elementDescriptor$iv.getKind(), SerialKind.ENUM.INSTANCE)) {
                    if (elementDescriptor$iv.isNullable()) {
                        it = currentElementOrNull(name) instanceof JsonNull;
                        if (it) {
                            jsonElementCurrentElementOrNull = currentElementOrNull(name);
                            if (jsonElementCurrentElementOrNull instanceof JsonPrimitive) {
                                jsonPrimitive = (JsonPrimitive) jsonElementCurrentElementOrNull;
                            } else {
                                jsonPrimitive = null;
                            }
                            enumValue$iv = jsonPrimitive != null ? JsonElementKt.getContentOrNull(jsonPrimitive) : null;
                            if (enumValue$iv == null) {
                                z = false;
                            } else {
                                enumIndex$iv = JsonNamesMapKt.getJsonNameIndex(elementDescriptor$iv, $this$tryCoerceValue$iv, enumValue$iv);
                                if ($this$tryCoerceValue$iv.getConfiguration().getExplicitNulls() && elementDescriptor$iv.isNullable()) {
                                    coerceToNull$iv = true;
                                } else {
                                    coerceToNull$iv = false;
                                }
                                if (enumIndex$iv != -3 && (isOptional$iv || coerceToNull$iv)) {
                                    if (setForceNull(descriptor, index)) {
                                        return index;
                                    }
                                } else {
                                    z = false;
                                }
                            }
                        } else {
                            z = false;
                        }
                    } else {
                        jsonElementCurrentElementOrNull = currentElementOrNull(name);
                        if (jsonElementCurrentElementOrNull instanceof JsonPrimitive) {
                            jsonPrimitive = (JsonPrimitive) jsonElementCurrentElementOrNull;
                        } else {
                            jsonPrimitive = null;
                        }
                        if (jsonPrimitive != null) {
                        }
                        if (enumValue$iv == null) {
                            z = false;
                        } else {
                            enumIndex$iv = JsonNamesMapKt.getJsonNameIndex(elementDescriptor$iv, $this$tryCoerceValue$iv, enumValue$iv);
                            if ($this$tryCoerceValue$iv.getConfiguration().getExplicitNulls()) {
                                coerceToNull$iv = false;
                            } else {
                                coerceToNull$iv = false;
                            }
                            if (enumIndex$iv != -3) {
                                z = false;
                            } else {
                                z = false;
                            }
                        }
                    }
                } else {
                    z = false;
                }
                if (!z) {
                    return index;
                }
            }
        }
        return -1;
    }

    private final boolean setForceNull(SerialDescriptor descriptor, int index) {
        this.forceNull = (getJson().getConfiguration().getExplicitNulls() || descriptor.isElementOptional(index) || !descriptor.getElementDescriptor(index).isNullable()) ? false : true;
        return this.forceNull;
    }

    @Override
    public boolean decodeNotNullMark() {
        return !this.forceNull && super.decodeNotNullMark();
    }

    @Override
    protected String elementName(SerialDescriptor descriptor, int index) {
        Object next;
        Integer num;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        JsonNamingStrategy strategy = JsonNamesMapKt.namingStrategy(descriptor, getJson());
        String baseName = descriptor.getElementName(index);
        if (strategy == null && (!this.configuration.getUseAlternativeNames() || getValue().keySet().contains(baseName))) {
            return baseName;
        }
        Map<String, Integer> mapDeserializationNamesMap = JsonNamesMapKt.deserializationNamesMap(getJson(), descriptor);
        Iterator<String> it = getValue().keySet().iterator();
        do {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            num = mapDeserializationNamesMap.get((String) next);
        } while (!(num != null && num.intValue() == index));
        String it2 = (String) next;
        if (it2 != null) {
            return it2;
        }
        String fallbackName = strategy != null ? strategy.serialNameForJson(descriptor, index, baseName) : null;
        return fallbackName == null ? baseName : fallbackName;
    }

    @Override
    public JsonElement currentElement(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return (JsonElement) MapsKt.getValue(getValue(), tag);
    }

    public final JsonElement currentElementOrNull(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return (JsonElement) getValue().get((Object) tag);
    }

    @Override
    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (descriptor != this.polyDescriptor) {
            return super.beginStructure(descriptor);
        }
        Json json = getJson();
        JsonTreeDecoder this_$iv = this;
        JsonElement value$iv = currentObject();
        SerialDescriptor descriptor$iv = this.polyDescriptor;
        JsonTreeDecoder $this$cast$iv$iv = this_$iv;
        String serialName$iv$iv = descriptor$iv.getSerialName();
        if (value$iv instanceof JsonObject) {
            return new JsonTreeDecoder(json, (JsonObject) value$iv, getPolymorphicDiscriminator(), this.polyDescriptor);
        }
        String shortMessage$iv$iv$iv = "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(value$iv.getClass()).getSimpleName() + " as the serialized body of " + serialName$iv$iv;
        String path$iv$iv$iv = this_$iv.renderTagStack();
        JsonConfiguration $this$ifDebugInput$iv$iv$iv$iv = $this$cast$iv$iv.getJson().getConfiguration();
        String inputValue$iv$iv$iv = $this$ifDebugInput$iv$iv$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(value$iv.toString(), 0, 1, null).toString() : null;
        throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv$iv$iv, path$iv$iv$iv, null, inputValue$iv$iv$iv), shortMessage$iv$iv$iv, -1, path$iv$iv$iv, inputValue$iv$iv$iv, null);
    }

    @Override
    public void endStructure(SerialDescriptor descriptor) {
        Set<String> setPlus;
        JsonTreeDecoder jsonTreeDecoder = this;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (JsonNamesMapKt.ignoreUnknownKeys(descriptor, jsonTreeDecoder.getJson()) || (descriptor.getKind() instanceof PolymorphicKind)) {
            return;
        }
        JsonNamingStrategy strategy = JsonNamesMapKt.namingStrategy(descriptor, jsonTreeDecoder.getJson());
        if (strategy == null && !jsonTreeDecoder.configuration.getUseAlternativeNames()) {
            setPlus = JsonInternalDependenciesKt.jsonCachedSerialNames(descriptor);
        } else if (strategy != null) {
            setPlus = JsonNamesMapKt.deserializationNamesMap(jsonTreeDecoder.getJson(), descriptor).keySet();
        } else {
            Set<String> setJsonCachedSerialNames = JsonInternalDependenciesKt.jsonCachedSerialNames(descriptor);
            Map map = (Map) JsonSchemaCacheKt.getSchemaCache(jsonTreeDecoder.getJson()).get(descriptor, JsonNamesMapKt.getJsonDeserializationNamesKey());
            Set setKeySet = map != null ? map.keySet() : null;
            if (setKeySet == null) {
                setKeySet = SetsKt.emptySet();
            }
            setPlus = SetsKt.plus((Set) setJsonCachedSerialNames, (Iterable) setKeySet);
        }
        for (String key : jsonTreeDecoder.getValue().keySet()) {
            if (!setPlus.contains(key) && !Intrinsics.areEqual(key, jsonTreeDecoder.getPolymorphicDiscriminator())) {
                JsonDecoder $this$decodingExceptionOf$iv = jsonTreeDecoder;
                String shortMessage$iv = "Encountered an unknown key '" + key + '\'';
                String path$iv = jsonTreeDecoder.renderTagStack();
                JsonConfiguration $this$ifDebugInput$iv$iv = $this$decodingExceptionOf$iv.getJson().getConfiguration();
                String inputValue$iv = $this$ifDebugInput$iv$iv.getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(jsonTreeDecoder.getValue().toString(), 0, 1, null).toString() : null;
                throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, shortMessage$iv, path$iv, AbstractJsonLexerKt.ignoreUnknownKeysHint, inputValue$iv), shortMessage$iv, -1, path$iv, inputValue$iv, AbstractJsonLexerKt.ignoreUnknownKeysHint);
            }
            jsonTreeDecoder = this;
        }
    }
}
