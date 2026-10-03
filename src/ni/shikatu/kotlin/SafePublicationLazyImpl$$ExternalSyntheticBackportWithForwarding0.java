package ni.shikatu.kotlin;

import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

public final  class SafePublicationLazyImpl$$ExternalSyntheticBackportWithForwarding0 {
    public static  boolean m(AtomicReferenceFieldUpdater atomicReferenceFieldUpdater, Object obj, Object obj2, Object obj3) {
        while (!atomicReferenceFieldUpdater.compareAndSet(obj, obj2, obj3)) {
            if (atomicReferenceFieldUpdater.get(obj) != obj2) {
                return false;
            }
        }
        return true;
    }
}
