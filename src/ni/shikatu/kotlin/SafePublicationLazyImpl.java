package ni.shikatu.kotlin;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.DefaultConstructorMarker;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0002\u0018\u0000 \u0016*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00060\u0003j\u0002`\u0004:\u0001\u0016B\u0015\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\nH\u0002R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u00020\nX\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u0017"}, d2 = {"Lni/shikatu/kotlin/SafePublicationLazyImpl;", "T", "Lni/shikatu/kotlin/Lazy;", "Ljava/io/Serializable;", "Lni/shikatu/kotlin/io/Serializable;", "initializer", "Lni/shikatu/kotlin/Function0;", "<init>", "(Lkotlin/jvm/functions/Function0;)V", "_value", "", "final", "getFinal$annotations", "()V", "value", "getValue", "()Ljava/lang/Object;", "isInitialized", "", "toString", "", "writeReplace", "Companion", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
final class SafePublicationLazyImpl<T> implements Lazy<T>, Serializable {
    public static final Companion Companion = new Companion(null);
    private static final AtomicReferenceFieldUpdater<SafePublicationLazyImpl<?>, Object> valueUpdater = AtomicReferenceFieldUpdater.newUpdater(SafePublicationLazyImpl.class, Object.class, "_value");
    private volatile Object _value;

    private final Object f0final;
    private volatile Function0<? extends T> initializer;

    private static  void getFinal$annotations() {
    }

    public SafePublicationLazyImpl(Function0<? extends T> function0) {
        Intrinsics.checkNotNullParameter(function0, "initializer");
        this.initializer = function0;
        this._value = UNINITIALIZED_VALUE.INSTANCE;
        this.f0final = UNINITIALIZED_VALUE.INSTANCE;
    }

    @Override
    public T getValue() {
        T t = (T) this._value;
        if (t != UNINITIALIZED_VALUE.INSTANCE) {
            return t;
        }
        Function0<? extends T> function0 = this.initializer;
        if (function0 != null) {
            T tInvoke = function0.invoke();
            if (SafePublicationLazyImpl$$ExternalSyntheticBackportWithForwarding0.m(valueUpdater, this, UNINITIALIZED_VALUE.INSTANCE, tInvoke)) {
                this.initializer = null;
                return tInvoke;
            }
        }
        return (T) this._value;
    }

    @Override
    public boolean isInitialized() {
        return this._value != UNINITIALIZED_VALUE.INSTANCE;
    }

    public String toString() {
        return isInitialized() ? String.valueOf(getValue()) : "Lazy value not initialized yet.";
    }

    private final Object writeReplace() {
        return new InitializedLazyImpl(getValue());
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R`\u0010\u0004\u001aR\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00010\u0001 \u0007*(\u0012\u0014\u0012\u0012\u0012\u0002\b\u0003 \u0007*\b\u0012\u0002\b\u0003\u0018\u00010\u00060\u0006\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00010\u0001\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\b¨\u0006\t"}, d2 = {"Lni/shikatu/kotlin/SafePublicationLazyImpl$Companion;", "", "<init>", "()V", "valueUpdater", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "Lni/shikatu/kotlin/SafePublicationLazyImpl;", "ni.shikatu.kotlin.jvm.PlatformType", "Ljava/util/concurrent/atomic/AtomicReferenceFieldUpdater;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public  Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
