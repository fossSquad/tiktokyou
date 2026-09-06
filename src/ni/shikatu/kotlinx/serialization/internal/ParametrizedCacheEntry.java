package ni.shikatu.kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KType;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\t\bF¢\u0006\u0004\b\u0003\u0010\u0004JF\u0010\u000b\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n0\t2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\u00072\u0014\u0010\u000e\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n0\u000fH\u0086\u0088\u0004ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011R/\u0010\u0005\u001a\"\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n0\t0\u0006X\u0082\u0084\b¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0012"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/ParametrizedCacheEntry;", "T", _UrlKt.FRAGMENT_ENCODE_SET, "<init>", "()V", "serializers", "Ljava/util/concurrent/ConcurrentHashMap;", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlinx/serialization/internal/KTypeWrapper;", "Lni/shikatu/kotlin/Result;", "Lni/shikatu/kotlinx/serialization/KSerializer;", "computeIfAbsent", "types", "Lni/shikatu/kotlin/reflect/KType;", "producer", "Lni/shikatu/kotlin/Function0;", "computeIfAbsent-gIAlu-s", "(Ljava/util/List;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class ParametrizedCacheEntry<T> {
    private final ConcurrentHashMap<List<KTypeWrapper>, Result<KSerializer<T>>> serializers = new ConcurrentHashMap<>();

    public final Object m1541computeIfAbsentgIAlus(List<? extends KType> list, Function0<? extends KSerializer<T>> function0) {
        Object objM6constructorimpl;
        Intrinsics.checkNotNullParameter(list, "types");
        Intrinsics.checkNotNullParameter(function0, "producer");
        List<? extends KType> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Object item$iv$iv : $this$map$iv) {
            KType it = (KType) item$iv$iv;
            destination$iv$iv.add(new KTypeWrapper(it));
        }
        ArrayList arrayList = (List) destination$iv$iv;
        ConcurrentMap $this$getOrPut$iv = this.serializers;
        Object obj = $this$getOrPut$iv.get(arrayList);
        if (obj == null) {
            try {
                Result.Companion companion = Result.Companion;
                objM6constructorimpl = Result.m6constructorimpl(function0.invoke());
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                objM6constructorimpl = Result.m6constructorimpl(ResultKt.createFailure(th));
            }
            Result resultM5boximpl = Result.m5boximpl(objM6constructorimpl);
            Object objPutIfAbsent = $this$getOrPut$iv.putIfAbsent(arrayList, resultM5boximpl);
            obj = objPutIfAbsent == null ? resultM5boximpl : objPutIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(obj, "getOrPut(...)");
        return ((Result) obj).m15unboximpl();
    }
}
