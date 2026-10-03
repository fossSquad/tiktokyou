package ni.shikatu.kotlinx.serialization.json.internal;

import java.util.Arrays;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\b\u0000\u0018\u00002\u00020\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0096\u0080\u0004J\u0012\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\u000eH\u0096\u0080\u0004J\u0012\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004J\u0012\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011H\u0096\u0080\u0004J\"\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u0011H\u0082\u0080\u0004J\n\u0010\u0017\u001a\u00020\tH\u0096\u0080\u0004J\n\u0010\u0018\u001a\u00020\u0011H\u0096\u0080\u0004J\u0012\u0010\u0019\u001a\u00020\t2\u0006\u0010\u001a\u001a\u00020\u0007H\u0082\u0080\u0004J\u001a\u0010\u001b\u001a\u00020\u00072\u0006\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u0007H\u0083\u0080\bR\u000f\u0010\u0004\u001a\u00020\u0005X\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0006\u001a\u00020\u0007X\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/JsonToStringWriter;", "Lni/shikatu/kotlinx/serialization/json/internal/InternalJsonWriter;", "<init>", "()V", "array", _UrlKt.FRAGMENT_ENCODE_SET, "size", _UrlKt.FRAGMENT_ENCODE_SET, "writeLong", _UrlKt.FRAGMENT_ENCODE_SET, "value", _UrlKt.FRAGMENT_ENCODE_SET, "writeChar", "char", _UrlKt.FRAGMENT_ENCODE_SET, "write", "text", _UrlKt.FRAGMENT_ENCODE_SET, "writeQuoted", "appendStringSlowPath", "firstEscapedChar", "currentSize", "string", "release", "toString", "ensureAdditionalCapacity", "expected", "ensureTotalCapacity", "oldSize", "additional", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JsonToStringWriter implements InternalJsonWriter {
    private char[] array = CharArrayPool.INSTANCE.take();
    private int size;

    @Override
    public void writeLong(long value) {
        write(String.valueOf(value));
    }

    @Override
    public void writeChar(char c) {
        ensureAdditionalCapacity(1);
        char[] cArr = this.array;
        int i = this.size;
        this.size = i + 1;
        cArr[i] = c;
    }

    @Override
    public void write(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        int length = text.length();
        if (length == 0) {
            return;
        }
        ensureAdditionalCapacity(length);
        text.getChars(0, text.length(), this.array, this.size);
        this.size += length;
    }

    @Override
    public void writeQuoted(String text) {
        Intrinsics.checkNotNullParameter(text, "text");
        ensureAdditionalCapacity(text.length() + 2);
        char[] arr = this.array;
        int sz = this.size;
        int sz2 = sz + 1;
        arr[sz] = '\"';
        int length = text.length();
        text.getChars(0, length, arr, sz2);
        int i = sz2 + length;
        for (int i2 = sz2; i2 < i; i2++) {
            char c = arr[i2];
            if (c < StringOpsKt.getESCAPE_MARKERS().length && StringOpsKt.getESCAPE_MARKERS()[c] != 0) {
                appendStringSlowPath(i2 - sz2, i2, text);
                return;
            }
        }
        int sz3 = sz2 + length;
        arr[sz3] = '\"';
        this.size = sz3 + 1;
    }

    private final void appendStringSlowPath(int firstEscapedChar, int currentSize, String string) {
        int sz = currentSize;
        int length = string.length();
        for (int i = firstEscapedChar; i < length; i++) {
            int sz2 = ensureTotalCapacity(sz, 2);
            int ch = string.charAt(i);
            if (ch < StringOpsKt.getESCAPE_MARKERS().length) {
                byte marker = StringOpsKt.getESCAPE_MARKERS()[ch];
                if (marker == 0) {
                    this.array[sz2] = (char) ch;
                    sz = sz2 + 1;
                } else if (marker == 1) {
                    String escapedString = StringOpsKt.getESCAPE_STRINGS()[ch];
                    Intrinsics.checkNotNull(escapedString);
                    int sz3 = ensureTotalCapacity(sz2, escapedString.length());
                    escapedString.getChars(0, escapedString.length(), this.array, sz3);
                    sz = sz3 + escapedString.length();
                    this.size = sz;
                } else {
                    this.array[sz2] = AbstractJsonLexerKt.STRING_ESC;
                    this.array[sz2 + 1] = (char) marker;
                    sz = sz2 + 2;
                    this.size = sz;
                }
            } else {
                this.array[sz2] = (char) ch;
                sz = sz2 + 1;
            }
        }
        int sz4 = ensureTotalCapacity(sz, 1);
        this.array[sz4] = '\"';
        this.size = sz4 + 1;
    }

    @Override
    public void release() {
        CharArrayPool.INSTANCE.release(this.array);
    }

    public String toString() {
        return new String(this.array, 0, this.size);
    }

    private final void ensureAdditionalCapacity(int expected) {
        ensureTotalCapacity(this.size, expected);
    }

    @IgnorableReturnValue
    private final int ensureTotalCapacity(int oldSize, int additional) {
        int newSize = oldSize + additional;
        if (this.array.length <= newSize) {
            char[] cArrCopyOf = Arrays.copyOf(this.array, RangesKt.coerceAtLeast(newSize, oldSize * 2));
            Intrinsics.checkNotNullExpressionValue(cArrCopyOf, "copyOf(...)");
            this.array = cArrCopyOf;
        }
        return oldSize;
    }
}
