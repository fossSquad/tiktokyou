package ni.shikatu.kotlin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ni.shikatu.kotlin.annotation.AnnotationRetention;
import ni.shikatu.kotlin.annotation.AnnotationTarget;
import ni.shikatu.kotlin.annotation.MustBeDocumented;
import ni.shikatu.kotlin.enums.EnumEntries;
import ni.shikatu.kotlin.enums.EnumEntriesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Target({ElementType.ANNOTATION_TYPE})
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\nB$\bF\u0012\u000e\b\u0002\u0010\u0002\u001a\u00020\u0003B\u0004\b\b(\u0004\u0012\u0010\b\u0002\u0010\u0005\u001a\u00020\u0006B\u0006\b\n0\u00068\u0007R\u0013\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0002\u0010\bR\u0013\u0010\u0005\u001a\u00020\u0006X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0005\u0010\tÊ\u0001\u0012\b\f\u0012\u000e\b\r\u0012\n\b\fJ\u0006\b\n0\u000e8\u000fÊ\u0001\u000e\b\u0010\u0012\n\b\u0011\u0012\u0006\b\n0\u00128\u0013Ê\u0001\u0002\b\u0014Ê\u0001\f\b\u0015\u0012\b\b\u0016\u0012\u0004\b\b(\u0017¨\u0006\u000b"}, d2 = {"Lni/shikatu/kotlin/RequiresOptIn;", _UrlKt.FRAGMENT_ENCODE_SET, "message", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "level", "Lni/shikatu/kotlin/RequiresOptIn$Level;", "ERROR", "()Ljava/lang/String;", "()Lkotlin/RequiresOptIn$Level;", "Level", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/annotation/Target;", "allowedTargets", "Lni/shikatu/kotlin/annotation/AnnotationTarget;", "ANNOTATION_CLASS", "Lni/shikatu/kotlin/annotation/Retention;", "value", "Lni/shikatu/kotlin/annotation/AnnotationRetention;", "BINARY", "Lni/shikatu/kotlin/annotation/MustBeDocumented;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.3"}, k = 1, mv = {2, 4, 0}, xi = 48)
@MustBeDocumented
@Retention(RetentionPolicy.CLASS)
@ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Documented
@ni.shikatu.kotlin.annotation.Retention(AnnotationRetention.BINARY)
public @interface RequiresOptIn {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/RequiresOptIn$Level;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
    public enum Level {
        WARNING,
        ERROR;

        private static final  EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Level> getEntries() {
            return $ENTRIES;
        }
    }

    Level level() default Level.ERROR;

    String message() default "";
}
