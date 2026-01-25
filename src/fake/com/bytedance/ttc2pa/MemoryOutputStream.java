package fake.com.bytedance.ttc2pa;

import com.sun.jna.Pointer;
import fake.d.c;
import java.io.OutputStream;

public final class MemoryOutputStream extends OutputStream {
    public long offset;
    public final Pointer pointer;

    public MemoryOutputStream(Pointer pointer) {
        c.b(pointer, "pointer");
        this.pointer = pointer;
    }

    @Override
    public void write(int i) {
        this.pointer.write(this.offset, new int[]{i}, 0, 1);
        this.offset++;
    }

    @Override
    public void write(byte[] bArr) {
        if (bArr == null) {
            return;
        }
        this.pointer.write(this.offset, bArr, 0, bArr.length);
        this.offset += (long) bArr.length;
    }

    @Override
    public void write(byte[] bArr, int i, int i2) {
        if (bArr == null) {
            return;
        }
        this.pointer.write(this.offset, bArr, i, i2);
        this.offset += (long) i2;
    }
}
