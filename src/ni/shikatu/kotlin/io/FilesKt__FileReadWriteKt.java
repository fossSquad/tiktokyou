package ni.shikatu.kotlin.io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.collections.ArraysKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.InlineMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlin.sequences.Sequence;
import ni.shikatu.kotlin.text.Charsets;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0090\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\u0002\b\u0005\u001a&\u0010\u0006\u001a\u00020\u0007*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tH\u0087\u0088\u0004b\u0002\b\u0005\u001a\u001c\u0010\n\u001a\u00020\u000b*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\u0002\b\u0005\u001a&\u0010\f\u001a\u00020\r*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\tH\u0087\u0088\u0004b\u0002\b\u0005\u001a\u001c\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0087\u0088\u0004b\u0002\b\u0005\u001a\u000e\u0010\u0010\u001a\u00020\u0011*\u00020\u0002H\u0086\u0080\u0004\u001a\u0016\u0010\u0012\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0086\u0080\u0004\u001a\u0016\u0010\u0015\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0011H\u0086\u0080\u0004\u001a\u0018\u0010\u0016\u001a\u00020\u0017*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086\u0080\u0004\u001a \u0010\u0018\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086\u0080\u0004\u001a \u0010\u001a\u001a\u00020\u0013*\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u00172\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086\u0080\u0004\u001a\u001e\u0010\u001b\u001a\u00020\u0013*\u00020\u001c2\u0006\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u0003\u001a\u00020\u0004H\u0080\u0080\u0004\u001a\u0016\u0010\u001d\u001a\n \u001f*\u0004\u0018\u00010\u001e0\u001e*\u00020\u0004H\u0080\u0080\u0004\u001a\u001a\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\t2\u0006\u0010#\u001a\u00020\u001eH\u0080\u0080\u0004\u001aF\u0010$\u001a\u00020\u0013*\u00020\u000226\u0010%\u001a2\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\t¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00130&H\u0086\u0080\u0004\u001aN\u0010$\u001a\u00020\u0013*\u00020\u00022\u0006\u0010+\u001a\u00020\t26\u0010%\u001a2\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0013\u0012\u00110\t¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(*\u0012\u0004\u0012\u00020\u00130&H\u0086\u0080\u0004\u001a;\u0010,\u001a\u00020\u0013*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042!\u0010%\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b(.\u0012\u0004\u0012\u00020\u00130-H\u0086\u0080\u0004\u001a\u0012\u0010/\u001a\u000200*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0005\u001a\u0012\u00101\u001a\u000202*\u00020\u0002H\u0087\u0088\u0004b\u0002\b\u0005\u001a\u001e\u00103\u001a\b\u0012\u0004\u0012\u00020\u001704*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u0004H\u0086\u0080\u0004\u001aM\u00105\u001a\u0002H6\"\u0004\b\u0000\u00106*\u00020\u00022\b\b\u0002\u0010\u0003\u001a\u00020\u00042\u0018\u00107\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001708\u0012\u0004\u0012\u0002H60-H\u0086\u0088\u0004ø\u0001\u0000\u0082\u0002\n\n\b\b\u0001\u0012\u0002\u0010\u0002 \u0001¢\u0006\u0002\u00109\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006:"}, d2 = {"reader", "Ljava/io/InputStreamReader;", "Ljava/io/File;", "charset", "Ljava/nio/charset/Charset;", "Lni/shikatu/kotlin/internal/InlineOnly;", "bufferedReader", "Ljava/io/BufferedReader;", "bufferSize", _UrlKt.FRAGMENT_ENCODE_SET, "writer", "Ljava/io/OutputStreamWriter;", "bufferedWriter", "Ljava/io/BufferedWriter;", "printWriter", "Ljava/io/PrintWriter;", "readBytes", _UrlKt.FRAGMENT_ENCODE_SET, "writeBytes", _UrlKt.FRAGMENT_ENCODE_SET, "array", "appendBytes", "readText", _UrlKt.FRAGMENT_ENCODE_SET, "writeText", "text", "appendText", "writeTextImpl", "Ljava/io/OutputStream;", "newReplaceEncoder", "Ljava/nio/charset/CharsetEncoder;", "ni.shikatu.kotlin.jvm.PlatformType", "byteBufferForEncoding", "Ljava/nio/ByteBuffer;", "chunkSize", "encoder", "forEachBlock", "action", "Lni/shikatu/kotlin/Function2;", "Lni/shikatu/kotlin/ParameterName;", "name", "buffer", "bytesRead", "blockSize", "forEachLine", "Lni/shikatu/kotlin/Function1;", "line", "inputStream", "Ljava/io/FileInputStream;", "outputStream", "Ljava/io/FileOutputStream;", "readLines", _UrlKt.FRAGMENT_ENCODE_SET, "useLines", "T", "block", "Lni/shikatu/kotlin/sequences/Sequence;", "(Ljava/io/File;Ljava/nio/charset/Charset;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "ni.shikatu.kotlin-stdlib"}, k = 5, mv = {2, 4, 0}, xi = 49, xs = "ni/shikatu/kotlin/io/FilesKt")
public class FilesKt__FileReadWriteKt extends FilesKt__FilePathComponentsKt {
    static  InputStreamReader reader$default(File $this$reader_u24default, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$reader_u24default, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new InputStreamReader(new FileInputStream($this$reader_u24default), charset);
    }

