package fake.com.bytedance.ttc2pa;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;
import fake.d.b;

public class RustBuffer extends Structure {
    public static final Companion Companion = new Companion((b) null);
    public int capacity;
    public Pointer data;
    public int len;

    public static final class ByValue extends RustBuffer implements Structure.ByValue {
    }
}
