package Z;
import ni.shikatu.kotlin.text.Charsets;

public final class o {
    public final int a;
    public final byte[] b;
    public final String c;
    public final String d;

    public o(int i, byte[] bArr, String str, String str2) {
        this.a = i;
        this.b = bArr;
        this.c = str;
        this.d = str2;
    }

    public final String a() {
        byte[] bArr = this.b;
        if (bArr != null) {
            return new String(bArr, Charsets.UTF_8);
        }
        return null;
    }
}
