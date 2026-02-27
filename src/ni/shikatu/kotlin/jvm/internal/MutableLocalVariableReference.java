package ni.shikatu.kotlin.jvm.internal;

import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.reflect.KDeclarationContainer;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\u0012\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\u000b"}, d2 = {"Lni/shikatu/kotlin/jvm/internal/MutableLocalVariableReference;", "Lni/shikatu/kotlin/jvm/internal/MutablePropertyReference0;", "<init>", "()V", "getOwner", "Lni/shikatu/kotlin/reflect/KDeclarationContainer;", "get", "", "set", "", "value", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 1, 0}, xi = 48)
public class MutableLocalVariableReference extends MutablePropertyReference0 {
    @Override
    public KDeclarationContainer getOwner() {
        LocalVariableReferencesKt.notSupportedError();
        throw new KotlinNothingValueException();
    }

    @Override
    public Object get() {
        LocalVariableReferencesKt.notSupportedError();
        throw new KotlinNothingValueException();
    }

    @Override
    public void set(Object value) {
        LocalVariableReferencesKt.notSupportedError();
        throw new KotlinNothingValueException();
    }
}
