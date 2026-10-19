package Z;
import ni.shikatu.kotlin.text.Charsets;
import ni.shikatu.okhttp3.Headers;

public final class s {
    public final int a;
    public final byte[] b;
    public final String c;
    public final String d;
    public final Headers e;

    public s(int i, byte[] bArr, String str, String str2, Headers headers) {
        this.a = i;
        this.b = bArr;
        this.c = str;
        this.d = str2;
        this.e = headers;
    }

    public final String a() {
        byte[] bArr = this.b;
        if (bArr != null) {
            return new String(bArr, Charsets.UTF_8);
        }
        return null;
    }
}
