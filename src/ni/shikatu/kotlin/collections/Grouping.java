package ni.shikatu.kotlin.collections;

import java.util.Iterator;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010(\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000*\u0004\b\u0000\u0010\u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003J\u0010\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005H¦\u0080\u0004J\u0017\u0010\u0006\u001a\u00028\u00012\u0006\u0010\u0007\u001a\u00028\u0000H¦\u0080\u0004¢\u0006\u0002\u0010\bÊ\u0001\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f¨\u0006\t"}, d2 = {"Lni/shikatu/kotlin/collections/Grouping;", "T", "K", _UrlKt.FRAGMENT_ENCODE_SET, "sourceIterator", _UrlKt.FRAGMENT_ENCODE_SET, "keyOf", "element", "(Ljava/lang/Object;)Ljava/lang/Object;", "ni.shikatu.kotlin-stdlib", "Lni/shikatu/kotlin/SinceKotlin;", "version", "1.1"}, k = 1, mv = {2, 4, 0}, xi = 48)
public interface Grouping<T, K> {
    K keyOf(T t);

    Iterator<T> sourceIterator();
}
