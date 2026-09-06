package ni.shikatu.kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ni.shikatu.kotlin.annotation.AnnotationRetention;
import ni.shikatu.kotlin.annotation.AnnotationTarget;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE, ElementType.ANNOTATION_TYPE})
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0016\bF\u0012\u0012\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003\"\u00020\u0004R\u001b\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005Ê\u0001\u0082\u0001\b\u0007\u0012~\b\b\u0012z\b\fJ\u0006\b\n0\t8\nJ\u0006\b\n0\t8\u000bJ\u0006\b\n0\t8\fJ\u0006\b\n0\t8\rJ\u0006\b\n0\t8\u000eJ\u0006\b\n0\t8\u000fJ\u0006\b\n0\t8\u0010J\u0006\b\n0\t8\u0011J\u0006\b\n0\t8\u0012J\u0006\b\n0\t8\u0013J\u0006\b\n0\t8\u0014J\u0006\b\n0\t8\u0015J\u0006\b\n0\t8\u0016J\u0006\b\n0\t8\u0017J\u0006\b\n0\t8\u0018Ê\u0001\u000e\b\u0019\u0012\n\b\u001a\u0012\u0006\b\n0\u001b8\u001c¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/Suppress;", _UrlKt.FRAGMENT_ENCODE_SET, "names", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "()[Ljava/lang/String;", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/annotation/Target;", "allowedTargets", "Lni/shikatu/kotlin/annotation/AnnotationTarget;", "CLASS", "ANNOTATION_CLASS", "TYPE_PARAMETER", "PROPERTY", "FIELD", "LOCAL_VARIABLE", "VALUE_PARAMETER", "CONSTRUCTOR", "FUNCTION", "PROPERTY_GETTER", "PROPERTY_SETTER", "TYPE", "EXPRESSION", "FILE", "TYPEALIAS", "Lni/shikatu/kotlin/annotation/Retention;", "value", "Lni/shikatu/kotlin/annotation/AnnotationRetention;", "SOURCE"}, k = 1, mv = {2, 4, 0}, xi = 48)
@ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.TYPE_PARAMETER, AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.LOCAL_VARIABLE, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.TYPE, AnnotationTarget.EXPRESSION, AnnotationTarget.FILE, AnnotationTarget.TYPEALIAS})
@Retention(RetentionPolicy.SOURCE)
@ni.shikatu.kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface Suppress {
    String[] names();
}
