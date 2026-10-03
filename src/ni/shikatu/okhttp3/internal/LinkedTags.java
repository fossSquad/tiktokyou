package ni.shikatu.okhttp3.internal;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.JvmClassMappingKt;
import ni.shikatu.kotlin.jvm.functions.Function1;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.sequences.SequencesKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0000\b\u0002\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B%\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005\u0012\u0006\u0010\u0006\u001a\u00028\u0000\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0004\b\b\u0010\tJ/\u0010\u000b\u001a\u00020\u0003\"\b\b\u0001\u0010\f*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\f0\u00052\b\u0010\u0006\u001a\u0004\u0018\u0001H\fH\u0016¢\u0006\u0002\u0010\rJ(\u0010\u000e\u001a\u0004\u0018\u0001H\f\"\b\b\u0001\u0010\f*\u00020\u00022\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\f0\u0005H\u0096\u0002¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0016R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00028\u0000X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\nR\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lni/shikatu/okhttp3/internal/LinkedTags;", "K", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/okhttp3/internal/Tags;", "key", "Lni/shikatu/kotlin/reflect/KClass;", "value", "next", "<init>", "(Lkotlin/reflect/KClass;Ljava/lang/Object;Lokhttp3/internal/Tags;)V", "Ljava/lang/Object;", "plus", "T", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Lokhttp3/internal/Tags;", "get", "(Lkotlin/reflect/KClass;)Ljava/lang/Object;", "toString", _UrlKt.FRAGMENT_ENCODE_SET, "okhttp"}, k = 1, mv = {2, 2, 0}, xi = 48)
final class LinkedTags<K> extends Tags {
    private final KClass<K> key;
    private final Tags next;
    private final K value;

    public LinkedTags(KClass<K> kClass, K k, Tags next) {
        super(null);
        Intrinsics.checkNotNullParameter(kClass, "key");
        Intrinsics.checkNotNullParameter(k, "value");
        Intrinsics.checkNotNullParameter(next, "next");
        this.key = kClass;
        this.value = k;
        this.next = next;
    }

    @Override
    public <T> Tags plus(KClass<T> kClass, T t) {
        Tags thisMinusKey;
        Intrinsics.checkNotNullParameter(kClass, "key");
        if (Intrinsics.areEqual(kClass, this.key)) {
            thisMinusKey = this.next;
        } else {
            Tags nextMinusKey = this.next.plus(kClass, null);
            thisMinusKey = nextMinusKey == this.next ? this : new LinkedTags(this.key, this.value, nextMinusKey);
        }
        return t != null ? new LinkedTags(kClass, t, thisMinusKey) : thisMinusKey;
    }

    @Override
    public <T> T get(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "key");
        return Intrinsics.areEqual(kClass, this.key) ? (T) JvmClassMappingKt.getJavaClass((KClass) kClass).cast(this.value) : (T) this.next.get(kClass);
    }

    public static final LinkedTags toString$lambda$0(LinkedTags it) {
        Intrinsics.checkNotNullParameter(it, "it");
        Tags tags = it.next;
        if (tags instanceof LinkedTags) {
            return (LinkedTags) tags;
        }
        return null;
    }

    public String toString() {
        return CollectionsKt.joinToString$default(CollectionsKt.reversed(SequencesKt.toList(SequencesKt.generateSequence(this, (Function1<? super LinkedTags<K>, ? extends LinkedTags<K>>) new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return LinkedTags.toString$lambda$0((LinkedTags) obj);
            }
        }))), null, "{", "}", 0, null, new Function1() {
            @Override
            public final Object invoke(Object obj) {
                return LinkedTags.toString$lambda$1((LinkedTags) obj);
            }
        }, 25, null);
    }

    public static final CharSequence toString$lambda$1(LinkedTags it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return new StringBuilder().append(it.key).append('=').append(it.value).toString();
    }
}
