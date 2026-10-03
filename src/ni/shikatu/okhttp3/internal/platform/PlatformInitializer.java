package ni.shikatu.okhttp3.internal.platform;

import android.content.Context;
import androidx.startup.Initializer;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\b\u001a\u0012\u0012\u000e\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00010\n0\tH\u0016¨\u0006\u000b"}, d2 = {"Lni/shikatu/okhttp3/internal/platform/PlatformInitializer;", "Landroidx/startup/Initializer;", "Lni/shikatu/okhttp3/internal/platform/Platform;", "<init>", "()V", "create", "context", "Landroid/content/Context;", "dependencies", _UrlKt.FRAGMENT_ENCODE_SET, "Ljava/lang/Class;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PlatformInitializer implements Initializer<Platform> {
    public Platform create(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        PlatformRegistry.INSTANCE.setApplicationContext(context);
        return Platform.Companion.get();
    }

    public List<Class<Initializer<?>>> dependencies() {
        return CollectionsKt.emptyList();
    }
}
