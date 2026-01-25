package fake.com.bytedance.ttc2pa;

public interface MoltenFFICallback {
    Object getCallbackObj();

    BufferCallStatus onInvoke(long j, long j2, RustBuffer.ByValue byValue);
}
