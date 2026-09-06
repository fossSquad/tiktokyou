package ni.shikatu.kotlin.jvm.internal;

import ni.shikatu.kotlin.KotlinNothingValueException;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.reflect.KDeclarationContainer;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0017\u0018\u00002\u00020\u0001B\t\bF¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\f\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0096\u0080\u0004Ê\u0001\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b¨\u0006\b"}, d2 = {"Lni/shikatu/kotlin/jvm/internal/LocalVariableReference;", "Lni/shikatu/kotlin/jvm/internal/PropertyReference0;", "<init>", "()V", "getOwner", "Lni/shikatu/kotlin/reflect/KDeclarationContainer;", "get", _UrlKt.FRAGMENT_ENCODE_SET, "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1"}, k = 1, mv = {2, 4, 0}, xi = 48)
public class LocalVariableReference extends PropertyReference0 {
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
}
