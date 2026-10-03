package ni.shikatu.kotlin.concurrent.atomics;

import java.util.concurrent.atomic.AtomicReferenceArray;

public final  class AtomicArraysKt__AtomicArrays_jvmKt$$ExternalSyntheticBackportWithForwarding0 {
    public static  boolean m(AtomicReferenceArray atomicReferenceArray, int i, Object obj, Object obj2) {
        while (!atomicReferenceArray.compareAndSet(i, obj, obj2)) {
            if (atomicReferenceArray.get(i) != obj) {
                return false;
            }
        }
        return true;
    }
}
