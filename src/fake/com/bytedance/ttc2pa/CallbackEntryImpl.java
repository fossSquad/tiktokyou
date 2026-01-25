package fake.com.bytedance.ttc2pa;

import fake.d.b;
import fake.d.c;

public final class CallbackEntryImpl implements CallbackEntry {
    public static final Companion Companion = new Companion();
    public static final CallbackEntry entry = new CallbackEntryImpl();

    public static final class Companion {
        public Companion() {
        }

        public  Companion(b bVar) {
            this();
        }

        public static  void getEntry$annotations() {
        }

        public final CallbackEntry getEntry() {
            return CallbackEntryImpl.entry;
        }
    }

    public static final CallbackEntry getEntry() {
        return Companion.getEntry();
    }

    @Override
    public int invoke(long j, long j2, long j3, RustBuffer.ByValue byValue, RustBufferByReference rustBufferByReference) {
        c.b(byValue, "params");
        c.b(rustBufferByReference, "outBuf");
        CallbackInstance callbackInstance = CallbackInstance.INSTANCE;
        MoltenFFICallback callbackInstance2 = callbackInstance.getInstance(j2);
        if (callbackInstance2 != null) {
            if (j3 == 0) {
                callbackInstance.unregisterInstance(j2);
            }
            BufferCallStatus bufferCallStatusOnInvoke = callbackInstance2.onInvoke(j, j3, byValue);
            rustBufferByReference.setValue(bufferCallStatusOnInvoke.data);
            return bufferCallStatusOnInvoke.code;
        }
        throw new RuntimeException("No registered callback<TypeId(" + j + "), InstanceId(" + j2 + ")>");
    }
}
