package ni.shikatu.kotlinx.serialization.json;

import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.io.ConstantsKt;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Segment;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\"\u0018\u00002\u00020\u0001B¿\u0001\b@\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\n\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0016\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0003¢\u0006\u0004\b\u0018\u0010\u0019J\n\u00107\u001a\u00020\nH\u0096\u0080\u0004R\u0015\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0015\u0010\u0004\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0015\u0010\u0005\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u001bR\u0015\u0010\u0006\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001bR\u0015\u0010\u0007\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001bR\u0015\u0010\b\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001bR\u0015\u0010\t\u001a\u00020\nX\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u0015\u0010\u000b\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001bR\u0015\u0010\f\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001bR\u0015\u0010\r\u001a\u00020\nX\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b$\u0010!R\u0015\u0010\u000e\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001bR\u0015\u0010\u000f\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u001bR\u001f\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006X\u0087\u0084\b¢\u0006\u000e\n\u0000\u0012\u0004\b'\u0010(\u001a\u0004\b)\u0010*R\u0015\u0010\u0012\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u001bR\u0015\u0010\u0013\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u001bR\u0015\u0010\u0014\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\u001bR#\u0010\u0015\u001a\u00020\u00168\u0006X\u0087\u008e\b¢\u0006\u0014\n\u0000\u0012\u0004\b.\u0010(\u001a\u0004\b/\u00100\"\u0004\b1\u00102R%\u0010\u0017\u001a\u00020\u00038\u0006@\u0006X\u0087\u008e\b¢\u0006\u0014\n\u0000\u0012\u0004\b3\u0010(\u001a\u0004\b4\u0010\u001b\"\u0004\b5\u00106¨\u00068"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonConfiguration;", _UrlKt.FRAGMENT_ENCODE_SET, "encodeDefaults", _UrlKt.FRAGMENT_ENCODE_SET, "ignoreUnknownKeys", "isLenient", "allowStructuredMapKeys", "prettyPrint", "explicitNulls", "prettyPrintIndent", _UrlKt.FRAGMENT_ENCODE_SET, "coerceInputValues", "useArrayPolymorphism", "classDiscriminator", "allowSpecialFloatingPointValues", "useAlternativeNames", "namingStrategy", "Lni/shikatu/kotlinx/serialization/json/JsonNamingStrategy;", "decodeEnumsCaseInsensitive", "allowTrailingComma", "allowComments", "classDiscriminatorMode", "Lni/shikatu/kotlinx/serialization/json/ClassDiscriminatorMode;", "exceptionsWithDebugInfo", "<init>", "(ZZZZZZLjava/lang/String;ZZLjava/lang/String;ZZLkotlinx/serialization/json/JsonNamingStrategy;ZZZLkotlinx/serialization/json/ClassDiscriminatorMode;Z)V", "getEncodeDefaults", "()Z", "getIgnoreUnknownKeys", "getAllowStructuredMapKeys", "getPrettyPrint", "getExplicitNulls", "getPrettyPrintIndent", "()Ljava/lang/String;", "getCoerceInputValues", "getUseArrayPolymorphism", "getClassDiscriminator", "getAllowSpecialFloatingPointValues", "getUseAlternativeNames", "getNamingStrategy$annotations", "()V", "getNamingStrategy", "()Lkotlinx/serialization/json/JsonNamingStrategy;", "getDecodeEnumsCaseInsensitive", "getAllowTrailingComma", "getAllowComments", "getClassDiscriminatorMode$annotations", "getClassDiscriminatorMode", "()Lkotlinx/serialization/json/ClassDiscriminatorMode;", "setClassDiscriminatorMode", "(Lkotlinx/serialization/json/ClassDiscriminatorMode;)V", "getExceptionsWithDebugInfo$annotations", "getExceptionsWithDebugInfo", "setExceptionsWithDebugInfo", "(Z)V", "toString", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JsonConfiguration {
    private final boolean allowComments;
    private final boolean allowSpecialFloatingPointValues;
    private final boolean allowStructuredMapKeys;
    private final boolean allowTrailingComma;
    private final String classDiscriminator;
    private ClassDiscriminatorMode classDiscriminatorMode;
    private final boolean coerceInputValues;
    private final boolean decodeEnumsCaseInsensitive;
    private final boolean encodeDefaults;
    private boolean exceptionsWithDebugInfo;
    private final boolean explicitNulls;
    private final boolean ignoreUnknownKeys;
    private final boolean isLenient;
    private final JsonNamingStrategy namingStrategy;
    private final boolean prettyPrint;
    private final String prettyPrintIndent;
    private final boolean useAlternativeNames;
    private final boolean useArrayPolymorphism;

    public JsonConfiguration() {
        this(false, false, false, false, false, false, null, false, false, null, false, false, null, false, false, false, null, false, 262143, null);
    }

    @ExperimentalSerializationApi
    public static  void getClassDiscriminatorMode$annotations() {
    }

    @ExperimentalSerializationApi
    public static  void getExceptionsWithDebugInfo$annotations() {
    }

    @ExperimentalSerializationApi
    public static  void getNamingStrategy$annotations() {
    }

    public JsonConfiguration(boolean encodeDefaults, boolean ignoreUnknownKeys, boolean isLenient, boolean allowStructuredMapKeys, boolean prettyPrint, boolean explicitNulls, String prettyPrintIndent, boolean coerceInputValues, boolean useArrayPolymorphism, String classDiscriminator, boolean allowSpecialFloatingPointValues, boolean useAlternativeNames, JsonNamingStrategy namingStrategy, boolean decodeEnumsCaseInsensitive, boolean allowTrailingComma, boolean allowComments, ClassDiscriminatorMode classDiscriminatorMode, boolean exceptionsWithDebugInfo) {
        Intrinsics.checkNotNullParameter(prettyPrintIndent, "prettyPrintIndent");
        Intrinsics.checkNotNullParameter(classDiscriminator, "classDiscriminator");
        Intrinsics.checkNotNullParameter(classDiscriminatorMode, "classDiscriminatorMode");
        this.encodeDefaults = encodeDefaults;
        this.ignoreUnknownKeys = ignoreUnknownKeys;
        this.isLenient = isLenient;
        this.allowStructuredMapKeys = allowStructuredMapKeys;
        this.prettyPrint = prettyPrint;
        this.explicitNulls = explicitNulls;
        this.prettyPrintIndent = prettyPrintIndent;
        this.coerceInputValues = coerceInputValues;
        this.useArrayPolymorphism = useArrayPolymorphism;
        this.classDiscriminator = classDiscriminator;
        this.allowSpecialFloatingPointValues = allowSpecialFloatingPointValues;
        this.useAlternativeNames = useAlternativeNames;
        this.namingStrategy = namingStrategy;
        this.decodeEnumsCaseInsensitive = decodeEnumsCaseInsensitive;
        this.allowTrailingComma = allowTrailingComma;
        this.allowComments = allowComments;
        this.classDiscriminatorMode = classDiscriminatorMode;
        this.exceptionsWithDebugInfo = exceptionsWithDebugInfo;
    }

    public  JsonConfiguration(boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, String str, boolean z7, boolean z8, String str2, boolean z9, boolean z10, JsonNamingStrategy jsonNamingStrategy, boolean z11, boolean z12, boolean z13, ClassDiscriminatorMode classDiscriminatorMode, boolean z14, int i, DefaultConstructorMarker defaultConstructorMarker) {
        boolean z15 = (i & 1) != 0 ? false : z;
        boolean z16 = (i & 2) != 0 ? false : z2;
        boolean z17 = (i & 4) != 0 ? false : z3;
        boolean z18 = (i & 8) != 0 ? false : z4;
        boolean z19 = (i & 16) != 0 ? false : z5;
        boolean z20 = (i & 32) != 0 ? true : z6;
        String str3 = (i & 64) != 0 ? "    " : str;
        boolean z21 = (i & 128) != 0 ? false : z7;
        boolean z22 = (i & 256) != 0 ? false : z8;
        String str4 = (i & ConstantsKt.MINIMUM_BLOCK_SIZE) != 0 ? "type" : str2;
        boolean z23 = (i & Segment.SHARE_MINIMUM) != 0 ? false : z9;
        boolean z24 = (i & 2048) != 0 ? true : z10;
        JsonNamingStrategy jsonNamingStrategy2 = (i & 4096) != 0 ? null : jsonNamingStrategy;
        boolean z25 = (i & 8192) != 0 ? false : z11;
        this(z15, z16, z17, z18, z19, z20, str3, z21, z22, str4, z23, z24, jsonNamingStrategy2, z25, (i & 16384) != 0 ? false : z12, (i & 32768) != 0 ? false : z13, (i & 65536) != 0 ? ClassDiscriminatorMode.POLYMORPHIC : classDiscriminatorMode, (i & 131072) != 0 ? true : z14);
    }

    public final boolean getEncodeDefaults() {
        return this.encodeDefaults;
    }

    public final boolean getIgnoreUnknownKeys() {
        return this.ignoreUnknownKeys;
    }

    public final boolean isLenient() {
        return this.isLenient;
    }

    public final boolean getAllowStructuredMapKeys() {
        return this.allowStructuredMapKeys;
    }

    public final boolean getPrettyPrint() {
        return this.prettyPrint;
    }

    public final boolean getExplicitNulls() {
        return this.explicitNulls;
    }

    public final String getPrettyPrintIndent() {
        return this.prettyPrintIndent;
    }

    public final boolean getCoerceInputValues() {
        return this.coerceInputValues;
    }

    public final boolean getUseArrayPolymorphism() {
        return this.useArrayPolymorphism;
    }

    public final String getClassDiscriminator() {
        return this.classDiscriminator;
    }

    public final boolean getAllowSpecialFloatingPointValues() {
        return this.allowSpecialFloatingPointValues;
    }

    public final boolean getUseAlternativeNames() {
        return this.useAlternativeNames;
    }

    public final JsonNamingStrategy getNamingStrategy() {
        return this.namingStrategy;
    }

    public final boolean getDecodeEnumsCaseInsensitive() {
        return this.decodeEnumsCaseInsensitive;
    }

    public final boolean getAllowTrailingComma() {
        return this.allowTrailingComma;
    }

    public final boolean getAllowComments() {
        return this.allowComments;
    }

    public final ClassDiscriminatorMode getClassDiscriminatorMode() {
        return this.classDiscriminatorMode;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "JsonConfiguration is not meant to be mutable, and will be made read-only in a future release. The `Json(from = ...) {}` copy builder should be used instead.")
    public final void setClassDiscriminatorMode(ClassDiscriminatorMode classDiscriminatorMode) {
        Intrinsics.checkNotNullParameter(classDiscriminatorMode, "<set-?>");
        this.classDiscriminatorMode = classDiscriminatorMode;
    }

    public final boolean getExceptionsWithDebugInfo() {
        return this.exceptionsWithDebugInfo;
    }

    public final void setExceptionsWithDebugInfo(boolean z) {
        this.exceptionsWithDebugInfo = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("JsonConfiguration(encodeDefaults=").append(this.encodeDefaults).append(", ignoreUnknownKeys=").append(this.ignoreUnknownKeys).append(", isLenient=").append(this.isLenient).append(", allowStructuredMapKeys=").append(this.allowStructuredMapKeys).append(", prettyPrint=").append(this.prettyPrint).append(", explicitNulls=").append(this.explicitNulls).append(", prettyPrintIndent='").append(this.prettyPrintIndent).append("', coerceInputValues=").append(this.coerceInputValues).append(", useArrayPolymorphism=").append(this.useArrayPolymorphism).append(", classDiscriminator='").append(this.classDiscriminator).append("', allowSpecialFloatingPointValues=").append(this.allowSpecialFloatingPointValues).append(", useAlternativeNames=");
        sb.append(this.useAlternativeNames).append(", namingStrategy=").append(this.namingStrategy).append(", decodeEnumsCaseInsensitive=").append(this.decodeEnumsCaseInsensitive).append(", allowTrailingComma=").append(this.allowTrailingComma).append(", allowComments=").append(this.allowComments).append(", classDiscriminatorMode=").append(this.classDiscriminatorMode).append(", exceptionsWithDebugInfo=").append(this.exceptionsWithDebugInfo).append(')');
        return sb.toString();
    }
}
