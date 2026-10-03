package ni.shikatu.okhttp3.internal.tls;

import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.internal._HostnamesCommonKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;
import ni.shikatu.okio.Utf8;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0003\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eJ\u0018\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eH\u0002J\f\u0010\u0013\u001a\u00020\n*\u00020\nH\u0002J\f\u0010\u0014\u001a\u00020\b*\u00020\nH\u0002J\u001c\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\nH\u0002J\u0014\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\n0\u00172\u0006\u0010\r\u001a\u00020\u000eJ\u001e\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\u00172\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0019\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lni/shikatu/okhttp3/internal/tls/OkHostnameVerifier;", "Ljavax/net/ssl/HostnameVerifier;", "<init>", "()V", "ALT_DNS_NAME", _UrlKt.FRAGMENT_ENCODE_SET, "ALT_IPA_NAME", "verify", _UrlKt.FRAGMENT_ENCODE_SET, "host", _UrlKt.FRAGMENT_ENCODE_SET, "session", "Ljavax/net/ssl/SSLSession;", "certificate", "Ljava/security/cert/X509Certificate;", "verifyIpAddress", "ipAddress", "verifyHostname", "hostname", "asciiToLowercase", "isAscii", "pattern", "allSubjectAltNames", _UrlKt.FRAGMENT_ENCODE_SET, "getSubjectAltNames", "type", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OkHostnameVerifier implements HostnameVerifier {
    private static final int ALT_DNS_NAME = 2;
    private static final int ALT_IPA_NAME = 7;
    public static final OkHostnameVerifier INSTANCE = new OkHostnameVerifier();

    private OkHostnameVerifier() {
    }

    @Override
    public boolean verify(String host, SSLSession session) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(session, "session");
        if (!isAscii(host)) {
            return false;
        }
        try {
            Certificate certificate = session.getPeerCertificates()[0];
            Intrinsics.checkNotNull(certificate, "null cannot be cast to non-null type java.security.cert.X509Certificate");
            return verify(host, (X509Certificate) certificate);
        } catch (SSLException e) {
            return false;
        }
    }

    public final boolean verify(String host, X509Certificate certificate) {
        Intrinsics.checkNotNullParameter(host, "host");
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        return _HostnamesCommonKt.canParseAsIpAddress(host) ? verifyIpAddress(host, certificate) : verifyHostname(host, certificate);
    }

    private final boolean verifyIpAddress(String ipAddress, X509Certificate certificate) {
        String canonicalIpAddress = _HostnamesCommonKt.toCanonicalHost(ipAddress);
        Iterable $this$any$iv = getSubjectAltNames(certificate, 7);
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            String it = (String) element$iv;
            if (Intrinsics.areEqual(canonicalIpAddress, _HostnamesCommonKt.toCanonicalHost(it))) {
                return true;
            }
        }
        return false;
    }

    private final boolean verifyHostname(String hostname, X509Certificate certificate) {
        String hostname2 = asciiToLowercase(hostname);
        Iterable $this$any$iv = getSubjectAltNames(certificate, 2);
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (Object element$iv : $this$any$iv) {
            String it = (String) element$iv;
            if (INSTANCE.verifyHostname(hostname2, it)) {
                return true;
            }
        }
        return false;
    }

    private final String asciiToLowercase(String $this$asciiToLowercase) {
        if (!isAscii($this$asciiToLowercase)) {
            return $this$asciiToLowercase;
        }
        Locale locale = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale, "US");
        String lowerCase = $this$asciiToLowercase.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    private final boolean isAscii(String $this$isAscii) {
        return $this$isAscii.length() == ((int) Utf8.size$default($this$isAscii, 0, 0, 3, null));
    }

    private final boolean verifyHostname(String hostname, String pattern) {
        String hostname2 = hostname;
        String pattern2 = pattern;
        String str = hostname2;
        if ((str == null || str.length() == 0) || StringsKt.startsWith$default(hostname2, ".", false, 2, (Object) null) || StringsKt.endsWith$default(hostname2, "..", false, 2, (Object) null)) {
            return false;
        }
        String str2 = pattern2;
        if ((str2 == null || str2.length() == 0) || StringsKt.startsWith$default(pattern2, ".", false, 2, (Object) null) || StringsKt.endsWith$default(pattern2, "..", false, 2, (Object) null)) {
            return false;
        }
        if (!StringsKt.endsWith$default(hostname2, ".", false, 2, (Object) null)) {
            hostname2 = hostname2 + '.';
        }
        if (!StringsKt.endsWith$default(pattern2, ".", false, 2, (Object) null)) {
            pattern2 = pattern2 + '.';
        }
        String pattern3 = asciiToLowercase(pattern2);
        if (!StringsKt.contains$default((CharSequence) pattern3, (CharSequence) "*", false, 2, (Object) null)) {
            return Intrinsics.areEqual(hostname2, pattern3);
        }
        if (!StringsKt.startsWith$default(pattern3, "*.", false, 2, (Object) null) || StringsKt.indexOf$default((CharSequence) pattern3, '*', 1, false, 4, (Object) null) != -1 || hostname2.length() < pattern3.length() || Intrinsics.areEqual("*.", pattern3)) {
            return false;
        }
        String suffix = pattern3.substring(1);
        Intrinsics.checkNotNullExpressionValue(suffix, "substring(...)");
        if (!StringsKt.endsWith$default(hostname2, suffix, false, 2, (Object) null)) {
            return false;
        }
        int suffixStartIndexInHostname = hostname2.length() - suffix.length();
        return suffixStartIndexInHostname <= 0 || StringsKt.lastIndexOf$default((CharSequence) hostname2, '.', suffixStartIndexInHostname + (-1), false, 4, (Object) null) == -1;
    }

    public final List<String> allSubjectAltNames(X509Certificate certificate) {
        Intrinsics.checkNotNullParameter(certificate, "certificate");
        return CollectionsKt.plus((Collection) getSubjectAltNames(certificate, 7), (Iterable) getSubjectAltNames(certificate, 2));
    }

    private final List<String> getSubjectAltNames(X509Certificate certificate, int type) {
        Object altName;
        try {
            Collection<List<?>> subjectAlternativeNames = certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return CollectionsKt.emptyList();
            }
            List result = new ArrayList();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && Intrinsics.areEqual(list.get(0), Integer.valueOf(type)) && (altName = list.get(1)) != null) {
                    result.add((String) altName);
                }
            }
            return result;
        } catch (CertificateParsingException e) {
            return CollectionsKt.emptyList();
        }
    }
}
