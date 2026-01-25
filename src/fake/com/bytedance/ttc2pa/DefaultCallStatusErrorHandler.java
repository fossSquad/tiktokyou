package fake.com.bytedance.ttc2pa;

import fake.d.c;

public final class DefaultCallStatusErrorHandler implements CallStatusErrorHandler {
    public static final DefaultCallStatusErrorHandler INSTANCE = new DefaultCallStatusErrorHandler();

    @Override
    public UnhandledException raise(RustBuffer.ByValue byValue) {
        c.b(byValue, "error_buf");
        RustBuffer.Companion.free$ttc2pa_release(byValue);
        return new UnhandledException("Unexpected CALL_ERROR");
    }
}
