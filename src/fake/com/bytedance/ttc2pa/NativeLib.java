package fake.com.bytedance.ttc2pa;

import com.sun.jna.Library;
import fake.a.a;
import fake.a.b;
import fake.d.c;

public interface NativeLib extends Library {
    public static final Companion Companion = Companion.$$INSTANCE;

    public static final class Companion {
        public static final  Companion $$INSTANCE = new Companion();
        public static final a INSTANCE$delegate = b.a(NativeLib$Companion$INSTANCE$2.INSTANCE);

        public final NativeLib getINSTANCE$ttc2pa_release() {
            Object value = INSTANCE$delegate.getValue();
            c.a(value, "<get-INSTANCE>(...)");
            return (NativeLib) value;
        }
    }

    RustBuffer.ByValue molten_ffi_tt_c2pa_sdk_check_sign_cert_available_9089(RustBuffer.ByValue byValue, RustCallStatus rustCallStatus);

    RustBuffer.ByValue molten_ffi_tt_c2pa_sdk_ttc2pa_read_and_verify_from_path_0e1a(RustBuffer.ByValue byValue, RustCallStatus rustCallStatus);

    RustBuffer.ByValue molten_ffi_tt_c2pa_sdk_ttc2pa_read_ingredient_from_path_c567(RustBuffer.ByValue byValue, RustCallStatus rustCallStatus);

    RustBuffer.ByValue molten_ffi_tt_c2pa_sdk_ttc2pa_set_temp_dir_7e8f(RustBuffer.ByValue byValue, RustCallStatus rustCallStatus);

    RustBuffer.ByValue molten_ffi_tt_c2pa_sdk_ttc2pa_write_and_sign_manifest_c606(RustBuffer.ByValue byValue, RustCallStatus rustCallStatus);

    void set_callback_entry(CallbackEntry callbackEntry);

    RustBuffer.ByValue uniffi_rustbuffer_alloc(int i);

    void uniffi_rustbuffer_free(RustBuffer.ByValue byValue, RustCallStatus rustCallStatus);

    RustBuffer.ByValue uniffi_rustbuffer_from_bytes(ForeignBytes.ByValue byValue, RustCallStatus rustCallStatus);
}
