package ni.shikatu.kotlin.text;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.IntCompanionObject;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00152\u00020\u0001:\u0004\u0012\u0013\u0014\u0015B!\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0016"}, d2 = {"Lni/shikatu/kotlin/text/HexFormat;", "", "upperCase", "", "bytes", "Lni/shikatu/kotlin/text/HexFormat$BytesHexFormat;", "number", "Lni/shikatu/kotlin/text/HexFormat$NumberHexFormat;", "<init>", "(ZLkotlin/text/HexFormat$BytesHexFormat;Lkotlin/text/HexFormat$NumberHexFormat;)V", "getUpperCase", "()Z", "getBytes", "()Lkotlin/text/HexFormat$BytesHexFormat;", "getNumber", "()Lkotlin/text/HexFormat$NumberHexFormat;", "toString", "", "BytesHexFormat", "NumberHexFormat", "Builder", "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HexFormat {
    public static final Companion Companion = new Companion(null);
    private static final HexFormat Default = new HexFormat(false, BytesHexFormat.Companion.getDefault$kotlin_stdlib(), NumberHexFormat.Companion.getDefault$kotlin_stdlib());
    private static final HexFormat UpperCase = new HexFormat(true, BytesHexFormat.Companion.getDefault$kotlin_stdlib(), NumberHexFormat.Companion.getDefault$kotlin_stdlib());
    private final BytesHexFormat bytes;
    private final NumberHexFormat number;
    private final boolean upperCase;

    public HexFormat(boolean upperCase, BytesHexFormat bytes, NumberHexFormat number) {
        Intrinsics.checkNotNullParameter(bytes, "bytes");
        Intrinsics.checkNotNullParameter(number, "number");
        this.upperCase = upperCase;
        this.bytes = bytes;
        this.number = number;
    }

    public final boolean getUpperCase() {
        return this.upperCase;
    }

    public final BytesHexFormat getBytes() {
        return this.bytes;
    }

    public final NumberHexFormat getNumber() {
        return this.number;
    }

    public String toString() {
        StringBuilder $this$toString_u24lambda_u240 = new StringBuilder();
        $this$toString_u24lambda_u240.append("HexFormat(").append('\n');
        $this$toString_u24lambda_u240.append("    upperCase = ").append(this.upperCase).append(",").append('\n');
        $this$toString_u24lambda_u240.append("    bytes = BytesHexFormat(").append('\n');
        this.bytes.appendOptionsTo$kotlin_stdlib($this$toString_u24lambda_u240, "        ").append('\n');
        $this$toString_u24lambda_u240.append("    ),").append('\n');
        $this$toString_u24lambda_u240.append("    number = NumberHexFormat(").append('\n');
        this.number.appendOptionsTo$kotlin_stdlib($this$toString_u24lambda_u240, "        ").append('\n');
        $this$toString_u24lambda_u240.append("    )").append('\n');
        $this$toString_u24lambda_u240.append(")");
        return $this$toString_u24lambda_u240.toString();
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 %2\u00020\u0001:\u0002$%B9\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\b\u0010\u001c\u001a\u00020\u0006H\u0016J'\u0010\u001d\u001a\u00060\u001ej\u0002`\u001f2\n\u0010 \u001a\u00060\u001ej\u0002`\u001f2\u0006\u0010!\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\"\u0010#R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\rR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0011\u0010\b\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0014\u0010\u0014\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0014\u0010\u001a\u001a\u00020\u0015X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017¨\u0006&"}, d2 = {"Lni/shikatu/kotlin/text/HexFormat$BytesHexFormat;", "", "bytesPerLine", "", "bytesPerGroup", "groupSeparator", "", "byteSeparator", "bytePrefix", "byteSuffix", "<init>", "(IILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getBytesPerLine", "()I", "getBytesPerGroup", "getGroupSeparator", "()Ljava/lang/String;", "getByteSeparator", "getBytePrefix", "getByteSuffix", "noLineAndGroupSeparator", "", "getNoLineAndGroupSeparator$kotlin_stdlib", "()Z", "shortByteSeparatorNoPrefixAndSuffix", "getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib", "ignoreCase", "getIgnoreCase$kotlin_stdlib", "toString", "appendOptionsTo", "Ljava/lang/StringBuilder;", "Lni/shikatu/kotlin/text/StringBuilder;", "sb", "indent", "appendOptionsTo$kotlin_stdlib", "(Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/StringBuilder;", "Builder", "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class BytesHexFormat {
        public static final Companion Companion = new Companion(null);
        private static final BytesHexFormat Default = new BytesHexFormat(IntCompanionObject.MAX_VALUE, IntCompanionObject.MAX_VALUE, "  ", "", "", "");
        private final String bytePrefix;
        private final String byteSeparator;
        private final String byteSuffix;
        private final int bytesPerGroup;
        private final int bytesPerLine;
        private final String groupSeparator;
        private final boolean ignoreCase;
        private final boolean noLineAndGroupSeparator;
        private final boolean shortByteSeparatorNoPrefixAndSuffix;

        public BytesHexFormat(int bytesPerLine, int bytesPerGroup, String groupSeparator, String byteSeparator, String bytePrefix, String byteSuffix) {
            boolean z;
            Intrinsics.checkNotNullParameter(groupSeparator, "groupSeparator");
            Intrinsics.checkNotNullParameter(byteSeparator, "byteSeparator");
            Intrinsics.checkNotNullParameter(bytePrefix, "bytePrefix");
            Intrinsics.checkNotNullParameter(byteSuffix, "byteSuffix");
            this.bytesPerLine = bytesPerLine;
            this.bytesPerGroup = bytesPerGroup;
            this.groupSeparator = groupSeparator;
            this.byteSeparator = byteSeparator;
            this.bytePrefix = bytePrefix;
            this.byteSuffix = byteSuffix;
            this.noLineAndGroupSeparator = this.bytesPerLine == Integer.MAX_VALUE && this.bytesPerGroup == Integer.MAX_VALUE;
            if (this.bytePrefix.length() == 0) {
                if (!(this.byteSuffix.length() == 0) || this.byteSeparator.length() > 1) {
                    z = false;
                } else {
                    z = true;
                }
            } else {
                z = false;
            }
            this.shortByteSeparatorNoPrefixAndSuffix = z;
            this.ignoreCase = HexFormatKt.isCaseSensitive(this.groupSeparator) || HexFormatKt.isCaseSensitive(this.byteSeparator) || HexFormatKt.isCaseSensitive(this.bytePrefix) || HexFormatKt.isCaseSensitive(this.byteSuffix);
        }

        public final int getBytesPerLine() {
            return this.bytesPerLine;
        }

        public final int getBytesPerGroup() {
            return this.bytesPerGroup;
        }

        public final String getGroupSeparator() {
            return this.groupSeparator;
        }

        public final String getByteSeparator() {
            return this.byteSeparator;
        }

        public final String getBytePrefix() {
            return this.bytePrefix;
        }

        public final String getByteSuffix() {
            return this.byteSuffix;
        }

        public final boolean getNoLineAndGroupSeparator$kotlin_stdlib() {
            return this.noLineAndGroupSeparator;
        }

        public final boolean getShortByteSeparatorNoPrefixAndSuffix$kotlin_stdlib() {
            return this.shortByteSeparatorNoPrefixAndSuffix;
        }

        public final boolean getIgnoreCase$kotlin_stdlib() {
            return this.ignoreCase;
        }

        public String toString() {
            StringBuilder $this$toString_u24lambda_u240 = new StringBuilder();
            $this$toString_u24lambda_u240.append("BytesHexFormat(").append('\n');
            appendOptionsTo$kotlin_stdlib($this$toString_u24lambda_u240, "    ").append('\n');
            $this$toString_u24lambda_u240.append(")");
            return $this$toString_u24lambda_u240.toString();
        }

        public final StringBuilder appendOptionsTo$kotlin_stdlib(StringBuilder sb, String indent) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            Intrinsics.checkNotNullParameter(indent, "indent");
            sb.append(indent).append("bytesPerLine = ").append(this.bytesPerLine).append(",").append('\n');
            sb.append(indent).append("bytesPerGroup = ").append(this.bytesPerGroup).append(",").append('\n');
            sb.append(indent).append("groupSeparator = \"").append(this.groupSeparator).append("\",").append('\n');
            sb.append(indent).append("byteSeparator = \"").append(this.byteSeparator).append("\",").append('\n');
            sb.append(indent).append("bytePrefix = \"").append(this.bytePrefix).append("\",").append('\n');
            sb.append(indent).append("byteSuffix = \"").append(this.byteSuffix).append("\"");
            return sb;
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u001d\u001a\u00020\u001eH\u0000¢\u0006\u0002\b\u001fR$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R$\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R$\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R$\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u0004\u001a\u00020\u000f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013¨\u0006 "}, d2 = {"Lni/shikatu/kotlin/text/HexFormat$BytesHexFormat$Builder;", "", "<init>", "()V", "value", "", "bytesPerLine", "getBytesPerLine", "()I", "setBytesPerLine", "(I)V", "bytesPerGroup", "getBytesPerGroup", "setBytesPerGroup", "groupSeparator", "", "getGroupSeparator", "()Ljava/lang/String;", "setGroupSeparator", "(Ljava/lang/String;)V", "byteSeparator", "getByteSeparator", "setByteSeparator", "bytePrefix", "getBytePrefix", "setBytePrefix", "byteSuffix", "getByteSuffix", "setByteSuffix", "build", "Lni/shikatu/kotlin/text/HexFormat$BytesHexFormat;", "build$kotlin_stdlib", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Builder {
            private int bytesPerLine = BytesHexFormat.Companion.getDefault$kotlin_stdlib().getBytesPerLine();
            private int bytesPerGroup = BytesHexFormat.Companion.getDefault$kotlin_stdlib().getBytesPerGroup();
            private String groupSeparator = BytesHexFormat.Companion.getDefault$kotlin_stdlib().getGroupSeparator();
            private String byteSeparator = BytesHexFormat.Companion.getDefault$kotlin_stdlib().getByteSeparator();
            private String bytePrefix = BytesHexFormat.Companion.getDefault$kotlin_stdlib().getBytePrefix();
            private String byteSuffix = BytesHexFormat.Companion.getDefault$kotlin_stdlib().getByteSuffix();

            public final int getBytesPerLine() {
                return this.bytesPerLine;
            }

            public final void setBytesPerLine(int value) {
                if (value <= 0) {
                    throw new IllegalArgumentException("Non-positive values are prohibited for bytesPerLine, but was " + value);
                }
                this.bytesPerLine = value;
            }

            public final int getBytesPerGroup() {
                return this.bytesPerGroup;
            }

            public final void setBytesPerGroup(int value) {
                if (value <= 0) {
                    throw new IllegalArgumentException("Non-positive values are prohibited for bytesPerGroup, but was " + value);
                }
                this.bytesPerGroup = value;
            }

            public final String getGroupSeparator() {
                return this.groupSeparator;
            }

            public final void setGroupSeparator(String str) {
                Intrinsics.checkNotNullParameter(str, "<set-?>");
                this.groupSeparator = str;
            }

            public final String getByteSeparator() {
                return this.byteSeparator;
            }

            public final void setByteSeparator(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (StringsKt.contains$default((CharSequence) value, '\n', false, 2, (Object) null) || StringsKt.contains$default((CharSequence) value, '\r', false, 2, (Object) null)) {
                    throw new IllegalArgumentException("LF and CR characters are prohibited in byteSeparator, but was " + value);
                }
                this.byteSeparator = value;
            }

            public final String getBytePrefix() {
                return this.bytePrefix;
            }

            public final void setBytePrefix(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (StringsKt.contains$default((CharSequence) value, '\n', false, 2, (Object) null) || StringsKt.contains$default((CharSequence) value, '\r', false, 2, (Object) null)) {
                    throw new IllegalArgumentException("LF and CR characters are prohibited in bytePrefix, but was " + value);
                }
                this.bytePrefix = value;
            }

            public final String getByteSuffix() {
                return this.byteSuffix;
            }

            public final void setByteSuffix(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (StringsKt.contains$default((CharSequence) value, '\n', false, 2, (Object) null) || StringsKt.contains$default((CharSequence) value, '\r', false, 2, (Object) null)) {
                    throw new IllegalArgumentException("LF and CR characters are prohibited in byteSuffix, but was " + value);
                }
                this.byteSuffix = value;
            }

            public final BytesHexFormat build$kotlin_stdlib() {
                return new BytesHexFormat(this.bytesPerLine, this.bytesPerGroup, this.groupSeparator, this.byteSeparator, this.bytePrefix, this.byteSuffix);
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lni/shikatu/kotlin/text/HexFormat$BytesHexFormat$Companion;", "", "<init>", "()V", "Default", "Lni/shikatu/kotlin/text/HexFormat$BytesHexFormat;", "getDefault$kotlin_stdlib", "()Lkotlin/text/HexFormat$BytesHexFormat;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final BytesHexFormat getDefault$kotlin_stdlib() {
                return BytesHexFormat.Default;
            }
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u0000 #2\u00020\u0001:\u0002\"#B)\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010\u001a\u001a\u00020\u0003H\u0016J'\u0010\u001b\u001a\u00060\u001cj\u0002`\u001d2\n\u0010\u001e\u001a\u00060\u001cj\u0002`\u001d2\u0006\u0010\u001f\u001a\u00020\u0003H\u0000¢\u0006\u0004\b \u0010!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0014\u0010\u0016\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0014\u0010\u0018\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u000f¨\u0006$"}, d2 = {"Lni/shikatu/kotlin/text/HexFormat$NumberHexFormat;", "", "prefix", "", "suffix", "removeLeadingZeros", "", "minLength", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;ZI)V", "getPrefix", "()Ljava/lang/String;", "getSuffix", "getRemoveLeadingZeros", "()Z", "getMinLength$annotations", "()V", "getMinLength", "()I", "isDigitsOnly", "isDigitsOnly$kotlin_stdlib", "isDigitsOnlyAndNoPadding", "isDigitsOnlyAndNoPadding$kotlin_stdlib", "ignoreCase", "getIgnoreCase$kotlin_stdlib", "toString", "appendOptionsTo", "Ljava/lang/StringBuilder;", "Lni/shikatu/kotlin/text/StringBuilder;", "sb", "indent", "appendOptionsTo$kotlin_stdlib", "(Ljava/lang/StringBuilder;Ljava/lang/String;)Ljava/lang/StringBuilder;", "Builder", "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class NumberHexFormat {
        public static final Companion Companion = new Companion(null);
        private static final NumberHexFormat Default = new NumberHexFormat("", "", false, 1);
        private final boolean ignoreCase;
        private final boolean isDigitsOnly;
        private final boolean isDigitsOnlyAndNoPadding;
        private final int minLength;
        private final String prefix;
        private final boolean removeLeadingZeros;
        private final String suffix;

        public static  void getMinLength$annotations() {
        }

        public NumberHexFormat(String prefix, String suffix, boolean removeLeadingZeros, int minLength) {
            boolean z;
            Intrinsics.checkNotNullParameter(prefix, "prefix");
            Intrinsics.checkNotNullParameter(suffix, "suffix");
            this.prefix = prefix;
            this.suffix = suffix;
            this.removeLeadingZeros = removeLeadingZeros;
            this.minLength = minLength;
            if (this.prefix.length() == 0) {
                if (this.suffix.length() == 0) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
            this.isDigitsOnly = z;
            this.isDigitsOnlyAndNoPadding = this.isDigitsOnly && this.minLength == 1;
            this.ignoreCase = HexFormatKt.isCaseSensitive(this.prefix) || HexFormatKt.isCaseSensitive(this.suffix);
        }

        public final String getPrefix() {
            return this.prefix;
        }

        public final String getSuffix() {
            return this.suffix;
        }

        public final boolean getRemoveLeadingZeros() {
            return this.removeLeadingZeros;
        }

        public final int getMinLength() {
            return this.minLength;
        }

        public final boolean isDigitsOnly$kotlin_stdlib() {
            return this.isDigitsOnly;
        }

        public final boolean isDigitsOnlyAndNoPadding$kotlin_stdlib() {
            return this.isDigitsOnlyAndNoPadding;
        }

        public final boolean getIgnoreCase$kotlin_stdlib() {
            return this.ignoreCase;
        }

        public String toString() {
            StringBuilder $this$toString_u24lambda_u240 = new StringBuilder();
            $this$toString_u24lambda_u240.append("NumberHexFormat(").append('\n');
            appendOptionsTo$kotlin_stdlib($this$toString_u24lambda_u240, "    ").append('\n');
            $this$toString_u24lambda_u240.append(")");
            return $this$toString_u24lambda_u240.toString();
        }

        public final StringBuilder appendOptionsTo$kotlin_stdlib(StringBuilder sb, String indent) {
            Intrinsics.checkNotNullParameter(sb, "sb");
            Intrinsics.checkNotNullParameter(indent, "indent");
            sb.append(indent).append("prefix = \"").append(this.prefix).append("\",").append('\n');
            sb.append(indent).append("suffix = \"").append(this.suffix).append("\",").append('\n');
            sb.append(indent).append("removeLeadingZeros = ").append(this.removeLeadingZeros).append(',').append('\n');
            sb.append(indent).append("minLength = ").append(this.minLength);
            return sb;
        }

        @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\t\b\u0000¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0002\b\u001dR$\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR$\u0010\u000b\u001a\u00020\u00052\u0006\u0010\u0004\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\b\"\u0004\b\r\u0010\nR\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R,\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0004\u001a\u00020\u00148\u0006@FX\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0016\u0010\u0003\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001e"}, d2 = {"Lni/shikatu/kotlin/text/HexFormat$NumberHexFormat$Builder;", "", "<init>", "()V", "value", "", "prefix", "getPrefix", "()Ljava/lang/String;", "setPrefix", "(Ljava/lang/String;)V", "suffix", "getSuffix", "setSuffix", "removeLeadingZeros", "", "getRemoveLeadingZeros", "()Z", "setRemoveLeadingZeros", "(Z)V", "", "minLength", "getMinLength$annotations", "getMinLength", "()I", "setMinLength", "(I)V", "build", "Lni/shikatu/kotlin/text/HexFormat$NumberHexFormat;", "build$kotlin_stdlib", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Builder {
            private String prefix = NumberHexFormat.Companion.getDefault$kotlin_stdlib().getPrefix();
            private String suffix = NumberHexFormat.Companion.getDefault$kotlin_stdlib().getSuffix();
            private boolean removeLeadingZeros = NumberHexFormat.Companion.getDefault$kotlin_stdlib().getRemoveLeadingZeros();
            private int minLength = NumberHexFormat.Companion.getDefault$kotlin_stdlib().getMinLength();

            public static  void getMinLength$annotations() {
            }

            public final String getPrefix() {
                return this.prefix;
            }

            public final void setPrefix(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (StringsKt.contains$default((CharSequence) value, '\n', false, 2, (Object) null) || StringsKt.contains$default((CharSequence) value, '\r', false, 2, (Object) null)) {
                    throw new IllegalArgumentException("LF and CR characters are prohibited in prefix, but was " + value);
                }
                this.prefix = value;
            }

            public final String getSuffix() {
                return this.suffix;
            }

            public final void setSuffix(String value) {
                Intrinsics.checkNotNullParameter(value, "value");
                if (StringsKt.contains$default((CharSequence) value, '\n', false, 2, (Object) null) || StringsKt.contains$default((CharSequence) value, '\r', false, 2, (Object) null)) {
                    throw new IllegalArgumentException("LF and CR characters are prohibited in suffix, but was " + value);
                }
                this.suffix = value;
            }

            public final boolean getRemoveLeadingZeros() {
                return this.removeLeadingZeros;
            }

            public final void setRemoveLeadingZeros(boolean z) {
                this.removeLeadingZeros = z;
            }

            public final int getMinLength() {
                return this.minLength;
            }

            public final void setMinLength(int value) {
                if (!(value > 0)) {
                    throw new IllegalArgumentException(("Non-positive values are prohibited for minLength, but was " + value).toString());
                }
                this.minLength = value;
            }

            public final NumberHexFormat build$kotlin_stdlib() {
                return new NumberHexFormat(this.prefix, this.suffix, this.removeLeadingZeros, this.minLength);
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lni/shikatu/kotlin/text/HexFormat$NumberHexFormat$Companion;", "", "<init>", "()V", "Default", "Lni/shikatu/kotlin/text/HexFormat$NumberHexFormat;", "getDefault$kotlin_stdlib", "()Lkotlin/text/HexFormat$NumberHexFormat;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
        public static final class Companion {
            public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final NumberHexFormat getDefault$kotlin_stdlib() {
                return NumberHexFormat.Default;
            }
        }
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0001¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\n\u001a\u00020\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\u0002\b\u0017H\u0087\bø\u0001\u0000J%\u0010\u000f\u001a\u00020\u00142\u0017\u0010\u0015\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00140\u0016¢\u0006\u0002\b\u0017H\u0087\bø\u0001\u0000J\b\u0010\u0018\u001a\u00020\u0019H\u0001R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001a"}, d2 = {"Lni/shikatu/kotlin/text/HexFormat$Builder;", "", "<init>", "()V", "upperCase", "", "getUpperCase", "()Z", "setUpperCase", "(Z)V", "bytes", "Lni/shikatu/kotlin/text/HexFormat$BytesHexFormat$Builder;", "getBytes", "()Lkotlin/text/HexFormat$BytesHexFormat$Builder;", "_bytes", "number", "Lni/shikatu/kotlin/text/HexFormat$NumberHexFormat$Builder;", "getNumber", "()Lkotlin/text/HexFormat$NumberHexFormat$Builder;", "_number", "", "builderAction", "Lni/shikatu/kotlin/Function1;", "Lni/shikatu/kotlin/ExtensionFunctionType;", "build", "Lni/shikatu/kotlin/text/HexFormat;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Builder {
        private BytesHexFormat.Builder _bytes;
        private NumberHexFormat.Builder _number;
        private boolean upperCase = HexFormat.Companion.getDefault().getUpperCase();

        public final boolean getUpperCase() {
            return this.upperCase;
        }

        public final void setUpperCase(boolean z) {
            this.upperCase = z;
        }

        public final BytesHexFormat.Builder getBytes() {
            if (this._bytes == null) {
                this._bytes = new BytesHexFormat.Builder();
            }
            BytesHexFormat.Builder builder = this._bytes;
            Intrinsics.checkNotNull(builder);
            return builder;
        }

        public final NumberHexFormat.Builder getNumber() {
            if (this._number == null) {
                this._number = new NumberHexFormat.Builder();
            }
            NumberHexFormat.Builder builder = this._number;
            Intrinsics.checkNotNull(builder);
            return builder;
        }

        private final void bytes(Function1<? super BytesHexFormat.Builder, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "builderAction");
            function1.invoke(getBytes());
        }

        private final void number(Function1<? super NumberHexFormat.Builder, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "builderAction");
            function1.invoke(getNumber());
        }

        public final HexFormat build() {
            BytesHexFormat default$kotlin_stdlib;
            NumberHexFormat default$kotlin_stdlib2;
            boolean z = this.upperCase;
            BytesHexFormat.Builder builder = this._bytes;
            if (builder == null || (default$kotlin_stdlib = builder.build$kotlin_stdlib()) == null) {
                default$kotlin_stdlib = BytesHexFormat.Companion.getDefault$kotlin_stdlib();
            }
            NumberHexFormat.Builder builder2 = this._number;
            if (builder2 == null || (default$kotlin_stdlib2 = builder2.build$kotlin_stdlib()) == null) {
                default$kotlin_stdlib2 = NumberHexFormat.Companion.getDefault$kotlin_stdlib();
            }
            return new HexFormat(z, default$kotlin_stdlib, default$kotlin_stdlib2);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lni/shikatu/kotlin/text/HexFormat$Companion;", "", "<init>", "()V", "Default", "Lni/shikatu/kotlin/text/HexFormat;", "getDefault", "()Lkotlin/text/HexFormat;", "UpperCase", "getUpperCase", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final HexFormat getDefault() {
            return HexFormat.Default;
        }

        public final HexFormat getUpperCase() {
            return HexFormat.UpperCase;
        }
    }
}
