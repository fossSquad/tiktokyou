package ni.shikatu.kotlinx.serialization.descriptors;

import java.lang.annotation.Annotation;
import java.util.List;
import ni.shikatu.kotlin.Metadata;
import ni.shikatu.kotlin.collections.CollectionsKt;
import ni.shikatu.okhttp3.internal.url._UrlKt;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0010\u001b\n\u0002\b\n\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u000fH¦\u0080\u0004J\u0012\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u0003H¦\u0080\u0004J\u0018\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00140\u00132\u0006\u0010\u0018\u001a\u00020\u000fH¦\u0080\u0004J\u0012\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u000fH¦\u0080\u0004J\u0012\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u0018\u001a\u00020\u000fH¦\u0080\u0004R\u0013\u0010\u0002\u001a\u00020\u0003X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0013\u0010\u0006\u001a\u00020\u0007X¦\u0084\b¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0015\u0010\n\u001a\u00020\u000b8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\n\u0010\fR\u0015\u0010\r\u001a\u00020\u000b8VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\r\u0010\fR\u0013\u0010\u000e\u001a\u00020\u000fX¦\u0084\b¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u001b\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u00138VX\u0096\u0084\b¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001eÀ\u0006\u0003"}, d2 = {"Lni/shikatu/kotlinx/serialization/descriptors/SerialDescriptor;", _UrlKt.FRAGMENT_ENCODE_SET, "serialName", _UrlKt.FRAGMENT_ENCODE_SET, "getSerialName", "()Ljava/lang/String;", "kind", "Lni/shikatu/kotlinx/serialization/descriptors/SerialKind;", "getKind", "()Lkotlinx/serialization/descriptors/SerialKind;", "isNullable", _UrlKt.FRAGMENT_ENCODE_SET, "()Z", "isInline", "elementsCount", _UrlKt.FRAGMENT_ENCODE_SET, "getElementsCount", "()I", "annotations", _UrlKt.FRAGMENT_ENCODE_SET, _UrlKt.FRAGMENT_ENCODE_SET, "getAnnotations", "()Ljava/util/List;", "getElementName", "index", "getElementIndex", "name", "getElementAnnotations", "getElementDescriptor", "isElementOptional", "ni.shikatu.kotlinx-serialization-core"}, k = 1, mv = {2, 3, 0}, xi = 48)
public interface SerialDescriptor {
    List<Annotation> getElementAnnotations(int i);

    SerialDescriptor getElementDescriptor(int i);

    int getElementIndex(String str);

    String getElementName(int i);

    int getElementsCount();

    SerialKind getKind();

    String getSerialName();

    boolean isElementOptional(int i);

    @Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
    public static final class DefaultImpls {
        @Deprecated
        public static boolean isNullable(SerialDescriptor $this) {
            return SerialDescriptor.super.isNullable();
        }

        @Deprecated
        public static boolean isInline(SerialDescriptor $this) {
            return SerialDescriptor.super.isInline();
        }

        @Deprecated
        public static List<Annotation> getAnnotations(SerialDescriptor $this) {
            return SerialDescriptor.super.getAnnotations();
        }
    }

    default boolean isNullable() {
        return false;
    }

    default boolean isInline() {
        return false;
    }

    default List<Annotation> getAnnotations() {
        return CollectionsKt.emptyList();
    }
}
