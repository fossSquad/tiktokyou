package ni.shikatu.okhttp3.internal.platform.android;

import java.util.logging.Handler;
import java.util.logging.LogRecord;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0005H\u0016J\b\u0010\t\u001a\u00020\u0005H\u0016¨\u0006\n"}, d2 = {"Lni/shikatu/okhttp3/internal/platform/android/AndroidLogHandler;", "Ljava/util/logging/Handler;", "<init>", "()V", "publish", _UrlKt.FRAGMENT_ENCODE_SET, "record", "Ljava/util/logging/LogRecord;", "flush", "close", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AndroidLogHandler extends Handler {
    public static final AndroidLogHandler INSTANCE = new AndroidLogHandler();

    private AndroidLogHandler() {
    }

    @Override
    public void publish(LogRecord record) {
        Intrinsics.checkNotNullParameter(record, "record");
        AndroidLog androidLog = AndroidLog.INSTANCE;
        String loggerName = record.getLoggerName();
        Intrinsics.checkNotNullExpressionValue(loggerName, "getLoggerName(...)");
        int androidLevel = AndroidLogKt.getAndroidLevel(record);
        String message = record.getMessage();
        Intrinsics.checkNotNullExpressionValue(message, "getMessage(...)");
        androidLog.androidLog$okhttp(loggerName, androidLevel, message, record.getThrown());
    }

    @Override
    public void flush() {
    }

    @Override
    public void close() {
    }
}
