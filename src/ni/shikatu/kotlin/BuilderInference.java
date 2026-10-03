package ni.shikatu.kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ni.shikatu.kotlin.annotation.AnnotationRetention;
import ni.shikatu.kotlin.annotation.AnnotationTarget;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Target({ElementType.METHOD, ElementType.PARAMETER})
@DeprecatedSinceKotlin(errorSince = "2.5", hiddenSince = "2.6", warningSince = "2.0")
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0002\bFÊ\u0001\"\b\u0003\u0012\u001e\b\u0004\u0012\u001a\b\fJ\u0006\b\n0\u00058\u0006J\u0006\b\n0\u00058\u0007J\u0006\b\n0\u00058\bÊ\u0001\u000e\b\t\u0012\n\b\n\u0012\u0006\b\n0\u000b8\fÊ\u0001\f\b\r\u0012\b\b\u000e\u0012\u0004\b\b(\u000fÊ\u0001\u0002\b\u0010Ê\u0001\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0013Ê\u0001 \b\u0014\u0012\b\b\u0015\u0012\u0004\b\b(\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a¨\u0006\u0002"}, d2 = {"Lni/shikatu/kotlin/BuilderInference;", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/annotation/Target;", "allowedTargets", "Lni/shikatu/kotlin/annotation/AnnotationTarget;", "VALUE_PARAMETER", "FUNCTION", "PROPERTY", "Lni/shikatu/kotlin/annotation/Retention;", "value", "Lni/shikatu/kotlin/annotation/AnnotationRetention;", "BINARY", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3", "Lni/shikatu/kotlin/experimental/ExperimentalTypeInference;", "Lni/shikatu/kotlin/Deprecated;", "message", "BuilderInference annotation must not be used anymore. Builder inference is enabled automatically for builder calls if needed.", "Lni/shikatu/kotlin/DeprecatedSinceKotlin;", "warningSince", "2.0", "errorSince", "2.5", "hiddenSince", "2.6"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Retention(RetentionPolicy.CLASS)
@ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.VALUE_PARAMETER, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY})
@Deprecated(message = "BuilderInference annotation must not be used anymore. Builder inference is enabled automatically for builder calls if needed.")
@ni.shikatu.kotlin.annotation.Retention(AnnotationRetention.BINARY)
public @interface BuilderInference {
}
