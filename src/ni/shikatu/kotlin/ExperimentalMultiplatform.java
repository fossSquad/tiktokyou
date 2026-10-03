package ni.shikatu.kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ni.shikatu.kotlin.annotation.AnnotationRetention;
import ni.shikatu.kotlin.annotation.AnnotationTarget;
import ni.shikatu.kotlin.annotation.MustBeDocumented;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0002\bFÊ\u0001\u0002\b\u0003Ê\u0001\u0002\b\u0004Ê\u0001b\b\u0005\u0012^\b\u0006\u0012Z\b\fJ\u0006\b\n0\u00078\bJ\u0006\b\n0\u00078\tJ\u0006\b\n0\u00078\nJ\u0006\b\n0\u00078\u000bJ\u0006\b\n0\u00078\fJ\u0006\b\n0\u00078\rJ\u0006\b\n0\u00078\u000eJ\u0006\b\n0\u00078\u000fJ\u0006\b\n0\u00078\u0010J\u0006\b\n0\u00078\u0011J\u0006\b\n0\u00078\u0012Ê\u0001\u000e\b\u0013\u0012\n\b\u0014\u0012\u0006\b\n0\u00158\u0016¨\u0006\u0002"}, d2 = {"Lni/shikatu/kotlin/ExperimentalMultiplatform;", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/RequiresOptIn;", "Lni/shikatu/kotlin/annotation/MustBeDocumented;", "Lni/shikatu/kotlin/annotation/Target;", "allowedTargets", "Lni/shikatu/kotlin/annotation/AnnotationTarget;", "CLASS", "ANNOTATION_CLASS", "PROPERTY", "FIELD", "LOCAL_VARIABLE", "VALUE_PARAMETER", "CONSTRUCTOR", "FUNCTION", "PROPERTY_GETTER", "PROPERTY_SETTER", "TYPEALIAS", "Lni/shikatu/kotlin/annotation/Retention;", "value", "Lni/shikatu/kotlin/annotation/AnnotationRetention;", "BINARY"}, k = 1, mv = {2, 4, 0}, xi = 48)
@MustBeDocumented
@Retention(RetentionPolicy.CLASS)
@ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.LOCAL_VARIABLE, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.TYPEALIAS})
@Documented
@ni.shikatu.kotlin.annotation.Retention(AnnotationRetention.BINARY)
public @interface ExperimentalMultiplatform {
}
