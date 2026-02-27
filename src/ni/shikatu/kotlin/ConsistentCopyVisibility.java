package ni.shikatu.kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ni.shikatu.kotlin.annotation.AnnotationRetention;
import ni.shikatu.kotlin.annotation.AnnotationTarget;

@Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lni/shikatu/kotlin/ConsistentCopyVisibility;", "", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.SOURCE)
@ni.shikatu.kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface ConsistentCopyVisibility {
}
