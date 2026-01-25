package fake.com.bytedance.ttc2pa;

import com.sun.jna.Pointer;
import fake.d.c;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;

public abstract class RustArcClass implements Disposable, AutoCloseable {
    public final AtomicLong callCounter;
    public final Pointer pointer;
    public final AtomicBoolean wasDestroyed;

    public RustArcClass(Pointer pointer) {
        c.b(pointer, "pointer");
        this.pointer = pointer;
        this.wasDestroyed = new AtomicBoolean(false);
        this.callCounter = new AtomicLong(1L);
    }

    public final java.lang.Object callWithPointer$ttc2pa_release(fake.c.b r8) {
        /*
            r7 = this;
            java.lang.String r0 = "block"
            fake.d.c.b(r8, r0)
        L5:
            java.util.concurrent.atomic.AtomicLong r0 = r7.callCounter
            long r3 = r0.get()
            r5 = 0
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L5f
            r1 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 == 0) goto L4b
            java.util.concurrent.atomic.AtomicLong r2 = r7.callCounter
            r0 = 1
            long r0 = r0 + r3
            boolean r0 = r2.compareAndSet(r3, r0)
            if (r0 == 0) goto L5
            com.sun.jna.Pointer r0 = r7.pointer     // Catch: java.lang.Throwable -> L39
            java.lang.Object r3 = r8.invoke(r0)     // Catch: java.lang.Throwable -> L39
            java.util.concurrent.atomic.AtomicLong r0 = r7.callCounter
            long r1 = r0.decrementAndGet()
            int r0 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r0 != 0) goto L38
            r7.freeRustArcPtr()
        L38:
            return r3
        L39:
            r3 = move-exception
            com.bytedance.tt.reliability.monitor.catchchecker.TryCatchGuardChecker.doCheck(r3)
            java.util.concurrent.atomic.AtomicLong r0 = r7.callCounter
            long r1 = r0.decrementAndGet()
            int r0 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r0 != 0) goto L4a
            r7.freeRustArcPtr()
        L4a:
            throw r3
        L4b:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.Class r0 = r7.getClass()
            java.lang.String r1 = r0.getSimpleName()
            java.lang.String r0 = " call counter would overflow"
            java.lang.String r0 = r1.concat(r0)
            r2.<init>(r0)
            throw r2
        L5f:
            java.lang.IllegalStateException r2 = new java.lang.IllegalStateException
            java.lang.Class r0 = r7.getClass()
            java.lang.String r1 = r0.getSimpleName()
            java.lang.String r0 = " object has already been destroyed"
            java.lang.String r0 = r1.concat(r0)
            r2.<init>(r0)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: fake.com.bytedance.ttc2pa.RustArcClass.callWithPointer$ttc2pa_release(fake.c.b):java.lang.Object");
    }

    @Override
    public synchronized void close() {
        destroy();
    }

    @Override
    public void destroy() {
        if (this.wasDestroyed.compareAndSet(false, true) && this.callCounter.decrementAndGet() == 0) {
            freeRustArcPtr();
        }
    }

    public void freeRustArcPtr() {
    }

    public final Pointer getPointer() {
        return this.pointer;
    }
}
