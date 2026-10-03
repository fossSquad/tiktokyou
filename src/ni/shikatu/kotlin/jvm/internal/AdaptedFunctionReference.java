package ni.shikatu.kotlin.jvm.internal;

import java.io.Serializable;
import ni.shikatu.kotlin.reflect.KDeclarationContainer;

public class AdaptedFunctionReference implements FunctionBase, Serializable {
    private final int arity;
    private final int flags;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private final String signature;

    public AdaptedFunctionReference(int arity, Class owner, String name, String signature, int flagsWithIsTopLevel) {
        this(arity, CallableReference.NO_RECEIVER, owner, name, signature, flagsWithIsTopLevel);
    }

    public AdaptedFunctionReference(int arity, Object receiver, Class owner, String name, String signature, int flagsWithIsTopLevel) {
        this.receiver = receiver;
        this.owner = owner;
        this.name = name;
        this.signature = signature;
        this.isTopLevel = (flagsWithIsTopLevel & 1) == 1;
        this.arity = arity;
        this.flags = flagsWithIsTopLevel >> 1;
    }

    @Override
    public int getArity() {
        return this.arity;
    }

    public KDeclarationContainer getOwner() {
        if (this.owner == null) {
            return null;
        }
        return this.isTopLevel ? Reflection.getOrCreateKotlinPackage(this.owner) : Reflection.getOrCreateKotlinClass(this.owner);
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AdaptedFunctionReference)) {
            return false;
        }
        AdaptedFunctionReference other = (AdaptedFunctionReference) o;
        return this.isTopLevel == other.isTopLevel && this.arity == other.arity && this.flags == other.flags && Intrinsics.areEqual(this.receiver, other.receiver) && Intrinsics.areEqual(this.owner, other.owner) && this.name.equals(other.name) && this.signature.equals(other.signature);
    }

    public int hashCode() {
        int result = this.receiver != null ? this.receiver.hashCode() : 0;
        return (((((((((((result * 31) + (this.owner != null ? this.owner.hashCode() : 0)) * 31) + this.name.hashCode()) * 31) + this.signature.hashCode()) * 31) + (this.isTopLevel ? 1231 : 1237)) * 31) + this.arity) * 31) + this.flags;
    }

    public String toString() {
        return Reflection.renderLambdaToString(this);
    }
}
