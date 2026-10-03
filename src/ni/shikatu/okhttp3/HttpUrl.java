package ni.shikatu.okhttp3;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.collections.SetsKt;
import ni.shikatu.kotlin.internal.ProgressionUtilKt;
import ni.shikatu.kotlin.jvm.JvmStatic;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.ranges.IntProgression;
import ni.shikatu.kotlin.ranges.RangesKt;
import ni.shikatu.kotlin.text.Regex;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.kotlin.text.Typography;
import ni.shikatu.kotlinx.serialization.json.internal.AbstractJsonLexerKt;
import ni.shikatu.okhttp3.internal._HostnamesCommonKt;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\"\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u001b\u0018\u0000 K2\u00020\u0001:\u0002JKBc\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n\u0012\u0010\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\n\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\r\u001a\u00020\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\r\u0010\u0016\u001a\u00020\u0017H\u0007¢\u0006\u0002\b\rJ\r\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\b\u001aJ\u0010\u0010#\u001a\u0004\u0018\u00010\u00032\u0006\u0010$\u001a\u00020\u0003J\u0016\u0010(\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\n2\u0006\u0010$\u001a\u00020\u0003J\u000e\u0010)\u001a\u00020\u00032\u0006\u0010*\u001a\u00020\bJ\u0010\u0010+\u001a\u0004\u0018\u00010\u00032\u0006\u0010*\u001a\u00020\bJ\u0006\u0010-\u001a\u00020\u0003J\u0010\u0010.\u001a\u0004\u0018\u00010\u00002\u0006\u0010/\u001a\u00020\u0003J\u0006\u00100\u001a\u000201J\u0010\u00100\u001a\u0004\u0018\u0001012\u0006\u0010/\u001a\u00020\u0003J\u0013\u00102\u001a\u00020\u00142\b\u00103\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u00104\u001a\u00020\bH\u0016J\b\u00105\u001a\u00020\u0003H\u0016J\b\u00106\u001a\u0004\u0018\u00010\u0003J\r\u0010\r\u001a\u00020\u0017H\u0007¢\u0006\u0002\b7J\r\u0010\u001a\u001a\u00020\u0019H\u0007¢\u0006\u0002\b8J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b9J\r\u0010\u001b\u001a\u00020\u0003H\u0007¢\u0006\u0002\b:J\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b;J\r\u0010\u001c\u001a\u00020\u0003H\u0007¢\u0006\u0002\b<J\r\u0010\u0005\u001a\u00020\u0003H\u0007¢\u0006\u0002\b=J\r\u0010\u0006\u001a\u00020\u0003H\u0007¢\u0006\u0002\b>J\r\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\b?J\r\u0010\u001d\u001a\u00020\bH\u0007¢\u0006\u0002\b@J\r\u0010\u001e\u001a\u00020\u0003H\u0007¢\u0006\u0002\bAJ\u0013\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007¢\u0006\u0002\bBJ\u0013\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\nH\u0007¢\u0006\u0002\bCJ\u000f\u0010 \u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\bDJ\u000f\u0010!\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\bEJ\r\u0010\"\u001a\u00020\bH\u0007¢\u0006\u0002\bFJ\u0013\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030&H\u0007¢\u0006\u0002\bGJ\u000f\u0010,\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\bHJ\u000f\u0010\f\u001a\u0004\u0018\u00010\u0003H\u0007¢\u0006\u0002\bIR\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0010R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0010R\u0013\u0010\u0005\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0010R\u0013\u0010\u0006\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0010R\u0013\u0010\u0007\u001a\u00020\b8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u0019\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0012R\u0018\u0010\u000b\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\f\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0010R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0013\u001a\u00020\u00148F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0011\u0010\u001b\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0010R\u0011\u0010\u001c\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u0010R\u0011\u0010\u001d\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0011R\u0011\u0010\u001e\u001a\u00020\u00038G¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u0010R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00030\n8G¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0012R\u0013\u0010 \u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b \u0010\u0010R\u0013\u0010!\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b!\u0010\u0010R\u0011\u0010\"\u001a\u00020\b8G¢\u0006\u0006\u001a\u0004\b\"\u0010\u0011R\u0017\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030&8G¢\u0006\u0006\u001a\u0004\b%\u0010'R\u0013\u0010,\u001a\u0004\u0018\u00010\u00038G¢\u0006\u0006\u001a\u0004\b,\u0010\u0010¨\u0006L"}, d2 = {"Lni/shikatu/okhttp3/HttpUrl;", _UrlKt.FRAGMENT_ENCODE_SET, "scheme", _UrlKt.FRAGMENT_ENCODE_SET, "username", "password", "host", "port", _UrlKt.FRAGMENT_ENCODE_SET, "pathSegments", _UrlKt.FRAGMENT_ENCODE_SET, "queryNamesAndValues", "fragment", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "()Ljava/lang/String;", "()I", "()Ljava/util/List;", "isHttps", _UrlKt.FRAGMENT_ENCODE_SET, "()Z", "toUrl", "Ljava/net/URL;", "toUri", "Ljava/net/URI;", "uri", "encodedUsername", "encodedPassword", "pathSize", "encodedPath", "encodedPathSegments", "encodedQuery", "query", "querySize", "queryParameter", "name", "queryParameterNames", _UrlKt.FRAGMENT_ENCODE_SET, "()Ljava/util/Set;", "queryParameterValues", "queryParameterName", "index", "queryParameterValue", "encodedFragment", "redact", "resolve", "link", "newBuilder", "Lni/shikatu/okhttp3/HttpUrl$Builder;", "equals", "other", "hashCode", "toString", "topPrivateDomain", "-deprecated_url", "-deprecated_uri", "-deprecated_scheme", "-deprecated_encodedUsername", "-deprecated_username", "-deprecated_encodedPassword", "-deprecated_password", "-deprecated_host", "-deprecated_port", "-deprecated_pathSize", "-deprecated_encodedPath", "-deprecated_encodedPathSegments", "-deprecated_pathSegments", "-deprecated_encodedQuery", "-deprecated_query", "-deprecated_querySize", "-deprecated_queryParameterNames", "-deprecated_encodedFragment", "-deprecated_fragment", "Builder", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class HttpUrl {
    public static final Companion Companion = new Companion(null);
    private final String fragment;
    private final String host;
    private final String password;
    private final List<String> pathSegments;
    private final int port;
    private final List<String> queryNamesAndValues;
    private final String scheme;
    private final String url;
    private final String username;

    public  HttpUrl(String str, String str2, String str3, String str4, int i, List list, List list2, String str5, String str6, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, str4, i, list, list2, str5, str6);
    }

    private HttpUrl(String scheme, String username, String password, String host, int port, List<String> list, List<String> list2, String fragment, String url) {
        this.scheme = scheme;
        this.username = username;
        this.password = password;
        this.host = host;
        this.port = port;
        this.pathSegments = list;
        this.queryNamesAndValues = list2;
        this.fragment = fragment;
        this.url = url;
    }

    public final String scheme() {
        return this.scheme;
    }

    public final String username() {
        return this.username;
    }

    public final String password() {
        return this.password;
    }

    public final String host() {
        return this.host;
    }

    public final int port() {
        return this.port;
    }

    public final List<String> pathSegments() {
        return this.pathSegments;
    }

    public final String fragment() {
        return this.fragment;
    }

    public final boolean isHttps() {
        return Intrinsics.areEqual(this.scheme, "https");
    }

    public final URL url() {
        try {
            return new URL(this.url);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public final URI uri() {
        String uri = newBuilder().reencodeForUri$okhttp().toString();
        try {
            return new URI(uri);
        } catch (URISyntaxException e) {
            try {
                String stripped = new Regex("[\\u0000-\\u001F\\u007F-\\u009F\\p{javaWhitespace}]").replace(uri, _UrlKt.FRAGMENT_ENCODE_SET);
                URI uriCreate = URI.create(stripped);
                Intrinsics.checkNotNull(uriCreate);
                return uriCreate;
            } catch (Exception e2) {
                throw new RuntimeException(e);
            }
        }
    }

    public final String encodedUsername() {
        if (this.username.length() == 0) {
            return _UrlKt.FRAGMENT_ENCODE_SET;
        }
        int usernameStart = this.scheme.length() + 3;
        int usernameEnd = _UtilCommonKt.delimiterOffset(this.url, ":@", usernameStart, this.url.length());
        String strSubstring = this.url.substring(usernameStart, usernameEnd);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String encodedPassword() {
        if (this.password.length() == 0) {
            return _UrlKt.FRAGMENT_ENCODE_SET;
        }
        int passwordStart = StringsKt.indexOf$default((CharSequence) this.url, AbstractJsonLexerKt.COLON, this.scheme.length() + 3, false, 4, (Object) null) + 1;
        int passwordEnd = StringsKt.indexOf$default((CharSequence) this.url, '@', 0, false, 6, (Object) null);
        String strSubstring = this.url.substring(passwordStart, passwordEnd);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final int pathSize() {
        return this.pathSegments.size();
    }

    public final String encodedPath() {
        int pathStart = StringsKt.indexOf$default((CharSequence) this.url, '/', this.scheme.length() + 3, false, 4, (Object) null);
        int pathEnd = _UtilCommonKt.delimiterOffset(this.url, "?#", pathStart, this.url.length());
        String strSubstring = this.url.substring(pathStart, pathEnd);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final List<String> encodedPathSegments() {
        int pathStart = StringsKt.indexOf$default((CharSequence) this.url, '/', this.scheme.length() + 3, false, 4, (Object) null);
        int pathEnd = _UtilCommonKt.delimiterOffset(this.url, "?#", pathStart, this.url.length());
        List result = new ArrayList();
        int i = pathStart;
        while (i < pathEnd) {
            int i2 = i + 1;
            int segmentEnd = _UtilCommonKt.delimiterOffset(this.url, '/', i2, pathEnd);
            String strSubstring = this.url.substring(i2, segmentEnd);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
            result.add(strSubstring);
            i = segmentEnd;
        }
        return result;
    }

    public final String encodedQuery() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        int queryStart = StringsKt.indexOf$default((CharSequence) this.url, '?', 0, false, 6, (Object) null) + 1;
        int queryEnd = _UtilCommonKt.delimiterOffset(this.url, '#', queryStart, this.url.length());
        String strSubstring = this.url.substring(queryStart, queryEnd);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String query() {
        if (this.queryNamesAndValues == null) {
            return null;
        }
        StringBuilder result = new StringBuilder();
        Companion.toQueryString(this.queryNamesAndValues, result);
        return result.toString();
    }

    public final int querySize() {
        if (this.queryNamesAndValues != null) {
            return this.queryNamesAndValues.size() / 2;
        }
        return 0;
    }

    public final String queryParameter(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.queryNamesAndValues == null) {
            return null;
        }
        IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, this.queryNamesAndValues.size()), 2);
        int i = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step > 0 && i <= last) || (step < 0 && last <= i)) {
            while (!Intrinsics.areEqual(name, this.queryNamesAndValues.get(i))) {
                if (i != last) {
                    i += step;
                }
            }
            return this.queryNamesAndValues.get(i + 1);
        }
        return null;
    }

    public final Set<String> queryParameterNames() {
        if (this.queryNamesAndValues == null) {
            return SetsKt.emptySet();
        }
        LinkedHashSet result = new LinkedHashSet(this.queryNamesAndValues.size() / 2, 1.0f);
        IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, this.queryNamesAndValues.size()), 2);
        int i = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step > 0 && i <= last) || (step < 0 && last <= i)) {
            while (true) {
                String str = this.queryNamesAndValues.get(i);
                Intrinsics.checkNotNull(str);
                result.add(str);
                if (i == last) {
                    break;
                }
                i += step;
            }
        }
        LinkedHashSet $this$unmodifiable$iv = result;
        Set<String> setUnmodifiableSet = Collections.unmodifiableSet($this$unmodifiable$iv);
        Intrinsics.checkNotNullExpressionValue(setUnmodifiableSet, "unmodifiableSet(...)");
        return setUnmodifiableSet;
    }

    public final List<String> queryParameterValues(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        if (this.queryNamesAndValues == null) {
            return CollectionsKt.emptyList();
        }
        ArrayList result = new ArrayList(4);
        IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, this.queryNamesAndValues.size()), 2);
        int i = intProgressionStep.getFirst();
        int last = intProgressionStep.getLast();
        int step = intProgressionStep.getStep();
        if ((step > 0 && i <= last) || (step < 0 && last <= i)) {
            while (true) {
                if (Intrinsics.areEqual(name, this.queryNamesAndValues.get(i))) {
                    result.add(this.queryNamesAndValues.get(i + 1));
                }
                if (i == last) {
                    break;
                }
                i += step;
            }
        }
        ArrayList $this$unmodifiable$iv = result;
        List<String> listUnmodifiableList = Collections.unmodifiableList($this$unmodifiable$iv);
        Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(...)");
        return listUnmodifiableList;
    }

    public final String queryParameterName(int index) {
        if (this.queryNamesAndValues == null) {
            throw new IndexOutOfBoundsException();
        }
        String str = this.queryNamesAndValues.get(index * 2);
        Intrinsics.checkNotNull(str);
        return str;
    }

    public final String queryParameterValue(int index) {
        if (this.queryNamesAndValues == null) {
            throw new IndexOutOfBoundsException();
        }
        return this.queryNamesAndValues.get((index * 2) + 1);
    }

    public final String encodedFragment() {
        if (this.fragment == null) {
            return null;
        }
        int fragmentStart = StringsKt.indexOf$default((CharSequence) this.url, '#', 0, false, 6, (Object) null) + 1;
        String strSubstring = this.url.substring(fragmentStart);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final String redact() {
        Builder builderNewBuilder = newBuilder("/...");
        Intrinsics.checkNotNull(builderNewBuilder);
        return builderNewBuilder.username(_UrlKt.FRAGMENT_ENCODE_SET).password(_UrlKt.FRAGMENT_ENCODE_SET).build().toString();
    }

    public final HttpUrl resolve(String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        Builder builderNewBuilder = newBuilder(link);
        if (builderNewBuilder != null) {
            return builderNewBuilder.build();
        }
        return null;
    }

    public final Builder newBuilder() {
        Builder result = new Builder();
        result.setScheme$okhttp(this.scheme);
        result.setEncodedUsername$okhttp(encodedUsername());
        result.setEncodedPassword$okhttp(encodedPassword());
        result.setHost$okhttp(this.host);
        result.setPort$okhttp(this.port != Companion.defaultPort(this.scheme) ? this.port : -1);
        result.getEncodedPathSegments$okhttp().clear();
        result.getEncodedPathSegments$okhttp().addAll(encodedPathSegments());
        result.encodedQuery(encodedQuery());
        result.setEncodedFragment$okhttp(encodedFragment());
        return result;
    }

    public final Builder newBuilder(String link) {
        Intrinsics.checkNotNullParameter(link, "link");
        try {
            return new Builder().parse$okhttp(this, link);
        } catch (IllegalArgumentException e) {
            return null;
        }
    }

    public boolean equals(Object other) {
        return (other instanceof HttpUrl) && Intrinsics.areEqual(((HttpUrl) other).url, this.url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return this.url;
    }

    public final String topPrivateDomain() {
        if (_HostnamesCommonKt.canParseAsIpAddress(this.host)) {
            return null;
        }
        return PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(this.host);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to toUrl()", replaceWith = @ReplaceWith(expression = "toUrl()", imports = {}))

    public final URL m1662deprecated_url() {
        return url();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to toUri()", replaceWith = @ReplaceWith(expression = "toUri()", imports = {}))

    public final URI m1661deprecated_uri() {
        return uri();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "scheme", imports = {}))

    public final String m1660deprecated_scheme() {
        return this.scheme;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedUsername", imports = {}))

    public final String m1650deprecated_encodedUsername() {
        return encodedUsername();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "username", imports = {}))

    public final String m1663deprecated_username() {
        return this.username;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPassword", imports = {}))

    public final String m1646deprecated_encodedPassword() {
        return encodedPassword();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "password", imports = {}))

    public final String m1653deprecated_password() {
        return this.password;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "host", imports = {}))

    public final String m1652deprecated_host() {
        return this.host;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "port", imports = {}))

    public final int m1656deprecated_port() {
        return this.port;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "pathSize", imports = {}))

    public final int m1655deprecated_pathSize() {
        return pathSize();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPath", imports = {}))

    public final String m1647deprecated_encodedPath() {
        return encodedPath();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedPathSegments", imports = {}))

    public final List<String> m1648deprecated_encodedPathSegments() {
        return encodedPathSegments();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "pathSegments", imports = {}))

    public final List<String> m1654deprecated_pathSegments() {
        return this.pathSegments;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedQuery", imports = {}))

    public final String m1649deprecated_encodedQuery() {
        return encodedQuery();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "query", imports = {}))

    public final String m1657deprecated_query() {
        return query();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "querySize", imports = {}))

    public final int m1659deprecated_querySize() {
        return querySize();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "queryParameterNames", imports = {}))

    public final Set<String> m1658deprecated_queryParameterNames() {
        return queryParameterNames();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "encodedFragment", imports = {}))

    public final String m1645deprecated_encodedFragment() {
        return encodedFragment();
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "fragment", imports = {}))

    public final String m1651deprecated_fragment() {
        return this.fragment;
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0013\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\u0004\u001a\u00020\u00002\u0006\u0010\u0004\u001a\u00020\u0005J\u000e\u0010$\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u0005J\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0005J\u000e\u0010%\u001a\u00020\u00002\u0006\u0010%\u001a\u00020\u0005J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0005J\u000e\u0010\u0010\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u0005J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014J\u000e\u0010&\u001a\u00020\u00002\u0006\u0010'\u001a\u00020\u0005J\u000e\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u0005J\u000e\u0010*\u001a\u00020\u00002\u0006\u0010+\u001a\u00020\u0005J\u000e\u0010,\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0005J\u0018\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\u00052\u0006\u0010-\u001a\u00020.H\u0002J\u0016\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u0005J\u0016\u00101\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u00142\u0006\u0010+\u001a\u00020\u0005J\u000e\u00102\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0014J\u000e\u00103\u001a\u00020\u00002\u0006\u00103\u001a\u00020\u0005J\u0010\u00104\u001a\u00020\u00002\b\u00104\u001a\u0004\u0018\u00010\u0005J\u0010\u00105\u001a\u00020\u00002\b\u00105\u001a\u0004\u0018\u00010\u0005J\u0018\u00106\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u00052\b\u00108\u001a\u0004\u0018\u00010\u0005J\u0018\u00109\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010\u0005J\u0018\u0010<\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u00052\b\u00108\u001a\u0004\u0018\u00010\u0005J\u0018\u0010=\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u00052\b\u0010;\u001a\u0004\u0018\u00010\u0005J\u000e\u0010>\u001a\u00020\u00002\u0006\u00107\u001a\u00020\u0005J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010:\u001a\u00020\u0005J\u0010\u0010@\u001a\u00020A2\u0006\u0010B\u001a\u00020\u0005H\u0002J\u0010\u0010C\u001a\u00020\u00002\b\u0010C\u001a\u0004\u0018\u00010\u0005J\u0010\u0010!\u001a\u00020\u00002\b\u0010!\u001a\u0004\u0018\u00010\u0005J\r\u0010D\u001a\u00020\u0000H\u0000¢\u0006\u0002\bEJ\u0006\u0010F\u001a\u00020GJ\b\u0010H\u001a\u00020\u0014H\u0002J\b\u0010I\u001a\u00020\u0005H\u0016J\u001e\u0010J\u001a\u00020A*\b\u0012\u0004\u0012\u00020\u00050K2\n\u0010L\u001a\u00060Mj\u0002`NH\u0002J\u001f\u0010O\u001a\u00020\u00002\b\u0010P\u001a\u0004\u0018\u00010G2\u0006\u0010Q\u001a\u00020\u0005H\u0000¢\u0006\u0002\bRJ \u0010S\u001a\u00020A2\u0006\u0010Q\u001a\u00020\u00052\u0006\u0010T\u001a\u00020\u00142\u0006\u0010U\u001a\u00020\u0014H\u0002J0\u0010V\u001a\u00020A2\u0006\u0010Q\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u00142\u0006\u0010U\u001a\u00020\u00142\u0006\u0010X\u001a\u00020.2\u0006\u0010-\u001a\u00020.H\u0002J\b\u0010Y\u001a\u00020AH\u0002J\u0010\u0010Z\u001a\u00020.2\u0006\u0010Q\u001a\u00020\u0005H\u0002J\u0010\u0010[\u001a\u00020.2\u0006\u0010Q\u001a\u00020\u0005H\u0002J\u0014\u0010\\\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u001a*\u00020\u0005H\u0002J \u0010]\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u00142\u0006\u0010U\u001a\u00020\u0014H\u0002J\u001c\u0010^\u001a\u00020\u0014*\u00020\u00052\u0006\u0010W\u001a\u00020\u00142\u0006\u0010U\u001a\u00020\u0014H\u0002J \u0010_\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u00142\u0006\u0010U\u001a\u00020\u0014H\u0002J \u0010`\u001a\u00020\u00142\u0006\u0010Q\u001a\u00020\u00052\u0006\u0010W\u001a\u00020\u00142\u0006\u0010U\u001a\u00020\u0014H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0007\"\u0004\b\u000f\u0010\tR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0007\"\u0004\b\u0012\u0010\tR\u001a\u0010\u0013\u001a\u00020\u0014X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00050\u001aX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR$\u0010\u001d\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u001aX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001c\"\u0004\b\u001f\u0010 R\u001c\u0010!\u001a\u0004\u0018\u00010\u0005X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0007\"\u0004\b#\u0010\t¨\u0006a"}, d2 = {"Lni/shikatu/okhttp3/HttpUrl$Builder;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "scheme", _UrlKt.FRAGMENT_ENCODE_SET, "getScheme$okhttp", "()Ljava/lang/String;", "setScheme$okhttp", "(Ljava/lang/String;)V", "encodedUsername", "getEncodedUsername$okhttp", "setEncodedUsername$okhttp", "encodedPassword", "getEncodedPassword$okhttp", "setEncodedPassword$okhttp", "host", "getHost$okhttp", "setHost$okhttp", "port", _UrlKt.FRAGMENT_ENCODE_SET, "getPort$okhttp", "()I", "setPort$okhttp", "(I)V", "encodedPathSegments", _UrlKt.FRAGMENT_ENCODE_SET, "getEncodedPathSegments$okhttp", "()Ljava/util/List;", "encodedQueryNamesAndValues", "getEncodedQueryNamesAndValues$okhttp", "setEncodedQueryNamesAndValues$okhttp", "(Ljava/util/List;)V", "encodedFragment", "getEncodedFragment$okhttp", "setEncodedFragment$okhttp", "username", "password", "addPathSegment", "pathSegment", "addPathSegments", "pathSegments", "addEncodedPathSegment", "encodedPathSegment", "addEncodedPathSegments", "alreadyEncoded", _UrlKt.FRAGMENT_ENCODE_SET, "setPathSegment", "index", "setEncodedPathSegment", "removePathSegment", "encodedPath", "query", "encodedQuery", "addQueryParameter", "name", "value", "addEncodedQueryParameter", "encodedName", "encodedValue", "setQueryParameter", "setEncodedQueryParameter", "removeAllQueryParameters", "removeAllEncodedQueryParameters", "removeAllCanonicalQueryParameters", _UrlKt.FRAGMENT_ENCODE_SET, "canonicalName", "fragment", "reencodeForUri", "reencodeForUri$okhttp", "build", "Lni/shikatu/okhttp3/HttpUrl;", "effectivePort", "toString", "toPathString", _UrlKt.FRAGMENT_ENCODE_SET, "out", "Ljava/lang/StringBuilder;", "Lni/shikatu/kotlin/text/StringBuilder;", "parse", "base", "input", "parse$okhttp", "resolvePath", "startPos", "limit", "push", "pos", "addTrailingSlash", "pop", "isDot", "isDotDot", "toQueryNamesAndValues", "schemeDelimiterOffset", "slashCount", "portColonOffset", "parsePort", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        private String encodedFragment;
        private List<String> encodedQueryNamesAndValues;
        private String host;
        private String scheme;
        private String encodedUsername = _UrlKt.FRAGMENT_ENCODE_SET;
        private String encodedPassword = _UrlKt.FRAGMENT_ENCODE_SET;
        private int port = -1;
        private final List<String> encodedPathSegments = CollectionsKt.mutableListOf(_UrlKt.FRAGMENT_ENCODE_SET);

        public final String getScheme$okhttp() {
            return this.scheme;
        }

        public final void setScheme$okhttp(String str) {
            this.scheme = str;
        }

        public final String getEncodedUsername$okhttp() {
            return this.encodedUsername;
        }

        public final void setEncodedUsername$okhttp(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.encodedUsername = str;
        }

        public final String getEncodedPassword$okhttp() {
            return this.encodedPassword;
        }

        public final void setEncodedPassword$okhttp(String str) {
            Intrinsics.checkNotNullParameter(str, "<set-?>");
            this.encodedPassword = str;
        }

        public final String getHost$okhttp() {
            return this.host;
        }

        public final void setHost$okhttp(String str) {
            this.host = str;
        }

        public final int getPort$okhttp() {
            return this.port;
        }

        public final void setPort$okhttp(int i) {
            this.port = i;
        }

        public final List<String> getEncodedPathSegments$okhttp() {
            return this.encodedPathSegments;
        }

        public final List<String> getEncodedQueryNamesAndValues$okhttp() {
            return this.encodedQueryNamesAndValues;
        }

        public final void setEncodedQueryNamesAndValues$okhttp(List<String> list) {
            this.encodedQueryNamesAndValues = list;
        }

        public final String getEncodedFragment$okhttp() {
            return this.encodedFragment;
        }

        public final void setEncodedFragment$okhttp(String str) {
            this.encodedFragment = str;
        }

        public final Builder scheme(String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            Builder $this$scheme_u24lambda_u240 = this;
            if (StringsKt.equals(scheme, "http", true)) {
                $this$scheme_u24lambda_u240.scheme = "http";
            } else if (StringsKt.equals(scheme, "https", true)) {
                $this$scheme_u24lambda_u240.scheme = "https";
            } else {
                throw new IllegalArgumentException("unexpected scheme: " + scheme);
            }
            return this;
        }

        public final Builder username(String username) {
            Intrinsics.checkNotNullParameter(username, "username");
            Builder $this$username_u24lambda_u240 = this;
            $this$username_u24lambda_u240.encodedUsername = _UrlKt.canonicalize$default(username, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 123, null);
            return this;
        }

        public final Builder encodedUsername(String encodedUsername) {
            Intrinsics.checkNotNullParameter(encodedUsername, "encodedUsername");
            Builder $this$encodedUsername_u24lambda_u240 = this;
            $this$encodedUsername_u24lambda_u240.encodedUsername = _UrlKt.canonicalize$default(encodedUsername, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 115, null);
            return this;
        }

        public final Builder password(String password) {
            Intrinsics.checkNotNullParameter(password, "password");
            Builder $this$password_u24lambda_u240 = this;
            $this$password_u24lambda_u240.encodedPassword = _UrlKt.canonicalize$default(password, 0, 0, " \"':;<=>@[]^`{}|/\\?#", false, false, false, false, 123, null);
            return this;
        }

        public final Builder encodedPassword(String encodedPassword) {
            Intrinsics.checkNotNullParameter(encodedPassword, "encodedPassword");
            Builder $this$encodedPassword_u24lambda_u240 = this;
            $this$encodedPassword_u24lambda_u240.encodedPassword = _UrlKt.canonicalize$default(encodedPassword, 0, 0, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 115, null);
            return this;
        }

        public final Builder host(String host) {
            Intrinsics.checkNotNullParameter(host, "host");
            Builder $this$host_u24lambda_u240 = this;
            String encoded = _HostnamesCommonKt.toCanonicalHost(_UrlKt.percentDecode$default(host, 0, 0, false, 7, null));
            if (encoded == null) {
                throw new IllegalArgumentException("unexpected host: " + host);
            }
            $this$host_u24lambda_u240.host = encoded;
            return this;
        }

        public final Builder port(int port) {
            Builder $this$port_u24lambda_u240 = this;
            boolean z = false;
            if (1 <= port && port < 65536) {
                z = true;
            }
            if (!z) {
                throw new IllegalArgumentException(("unexpected port: " + port).toString());
            }
            $this$port_u24lambda_u240.port = port;
            return this;
        }

        public final Builder addPathSegment(String pathSegment) {
            Intrinsics.checkNotNullParameter(pathSegment, "pathSegment");
            Builder $this$addPathSegment_u24lambda_u240 = this;
            $this$addPathSegment_u24lambda_u240.push(pathSegment, 0, pathSegment.length(), false, false);
            return this;
        }

        public final Builder addPathSegments(String pathSegments) {
            Intrinsics.checkNotNullParameter(pathSegments, "pathSegments");
            return addPathSegments(pathSegments, false);
        }

        public final Builder addEncodedPathSegment(String encodedPathSegment) {
            Intrinsics.checkNotNullParameter(encodedPathSegment, "encodedPathSegment");
            Builder $this$addEncodedPathSegment_u24lambda_u240 = this;
            $this$addEncodedPathSegment_u24lambda_u240.push(encodedPathSegment, 0, encodedPathSegment.length(), false, true);
            return this;
        }

        public final Builder addEncodedPathSegments(String encodedPathSegments) {
            Intrinsics.checkNotNullParameter(encodedPathSegments, "encodedPathSegments");
            return addPathSegments(encodedPathSegments, true);
        }

        private final Builder addPathSegments(String pathSegments, boolean alreadyEncoded) {
            Builder $this$addPathSegments_u24lambda_u240 = this;
            int offset = 0;
            while (true) {
                int segmentEnd = _UtilCommonKt.delimiterOffset(pathSegments, "/\\", offset, pathSegments.length());
                boolean addTrailingSlash = segmentEnd < pathSegments.length();
                String pathSegments2 = pathSegments;
                boolean alreadyEncoded2 = alreadyEncoded;
                $this$addPathSegments_u24lambda_u240.push(pathSegments2, offset, segmentEnd, addTrailingSlash, alreadyEncoded2);
                offset = segmentEnd + 1;
                if (offset > pathSegments2.length()) {
                    return this;
                }
                pathSegments = pathSegments2;
                alreadyEncoded = alreadyEncoded2;
            }
        }

        public final Builder setPathSegment(int index, String pathSegment) {
            Intrinsics.checkNotNullParameter(pathSegment, "pathSegment");
            Builder $this$setPathSegment_u24lambda_u240 = this;
            String canonicalPathSegment = _UrlKt.canonicalize$default(pathSegment, 0, 0, _UrlKt.PATH_SEGMENT_ENCODE_SET, false, false, false, false, 123, null);
            if (!(($this$setPathSegment_u24lambda_u240.isDot(canonicalPathSegment) || $this$setPathSegment_u24lambda_u240.isDotDot(canonicalPathSegment)) ? false : true)) {
                throw new IllegalArgumentException(("unexpected path segment: " + pathSegment).toString());
            }
            $this$setPathSegment_u24lambda_u240.encodedPathSegments.set(index, canonicalPathSegment);
            return this;
        }

        public final Builder setEncodedPathSegment(int index, String encodedPathSegment) {
            Intrinsics.checkNotNullParameter(encodedPathSegment, "encodedPathSegment");
            Builder $this$setEncodedPathSegment_u24lambda_u240 = this;
            String canonicalPathSegment = _UrlKt.canonicalize$default(encodedPathSegment, 0, 0, _UrlKt.PATH_SEGMENT_ENCODE_SET, true, false, false, false, 115, null);
            $this$setEncodedPathSegment_u24lambda_u240.encodedPathSegments.set(index, canonicalPathSegment);
            if (($this$setEncodedPathSegment_u24lambda_u240.isDot(canonicalPathSegment) || $this$setEncodedPathSegment_u24lambda_u240.isDotDot(canonicalPathSegment)) ? false : true) {
                return this;
            }
            throw new IllegalArgumentException(("unexpected path segment: " + encodedPathSegment).toString());
        }

        public final Builder removePathSegment(int index) {
            Builder $this$removePathSegment_u24lambda_u240 = this;
            $this$removePathSegment_u24lambda_u240.encodedPathSegments.remove(index);
            if ($this$removePathSegment_u24lambda_u240.encodedPathSegments.isEmpty()) {
                $this$removePathSegment_u24lambda_u240.encodedPathSegments.add(_UrlKt.FRAGMENT_ENCODE_SET);
            }
            return this;
        }

        public final Builder encodedPath(String encodedPath) {
            Intrinsics.checkNotNullParameter(encodedPath, "encodedPath");
            Builder $this$encodedPath_u24lambda_u240 = this;
            if (!StringsKt.startsWith$default(encodedPath, "/", false, 2, (Object) null)) {
                throw new IllegalArgumentException(("unexpected encodedPath: " + encodedPath).toString());
            }
            $this$encodedPath_u24lambda_u240.resolvePath(encodedPath, 0, encodedPath.length());
            return this;
        }

        public final Builder query(String query) {
            String query2;
            Builder $this$query_u24lambda_u240 = this;
            $this$query_u24lambda_u240.encodedQueryNamesAndValues = (query == null || (query2 = _UrlKt.canonicalize$default(query, 0, 0, _UrlKt.QUERY_ENCODE_SET, false, false, true, false, 91, null)) == null) ? null : $this$query_u24lambda_u240.toQueryNamesAndValues(query2);
            return this;
        }

        public final Builder encodedQuery(String encodedQuery) {
            String encodedQuery2;
            Builder $this$encodedQuery_u24lambda_u240 = this;
            $this$encodedQuery_u24lambda_u240.encodedQueryNamesAndValues = (encodedQuery == null || (encodedQuery2 = _UrlKt.canonicalize$default(encodedQuery, 0, 0, _UrlKt.QUERY_ENCODE_SET, true, false, true, false, 83, null)) == null) ? null : $this$encodedQuery_u24lambda_u240.toQueryNamesAndValues(encodedQuery2);
            return this;
        }

        public final Builder addQueryParameter(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Builder $this$addQueryParameter_u24lambda_u240 = this;
            if ($this$addQueryParameter_u24lambda_u240.encodedQueryNamesAndValues == null) {
                $this$addQueryParameter_u24lambda_u240.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = $this$addQueryParameter_u24lambda_u240.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list);
            list.add(_UrlKt.canonicalize$default(name, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, 91, null));
            List<String> list2 = $this$addQueryParameter_u24lambda_u240.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list2);
            list2.add(value != null ? _UrlKt.canonicalize$default(value, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, 91, null) : null);
            return this;
        }

        public final Builder addEncodedQueryParameter(String encodedName, String encodedValue) {
            Intrinsics.checkNotNullParameter(encodedName, "encodedName");
            Builder $this$addEncodedQueryParameter_u24lambda_u240 = this;
            if ($this$addEncodedQueryParameter_u24lambda_u240.encodedQueryNamesAndValues == null) {
                $this$addEncodedQueryParameter_u24lambda_u240.encodedQueryNamesAndValues = new ArrayList();
            }
            List<String> list = $this$addEncodedQueryParameter_u24lambda_u240.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list);
            list.add(_UrlKt.canonicalize$default(encodedName, 0, 0, _UrlKt.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, 83, null));
            List<String> list2 = $this$addEncodedQueryParameter_u24lambda_u240.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list2);
            list2.add(encodedValue != null ? _UrlKt.canonicalize$default(encodedValue, 0, 0, _UrlKt.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, 83, null) : null);
            return this;
        }

        public final Builder setQueryParameter(String name, String value) {
            Intrinsics.checkNotNullParameter(name, "name");
            Builder $this$setQueryParameter_u24lambda_u240 = this;
            $this$setQueryParameter_u24lambda_u240.removeAllQueryParameters(name);
            $this$setQueryParameter_u24lambda_u240.addQueryParameter(name, value);
            return this;
        }

        public final Builder setEncodedQueryParameter(String encodedName, String encodedValue) {
            Intrinsics.checkNotNullParameter(encodedName, "encodedName");
            Builder $this$setEncodedQueryParameter_u24lambda_u240 = this;
            $this$setEncodedQueryParameter_u24lambda_u240.removeAllEncodedQueryParameters(encodedName);
            $this$setEncodedQueryParameter_u24lambda_u240.addEncodedQueryParameter(encodedName, encodedValue);
            return this;
        }

        public final Builder removeAllQueryParameters(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            Builder $this$removeAllQueryParameters_u24lambda_u240 = this;
            if ($this$removeAllQueryParameters_u24lambda_u240.encodedQueryNamesAndValues == null) {
                return $this$removeAllQueryParameters_u24lambda_u240;
            }
            String nameToRemove = _UrlKt.canonicalize$default(name, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET, false, false, true, false, 91, null);
            $this$removeAllQueryParameters_u24lambda_u240.removeAllCanonicalQueryParameters(nameToRemove);
            return this;
        }

        public final Builder removeAllEncodedQueryParameters(String encodedName) {
            Intrinsics.checkNotNullParameter(encodedName, "encodedName");
            Builder $this$removeAllEncodedQueryParameters_u24lambda_u240 = this;
            if ($this$removeAllEncodedQueryParameters_u24lambda_u240.encodedQueryNamesAndValues == null) {
                return $this$removeAllEncodedQueryParameters_u24lambda_u240;
            }
            $this$removeAllEncodedQueryParameters_u24lambda_u240.removeAllCanonicalQueryParameters(_UrlKt.canonicalize$default(encodedName, 0, 0, _UrlKt.QUERY_COMPONENT_REENCODE_SET, true, false, true, false, 83, null));
            return this;
        }

        private final void removeAllCanonicalQueryParameters(String canonicalName) {
            List<String> list = this.encodedQueryNamesAndValues;
            Intrinsics.checkNotNull(list);
            int size = list.size() - 2;
            int i = size;
            int progressionLastElement = ProgressionUtilKt.getProgressionLastElement(size, 0, -2);
            if (progressionLastElement > i) {
                return;
            }
            while (true) {
                List<String> list2 = this.encodedQueryNamesAndValues;
                Intrinsics.checkNotNull(list2);
                if (Intrinsics.areEqual(canonicalName, list2.get(i))) {
                    List<String> list3 = this.encodedQueryNamesAndValues;
                    Intrinsics.checkNotNull(list3);
                    list3.remove(i + 1);
                    List<String> list4 = this.encodedQueryNamesAndValues;
                    Intrinsics.checkNotNull(list4);
                    list4.remove(i);
                    List<String> list5 = this.encodedQueryNamesAndValues;
                    Intrinsics.checkNotNull(list5);
                    if (list5.isEmpty()) {
                        this.encodedQueryNamesAndValues = null;
                        return;
                    }
                }
                if (i == progressionLastElement) {
                    return;
                } else {
                    i -= 2;
                }
            }
        }

        public final Builder fragment(String fragment) {
            Builder $this$fragment_u24lambda_u240 = this;
            $this$fragment_u24lambda_u240.encodedFragment = fragment != null ? _UrlKt.canonicalize$default(fragment, 0, 0, _UrlKt.FRAGMENT_ENCODE_SET, false, false, false, true, 59, null) : null;
            return this;
        }

        public final Builder encodedFragment(String encodedFragment) {
            Builder $this$encodedFragment_u24lambda_u240 = this;
            $this$encodedFragment_u24lambda_u240.encodedFragment = encodedFragment != null ? _UrlKt.canonicalize$default(encodedFragment, 0, 0, _UrlKt.FRAGMENT_ENCODE_SET, true, false, false, true, 51, null) : null;
            return this;
        }

        public final Builder reencodeForUri$okhttp() {
            Builder $this$reencodeForUri_u24lambda_u240 = this;
            String str = $this$reencodeForUri_u24lambda_u240.host;
            $this$reencodeForUri_u24lambda_u240.host = str != null ? new Regex("[\"<>^`{|}]").replace(str, _UrlKt.FRAGMENT_ENCODE_SET) : null;
            int size = $this$reencodeForUri_u24lambda_u240.encodedPathSegments.size();
            for (int i = 0; i < size; i++) {
                $this$reencodeForUri_u24lambda_u240.encodedPathSegments.set(i, _UrlKt.canonicalize$default($this$reencodeForUri_u24lambda_u240.encodedPathSegments.get(i), 0, 0, _UrlKt.PATH_SEGMENT_ENCODE_SET_URI, true, true, false, false, 99, null));
            }
            List<String> list = $this$reencodeForUri_u24lambda_u240.encodedQueryNamesAndValues;
            if (list != null) {
                int size2 = list.size();
                for (int i2 = 0; i2 < size2; i2++) {
                    String str2 = list.get(i2);
                    list.set(i2, str2 != null ? _UrlKt.canonicalize$default(str2, 0, 0, _UrlKt.QUERY_COMPONENT_ENCODE_SET_URI, true, true, true, false, 67, null) : null);
                }
            }
            String str3 = $this$reencodeForUri_u24lambda_u240.encodedFragment;
            $this$reencodeForUri_u24lambda_u240.encodedFragment = str3 != null ? _UrlKt.canonicalize$default(str3, 0, 0, _UrlKt.FRAGMENT_ENCODE_SET_URI, true, true, false, true, 35, null) : null;
            return this;
        }

        public final HttpUrl build() {
            ArrayList arrayList;
            String str = this.scheme;
            if (str == null) {
                throw new IllegalStateException("scheme == null");
            }
            String strPercentDecode$default = _UrlKt.percentDecode$default(this.encodedUsername, 0, 0, false, 7, null);
            String strPercentDecode$default2 = _UrlKt.percentDecode$default(this.encodedPassword, 0, 0, false, 7, null);
            String str2 = this.host;
            if (str2 == null) {
                throw new IllegalStateException("host == null");
            }
            int iEffectivePort = effectivePort();
            Iterable $this$map$iv = this.encodedPathSegments;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (Object item$iv$iv : $this$map$iv) {
                destination$iv$iv.add(_UrlKt.percentDecode$default((String) item$iv$iv, 0, 0, false, 7, null));
            }
            ArrayList arrayList2 = (List) destination$iv$iv;
            Iterable $this$map$iv2 = this.encodedQueryNamesAndValues;
            if ($this$map$iv2 == null) {
                arrayList = null;
            } else {
                Iterable $this$map$iv3 = $this$map$iv2;
                Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv3, 10));
                for (Object item$iv$iv2 : $this$map$iv3) {
                    String it = (String) item$iv$iv2;
                    destination$iv$iv2.add(it != null ? _UrlKt.percentDecode$default(it, 0, 0, true, 3, null) : null);
                }
                arrayList = (List) destination$iv$iv2;
            }
            String str3 = this.encodedFragment;
            return new HttpUrl(str, strPercentDecode$default, strPercentDecode$default2, str2, iEffectivePort, arrayList2, arrayList, str3 != null ? _UrlKt.percentDecode$default(str3, 0, 0, false, 7, null) : null, toString(), null);
        }

        private final int effectivePort() {
            if (this.port != -1) {
                return this.port;
            }
            Companion companion = HttpUrl.Companion;
            String str = this.scheme;
            Intrinsics.checkNotNull(str);
            return companion.defaultPort(str);
        }

        public String toString() {
            StringBuilder $this$toString_u24lambda_u240 = new StringBuilder();
            if (this.scheme != null) {
                $this$toString_u24lambda_u240.append(this.scheme);
                $this$toString_u24lambda_u240.append("://");
            } else {
                $this$toString_u24lambda_u240.append("//");
            }
            if (this.encodedUsername.length() > 0) {
                $this$toString_u24lambda_u240.append(this.encodedUsername);
                if (this.encodedPassword.length() > 0) {
                    $this$toString_u24lambda_u240.append(AbstractJsonLexerKt.COLON);
                    $this$toString_u24lambda_u240.append(this.encodedPassword);
                }
                $this$toString_u24lambda_u240.append('@');
            } else {
                if (this.encodedPassword.length() > 0) {
                    $this$toString_u24lambda_u240.append(this.encodedUsername);
                    if (this.encodedPassword.length() > 0) {
                        $this$toString_u24lambda_u240.append(AbstractJsonLexerKt.COLON);
                        $this$toString_u24lambda_u240.append(this.encodedPassword);
                    }
                    $this$toString_u24lambda_u240.append('@');
                }
            }
            if (this.host != null) {
                String str = this.host;
                Intrinsics.checkNotNull(str);
                if (StringsKt.contains$default((CharSequence) str, AbstractJsonLexerKt.COLON, false, 2, (Object) null)) {
                    $this$toString_u24lambda_u240.append(AbstractJsonLexerKt.BEGIN_LIST);
                    $this$toString_u24lambda_u240.append(this.host);
                    $this$toString_u24lambda_u240.append(AbstractJsonLexerKt.END_LIST);
                } else {
                    $this$toString_u24lambda_u240.append(this.host);
                }
            }
            if (this.port != -1 || this.scheme != null) {
                int effectivePort = effectivePort();
                if (this.scheme != null) {
                    Companion companion = HttpUrl.Companion;
                    String str2 = this.scheme;
                    Intrinsics.checkNotNull(str2);
                    if (effectivePort != companion.defaultPort(str2)) {
                        $this$toString_u24lambda_u240.append(AbstractJsonLexerKt.COLON);
                        $this$toString_u24lambda_u240.append(effectivePort);
                    }
                } else {
                    $this$toString_u24lambda_u240.append(AbstractJsonLexerKt.COLON);
                    $this$toString_u24lambda_u240.append(effectivePort);
                }
            }
            toPathString(this.encodedPathSegments, $this$toString_u24lambda_u240);
            if (this.encodedQueryNamesAndValues != null) {
                $this$toString_u24lambda_u240.append('?');
                Companion companion2 = HttpUrl.Companion;
                List<String> list = this.encodedQueryNamesAndValues;
                Intrinsics.checkNotNull(list);
                companion2.toQueryString(list, $this$toString_u24lambda_u240);
            }
            if (this.encodedFragment != null) {
                $this$toString_u24lambda_u240.append('#');
                $this$toString_u24lambda_u240.append(this.encodedFragment);
            }
            return $this$toString_u24lambda_u240.toString();
        }

        private final void toPathString(List<String> list, StringBuilder out) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                out.append('/');
                out.append(list.get(i));
            }
        }

        public final Builder parse$okhttp(HttpUrl base, String input) {
            int iCharAt;
            int schemeDelimiterOffset;
            int componentDelimiterOffset;
            String str;
            int componentDelimiterOffset2;
            String str2 = input;
            Intrinsics.checkNotNullParameter(str2, "input");
            int pos = _UtilCommonKt.indexOfFirstNonAsciiWhitespace$default(str2, 0, 0, 3, null);
            int limit = _UtilCommonKt.indexOfLastNonAsciiWhitespace$default(str2, pos, 0, 2, null);
            int schemeDelimiterOffset2 = schemeDelimiterOffset(str2, pos, limit);
            int limit2 = -1;
            if (schemeDelimiterOffset2 != -1) {
                if (StringsKt.startsWith(str2, "https:", pos, true)) {
                    this.scheme = "https";
                    pos += 6;
                } else if (StringsKt.startsWith(str2, "http:", pos, true)) {
                    this.scheme = "http";
                    pos += 5;
                } else {
                    StringBuilder sbAppend = new StringBuilder().append("Expected URL scheme 'http' or 'https' but was '");
                    String strSubstring = str2.substring(0, schemeDelimiterOffset2);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    throw new IllegalArgumentException(sbAppend.append(strSubstring).append('\'').toString());
                }
            } else if (base != null) {
                this.scheme = base.scheme();
            } else {
                String truncated = str2.length() > 6 ? StringsKt.take(str2, 6) + "..." : str2;
                throw new IllegalArgumentException("Expected URL scheme 'http' or 'https' but no scheme was found for " + truncated);
            }
            int componentDelimiterOffset3 = slashCount(str2, pos, limit);
            int i = 35;
            if (componentDelimiterOffset3 >= 2 || base == null || !Intrinsics.areEqual(base.scheme(), this.scheme)) {
                int pos2 = pos + componentDelimiterOffset3;
                boolean hasUsername = false;
                boolean hasPassword = false;
                while (true) {
                    int componentDelimiterOffset4 = _UtilCommonKt.delimiterOffset(str2, "@/\\?#", pos2, limit);
                    if (componentDelimiterOffset4 != limit) {
                        iCharAt = str2.charAt(componentDelimiterOffset4);
                    } else {
                        iCharAt = limit2;
                    }
                    int c = iCharAt;
                    switch (c) {
                        case -1:
                        case 35:
                        case 47:
                        case 63:
                        case 92:
                            int schemeDelimiterOffset3 = limit2;
                            int portColonOffset = portColonOffset(str2, pos2, componentDelimiterOffset4);
                            if (portColonOffset + 1 < componentDelimiterOffset4) {
                                this.host = _HostnamesCommonKt.toCanonicalHost(_UrlKt.percentDecode$default(str2, pos2, portColonOffset, false, 4, null));
                                this.port = parsePort(str2, portColonOffset + 1, componentDelimiterOffset4);
                                if (!(this.port != schemeDelimiterOffset3)) {
                                    StringBuilder sbAppend2 = new StringBuilder().append("Invalid URL port: \"");
                                    String strSubstring2 = str2.substring(portColonOffset + 1, componentDelimiterOffset4);
                                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                                    throw new IllegalArgumentException(sbAppend2.append(strSubstring2).append('\"').toString().toString());
                                }
                            } else {
                                this.host = _HostnamesCommonKt.toCanonicalHost(_UrlKt.percentDecode$default(str2, pos2, portColonOffset, false, 4, null));
                                Companion companion = HttpUrl.Companion;
                                String str3 = this.scheme;
                                Intrinsics.checkNotNull(str3);
                                this.port = companion.defaultPort(str3);
                            }
                            if (!(this.host != null)) {
                                StringBuilder sbAppend3 = new StringBuilder().append("Invalid URL host: \"");
                                String strSubstring3 = str2.substring(pos2, portColonOffset);
                                Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                                throw new IllegalArgumentException(sbAppend3.append(strSubstring3).append('\"').toString().toString());
                            }
                            pos = componentDelimiterOffset4;
                            break;
                            break;
                        case 64:
                            if (hasPassword) {
                                schemeDelimiterOffset = limit2;
                                str2 = input;
                                componentDelimiterOffset = componentDelimiterOffset4;
                                this.encodedPassword += "%40" + _UrlKt.canonicalize$default(str2, pos2, componentDelimiterOffset4, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 112, null);
                            } else {
                                int passwordColonOffset = _UtilCommonKt.delimiterOffset(str2, AbstractJsonLexerKt.COLON, pos2, componentDelimiterOffset4);
                                schemeDelimiterOffset = limit2;
                                String canonicalUsername = _UrlKt.canonicalize$default(str2, pos2, passwordColonOffset, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 112, null);
                                if (hasUsername) {
                                    str = this.encodedUsername + "%40" + canonicalUsername;
                                } else {
                                    str = canonicalUsername;
                                }
                                this.encodedUsername = str;
                                if (passwordColonOffset != componentDelimiterOffset4) {
                                    hasPassword = true;
                                    componentDelimiterOffset2 = componentDelimiterOffset4;
                                    this.encodedPassword = _UrlKt.canonicalize$default(input, passwordColonOffset + 1, componentDelimiterOffset2, " \"':;<=>@[]^`{}|/\\?#", true, false, false, false, 112, null);
                                } else {
                                    componentDelimiterOffset2 = componentDelimiterOffset4;
                                }
                                hasUsername = true;
                                componentDelimiterOffset = componentDelimiterOffset2;
                                str2 = input;
                            }
                            pos2 = componentDelimiterOffset + 1;
                            limit2 = schemeDelimiterOffset;
                            schemeDelimiterOffset2 = schemeDelimiterOffset2;
                            componentDelimiterOffset3 = componentDelimiterOffset3;
                            i = 35;
                            continue;
                        default:
                            int slashCount = componentDelimiterOffset3;
                            limit2 = limit2;
                            schemeDelimiterOffset2 = schemeDelimiterOffset2;
                            componentDelimiterOffset3 = slashCount;
                            continue;
                    }
                }
            } else {
                this.encodedUsername = base.encodedUsername();
                this.encodedPassword = base.encodedPassword();
                this.host = base.host();
                this.port = base.port();
                this.encodedPathSegments.clear();
                this.encodedPathSegments.addAll(base.encodedPathSegments());
                if (pos == limit || str2.charAt(pos) == '#') {
                    encodedQuery(base.encodedQuery());
                }
            }
            int pathDelimiterOffset = _UtilCommonKt.delimiterOffset(str2, "?#", pos, limit);
            resolvePath(str2, pos, pathDelimiterOffset);
            int pos3 = pathDelimiterOffset;
            if (pos3 < limit && str2.charAt(pos3) == '?') {
                int queryDelimiterOffset = _UtilCommonKt.delimiterOffset(str2, '#', pos3, limit);
                this.encodedQueryNamesAndValues = toQueryNamesAndValues(_UrlKt.canonicalize$default(str2, pos3 + 1, queryDelimiterOffset, _UrlKt.QUERY_ENCODE_SET, true, false, true, false, 80, null));
                pos3 = queryDelimiterOffset;
            }
            if (pos3 < limit && str2.charAt(pos3) == '#') {
                this.encodedFragment = _UrlKt.canonicalize$default(str2, pos3 + 1, limit, _UrlKt.FRAGMENT_ENCODE_SET, true, false, false, true, 48, null);
            }
            return this;
        }

        private final void resolvePath(String input, int startPos, int limit) {
            int pos = startPos;
            if (pos == limit) {
                return;
            }
            char c = input.charAt(pos);
            switch (c) {
                case '/':
                case '\\':
                    this.encodedPathSegments.clear();
                    this.encodedPathSegments.add(_UrlKt.FRAGMENT_ENCODE_SET);
                    pos++;
                    break;
                default:
                    this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, _UrlKt.FRAGMENT_ENCODE_SET);
                    break;
            }
            int i = pos;
            while (i < limit) {
                int pathSegmentDelimiterOffset = _UtilCommonKt.delimiterOffset(input, "/\\", i, limit);
                boolean segmentHasTrailingSlash = pathSegmentDelimiterOffset < limit;
                input = input;
                push(input, i, pathSegmentDelimiterOffset, segmentHasTrailingSlash, true);
                i = pathSegmentDelimiterOffset;
                if (segmentHasTrailingSlash) {
                    i++;
                }
            }
        }

        private final void push(String input, int pos, int limit, boolean addTrailingSlash, boolean alreadyEncoded) {
            String segment = _UrlKt.canonicalize$default(input, pos, limit, _UrlKt.PATH_SEGMENT_ENCODE_SET, alreadyEncoded, false, false, false, 112, null);
            if (isDot(segment)) {
                return;
            }
            if (isDotDot(segment)) {
                pop();
                return;
            }
            if (this.encodedPathSegments.get(this.encodedPathSegments.size() - 1).length() == 0) {
                this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, segment);
            } else {
                this.encodedPathSegments.add(segment);
            }
            if (addTrailingSlash) {
                this.encodedPathSegments.add(_UrlKt.FRAGMENT_ENCODE_SET);
            }
        }

        private final void pop() {
            String removed = this.encodedPathSegments.remove(this.encodedPathSegments.size() - 1);
            if ((removed.length() == 0) && !this.encodedPathSegments.isEmpty()) {
                this.encodedPathSegments.set(this.encodedPathSegments.size() - 1, _UrlKt.FRAGMENT_ENCODE_SET);
            } else {
                this.encodedPathSegments.add(_UrlKt.FRAGMENT_ENCODE_SET);
            }
        }

        private final boolean isDot(String input) {
            return Intrinsics.areEqual(input, ".") || StringsKt.equals(input, "%2e", true);
        }

        private final boolean isDotDot(String input) {
            return Intrinsics.areEqual(input, "..") || StringsKt.equals(input, "%2e.", true) || StringsKt.equals(input, ".%2e", true) || StringsKt.equals(input, "%2e%2e", true);
        }

        private final List<String> toQueryNamesAndValues(String $this$toQueryNamesAndValues) {
            List result = new ArrayList();
            int pos = 0;
            while (pos <= $this$toQueryNamesAndValues.length()) {
                int ampersandOffset = StringsKt.indexOf$default((CharSequence) $this$toQueryNamesAndValues, Typography.amp, pos, false, 4, (Object) null);
                if (ampersandOffset == -1) {
                    ampersandOffset = $this$toQueryNamesAndValues.length();
                }
                int equalsOffset = StringsKt.indexOf$default((CharSequence) $this$toQueryNamesAndValues, '=', pos, false, 4, (Object) null);
                if (equalsOffset == -1 || equalsOffset > ampersandOffset) {
                    String strSubstring = $this$toQueryNamesAndValues.substring(pos, ampersandOffset);
                    Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    result.add(strSubstring);
                    result.add(null);
                } else {
                    String strSubstring2 = $this$toQueryNamesAndValues.substring(pos, equalsOffset);
                    Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                    result.add(strSubstring2);
                    String strSubstring3 = $this$toQueryNamesAndValues.substring(equalsOffset + 1, ampersandOffset);
                    Intrinsics.checkNotNullExpressionValue(strSubstring3, "substring(...)");
                    result.add(strSubstring3);
                }
                pos = ampersandOffset + 1;
            }
            return result;
        }

        private final int schemeDelimiterOffset(String input, int pos, int limit) {
            if (limit - pos < 2) {
                return -1;
            }
            char c0 = input.charAt(pos);
            if ((Intrinsics.compare((int) c0, 97) < 0 || Intrinsics.compare((int) c0, 122) > 0) && (Intrinsics.compare((int) c0, 65) < 0 || Intrinsics.compare((int) c0, 90) > 0)) {
                return -1;
            }
            for (int i = pos + 1; i < limit; i++) {
                char cCharAt = input.charAt(i);
                if (!('a' <= cCharAt && cCharAt < '{')) {
                    if ('A' <= cCharAt && cCharAt < '[') {
                        continue;
                    } else {
                        if (!('0' <= cCharAt && cCharAt < ':') && cCharAt != '+' && cCharAt != '-' && cCharAt != '.') {
                            if (cCharAt == ':') {
                                return i;
                            }
                            return -1;
                        }
                    }
                }
            }
            return -1;
        }

        private final int slashCount(String $this$slashCount, int pos, int limit) {
            int slashCount = 0;
            for (int i = pos; i < limit; i++) {
                char c = $this$slashCount.charAt(i);
                switch (c) {
                    case '/':
                    case '\\':
                        slashCount++;
                        break;
                    default:
                        return slashCount;
                }
            }
            return slashCount;
        }

        private final int portColonOffset(String input, int pos, int limit) {
            int i = pos;
            while (i < limit) {
                switch (input.charAt(i)) {
                    case ':':
                        return i;
                    case '[':
                        break;
                    default:
                        continue;
                        i++;
                        break;
                }
                do {
                    i++;
                    if (i >= limit) {
                        break;
                    }
                } while (input.charAt(i) != ']');
                i++;
            }
            return limit;
        }

        private final int parsePort(String input, int pos, int limit) {
            try {
                String portString = _UrlKt.canonicalize$default(input, pos, limit, _UrlKt.FRAGMENT_ENCODE_SET, false, false, false, false, 120, null);
                int i = Integer.parseInt(portString);
                boolean z = false;
                if (1 <= i && i < 65536) {
                    z = true;
                }
                if (z) {
                    return i;
                }
                return -1;
            } catch (NumberFormatException e) {
                return -1;
            }
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0007J \u0010\b\u001a\u00020\t*\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\n2\n\u0010\u000b\u001a\u00060\fj\u0002`\rH\u0002J\u0011\u0010\u000e\u001a\u00020\u000f*\u00020\u0007H\u0007¢\u0006\u0002\b\u0010J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000f*\u00020\u0007H\u0007¢\u0006\u0002\b\u0012J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000f*\u00020\u0013H\u0007¢\u0006\u0002\b\u0010J\u0013\u0010\u0011\u001a\u0004\u0018\u00010\u000f*\u00020\u0014H\u0007¢\u0006\u0002\b\u0010J\u0015\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u0016J\u0017\u0010\u0012\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u0007H\u0007¢\u0006\u0002\b\u0017J\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0015\u001a\u00020\u0013H\u0007¢\u0006\u0002\b\u0016J\u0017\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0018\u001a\u00020\u0014H\u0007¢\u0006\u0002\b\u0016¨\u0006\u0019"}, d2 = {"Lni/shikatu/okhttp3/HttpUrl$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "defaultPort", _UrlKt.FRAGMENT_ENCODE_SET, "scheme", _UrlKt.FRAGMENT_ENCODE_SET, "toQueryString", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "out", "Ljava/lang/StringBuilder;", "Lni/shikatu/kotlin/text/StringBuilder;", "toHttpUrl", "Lni/shikatu/okhttp3/HttpUrl;", "get", "toHttpUrlOrNull", "parse", "Ljava/net/URL;", "Ljava/net/URI;", "url", "-deprecated_get", "-deprecated_parse", "uri", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final int defaultPort(String scheme) {
            Intrinsics.checkNotNullParameter(scheme, "scheme");
            if (Intrinsics.areEqual(scheme, "http")) {
                return 80;
            }
            return Intrinsics.areEqual(scheme, "https") ? 443 : -1;
        }

        public final void toQueryString(List<String> list, StringBuilder out) {
            IntProgression intProgressionStep = RangesKt.step(RangesKt.until(0, list.size()), 2);
            int i = intProgressionStep.getFirst();
            int last = intProgressionStep.getLast();
            int step = intProgressionStep.getStep();
            if ((step <= 0 || i > last) && (step >= 0 || last > i)) {
                return;
            }
            while (true) {
                String name = list.get(i);
                String value = list.get(i + 1);
                if (i > 0) {
                    out.append(Typography.amp);
                }
                out.append(name);
                if (value != null) {
                    out.append('=');
                    out.append(value);
                }
                if (i == last) {
                    return;
                } else {
                    i += step;
                }
            }
        }

        @JvmStatic
        public final HttpUrl get(String $this$toHttpUrl) {
            Intrinsics.checkNotNullParameter($this$toHttpUrl, "<this>");
            return new Builder().parse$okhttp(null, $this$toHttpUrl).build();
        }

        @JvmStatic
        public final HttpUrl parse(String $this$toHttpUrlOrNull) {
            Intrinsics.checkNotNullParameter($this$toHttpUrlOrNull, "<this>");
            try {
                return get($this$toHttpUrlOrNull);
            } catch (IllegalArgumentException e) {
                return null;
            }
        }

        @JvmStatic
        public final HttpUrl get(URL $this$toHttpUrlOrNull) {
            Intrinsics.checkNotNullParameter($this$toHttpUrlOrNull, "<this>");
            String string = $this$toHttpUrlOrNull.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return parse(string);
        }

        @JvmStatic
        public final HttpUrl get(URI $this$toHttpUrlOrNull) {
            Intrinsics.checkNotNullParameter($this$toHttpUrlOrNull, "<this>");
            String string = $this$toHttpUrlOrNull.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            return parse(string);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrl()", imports = {"ni.shikatu.okhttp3.HttpUrl.Companion.toHttpUrl"}))

        public final HttpUrl m1664deprecated_get(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return get(url);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrlOrNull()", imports = {"ni.shikatu.okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))

        public final HttpUrl m1667deprecated_parse(String url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return parse(url);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "url.toHttpUrlOrNull()", imports = {"ni.shikatu.okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))

        public final HttpUrl m1666deprecated_get(URL url) {
            Intrinsics.checkNotNullParameter(url, "url");
            return get(url);
        }

        @Deprecated(level = DeprecationLevel.ERROR, message = "moved to extension function", replaceWith = @ReplaceWith(expression = "uri.toHttpUrlOrNull()", imports = {"ni.shikatu.okhttp3.HttpUrl.Companion.toHttpUrlOrNull"}))

        public final HttpUrl m1665deprecated_get(URI uri) {
            Intrinsics.checkNotNullParameter(uri, "uri");
            return get(uri);
        }
    }

    @JvmStatic
    public static final int defaultPort(String scheme) {
        return Companion.defaultPort(scheme);
    }

    @JvmStatic
    public static final HttpUrl get(String $this$get) {
        return Companion.get($this$get);
    }

    @JvmStatic
    public static final HttpUrl parse(String $this$parse) {
        return Companion.parse($this$parse);
    }

    @JvmStatic
    public static final HttpUrl get(URL $this$get) {
        return Companion.get($this$get);
    }

    @JvmStatic
    public static final HttpUrl get(URI $this$get) {
        return Companion.get($this$get);
    }
}
