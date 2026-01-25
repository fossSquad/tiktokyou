package fake.com.bytedance.ttc2pa;

import com.sun.jna.Pointer;
import com.sun.jna.Structure;

public class ForeignBytes extends Structure {
    public Pointer data;
    public int len;

    public static final class ByValue extends ForeignBytes implements Structure.ByValue {
    }
}
