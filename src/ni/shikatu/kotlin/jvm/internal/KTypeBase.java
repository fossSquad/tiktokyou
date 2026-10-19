package ni.shikatu.kotlin.jvm.internal;

import java.lang.reflect.Type;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.reflect.KType;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005Ê\u0001\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t¨\u0006\u0006"}, d2 = {"Lni/shikatu/kotlin/jvm/internal/KTypeBase;", "Lni/shikatu/kotlin/reflect/KType;", "javaType", "Ljava/lang/reflect/Type;", "getJavaType", "()Ljava/lang/reflect/Type;", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.4"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface KTypeBase extends KType {
    Type getJavaType();
}
