package ni.shikatu.kotlinx.serialization.json;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.annotation.AnnotationTarget;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlinx.serialization.ExperimentalSerializationApi;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Target({})
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0016\bF\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004R\u001b\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/JsonNames;", _UrlKt.FRAGMENT_ENCODE_SET, "names", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "()[Ljava/lang/String;", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
@ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY})
@Retention(RetentionPolicy.RUNTIME)
@ExperimentalSerializationApi
public @interface JsonNames {

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final  class Impl implements JsonNames {
        private final  String[] names;

        public Impl(String[] strArr) {
            Intrinsics.checkNotNullParameter(strArr, "names");
            this.names = strArr;
        }

        @Override
        public final  String[] names() {
            return this.names;
        }

        @Override
        public Class<? extends java.lang.annotation.Annotation> annotationType() {
            return JsonNames.class;
        }
    }

    String[] names();
}
