package ni.shikatu.kotlin.text;

import java.io.IOException;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecatedSinceKotlin;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0005\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\u0010\f\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001d\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a%\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a%\u0010\u0006\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u0014\u0010\t\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0007\u001a!\u0010\n\u001a\u00020\u000b*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\fH\u0087\n\u001a-\u0010\r\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0010H\u0087\b\u001a\u001d\u0010\u0011\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0007\u001a\u00020\bH\u0087\b\u001a%\u0010\u0012\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0087\b\u001a7\u0010\u0013\u001a\u00020\u000b*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\b2\b\b\u0002\u0010\u000e\u001a\u00020\b2\b\b\u0002\u0010\u000f\u001a\u00020\bH\u0087\b\u001a-\u0010\u0017\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0087\b\u001a-\u0010\u0017\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0087\b\u001a5\u0010\u0019\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0087\b\u001a5\u0010\u0019\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\bH\u0087\b\u001a\u001f\u0010\u001a\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u001bH\u0087\b\u001a%\u0010\u001a\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000e\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\b\u001a\u001d\u0010\u001a\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u001d\u0010\u001a\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u001d\u0010\u001a\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001d\u0010\u001a\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u001cH\u0087\b\u001a\u001d\u0010\u001a\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u001dH\u0087\b\u001a\u001d\u0010\u001a\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u001eH\u0087\b\u001a\u0014\u0010\u001f\u001a\u00060 j\u0002`!*\u00060 j\u0002`!H\u0007\u001a\u001f\u0010\u001f\u001a\u00060 j\u0002`!*\u00060 j\u0002`!2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0018H\u0087\b\u001a\u001d\u0010\u001f\u001a\u00060 j\u0002`!*\u00060 j\u0002`!2\u0006\u0010\u0003\u001a\u00020\fH\u0087\b\u001a\u0014\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u0002H\u0007\u001a\u001f\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u001bH\u0087\b\u001a\u001f\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0018H\u0087\b\u001a\u001f\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0010H\u0087\b\u001a\u001f\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\"H\u0087\b\u001a%\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u000e\u0010\u0003\u001a\n\u0018\u00010\u0001j\u0004\u0018\u0001`\u0002H\u0087\b\u001a\u001d\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0015H\u0087\b\u001a\u001d\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\fH\u0087\b\u001a\u001d\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020#H\u0087\b\u001a\u001d\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\bH\u0087\b\u001a\u001d\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0005H\u0087\b\u001a\u001d\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0087\b\u001a\u001d\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u001cH\u0087\b\u001a\u001d\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u001dH\u0087\b\u001a\u001d\u0010\u001f\u001a\u00060\u0001j\u0002`\u0002*\u00060\u0001j\u0002`\u00022\u0006\u0010\u0003\u001a\u00020\u001eH\u0087\b¨\u0006$"}, d2 = {"append", "Ljava/lang/StringBuilder;", "Lni/shikatu/kotlin/text/StringBuilder;", "value", "", "", "insert", "index", "", "clear", "set", "", "", "setRange", "startIndex", "endIndex", "", "deleteAt", "deleteRange", "toCharArray", "destination", "", "destinationOffset", "appendRange", "", "insertRange", "appendLine", "Ljava/lang/StringBuffer;", "", "", "", "appendln", "Ljava/lang/Appendable;", "Lni/shikatu/kotlin/text/Appendable;", "", "", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 1, 0}, xi = 49, xs = "ni/shikatu/kotlin/text/StringsKt")
class StringsKt__StringBuilderJVMKt extends StringsKt__RegexExtensionsKt {
    private static final StringBuilder append(StringBuilder $this$append, byte value) {
        Intrinsics.checkNotNullParameter($this$append, "<this>");
        StringBuilder sbAppend = $this$append.append((int) value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend;
    }

    private static final StringBuilder append(StringBuilder $this$append, short value) {
        Intrinsics.checkNotNullParameter($this$append, "<this>");
        StringBuilder sbAppend = $this$append.append((int) value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend;
    }

    private static final StringBuilder insert(StringBuilder $this$insert, int index, byte value) {
        Intrinsics.checkNotNullParameter($this$insert, "<this>");
        StringBuilder sbInsert = $this$insert.insert(index, (int) value);
        Intrinsics.checkNotNullExpressionValue(sbInsert, "insert(...)");
        return sbInsert;
    }

    private static final StringBuilder insert(StringBuilder $this$insert, int index, short value) {
        Intrinsics.checkNotNullParameter($this$insert, "<this>");
        StringBuilder sbInsert = $this$insert.insert(index, (int) value);
        Intrinsics.checkNotNullExpressionValue(sbInsert, "insert(...)");
        return sbInsert;
    }

    public static final StringBuilder clear(StringBuilder $this$clear) {
        Intrinsics.checkNotNullParameter($this$clear, "<this>");
        $this$clear.setLength(0);
        return $this$clear;
    }

    private static final void set(StringBuilder $this$set, int index, char value) {
        Intrinsics.checkNotNullParameter($this$set, "<this>");
        $this$set.setCharAt(index, value);
    }

    private static final StringBuilder setRange(StringBuilder $this$setRange, int startIndex, int endIndex, String value) {
        Intrinsics.checkNotNullParameter($this$setRange, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sbReplace = $this$setRange.replace(startIndex, endIndex, value);
        Intrinsics.checkNotNullExpressionValue(sbReplace, "replace(...)");
        return sbReplace;
    }

    private static final StringBuilder deleteAt(StringBuilder $this$deleteAt, int index) {
        Intrinsics.checkNotNullParameter($this$deleteAt, "<this>");
        StringBuilder sbDeleteCharAt = $this$deleteAt.deleteCharAt(index);
        Intrinsics.checkNotNullExpressionValue(sbDeleteCharAt, "deleteCharAt(...)");
        return sbDeleteCharAt;
    }

    private static final StringBuilder deleteRange(StringBuilder $this$deleteRange, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$deleteRange, "<this>");
        StringBuilder sbDelete = $this$deleteRange.delete(startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(sbDelete, "delete(...)");
        return sbDelete;
    }

    static  void toCharArray$default(StringBuilder $this$toCharArray_u24default, char[] destination, int destinationOffset, int startIndex, int endIndex, int i, Object obj) {
        if ((i & 2) != 0) {
            destinationOffset = 0;
        }
        if ((i & 4) != 0) {
            startIndex = 0;
        }
        if ((i & 8) != 0) {
            endIndex = $this$toCharArray_u24default.length();
        }
        Intrinsics.checkNotNullParameter($this$toCharArray_u24default, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        $this$toCharArray_u24default.getChars(startIndex, endIndex, destination, destinationOffset);
    }

    private static final void toCharArray(StringBuilder $this$toCharArray, char[] destination, int destinationOffset, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$toCharArray, "<this>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        $this$toCharArray.getChars(startIndex, endIndex, destination, destinationOffset);
    }

    private static final StringBuilder appendRange(StringBuilder $this$appendRange, char[] value, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$appendRange, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sbAppend = $this$appendRange.append(value, startIndex, endIndex - startIndex);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend;
    }

    private static final StringBuilder appendRange(StringBuilder $this$appendRange, CharSequence value, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$appendRange, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sbAppend = $this$appendRange.append(value, startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend;
    }

    private static final StringBuilder insertRange(StringBuilder $this$insertRange, int index, char[] value, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$insertRange, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sbInsert = $this$insertRange.insert(index, value, startIndex, endIndex - startIndex);
        Intrinsics.checkNotNullExpressionValue(sbInsert, "insert(...)");
        return sbInsert;
    }

    private static final StringBuilder insertRange(StringBuilder $this$insertRange, int index, CharSequence value, int startIndex, int endIndex) {
        Intrinsics.checkNotNullParameter($this$insertRange, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sbInsert = $this$insertRange.insert(index, value, startIndex, endIndex);
        Intrinsics.checkNotNullExpressionValue(sbInsert, "insert(...)");
        return sbInsert;
    }

    private static final StringBuilder appendLine(StringBuilder $this$appendLine, StringBuffer value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        StringBuilder sbAppend = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend.append('\n');
    }

    private static final StringBuilder appendLine(StringBuilder $this$appendLine, StringBuilder value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        StringBuilder sbAppend = $this$appendLine.append((CharSequence) value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend.append('\n');
    }

    private static final StringBuilder appendLine(StringBuilder $this$appendLine, int value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        StringBuilder sbAppend = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend.append('\n');
    }

    private static final StringBuilder appendLine(StringBuilder $this$appendLine, short value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        StringBuilder sbAppend = $this$appendLine.append((int) value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend.append('\n');
    }

    private static final StringBuilder appendLine(StringBuilder $this$appendLine, byte value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        StringBuilder sbAppend = $this$appendLine.append((int) value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend.append('\n');
    }

    private static final StringBuilder appendLine(StringBuilder $this$appendLine, long value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        StringBuilder sbAppend = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend.append('\n');
    }

    private static final StringBuilder appendLine(StringBuilder $this$appendLine, float value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        StringBuilder sbAppend = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend.append('\n');
    }

    private static final StringBuilder appendLine(StringBuilder $this$appendLine, double value) {
        Intrinsics.checkNotNullParameter($this$appendLine, "<this>");
        StringBuilder sbAppend = $this$appendLine.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend.append('\n');
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    public static final Appendable appendln(Appendable $this$appendln) throws IOException {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        Appendable appendableAppend = $this$appendln.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(appendableAppend, "append(...)");
        return appendableAppend;
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final Appendable appendln(Appendable $this$appendln, CharSequence value) throws IOException {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        Appendable appendableAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(appendableAppend, "append(...)");
        return StringsKt.appendln(appendableAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final Appendable appendln(Appendable $this$appendln, char value) throws IOException {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        Appendable appendableAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(appendableAppend, "append(...)");
        return StringsKt.appendln(appendableAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine()", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    public static final StringBuilder appendln(StringBuilder $this$appendln) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append(SystemProperties.LINE_SEPARATOR);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return sbAppend;
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, StringBuffer value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, CharSequence value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, String value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, Object value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, StringBuilder value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append((CharSequence) value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, char[] value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        Intrinsics.checkNotNullParameter(value, "value");
        StringBuilder sbAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, char value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, boolean value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, int value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, short value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append((int) value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, byte value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append((int) value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, long value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, float value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }

    @Deprecated(message = "Use appendLine instead. Note that the new method always appends the line feed character '\\n' regardless of the system line separator.", replaceWith = @ReplaceWith(expression = "appendLine(value)", imports = {}))
    @DeprecatedSinceKotlin(errorSince = "2.1", warningSince = "1.4")
    private static final StringBuilder appendln(StringBuilder $this$appendln, double value) {
        Intrinsics.checkNotNullParameter($this$appendln, "<this>");
        StringBuilder sbAppend = $this$appendln.append(value);
        Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
        return StringsKt.appendln(sbAppend);
    }
}
