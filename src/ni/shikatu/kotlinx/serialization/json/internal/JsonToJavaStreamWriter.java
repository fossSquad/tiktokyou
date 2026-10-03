package ni.shikatu.kotlinx.serialization.json.internal;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import ni.shikatu.kotlin.IgnorableReturnValue;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlinx.serialization.json.JsonEncodingException;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\b\u0000\u0018\u00002\u00020\u0001B\u0011\bF\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0012\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0096\u0080\u0004J\u0012\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0096\u0080\u0004J\u0012\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096\u0080\u0004J\u0012\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0096\u0080\u0004J\u001a\u0010\u0017\u001a\u00020\r2\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u0015H\u0082\u0080\u0004J\u001a\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000b2\u0006\u0010\u001c\u001a\u00020\u000bH\u0083\u0080\bJ\n\u0010\u001d\u001a\u00020\rH\u0096\u0080\u0004J\n\u0010\u001e\u001a\u00020\rH\u0082\u0080\u0004J\u0012\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000bH\u0082\u0088\u0004J\u0012\u0010\u0013\u001a\u00020\r2\u0006\u0010!\u001a\u00020\u000bH\u0082\u0088\u0004J\n\u0010\"\u001a\u00020\u000bH\u0082\u0088\u0004J\u001a\u0010#\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u000bH\u0082\u0080\u0004J\u0012\u0010%\u001a\u00020\r2\u0006\u0010&\u001a\u00020\u000bH\u0082\u0080\u0004R\u000f\u0010\u0002\u001a\u00020\u0003X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\u0006\u001a\u00020\u0007X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u000f\u0010\b\u001a\u00020\tX\u0082\u008e\b¢\u0006\u0002\n\u0000R\u000f\u0010\n\u001a\u00020\u000bX\u0082\u008e\b¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lni/shikatu/kotlinx/serialization/json/internal/JsonToJavaStreamWriter;", "Lni/shikatu/kotlinx/serialization/json/internal/InternalJsonWriter;", "stream", "Ljava/io/OutputStream;", "<init>", "(Ljava/io/OutputStream;)V", "buffer", _UrlKt.FRAGMENT_ENCODE_SET, "charArray", _UrlKt.FRAGMENT_ENCODE_SET, "indexInBuffer", _UrlKt.FRAGMENT_ENCODE_SET, "writeLong", _UrlKt.FRAGMENT_ENCODE_SET, "value", _UrlKt.FRAGMENT_ENCODE_SET, "writeChar", "char", _UrlKt.FRAGMENT_ENCODE_SET, "write", "text", _UrlKt.FRAGMENT_ENCODE_SET, "writeQuoted", "appendStringSlowPath", "currentSize", "string", "ensureTotalCapacity", "oldSize", "additional", "release", "flush", "ensure", "bytesCount", "byte", "rest", "writeUtf8", "count", "writeUtf8CodePoint", "codePoint", "ni.shikatu.kotlinx-serialization-json"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class JsonToJavaStreamWriter implements InternalJsonWriter {
    private final byte[] buffer;
    private char[] charArray;
    private int indexInBuffer;
    private final OutputStream stream;

    public JsonToJavaStreamWriter(OutputStream stream) {
        Intrinsics.checkNotNullParameter(stream, "stream");
        this.stream = stream;
        this.buffer = ByteArrayPool.INSTANCE.take();
        this.charArray = CharArrayPool.INSTANCE.take();
    }

    @Override
    public void writeLong(long value) {
        write(String.valueOf(value));
    }

    @Override
    public void writeChar(char c) {
        try {
            writeUtf8CodePoint(c);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void write(String text) {
        try {
            Intrinsics.checkNotNullParameter(text, "text");
            int length = text.length();
            ensureTotalCapacity(0, length);
            text.getChars(0, length, this.charArray, 0);
            writeUtf8(this.charArray, length);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeQuoted(String text) {
        try {
            Intrinsics.checkNotNullParameter(text, "text");
            ensureTotalCapacity(0, text.length() + 2);
            char[] arr = this.charArray;
            arr[0] = '\"';
            int length = text.length();
            text.getChars(0, length, arr, 1);
            int i = length + 1;
            for (int i2 = 1; i2 < i; i2++) {
                char c = arr[i2];
                if (c < StringOpsKt.getESCAPE_MARKERS().length && StringOpsKt.getESCAPE_MARKERS()[c] != 0) {
                    appendStringSlowPath(i2, text);
                    return;
                }
            }
            int i3 = length + 1;
            arr[i3] = '\"';
            writeUtf8(arr, length + 2);
            flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final void appendStringSlowPath(int currentSize, String string) throws IOException {
        int sz = currentSize;
        int length = string.length();
        for (int i = currentSize - 1; i < length; i++) {
            int sz2 = ensureTotalCapacity(sz, 2);
            int ch = string.charAt(i);
            if (ch < StringOpsKt.getESCAPE_MARKERS().length) {
                byte marker = StringOpsKt.getESCAPE_MARKERS()[ch];
                if (marker == 0) {
                    this.charArray[sz2] = (char) ch;
                    sz = sz2 + 1;
                } else if (marker == 1) {
                    String escapedString = StringOpsKt.getESCAPE_STRINGS()[ch];
                    Intrinsics.checkNotNull(escapedString);
                    int sz3 = ensureTotalCapacity(sz2, escapedString.length());
                    escapedString.getChars(0, escapedString.length(), this.charArray, sz3);
                    sz = sz3 + escapedString.length();
                } else {
                    this.charArray[sz2] = AbstractJsonLexerKt.STRING_ESC;
                    this.charArray[sz2 + 1] = (char) marker;
                    sz = sz2 + 2;
                }
            } else {
                this.charArray[sz2] = (char) ch;
                sz = sz2 + 1;
            }
        }
        ensureTotalCapacity(sz, 1);
        this.charArray[sz] = '\"';
        writeUtf8(this.charArray, sz + 1);
        flush();
    }

    @IgnorableReturnValue
    private final int ensureTotalCapacity(int oldSize, int additional) {
        int newSize = oldSize + additional;
        if (this.charArray.length <= newSize) {
            char[] cArrCopyOf = Arrays.copyOf(this.charArray, RangesKt.coerceAtLeast(newSize, oldSize * 2));
            Intrinsics.checkNotNullExpressionValue(cArrCopyOf, "copyOf(...)");
            this.charArray = cArrCopyOf;
        }
        return oldSize;
    }

    @Override
    public void release() {
        try {
            flush();
            CharArrayPool.INSTANCE.release(this.charArray);
            ByteArrayPool.INSTANCE.release(this.buffer);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private final void flush() throws IOException {
        this.stream.write(this.buffer, 0, this.indexInBuffer);
        this.indexInBuffer = 0;
    }

    private final void ensure(int bytesCount) throws IOException {
        if (this.buffer.length - this.indexInBuffer < bytesCount) {
            flush();
        }
    }

    private final void write(int i) {
        byte[] bArr = this.buffer;
        int i2 = this.indexInBuffer;
        this.indexInBuffer = i2 + 1;
        bArr[i2] = (byte) i;
    }

    private final int rest() {
        return this.buffer.length - this.indexInBuffer;
    }

    private final void writeUtf8(char[] string, int count) throws IOException {
        if (!(count >= 0)) {
            throw new IllegalArgumentException("count < 0".toString());
        }
        if (!(count <= string.length)) {
            throw new IllegalArgumentException(("count > string.length: " + count + " > " + string.length).toString());
        }
        int i = 0;
        while (i < count) {
            char c = string[i];
            if (c >= 128) {
                if (c >= 2048) {
                    if (c >= 55296 && c <= 57343) {
                        char c2 = i + 1 < count ? string[i + 1] : (char) 0;
                        if (c <= 56319) {
                            if (56320 <= c2 && c2 < 57344) {
                                int codePoint = (((c & 1023) << 10) | (c2 & 1023)) + 65536;
                                if (this.buffer.length - this.indexInBuffer < 4) {
                                    flush();
                                }
                                int bytesCount$iv = codePoint >> 18;
                                int byte$iv = bytesCount$iv | 240;
                                byte[] bArr = this.buffer;
                                int i2 = this.indexInBuffer;
                                this.indexInBuffer = i2 + 1;
                                bArr[i2] = (byte) byte$iv;
                                int byte$iv2 = codePoint >> 12;
                                byte[] bArr2 = this.buffer;
                                int i3 = this.indexInBuffer;
                                this.indexInBuffer = i3 + 1;
                                bArr2[i3] = (byte) ((byte$iv2 & 63) | 128);
                                int byte$iv3 = codePoint >> 6;
                                byte[] bArr3 = this.buffer;
                                int i4 = this.indexInBuffer;
                                this.indexInBuffer = i4 + 1;
                                bArr3[i4] = (byte) ((byte$iv3 & 63) | 128);
                                int byte$iv4 = codePoint & 63;
                                byte[] bArr4 = this.buffer;
                                int i5 = this.indexInBuffer;
                                this.indexInBuffer = i5 + 1;
                                bArr4[i5] = (byte) (128 | byte$iv4);
                                i += 2;
                            }
                        }
                        if (this.buffer.length - this.indexInBuffer < 1) {
                            flush();
                        }
                        byte[] bArr5 = this.buffer;
                        int i6 = this.indexInBuffer;
                        this.indexInBuffer = i6 + 1;
                        bArr5[i6] = (byte) 63;
                        i++;
                    } else {
                        if (this.buffer.length - this.indexInBuffer < 3) {
                            flush();
                        }
                        int bytesCount$iv2 = c >> '\f';
                        int byte$iv5 = bytesCount$iv2 | 224;
                        byte[] bArr6 = this.buffer;
                        int i7 = this.indexInBuffer;
                        this.indexInBuffer = i7 + 1;
                        bArr6[i7] = (byte) byte$iv5;
                        int byte$iv6 = c >> 6;
                        byte[] bArr7 = this.buffer;
                        int i8 = this.indexInBuffer;
                        this.indexInBuffer = i8 + 1;
                        bArr7[i8] = (byte) ((byte$iv6 & 63) | 128);
                        int byte$iv7 = c & '?';
                        byte[] bArr8 = this.buffer;
                        int i9 = this.indexInBuffer;
                        this.indexInBuffer = i9 + 1;
                        bArr8[i9] = (byte) (128 | byte$iv7);
                        i++;
                    }
                } else {
                    if (this.buffer.length - this.indexInBuffer < 2) {
                        flush();
                    }
                    int bytesCount$iv3 = c >> 6;
                    int byte$iv8 = bytesCount$iv3 | 192;
                    byte[] bArr9 = this.buffer;
                    int i10 = this.indexInBuffer;
                    this.indexInBuffer = i10 + 1;
                    bArr9[i10] = (byte) byte$iv8;
                    int byte$iv9 = c & '?';
                    byte[] bArr10 = this.buffer;
                    int i11 = this.indexInBuffer;
                    this.indexInBuffer = i11 + 1;
                    bArr10[i11] = (byte) (128 | byte$iv9);
                    i++;
                }
            } else {
                if (this.buffer.length - this.indexInBuffer < 1) {
                    flush();
                }
                byte[] bArr11 = this.buffer;
                int i12 = this.indexInBuffer;
                this.indexInBuffer = i12 + 1;
                bArr11[i12] = (byte) c;
                i++;
                int runLimit = Math.min(count, (this.buffer.length - this.indexInBuffer) + i);
                while (i < runLimit) {
                    char c3 = string[i];
                    if (c3 >= 128) {
                        break;
                    }
                    byte[] bArr12 = this.buffer;
                    int i13 = this.indexInBuffer;
                    this.indexInBuffer = i13 + 1;
                    bArr12[i13] = (byte) c3;
                    i++;
                }
            }
        }
    }

    private final void writeUtf8CodePoint(int codePoint) throws IOException {
        if (codePoint >= 128) {
            if (codePoint >= 2048) {
                boolean z = false;
                if (55296 <= codePoint && codePoint < 57344) {
                    z = true;
                }
                if (!z) {
                    if (codePoint >= 65536) {
                        if (codePoint > 1114111) {
                            throw new JsonEncodingException("Unexpected code point: " + codePoint + ". Check your strings for malformed UTF-8 sequences.", null, null, 6, null);
                        }
                        if (this.buffer.length - this.indexInBuffer < 4) {
                            flush();
                        }
                        int bytesCount$iv = codePoint >> 18;
                        int byte$iv = bytesCount$iv | 240;
                        byte[] bArr = this.buffer;
                        int i = this.indexInBuffer;
                        this.indexInBuffer = i + 1;
                        bArr[i] = (byte) byte$iv;
                        int byte$iv2 = codePoint >> 12;
                        byte[] bArr2 = this.buffer;
                        int i2 = this.indexInBuffer;
                        this.indexInBuffer = i2 + 1;
                        bArr2[i2] = (byte) ((byte$iv2 & 63) | 128);
                        int byte$iv3 = codePoint >> 6;
                        byte[] bArr3 = this.buffer;
                        int i3 = this.indexInBuffer;
                        this.indexInBuffer = i3 + 1;
                        bArr3[i3] = (byte) ((byte$iv3 & 63) | 128);
                        int byte$iv4 = codePoint & 63;
                        byte[] bArr4 = this.buffer;
                        int i4 = this.indexInBuffer;
                        this.indexInBuffer = i4 + 1;
                        bArr4[i4] = (byte) (128 | byte$iv4);
                        return;
                    }
                    if (this.buffer.length - this.indexInBuffer < 3) {
                        flush();
                    }
                    int bytesCount$iv2 = codePoint >> 12;
                    int byte$iv5 = bytesCount$iv2 | 224;
                    byte[] bArr5 = this.buffer;
                    int i5 = this.indexInBuffer;
                    this.indexInBuffer = i5 + 1;
                    bArr5[i5] = (byte) byte$iv5;
                    int byte$iv6 = codePoint >> 6;
                    byte[] bArr6 = this.buffer;
                    int i6 = this.indexInBuffer;
                    this.indexInBuffer = i6 + 1;
                    bArr6[i6] = (byte) ((byte$iv6 & 63) | 128);
                    int byte$iv7 = codePoint & 63;
                    byte[] bArr7 = this.buffer;
                    int i7 = this.indexInBuffer;
                    this.indexInBuffer = i7 + 1;
                    bArr7[i7] = (byte) (128 | byte$iv7);
                    return;
                }
                if (this.buffer.length - this.indexInBuffer < 1) {
                    flush();
                }
                byte[] bArr8 = this.buffer;
                int i8 = this.indexInBuffer;
                this.indexInBuffer = i8 + 1;
                bArr8[i8] = (byte) 63;
                return;
            }
            if (this.buffer.length - this.indexInBuffer < 2) {
                flush();
            }
            int bytesCount$iv3 = codePoint >> 6;
            int byte$iv8 = bytesCount$iv3 | 192;
            byte[] bArr9 = this.buffer;
            int i9 = this.indexInBuffer;
            this.indexInBuffer = i9 + 1;
            bArr9[i9] = (byte) byte$iv8;
            int byte$iv9 = codePoint & 63;
            byte[] bArr10 = this.buffer;
            int i10 = this.indexInBuffer;
            this.indexInBuffer = i10 + 1;
            bArr10[i10] = (byte) (128 | byte$iv9);
            return;
        }
        if (this.buffer.length - this.indexInBuffer < 1) {
            flush();
        }
        byte[] bArr11 = this.buffer;
        int i11 = this.indexInBuffer;
        this.indexInBuffer = i11 + 1;
        bArr11[i11] = (byte) codePoint;
    }
}
