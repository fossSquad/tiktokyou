package ni.shikatu.kotlin.jvm.internal;

import ni.shikatu.kotlin.reflect.KCallable;
import ni.shikatu.kotlin.reflect.KProperty2;

public abstract class PropertyReference2 extends PropertyReference implements KProperty2 {
    public PropertyReference2() {
    }

    public PropertyReference2(Class owner, String name, String signature, int flags) {
        super(NO_RECEIVER, owner, name, signature, flags);
    }

    @Override
    protected KCallable computeReflected() {
        return Reflection.property2(this);
    }

    @Override
    public Object invoke(Object receiver1, Object receiver2) {
        return get(receiver1, receiver2);
    }

    @Override
    public KProperty2.Getter getGetter() {
        return ((KProperty2) getReflected()).getGetter();
    }

    @Override
    public Object getDelegate(Object receiver1, Object receiver2) {
        return ((KProperty2) getReflected()).getDelegate(receiver1, receiver2);
    }
}
