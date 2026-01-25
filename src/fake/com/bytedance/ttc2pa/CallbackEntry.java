package fake.com.bytedance.ttc2pa;

import com.sun.jna.Callback;

public interface CallbackEntry extends Callback {
    int invoke(long j, long j2, long j3, RustBuffer.ByValue byValue, RustBufferByReference rustBufferByReference);
}
