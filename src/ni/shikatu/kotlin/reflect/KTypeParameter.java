package ni.shikatu.kotlin.reflect;

import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001R\u0013\u0010\u0002\u001a\u00020\u0003X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0019\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0013\u0010\u000b\u001a\u00020\fX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u000f\u001a\u00020\u0010X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0011Ê\u0001\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015¨\u0006\u0012"}, d2 = {"Lni/shikatu/kotlin/reflect/KTypeParameter;", "Lni/shikatu/kotlin/reflect/KClassifier;", "name", _UrlKt.FRAGMENT_ENCODE_SET, "getName", "()Ljava/lang/String;", "upperBounds", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/reflect/KType;", "getUpperBounds", "()Ljava/util/List;", "variance", "Lni/shikatu/kotlin/reflect/KVariance;", "getVariance", "()Lkotlin/reflect/KVariance;", "isReified", _UrlKt.FRAGMENT_ENCODE_SET, "()Z", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface KTypeParameter extends KClassifier {
    String getName();

    List<KType> getUpperBounds();

    KVariance getVariance();

    boolean isReified();
}
