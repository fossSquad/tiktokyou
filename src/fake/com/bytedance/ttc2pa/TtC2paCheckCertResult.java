package fake.com.bytedance.ttc2pa;

import X.0Vx6;
import fake.d.c;
import fake.f.l;

public final class TtC2paCheckCertResult {
    public long certCount;
    public String errorMessage;

    public TtC2paCheckCertResult(long j, String str) {
        c.b(str, "errorMessage");
        this.certCount = j;
        this.errorMessage = str;
    }

    public final TtC2paCheckCertResult copy(long j, String str) {
        c.b(str, "errorMessage");
        return new TtC2paCheckCertResult(j, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TtC2paCheckCertResult)) {
            return false;
        }
        TtC2paCheckCertResult ttC2paCheckCertResult = (TtC2paCheckCertResult) obj;
        return this.certCount == ttC2paCheckCertResult.certCount && c.a((Object) this.errorMessage, (Object) ttC2paCheckCertResult.errorMessage);
    }

    public final long getCertCount() {
        return this.certCount;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public int hashCode() {
        return this.errorMessage.hashCode() + (0Vx6.c(this.certCount) * 31);
    }

    public final l into() {
        return new l(Long.valueOf(this.certCount), this.errorMessage);
    }

    public final void setCertCount(long j) {
        this.certCount = j;
    }

    public final void setErrorMessage(String str) {
        c.b(str, "<set-?>");
        this.errorMessage = str;
    }

    public String toString() {
        return "TtC2paCheckCertResult(certCount=" + this.certCount + ", errorMessage=" + this.errorMessage + ')';
    }
}
