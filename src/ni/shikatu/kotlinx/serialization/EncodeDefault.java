package ni.shikatu.kotlinx.serialization;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.annotation.AnnotationTarget;
import ni.shikatu.kotlin.annotation.MustBeDocumented;
import ni.shikatu.kotlin.enums.EnumEntries;
import ni.shikatu.kotlin.enums.EnumEntriesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Target({})
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\u0002\u0018\u00002\u00020\u0001:\u0001\u0006B\u0014\bF\u0012\u0010\b\u0002\u0010\u0002\u001a\u00020\u0003B\u0006\b\n0\u00038\u0004R\u0013\u0010\u0002\u001a\u00020\u0003X\u0086\u0084\b¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0007"}, d2 = {"Lni/shikatu/kotlinx/serialization/EncodeDefault;", _UrlKt.FRAGMENT_ENCODE_SET, "mode", "Lni/shikatu/kotlinx/serialization/EncodeDefault$Mode;", "ALWAYS", "()Lkotlinx/serialization/EncodeDefault$Mode;", "Mode", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
@MustBeDocumented
@ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface EncodeDefault {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\bB¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlinx/serialization/EncodeDefault$Mode;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;I)V", "ALWAYS", "NEVER", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
    public enum Mode {
        ALWAYS,
        NEVER;

        private static final  EnumEntries $ENTRIES = EnumEntriesKt.enumEntries($VALUES);

        public static EnumEntries<Mode> getEntries() {
            return $ENTRIES;
        }
    }

    Mode mode() default Mode.ALWAYS;
}
