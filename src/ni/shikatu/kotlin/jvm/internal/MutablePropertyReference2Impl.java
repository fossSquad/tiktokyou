package ni.shikatu.kotlin.jvm.internal;

import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.reflect.KDeclarationContainer;

public class MutablePropertyReference2Impl extends MutablePropertyReference2 {
    public MutablePropertyReference2Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(((ClassBasedDeclarationContainer) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof KClass) ? 1 : 0);
    }

    public MutablePropertyReference2Impl(Class owner, String name, String signature, int flags) {
        super(owner, name, signature, flags);
    }

    @Override
    public Object get(Object receiver1, Object receiver2) {
        return getGetter().call(receiver1, receiver2);
    }

    @Override
    public void set(Object receiver1, Object receiver2, Object value) {
        getSetter().call(receiver1, receiver2, value);
    }
}
