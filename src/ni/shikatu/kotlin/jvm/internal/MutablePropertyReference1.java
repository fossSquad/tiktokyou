package ni.shikatu.kotlin.jvm.internal;

import ni.shikatu.kotlin.reflect.KCallable;
import ni.shikatu.kotlin.reflect.KMutableProperty1;
import ni.shikatu.kotlin.reflect.KProperty1;

public abstract class MutablePropertyReference1 extends MutablePropertyReference implements KMutableProperty1 {
    public MutablePropertyReference1() {
    }

    public MutablePropertyReference1(Object receiver) {
        super(receiver);
    }

    public MutablePropertyReference1(Object receiver, Class owner, String name, String signature, int flags) {
        super(receiver, owner, name, signature, flags);
    }

    @Override
    protected KCallable computeReflected() {
        return Reflection.mutableProperty1(this);
    }

    @Override
    public Object invoke(Object receiver) {
        return get(receiver);
    }

    @Override
    public KProperty1.Getter getGetter() {
        return ((KMutableProperty1) getReflected()).getGetter();
    }

    @Override
    public KMutableProperty1.Setter getSetter() {
        return ((KMutableProperty1) getReflected()).getSetter();
    }

    @Override
    public Object getDelegate(Object receiver) {
        return ((KMutableProperty1) getReflected()).getDelegate(receiver);
    }
}
