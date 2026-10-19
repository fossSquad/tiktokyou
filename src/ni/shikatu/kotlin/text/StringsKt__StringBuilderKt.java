package ni.shikatu.kotlin.text;

import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.NotImplementedError;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0002\b\t\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u001ae\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0087\u0088\bb6\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u001c\b\t\u0012\u0018\b\u000bB\u0014\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0006\b\r\u0012\u0002\b\f\u0012\n\b\u000e\u0012\u0006\b\n0\u000f8\u0010b\u0002\b\u0011b\u0002\b\u0012¢\u0006\u0002\u0010\u0005\u001a;\u0010\u0013\u001a\u00020\u00142\u001b\u0010\u0015\u001a\u0017\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b\u0018H\u0087\u0088\u0004b\u0002\b\u0011ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0001 \u0001\u001aQ\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a2\u001b\u0010\u0015\u001a\u0017\u0012\b\u0012\u00060\u0001j\u0002`\u0002\u0012\u0004\u0012\u00020\u00170\u0016¢\u0006\u0002\b\u0018H\u0087\u0088\u0004b\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(\u001db\u0002\b\u0011ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001\u001a7\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0016\u0010\u001e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00140\u001f\"\u0004\u0018\u00010\u0014H\u0087\u0080\bb\u0002\b\u0012¢\u0006\u0002\u0010 \u001a7\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0016\u0010\u001e\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u001f\"\u0004\u0018\u00010\u0004H\u0087\u0080\bb\u0002\b\u0012¢\u0006\u0002\u0010!\u001as\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u001a2\u0006\u0010%\u001a\u00020\u001aH\u0087\u0088\bb6\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b('\u0012\u001c\b\t\u0012\u0018\b\u000bB\u0014\b\n\u0012\b\b\u000b\u0012\u0004\b\b((\u0012\u0006\b\r\u0012\u0002\b\f\u0012\n\b\u000e\u0012\u0006\b\n0\u000f8)b\u0002\b\u0011b\u0002\b\u0012¢\u0006\u0002\u0010&\u001a1\u0010*\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0087\u0088\bb\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(,b\u0002\b\u0011b\u0002\b\u0012¢\u0006\u0002\u0010+\u001a;\u0010*\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010-H\u0087\u0088\bb\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(,b\u0002\b\u0011b\u0002\b\u0012¢\u0006\u0002\u0010.\u001a;\u0010*\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u0014H\u0087\u0088\bb\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(,b\u0002\b\u0011b\u0002\b\u0012¢\u0006\u0002\u0010/\u001a;\u0010*\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u001e\u001a\u0004\u0018\u00010\u0004H\u0087\u0088\bb\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(,b\u0002\b\u0011b\u0002\b\u0012¢\u0006\u0002\u0010\u0005\u001a9\u0010*\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u001e\u001a\u00020#H\u0087\u0088\bb\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(,b\u0002\b\u0011b\u0002\b\u0012¢\u0006\u0002\u00100\u001a9\u0010*\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u001e\u001a\u000201H\u0087\u0088\bb\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(,b\u0002\b\u0011b\u0002\b\u0012¢\u0006\u0002\u00102\u001a9\u0010*\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u001e\u001a\u000203H\u0087\u0088\bb\f\b\u001b\u0012\b\b\u001c\u0012\u0004\b\b(,b\u0002\b\u0011b\u0002\b\u0012¢\u0006\u0002\u00104\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00065"}, d2 = {"append", "Ljava/lang/StringBuilder;", "Lni/shikatu/kotlin/text/StringBuilder;", "obj", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/StringBuilder;Ljava/lang/Object;)Ljava/lang/StringBuilder;", "Lni/shikatu/kotlin/Deprecated;", "message", "Use append(value: Any?) instead", "replaceWith", "Lni/shikatu/kotlin/ReplaceWith;", "expression", "append(value = obj)", "imports", "level", "Lni/shikatu/kotlin/DeprecationLevel;", "WARNING", "Lni/shikatu/kotlin/internal/InlineOnly;", "Lni/shikatu/kotlin/IgnorableReturnValue;", "buildString", _UrlKt.FRAGMENT_ENCODE_SET, "builderAction", "Lni/shikatu/kotlin/Function1;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/ExtensionFunctionType;", "capacity", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1", "value", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/StringBuilder;[Ljava/lang/String;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[Ljava/lang/Object;)Ljava/lang/StringBuilder;", "str", _UrlKt.FRAGMENT_ENCODE_SET, "offset", "len", "(Ljava/lang/StringBuilder;[CII)Ljava/lang/StringBuilder;", "Use appendRange instead.", "this.appendRange(str, offset, offset + len)", "ERROR", "appendLine", "(Ljava/lang/StringBuilder;)Ljava/lang/StringBuilder;", "1.4", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/StringBuilder;Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[C)Ljava/lang/StringBuilder;", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/StringBuilder;C)Ljava/lang/StringBuilder;", _UrlKt.FRAGMENT_ENCODE_SET, "(Ljava/lang/StringBuilder;Z)Ljava/lang/StringBuilder;", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/text/StringsKt")
class StringsKt__StringBuilderKt extends StringsKt__StringBuilderJVMKt {
    @IgnorableReturnValue
    @Deprecated(level = DeprecationLevel.WARNING, message = "Use append(value: Any?) instead", replaceWith = @ReplaceWith(expression = "append(value = obj)", imports = {}))
    private static final StringBuilder append(StringBuilder $this$append, Object obj) {
        Intrinsics.checkNotNullParameter($this$append, "<this>");
        return $this$append.append(obj);
    }

    private static final String buildString(Function1<? super StringBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        StringBuilder sb = new StringBuilder();
        function1.invoke(sb);
        return sb.toString();
    }

    private static final String buildString(int capacity, Function1<? super StringBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "builderAction");
        StringBuilder sb = new StringBuilder(capacity);
        function1.invoke(sb);
        return sb.toString();
    }

    @IgnorableReturnValue
    public static final StringBuilder append(StringBuilder $this$append, String... value) {
        Intrinsics.checkNotNullParameter($this$append, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        for (String item : value) {
            $this$append.append(item);
        }
        return $this$append;
    }

    @IgnorableReturnValue
    public static final StringBuilder append(StringBuilder $this$append, Object... value) {
        Intrinsics.checkNotNullParameter($this$append, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        for (Object item : value) {
            $this$append.append(item);
        }
        return $this$append;
    }

    @IgnorableReturnValue
    @Deprecated(level = DeprecationLevel.ERROR, message = "Use appendRange instead.", replaceWith = @ReplaceWith(expression = "this.appendRange(str, offset, offset + len)", imports = {}))
    private static final StringBuilder append(StringBuilder $this$append, char[] str, int offset, int len) {
        Intrinsics.checkNotNullParameter($this$append, "<this>");
        Intrinsics.checkNotNullParameter(str, "str");
        throw new NotImplementedError(null, 1, null);
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder $this$appendLine) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        return $this$appendLine.append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder $this$appendLine, CharSequence value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        return $this$appendLine.append(value).append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder $this$appendLine, String value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        return $this$appendLine.append(value).append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder $this$appendLine, Object value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        return $this$appendLine.append(value).append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder $this$appendLine, char[] value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        return $this$appendLine.append(value).append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder $this$appendLine, char value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        return $this$appendLine.append(value).append('\n');
    }

    @IgnorableReturnValue
    private static final StringBuilder appendLine(StringBuilder $this$appendLine, boolean value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        return $this$appendLine.append(value).append('\n');
    }
}
