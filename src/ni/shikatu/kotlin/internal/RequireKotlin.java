package ni.shikatu.kotlin.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.annotation.AnnotationRetention;
import ni.shikatu.kotlin.annotation.AnnotationTarget;
import ni.shikatu.kotlin.annotation.Repeatable;
import ni.shikatu.kotlin.jvm.internal.RepeatableContainer;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0081\u0002\u0018\u00002\u00020\u0001BN\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\u00020\u0003B\u0004\b\b(\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\u00020\u0007B\u0006\b\n0\u00078\b\u0012\u0010\b\u0002\u0010\t\u001a\u00020\nB\u0006\b\n0\n8\u000b\u0012\u000e\b\u0002\u0010\f\u001a\u00020\rB\u0004\b\u0003\u0010\u0001R\u0013\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u000eR\u0013\u0010\u0004\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u000eR\u0013\u0010\u0006\u001a\u00020\u0007X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u000fR\u0013\u0010\t\u001a\u00020\nX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\u0010R\u0013\u0010\f\u001a\u00020\rX\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\f\u0010\u0011Ê\u00012\b\u0013\u0012.\b\u0014\u0012*\b\fJ\u0006\b\n0\u00158\u0016J\u0006\b\n0\u00158\u0017J\u0006\b\n0\u00158\u0018J\u0006\b\n0\u00158\u0019J\u0006\b\n0\u00158\u001aÊ\u0001\u000e\b\u001b\u0012\n\b\u001c\u0012\u0006\b\n0\u001d8\u001eÊ\u0001\u0002\b\u001fÊ\u0001\f\b \u0012\b\b\u0002\u0012\u0004\b\b(!¨\u0006\u0012"}, d2 = {"Lni/shikatu/kotlin/internal/RequireKotlin;", _UrlKt.FRAGMENT_ENCODE_SET, "version", _UrlKt.FRAGMENT_ENCODE_SET, "message", _UrlKt.FRAGMENT_ENCODE_SET, "level", "Lni/shikatu/kotlin/DeprecationLevel;", "ERROR", "versionKind", "Lni/shikatu/kotlin/internal/RequireKotlinVersionKind;", "LANGUAGE_VERSION", "errorCode", _UrlKt.FRAGMENT_ENCODE_SET, "()Ljava/lang/String;", "()Lkotlin/DeprecationLevel;", "()Lkotlin/internal/RequireKotlinVersionKind;", "()I", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/annotation/Target;", "allowedTargets", "Lni/shikatu/kotlin/annotation/AnnotationTarget;", "CLASS", "FUNCTION", "PROPERTY", "CONSTRUCTOR", "TYPEALIAS", "Lni/shikatu/kotlin/annotation/Retention;", "value", "Lni/shikatu/kotlin/annotation/AnnotationRetention;", "SOURCE", "Lni/shikatu/kotlin/annotation/Repeatable;", "Lni/shikatu/kotlin/SinceKotlin;", "1.2"}, k = 1, mv = {2, 4, 0}, xi = 48)
@Repeatable
@Retention(RetentionPolicy.SOURCE)
@ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.TYPEALIAS})
@java.lang.annotation.Repeatable(RequireKotlin.Container.class)
@ni.shikatu.kotlin.annotation.Retention(AnnotationRetention.SOURCE)
public @interface RequireKotlin {

    @Target({ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR})
    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    @ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY, AnnotationTarget.CONSTRUCTOR, AnnotationTarget.TYPEALIAS})
    @RepeatableContainer
    @Retention(RetentionPolicy.SOURCE)
    @ni.shikatu.kotlin.annotation.Retention(AnnotationRetention.SOURCE)
    public @interface Container {
        RequireKotlin[] value();
    }

    int errorCode() default -1;

    DeprecationLevel level() default DeprecationLevel.ERROR;

    String message() default "";

    String version();

    RequireKotlinVersionKind versionKind() default RequireKotlinVersionKind.LANGUAGE_VERSION;
}
