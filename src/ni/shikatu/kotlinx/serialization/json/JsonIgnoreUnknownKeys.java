package ni.shikatu.kotlinx.serialization.json;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.annotation.AnnotationTarget;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0002\bF¨\u0006\u0002"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonIgnoreUnknownKeys;", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
@ExperimentalSerializationApi
public @interface JsonIgnoreUnknownKeys {

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final  class Impl implements JsonIgnoreUnknownKeys {
        @Override
        public Class<? extends java.lang.annotation.Annotation> annotationType() {
            return JsonIgnoreUnknownKeys.class;
        }
    }
}
