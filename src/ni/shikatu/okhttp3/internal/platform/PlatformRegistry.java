package ni.shikatu.okhttp3.internal.platform;

import android.content.Context;
import android.os.Build;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.platform.android.AndroidLog;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005R\u0011\u0010\u0006\u001a\u00020\u00078F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\bR(\u0010\u000b\u001a\u0004\u0018\u00010\n2\b\u0010\t\u001a\u0004\u0018\u00010\n8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0010"}, d2 = {"Lni/shikatu/okhttp3/internal/platform/PlatformRegistry;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "findPlatform", "Lni/shikatu/okhttp3/internal/platform/Platform;", "isAndroid", _UrlKt.FRAGMENT_ENCODE_SET, "()Z", "value", "Landroid/content/Context;", "applicationContext", "getApplicationContext", "()Landroid/content/Context;", "setApplicationContext", "(Landroid/content/Context;)V", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlatformRegistry {
    public static final PlatformRegistry INSTANCE = new PlatformRegistry();

    private PlatformRegistry() {
    }

    public final Platform findPlatform() {
        AndroidLog.INSTANCE.enable();
        Platform androidPlatform = Android10Platform.Companion.buildIfSupported();
        if (androidPlatform == null) {
            androidPlatform = AndroidPlatform.Companion.buildIfSupported();
        }
        if (androidPlatform != null) {
            return androidPlatform;
        }
        throw new IllegalStateException("Expected Android API level 21+ but was " + Build.VERSION.SDK_INT);
    }

    public final boolean isAndroid() {
        return true;
    }

    public final Context getApplicationContext() {
        Object obj = Platform.Companion.get();
        ContextAwarePlatform contextAwarePlatform = obj instanceof ContextAwarePlatform ? (ContextAwarePlatform) obj : null;
        if (contextAwarePlatform != null) {
            return contextAwarePlatform.getApplicationContext();
        }
        return null;
    }

    public final void setApplicationContext(Context value) {
        Object obj = Platform.Companion.get();
        ContextAwarePlatform contextAwarePlatform = obj instanceof ContextAwarePlatform ? (ContextAwarePlatform) obj : null;
        if (contextAwarePlatform != null) {
            contextAwarePlatform.setApplicationContext(value);
        }
    }
}
