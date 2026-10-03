package ni.shikatu.kotlin.concurrent.atomics;

import java.util.concurrent.atomic.AtomicReference;

public final  class AtomicsKt__Atomics_jvmKt$$ExternalSyntheticBackportWithForwarding0 {
    public static  boolean m(AtomicReference atomicReference, Object obj, Object obj2) {
        while (!atomicReference.compareAndSet(obj, obj2)) {
            if (atomicReference.get() != obj) {
                return false;
            }
        }
        return true;
    }
}
