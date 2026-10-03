package ni.shikatu.kotlin.coroutines.jvm.internal;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.annotation.AnnotationTarget;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Target({ElementType.TYPE})
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\b\u0081\u0002\u0018\u00002\u00020\u0001B\u0094\u0001\bF\u0012\u000e\b\u0002\u0010\u0002\u001a\u00020\u0003B\u0004\b\u0003\u0010\u0004\u0012\u000e\b\u0002\u0010\u0004\u001a\u00020\u0005B\u0004\b\b(\u0006\u0012\f\b\u0002\u0010\u0007\u001a\u00020\bB\u0002\b\f\u0012\u0012\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nB\u0002\b\f\u0012\u0012\b\u0002\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\nB\u0002\b\f\u0012\f\b\u0002\u0010\f\u001a\u00020\bB\u0002\b\f\u0012\u000e\b\u0002\u0010\r\u001a\u00020\u0005B\u0004\b\b(\u0006\u0012\u000e\b\u0002\u0010\u000e\u001a\u00020\u0005B\u0004\b\b(\u0006\u0012\f\b\u0002\u0010\u000f\u001a\u00020\bB\u0002\b\fR#\u0010\u0002\u001a\u00020\u00038\u0007X\u0086\u0084\bz\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0010¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R#\u0010\u0004\u001a\u00020\u00058\u0007X\u0086\u0084\bz\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R#\u0010\u0007\u001a\u00020\b8\u0007X\u0086\u0084\bz\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R)\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0007X\u0086\u0084\bz\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0018¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R)\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\n8\u0007X\u0086\u0084\bz\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001a¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0019R#\u0010\f\u001a\u00020\b8\u0007X\u0086\u0084\bz\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001b¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0017R#\u0010\r\u001a\u00020\u00058\u0007X\u0086\u0084\bz\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001c¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0015R#\u0010\u000e\u001a\u00020\u00058\u0007X\u0086\u0084\bz\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u001d¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0015R5\u0010\u000f\u001a\u00020\bX\u0087\u0084\br\f\b!\u0012\b\b\u0002\u0012\u0004\b\b(\"z\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b( ¢\u0006\f\u0012\u0004\b\u001e\u0010\u001f\u001a\u0004\b \u0010\u0017Ê\u0001\u0012\b$\u0012\u000e\b%\u0012\n\b\fJ\u0006\b\n0&8'Ê\u0001\f\b!\u0012\b\b\u0002\u0012\u0004\b\b((Ê\u0001\u0002\b)¨\u0006#"}, d2 = {"Lni/shikatu/kotlin/coroutines/jvm/internal/DebugMetadata;", _UrlKt.FRAGMENT_ENCODE_SET, "version", _UrlKt.FRAGMENT_ENCODE_SET, "sourceFile", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "lineNumbers", _UrlKt.FRAGMENT_ENCODE_SET, "localNames", _UrlKt.FRAGMENT_ENCODE_SET, "spilled", "indexToLabel", "methodName", "className", "nextLineNumbers", "v", "()I", "Lni/shikatu/kotlin/jvm/JvmName;", "name", "f", "()Ljava/lang/String;", "l", "()[I", "n", "()[Ljava/lang/String;", "s", "i", "m", "c", "nl$annotations", "()V", "nl", "Lni/shikatu/kotlin/SinceKotlin;", "2.2", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/annotation/Target;", "allowedTargets", "Lni/shikatu/kotlin/annotation/AnnotationTarget;", "CLASS", "1.3", "Lni/shikatu/kotlin/PublishedApi;"}, k = 1, mv = {2, 4, 0}, xi = 48)
@ni.shikatu.kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
public @interface DebugMetadata {

    @Metadata(k = 3, mv = {2, 4, 0}, xi = 48)
    public static final class DefaultImpls {
        public static  void nl$annotations() {
        }
    }

    String c() default "";

    String f() default "";

    int[] i() default {};

    int[] l() default {};

    String m() default "";

    String[] n() default {};

    int[] nl() default {};

    String[] s() default {};

    int v() default 2;
}
