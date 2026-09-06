package ni.shikatu.kotlinx.serialization;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.annotation.AnnotationTarget;
import ni.shikatu.kotlin.annotation.MustBeDocumented;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\n\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u0013\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"Lni/shikatu/kotlinx/serialization/SerialName;", _UrlKt.FRAGMENT_ENCODE_SET, "value", _UrlKt.FRAGMENT_ENCODE_SET, "()Ljava/lang/String;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@MustBeDocumented
@ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY, AnnotationTarget.CLASS})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface SerialName {
    String value();
}
