package ni.shikatu.kotlinx.serialization.json;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.kotlinx.serialization.descriptors.SerialDescriptor;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bç\u0080\u0001\u0018\u0000 \t2\u00020\u0001:\u0001\tJ\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H¦\u0080\u0004¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonNamingStrategy;", _UrlKt.FRAGMENT_ENCODE_SET, "serialNameForJson", _UrlKt.FRAGMENT_ENCODE_SET, "descriptor", "Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", "elementIndex", _UrlKt.FRAGMENT_ENCODE_SET, "serialName", "Builtins", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ExperimentalSerializationApi
public interface JsonNamingStrategy {
    public static final Builtins Builtins = Builtins.$$INSTANCE;

    String serialNameForJson(SerialDescriptor serialDescriptor, int i, String str);

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\f\n\u0000\b\u0087\u0003\u0018\u00002\u00020\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0082\u0080\u0004R\u001d\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0084\b¢\u0006\u000e\n\u0000\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001d\u0010\t\u001a\u00020\u00058\u0006X\u0087\u0084\b¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0003\u001a\u0004\b\u000b\u0010\b¨\u0006\u0011"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonNamingStrategy$Builtins;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "SnakeCase", "Lni/shikatu/kotlinx/serialization/json/JsonNamingStrategy;", "getSnakeCase$annotations", "getSnakeCase", "()Lkotlinx/serialization/json/JsonNamingStrategy;", "KebabCase", "getKebabCase$annotations", "getKebabCase", "convertCamelCase", _UrlKt.FRAGMENT_ENCODE_SET, "serialName", "delimiter", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
    @ExperimentalSerializationApi
    public static final class Builtins {
        static final  Builtins $$INSTANCE = new Builtins();
        private static final JsonNamingStrategy SnakeCase = new JsonNamingStrategy() {
            @Override
            public String serialNameForJson(SerialDescriptor descriptor, int elementIndex, String serialName) {
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                Intrinsics.checkNotNullParameter(serialName, "serialName");
                return JsonNamingStrategy.Builtins.$$INSTANCE.convertCamelCase(serialName, '_');
            }

            public String toString() {
                return "ni.shikatu.kotlinx.serialization.json.JsonNamingStrategy.SnakeCase";
            }
        };
        private static final JsonNamingStrategy KebabCase = new JsonNamingStrategy() {
            @Override
            public String serialNameForJson(SerialDescriptor descriptor, int elementIndex, String serialName) {
                Intrinsics.checkNotNullParameter(descriptor, "descriptor");
                Intrinsics.checkNotNullParameter(serialName, "serialName");
                return JsonNamingStrategy.Builtins.$$INSTANCE.convertCamelCase(serialName, '-');
            }

            public String toString() {
                return "ni.shikatu.kotlinx.serialization.json.JsonNamingStrategy.KebabCase";
            }
        };

        @ExperimentalSerializationApi
        public static  void getKebabCase$annotations() {
        }

        @ExperimentalSerializationApi
        public static  void getSnakeCase$annotations() {
        }

        private Builtins() {
        }

        public final JsonNamingStrategy getSnakeCase() {
            return SnakeCase;
        }

        public final JsonNamingStrategy getKebabCase() {
            return KebabCase;
        }

        public final String convertCamelCase(String serialName, char delimiter) {
            StringBuilder $this$convertCamelCase_u24lambda_u240 = new StringBuilder(serialName.length() * 2);
            Character chValueOf = null;
            int previousUpperCharsCount = 0;
            String $this$forEach$iv = serialName;
            for (int i = 0; i < $this$forEach$iv.length(); i++) {
                char element$iv = $this$forEach$iv.charAt(i);
                if (Character.isUpperCase(element$iv)) {
                    if (previousUpperCharsCount == 0) {
                        if (($this$convertCamelCase_u24lambda_u240.length() > 0) && StringsKt.last($this$convertCamelCase_u24lambda_u240) != delimiter) {
                            $this$convertCamelCase_u24lambda_u240.append(delimiter);
                        }
                    }
                    if (chValueOf != null) {
                        char p0 = chValueOf.charValue();
                        $this$convertCamelCase_u24lambda_u240.append(p0);
                    }
                    previousUpperCharsCount++;
                    chValueOf = Character.valueOf(Character.toLowerCase(element$iv));
                } else {
                    if (chValueOf != null) {
                        if (previousUpperCharsCount > 1 && Character.isLetter(element$iv)) {
                            $this$convertCamelCase_u24lambda_u240.append(delimiter);
                        }
                        $this$convertCamelCase_u24lambda_u240.append(chValueOf.charValue());
                        previousUpperCharsCount = 0;
                        chValueOf = null;
                    }
                    $this$convertCamelCase_u24lambda_u240.append(element$iv);
                }
            }
            if (chValueOf != null) {
                $this$convertCamelCase_u24lambda_u240.append(chValueOf.charValue());
            }
            return $this$convertCamelCase_u24lambda_u240.toString();
        }
    }
}
