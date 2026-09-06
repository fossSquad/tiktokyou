package ni.shikatu.okhttp3;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import ni.shikatu.kotlin.Deprecated;
import ni.shikatu.kotlin.DeprecationLevel;
import ni.shikatu.kotlin.KotlinVersion;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.ReplaceWith;
import ni.shikatu.kotlin.jvm.JvmStatic;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.text.StringsKt;
import ni.shikatu.okhttp3.internal.http.HttpStatusCodesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0007J\b\u0010\b\u001a\u00020\u0003H\u0016R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0006¨\u0006\n"}, d2 = {"Lni/shikatu/okhttp3/CipherSuite;", _UrlKt.FRAGMENT_ENCODE_SET, "javaName", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "(Ljava/lang/String;)V", "()Ljava/lang/String;", "-deprecated_javaName", "toString", "Companion", "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CipherSuite {
    private final String javaName;
    public static final Companion Companion = new Companion(null);
    private static final Comparator<String> ORDER_BY_NAME = new Comparator<String>() {
        @Override
        public int compare(String a, String b) {
            Intrinsics.checkNotNullParameter(a, "a");
            Intrinsics.checkNotNullParameter(b, "b");
            int limit = Math.min(a.length(), b.length());
            for (int i = 4; i < limit; i++) {
                char charA = a.charAt(i);
                char charB = b.charAt(i);
                if (charA != charB) {
                    return Intrinsics.compare((int) charA, (int) charB) < 0 ? -1 : 1;
                }
            }
            int lengthA = a.length();
            int lengthB = b.length();
            if (lengthA != lengthB) {
                return lengthA < lengthB ? -1 : 1;
            }
            return 0;
        }
    };
    private static final Map<String, CipherSuite> INSTANCES = new LinkedHashMap();
    public static final CipherSuite TLS_RSA_WITH_NULL_MD5 = Companion.init("SSL_RSA_WITH_NULL_MD5", 1);
    public static final CipherSuite TLS_RSA_WITH_NULL_SHA = Companion.init("SSL_RSA_WITH_NULL_SHA", 2);
    public static final CipherSuite TLS_RSA_EXPORT_WITH_RC4_40_MD5 = Companion.init("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
    public static final CipherSuite TLS_RSA_WITH_RC4_128_MD5 = Companion.init("SSL_RSA_WITH_RC4_128_MD5", 4);
    public static final CipherSuite TLS_RSA_WITH_RC4_128_SHA = Companion.init("SSL_RSA_WITH_RC4_128_SHA", 5);
    public static final CipherSuite TLS_RSA_EXPORT_WITH_DES40_CBC_SHA = Companion.init("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    public static final CipherSuite TLS_RSA_WITH_DES_CBC_SHA = Companion.init("SSL_RSA_WITH_DES_CBC_SHA", 9);
    public static final CipherSuite TLS_RSA_WITH_3DES_EDE_CBC_SHA = Companion.init("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    public static final CipherSuite TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA = Companion.init("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    public static final CipherSuite TLS_DHE_DSS_WITH_DES_CBC_SHA = Companion.init("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    public static final CipherSuite TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA = Companion.init("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    public static final CipherSuite TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA = Companion.init("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    public static final CipherSuite TLS_DHE_RSA_WITH_DES_CBC_SHA = Companion.init("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    public static final CipherSuite TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA = Companion.init("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    public static final CipherSuite TLS_DH_anon_EXPORT_WITH_RC4_40_MD5 = Companion.init("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    public static final CipherSuite TLS_DH_anon_WITH_RC4_128_MD5 = Companion.init("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    public static final CipherSuite TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA = Companion.init("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    public static final CipherSuite TLS_DH_anon_WITH_DES_CBC_SHA = Companion.init("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    public static final CipherSuite TLS_DH_anon_WITH_3DES_EDE_CBC_SHA = Companion.init("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    public static final CipherSuite TLS_KRB5_WITH_DES_CBC_SHA = Companion.init("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    public static final CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_SHA = Companion.init("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    public static final CipherSuite TLS_KRB5_WITH_RC4_128_SHA = Companion.init("TLS_KRB5_WITH_RC4_128_SHA", 32);
    public static final CipherSuite TLS_KRB5_WITH_DES_CBC_MD5 = Companion.init("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    public static final CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_MD5 = Companion.init("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    public static final CipherSuite TLS_KRB5_WITH_RC4_128_MD5 = Companion.init("TLS_KRB5_WITH_RC4_128_MD5", 36);
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA = Companion.init("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_SHA = Companion.init("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5 = Companion.init("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_MD5 = Companion.init("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA = Companion.init("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA = Companion.init("TLS_DHE_DSS_WITH_AES_128_CBC_SHA", 50);
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA = Companion.init("TLS_DHE_RSA_WITH_AES_128_CBC_SHA", 51);
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA = Companion.init("TLS_DH_anon_WITH_AES_128_CBC_SHA", 52);
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA = Companion.init("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA = Companion.init("TLS_DHE_DSS_WITH_AES_256_CBC_SHA", 56);
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA = Companion.init("TLS_DHE_RSA_WITH_AES_256_CBC_SHA", 57);
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA = Companion.init("TLS_DH_anon_WITH_AES_256_CBC_SHA", 58);
    public static final CipherSuite TLS_RSA_WITH_NULL_SHA256 = Companion.init("TLS_RSA_WITH_NULL_SHA256", 59);
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA256 = Companion.init("TLS_RSA_WITH_AES_128_CBC_SHA256", 60);
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA256 = Companion.init("TLS_RSA_WITH_AES_256_CBC_SHA256", 61);
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA256 = Companion.init("TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", 64);
    public static final CipherSuite TLS_RSA_WITH_CAMELLIA_128_CBC_SHA = Companion.init("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    public static final CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA = Companion.init("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    public static final CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA = Companion.init("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA256 = Companion.init("TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", HttpStatusCodesKt.HTTP_EARLY_HINTS);
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA256 = Companion.init("TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", 106);
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA256 = Companion.init("TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", 107);
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA256 = Companion.init("TLS_DH_anon_WITH_AES_128_CBC_SHA256", 108);
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA256 = Companion.init("TLS_DH_anon_WITH_AES_256_CBC_SHA256", 109);
    public static final CipherSuite TLS_RSA_WITH_CAMELLIA_256_CBC_SHA = Companion.init("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
    public static final CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA = Companion.init("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
    public static final CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA = Companion.init("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
    public static final CipherSuite TLS_PSK_WITH_RC4_128_SHA = Companion.init("TLS_PSK_WITH_RC4_128_SHA", 138);
    public static final CipherSuite TLS_PSK_WITH_3DES_EDE_CBC_SHA = Companion.init("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
    public static final CipherSuite TLS_PSK_WITH_AES_128_CBC_SHA = Companion.init("TLS_PSK_WITH_AES_128_CBC_SHA", 140);
    public static final CipherSuite TLS_PSK_WITH_AES_256_CBC_SHA = Companion.init("TLS_PSK_WITH_AES_256_CBC_SHA", 141);
    public static final CipherSuite TLS_RSA_WITH_SEED_CBC_SHA = Companion.init("TLS_RSA_WITH_SEED_CBC_SHA", 150);
    public static final CipherSuite TLS_RSA_WITH_AES_128_GCM_SHA256 = Companion.init("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    public static final CipherSuite TLS_RSA_WITH_AES_256_GCM_SHA384 = Companion.init("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_GCM_SHA256 = Companion.init("TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", 158);
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 = Companion.init("TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", 159);
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_GCM_SHA256 = Companion.init("TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", 162);
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 = Companion.init("TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", 163);
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_GCM_SHA256 = Companion.init("TLS_DH_anon_WITH_AES_128_GCM_SHA256", 166);
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_GCM_SHA384 = Companion.init("TLS_DH_anon_WITH_AES_256_GCM_SHA384", 167);
    public static final CipherSuite TLS_EMPTY_RENEGOTIATION_INFO_SCSV = Companion.init("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", KotlinVersion.MAX_COMPONENT_VALUE);
    public static final CipherSuite TLS_FALLBACK_SCSV = Companion.init("TLS_FALLBACK_SCSV", 22016);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_NULL_SHA = Companion.init("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_RC4_128_SHA = Companion.init("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA = Companion.init("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA = Companion.init("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA = Companion.init("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_NULL_SHA = Companion.init("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_RC4_128_SHA = Companion.init("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA = Companion.init("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA = Companion.init("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA = Companion.init("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    public static final CipherSuite TLS_ECDH_RSA_WITH_NULL_SHA = Companion.init("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    public static final CipherSuite TLS_ECDH_RSA_WITH_RC4_128_SHA = Companion.init("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    public static final CipherSuite TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA = Companion.init("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA = Companion.init("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA = Companion.init("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_NULL_SHA = Companion.init("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_RC4_128_SHA = Companion.init("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA = Companion.init("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = Companion.init("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = Companion.init("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    public static final CipherSuite TLS_ECDH_anon_WITH_NULL_SHA = Companion.init("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    public static final CipherSuite TLS_ECDH_anon_WITH_RC4_128_SHA = Companion.init("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    public static final CipherSuite TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA = Companion.init("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    public static final CipherSuite TLS_ECDH_anon_WITH_AES_128_CBC_SHA = Companion.init("TLS_ECDH_anon_WITH_AES_128_CBC_SHA", 49176);
    public static final CipherSuite TLS_ECDH_anon_WITH_AES_256_CBC_SHA = Companion.init("TLS_ECDH_anon_WITH_AES_256_CBC_SHA", 49177);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256 = Companion.init("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", 49187);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384 = Companion.init("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", 49188);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256 = Companion.init("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384 = Companion.init("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256 = Companion.init("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", 49191);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 = Companion.init("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", 49192);
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256 = Companion.init("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384 = Companion.init("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 = Companion.init("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 = Companion.init("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256 = Companion.init("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384 = Companion.init("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 = Companion.init("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 = Companion.init("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256 = Companion.init("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384 = Companion.init("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA = Companion.init("TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", 49205);
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA = Companion.init("TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", 49206);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = Companion.init("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256 = Companion.init("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    public static final CipherSuite TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = Companion.init("TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52394);
    public static final CipherSuite TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256 = Companion.init("TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", 52396);
    public static final CipherSuite TLS_AES_128_GCM_SHA256 = Companion.init("TLS_AES_128_GCM_SHA256", 4865);
    public static final CipherSuite TLS_AES_256_GCM_SHA384 = Companion.init("TLS_AES_256_GCM_SHA384", 4866);
    public static final CipherSuite TLS_CHACHA20_POLY1305_SHA256 = Companion.init("TLS_CHACHA20_POLY1305_SHA256", 4867);
    public static final CipherSuite TLS_AES_128_CCM_SHA256 = Companion.init("TLS_AES_128_CCM_SHA256", 4868);
    public static final CipherSuite TLS_AES_128_CCM_8_SHA256 = Companion.init("TLS_AES_128_CCM_8_SHA256", 4869);

    public  CipherSuite(String str, DefaultConstructorMarker defaultConstructorMarker) {
        this(str);
    }

    private CipherSuite(String javaName) {
        this.javaName = javaName;
    }

    public final String javaName() {
        return this.javaName;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = "moved to val", replaceWith = @ReplaceWith(expression = "javaName", imports = {}))

    public final String m1619deprecated_javaName() {
        return this.javaName;
    }

    public String toString() {
        return this.javaName;
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b|\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0084\u0001\u001a\u00020\f2\u0007\u0010\u0085\u0001\u001a\u00020\u0006H\u0007J\u0012\u0010\u0086\u0001\u001a\u00020\u00062\u0007\u0010\u0085\u0001\u001a\u00020\u0006H\u0002J\u001c\u0010\u0087\u0001\u001a\u00020\f2\u0007\u0010\u0085\u0001\u001a\u00020\u00062\b\u0010\u0088\u0001\u001a\u00030\u0089\u0001H\u0002R$\u0010\u0004\u001a\u0012\u0012\u0004\u0012\u00020\u00060\u0005j\b\u0012\u0004\u0012\u00020\u0006`\u0007X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001c\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010&\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010(\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010)\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010,\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010-\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010/\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00100\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00101\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00103\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00105\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00106\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00107\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00108\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u00109\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010:\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010<\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010=\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010?\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010@\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010B\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010C\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010E\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010G\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010I\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010J\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010K\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010L\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010N\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010O\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010P\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010T\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Y\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010[\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\\\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010]\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010_\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010a\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010d\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010f\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010g\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010h\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010i\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010j\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010k\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010l\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010m\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010n\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010o\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010p\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010q\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010r\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010s\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010t\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010u\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010v\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010w\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010x\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010y\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010z\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010{\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010|\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010}\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010~\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u007f\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0080\u0001\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0081\u0001\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0082\u0001\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0083\u0001\u001a\u00020\f8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u008a\u0001"}, d2 = {"Lni/shikatu/okhttp3/CipherSuite$Companion;", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "ORDER_BY_NAME", "Ljava/util/Comparator;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/Comparator;", "getORDER_BY_NAME$okhttp", "()Ljava/util/Comparator;", "INSTANCES", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/CipherSuite;", "TLS_RSA_WITH_NULL_MD5", "TLS_RSA_WITH_NULL_SHA", "TLS_RSA_EXPORT_WITH_RC4_40_MD5", "TLS_RSA_WITH_RC4_128_MD5", "TLS_RSA_WITH_RC4_128_SHA", "TLS_RSA_EXPORT_WITH_DES40_CBC_SHA", "TLS_RSA_WITH_DES_CBC_SHA", "TLS_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", "TLS_DHE_DSS_WITH_DES_CBC_SHA", "TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA", "TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", "TLS_DHE_RSA_WITH_DES_CBC_SHA", "TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_DH_anon_EXPORT_WITH_RC4_40_MD5", "TLS_DH_anon_WITH_RC4_128_MD5", "TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA", "TLS_DH_anon_WITH_DES_CBC_SHA", "TLS_DH_anon_WITH_3DES_EDE_CBC_SHA", "TLS_KRB5_WITH_DES_CBC_SHA", "TLS_KRB5_WITH_3DES_EDE_CBC_SHA", "TLS_KRB5_WITH_RC4_128_SHA", "TLS_KRB5_WITH_DES_CBC_MD5", "TLS_KRB5_WITH_3DES_EDE_CBC_MD5", "TLS_KRB5_WITH_RC4_128_MD5", "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", "TLS_KRB5_EXPORT_WITH_RC4_40_SHA", "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", "TLS_KRB5_EXPORT_WITH_RC4_40_MD5", "TLS_RSA_WITH_AES_128_CBC_SHA", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA", "TLS_DH_anon_WITH_AES_128_CBC_SHA", "TLS_RSA_WITH_AES_256_CBC_SHA", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA", "TLS_DH_anon_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_NULL_SHA256", "TLS_RSA_WITH_AES_128_CBC_SHA256", "TLS_RSA_WITH_AES_256_CBC_SHA256", "TLS_DHE_DSS_WITH_AES_128_CBC_SHA256", "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", "TLS_DHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_DHE_DSS_WITH_AES_256_CBC_SHA256", "TLS_DHE_RSA_WITH_AES_256_CBC_SHA256", "TLS_DH_anon_WITH_AES_128_CBC_SHA256", "TLS_DH_anon_WITH_AES_256_CBC_SHA256", "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", "TLS_PSK_WITH_RC4_128_SHA", "TLS_PSK_WITH_3DES_EDE_CBC_SHA", "TLS_PSK_WITH_AES_128_CBC_SHA", "TLS_PSK_WITH_AES_256_CBC_SHA", "TLS_RSA_WITH_SEED_CBC_SHA", "TLS_RSA_WITH_AES_128_GCM_SHA256", "TLS_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_DHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_DHE_DSS_WITH_AES_128_GCM_SHA256", "TLS_DHE_DSS_WITH_AES_256_GCM_SHA384", "TLS_DH_anon_WITH_AES_128_GCM_SHA256", "TLS_DH_anon_WITH_AES_256_GCM_SHA384", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", "TLS_FALLBACK_SCSV", "TLS_ECDH_ECDSA_WITH_NULL_SHA", "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_NULL_SHA", "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDH_RSA_WITH_NULL_SHA", "TLS_ECDH_RSA_WITH_RC4_128_SHA", "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_NULL_SHA", "TLS_ECDHE_RSA_WITH_RC4_128_SHA", "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDH_anon_WITH_NULL_SHA", "TLS_ECDH_anon_WITH_RC4_128_SHA", "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_anon_WITH_AES_128_CBC_SHA", "TLS_ECDH_anon_WITH_AES_256_CBC_SHA", "TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384", "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA", "TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA", "TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256", "TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256", "TLS_AES_128_GCM_SHA256", "TLS_AES_256_GCM_SHA384", "TLS_CHACHA20_POLY1305_SHA256", "TLS_AES_128_CCM_SHA256", "TLS_AES_128_CCM_8_SHA256", "forJavaName", "javaName", "secondaryName", "init", "value", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Comparator<String> getORDER_BY_NAME$okhttp() {
            return CipherSuite.ORDER_BY_NAME;
        }

        @JvmStatic
        public final synchronized CipherSuite forJavaName(String javaName) {
            CipherSuite result;
            Intrinsics.checkNotNullParameter(javaName, "javaName");
            result = (CipherSuite) CipherSuite.INSTANCES.get(javaName);
            if (result == null) {
                CipherSuite result2 = (CipherSuite) CipherSuite.INSTANCES.get(secondaryName(javaName));
                if (result2 != null) {
                    result = result2;
                } else {
                    result = new CipherSuite(javaName, null);
                }
                CipherSuite.INSTANCES.put(javaName, result);
            }
            return result;
        }

        private final String secondaryName(String javaName) {
            if (StringsKt.startsWith$default(javaName, "TLS_", false, 2, (Object) null)) {
                StringBuilder sbAppend = new StringBuilder().append("SSL_");
                String strSubstring = javaName.substring(4);
                Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
                return sbAppend.append(strSubstring).toString();
            }
            if (StringsKt.startsWith$default(javaName, "SSL_", false, 2, (Object) null)) {
                StringBuilder sbAppend2 = new StringBuilder().append("TLS_");
                String strSubstring2 = javaName.substring(4);
                Intrinsics.checkNotNullExpressionValue(strSubstring2, "substring(...)");
                return sbAppend2.append(strSubstring2).toString();
            }
            return javaName;
        }

        public final CipherSuite init(String javaName, int value) {
            CipherSuite suite = new CipherSuite(javaName, null);
            CipherSuite.INSTANCES.put(javaName, suite);
            return suite;
        }
    }

    @JvmStatic
    public static final synchronized CipherSuite forJavaName(String javaName) {
        return Companion.forJavaName(javaName);
    }
}
