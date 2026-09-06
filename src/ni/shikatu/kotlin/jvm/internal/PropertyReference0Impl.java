package ni.shikatu.kotlin.jvm.internal;

import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.reflect.KDeclarationContainer;

public class PropertyReference0Impl extends PropertyReference0 {
    public PropertyReference0Impl(KDeclarationContainer kDeclarationContainer, String str, String str2) {
        super(NO_RECEIVER, ((ClassBasedDeclarationContainer) kDeclarationContainer).getJClass(), str, str2, !(kDeclarationContainer instanceof KClass) ? 1 : 0);
    }

    public PropertyReference0Impl(Class owner, String name, String signature, int flags) {
        super(NO_RECEIVER, owner, name, signature, flags);
    }

    public PropertyReference0Impl(Object receiver, Class owner, String name, String signature, int flags) {
        super(receiver, owner, name, signature, flags);
    }

    @Override
    public Object get() {
        return getGetter().call(new Object[0]);
    }
}
