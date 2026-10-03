package ni.shikatu.okhttp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.JvmStatic;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.jvm.internal.LongCompanionObject;
import ni.shikatu.kotlin.text.Regex;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.internal._HostnamesCommonKt;
import ni.shikatu.okhttp3.internal._UtilCommonKt;
import ni.shikatu.okhttp3.internal._UtilJvmKt;
import ni.shikatu.okhttp3.internal.http.DateFormattingKt;
import ni.shikatu.okhttp3.internal.publicsuffix.PublicSuffixDatabase;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 *2\u00020\u0001:\u0002)*B[\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\r\u001a\u00020\n\u0012\b\u0010\u000e\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u000f\u0010\u0010J\u000e\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\n2\b\u0010\u0018\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0017J\b\u0010\u001b\u001a\u00020\u0003H\u0016J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001cJ\r\u0010\u0004\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u001dJ\r\u0010\f\u001a\u00020\nH\u0007¢\u0006\u0002\b\u001eJ\r\u0010\u0005\u001a\u00020\u0006H\u0007¢\u0006\u0002\b\u001fJ\r\u0010\r\u001a\u00020\nH\u0007¢\u0006\u0002\b J\r\u0010\u0007\u001a\u00020\u0003H\u0007¢\u0006\u0002\b!J\r\u0010\b\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\"J\r\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0002\b#J\r\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\b$J\u0015\u0010\u001b\u001a\u00020\u00032\u0006\u0010%\u001a\u00020\nH\u0000¢\u0006\u0002\b&J\u0006\u0010'\u001a\u00020(R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0011R\u0013\u0010\u0004\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0011R\u0013\u0010\u0005\u001a\u00020\u00068\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0012R\u0013\u0010\u0007\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0011R\u0013\u0010\b\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0011R\u0013\u0010\t\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\u0013R\u0013\u0010\u000b\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0013R\u0013\u0010\f\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0013R\u0013\u0010\r\u001a\u00020\n8\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0013R\u0015\u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0011¨\u0006+"}, d2 = {"Lni/shikatu/okhttp3/Cookie;", _UrlKt.FRAGMENT_ENCODE_SET, "name", _UrlKt.FRAGMENT_ENCODE_SET, "value", "expiresAt", _UrlKt.FRAGMENT_ENCODE_SET, "domain", "path", "secure", _UrlKt.FRAGMENT_ENCODE_SET, "httpOnly", "persistent", "hostOnly", "sameSite", "<init>", "(Ljava/lang/String;Ljava/lang/String;JLjava/lang/String;Ljava/lang/String;ZZZZLjava/lang/String;)V", "()Ljava/lang/String;", "()J", "()Z", "matches", "url", "Lni/shikatu/okhttp3/HttpUrl;", "equals", "other", "hashCode", _UrlKt.FRAGMENT_ENCODE_SET, "toString", "-deprecated_name", "-deprecated_value", "-deprecated_persistent", "-deprecated_expiresAt", "-deprecated_hostOnly", "-deprecated_domain", "-deprecated_path", "-deprecated_httpOnly", "-deprecated_secure", "forObsoleteRfc2965", "toString$okhttp", "newBuilder", "Lni/shikatu/okhttp3/Cookie$Builder;", "Builder", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class Cookie {
    private final String domain;
    private final long expiresAt;
    private final boolean hostOnly;
    private final boolean httpOnly;
    private final String name;
    private final String path;
    private final boolean persistent;
    private final String sameSite;
    private final boolean secure;
    private final String value;
    public static final Companion Companion = new Companion(null);
    private static final Pattern YEAR_PATTERN = Pattern.compile("(\\d{2,4})[^\\d]*");
    private static final Pattern MONTH_PATTERN = Pattern.compile("(?i)(jan|feb|mar|apr|may|jun|jul|aug|sep|oct|nov|dec).*");
    private static final Pattern DAY_OF_MONTH_PATTERN = Pattern.compile("(\\d{1,2})[^\\d]*");
    private static final Pattern TIME_PATTERN = Pattern.compile("(\\d{1,2}):(\\d{1,2}):(\\d{1,2})[^\\d]*");

    public  Cookie(String str, String str2, long j, String str3, String str4, boolean z, boolean z2, boolean z3, boolean z4, String str5, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, j, str3, str4, z, z2, z3, z4, str5);
    }

    private Cookie(String name, String value, long expiresAt, String domain, String path, boolean secure, boolean httpOnly, boolean persistent, boolean hostOnly, String sameSite) {
        this.name = name;
        this.value = value;
        this.expiresAt = expiresAt;
        this.domain = domain;
        this.path = path;
        this.secure = secure;
        this.httpOnly = httpOnly;
        this.persistent = persistent;
        this.hostOnly = hostOnly;
        this.sameSite = sameSite;
    }

    public final String name() {
        return this.name;
    }

    public final String value() {
        return this.value;
    }

    public final long expiresAt() {
        return this.expiresAt;
    }

    public final String domain() {
        return this.domain;
    }

    public final String path() {
        return this.path;
    }

    public final boolean secure() {
        return this.secure;
    }

    public final boolean httpOnly() {
        return this.httpOnly;
    }

    public final boolean persistent() {
        return this.persistent;
    }

    public final boolean hostOnly() {
        return this.hostOnly;
    }

    public final String sameSite() {
        return this.sameSite;
    }

    public final boolean matches(HttpUrl url) {
        boolean domainMatch;
        Intrinsics.checkNotNullParameter(url, "url");
        if (this.hostOnly) {
            domainMatch = Intrinsics.areEqual(url.host(), this.domain);
        } else {
            domainMatch = Companion.domainMatch(url.host(), this.domain);
        }
        if (domainMatch && Companion.pathMatch(url, this.path)) {
            return !this.secure || url.isHttps();
        }
        return false;
    }

    public boolean equals(Object other) {
        return (other instanceof Cookie) && Intrinsics.areEqual(((Cookie) other).name, this.name) && Intrinsics.areEqual(((Cookie) other).value, this.value) && ((Cookie) other).expiresAt == this.expiresAt && Intrinsics.areEqual(((Cookie) other).domain, this.domain) && Intrinsics.areEqual(((Cookie) other).path, this.path) && ((Cookie) other).secure == this.secure && ((Cookie) other).httpOnly == this.httpOnly && ((Cookie) other).persistent == this.persistent && ((Cookie) other).hostOnly == this.hostOnly && Intrinsics.areEqual(((Cookie) other).sameSite, this.sameSite);
    }

    public int hashCode() {
        int result = (17 * 31) + this.name.hashCode();
        int result2 = ((((((((((((((((result * 31) + this.value.hashCode()) * 31) + Long.hashCode(this.expiresAt)) * 31) + this.domain.hashCode()) * 31) + this.path.hashCode()) * 31) + Boolean.hashCode(this.secure)) * 31) + Boolean.hashCode(this.httpOnly)) * 31) + Boolean.hashCode(this.persistent)) * 31) + Boolean.hashCode(this.hostOnly)) * 31;
        String str = this.sameSite;
        return result2 + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return toString$okhttp(false);
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "name", imports = {}))

    public final String m1627deprecated_name() {
        return this.name;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "value", imports = {}))

    public final String m1631deprecated_value() {
        return this.value;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "persistent", imports = {}))

    public final boolean m1629deprecated_persistent() {
        return this.persistent;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "expiresAt", imports = {}))

    public final long m1624deprecated_expiresAt() {
        return this.expiresAt;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "hostOnly", imports = {}))

    public final boolean m1625deprecated_hostOnly() {
        return this.hostOnly;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "domain", imports = {}))

    public final String m1623deprecated_domain() {
        return this.domain;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "path", imports = {}))

    public final String m1628deprecated_path() {
        return this.path;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "httpOnly", imports = {}))

    public final boolean m1626deprecated_httpOnly() {
        return this.httpOnly;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "secure", imports = {}))

    public final boolean m1630deprecated_secure() {
        return this.secure;
    }

    public final String toString$okhttp(boolean forObsoleteRfc2965) {
        StringBuilder $this$toString_u24lambda_u240 = new StringBuilder();
        $this$toString_u24lambda_u240.append(this.name);
        $this$toString_u24lambda_u240.append('=');
        $this$toString_u24lambda_u240.append(this.value);
        if (this.persistent) {
            if (this.expiresAt == Long.MIN_VALUE) {
                $this$toString_u24lambda_u240.append("; max-age=0");
            } else {
                $this$toString_u24lambda_u240.append("; expires=").append(DateFormattingKt.toHttpDateString(new Date(this.expiresAt)));
            }
        }
        if (!this.hostOnly) {
            $this$toString_u24lambda_u240.append("; domain=");
            if (forObsoleteRfc2965) {
                $this$toString_u24lambda_u240.append(".");
            }
            $this$toString_u24lambda_u240.append(this.domain);
        }
        $this$toString_u24lambda_u240.append("; path=").append(this.path);
        if (this.secure) {
            $this$toString_u24lambda_u240.append("; secure");
        }
        if (this.httpOnly) {
            $this$toString_u24lambda_u240.append("; httponly");
        }
        if (this.sameSite != null) {
            $this$toString_u24lambda_u240.append("; samesite=").append(this.sameSite);
        }
        String string = $this$toString_u24lambda_u240.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final Builder newBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0010\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\bJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u000bJ\u000e\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bJ\u000e\u0010\u0014\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\bJ\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\bJ\u0006\u0010\u000e\u001a\u00020\u0000J\u0006\u0010\u0010\u001a\u00020\u0000J\u000e\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\bJ\u0006\u0010\u0015\u001a\u00020\u0005R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lni/shikatu/okhttp3/Cookie$Builder;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "cookie", "Lni/shikatu/okhttp3/Cookie;", "(Lokhttp3/Cookie;)V", "name", _UrlKt.FRAGMENT_ENCODE_SET, "value", "expiresAt", _UrlKt.FRAGMENT_ENCODE_SET, "domain", "path", "secure", _UrlKt.FRAGMENT_ENCODE_SET, "httpOnly", "persistent", "hostOnly", "sameSite", "hostOnlyDomain", "build", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Builder {
        private String domain;
        private long expiresAt;
        private boolean hostOnly;
        private boolean httpOnly;
        private String name;
        private String path;
        private boolean persistent;
        private String sameSite;
        private boolean secure;
        private String value;

        public Builder() {
            this.expiresAt = DateFormattingKt.MAX_DATE;
            this.path = "/";
        }

        public Builder(Cookie cookie) {
            this();
            Intrinsics.checkNotNullParameter(cookie, "cookie");
            this.name = cookie.name();
            this.value = cookie.value();
            this.expiresAt = cookie.expiresAt();
            this.domain = cookie.domain();
            this.path = cookie.path();
            this.secure = cookie.secure();
            this.httpOnly = cookie.httpOnly();
            this.persistent = cookie.persistent();
            this.hostOnly = cookie.hostOnly();
            this.sameSite = cookie.sameSite();
        }

        public final Builder name(String name) {
            Intrinsics.checkNotNullParameter(name, "name");
            Builder $this$name_u24lambda_u240 = this;
            if (!Intrinsics.areEqual(StringsKt.trim((CharSequence) name).toString(), name)) {
                throw new IllegalArgumentException("name is not trimmed".toString());
            }
            $this$name_u24lambda_u240.name = name;
            return this;
        }

        public final Builder value(String value) {
            Intrinsics.checkNotNullParameter(value, "value");
            Builder $this$value_u24lambda_u240 = this;
            if (!Intrinsics.areEqual(StringsKt.trim((CharSequence) value).toString(), value)) {
                throw new IllegalArgumentException("value is not trimmed".toString());
            }
            $this$value_u24lambda_u240.value = value;
            return this;
        }

        public final Builder expiresAt(long expiresAt) {
            Builder $this$expiresAt_u24lambda_u240 = this;
            long expiresAt2 = expiresAt;
            if (expiresAt2 <= 0) {
                expiresAt2 = Long.MIN_VALUE;
            }
            if (expiresAt2 > DateFormattingKt.MAX_DATE) {
                expiresAt2 = DateFormattingKt.MAX_DATE;
            }
            $this$expiresAt_u24lambda_u240.expiresAt = expiresAt2;
            $this$expiresAt_u24lambda_u240.persistent = true;
            return this;
        }

        public final Builder domain(String domain) {
            Intrinsics.checkNotNullParameter(domain, "domain");
            return domain(domain, false);
        }

        public final Builder hostOnlyDomain(String domain) {
            Intrinsics.checkNotNullParameter(domain, "domain");
            return domain(domain, true);
        }

        private final Builder domain(String domain, boolean hostOnly) {
            Builder $this$domain_u24lambda_u240 = this;
            String canonicalDomain = _HostnamesCommonKt.toCanonicalHost(domain);
            if (canonicalDomain == null) {
                throw new IllegalArgumentException("unexpected domain: " + domain);
            }
            $this$domain_u24lambda_u240.domain = canonicalDomain;
            $this$domain_u24lambda_u240.hostOnly = hostOnly;
            return this;
        }

        public final Builder path(String path) {
            Intrinsics.checkNotNullParameter(path, "path");
            Builder $this$path_u24lambda_u240 = this;
            if (!StringsKt.startsWith$default(path, "/", false, 2, (Object) null)) {
                throw new IllegalArgumentException("path must start with '/'".toString());
            }
            $this$path_u24lambda_u240.path = path;
            return this;
        }

        public final Builder secure() {
            Builder $this$secure_u24lambda_u240 = this;
            $this$secure_u24lambda_u240.secure = true;
            return this;
        }

        public final Builder httpOnly() {
            Builder $this$httpOnly_u24lambda_u240 = this;
            $this$httpOnly_u24lambda_u240.httpOnly = true;
            return this;
        }

        public final Builder sameSite(String sameSite) {
            Intrinsics.checkNotNullParameter(sameSite, "sameSite");
            Builder $this$sameSite_u24lambda_u240 = this;
            if (!Intrinsics.areEqual(StringsKt.trim((CharSequence) sameSite).toString(), sameSite)) {
                throw new IllegalArgumentException("sameSite is not trimmed".toString());
            }
            $this$sameSite_u24lambda_u240.sameSite = sameSite;
            return this;
        }

        public final Cookie build() {
            String str = this.name;
            if (str == null) {
                throw new NullPointerException("builder.name == null");
            }
            String str2 = this.value;
            if (str2 == null) {
                throw new NullPointerException("builder.value == null");
            }
            long j = this.expiresAt;
            String str3 = this.domain;
            if (str3 != null) {
                return new Cookie(str, str2, j, str3, this.path, this.secure, this.httpOnly, this.persistent, this.hostOnly, this.sameSite, null);
            }
            throw new NullPointerException("builder.domain == null");
        }
    }

    @Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0002J\u0018\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\rH\u0002J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\rH\u0007J'\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\rH\u0000¢\u0006\u0002\b\u0018J \u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002J(\u0010\u001e\u001a\u00020\u001c2\u0006\u0010\u001f\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010 \u001a\u00020\u000bH\u0002J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\rH\u0002J\u0010\u0010\"\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\rH\u0002J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00140$2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010%\u001a\u00020&H\u0007R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lni/shikatu/okhttp3/Cookie$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "YEAR_PATTERN", "Ljava/util/regex/Pattern;", "ni.shikatu.kotlin.jvm.PlatformType", "MONTH_PATTERN", "DAY_OF_MONTH_PATTERN", "TIME_PATTERN", "domainMatch", _UrlKt.FRAGMENT_ENCODE_SET, "urlHost", _UrlKt.FRAGMENT_ENCODE_SET, "domain", "pathMatch", "url", "Lni/shikatu/okhttp3/HttpUrl;", "path", "parse", "Lni/shikatu/okhttp3/Cookie;", "setCookie", "currentTimeMillis", _UrlKt.FRAGMENT_ENCODE_SET, "parse$okhttp", "parseExpires", "s", "pos", _UrlKt.FRAGMENT_ENCODE_SET, "limit", "dateCharacterOffset", "input", "invert", "parseMaxAge", "parseDomain", "parseAll", _UrlKt.FRAGMENT_ENCODE_SET, "headers", "Lni/shikatu/okhttp3/Headers;", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean domainMatch(String urlHost, String domain) {
            if (Intrinsics.areEqual(urlHost, domain)) {
                return true;
            }
            return StringsKt.endsWith$default(urlHost, domain, false, 2, (Object) null) && urlHost.charAt((urlHost.length() - domain.length()) - 1) == '.' && !_HostnamesCommonKt.canParseAsIpAddress(urlHost);
        }

        public final boolean pathMatch(HttpUrl url, String path) {
            String urlPath = url.encodedPath();
            if (Intrinsics.areEqual(urlPath, path)) {
                return true;
            }
            return StringsKt.startsWith$default(urlPath, path, false, 2, (Object) null) && (StringsKt.endsWith$default(path, "/", false, 2, (Object) null) || urlPath.charAt(path.length()) == '/');
        }

        @JvmStatic
        public final Cookie parse(HttpUrl url, String setCookie) {
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(setCookie, "setCookie");
            return parse$okhttp(System.currentTimeMillis(), url, setCookie);
        }

        public final Cookie parse$okhttp(long currentTimeMillis, HttpUrl url, String setCookie) {
            long deltaMilliseconds;
            String strTrimSubstring;
            int limit;
            int limit2;
            String attributeValue = setCookie;
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(attributeValue, "setCookie");
            int cookiePairEnd = _UtilCommonKt.delimiterOffset$default(attributeValue, ';', 0, 0, 6, (Object) null);
            int pairEqualsSign = _UtilCommonKt.delimiterOffset$default(attributeValue, '=', 0, cookiePairEnd, 2, (Object) null);
            if (pairEqualsSign == cookiePairEnd) {
                return null;
            }
            String cookieName = _UtilCommonKt.trimSubstring$default(attributeValue, 0, pairEqualsSign, 1, null);
            if (!(cookieName.length() == 0) && _UtilCommonKt.indexOfControlOrNonAscii(cookieName) == -1) {
                String cookieValue = _UtilCommonKt.trimSubstring(attributeValue, pairEqualsSign + 1, cookiePairEnd);
                if (_UtilCommonKt.indexOfControlOrNonAscii(cookieValue) != -1) {
                    return null;
                }
                boolean secureOnly = false;
                boolean httpOnly = false;
                String sameSite = null;
                int pos = cookiePairEnd + 1;
                int limit3 = attributeValue.length();
                boolean hostOnly = true;
                boolean persistent = false;
                long deltaSeconds = -1;
                int pos2 = pos;
                long expiresAt = 253402300799999L;
                String path = null;
                String domain = null;
                while (pos2 < limit3) {
                    int attributePairEnd = _UtilCommonKt.delimiterOffset(attributeValue, ';', pos2, limit3);
                    int attributeEqualsSign = _UtilCommonKt.delimiterOffset(attributeValue, '=', pos2, attributePairEnd);
                    int pairEqualsSign2 = pairEqualsSign;
                    String attributeName = _UtilCommonKt.trimSubstring(attributeValue, pos2, attributeEqualsSign);
                    if (attributeEqualsSign < attributePairEnd) {
                        strTrimSubstring = _UtilCommonKt.trimSubstring(attributeValue, attributeEqualsSign + 1, attributePairEnd);
                    } else {
                        strTrimSubstring = _UrlKt.FRAGMENT_ENCODE_SET;
                    }
                    String attributeValue2 = strTrimSubstring;
                    if (StringsKt.equals(attributeName, "expires", true)) {
                        try {
                            int length = attributeValue2.length();
                            limit = limit3;
                            try {
                                long expiresAt2 = parseExpires(attributeValue2, 0, length);
                                persistent = true;
                                expiresAt = expiresAt2;
                                limit2 = 1;
                            } catch (IllegalArgumentException e) {
                                limit2 = 1;
                            }
                        } catch (IllegalArgumentException e2) {
                            limit = limit3;
                        }
                    } else {
                        limit = limit3;
                        if (StringsKt.equals(attributeName, "max-age", true)) {
                            try {
                                long deltaSeconds2 = parseMaxAge(attributeValue2);
                                persistent = true;
                                deltaSeconds = deltaSeconds2;
                                limit2 = 1;
                            } catch (NumberFormatException e3) {
                                limit2 = 1;
                            }
                        } else if (StringsKt.equals(attributeName, "domain", true)) {
                            try {
                                String domain2 = parseDomain(attributeValue2);
                                domain = domain2;
                                hostOnly = false;
                                limit2 = 1;
                            } catch (IllegalArgumentException e4) {
                                limit2 = 1;
                            }
                        } else {
                            limit2 = 1;
                            if (StringsKt.equals(attributeName, "path", true)) {
                                path = attributeValue2;
                            } else if (StringsKt.equals(attributeName, "secure", true)) {
                                secureOnly = true;
                            } else if (StringsKt.equals(attributeName, "httponly", true)) {
                                httpOnly = true;
                            } else if (StringsKt.equals(attributeName, "samesite", true)) {
                                sameSite = attributeValue2;
                            }
                        }
                    }
                    pos2 = attributePairEnd + 1;
                    attributeValue = setCookie;
                    pairEqualsSign = pairEqualsSign2;
                    limit3 = limit;
                }
                if (deltaSeconds == Long.MIN_VALUE) {
                    expiresAt = Long.MIN_VALUE;
                } else if (deltaSeconds != -1) {
                    if (deltaSeconds <= 9223372036854775L) {
                        deltaMilliseconds = ((long) 1000) * deltaSeconds;
                    } else {
                        deltaMilliseconds = LongCompanionObject.MAX_VALUE;
                    }
                    expiresAt = currentTimeMillis + deltaMilliseconds;
                    if (expiresAt < currentTimeMillis || expiresAt > DateFormattingKt.MAX_DATE) {
                        expiresAt = DateFormattingKt.MAX_DATE;
                    }
                }
                String urlHost = url.host();
                if (domain == null) {
                    domain = urlHost;
                } else if (!domainMatch(urlHost, domain)) {
                    return null;
                }
                if (urlHost.length() != domain.length() && PublicSuffixDatabase.Companion.get().getEffectiveTldPlusOne(domain) == null) {
                    return null;
                }
                String strSubstring = "/";
                if (path == null || !StringsKt.startsWith$default(path, "/", false, 2, (Object) null)) {
                    String encodedPath = url.encodedPath();
                    int lastSlash = StringsKt.lastIndexOf$default((CharSequence) encodedPath, '/', 0, false, 6, (Object) null);
                    if (lastSlash != 0) {
                        strSubstring = encodedPath.substring(0, lastSlash);
                        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                    }
                    path = strSubstring;
                }
                return new Cookie(cookieName, cookieValue, expiresAt, domain, path, secureOnly, httpOnly, persistent, hostOnly, sameSite, null);
            }
            return null;
        }

        private final long parseExpires(String s, int pos, int limit) {
            int pos2 = dateCharacterOffset(s, pos, limit, false);
            int hour = -1;
            int minute = -1;
            int second = -1;
            int dayOfMonth = -1;
            int month = -1;
            int year = -1;
            Matcher matcher = Cookie.TIME_PATTERN.matcher(s);
            while (pos2 < limit) {
                int end = dateCharacterOffset(s, pos2 + 1, limit, true);
                matcher.region(pos2, end);
                if (hour == -1 && matcher.usePattern(Cookie.TIME_PATTERN).matches()) {
                    String strGroup = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(strGroup, "group(...)");
                    hour = Integer.parseInt(strGroup);
                    String strGroup2 = matcher.group(2);
                    Intrinsics.checkNotNullExpressionValue(strGroup2, "group(...)");
                    minute = Integer.parseInt(strGroup2);
                    String strGroup3 = matcher.group(3);
                    Intrinsics.checkNotNullExpressionValue(strGroup3, "group(...)");
                    second = Integer.parseInt(strGroup3);
                } else if (dayOfMonth == -1 && matcher.usePattern(Cookie.DAY_OF_MONTH_PATTERN).matches()) {
                    String strGroup4 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(strGroup4, "group(...)");
                    dayOfMonth = Integer.parseInt(strGroup4);
                } else if (month == -1 && matcher.usePattern(Cookie.MONTH_PATTERN).matches()) {
                    String strGroup5 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(strGroup5, "group(...)");
                    Locale locale = Locale.US;
                    Intrinsics.checkNotNullExpressionValue(locale, "US");
                    String monthString = strGroup5.toLowerCase(locale);
                    Intrinsics.checkNotNullExpressionValue(monthString, "toLowerCase(...)");
                    String strPattern = Cookie.MONTH_PATTERN.pattern();
                    Intrinsics.checkNotNullExpressionValue(strPattern, "pattern(...)");
                    month = StringsKt.indexOf$default((CharSequence) strPattern, monthString, 0, false, 6, (Object) null) / 4;
                } else if (year == -1 && matcher.usePattern(Cookie.YEAR_PATTERN).matches()) {
                    String strGroup6 = matcher.group(1);
                    Intrinsics.checkNotNullExpressionValue(strGroup6, "group(...)");
                    year = Integer.parseInt(strGroup6);
                }
                pos2 = dateCharacterOffset(s, end + 1, limit, false);
            }
            if (70 <= year && year < 100) {
                year += 1900;
            }
            if (year >= 0 && year < 70) {
                year += 2000;
            }
            if (!(year >= 1601)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(month != -1)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(1 <= dayOfMonth && dayOfMonth < 32)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(hour >= 0 && hour < 24)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(minute >= 0 && minute < 60)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            if (!(second >= 0 && second < 60)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            GregorianCalendar $this$parseExpires_u24lambda_u240 = new GregorianCalendar(_UtilJvmKt.UTC);
            $this$parseExpires_u24lambda_u240.setLenient(false);
            $this$parseExpires_u24lambda_u240.set(1, year);
            $this$parseExpires_u24lambda_u240.set(2, month - 1);
            $this$parseExpires_u24lambda_u240.set(5, dayOfMonth);
            $this$parseExpires_u24lambda_u240.set(11, hour);
            $this$parseExpires_u24lambda_u240.set(12, minute);
            $this$parseExpires_u24lambda_u240.set(13, second);
            $this$parseExpires_u24lambda_u240.set(14, 0);
            return $this$parseExpires_u24lambda_u240.getTimeInMillis();
        }

        private final int dateCharacterOffset(String input, int pos, int limit, boolean invert) {
            for (int i = pos; i < limit; i++) {
                int c = input.charAt(i);
                boolean dateCharacter = true;
                if ((c >= 32 || c == 9) && c < 127) {
                    if (!(48 <= c && c < 58)) {
                        if (!(97 <= c && c < 123)) {
                            if (!(65 <= c && c < 91) && c != 58) {
                                dateCharacter = false;
                            }
                        }
                    }
                }
                if (dateCharacter == (!invert)) {
                    return i;
                }
            }
            return limit;
        }

        private final long parseMaxAge(String s) {
            try {
                long parsed = Long.parseLong(s);
                if (parsed <= 0) {
                    return Long.MIN_VALUE;
                }
                return parsed;
            } catch (NumberFormatException e) {
                if (new Regex("-?\\d+").matches(s)) {
                    if (StringsKt.startsWith$default(s, "-", false, 2, (Object) null)) {
                        return Long.MIN_VALUE;
                    }
                    return LongCompanionObject.MAX_VALUE;
                }
                throw e;
            }
        }

        private final String parseDomain(String s) {
            if (StringsKt.endsWith$default(s, ".", false, 2, (Object) null)) {
                throw new IllegalArgumentException("Failed requirement.".toString());
            }
            String canonicalHost = _HostnamesCommonKt.toCanonicalHost(StringsKt.removePrefix(s, (CharSequence) "."));
            if (canonicalHost != null) {
                return canonicalHost;
            }
            throw new IllegalArgumentException();
        }

        @JvmStatic
        public final List<Cookie> parseAll(HttpUrl url, Headers headers) {
            List<Cookie> listUnmodifiableList;
            Intrinsics.checkNotNullParameter(url, "url");
            Intrinsics.checkNotNullParameter(headers, "headers");
            List<String> listValues = headers.values("Set-Cookie");
            List cookies = null;
            int size = listValues.size();
            for (int i = 0; i < size; i++) {
                Cookie cookie = parse(url, listValues.get(i));
                if (cookie != null) {
                    if (cookies == null) {
                        List cookies2 = new ArrayList();
                        cookies = cookies2;
                    }
                    cookies.add(cookie);
                }
            }
            if (cookies == null) {
                listUnmodifiableList = null;
            } else {
                List $this$unmodifiable$iv = cookies;
                listUnmodifiableList = Collections.unmodifiableList($this$unmodifiable$iv);
                Intrinsics.checkNotNullExpressionValue(listUnmodifiableList, "unmodifiableList(...)");
            }
            return listUnmodifiableList == null ? CollectionsKt.emptyList() : listUnmodifiableList;
        }
    }

    @JvmStatic
    public static final Cookie parse(HttpUrl url, String setCookie) {
        return Companion.parse(url, setCookie);
    }

    @JvmStatic
    public static final List<Cookie> parseAll(HttpUrl url, Headers headers) {
        return Companion.parseAll(url, headers);
    }
}
