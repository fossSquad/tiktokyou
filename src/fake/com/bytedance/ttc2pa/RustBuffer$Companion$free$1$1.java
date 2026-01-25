package fake.com.bytedance.ttc2pa;

import fake.a.h;
import fake.c.a;
import fake.d.d;

public final class RustBuffer$Companion$free$1$1 extends d implements a {
    public final  RustBuffer.ByValue $buf;
    public final  RustCallStatus $status;

    public RustBuffer$Companion$free$1$1(RustBuffer.ByValue byValue, RustCallStatus rustCallStatus) {
        super(0);
        this.$buf = byValue;
        this.$status = rustCallStatus;
    }

    @Override
    public /* bridge */  Object invoke() {
        m0invoke();
        return h.a;
    }

    public final void m0invoke() {
        NativeLib.Companion.getINSTANCE$ttc2pa_release().uniffi_rustbuffer_free(this.$buf, this.$status);
    }
}
