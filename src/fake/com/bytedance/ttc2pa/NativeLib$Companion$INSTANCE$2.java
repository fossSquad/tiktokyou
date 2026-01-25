package fake.com.bytedance.ttc2pa;

import com.sun.jna.Native;
import fake.c.a;
import fake.d.d;

public final class NativeLib$Companion$INSTANCE$2 extends d implements a {
    public static final NativeLib$Companion$INSTANCE$2 INSTANCE = new NativeLib$Companion$INSTANCE$2();

    public NativeLib$Companion$INSTANCE$2() {
        super(0);
    }

    @Override
    public final NativeLib invoke() {
        NativeLib nativeLib = (NativeLib) Native.load(Tt_c2pa_sdkKt.access$findLibraryName("tt_c2pa_sdk"), NativeLib.class);
        nativeLib.set_callback_entry(CallbackEntryImpl.Companion.getEntry());
        return nativeLib;
    }
}
