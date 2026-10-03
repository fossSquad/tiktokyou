package ni.shikatu.kotlinx.serialization.json.internal;

import java.lang.annotation.Annotation;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.NoWhenBranchMatchedException;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.Reflection;
import ni.shikatu.kotlinx.serialization.DeserializationStrategy;
import ni.shikatu.kotlinx.serialization.PolymorphicSerializerKt;
import ni.shikatu.kotlinx.serialization.SerializationException;
import ni.shikatu.kotlinx.serialization.SerializationStrategy;
import ni.shikatu.kotlinx.serialization.descriptors.PolymorphicKind;
import ni.shikatu.kotlinx.serialization.descriptors.PrimitiveKind;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialKind;
import ni.shikatu.kotlinx.serialization.descriptors.StructureKind;
import ni.shikatu.kotlinx.serialization.internal.AbstractPolymorphicSerializer;
import ni.shikatu.kotlinx.serialization.json.ClassDiscriminatorMode;
import ni.shikatu.kotlinx.serialization.json.Json;
import ni.shikatu.kotlinx.serialization.json.JsonClassDiscriminator;
import ni.shikatu.kotlinx.serialization.json.JsonDecoder;
import ni.shikatu.kotlinx.serialization.json.JsonDecodingException;
import ni.shikatu.kotlinx.serialization.json.JsonElement;
import ni.shikatu.kotlinx.serialization.json.JsonElementKt;
import ni.shikatu.kotlinx.serialization.json.JsonEncoder;
import ni.shikatu.kotlinx.serialization.json.JsonEncodingException;
import ni.shikatu.kotlinx.serialization.json.JsonObject;
import ni.shikatu.kotlinx.serialization.json.JsonPrimitive;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000Z\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0000\u001aj\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00052\u0006\u0010\u0006\u001a\u0002H\u000226\u0010\u0007\u001a2\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00010\bH\u0080\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u000e\u001a.\u0010\u000f\u001a\u00020\u0001*\u00020\u00102\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0012\u001a\u00020\tH\u0082\u0080\u0004\u001a\u0012\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0015H\u0080\u0080\u0004\u001a8\u0010\u0016\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\u00020\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u0002H\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\t0\u001bH\u0080\u0088\u0004ø\u0001\u0000¢\u0006\u0002\u0010\u001c\u001a\u0016\u0010\u0012\u001a\u00020\t*\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0010H\u0080\u0080\u0004\u001a\u001c\u0010\u001f\u001a\u00020 2\b\u0010\r\u001a\u0004\u0018\u00010\t2\u0006\u0010!\u001a\u00020\"H\u0080\u0080\u0004\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#"}, d2 = {"encodePolymorphically", _UrlKt.FRAGMENT_ENCODE_SET, "T", "Lni/shikatu/kotlinx/serialization/json/JsonEncoder;", "serializer", "Lni/shikatu/kotlinx/serialization/SerializationStrategy;", "value", "ifPolymorphic", "Lni/shikatu/kotlin/Function2;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ParameterName;", "name", "discriminatorName", "serialName", "(Lkotlinx/serialization/json/JsonEncoder;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)V", "checkEncodingConflicts", "Lni/shikatu/kotlinx/serialization/json/Json;", "actualSerializer", "classDiscriminator", "checkKind", "kind", "Lni/shikatu/kotlinx/serialization/descriptors/SerialKind;", "decodeSerializableValuePolymorphic", "Lni/shikatu/kotlinx/serialization/json/JsonDecoder;", "deserializer", "Lni/shikatu/kotlinx/serialization/DeserializationStrategy;", "path", "Lni/shikatu/kotlin/Function0;", "(Lkotlinx/serialization/json/JsonDecoder;Lkotlinx/serialization/DeserializationStrategy;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "json", "throwJsonElementPolymorphicException", _UrlKt.FRAGMENT_ENCODE_SET, "element", "Lni/shikatu/kotlinx/serialization/json/JsonElement;", "ni.shikatu.kotlinx-serialization-json"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class PolymorphicKt {

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 176)
    public static final  class WhenMappings {
        public static final  int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ClassDiscriminatorMode.values().length];
            try {
                iArr[ClassDiscriminatorMode.NONE.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[ClassDiscriminatorMode.POLYMORPHIC.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[ClassDiscriminatorMode.ALL_JSON_OBJECTS.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final <T> void encodePolymorphically(JsonEncoder $this$encodePolymorphically, SerializationStrategy<? super T> serializationStrategy, T t, Function2<? super String, ? super String, Unit> function2) {
        SerializationStrategy<? super T> serializationStrategyFindPolymorphicSerializer;
        Intrinsics.checkNotNullParameter($this$encodePolymorphically, "<this>");
        Intrinsics.checkNotNullParameter(serializationStrategy, "serializer");
        Intrinsics.checkNotNullParameter(function2, "ifPolymorphic");
        if ($this$encodePolymorphically.getJson().getConfiguration().getUseArrayPolymorphism()) {
            serializationStrategy.serialize($this$encodePolymorphically, t);
            return;
        }
        boolean isPolymorphicSerializer = serializationStrategy instanceof AbstractPolymorphicSerializer;
        boolean needDiscriminator = true;
        if (isPolymorphicSerializer) {
            if ($this$encodePolymorphically.getJson().getConfiguration().getClassDiscriminatorMode() == ClassDiscriminatorMode.NONE) {
                needDiscriminator = false;
            }
        } else {
            switch (WhenMappings.$EnumSwitchMapping$0[$this$encodePolymorphically.getJson().getConfiguration().getClassDiscriminatorMode().ordinal()]) {
                case 1:
                case 2:
                    needDiscriminator = false;
                    break;
                case 3:
                    SerialKind it = serializationStrategy.getDescriptor().getKind();
                    if (!Intrinsics.areEqual(it, StructureKind.CLASS.INSTANCE) && !Intrinsics.areEqual(it, StructureKind.OBJECT.INSTANCE)) {
                        needDiscriminator = false;
                    }
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
        }
        String baseClassDiscriminator = needDiscriminator ? classDiscriminator(serializationStrategy.getDescriptor(), $this$encodePolymorphically.getJson()) : null;
        if (isPolymorphicSerializer) {
            AbstractPolymorphicSerializer casted = (AbstractPolymorphicSerializer) serializationStrategy;
            if (t == null) {
                throw new IllegalArgumentException(("Value for serializer " + ((AbstractPolymorphicSerializer) serializationStrategy).getDescriptor() + " should always be non-null. Please report issue to the kotlinx.serialization tracker.").toString());
            }
            serializationStrategyFindPolymorphicSerializer = PolymorphicSerializerKt.findPolymorphicSerializer(casted, $this$encodePolymorphically, t);
            Intrinsics.checkNotNull(serializationStrategyFindPolymorphicSerializer, "null cannot be cast to non-null type kotlinx.serialization.SerializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.encodePolymorphically>");
        } else {
            serializationStrategyFindPolymorphicSerializer = serializationStrategy;
        }
        if (baseClassDiscriminator != null) {
            checkEncodingConflicts($this$encodePolymorphically.getJson(), serializationStrategy, serializationStrategyFindPolymorphicSerializer, baseClassDiscriminator);
            checkKind(serializationStrategyFindPolymorphicSerializer.getDescriptor().getKind());
            function2.invoke(baseClassDiscriminator, serializationStrategyFindPolymorphicSerializer.getDescriptor().getSerialName());
        }
        serializationStrategyFindPolymorphicSerializer.serialize($this$encodePolymorphically, t);
    }

    public static final void checkEncodingConflicts(Json $this$checkEncodingConflicts, SerializationStrategy<?> serializationStrategy, SerializationStrategy<?> serializationStrategy2, String classDiscriminator) {
        if (JsonNamesMapKt.getJsonEncodedNames(serializationStrategy2.getDescriptor(), $this$checkEncodingConflicts).contains(classDiscriminator)) {
            String baseName = serializationStrategy.getDescriptor().getSerialName();
            String actualName = serializationStrategy2.getDescriptor().getSerialName();
            String text = ($this$checkEncodingConflicts.getConfiguration().getClassDiscriminatorMode() == ClassDiscriminatorMode.ALL_JSON_OBJECTS && Intrinsics.areEqual(baseName, actualName)) ? "in ALL_JSON_OBJECTS class discriminator mode" : "as base class '" + baseName + '\'';
            throw new JsonEncodingException("Class '" + actualName + "' cannot be serialized " + text + " because it has property name that conflicts with JSON class discriminator '" + classDiscriminator + "'.", actualName, "You can either change class discriminator in JsonConfiguration, or rename property with @SerialName annotation.");
        }
    }

    public static final void checkKind(SerialKind kind) {
        Intrinsics.checkNotNullParameter(kind, "kind");
        if (kind instanceof SerialKind.ENUM) {
            throw new IllegalStateException("Enums cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
        }
        if (kind instanceof PrimitiveKind) {
            throw new IllegalStateException("Primitives cannot be serialized polymorphically with 'type' parameter. You can use 'JsonBuilder.useArrayPolymorphism' instead".toString());
        }
        if (kind instanceof PolymorphicKind) {
            throw new IllegalStateException("Actual serializer for polymorphic cannot be polymorphic itself".toString());
        }
    }

    public static final <T> T decodeSerializableValuePolymorphic(JsonDecoder jsonDecoder, DeserializationStrategy<? extends T> deserializationStrategy, Function0<String> function0) {
        JsonPrimitive jsonPrimitive;
        Intrinsics.checkNotNullParameter(jsonDecoder, "<this>");
        Intrinsics.checkNotNullParameter(deserializationStrategy, "deserializer");
        Intrinsics.checkNotNullParameter(function0, "path");
        if (!(deserializationStrategy instanceof AbstractPolymorphicSerializer) || jsonDecoder.getJson().getConfiguration().getUseArrayPolymorphism()) {
            return deserializationStrategy.deserialize(jsonDecoder);
        }
        String strClassDiscriminator = classDiscriminator(((AbstractPolymorphicSerializer) deserializationStrategy).getDescriptor(), jsonDecoder.getJson());
        JsonElement jsonElementDecodeJsonElement = jsonDecoder.decodeJsonElement();
        String serialName = ((AbstractPolymorphicSerializer) deserializationStrategy).getDescriptor().getSerialName();
        String string = null;
        if (!(jsonElementDecodeJsonElement instanceof JsonObject)) {
            String str = "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class).getSimpleName() + ", but had " + Reflection.getOrCreateKotlinClass(jsonElementDecodeJsonElement.getClass()).getSimpleName() + " as the serialized body of " + serialName;
            String strInvoke = function0.invoke();
            String string2 = jsonDecoder.getJson().getConfiguration().getExceptionsWithDebugInfo() ? JsonExceptionsKt.minify$default(jsonElementDecodeJsonElement.toString(), 0, 1, null).toString() : null;
            throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, str, strInvoke, null, string2), str, -1, strInvoke, string2, null);
        }
        JsonObject jsonObject = (JsonObject) jsonElementDecodeJsonElement;
        JsonElement jsonElement = (JsonElement) jsonObject.get((Object) strClassDiscriminator);
        try {
            DeserializationStrategy deserializationStrategyFindPolymorphicSerializer = PolymorphicSerializerKt.findPolymorphicSerializer((AbstractPolymorphicSerializer) deserializationStrategy, jsonDecoder, (jsonElement == null || (jsonPrimitive = JsonElementKt.getJsonPrimitive(jsonElement)) == null) ? null : JsonElementKt.getContentOrNull(jsonPrimitive));
            Intrinsics.checkNotNull(deserializationStrategyFindPolymorphicSerializer, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.decodeSerializableValuePolymorphic>");
            return (T) TreeJsonDecoderKt.readPolymorphicJson(jsonDecoder.getJson(), strClassDiscriminator, jsonObject, deserializationStrategyFindPolymorphicSerializer);
        } catch (SerializationException e) {
            String message = e.getMessage();
            Intrinsics.checkNotNull(message);
            if (jsonDecoder.getJson().getConfiguration().getExceptionsWithDebugInfo()) {
                string = JsonExceptionsKt.minify$default(jsonObject.toString(), 0, 1, null).toString();
            }
            String str2 = string;
            throw new JsonDecodingException(JsonExceptionsKt.formatDecodingException(-1, message, null, null, str2), message, -1, null, str2, null);
        }
    }

    public static final String classDiscriminator(SerialDescriptor $this$classDiscriminator, Json json) {
        Intrinsics.checkNotNullParameter($this$classDiscriminator, "<this>");
        Intrinsics.checkNotNullParameter(json, "json");
        for (Annotation annotation : $this$classDiscriminator.getAnnotations()) {
            if (annotation instanceof JsonClassDiscriminator) {
                return ((JsonClassDiscriminator) annotation).discriminator();
            }
        }
        return json.getConfiguration().getClassDiscriminator();
    }

    public static final Void throwJsonElementPolymorphicException(String serialName, JsonElement element) {
        Intrinsics.checkNotNullParameter(element, "element");
        throw new JsonEncodingException("Class with serial name " + serialName + " cannot be serialized polymorphically because it is represented as " + Reflection.getOrCreateKotlinClass(element.getClass()).getSimpleName() + '.', serialName, "Make sure that its JsonTransformingSerializer returns JsonObject, so class discriminator can be added to it.");
    }
}
