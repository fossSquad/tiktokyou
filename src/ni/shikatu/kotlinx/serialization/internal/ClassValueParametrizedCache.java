package ni.shikatu.kotlinx.serialization.internal;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.Result;
import ni.shikatu.kotlin.ResultKt;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.kotlin.jvm.JvmClassMappingKt;
import ni.shikatu.kotlin.jvm.functions.Function0;
import ni.shikatu.kotlin.jvm.functions.Function2;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.kotlin.reflect.KClass;
import ni.shikatu.kotlin.reflect.KType;
import ni.shikatu.kotlinx.serialization.KSerializer;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B7\bF\u0012,\u0010\u0003\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u0004¢\u0006\u0004\b\n\u0010\u000bJ;\u0010\u000f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0096\u0080\u0004¢\u0006\u0004\b\u0013\u0010\u0014R5\u0010\u0003\u001a(\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\t0\u0004X\u0082\u0084\b¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u000e0\rX\u0082\u0084\b¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lni/shikatu/kotlinx/serialization/internal/ClassValueParametrizedCache;", "T", "Lni/shikatu/kotlinx/serialization/internal/ParametrizedSerializerCache;", "compute", "Lni/shikatu/kotlin/Function2;", "Lni/shikatu/kotlin/reflect/KClass;", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/reflect/KType;", "Lni/shikatu/kotlinx/serialization/KSerializer;", "<init>", "(Lkotlin/jvm/functions/Function2;)V", "classValue", "Lni/shikatu/kotlinx/serialization/internal/ClassValueReferences;", "Lni/shikatu/kotlinx/serialization/internal/ParametrizedCacheEntry;", "get", "Lni/shikatu/kotlin/Result;", "key", "types", "get-gIAlu-s", "(Lkotlin/reflect/KClass;Ljava/util/List;)Ljava/lang/Object;", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
final class ClassValueParametrizedCache<T> implements ParametrizedSerializerCache<T> {
    private final ClassValueReferences<ParametrizedCacheEntry<T>> classValue;
    private final Function2<KClass<Object>, List<? extends KType>, KSerializer<T>> compute;

    public ClassValueParametrizedCache(Function2<? super KClass<Object>, ? super List<? extends KType>, ? extends KSerializer<T>> function2) {
        Intrinsics.checkNotNullParameter(function2, "compute");
        this.compute = function2;
        this.classValue = new ClassValueReferences<>();
    }

    @Override

    public Object mo1535getgIAlus(KClass<Object> kClass, List<? extends KType> list) {
        Object objM6constructorimpl;
        Intrinsics.checkNotNullParameter(kClass, "key");
        Intrinsics.checkNotNullParameter(list, "types");
        ParametrizedCacheEntry<T> parametrizedCacheEntry = this.classValue.get(JvmClassMappingKt.getJavaClass((KClass) kClass));
        Intrinsics.checkNotNullExpressionValue(parametrizedCacheEntry, "get(...)");
        MutableSoftReference mutableSoftReference = (MutableSoftReference) parametrizedCacheEntry;
        T t = mutableSoftReference.reference.get();
        if (t == null) {
            t = (T) mutableSoftReference.getOrSetWithLock(new Function0<T>() {
                @Override
                public final T invoke() {
                    return (T) new ParametrizedCacheEntry();
                }
            });
        }
        ParametrizedCacheEntry parametrizedCacheEntry2 = t;
        List<? extends KType> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(new KTypeWrapper((KType) it.next()));
        }
        ArrayList arrayList2 = arrayList;
        ConcurrentHashMap concurrentHashMap = parametrizedCacheEntry2.serializers;
        Object obj = concurrentHashMap.get(arrayList2);
        if (obj == null) {
            try {
                Result.Companion companion = Result.Companion;
                objM6constructorimpl = Result.m6constructorimpl(this.compute.invoke(kClass, list));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                objM6constructorimpl = Result.m6constructorimpl(ResultKt.createFailure(th));
            }
            Result resultM5boximpl = Result.m5boximpl(objM6constructorimpl);
            Object objPutIfAbsent = concurrentHashMap.putIfAbsent(arrayList2, resultM5boximpl);
            obj = objPutIfAbsent == null ? resultM5boximpl : objPutIfAbsent;
        }
        Intrinsics.checkNotNullExpressionValue(obj, "getOrPut(...)");
        return ((Result) obj).m15unboximpl();
    }
}
