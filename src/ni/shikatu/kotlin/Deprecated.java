package ni.shikatu.kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ni.shikatu.kotlin.annotation.AnnotationTarget;
import ni.shikatu.kotlin.annotation.MustBeDocumented;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR, ElementType.ANNOTATION_TYPE})
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B@\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\"\b\u0002\u0010\u0004\u001a\u00020\u0005B\u0018\b\u000bB\u0014\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0006\b\b\u0012\u0002\b\f\u0012\u0010\b\u0002\u0010\t\u001a\u00020\nB\u0006\b\n0\n8\u000bR\u0013\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0002\u0010\fR\u0013\u0010\u0004\u001a\u00020\u0005X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0004\u0010\rR\u0013\u0010\t\u001a\u00020\nX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\u000eÊ\u0001J\b\u0010\u0012F\b\u0011\u0012B\b\fJ\u0006\b\n0\u00128\u0013J\u0006\b\n0\u00128\u0014J\u0006\b\n0\u00128\u0015J\u0006\b\n0\u00128\u0016J\u0006\b\n0\u00128\u0017J\u0006\b\n0\u00128\u0018J\u0006\b\n0\u00128\u0019J\u0006\b\n0\u00128\u001aÊ\u0001\u0002\b\u001b¨\u0006\u000f"}, d2 = {"Lni/shikatu/kotlin/Deprecated;", _UrlKt.FRAGMENT_ENCODE_SET, "message", _UrlKt.FRAGMENT_ENCODE_SET, "replaceWith", "Lni/shikatu/kotlin/ReplaceWith;", "expression", _UrlKt.FRAGMENT_ENCODE_SET, "imports", "level", "Lni/shikatu/kotlin/DeprecationLevel;", "WARNING", "()Ljava/lang/String;", "()Lkotlin/ReplaceWith;", "()Lkotlin/DeprecationLevel;", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/annotation/Target;", "allowedTargets", "Lni/shikatu/kotlin/annotation/AnnotationTarget;", "CLASS", "FUNCTION", "PROPERTY", "ANNOTATION_CLASS", "CONSTRUCTOR", "PROPERTY_SETTER", "PROPERTY_GETTER", "TYPEALIAS", "Lni/shikatu/kotlin/annotation/MustBeDocumented;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@MustBeDocumented
@ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.ANNOTATION_CLASS, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.TYPEALIAS})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Deprecated {
    DeprecationLevel level() default DeprecationLevel.WARNING;

    String message();

    ReplaceWith replaceWith() default @ReplaceWith(expression = "", imports = {});
}
