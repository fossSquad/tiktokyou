package fake.com.bytedance.ttc2pa.utils;

public final class Logger {
    public static final Logger INSTANCE = new Logger();
    public static final String TAG = "Logger";
    public static int logLevel = 4;

    public final void d(String str) {
        d(TAG, str);
    }

    public final void d(String str, String str2) {
    }

    public final void d(String str, String str2, Throwable th) {
    }

    public final boolean debug() {
        return logLevel <= 3;
    }

    public final void e(String str) {
        e(TAG, str);
    }

    public final void e(String str, String str2) {
    }

    public final void e(String str, String str2, Throwable th) {
    }

    public final int getLogLevel() {
        return logLevel;
    }

    public final void i(String str) {
        i(TAG, str);
    }

    public final void i(String str, String str2) {
    }

    public final void i(String str, String str2, Throwable th) {
    }

    public final void setLogLevel(int i) {
        logLevel = i;
    }

    public final void v(String str) {
        v(TAG, str);
    }

    public final void v(String str, String str2) {
    }

    public final void v(String str, String str2, Throwable th) {
    }

    public final void w(String str) {
        w(TAG, str);
    }

    public final void w(String str, String str2) {
    }

    public final void w(String str, String str2, Throwable th) {
    }
}
