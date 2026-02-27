package ni.shikatu.kotlin.jvm.internal;

import java.io.Serializable;
import ni.shikatu.kotlin.reflect.KFunction;

public class FunInterfaceConstructorReference extends FunctionReference implements Serializable {
    private final Class funInterface;

    public FunInterfaceConstructorReference(Class funInterface) {
        super(1);
        this.funInterface = funInterface;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FunInterfaceConstructorReference)) {
            return false;
        }
        FunInterfaceConstructorReference other = (FunInterfaceConstructorReference) o;
        return this.funInterface.equals(other.funInterface);
    }

    @Override
    public int hashCode() {
        return this.funInterface.hashCode();
    }

    @Override
    public String toString() {
        return "fun interface " + this.funInterface.getName();
    }

    @Override
    public KFunction getReflected() {
        throw new UnsupportedOperationException("Functional interface constructor does not support reflection");
    }
}
