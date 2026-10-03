package ni.shikatu.okhttp3;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Pair;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.io.CloseableKt;
import ni.shikatu.kotlin.jvm.JvmStatic;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.Internal;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.BufferedSink;
import ni.shikatu.okio.ByteString;
import ni.shikatu.okio.FileSystem;
import ni.shikatu.okio.HashingSink;
import ni.shikatu.okio.Okio;
import ni.shikatu.okio.Path;
import ni.shikatu.okio.Source;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\n\u0010\u0004\u001a\u0004\u0018\u00010\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH&J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\rH\u0016J\u0006\u0010\u000f\u001a\u00020\u0010¨\u0006\u0012"}, d2 = {"Lni/shikatu/okhttp3/RequestBody;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "contentType", "Lni/shikatu/okhttp3/MediaType;", "contentLength", _UrlKt.FRAGMENT_ENCODE_SET, "writeTo", _UrlKt.FRAGMENT_ENCODE_SET, "sink", "Lni/shikatu/okio/BufferedSink;", "isDuplex", _UrlKt.FRAGMENT_ENCODE_SET, "isOneShot", "sha256", "Lni/shikatu/okio/ByteString;", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class RequestBody {
    public static final Companion Companion = new Companion(null);
    public static final RequestBody EMPTY = Companion.create$default(Companion, ByteString.EMPTY, (MediaType) null, 1, (Object) null);

    public abstract MediaType contentType();

    public abstract void writeTo(BufferedSink bufferedSink) throws IOException;

    public long contentLength() throws IOException {
        return -1L;
    }

    public boolean isDuplex() {
        return false;
    }

    public boolean isOneShot() {
        return false;
    }

    public final ByteString sha256() throws IOException {
        HashingSink hashingSink = HashingSink.Companion.sha256(Okio.blackhole());
        BufferedSink bufferedSinkBuffer = Okio.buffer(hashingSink);
        try {
            BufferedSink it = bufferedSinkBuffer;
            writeTo(it);
            Unit unit = Unit.INSTANCE;
            CloseableKt.closeFinally(bufferedSinkBuffer, null);
            return hashingSink.hash();
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                CloseableKt.closeFinally(bufferedSinkBuffer, th);
                throw th2;
            }
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0006\u001a\u00020\u0005*\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\b\nJ\u001d\u0010\u0006\u001a\u00020\u0005*\u00020\u000b2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\b\nJ\u001d\u0010\u0006\u001a\u00020\u0005*\u00020\f2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\b\nJ1\u0010\u0006\u001a\u00020\u0005*\u00020\r2\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007¢\u0006\u0002\b\nJ\u001d\u0010\u0011\u001a\u00020\u0005*\u00020\u00122\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\b\nJ%\u0010\u0011\u001a\u00020\u0005*\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\tH\u0007¢\u0006\u0002\b\nJ\u001a\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u0007H\u0007J\u001a\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\u000bH\u0007J.\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0016\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000fH\u0007J\u001a\u0010\n\u001a\u00020\u00052\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0017\u001a\u00020\u0012H\u0007R\u0010\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lni/shikatu/okhttp3/RequestBody$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "EMPTY", "Lni/shikatu/okhttp3/RequestBody;", "toRequestBody", _UrlKt.FRAGMENT_ENCODE_SET, "contentType", "Lni/shikatu/okhttp3/MediaType;", "create", "Lni/shikatu/okio/ByteString;", "Ljava/io/FileDescriptor;", _UrlKt.FRAGMENT_ENCODE_SET, "offset", _UrlKt.FRAGMENT_ENCODE_SET, "byteCount", "asRequestBody", "Ljava/io/File;", "Lni/shikatu/okio/Path;", "fileSystem", "Lni/shikatu/okio/FileSystem;", "content", "file", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"ni.shikatu.okhttp3.RequestBody.Companion.toRequestBody"}))
        public final RequestBody create(MediaType mediaType, byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "content");
            return create$default(this, mediaType, bArr, 0, 0, 12, (Object) null);
        }

        @JvmStatic
        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"ni.shikatu.okhttp3.RequestBody.Companion.toRequestBody"}))
        public final RequestBody create(MediaType mediaType, byte[] bArr, int i) {
            Intrinsics.checkNotNullParameter(bArr, "content");
            return create$default(this, mediaType, bArr, i, 0, 8, (Object) null);
        }

        @JvmStatic
        public final RequestBody create(byte[] bArr) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            return create$default(this, bArr, (MediaType) null, 0, 0, 7, (Object) null);
        }

        @JvmStatic
        public final RequestBody create(byte[] bArr, MediaType mediaType) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            return create$default(this, bArr, mediaType, 0, 0, 6, (Object) null);
        }

        @JvmStatic
        public final RequestBody create(byte[] bArr, MediaType mediaType, int i) {
            Intrinsics.checkNotNullParameter(bArr, "<this>");
            return create$default(this, bArr, mediaType, i, 0, 4, (Object) null);
        }

        private Companion() {
        }

        public static  RequestBody create$default(Companion companion, String str, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(str, mediaType);
        }

        @JvmStatic
        public final RequestBody create(String $this$toRequestBody, MediaType contentType) {
            Intrinsics.checkNotNullParameter($this$toRequestBody, "<this>");
            Pair<Charset, MediaType> pairChooseCharset = Internal.chooseCharset(contentType);
            Charset charset = pairChooseCharset.component1();
            MediaType finalContentType = pairChooseCharset.component2();
            byte[] bytes = $this$toRequestBody.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "getBytes(...)");
            return create(bytes, finalContentType, 0, bytes.length);
        }

        public static  RequestBody create$default(Companion companion, ByteString byteString, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(byteString, mediaType);
        }

        @JvmStatic
        public final RequestBody create(final ByteString $this$toRequestBody, final MediaType contentType) {
            Intrinsics.checkNotNullParameter($this$toRequestBody, "<this>");
            return new RequestBody() {
                @Override
                public MediaType contentType() {
                    return contentType;
                }

                @Override
                public long contentLength() {
                    return $this$toRequestBody.size();
                }

                @Override
                public void writeTo(BufferedSink sink) throws IOException {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    sink.write($this$toRequestBody);
                }
            };
        }

        public static  RequestBody create$default(Companion companion, FileDescriptor fileDescriptor, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(fileDescriptor, mediaType);
        }

        @JvmStatic
        public final RequestBody create(final FileDescriptor $this$toRequestBody, final MediaType contentType) {
            Intrinsics.checkNotNullParameter($this$toRequestBody, "<this>");
            return new RequestBody() {
                @Override
                public MediaType contentType() {
                    return contentType;
                }

                @Override
                public boolean isOneShot() {
                    return true;
                }

                @Override
                public void writeTo(BufferedSink sink) throws IOException {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    FileInputStream fileInputStream = new FileInputStream($this$toRequestBody);
                    try {
                        FileInputStream it = fileInputStream;
                        sink.getBuffer().writeAll(Okio.source(it));
                        CloseableKt.closeFinally(fileInputStream, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(fileInputStream, th);
                            throw th2;
                        }
                    }
                }
            };
        }

        public static  RequestBody create$default(Companion companion, byte[] bArr, MediaType mediaType, int i, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                mediaType = null;
            }
            if ((i3 & 2) != 0) {
                i = 0;
            }
            if ((i3 & 4) != 0) {
                i2 = bArr.length;
            }
            return companion.create(bArr, mediaType, i, i2);
        }

        @JvmStatic
        public final RequestBody create(final byte[] $this$toRequestBody, final MediaType contentType, final int offset, final int byteCount) {
            Intrinsics.checkNotNullParameter($this$toRequestBody, "<this>");
            _UtilCommonKt.checkOffsetAndCount($this$toRequestBody.length, offset, byteCount);
            return new RequestBody() {
                @Override
                public MediaType contentType() {
                    return contentType;
                }

                @Override
                public long contentLength() {
                    return byteCount;
                }

                @Override
                public void writeTo(BufferedSink sink) throws IOException {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    sink.write($this$toRequestBody, offset, byteCount);
                }
            };
        }

        public static  RequestBody create$default(Companion companion, File file, MediaType mediaType, int i, Object obj) {
            if ((i & 1) != 0) {
                mediaType = null;
            }
            return companion.create(file, mediaType);
        }

        @JvmStatic
        public final RequestBody create(final File $this$asRequestBody, final MediaType contentType) {
            Intrinsics.checkNotNullParameter($this$asRequestBody, "<this>");
            return new RequestBody() {
                @Override
                public MediaType contentType() {
                    return contentType;
                }

                @Override
                public long contentLength() {
                    return $this$asRequestBody.length();
                }

                @Override
                public void writeTo(BufferedSink sink) throws IOException {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    Source source = Okio.source($this$asRequestBody);
                    try {
                        Source source2 = source;
                        sink.writeAll(source2);
                        CloseableKt.closeFinally(source, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(source, th);
                            throw th2;
                        }
                    }
                }
            };
        }

        public static  RequestBody create$default(Companion companion, Path path, FileSystem fileSystem, MediaType mediaType, int i, Object obj) {
            if ((i & 2) != 0) {
                mediaType = null;
            }
            return companion.create(path, fileSystem, mediaType);
        }

        @JvmStatic
        public final RequestBody create(final Path $this$asRequestBody, final FileSystem fileSystem, final MediaType contentType) {
            Intrinsics.checkNotNullParameter($this$asRequestBody, "<this>");
            Intrinsics.checkNotNullParameter(fileSystem, "fileSystem");
            return new RequestBody() {
                @Override
                public MediaType contentType() {
                    return contentType;
                }

                @Override
                public long contentLength() {
                    Long size = fileSystem.metadata($this$asRequestBody).getSize();
                    if (size != null) {
                        return size.longValue();
                    }
                    return -1L;
                }

                @Override
                public void writeTo(BufferedSink sink) throws IOException {
                    Intrinsics.checkNotNullParameter(sink, "sink");
                    Source source = fileSystem.source($this$asRequestBody);
                    try {
                        Source source2 = source;
                        sink.writeAll(source2);
                        CloseableKt.closeFinally(source, null);
                    } catch (Throwable th) {
                        try {
                            throw th;
                        } catch (Throwable th2) {
                            CloseableKt.closeFinally(source, th);
                            throw th2;
                        }
                    }
                }
            };
        }

        @JvmStatic
        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"ni.shikatu.okhttp3.RequestBody.Companion.toRequestBody"}))
        public final RequestBody create(MediaType contentType, String content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create(content, contentType);
        }

        @JvmStatic
        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"ni.shikatu.okhttp3.RequestBody.Companion.toRequestBody"}))
        public final RequestBody create(MediaType contentType, ByteString content) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create(content, contentType);
        }

        public static  RequestBody create$default(Companion companion, MediaType mediaType, byte[] bArr, int i, int i2, int i3, Object obj) {
            if ((i3 & 4) != 0) {
                i = 0;
            }
            if ((i3 & 8) != 0) {
                i2 = bArr.length;
            }
            return companion.create(mediaType, bArr, i, i2);
        }

        @JvmStatic
        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"ni.shikatu.okhttp3.RequestBody.Companion.toRequestBody"}))
        public final RequestBody create(MediaType contentType, byte[] content, int offset, int byteCount) {
            Intrinsics.checkNotNullParameter(content, "content");
            return create(content, contentType, offset, byteCount);
        }

        @JvmStatic
        @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @ReplaceWith(expression = "file.asRequestBody(contentType)", imports = {"ni.shikatu.okhttp3.RequestBody.Companion.asRequestBody"}))
        public final RequestBody create(MediaType contentType, File file) {
            Intrinsics.checkNotNullParameter(file, "file");
            return create(file, contentType);
        }
    }

    @JvmStatic
    public static final RequestBody create(String $this$create, MediaType contentType) {
        return Companion.create($this$create, contentType);
    }

    @JvmStatic
    public static final RequestBody create(ByteString $this$create, MediaType contentType) {
        return Companion.create($this$create, contentType);
    }

    @JvmStatic
    public static final RequestBody create(FileDescriptor $this$create, MediaType contentType) {
        return Companion.create($this$create, contentType);
    }

    @JvmStatic
    public static final RequestBody create(byte[] $this$create) {
        return Companion.create($this$create);
    }

    @JvmStatic
    public static final RequestBody create(byte[] $this$create, MediaType contentType) {
        return Companion.create($this$create, contentType);
    }

    @JvmStatic
    public static final RequestBody create(byte[] $this$create, MediaType contentType, int offset) {
        return Companion.create($this$create, contentType, offset);
    }

    @JvmStatic
    public static final RequestBody create(byte[] $this$create, MediaType contentType, int offset, int byteCount) {
        return Companion.create($this$create, contentType, offset, byteCount);
    }

    @JvmStatic
    public static final RequestBody create(File $this$create, MediaType contentType) {
        return Companion.create($this$create, contentType);
    }

    @JvmStatic
    public static final RequestBody create(Path $this$create, FileSystem fileSystem, MediaType contentType) {
        return Companion.create($this$create, fileSystem, contentType);
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"ni.shikatu.okhttp3.RequestBody.Companion.toRequestBody"}))
    public static final RequestBody create(MediaType contentType, String content) {
        return Companion.create(contentType, content);
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType)", imports = {"ni.shikatu.okhttp3.RequestBody.Companion.toRequestBody"}))
    public static final RequestBody create(MediaType contentType, ByteString content) {
        return Companion.create(contentType, content);
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"ni.shikatu.okhttp3.RequestBody.Companion.toRequestBody"}))
    public static final RequestBody create(MediaType contentType, byte[] content) {
        return Companion.create(contentType, content);
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"ni.shikatu.okhttp3.RequestBody.Companion.toRequestBody"}))
    public static final RequestBody create(MediaType contentType, byte[] content, int offset) {
        return Companion.create(contentType, content, offset);
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'content' argument first to fix Java", replaceWith = @ReplaceWith(expression = "content.toRequestBody(contentType, offset, byteCount)", imports = {"ni.shikatu.okhttp3.RequestBody.Companion.toRequestBody"}))
    public static final RequestBody create(MediaType contentType, byte[] content, int offset, int byteCount) {
        return Companion.create(contentType, content, offset, byteCount);
    }

    @JvmStatic
    @Deprecated(level = DeprecationLevel.WARNING, message = "Moved to extension function. Put the 'file' argument first to fix Java", replaceWith = @ReplaceWith(expression = "file.asRequestBody(contentType)", imports = {"ni.shikatu.okhttp3.RequestBody.Companion.asRequestBody"}))
    public static final RequestBody create(MediaType contentType, File file) {
        return Companion.create(contentType, file);
    }
}
