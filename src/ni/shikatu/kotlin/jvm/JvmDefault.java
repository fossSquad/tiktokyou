package ni.shikatu.kotlin.jvm;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.annotation.AnnotationTarget;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Target({ElementType.METHOD})
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0002\bFÊ\u0001\f\b\u0003\u0012\b\b\u0004\u0012\u0004\b\b(\u0005Ê\u0001\u001a\b\u0006\u0012\u0016\b\u0007\u0012\u0012\b\fJ\u0006\b\n0\b8\tJ\u0006\b\n0\b8\nÊ\u0001\u0018\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\n\b\u000e\u0012\u0006\b\n0\u000f8\u0010¨\u0006\u0002"}, d2 = {"Lni/shikatu/kotlin/jvm/JvmDefault;", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.2", "Lni/shikatu/kotlin/annotation/Target;", "allowedTargets", "Lni/shikatu/kotlin/annotation/AnnotationTarget;", "FUNCTION", "PROPERTY", "Lni/shikatu/kotlin/Deprecated;", "message", "Switch to new -jvm-default modes: `enable` or `no-compatibility`", "level", "Lni/shikatu/kotlin/DeprecationLevel;", "HIDDEN"}, k = 1, mv = {2, 4, 0}, xi = 48)
@ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY})
@Deprecated(level = DeprecationLevel.HIDDEN, message = "Switch to new -jvm-default modes: `enable` or `no-compatibility`")
@Retention(RetentionPolicy.RUNTIME)
public @interface JvmDefault {
}
