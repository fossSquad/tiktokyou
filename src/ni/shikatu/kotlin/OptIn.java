package ni.shikatu.kotlin;

import java.lang.annotation.Annotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ni.shikatu.kotlin.annotation.AnnotationRetention;
import ni.shikatu.kotlin.annotation.AnnotationTarget;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.PARAMETER, ElementType.CONSTRUCTOR, ElementType.LOCAL_VARIABLE})
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B&\bF\u0012\"\u0010\u0002\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00040\u0003\"\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u0004R#\u0010\u0002\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u00040\u0003X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005Ê\u0001b\b\u0007\u0012^\b\b\u0012Z\b\fJ\u0006\b\n0\t8\nJ\u0006\b\n0\t8\u000bJ\u0006\b\n0\t8\fJ\u0006\b\n0\t8\rJ\u0006\b\n0\t8\u000eJ\u0006\b\n0\t8\u000fJ\u0006\b\n0\t8\u0010J\u0006\b\n0\t8\u0011J\u0006\b\n0\t8\u0012J\u0006\b\n0\t8\u0013J\u0006\b\n0\t8\u0014Ê\u0001\u000e\b\u0015\u0012\n\b\u0016\u0012\u0006\b\n0\u00178\u0018Ê\u0001\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/OptIn;", _UrlKt.FRAGMENT_ENCODE_SET, "markerClass", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/reflect/KClass;", "()[Ljava/lang/Class;", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/annotation/Target;", "allowedTargets", "Lni/shikatu/kotlin/annotation/AnnotationTarget;", "CLASS", "PROPERTY", "LOCAL_VARIABLE", "VALUE_PARAMETER", "CONSTRUCTOR", "FUNCTION", "PROPERTY_GETTER", "PROPERTY_SETTER", "EXPRESSION", "FILE", "TYPEALIAS", "Lni/shikatu/kotlin/annotation/Retention;", "value", "Lni/shikatu/kotlin/annotation/AnnotationRetention;", "SOURCE", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3"}, k = 1, mv = {2, 4, 0}, xi = 48)
@ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.LOCAL_VARIABLE, AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.EXPRESSION, AnnotationTarget.FILE, AnnotationTarget.TYPEALIAS})
@Retention(RetentionPolicy.SOURCE)
@ni.shikatu.kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface OptIn {
    Class<? extends Annotation>[] markerClass();
}
