package ni.shikatu.okhttp3.internal.publicsuffix;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Unit;
import ni.shikatu.kotlin.io.CloseableKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.BufferedSource;
import ni.shikatu.okio.ByteString;
import ni.shikatu.okio.Okio;
import ni.shikatu.okio.Source;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b \u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0013\u001a\u00020\u0014H\u0002J\b\u0010\u0015\u001a\u00020\u0016H&J\b\u0010\u0017\u001a\u00020\u0014H\u0016J\b\u0010\u001c\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\tX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\tX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\rR\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00020\u0019X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001b¨\u0006\u001d"}, d2 = {"Lni/shikatu/okhttp3/internal/publicsuffix/BasePublicSuffixList;", "Lni/shikatu/okhttp3/internal/publicsuffix/PublicSuffixList;", "<init>", "()V", "listRead", "Ljava/util/concurrent/atomic/AtomicBoolean;", "readCompleteLatch", "Ljava/util/concurrent/CountDownLatch;", "bytes", "Lni/shikatu/okio/ByteString;", "getBytes", "()Lokio/ByteString;", "setBytes", "(Lokio/ByteString;)V", "exceptionBytes", "getExceptionBytes", "setExceptionBytes", "readFailure", "Ljava/io/IOException;", "readTheList", _UrlKt.FRAGMENT_ENCODE_SET, "listSource", "Lni/shikatu/okio/Source;", "ensureLoaded", "path", _UrlKt.FRAGMENT_ENCODE_SET, "getPath", "()Ljava/lang/Object;", "readTheListUninterruptibly", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public abstract class BasePublicSuffixList implements PublicSuffixList {
    public ByteString bytes;
    public ByteString exceptionBytes;
    private final AtomicBoolean listRead = new AtomicBoolean(false);
    private final CountDownLatch readCompleteLatch = new CountDownLatch(1);
    private IOException readFailure;

    public abstract Object getPath();

    public abstract Source listSource();

    @Override
    public ByteString getBytes() {
        ByteString byteString = this.bytes;
        if (byteString != null) {
            return byteString;
        }
        Intrinsics.throwUninitializedPropertyAccessException("bytes");
        return null;
    }

    public void setBytes(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<set-?>");
        this.bytes = byteString;
    }

    @Override
    public ByteString getExceptionBytes() {
        ByteString byteString = this.exceptionBytes;
        if (byteString != null) {
            return byteString;
        }
        Intrinsics.throwUninitializedPropertyAccessException("exceptionBytes");
        return null;
    }

    public void setExceptionBytes(ByteString byteString) {
        Intrinsics.checkNotNullParameter(byteString, "<set-?>");
        this.exceptionBytes = byteString;
    }

    private final void readTheList() throws IOException {
        try {
            BufferedSource bufferedSourceBuffer = Okio.buffer(listSource());
            try {
                BufferedSource bufferedSource = bufferedSourceBuffer;
                int totalBytes = bufferedSource.readInt();
                ByteString byteString = bufferedSource.readByteString(totalBytes);
                int totalExceptionBytes = bufferedSource.readInt();
                ByteString byteString2 = bufferedSource.readByteString(totalExceptionBytes);
                Unit unit = Unit.INSTANCE;
                CloseableKt.closeFinally(bufferedSourceBuffer, null);
                synchronized (this) {
                    Intrinsics.checkNotNull(byteString);
                    setBytes(byteString);
                    Intrinsics.checkNotNull(byteString2);
                    setExceptionBytes(byteString2);
                    Unit unit2 = Unit.INSTANCE;
                }
                this.readCompleteLatch.countDown();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    CloseableKt.closeFinally(bufferedSourceBuffer, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            this.readCompleteLatch.countDown();
            throw th3;
        }
    }

    @Override
    public void ensureLoaded() {
        if (!this.listRead.get() && this.listRead.compareAndSet(false, true)) {
            readTheListUninterruptibly();
        } else {
            try {
                this.readCompleteLatch.await();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        if (this.bytes == null) {
            IllegalStateException $this$ensureLoaded_u24lambda_u240 = new IllegalStateException("Unable to load " + getPath() + " resource.");
            $this$ensureLoaded_u24lambda_u240.initCause(this.readFailure);
            throw $this$ensureLoaded_u24lambda_u240;
        }
    }

    private final void readTheListUninterruptibly() {
        boolean interrupted = false;
        while (true) {
            try {
                try {
                    try {
                        readTheList();
                        break;
                    } catch (InterruptedIOException e) {
                        Thread.interrupted();
                        interrupted = true;
                    }
                } catch (IOException e2) {
                    this.readFailure = e2;
                    if (interrupted) {
                        Thread.currentThread().interrupt();
                        return;
                    }
                    return;
                }
            } catch (Throwable th) {
                if (interrupted) {
                    Thread.currentThread().interrupt();
                }
                throw th;
            }
        }
        if (interrupted) {
            Thread.currentThread().interrupt();
        }
    }
}
