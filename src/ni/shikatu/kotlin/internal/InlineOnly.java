package ni.shikatu.kotlin.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.annotation.AnnotationRetention;
import ni.shikatu.kotlin.annotation.AnnotationTarget;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Target({ElementType.METHOD})
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0002\bFÊ\u0001*\b\u0003\u0012&\b\u0004\u0012\"\b\fJ\u0006\b\n0\u00058\u0006J\u0006\b\n0\u00058\u0007J\u0006\b\n0\u00058\bJ\u0006\b\n0\u00058\tÊ\u0001\u000e\b\n\u0012\n\b\u000b\u0012\u0006\b\n0\f8\r¨\u0006\u0002"}, d2 = {"Lni/shikatu/kotlin/internal/InlineOnly;", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/annotation/Target;", "allowedTargets", "Lni/shikatu/kotlin/annotation/AnnotationTarget;", "FUNCTION", "PROPERTY", "PROPERTY_GETTER", "PROPERTY_SETTER", "Lni/shikatu/kotlin/annotation/Retention;", "value", "Lni/shikatu/kotlin/annotation/AnnotationRetention;", "BINARY"}, k = 1, mv = {2, 4, 0}, xi = 48)
@ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER})
@Retention(RetentionPolicy.CLASS)
@ni.shikatu.kotlin.annotation.Retention(AnnotationRetention.BINARY)
public @interface InlineOnly {
}
