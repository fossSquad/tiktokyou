package ni.shikatu.kotlinx.serialization.json;

import java.lang.annotation.Annotation;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.kotlinx.serialization.builtins.BuiltinSerializersKt;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.descriptors.SerialKind;
import ni.shikatu.kotlinx.serialization.encoding.Decoder;
import ni.shikatu.kotlinx.serialization.encoding.Encoder;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0011B\t\bB¢\u0006\u0004\b\u0003\u0010\u0004J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0002H\u0096\u0080\u0004J\u0012\u0010\u000e\u001a\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0096\u0080\u0004R\u0015\u0010\u0005\u001a\u00020\u0006X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonArraySerializer;", "Lni/shikatu/kotlinx/serialization/KSerializer;", "Lni/shikatu/kotlinx/serialization/json/JsonArray;", "<init>", "()V", "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "getDescriptor", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "serialize", _UrlKt.FRAGMENT_ENCODE_SET, "encoder", "Lni/shikatu/kotlinx/serialization/encoding/Encoder;", "value", "deserialize", "decoder", "Lni/shikatu/kotlinx/serialization/encoding/Decoder;", "JsonArrayDescriptor", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JsonArraySerializer implements KSerializer<JsonArray> {
    public static final JsonArraySerializer INSTANCE = new JsonArraySerializer();
    private static final SerialDescriptor descriptor = JsonArrayDescriptor.INSTANCE;

    private JsonArraySerializer() {
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0081\u0004J\u0012\u0010\r\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0081\u0004J\u0012\u0010\u000e\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u0005H\u0096\u0081\u0004J\u0012\u0010\u0010\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0081\u0004J\u0012\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000b\u001a\u00020\fH\u0096\u0081\u0004R\u0015\u0010\u0004\u001a\u00020\u0005X\u0096Ä\b¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\n0\t8VX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u00020\fX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0015\u0010\u0019\u001a\u00020\u00128VX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR\u0015\u0010\u001b\u001a\u00020\u00128VX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001aR\u0013\u0010\u001c\u001a\u00020\u001dX\u0096\u0085\b¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonArraySerializer$JsonArrayDescriptor;", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "<init>", "()V", "serialName", _UrlKt.FRAGMENT_ENCODE_SET, "getSerialName", "()Ljava/lang/String;", "getElementAnnotations", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "index", _UrlKt.FRAGMENT_ENCODE_SET, "getElementDescriptor", "getElementIndex", "name", "getElementName", "isElementOptional", _UrlKt.FRAGMENT_ENCODE_SET, "annotations", "getAnnotations", "()Ljava/util/List;", "elementsCount", "getElementsCount", "()I", "isInline", "()Z", "isNullable", "kind", "Lni/shikatu/kotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
    private static final class JsonArrayDescriptor implements SerialDescriptor {
        public static final JsonArrayDescriptor INSTANCE = new JsonArrayDescriptor();
        private static final String serialName = "ni.shikatu.kotlinx.serialization.json.JsonArray";
        private final  SerialDescriptor $$delegate_0 = BuiltinSerializersKt.ListSerializer(JsonElementSerializer.INSTANCE).getDescriptor();

        @Override
        public List<Annotation> getAnnotations() {
            return this.$$delegate_0.getAnnotations();
        }

        @Override
        public List<Annotation> getElementAnnotations(int i) {
            return this.$$delegate_0.getElementAnnotations(i);
        }

        @Override
        public SerialDescriptor getElementDescriptor(int i) {
            return this.$$delegate_0.getElementDescriptor(i);
        }

        @Override
        public int getElementIndex(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            return this.$$delegate_0.getElementIndex(str);
        }

        @Override
        public String getElementName(int i) {
            return this.$$delegate_0.getElementName(i);
        }

        @Override
        public int getElementsCount() {
            return this.$$delegate_0.getElementsCount();
        }

        @Override
        public SerialKind getKind() {
            return this.$$delegate_0.getKind();
        }

        @Override
        public boolean isElementOptional(int i) {
            return this.$$delegate_0.isElementOptional(i);
        }

        @Override
        public boolean isInline() {
            return this.$$delegate_0.isInline();
        }

        @Override
        public boolean isNullable() {
            return this.$$delegate_0.isNullable();
        }

        private JsonArrayDescriptor() {
        }

        @Override
        public String getSerialName() {
            return serialName;
        }
    }

    @Override
    public SerialDescriptor getDescriptor() {
        return descriptor;
    }

    @Override
    public void serialize(Encoder encoder, JsonArray value) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        Intrinsics.checkNotNullParameter(value, "value");
        JsonElementSerializersKt.verify(encoder);
        BuiltinSerializersKt.ListSerializer(JsonElementSerializer.INSTANCE).serialize(encoder, value);
    }

    @Override
    public JsonArray deserialize(Decoder decoder) {
        Intrinsics.checkNotNullParameter(decoder, "decoder");
        JsonElementSerializersKt.verify(decoder);
        return new JsonArray((List) BuiltinSerializersKt.ListSerializer(JsonElementSerializer.INSTANCE).deserialize(decoder));
    }
}
