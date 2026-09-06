package ni.shikatu.kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ni.shikatu.kotlin.annotation.AnnotationTarget;
import ni.shikatu.kotlin.annotation.MustBeDocumented;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Target({ElementType.PARAMETER})
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\n\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u0013\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004Ê\u0001\u0012\b\u0006\u0012\u000e\b\u0007\u0012\n\b\fJ\u0006\b\n0\b8\tÊ\u0001\u0002\b\nÊ\u0001\f\b\u000b\u0012\b\b\u0002\u0012\u0004\b\b(\fÊ\u0001\u0002\b\r¨\u0006\u0005"}, d2 = {"Lni/shikatu/kotlin/IntroducedAt;", _UrlKt.FRAGMENT_ENCODE_SET, "version", _UrlKt.FRAGMENT_ENCODE_SET, "()Ljava/lang/String;", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/annotation/Target;", "allowedTargets", "Lni/shikatu/kotlin/annotation/AnnotationTarget;", "VALUE_PARAMETER", "Lni/shikatu/kotlin/annotation/MustBeDocumented;", "Lni/shikatu/kotlin/SinceKotlin;", "2.3", "Lni/shikatu/kotlin/ExperimentalVersionOverloading;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@MustBeDocumented
@ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface IntroducedAt {
    String version();
}
