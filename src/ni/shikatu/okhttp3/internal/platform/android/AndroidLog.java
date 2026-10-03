package ni.shikatu.okhttp3.internal.platform.android;
import java.util.Map.Entry;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.MapsKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.OkHttpClient;
import ni.shikatu.okhttp3.internal.concurrent.TaskRunner;
import ni.shikatu.okhttp3.internal.http2.Http2;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0002\b\u0007\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J1\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0010\u001a\u00020\u000b2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0000¢\u0006\u0002\b\u0013J\u0010\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0002J\u0006\u0010\u0015\u001a\u00020\rJ\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000bH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lni/shikatu/okhttp3/internal/platform/android/AndroidLog;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "MAX_LOG_LENGTH", _UrlKt.FRAGMENT_ENCODE_SET, "configuredLoggers", "Ljava/util/concurrent/CopyOnWriteArraySet;", "Ljava/util/logging/Logger;", "knownLoggers", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "androidLog", _UrlKt.FRAGMENT_ENCODE_SET, "loggerName", "logLevel", "message", "t", _UrlKt.FRAGMENT_ENCODE_SET, "androidLog$okhttp", "loggerTag", "enable", "enableLogging", "logger", "tag", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AndroidLog {
    private static final int MAX_LOG_LENGTH = 4000;
    private static final Map<String, String> knownLoggers;
    public static final AndroidLog INSTANCE = new AndroidLog();
    private static final CopyOnWriteArraySet<Logger> configuredLoggers = new CopyOnWriteArraySet<>();

    private AndroidLog() {
    }

    static {
        LinkedHashMap $this$knownLoggers_u24lambda_u240 = new LinkedHashMap();
        Package r3 = OkHttpClient.class.getPackage();
        String packageName = r3 != null ? r3.getName() : null;
        if (packageName != null) {
            $this$knownLoggers_u24lambda_u240.put(packageName, "OkHttp");
        }
        $this$knownLoggers_u24lambda_u240.put(OkHttpClient.class.getName(), "okhttp.OkHttpClient");
        $this$knownLoggers_u24lambda_u240.put(Http2.class.getName(), "okhttp.Http2");
        $this$knownLoggers_u24lambda_u240.put(TaskRunner.class.getName(), "okhttp.TaskRunner");
        $this$knownLoggers_u24lambda_u240.put("ni.shikatu.okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        knownLoggers = MapsKt.toMap($this$knownLoggers_u24lambda_u240);
    }

    public static  void androidLog$okhttp$default(AndroidLog androidLog, String str, int i, String str2, Throwable th, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            th = null;
        }
        androidLog.androidLog$okhttp(str, i, str2, th);
    }

    public final void androidLog$okhttp(String loggerName, int logLevel, String message, Throwable t) {
        Intrinsics.checkNotNullParameter(loggerName, "loggerName");
        Intrinsics.checkNotNullParameter(message, "message");
        String tag = loggerTag(loggerName);
        if (Log.isLoggable(tag, logLevel)) {
            String logMessage = message;
            if (t != null) {
                logMessage = logMessage + '\n' + Log.getStackTraceString(t);
            }
            int length = logMessage.length();
            int i = 0;
            while (i < length) {
                int newline = StringsKt.indexOf$default((CharSequence) logMessage, '\n', i, false, 4, (Object) null);
                int newline2 = newline != -1 ? newline : length;
                do {
                    int end = Math.min(newline2, i + MAX_LOG_LENGTH);
                    String strSubstring = logMessage.substring(i, end);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    Log.println(logLevel, tag, strSubstring);
                    i = end;
                } while (i < newline2);
                i++;
            }
        }
    }

    private final String loggerTag(String loggerName) {
        String str = knownLoggers.get(loggerName);
        return str == null ? StringsKt.take(loggerName, 23) : str;
    }

    public final void enable() {
        try {
            for (Map.Entry<String, String> entry : knownLoggers.entrySet()) {
                String logger = entry.getKey();
                String tag = entry.getValue();
                enableLogging(logger, tag);
            }
        } catch (RuntimeException re) {
            System.err.println("Possibly running android unit test without robolectric");
            re.printStackTrace();
        } catch (UnsatisfiedLinkError ule) {
            System.err.println("Possibly running android unit test without robolectric");
            ule.printStackTrace();
        }
    }

    private final void enableLogging(String logger, String tag) {
        Level level;
        Logger logger2 = Logger.getLogger(logger);
        if (configuredLoggers.add(logger2)) {
            logger2.setUseParentHandlers(false);
            if (Log.isLoggable(tag, 3)) {
                level = Level.FINE;
            } else {
                level = Log.isLoggable(tag, 4) ? Level.INFO : Level.WARNING;
            }
            logger2.setLevel(level);
            logger2.addHandler(AndroidLogHandler.INSTANCE);
        }
    }
}
