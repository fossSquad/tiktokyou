package ni.shikatu.kotlin.jvm.internal;

import ni.shikatu.kotlin.reflect.KCallable;
import ni.shikatu.kotlin.reflect.KProperty0;

public abstract class PropertyReference0 extends PropertyReference implements KProperty0 {
    public PropertyReference0() {
    }

    public PropertyReference0(Object receiver) {
        super(receiver);
    }

    public PropertyReference0(Object receiver, Class owner, String name, String signature, int flags) {
        super(receiver, owner, name, signature, flags);
    }

    @Override
    protected KCallable computeReflected() {
        return Reflection.property0(this);
    }

    @Override
    public Object invoke() {
        return get();
    }

    @Override
    public KProperty0.Getter getGetter() {
        return ((KProperty0) getReflected()).getGetter();
    }

    @Override
    public Object getDelegate() {
        return ((KProperty0) getReflected()).getDelegate();
    }
}
