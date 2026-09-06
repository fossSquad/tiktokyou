package ni.shikatu.kotlin.reflect;

import java.lang.annotation.Annotation;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001R\u0019\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lni/shikatu/kotlin/reflect/KAnnotatedElement;", _UrlKt.FRAGMENT_ENCODE_SET, "annotations", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "getAnnotations", "()Ljava/util/List;", "ni.shikatu.kotlin-stdlib"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface KAnnotatedElement {
    List<Annotation> getAnnotations();
}
