package ni.shikatu.kotlin.jvm;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.annotation.AnnotationRetention;
import ni.shikatu.kotlin.annotation.AnnotationTarget;
import ni.shikatu.kotlin.annotation.MustBeDocumented;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Target({ElementType.FIELD})
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0002\bFÊ\u0001\u0012\b\u0003\u0012\u000e\b\u0004\u0012\n\b\fJ\u0006\b\n0\u00058\u0006Ê\u0001\u000e\b\u0007\u0012\n\b\b\u0012\u0006\b\n0\t8\nÊ\u0001\u0002\b\u000b¨\u0006\u0002"}, d2 = {"Lni/shikatu/kotlin/jvm/Volatile;", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/annotation/Target;", "allowedTargets", "Lni/shikatu/kotlin/annotation/AnnotationTarget;", "FIELD", "Lni/shikatu/kotlin/annotation/Retention;", "value", "Lni/shikatu/kotlin/annotation/AnnotationRetention;", "SOURCE", "Lni/shikatu/kotlin/annotation/MustBeDocumented;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@MustBeDocumented
@Retention(RetentionPolicy.SOURCE)
@ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD})
@Documented
@ni.shikatu.kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface Volatile {
}
