package ni.shikatu.kotlin.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.RetentionPolicy;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@java.lang.annotation.Target({ElementType.ANNOTATION_TYPE})
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0016\bF\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004R\u001b\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005Ê\u0001\u0012\b\u0000\u0012\u000e\b\u0002\u0012\n\b\fJ\u0006\b\n0\u00048\u0007Ê\u0001\u0002\b\b¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/annotation/Target;", _UrlKt.FRAGMENT_ENCODE_SET, "allowedTargets", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/annotation/AnnotationTarget;", "()[Lkotlin/annotation/AnnotationTarget;", "ni.shikatu.kotlin-stdlib", "ANNOTATION_CLASS", "Lni/shikatu/kotlin/annotation/MustBeDocumented;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@MustBeDocumented
@Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Documented
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
public @interface Target {
    AnnotationTarget[] allowedTargets();
}