    private static final InputStreamReader reader(File $this$reader, Charset charset) {
        Intrinsics.checkNotNullParameter($this$reader, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new InputStreamReader(new FileInputStream($this$reader), charset);
    }

    static  BufferedReader bufferedReader$default(File $this$bufferedReader_u24default, Charset charset, int bufferSize, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i & 2) != 0) {
            bufferSize = 8192;
        }
        Intrinsics.checkNotNullParameter($this$bufferedReader_u24default, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Reader inputStreamReader = new InputStreamReader(new FileInputStream($this$bufferedReader_u24default), charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, bufferSize);
    }

    private static final BufferedReader bufferedReader(File $this$bufferedReader, Charset charset, int bufferSize) {
        Intrinsics.checkNotNullParameter($this$bufferedReader, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Reader inputStreamReader = new InputStreamReader(new FileInputStream($this$bufferedReader), charset);
        return inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, bufferSize);
    }

    static  OutputStreamWriter writer$default(File $this$writer_u24default, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$writer_u24default, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new OutputStreamWriter(new FileOutputStream($this$writer_u24default), charset);
    }

    private static final OutputStreamWriter writer(File $this$writer, Charset charset) {
        Intrinsics.checkNotNullParameter($this$writer, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        return new OutputStreamWriter(new FileOutputStream($this$writer), charset);
    }

    static  BufferedWriter bufferedWriter$default(File $this$bufferedWriter_u24default, Charset charset, int bufferSize, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        if ((i & 2) != 0) {
            bufferSize = 8192;
        }
        Intrinsics.checkNotNullParameter($this$bufferedWriter_u24default, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream($this$bufferedWriter_u24default), charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, bufferSize);
    }

    private static final BufferedWriter bufferedWriter(File $this$bufferedWriter, Charset charset, int bufferSize) {
        Intrinsics.checkNotNullParameter($this$bufferedWriter, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream($this$bufferedWriter), charset);
        return outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, bufferSize);
    }

