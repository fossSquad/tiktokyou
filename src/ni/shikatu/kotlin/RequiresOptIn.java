package ni.shikatu.kotlin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ni.shikatu.kotlin.annotation.AnnotationRetention;
import ni.shikatu.kotlin.annotation.AnnotationTarget;
import ni.shikatu.kotlin.enums.EnumEntries;
import ni.shikatu.kotlin.enums.EnumEntriesKt;

@Target({ElementType.ANNOTATION_TYPE})
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\bB\u0014\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0006R\u000f\u0010\u0004\u001a\u00020\u0005¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0007¨\u0006\t"}, d2 = {"Lni/shikatu/kotlin/RequiresOptIn;", "", "message", "", "level", "Lni/shikatu/kotlin/RequiresOptIn$Level;", "()Ljava/lang/String;", "()Lkotlin/RequiresOptIn$Level;", "Level", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
@ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.ANNOTATION_CLASS})
@Retention(RetentionPolicy.CLASS)
@ni.shikatu.kotlin.annotation.Retention(AnnotationRetention.BINARY)
public @interface RequiresOptIn {
    Level level() default Level.ERROR;

    String message() default "";

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/RequiresOptIn$Level;", "", "<init>", "(Ljava/lang/String;I)V", "WARNING", "ERROR", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public enum Level {
        WARNING,
        ERROR;

        private static final  EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Level> getEntries() {
            return $ENTRIES;
        }
    }
}
