package fake.com.bytedance.ttc2pa;

import com.sun.jna.Structure;
import fake.d.b;
import fake.d.c;

public class BufferCallStatus extends Structure {
    public static final Companion Companion = new Companion();
    public int code;
    public RustBuffer.ByValue data;

    public static final class Companion {
        public Companion() {
        }

        public  Companion(b bVar) {
            this();
        }

        public final BufferCallStatus error(RustBuffer.ByValue byValue) {
            c.b(byValue, "err");
            return new BufferCallStatus(1, byValue);
        }

        public final BufferCallStatus success(RustBuffer.ByValue byValue) {
            c.b(byValue, "data");
            return new BufferCallStatus(0, byValue);
        }
    }

    public BufferCallStatus() {
        this(0, null, 3, 0 == true ? 1 : 0);
    }

    public BufferCallStatus(int i, RustBuffer.ByValue byValue) {
        c.b(byValue, "data");
        this.code = i;
        this.data = byValue;
    }

    public  BufferCallStatus(int i, RustBuffer.ByValue byValue, int i2, b bVar) {
        this((i2 & 1) != 0 ? 0 : i, (i2 & 2) != 0 ? new RustBuffer.ByValue() : byValue);
    }
}
