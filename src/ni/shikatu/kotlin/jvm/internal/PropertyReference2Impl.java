package ni.shikatu.kotlin.jvm.internal;

import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.reflect.KDeclarationContainer;

public class PropertyReference2Impl extends PropertyReference2 {
    public PropertyReference2Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(((ClassBasedDeclarationContainer) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof KClass) ? 1 : 0);
    }

    public PropertyReference2Impl(Class owner, String name, String signature, int flags) {
        super(owner, name, signature, flags);
    }

    @Override
    public Object get(Object receiver1, Object receiver2) {
        return getGetter().call(receiver1, receiver2);
    }
}
