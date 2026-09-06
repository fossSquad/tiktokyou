package ni.shikatu.kotlinx.serialization.json;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.modules.SerializersModule;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0011\b@\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010Q\u001a\u00020RH\u0080\u0080\u0004¢\u0006\u0002\bSR\u001b\u0010\u0006\u001a\u00020\u0007X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001b\u0010\f\u001a\u00020\u0007X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\t\"\u0004\b\u000e\u0010\u000bR\u001b\u0010\u000f\u001a\u00020\u0007X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\t\"\u0004\b\u0011\u0010\u000bR\u001b\u0010\u0012\u001a\u00020\u0007X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\t\"\u0004\b\u0013\u0010\u000bR\u001b\u0010\u0014\u001a\u00020\u0007X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\t\"\u0004\b\u0016\u0010\u000bR\u001b\u0010\u0017\u001a\u00020\u0018X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001b\u0010\u001d\u001a\u00020\u0007X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\t\"\u0004\b\u001f\u0010\u000bR\u001b\u0010 \u001a\u00020\u0018X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001a\"\u0004\b\"\u0010\u001cR%\u0010#\u001a\u00020$8\u0006@\u0006X\u0087\u008e\b¢\u0006\u0014\n\u0000\u0012\u0004\b%\u0010&\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001b\u0010+\u001a\u00020\u0007X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\t\"\u0004\b-\u0010\u000bR'\u0010.\u001a\u0004\u0018\u00010/8\u0006@\u0006X\u0087\u008e\b¢\u0006\u0014\n\u0000\u0012\u0004\b0\u0010&\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\u001b\u00105\u001a\u00020\u0007X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b6\u0010\t\"\u0004\b7\u0010\u000bR\u001b\u00108\u001a\u00020\u0007X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\t\"\u0004\b:\u0010\u000bR\u001b\u0010;\u001a\u00020\u0007X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b<\u0010\t\"\u0004\b=\u0010\u000bR\u001b\u0010>\u001a\u00020\u0007X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010\t\"\u0004\b@\u0010\u000bR\u001b\u0010A\u001a\u00020\u0007X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\bB\u0010\t\"\u0004\bC\u0010\u000bR\u001b\u0010D\u001a\u00020\u0007X\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\bE\u0010\t\"\u0004\bF\u0010\u000bR\u001b\u0010G\u001a\u00020HX\u0086\u008e\b¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010J\"\u0004\bK\u0010LR%\u0010M\u001a\u00020\u00078\u0006@\u0006X\u0087\u008e\b¢\u0006\u0014\n\u0000\u0012\u0004\bN\u0010&\u001a\u0004\bO\u0010\t\"\u0004\bP\u0010\u000b¨\u0006T"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonBuilder;", _UrlKt.FRAGMENT_ENCODE_SET, "json", "Lni/shikatu/kotlinx/serialization/json/Json;", "<init>", "(Lkotlinx/serialization/json/Json;)V", "encodeDefaults", _UrlKt.FRAGMENT_ENCODE_SET, "getEncodeDefaults", "()Z", "setEncodeDefaults", "(Z)V", "explicitNulls", "getExplicitNulls", "setExplicitNulls", "ignoreUnknownKeys", "getIgnoreUnknownKeys", "setIgnoreUnknownKeys", "isLenient", "setLenient", "prettyPrint", "getPrettyPrint", "setPrettyPrint", "prettyPrintIndent", _UrlKt.FRAGMENT_ENCODE_SET, "getPrettyPrintIndent", "()Ljava/lang/String;", "setPrettyPrintIndent", "(Ljava/lang/String;)V", "coerceInputValues", "getCoerceInputValues", "setCoerceInputValues", "classDiscriminator", "getClassDiscriminator", "setClassDiscriminator", "classDiscriminatorMode", "Lni/shikatu/kotlinx/serialization/json/ClassDiscriminatorMode;", "getClassDiscriminatorMode$annotations", "()V", "getClassDiscriminatorMode", "()Lkotlinx/serialization/json/ClassDiscriminatorMode;", "setClassDiscriminatorMode", "(Lkotlinx/serialization/json/ClassDiscriminatorMode;)V", "useAlternativeNames", "getUseAlternativeNames", "setUseAlternativeNames", "namingStrategy", "Lni/shikatu/kotlinx/serialization/json/JsonNamingStrategy;", "getNamingStrategy$annotations", "getNamingStrategy", "()Lkotlinx/serialization/json/JsonNamingStrategy;", "setNamingStrategy", "(Lkotlinx/serialization/json/JsonNamingStrategy;)V", "decodeEnumsCaseInsensitive", "getDecodeEnumsCaseInsensitive", "setDecodeEnumsCaseInsensitive", "allowTrailingComma", "getAllowTrailingComma", "setAllowTrailingComma", "allowComments", "getAllowComments", "setAllowComments", "allowSpecialFloatingPointValues", "getAllowSpecialFloatingPointValues", "setAllowSpecialFloatingPointValues", "allowStructuredMapKeys", "getAllowStructuredMapKeys", "setAllowStructuredMapKeys", "useArrayPolymorphism", "getUseArrayPolymorphism", "setUseArrayPolymorphism", "serializersModule", "Lni/shikatu/kotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "setSerializersModule", "(Lkotlinx/serialization/modules/SerializersModule;)V", "exceptionsWithDebugInfo", "getExceptionsWithDebugInfo$annotations", "getExceptionsWithDebugInfo", "setExceptionsWithDebugInfo", "build", "Lni/shikatu/kotlinx/serialization/json/JsonConfiguration;", "build$kotlinx_serialization_json", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JsonBuilder {
    private boolean allowComments;
    private boolean allowSpecialFloatingPointValues;
    private boolean allowStructuredMapKeys;
    private boolean allowTrailingComma;
    private String classDiscriminator;
    private ClassDiscriminatorMode classDiscriminatorMode;
    private boolean coerceInputValues;
    private boolean decodeEnumsCaseInsensitive;
    private boolean encodeDefaults;
    private boolean exceptionsWithDebugInfo;
    private boolean explicitNulls;
    private boolean ignoreUnknownKeys;
    private boolean isLenient;
    private JsonNamingStrategy namingStrategy;
    private boolean prettyPrint;
    private String prettyPrintIndent;
    private SerializersModule serializersModule;
    private boolean useAlternativeNames;
    private boolean useArrayPolymorphism;

    @ExperimentalSerializationApi
    public static  void getClassDiscriminatorMode$annotations() {
    }

    @ExperimentalSerializationApi
    public static  void getExceptionsWithDebugInfo$annotations() {
    }

    @ExperimentalSerializationApi
    public static  void getNamingStrategy$annotations() {
    }

    public JsonBuilder(Json json) {
        Intrinsics.checkNotNullParameter(json, "json");
        this.encodeDefaults = json.getConfiguration().getEncodeDefaults();
        this.explicitNulls = json.getConfiguration().getExplicitNulls();
        this.ignoreUnknownKeys = json.getConfiguration().getIgnoreUnknownKeys();
        this.isLenient = json.getConfiguration().isLenient();
        this.prettyPrint = json.getConfiguration().getPrettyPrint();
        this.prettyPrintIndent = json.getConfiguration().getPrettyPrintIndent();
        this.coerceInputValues = json.getConfiguration().getCoerceInputValues();
        this.classDiscriminator = json.getConfiguration().getClassDiscriminator();
        this.classDiscriminatorMode = json.getConfiguration().getClassDiscriminatorMode();
        this.useAlternativeNames = json.getConfiguration().getUseAlternativeNames();
        this.namingStrategy = json.getConfiguration().getNamingStrategy();
        this.decodeEnumsCaseInsensitive = json.getConfiguration().getDecodeEnumsCaseInsensitive();
        this.allowTrailingComma = json.getConfiguration().getAllowTrailingComma();
        this.allowComments = json.getConfiguration().getAllowComments();
        this.allowSpecialFloatingPointValues = json.getConfiguration().getAllowSpecialFloatingPointValues();
        this.allowStructuredMapKeys = json.getConfiguration().getAllowStructuredMapKeys();
        this.useArrayPolymorphism = json.getConfiguration().getUseArrayPolymorphism();
        this.serializersModule = json.getSerializersModule();
        this.exceptionsWithDebugInfo = json.getConfiguration().getExceptionsWithDebugInfo();
    }

    public final boolean getEncodeDefaults() {
        return this.encodeDefaults;
    }

    public final void setEncodeDefaults(boolean z) {
        this.encodeDefaults = z;
    }

    public final boolean getExplicitNulls() {
        return this.explicitNulls;
    }

    public final void setExplicitNulls(boolean z) {
        this.explicitNulls = z;
    }

    public final boolean getIgnoreUnknownKeys() {
        return this.ignoreUnknownKeys;
    }

    public final void setIgnoreUnknownKeys(boolean z) {
        this.ignoreUnknownKeys = z;
    }

    public final boolean isLenient() {
        return this.isLenient;
    }

    public final void setLenient(boolean z) {
        this.isLenient = z;
    }

    public final boolean getPrettyPrint() {
        return this.prettyPrint;
    }

    public final void setPrettyPrint(boolean z) {
        this.prettyPrint = z;
    }

    public final String getPrettyPrintIndent() {
        return this.prettyPrintIndent;
    }

    public final void setPrettyPrintIndent(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.prettyPrintIndent = str;
    }

    public final boolean getCoerceInputValues() {
        return this.coerceInputValues;
    }

    public final void setCoerceInputValues(boolean z) {
        this.coerceInputValues = z;
    }

    public final String getClassDiscriminator() {
        return this.classDiscriminator;
    }

    public final void setClassDiscriminator(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.classDiscriminator = str;
    }

    public final ClassDiscriminatorMode getClassDiscriminatorMode() {
        return this.classDiscriminatorMode;
    }

    public final void setClassDiscriminatorMode(ClassDiscriminatorMode classDiscriminatorMode) {
        Intrinsics.checkNotNullParameter(classDiscriminatorMode, "<set-?>");
        this.classDiscriminatorMode = classDiscriminatorMode;
    }

    public final boolean getUseAlternativeNames() {
        return this.useAlternativeNames;
    }

    public final void setUseAlternativeNames(boolean z) {
        this.useAlternativeNames = z;
    }

    public final JsonNamingStrategy getNamingStrategy() {
        return this.namingStrategy;
    }

    public final void setNamingStrategy(JsonNamingStrategy jsonNamingStrategy) {
        this.namingStrategy = jsonNamingStrategy;
    }

    public final boolean getDecodeEnumsCaseInsensitive() {
        return this.decodeEnumsCaseInsensitive;
    }

    public final void setDecodeEnumsCaseInsensitive(boolean z) {
        this.decodeEnumsCaseInsensitive = z;
    }

    public final boolean getAllowTrailingComma() {
        return this.allowTrailingComma;
    }

    public final void setAllowTrailingComma(boolean z) {
        this.allowTrailingComma = z;
    }

    public final boolean getAllowComments() {
        return this.allowComments;
    }

    public final void setAllowComments(boolean z) {
        this.allowComments = z;
    }

    public final boolean getAllowSpecialFloatingPointValues() {
        return this.allowSpecialFloatingPointValues;
    }

    public final void setAllowSpecialFloatingPointValues(boolean z) {
        this.allowSpecialFloatingPointValues = z;
    }

    public final boolean getAllowStructuredMapKeys() {
        return this.allowStructuredMapKeys;
    }

    public final void setAllowStructuredMapKeys(boolean z) {
        this.allowStructuredMapKeys = z;
    }

    public final boolean getUseArrayPolymorphism() {
        return this.useArrayPolymorphism;
    }

    public final void setUseArrayPolymorphism(boolean z) {
        this.useArrayPolymorphism = z;
    }

    public final SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    public final void setSerializersModule(SerializersModule serializersModule) {
        Intrinsics.checkNotNullParameter(serializersModule, "<set-?>");
        this.serializersModule = serializersModule;
    }

    public final boolean getExceptionsWithDebugInfo() {
        return this.exceptionsWithDebugInfo;
    }

    public final void setExceptionsWithDebugInfo(boolean z) {
        this.exceptionsWithDebugInfo = z;
    }

    public final JsonConfiguration build$kotlinx_serialization_json() {
        boolean allWhitespaces = true;
        if (this.useArrayPolymorphism) {
            if (!Intrinsics.areEqual(this.classDiscriminator, "type")) {
                throw new IllegalArgumentException("Class discriminator should not be specified when array polymorphism is specified".toString());
            }
            if (!(this.classDiscriminatorMode == ClassDiscriminatorMode.POLYMORPHIC)) {
                throw new IllegalArgumentException("useArrayPolymorphism option can only be used if classDiscriminatorMode in a default POLYMORPHIC state.".toString());
            }
        }
        if (!this.prettyPrint) {
            if (!Intrinsics.areEqual(this.prettyPrintIndent, "    ")) {
                throw new IllegalArgumentException("Indent should not be specified when default printing mode is used".toString());
            }
        } else if (!Intrinsics.areEqual(this.prettyPrintIndent, "    ")) {
            CharSequence $this$all$iv = this.prettyPrintIndent;
            for (int i = 0; i < $this$all$iv.length(); i++) {
                char element$iv = $this$all$iv.charAt(i);
                char it = (element$iv == ' ' || element$iv == '\t' || element$iv == '\r' || element$iv == '\n') ? (char) 1 : (char) 0;
                if (it == 0) {
                    allWhitespaces = false;
                    break;
                }
            }
            if (!allWhitespaces) {
                throw new IllegalArgumentException(("Only whitespace, tab, newline and carriage return are allowed as pretty print symbols. Had " + this.prettyPrintIndent).toString());
            }
        }
        return new JsonConfiguration(this.encodeDefaults, this.ignoreUnknownKeys, this.isLenient, this.allowStructuredMapKeys, this.prettyPrint, this.explicitNulls, this.prettyPrintIndent, this.coerceInputValues, this.useArrayPolymorphism, this.classDiscriminator, this.allowSpecialFloatingPointValues, this.useAlternativeNames, this.namingStrategy, this.decodeEnumsCaseInsensitive, this.allowTrailingComma, this.allowComments, this.classDiscriminatorMode, this.exceptionsWithDebugInfo);
    }
}
