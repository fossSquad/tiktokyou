package fake.com.bytedance.ttc2pa;

import X.0Vqr;
import fake.d.c;
import fake.f.n;

public final class TtC2paResult {
    public long errorCode;
    public String errorDesc;
    public String resultJson;

    public TtC2paResult(long j, String str, String str2) {
        c.b(str, "errorDesc");
        c.b(str2, "resultJson");
        this.errorCode = j;
        this.errorDesc = str;
        this.resultJson = str2;
    }

    public final TtC2paResult copy(long j, String str, String str2) {
        c.b(str, "errorDesc");
        c.b(str2, "resultJson");
        return new TtC2paResult(j, str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TtC2paResult)) {
            return false;
        }
        TtC2paResult ttC2paResult = (TtC2paResult) obj;
        return this.errorCode == ttC2paResult.errorCode && c.a((Object) this.errorDesc, (Object) ttC2paResult.errorDesc) && c.a((Object) this.resultJson, (Object) ttC2paResult.resultJson);
    }

    public final long getErrorCode() {
        return this.errorCode;
    }

    public final String getErrorDesc() {
        return this.errorDesc;
    }

    public final String getResultJson() {
        return this.resultJson;
    }

    public int hashCode() {
        return this.resultJson.hashCode() + ((this.errorDesc.hashCode() + (0Vqr.h(this.errorCode) * 31)) * 31);
    }

    public final n into() {
        return new n(Long.valueOf(this.errorCode), this.errorDesc, this.resultJson);
    }

    public final void setErrorCode(long j) {
        this.errorCode = j;
    }

    public final void setErrorDesc(String str) {
        c.b(str, "<set-?>");
        this.errorDesc = str;
    }

    public final void setResultJson(String str) {
        c.b(str, "<set-?>");
        this.resultJson = str;
    }

    public String toString() {
        return "TtC2paResult(errorCode=" + this.errorCode + ", errorDesc=" + this.errorDesc + ", resultJson=" + this.resultJson + ')';
    }
}
