package ni.shikatu.kotlinx.serialization.json;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.annotation.AnnotationTarget;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\n\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u0013\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonClassDiscriminator;", _UrlKt.FRAGMENT_ENCODE_SET, "discriminator", _UrlKt.FRAGMENT_ENCODE_SET, "()Ljava/lang/String;", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
@ExperimentalSerializationApi
public @interface JsonClassDiscriminator {

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final  class Impl implements JsonClassDiscriminator {
        private final  String discriminator;

        public Impl(String str) {
            Intrinsics.checkNotNullParameter(str, "discriminator");
            this.discriminator = str;
        }

        @Override
        public final  String discriminator() {
            return this.discriminator;
        }

        @Override
        public Class<? extends java.lang.annotation.Annotation> annotationType() {
            return JsonClassDiscriminator.class;
        }
    }

    String discriminator();
}
