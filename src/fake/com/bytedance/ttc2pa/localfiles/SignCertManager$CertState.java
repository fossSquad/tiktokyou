package fake.com.bytedance.ttc2pa.localfiles;

import fake.d.c;

public final class SignCertManager$CertState {
    public final SignCertManager$CertInfo certInfo;
    public final long errorCode;
    public final String errorDesc;

    public SignCertManager$CertState(long j, String str, SignCertManager$CertInfo signCertManager$CertInfo) {
        c.b(str, "errorDesc");
        this.errorCode = j;
        this.errorDesc = str;
        this.certInfo = signCertManager$CertInfo;
    }

    public final SignCertManager$CertInfo getCertInfo() {
        return this.certInfo;
    }

    public final long getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorDesc() {
        return this.errorDesc;
    }
}
