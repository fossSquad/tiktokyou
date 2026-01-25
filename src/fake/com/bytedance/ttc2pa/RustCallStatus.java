package fake.com.bytedance.ttc2pa;

import com.sun.jna.Structure;

public class RustCallStatus extends Structure {
    public int code;
    public RustBuffer.ByValue error_buf = new RustBuffer.ByValue();

    public final boolean isError() {
        return this.code == 1;
    }

    public final boolean isPanic() {
        return this.code == 2;
    }

    public final boolean isSuccess() {
        return this.code == 0;
    }
}
