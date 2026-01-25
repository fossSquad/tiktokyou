package fake.com.bytedance.ttc2pa;

import X.0Vqr;
import fake.d.c;
import fake.f.m;
import java.util.Arrays;
import okio.ByteString;

public final class TtC2paNetworkResponse {
    public byte[] body;
    public String contentType;
    public String errorMessage;
    public long httpStatus;

    public TtC2paNetworkResponse(long j, String str, String str2, byte[] bArr) {
        c.b(str, "errorMessage");
        c.b(str2, "contentType");
        c.b(bArr, "body");
        this.httpStatus = j;
        this.errorMessage = str;
        this.contentType = str2;
        this.body = bArr;
    }

    public final TtC2paNetworkResponse copy(long j, String str, String str2, byte[] bArr) {
        c.b(str, "errorMessage");
        c.b(str2, "contentType");
        c.b(bArr, "body");
        return new TtC2paNetworkResponse(j, str, str2, bArr);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TtC2paNetworkResponse)) {
            return false;
        }
        TtC2paNetworkResponse ttC2paNetworkResponse = (TtC2paNetworkResponse) obj;
        return this.httpStatus == ttC2paNetworkResponse.httpStatus && c.a((Object) this.errorMessage, (Object) ttC2paNetworkResponse.errorMessage) && c.a((Object) this.contentType, (Object) ttC2paNetworkResponse.contentType) && c.a(this.body, ttC2paNetworkResponse.body);
    }

    public final byte[] getBody() {
        return this.body;
    }

    public final String getContentType() {
        return this.contentType;
    }

    public final String getErrorMessage() {
        return this.errorMessage;
    }

    public final long getHttpStatus() {
        return this.httpStatus;
    }

    public int hashCode() {
        return Arrays.hashCode(this.body) + ((this.contentType.hashCode() + ((this.errorMessage.hashCode() + (0Vqr.h(this.httpStatus) * 31)) * 31)) * 31);
    }

    public final m into() {
        Long lValueOf = Long.valueOf(this.httpStatus);
        String str = this.errorMessage;
        String str2 = this.contentType;
        byte[] bArr = this.body;
        return new m(lValueOf, str, str2, ByteString.of(bArr, 0, bArr.length));
    }

    public final void setBody(byte[] bArr) {
        c.b(bArr, "<set-?>");
        this.body = bArr;
    }

    public final void setContentType(String str) {
        c.b(str, "<set-?>");
        this.contentType = str;
    }

    public final void setErrorMessage(String str) {
        c.b(str, "<set-?>");
        this.errorMessage = str;
    }

    public final void setHttpStatus(long j) {
        this.httpStatus = j;
    }

    public String toString() {
        return "TtC2paNetworkResponse(httpStatus=" + this.httpStatus + ", errorMessage=" + this.errorMessage + ", contentType=" + this.contentType + ", body=" + Arrays.toString(this.body) + ')';
    }
}
