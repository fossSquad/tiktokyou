package ni.shikatu.kotlin.jvm.internal;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.lang.annotation.Annotation;
import java.lang.reflect.GenericDeclaration;
import java.util.List;
import java.util.Map;
import ni.shikatu.kotlin.jvm.KotlinReflectionNotSupportedError;
import ni.shikatu.kotlin.reflect.KCallable;
import ni.shikatu.kotlin.reflect.KDeclarationContainer;
import ni.shikatu.kotlin.reflect.KParameter;
import ni.shikatu.kotlin.reflect.KType;
import ni.shikatu.kotlin.reflect.KTypeParameter;
import ni.shikatu.kotlin.reflect.KVisibility;

public abstract class CallableReference implements KCallable, Serializable, KotlinGenericDeclaration {
    public static final Object NO_RECEIVER = NoReceiver.INSTANCE;
    private final boolean isTopLevel;
    private final String name;
    private final Class owner;
    protected final Object receiver;
    private transient KCallable reflected;
    private final String signature;

    protected abstract KCallable computeReflected();

    private static class NoReceiver implements Serializable {
        private static final NoReceiver INSTANCE = new NoReceiver();

        private NoReceiver() {
        }

        private Object readResolve() throws ObjectStreamException {
            return INSTANCE;
        }
    }

    public CallableReference() {
        this(NO_RECEIVER);
    }

    protected CallableReference(Object receiver) {
        this(receiver, null, null, null, false);
    }

    protected CallableReference(Object receiver, Class owner, String name, String signature, boolean isTopLevel) {
        this.receiver = receiver;
        this.owner = owner;
        this.name = name;
        this.signature = signature;
        this.isTopLevel = isTopLevel;
    }

    public Object getBoundReceiver() {
        return this.receiver;
    }

    public KCallable compute() {
        KCallable result = this.reflected;
        if (result == null) {
            KCallable result2 = computeReflected();
            this.reflected = result2;
            return result2;
        }
        return result;
    }

    protected KCallable getReflected() {
        KCallable result = compute();
        if (result == this) {
            throw new KotlinReflectionNotSupportedError();
        }
        return result;
    }

    public KDeclarationContainer getOwner() {
        if (this.owner == null) {
            return null;
        }
        return this.isTopLevel ? Reflection.getOrCreateKotlinPackage(this.owner) : Reflection.getOrCreateKotlinClass(this.owner);
    }

    @Override
    public String getName() {
        return this.name;
    }

    public String getSignature() {
        return this.signature;
    }

    @Override
    public GenericDeclaration findJavaDeclaration() {
        return KotlinGenericDeclarationKt.findMethodBySignature(getOwner(), getSignature());
    }

    @Override
    public List<KParameter> getParameters() {
        return getReflected().getParameters();
    }

    @Override
    public KType getReturnType() {
        return getReflected().getReturnType();
    }

    @Override
    public List<Annotation> getAnnotations() {
        return getReflected().getAnnotations();
    }

    @Override
    public List<KTypeParameter> getTypeParameters() {
        return getReflected().getTypeParameters();
    }

    @Override
    public Object call(Object... args) {
        return getReflected().call(args);
    }

    @Override
    public Object callBy(Map args) {
        return getReflected().callBy(args);
    }

    @Override
    public KVisibility getVisibility() {
        return getReflected().getVisibility();
    }

    @Override
    public boolean isFinal() {
        return getReflected().isFinal();
    }

    @Override
    public boolean isOpen() {
        return getReflected().isOpen();
    }

    @Override
    public boolean isAbstract() {
        return getReflected().isAbstract();
    }

    @Override
    public boolean isSuspend() {
        return getReflected().isSuspend();
    }
}
