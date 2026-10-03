package ni.shikatu.kotlin.jvm.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.annotation.AnnotationRetention;
import ni.shikatu.kotlin.annotation.AnnotationTarget;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0016\bF\u0012\u0012\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003B\u0002\b\fR)\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0007X\u0086\u0084\bz\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0005¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006Ê\u0001\u000e\b\n\u0012\n\b\u000b\u0012\u0006\b\n0\f8\rÊ\u0001\u0012\b\u000e\u0012\u000e\b\u000f\u0012\n\b\fJ\u0006\b\n0\u00108\u0011Ê\u0001\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014¨\u0006\t"}, d2 = {"Lni/shikatu/kotlin/jvm/internal/SerializedIr;", _UrlKt.FRAGMENT_ENCODE_SET, "bytes", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "b", "()[Ljava/lang/String;", "Lni/shikatu/kotlin/jvm/JvmName;", "name", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/annotation/Retention;", "value", "Lni/shikatu/kotlin/annotation/AnnotationRetention;", "BINARY", "Lni/shikatu/kotlin/annotation/Target;", "allowedTargets", "Lni/shikatu/kotlin/annotation/AnnotationTarget;", "CLASS", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.6"}, k = 1, mv = {2, 4, 0}, xi = 48)
@ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.CLASS)
@ni.shikatu.kotlin.annotation.Retention(AnnotationRetention.BINARY)
public @interface SerializedIr {
    String[] b() default {};
}
