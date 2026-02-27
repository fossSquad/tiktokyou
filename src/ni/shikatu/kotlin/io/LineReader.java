package ni.shikatu.kotlin.io;

import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\tH\u0002J\b\u0010\u001d\u001a\u00020\u0005H\u0002J\u0018\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u001f\u001a\u00020\u00052\u0006\u0010 \u001a\u00020\u0005H\u0002J\u0010\u0010!\u001a\u00020\"2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\b\u0010#\u001a\u00020\"H\u0002J\b\u0010$\u001a\u00020\"H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0012\u001a\u00060\u0013j\u0002`\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lni/shikatu/kotlin/io/LineReader;", "", "<init>", "()V", "BUFFER_SIZE", "", "decoder", "Ljava/nio/charset/CharsetDecoder;", "directEOL", "", "bytes", "", "chars", "", "byteBuf", "Ljava/nio/ByteBuffer;", "charBuf", "Ljava/nio/CharBuffer;", "sb", "Ljava/lang/StringBuilder;", "Lni/shikatu/kotlin/text/StringBuilder;", "readLine", "", "inputStream", "Ljava/io/InputStream;", "charset", "Ljava/nio/charset/Charset;", "decode", "endOfInput", "compactBytes", "decodeEndOfInput", "nBytes", "nChars", "updateCharset", "", "resetAll", "trimStringBuilder", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LineReader {
    private static final int BUFFER_SIZE = 32;
    private static final ByteBuffer byteBuf;
    private static final CharBuffer charBuf;
    private static CharsetDecoder decoder;
    private static boolean directEOL;
    private static final StringBuilder sb;
    public static final LineReader INSTANCE = new LineReader();
    private static final byte[] bytes = new byte[32];
    private static final char[] chars = new char[32];

    private LineReader() {
    }

    static {
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bytes);
        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(...)");
        byteBuf = byteBufferWrap;
        CharBuffer charBufferWrap = CharBuffer.wrap(chars);
        Intrinsics.checkNotNullExpressionValue(charBufferWrap, "wrap(...)");
        charBuf = charBufferWrap;
        sb = new StringBuilder();
    }

    public final synchronized String readLine(InputStream inputStream, Charset charset) {
        boolean z;
        int nChars;
        Intrinsics.checkNotNullParameter(inputStream, "inputStream");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (decoder == null) {
            updateCharset(charset);
        } else {
            CharsetDecoder charsetDecoder = decoder;
            if (charsetDecoder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("decoder");
                charsetDecoder = null;
            }
            if (!Intrinsics.areEqual(charsetDecoder.charset(), charset)) {
                updateCharset(charset);
            }
        }
        int nBytes = 0;
        int nChars2 = 0;
        while (true) {
            int readByte = inputStream.read();
            z = true;
            if (readByte == -1) {
                if (!(sb.length() == 0) || nBytes != 0 || nChars2 != 0) {
                    nChars = decodeEndOfInput(nBytes, nChars2);
                    break;
                }
                return null;
            }
            int nBytes2 = nBytes + 1;
            bytes[nBytes] = (byte) readByte;
            if (readByte == 10 || nBytes2 == 32 || !directEOL) {
                byteBuf.limit(nBytes2);
                charBuf.position(nChars2);
                nChars2 = decode(false);
                if (nChars2 > 0 && chars[nChars2 - 1] == '\n') {
                    byteBuf.position(0);
                    nChars = nChars2;
                    break;
                }
                nBytes = compactBytes();
            } else {
                nBytes = nBytes2;
            }
        }
        if (nChars > 0 && chars[nChars - 1] == '\n' && (nChars = nChars - 1) > 0 && chars[nChars - 1] == '\r') {
            nChars--;
        }
        if (sb.length() != 0) {
            z = false;
        }
        if (z) {
            return new String(chars, 0, nChars);
        }
        sb.append(chars, 0, nChars);
        String result = sb.toString();
        Intrinsics.checkNotNullExpressionValue(result, "toString(...)");
        if (sb.length() > 32) {
            trimStringBuilder();
        }
        sb.setLength(0);
        return result;
    }

    private final int decode(boolean endOfInput) throws CharacterCodingException {
        while (true) {
            CharsetDecoder charsetDecoder = decoder;
            if (charsetDecoder == null) {
                Intrinsics.throwUninitializedPropertyAccessException("decoder");
                charsetDecoder = null;
            }
            CoderResult coderResult = charsetDecoder.decode(byteBuf, charBuf, endOfInput);
            Intrinsics.checkNotNullExpressionValue(coderResult, "decode(...)");
            if (coderResult.isError()) {
                resetAll();
                coderResult.throwException();
            }
            int nChars = charBuf.position();
            if (!coderResult.isOverflow()) {
                return nChars;
            }
            sb.append(chars, 0, nChars - 1);
            charBuf.position(0);
            charBuf.limit(32);
            charBuf.put(chars[nChars - 1]);
        }
    }

    private final int compactBytes() {
        ByteBuffer $this$compactBytes_u24lambda_u241 = byteBuf;
        $this$compactBytes_u24lambda_u241.compact();
        int iPosition = $this$compactBytes_u24lambda_u241.position();
        $this$compactBytes_u24lambda_u241.position(0);
        return iPosition;
    }

    private final int decodeEndOfInput(int nBytes, int nChars) throws CharacterCodingException {
        byteBuf.limit(nBytes);
        charBuf.position(nChars);
        int iDecode = decode(true);
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        byteBuf.position(0);
        return iDecode;
    }

    private final void updateCharset(Charset charset) {
        decoder = charset.newDecoder();
        byteBuf.clear();
        charBuf.clear();
        byteBuf.put((byte) 10);
        byteBuf.flip();
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            charsetDecoder = null;
        }
        boolean z = false;
        charsetDecoder.decode(byteBuf, charBuf, false);
        if (charBuf.position() == 1 && charBuf.get(0) == '\n') {
            z = true;
        }
        directEOL = z;
        resetAll();
    }

    private final void resetAll() {
        CharsetDecoder charsetDecoder = decoder;
        if (charsetDecoder == null) {
            Intrinsics.throwUninitializedPropertyAccessException("decoder");
            charsetDecoder = null;
        }
        charsetDecoder.reset();
        byteBuf.position(0);
        sb.setLength(0);
    }

    private final void trimStringBuilder() {
        sb.setLength(32);
        sb.trimToSize();
    }
}
