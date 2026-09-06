package ni.shikatu.okio;

import java.io.RandomAccessFile;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0014J\b\u0010\f\u001a\u00020\u000bH\u0014J(\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0014J(\u0010\u0014\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\u000eH\u0014J\b\u0010\u0015\u001a\u00020\tH\u0014J\b\u0010\u0016\u001a\u00020\tH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lni/shikatu/okio/JvmFileHandle;", "Lni/shikatu/okio/FileHandle;", "readWrite", _UrlKt.FRAGMENT_ENCODE_SET, "randomAccessFile", "Ljava/io/RandomAccessFile;", "<init>", "(ZLjava/io/RandomAccessFile;)V", "protectedResize", _UrlKt.FRAGMENT_ENCODE_SET, "size", _UrlKt.FRAGMENT_ENCODE_SET, "protectedSize", "protectedRead", _UrlKt.FRAGMENT_ENCODE_SET, "fileOffset", "array", _UrlKt.FRAGMENT_ENCODE_SET, "arrayOffset", "byteCount", "protectedWrite", "protectedFlush", "protectedClose", "ni.shikatu.okio"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class JvmFileHandle extends FileHandle {
    private final RandomAccessFile randomAccessFile;

    public JvmFileHandle(boolean readWrite, RandomAccessFile randomAccessFile) {
        super(readWrite);
        Intrinsics.checkNotNullParameter(randomAccessFile, "randomAccessFile");
        this.randomAccessFile = randomAccessFile;
    }

    @Override
    protected synchronized void protectedResize(long size) throws Throwable {
        try {
            try {
                long currentSize = size();
                long delta = size - currentSize;
                if (delta > 0) {
                    protectedWrite(currentSize, new byte[(int) delta], 0, (int) delta);
                } else {
                    this.randomAccessFile.setLength(size);
                }
            } catch (Throwable th) {
                th = th;
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    @Override
    protected synchronized long protectedSize() {
        return this.randomAccessFile.length();
    }

    @Override
    protected synchronized int protectedRead(long fileOffset, byte[] array, int arrayOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.randomAccessFile.seek(fileOffset);
        int bytesRead = 0;
        while (bytesRead < byteCount) {
            int readResult = this.randomAccessFile.read(array, arrayOffset, byteCount - bytesRead);
            if (readResult == -1) {
                if (bytesRead != 0) {
                    break;
                }
                return -1;
            }
            bytesRead += readResult;
        }
        return bytesRead;
    }

    @Override
    protected synchronized void protectedWrite(long fileOffset, byte[] array, int arrayOffset, int byteCount) {
        Intrinsics.checkNotNullParameter(array, "array");
        this.randomAccessFile.seek(fileOffset);
        this.randomAccessFile.write(array, arrayOffset, byteCount);
    }

    @Override
    protected synchronized void protectedFlush() {
        this.randomAccessFile.getFD().sync();
    }

    @Override
    protected synchronized void protectedClose() {
        this.randomAccessFile.close();
    }
}
