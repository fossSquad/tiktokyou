package ni.shikatu.okhttp3;

import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u0000 \n2\u00020\u0001:\u0001\nJ\u001e\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H&J\u0016\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u000bÀ\u0006\u0003"}, d2 = {"Lni/shikatu/okhttp3/CookieJar;", _UrlKt.FRAGMENT_ENCODE_SET, "saveFromResponse", _UrlKt.FRAGMENT_ENCODE_SET, "url", "Lni/shikatu/okhttp3/HttpUrl;", "cookies", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/Cookie;", "loadForRequest", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public interface CookieJar {
    public static final Companion Companion = ni.shikatu.okhttp3.CookieJar.Companion.$$INSTANCE;
    public static final CookieJar NO_COOKIES = new Companion.NoCookies();

    List<Cookie> loadForRequest(HttpUrl httpUrl);

    void saveFromResponse(HttpUrl httpUrl, List<Cookie> list);

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0006B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0001¨\u0006\u0007"}, d2 = {"Lni/shikatu/okhttp3/CookieJar$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "NO_COOKIES", "Lni/shikatu/okhttp3/CookieJar;", "NoCookies", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        static final  Companion $$INSTANCE = new Companion();

        private Companion() {
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001e\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¨\u0006\f"}, d2 = {"Lni/shikatu/okhttp3/CookieJar$Companion$NoCookies;", "Lni/shikatu/okhttp3/CookieJar;", "<init>", "()V", "saveFromResponse", _UrlKt.FRAGMENT_ENCODE_SET, "url", "Lni/shikatu/okhttp3/HttpUrl;", "cookies", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/Cookie;", "loadForRequest", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
        private static final class NoCookies implements CookieJar {
            @Override
            public void saveFromResponse(HttpUrl url, List<Cookie> list) {
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(list, "cookies");
            }

            @Override
            public List<Cookie> loadForRequest(HttpUrl url) {
                Intrinsics.checkNotNullParameter(url, "url");
                return CollectionsKt.emptyList();
            }
        }
    }
}
