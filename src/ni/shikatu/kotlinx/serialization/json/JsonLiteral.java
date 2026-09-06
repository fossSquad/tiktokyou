package ni.shikatu.kotlinx.serialization.json;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.kotlinx.serialization.json.internal.StringOpsKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B%\b@\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0004\b\b\u0010\tJ\n\u0010\u0011\u001a\u00020\u000eH\u0096\u0080\u0004J\u0014\u0010\u0012\u001a\u00020\u00052\b\u0010\u0013\u001a\u0004\u0018\u00010\u0003H\u0096\u0082\u0004J\n\u0010\u0014\u001a\u00020\u0015H\u0097\u0080\u0004R\u0015\u0010\u0004\u001a\u00020\u0005X\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\nR\u0017\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0080\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0015\u0010\r\u001a\u00020\u000eX\u0096\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0016"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonLiteral;", "Lni/shikatu/kotlinx/serialization/json/JsonPrimitive;", "body", _UrlKt.FRAGMENT_ENCODE_SET, "isString", _UrlKt.FRAGMENT_ENCODE_SET, "coerceToInlineType", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "<init>", "(Ljava/lang/Object;ZLkotlinx/serialization/descriptors/SerialDescriptor;)V", "()Z", "getCoerceToInlineType$kotlinx_serialization_json", "()Lkotlinx/serialization/descriptors/SerialDescriptor;", "content", _UrlKt.FRAGMENT_ENCODE_SET, "getContent", "()Ljava/lang/String;", "toString", "equals", "other", "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JsonLiteral extends JsonPrimitive {
    private final SerialDescriptor coerceToInlineType;
    private final String content;
    private final boolean isString;

    public JsonLiteral(Object body, boolean isString, SerialDescriptor coerceToInlineType) {
        super(null);
        Intrinsics.checkNotNullParameter(body, "body");
        this.isString = isString;
        this.coerceToInlineType = coerceToInlineType;
        this.content = body.toString();
        if (this.coerceToInlineType != null && !this.coerceToInlineType.isInline()) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
    }

    public  JsonLiteral(Object obj, boolean z, SerialDescriptor serialDescriptor, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, z, (i & 4) != 0 ? null : serialDescriptor);
    }

    @Override
    public boolean isString() {
        return this.isString;
    }

    public final SerialDescriptor getCoerceToInlineType$kotlinx_serialization_json() {
        return this.coerceToInlineType;
    }

    @Override
    public String getContent() {
        return this.content;
    }

    @Override
    public String toString() {
        if (isString()) {
            StringBuilder $this$toString_u24lambda_u240 = new StringBuilder();
            StringOpsKt.printQuoted($this$toString_u24lambda_u240, getContent());
            return $this$toString_u24lambda_u240.toString();
        }
        return getContent();
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        if (isString() == ((JsonLiteral) other).isString() && Intrinsics.areEqual(getContent(), ((JsonLiteral) other).getContent())) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int result = Boolean.hashCode(isString());
        return (result * 31) + getContent().hashCode();
    }
}
