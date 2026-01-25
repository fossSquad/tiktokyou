package fake.com.bytedance.ttc2pa.localfiles;

import fake.d.c;

public final class SignCertManager$CertInfo {
    public final String certContent;
    public final String certFingerPrint;

    public SignCertManager$CertInfo(String str, String str2) {
        c.b(str, "certFingerPrint");
        c.b(str2, "certContent");
        this.certFingerPrint = str;
        this.certContent = str2;
    }

    public final String getCertContent() {
        return this.certContent;
    }

    public final String getCertFingerPrint() {
        return this.certFingerPrint;
    }
}
