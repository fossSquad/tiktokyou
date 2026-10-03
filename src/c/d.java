package c;

import com.vapro.vae.stringfog.StringFogRuntime;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public final class d extends InputStream {
    public final BufferedInputStream a;
    public final long b = 134217728;

    public long f2c;

    public d(InputStream inputStream) {
        this.a = new BufferedInputStream(inputStream);
    }

    @Override
    public final int read() throws IOException {
        if (this.f2c >= this.b) {
            throw new IOException("Entry exceeds size limit");
        }
        int i = this.a.read();
        if (i >= 0) {
            this.f2c++;
        }
        return i;
    }

    @Override
    public final int read(byte[] bArr, int i, int i2) throws IOException {
        long j = this.f2c;
        long j2 = this.b;
        if (j < j2) {
            int i3 = this.a.read(bArr, i, (int) Math.min(i2, j2 - j));
            if (i3 > 0) {
                this.f2c += (long) i3;
            }
            return i3;
        }
        throw new IOException("Entry exceeds size limit");
    }
}
