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

@Target({ElementType.TYPE, ElementType.FIELD, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\n\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003R\u0013\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0004Ê\u0001J\b\u0006\u0012F\b\u0007\u0012B\b\fJ\u0006\b\n0\b8\tJ\u0006\b\n0\b8\nJ\u0006\b\n0\b8\u000bJ\u0006\b\n0\b8\fJ\u0006\b\n0\b8\rJ\u0006\b\n0\b8\u000eJ\u0006\b\n0\b8\u000fJ\u0006\b\n0\b8\u0010Ê\u0001\u000e\b\u0011\u0012\n\b\u0012\u0012\u0006\b\n0\u00138\u0014Ê\u0001\u0002\b\u0015¨\u0006\u0005"}, d2 = {"Lni/shikatu/kotlin/SinceKotlin;", _UrlKt.FRAGMENT_ENCODE_SET, "version", _UrlKt.FRAGMENT_ENCODE_SET, "()Ljava/lang/String;", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/annotation/Target;", "allowedTargets", "Lni/shikatu/kotlin/annotation/AnnotationTarget;", "CLASS", "PROPERTY", "FIELD", "CONSTRUCTOR", "FUNCTION", "PROPERTY_GETTER", "PROPERTY_SETTER", "TYPEALIAS", "Lni/shikatu/kotlin/annotation/Retention;", "value", "Lni/shikatu/kotlin/annotation/AnnotationRetention;", "BINARY", "Lni/shikatu/kotlin/annotation/MustBeDocumented;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@MustBeDocumented
@Retention(RetentionPolicy.CLASS)
@ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.FIELD, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.TYPEALIAS})
@Documented
@ni.shikatu.kotlin.annotation.Retention(AnnotationRetention.BINARY)
public @interface SinceKotlin {
    String version();
}
