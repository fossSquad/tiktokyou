package ni.shikatu.kotlin.text;

import java.io.IOException;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000P\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aK\u0010\u0000\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0087\u0080\bb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\r¢\u0006\u0002\u0010\t\u001a=\u0010\u000e\u001a\u0002H\u0001\"\f\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u0003*\u0002H\u00012\u0016\u0010\u0004\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00050\u000f\"\u0004\u0018\u00010\u0005H\u0087\u0080\bb\u0002\b\r¢\u0006\u0002\u0010\u0010\u001a1\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u0003H\u0087\u0088\bb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0013b\u0002\b\r¢\u0006\u0002\u0010\u0012\u001a;\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0087\u0088\bb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0013b\u0002\b\r¢\u0006\u0002\u0010\u0014\u001a9\u0010\u0011\u001a\u00060\u0002j\u0002`\u0003*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0004\u001a\u00020\u0015H\u0087\u0088\bb\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\fb\u0002\b\u0013b\u0002\b\r¢\u0006\u0002\u0010\u0016\u001a;\u0010\u0017\u001a\u00020\u0018\"\u0004\b\u0000\u0010\u0001*\u00060\u0002j\u0002`\u00032\u0006\u0010\u0019\u001a\u0002H\u00012\u0014\u0010\u001a\u001a\u0010\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u001bH\u0080\u0080\u0004¢\u0006\u0002\u0010\u001c¨\u0006\u001d"}, d2 = {"appendRange", "T", "Ljava/lang/Appendable;", "Lni/shikatu/kotlin/text/Appendable;", "value", _UrlKt.FRAGMENT_ENCODE_SET, "startIndex", _UrlKt.FRAGMENT_ENCODE_SET, "endIndex", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;II)Ljava/lang/Appendable;", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.4", "Lni/shikatu/kotlin/IgnorableReturnValue;", "append", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/Appendable;[Ljava/lang/CharSequence;)Ljava/lang/Appendable;", "appendLine", "(Ljava/lang/Appendable;)Ljava/lang/Appendable;", "Lni/shikatu/kotlin/internal/InlineOnly;", "(Ljava/lang/Appendable;Ljava/lang/CharSequence;)Ljava/lang/Appendable;", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/Appendable;C)Ljava/lang/Appendable;", "appendElement", _UrlKt.FRAGMENT_ENCODE_SET, "element", "transform", "Lni/shikatu/kotlin/Function1;", "(Ljava/lang/Appendable;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)V", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/text/StringsKt")
public class StringsKt__AppendableKt {
    @IgnorableReturnValue
    public static final <T extends Appendable> T appendRange(T t, CharSequence charSequence, int i, int i2) {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(charSequence, "value");
        T t2 = (T) t.append(charSequence, i, i2);
        Intrinsics.checkNotNull(t2, "null cannot be cast to non-null type T of kotlin.text.StringsKt__AppendableKt.appendRange");
        return t2;
    }

    @IgnorableReturnValue
    public static final <T extends Appendable> T append(T t, CharSequence... value) throws IOException {
        Intrinsics.checkNotNullParameter(t, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        for (CharSequence item : value) {
            t.append(item);
        }
        return t;
    }

    @IgnorableReturnValue
    private static final Appendable appendLine(Appendable $this$appendLine) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        return $this$appendLine.append('\n');
    }

    @IgnorableReturnValue
    private static final Appendable appendLine(Appendable $this$appendLine, CharSequence value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        return $this$appendLine.append(value).append('\n');
    }

    @IgnorableReturnValue
    private static final Appendable appendLine(Appendable $this$appendLine, char value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        return $this$appendLine.append(value).append('\n');
    }

    public static final <T> void appendElement(Appendable $this$appendElement, T t, Function1<? super T, ? extends CharSequence> function1) throws IOException {
        Intrinsics.checkNotNullParameter($this$appendElement, "<this>");
        if (function1 == null) {
            if (!(t == 0 ? true : t instanceof CharSequence)) {
                if (!(t instanceof Character)) {
                    $this$appendElement.append(t.toString());
                    return;
                } else {
                    $this$appendElement.append(((Character) t).charValue());
                    return;
                }
            }
            $this$appendElement.append((CharSequence) t);
            return;
        }
        $this$appendElement.append(function1.invoke(t));
    }
}
