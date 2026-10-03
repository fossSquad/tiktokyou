package ni.shikatu.kotlin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@java.lang.annotation.Target({ElementType.ANNOTATION_TYPE})
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0014\bF\u0012\u0010\b\u0002\u0010\u0002\u001a\u00020\u0003B\u0006\b\n0\u00038\u0004R\u0013\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005Ê\u0001\u0012\b\u0007\u0012\u000e\b\b\u0012\n\b\fJ\u0006\b\n0\t8\n¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/annotation/Retention;", _UrlKt.FRAGMENT_ENCODE_SET, "value", "Lni/shikatu/kotlin/annotation/AnnotationRetention;", "RUNTIME", "()Lkotlin/annotation/AnnotationRetention;", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/annotation/Target;", "allowedTargets", "Lni/shikatu/kotlin/annotation/AnnotationTarget;", "ANNOTATION_CLASS"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
public @interface Retention {
    AnnotationRetention value() default AnnotationRetention.RUNTIME;
}
