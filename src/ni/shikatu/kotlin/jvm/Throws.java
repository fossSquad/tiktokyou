package ni.shikatu.kotlin.jvm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.annotation.AnnotationRetention;
import ni.shikatu.kotlin.annotation.AnnotationTarget;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Target({ElementType.METHOD, ElementType.CONSTRUCTOR})
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B&\bF\u0012\"\u0010\u0002\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003\"\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u0004R#\u0010\u0002\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00050\u00040\u0003X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006Ê\u0001*\b\b\u0012&\b\t\u0012\"\b\fJ\u0006\b\n0\n8\u000bJ\u0006\b\n0\n8\fJ\u0006\b\n0\n8\rJ\u0006\b\n0\n8\u000eÊ\u0001\u000e\b\u000f\u0012\n\b\u0010\u0012\u0006\b\n0\u00118\u0012¨\u0006\u0007"}, d2 = {"Lni/shikatu/kotlin/jvm/Throws;", _UrlKt.FRAGMENT_ENCODE_SET, "exceptionClasses", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/reflect/KClass;", _UrlKt.FRAGMENT_ENCODE_SET, "()[Ljava/lang/Class;", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/annotation/Target;", "allowedTargets", "Lni/shikatu/kotlin/annotation/AnnotationTarget;", "FUNCTION", "PROPERTY_GETTER", "PROPERTY_SETTER", "CONSTRUCTOR", "Lni/shikatu/kotlin/annotation/Retention;", "value", "Lni/shikatu/kotlin/annotation/AnnotationRetention;", "SOURCE"}, k = 1, mv = {2, 4, 0}, xi = 48)
@ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.CONSTRUCTOR})
@Retention(RetentionPolicy.SOURCE)
@ni.shikatu.kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface Throws {
    Class<? extends Throwable>[] exceptionClasses();
}
