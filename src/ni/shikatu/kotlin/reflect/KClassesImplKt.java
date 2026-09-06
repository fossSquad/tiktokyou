package ni.shikatu.kotlin.reflect;

import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.jvm.internal.Intrinsics;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\" \u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u0006\u0012\u0002\b\u00030\u00028À\u0002X\u0080\u0084\b¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004¨\u0006\u0005"}, d2 = {"qualifiedOrSimpleName", _UrlKt.FRAGMENT_ENCODE_SET, "Lni/shikatu/kotlin/reflect/KClass;", "getQualifiedOrSimpleName", "(Lkotlin/reflect/KClass;)Ljava/lang/String;", "ni.shikatu.kotlin-stdlib"}, k = 2, mv = {2, 4, 0}, xi = 48)
public final class KClassesImplKt {
    public static final String getQualifiedOrSimpleName(KClass<?> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "<this>");
        return kClass.getQualifiedName();
    }
}
