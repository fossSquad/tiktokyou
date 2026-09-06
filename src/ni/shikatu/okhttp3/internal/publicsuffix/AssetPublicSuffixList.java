package ni.shikatu.okhttp3.internal.publicsuffix;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Build;
import java.io.IOException;
import java.io.InputStream;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.platform.PlatformRegistry;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Okio;
import ni.shikatu.okio.Source;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\b\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000b"}, d2 = {"Lni/shikatu/okhttp3/internal/publicsuffix/AssetPublicSuffixList;", "Lni/shikatu/okhttp3/internal/publicsuffix/BasePublicSuffixList;", "path", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;)V", "getPath", "()Ljava/lang/String;", "listSource", "Lni/shikatu/okio/Source;", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class AssetPublicSuffixList extends BasePublicSuffixList {
    public static final Companion Companion = new Companion(null);
    private static final String PUBLIC_SUFFIX_RESOURCE = "PublicSuffixDatabase.list";
    private final String path;

    public AssetPublicSuffixList() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public AssetPublicSuffixList(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        this.path = path;
    }

    public  AssetPublicSuffixList(String str, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? PUBLIC_SUFFIX_RESOURCE : str);
    }

    @Override
    public String getPath() {
        return this.path;
    }

    @Override
    public Source listSource() throws IOException {
        Context applicationContext = PlatformRegistry.INSTANCE.getApplicationContext();
        AssetManager assets = applicationContext != null ? applicationContext.getAssets() : null;
        if (assets == null) {
            if (Build.FINGERPRINT == null) {
                throw new IOException("Platform applicationContext not initialized. Possibly running Android unit test without Robolectric. Android tests should run with Robolectric and call OkHttp.initialize before test");
            }
            throw new IOException("Platform applicationContext not initialized. Startup Initializer possibly disabled, call OkHttp.initialize before test.");
        }
        InputStream inputStreamOpen = assets.open(getPath());
        Intrinsics.checkNotNullExpressionValue(inputStreamOpen, "open(...)");
        return Okio.source(inputStreamOpen);
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0004\u001a\u00020\u0005X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lni/shikatu/okhttp3/internal/publicsuffix/AssetPublicSuffixList$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "PUBLIC_SUFFIX_RESOURCE", _UrlKt.FRAGMENT_ENCODE_SET, "getPUBLIC_SUFFIX_RESOURCE", "()Ljava/lang/String;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getPUBLIC_SUFFIX_RESOURCE() {
            return AssetPublicSuffixList.PUBLIC_SUFFIX_RESOURCE;
        }
    }
}
