package ni.shikatu.kotlin.jvm.internal;

import ni.shikatu.kotlin.reflect.KCallable;
import ni.shikatu.kotlin.reflect.KProperty1;

public abstract class PropertyReference1 extends PropertyReference implements KProperty1 {
    public PropertyReference1() {
    }

    public PropertyReference1(Object receiver) {
        super(receiver);
    }

    public PropertyReference1(Object receiver, Class owner, String name, String signature, int flags) {
        super(receiver, owner, name, signature, flags);
    }

    @Override
    protected KCallable computeReflected() {
        return Reflection.property1(this);
    }

    @Override
    public Object invoke(Object receiver) {
        return get(receiver);
    }

    @Override
    public KProperty1.Getter getGetter() {
        return ((KProperty1) getReflected()).getGetter();
    }

    @Override
    public Object getDelegate(Object receiver) {
        return ((KProperty1) getReflected()).getDelegate(receiver);
    }
}