    static  PrintWriter printWriter$default(File $this$printWriter_u24default, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$printWriter_u24default, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream($this$printWriter_u24default), charset);
        return new PrintWriter(outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192));
    }

    private static final PrintWriter printWriter(File $this$printWriter, Charset charset) {
        Intrinsics.checkNotNullParameter($this$printWriter, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Writer outputStreamWriter = new OutputStreamWriter(new FileOutputStream($this$printWriter), charset);
        return new PrintWriter(outputStreamWriter instanceof BufferedWriter ? (BufferedWriter) outputStreamWriter : new BufferedWriter(outputStreamWriter, 8192));
    }

    public static final byte[] readBytes(File $this$readBytes) throws IOException {
        Intrinsics.checkNotNullParameter($this$readBytes, "<this>");
        FileInputStream fileInputStream = new FileInputStream($this$readBytes);
        try {
            FileInputStream input = fileInputStream;
            int offset = 0;
            long length = $this$readBytes.length();
            if (length > 2147483647L) {
                throw new OutOfMemoryError("File " + $this$readBytes + " is too big (" + length + " bytes) to fit in memory.");
            }
            int remaining = (int) length;
            byte[] result = new byte[remaining];
            while (remaining > 0) {
                int read = input.read(result, offset, remaining);
                if (read < 0) {
                    break;
                }
                remaining -= read;
                offset += read;
            }
            if (remaining > 0) {
                byte[] bArrCopyOf = Arrays.copyOf(result, offset);
                Intrinsics.checkNotNullExpressionValue(bArrCopyOf, "copyOf(...)");
                result = bArrCopyOf;
            } else {
                int extraByte = input.read();
                if (extraByte != -1) {
                    ExposingBufferByteArrayOutputStream extra = new ExposingBufferByteArrayOutputStream(8193);
                    extra.write(extraByte);
                    ByteStreamsKt.copyTo$default(input, extra, 0, 2, null);
                    int resultingSize = result.length + extra.size();
                    if (resultingSize < 0) {
                        throw new OutOfMemoryError("File " + $this$readBytes + " is too big to fit in memory.");
                    }
                    byte[] buffer = extra.getBuffer();
                    byte[] bArrCopyOf2 = Arrays.copyOf(result, resultingSize);
                    Intrinsics.checkNotNullExpressionValue(bArrCopyOf2, "copyOf(...)");
                    result = ArraysKt.copyInto(buffer, bArrCopyOf2, result.length, 0, extra.size());
                }
            }
            CloseableKt.closeFinally(fileInputStream, null);
            return result;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static final void writeBytes(File $this$writeBytes, byte[] array) throws IOException {
        Intrinsics.checkNotNullParameter($this$writeBytes, "<this>");
        Intrinsics.checkNotNullParameter(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream($this$writeBytes);
        try {
            FileOutputStream it = fileOutputStream;
            it.write(array);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileOutputStream, th);
                throw th2;
            }
        }
    }

    public static final void appendBytes(File $this$appendBytes, byte[] array) throws IOException {
        Intrinsics.checkNotNullParameter($this$appendBytes, "<this>");
        Intrinsics.checkNotNullParameter(array, "array");
        FileOutputStream fileOutputStream = new FileOutputStream($this$appendBytes, true);
        try {
            FileOutputStream it = fileOutputStream;
            it.write(array);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileOutputStream, th);
                throw th2;
            }
        }
    }

    public static final String readText(File $this$readText, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter($this$readText, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream($this$readText), charset);
        try {
            InputStreamReader it = inputStreamReader;
            String text = TextStreamsKt.readText(it);
            CloseableKt.closeFinally(inputStreamReader, null);
            return text;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(inputStreamReader, th);
                throw th2;
            }
        }
    }

    public static  String readText$default(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return FilesKt.readText(file, charset);
    }

    public static  void writeText$default(File file, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        FilesKt.writeText(file, str, charset);
    }

    public static final void writeText(File $this$writeText, String text, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter($this$writeText, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream($this$writeText);
        try {
            FileOutputStream it = fileOutputStream;
            FilesKt.writeTextImpl(it, text, charset);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileOutputStream, th);
                throw th2;
            }
        }
    }

    public static  void appendText$default(File file, String str, Charset charset, int i, Object obj) {
        if ((i & 2) != 0) {
            charset = Charsets.UTF_8;
        }
        FilesKt.appendText(file, str, charset);
    }

    public static final void appendText(File $this$appendText, String text, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter($this$appendText, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        FileOutputStream fileOutputStream = new FileOutputStream($this$appendText, true);
        try {
            FileOutputStream it = fileOutputStream;
            FilesKt.writeTextImpl(it, text, charset);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(fileOutputStream, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileOutputStream, th);
                throw th2;
            }
        }
    }

    public static final void writeTextImpl(OutputStream $this$writeTextImpl, String text, Charset charset) throws IOException {
        Intrinsics.checkNotNullParameter($this$writeTextImpl, "<this>");
        Intrinsics.checkNotNullParameter(text, "text");
        Intrinsics.checkNotNullParameter(charset, "charset");
        if (text.length() < 8192 * 2) {
            byte[] bytes = text.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            $this$writeTextImpl.write(bytes);
            return;
        }
        CharsetEncoder encoder = FilesKt.newReplaceEncoder(charset);
        CharBuffer charBuffer = CharBuffer.allocate(8192);
        Intrinsics.checkNotNull(encoder);
        ByteBuffer byteBuffer = FilesKt.byteBufferForEncoding(8192, encoder);
        int startIndex = 0;
        int leftover = 0;
        while (startIndex < text.length()) {
            int copyLength = Math.min(8192 - leftover, text.length() - startIndex);
            int endIndex = startIndex + copyLength;
            char[] cArrArray = charBuffer.array();
            Intrinsics.checkNotNullExpressionValue(cArrArray, "array(...)");
            text.getChars(startIndex, endIndex, cArrArray, leftover);
            charBuffer.limit(copyLength + leftover);
            CoderResult it = encoder.encode(charBuffer, byteBuffer, endIndex == text.length());
            if (!it.isUnderflow()) {
                throw new IllegalStateException("Check failed.");
            }
            $this$writeTextImpl.write(byteBuffer.array(), 0, byteBuffer.position());
            if (charBuffer.position() != charBuffer.limit()) {
                charBuffer.put(0, charBuffer.get());
                leftover = 1;
            } else {
                leftover = 0;
            }
            charBuffer.clear();
            byteBuffer.clear();
            startIndex = endIndex;
        }
    }

    public static final CharsetEncoder newReplaceEncoder(Charset $this$newReplaceEncoder) {
        Intrinsics.checkNotNullParameter($this$newReplaceEncoder, "<this>");
        return $this$newReplaceEncoder.newEncoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
    }

    public static final ByteBuffer byteBufferForEncoding(int chunkSize, CharsetEncoder encoder) {
        Intrinsics.checkNotNullParameter(encoder, "encoder");
        int maxBytesPerChar = (int) Math.ceil(encoder.maxBytesPerChar());
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(chunkSize * maxBytesPerChar);
        Intrinsics.checkNotNullExpressionValue(byteBufferAllocate, "allocate(...)");
        return byteBufferAllocate;
    }

    public static final void forEachBlock(File $this$forEachBlock, Function2<? super byte[], ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter($this$forEachBlock, "<this>");
        Intrinsics.checkNotNullParameter(function2, "action");
        FilesKt.forEachBlock($this$forEachBlock, 4096, function2);
    }

    public static final void forEachBlock(File $this$forEachBlock, int blockSize, Function2<? super byte[], ? super Integer, Unit> function2) throws IOException {
        Intrinsics.checkNotNullParameter($this$forEachBlock, "<this>");
        Intrinsics.checkNotNullParameter(function2, "action");
        ?? r0 = new byte[RangesKt.coerceAtLeast(blockSize, ConstantsKt.MINIMUM_BLOCK_SIZE)];
        FileInputStream fileInputStream = new FileInputStream($this$forEachBlock);
        try {
            FileInputStream fileInputStream2 = fileInputStream;
            while (true) {
                int size = fileInputStream2.read(r0);
                if (size <= 0) {
                    Unit unit = Unit.INSTANCE;
                    CloseableKt.closeFinally(fileInputStream, null);
                    return;
                }
                function2.invoke(r0, Integer.valueOf(size));
            }
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(fileInputStream, th);
                throw th2;
            }
        }
    }

    public static  void forEachLine$default(File file, Charset charset, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        FilesKt.forEachLine(file, charset, function1);
    }

    public static final void forEachLine(File $this$forEachLine, Charset charset, Function1<? super String, Unit> function1) throws IOException {
        Intrinsics.checkNotNullParameter($this$forEachLine, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(function1, "action");
        TextStreamsKt.forEachLine(new BufferedReader(new InputStreamReader(new FileInputStream($this$forEachLine), charset)), function1);
    }

    private static final FileInputStream inputStream(File $this$inputStream) {
        Intrinsics.checkNotNullParameter($this$inputStream, "<this>");
        return new FileInputStream($this$inputStream);
    }

    private static final FileOutputStream outputStream(File $this$outputStream) {
        Intrinsics.checkNotNullParameter($this$outputStream, "<this>");
        return new FileOutputStream($this$outputStream);
    }

    public static  List readLines$default(File file, Charset charset, int i, Object obj) {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        return FilesKt.readLines(file, charset);
    }

    public static final List<String> readLines(File $this$readLines, Charset charset) {
        Intrinsics.checkNotNullParameter($this$readLines, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        final ArrayList result = new ArrayList();
        FilesKt.forEachLine($this$readLines, charset, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return FilesKt__FileReadWriteKt.readLines$lambda$0$FilesKt__FileReadWriteKt(result, (String) obj);
            }
        });
        return result;
    }

    public static final Unit readLines$lambda$0$FilesKt__FileReadWriteKt(ArrayList $result, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        $result.add(it);
        return Unit.INSTANCE;
    }

    public static  Object useLines$default(File $this$useLines_u24default, Charset charset, Function1 block, int i, Object obj) throws IOException {
        if ((i & 1) != 0) {
            charset = Charsets.UTF_8;
        }
        Intrinsics.checkNotNullParameter($this$useLines_u24default, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(block, "block");
        Reader inputStreamReader = new InputStreamReader(new FileInputStream($this$useLines_u24default), charset);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            BufferedReader it = bufferedReader;
            Object objInvoke = block.invoke(TextStreamsKt.lineSequence(it));
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(bufferedReader, null);
            InlineMarker.finallyEnd(1);
            return objInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                CloseableKt.closeFinally(bufferedReader, th);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
    }

    public static final <T> T useLines(File $this$useLines, Charset charset, Function1<? super Sequence<String>, ? extends T> function1) throws IOException {
        Intrinsics.checkNotNullParameter($this$useLines, "<this>");
        Intrinsics.checkNotNullParameter(charset, "charset");
        Intrinsics.checkNotNullParameter(function1, "block");
        Reader inputStreamReader = new InputStreamReader(new FileInputStream($this$useLines), charset);
        BufferedReader bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
        try {
            BufferedReader it = bufferedReader;
            T tInvoke = function1.invoke(TextStreamsKt.lineSequence(it));
            InlineMarker.finallyStart(1);
            CloseableKt.closeFinally(bufferedReader, null);
            InlineMarker.finallyEnd(1);
            return tInvoke;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                InlineMarker.finallyStart(1);
                CloseableKt.closeFinally(bufferedReader, th);
                InlineMarker.finallyEnd(1);
                throw th2;
            }
        }
    }
}
