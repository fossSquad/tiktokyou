package ni.shikatu.okhttp3;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.ExceptionsKt;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.jvm.JvmStatic;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.InlineMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.Internal;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Buffer;
import ni.shikatu.okio.BufferedSource;
import ni.shikatu.okio.ByteString;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\b&\u0018\u0000 \"2\u00020\u0001:\u0002!\"B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&J\b\u0010\b\u001a\u00020\tH&J\u0006\u0010\n\u001a\u00020\u000bJ\b\u0010\f\u001a\u00020\rH&J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011JD\u0010\u0012\u001a\u0002H\u0013\"\b\b\u0000\u0010\u0013*\u00020\u0014*\u00020\u00002\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u0002H\u00130\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u0002H\u0013\u0012\u0004\u0012\u00020\u00180\u0016H\u0082\b¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0005J\u0006\u0010\u001b\u001a\u00020\u001cJ\b\u0010\u001d\u001a\u00020\u001eH\u0002J\b\u0010\u001f\u001a\u00020 H\u0016R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lni/shikatu/okhttp3/ResponseBody;", "Ljava/io/Closeable;", "<init>", "()V", "reader", "Ljava/io/Reader;", "contentType", "Lni/shikatu/okhttp3/MediaType;", "contentLength", _UrlKt.FRAGMENT_ENCODE_SET, "byteStream", "Ljava/io/InputStream;", "source", "Lni/shikatu/okio/BufferedSource;", "bytes", _UrlKt.FRAGMENT_ENCODE_SET, "byteString", "Lni/shikatu/okio/ByteString;", "consumeSource", "T", _UrlKt.FRAGMENT_ENCODE_SET, "consumer", "Lni/shikatu/kotlin/Function1;", "sizeMapper", _UrlKt.FRAGMENT_ENCODE_SET, "(Lokhttp3/ResponseBody;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "charStream", "string", _UrlKt.FRAGMENT_ENCODE_SET, "charset", "Ljava/nio/charset/Charset;", "close", _UrlKt.FRAGMENT_ENCODE_SET, "BomAwareReader", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class ResponseBody implements Closeable {
    public static final Companion Companion = new Companion(null);
    public static final ResponseBody EMPTY = Companion.create$default(Companion, ByteString.EMPTY, (MediaType) null, 1, (Object) null);
    private Reader reader;

    public abstract long contentLength();

    public abstract MediaType contentType();

    public abstract BufferedSource source();

    public final InputStream byteStream() {
        return source().inputStream();
    }

    public final byte[] bytes() throws Throwable {
        byte[] byteArray;
        long contentLength$iv = contentLength();
        if (contentLength$iv > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength$iv);
        }
        Closeable $this$use$iv$iv = source();
        Throwable thrown$iv$iv = null;
        try {
            BufferedSource p0 = (BufferedSource) $this$use$iv$iv;
            byteArray = p0.readByteArray();
            if ($this$use$iv$iv != null) {
                try {
                    $this$use$iv$iv.close();
                } catch (Throwable t$iv$iv) {
                    thrown$iv$iv = t$iv$iv;
                }
            }
        } catch (Throwable t$iv$iv2) {
            thrown$iv$iv = t$iv$iv2;
            if ($this$use$iv$iv != null) {
                try {
                    $this$use$iv$iv.close();
                } catch (Throwable t$iv$iv3) {
                    ExceptionsKt.addSuppressed(thrown$iv$iv, t$iv$iv3);
                }
            }
            byteArray = null;
        }
        if (thrown$iv$iv != null) {
            throw thrown$iv$iv;
        }
        byte[] it = byteArray;
        int size$iv = it.length;
        if (contentLength$iv == -1 || contentLength$iv == size$iv) {
            return byteArray;
        }
        throw new IOException("Content-Length (" + contentLength$iv + ") and stream length (" + size$iv + ") disagree");
    }

    public final ByteString byteString() throws Throwable {
        ByteString byteString;
        long contentLength$iv = contentLength();
        if (contentLength$iv > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + contentLength$iv);
        }
        Closeable $this$use$iv$iv = source();
        Throwable thrown$iv$iv = null;
        try {
            BufferedSource p0 = (BufferedSource) $this$use$iv$iv;
            byteString = p0.readByteString();
            if ($this$use$iv$iv != null) {
                try {
                    $this$use$iv$iv.close();
                } catch (Throwable t$iv$iv) {
                    thrown$iv$iv = t$iv$iv;
                }
            }
        } catch (Throwable t$iv$iv2) {
            thrown$iv$iv = t$iv$iv2;
            if ($this$use$iv$iv != null) {
                try {
                    $this$use$iv$iv.close();
                } catch (Throwable t$iv$iv3) {
                    ExceptionsKt.addSuppressed(thrown$iv$iv, t$iv$iv3);
                }
            }
            byteString = null;
        }
        if (thrown$iv$iv != null) {
            throw thrown$iv$iv;
        }
        ByteString it = byteString;
        int size$iv = it.size();
        if (contentLength$iv == -1 || contentLength$iv == size$iv) {
            return byteString;
        }
        throw new IOException("Content-Length (" + contentLength$iv + ") and stream length (" + size$iv + ") disagree");
    }

    private final <T> T consumeSource(ResponseBody responseBody, Function1<? super BufferedSource, ? extends T> function1, Function1<? super T, Integer> function2) throws Throwable {
        T tInvoke;
        long jContentLength = responseBody.contentLength();
        if (jContentLength > 2147483647L) {
            throw new IOException("Cannot buffer entire body for content length: " + jContentLength);
        }
        BufferedSource bufferedSourceSource = responseBody.source();
        Throwable th = null;
        try {
            tInvoke = function1.invoke(bufferedSourceSource);
            InlineMarker.finallyStart(1);
            if (bufferedSourceSource != null) {
                try {
                    bufferedSourceSource.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            }
            InlineMarker.finallyEnd(1);
        } catch (Throwable th3) {
            th = th3;
            InlineMarker.finallyStart(1);
            if (bufferedSourceSource != null) {
                try {
                    bufferedSourceSource.close();
                } catch (Throwable th4) {
                    ExceptionsKt.addSuppressed(th, th4);
                }
            }
            InlineMarker.finallyEnd(1);
            tInvoke = (Object) null;
        }
        if (th == null) {
            int iIntValue = function2.invoke(tInvoke).intValue();
            if (jContentLength == -1 || jContentLength == iIntValue) {
                return tInvoke;
            }
            throw new IOException("Content-Length (" + jContentLength + ") and stream length (" + iIntValue + ") disagree");
        }
        throw th;
    }

    public final Reader charStream() {
        Reader reader = this.reader;
        if (reader == null) {
            BomAwareReader it = new BomAwareReader(source(), charset());
            this.reader = it;
            return it;
        }
        return reader;
    }

    public final String string() throws Throwable {
        String string;
        Closeable $this$use$iv = source();
        Throwable thrown$iv = null;
        try {
            BufferedSource source = (BufferedSource) $this$use$iv;
            string = source.readString(_UtilJvmKt.readBomAsCharset(source, charset()));
            if ($this$use$iv != null) {
                try {
                    $this$use$iv.close();
                } catch (Throwable t$iv) {
                    thrown$iv = t$iv;
                }
            }
        } catch (Throwable t$iv2) {
            thrown$iv = t$iv2;
            if ($this$use$iv != null) {
                try {
                    $this$use$iv.close();
                } catch (Throwable t$iv3) {
                    ExceptionsKt.addSuppressed(thrown$iv, t$iv3);
                }
            }
            string = null;
        }
        if (thrown$iv == null) {
            return string;
        }
        throw thrown$iv;
    }

    private final Charset charset() {
        return Internal.charsetOrUtf8(contentType());
    }

    @Override
    public void close() {
        _UtilCommonKt.closeQuietly(source());
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0019\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0016J\b\u0010\u0011\u001a\u00020\u0012H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lni/shikatu/okhttp3/ResponseBody$BomAwareReader;", "Ljava/io/Reader;", "source", "Lni/shikatu/okio/BufferedSource;", "charset", "Ljava/nio/charset/Charset;", "<init>", "(Lokio/BufferedSource;Ljava/nio/charset/Charset;)V", "closed", _UrlKt.FRAGMENT_ENCODE_SET, "delegate", "read", _UrlKt.FRAGMENT_ENCODE_SET, "cbuf", _UrlKt.FRAGMENT_ENCODE_SET, "off", "len", "close", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class BomAwareReader extends Reader {
        private final Charset charset;
        private boolean closed;
        private Reader delegate;
        private final BufferedSource source;

        public BomAwareReader(BufferedSource source, Charset charset) {
            Intrinsics.checkNotNullParameter(source, "source");
            Intrinsics.checkNotNullParameter(charset, "charset");
            this.source = source;
            this.charset = charset;
        }

        @Override
        public int read(char[] cbuf, int off, int len) throws IOException {
            Intrinsics.checkNotNullParameter(cbuf, "cbuf");
            if (this.closed) {
                throw new IOException("Stream closed");
            }
            InputStreamReader finalDelegate = this.delegate;
            if (finalDelegate == null) {
                InputStreamReader it = new InputStreamReader(this.source.inputStream(), _UtilJvmKt.readBomAsCharset(this.source, this.charset));
                this.delegate = it;
                finalDelegate = it;
            }
            return finalDelegate.read(cbuf, off, len);
        }

        @Override
        public void close() throws IOException {
            this.closed = true;
            Reader reader = this.delegate;
            if (reader == null) {
                BomAwareReader $this$close_u24lambda_u240 = this;
                $this$close_u24lambda_u240.source.close();
            } else {
                reader.close();
            }
        }
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0006\u001a\u00020\u0005*\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\b\nJ\u001d\u0010\u0006\u001a\u00020\u0005*\u00020\u000b2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\b\nJ\u001d\u0010\u0006\u001a\u00020\u0005*\u00020\f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\b\nJ'\u0010\r\u001a\u00020\u0005*\u00020\u000e2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\b\nJ\u001a\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u0007H\u0007J\u001a\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\u000bH\u0007J\u001a\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0011\u001a\u00020\fH\u0007J\"\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000eH\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lni/shikatu/okhttp3/ResponseBody$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "EMPTY", "Lni/shikatu/okhttp3/ResponseBody;", "toResponseBody", _UrlKt.FRAGMENT_ENCODE_SET, "contentType", "Lni/shikatu/okhttp3/MediaType;", "create", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okio/ByteString;", "asResponseBody", "Lni/shikatu/okio/BufferedSource;", "contentLength", _UrlKt.FRAGMENT_ENCODE_SET, "content", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static  ResponseBody create$default(Companion companion, String str, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        @JvmStatic
        public final ResponseBody create(String $this$toResponseBody, MediaType contentType) {
            Intrinsics.checkNotNullParameter($this$toResponseBody, "<this>");
            Pair<Charset, MediaType> pairChooseCharset = Internal.chooseCharset(contentType);
            Charset charset = pairChooseCharset.component1();
            MediaType finalContentType = pairChooseCharset.component2();
            Buffer buffer = new Buffer().writeString($this$toResponseBody, charset);
            return create(buffer, finalContentType, buffer.size());
        }

        public static  ResponseBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(bArr, mediaType);
        }

        @JvmStatic
        public final ResponseBody create(byte[] $this$toResponseBody, MediaType contentType) {
            Intrinsics.checkNotNullParameter($this$toResponseBody, "<this>");
            return create(new Buffer().write($this$toResponseBody), contentType, $this$toResponseBody.length);
        }

        public static  ResponseBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        @JvmStatic
        public final ResponseBody create(ByteString $this$toResponseBody, MediaType contentType) {
            Intrinsics.checkNotNullParameter($this$toResponseBody, "<this>");
            return create(new Buffer().write($this$toResponseBody), contentType, $this$toResponseBody.size());
        }

        public static  ResponseBody create$default(Companion companion, BufferedSource bufferedSource, MediaType mediaType, long j, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            if ((i & 2) != 0) {
                j = -1;
            }
            return companion.create(bufferedSource, mediaType, j);
        }

        @JvmStatic
        public final ResponseBody create(final BufferedSource $this$asResponseBody, final MediaType contentType, final long contentLength) {
            Intrinsics.checkNotNullParameter($this$asResponseBody, "<this>");
            return new ResponseBody() {
                @Override
                public MediaType contentType() {
                    return contentType;
                }

                @Override
                public long contentLength() {
                    return contentLength;
                }

                @Override
                public BufferedSource source() {
                    return $this$asResponseBody;
                }
            };
        }

        @JvmStatic
        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"ni.shikatu.okhttp3.ResponseBody.Companion.toResponseBody"}))
        public final ResponseBody create(MediaType contentType, String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create(content, contentType);
        }

        @JvmStatic
        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"ni.shikatu.okhttp3.ResponseBody.Companion.toResponseBody"}))
        public final ResponseBody create(MediaType contentType, byte[] content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create(content, contentType);
        }

        @JvmStatic
        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"ni.shikatu.okhttp3.ResponseBody.Companion.toResponseBody"}))
        public final ResponseBody create(MediaType contentType, ByteString content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create(content, contentType);
        }

        @JvmStatic
        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.asResponseBody(contentType, contentLength)", imports = {"ni.shikatu.okhttp3.ResponseBody.Companion.asResponseBody"}))
        public final ResponseBody create(MediaType contentType, long contentLength, BufferedSource content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create(content, contentType, contentLength);
        }
    }

    @JvmStatic
    public static final ResponseBody create(String $this$create, MediaType contentType) {
        return Companion.create($this$create, contentType);
    }

    @JvmStatic
    public static final ResponseBody create(byte[] $this$create, MediaType contentType) {
        return Companion.create($this$create, contentType);
    }

    @JvmStatic
    public static final ResponseBody create(ByteString $this$create, MediaType contentType) {
        return Companion.create($this$create, contentType);
    }

    @JvmStatic
    public static final ResponseBody create(BufferedSource $this$create, MediaType contentType, long contentLength) {
        return Companion.create($this$create, contentType, contentLength);
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"ni.shikatu.okhttp3.ResponseBody.Companion.toResponseBody"}))
    public static final ResponseBody create(MediaType contentType, String content) {
        return Companion.create(contentType, content);
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"ni.shikatu.okhttp3.ResponseBody.Companion.toResponseBody"}))
    public static final ResponseBody create(MediaType contentType, byte[] content) {
        return Companion.create(contentType, content);
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toResponseBody(contentType)", imports = {"ni.shikatu.okhttp3.ResponseBody.Companion.toResponseBody"}))
    public static final ResponseBody create(MediaType contentType, ByteString content) {
        return Companion.create(contentType, content);
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.asResponseBody(contentType, contentLength)", imports = {"ni.shikatu.okhttp3.ResponseBody.Companion.asResponseBody"}))
    public static final ResponseBody create(MediaType contentType, long contentLength, BufferedSource content) {
        return Companion.create(contentType, contentLength, content);
    }
}
