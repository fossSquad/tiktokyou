package fake.com.bytedance.ttc2pa;

import com.sun.jna.Pointer;
import com.sun.jna.ptr.ByReference;
import fake.d.c;

public final class RustBufferByReference extends ByReference {
    public RustBufferByReference() {
        super(16);
    }

    public final void setValue(RustBuffer.ByValue byValue) {
        c.b(byValue, "value");
        Pointer pointer = getPointer();
        pointer.setInt(0L, byValue.capacity);
        pointer.setInt(4L, byValue.len);
        pointer.setPointer(8L, byValue.data);
    }
}
