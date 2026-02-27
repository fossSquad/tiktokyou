package ni.shikatu.kotlin.jvm.internal;

import ni.shikatu.kotlin.reflect.KCallable;
import ni.shikatu.kotlin.reflect.KFunction;

public class FunctionReference extends CallableReference implements FunctionBase, KFunction {
    private final int arity;
    private final int flags;

    public FunctionReference(int arity) {
        this(arity, NO_RECEIVER, null, null, null, 0);
    }

    public FunctionReference(int arity, Object receiver) {
        this(arity, receiver, null, null, null, 0);
    }

    public FunctionReference(int arity, Object receiver, Class owner, String name, String signature, int flags) {
        super(receiver, owner, name, signature, (flags & 1) == 1);
        this.arity = arity;
        this.flags = flags >> 1;
    }

    @Override
    public int getArity() {
        return this.arity;
    }

    @Override
    public KFunction getReflected() {
        return (KFunction) super.getReflected();
    }

    @Override
    protected KCallable computeReflected() {
        return Reflection.function(this);
    }

    @Override
    public boolean isInline() {
        return getReflected().isInline();
    }

    @Override
    public boolean isExternal() {
        return getReflected().isExternal();
    }

    @Override
    public boolean isOperator() {
        return getReflected().isOperator();
    }

    @Override
    public boolean isInfix() {
        return getReflected().isInfix();
    }

    @Override
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof FunctionReference) {
            FunctionReference other = (FunctionReference) obj;
            return getName().equals(other.getName()) && getSignature().equals(other.getSignature()) && this.flags == other.flags && this.arity == other.arity && Intrinsics.areEqual(getBoundReceiver(), other.getBoundReceiver()) && Intrinsics.areEqual(getOwner(), other.getOwner());
        }
        if (obj instanceof KFunction) {
            return obj.equals(compute());
        }
        return false;
    }

    public int hashCode() {
        return (((getOwner() == null ? 0 : getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public String toString() {
        KCallable reflected = compute();
        if (reflected != this) {
            return reflected.toString();
        }
        return "<init>".equals(getName()) ? "constructor (Kotlin reflection is not available)" : "function " + getName() + " (Kotlin reflection is not available)";
    }
}
